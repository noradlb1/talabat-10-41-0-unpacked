package JsonModels.Response.ShopStatus;

import com.google.gson.annotations.SerializedName;

public class ShopStatusDeliveryDetails {
    @SerializedName("chain")
    public int chainId;
    @SerializedName("coverage")
    public int coverageAreaId;
    @SerializedName("final")
    public int deliveryAreaStatus;
    @SerializedName("vendor")
    public int vendorId;
}
