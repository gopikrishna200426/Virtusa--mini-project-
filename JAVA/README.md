# SmartPay Utility Biller 
## Overview

SmartPay Utility Biller is a Core Java console application that calculates electricity or water bills based on units consumed using a progressive slab system. The program also validates user input and generates a simple digital receipt.

This project is designed to demonstrate fundamental Java concepts such as interfaces, classes, loops, and conditional logic.

---
##  Features

* Progressive slab-based billing system
* Input validation for meter readings
* Interface implementation (`Billable`)
* Digital receipt generation
* Continuous input support (multiple customers)
* Compatible with online Java compilers

---
##  Billing Logic

| Units Consumed | Rate per Unit |
| -------------- | ------------- |
| 0 – 100        | $1.00         |
| 101 – 300      | $2.00         |
| Above 300      | $5.00         |

> The billing is calculated cumulatively based on slabs.
---
##  Technologies Used

* Java (Core Java)
* Object-Oriented Programming (OOP)

  * Interface
  * Class & Objects
  * Encapsulation

---
## Sample Input

```id="input1"
Enter Customer Name: Gopi
Enter Previous Reading: 100
Enter Current Reading: 250
```

---

## Sample Output

```id="output1"
------ DIGITAL RECEIPT ------
Customer Name : Gopi
Units Consumed: 150
Total Bill    : $200.0
-----------------------------
```
<img width="546" height="687" alt="output" src="https://github.com/user-attachments/assets/2b252c05-e41b-4b9d-8866-0465219d2966" />

---

## Input Validation

* The program ensures that:

  * Previous reading is not greater than current reading
* Displays an error message if invalid input is entered

---

##  Learning Objectives

* Understand how to use interfaces in Java
* Implement real-world billing logic using conditions
* Practice loops and user input handling
* Build structured and maintainable code

---

##  Author

Completed by : Gopikrishna Thirunavukarasu

SRM university

---
