# Exercise 2 - E-commerce Platform Search Function

## Objective
Implement search functionality for an e-commerce platform using linear search and binary search.

## Files Created
- Product.java
- SearchService.java
- Main.java

## How to Run
Open terminal inside the src folder and run:

javac *.java
java Main

## Expected Output
The program searches for a product by product ID using both linear search and binary search.

## What I Understood
Linear search checks each product one by one, so its time complexity is O(n). Binary search is faster with O(log n), but it only works correctly when the data is sorted. For large product lists, binary search is more efficient if products are sorted by ID.
