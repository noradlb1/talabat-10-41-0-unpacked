package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzk implements Parcelable.Creator<zzj> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i11 = 0;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        String str = null;
        float f11 = 0.0f;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    f11 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 7:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z16 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzj(z11, z12, str, z13, f11, i11, z14, z15, z16);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzj[i11];
    }
}
