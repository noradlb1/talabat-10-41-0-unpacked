package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zan implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        String str = null;
        String str2 = null;
        long j11 = 0;
        long j12 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 3:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 5:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 6:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 8:
                    i15 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 9:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MethodInvocation(i12, i13, i14, j11, j12, str, str2, i15, i11);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new MethodInvocation[i11];
    }
}
