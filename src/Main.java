

import java.util.Locale;
import java.util.Scanner;
import java.util.random.RandomGenerator;


public class Main {


    static int green;
    static int orange;
    static int yellow;
    static int compMoveAmount;
    static String compMoveColor;
    static int humanMoveAmount;
    static String humanMoveColor;
    static Scanner scanner = new Scanner(System.in);

//    System.out.println("testtt");
    public static void main(String[] args) {
        System.out.println("test");
        runGame();
    }
    static void runGame(){
        green = 3;
        yellow = 7;
        orange = 5;

        System.out.println("Game started! Who goes first? \n ( [C]omputer/[H]uman )");
        String firstPlayer = scanner.next();
        firstPlayer = firstPlayer.toUpperCase();
//        System.out.println(firstPlayer);
//        makeMove(firstPlayer,0);
        boolean gameOver = false;
        boolean computerMove;

        if(firstPlayer == "C"){
            computerMove = true;
        }else {
            computerMove = false;
        }
        while(!gameOver){
            if(computerMove){
                determineMove();
                makeMove(compMoveColor,compMoveAmount);
            }else{
                System.out.println("Current state of the game: \nGreen:" + green + "\nYellow: " + yellow + "\nOrange: " + orange);
                System.out.println("Your turn! Pick a color: ");
                humanMoveColor = scanner.next();
                System.out.println("pick amount");
                humanMoveAmount = scanner.nextInt();
                makeMove(humanMoveColor,humanMoveAmount);
            }
            if(green <= 0 && yellow <= 0 && orange <= 0){
                gameOver = true;
            }
            computerMove = !computerMove;
        }

    }
    static boolean makeMove(String color, int amount){
        color = color.toUpperCase();
        switch (color) {
            case "G":
                System.out.println("g");
                green -= amount;
                break;
            case "Y":
                System.out.println("y");
                yellow -= amount;
                break;

            case "O":
                System.out.println("y");
                orange -= amount;
                break;
            default:
                return false;

        }
        return true;
    }
    static void determineMove(){
        if(yellow > (green^orange)){
            compMoveAmount = yellow - (green^orange);
            compMoveColor = "Y";
        }else if(orange > (green^yellow)){
            compMoveAmount = orange - (green^yellow);
            compMoveColor = "O";
        }else if(green > (orange^yellow)){
            compMoveAmount = green - (orange^yellow);
            compMoveColor = "G";
        }else{
//            random
            System.out.println("random "+ (yellow-(green^orange)));
            compMoveAmount = green - (orange^yellow);
            compMoveColor = "g";
        }
    }
}