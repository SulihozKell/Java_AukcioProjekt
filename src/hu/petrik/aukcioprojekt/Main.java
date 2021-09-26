package hu.petrik.aukcioprojekt;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Tesztelés
        Festmeny f1 = new Festmeny("Valami Cím", "Valaki Neve", "Stilusos");
        f1.licit();
        System.out.println(f1.getFesto());
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit();
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());
        f1.licit();
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());

        for (int i = 0; i < 29; i++) {
            f1.licit();
        }

        System.out.println(f1.getLegutolsoLicitIdeje());
        System.out.println(f1.getLicitekSzama());
        System.out.println(f1.getLegmagasabbLicit());

        Festmeny f2 = new Festmeny("Harcos", "Teszt Elek", "Szép");
        f2.licit(-100);
        f2.licit(20);
        System.out.println(f2.getLegmagasabbLicit());
        f2.licit(50);
        System.out.println(f2.getLegmagasabbLicit());
        f2.licit(30);
        System.out.println(f2.getLegmagasabbLicit());
        f2.licit(10);
        System.out.println(f2.getLegmagasabbLicit());
        System.out.println(f2);

        Festmeny f3 = new Festmeny("Cím", "Festő", "Stílus");
        System.out.println(f3);

        // Lista festményekkel
        ArrayList<Festmeny> festmenyek = new ArrayList<>();
        festmenyek.add(new Festmeny("Nyugalom", "Teszt Elek", "Egyedi"));
        festmenyek.add(new Festmeny("A Sárkány", "Gipsz Jakab", "Fantasy"));
        festmenyek.add(new Festmeny("Étel", "Éhes Évi", "Fantasy"));

    }
}
