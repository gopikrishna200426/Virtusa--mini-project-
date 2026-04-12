# 🚚 E-Commerce Logistics Tracker (SQL Project)

## 📌 Business Case

**SwiftShip** is a third-party logistics provider handling thousands of deliveries daily.
The company faces issues with **delayed shipments** and **underperforming delivery partners**.

## 🎯 Project Objective

This project aims to:

* Identify delayed shipments
* Evaluate delivery partner performance
* Calculate success rates
* Analyze delivery trends and popular cities
  
## 🛠️ Technologies Used

* MySQL
* SQL (DDL, DML, Joins, Aggregations, Date Functions)

---
## 🗂️ Database Schema

### 1. Partners

* Stores delivery partner details

### 2. Shipments

* Tracks order, delivery, and status

### 3. DeliveryLogs

* Stores shipment status updates
---
## ⚙️ Features Implemented

### 🔴 Delayed Shipments Detection

* Identifies shipments delivered after the promised date

### 📊 Partner Performance Analysis

* Counts successful vs returned deliveries

### 🏆 Partner Scorecard

* Calculates success rate for each partner

### 🌍 Zone Analysis

* Finds most popular destination city in last 30 days

### 📈 Advanced Analytics

* Average delay per partner
* Late deliveries count
* Delivery time calculation
* Monthly shipment trends

## 📂 Project Structure

```
Ecommerce-Logistics-SQL/
│
├── sql/
│   └── logistics.sql
│
├── outputs/
│   ├── output1.png
│   ├── output2.png
│   ├── output3.png
│   └── ...
│
├── README.md
```
## 📸 Sample Output
<img width="702" height="227" alt="output1" src="https://github.com/user-attachments/assets/939bfb99-fd8b-4005-933b-e8b884c9ceb5" />
<img width="422" height="221" alt="output2" src="https://github.com/user-attachments/assets/7182aef7-2bb2-49c9-ba9f-b1812bd2e69b" />
<img width="482" height="345" alt="output4" src="https://github.com/user-attachments/assets/ebc1504e-2a4d-4c4a-9dda-2aaa0b3dc6d6" />

'''
## 💡 Key SQL Concepts Used

* JOIN (INNER JOIN)
* GROUP BY & Aggregations
* CASE Statements
* DATE Functions (DATEDIFF, DATE_SUB)
* Filtering & Sorting
---
## 🚀 Future Enhancements

* Integrate with a web dashboard
* Add real-time tracking system
* Connect with Power BI for visualization
---
## 👨‍💻 Author
Completed by: Gopikrishna Thirunavukarasu
SRM University
