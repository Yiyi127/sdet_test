# SDET-test
## About the project
Tech stack: Java, Selenium, TestNG

Design Pattern: Page Object Model(POM)

Description: This test project use selenium and TestNG in Java. Assert by the first return result.
For future use, this project can change the website and search terms and the different assert ways.

## 1. Install the necessary packages
```
pip install

```



## 2. Create the following directory structure
```

test_framework/
|-- src/
|   |-- main/
|   |-- test/
|       |-- java/
|           |-- pages/
|               |-- BasePage.java
|               |-- SearchPage.java
|               |-- SearchResultsPage.java
|           |-- tests/
|               |-- TestSearch.java
|           |-- utils/
|               |-- WebDriverFactory.java
|-- pom.xml


```


## 3. Install the dependencies
```
<!-- pom.xml -->

<dependencies>
    <!-- Selenium -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>

    <!-- TestNG -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.4.0</version>
    </dependency>
</dependencies>




```

## 4. Implement the framework
WebDriverFactory.java - Utility to create and manage WebDriver instances

BasePage.java - Base page class for common functionality

SearchPage.java - Page class for the search functionality

SearchResultsPage.java - Page class for handling search results

TestSearch.java - Test case using TestNG

