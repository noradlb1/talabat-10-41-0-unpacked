package com.google.android.gms.internal.ads;

import android.util.Log;
import java.nio.ByteBuffer;

final class zzoa {
    private long zza;
    private long zzb;
    private boolean zzc;

    private final long zzd(long j11) {
        return this.zza + Math.max(0, ((this.zzb - 529) * 1000000) / j11);
    }

    public final long zza(zzab zzab) {
        return zzd((long) zzab.zzA);
    }

    public final long zzb(zzab zzab, zzda zzda) {
        if (this.zzb == 0) {
            this.zza = zzda.zzd;
        }
        if (this.zzc) {
            return zzda.zzd;
        }
        ByteBuffer byteBuffer = zzda.zzb;
        byteBuffer.getClass();
        byte b11 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            b11 = (b11 << 8) | (byteBuffer.get(i11) & 255);
        }
        int zzc2 = zzxk.zzc(b11);
        if (zzc2 == -1) {
            this.zzc = true;
            this.zzb = 0;
            this.zza = zzda.zzd;
            Log.w("C2Mp3TimestampTracker", "MPEG audio header is invalid.");
            return zzda.zzd;
        }
        long zzd = zzd((long) zzab.zzA);
        this.zzb += (long) zzc2;
        return zzd;
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = 0;
        this.zzc = false;
    }
}
