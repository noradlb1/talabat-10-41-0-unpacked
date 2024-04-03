package datamodels;

import android.os.Parcel;

public class ReviewReply {
    public String resDate;
    public String restaurantResponse;

    public ReviewReply() {
    }

    public ReviewReply(Parcel parcel) {
        this.restaurantResponse = parcel.readString();
        this.resDate = parcel.readString();
    }
}
