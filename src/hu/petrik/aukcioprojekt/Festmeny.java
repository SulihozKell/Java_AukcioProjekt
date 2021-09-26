package hu.petrik.aukcioprojekt;

import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.elkelt = false;
    }

    public String getFesto() {
        return this.festo;
    }

    public String getStilus() {
        return this.stilus;
    }

    public int getLicitekSzama() {
        return this.licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return this.legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return this.legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return this.elkelt;
    }

    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }

    public void licit() {
        if (elkelt) {
            System.out.println("A festmény már elkelt.");
        }
        else {
            if (licitekSzama == 0) {
                legmagasabbLicit = 100;
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            }
            else {
                legmagasabbLicit = (int)(legmagasabbLicit * 1.1);

                String legmagasabbLicitString = String.valueOf(legmagasabbLicit);
                int legmagasabbLicitStringHossz = legmagasabbLicitString.length();
                char[] legmagasabbLicitChars = legmagasabbLicitString.toCharArray();

                for (int i = 0; i < legmagasabbLicitStringHossz; i++) {
                    if (i >= 2) {
                        legmagasabbLicitChars[i] = '0';
                        legmagasabbLicitString = String.valueOf(legmagasabbLicitChars);
                    }
                }

                legmagasabbLicit = Integer.parseInt(legmagasabbLicitString);
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            }
        }
    }

    public void licit(int mertek) {

    }




}
