
# COMP 250 Final Project: RateMyProfessors Data Analysis

## Introduction

This project was developed as part of **COMP 250 Winter 2023**. It focuses on analyzing professor reviews from **RateMyProfessors.com** using a custom hash table implementation and data visualization. The dataset includes detailed reviews of university professors, with attributes such as ratings, comments, and perceived gender.

The primary objectives of the project were to:
1. Implement a generic hash table with efficient operations.
2. Build data analysis tools to extract meaningful insights from the dataset.
3. Create a user-friendly GUI using JavaFX to visualize the results.

## Features

1. **Custom Hash Table**:
   - A generic hash table (`MyHashTable<K, V>`) supporting core operations (`put`, `get`, `remove`, `rehash`) with average constant time complexity.
   - Supports dynamic resizing and iteration over key-value pairs.

2. **Data Analysis Tools**:
   - `RatingDistributionByProf`: Displays the distribution of ratings for a specific professor.
   - `RatingDistributionBySchool`: Shows rating counts and averages for professors in a given school.
   - `GenderByKeyword`: Analyzes the frequency of specific keywords in reviews based on professor gender.
   - `RatingByKeyword`: Displays rating distribution associated with different keywords.
   - `RatingByGender`: Shows the distribution of quality and difficulty ratings by gender.

3. **Graphical User Interface (GUI)**:
   - Developed using **JavaFX** with a clean and intuitive layout defined in `scene.fxml`.
   - GUI controls user interactions and displays results in various chart formats (e.g., bar charts, line graphs).
   - Styled using `style.css` for a polished user experience.

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

### Data Analysis Classes

- **Abstract Class**: `DataAnalyzer` defines the core structure for data analysis tasks, with methods `extractInformation()` and `getDistByKeyword()` to be implemented by subclasses.
- **Subclasses**:
  - `RatingDistributionByProf`: Analyzes rating distribution for a specific professor.
  - `RatingDistributionBySchool`: Computes rating counts and averages for professors in a given school.
  - `GenderByKeyword`: Evaluates keyword frequency based on professor gender.
  - `RatingByKeyword`: Displays rating distribution for specific keywords.
  - `RatingByGender`: Shows quality and difficulty rating distribution by gender.

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

