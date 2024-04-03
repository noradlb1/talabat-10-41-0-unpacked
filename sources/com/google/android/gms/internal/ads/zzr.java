package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.UUID;

public final class zzr implements Parcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzq();
    public final UUID zza;
    @Nullable
    public final String zzb;
    public final String zzc;
    @Nullable
    public final byte[] zzd;
    private int zze;

    public zzr(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zzc = readString;
        this.zzd = parcel.createByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzr)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzr zzr = (zzr) obj;
        if (!zzfn.zzP(this.zzb, zzr.zzb) || !zzfn.zzP(this.zzc, zzr.zzc) || !zzfn.zzP(this.zza, zzr.zza) || !Arrays.equals(this.zzd, zzr.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i11;
        int i12 = this.zze;
        if (i12 != 0) {
            return i12;
        }
        int hashCode = this.zza.hashCode() * 31;
        String str = this.zzb;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        int hashCode2 = ((((hashCode + i11) * 31) + this.zzc.hashCode()) * 31) + Arrays.hashCode(this.zzd);
        this.zze = hashCode2;
        return hashCode2;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzr(UUID uuid, @Nullable String str, String str2, @Nullable byte[] bArr) {
        uuid.getClass();
        this.zza = uuid;
        this.zzb = null;
        this.zzc = str2;
        this.zzd = bArr;
    }
}
