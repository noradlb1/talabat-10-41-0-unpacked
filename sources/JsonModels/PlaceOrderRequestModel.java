package JsonModels;

import androidx.annotation.VisibleForTesting;
import com.google.gson.annotations.SerializedName;
import com.talabat.domain.address.Address;
import datamodels.TransactionCart;
import datamodels.TransactionRestaurant;
import java.util.HashMap;
import java.util.Map;

public class PlaceOrderRequestModel {
    @SerializedName("addtPayMethod")
    public int additionalPaymentMethod;
    public Address address;
    @SerializedName("AgeLimit")
    public String ageLimit;
    private boolean allowDuplicateOrder;
    public String appboyUserId;
    /* access modifiers changed from: private */
    public TransactionCart cart;
    private String cname;
    public int countryId;
    private String deliveryTime;
    public String deviceId;
    private String firstname;
    @SerializedName("hasScheduledDeliveryDiscount")
    public boolean hasScheduledDeliveryDiscount;
    @SerializedName("irc")
    public boolean isContactLess;
    @SerializedName("isDS")
    public boolean isDarkStore;
    public boolean isGoGreen;
    @SerializedName("ItemUnavailabilityAction")
    public String itemUnavailabilityAction;
    private String lastname;
    public double latitude;
    public double longitude;
    /* access modifiers changed from: private */
    public int orderType;
    private float payBy6alabat;
    private float payByCredit;
    private float payByDebit;
    private int paymentMethod;
    private Double riderTip;

    public PlaceOrderRequestModel(int i11, String str, float f11, float f12, float f13, Address address2, TransactionCart transactionCart, boolean z11, String str2, int i12, boolean z12, String str3, int i13, boolean z13, String str4, Double d11, boolean z14) {
        this.paymentMethod = i11;
        this.deliveryTime = str;
        this.payBy6alabat = f11;
        this.payByDebit = f12;
        this.payByCredit = f13;
        this.address = address2;
        this.cart = transactionCart;
        this.allowDuplicateOrder = z11;
        this.appboyUserId = str2;
        this.additionalPaymentMethod = i12;
        this.isGoGreen = z12;
        this.deviceId = str3;
        this.countryId = i13;
        this.isContactLess = z13;
        this.riderTip = d11;
        this.hasScheduledDeliveryDiscount = z14;
        setOrderType(str4);
    }

    public TransactionCart getCart() {
        return this.cart;
    }

    public int getOrderType() {
        return this.orderType;
    }

    @VisibleForTesting
    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public Map<String, String> getPlaceOrderEventData() {
        return new HashMap<String, String>(this.cart.getRestaurant()) {
            final /* synthetic */ TransactionRestaurant val$restaurant;

            {
                this.val$restaurant = r4;
                put("countryId", String.valueOf(PlaceOrderRequestModel.this.countryId));
                put("isDS", String.valueOf(PlaceOrderRequestModel.this.isDarkStore));
                put("appBoyUserId", PlaceOrderRequestModel.this.appboyUserId);
                put("cityId", String.valueOf(PlaceOrderRequestModel.this.address.cityId));
                put("areaId", String.valueOf(PlaceOrderRequestModel.this.cart.getAreaId()));
                put("latitude", String.valueOf(PlaceOrderRequestModel.this.latitude));
                put("longitude", String.valueOf(PlaceOrderRequestModel.this.longitude));
                put("totalAmount", String.valueOf(PlaceOrderRequestModel.this.cart.getTotalAmount()));
                put("orderType", String.valueOf(PlaceOrderRequestModel.this.orderType));
                if (r4 != null) {
                    put("branchId", String.valueOf(r4.branchId));
                    put("branchName", r4.branchName);
                    put("restId", String.valueOf(r4.restId));
                    put("restName", r4.restName);
                    put("dijiniVendorId", r4.getDijiniVendorId());
                    put("darkStoreCartId", r4.getDarkStoreCartId());
                }
            }
        };
    }

    public void setAddress(Address address2) {
        this.address = address2;
    }

    public void setAgeLimit(String str) {
        this.ageLimit = str;
    }

    public void setAllowDuplicateOrder(boolean z11) {
        this.allowDuplicateOrder = z11;
    }

    public void setCart(TransactionCart transactionCart) {
        this.cart = transactionCart;
    }

    public void setDarkStore(boolean z11) {
        this.isDarkStore = z11;
    }

    public void setItemUnavailabilityAction(String str) {
        this.itemUnavailabilityAction = str;
    }

    public void setOrderType(String str) {
        if (str.equals("pickup")) {
            this.orderType = 1;
        } else {
            this.orderType = 0;
        }
    }

    public PlaceOrderRequestModel(String str, String str2, String str3, int i11, String str4, float f11, float f12, float f13, Address address2, TransactionCart transactionCart, boolean z11, String str5, int i12, boolean z12, String str6, int i13, boolean z13, String str7, Double d11, boolean z14) {
        this.paymentMethod = i11;
        this.deliveryTime = str4;
        this.payBy6alabat = f11;
        this.payByDebit = f12;
        this.payByCredit = f13;
        this.address = address2;
        this.cart = transactionCart;
        this.allowDuplicateOrder = z11;
        this.firstname = str;
        this.lastname = str2;
        this.cname = str3;
        this.appboyUserId = str5;
        this.additionalPaymentMethod = i12;
        this.isGoGreen = z12;
        this.deviceId = str6;
        this.countryId = i13;
        this.isContactLess = z13;
        this.riderTip = d11;
        this.hasScheduledDeliveryDiscount = z14;
        setOrderType(str7);
    }
}
