import java.util.Arrays;
import java.util.Scanner;

public class Puzzle {


    public static final int RANDOM_DEPTH = 50;
    public static void main(String[] args) {

        Desk desk = new Desk();
        desk.setDeskAsc();
        desk.shuffle();
        desk.deskPrint();
        System.out.println("Use S, W, A, D to move piece");
        Scanner sc = new Scanner(System.in);
        String s;
        while(!desk.checkWinPosition())
        {
            s=sc.nextLine();
            desk.movePiece(s);
            desk.deskPrint();
        }
        System.out.println("Congratulations, you won!");



    }
}
