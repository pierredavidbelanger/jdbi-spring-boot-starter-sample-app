# jdbi-spring-boot-starter-sample-app

A sample app that shows how to integrate [jdbi-spring-boot-starter](https://github.com/pierredavidbelanger/jdbi-spring-boot-starter).

## Content

- a [schema](src/main/resources/db/migration/hqldb/V1__initial.sql), [migrated at startup with with flyway](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-execute-flyway-database-migrations-on-startup)  
- a [model](src/main/java/ca/pjer/app/Visit.java) POJO
- a [DAO](src/main/java/ca/pjer/app/VisitDao.java), auto created/wired because of [jdbi-spring-boot-starter](https://github.com/pierredavidbelanger/jdbi-spring-boot-starter#usage) 
- a [Controller](src/main/java/ca/pjer/app/MainCtrl.java) that uses the DAO

## Run

```sh
$ mvn spring-boot:run
```
