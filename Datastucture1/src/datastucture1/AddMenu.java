package datastucture1;

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
         
         do{
         
        
        System.out.println("Enter Product Name. ");
        name = scanner.nextLine();
        System.out.println("Enter Product Price. type -1 to exit");
        price = Double.parseDouble(scanner.nextLine());
        
        
        Menu menu = new Menu(productId,name,price);
        
        menuList.add(menu);
 
        productId++;
        
         }while(price!= -1);
      
    
         
         
        
}
      
      
      public void mainMenu(){
          int choice=0;
         System.out.println("1.Add Menu");
         System.out.println("2. Update Item Details");
         choice = Integer.parseInt(scanner.nextLine());
         if(choice == 1){
             inputMenu();
         }
         
      }
      
}
