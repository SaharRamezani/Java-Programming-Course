import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Examiner ex = new Examiner();
        List<Product> products = new ArrayList<>();

        products.add(new Product(1, 80, 1200, 240));
        products.add(new Product(2, 70, 900, 239));
        products.add(new Product(3, 70, 1000, 210));
        products.add(new Product(4, 70, 1200, 238));

        List<String> output = ex.checkProductList(products); // [color], [pressure], [color]
        for (String p : output) {
            System.out.println(p);
        }
    }
}
