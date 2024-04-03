package datamodels;

import JsonModels.Response.OrderItem;
import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class TOrderResponse {
    @SerializedName("don")
    public String deliveryTime;
    @SerializedName("igo")
    public boolean isGemOrder;
    @SerializedName("ispr")
    public boolean isPreOrder;
    @SerializedName("itm")
    public OrderItem[] orderItems;
    @SerializedName("rfid")
    public int orderNumber;
    @SerializedName("oid")
    public String orderidEncypted;
    @SerializedName("pay")
    public OrderPaymentInfo paymentInfo;
    @SerializedName("pym")
    public String paymentMethod;
    @SerializedName("avgd")
    public String restaurantDeliveryTime;
    @SerializedName("rnm")
    public String restaurantName;
    @SerializedName("tot")
    public float total;
    @SerializedName("ocont")
    public String transactiionTime;
    @SerializedName("ocond")
    public String transactionDate;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TOrderResponse tOrderResponse = (TOrderResponse) obj;
        if (Float.compare(tOrderResponse.total, this.total) != 0 || this.orderNumber != tOrderResponse.orderNumber || this.isGemOrder != tOrderResponse.isGemOrder || this.isPreOrder != tOrderResponse.isPreOrder) {
            return false;
        }
        String str = this.restaurantName;
        if (str == null ? tOrderResponse.restaurantName != null : !str.equals(tOrderResponse.restaurantName)) {
            return false;
        }
        String str2 = this.paymentMethod;
        if (str2 == null ? tOrderResponse.paymentMethod != null : !str2.equals(tOrderResponse.paymentMethod)) {
            return false;
        }
        String str3 = this.transactionDate;
        if (str3 == null ? tOrderResponse.transactionDate != null : !str3.equals(tOrderResponse.transactionDate)) {
            return false;
        }
        String str4 = this.transactiionTime;
        if (str4 == null ? tOrderResponse.transactiionTime != null : !str4.equals(tOrderResponse.transactiionTime)) {
            return false;
        }
        String str5 = this.orderidEncypted;
        if (str5 == null ? tOrderResponse.orderidEncypted != null : !str5.equals(tOrderResponse.orderidEncypted)) {
            return false;
        }
        OrderPaymentInfo orderPaymentInfo = this.paymentInfo;
        if (orderPaymentInfo == null ? tOrderResponse.paymentInfo != null : !orderPaymentInfo.equals(tOrderResponse.paymentInfo)) {
            return false;
        }
        String str6 = this.deliveryTime;
        if (str6 == null ? tOrderResponse.deliveryTime != null : !str6.equals(tOrderResponse.deliveryTime)) {
            return false;
        }
        String str7 = this.restaurantDeliveryTime;
        if (str7 == null ? tOrderResponse.restaurantDeliveryTime == null : str7.equals(tOrderResponse.restaurantDeliveryTime)) {
            return Arrays.equals(this.orderItems, tOrderResponse.orderItems);
        }
        return false;
    }

    public String getDisplayOrderId() {
        return "" + this.orderNumber;
    }

    public String getDisplayTotal() {
        return TalabatFormatter.getInstance().getFormattedCurrency(this.total);
    }

    public String getDisplayTransactionTime() {
        return this.transactionDate + " " + this.transactiionTime;
    }

    public String getOrderId() {
        return this.orderidEncypted;
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
        String str = this.restaurantName;
        int i19 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i21 = i11 * 31;
        String str2 = this.paymentMethod;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i22 = (i21 + i12) * 31;
        float f11 = this.total;
        if (f11 != 0.0f) {
            i13 = Float.floatToIntBits(f11);
        } else {
            i13 = 0;
        }
        int i23 = (i22 + i13) * 31;
        String str3 = this.transactionDate;
        if (str3 != null) {
            i14 = str3.hashCode();
        } else {
            i14 = 0;
        }
        int i24 = (i23 + i14) * 31;
        String str4 = this.transactiionTime;
        if (str4 != null) {
            i15 = str4.hashCode();
        } else {
            i15 = 0;
        }
        int i25 = (((i24 + i15) * 31) + this.orderNumber) * 31;
        String str5 = this.orderidEncypted;
        if (str5 != null) {
            i16 = str5.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i25 + i16) * 31;
        OrderPaymentInfo orderPaymentInfo = this.paymentInfo;
        if (orderPaymentInfo != null) {
            i17 = orderPaymentInfo.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str6 = this.deliveryTime;
        if (str6 != null) {
            i18 = str6.hashCode();
        } else {
            i18 = 0;
        }
        int i28 = (i27 + i18) * 31;
        String str7 = this.restaurantDeliveryTime;
        if (str7 != null) {
            i19 = str7.hashCode();
        }
        return ((((((i28 + i19) * 31) + (this.isGemOrder ? 1 : 0)) * 31) + Arrays.hashCode(this.orderItems)) * 31) + (this.isPreOrder ? 1 : 0);
    }

    public String toString() {
        return "TOrderResponse{restaurantName='" + this.restaurantName + '\'' + ", paymentMethod='" + this.paymentMethod + '\'' + ", total=" + this.total + ", transactionDate='" + this.transactionDate + '\'' + ", transactiionTime='" + this.transactiionTime + '\'' + ", orderNumber=" + this.orderNumber + ", orderidEncypted='" + this.orderidEncypted + '\'' + ", paymentInfo=" + this.paymentInfo + ", deliveryTime='" + this.deliveryTime + '\'' + ", restaurantDeliveryTime='" + this.restaurantDeliveryTime + '\'' + ", isGemOrder=" + this.isGemOrder + ", orderItems=" + Arrays.toString(this.orderItems) + ", isPreOrder=" + this.isPreOrder + AbstractJsonLexerKt.END_OBJ;
    }
}
