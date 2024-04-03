package datamodels;

import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;

public class OrderDetailsItem {
    @SerializedName("ici")
    public boolean hasChoices;
    @SerializedName("ich")
    public String itemChoices;
    @SerializedName("inm")
    public String itemName;
    @SerializedName("ip2")
    public float itemPrice;
    @SerializedName("itq")
    public int itemQuantity;
    @SerializedName("sr")
    public String specialRequest;

    public String getItemPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.itemPrice);
    }

    public String getItemPriceWithoutCurrency() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.itemPrice, false);
    }
}
