import java.util.ArrayList;
import java.util.regex.Pattern;

public class RealNumberHelper {
    public static ArrayList<String> check(ArrayList<String> numbers) {
        ArrayList<String> result = new ArrayList<>();
        
        // Regex برای عدد حقیقی معتبر
        String realNumberRegex = "^\\s*[+-]?(\\d+\\.\\d+|\\d+)([eE][+-]?\\d+)?\\s*$";
        Pattern pattern = Pattern.compile(realNumberRegex);
        
        for (String number : numbers) {
            if (pattern.matcher(number).matches()) {
                result.add("LEGAL");
            } else {
                result.add("ILLEGAL");
            }
        }
        
        return result;
    }
}
