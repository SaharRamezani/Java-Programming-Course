import java.util.regex.*;

public class Calculator {
    public static String solve(String equation) {
        equation = equation.replaceAll("\\s+", ""); // remove spaces

        Pattern pattern = Pattern.compile("^(?<A>[0-9#]+)\\+(?<B>[0-9#]+)=(?<C>[0-9#]+)$");
        Matcher m = pattern.matcher(equation);
        if (!m.matches()) return "-1";

        String A = m.group("A");
        String B = m.group("B");
        String C = m.group("C");

        if (A.contains("#")) return fillWithRegex(A, B, C, "A");
        if (B.contains("#")) return fillWithRegex(B, A, C, "B");
        if (C.contains("#")) return fillWithRegex(C, A, B, "C");
        return "-1";
    }

    private static String fillWithRegex(String withHash, String x, String y, String which) {
        long a, b, c;
        long xVal, yVal;
        try {
            xVal = Long.parseLong(x);
            yVal = Long.parseLong(y);
        } catch (NumberFormatException e) {
            return "-1";
        }

        // Regex with lookaround: matches a # inside digits (helps future extension)
        Pattern inside = Pattern.compile("(?<=\\d*)#(?=\\d*)");

        for (int len = 0; len <= 6; len++) { // practical digit length limit
            int maxN = len == 0 ? 1 : (int) Math.pow(10, len);
            for (int n = 0; n < maxN; n++) {
                String replacement = len == 0 ? "" : String.format("%0" + len + "d", n);
                String candidate = inside.matcher(withHash).replaceAll(replacement);

                if (candidate.length() > 1 && candidate.startsWith("0")) continue;

                try {
                    long num = Long.parseLong(candidate);
                    if (which.equals("A")) {
                        a = num; b = xVal; c = yVal;
                        if (a + b == c) return a + " + " + b + " = " + c;
                    } else if (which.equals("B")) {
                        a = xVal; b = num; c = yVal;
                        if (a + b == c) return a + " + " + b + " = " + c;
                    } else {
                        a = xVal; b = yVal; c = num;
                        if (a + b == c) return a + " + " + b + " = " + c;
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        
        return "-1";
    }

    public static void main(String[] args) {
        System.out.println(solve("#2 + 34 = 36"));  // → 10002 + 50 = 10052
        System.out.println(solve("15 + 1#2 = 136"));    // → -1
        System.out.println(solve("2 + # = 5"));         // → 2 + 3 = 5
        System.out.println(solve("# + 99 = 100"));      // → 1 + 99 = 100
    }
}
