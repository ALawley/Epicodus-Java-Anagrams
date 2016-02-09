import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class Anagram {
  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/anagram-word", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/anagram-word.vtl");

      String word1 = request.queryParams("word1");
      String word2 = request.queryParams("word2");
      Boolean isAnagram = isAnagram(word1, word2);

      model.put("isAnagram", isAnagram);
      model.put("word1", request.queryParams("word1"));
      model.put("word2", request.queryParams("word2"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/anagram-phrase", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/anagram-phrase.vtl");

      String phrase = request.queryParams("phrase");
      ArrayList<String> anagramsInPhrase = anagramsInPhrase(phrase);
      String liDisplay = "";
      for (String anagramWord : anagramsInPhrase) {
        liDisplay += "<li>" + anagramWord + "</li>";
      }
      //create big string variable
      //for each word in anagrams
        //add <li>word</li> to big string
      //return big string
      //print big string to page

      model.put("phraseAnagrams", liDisplay);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

  public static Boolean isAnagram(String input1, String input2) {
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
  public static ArrayList<String> anagramsInPhrase(String input) {
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
