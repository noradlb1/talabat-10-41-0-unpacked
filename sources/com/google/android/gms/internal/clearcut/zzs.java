package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzs implements Parcelable.Creator<zzr> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        boolean z12 = true;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    i11 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    i12 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 9:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    i13 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzr(str, i11, i12, str2, str3, z12, str4, z11, i13);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzr[i11];
    }
}
