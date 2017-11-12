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
/**
 *
 * @author C K
 */
public class AddStaff {

    /**
     * @param args the command line arguments
     */
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
        System.out.println("Please enter number:");
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
        
        System.out.println("Please enter following information : ");
        
        System.out.println("Name: ");
        Astaff.setAstaff_name(reader.nextLine());
        
        System.out.println("IC.NO: ");
        Astaff.setAstaff_icNo(reader.nextLine());
        
        System.out.println("Phone.No: ");
        Astaff.setAstaff_phoneNo(reader.nextLine());
        
        System.out.println("Status: ");
        Astaff.setAstaff_status(reader.nextLine());
        
        System.out.println("Gender: ");
        Astaff.setAstaff_gender(reader.nextLine());
        
        System.out.println("Username: ");
        Astaff.setAstaff_userName(reader.nextLine());
        
        System.out.println("Password: ");
        Astaff.setAstaff_passWord(reader.nextLine());
        
        
        
        ArrayList<Staff> addStaff = new ArrayList<Staff>();
        addStaff.add(Astaff);
        
        for(int i=0;i < addStaff.size(); i++)
        {
              System.out.println(addStaff.size());
              System.out.println(""+addStaff.get(i));
        }
        
        System.out.println("Continue to add new staff? (Yes to continue|No to Menu|Esc to exit)");
        option = reader.nextLine().toUpperCase();
        
        }while(option.equals("YES"));
        {
        
            if(option.equals("NO"))
        {
           
            Menu();
        }
        }
        
        
        
        
        
    }
    
    
    
}
