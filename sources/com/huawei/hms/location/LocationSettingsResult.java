package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.annotation.Packed;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;

public class LocationSettingsResult extends Result implements Parcelable {
    public static final Parcelable.Creator<LocationSettingsResult> CREATOR = new yn();
    @Packed
    private LocationSettingsStates locationSettingsStates;
    @Packed
    private Status status;

    public static class yn implements Parcelable.Creator<LocationSettingsResult> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationSettingsResult(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationSettingsResult[i11];
        }
    }

    public LocationSettingsResult() {
    }

    public LocationSettingsResult(Parcel parcel) {
        this.status = (Status) parcel.readParcelable(Status.class.getClassLoader());
        this.locationSettingsStates = (LocationSettingsStates) parcel.readParcelable(LocationSettingsStates.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public LocationSettingsStates getLocationSettingsStates() {
        return this.locationSettingsStates;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setLocationSettingsStates(LocationSettingsStates locationSettingsStates2) {
        this.locationSettingsStates = locationSettingsStates2;
    }

    public void setStatus(Status status2) {
        this.status = status2;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeParcelable(this.status, i11);
        parcel.writeParcelable(this.locationSettingsStates, i11);
    }
}
