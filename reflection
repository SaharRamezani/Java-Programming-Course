import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class<Fruit> c = Fruit.class;
        Method method = c.getDeclaredMethod("introduce", String.class);
        method.setAccessible(true);
        Fruit fruit = new Fruit("Banana", Fruit.Color.Yellow);
        String result = (String) method.invoke(fruit, "Quera");

        System.out.println(result);

        // cause error
        // System.out.println(fruit.introduce("Quera"));
    }
}

class Fruit {
    enum Color {
        Yellow, Orange, Green, Red, Brown
    }
    private final String name;
    private final Color color;

    public Fruit(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    private String introduce (String yourName) {
        return String.format(
            "I am a %s and my color is %s. Taste me %s!", 
                name, color, yourName);
    }
}
