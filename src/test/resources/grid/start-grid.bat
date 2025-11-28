@echo off
echo Starting Selenium GRID HUB...
start java -jar selenium-server-4.38.0.jar hub --host 127.0.0.1 --port 4444

timeout /t 5

echo Starting Selenium NODE (maxSessions=5)...
start java -jar selenium-server-4.38.0.jar node --max-sessions 5  --hub http://127.0.0.1:4444
echo GRID started:
echo Hub URL: http://localhost:4444/ui
