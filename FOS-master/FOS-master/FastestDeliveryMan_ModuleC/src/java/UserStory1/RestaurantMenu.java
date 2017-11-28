package UserStory1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import java.util.Date;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;


@WebServlet(name = "RestaurantMenu", urlPatterns = {"/RestaurantMenu"})
public class RestaurantMenu extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        PrintWriter out = response.getWriter();
        
        
        String RestaurantName = request.getParameter("RestaurantList");
        String RestaurantBranch = request.getParameter("Branch");
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleCPrototypedatabase", "ModuleC", "ModuleC");
            PreparedStatement pstmt1 = conn.prepareStatement("Select * from Menu where restaurant_name =? AND menu_availability=true");
            pstmt1.setString(1, RestaurantName);
            int results = 0;
            
            out.println("<html>"+
                        "    <head>"+
                        "        <title>FastestDeliveryMan Food Delivery</title>"+
                        "        <meta charset=\"UTF-8\">"+
                        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
                        "        <style>"+
                        "           body {"+
                        "               float: center;"+
                        "	        }"+
                        "           center {"+
                        "               width: 100%;"+
                        "               margin: 0px auto;"+
                        "           }"+
                        "           form {"+
                        "               width: 50% "+
                        "           }"+
                        "           form#Search {"+
                        "               background-color: lightgrey;"+
                        "           }"+
                        "       </style>"+
                        "   </head>"+
                        "   <body>"+
                        "       <header></header>"+
                        "       <nav></nav>"+
                        "       <center>"+
                        "           <h1>FastestDeliveryman Food Order</h1>"+
                        "           <form action=\"\" id=\"Search\" method=\"get\">"+
                        "               <fieldset id=\"SearchRestaurant\">"+
                        "                   <legend>Search Restaurant</legend>"+
                        "                   <table>"+
                        "                       <tr>"+
                        "                           <td>"+
                        "                               <label for=\"RestaurantList\">Select a restaurant: </label>"+
                        "                           </td>"+
                        "                           <td>"+
                        "                               <select name =\"RestaurantList\">"+
                        "                                   <option value=\"Restaurant CK\">Restaurant CK</option>"+
                        "                                   <option value=\"2\">Restaurant 2</option>"+
                        "                                   <option value=\"3\">Restaurant 3</option>"+
                        "                                   <option value=\"4\">Restaurant 4</option>"+
                        "                               </select>"+
                        "                           </td>"+
                        "                       </tr>"+
                        "                   </table>"+
                        "                   <br/>"+
                        "                   <input type=\"reset\" value=\"Reset Selection\" title=\"Reset Selection\"/>"+
                        "                   <input type=\"submit\" value=\"Search Restaurant\" title=\"Search for selected restaurant\"/>"+
                        "               </fieldset>"+
                        "           </form>");
            if (!RestaurantName.equals("") || !RestaurantBranch.equals("")){
            out.println("           <form action=\"RestaurantMenu\" id=\"Results\">"+
                        "           <fieldset>"+
                        "               <legend>Search Result</legend>"+
                        "               <table>"+
                        "                   <tr>"+
                        "                       <td>"+
                        "                           <label for=\"\">Restaurant Name: </label>"+
                        "                       </td>"+
                        "                       <td>"+
                        "                           <input type=\"text\" readonly=\"readonly\" value=\""+RestaurantName+"\"/>"+
                        "                       </td>"+
                        "                   </tr>"+
                        "                   <tr>"+
                        "                       <td>"+
                        "                           <label for=\"\">Restaurant Branch: </label>"+
                        "                       </td>"+
                        "                       <td>"+
                        "                           <input type=\"text\" readonly=\"readonly\" value=\""+RestaurantBranch+"\"/>"+
                        "                       </td>"+
                        "                   </tr>"+              
                        "               </table>"+
                        "           </fieldset>");
            }
            out.println("           <fieldset>"+
                        "               <legend>Menu Items</legend>"+
                        "               <table>");
            ResultSet rs = pstmt1.executeQuery();
            for (;rs.next() == true;results++){
                out.println("                   <tr>"+
                            "                       <td>Item Name: "+rs.getString("Menu_Name")+"</td>"+
                            "                       <td>Item Price: "+rs.getString("Menu_Price")+"</td>"+
                            "                   </tr>");
            }
                          
            out.println("               </table>"+
                        "           </form>"+
                        "        </center>"+
                        "    </body>"+
                        "</html>");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}