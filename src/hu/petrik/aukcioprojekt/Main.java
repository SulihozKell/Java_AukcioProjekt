package hu.petrik.aukcioprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Tesztelés
        /*
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
        */
        // Lista festményekkel
        ArrayList<Festmeny> festmenyek = new ArrayList<>();
        festmenyek.add(new Festmeny("Nyugalom", "Teszt Elek", "Barokk"));
        festmenyek.add(new Festmeny("A Sárkány", "Gipsz Jakab", "Reneszánsz"));
        festmenyek.add(new Festmeny("Étel", "Éhes Évi", "Reneszánsz"));

        fajlBeolvasas("festmenyek.csv", festmenyek);

        for (int i = 0; i < 20; i++) {
            int randomNum = (int)(Math.random() * festmenyek.size());
            festmenyek.get(randomNum).licit();
        }

        for (Festmeny f : festmenyek) {
            System.out.println(f);
        }

        felhasznaloLicit(festmenyek);
        legdragabbElkelt(festmenyek);

    }

    public static void fajlBeolvasas(String fajlNev, ArrayList<Festmeny> festmenyek) {
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null) {
                String[] adatok = sor.split(";");
                Festmeny festmeny = new Festmeny(adatok[1], adatok[0], adatok[2]);
                festmenyek.add(festmeny);
                sor = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void felhasznaloLicit(ArrayList<Festmeny> festmenyek) {
        Scanner sc = new Scanner(System.in);

        int sorszam = 0;
        boolean vege = false;

        while (!vege) {
            try {
                System.out.println("Festmény sorszáma: ");
                sorszam = sc.nextInt();

            }
            catch (Exception e) {
                System.out.println("Ez nem egy sorszám!");
            }
            if (sorszam == 0) {
                vege = true;
            }
            else if (sorszam <= festmenyek.size() && sorszam > 0) {
                if (uresEnter(festmenyek, sorszam)) {
                    vege = true;
                }
            }
            else {
                System.out.println("Nem létező sorszám!");
            }
        }
        for (Festmeny f : festmenyek) {
            if (f.getLegmagasabbLicit() != 0) {
                f.setElkelt(true);
            }
            System.out.println(f);
        }
    }

    public static boolean uresEnter(ArrayList<Festmeny> festmenyek, int sorszam) {
        System.out.println("Milyen mértékkel szeretne licitálni? ");
        Scanner sc = new Scanner(System.in);
        String mertek = sc.nextLine();

        if (mertek.isEmpty()) {
            festmenyek.get(sorszam - 1).licit();
            return false;
        }
        else {
            try {
                festmenyek.get(sorszam - 1).licit(Integer.parseInt(mertek));
                return false;
            }
            catch (Exception e) {
                System.out.println("Ez nem egy sorszám!");
                return true;
            }
        }
    }

    public static void legdragabbElkelt(ArrayList<Festmeny> festmenyek) {
        int legnagyobb = 0;
        int legnagyobbIndex = 0;

        for (int i = 0; i < festmenyek.size(); i++) {
            if (festmenyek.get(i).getElkelt() && festmenyek.get(i).getLegmagasabbLicit() > legnagyobb) {
                legnagyobb = festmenyek.get(i).getLegmagasabbLicit();
                legnagyobbIndex = i;
            }
        }
        System.out.println("A legdrágábban elkelt festmény: " + (legnagyobbIndex + 1) + ". sorszámú. " + legnagyobb + "$.");
    }
}
