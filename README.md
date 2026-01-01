🏦 Bank Management System – REST API

📌 Project Overview

The Bank Management System is a Java-based RESTful web application that provides core banking operations such as:
Customer management
Account creation and closure
Deposits, withdrawals, and fund transfers
Transaction history
Administrative reports
The project follows a layered architecture using:
Controller Layer
Service Layer
DAO Layer
Model Layer

🛠️ Technology Stack

Technology	Description
Java	Core programming language
JAX-RS (Jersey)	REST API development
JDBC	Database connectivity
MySQL	Relational database
Maven	Dependency management
JSON	Data exchange format

📂 Project Structure
com.bank.management
│
├── controller
│   ├── AccountController.java
│   ├── CustomerController.java
│   ├── TransactionController.java
│   └── ReportController.java
│
├── service
│   ├── AccountService.java
│   ├── CustomerService.java
│   ├── TransactionService.java
│   └── ReportService.java
│
├── dao
│   ├── AccountDAO.java
│   ├── CustomerDAO.java
│   ├── TransactionDAO.java
│   └── TransactionHistoryDAO.java
│
├── model
│   ├── Account.java
│   ├── Customer.java
│   └── Transaction.java
│
├── util
│   ├── DBUtil.java
│   └── AccountNumberGenerator.java
│
└── config
    └── DatabaseConfig.java

🚀 Features

👤 Customer Management

Create customer
View customer details
Update customer
Delete customer

💳 Account Management

Open bank account
Close account
Check balance
💰 Transactions
Deposit money
Withdraw money
Transfer funds between accounts

📊 Reports

Transaction history per account
Total customers
Total deposited amount

🔌 API Endpoints

🔹 Customer APIs

Method	Endpoint	Description
POST	/customers	Create customer
GET	/customers/{id}	Get customer by ID
GET	/customers	Get all customers
PUT	/customers/{id}	Update customer
DELETE	/customers/{id}	Delete customer

🔹 Account APIs

Method	Endpoint	Description
POST	/accounts	Open account
GET	/accounts/{accNo}/balance	Get balance
PUT	/accounts/{accNo}/close	Close account
DELETE	/accounts/{accNo}	Close account

🔹 Transaction APIs

Method	Endpoint	Description
POST	/transactions/deposit	Deposit money
POST	/transactions/withdraw	Withdraw money
POST	/transactions/transfer	Transfer funds

🔹 Report APIs

Method	Endpoint	Description
GET	/reports/history/{accNo}	Transaction history
GET	/reports/admin/summary	Admin summary

🗄️ Database Configuration

application.properties
db.url=jdbc:mysql://localhost:3306/bank_db
db.username=root
db.password=your_password
db.driver=com.mysql.cj.jdbc.Driver

⚙️ How to Run

Clone the repository
Import project into Eclipse / IntelliJ
Configure application.properties
Create database tables
Deploy on Apache Tomcat
Test APIs using Postman

✅ Key Highlights

✔ Clean layered architecture
✔ Secure database access
✔ Modular design
✔ Easy to extend
✔ Industry-standard coding practices

📌 Future Enhancements

JWT Authentication
Role-based access control
Swagger API documentation
Pagination for reports
Logging and exception handling improvements

👨‍💻 Developed By

Bank Management System Project
Java REST API Based Application
