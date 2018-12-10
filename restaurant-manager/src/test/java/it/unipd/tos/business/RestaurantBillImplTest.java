package it.unipd.tos.business;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImplTest {

    @Test(expected = RestaurantBillException.class)
    public void GetOrderPrice_MoreThan20Elements_ExceptionThrown() throws RestaurantBillException{
        List<MenuItem> items = new ArrayList<MenuItem>();
        for(int i =0; i < 25; ++i) {
            items.add(new MenuItem("Pasta", MenuItem.ItemType.Primi, Math.random()));
        }
        
        RestaurantBillImpl restaurantBillImpl = new RestaurantBillImpl();
        restaurantBillImpl.getOrderPrice(items);
    }
    
    @Test
    public void GetOrderPrice_LessThan10PizzasAndTotalMoreThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 5;i++) {
            itemsOrdered.add(new MenuItem("Patatosa", MenuItem.ItemType.Pizze, 100));
        }
        
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(380, r.getOrderPrice(itemsOrdered),0.0);
     }
    
    @Test
    public void GetOrderPrice_LessThan10PizzasAndTotalLessThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 5;i++) {
            itemsOrdered.add(new MenuItem("Ciao",MenuItem.ItemType.Primi, 1));
        }
        
        RestaurantBillImpl r = new RestaurantBillImpl();
        assertEquals(4, r.getOrderPrice(itemsOrdered),0.0);
     }
    
    @Test
    public void GetOrderPrice_MoreThan10PizzasAndTotalLessThan100_Calculate() throws RestaurantBillException{
        List<MenuItem> itemsOrdered = new ArrayList<>();
        for(int i = 1 ; i < 15;i++) {
            itemsOrdered.add(new MenuItem("Diavola",MenuItem.ItemType.Pizze, 5));
        }
        
        RestaurantBillImpl r = new RestaurantBillImpl();
       assertEquals(65, r.getOrderPrice(itemsOrdered),0.0f);
     }
    
    @Test
    public void GetOrderPrice_MoreThan10PizzasAndTotalMoreThan100_Calculate() throws RestaurantBillException{
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
     public void GetOrderPrice_MoreThan10PizzasWithDifferentPriceAndTotalMoreThan100_Calculate() throws RestaurantBillException{
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
     public void GetOrderPrice_MoreThan10PizzasWithDifferentPriceAndTotalLessThan100_Calculate() throws RestaurantBillException{
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
     public void GetSetAmountOfMenuItem_OneMenuItem_Compare(){
    	 MenuItem menuItem = new MenuItem("Pasta",MenuItem.ItemType.Primi,35);
    	 
    	 menuItem.setAmount(99);
    	 double a = menuItem.getPrice();
    	 
    	 assertEquals(a, menuItem.getPrice(),0.0f);
     }
}
