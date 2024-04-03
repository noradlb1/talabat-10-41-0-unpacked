package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbnx implements Parcelable.Creator<zzbnw> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        boolean z12 = false;
        int i13 = 0;
        boolean z13 = false;
        int i14 = 0;
        zzbkq zzbkq = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    zzbkq = (zzbkq) SafeParcelReader.createParcelable(parcel, readHeader, zzbkq.CREATOR);
                    break;
                case 7:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    i14 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbnw(i11, z11, i12, z12, i13, zzbkq, z13, i14);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbnw[i11];
    }
}
