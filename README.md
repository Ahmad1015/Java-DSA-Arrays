# Java Array Operations

This Java program demonstrates various operations on an integer array, including adding elements at the start and end, searching for an element, sorting the array, and updating elements at a specific location.

## Table of Contents

- [Introduction](#introduction)
- [Usage](#usage)
- [Available Operations](#available-operations)
- [Sample Code](#sample-code)

## Introduction

This Java program showcases how to perform common operations on an integer array using object-oriented programming concepts. It consists of a base `List` class with abstract methods and a concrete `Array` class that extends `List` to provide implementations for these methods.

## Usage

To use this program, you need to compile the Java files and run the `Main` class. Here are the steps:

1. Compile the Java files:
```bash
javac Main.java
```

2. Run the program:
```bash
java Main
```



## Available Operations

The program includes the following operations:

### 1. Adding Elements

- `addAtStart(int element)`: Adds an element to the beginning of the array.
- `addAtEnd(int element)`: Adds an element to the end of the array.

### 2. Searching

- `search(int element)`: Searches for an element in the array and returns its index if found, or -1 if not found.

### 3. Sorting

- `sortArray()`: Sorts the array in ascending order using the bubble sort algorithm.

### 4. Updating

- `updateArray(int element, int location)`: Updates an element at a specific location in the array.

### 5. Deleting

- `delAtEnd()`: Deletes the element at the end of the array.
- `delAtStart()`: Deletes the element at the beginning of the array.
- `delAtLocation(int location)`: Deletes the element at a specific location in the array.

### 6. Printing

- `print()`: Prints the current elements of the array.

## Sample Code

Here's an example of how to use the provided operations in the `Main` class:

```java
public class Main {
 public static void main(String[] args) {
     // Initialize an array
     List arr = new Array();

     // Adding elements
     arr.addAtStart(42);
     arr.addAtEnd(77);

     // Searching for an element
     int location = arr.search(8);

     // Sorting the array
     arr.sortArray();

     // Updating an element
     arr.updateArray(5, 2);

     // Deleting an element
     arr.delAtEnd();

     // Printing the array
     arr.print();
 }
}
```
Feel free to explore and modify the code according to your requirements.
