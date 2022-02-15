# Java Coding Challenge

The goal of this exercise is to allow you to show us what you know and how you would approach a real project.

## General aspects

- You will find the basic application structure and code in the `cars` directory. You can use the` ANSWERS.md` file if you want to write a short explanation and \ or description of your solution.
- To make things a little easier we have added the necessary assets and configurations in the directory: `src / main / resources`

> After importing the project into your ide, you should be ready to start. The cars application will be on port `8080` after running it with the command` mvn spring-boot: run`

### The technology stack

Below is a list of the technologies that you will find in the application structure:

- Java 8
- Spring boot 2.1.4
- Maven 3.3.9 or above
- Tomcat server 9 (embedded)
- H2 embedded database
- Spring Data JPA

> Feel free to add any dependencies you deem necessary but please stick with the core stack technologies above.

## Introduction

Our client is a large auto dealership with many regional branches across the nation. <br>
He requested a service that allows the application in use to the sellers in the various local branches to read the characteristics of the cars. <br>
The car specs come from different car manufacturers and are in different formats, the idea is to unify the data and expose it with a standard interface like a RESTful service.

### A - The entities

You can find an example of Ford's car features file called ford-example.xml inside the application's resources directory.
Create a UML diagram of the class model to explain how you will represent the information in that file. Remember to create a data structure, entities and normalized relationships.

> Provide the diagram as an image and include it in your answer. <br>
You can also use the `ANSWERS.md` file to explain the schema in more detail if you wish.

### B - Data ingest
Our client wants to start entering Ford car features which are provided in XML format.

You will find a scheduled task within the `FordIngesterTask` class configured to run every minute.
Use it to process the `ford-example.xml` file from the filesystem and put all data into the database provided as you designed in part` A`.

> Feel free to change the scheduled configuration to run the task more or less frequently as needed.

> It is recommended to implement everything needed using JPA entities and Spring repository to persist data. <br>
Use the following java packages `com.carseller.cars.repositories` and` com.carseller.cars.domain`.
The cars application is already configured to find entities and repositories within those packages.

### C - Expose data with a RESTful API
Create the following RESTful API endpoints for:
- 1) Get car features by ID
- 2) Get all the features of the car by brand

> All endpoints must expose results in JSON format.

### D - Frontend Jquery Bootstrap

Make a frontend page with jquery + bootstrap + bootstraptable that queries the second service of the services at point C and displays the list of specifications.

### E - If you've made it this far ....

the customer wants to be able to change the order of the results in the list of point D directly from the front end page, as you would do it with jquery and bootsrap?

### F - Adding images (optional)
Explain *** (no code needed) *** how you would go about adding image files to the `B` part process. <br>
Note that the customer wants to include them as part of the endpoint responses in part "C".

### G - Improvements
Is there anything you think could be improved in your solution? ** Please explain **

## FAQ
- Do I need to provide clean code and apply design templates and best practices?
    - Definitely yes! We will evaluate these aspects.
- Should I add tests?
    - Tests are always important! In the case of this challenge they are not mandatory, but always check what you think is important.
- Do I have to use some specific libraries?
    - No, create the application with the tools you prefer, there are no limits. Keep only the libraries already provided.