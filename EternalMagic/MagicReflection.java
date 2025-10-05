import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MagicReflection {
    public Class[] getClasses(){
        return JavaDonLibrary.class.getDeclaredClasses();
    }

    public Method[] getMethods(String className) {
        try {
            Class<?> clazz = null;
            // Try to find as inner class of JavaDonLibrary
            for (Class<?> c : JavaDonLibrary.class.getDeclaredClasses()) {
                if (c.getSimpleName().equals(className)) {
                    clazz = c;
                    break;
                }
            }
            if (clazz == null) {
                // Try fully qualified inner class name
                String fqName = JavaDonLibrary.class.getName() + "$" + className;
                try {
                    clazz = Class.forName(fqName);
                } catch (ClassNotFoundException e) {
                    // Fallback: try as top-level class
                    clazz = Class.forName(className);
                }
            }
            return clazz.getDeclaredMethods();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new Method[0];
        }
    }

    public String callRevealHiddenSpell(){
        try {
            Class<?> clazz = Class.forName("SecretsOfFlying");
            Method method = clazz.getDeclaredMethod("revealHiddenSpell");
            method.setAccessible(true);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            return (String) method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String callCastSpell(String spellName){
        // Chenge the spellName field to the provided spellName in SecretsOfFlying class
        try {
            Class<?> clazz = Class.forName("SecretsOfFlying");
            Field field = clazz.getDeclaredField("spellName");
            field.setAccessible(true);
            Object instance = clazz.getDeclaredConstructor().newInstance();
            field.set(instance, spellName);
            Method method = clazz.getDeclaredMethod("castSpell");
            return (String) method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
