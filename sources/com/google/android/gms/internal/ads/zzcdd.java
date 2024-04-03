package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzcdd implements Parcelable.Creator<zzcdc> {
    public static final zzcdc zza(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        boolean z12 = false;
        int i15 = 0;
        int i16 = 0;
        boolean z13 = false;
        boolean z14 = false;
        int i17 = 0;
        boolean z15 = false;
        boolean z16 = false;
        int i18 = 0;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        Bundle bundle = null;
        zzbfd zzbfd = null;
        zzbfi zzbfi = null;
        String str = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        zzcjf zzcjf = null;
        Bundle bundle2 = null;
        ArrayList<String> arrayList = null;
        Bundle bundle3 = null;
        String str5 = null;
        String str6 = null;
        ArrayList<String> arrayList2 = null;
        String str7 = null;
        zzbnw zzbnw = null;
        ArrayList<String> arrayList3 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        Bundle bundle4 = null;
        String str11 = null;
        zzbjd zzbjd = null;
        Bundle bundle5 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        ArrayList<Integer> arrayList4 = null;
        String str15 = null;
        ArrayList<String> arrayList5 = null;
        ArrayList<String> arrayList6 = null;
        String str16 = null;
        zzbtz zzbtz = null;
        String str17 = null;
        Bundle bundle6 = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        long j11 = 0;
        long j12 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 2:
                    bundle = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 3:
                    zzbfd = (zzbfd) SafeParcelReader.createParcelable(parcel2, readHeader, zzbfd.CREATOR);
                    break;
                case 4:
                    zzbfi = (zzbfi) SafeParcelReader.createParcelable(parcel2, readHeader, zzbfi.CREATOR);
                    break;
                case 5:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.createParcelable(parcel2, readHeader, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.createParcelable(parcel2, readHeader, PackageInfo.CREATOR);
                    break;
                case 8:
                    str2 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 9:
                    str3 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 10:
                    str4 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 11:
                    zzcjf = (zzcjf) SafeParcelReader.createParcelable(parcel2, readHeader, zzcjf.CREATOR);
                    break;
                case 12:
                    bundle2 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 13:
                    i12 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 14:
                    arrayList = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 15:
                    bundle3 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 16:
                    z11 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 18:
                    i13 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 19:
                    i14 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 20:
                    f11 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 21:
                    str5 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 25:
                    j11 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 26:
                    str6 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 27:
                    arrayList2 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 28:
                    str7 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 29:
                    zzbnw = (zzbnw) SafeParcelReader.createParcelable(parcel2, readHeader, zzbnw.CREATOR);
                    break;
                case 30:
                    arrayList3 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 31:
                    j12 = SafeParcelReader.readLong(parcel2, readHeader);
                    break;
                case 33:
                    str8 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 34:
                    f12 = SafeParcelReader.readFloat(parcel2, readHeader);
                    break;
                case 35:
                    i15 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 36:
                    i16 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 37:
                    z13 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 39:
                    str9 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 40:
                    z12 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 41:
                    str10 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 42:
                    z14 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 43:
                    i17 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 44:
                    bundle4 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 45:
                    str11 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 46:
                    zzbjd = (zzbjd) SafeParcelReader.createParcelable(parcel2, readHeader, zzbjd.CREATOR);
                    break;
                case 47:
                    z15 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 48:
                    bundle5 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                case 49:
                    str12 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 50:
                    str13 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 51:
                    str14 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 52:
                    z16 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 53:
                    arrayList4 = SafeParcelReader.createIntegerList(parcel2, readHeader);
                    break;
                case 54:
                    str15 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 55:
                    arrayList5 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 56:
                    i18 = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 57:
                    z17 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 58:
                    z18 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 59:
                    z19 = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 60:
                    arrayList6 = SafeParcelReader.createStringList(parcel2, readHeader);
                    break;
                case 61:
                    str16 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 63:
                    zzbtz = (zzbtz) SafeParcelReader.createParcelable(parcel2, readHeader, zzbtz.CREATOR);
                    break;
                case 64:
                    str17 = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                case 65:
                    bundle6 = SafeParcelReader.createBundle(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new zzcdc(i11, bundle, zzbfd, zzbfi, str, applicationInfo, packageInfo, str2, str3, str4, zzcjf, bundle2, i12, arrayList, bundle3, z11, i13, i14, f11, str5, j11, str6, arrayList2, str7, zzbnw, arrayList3, j12, str8, f12, z12, i15, i16, z13, str9, str10, z14, i17, bundle4, str11, zzbjd, z15, bundle5, str12, str13, str14, z16, arrayList4, str15, arrayList5, i18, z17, z18, z19, arrayList6, str16, zzbtz, str17, bundle6);
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzcdc[i11];
    }
}
