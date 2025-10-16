public class Product {
    private int id;
    private int size;
    private int pressureTolerance;
    private int colorTransparency;

    public Product(int id, int size, int pressureTolerance, int colorTransparency) {
        this.id = id;
        this.size = size;
        this.pressureTolerance = pressureTolerance;
        this.colorTransparency = colorTransparency;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getPressureTolerance() {
        return pressureTolerance;
    }

    public int getColorTransparency() {
        return colorTransparency;
    }
}
