package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import java.util.Arrays;

public final class zzzl extends zzzu {
    public static final Parcelable.Creator<zzzl> CREATOR = new zzzk();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzzu[] zze;

    public zzzl(Parcel parcel) {
        super(ChapterTocFrame.ID);
        String readString = parcel.readString();
        int i11 = zzfn.zza;
        this.zza = readString;
        boolean z11 = true;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() == 0 ? false : z11;
        this.zzd = (String[]) zzfn.zzC(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.zze = new zzzu[readInt];
        for (int i12 = 0; i12 < readInt; i12++) {
            this.zze[i12] = (zzzu) parcel.readParcelable(zzzu.class.getClassLoader());
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzl.class == obj.getClass()) {
            zzzl zzzl = (zzzl) obj;
            if (this.zzb != zzzl.zzb || this.zzc != zzzl.zzc || !zzfn.zzP(this.zza, zzzl.zza) || !Arrays.equals(this.zzd, zzzl.zzd) || !Arrays.equals(this.zze, zzzl.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11 = ((((this.zzb ? 1 : 0) + true) * 31) + (this.zzc ? 1 : 0)) * 31;
        String str = this.zza;
        return i11 + (str != null ? str.hashCode() : 0);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : 0);
        parcel.writeByte(this.zzc ? (byte) 1 : 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzzu writeParcelable : this.zze) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public zzzl(String str, boolean z11, boolean z12, String[] strArr, zzzu[] zzzuArr) {
        super(ChapterTocFrame.ID);
        this.zza = str;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = strArr;
        this.zze = zzzuArr;
    }
}
