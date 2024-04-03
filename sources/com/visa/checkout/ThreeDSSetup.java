package com.visa.checkout;

import android.os.Parcel;
import android.os.Parcelable;

public class ThreeDSSetup implements Parcelable {
    public static final Parcelable.Creator<ThreeDSSetup> CREATOR = new Parcelable.Creator<ThreeDSSetup>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ThreeDSSetup(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
            return new ThreeDSSetup[0];
        }
    };
    private boolean threeDSActive;
    private boolean threeDSSuppressChallenge;

    public int describeContents() {
        return 0;
    }

    public boolean isSuppress3DSChallenge() {
        return this.threeDSSuppressChallenge;
    }

    public boolean isThreeDSActive() {
        return this.threeDSActive;
    }

    public void setSuppressThreeDSChallenge(boolean z11) {
        this.threeDSSuppressChallenge = z11;
    }

    public void setThreeDSActive(boolean z11) {
        this.threeDSActive = z11;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeByte(this.threeDSActive ? (byte) 1 : 0);
        parcel.writeByte(this.threeDSSuppressChallenge ? (byte) 1 : 0);
    }

    private ThreeDSSetup(Parcel parcel) {
        boolean z11 = true;
        this.threeDSActive = true;
        this.threeDSActive = parcel.readByte() == 1;
        this.threeDSSuppressChallenge = parcel.readByte() != 1 ? false : z11;
    }

    public ThreeDSSetup() {
        this.threeDSActive = true;
    }
}
