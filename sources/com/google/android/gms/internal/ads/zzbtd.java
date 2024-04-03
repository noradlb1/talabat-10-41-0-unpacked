package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzbtd implements Parcelable.Creator<zzbtc> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        boolean z11 = false;
        int i11 = 0;
        boolean z12 = false;
        String str = null;
        byte[] bArr = null;
        String[] strArr = null;
        String[] strArr2 = null;
        long j11 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    bArr = SafeParcelReader.createByteArray(parcel2, readHeader);
                    break;
                case 5:
                    strArr = SafeParcelReader.createStringArray(parcel2, readHeader);
                    break;
                case 6:
                    strArr2 = SafeParcelReader.createStringArray(parcel2, readHeader);
                    break;
                case 7:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 8:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzbtc(z11, str, i11, bArr, strArr, strArr2, z12, j11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbtc[i11];
    }
}
