////////////////////////////////////////////////////////////////////
// [Pardeep] [Singh] [1143264]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.business;

import java.util.Collection;
import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class RestaurantBillImpl implements RestaurantBill{

    @Override
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {
        double sconto = 0.05;
        //Non e' possibile avere un'ordinazione con più di 20 elementi
        if(itemsOrdered.size() > 20) {
            throw new RestaurantBillException();
        }
        double tot=0.0;
        double przPizzaMenoEcon=0.0;
        int contaPizze = 0;
        
        for (MenuItem menuItem : itemsOrdered) {
            tot+=menuItem.getPrice();
            if(menuItem.getType().equals(MenuItem.ItemType.Pizze)) {
                contaPizze++;
                //Se vengono ordinate più di 10 pizze la meno costosa e' in regalo
                if(contaPizze > 1) {
                    if(przPizzaMenoEcon > menuItem.getPrice()) {
                        przPizzaMenoEcon = menuItem.getPrice();
                    }
                }else {//trovata la prima pizza della lista
                    przPizzaMenoEcon = menuItem.getPrice();
                }
            }
        }
        
        //Se ci sono più di 10 pizze allora la meno costosa non conta
        if(contaPizze > 10) {
            tot-=przPizzaMenoEcon;
        }
        //Se l'importo totale delle ordinazioni (Pizze e primi) supera i 100€ viene fatto un 5% di sconto
        if(tot > 100.0) {
            tot=tot-sconto*tot;
        }
        
        return tot;
    }

}