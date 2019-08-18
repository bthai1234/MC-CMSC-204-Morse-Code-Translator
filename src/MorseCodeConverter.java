import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * converts morse Code from a string or file
 * @author bthai
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the toArrayList method in MorseCodeTree It should return the data in this order: 
	 *"h s v i f u e l r a p w j b d x n c k y t z g q m o" Note the extra space between j and b 
	 *- that is because there is an empty string that is the root, and in the LNR traversal, 
	 *the root would come between the right most child of the left tree (j) and the left most child of the right tree (b). This is used for testing purposes to make sure the MorseCodeTree has been built properly
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree(){
		ArrayList<String> list = tree.toArrayList();
		String treeList = "";
		for(int i = 0; i < list.size(); i++){
			if(i == list.size() -1){
				treeList += list.get(i);
			}else
				treeList += list.get(i) + " "; 
		}
		return treeList;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 *Example: 
	 *code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 *string returned = "Hello World"
	 * @param code - the morse code
	 * @return the English translation
	 */
	public static String convertToEnglish(String code){
		Scanner wordScanner = new Scanner(code);
		wordScanner.useDelimiter("/");
		
		String word, translated = "";
		while (wordScanner.hasNext()){
			word = wordScanner.next();
			Scanner letterScanner = new Scanner(word);
			letterScanner.useDelimiter(" ");

			String letter;
			while(letterScanner.hasNext()){
				letter = letterScanner.next();
				letter = tree.fetch(letter);
				translated += letter;
			}
			
			if(wordScanner.hasNext() != false){
				translated += " ";
			}
		}
		
		return translated;
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	 *Example: 
	 *a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	 *string returned = "Hello World"
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws java.io.FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws java.io.FileNotFoundException{
		Scanner fileScanner;
		String translated = "";
		try{
			fileScanner = new Scanner(codeFile);
			while(fileScanner.hasNextLine()){
				String line =  convertToEnglish(fileScanner.nextLine());
				if(fileScanner.hasNextLine()){
					translated += line + " ";
				}else
					translated += line;
			}
			
		}catch(FileNotFoundException e){
			System.out.println(e);
		}
		return translated;
	}
}
