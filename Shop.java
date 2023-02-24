import java.util.*;
public class Shop {
    private boolean isOpen = false;
    private boolean hasPeople = false;
    private String storeName;
    private ArrayList<String> menu = new ArrayList<String>(); 
    private String menuList = "";

    public Shop(String storeName) {
        this.storeName = storeName;
    }
    
    public boolean getShopStatus() {
        return isOpen;
    }
    
    public void changeShop() {
        if (isOpen == true) {
            isOpen = false;
        }
        else if (isOpen == false) {
            isOpen = true;
        }
    }
    public void addPeople() {
        hasPeople = true;
    }
    public boolean hasPer() {
        return hasPeople;
    }
    public void createMenu() {
        menu.add("Affogato");
        menu.add("Americano");
        menu.add("Caffè Latte");
        menu.add("Caffeè Mocha");
        menu.add("Cappuccino");
        menu.add("Doppio");
    }
    
    public String getMenu() {
    for(int x = 0; x < menu.size() - 1; x++)
            menuList += menu.get(x) + "\n";
    menuList += menu.get(menu.size() - 1);
    return menuList;
    }
    
    public ArrayList<String> getArrayMenu() {
        return menu;
    }
    
          
    
}