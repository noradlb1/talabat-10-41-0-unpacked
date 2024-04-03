package JsonModels;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class PolygonEvents implements Parcelable {
    public static final Parcelable.Creator<PolygonEvents> CREATOR = new Parcelable.Creator<PolygonEvents>() {
        public PolygonEvents createFromParcel(Parcel parcel) {
            return new PolygonEvents(parcel);
        }

        public PolygonEvents[] newArray(int i11) {
            return new PolygonEvents[i11];
        }
    };
    @SerializedName("eid")
    public int eventId;
    @SerializedName("emg")
    public String eventMsg;
    @SerializedName("evt")
    public String eventType;
    @SerializedName("eva")
    public int eventValue;
    @SerializedName("isac")
    public boolean isActive;

    public PolygonEvents() {
    }

    public PolygonEvents(Parcel parcel) {
        boolean z11;
        if (parcel.readByte() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.isActive = z11;
        this.eventId = parcel.readInt();
        this.eventValue = parcel.readInt();
        this.eventType = parcel.readString();
        this.eventMsg = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByte(this.isActive ? (byte) 1 : 0);
        parcel.writeInt(this.eventId);
        parcel.writeInt(this.eventValue);
        parcel.writeString(this.eventType);
        parcel.writeString(this.eventMsg);
    }
}
