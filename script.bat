javac -d Framework/build/WEB-INF/classes/ Framework/src/*.java
cd Framework/build/WEB-INF/classes
jar -cf framework.jar ./
xcopy /y .\framework.jar ..\..\..\..\Testframework\build\WEB-INF\lib
xcopy /y .\framework.jar ..\..\..\..\
cd ../../../../
SET CLASSPATH=.\Testframework\build\WEB-INF\lib\framework.jar
javac -parameters -d Testframework/build/WEB-INF/classes Testframework/src/*.java
cd Testframework/build
jar -cf TestFramework.war ./
xcopy /y .\TestFramework.war "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps"
xcopy /y .\TestFramework.war ..\..\
cd ../../