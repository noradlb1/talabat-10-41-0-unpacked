package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzk implements Parcelable.Creator<zzi> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        long j11 = 0;
        boolean z11 = false;
        int i11 = 0;
        int i12 = 0;
        double d11 = 0.0d;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 4:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 5:
                    d11 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 8:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzi(str, j11, z11, d11, str2, bArr, i11, i12);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzi[i11];
    }
}
