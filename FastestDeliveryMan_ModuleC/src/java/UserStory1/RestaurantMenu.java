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
                        "                                   <option value=\"1\">Restaurant 1</option>"+
                        "                                   <option value=\"2\">Restaurant 2</option>"+
                        "                                   <option value=\"3\">Restaurant 3</option>"+
                        "                                   <option value=\"4\">Restaurant 4</option>"+
                        "                               </select>"+
                        "                           </td>"+
                        "                       </tr>"+
                        "                       <tr>"+
                        "                           <td>"+
                        "                               <label for=\"Branch\">Branch: </label>"+
                        "                           </td>"+
                        "                           <td>"+
                        "                               <select name=\"Branch\">"+
                        "                                   <option value=\"1\">Branch 1</option>"+
                        "                                   <option value=\"2\">Branch 2</option>"+
                        "                                   <option value=\"3\">Branch 3</option>"+
                        "                                   <option value=\"4\">Branch 4</option>"+
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
                        "               <table>"+
                        "                   <tr>"+
                        "                       <td>"+
                        "                           <p>placeholder</p>"+
                        "                       </td>"+
                        "                       <td>"+
                        "                           <p>placeholder</p>"+
                        "                       </td>"+
                        "                   </tr>"+
                        "                   <tr>"+
                        "                       <td>"+
                        "                           <p>placeholder</p>"+
                        "                       </td>"+
                        "                       <td>"+
                        "                           <p>placeholder</p>"+
                        "                       </td>"+
                        "                   </tr>"+              
                        "               </table>"+
                        "           </form>");
            out.println("        </center>"+
                        "    </body>"+
                        "</html>");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}