package cinibook;

import java.util.Scanner;

public class PaymentTab {

    static Scanner b = new Scanner(System.in);
    static int attempt = 3;
    public static void billing(String [] Ak,float mPrice, float cPrice, float total) throws Exception{
       try {

    	   System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
           Thread.sleep(500);
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ____Your Bill____");
           Thread.sleep(500);
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Your Ticket Cost is: " + mPrice);
           Thread.sleep(500);
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Your Cafe Cost is: " + cPrice);
           Thread.sleep(500);
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ---------------------------");
           Thread.sleep(500);
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Your Total Cost is: " + total);
           Thread.sleep(500);
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t ---------------------------");
           Thread.sleep(500);
           System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

           System.out.println();
           System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t ...MPIN: Your mobile number... ");
           Thread.sleep(500);
           System.out.print("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Enter your MPIN to pay: ");
           int mPin = b.nextInt();
           System.out.println();
           
           

           if ((mPin==DB.contactStore) && attempt > 0) {
               System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
               System.out.println("Payment Successful...");
               Thread.sleep(500);
               System.out.println("Don't stop searching for exclusive movies here on \'CiniBook\'....");
               System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

               WelcomePage.s1=false;
               WelcomePage.s2=false;
               DB.movieSurf=true;
               DB.processing=false;
               MovieSurf.main(Ak);
           } else if (attempt > 0) {
               attempt -= 1;
               System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
               System.out.println("Payment Failed...");
               Thread.sleep(500);
               System.out.println("Try Again boss.....");
               System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
               PaymentTab.billing(Ak, mPrice, cPrice, total);
           } else {
               System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
               System.out.println("You Exceeded Maximum attempts...");
               Thread.sleep(500);
               System.out.println("and seems suspicious....");
               Thread.sleep(500);
               System.out.println("Auto exit: \"ACTIVATED\"");
               System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
               WelcomePage.exitApp();
           }
       }catch(Exception e){

       }
    }
}
