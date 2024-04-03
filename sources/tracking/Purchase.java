package tracking;

import com.talabat.helpers.TalabatUtils;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragmentKt;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import datamodels.CartMenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class Purchase {
    private String CouponAmount = "";
    private String CouponId = "";
    private String PaymentMethod = "";
    private String VoucherAmount = "";
    private String VoucherCode = "";
    private ArrayList<CartMenuItem> cart;
    private String cuisine1;
    private String deliveryAddress;
    private String deliveryCharges = "";
    private String displayOrderId = "";
    private String encyptedTransactionId = "";
    private boolean isFirstOrder = false;
    private boolean isFirstOrderFromApp = false;
    private boolean isPurchaseEventsEnabled = false;
    private String mobileCountryCode;
    private String mobileNumber;
    private String offerCampaignId;
    private String offerVoucherId;
    private Restaurant restaurant;
    private String restaurantName = "";
    private double riderTip;
    private String secondaryCuisinesString;
    private float tax = 0.0f;
    private String total = "";
    private String transId = "";
    private float usedTalabatCredit;
    private String voucherType = "normal";

    public String getAddress() {
        return this.deliveryAddress;
    }

    public ArrayList<CartMenuItem> getCart() {
        return this.cart;
    }

    public String getCouponAmount() {
        return this.CouponAmount;
    }

    public String getCouponId() {
        return this.CouponId;
    }

    public String getCuisine1() {
        return this.cuisine1;
    }

    public String getDelCharges() {
        return this.deliveryCharges.isEmpty() ? "0.0" : this.deliveryCharges;
    }

    public String getDisplayOrderId() {
        return this.displayOrderId;
    }

    public String getEncyptedTransactionId() {
        return this.encyptedTransactionId;
    }

    public String getMobileCountryCode() {
        return this.mobileCountryCode;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getOfferCampaignId() {
        return this.offerCampaignId;
    }

    public String getOfferVoucherId() {
        return this.offerVoucherId;
    }

    public String getPaymentMethod() {
        return this.PaymentMethod;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public double getRiderTip() {
        return this.riderTip;
    }

    public String getSecondaryCuisines() {
        return this.secondaryCuisinesString;
    }

    public String getTax() {
        return Float.toString(this.tax);
    }

    public String getTotal() {
        return this.total;
    }

    public String getTransactionId() {
        return this.transId;
    }

    public float getUsedTalabatCredit() {
        return this.usedTalabatCredit;
    }

    public String getVoucherAmount() {
        return this.VoucherAmount;
    }

    public String getVoucherCode() {
        return this.VoucherCode;
    }

    public String getVoucherType() {
        return this.voucherType;
    }

    public boolean isFirstOrder() {
        return this.isFirstOrder;
    }

    public boolean isFirstOrderFromApp() {
        return this.isFirstOrderFromApp;
    }

    public boolean isPurchaseEventsEnabled() {
        return this.isPurchaseEventsEnabled;
    }

    public boolean isReorder() {
        return !isFirstOrder();
    }

    public boolean isVoucherApplied() {
        return !this.VoucherCode.equals("");
    }

    public void setAddress(String str) {
        this.deliveryAddress = str;
    }

    public void setCart(ArrayList<CartMenuItem> arrayList) {
        ArrayList<CartMenuItem> arrayList2 = new ArrayList<>();
        this.cart = arrayList2;
        arrayList2.addAll(arrayList);
    }

    public void setCoupon(String str, String str2) {
        this.CouponId = str;
        this.CouponAmount = str2;
    }

    public void setCuisine1(String str) {
        this.cuisine1 = str;
    }

    public void setDelCharges(String str) {
        this.deliveryCharges = str;
    }

    public void setDisplayOrderId(String str) {
        this.displayOrderId = str;
    }

    public void setEncyptedTransactionId(String str) {
        this.encyptedTransactionId = str;
    }

    public void setFirstOrder(boolean z11) {
        this.isFirstOrder = z11;
    }

    public void setMobileCountryCode(String str) {
        this.mobileCountryCode = str;
    }

    public void setMobileNumber(String str) {
        this.mobileNumber = str;
    }

    public void setMunciplityTax(float f11) {
        this.tax += f11;
    }

    public void setOfferCampaignId(String str) {
        this.offerCampaignId = str;
    }

    public void setOfferVoucherId(String str) {
        this.offerVoucherId = str;
    }

    public void setPaymentMethod(String str) {
        this.PaymentMethod = str;
    }

    public void setPurchaseEventsEnabled(boolean z11) {
        this.isPurchaseEventsEnabled = z11;
    }

    public void setRestaurant(Restaurant restaurant2) {
        this.restaurant = restaurant2;
    }

    public void setRiderTip(double d11) {
        this.riderTip = d11;
    }

    public void setSecondaryCuisines(String[] strArr) {
        String str;
        String str2;
        if (strArr != null) {
            for (int i11 = 0; i11 < strArr.length; i11++) {
                if (i11 == 0) {
                    if (!TalabatUtils.isNullOrEmpty(strArr[0])) {
                        str2 = strArr[0];
                    } else {
                        str2 = "";
                    }
                    this.secondaryCuisinesString = str2;
                } else if (!TalabatUtils.isNullOrEmpty(strArr[i11])) {
                    if (!TalabatUtils.isNullOrEmpty(this.secondaryCuisinesString)) {
                        str = this.secondaryCuisinesString + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + strArr[i11];
                    } else {
                        str = strArr[i11];
                    }
                    this.secondaryCuisinesString = str;
                }
            }
        }
    }

    public void setTotal(String str) {
        this.total = str;
    }

    public void setTouristTax(float f11) {
        this.tax += f11;
    }

    public void setTransactionId(String str) {
        this.transId = str;
    }

    public void setUsedTalabatCredit(float f11) {
        this.usedTalabatCredit = f11;
    }

    public void setVoucher(String str, String str2) {
        this.VoucherCode = str;
        this.VoucherAmount = str2;
    }

    public void setVoucherType(String str) {
        this.voucherType = str;
    }

    public void setPaymentMethod(int i11, boolean z11, int i12) {
        if (i11 == 0) {
            this.PaymentMethod = "cash";
        } else if (i11 == 1) {
            this.PaymentMethod = "debit_card";
        } else if (i11 == 2) {
            if (z11) {
                this.PaymentMethod = "visa_checkout";
            } else {
                this.PaymentMethod = WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD;
            }
        } else if (i11 == 3) {
            this.PaymentMethod = "talabat_credit";
        } else if (i11 == 4) {
            this.PaymentMethod = "card_on_del";
        } else if (i11 == 5) {
            this.PaymentMethod = "boloro";
        } else if (i12 == 11 || i11 == 11) {
            this.PaymentMethod = BNPLInitiatePlaceOrderFragmentKt.BNPL_TRACKING_NAME;
        } else {
            this.PaymentMethod = "cash";
        }
    }
}
