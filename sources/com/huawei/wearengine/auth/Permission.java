package com.huawei.wearengine.auth;

import android.os.Parcel;
import android.os.Parcelable;

public class Permission implements Parcelable {
    public static final Parcelable.Creator<Permission> CREATOR = new a();
    public static final Permission DEVICE_MANAGER = new Permission("device_manager");
    public static final Permission NOTIFY = new Permission("notify");
    public static final Permission SENSOR = new Permission("sensor");
    private String mName;

    public static class a implements Parcelable.Creator<Permission> {
        public Object createFromParcel(Parcel parcel) {
            return new Permission(parcel.readString(), (a) null);
        }

        public Object[] newArray(int i11) {
            if (i11 > 65535 || i11 < 0) {
                return null;
            }
            return new Permission[i11];
        }
    }

    private Permission(String str) {
        this.mName = str;
    }

    public /* synthetic */ Permission(String str, a aVar) {
        this(str);
    }

    public int describeContents() {
        return 0;
    }

    public String getName() {
        return this.mName;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.mName);
    }
}
