import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates a Markov chain for the given input.
 * 
 * @author millerc5. Created 22 Oct 2013.
 */
public class Chain {

	private HashMap<String,MultiSet> table;

	private int maxWords;

	private int charsPerLine;

	private int prefixLength;
	/**
	 * Constructs an instance of a Markov chain.
	 * 
	 * @param pathToInputFile
	 * @param prefixLength
	 * @param maxWords
	 * @param charsPerLine
	 */
	//CONSIDER: In order to check the randomization tests, graders might have to run code SEVERAL times.
	//CONSIDER: Your code, although it did not pass the last 4 - ran the fastest of anyone's.
	//CONSIDER: Great algorithm work.
	public Chain(String pathToInputFile, int prefixLength, int maxWords,
			int charsPerLine) {
		this.maxWords = maxWords;
		this.charsPerLine = charsPerLine;
		this.prefixLength = prefixLength;

		ArrayList<String> file = fileToArray(pathToInputFile);


		FixedLengthQueue queue = new FixedLengthQueue(prefixLength);

		this.table = new HashMap<String,MultiSet>();

		for(int i = 0; i < prefixLength; i++){
			queue.add(null);
		}


		for(String s: file){
			for(String temp: words(s)){
				MultiSet set;
				if((set = this.table.get(queue)) == null){
					set = new MultiSet();
					set.add(temp);
					this.table.put(queue.toString(),set);
				}else{
					set.add(temp);
				}
				queue.add(temp);
			}
		}
	}

	/**
	 * @return an ArrayList with the entire contents of the file
	 */
	private ArrayList<String> fileToArray(String file){
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			ArrayList<String> toReturn = new ArrayList<String>();
			String s;
			while( (s = br.readLine()) != null){
				toReturn.add(s);
			}
			for(int i = 0; i < toReturn.size(); i++){
				toReturn.set(i,toReturn.get(i).trim());
			}
			br.close();
			return toReturn;
		}catch(IOException e){
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 
	 * Returns a arraylist of the words without spaces.
	 *
	 * @param s a nonNull String
	 * @return an ArrayList of the words in 's'
	 */
	private ArrayList<String> words(String s){
		ArrayList<String> array = new ArrayList<String>();
		for(String string: s.split(" ")){
			string = string.trim();
			if(!string.isEmpty()){
				array.add(string);
			}
		}
		return array;
	}
	/**
	 * Returns the string from 'ms' according to its weighted value.
	 * 
	 *
	 * @param ms
	 * @return the weighted string.
	 */
	private String weightedString(MultiSet ms){
		if(ms == null) return null;
		int random = (int) (ms.size() * Math.random());
		return (String) ms.findKth(random);
	}


	/**
	 * @return a Markov chain of words for this instance.
	 */
	public ArrayList<String> getWords() {
		ArrayList<String> toReturn = new ArrayList<String>(this.maxWords);

		FixedLengthQueue queue = new FixedLengthQueue(this.prefixLength);
		for(int i = 0; i < this.prefixLength; i++){
			queue.add(null);
		}
		for(int i = 0; i < this.maxWords; i++){
			String temp = weightedString(this.table.get(queue.toString()));
			if(temp ==null) break;
			toReturn.add(temp);
			queue.add(temp);
		}

		return toReturn;
	}

	/**
	 * Returns a justified list of lines representing a Markov chain for this
	 * instance.
	 * 
	 * @return a justified list of lines
	 */
	public ArrayList<String> getWrappedLines() {
		ArrayList<String> a = getWords();
		ArrayList<String> toReturn = new ArrayList<String>();
		
		StringBuilder string = new StringBuilder();
		for(int i = 0; i < a.size(); i++){
			if(string.length() + a.get(i).length()+1 > this.charsPerLine){
				toReturn.add(string.toString());
				string = new StringBuilder();
			}
			string.append(a.get(i));
			string.append(" ");
						
		}
		toReturn.add(string.toString());

		return justify(toReturn);
	}
	/**
	 * 
	 * Justifies 'array'
	 *
	 * @param array a nonnull array
	 * @return a justified 'array'
	 */
	private ArrayList<String> justify(ArrayList<String> array){
		for(int i = 0; i < array.size() -1; i++){
			String temp = array.remove(i);
			ArrayList<String> words = words(temp);
			int toAdd = this.charsPerLine - temp.length();
			int counter = 0;
			for(int j = 0; j < toAdd; j++ ){
				if(++counter >= words.size()-1) counter = 0;
				String s = words.remove(counter);
				words.add(counter, s + " ");
			}
			StringBuilder sb = new StringBuilder();
			for(int k = 0; k < words.size(); k++){
				sb.append(words.get(k));
				sb.append(" ");
			}
			array.add(i,sb.toString());
		}
		return array;
	}

}
