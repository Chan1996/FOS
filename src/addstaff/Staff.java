/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addstaff;

/**
 *
 * @author C K
 */
public class Staff {
    
    private String Astaff_name;
    private String Astaff_icNo;
    private String Astaff_phoneNo;
    private String Astaff_status;
    private String Astaff_gender;
    private String Astaff_userName;
    private String Astaff_passWord;
    
    public Staff(){
    
        this("","","","","","","");
    }
    
    public Staff(String Astaff_name,String Astaff_icNo,String Astaff_phoneNo,String Astaff_status,String Astaff_gender,String Astaff_userName,String Astaff_passWord){
    
        this.Astaff_name=Astaff_name;
        this.Astaff_icNo=Astaff_icNo;
        this.Astaff_phoneNo=Astaff_phoneNo;
        this.Astaff_status=Astaff_status;
        this.Astaff_gender=Astaff_gender;
        this.Astaff_userName=Astaff_userName;
        this.Astaff_passWord=Astaff_passWord;
        
    }
    
    public String getAstaff_name(){
     return Astaff_name;
    }
    
    public void setAstaff_name(String Astaff_name ){
    this.Astaff_name=Astaff_name;
    }
    
    public String getAstaff_icNo(){
     return Astaff_icNo;
    }
    
    public void setAstaff_icNo(String Astaff_icNo ){
    this.Astaff_icNo=Astaff_icNo;
    }
    
    public String getAstaff_phoneNo(){
     return Astaff_phoneNo;
    }
    
    public void setAstaff_phoneNo(String Astaff_phoneNo ){
    this.Astaff_phoneNo=Astaff_phoneNo;
    }
    
    public String getAstaff_status(){
     return Astaff_status;
    }
    
    public void setAstaff_status(String Astaff_status ){
    this.Astaff_status=Astaff_status;
    }
    
    public String getAstaff_gender(){
     return Astaff_gender;
    }
    
    public void setAstaff_gender(String Astaff_gender ){
    this.Astaff_gender=Astaff_gender;
    }
    
    public String getAstaff_userName(){
     return Astaff_userName;
    }
    
    public void setAstaff_userName(String Astaff_userName ){
    this.Astaff_userName=Astaff_userName;
    }
    
    public String getAstaff_passWord(){
     return Astaff_passWord;
    }
    
    public void setAstaff_passWord(String Astaff_passWord ){
    this.Astaff_passWord=Astaff_passWord;
    }
    
    public String toString(){
    
        return"Staff Information:\n" +"=================="+"\n" +"Name    : " + Astaff_name +"\n"+ "IC.NO   : " + Astaff_icNo +"\n"+ "Status  : " + Astaff_status +"\n"+ "Gender  : " + Astaff_gender +"\n"+ "Username: " + Astaff_userName +"\n"+
                "Password: " + Astaff_passWord +"\n";
    }
}
