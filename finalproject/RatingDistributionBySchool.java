package finalproject;



import java.util.ArrayList;


public class RatingDistributionBySchool extends DataAnalyzer {
	private MyHashTable<String, MyHashTable<String, Integer>> distribution;

	public RatingDistributionBySchool(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		return distribution.get(keyword.toLowerCase().trim());
	}

	@Override
	public void extractInformation() {
		distribution = new MyHashTable<>();
		MyHashTable<String, MyHashTable<String, ArrayList<Double>>> hashTable = new MyHashTable<>();

		for (String[] array : parser.data) {
			String schoolName = array[parser.fields.get("school_name")].toLowerCase().trim();
			String professorName = array[parser.fields.get("professor_name")].toLowerCase().trim();
			double studentRating = Double.parseDouble(array[parser.fields.get("student_star")]);

			MyHashTable<String, ArrayList<Double>> professors = hashTable.get(schoolName);
			if (professors == null) {
				professors = new MyHashTable<>();
				hashTable.put(schoolName, professors);
			}

			ArrayList<Double> ratings = professors.get(professorName);
			if (ratings == null) {
				ratings = new ArrayList<>();
				professors.put(professorName, ratings);
			}
			ratings.add(studentRating);
		}

		for (MyPair<String, MyHashTable<String, ArrayList<Double>>> schoolInfo : hashTable) {
			String schoolName = schoolInfo.getKey();
			MyHashTable<String, ArrayList<Double>> professors = schoolInfo.getValue();

			MyHashTable<String, Integer> professorTable = new MyHashTable<>();
			for (MyPair<String, ArrayList<Double>> profEntry : professors) {
				String professorName = profEntry.getKey();
				ArrayList<Double> ratings = profEntry.getValue();
				double avgRating = ratings.stream().mapToDouble(Double::doubleValue).average().orElse(0);
				int count = ratings.size();
				String professorDetails = professorName + "\n" + Math.round(avgRating * 100.0) / 100.0;
				professorTable.put(professorDetails, count);
			}
			distribution.put(schoolName, professorTable);
		}
	}
}

