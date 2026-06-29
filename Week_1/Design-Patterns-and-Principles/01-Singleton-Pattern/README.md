# Exercise 1 - Singleton Pattern

## Objective
Implement the Singleton Pattern to ensure that only one instance of a class is created.

## Files Created
- Logger.java
- Main.java

## How to Run
Open terminal inside the src folder and run:

javac Logger.java Main.java
java Main

## Expected Output
The logger instance should be created only once. Both logger objects should point to the same instance.

## What I Understood
The Singleton Pattern restricts a class to only one object instance. This is useful when one shared object is required across the application, such as a logger or configuration manager. The constructor is private, and the object is accessed through a static getInstance method.
