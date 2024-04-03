package JsonModels.Response.rateOrders;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class RateReason implements Parcelable {
    public static final Parcelable.Creator<RateReason> CREATOR = new Parcelable.Creator<RateReason>() {
        public RateReason createFromParcel(Parcel parcel) {
            return new RateReason(parcel);
        }

        public RateReason[] newArray(int i11) {
            return new RateReason[i11];
        }
    };
    @SerializedName("enabled_for_ratings")
    int[] enabledForRatings;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    int f486id;
    @SerializedName("reason_text")
    String ratingReason;

    public RateReason() {
    }

    public RateReason(Parcel parcel) {
        this.f486id = parcel.readInt();
        this.ratingReason = parcel.readString();
        this.enabledForRatings = parcel.createIntArray();
    }

    public int describeContents() {
        return 0;
    }

    public int[] getEnabledForRatings() {
        return this.enabledForRatings;
    }

    public int getId() {
        return this.f486id;
    }

    public String getRatingReason() {
        return this.ratingReason;
    }

    public void setEnabledForRatings(int[] iArr) {
        this.enabledForRatings = iArr;
    }

    public void setId(int i11) {
        this.f486id = i11;
    }

    public void setRatingReason(String str) {
        this.ratingReason = str;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.f486id);
        parcel.writeString(this.ratingReason);
        parcel.writeIntArray(this.enabledForRatings);
    }
}
