package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class game {
    public static void main(String[] args) {
        game p = new game();
        p.principal();
    }
    public void principal(){
        ArrayList<Characters> character = new ArrayList<Characters>();
        crearPJ(character);

    }
    private void crearPJ(ArrayList<Characters> character) {
      
    }
    Scanner sc = new Scanner(System.in);
   
    public int llegirInt(String m) {
        int text = 0;
        boolean error = false;
        do {
            try {
                System.out.println(m);
                text = sc.nextInt();
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
}
