package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class RateOrderReq {
    public int ItemsRating;
    @SerializedName("branchId")
    public int branchId;
    @SerializedName("canRate")
    public boolean canRate;
    public float deliveryRating;
    @SerializedName("driverRating")
    public float driverRating;
    @SerializedName("message")
    public String errorMessage;
    public int eststatus;
    @SerializedName("idre")
    public boolean isDriverRateEnabled;
    @SerializedName("idrm")
    public boolean isDriverRateMandatory;
    public RateOrderItem[] items;
    public String ordId;
    @SerializedName("roid")
    public String orderID;
    @SerializedName("ocon")
    public String orderPlacedDate;
    @SerializedName("orst")
    public String orderStatus;
    @SerializedName("otherDrReason")
    public String otherDriverReason;
    public float packageRating;
    @SerializedName("drt")
    public ArrayList<RateTag> rateTags;
    public boolean ratingSubmitted;
    public String restId;
    public String restLogo;
    public String restName;
    public String review;
    @SerializedName("selectedDrtIds")
    public ArrayList<Integer> selectedDrivertIds;
    public float totalRating;
    @SerializedName("transactionId")
    public int transactionId;
    public float valueRating;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RateOrderReq rateOrderReq = (RateOrderReq) obj;
        if (Float.compare(rateOrderReq.packageRating, this.packageRating) != 0 || Float.compare(rateOrderReq.deliveryRating, this.deliveryRating) != 0 || Float.compare(rateOrderReq.valueRating, this.valueRating) != 0 || Float.compare(rateOrderReq.totalRating, this.totalRating) != 0 || this.ratingSubmitted != rateOrderReq.ratingSubmitted || this.ItemsRating != rateOrderReq.ItemsRating || this.eststatus != rateOrderReq.eststatus || this.canRate != rateOrderReq.canRate || this.branchId != rateOrderReq.branchId || this.transactionId != rateOrderReq.transactionId || this.isDriverRateEnabled != rateOrderReq.isDriverRateEnabled || this.isDriverRateMandatory != rateOrderReq.isDriverRateMandatory || Float.compare(rateOrderReq.driverRating, this.driverRating) != 0 || !Objects.equals(this.ordId, rateOrderReq.ordId) || !Objects.equals(this.restId, rateOrderReq.restId) || !Objects.equals(this.review, rateOrderReq.review) || !Arrays.equals(this.items, rateOrderReq.items) || !Objects.equals(this.restName, rateOrderReq.restName) || !Objects.equals(this.restLogo, rateOrderReq.restLogo) || !Objects.equals(this.errorMessage, rateOrderReq.errorMessage) || !Objects.equals(this.orderStatus, rateOrderReq.orderStatus) || !Objects.equals(this.orderID, rateOrderReq.orderID) || !Objects.equals(this.orderPlacedDate, rateOrderReq.orderPlacedDate) || !Objects.equals(this.rateTags, rateOrderReq.rateTags) || !Objects.equals(this.otherDriverReason, rateOrderReq.otherDriverReason) || !Objects.equals(this.selectedDrivertIds, rateOrderReq.selectedDrivertIds)) {
            return false;
        }
        return true;
    }

    public String getLogo() {
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.restLogo;
    }

    public int hashCode() {
        return (Objects.hash(new Object[]{this.ordId, this.restId, Float.valueOf(this.packageRating), Float.valueOf(this.deliveryRating), Float.valueOf(this.valueRating), Float.valueOf(this.totalRating), this.review, this.restName, this.restLogo, Boolean.valueOf(this.ratingSubmitted), Integer.valueOf(this.ItemsRating), Integer.valueOf(this.eststatus), Boolean.valueOf(this.canRate), this.errorMessage, this.orderStatus, this.orderID, this.orderPlacedDate, Integer.valueOf(this.branchId), Integer.valueOf(this.transactionId), Boolean.valueOf(this.isDriverRateEnabled), Boolean.valueOf(this.isDriverRateMandatory), this.rateTags, Float.valueOf(this.driverRating), this.otherDriverReason, this.selectedDrivertIds}) * 31) + Arrays.hashCode(this.items);
    }

    public String toString() {
        return "RateOrderReq{ordId='" + this.ordId + '\'' + ", restId='" + this.restId + '\'' + ", packageRating=" + this.packageRating + ", deliveryRating=" + this.deliveryRating + ", valueRating=" + this.valueRating + ", totalRating=" + this.totalRating + ", review='" + this.review + '\'' + ", items=" + Arrays.toString(this.items) + ", restName='" + this.restName + '\'' + ", restLogo='" + this.restLogo + '\'' + ", ratingSubmitted=" + this.ratingSubmitted + ", ItemsRating=" + this.ItemsRating + ", eststatus=" + this.eststatus + ", canRate=" + this.canRate + ", errorMessage='" + this.errorMessage + '\'' + ", orderStatus='" + this.orderStatus + '\'' + ", orderID='" + this.orderID + '\'' + ", orderPlacedDate='" + this.orderPlacedDate + '\'' + ", branchId=" + this.branchId + ", transactionId=" + this.transactionId + ", isDriverRateEnabled=" + this.isDriverRateEnabled + ", isDriverRateMandatory=" + this.isDriverRateMandatory + ", rateTags=" + this.rateTags + ", driverRating=" + this.driverRating + ", otherDriverReason='" + this.otherDriverReason + '\'' + ", selectedDrivertIds=" + this.selectedDrivertIds + AbstractJsonLexerKt.END_OBJ;
    }
}
