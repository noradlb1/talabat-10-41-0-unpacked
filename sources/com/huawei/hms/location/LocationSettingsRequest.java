package com.huawei.hms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LocationSettingsRequest implements IMessageEntity, Parcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new yn();
    @Packed
    public boolean alwaysShow;
    @Packed
    public boolean needBle;
    @Packed
    public List<LocationRequest> requests;

    public static class Builder {
        private boolean alwaysShow = false;
        private boolean needBle = false;
        private List<LocationRequest> requests = new ArrayList();

        public Builder addAllLocationRequests(Collection<LocationRequest> collection) {
            this.requests.addAll(collection);
            return this;
        }

        public Builder addLocationRequest(LocationRequest locationRequest) {
            this.requests.add(locationRequest);
            return this;
        }

        public LocationSettingsRequest build() {
            return new LocationSettingsRequest(this.requests, this.alwaysShow, this.needBle, (yn) null);
        }

        public Builder setAlwaysShow(boolean z11) {
            this.alwaysShow = z11;
            return this;
        }

        public Builder setNeedBle(boolean z11) {
            this.needBle = z11;
            return this;
        }
    }

    public static class yn implements Parcelable.Creator<LocationSettingsRequest> {
        public Object createFromParcel(Parcel parcel) {
            return new LocationSettingsRequest(parcel);
        }

        public Object[] newArray(int i11) {
            return new LocationSettingsRequest[i11];
        }
    }

    private LocationSettingsRequest() {
    }

    public LocationSettingsRequest(Parcel parcel) {
        boolean z11 = true;
        this.alwaysShow = parcel.readByte() != 0;
        this.needBle = parcel.readByte() == 0 ? false : z11;
    }

    private LocationSettingsRequest(List<LocationRequest> list, boolean z11, boolean z12) {
        this.requests = list;
        this.alwaysShow = z11;
        this.needBle = z12;
    }

    public /* synthetic */ LocationSettingsRequest(List list, boolean z11, boolean z12, yn ynVar) {
        this(list, z11, z12);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeTypedList(this.requests);
        parcel.writeByte(this.alwaysShow ? (byte) 1 : 0);
        parcel.writeByte(this.needBle ? (byte) 1 : 0);
    }
}
