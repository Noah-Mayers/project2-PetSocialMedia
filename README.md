# Pet Social Media Application - Puppr

The Pet Social Media Application, enables users to to post pictures of their pets and browse those of other users. The submitted posts are compiled into a feed that each user can browse and posts can be liked or commented on to increase interactions between users.

## Technologies

* [Apache TomCat 8.5](http://tomcat.apache.org/tomcat-8.5-doc/)

* [Hibernate 5](https://mvnrepository.com/artifact/org.hibernate/hibernate-core)

* [Spring Web MVC](https://mvnrepository.com/artifact/org.springframework/spring-webmvc)

* [Google GSON API 2.8.6](https://www.javadoc.io/doc/com.google.code.gson/gson/latest/com.google.gson/module-summary.html)

* [DBeaver](https://dbeaver.io/)

* [Mockito](https://site.mockito.org/)

## Features

* Register and Login Users
* Upload images to be used for profile pictures, pet images, and post images.
* Add associated pets to a logged in user to eventually post
* Generate new posts to be added to a global feed, which is viewable by all users.

## Getting Started / Usage
To begin using this web application, ensure that:
1. Apache TomCat 8.5 is installed
2. Java 8 Runtime Environment is installed

All other dependencies already exist in the `pom.xml` file. To ensure functionality, be sure to refresh the project once you've loaded the code onto your machine.

Next, clone into this repository:
```bash
git clone https://github.com/Noah-Mayers/project2-PetSocialMedia.git
```
Following this, ensure to provide your S3 Key and Secret Key in the `ImageUploadService.java` file found in /src/main/dev/groupone/services directory.

Lastly, replace the placeholder values of your database endpoint/host and credentials in the `application.properties` file found in the /src/main/resources directory

## Contributors
Eduardo Garcia - [Eduardo-Garcia16](https://github.com/eduardo-garcia16)

Ricardo Orellana - [ricdeorellana](https://github.com/ricdeorellana)

Noah Mayers - [Noah-Mayers](https://github.com/Noah-Mayers)

Reese Poche - [ReesePoche](https://github.com/ReesePoche)
