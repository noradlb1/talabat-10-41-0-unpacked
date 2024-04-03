package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzcgd implements Parcelable.Creator<zzcgc> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 7:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzcgc(str, str2, z11, z12, arrayList, z13, z14, arrayList2);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzcgc[i11];
    }
}
