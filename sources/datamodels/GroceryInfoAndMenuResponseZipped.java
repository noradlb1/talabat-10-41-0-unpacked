package datamodels;

import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.SplitRestaurantApiResponse.SplitMenuRM;

public class GroceryInfoAndMenuResponseZipped {
    MenuItemResponse menuItemResponse;
    SplitMenuRM splitMenuRM;

    public GroceryInfoAndMenuResponseZipped(MenuItemResponse menuItemResponse2, SplitMenuRM splitMenuRM2) {
        this.menuItemResponse = menuItemResponse2;
        this.splitMenuRM = splitMenuRM2;
    }

    public MenuItemResponse getMenuItemResponse() {
        return this.menuItemResponse;
    }

    public SplitMenuRM getSplitMenuRM() {
        return this.splitMenuRM;
    }
}
