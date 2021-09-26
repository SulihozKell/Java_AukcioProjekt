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

        for (int i = 0; i < 29; i++) {
            f1.licit();
        }

        System.out.println(f1.getLegutolsoLicitIdeje());
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());

        Festmeny f2 = new Festmeny("Egy Cím", "Még Egy Név", "Wow");

        f2.licit(-100);
        f2.licit(20);
        System.out.println(f2.getLegmagasabbLicit());
        f2.licit(50);
        System.out.println(f2.getLegmagasabbLicit());
        f2.licit(30);
        System.out.println(f2.getLegmagasabbLicit());
        f2.licit(10);
        System.out.println(f2.getLegmagasabbLicit());


    }
}
