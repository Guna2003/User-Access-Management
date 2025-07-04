# User Access Management System

This project is a role-based web application that simplifies the management of software access requests within an organization. Built using Java Servlets, JSP, and PostgreSQL, it allows employees to request software access, managers to approve or reject those requests, and admins to manage the list of available software.

---

##  Features

###  Employee
- Register and log in to the system
- View all available software
- Request access to specific software
- Check request status (Approved / Rejected)

###  Manager
- Log in securely
- View all pending software requests
- Approve or reject employee requests

###  Admin
- Log in with admin credentials
- Add new software to the system
- Manage existing software records

---

##  Tech Stack

- **Frontend:** JSP, HTML, CSS
- **Backend:** Java Servlets
- **Database:** PostgreSQL
- **Build Tool:** Maven
- **Server:** Apache Tomcat
- **IDE:** VS Code

---

---

## ⚙️ Database Configuration

Create a PostgreSQL database with the required tables:

```sql
CREATE DATABASE user_access_db;

-- Users table
CREATE TABLE users (
 id SERIAL PRIMARY KEY,
 username VARCHAR(100) UNIQUE NOT NULL,
 password VARCHAR(100) NOT NULL,
 role VARCHAR(20) NOT NULL
);

-- Software table
CREATE TABLE software (
 id SERIAL PRIMARY KEY,
 name VARCHAR(100) NOT NULL,
 description TEXT
);

-- Access Requests table
CREATE TABLE requests (
 id SERIAL PRIMARY KEY,
 user_id INT REFERENCES users(id),
 software_id INT REFERENCES software(id),
 status VARCHAR(20) DEFAULT 'Pending'
);


