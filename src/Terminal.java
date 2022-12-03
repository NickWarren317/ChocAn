/*
 * Author: Nicholas Warren
 * 
 * displays information and prompts answers
 */


import java.util.Scanner;

public class Terminal{
    Scanner input = new Scanner(System.in);
    //displays string to terminal
    public void prompt(String prompt){
        System.out.println(prompt);
    }
    //accepts string input
    public String inputString(){
        return input.nextLine();
    }
    //accepts integer input
    public int inputInt(){
        int inpt =  input.nextInt(); //add some non int deteections
        input.nextLine();
        return inpt;
    }
}