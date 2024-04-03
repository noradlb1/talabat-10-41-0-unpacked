package datamodels;

import com.google.gson.annotations.SerializedName;

public class RestaurantUpselling {
    @SerializedName("dsc")
    public String upSellingItemDesc;
    @SerializedName("img")
    public String upSellingItemLogo;
    @SerializedName("nm")
    public String upSellingItemName;
    @SerializedName("pr")
    public String upSellingItemPrice;
    @SerializedName("id")
    public int upSellingItemid;

    public RestaurantUpselling(int i11, String str, String str2, String str3, String str4) {
        this.upSellingItemid = i11;
        this.upSellingItemName = str;
        this.upSellingItemLogo = str2;
        this.upSellingItemPrice = str3;
        this.upSellingItemDesc = str4;
    }

    public String getUpSellingImg() {
        String replaceAll = this.upSellingItemLogo.replaceAll(" ", "%20");
        this.upSellingItemLogo = replaceAll;
        return replaceAll;
    }

    public String getUpSellingItemLogo() {
        return this.upSellingItemLogo;
    }

    public String getUpSellingItemName() {
        return this.upSellingItemName;
    }

    public String getUpSellingItemPrice() {
        return this.upSellingItemPrice;
    }

    public int getUpSellingItemid() {
        return this.upSellingItemid;
    }

    public void setUpSellingItemLogo(String str) {
        this.upSellingItemLogo = str;
    }

    public void setUpSellingItemName(String str) {
        this.upSellingItemName = str;
    }

    public void setUpSellingItemPrice(String str) {
        this.upSellingItemPrice = str;
    }

    public void setUpSellingItemid(int i11) {
        this.upSellingItemid = i11;
    }
}
