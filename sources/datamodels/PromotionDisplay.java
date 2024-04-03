package datamodels;

import com.google.gson.annotations.SerializedName;

public class PromotionDisplay {
    @SerializedName("couponId")
    public int couponId;
    @SerializedName("dsc")
    public String description;
    public boolean isExapanded;
    @SerializedName("inm")
    public String title;
}
