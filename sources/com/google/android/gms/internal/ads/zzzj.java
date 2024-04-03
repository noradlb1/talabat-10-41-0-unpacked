package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import java.util.Arrays;

public final class zzzj extends zzzu {
    public static final Parcelable.Creator<zzzj> CREATOR = new zzzi();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzzu[] zzg;

    public zzzj(Parcel parcel) {
        super(ChapterFrame.ID);
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzg = new zzzu[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            this.zzg[i12] = (zzzu) parcel.readParcelable(zzzu.class.getClassLoader());
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzj.class == obj.getClass()) {
            zzzj zzzj = (zzzj) obj;
            if (this.zzb == zzzj.zzb && this.zzc == zzzj.zzc && this.zzd == zzzj.zzd && this.zze == zzzj.zze && zzfn.zzP(this.zza, zzzj.zza) && Arrays.equals(this.zzg, zzzj.zzg)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = (((((((this.zzb + 527) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 31;
        String str = this.zza;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        for (zzzu writeParcelable : this.zzg) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public zzzj(String str, int i11, int i12, long j11, long j12, zzzu[] zzzuArr) {
        super(ChapterFrame.ID);
        this.zza = str;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = j11;
        this.zze = j12;
        this.zzg = zzzuArr;
    }
}
