import java.util.List;
import java.util.ArrayList;
import exception.*;

public class Examiner {
    public List<String> checkProductList(List<Product> products) {
        // get a list of products and run checkProduct on each of them and throw exceptions and return the list of the products that had problems
        List<String> problems = new ArrayList<>();
        for (Product p : products) {
            try {
                checkProduct(p);
            } catch (SizeException e) {
                problems.add(p.getId() + "-1");
            } catch (PressureToleranceException e) {
                problems.add(p.getId() + "-2");
            } catch (ColorTransparencyException e) {
                problems.add(p.getId() + "-3");
            }
        }
        return problems;
    }

    private void checkProduct(Product p) throws SizeException, PressureToleranceException, ColorTransparencyException {
        if (p.getSize() != 70) {
            throw new SizeException("Invalid size");
        }
        if (p.getPressureTolerance() < 1000) {
            throw new PressureToleranceException("Invalid pressure tolerance");
        }
        if (p.getColorTransparency() < 235 || p.getColorTransparency() > 245) {
            throw new ColorTransparencyException("Invalid color transparency");
        }
    }
}
