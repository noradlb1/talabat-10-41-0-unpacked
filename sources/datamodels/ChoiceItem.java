package datamodels;

import android.os.Parcel;
import androidx.annotation.Nullable;
import buisnessmodels.TalabatFormatter;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ChoiceItem implements Serializable {
    public boolean allSubChoicesLoaded;
    @SerializedName(alternate = {"cid"}, value = "couponId")
    @Nullable
    public Integer couponId;
    @SerializedName("dp")
    public float discPrice;
    @SerializedName("hsc")
    public boolean hasSubChoice;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    public int f13839id;
    @SerializedName("ids")
    public boolean isDisountedItem;
    public boolean isMandatory;
    @SerializedName("nm")

    /* renamed from: name  reason: collision with root package name */
    public String f13840name;
    @SerializedName("opr")
    public float oldPrice;
    @SerializedName("pr")
    public float price;
    @SerializedName("quantity")
    public int quantity = 1;

    public ChoiceItem() {
    }

    public String getDisplayItemChoiceOldPrice() {
        if (this.oldPrice == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.oldPrice);
    }

    public String getDisplayItemChoicePice() {
        return this.price != 0.0f ? TalabatFormatter.getInstance().getFormattedCurrency(this.price) : "";
    }

    public int getQuantity() {
        if (this.quantity == 0) {
            this.quantity = 1;
        }
        return this.quantity;
    }

    public boolean isDiscounted() {
        return this.oldPrice > 0.0f;
    }

    public boolean isPriced() {
        return this.price > 0.0f;
    }

    public ChoiceItem(Parcel parcel) {
        boolean z11 = true;
        this.f13839id = parcel.readInt();
        this.f13840name = parcel.readString();
        this.price = parcel.readFloat();
        this.discPrice = parcel.readFloat();
        this.isDisountedItem = parcel.readByte() != 0;
        this.isMandatory = parcel.readByte() == 0 ? false : z11;
        this.oldPrice = parcel.readFloat();
    }

    public String getDisplayItemChoiceOldPrice(boolean z11) {
        if (this.oldPrice == 0.0f) {
            return "0";
        }
        return TalabatFormatter.getInstance().getFormattedCurrency(this.oldPrice, z11);
    }

    public String getDisplayItemChoicePice(boolean z11) {
        return this.price != 0.0f ? TalabatFormatter.getInstance().getFormattedCurrency(this.price, z11) : "";
    }
}
