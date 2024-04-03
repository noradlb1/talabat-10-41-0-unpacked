package datamodels;

import JsonModels.Response.GroceryResponse.GroceryItemsForSectionBrandModel;
import JsonModels.Response.GroceryResponse.GroceryItemsForSectionPagingInfo;
import JsonModels.Response.GroceryResponse.GroceryTagsModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class MenuSection {
    public boolean allItemsLoaded;
    public ArrayList<String> brandIds = new ArrayList<>();
    @SerializedName("brands")
    public GroceryItemsForSectionBrandModel[] brands;
    public MenuItem[] defaultItemsList;
    public GroceryItemsForSectionPagingInfo defaultItemsPagingInfo;
    public String filterBrands = "";
    @NotNull
    public GroceryTagsModel[] filteredGroceryTags;
    public boolean firstPageLoaded;
    public GroceryItemsForSectionPagingInfo groceryItemsForSectionPagingInfo;
    @SerializedName("tags")
    public GroceryTagsModel[] groceryTags;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f13863id;
    @SerializedName("dsc")
    public boolean isDiscounted;
    public int itemCount;
    @SerializedName("itm")
    public MenuItem[] items;
    @SerializedName("nm")

    /* renamed from: name  reason: collision with root package name */
    public String f13864name;
    public ArrayList<String> searchBrandIds = new ArrayList<>();
    public String sortCriteria = "";
    public String sortOrder = "";
    public GroceryItemsForSectionPagingInfo sortedItemsItemsPagingInfo;
    public MenuItem[] sortedItemsList;

    public static MenuSection copyMenuSectionWithOutItems(MenuSection menuSection) {
        MenuSection menuSection2 = new MenuSection();
        menuSection2.f13863id = menuSection.f13863id;
        menuSection2.f13864name = menuSection.f13864name;
        menuSection2.isDiscounted = menuSection.isDiscounted;
        menuSection2.itemCount = menuSection.itemCount;
        return menuSection2;
    }

    public void resetLocalCache() {
        this.sortedItemsList = null;
        this.sortedItemsItemsPagingInfo = new GroceryItemsForSectionPagingInfo();
        this.sortCriteria = "";
        this.filterBrands = "";
        this.sortOrder = "";
        this.brandIds = new ArrayList<>();
        this.searchBrandIds = new ArrayList<>();
    }

    public boolean showPercentage() {
        for (MenuItem menuItem : this.items) {
            if (menuItem.isPromotional) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Name :" + this.f13864name;
    }
}
