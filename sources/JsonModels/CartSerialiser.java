package JsonModels;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import com.google.gson.annotations.SerializedName;
import datamodels.AppliedVoucher;
import datamodels.CartMenuItem;
import datamodels.Restaurant;
import datamodels.UserOrderPreference;
import java.util.ArrayList;

public class CartSerialiser {
    private AppliedVoucher appliedVoucher;
    private int areaId;
    private String areaName;
    @SerializedName("itms")
    private ArrayList<CartMenuItem> cartMenuItems;
    private int cityId;
    private String cityName;
    private LoyaltyVoucherRM loyaltyVoucher;
    @SerializedName("rest")
    private Restaurant restaurant;
    private UserOrderPreference userOrderPreference;

    public CartSerialiser(ArrayList arrayList, Restaurant restaurant2, int i11, String str, int i12, String str2, UserOrderPreference userOrderPreference2, AppliedVoucher appliedVoucher2, LoyaltyVoucherRM loyaltyVoucherRM) {
        this.cartMenuItems = arrayList;
        this.restaurant = restaurant2;
        this.cityId = i11;
        this.areaId = i12;
        this.areaName = str2;
        this.cityName = str;
        this.userOrderPreference = userOrderPreference2;
        this.appliedVoucher = appliedVoucher2;
        this.loyaltyVoucher = loyaltyVoucherRM;
    }

    public AppliedVoucher getAppliedVoucher() {
        return this.appliedVoucher;
    }

    public int getAreaId() {
        return this.areaId;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public ArrayList<CartMenuItem> getCartMenuItems() {
        return this.cartMenuItems;
    }

    public int getCityId() {
        return this.cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public LoyaltyVoucherRM getLoyaltyVoucher() {
        return this.loyaltyVoucher;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public UserOrderPreference getUserOrderPreference() {
        return this.userOrderPreference;
    }
}
