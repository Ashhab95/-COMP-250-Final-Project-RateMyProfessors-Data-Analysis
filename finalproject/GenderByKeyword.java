package finalproject;

import javax.swing.text.html.parser.Parser;
import java.util.ArrayList;

import java.util.LinkedList;

public class GenderByKeyword extends DataAnalyzer {

	private MyHashTable<String, MyHashTable<String, Integer>> distribution;
	
	public GenderByKeyword(Parser p) {
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
			String gender = array[parser.fields.get("gender")].toUpperCase();
			String comment = array[parser.fields.get("comments")].toLowerCase();
			String[] tokens = comment.replaceAll("[^a-zA-Z']+", " ").split("\\s+");
			MyHashTable<String, Boolean> seenTokens = new MyHashTable<>();
			for (String token : tokens) {
				if (token.isEmpty()) continue;
				if (seenTokens.get(token) != null) continue;
				seenTokens.put(token, true);
				MyHashTable<String, Integer> genderTable = distribution.get(token);
				if (genderTable == null) {
					genderTable = new MyHashTable<>();
					genderTable.put("M", 0);
					genderTable.put("F", 0);
					genderTable.put("X", 0);
					distribution.put(token, genderTable);
				}
				genderTable.put(gender, genderTable.get(gender) + 1);
			}
		}
	}

}

