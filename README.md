
# COMP 250 Final Project: RateMyProfessors Data Analysis

## Introduction

This project was developed as part of **COMP 250 Winter 2023**. It focuses on analyzing professor reviews from **RateMyProfessors.com** using a custom hash table implementation and data visualization. The dataset includes detailed reviews of university professors, with attributes such as ratings, comments, and perceived gender.

## Features

### 1. Rating Distribution by Professor

This feature displays how ratings are distributed for a given professor. It maps the ratings into five categories ("1", "2", "3", "4", "5") and returns the count of reviews in each category.

**Example Output**:

![Rating Distribution by Professor](Sample%20Run/Screenshot%202025-01-04.png)

### 2. Rating Count Per Professor for a Selected School

This feature shows the rating distribution within a selected school. It maps professor names to the number of reviews received along with their average ratings.

**Example Output**:

![Rating Count Per Professor](Sample%20Run/Screenshot%202025-01-04%202.png)

### 3. Gender Distribution by Keyword

This feature evaluates the gender distribution for specific keywords in reviews. It maps genders ("M", "W", "X") to the number of times the input word appears in reviews for professors.

**Example Output**:

![Gender Distribution by Keyword](Sample%20Run/Screenshot%202025-01-04%203.png)

### 4. Rating Distribution by Keyword

This feature shows the distribution of ratings associated with a specific keyword. It maps the ratings ("1", "2", "3", "4", "5") to the count of reviews containing the keyword.

**Example Output**:

![Rating Distribution by Keyword](Sample%20Run/Screenshot%202025-01-04%204.png)

## Technologies Used

- **Programming Language**: Java
- **Framework**: JavaFX
- **IDE**: IntelliJ IDEA (configured with Liberica JDK for JavaFX support)
- **Data Structure**: Custom hash table (`MyHashTable<K, V>`)
- **Dataset**: CSV files (`RateMyProf_Data_Gendered.csv`, `RateMyProf_Data_Gendered_Sample.csv`)

## How to Run the Application

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed on your system.
- **JavaFX Setup**:
  - **For IntelliJ Users**:
    1. Go to `File > Project Structure > SDKs`.
    2. Add or download the **Liberica JDK** with JavaFX support.
    3. Set the Liberica JDK as your project SDK.
- **Dataset**:
  - Ensure the CSV files (`RateMyProf_Data_Gendered.csv` and `RateMyProf_Data_Gendered_Sample.csv`) are in the correct directory.

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
   - Run the `Main.java` file to launch the JavaFX GUI.
   - Use the GUI to perform different analyses.

## Implementation Details

### MyHashTable

`MyHashTable<K, V>` is a generic hash table implementation with the following features:

- **Dynamic resizing** through rehashing when the load factor exceeds 0.75.
- **O(1) average time complexity** for `put`, `get`, and `remove` operations.
- **Custom methods**:
  - `getKeySet()`: Returns a list of all keys.
  - `getValueSet()`: Returns a list of all unique values.
  - `getEntries()`: Returns a list of all key-value pairs.

### GUI Components

- **`scene.fxml`**: Defines the layout of the JavaFX interface, including input fields, buttons, and chart containers.
- **`Controller.java`**: Handles user interactions and updates the GUI with analysis results.
- **`style.css`**: Provides styling rules for the JavaFX GUI, ensuring a clean and visually appealing interface.
- **`Main.java`**: Serves as the entry point for launching the JavaFX application.

## Success Criteria

- The project meets the specified performance guarantees for hash table operations.
- The GUI is functional and provides meaningful visualizations of analysis results.
- The code adheres to the course guidelines and constraints.

## Future Enhancements

- Improve GUI responsiveness for different screen sizes.
- Add support for exporting analysis results to external files (e.g., CSV, PDF).
- Introduce additional filters for more granular analysis (e.g., date range, department).
- Include more advanced visualization options, such as pie charts or histograms.

## Contact

For any inquiries or feedback, please contact **Kazi Ashhab Rahman** at [kazi.a.rahman@mail.mcgill.ca](mailto:kazi.a.rahman@mail.mcgill.ca).

## License

This project is licensed under the [MIT License](LICENSE).

