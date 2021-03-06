package hu.petrik.aukcioprojekt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        if (tiznelTobbszorLicitaltak(festmenyek)) {
            System.out.println("Volt olyan festmény amire 10-nél többször licitáltak!");
        }
        else {
            System.out.println("Nem volt olyan festmény amire 10-nél többször licitáltak!");
        }
        hanyFestmenyNemKeltEl(festmenyek);
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

    public static boolean tiznelTobbszorLicitaltak(ArrayList<Festmeny> festmenyek) {
        for (Festmeny f : festmenyek) {
            if (f.getLicitekSzama() >= 10) {
                return true;
            }
        }
        return false;
    }

    public static void hanyFestmenyNemKeltEl(ArrayList<Festmeny> festmenyek) {
        int osszeg = 0;
        for (Festmeny f : festmenyek) {
            if (!f.getElkelt()) {
                osszeg++;
            }
        }
        System.out.println(osszeg + " db festmény nem kelt el.");
    }
}
