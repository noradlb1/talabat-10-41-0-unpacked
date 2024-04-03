package datamodels;

import com.google.gson.annotations.SerializedName;

public class DeliveryArea extends Area {
    @SerializedName("brh")
    public int branchCount;
    @SerializedName("bid")
    public int branchId;
    @SerializedName("rgrl")
    public boolean isGlrEnabled;
    @SerializedName("moa")
    public float minimumOrderAmount;
}
