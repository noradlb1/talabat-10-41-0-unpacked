package JsonModels.Response;

import com.google.gson.annotations.SerializedName;
import datamodels.Restaurant;
import java.util.ArrayList;

public class RestaurantSearchResponse {
    @SerializedName("bid")
    public int branchId;
    @SerializedName("mitmcnt")
    public int itemCount;
    @SerializedName("mitms")
    public ArrayList<ItemSearchResponse> menuItems;
    public Restaurant restaurant;
    @SerializedName("rnm_ar")
    public String restaurantNameAr;
    @SerializedName("rnm_en")
    public String restaurantNameEn;

    public boolean equals(Object obj) {
        if (!(obj instanceof RestaurantSearchResponse) || ((RestaurantSearchResponse) obj).restaurant.getBranchId() != this.restaurant.getBranchId()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return 119 + this.restaurant.getBranchId();
    }
}
