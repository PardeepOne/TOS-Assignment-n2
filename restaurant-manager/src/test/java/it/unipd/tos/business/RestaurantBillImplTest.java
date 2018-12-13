////////////////////////////////////////////////////////////////////
// [Pardeep] [Singh] [1143264]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImplTest {

    @Test(expected = RestaurantBillException.class)
    public void GetOrderPrice_MoreThan20MenuItems_RestaurantBillExceptionThrown() throws RestaurantBillException{
        List<MenuItem> items = new ArrayList<MenuItem>();
        for(int i =0; i < 5; ++i) {
            items.add(new MenuItem("Pizza", MenuItem.ItemType.Pizze, Math.random()));
        }
        for(int i =0; i < 25; ++i) {
            items.add(new MenuItem("Pasta", MenuItem.ItemType.Primi, Math.random()));
        }
        
        RestaurantBillImpl restaurantBillImpl = new RestaurantBillImpl();
        restaurantBillImpl.getOrderPrice(items);
    }
    
    @Test
    public void GetOrderPrice_OnlyPrimiWithTotalMoreThan100_Calculate() throws RestaurantBillException {
    	List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 5;i++) {
            itemsOrdered.add(new MenuItem("Primi", MenuItem.ItemType.Primi, 50));
        }
        
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        double expPrice = 200*0.95;
        assertEquals(expPrice, r.getOrderPrice(itemsOrdered),0.0);
    }
    
    @Test
    public void GetOrderPrice_OnlyPrimiWithTotalLessThan100_Calculate() throws RestaurantBillException {
    	List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 20;i++) {
            itemsOrdered.add(new MenuItem("Primi", MenuItem.ItemType.Primi, 1));
        }
        
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        double expPrice = 19;
        assertEquals(expPrice, r.getOrderPrice(itemsOrdered),0.0);
    }
    
    @Test
    public void GetOrderPrice_OnlyLessThan10PizzeAndTotalMoreThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 5;i++) {
            itemsOrdered.add(new MenuItem("Patatosa", MenuItem.ItemType.Pizze, 100));
        }
        
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        double expPrice = 380;
        assertEquals(expPrice, r.getOrderPrice(itemsOrdered),0.0);
     }
    
    @Test
    public void GetOrderPrice_OnlyLessThan10PizzeAndTotalLessThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 9;i++) {
            itemsOrdered.add(new MenuItem("Ciao",MenuItem.ItemType.Pizze, 1));
        }
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        double expPrice = 8;
        assertEquals(expPrice, r.getOrderPrice(itemsOrdered),0.0);
     }
    
    @Test
    public void GetOrderPrice_OnlyMoreThan10PizzeAndTotalLessThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 15;i++) {
            itemsOrdered.add(new MenuItem("Diavola",MenuItem.ItemType.Pizze, 5));
        }
        
        RestaurantBillImpl r = new RestaurantBillImpl();
       assertEquals(65, r.getOrderPrice(itemsOrdered),0.0f);
     }
    
    @Test
    public void GetOrderPrice_MoreThan10PizzeAndTotalMoreThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 0 ; i < 12;i++) {
            itemsOrdered.add(new MenuItem("Margherita",MenuItem.ItemType.Pizze, 10));
        }
        for(int i = 1 ; i < 5;i++) {
            itemsOrdered.add(new MenuItem("Pasta",MenuItem.ItemType.Primi, 10));
        }
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(142.5, r.getOrderPrice(itemsOrdered),0.0f);
     }
    
     @Test
     public void GetOrderPrice_MoreThan10PizzeWithDifferentPriceAndTotalMoreThan100_Calculate() throws RestaurantBillException{
    	 List<MenuItem> itemsOrdered = new ArrayList<>();
    	 for(int i = 0 ; i < 12;i++) {
             itemsOrdered.add(new MenuItem("Margherita",MenuItem.ItemType.Pizze, 10));
         }
    	 //adding one pizza with different rate.. it's the cheapest one
    	 itemsOrdered.add(new MenuItem("Funghi",MenuItem.ItemType.Pizze,7));
    	 for(int i = 1 ; i < 5;i++) {
             itemsOrdered.add(new MenuItem("Pasta",MenuItem.ItemType.Primi, 10));
         }
     
    	 RestaurantBillImpl r = new RestaurantBillImpl();
         assertEquals(152, r.getOrderPrice(itemsOrdered),0.0f);
     }
     

     @Test
     public void GetOrderPrice_MoreThan10PizzeWithDifferentPriceAndTotalLessThan100_Calculate() throws RestaurantBillException{
    	 List<MenuItem> itemsOrdered = new ArrayList<>();
    	 for(int i = 0 ; i < 12;i++) {
             itemsOrdered.add(new MenuItem("Margherita",MenuItem.ItemType.Pizze, 5));
         }
    	 //adding one pizza with different rate.. it's Not the cheapest one
    	 itemsOrdered.add(new MenuItem("Funghi",MenuItem.ItemType.Pizze,7));
    	 for(int i = 1 ; i < 5;i++) {
             itemsOrdered.add(new MenuItem("Pasta",MenuItem.ItemType.Primi, 5));
         }
         
    	 RestaurantBillImpl r = new RestaurantBillImpl();
         assertEquals(82, r.getOrderPrice(itemsOrdered),0.0f);
     }
     
     @Test
     public void GetSetNameOfMenuItem_OneMenuItem_Compare() {
    	 MenuItem menuItem = new MenuItem("Pasta",MenuItem.ItemType.Primi,35);
    	 
    	 menuItem.setName("Riso");
    	 String getS = menuItem.getName();
    	 
    	 
    	 assertEquals(getS, menuItem.getName());
     }
 
     @Test
     public void GetSetTypeOfMenuItem_OneMenuItem_Compare(){
    	 MenuItem menuItem = new MenuItem("Pasta",MenuItem.ItemType.Primi,35);
    	 
    	 MenuItem.ItemType itemType = menuItem.getType();
    	 menuItem.setType(MenuItem.ItemType.Primi);
    	 
    	 assertEquals(itemType, menuItem.getType());
     }
     
     @Test
     public void GetSetPriceOfMenuItem_OneMenuItem_Compare(){
    	 MenuItem menuItem = new MenuItem("Pasta",MenuItem.ItemType.Primi,35);
    	 
    	 menuItem.setPrice(99);
    	 double a = menuItem.getPrice();
    	 
    	 assertEquals(a, menuItem.getPrice(),0.0f);
     }
}
