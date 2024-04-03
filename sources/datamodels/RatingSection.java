package datamodels;

import android.os.Parcel;
import com.google.gson.annotations.SerializedName;

public class RatingSection {
    @SerializedName("dr")
    public float deliveryRating;
    @SerializedName("pr")
    public float packageRating;
    @SerializedName("qr")
    public float qualityRating;
    @SerializedName("vr")
    public float valueRating;

    public RatingSection() {
    }

    public RatingSection(Parcel parcel) {
        this.packageRating = parcel.readFloat();
        this.deliveryRating = parcel.readFloat();
        this.valueRating = parcel.readFloat();
        this.qualityRating = parcel.readFloat();
    }
}
