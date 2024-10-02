my README file:
# selenide-ta_dashboard

## **Environment**
> **Platform**: <em>Windows 11</em><br/>
> **IDE**: <em>IntelliJ IDEA 2024.2.0.1 (Community Edition)</em><br/>
> **Java**: <em>17.0.12</em><br/>
> **Apache Maven**: <em>3.8.6</em><br/>
> **Docker**: <em>27.1.1</em><br/>

## **Frameworks/Libraries**
> **Selenide**: <em>7.4.2 - Web Driver</em><br/>
> **TestNG**: <em>7.10.2 - Testing Framework</em><br/>
> **ReportPortal UI**: <em>5.11.0 - Reporting Engine Service</em><br/>
> **ReportPortal Java Agent**: <em>5.4.2 - Reporting Engine Agent for TestNG</em><br/>

### **Deploy ReportPortal With Docker**
#### **Install Docker, Docker Compose**
1. Download the installer using the download button at the top of the page, or from the release notes
2. Double-click Docker Desktop Installer.exe to run the installer. By default, Docker Desktop is installed at C:\Program Files\Docker\Docker
3. When prompted, ensure the Use WSL 2 instead of Hyper-V option on the Configuration page is selected or not depending on your choice of backend
4. If your system only supports one of the two options, you won't be able to select which backend to use
5. Follow the instructions on the installation wizard to authorize the installer and proceed with the install
6. When the installation is successful, select Close to complete the installation process
7. Start Docker Desktop

<em>To check the version type the following command.</em><br/>
> `$ docker --version`<br/>
> `$ docker-compose --version`<br/>

<em>Start Docker desktop community.</em><br/>
1. Search for Docker, and select Docker Desktop in the search results
2. The Docker menu ( whale menu ) displays the Docker Subscription Service Agreement
3. Select Accept to continue. Docker Desktop starts after you accept the terms

#### **Deploy ReportPortal with Docker**
By the following official instructions [here](https://reportportal.io/docs/Deploy-with-Docker), you can do that in shortly.

<em>Navigate repository root.</em><br/>
`$ cd selenide-ta_dashboard`<br/>

<em>Download the latest compose descriptor.</em><br/>
`$ curl https://raw.githubusercontent.com/reportportal/reportportal/master/docker-compose.yml -o docker-compose.yml`<br/>

<em>Login with Docker credential</em><br/>
`$ docker login`<br/>

<em>Start the application using the following command.</em><br/>
`$ docker-compose -p reportportal up -d --force-recreate`<br/>

#### **Setup ReportPortal UI**
<em>Get current IP on your machine (For ethernet in this case). </em><br/>
>`$ ipconfig`<br/>
> 172.25.208.1

Open your browser with an IP address of the deployed environment at port 8080.

Use below accounts to access.
> `default/1q2w3e`<br/>
> `superadmin/erebus`

Now, I use account `superadmin/erebus` to create a project named `ta_selenide`
1. Navigate to Projects Management in URL http://localhost:8080/ui/#administrate/projects
2. Create a project
3. Add a user to the project
4. Use the newly account to join to the project

### **Initialize Selenium Grid**

#### **Start the Selenium Hub**
1. Download the Selenium Server jar file from the official Selenium website.
2. Open a terminal and navigate to the directory where you downloaded the Selenium Server jar file.
3. Run the following command to start the hub:
    ```sh
    java -jar selenium-server-<version>.jar hub
    ```

#### **Start the Chrome Node**
1. Open another terminal window.
2. Run the following command to start a Chrome node on port 5555:
    ```sh
    java -jar selenium-server-<version>.jar node --port 5555 --detect-drivers true -I "chrome" --hub http://localhost:4444/ui
    ```

#### **Start the Edge Node**
1. Open another terminal window.
2. Run the following command to start an Edge node on port 6666:
    ```sh
    java -jar selenium-server-<version>.jar node --port 6666 --detect-drivers true -I "edge" --hub http://localhost:4444/ui
    ```
#### **To Run Test in Selenium Grid:**
1. Open suiteAll.xml
2. Edit value of parameters `runMode` is `grid`
3. Start test with maven command line

#### **Run Tests With Maven**
> `mvn clean test`<br/>

### **ReportPortal Results**
See test results as launches in URL http://localhost:8080/ui/?#default_personal/launches/all

### **NGRok**
1. Run ngrok.exe
2. Run command
> ngrok config add-authtoken <auth-token></br>
> ngrok http http://localhost:8080</br>

See URL as launches in Forwarding line

please help me write more instructions to initialize selenium grid and config to run with maven and testng.xml file