package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbfj implements Parcelable.Creator<zzbfi> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzbfi[] zzbfiArr = null;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 6:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 7:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    zzbfiArr = (zzbfi[]) SafeParcelReader.createTypedArray(parcel2, readHeader, zzbfi.CREATOR);
                    break;
                case 9:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    z14 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 12:
                    z15 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 13:
                    z16 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 14:
                    z17 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 15:
                    z18 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 16:
                    z19 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzbfi(str, i11, i12, z11, i13, i14, zzbfiArr, z12, z13, z14, z15, z16, z17, z18, z19);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbfi[i11];
    }
}
