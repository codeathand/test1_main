# Preconditions

Internet connection

Windows 10

Page http://automationpractice.com/index.php is accessible

Github repository https://github.com/codeathand/test1

Eclipse IDE

TestNG for Eclipse

Chrome driver 88.0.4324.96 and compatible version of Chrome browser

Install Maven https://mkyong.com/maven/how-to-install-maven-in-windows/

Environment system variable MAVEN_HOME - path of Maven

Environment Path variable add %MAVEN_HOME%\bin

# Install

Download from the Git repository https://github.com/codeathand/test1

Unpack archive

Import project in Eclipse File > Import

Find Maven > Existing Maven projects, click Next

Click Browse and select unpacked folder from the archive

Click Select All

Click Finish button

# Run the tests ECLIPSE

In the project expand src/test/java

Expand com.qa.test1 package

Right click on Test1.java

Find Run As and click TestNG Test

# Run the tests  POWERSHELL or TERMINAL

Go to the project folder

Type 

```
mvn clean install
```

for complete build or

```
mvn test
```

only for tests