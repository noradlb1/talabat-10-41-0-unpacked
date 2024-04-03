package datamodels;

import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;

public class Offers {
    @SerializedName("bid")
    public int branchId;
    @SerializedName("bnm")
    public String branchName;
    @SerializedName("dsc")
    public String offerDescription;
    @SerializedName("pdetl")
    public OffersItem[] offersItem;
    @SerializedName("prc")
    public float price;
    @SerializedName("pty")
    public int promotionType;
    @SerializedName("rid")
    public int restaurantId;
    @SerializedName("rnm")
    public String restaurantName;
    @SerializedName("img")
    public String thumbnail;

    public String getOfferDescription() {
        return this.offersItem[0].description.trim();
    }

    public String getOfferTitle() {
        return this.offersItem[0].itemName.trim();
    }

    public String getPrice() {
        if (this.price > 0.0f) {
            return TalabatFormatter.getInstance().getFormattedCurrency(this.offersItem[0].price);
        }
        return "Price On Selection";
    }

    public int getPromotionType() {
        return this.offersItem[0].promotionType;
    }

    public int getRestaurantId() {
        return this.restaurantId;
    }

    public String getRestaurantLogo() {
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.thumbnail;
    }
}
