import java.util.Arrays;
import java.util.ArrayList;

public class Anagram {
  public static void main(String[] args) {}

  public Boolean isAnagram(String input1, String input2) {
    char[] input1Letters = input1.toCharArray();
    char[] input2Letters = input2.toCharArray();
    Arrays.sort(input1Letters);
    Arrays.sort(input2Letters);
    if (Arrays.equals(input1Letters, input2Letters)) {
      return true;
    } else {
      return false;
    }
  }
  public ArrayList<String> anagramsInPhrase(String input) {
    ArrayList<String> trueAnagrams = new ArrayList<String>();
    ArrayList<char[]> wordLetters = new ArrayList<char[]>();
    String[] words = input.toLowerCase().split(" ");
    for ( String word : words ) {
      wordLetters.add(word.toCharArray());
    }
    for ( char[] letterGroup : wordLetters ) {
      Arrays.sort(letterGroup);
    }
    for ( Integer i = 0; i < wordLetters.size(); i++ ) {
      for ( Integer j = 0; j < wordLetters.size(); j++ ) {
        if (Arrays.equals(wordLetters.get(i), wordLetters.get(j)) &&  i != j ) {
          trueAnagrams.add(words[i]);
        }
      }
    }
    return trueAnagrams;
  }
}

// split into array of strings
// for each split into char array, add to array list (array of character arrays)
// for each item of array list, sort letters
// for each item of array list, compare to (another for each) each item in array. If true, add to solved array
// How do we add original word to solved array with just the ordered letters?
