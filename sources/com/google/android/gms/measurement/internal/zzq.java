package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 17, 20})
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(id = 2)
    @Nullable
    public final String zza;
    @SafeParcelable.Field(id = 3)
    @Nullable
    public final String zzb;
    @SafeParcelable.Field(id = 4)
    @Nullable
    public final String zzc;
    @SafeParcelable.Field(id = 5)
    @Nullable
    public final String zzd;
    @SafeParcelable.Field(id = 6)
    public final long zze;
    @SafeParcelable.Field(id = 7)
    public final long zzf;
    @SafeParcelable.Field(id = 8)
    @Nullable
    public final String zzg;
    @SafeParcelable.Field(defaultValue = "true", id = 9)
    public final boolean zzh;
    @SafeParcelable.Field(id = 10)
    public final boolean zzi;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzj;
    @SafeParcelable.Field(id = 12)
    @Nullable
    public final String zzk;
    @SafeParcelable.Field(id = 13)
    @Deprecated
    public final long zzl;
    @SafeParcelable.Field(id = 14)
    public final long zzm;
    @SafeParcelable.Field(id = 15)
    public final int zzn;
    @SafeParcelable.Field(defaultValue = "true", id = 16)
    public final boolean zzo;
    @SafeParcelable.Field(id = 18)
    public final boolean zzp;
    @SafeParcelable.Field(id = 19)
    @Nullable
    public final String zzq;
    @SafeParcelable.Field(id = 21)
    @Nullable
    public final Boolean zzr;
    @SafeParcelable.Field(id = 22)
    public final long zzs;
    @SafeParcelable.Field(id = 23)
    @Nullable
    public final List zzt;
    @SafeParcelable.Field(id = 24)
    @Nullable
    public final String zzu;
    @SafeParcelable.Field(defaultValue = "", id = 25)
    public final String zzv;
    @SafeParcelable.Field(defaultValue = "", id = 26)
    public final String zzw;
    @SafeParcelable.Field(id = 27)
    @Nullable
    public final String zzx;
    @SafeParcelable.Field(defaultValue = "false", id = 28)
    public final boolean zzy;
    @SafeParcelable.Field(id = 29)
    public final long zzz;

    public zzq(@Nullable String str, @Nullable String str2, @Nullable String str3, long j11, @Nullable String str4, long j12, long j13, @Nullable String str5, boolean z11, boolean z12, @Nullable String str6, long j14, long j15, int i11, boolean z13, boolean z14, @Nullable String str7, @Nullable Boolean bool, long j16, @Nullable List list, @Nullable String str8, String str9, String str10, @Nullable String str11, boolean z15, long j17) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = true == TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j11;
        this.zzd = str4;
        this.zze = j12;
        this.zzf = j13;
        this.zzg = str5;
        this.zzh = z11;
        this.zzi = z12;
        this.zzk = str6;
        this.zzl = 0;
        this.zzm = j15;
        this.zzn = i11;
        this.zzo = z13;
        this.zzp = z14;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j16;
        this.zzt = list;
        this.zzu = null;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
        this.zzy = z15;
        this.zzz = j17;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzl);
        SafeParcelWriter.writeLong(parcel, 14, this.zzm);
        SafeParcelWriter.writeInt(parcel, 15, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzo);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzp);
        SafeParcelWriter.writeString(parcel, 19, this.zzq, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzr, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzs);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzv, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzw, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzx, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzy);
        SafeParcelWriter.writeLong(parcel, 29, this.zzz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable String str2, @SafeParcelable.Param(id = 4) @Nullable String str3, @SafeParcelable.Param(id = 5) @Nullable String str4, @SafeParcelable.Param(id = 6) long j11, @SafeParcelable.Param(id = 7) long j12, @SafeParcelable.Param(id = 8) @Nullable String str5, @SafeParcelable.Param(id = 9) boolean z11, @SafeParcelable.Param(id = 10) boolean z12, @SafeParcelable.Param(id = 11) long j13, @SafeParcelable.Param(id = 12) @Nullable String str6, @SafeParcelable.Param(id = 13) long j14, @SafeParcelable.Param(id = 14) long j15, @SafeParcelable.Param(id = 15) int i11, @SafeParcelable.Param(id = 16) boolean z13, @SafeParcelable.Param(id = 18) boolean z14, @SafeParcelable.Param(id = 19) @Nullable String str7, @SafeParcelable.Param(id = 21) @Nullable Boolean bool, @SafeParcelable.Param(id = 22) long j16, @SafeParcelable.Param(id = 23) @Nullable List list, @SafeParcelable.Param(id = 24) @Nullable String str8, @SafeParcelable.Param(id = 25) String str9, @SafeParcelable.Param(id = 26) String str10, @SafeParcelable.Param(id = 27) String str11, @SafeParcelable.Param(id = 28) boolean z15, @SafeParcelable.Param(id = 29) long j17) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j13;
        this.zzd = str4;
        this.zze = j11;
        this.zzf = j12;
        this.zzg = str5;
        this.zzh = z11;
        this.zzi = z12;
        this.zzk = str6;
        this.zzl = j14;
        this.zzm = j15;
        this.zzn = i11;
        this.zzo = z13;
        this.zzp = z14;
        this.zzq = str7;
        this.zzr = bool;
        this.zzs = j16;
        this.zzt = list;
        this.zzu = str8;
        this.zzv = str9;
        this.zzw = str10;
        this.zzx = str11;
        this.zzy = z15;
        this.zzz = j17;
    }
}
