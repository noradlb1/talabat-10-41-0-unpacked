package JsonModels.Response.ShopStatus;

import com.google.gson.annotations.SerializedName;

public class ShopStatusResult {
    @SerializedName("status")
    public ShopStatusDeliveryDetails shopStatusDeliveryDetails = new ShopStatusDeliveryDetails();
}
