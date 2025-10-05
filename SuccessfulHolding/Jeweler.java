public class Jeweler extends Craftsman {
    // Implement Jeweler class
    @Override
    public String craftsmanSkill() {
        return "The Jeweler crafts a radiant diamond ring";
    }

    @Override
    public void createItem() {
        System.out.println("Jeweler creates a necklace");
    }
    @Override
    public void displayItem() {
        System.out.println("Displaying the necklace created by Jeweler");
    }
    @Override
    public void sellItem() {
        System.out.println("Selling the necklace created by Jeweler");
    }
}
