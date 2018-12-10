////////////////////////////////////////////////////////////////////
// [Pardeep] [Singh] [1143264]
////////////////////////////////////////////////////////////////////
package it.unipd.tos;

import java.util.ArrayList;
import java.util.List;

import it.unipd.tos.business.RestaurantBillImpl;
import it.unipd.tos.model.MenuItem;

public class App 
{
    //args: nome delle pietanze
    public static void main( String[] args )
    {
        RestaurantBillImpl restaurantBillImpl = new RestaurantBillImpl();
        List<MenuItem> menuItems = new ArrayList<>();
        for (String s : args) {
            menuItems.add(new MenuItem("Prova",MenuItem.ItemType.Pizze,2));
        }
    }
}
