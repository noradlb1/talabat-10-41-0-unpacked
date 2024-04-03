package datamodels;

import com.google.gson.annotations.SerializedName;

public class ReorderItemChoice {
    @SerializedName("ici")
    public int itemChoiceId;
    @SerializedName("icp")
    public float itemChoicePrice;
    @SerializedName("icq")
    public int itemChoiceQty;
    @SerializedName("inm")
    public String itemName;
    @SerializedName("ipid")
    public int itemParentId;
}
