package library.talabat.inlineadsengine;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import datamodels.Restaurant;

public class AdsWrapper {
    @Nullable
    private String adsImage;
    @Nullable
    private String adsLink;
    private int adsPosition;
    @Nullable
    private NativeCustomTemplateAd nativeCustomTemplateAd;
    @Nullable
    private Restaurant restaurant;
    private int vendorId;

    @Nullable
    public String getAdsImage() {
        return this.adsImage;
    }

    @Nullable
    public String getAdsLink() {
        return this.adsLink;
    }

    public int getAdsPosition() {
        return this.adsPosition;
    }

    @Nullable
    public NativeCustomTemplateAd getNativeCustomTemplateAd() {
        return this.nativeCustomTemplateAd;
    }

    @Nullable
    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    @Nullable
    public String getRestaurantCuisine() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getCuisineString();
        }
        return "";
    }

    @Nullable
    public String getRestaurantLogo() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getLogo();
        }
        return "";
    }

    @Nullable
    public String getRestaurantName() {
        Restaurant restaurant2 = this.restaurant;
        if (restaurant2 != null) {
            return restaurant2.getName();
        }
        return "";
    }

    public int getVendorId() {
        return this.vendorId;
    }

    public void setAdsImage(@Nullable String str) {
        this.adsImage = str;
    }

    public void setAdsLink(@Nullable String str) {
        this.adsLink = str;
    }

    public void setAdsPosition(int i11) {
        this.adsPosition = i11;
    }

    public void setNativeCustomTemplateAd(@Nullable NativeCustomTemplateAd nativeCustomTemplateAd2) {
        this.nativeCustomTemplateAd = nativeCustomTemplateAd2;
    }

    public void setRestaurant(@Nullable Restaurant restaurant2) {
        this.restaurant = restaurant2;
    }

    public void setVendorId(int i11) {
        this.vendorId = i11;
    }
}
