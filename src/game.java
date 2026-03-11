package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        game p = new game();
        p.principal();
    }

    public void principal() {
        ArrayList<Character> character = new ArrayList<Character>();
        System.out.println("BENVINGUT");
        int menu = 0;
        do {
            menu = llegirInt("\n 1- Crear personatge\n 2- Jugar combat simple (1vs1)\n 3-Sortir");
            switch (menu) {
                case 1:
                    crearPJ(character);
                    break;
                case 2:
                    if (character.size() < 2) {
                        System.out.println("Necessites com a mínim 2 personatges per jugar!");
                    } else {
                        jugar1v1(character);
                    }
                    break;
                case 3:
                    System.out.println("Fins aviat!");
                    break;
                default:
                    System.out.println("Trie entre el 1, 2 i 3");
                    break;
            }

        } while (menu != 3);

    }

    public void jugar1v1(ArrayList<Character> character) {
        Character pj1 = escollirPersonatge(character, 1, -1);
        Character pj2 = escollirPersonatge(character, 2, character.indexOf(pj1));
        System.out.println("Jugador 1: " + pj1.getName() + " vs Jugador 2: " + pj2.getName());
        combat(pj1, pj2);
    }

    public void combat(Character pj1, Character pj2) {
        boolean torn = true;
        int player = 1;
        while (torn) {
            int resposta = 0;
            if (player > 2) {
                player = 1;
            }
            Character atacant;
            Character defensor;
            if (player == 1) {
                atacant = pj1;
                defensor = pj2;
            } else {
                atacant = pj2;
                defensor = pj1;
            }

            do {
                resposta = llegirInt("Jugador  " + player + ": \n1- Atacar \n 2- Defensar");
                if (resposta < 1 || resposta > 2) {
                    System.out.println("Tria entre 1 i 2!");
                }

            } while (resposta < 1 || resposta > 2);
            switch (resposta) {
                case 1:
                    double dany = atacant.atacar();
                    
                    break;
            
                default:
                    break;
            }
        }

    }

    public void crearPJ(ArrayList<Character> character) {
        boolean error = false;
        String resposta = "";
        do {
            resposta = llegirString("Vols omplir les dades manualment? (si/no)");
            if (resposta.equalsIgnoreCase("si") || resposta.equalsIgnoreCase("no")) {
                error = false;
            } else {
                error = true;
                System.out.println("Respon només si o no");
            }
        } while (error);
        if (resposta.equalsIgnoreCase("si")) {
            omplirManualment(character);
        } else if (resposta.equalsIgnoreCase("no")) {
            omplirAutomatic(character);
        }
    }

    public void omplirAutomatic(ArrayList<Character> character) {
        String nom = llegirString("Escriu el nom del personatge:");
        int edat;
        do {
            edat = llegirInt("Escriu l'edat del personatge");
        } while (edat <= 0);
        int opcioRaca = (int) (Math.random() * 4) + 1;
        Race raca = Race.HUMAN;
        if (opcioRaca == 1) {
            raca = Race.ORC;
        } else if (opcioRaca == 2) {
            raca = Race.ELF;
        } else if (opcioRaca == 3) {
            raca = Race.DUORF;
        } else if (opcioRaca == 4) {
            raca = Race.HUMAN;
        }

        int[] stats = { 5, 5, 5, 5, 5, 5 };
        int queden = 30;
        while (queden > 0) {
            int i = (int) (Math.random() * 6);
            if (stats[i] < 20) {
                stats[i]++;
                queden--;
            }
        }

        Character nou = new Character(nom, edat, raca, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
        character.add(nou);
        System.out.println("Personatge creat automàticament!");
        System.out.println(nou.toString());
    }

    public void omplirManualment(ArrayList<Character> character) {
        String nom = llegirString("Escriu el nom del personatge:");
        int edat;
        do {
            edat = llegirInt("Escriu l'edat del personatge:");
            if (edat <= 0) {
                System.out.println("L'edat ha de ser positiva!");
            }
        } while (edat <= 0);

        System.out.println("Tria la raça: 1-ORC, 2-ELF, 3-NAN, 4-HUMÀ");
        int opcioRaca = llegirInt("");
        Race raca;
        if (opcioRaca == 1) {
            raca = Race.ORC;
        } else if (opcioRaca == 2) {
            raca = Race.ELF;
        } else if (opcioRaca == 3) {
            raca = Race.DUORF;
        } else {
            raca = Race.HUMAN;
        }

        double strength, dexterity, constitution, intelligence, wisdom, charisma;
        int total;

        int restants = 60;
        do {

            System.out.println("Punts a repartir restants: " + restants);
            strength = llegirCaracteristica("Força");
            restants -= strength;
            System.out.println("Punts a repartir restants: " + restants);
            dexterity = llegirCaracteristica("Destresa");
            restants -= dexterity;
            System.out.println("Punts a repartir restants: " + restants);
            constitution = llegirCaracteristica("Constitució");
            restants -= constitution;
            System.out.println("Punts a repartir restants: " + restants);
            intelligence = llegirCaracteristica("Intel·ligència");
            restants -= intelligence;
            System.out.println("Punts a repartir restants: " + restants);
            wisdom = llegirCaracteristica("Saviesa");
            restants -= wisdom;
            System.out.println("Punts a repartir restants: " + restants);
            charisma = llegirCaracteristica("Carisma");
            total = (int) (strength + dexterity + constitution + intelligence + wisdom + charisma);
            if (total != 60) {
                System.out.println("Les característiques han de sumar 60! Has posat " + total);
                restants = 60;
            }
        } while (total != 60);

        Character nou = new Character(nom, edat, raca, strength, dexterity, constitution, intelligence, wisdom,
                charisma);
        character.add(nou);
        System.out.println("Personatge creat!");

    }

    public int llegirCaracteristica(String nom) {
        int valor;
        do {
            valor = llegirInt(nom + " (5-20):");
            if (valor < 5 || valor > 20) {
                System.out.println("El valor ha de ser entre 5 i 20!");
            }
        } while (valor < 5 || valor > 20);
        return valor;
    }

    Scanner sc = new Scanner(System.in);

    public int llegirInt(String m) {
        int text = 0;
        boolean error = false;
        do {
            try {
                System.out.println(m);
                text = sc.nextInt();
                sc.nextLine();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error, escriu numeros");
                error = true;
                sc.next();
            } catch (Exception e) {
                System.out.println("Error desconegut, torna");
                error = true;
                sc.next();
            }
        } while (error);
        return text;
    }

    public String llegirString(String m) {
        String text = "";
        boolean error = false;
        do {
            try {
                System.out.println(m);
                text = sc.nextLine();
                error = false;
            } catch (InputMismatchException e) {
                System.out.println("Error, escriu lletres o numeros");
                error = true;
                sc.next();
            } catch (Exception e) {
                System.out.println("Error desconegut, torna");
                error = true;
                sc.next();
            }
        } while (error);
        return text;
    }

    public Character escollirPersonatge(ArrayList<Character> character, int jugador, int exclou) {
        System.out.println("\nPersonatges disponibles:");
        for (int c = 0; c < character.size(); c++) {
            System.out.println((c + 1) + "- " + character.get(c).getName());
        }
        int opcio;
        do {
            opcio = llegirInt("Jugador " + jugador + ", tria un personatge:") - 1;
            if (opcio < 0 || opcio >= character.size()) {
                System.out.println("Tria un personatge vàlid!");
            } else if (opcio == exclou) {
                System.out.println("Aquest personatge ja l'ha triat l'altre jugador!");
            }
        } while (opcio < 0 || opcio >= character.size() || opcio == exclou);
        return character.get(opcio);
    }

}
