import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class AnagramTest {

  @Test
  public void isAnagram_forTwoIdenticalLetters_true() {
    Anagram newAnagram = new Anagram();
    assertEquals(true, newAnagram.isAnagram("a", "a"));
  }
  @Test
  public void isAnagram_forTwoAnagramWords_true() {
    Anagram newAnagram = new Anagram();
    assertEquals(true, newAnagram.isAnagram("taco", "coat"));
  }
  @Test
  public void anagramsInPhrase_forSentence_allAnagramWords() {
    Anagram newAnagram = new Anagram();
    ArrayList<String> results = new ArrayList<String>();
    results.add("act");
    results.add("cat");
    results.add("arm");
    results.add("ram");
    assertEquals(results, newAnagram.anagramsInPhrase("act Cat arm ram sheep"));
  }
}
