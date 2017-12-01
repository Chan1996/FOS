/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkinout;

/**
 *
 * @author AshLim
 */
import java.util.*;

public class CheckInOut {

    static int staffid;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        function();
    }

    public static void function() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Enter your staff ID:");
        staffid = scanner.nextInt();
        if (staffid >= 0) {
            System.out.println("Proceed to page...");
            clearScreen();
            clockmenu();
        } else {
            System.out.println("Invalid Staff Id");
            function();

        }
    }

    public static void clockmenu() {
        Date date = new Date();
        Scanner scanner = new Scanner(System.in);
        int condition;
        int yes = 1;
        int no = 2;
        System.out.println("Clock In and Clock in");
        System.out.println("======================");
        System.out.println("1.Clock in");
        System.out.println("2.Clock Out");
        int decision = scanner.nextInt();
        if (decision == 1) {
            System.out.println("Staff id :" + staffid);
            System.out.println("Clock in Time:" + date.toString());
            System.out.println("Clock In Sucessful!!");
            System.out.println("Continue?(y/n)");
            System.out.println("1.Yes");
            System.out.println("2.No");
            condition = scanner.nextInt();
            if (no == condition) {
                System.out.println("Thank You");
            } else if (yes == condition) {
                function();
            }
        } else if (decision == 2) {
            System.out.println("Staff id :" + staffid);
            System.out.println("Clock Out Time:" + date.toString());
            System.out.println("Clock Out Sucessful!!");
            System.out.println("Continue?(y/n)");
            System.out.println("1.Yes");
            System.out.println("2.No");
            condition = scanner.nextInt();
            if (no == condition) {
                System.out.println("Thank You");
            } else if (yes == condition) {
                function();
            }
        } else {
            System.out.println("Invalid Menu Number.");
            clockmenu();
        }

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
