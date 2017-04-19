:: http://stackoverflow.com/questions/22469732/running-a-multiple-jar-files-in-a-batch-file
:: http://stackoverflow.com/questions/14554786/batch-script-run-multiple-jar-files-at-once
:: http://stackoverflow.com/questions/6573062/how-to-execute-more-than-one-maven-command-in-bat-file
:: http://stackoverflow.com/questions/6130312/execute-multiple-maven-project-from-ms-bat-file
@echo off
call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=subject"
call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=verb"
call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=article"
call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=adjective"
call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=noun"
call mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=sentence"
