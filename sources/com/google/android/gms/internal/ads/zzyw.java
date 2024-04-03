package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;

public final class zzyw implements zzdc {
    public static final Parcelable.Creator<zzyw> CREATOR = new zzyv();
    private static final zzab zzf;
    private static final zzab zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzh;

    static {
        zzz zzz = new zzz();
        zzz.zzS(MimeTypes.APPLICATION_ID3);
        zzf = zzz.zzY();
        zzz zzz2 = new zzz();
        zzz2.zzS(MimeTypes.APPLICATION_SCTE35);
        zzg = zzz2.zzY();
    }

    public zzyw(Parcel parcel) {
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = (byte[]) zzfn.zzC(parcel.createByteArray());
    }

    public zzyw(String str, String str2, long j11, long j12, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j11;
        this.zzd = j12;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzyw.class == obj.getClass()) {
            zzyw zzyw = (zzyw) obj;
            if (this.zzc != zzyw.zzc || this.zzd != zzyw.zzd || !zzfn.zzP(this.zza, zzyw.zza) || !zzfn.zzP(this.zzb, zzyw.zzb) || !Arrays.equals(this.zze, zzyw.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int i12 = this.zzh;
        if (i12 != 0) {
            return i12;
        }
        String str = this.zza;
        int i13 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = (i11 + 527) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i13 = str2.hashCode();
        }
        long j11 = this.zzc;
        long j12 = this.zzd;
        int hashCode = ((((((i14 + i13) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) ((j12 >>> 32) ^ j12))) * 31) + Arrays.hashCode(this.zze);
        this.zzh = hashCode;
        return hashCode;
    }

    public final String toString() {
        String str = this.zza;
        long j11 = this.zzd;
        long j12 = this.zzc;
        String str2 = this.zzb;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 79 + String.valueOf(str2).length());
        sb2.append("EMSG: scheme=");
        sb2.append(str);
        sb2.append(", id=");
        sb2.append(j11);
        sb2.append(", durationMs=");
        sb2.append(j12);
        sb2.append(", value=");
        sb2.append(str2);
        return sb2.toString();
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final /* synthetic */ void zza(zzbc zzbc) {
    }
}
