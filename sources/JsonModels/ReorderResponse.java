package JsonModels;

import JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse;
import com.google.gson.annotations.SerializedName;
import datamodels.ReorderItem;
import datamodels.ReorderItemStatus;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.List;

public class ReorderResponse {
    @SerializedName("cartId")
    public int cartId = -1;
    public String err;
    @SerializedName("isOrderModified")
    public boolean isReOrderModified = false;
    @SerializedName("reOrderModifications")
    public List<ReorderItemStatus> itemStatus = new ArrayList();
    @SerializedName("itms")
    public ReorderItem[] items;
    @SerializedName("rest")
    public Restaurant restaurant;
    @SerializedName("tgoDiscountData")
    public TgoFreeDeliveryResponse tgoFreeDeliveryResponse;

    public boolean hasCartId() {
        return this.cartId != -1;
    }

    public boolean hasItems() {
        ReorderItem[] reorderItemArr = this.items;
        return reorderItemArr != null && reorderItemArr.length > 0;
    }

    public boolean hasShop() {
        Restaurant restaurant2 = this.restaurant;
        return restaurant2 != null && restaurant2.f13872id > 0;
    }
}
