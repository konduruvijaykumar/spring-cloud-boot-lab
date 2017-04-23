:: http://stackoverflow.com/questions/22469732/running-a-multiple-jar-files-in-a-batch-file
:: http://stackoverflow.com/questions/14554786/batch-script-run-multiple-jar-files-at-once
:: http://stackoverflow.com/questions/6573062/how-to-execute-more-than-one-maven-command-in-bat-file
:: http://stackoverflow.com/questions/6130312/execute-multiple-maven-project-from-ms-bat-file

@echo off
::call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=subject"
::call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=verb"
::call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=article"
::call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=adjective"
::call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=noun"
::call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=sentence"

:: Looks like above statements execute sequentially on after another after each task completes.
:: In our case tomcat server start and continues to run, hence other remaining tasks will not.
:: Lets use start command to run simultaneously or asynchronously
:: http://stackoverflow.com/questions/1103994/how-to-run-multiple-bat-files-within-a-bat-file
:: I am not good at writing windows batch files. So i feel that this can be further optimized like add wait b/w starts

::start call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=subject"
::start call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=verb"
::start call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=article"
::start call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=adjective"
start call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=noun"
::start call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=sentence"
