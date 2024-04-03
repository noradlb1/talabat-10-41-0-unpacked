package JsonModels.Request.SplitRestaurantApiRequest;

import com.google.gson.annotations.SerializedName;

public class AllChoiceRequest {
    @SerializedName("MenuItemIds")
    String menuItemIds;

    public AllChoiceRequest(String str) {
        this.menuItemIds = str;
    }
}
