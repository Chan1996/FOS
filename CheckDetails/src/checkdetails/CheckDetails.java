
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AshLim
 */
import java.util.Scanner;



public class CheckDetails {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String man[][] = {{"1001", "Lim Zhi Hui", "Y", "\t", "1.00-2.00"},
                            {"1002", "Aw Khaw Wai", "N", "Deliver burger", "11.00-12.00"}, 
                            {"1003", "Yong Kai Xiong", "N", "Deliver noodles", "2.30-3.30"},
                            {"1004", "Chua Wei Han", "Y", "\t", "2.00 - 3.00"}};
        
        System.out.println("Staff ID\tStaff Name\t\tAvailable\tDelivery Description\tBreak-time");

        for(int row =0;row<man.length;row++){
            for(int col=0;col<man[row].length;col++){
                System.out.print(man[row][col] +"\t\t");
            }
            System.out.println();
        }
            
    }

    private static class Delivery {

        private int staffID;
        private String staff_name;
        private char available;
        private String delivery;
        private String break_time;

        public Delivery(int staffID, String staff_name, char available, String delivery, String break_time) {
            this.staffID = staffID;
            this.staff_name = staff_name;
            this.available = available;
            this.delivery = delivery;
            this.break_time = break_time;
        }

        public int getStaffID() {
            return staffID;
        }

        public String getStaff_name() {
            return staff_name;
        }

        public char getAvailable() {
            return available;
        }

        public String getDelivery() {
            return delivery;
        }

        public String getBreak_time() {
            return break_time;
        }

        public void setStaffID(int staffID) {
            this.staffID = staffID;
        }

        public void setStaff_name(String staff_name) {
            this.staff_name = staff_name;
        }

        public void setAvailable(char available) {
            this.available = available;
        }

        public void setDelivery(String delivery) {
            this.delivery = delivery;
        }

        public void setBreak_time(String break_time) {
            this.break_time = break_time;
        }

        @Override
        public String toString() {
            return "Delivery:\n" + "==========================" + "\nStaff ID =" + staffID + "\nStaff Name =" + staff_name + "\nAvailable =" + available + "\nDelivery =" + delivery + "\nBreak_time =" + break_time;
        }

    }
}
