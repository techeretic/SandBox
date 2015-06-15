import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.Charset;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

// bat - tab

// "/usr/share/dict/words"

class AnagramFromDict {
  public static void main(String[] args) throws Exception {
    
    List<String> lines = Files.readAllLines(Paths.get("/usr/share/dict/words"), Charset.defaultCharset());
    
    HashMap<Integer, String> dictMap = new HashMap<Integer, String>();
    
    for(String s : lines) {
      int hash = getSortedHash(s);
      if (dictMap.containsKey(hash)) {
        String t = dictMap.get(hash) + "," + s;
        dictMap.put(hash, t);
      } else {
        dictMap.put(hash, s);
      }
    }
    
    String input = "elvis";
    
    System.out.println(dictMap.get(getSortedHash(input)));
    
  }
  
  private static int getSortedHash(String s) {
    
    char[] temp3 = s.toLowerCase().toCharArray();
    Arrays.sort(temp3);
    return String.valueOf(temp3).hashCode();
    
  }
}
