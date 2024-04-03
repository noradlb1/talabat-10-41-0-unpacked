package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzang extends zzaoa {
    private final long zzi;

    public zzang(zzams zzams, String str, String str2, zzaiz zzaiz, long j11, int i11, int i12) {
        super(zzams, "llxemQySqp4ImE2+K1SCPJZsWjXNCqydynC9yBT/03FiPJ85o8JSvF0iMBwiw5vV", "Do3k5DuMuAsRGeDxKZVVE8+FSftLk9ZlBUPdFxDzrUE=", zzaiz, i11, 25);
        this.zzi = j11;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zze) {
            this.zze.zzr(longValue);
            long j11 = this.zzi;
            if (j11 != 0) {
                this.zze.zzO(longValue - j11);
                this.zze.zzP(this.zzi);
            }
        }
    }
}
