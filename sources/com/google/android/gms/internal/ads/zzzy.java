package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import java.util.Arrays;

public final class zzzy extends zzzu {
    public static final Parcelable.Creator<zzzy> CREATOR = new zzzx();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzzy(int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        super(MlltFrame.ID);
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzy.class == obj.getClass()) {
            zzzy zzzy = (zzzy) obj;
            if (this.zza == zzzy.zza && this.zzb == zzzy.zzb && this.zzc == zzzy.zzc && Arrays.equals(this.zzd, zzzy.zzd) && Arrays.equals(this.zze, zzzy.zze)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }

    public zzzy(Parcel parcel) {
        super(MlltFrame.ID);
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = (int[]) zzfn.zzC(parcel.createIntArray());
        this.zze = (int[]) zzfn.zzC(parcel.createIntArray());
    }
}
