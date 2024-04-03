package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = 0;
        long j12 = 0;
        boolean z11 = false;
        boolean z12 = false;
        WorkSource workSource = null;
        String str = null;
        int[] iArr = null;
        String str2 = null;
        String str3 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 2:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 3:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel2, readHeader, WorkSource.CREATOR);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    iArr = SafeParcelReader.createIntArray(parcel2, readHeader);
                    break;
                case 6:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 9:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzb(j11, z11, workSource, str, iArr, z12, str2, j12, str3);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzb[i11];
    }
}
