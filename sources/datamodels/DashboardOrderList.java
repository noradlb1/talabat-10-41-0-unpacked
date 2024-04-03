package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;

public class DashboardOrderList {
    @SerializedName("oid")
    public String encryptedOrderId;
    @SerializedName("itn")
    public String firstItemName;
    @SerializedName("qty")
    public String firstItemQuantity;
    @SerializedName("isds")
    public boolean isDarkStore;
    @SerializedName("rgrl")
    public boolean isGlrEnabled;
    @SerializedName("iord")
    public boolean isOldOrder;
    @SerializedName("israted")
    public boolean isOrderRated;
    @SerializedName("ispr")
    public boolean isPreOrder;
    @SerializedName("srp")
    public boolean isTimePassedToRate;
    @SerializedName("ipt")
    public boolean isTracking = true;
    @SerializedName("eos")
    public int newOrderStatus = -5;
    @SerializedName("iid")
    public String orderId;
    @SerializedName("recvdt")
    public String orderReceivedTime;
    @SerializedName("ost")
    public boolean orderStatus;
    @SerializedName("odt")
    public String orderTime;
    @SerializedName("rid")
    public int restaurantId;
    @SerializedName("rlg")
    public String restaurantLogoName;
    @SerializedName("rnm")
    public String restaurantName;
    @SerializedName("ic")
    public String totalItems;
    @SerializedName("tot")
    public float totalOrderCost;

    public String getLogo() {
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.restaurantLogoName;
    }
}
