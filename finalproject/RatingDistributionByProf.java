package finalproject;



public class RatingDistributionByProf extends DataAnalyzer {

	private MyHashTable<String, MyHashTable<String, Integer>> distribution;
	
    public RatingDistributionByProf(Parser p) {
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
			String professorName = array[parser.fields.get("professor_name")].toLowerCase().trim();
			double studentScore = Double.parseDouble(array[parser.fields.get("student_star")]);
			int ratingCategory = Math.min(5, Math.max(1, (int) studentScore));
			MyHashTable<String, Integer> ratingTable = distribution.get(professorName);

			if (ratingTable == null) {
				ratingTable = new MyHashTable<>();
				ratingTable.put("1", 0);
				ratingTable.put("2", 0);
				ratingTable.put("3", 0);
				ratingTable.put("4", 0);
				ratingTable.put("5", 0);
				distribution.put(professorName, ratingTable);
			}

			int count = ratingTable.get(Integer.toString(ratingCategory));
			ratingTable.put(Integer.toString(ratingCategory), count + 1);
		}
	}
}

