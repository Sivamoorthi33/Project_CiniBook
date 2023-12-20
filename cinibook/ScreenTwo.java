package cinibook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScreenTwo {

    static float screenTwoPrice;

    static Scanner x = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        List<String> filledS = new ArrayList<>();
        List<String> unFilledS = new ArrayList<>();

        filledS.add("A02");
        filledS.add("A03");
        filledS.add("G29");
        filledS.add("G30");
        filledS.add("D24");
        filledS.add("D25");
        filledS.add("G04");
        filledS.add("B10");
        filledS.add("H06");
        filledS.add("F14");


        //Section-1
        System.out.print("\t");
        for (int i = 1; i <= 20; i++) {
            if (i < 10) {
                System.out.print(" 0" + i + " ");
            } else {
                System.out.print("  " + i);
            }
        }

        //Section-2
        System.out.print("\t\t");
        for (int i = 21; i <= 30; i++) {
            System.out.print("  " + i);
        }
        System.out.println();


        for (int i = 75; i >= 69; i--) {
            System.out.print(" " + (char) i + "  ");
            for (int fill = 1; fill <= 49; fill++) {
                if (fill <= 20 || (fill >= 23 && fill <= 32)) {
                    System.out.print(" |=|");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 68; i >= 65; i--) {
            System.out.print(" " + (char) i + "  ");
            for (int fill = 1; fill <= 49; fill++) {
                if (fill <= 20 || (fill >= 23 && fill <= 32)) {
                    System.out.print(" |=|");
                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        System.out.println("\t\t __________________________________________________________________________________________________________________\t\t");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t (way to screen)");

        System.out.println();
        System.out.println();
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        System.out.println("Already filled seats are: ");
        Thread.sleep(1000);
        System.out.println(filledS);
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

        choosingSeats(args,filledS,unFilledS);

    }


    public static void choosingSeats(String[] args,List filledS, List unFilledS) throws Exception {
        while (WelcomePage.s2) {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t How many seats do you want to book....");
            Thread.sleep(500);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t Press \'0\' to Surf Other Movies.....");
            Thread.sleep(500);
            System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t Seats: ");
            int seats = x.nextInt();

            seatValidation(args,seats,filledS,unFilledS);
        }
    }

    private static void seatValidation(String [] args, int seats, List filledS, List unFilledS) throws Exception {
        if (seats > 0) {
            for (int i = 1; i <= seats; i++) {
                System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t Enter Seat ID as Matrix: ");
                String s = x.next();
                System.out.println();

                unFilledS.add(s);
            }
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            checkUserChoise(args,filledS,unFilledS);
        } else {
            WelcomePage.s2=false;
            DB.movieSurf=true;
            MovieSurf.main(args);
        }
    }

    public static void checkUserChoise(String[] args,List filledS,List unFilledS)throws Exception{

        int len = unFilledS.size();
        int count=0, booked=0;

        for (int i=0;i<len;i++){
            String tempStr = String.valueOf(unFilledS.get(i));
            if (filledS.contains(tempStr)){
                booked+=1;
            } else {
                count+=1;
            }
        }

        screenTwoPrice = count*140;

        if (booked>0){
            System.out.println("Seats you requested are already booked.....");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            unFilledS.clear();
            ScreenTwo.choosingSeats(args,filledS,unFilledS);
        }else {
            DB.processing=true;
            WelcomePage.s2=false;
            if (DB.userSignedUp==true){
                if (DB.userLoggedIn==true) {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ...Welcome to Cafe...");
                    Thread.sleep(500);
                    Cafeteria.addOns(args,screenTwoPrice);
                } else {
                    System.out.println("Lets log in first to continue...");
                    WelcomePage.logIn(args);
                    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                    System.out.println();
                    Thread.sleep(500);
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ...Welcome to Cafe...");
                    Thread.sleep(500);
                    DB.processing=false;
                    Cafeteria.addOns(args,screenTwoPrice);
                }
            } else {
                System.out.println("You don't have an account...");
                Thread.sleep(500);
                System.out.println("Lets create an account first to continue...");
                WelcomePage.signUp();
                System.out.println("Lets log in first to continue...");
                WelcomePage.logIn(args);
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.println();
                Thread.sleep(500);
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ...Welcome to Cafe...");
                Thread.sleep(500);
                DB.processing=false;
                Cafeteria.addOns(args,screenTwoPrice);
            }
        }
    }
}