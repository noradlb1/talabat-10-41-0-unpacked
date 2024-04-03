package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzbff implements Parcelable.Creator<zzbfd> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        boolean z12 = false;
        boolean z13 = false;
        int i14 = 0;
        int i15 = 0;
        long j11 = 0;
        Bundle bundle = null;
        ArrayList<String> arrayList = null;
        String str = null;
        zzbkm zzbkm = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        ArrayList<String> arrayList2 = null;
        String str3 = null;
        String str4 = null;
        zzbeu zzbeu = null;
        String str5 = null;
        ArrayList<String> arrayList3 = null;
        String str6 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 3:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 4:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 5:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 6:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 7:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 8:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    zzbkm = (zzbkm) SafeParcelReader.createParcelable(parcel2, readHeader, zzbkm.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.createParcelable(parcel2, readHeader, Location.CREATOR);
                    break;
                case 12:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 13:
                    bundle2 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 14:
                    bundle3 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 15:
                    arrayList2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 16:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 17:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 18:
                    z13 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 19:
                    zzbeu = (zzbeu) SafeParcelReader.createParcelable(parcel2, readHeader, zzbeu.CREATOR);
                    break;
                case 20:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 21:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 22:
                    arrayList3 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 23:
                    i15 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 24:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzbfd(i11, j11, bundle, i12, arrayList, z11, i13, z12, str, zzbkm, location, str2, bundle2, bundle3, arrayList2, str3, str4, z13, zzbeu, i14, str5, arrayList3, i15, str6);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbfd[i11];
    }
}
