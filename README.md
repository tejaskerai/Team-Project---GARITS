

# GARITS -  (The Garage IT System)

## Overview 

GARITS involved creating a desktop application for a garage business that would keep records of customers and their vehicles. The franchisee is able to add and manage existing customer and also add their vehicle inventory. They can manage stock by updating, adding or removing them. Mechanics are able to see a list of pending jobs which they can choose to complete. They are required to add the parts they have used and include any additional information that they carried out on the job. Administrator are able to add new staff and manage current staff.
This application was created as a team project at university.

### To view a demo of the application click the video below:
[![FindTheTime](https://j.gifs.com/MwyKGm.gif)](https://www.youtube.com/watch?v=MPG1YR7sgzQ&ab_channel=TejasKerai)

## Tech Stack
These tools were used to create the application:
- **IntelliJ** - IDE
- **Java** - Programming language
- **MySQL 8** - Relational Database Management System used to store information for the application
- **MySQL Workbench** - Tool used to view database relations and data
- **Hibernate** -  ORM used for mapping an object-oriented domain model to a relational database


## Installation
Clone the repository
```
git@github.com:tejaskerai/Team-Project---GARITS.git
```

You will need Intellij to run the application, all dependencies are included in pom.xml file. You will need MySQL Workbench to establish connection and import database.

### Click link below for video guide to set up
[Installation video guide](https://www.youtube.com/watch?v=7detWDzps-U&feature=youtu.be&ab_channel=TejasKerai)

1. Turn on MySQL server from **services**
2. Create new connection on MySQL Workbench, and change port number to **3308**. (Default password: 1234)
3. Download sample data from 
[Garitsdb with sample data](https://1drv.ms/u/s!Aq-oVUnBq_M7kRfkiSOCFusylbjR?e=ubQrK9)
4. Select **server** tab then **Data import**
5. Select **Import form self-contained file**  and select the sample data file
6. Run application

