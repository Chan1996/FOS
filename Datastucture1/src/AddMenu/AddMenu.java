package AddMenu;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AddMenu  {
   List<Menu> menuList = new ArrayList<Menu>();
   Scanner scanner = new Scanner(System.in);
    
      
      
    public static void main (String args[]){
       AddMenu add= new AddMenu();
        add.mainMenu();
    }
      
      public void inputMenu(){
         
         int productId=1;

         String name="";
         double price;
         char choice ='Y';
         
         
         do{
         
       
        System.out.println("Enter Product Name: ");
        
        name = scanner.nextLine();
        scanner.nextLine();
        
        
        
        for(int count=0;count<menuList.size();count++){
            if(name.equals(menuList.get(count).getName())){
                System.out.println("Duplicate product name, reenter a product name.\n Redirecting to Main Menu . . . . . . . . \n");
                mainMenu();
            }
        }
        
        
        System.out.println("Enter Product Price : ");
        price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("");
        System.out.println("Continue? (Y/N)");
        choice= scanner.next().charAt(0);
        System.out.println("\n------------------------------------------------------------\n");
        
        scanner.nextLine();
        Menu menu = new Menu(productId,name,price);
        menuList.add(menu);
        
        productId++;
        
         }while(choice== 'Y'||choice =='y');
      
      mainMenu();
         
         
        
}
      
      public void displayMenu(){
          System.out.println("M E N U        L I S T \n-----------------------------------------------------\n");
          String pid="Product ID";
          String pname="Product Name";
          String pprice="Price";
          
               System.out.println("\n ----------------------------------------------------------------------------------");
               System.out.printf("\n |%-16s | %-15s |%-20s \n",pid,pname,pprice);
              System.out.println(menuList.toString());
              System.out.println("\n ----------------------------------------------------------------------------------\n");
              mainMenu();
      }
      
      

      
      public void mainMenu(){
          
          System.out.println("---------------------------------------------------\n M A I N            M E N U \n");
          int choice=0;
         System.out.println("1.Add Menu");
         System.out.println("2.Display Menu");
         choice = Integer.parseInt(scanner.nextLine());
         scanner.nextLine();
         if(choice == 1){
             inputMenu();
         }
         if(choice == 2)
         {
             displayMenu();
         }
         
      }
      
}
