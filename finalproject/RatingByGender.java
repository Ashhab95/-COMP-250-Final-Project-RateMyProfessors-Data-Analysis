package finalproject;

import java.util.ArrayList;

public class RatingByGender extends DataAnalyzer{
	private MyHashTable<String, MyHashTable<String, MyHashTable<String, Integer>>> distribution;

	public RatingByGender(Parser p) {
		super(p);
	}

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		String[] parts = keyword.split(",");
		String ratingType = null;
		String gender = null;
		if (parts.length == 3) {
			ratingType = parts[2].strip().toLowerCase();
			gender = parts[1].strip().toUpperCase();
		}
		else {
			ratingType = parts[1].strip().toLowerCase();
			gender = parts[0].strip().toUpperCase();
		}

		return distribution.get(ratingType).get(gender);
	}

	@Override
	public void extractInformation() {
		distribution = new MyHashTable<>();
		MyHashTable<String, MyHashTable<String, Integer>> genderDifficultyTable = new MyHashTable<>();
		genderDifficultyTable.put("F", getRatingTable());
		genderDifficultyTable.put("M", getRatingTable());
		genderDifficultyTable.put("X", getRatingTable());
		MyHashTable<String, MyHashTable<String, Integer>> genderQualityTable = new MyHashTable<>();
		genderQualityTable.put("F", getRatingTable());
		genderQualityTable.put("M", getRatingTable());
		genderQualityTable.put("X", getRatingTable());
		distribution.put("difficulty", genderDifficultyTable);
		distribution.put("quality", genderQualityTable);

		for (String[] array : parser.data) {
			double QualityScore = Double.parseDouble(array[parser.fields.get("student_star")]);
			double difficultyScore = Double.parseDouble(array[parser.fields.get("student_difficult")]);
			String gender = array[parser.fields.get("gender")];

			MyHashTable<String, Integer> difficultyRatingTable = distribution.get("difficulty").get(gender);
			MyHashTable<String, Integer> QualityRatingTable = distribution.get("quality").get(gender);
			String qualityCategory = String.valueOf(Math.min(5, Math.max(1, (int) QualityScore)));
			String difficultyCategory = String.valueOf(Math.min(5, Math.max(1, (int) difficultyScore)));
			int qualityCount = QualityRatingTable.get(qualityCategory);
			qualityCount++;
			QualityRatingTable.put(qualityCategory,qualityCount);
			int difficultyCount = difficultyRatingTable.get(difficultyCategory);
			difficultyCount++;
			difficultyRatingTable.put(difficultyCategory,difficultyCount);
			genderDifficultyTable.put(gender,difficultyRatingTable);
			genderQualityTable.put(gender,QualityRatingTable);
			distribution.put("difficulty", genderDifficultyTable);
			distribution.put("quality", genderQualityTable);
		}

	}

	private MyHashTable<String, Integer> getRatingTable(){
		MyHashTable<String, Integer> ratingTable = new MyHashTable<>();
		ratingTable.put("1", 0);
		ratingTable.put("2", 0);
		ratingTable.put("3", 0);
		ratingTable.put("4", 0);
		ratingTable.put("5", 0);
		return ratingTable;
	}
}
