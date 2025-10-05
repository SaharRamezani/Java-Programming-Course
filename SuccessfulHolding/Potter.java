public class Potter extends Craftsman {
    @Override
    public String craftsmanSkill() {
        return "The Potter shapes a beautiful vase";
    }

    @Override
    public void createItem() {
        System.out.println("Potter creates a vase");
    }
    @Override
    public void displayItem() {
        System.out.println("Displaying the vase created by Potter");
    }
    @Override
    public void sellItem() {
        System.out.println("Selling the vase created by Potter");
    }
}
