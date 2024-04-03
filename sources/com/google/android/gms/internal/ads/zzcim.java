package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import javax.annotation.concurrent.GuardedBy;

public final class zzcim {
    @GuardedBy("this")
    private BigInteger zza = BigInteger.ONE;
    @GuardedBy("this")
    private String zzb = "0";

    public final synchronized String zza() {
        String bigInteger;
        bigInteger = this.zza.toString();
        this.zza = this.zza.add(BigInteger.ONE);
        this.zzb = bigInteger;
        return bigInteger;
    }

    public final synchronized String zzb() {
        return this.zzb;
    }
}
