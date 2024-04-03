package com.google.android.libraries.places.internal;

import android.os.Build;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

final class zzij extends zzid {
    private static final AtomicReference<zzif> zza = new AtomicReference<>();
    private static final AtomicLong zzb = new AtomicLong();
    private static final ConcurrentLinkedQueue<zzii> zzc = new ConcurrentLinkedQueue<>();
    private volatile zzhl zzd;

    private zzij(String str) {
        super(str);
        boolean z11;
        boolean z12;
        String str2 = Build.FINGERPRINT;
        boolean z13 = true;
        if (str2 == null || "robolectric".equals(str2)) {
            z11 = true;
        } else {
            z11 = false;
        }
        String str3 = Build.HARDWARE;
        if ("goldfish".equals(str3) || "ranchu".equals(str3)) {
            z12 = true;
        } else {
            z12 = false;
        }
        String str4 = Build.TYPE;
        if (!"eng".equals(str4) && !"userdebug".equals(str4)) {
            z13 = false;
        }
        if (z11 || z12) {
            this.zzd = new zzie().zza(zza());
        } else if (z13) {
            this.zzd = new zzil().zzb(false).zza(zza());
        } else {
            this.zzd = null;
        }
    }

    public static zzhl zzb(String str) {
        AtomicReference<zzif> atomicReference = zza;
        if (atomicReference.get() != null) {
            return atomicReference.get().zza(str);
        }
        zzij zzij = new zzij(str.replace('$', '.'));
        zzih.zza.offer(zzij);
        if (atomicReference.get() != null) {
            while (true) {
                zzij poll = zzih.zza.poll();
                if (poll == null) {
                    break;
                }
                poll.zzd = zza.get().zza(poll.zza());
            }
            if (zzc.poll() != null) {
                zzb.getAndDecrement();
                throw null;
            }
        }
        return zzij;
    }
}
