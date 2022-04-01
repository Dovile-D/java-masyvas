package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        spausdinti("Programa paskaiciuojanti pateikto masyvp elementu aritmetini vidurki, \nsukeicianti " +
                "vietomis didziausia masyvo elementa su maziausiu \nbei atspausdinanti pirmini masyva, bei masyva " +
                "po pakeitimu");
        int[] skaiciai = sukurtiDesimtiesElementuMasyva();
        spausdinti("Pateikto masyvo lyginiu elementu aritmetinis vidurkis yra: ", skaiciai);
        spausdintiAbuMasyvus(skaiciai);

        // naujas dalykas, paprastesnis budas rasti maziausia masyvo elementa:
        int maziausiasElementas = Arrays.stream(skaiciai).min().getAsInt();
        int didziausiasElementas = Arrays.stream(skaiciai).max().getAsInt();
        System.out.println("\nPapildomai. Maziausias masyvo elementas: " + maziausiasElementas + "\nDidziausias " +
                "masyvo elementas: " + didziausiasElementas);

        // gynimo uzduotis
        spausdinti("\nGYNIMAS:\nMaziausias lyginis masyvo elementas yra: ",
                gautiMaziausiaLyginiNeigiamaElementa(skaiciai));
    }

    /**
     * Funkcija sukurianti 10 elementu masyva is vartotojo ivestu skaiciu
     *
     * @return sukurtas masyvas
     */
    public static int[] sukurtiDesimtiesElementuMasyva() {
        int indeksas = 0;
        Scanner scan = new Scanner(System.in);
        spausdinti("Iveskite 10 teigiamu ir neigiamu sveikuju skaiciu, kurie bus masyve.");
        int[] skaiciai = new int[10];
        for (int i = 0; i < 10; i++) {
            spausdinti("Iveskite skaiciu Nr. " + (i + 1));
            int vartotojoSkaicius = scan.nextInt();
            skaiciai[indeksas] = vartotojoSkaicius;
            indeksas++;
        }
        return skaiciai;
    }

    /**
     * Funkcija suskaiciuojanti ir grazinanti lyginiu masyvo elementu suma
     *
     * @param skaiciai perduodamas masyvas
     * @return masyvo elementu suma
     */
    public static int skaiciuotiLyginiuMasyvoElementuSuma(int[] skaiciai) {
        int lyginiuElementuSuma = 0;
        for (int i = 0; i < skaiciai.length; i++) {
            if (skaiciai[i] % 2 == 0) {
                lyginiuElementuSuma = lyginiuElementuSuma + skaiciai[i];
            }
        }
        return lyginiuElementuSuma;
    }

    /**
     * Funkcija skaiciuojanti lyginiu masyvo elementu kieki
     *
     * @param skaiciai pateiktas masyvas
     * @return lyginiu elementu kiekis
     */
    public static int skaiciuotiLyginiuMasyvoElementuKieki(int[] skaiciai) {
        int lyginiuElementuKiekis = 0;
        for (int i = 0; i < skaiciai.length; i++) {
            if (skaiciai[i] % 2 == 0) {
                lyginiuElementuKiekis++;
            }
        }
        return lyginiuElementuKiekis;

    }

    /**
     * Funkcija pagal gauta is funkcijos skaiciuotiMasyvoElementuSuma() masyvo elementu suma, paskaiciuoja tu elementu
     * aritmetini vidurki
     *
     * @param skaiciai perduodamas masyvas
     * @return masyvo elementu aritmetinis vidurkis
     */
    public static double skaiciuotiMasyvoElementuVidurki(int[] skaiciai) {
        int masyvoElementuSuma = skaiciuotiLyginiuMasyvoElementuSuma(skaiciai);
        int lyginiuElementuKiekis = skaiciuotiLyginiuMasyvoElementuKieki(skaiciai);
        double masyvoElementuVidurkis = masyvoElementuSuma / lyginiuElementuKiekis;
        return masyvoElementuVidurkis;
    }

    /**
     * Funkcija terminale isvedanti pateikta teksta ir kintamaji masyva
     *
     * @param tekstas  pateiktas tekstas
     * @param skaiciai kintamasis masyvas
     */
    public static void spausdinti(String tekstas, int[] skaiciai) {
        double masyvoElementuVidurkis = skaiciuotiMasyvoElementuVidurki(skaiciai);
        System.out.println(tekstas + masyvoElementuVidurkis);
    }

    /**
     * Funkcija terminale isvedanti pateikta skaiciu ir kintamaji
     *
     * @param tekstas    pateiktas tekstas
     * @param kintamasis pateiktas kintamasis
     */
    public static void spausdinti(String tekstas, int kintamasis) {
        System.out.println(tekstas + kintamasis);
    }

    /**
     * Funcija terminale isvedanti pateikta teksta
     *
     * @param tekstas pateiktas tekstas
     */
    public static void spausdinti(String tekstas) {
        System.out.println(tekstas);
    }

    /**
     * Funkcija didziausio pateikto masyvo elemento indeksui rasti
     *
     * @param skaiciai pateiktas masyvas
     * @return didziausio masyvo elemento indeksas
     */
    public static int rastiDidziausioMasyvoElementoIndeksa(int[] skaiciai) {
        int didziausiasElementas = Integer.MIN_VALUE;
        int didziausioElementoIndeksas = 0;
        for (int i = 0; i < skaiciai.length; i++) {
            if (skaiciai[i] > didziausiasElementas) {
                didziausiasElementas = skaiciai[i];
                didziausioElementoIndeksas = i;
            }
        }
        return didziausioElementoIndeksas;
    }

    /**
     * Funkcija rasti maziausio pateikto masyvo elemento indeksui rasti
     *
     * @param skaiciai pateiktas masyvas
     * @return maziausio masyvo elemto indeksas
     */
    public static int rastiMaziausioMasyvoElementoIndeksa(int[] skaiciai) {

        int maziausiasElementas = Integer.MAX_VALUE;
        int maziausioElementoIndeksas = 0;
        for (int i = 0; i < skaiciai.length; i++) {
            if (skaiciai[i] < maziausiasElementas) {
                maziausiasElementas = skaiciai[i];
                maziausioElementoIndeksas = i;
            }
        }
        return maziausioElementoIndeksas;
    }

    /**
     * funkcija sukeicianti vietomis didziausia ir maziausia masyvo elementus
     *
     * @param skaiciai perduodamas masyvas
     * @return masyvas su sukeistais vietomis elementais
     */
    public static int[] sukeistiDidziausiaIrMaziausiaVietomis(int[] skaiciai) {
        int didziausioIndeksas = rastiDidziausioMasyvoElementoIndeksa(skaiciai);
        int maziausioIndeksas = rastiMaziausioMasyvoElementoIndeksa(skaiciai);
        int[] naujiSkaiciai = new int[10];

        for (int i = 0; i < skaiciai.length; i++) {
            if (i == didziausioIndeksas) {
                naujiSkaiciai[didziausioIndeksas] = skaiciai[maziausioIndeksas];
            } else if (i == maziausioIndeksas) {
                naujiSkaiciai[maziausioIndeksas] = skaiciai[didziausioIndeksas];
            } else {
                naujiSkaiciai[i] = skaiciai[i];
            }
        }
        return naujiSkaiciai;
    }

    /**
     * Funkcija terminale isvedanti masyva pries sukeiciant didziausia masyvo elementa su maziausiu ir masyva juos
     * sukeitus
     *
     * @param skaiciai pirminis masyvas
     */
    public static void spausdintiAbuMasyvus(int[] skaiciai) {
        String pirminisMasyvas = Arrays.toString(skaiciai);
        String naujasMasyvas = Arrays.toString(sukeistiDidziausiaIrMaziausiaVietomis(skaiciai));
        System.out.println("Pirminis masyvas: " + pirminisMasyvas + "\nMasyvas sukeitus didziausia ir maziausia " +
                "elementus vietomis: " + naujasMasyvas);
    }

    /**
     * Funkcija randanti maziausia neigiama masyvo elementa
     *
     * @param skaiciai pateiktas masyvas
     * @return maziausias neigiamas masyvo elementas
     */
    public static int gautiMaziausiaLyginiNeigiamaElementa(int[] skaiciai) {
        int maziausiasNeigiamasLyginisElementas = Integer.MAX_VALUE;
        for (int i = 0; i < skaiciai.length; i++) {
            if (skaiciai[i] < 0) {
                if (skaiciai[i] % 2 == 0) {
                    if (skaiciai[i] < maziausiasNeigiamasLyginisElementas) {
                        maziausiasNeigiamasLyginisElementas = skaiciai[i];
                    }
                }
            }
        }
        return maziausiasNeigiamasLyginisElementas;
    }

}


// Uzduotis:
//1. Sukurti 10 + ir - skaičių masyvą.
//
//2. Sukurti funkciją, skaičiuojančią lyginių masyvo elementų vidurkį (sumai ir kiekiui atskiros funkcijos (!)).
//
//3. Sukeisti dydžiausias ir mažiausias reikšmes masyve vietomis (atskiros funkcijos min ir max radimui).
//
//4. Sukurti funkciją, spausdinančią masyvą prieš pakeitimus ir po jų.
// Gynimas: Papildyti laboratorinį darbą nauju funkcionalumu
// Sukurti funkciją, surandančią mažiausią skaičių tarp lyginių neigiamų masyvo elementų.