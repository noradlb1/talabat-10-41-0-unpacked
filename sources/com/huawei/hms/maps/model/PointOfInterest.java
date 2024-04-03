package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class PointOfInterest implements Parcelable {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new Parcelable.Creator<PointOfInterest>() {
        /* renamed from: a */
        public PointOfInterest createFromParcel(Parcel parcel) {
            return new PointOfInterest(parcel);
        }

        /* renamed from: a */
        public PointOfInterest[] newArray(int i11) {
            return new PointOfInterest[i11];
        }
    };
    public final LatLng latLng;

    /* renamed from: name  reason: collision with root package name */
    public final String f49531name;
    public final String placeId;

    public PointOfInterest(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.latLng = (LatLng) parcelReader.readParcelable(2, LatLng.CREATOR, null);
        this.f49531name = parcelReader.createString(3, (String) null);
        this.placeId = parcelReader.createString(4, (String) null);
    }

    public PointOfInterest(LatLng latLng2, String str, String str2) {
        this.latLng = latLng2;
        this.placeId = str;
        this.f49531name = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, this.latLng, i11, false);
        parcelWrite.writeString(3, this.f49531name, false);
        parcelWrite.writeString(4, this.placeId, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
