# La Casa Dorada Restaurant 
## Restaurant Manager

The 'La casa Dorada Restaurant' program is a program adapted to the real need of a Colombian restaurant located in the city of Cali, which needed a software that would allow to carry out the management of orders and basic reports of the restaurant.

## Folder Structure:
-`bin` the folder to hold compiled files.
-`src` the folder to mantain sources.
-`data` the folder to hold application maintenance files.
-`docs` the folder to contain the diagram class and functional requirements.

## ChangeLog
All notable changes to this project will be documented in this file.
### Added
- Class Diagram
- The program exports the csv file with the characteristics specified in the statement.
- README.md file
### Modified
- The program allows the registration and updating of ingredients, types, products, employees, customers and users.
- The program allows the registration of orders and subsequent updating of their status.
- The program serializes and deserializes all the information of the model in files automatically when new information is added and when the program starts, respectively.
- The program allows generating the reports specified in the statement:
a). Employees consolidating orders.
b). Products consolidating number of times it was ordered.
Both in a range of dates indicated by the user of the program.
- The program allows you to import data from a csv file with information on 1) customers, another with information on 2) products, and another with information on 3) orders. The project has in the data directory each csv file with at least 1000 data each.
- Create orders with autogenerated code.
### Fixed
- Serializable bugs.
- Showing Orders in view GUI.
- Showing BaseProducts in view GUI.
- Delete User for the Employee's list.
- The comparison of the date and time interval to generate the reports.

## Authors
- [Jhorman German Mera Escobar](https://github.com/JhormanMera)
- [Paula Andrea Trujillo Mejía](https://github.com/PaulaTrujillo27)










