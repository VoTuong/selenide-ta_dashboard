# Selenium Java Level 2 with Selenide - Final Test

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

## **Deploy ReportPortal with Docker**
> By the following official instructions [here](https://reportportal.io/docs/Deploy-with-Docker), you can do that in shortly.

### **Setup ReportPortal UI**
Add ReportPortal Configuration
Create a `reportportal.properties` file in the `src/test/resources` directory and configure it with your ReportPortal details:

> rp.endpoint = http://<reportportal-url>:8080<br/>
> rp.api.key  = <your-api-key><br/>
> rp.launch = <launch-name><br/>
> rp.project = <your-project-name><br/>

- rp.endpoint: The URL of your ReportPortal instance.
- rp.api.key: Your unique user token from ReportPortal (found in your ReportPortal profile).
- rp.launch: The name of the test launch that will appear in ReportPortal.
- rp.project: The name of your ReportPortal project.

## **Initialize Selenium Grid**

### **Start the Selenium Hub**
1. Download the Selenium Server jar file from the official Selenium website.
2. Open a terminal and navigate to the directory where you downloaded the Selenium Server jar file.
3. Run the following command to start the hub:
    ```sh
    java -jar selenium-server-<version>.jar hub
    ```

### **Start the Chrome Node**
1. Open another terminal window.
2. Run the following command to start a Chrome node on port 5555:
    ```sh
    java -jar selenium-server-<version>.jar node --port 5555 --detect-drivers true -I "chrome" --hub http://localhost:4444/ui
    ```

### **Start the Edge Node**
1. Open another terminal window.
2. Run the following command to start an Edge node on port 6666:
    ```sh
    java -jar selenium-server-<version>.jar node --port 6666 --detect-drivers true -I "edge" --hub http://localhost:4444/ui
    ```
### **Run Test in Selenium Grid:**
1. Open `suiteAll.xml`
2. Edit value of parameters `runMode` is `grid`
3. Start test with maven command line

## **Run Tests With Maven**
> `mvn clean test`<br/>

## **Generating Allure Report**
After running the tests, generate the Allure report:

Use the following command to generate the Allure report:

> `allure serve allure-results`

Note: If you're using Gradle, the results may be in build/allure-results.

This command will start a local server and open the Allure report in your default web browser.

## **ReportPortal Results**
See test results as launches in URL http://localhost:8080/ui/?#default_personal/launches/all