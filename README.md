# Train Reservation System (Java)

A console-based Train Reservation System built using Java, JDBC, and MySQL database.

## Project Overview

This is a complete train reservation management system that allows users to:
- Add new trains to the system
- Book tickets for passengers
- Cancel existing tickets
- View train details and availability

## Features

1. **Add Train** - Add new trains with ID, name, and seat capacity
2. **Book Ticket** - Reserve seats for passengers on available trains
3. **Cancel Ticket** - Cancel booked tickets and release seats
4. **View Train Details** - View train information including available seats

## Technology Stack

- **Language:** Java
- **Database:** MySQL
- **JDBC Driver:** MySQL Connector/J 9.6.0
- **Build Tool:** Manual compilation with javac

## Project Structure

```
Train_Management_System/
├── DBConnection.java          # Database connection handler
├── Main.java                  # Main entry point with menu system
├── Passenger.java             # Passenger model class
├── ReservationSystem.java     # Core business logic
├── Ticket.java                # Ticket model class
├── Train.java                 # Train model class
├── lib/
│   └── mysql-connector-j-9.6.0.jar  # MySQL JDBC driver
└── README.md                  # Project documentation
```

## Database Setup

### 1. Create Database

```
sql
CREATE DATABASE train_system;
USE train_system;
```

### 2. Create Tables

```sql
-- Trains Table
CREATE TABLE trains (
    train_id INT PRIMARY KEY,
    train_name VARCHAR(100),
    total_seats INT,
    available_seats INT
);

-- Tickets Table
CREATE TABLE tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_name VARCHAR(100),
    passenger_age INT,
    train_id INT,
    seat_number INT,
    status VARCHAR(20),
    FOREIGN KEY (train_id) REFERENCES trains(train_id)
);
```

### 3. Database Configuration

Update the connection details in `DBConnection.java` if needed:

```
java
private static final String URL = "jdbc:mysql://localhost:3306/train_system";
private static final String USER = "root";
private static final String PASSWORD = "Mini@280906";
```

## How to Run

### Step 1: Compile the Project

```
bash
javac -cp ".;lib/mysql-connector-j-9.6.0.jar" *.java
```

### Step 2: Run the Application

```
bash
java -cp ".;lib/mysql-connector-j-9.6.0.jar" Main
```

## 📖 Usage Guide

When you run the application, you'll see the following menu:

```
==== Train Reservation System ====
1. Add Train
2. Book Ticket
3. Cancel Ticket
4. View Train Details
5. Exit
```

### Option 1: Add Train
- Enter Train ID (e.g., 101)
- Enter Train Name (e.g., Express 101)
- Enter Total Seats (e.g., 50)

### Option 2: Book Ticket
- Enter Passenger Name
- Enter Passenger Age
- Enter Train ID to book

### Option 3: Cancel Ticket
- Enter the Ticket ID to cancel

### Option 4: View Train Details
- Enter the Train ID to view details

### Option 5: Exit
- Exit the application

## Code Description

### DBConnection.java
Manages the database connection using JDBC. Provides a static method `getConnection()` that returns a connection to the MySQL database.

### Main.java
The entry point of the application. Contains the main menu loop and handles user input for all operations.

### Passenger.java
A model class representing a passenger with:
- `passengerId` - Unique identifier
- `name` - Passenger name
- `age` - Passenger age

### Train.java
A model class representing a train with:
- `trainId` - Unique identifier
- `trainName` - Name of the train
- `totalSeats` - Total seat capacity
- `availableSeats` - Currently available seats

### Ticket.java
A model class representing a booked ticket with:
- `ticketId` - Unique ticket identifier
- `passenger` - Passenger object
- `train` - Train object
- `seatNumber` - Assigned seat number
- `status` - Ticket status (e.g., "CONFIRMED")

### ReservationSystem.java
Contains the core business logic:
- `addTrain()` - Inserts a new train into the database
- `bookTicket()` - Books a ticket and updates seat availability
- `cancelTicket()` - Cancels a ticket and releases the seat
- `viewTrain()` - Retrieves and displays train information

## Requirements

- Java Development Kit (JDK) 8 or higher
- MySQL Server 5.7 or higher
- MySQL Connector/J library

## Future Enhancements

- User authentication system
- Train schedule management
- Multiple route support
- Payment integration
- Ticket printing feature
- GUI interface

