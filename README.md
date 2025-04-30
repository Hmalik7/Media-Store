# 📚 Media Store Management System

**Java 8+** • **Maven** • **JUnit 4.13.2**

A Java-based object-oriented library that models a media rental store inventory system with support for various types of books and movies, featuring inheritance hierarchies and polymorphic late fee calculation.

## 🎯 Project Overview

This system implements a robust media inventory management solution where different types of media items (books and movies) can be tracked and managed with operations such as late fee calculation. The architecture demonstrates:

- Clean object-oriented design with clear inheritance hierarchies
- Polymorphism for managing different types of media through a common interface
- Interface-based programming for consistent operations across media types
- Comprehensive unit testing to validate functionality and catch edge cases

## 🏗️ Architecture

### Interface
- `StoreMediaOperations` - Contract for all media items defining core operations

### Abstract Base Classes
- `Book` - Foundation for all book types with common properties and behavior
- `Movie` - Foundation for all movie types with common properties and behavior

### Book Implementation Classes
- `BookFiction` - Implementation for fiction books with genre-specific behavior
- `BookRomance` - Implementation for romance books with specific late fee policies

### Movie Implementation Classes
- `MovieAction` - Implementation for action movies with progressive late fee structure
- `MovieComedy` - Implementation for comedy movies with standard late fee calculation

## ✨ Key Features

### 🔑 Unique Identification
- Each media item is assigned a unique UUID upon creation
- Ensures reliable tracking and identification throughout the system

### 💰 Differentiated Late Fee Calculation
Media types implement their own business logic for late fee calculation:

| Media Type | Base Rate | Special Rules |
|------------|-----------|---------------|
| Fiction Books | $2/day | Standard rate |
| Romance Books | $4/day | Standard rate |
| Comedy Movies | $3/day | Standard rate |
| Action Movies | Base rate | 2x multiplier after 5+ days |

### 🔄 Copy Constructor Pattern
- Enables creating identical copies of media items while preserving identity
- Useful for inventory management and transaction processing

### 🔍 Identity Implementation
- Robust equality implementation based solely on UUID
- Ensures consistent behavior across the system regardless of other property changes

## 🐛 Bug Fixes

The codebase addressed critical bugs in the `equals()` implementation:

**Issue**: Original implementation incorrectly compared multiple properties (ID, title, author/rating)  
**Fix**: Updated to compare only the UUID, which is the true unique identifier

## 🚀 Getting Started

### Prerequisites
- Java 8 or higher
- Maven

### Building the Project

```bash
# Clone the repository
git clone https://github.com/yourusername/media-store.git
cd media-store

# Build the project
mvn clean compile

# Run tests
mvn test
```

## 🧪 Test Suite

The project includes comprehensive tests in `Problem3Test.java` that:

- ✅ Validate late fee calculations for all media types
- ✅ Test equality implementations across the class hierarchy
- ✅ Verify the copy constructor functionality
- ✅ Include specific regression tests that catch the equals() method bugs

## 📋 Development Guidelines

- Follow the established inheritance hierarchy when adding new media types
- Implement the `StoreMediaOperations` interface for all new media classes
- Ensure proper UUID handling for equality comparison
- Add unit tests for any new functionality
