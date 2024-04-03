package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
@ParametersAreNonnullByDefault
public final class zzcdc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcdc> CREATOR = new zzcdd();
    @SafeParcelable.Field(id = 31)
    public final long zzA;
    @SafeParcelable.Field(id = 33)
    public final String zzB;
    @SafeParcelable.Field(id = 34)
    public final float zzC;
    @SafeParcelable.Field(id = 35)
    public final int zzD;
    @SafeParcelable.Field(id = 36)
    public final int zzE;
    @SafeParcelable.Field(id = 37)
    public final boolean zzF;
    @SafeParcelable.Field(id = 39)
    public final String zzG;
    @SafeParcelable.Field(id = 40)
    public final boolean zzH;
    @SafeParcelable.Field(id = 41)
    public final String zzI;
    @SafeParcelable.Field(id = 42)
    public final boolean zzJ;
    @SafeParcelable.Field(id = 43)
    public final int zzK;
    @SafeParcelable.Field(id = 44)
    public final Bundle zzL;
    @SafeParcelable.Field(id = 45)
    public final String zzM;
    @SafeParcelable.Field(id = 46)
    @Nullable
    public final zzbjd zzN;
    @SafeParcelable.Field(id = 47)
    public final boolean zzO;
    @SafeParcelable.Field(id = 48)
    public final Bundle zzP;
    @SafeParcelable.Field(id = 49)
    @Nullable
    public final String zzQ;
    @SafeParcelable.Field(id = 50)
    @Nullable
    public final String zzR;
    @SafeParcelable.Field(id = 51)
    @Nullable
    public final String zzS;
    @SafeParcelable.Field(id = 52)
    public final boolean zzT;
    @SafeParcelable.Field(id = 53)
    public final List<Integer> zzU;
    @SafeParcelable.Field(id = 54)
    public final String zzV;
    @SafeParcelable.Field(id = 55)
    public final List<String> zzW;
    @SafeParcelable.Field(id = 56)
    public final int zzX;
    @SafeParcelable.Field(id = 57)
    public final boolean zzY;
    @SafeParcelable.Field(id = 58)
    public final boolean zzZ;
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @SafeParcelable.Field(id = 59)
    public final boolean zzaa;
    @SafeParcelable.Field(id = 60)
    public final ArrayList<String> zzab;
    @SafeParcelable.Field(id = 61)
    public final String zzac;
    @SafeParcelable.Field(id = 63)
    public final zzbtz zzad;
    @SafeParcelable.Field(id = 64)
    @Nullable
    public final String zzae;
    @SafeParcelable.Field(id = 65)
    public final Bundle zzaf;
    @SafeParcelable.Field(id = 2)
    @Nullable
    public final Bundle zzb;
    @SafeParcelable.Field(id = 3)
    public final zzbfd zzc;
    @SafeParcelable.Field(id = 4)
    public final zzbfi zzd;
    @SafeParcelable.Field(id = 5)
    public final String zze;
    @SafeParcelable.Field(id = 6)
    public final ApplicationInfo zzf;
    @SafeParcelable.Field(id = 7)
    @Nullable
    public final PackageInfo zzg;
    @SafeParcelable.Field(id = 8)
    public final String zzh;
    @SafeParcelable.Field(id = 9)
    public final String zzi;
    @SafeParcelable.Field(id = 10)
    public final String zzj;
    @SafeParcelable.Field(id = 11)
    public final zzcjf zzk;
    @SafeParcelable.Field(id = 12)
    public final Bundle zzl;
    @SafeParcelable.Field(id = 13)
    public final int zzm;
    @SafeParcelable.Field(id = 14)
    public final List<String> zzn;
    @SafeParcelable.Field(id = 15)
    public final Bundle zzo;
    @SafeParcelable.Field(id = 16)
    public final boolean zzp;
    @SafeParcelable.Field(id = 18)
    public final int zzq;
    @SafeParcelable.Field(id = 19)
    public final int zzr;
    @SafeParcelable.Field(id = 20)
    public final float zzs;
    @SafeParcelable.Field(id = 21)
    public final String zzt;
    @SafeParcelable.Field(id = 25)
    public final long zzu;
    @SafeParcelable.Field(id = 26)
    public final String zzv;
    @SafeParcelable.Field(id = 27)
    @Nullable
    public final List<String> zzw;
    @SafeParcelable.Field(id = 28)
    public final String zzx;
    @SafeParcelable.Field(id = 29)
    public final zzbnw zzy;
    @SafeParcelable.Field(id = 30)
    public final List<String> zzz;

    @SafeParcelable.Constructor
    public zzcdc(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) Bundle bundle, @SafeParcelable.Param(id = 3) zzbfd zzbfd, @SafeParcelable.Param(id = 4) zzbfi zzbfi, @SafeParcelable.Param(id = 5) String str, @SafeParcelable.Param(id = 6) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 7) PackageInfo packageInfo, @SafeParcelable.Param(id = 8) String str2, @SafeParcelable.Param(id = 9) String str3, @SafeParcelable.Param(id = 10) String str4, @SafeParcelable.Param(id = 11) zzcjf zzcjf, @SafeParcelable.Param(id = 12) Bundle bundle2, @SafeParcelable.Param(id = 13) int i12, @SafeParcelable.Param(id = 14) List<String> list, @SafeParcelable.Param(id = 15) Bundle bundle3, @SafeParcelable.Param(id = 16) boolean z11, @SafeParcelable.Param(id = 18) int i13, @SafeParcelable.Param(id = 19) int i14, @SafeParcelable.Param(id = 20) float f11, @SafeParcelable.Param(id = 21) String str5, @SafeParcelable.Param(id = 25) long j11, @SafeParcelable.Param(id = 26) String str6, @SafeParcelable.Param(id = 27) List<String> list2, @SafeParcelable.Param(id = 28) String str7, @SafeParcelable.Param(id = 29) zzbnw zzbnw, @SafeParcelable.Param(id = 30) List<String> list3, @SafeParcelable.Param(id = 31) long j12, @SafeParcelable.Param(id = 33) String str8, @SafeParcelable.Param(id = 34) float f12, @SafeParcelable.Param(id = 40) boolean z12, @SafeParcelable.Param(id = 35) int i15, @SafeParcelable.Param(id = 36) int i16, @SafeParcelable.Param(id = 37) boolean z13, @SafeParcelable.Param(id = 39) String str9, @SafeParcelable.Param(id = 41) String str10, @SafeParcelable.Param(id = 42) boolean z14, @SafeParcelable.Param(id = 43) int i17, @SafeParcelable.Param(id = 44) Bundle bundle4, @SafeParcelable.Param(id = 45) String str11, @SafeParcelable.Param(id = 46) zzbjd zzbjd, @SafeParcelable.Param(id = 47) boolean z15, @SafeParcelable.Param(id = 48) Bundle bundle5, @SafeParcelable.Param(id = 49) @Nullable String str12, @SafeParcelable.Param(id = 50) @Nullable String str13, @SafeParcelable.Param(id = 51) @Nullable String str14, @SafeParcelable.Param(id = 52) boolean z16, @SafeParcelable.Param(id = 53) List<Integer> list4, @SafeParcelable.Param(id = 54) String str15, @SafeParcelable.Param(id = 55) List<String> list5, @SafeParcelable.Param(id = 56) int i18, @SafeParcelable.Param(id = 57) boolean z17, @SafeParcelable.Param(id = 58) boolean z18, @SafeParcelable.Param(id = 59) boolean z19, @SafeParcelable.Param(id = 60) ArrayList<String> arrayList, @SafeParcelable.Param(id = 61) String str16, @SafeParcelable.Param(id = 63) zzbtz zzbtz, @SafeParcelable.Param(id = 64) @Nullable String str17, @SafeParcelable.Param(id = 65) Bundle bundle6) {
        List<String> list6;
        List<String> list7;
        this.zza = i11;
        this.zzb = bundle;
        this.zzc = zzbfd;
        this.zzd = zzbfi;
        this.zze = str;
        this.zzf = applicationInfo;
        this.zzg = packageInfo;
        this.zzh = str2;
        this.zzi = str3;
        this.zzj = str4;
        this.zzk = zzcjf;
        this.zzl = bundle2;
        this.zzm = i12;
        this.zzn = list;
        if (list3 == null) {
            list6 = Collections.emptyList();
        } else {
            list6 = Collections.unmodifiableList(list3);
        }
        this.zzz = list6;
        this.zzo = bundle3;
        this.zzp = z11;
        this.zzq = i13;
        this.zzr = i14;
        this.zzs = f11;
        this.zzt = str5;
        this.zzu = j11;
        this.zzv = str6;
        if (list2 == null) {
            list7 = Collections.emptyList();
        } else {
            list7 = Collections.unmodifiableList(list2);
        }
        this.zzw = list7;
        this.zzx = str7;
        this.zzy = zzbnw;
        this.zzA = j12;
        this.zzB = str8;
        this.zzC = f12;
        this.zzH = z12;
        this.zzD = i15;
        this.zzE = i16;
        this.zzF = z13;
        this.zzG = str9;
        this.zzI = str10;
        this.zzJ = z14;
        this.zzK = i17;
        this.zzL = bundle4;
        this.zzM = str11;
        this.zzN = zzbjd;
        this.zzO = z15;
        this.zzP = bundle5;
        this.zzQ = str12;
        this.zzR = str13;
        this.zzS = str14;
        this.zzT = z16;
        this.zzU = list4;
        this.zzV = str15;
        this.zzW = list5;
        this.zzX = i18;
        this.zzY = z17;
        this.zzZ = z18;
        this.zzaa = z19;
        this.zzab = arrayList;
        this.zzac = str16;
        this.zzad = zzbtz;
        this.zzae = str17;
        this.zzaf = bundle6;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i11, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i11, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i11, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i11, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzl, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzo, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzp);
        SafeParcelWriter.writeInt(parcel, 18, this.zzq);
        SafeParcelWriter.writeInt(parcel, 19, this.zzr);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzs);
        SafeParcelWriter.writeString(parcel, 21, this.zzt, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzu);
        SafeParcelWriter.writeString(parcel, 26, this.zzv, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzw, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzx, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzy, i11, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzz, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzA);
        SafeParcelWriter.writeString(parcel, 33, this.zzB, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzC);
        SafeParcelWriter.writeInt(parcel, 35, this.zzD);
        SafeParcelWriter.writeInt(parcel, 36, this.zzE);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzF);
        SafeParcelWriter.writeString(parcel, 39, this.zzG, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzH);
        SafeParcelWriter.writeString(parcel, 41, this.zzI, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzJ);
        SafeParcelWriter.writeInt(parcel, 43, this.zzK);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzL, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzM, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzN, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzO);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzP, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzQ, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzR, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzS, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzT);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzU, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzV, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzW, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzX);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzY);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzZ);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzaa);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzab, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzac, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzad, i11, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzae, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzaf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
