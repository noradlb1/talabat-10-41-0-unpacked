package datamodels;

import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;
import datamodels.mappers.AutoApplyDiscountCoupon;
import java.util.ArrayList;

public class TransactionRestaurant {
    ArrayList<TransactionCoupon> Coupons;
    ArrayList<TransactionItem> Items = new ArrayList<>();
    ArrayList<TransactionPromotion> Promotions;
    public int branchId;
    public String branchName;
    private double darkStoreCartDiscount;
    private String darkStoreCartId;
    private double darkStoreDeliveryFeeDiscount;
    @SerializedName("DeliveryFee")
    private float deliveryFee;
    private String dijiniVendorId;
    public boolean isNineCookies;
    public boolean isTGO;
    private float rest6alabatCharges;
    private float restDeliveryCharges;
    private String restGeneralRequest;
    public int restId;
    private float restMuncipalityCharges;
    public String restName;
    private float restTouristCharge;
    private float serviceFee;
    @SerializedName("SmallOrderFee")
    private float smallOrderFee;
    private float tgoDeliveryDiscount;
    private float tgoDeliveryDiscountTier;
    private String voucherCode;
    private float voucherDiscoint;

    public TransactionRestaurant(Restaurant restaurant, String str, float f11, Coupon coupon, Promotion promotion, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, float f22) {
        Restaurant restaurant2 = restaurant;
        Coupon coupon2 = coupon;
        Promotion promotion2 = promotion;
        float f23 = f18;
        this.restId = restaurant2.f13872id;
        this.restName = restaurant2.f13873name;
        this.branchId = restaurant2.branchId;
        this.branchName = restaurant2.branchName;
        this.isNineCookies = restaurant2.isNineCookiesEnabledRestaurant;
        this.isTGO = restaurant2.isTalabatGo;
        float f24 = f14;
        this.restDeliveryCharges = TalabatFormatter.getInstance().getRoundedAmount(f14);
        this.tgoDeliveryDiscount = f16;
        this.tgoDeliveryDiscountTier = f17;
        this.restMuncipalityCharges = f12;
        this.restTouristCharge = f13;
        this.rest6alabatCharges = f15;
        this.voucherCode = str;
        this.voucherDiscoint = f11;
        this.serviceFee = TalabatFormatter.getInstance().getRoundedAmount(f19);
        this.smallOrderFee = TalabatFormatter.getInstance().getRoundedAmount(f21);
        this.deliveryFee = TalabatFormatter.getInstance().getRoundedAmount(f22);
        if (coupon2 != null && !(coupon2 instanceof AutoApplyDiscountCoupon)) {
            this.Coupons = new ArrayList<>();
            this.Coupons.add(new TransactionCoupon(coupon2.f13847id, coupon2.discount));
        }
        if (f23 > 0.0f) {
            if (this.Coupons == null) {
                this.Coupons = new ArrayList<>();
            }
            this.Coupons.add(new TransactionCoupon(f23));
        }
        if (promotion2 != null) {
            this.Promotions = new ArrayList<>();
            this.Promotions.add(new TransactionPromotion(promotion2.f13866id));
        }
    }

    public void addItems(TransactionItem transactionItem) {
        this.Items.add(transactionItem);
    }

    public ArrayList<TransactionCoupon> getCoupons() {
        return this.Coupons;
    }

    public String getDarkStoreCartId() {
        return this.darkStoreCartId;
    }

    public float getDeliveryFee() {
        return this.deliveryFee;
    }

    public String getDijiniVendorId() {
        return this.dijiniVendorId;
    }

    public ArrayList<TransactionPromotion> getPromotions() {
        return this.Promotions;
    }

    public float getServiceFee() {
        return this.serviceFee;
    }

    public float getSmallOrderFee() {
        return this.smallOrderFee;
    }

    public void setDarkStoreCartDiscount(double d11) {
        this.darkStoreCartDiscount = d11;
    }

    public void setDarkStoreCartId(String str) {
        this.darkStoreCartId = str;
    }

    public void setDarkStoreDeliveryFeeDiscount(double d11) {
        this.darkStoreDeliveryFeeDiscount = d11;
    }

    public void setDijiniVendorId(String str) {
        this.dijiniVendorId = str;
    }

    public void setGeneralRequest(String str) {
        this.restGeneralRequest = str;
    }
}
