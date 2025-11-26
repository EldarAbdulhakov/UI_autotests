@echo off
set FAILED_XML=target/surefire-reports/testng-failed.xml

echo Searching for failed tests...

if exist "%FAILED_XML%" (
    echo A file with failed tests has been found. Let's run only those...
    call mvn test -Dsurefire.suiteXmlFiles=%FAILED_XML%
) else (
    echo.
    echo File %FAILED_XML% not found!
    echo First, perform a full run: mvn clean test
    echo.
)
