# Exercise 2 - Factory Method Pattern

## Objective
Implement the Factory Method Pattern to create different types of documents without directly creating objects in the main program logic.

## Files Created
- Document.java
- WordDocument.java
- PdfDocument.java
- ExcelDocument.java
- DocumentFactory.java
- Main.java

## How to Run
Open terminal inside the src folder and run:

javac *.java
java Main

## Expected Output
Opening Word document
Opening PDF document
Opening Excel document

## What I Understood
The Factory Method Pattern moves object creation logic into a factory class. Instead of creating objects directly using new in the main program, the factory decides which object to create based on the input. This makes the code easier to extend when new document types are added.
