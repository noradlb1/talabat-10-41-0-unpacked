package datamodels;

import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;

public class MostRecentOrderList {
    @SerializedName("bid")
    public int branchId;
    @SerializedName("oid")
    public String encryptedOrderId;
    @SerializedName("estx")
    public String estimatedDeliveryExTime;
    @SerializedName("est")
    public String estimatedDeliveryTime;
    @SerializedName("itn")
    public String firstItemName;
    @SerializedName("qty")
    public String firstItemQuantity;
    @SerializedName("rgrl")
    public boolean isGlrEnabled;
    @SerializedName("iord")
    public boolean isOldOrder;
    @SerializedName("ispr")
    public boolean isPreOrder;
    @SerializedName("israted")
    public boolean isRated = false;
    @SerializedName("itg")
    public boolean isTgo = false;
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
    @SerializedName("pmt")
    public int paymentMethod;
    @SerializedName("preOrderDeliveryTime")
    public String preOrderDeliveryTime;
    @SerializedName("rid")
    public int restaurantId;
    @SerializedName("rlg")
    public String restaurantLogoName;
    @SerializedName("restMobile")
    public String restaurantMobile;
    @SerializedName("rnm")
    public String restaurantName;
    @SerializedName("ic")
    public String totalItems;
    @SerializedName("tot")
    public float totalOrderCost;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MostRecentOrderList mostRecentOrderList = (MostRecentOrderList) obj;
        if (this.restaurantId != mostRecentOrderList.restaurantId || this.orderStatus != mostRecentOrderList.orderStatus || Float.compare(mostRecentOrderList.totalOrderCost, this.totalOrderCost) != 0 || this.newOrderStatus != mostRecentOrderList.newOrderStatus || this.isTracking != mostRecentOrderList.isTracking || this.isGlrEnabled != mostRecentOrderList.isGlrEnabled || this.isOldOrder != mostRecentOrderList.isOldOrder || this.isPreOrder != mostRecentOrderList.isPreOrder || this.paymentMethod != mostRecentOrderList.paymentMethod || this.branchId != mostRecentOrderList.branchId) {
            return false;
        }
        String str = this.encryptedOrderId;
        if (str == null ? mostRecentOrderList.encryptedOrderId != null : !str.equals(mostRecentOrderList.encryptedOrderId)) {
            return false;
        }
        String str2 = this.restaurantName;
        if (str2 == null ? mostRecentOrderList.restaurantName != null : !str2.equals(mostRecentOrderList.restaurantName)) {
            return false;
        }
        String str3 = this.restaurantLogoName;
        if (str3 == null ? mostRecentOrderList.restaurantLogoName != null : !str3.equals(mostRecentOrderList.restaurantLogoName)) {
            return false;
        }
        String str4 = this.orderTime;
        if (str4 == null ? mostRecentOrderList.orderTime != null : !str4.equals(mostRecentOrderList.orderTime)) {
            return false;
        }
        String str5 = this.orderId;
        if (str5 == null ? mostRecentOrderList.orderId != null : !str5.equals(mostRecentOrderList.orderId)) {
            return false;
        }
        String str6 = this.firstItemName;
        if (str6 == null ? mostRecentOrderList.firstItemName != null : !str6.equals(mostRecentOrderList.firstItemName)) {
            return false;
        }
        String str7 = this.firstItemQuantity;
        if (str7 == null ? mostRecentOrderList.firstItemQuantity != null : !str7.equals(mostRecentOrderList.firstItemQuantity)) {
            return false;
        }
        String str8 = this.totalItems;
        if (str8 == null ? mostRecentOrderList.totalItems != null : !str8.equals(mostRecentOrderList.totalItems)) {
            return false;
        }
        String str9 = this.orderReceivedTime;
        if (str9 == null ? mostRecentOrderList.orderReceivedTime != null : !str9.equals(mostRecentOrderList.orderReceivedTime)) {
            return false;
        }
        String str10 = this.estimatedDeliveryTime;
        if (str10 == null ? mostRecentOrderList.estimatedDeliveryTime != null : !str10.equals(mostRecentOrderList.estimatedDeliveryTime)) {
            return false;
        }
        String str11 = this.estimatedDeliveryExTime;
        if (str11 == null ? mostRecentOrderList.estimatedDeliveryExTime != null : !str11.equals(mostRecentOrderList.estimatedDeliveryExTime)) {
            return false;
        }
        String str12 = this.restaurantMobile;
        if (str12 == null ? mostRecentOrderList.restaurantMobile != null : !str12.equals(mostRecentOrderList.restaurantMobile)) {
            return false;
        }
        String str13 = this.preOrderDeliveryTime;
        if (str13 != null) {
            return str13.equals(mostRecentOrderList.preOrderDeliveryTime);
        }
        if (mostRecentOrderList.preOrderDeliveryTime == null) {
            return true;
        }
        return false;
    }

    public boolean firstItemExists() {
        if (TalabatUtils.isNullOrEmpty(getFirstItemQuantity()) || TalabatUtils.isNullOrEmpty(getFirstItemName())) {
            return false;
        }
        return true;
    }

    public String getFirstItemName() {
        if (!TalabatUtils.isNullOrEmpty(this.firstItemName)) {
            return this.firstItemName;
        }
        return "";
    }

    public String getFirstItemQuantity() {
        if (!TalabatUtils.isNullOrEmpty(this.firstItemQuantity)) {
            return this.firstItemQuantity;
        }
        return "";
    }

    public String getLogo() {
        return GlobalDataModel.imageBaseUrl + "restaurants/" + this.restaurantLogoName;
    }

    public Integer getTotalItemsCount() {
        if (!TalabatUtils.isNullOrEmpty(this.totalItems)) {
            return Integer.valueOf(Integer.parseInt(this.totalItems));
        }
        return 0;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        int i23;
        int i24;
        String str = this.encryptedOrderId;
        int i25 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i26 = ((i11 * 31) + this.restaurantId) * 31;
        String str2 = this.restaurantName;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i27 = (i26 + i12) * 31;
        String str3 = this.restaurantLogoName;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i28 = (i27 + i13) * 31;
        String str4 = this.orderTime;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i29 = (((i28 + i14) * 31) + (this.orderStatus ? 1 : 0)) * 31;
        String str5 = this.orderId;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i31 = (i29 + i15) * 31;
        String str6 = this.firstItemName;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i32 = (i31 + i16) * 31;
        String str7 = this.firstItemQuantity;
        if (str7 != null) {
            i17 = str7.hashCode();
        } else {
            i17 = 0;
        }
        int i33 = (i32 + i17) * 31;
        float f11 = this.totalOrderCost;
        if (f11 != 0.0f) {
            i18 = Float.floatToIntBits(f11);
        } else {
            i18 = 0;
        }
        int i34 = (i33 + i18) * 31;
        String str8 = this.totalItems;
        if (str8 != null) {
            i19 = str8.hashCode();
        } else {
            i19 = 0;
        }
        int i35 = (((((((i34 + i19) * 31) + this.newOrderStatus) * 31) + (this.isTracking ? 1 : 0)) * 31) + (this.isGlrEnabled ? 1 : 0)) * 31;
        String str9 = this.orderReceivedTime;
        if (str9 != null) {
            i21 = str9.hashCode();
        } else {
            i21 = 0;
        }
        int i36 = (((((((((i35 + i21) * 31) + (this.isOldOrder ? 1 : 0)) * 31) + (this.isPreOrder ? 1 : 0)) * 31) + this.paymentMethod) * 31) + this.branchId) * 31;
        String str10 = this.estimatedDeliveryTime;
        if (str10 != null) {
            i22 = str10.hashCode();
        } else {
            i22 = 0;
        }
        int i37 = (i36 + i22) * 31;
        String str11 = this.estimatedDeliveryExTime;
        if (str11 != null) {
            i23 = str11.hashCode();
        } else {
            i23 = 0;
        }
        int i38 = (i37 + i23) * 31;
        String str12 = this.restaurantMobile;
        if (str12 != null) {
            i24 = str12.hashCode();
        } else {
            i24 = 0;
        }
        int i39 = (i38 + i24) * 31;
        String str13 = this.preOrderDeliveryTime;
        if (str13 != null) {
            i25 = str13.hashCode();
        }
        return i39 + i25;
    }

    public boolean isOrderCancelled() {
        return !this.orderStatus;
    }
}
