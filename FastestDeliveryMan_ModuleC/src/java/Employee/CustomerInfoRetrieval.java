package Employee;

import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;

public class CustomerInfoRetrieval {
    Scanner scanner = new Scanner(System.in);
    
    public CustomerInfoRetrieval(){
        try {
            int redo;
        
            do {
                redo = 0;
                Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleCPrototypedatabase", "ModuleC", "ModuleC");
                String contactNumber;
                        
                boolean invalid = false;
                do{
                    invalid = false;
                    System.out.println("Delivery Query System");
                    System.out.println("---------------------");
                    System.out.println("Please enter a contact  number in the format (xxx-xxxxxxx) to start querying: ");
                    contactNumber = scanner.nextLine();
                    if (contactNumber.length() != 11){
                        invalid = true;
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("Invalid contact number, try again\n");
                    }
                }while (invalid == true);

                String firstThree = contactNumber.substring(0, 3);
                String lastSegment = contactNumber.substring(4);

                PreparedStatement statementQuery = conn.prepareStatement("Select * from customer_delivery where customer_contactnumber = ? and status_delivered = false");
                statementQuery.setString(1, firstThree.concat(lastSegment));
                System.out.println("\n");

                ResultSet results = statementQuery.executeQuery();
                
                if (results.next() == false){
                    System.out.println("No active deliveries pending for selected contact number"); //Retieve customer details based on contact number so that i can proceed with my work
                }
                else {
                    System.out.println("Result 1:");
                    System.out.println("-----------------");
                    System.out.println("Contact Number: "+results.getString("Customer_ContactNumber"));
                    System.out.println("Order ID: "+results.getString("Order_ID"));
                    System.out.println("Customer Name: "+results.getString("Customer_Name"));
                    System.out.println("Customer Address: "+results.getString("Customer_DELIVERY_Address"));
                    System.out.println("Enter any value to proceed");
                    String valuePlaceholder = scanner.nextLine();
                    
                    for (int index = 2;results.next()==true; index++){
                        System.out.println("\n");
                        System.out.println("\n");
                        System.out.println("Result "+index+":");
                        System.out.println("-----------------");
                        System.out.println("Contact Number: "+results.getString("Customer_ContactNumber"));
                        System.out.println("Order ID: "+results.getString("Order_ID"));
                        System.out.println("Customer Name: "+results.getString("Customer_Name"));
                        System.out.println("Customer Address: "+results.getString("Customer_DELIVERY_Address"));
                        System.out.println("Enter any value to proceed");
                        valuePlaceholder = scanner.nextLine();
                    }
                }
                int errorFree;
                do {
                    errorFree = 1;
                    System.out.println("Is there more queries?: (Enter 1 for yes)");
                    String input = scanner.nextLine();
                    System.out.println("\n");
                    System.out.println("\n");
                    try {
                        redo = Integer.parseInt(input);
                    }
                    catch (Exception ex){
                        errorFree = 0;
                        System.out.println("Only integers are allowed");
                    }
                } while (errorFree == 0);
                
            }while(redo == 1);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        
    }
}
