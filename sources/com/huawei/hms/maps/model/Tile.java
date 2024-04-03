package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class Tile implements Parcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new Parcelable.Creator<Tile>() {
        /* renamed from: a */
        public Tile createFromParcel(Parcel parcel) {
            return new Tile(parcel);
        }

        /* renamed from: a */
        public Tile[] newArray(int i11) {
            return new Tile[i11];
        }
    };
    public final byte[] data;
    public final int height;
    public final int width;

    public Tile(int i11, int i12, byte[] bArr) {
        this.width = i11;
        this.height = i12;
        this.data = bArr;
    }

    public Tile(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.data = parcelReader.createByteArray(2, (byte[]) null);
        this.height = parcelReader.readInt(3, 0);
        this.width = parcelReader.readInt(4, 0);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeByteArray(2, this.data, false);
        parcelWrite.writeInt(3, this.height);
        parcelWrite.writeInt(4, this.width);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }
}
