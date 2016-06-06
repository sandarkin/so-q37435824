### Sample project for Stackoverflow question How to use @PathVariable to resolve parameter name in Spring Security?
<http://stackoverflow.com/questions/37435824>

On Unix run
```
./gradlew bootRun
```

On Windows run
```
gradlew.bat bootRun
```
----
Go to <http://localhost:8080/something/1> and in console output you can see something like this
```
2016-06-06 17:09:01.635  INFO 2871 --- c.s.so.q37435824.SecurityService: myParam value from PathVariable equals 1
```
----
