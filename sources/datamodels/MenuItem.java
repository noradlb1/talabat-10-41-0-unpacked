package datamodels;

import android.net.Uri;
import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import org.jetbrains.annotations.Nullable;

public class MenuItem {
    @SerializedName("csc")
    public ChoiceSection[] choiceSections;
    public boolean choicesLoaded = false;
    @SerializedName("couponId")
    @Nullable
    public Integer couponId;
    @SerializedName("dsc")
    public String desc;
    @SerializedName("dp")
    public float descPrice;
    @SerializedName("exG")
    public boolean excludedFromGem;
    @SerializedName("ht")
    public boolean hasThumbnail;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f13861id;
    public String imgurl;
    @SerializedName("isi")
    public boolean isItemDiscount;
    @SerializedName("ipr")
    public boolean isPromotional;
    @SerializedName("msi")
    public int menuSectionId;
    @SerializedName("nm")

    /* renamed from: name  reason: collision with root package name */
    public String f13862name;
    @SerializedName("opr")
    public float oldPrice;
    @SerializedName("pr")
    public float price;
    @SerializedName("img")
    public String thumbnail;
    @SerializedName("icc")
    public boolean willHaveChoices;

    public MenuItem() {
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MenuItem) && this.f13861id == ((MenuItem) obj).f13861id) {
            return true;
        }
        return false;
    }

    public String getDisplayOldPrice() {
        if (this.oldPrice == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.oldPrice);
    }

    public String getDisplayOldPriceFormatted() {
        if (this.oldPrice == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.oldPrice, true);
    }

    public String getDisplayOldPriceNonFormatted() {
        if (this.oldPrice == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.oldPrice, false);
    }

    public String getDisplayPrice() {
        TalabatFormatter instance = TalabatFormatter.getInstance();
        float f11 = this.price;
        if (f11 == 0.0f) {
            return "0";
        }
        return instance.getFormattedCurrency(f11);
    }

    public String getDisplayPriceNonFormatted() {
        if (this.price == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.price, false);
    }

    public String getDisplayStartsWithPrice(boolean z11) {
        return TalabatFormatter.getInstance().getFormattedCurrency(getStartsWithPrice(), z11);
    }

    public float getStartsWithPrice() {
        float f11 = 0.0f;
        for (ChoiceSection minimumTotalCost : this.choiceSections) {
            f11 += minimumTotalCost.getMinimumTotalCost();
        }
        return f11;
    }

    public String getThumbnail(int i11) {
        if (TalabatUtils.isNullOrEmpty(this.thumbnail.trim())) {
            return "";
        }
        if (this.thumbnail.contains("menuitems/")) {
            return (this.thumbnail + "?height=" + i11).replace(" ", "%20");
        }
        String encode = Uri.encode(this.thumbnail);
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + encode + "?height=" + i11).replace(" ", "%20");
    }

    public String getThumbnailWithSize(int i11) {
        String str = this.thumbnail;
        if (str == null) {
            return "";
        }
        if (str.contains("menuitems/")) {
            return (this.thumbnail + "?height=" + i11).replace(" ", "%20");
        }
        String encode = Uri.encode(this.thumbnail);
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + encode + "?height=" + i11).replace(" ", "%20");
    }

    public String getThumbnailWithWidth(int i11) {
        String str = this.thumbnail;
        if (str == null) {
            return "";
        }
        if (str.contains("menuitems/")) {
            return this.thumbnail + "?width=" + i11;
        }
        String encode = Uri.encode(this.thumbnail);
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + encode + "?width=" + i11).replace(" ", "%20");
    }

    public boolean isChoicesLoaded() {
        return this.choicesLoaded;
    }

    public boolean isDiscounted() {
        return this.oldPrice > 0.0f;
    }

    public void setThumbnail(String str) {
        this.thumbnail = str;
    }

    public String toString() {
        return this.f13862name;
    }

    public boolean willHaveChoices() {
        return this.willHaveChoices;
    }

    public MenuItem(int i11, int i12, String str, String str2, float f11, String str3) {
        this.f13861id = i11;
        this.menuSectionId = i12;
        this.f13862name = str;
        this.price = f11;
        this.thumbnail = str2;
        this.desc = str3;
    }

    public String getThumbnail() {
        if (TalabatUtils.isNullOrEmpty(this.thumbnail) || TalabatUtils.isNullOrEmpty(this.thumbnail.trim())) {
            return "";
        }
        if (this.thumbnail.contains("menuitems/")) {
            return this.thumbnail;
        }
        String encode = Uri.encode(this.thumbnail);
        return (GlobalDataModel.imageBaseUrl + "menuitems/" + encode).replace(" ", "%20");
    }
}
