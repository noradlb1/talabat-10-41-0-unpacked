package datamodels;

import com.google.gson.annotations.SerializedName;
import library.talabat.mvp.homepagebanner.OnPageClickListener;

public class Page {
    @SerializedName("bimage")
    public String bannerImage;
    @SerializedName("bna")
    public String bannerName;
    @SerializedName("zid")
    public int bannerOrder;
    @SerializedName("lnk")
    public String deepLink;

    /* renamed from: id  reason: collision with root package name */
    public int f13865id;
    OnPageClickListener onPageClickListener;
    @SerializedName("rid")
    public String restaurantId;
    @SerializedName("rlogo")
    public String restaurantLogo;
    @SerializedName("rna")
    public String restaurantName;

    public Page(OnPageClickListener onPageClickListener2, int i11, String str, int i12, String str2, String str3, String str4) {
        this.onPageClickListener = onPageClickListener2;
        this.f13865id = i11;
        this.restaurantId = str;
        this.bannerOrder = i12;
        this.deepLink = str2;
        this.restaurantLogo = str3;
        this.bannerImage = str4;
    }

    public int getPageOrder() {
        return this.bannerOrder;
    }

    public Page(OnPageClickListener onPageClickListener2) {
        this.onPageClickListener = onPageClickListener2;
    }
}
