package JsonModels.Response.GEMResponse;

import com.google.gson.annotations.SerializedName;
import datamodels.Gem;
import datamodels.GemOfferItemsModel;

public class GemOfferResponse {
    @SerializedName("areaID")
    int areaId;
    @SerializedName("brandingMessage")
    public String brandingMessage;
    @SerializedName("collectionSubtitle")
    public String collectionSubtitle;
    @SerializedName("collectionTitle")
    public String collectionTitle;
    @SerializedName("expiryDateUTC")
    public String expiryDate;
    @SerializedName("offerItems")
    public GemOfferItemsModel[] gemOfferItems;
    @SerializedName("gemTiers")
    public Gem[] gemTiers;
    @SerializedName("message")
    public String message;
    @SerializedName("offerID")
    public String offerId;
    @SerializedName("offerItemDetails")
    private GemOfferItemsModel[] offerItemDetails;
    @SerializedName("remDuration")
    public float remDuration;

    public GemOfferItemsModel[] getGemOfferItemsDetails() {
        GemOfferItemsModel[] gemOfferItemsModelArr = this.gemOfferItems;
        return gemOfferItemsModelArr != null ? gemOfferItemsModelArr : this.offerItemDetails;
    }
}
