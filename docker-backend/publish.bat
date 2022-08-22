cd ..
echo "Deleting old jar files"
del .\build\libs\BatteryController.jar
del .\docker-backend\BatteryController.jar

echo "-- LINTING --"
echo "ktlint Format"
call .\gradlew ktlintFormat

echo "ng lint with fixing"
cd .\src\main\kotlin\org\ocpp\battery\controller\frontend
call ng lint --fix
cd ..\..\..\..\..\..\..\

echo "-- BUILDING JAR --"
echo "Gradle build without tests. Run tests manually if required
call .\gradlew build -x test
echo "Copying jar file"
copy .\build\libs\BatteryController.jar .\docker-backend\BatteryController.jar

echo "-- DEPLOYMENT --"
cd .\docker-backend
echo "Docker compose"
call docker-compose build
echo "-- FINISHED --"
