public class Validator {

    public static Boolean ValidateEmail(String email) {
        if (email == null) return false;
        // username: [a-zA-Z0-9_.]+
        // domain: [a-zA-Z0-9]+
        // tld: [a-zA-Z]{3}
        // شکل کلی: username@domain.tld
        String regex = "^[a-zA-Z0-9_.]+@[a-zA-Z0-9]+\\.[a-zA-Z]{3}$";
        return email.matches(regex);
    }

    public static Boolean ValidatePhone(String phone) {
        if (phone == null) return false;
        // سه حالت مجاز:
        // 09xxxxxxxxx  (11 رقم)
        // +989xxxxxxxxx (13 رقم)
        // 00989xxxxxxxxx (14 رقم)
        String regex = "^(09\\d{9}|\\+989\\d{9}|00989\\d{9})$";
        return phone.matches(regex);
    }

    public static void main(String[] args) {
        // تست
        System.out.println(ValidateEmail("user.name_1@domain.com")); // true
        System.out.println(ValidateEmail("user@domain.c"));          // false
        System.out.println(ValidatePhone("09123456789"));            // true
        System.out.println(ValidatePhone("+989123456789"));          // true
        System.out.println(ValidatePhone("00989123456789"));         // true
        System.out.println(ValidatePhone("08123456789"));            // false
    }
}
