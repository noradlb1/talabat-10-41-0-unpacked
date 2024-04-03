package datamodels;

import java.util.ArrayList;

public class GroceryHorizontalRowDataModel {
    private boolean hasShowMore;
    private ArrayList<MenuItem> menuItems;
    private MenuSection menuSection;

    public ArrayList<MenuItem> getAllMenuItems() {
        return this.menuItems;
    }

    public MenuSection getMenuSection() {
        return this.menuSection;
    }

    public boolean hasShowMore() {
        return this.hasShowMore;
    }

    public void setAllMenuItems(ArrayList<MenuItem> arrayList) {
        this.menuItems = arrayList;
    }

    public void setMenuSection(MenuSection menuSection2) {
        this.menuSection = menuSection2;
    }

    public void setShowMore(boolean z11) {
        this.hasShowMore = z11;
    }
}
