package datamodels;

import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;

public class OrderInfoPaging {
    private static final String ORDER_TYPE_DINE_OUT = "DineOut";
    @SerializedName("irt")
    public boolean IsRate;
    @SerializedName("irp")
    public boolean IsRepeat;
    @SerializedName("rsm")
    public int RatingSubmitted;
    @SerializedName("bid")
    public int branchId;
    @SerializedName("bnm")
    public String branchName;
    @SerializedName("dtm")
    public String deliveryTime;
    @SerializedName("dsc")
    public float discount;
    @SerializedName("grq")
    public String generalReq;
    @SerializedName("isds")
    public boolean isDarkStore;
    @SerializedName("rgrl")
    public boolean isGlrEnabled;
    @SerializedName("ismgrtd")
    public boolean isMigrated;
    @SerializedName("iord")
    public boolean isOldOrder;
    @SerializedName("ispr")
    public boolean isPreOrder;
    @SerializedName("itg")
    public Boolean isTgo;
    @SerializedName("ipt")
    public boolean isTracking = true;
    @SerializedName("itx")
    public String itemText;
    @SerializedName("eos")
    public int newOrderStatus = -5;
    public String oid;
    @SerializedName("ost")
    public boolean ordStatus;
    @SerializedName("recvdt")
    public String orderReceivedTime;
    @SerializedName("otp")
    public String orderType;
    @SerializedName("pym")
    public String payMethod;
    @SerializedName("preOrderDeliveryTime")
    public String preOrderDeliveryTime;
    @SerializedName("rfid")
    public int refId;
    @SerializedName("rid")
    public int restId;
    @SerializedName("rlg")
    public String restLogo;
    @SerializedName("rnm")
    public String restName;
    @SerializedName("rrt")
    public float restRating;
    @SerializedName("st")
    public float subTotal;
    @SerializedName("tot")
    public float total;

    public String getDisplayPrice() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.total);
    }

    public String getLogo() {
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.restLogo;
    }

    public boolean isDineOut() {
        return ORDER_TYPE_DINE_OUT.equals(this.orderType);
    }

    public boolean isPickup() {
        String str = this.orderType;
        return str != null && str.equalsIgnoreCase("pickup");
    }
}
