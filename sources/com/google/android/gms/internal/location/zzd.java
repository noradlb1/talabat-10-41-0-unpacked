package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getUid", id = 1)
    private final int zza;
    @SafeParcelable.Field(getter = "getPid", id = 2)
    private final int zzb;
    @SafeParcelable.Field(getter = "getPackageName", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getAttributionTag", id = 4)
    @Nullable
    private final String zzd;
    @SafeParcelable.Field(getter = "getClientSdkVersion", id = 5)
    private final int zze;
    @SafeParcelable.Field(getter = "getListenerId", id = 6)
    @Nullable
    private final String zzf;
    @SafeParcelable.Field(getter = "getImpersonator", id = 7)
    @Nullable
    private final zzd zzg;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.common.collect.ImmutableList.of()", getter = "getClientFeatures", id = 8)
    private final List zzh;

    static {
        Process.myUid();
        Process.myPid();
    }

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) int i12, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable String str2, @SafeParcelable.Param(id = 6) @Nullable String str3, @SafeParcelable.Param(id = 5) int i13, @SafeParcelable.Param(id = 8) List list, @SafeParcelable.Param(id = 7) @Nullable zzd zzd2) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = str3;
        this.zze = i13;
        this.zzh = zzds.zzj(list);
        this.zzg = zzd2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzd) {
            zzd zzd2 = (zzd) obj;
            if (this.zza != zzd2.zza || this.zzb != zzd2.zzb || this.zze != zzd2.zze || !this.zzc.equals(zzd2.zzc) || !zzdl.zza(this.zzd, zzd2.zzd) || !zzdl.zza(this.zzf, zzd2.zzf) || !zzdl.zza(this.zzg, zzd2.zzg) || !this.zzh.equals(zzd2.zzh)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), this.zzc, this.zzd, this.zzf});
    }

    public final String toString() {
        int length = this.zzc.length() + 18;
        String str = this.zzd;
        if (str != null) {
            length += str.length();
        }
        StringBuilder sb2 = new StringBuilder(length);
        sb2.append(this.zza);
        sb2.append("/");
        sb2.append(this.zzc);
        if (this.zzd != null) {
            sb2.append("[");
            if (this.zzd.startsWith(this.zzc)) {
                sb2.append(this.zzd, this.zzc.length(), this.zzd.length());
            } else {
                sb2.append(this.zzd);
            }
            sb2.append("]");
        }
        if (this.zzf != null) {
            sb2.append("/");
            sb2.append(Integer.toHexString(this.zzf.hashCode()));
        }
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i11, false);
        SafeParcelWriter.writeTypedList(parcel, 8, this.zzh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
