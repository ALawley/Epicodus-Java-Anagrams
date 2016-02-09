import org.junit.*;
import static org.junit.Assert.*;

public class AnagramTest {

  @Test
  public void isAnagram_forTwoIdenticalLetters_true() {
    Anagram newAnagram = new Anagram();
    assertEquals(true, newAnagram.isAnagram("a", "a"));
  }
}
