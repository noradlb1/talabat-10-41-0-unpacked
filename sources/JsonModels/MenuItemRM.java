package JsonModels;

import datamodels.MenuItem;
import datamodels.MenuSection;

public class MenuItemRM {
    public MenuSection[] menuSection;
    public MenuItem[] mostItems;

    public boolean isEmpty() {
        MenuSection[] menuSectionArr = this.menuSection;
        return menuSectionArr == null || menuSectionArr.length == 0;
    }
}
