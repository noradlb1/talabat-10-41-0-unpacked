package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

public final class zzaak implements zzdc {
    public static final Parcelable.Creator<zzaak> CREATOR = new zzaai();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzaak(long j11, long j12, long j13, long j14, long j15) {
        this.zza = j11;
        this.zzb = j12;
        this.zzc = j13;
        this.zzd = j14;
        this.zze = j15;
    }

    public /* synthetic */ zzaak(Parcel parcel, zzaaj zzaaj) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaak.class == obj.getClass()) {
            zzaak zzaak = (zzaak) obj;
            return this.zza == zzaak.zza && this.zzb == zzaak.zzb && this.zzc == zzaak.zzc && this.zzd == zzaak.zzd && this.zze == zzaak.zze;
        }
    }

    public final int hashCode() {
        long j11 = this.zza;
        long j12 = this.zzb;
        long j13 = this.zzc;
        long j14 = this.zzd;
        long j15 = this.zze;
        return ((((((((((int) (j11 ^ (j11 >>> 32))) + 527) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) ((j13 >>> 32) ^ j13))) * 31) + ((int) ((j14 >>> 32) ^ j14))) * 31) + ((int) ((j15 >>> 32) ^ j15));
    }

    public final String toString() {
        long j11 = this.zza;
        long j12 = this.zzb;
        long j13 = this.zzc;
        long j14 = this.zzd;
        long j15 = this.zze;
        StringBuilder sb2 = new StringBuilder(218);
        sb2.append("Motion photo metadata: photoStartPosition=");
        sb2.append(j11);
        sb2.append(", photoSize=");
        sb2.append(j12);
        sb2.append(", photoPresentationTimestampUs=");
        sb2.append(j13);
        sb2.append(", videoStartPosition=");
        sb2.append(j14);
        sb2.append(", videoSize=");
        sb2.append(j15);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    public final /* synthetic */ void zza(zzbc zzbc) {
    }
}
