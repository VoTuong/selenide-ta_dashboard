@echo off

start cmd /k "java -jar selenium-server-4.25.0.jar hub"

start cmd /k "java -jar selenium-server-4.25.0.jar node --detect-drivers true -I 'chrome' --port 5555"

start cmd /k "java -jar selenium-server-4.25.0.jar node --detect-drivers true --port 6666"

pause