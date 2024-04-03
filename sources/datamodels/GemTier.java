package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class GemTier implements Parcelable {
    public static final Parcelable.Creator<GemTier> CREATOR = new Parcelable.Creator<GemTier>() {
        public GemTier createFromParcel(Parcel parcel) {
            return new GemTier(parcel);
        }

        public GemTier[] newArray(int i11) {
            return new GemTier[i11];
        }
    };
    @SerializedName("countryId")
    int cntid;
    @SerializedName("clr")
    String color;
    @SerializedName("discount")
    double discount;
    @SerializedName("tierAmount")
    double tierAmount;

    public GemTier(Parcel parcel) {
        this.cntid = parcel.readInt();
        this.tierAmount = parcel.readDouble();
        this.discount = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public double getDiscount() {
        return this.discount;
    }

    public double getTierAmount() {
        return this.tierAmount;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.cntid);
        parcel.writeDouble(this.tierAmount);
        parcel.writeDouble(this.discount);
    }
}
