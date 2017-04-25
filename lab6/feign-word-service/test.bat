:: https://serverfault.com/questions/432322/how-to-sleep-in-a-batch-file
:: http://www.robvanderwoude.com/wait.php

@echo off
echo test1
timeout /t 20
echo test2
timeout /t 15 /nobreak
echo test3
timeout /t 10 /nobreak > NUL
echo test4
timeout /t 18 > NUL
echo test5
