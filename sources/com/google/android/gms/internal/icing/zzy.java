package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzy implements Parcelable.Creator<zzx> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzi zzi = null;
        String str = null;
        zzg zzg = null;
        String str2 = null;
        long j11 = 0;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        int i13 = -1;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzi = (zzi) SafeParcelReader.createParcelable(parcel2, readHeader, zzi.CREATOR);
                    break;
                case 2:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    zzg = (zzg) SafeParcelReader.createParcelable(parcel2, readHeader, zzg.CREATOR);
                    break;
                case 6:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzx(zzi, j11, i11, str, zzg, z11, i13, i12, str2);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i11) {
        return new zzx[i11];
    }
}
