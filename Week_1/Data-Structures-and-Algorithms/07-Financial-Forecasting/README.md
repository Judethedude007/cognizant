# Exercise 7 - Financial Forecasting

## Objective
Implement a financial forecasting function to predict future value based on current value, growth rate, and number of years.

## Files Created
- FinancialForecaster.java
- Main.java

## How to Run
Open terminal inside the src folder and run:

javac *.java
java Main

## Expected Output
The program displays the predicted future value using both recursive and iterative methods.

## What I Understood
Recursion is a technique where a method calls itself to solve a smaller version of the same problem. In this exercise, the future value is calculated year by year until the base case of zero years is reached. The recursive method has O(n) time complexity and O(n) space complexity because each recursive call is stored on the call stack. The iterative method also has O(n) time complexity but uses O(1) space.
