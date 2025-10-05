public class Blacksmith extends Craftsman {
    @Override
    public String craftsmanSkill() {
        return "The Blacksmith forges a mighty sword";
    }

    @Override
    public void createItem() {
        System.out.println("Blacksmith creates a sword");
    }
    @Override
    public void displayItem() {
        System.out.println("Displaying the sword created by Blacksmith");
    }
    @Override
    public void sellItem() {
        System.out.println("Selling the sword created by Blacksmith");
    }
}
