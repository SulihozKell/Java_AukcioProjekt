package hu.petrik.aukcioprojekt;

public class Main {

    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("Valami Cím", "Valaki Neve", "Stilusos");
        f1.licit();
        System.out.println(f1.getFesto());
        System.out.println(f1.getLegutolsoLicitIdeje());
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit();
        System.out.println(f1.getLegutolsoLicitIdeje());
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit();
        System.out.println(f1.getLegutolsoLicitIdeje());
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());
    }
}
