package com.huawei.hms.maps.model;

import android.graphics.Color;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.feature.dynamic.IObjectWrapper;

public class MyLocationStyle implements Parcelable {
    public static final Parcelable.Creator<MyLocationStyle> CREATOR = new Parcelable.Creator<MyLocationStyle>() {
        /* renamed from: a */
        public MyLocationStyle createFromParcel(Parcel parcel) {
            return new MyLocationStyle(parcel);
        }

        /* renamed from: a */
        public MyLocationStyle[] newArray(int i11) {
            return new MyLocationStyle[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private float f49527a = 0.5f;

    /* renamed from: b  reason: collision with root package name */
    private float f49528b = 0.5f;

    /* renamed from: c  reason: collision with root package name */
    private BitmapDescriptor f49529c;

    /* renamed from: d  reason: collision with root package name */
    private int f49530d = Color.argb(56, 117, 112, 255);

    public MyLocationStyle() {
    }

    public MyLocationStyle(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49527a = parcelReader.readFloat(2, 0.0f);
        this.f49528b = parcelReader.readFloat(3, 0.0f);
        IBinder readIBinder = parcelReader.readIBinder(4, (IBinder) null);
        if (readIBinder != null) {
            this.f49529c = new BitmapDescriptor(IObjectWrapper.Stub.asInterface(readIBinder));
        }
        this.f49530d = parcelReader.readInt(5, 0);
    }

    public MyLocationStyle anchor(float f11, float f12) {
        this.f49527a = f11;
        this.f49528b = f12;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public float getAnchorU() {
        return this.f49527a;
    }

    public float getAnchorV() {
        return this.f49528b;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.f49529c;
    }

    public int getRadiusFillColor() {
        return this.f49530d;
    }

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.f49529c = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i11) {
        this.f49530d = i11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeFloat(2, this.f49527a);
        parcelWrite.writeFloat(3, this.f49528b);
        BitmapDescriptor bitmapDescriptor = this.f49529c;
        parcelWrite.writeIBinder(4, bitmapDescriptor != null ? bitmapDescriptor.getObject().asBinder() : null, true);
        parcelWrite.writeInt(5, this.f49530d);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
