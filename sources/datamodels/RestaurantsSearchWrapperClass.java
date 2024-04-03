package datamodels;

import JsonModels.Response.ItemSearchResponse;
import java.util.ArrayList;

public class RestaurantsSearchWrapperClass {
    private String mHeaderText;
    private int mItemCount;
    private ArrayList<ItemSearchResponse> mMenuItems;
    private Restaurant mRestaurant;
    private int mType;

    public static class SEARCH_RESULT_TYPE {
        public static final int headerItems = 3;
        public static final int headerRestaurant = 2;
        public static final int menuItem = 1;
        public static final int restaurant = 0;
    }

    public RestaurantsSearchWrapperClass(Restaurant restaurant, ArrayList<ItemSearchResponse> arrayList, String str, int i11, int i12) {
        this.mRestaurant = restaurant;
        this.mMenuItems = arrayList;
        this.mHeaderText = str;
        this.mItemCount = i11;
        this.mType = i12;
    }

    public String getHeaderText() {
        return this.mHeaderText;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public ArrayList<ItemSearchResponse> getMenuItem() {
        return this.mMenuItems;
    }

    public Restaurant getRestaurant() {
        return this.mRestaurant;
    }

    public int getType() {
        return this.mType;
    }
}
