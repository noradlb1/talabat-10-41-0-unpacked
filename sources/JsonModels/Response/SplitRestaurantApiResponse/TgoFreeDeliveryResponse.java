package JsonModels.Response.SplitRestaurantApiResponse;

import com.google.gson.annotations.SerializedName;

public class TgoFreeDeliveryResponse {
    @SerializedName("tgoDiscTiers")
    public TgoDiscountTierModel[] discountTierArray;
    public int tgoUserType;
}
