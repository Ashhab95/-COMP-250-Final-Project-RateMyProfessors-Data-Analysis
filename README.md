
# COMP 250 Final Project: RateMyProfessors Data Analysis

## Introduction

This project, developed for **COMP 250 Winter 2023**, focuses on analyzing professor reviews from **RateMyProfessors.com** using hash tables and data visualization. The dataset contains detailed reviews of university professors, including attributes like ratings, comments, and perceived gender. The primary goal is to implement a custom hash table, perform various analyses, and visualize the results through a JavaFX-based graphical user interface (GUI).

## Features

1. **Custom Hash Table Implementation**:
   - Developed a generic hash table (`MyHashTable<K, V>`) supporting key operations like `put`, `get`, `remove`, and `rehash` with average constant time complexity.
   - Supports iteration over key-value pairs using a custom iterator.

2. **Data Analysis Tools**:
   - **Rating Distribution by Professor**:
     - Displays how ratings are distributed for a specific professor.
   - **Rating Distribution by School**:
     - Shows the rating count per professor for a selected school along with average ratings.
   - **Gender Distribution by Keyword**:
     - Analyzes the frequency of a keyword in reviews based on the perceived gender of professors.
   - **Rating Distribution by Keyword**:
     - Displays how often specific keywords are associated with different rating categories.
   - **Rating by Gender**:
     - Shows the distribution of quality and difficulty ratings for professors based on their perceived gender.

3. **Graphical User Interface**:
   - Built using **JavaFX**.
   - Allows users to interact with the data through simple input fields and buttons.
   - Displays results in bar charts or line graphs, depending on the type of analysis.

## Technologies Used

- **Programming Language**: Java
- **Framework**: JavaFX
- **IDE**: IntelliJ IDEA (with Liberica JDK for JavaFX support)
- **Data Structure**: Custom hash table (`MyHashTable<K, V>`)
- **Dataset**: CSV files containing RateMyProfessors reviews

## How to Run the Application

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed.
- **JavaFX Setup**:
  - **For IntelliJ Users**:
    1. Go to `File > Project Structure > SDKs`.
    2. Add or download the **Liberica JDK** with JavaFX support.
    3. Set the Liberica JDK as your project SDK.
- **Dataset**:
  - Ensure the CSV files (`RateMyProf Data Gendered.csv` and `RateMyProf Data Gendered Sample.csv`) are in the correct directory.

### Steps to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/comp250-final-project.git
   cd comp250-final-project
   ```

2. **Open the Project in IntelliJ IDEA**:
   - Open the project folder and set the Liberica JDK as your project SDK.
   - Ensure that the `finalproject` package structure is correctly maintained.

3. **Build and Run**:
   - Build the project by selecting `Build > Build Project`.
   - Run the main class to launch the JavaFX GUI.
   - Use the provided input fields and buttons to perform different analyses.

## Implementation Details

### MyHashTable

`MyHashTable<K, V>` is a generic hash table implementation with the following features:
- **Dynamic resizing** through rehashing when the load factor exceeds 0.75.
- **O(1) average time complexity** for `put`, `get`, and `remove` operations.
- Custom methods:
  - `getKeySet()`: Returns a list of all keys.
  - `getValueSet()`: Returns a list of all unique values.
  - `getEntries()`: Returns a list of all key-value pairs.

### Data Analysis Classes

- **DataAnalyzer** (abstract class):
  - Defines the core structure for all data analysis tasks.
  - Contains methods `extractInformation()` and `getDistByKeyword()` to be implemented by subclasses.

- **Subclasses**:
  - `RatingDistributionByProf`: Analyzes rating distribution for a specific professor.
  - `RatingDistributionBySchool`: Computes rating count and average for professors in a given school.
  - `GenderByKeyword`: Evaluates the frequency of a keyword in reviews based on professor gender.
  - `RatingByKeyword`: Displays rating distribution associated with specific keywords.
  - `RatingByGender`: Shows quality and difficulty rating distribution by gender.

## Success Criteria

- Accurate implementation of a hash table with the specified performance guarantees.
- Proper extraction and analysis of data using custom-built tools.
- Functional GUI that provides meaningful visualizations for different analyses.
- Code adheres to the course guidelines and constraints.

## Future Enhancements

- Improve the GUI for better user experience.
- Add more advanced data visualizations (e.g., pie charts, histograms).
- Allow export of analysis results to external files (e.g., CSV or PDF).
- Incorporate additional filters for more granular analysis (e.g., date range, department).

## Contact

For any inquiries or feedback, please contact **Kazi Ashhab Rahman** at [kazi.a.rahman@mail.mcgill.ca](mailto:kazi.a.rahman@mail.mcgill.ca).
