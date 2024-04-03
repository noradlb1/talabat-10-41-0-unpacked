package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

public final class zzr implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        long j15 = 0;
        long j16 = 0;
        boolean z11 = false;
        int i11 = 0;
        boolean z12 = false;
        boolean z13 = false;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        Boolean bool = null;
        ArrayList<String> arrayList = null;
        String str8 = null;
        String str9 = null;
        String str10 = "";
        String str11 = str10;
        boolean z14 = true;
        boolean z15 = true;
        long j17 = -2147483648L;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 3:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 4:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 5:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 7:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 8:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    z14 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 10:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 11:
                    j17 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 12:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    j13 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 14:
                    j14 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 15:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 16:
                    z15 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 21:
                    bool = SafeParcelReader.readBooleanObject(parcel2, readHeader);
                    break;
                case 22:
                    j15 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 23:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 24:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 25:
                    str10 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 26:
                    str11 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 27:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 28:
                    z13 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 29:
                    j16 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzq(str, str2, str3, str4, j11, j12, str5, z14, z11, j17, str6, j13, j14, i11, z15, z12, str7, bool, j15, (List) arrayList, str8, str10, str11, str9, z13, j16);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzq[i11];
    }
}
