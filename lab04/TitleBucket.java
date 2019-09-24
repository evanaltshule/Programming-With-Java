// TitleBucket.java

import java.util.ArrayList;

public class TitleBucket implements BucketInterface{

	private ArrayList<ArrayList<MusicTrack>> titleBucket;


	public TitleBucket(){
		titleBucket = new ArrayList<ArrayList<MusicTrack>>(26);
	}

	public void addItem(MusicTrack itemToAdd){
		// adds MusicTrack to appropriate bucket

		// nagivate to correct arrayList corresponding to first letter of artist
		String trackName = (itemToAdd.getTitle()).toLowerCase();
		char firstCharacter = trackName.charAt(0);
		int outerBucketIndex = (int) firstCharacter - 97;
		ArrayList<MusicTrack> innerBucket = titleBucket.get(outerBucketIndex);

		// compare elements within that arraylist and add into that arraylist in order
		int innerBucketIndex = 0;
		// while lexicographically name to be added is greater than the checked index
		while (trackName.compareTo(innerBucket.get(innerBucketIndex).getTitle()) > 0 ){
			innerBucketIndex++;
		}
		// add at the index itemToAdd, will shift all subsequent elements one element down
		innerBucket.add(innerBucketIndex, itemToAdd);
	}

	public ArrayList<ArrayList<MusicTrack>> getBuckets(){
		return titleBucket;
	}

}
