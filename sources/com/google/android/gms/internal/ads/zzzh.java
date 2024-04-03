package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzzh extends zzzu {
    public static final Parcelable.Creator<zzzh> CREATOR = new zzzg();
    public final byte[] zza;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzzh(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzfn.zza
            r2.<init>(r0)
            byte[] r3 = r3.createByteArray()
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzfn.zzC(r3)
            byte[] r3 = (byte[]) r3
            r2.zza = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzh.<init>(android.os.Parcel):void");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzh.class == obj.getClass()) {
            zzzh zzzh = (zzzh) obj;
            if (!this.zzf.equals(zzzh.zzf) || !Arrays.equals(this.zza, zzzh.zza)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzf.hashCode() + 527) * 31) + Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }

    public zzzh(String str, byte[] bArr) {
        super(str);
        this.zza = bArr;
    }
}
