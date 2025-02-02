package finalproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;




public class MyHashTable<K,V> implements Iterable<MyPair<K,V>>{
	// num of entries to the table
	private int size;
	// num of buckets 
	private int capacity = 16;
	// load factor needed to check for rehashing 
	private static final double MAX_LOAD_FACTOR = 0.75;
	// ArrayList of buckets. Each bucket is a LinkedList of HashPair
	private ArrayList<LinkedList<MyPair<K,V>>> buckets; 


	// constructors
	public MyHashTable() {
		this(16);
	}

	public MyHashTable(int initialCapacity) {
		this.capacity = initialCapacity;
		this.size = 0;
		this.buckets = new ArrayList<>(this.capacity);
		for (int i = 0; i < this.capacity; i++) {
			this.buckets.add(new LinkedList<>());
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int numBuckets() {
		return this.capacity;
	}

	/**
	 * Returns the buckets variable. Useful for testing  purposes.
	 */
	public ArrayList<LinkedList< MyPair<K,V> > > getBuckets(){
		return this.buckets;
	}

	/**
	 * Given a key, return the bucket position for the key. 
	 */
	public int hashFunction(K key) {
		int hashValue = Math.abs(key.hashCode())%this.capacity;
		return hashValue;
	}

	/**
	 * Takes a key and a value as input and adds the corresponding HashPair
	 * to this HashTable. Expected average run time  O(1)
	 */
	public V put(K key, V value) {
		//  ADD YOUR CODE BELOW HERE

		int hashValue = hashFunction(key);
		LinkedList<MyPair<K, V>> bucket = this.buckets.get(hashValue);

		for (MyPair<K, V> pair : bucket) {
			if (pair.getKey().equals(key)) {
				V previousValue = pair.getValue();
				pair.setValue(value);
				return previousValue;
			}
		}

		bucket.add(new MyPair<>(key, value));
		this.size++;
		if ((double) this.size / this.capacity > MAX_LOAD_FACTOR) {
			this.rehash();
		}

		return null;
	}


	/**
	 * Get the value corresponding to key. Expected average runtime O(1)
	 */

	public V get(K key) {
		int hashValue = hashFunction(key);
		LinkedList<MyPair<K, V>> bucket = this.buckets.get(hashValue);
		for (MyPair<K, V> pair : bucket) {
			if (pair.getKey().equals(key)) {
				return pair.getValue();
			}
		}
		return null;
	}

	/**
	 * Remove the HashPair corresponding to key . Expected average runtime O(1) 
	 */
	public V remove(K key) {
		int hashValue = hashFunction(key);
		LinkedList<MyPair<K, V>> bucket = this.buckets.get(hashValue);
		for (MyPair<K, V> pair : bucket) {
			if (pair.getKey().equals(key)) {
				V value = pair.getValue();
				bucket.remove(pair);
				this.size--;
				return value;
			}
		}

		return null;
	}


	/** 
	 * Method to double the size of the hashtable if load factor increases
	 * beyond MAX_LOAD_FACTOR.
	 * Made public for ease of testing.
	 * Expected average runtime is O(m), where m is the number of buckets
	 */
	public void rehash() {
		int updatedCapacity = this.capacity * 2;
		ArrayList<LinkedList<MyPair<K, V>>> updatedBuckets = new ArrayList<>(updatedCapacity);

		for (int i = 0; i < updatedCapacity; i++) {
			updatedBuckets.add(new LinkedList<>());
		}

		this.capacity = updatedCapacity;

		for (LinkedList<MyPair<K, V>> bucket : this.buckets) {
			bucket.forEach(pair -> {
				int updatedIndex = hashFunction(pair.getKey());
				updatedBuckets.get(updatedIndex).add(pair);
			});
		}

		this.buckets = updatedBuckets;
	}


	/**
	 * Return a list of all the keys present in this hashtable.
	 * Expected average runtime is O(m), where m is the number of buckets
	 */

	public ArrayList<K> getKeySet() {
		ArrayList<K> keySet = new ArrayList<>(this.size);
		for (LinkedList<MyPair<K, V>> bucket : this.buckets) {
			bucket.stream().map(MyPair::getKey).forEach(keySet::add);
		}
		return keySet;
	}

	/**
	 * Returns an ArrayList of unique values present in this hashtable.
	 * Expected average runtime is O(m) where m is the number of buckets
	 */
	public ArrayList<V> getValueSet() {
		ArrayList<V> valueSet = new ArrayList<>();
		for (LinkedList<MyPair<K, V>> bucket : this.buckets) {
			bucket.stream().filter(pair -> !valueSet.contains(pair.getValue()))
					.forEach(pair -> valueSet.add(pair.getValue()));
		}
		return valueSet;
	}


	/**
	 * Returns an ArrayList of all the key-value pairs present in this hashtable.
	 * Expected average runtime is O(m) where m is the number of buckets
	 */
	public ArrayList<MyPair<K, V>> getEntries() {
		ArrayList<MyPair<K,V>> entryList = new ArrayList<MyPair<K,V>>();
		for (LinkedList<MyPair<K,V>> bucket : buckets) {
			if (bucket != null) {
				entryList.addAll(bucket);
			}
		}

		return entryList;
	}

	
	
	@Override
	public MyHashIterator iterator() {
		return new MyHashIterator();
	}   

	
	private class MyHashIterator implements Iterator<MyPair<K,V>> {

		private int currentBucket;
		private Iterator<MyPair<K, V>> currentIterator;

		private MyHashIterator() {
			currentBucket = 0;
			currentIterator = null;

			while (currentBucket < numBuckets() && getBuckets().get(currentBucket).isEmpty()) {
				currentBucket++;
			}
			if (currentBucket == numBuckets()) {
				currentIterator = null;
			} else {
				currentIterator = getBuckets().get(currentBucket).iterator();
			}
		}

		@Override
		public boolean hasNext() {
			if (currentIterator != null && currentIterator.hasNext()) {
				return true;
			}

			int nextBucket = currentBucket + 1;
			while (nextBucket < numBuckets() && getBuckets().get(nextBucket).isEmpty()) {
				nextBucket++;
			}
			if (nextBucket == numBuckets()) {
				return false;
			} else {
				currentBucket = nextBucket;
				currentIterator = getBuckets().get(currentBucket).iterator();
				return true;
			}
		}

		@Override
		public MyPair<K,V> next() {
			if (!hasNext()) {
				System.out.println("No such element found!");
				return null;
			}
			return currentIterator.next();
		}

	}
	
}

