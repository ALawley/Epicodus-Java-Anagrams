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
}
