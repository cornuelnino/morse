package com.example.testmorse;
import javafx.scene.paint.Color;

public class Morse {

    private static final String a = ".-";
    private static final String b = "-...";
    private static final String c = "-.-.";
    private static final String d = "-..";
    private static final String e = ".";
    private static final String f = "..-.";
    private static final String g = "--.";
    private static final String h = "....";
    private static final String ii = "..";
    private static final String j = ".---";
    private static final String k = "-.-";
    private static final String l = ".-..";
    private static final String m = "--";
    private static final String n = "-.";
    private static final String o = "---";
    private static final String p = ".--.";
    private static final String q = "--.-";
    private static final String r = ".-.";
    private static final String ss = "...";
    private static final String t = "-";
    private static final String u = "..-";
    private static final String v = "...-";
    private static final String w = ".--";
    private static final String x = "-..-";
    private static final String y = "-.--";
    private static final String z = "--..";
    private static final String un = ".----";
    private static final String deux = "..---";
    private static final String trois = "...--";
    private static final String quatre = "....-";
    private static final String cinq = ".....";
    private static final String six = "-....";
    private static final String sept = "--...";
    private static final String huit = "---..";
    private static final String neuf = "----.";
    private static final String zero = "-----";
    private final Controller controller;
    private static final int tempsPoint = 500;
    private static final int tempsTiret = tempsPoint * 3;
    private static final int tempsEspace = tempsPoint * 7;
    private static final int tempsSlash = tempsPoint * 3;


    public Morse(Controller controller) {
        this.controller = controller;
    }

    public void printMorse(String s) {

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);


            try {
                System.out.print(currentChar);

                if (currentChar == '/') {
                    Thread.sleep(tempsSlash);

                } else if (currentChar == '.') {
                    LED(true);
                    Thread.sleep(tempsPoint);

                    LED(false);
                    Thread.sleep(tempsPoint);

                } else if (currentChar == '-') {
                    LED(true);
                    Thread.sleep(tempsTiret);

                    LED(false);
                    Thread.sleep(tempsPoint);

                } else if (currentChar == ' ') {
                    Thread.sleep(tempsEspace);
                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }
        controller.buttonMorse.setText("LANCER TRADUCTION");
    }

    private void LED(boolean etat) {

        if (etat) {
            controller.circleMorse.setFill(Color.RED);

        } else {
            controller.circleMorse.setFill(Color.BLACK);
        }
    }

    public String insertSlash(String s) {

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            result.append('/');
            result.append(currentChar);
        }


        return String.valueOf(result);
    }

    public String transformToMorse(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '/' || currentChar == ' ') {
                result.append(currentChar);

            } else {

                String so = String.valueOf(currentChar);

                switch (so) {
                    case "a":
                        result.append(a);
                        break;
                    case "b":
                        result.append(b);
                        break;
                    case "c":
                        result.append(c);
                        break;
                    case "d":
                        result.append(d);
                        break;
                    case "e":
                        result.append(e);
                        break;
                    case "f":
                        result.append(f);
                        break;
                    case "g":
                        result.append(g);
                        break;
                    case "h":
                        result.append(h);
                        break;
                    case "i":
                        result.append(ii);
                        break;
                    case "j":
                        result.append(j);
                        break;
                    case "k":
                        result.append(k);
                        break;
                    case "l":
                        result.append(l);
                        break;
                    case "m":
                        result.append(m);
                        break;
                    case "n":
                        result.append(n);
                        break;
                    case "o":
                        result.append(o);
                        break;
                    case "p":
                        result.append(p);
                        break;
                    case "q":
                        result.append(q);
                        break;
                    case "r":
                        result.append(r);
                        break;
                    case "s":
                        result.append(ss);
                        break;
                    case "t":
                        result.append(t);
                        break;
                    case "u":
                        result.append(u);
                        break;
                    case "v":
                        result.append(v);
                        break;
                    case "w":
                        result.append(w);
                        break;
                    case "x":
                        result.append(x);
                        break;
                    case "y":
                        result.append(y);
                        break;
                    case "z":
                        result.append(z);
                        break;
                    case "1":
                        result.append(un);
                        break;
                    case "2":
                        result.append(deux);
                        break;
                    case "3":
                        result.append(trois);
                        break;
                    case "4":
                        result.append(quatre);
                        break;
                    case "5":
                        result.append(cinq);
                        break;
                    case "6":
                        result.append(six);
                        break;
                    case "7":
                        result.append(sept);
                        break;
                    case "8":
                        result.append(huit);
                        break;
                    case "9":
                        result.append(neuf);
                        break;
                    case "0":
                        result.append(zero);
                        break;
                }

            }


        }
        return String.valueOf(result);
    }

}
