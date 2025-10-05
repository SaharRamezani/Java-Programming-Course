public class Main {
    public static void main(String[] args) throws Exception {
        MagicReflection magic = new MagicReflection();

        System.out.println(magic.getClasses().length);
        // expected 2
        System.out.println(magic.getClasses()[0].getName());
        // expected JavaDonLibrary$B
        System.out.println(magic.getClasses()[1].getName());
        // expected JavaDonLibrary$A

        System.out.println(magic.getMethods("B").length);
        // expected 1
        System.out.println(magic.getMethods("B")[0].getParameterCount());
        // expected 1

        System.out.println(magic.callRevealHiddenSpell());
        // expected "This is a hidden spell: Invisibility"

        System.out.println(magic.callCastSpell("Soaring"));
        // expected "Flying high with Soaring!"
    }
}