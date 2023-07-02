# Automation Coding Exercise 


## Functionality 
- [x] Login.
- [x] Report.

# Execute 

- To run the tests `mvn test`

- To generate the report `mvn allure:report`

The report will be generated on the path /target/site/allure-maven-plugin

To see the individual test results go to the side bar option `xUnit`

- To set custom properties create a file under `src/test/resources/` called `application.yml`

```yaml
application:
  automation:
    username: myUsername
    password: myPassword
```


