package datamodels;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ReorderItem {
    @SerializedName("ht")
    public boolean hasThumbnail;
    @SerializedName("idsc")
    public boolean isItemDiscounted;
    @SerializedName("ipr")
    public boolean isPromotionalItem;
    @SerializedName("iid")
    public int itemId;
    @SerializedName("iti")
    public String itemImage;
    @SerializedName("itn")
    public String itemName;
    @SerializedName("iop")
    public float itemOldPrice;
    @SerializedName("iprc")
    public float itemPrice;
    @SerializedName("itot")
    public float itemTotal;
    @SerializedName("lic")
    public ArrayList<ReorderItemChoice> lstItemsChoice;
    @SerializedName("pr")
    public float price;
    @SerializedName("qty")
    public int quantity;
    @SerializedName("rt")
    public int rating;
    @SerializedName("srq")
    public String specialReq;
}
