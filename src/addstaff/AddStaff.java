/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addstaff;

import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Scanner;
import static javafx.application.Platform.exit;
/**
 *
 * @author C K
 */
public class AddStaff {

    /**
     * @param args the command line arguments
     */
    
    private static List<Staff> addStaff = new ArrayList<>();
    public static void main(String[] args) {
        // TODO code application logic here
        Menu();
    }
    
    private static void Menu(){
    
        Scanner reader = new Scanner(System.in);
        int selection;
        System.out.println(" HR Executive ");
        System.out.println("==============");
        System.out.println("1.Add New Staff");
        System.out.println("2.Update Staff Details");
        System.out.println("0.Exit");
        System.out.println("\nPlease enter number:");
        selection = reader.nextInt();
        
        
        if(selection==1)
        {
        AddStaff();
            
        }
        
        else if(selection==2)
        {
        System.out.println("Update Staff Details");
        }
        
        else
        {
         System.out.println("Thank you for using this system ! have a Good Day !");
        }
         
    }
    
    private static void AddStaff(){
    
        String option;
        
        do{
       
        
        
        Scanner reader = new Scanner(System.in);
        Staff Astaff = new Staff();
        
        System.out.println("\nPlease enter following information : ");
        
        System.out.println("\nName: ");
        Astaff.setAstaff_name(reader.nextLine());
        
        
        System.out.println("\nIC.NO: ");
        Astaff.setAstaff_icNo(reader.nextLine());
        
        
        System.out.println("\nPhone.No: ");
        Astaff.setAstaff_phoneNo(reader.nextLine());
        
        
        System.out.println("\nStatus: ");
        Astaff.setAstaff_status(reader.nextLine());
        
        
        System.out.println("\nGender: ");
        Astaff.setAstaff_gender(reader.nextLine());
        
        
        System.out.println("\nUsername: ");
        Astaff.setAstaff_userName(reader.nextLine());
       
        
        System.out.println("\nPassword: ");
        Astaff.setAstaff_passWord(reader.nextLine());
        
        
        
        
        System.out.println("\nStaff Information Added : ");
        System.out.println("===========================");
        System.out.println("Name      : "+Astaff.getAstaff_name());
        System.out.println("IC.NO     : "+Astaff.getAstaff_icNo());
        System.out.println("Phone.No  : "+Astaff.getAstaff_phoneNo());
        System.out.println("Status    : "+Astaff.getAstaff_status());
        System.out.println("Gender    : "+Astaff.getAstaff_gender());
        System.out.println("Username  : "+Astaff.getAstaff_userName());
        System.out.println("Password  : "+Astaff.getAstaff_passWord());
        
        addStaff.add(Astaff);
        
        
        
        System.out.println("Continue to add new staff?\n (Yes to continue|Show to show added info|No to Menu|Esc to exit)");
        option = reader.nextLine().toUpperCase();
        
        }while(option.equals("YES"));
        {
        
            if(option.equals("SHOW"))
        {
           Scanner reader = new Scanner(System.in);
           System.out.println("\nStaff Information Added : ");
           System.out.println("===========================");
           
           for(int k=0;k<addStaff.size();k++)
           {
           
               System.out.println(1+k+". \n"+addStaff.get(k));
           }
           System.out.println("Enter 1 to menu|0 for exit");
           int choice=reader.nextInt();
           if(choice==1)
           {
           
               Menu();
           }
           else if(choice ==0)
           {
           
               exit();
           }
           
        }
        }
        
        
        
        
        
    }
    
    
    
}
