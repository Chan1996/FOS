/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrderConfirmation", urlPatterns = {"/OrderConfirmation"})
public class OrderConfirmation {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd = null;
        PrintWriter out = response.getWriter();
        
        String ItemName = request.getParameter("MenuItem");
        String ItemID = request.getParameter("MenuID");
        double ItemPrice = Double.parseDouble(request.getParameter("MenuPrice"));
        int ItemQuantity = Integer.parseInt(request.getParameter("MenuQuantity"));
        
        try {
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/ModuleCPrototypedatabase", "ModuleC", "ModuleC");
            PreparedStatement pstmt1 = conn.prepareStatement("Select * from ordering");
            
            ResultSet initialiseOrderID;
            int orderCount = 0;
            
            initialiseOrderID = pstmt1.executeQuery();
            for(;initialiseOrderID.next();){
                orderCount++;
            }
            
            PreparedStatement pstmt2 = conn.prepareStatement("Insert into ordering values(?,?,?,?,?)");     //Insert statement
            pstmt2.setString(1, "ORD"+orderCount);
            pstmt2.setDouble(2, ItemPrice);
            pstmt2.setInt(3, ItemQuantity);
            pstmt2.setString(4, ItemID);
            pstmt2.setString(5, ItemName);
            
            PreparedStatement pstmt3 = conn.prepareStatement("Delete * from ordering where Order_id = ?");  //Cancel entire order
            pstmt3.setString(1, ""+orderCount);
            
            PreparedStatement pstmt4 = conn.prepareStatement("Delete * from ordering where order_id = ? AND ");
            
            PreparedStatement pstmtStart = conn.prepareStatement("Select Restaurant_Name from menu group by Restaurant_Name");
            ResultSet searchResult;
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
                        "               width: 50% ;"+
                        "               background-color: lightgrey;"+
                        "           }"+
                        "           table#menuDisplay{"+
                        "               border-collapse: collapse;"+
                        "               background-color: white;"+
                        "           }"+
                        "           table#menuDisplay th, table#menuDisplay td{"+
                        "               border: 1px solid black;"+
                        "               width: 25%;"+
                        "           }"+
                        "       </style>"+
                        "   </head>"+
                        "   <body>"+
                        "       <header></header>"+
                        "       <nav></nav>"+
                        "       <center>"+
                        "           <h1>FastestDeliveryman Food Order Confirmation</h1>"+
                        "           "+
                        "        </center>"+
                        "    </body>"+
                        "</html>");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
