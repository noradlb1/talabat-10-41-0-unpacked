package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public String URI;

    /* renamed from: a  reason: collision with root package name */
    private int f48235a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f48236b;
    public Bundle header;

    public class a implements Parcelable.Creator<DataBuffer> {
        /* renamed from: a */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        /* renamed from: a */
        public DataBuffer[] newArray(int i11) {
            return new DataBuffer[i11];
        }
    }

    public /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f48236b = bundle;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f48236b;
    }

    public int getBodySize() {
        return this.f48236b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.f48235a;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        if (parcel != null) {
            parcel.writeInt(this.f48235a);
            parcel.writeString(this.URI);
            parcel.writeBundle(this.header);
            parcel.writeBundle(this.f48236b);
        }
    }

    private DataBuffer(Parcel parcel) {
        this.header = null;
        this.f48235a = 1;
        this.f48236b = null;
        a(parcel);
    }

    private void a(Parcel parcel) {
        this.f48235a = parcel.readInt();
        this.URI = parcel.readString();
        Class<Bundle> cls = Bundle.class;
        this.header = parcel.readBundle(a((Class) cls));
        this.f48236b = parcel.readBundle(a((Class) cls));
    }

    public DataBuffer() {
        this.header = null;
        this.f48235a = 1;
        this.f48236b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f48235a = 1;
        this.f48236b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i11) {
        this.header = null;
        this.f48236b = null;
        this.URI = str;
        this.f48235a = i11;
    }
}
