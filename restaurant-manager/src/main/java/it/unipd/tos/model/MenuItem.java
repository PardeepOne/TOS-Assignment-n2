////////////////////////////////////////////////////////////////////
// [Pardeep] [Singh] [1143264]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {

    private String name;

    //private ItemType itemType;
    public static enum ItemType {
        Pizze,
        Primi
    }


    private double price;
    private ItemType itemType;

    public MenuItem(String name, ItemType type, double price) {
        super();
        this.name = name;
        this.itemType = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemType getType() {
        return itemType;
    }

    public void setType(ItemType type) {
        this.itemType = type;
    }

    public double getPrice() {
        return price;
    }

    public void setAmount(double price) {
        this.price = price;
    }
    
}
