/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addstaff;

import static java.lang.Character.isDigit;
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
        
            UpdateStaff();
            
        }
        
        else
        {
         System.out.println("Thank you for using this system ! have a Good Day !");
        }
         
    }
    
    private static void AddStaff(){
    
        String option;
        
        do{
       
        String icno;
        String gender;
        String pass1;
        String pass2;
        String pno;
        
        Scanner reader = new Scanner(System.in);
        Staff Astaff = new Staff();
        
        System.out.println("\nPlease enter following information : ");
        
        System.out.println("\nName: ");
        Astaff.setAstaff_name(reader.nextLine());
        
        
        
        
        do{    
        System.out.println("\nIC.NO(12 digits): ");
        icno=reader.nextLine();           
            
        }while(icno.length()!=12);
        {
        
            if(icno.length()==12)
            {
            
                Astaff.setAstaff_icNo(icno);
            }
        }
        
        
        
        /**/
       System.out.println("\nPhone.No: ");
        Astaff.setAstaff_phoneNo(reader.nextLine());
        /*do{
        System.out.println("Phone No cannot contains any alphabet !");
        System.out.println("\nPhone.No: ");
        
        pno=reader.nextLine();
        }while();*/
        
        

        do{
        
        System.out.println("\nGender(Male/Female): ");
        gender=reader.nextLine().toUpperCase();
            
        }while(!gender.equals("MALE")&&!gender.equals("FEMALE"));
        {
        
             if(gender.equals("MALE")|| gender.equals("FEMALE"))
            {
            
                Astaff.setAstaff_gender(gender);
            }
        }
        
        System.out.println("\nStatus: ");
        Astaff.setAstaff_status(reader.nextLine());
        
        System.out.println("\nUsername: ");
        Astaff.setAstaff_userName(reader.nextLine());
        
        
        do{
        
        System.out.println("\nPassword must match !");
        System.out.println("Password: ");
        pass1=reader.nextLine();
        
        System.out.println("\nRe-type Password: ");
        pass2=reader.nextLine();
            
        }while(!pass1.equals(pass2));
        {
        
            if(pass1.equals(pass2))
            {
            
                Astaff.setAstaff_passWord(pass2);
            }
        }
        
        
        
        
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
            else if(option.equals("NO"))
            {
            
                Menu();
            }
        }
        
        
        
        
        
    }
    
    private static void UpdateStaff(){
  
     
            Scanner reader = new Scanner(System.in);
            System.out.println("Please enter staff name : ");
            String S_name=reader.nextLine();
            
            for(int i=0; i<addStaff.size();i++)
            {
            
                if(S_name.equals(addStaff.get(i).getAstaff_name()))
                        {
                        
                            System.out.println("Staff information found !");
                            System.out.println("\nPlease select information to update| P for Phone| S for status| E for exit");
                            String option=reader.nextLine().toUpperCase();
                            
                            if(option.equals("P"))
                            {
                            System.out.println("Staff Information");
                            System.out.println("=====================");
                            System.out.println("\n"+addStaff.get(i));
                            System.out.println("\nPlease enter new phone number : ");
                            String p_no=reader.nextLine();
                            
                            
                            if(p_no.equals(addStaff.get(i).getAstaff_phoneNo()))
                            {
                            
                                System.out.println("\nPhone number is same.");
                                UpdateStaff();
                            }
                            else
                            {
                                
                                for(int z=0;z<p_no.length();z++)
                                {
                                
                                    if(Character.isDigit(p_no.charAt(z)))
                                    {
                                    
                                        addStaff.get(i).setAstaff_phoneNo(p_no);
                                        
                             
                                    }
                                    else
                                    {
                                    
                                        System.out.println("\nPhone number only digit!");
                                        UpdateStaff();
                                    }
                                    
                                    
                                }
                                //
                            System.out.println("\nContact number has been updated !");
                            System.out.println("========================");
                            System.out.println(addStaff.get(i));
                            System.out.println("Continue to update ? Y for yes| N for no");
                                        String con_update=reader.nextLine().toUpperCase();
                            if(con_update.equals("Y"))
                            {
                            
                                UpdateStaff();
                            }
                            else if(con_update.equals("N"))
                            {
                            
                                exit();
                            }
                                
                             
                            }
                            
                                
                            }
                            
                            else if(option.equals("S"))
                            {
                             System.out.println("Staff Information");
                            System.out.println("=====================");
                            System.out.println("\n"+addStaff.get(i));
                            System.out.println("\nPlease enter new status |A for active| R for resign| : ");
                            String status=reader.nextLine();
                            
                            if(status.equals(addStaff.get(i).getAstaff_status()))
                            {
                             
                                System.out.println("Status is same.");
                                UpdateStaff();
                                
                            }
                            else
                            {
                            
                               addStaff.get(i).setAstaff_status(status);
                            System.out.println("Staff status has been updated !!");
                            System.out.println("========================");
                            System.out.println(addStaff.get(i)); 
                            }
                            
                                
                            }
                        }
                else
                {
                
                    System.out.println("User not found !");
                    UpdateStaff();
                }
            }
    }
}
