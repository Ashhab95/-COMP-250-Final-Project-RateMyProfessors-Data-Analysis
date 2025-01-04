package finalproject;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;


public class RatingByKeyword extends DataAnalyzer {

	private MyHashTable<String, MyHashTable<String, Integer>> distribution;
	
    public RatingByKeyword(Parser p) {
        super(p);
    }

	@Override
	public MyHashTable<String, Integer> getDistByKeyword(String keyword) {
		return distribution.get(keyword.toLowerCase().trim());
	}

	@Override
	public void extractInformation() {
		distribution = new MyHashTable<>();

		for (String[] array : parser.data) {
			double rating = Double.parseDouble(array[parser.fields.get("student_star")]);
			int ratingCategory = Math.min(5, Math.max(1, (int) rating));
			if (rating < 1 || rating > 5) continue;

			String comment = array[parser.fields.get("comments")].toLowerCase();
			String[] tokens = comment.replaceAll("[^a-zA-Z']+", " ").split("\\s+");
			MyHashTable<String, Boolean> addedTokens = new MyHashTable<>();

			for (String token : tokens) {
				if (token.isEmpty()) continue;
				if (addedTokens.get(token) != null) continue;
				addedTokens.put(token, true);
				MyHashTable<String, Integer> ratingTable = distribution.get(token);

				if (ratingTable == null) {
					ratingTable = new MyHashTable<>();
					ratingTable.put("1", 0);
					ratingTable.put("2", 0);
					ratingTable.put("3", 0);
					ratingTable.put("4", 0);
					ratingTable.put("5", 0);
					distribution.put(token, ratingTable);
				}

				ratingTable.put(Integer.toString(ratingCategory), ratingTable.get(Integer.toString(ratingCategory)) + 1);
			}
		}
	}
}

