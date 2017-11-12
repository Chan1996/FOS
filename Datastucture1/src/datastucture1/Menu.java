
package datastucture1;

import java.io.Serializable;

public class Menu implements Serializable {
    
private double price;
private int prodId;
private static int nextprodId=1;
private String prodName;

public Menu(){
    this.prodId= 0;
    this.prodName="";
}


public Menu(int prodId,String prodName,Double Price){
this.prodId=prodId;
this.prodName=prodName;
this.price=price;
}


public Menu(String prodName) {
    this.prodName = prodName;
    this.prodId = nextprodId++;
  }


  public String getName() {
    return prodName;
  }

  public void setName(String name) {
    this.prodName = prodName;
  }

  public int getProdId() {
    return prodId;
  }

  public void setProdId(int prodId) {
    this.prodId = prodId;
  }
  
  
 public static int getNextProdId() {
    return nextprodId;
  }

  public static void setNextProdId(int nextProdId) {
    Menu.nextprodId = nextprodId;
  }

  public double getPrice(){
      return price;
  }
  
  public void setPrice(double price){
      this.price = price ;
  }
  

 @Override
  public int hashCode() {
    int hash = 3;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Menu other = (Menu) obj;
    if (this.prodId != other.prodId) {
      return false;
    }
    return true;
  }
  
  
      
  @Override
  public String toString() {
    return String.format("No. %-10d %-20s\n", prodId, prodName);
  }
  

}