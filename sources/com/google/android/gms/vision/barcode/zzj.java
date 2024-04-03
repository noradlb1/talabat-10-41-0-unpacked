package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

public final class zzj implements Parcelable.Creator<Barcode.GeoPoint> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d11 = 0.0d;
        double d12 = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                d11 = SafeParcelReader.readDouble(parcel, readHeader);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                d12 = SafeParcelReader.readDouble(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Barcode.GeoPoint(d11, d12);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new Barcode.GeoPoint[i11];
    }
}
