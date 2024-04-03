package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdea;
import javax.annotation.concurrent.GuardedBy;

public final class zzfgp<R extends zzdea<AdT>, AdT extends zzdav> {
    private final zzfgi<R, AdT> zza;
    private final zzfxa<zzfgg<R, AdT>> zzb;
    @GuardedBy("this")
    private boolean zzc = false;
    @GuardedBy("this")
    private boolean zzd = false;

    public zzfgp(zzffn zzffn, zzfgh<R, AdT> zzfgh, zzfgi<R, AdT> zzfgi) {
        this.zza = zzfgi;
        this.zzb = zzfwq.zzg(zzfwq.zzn(zzfgh.zza(zzfgi), new zzfgn(this, zzfgh, zzffn, zzfgi), zzfgi.zzb()), Exception.class, new zzfgm(this, zzfgh), zzfgi.zzb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzfxa<com.google.android.gms.internal.ads.zzfgg<R, AdT>> zza(com.google.android.gms.internal.ads.zzfgi<R, AdT> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzd     // Catch:{ all -> 0x0035 }
            r1 = 0
            if (r0 != 0) goto L_0x0033
            boolean r0 = r2.zzc     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x000b
            goto L_0x0033
        L_0x000b:
            com.google.android.gms.internal.ads.zzfgi<R, AdT> r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzffx r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzffx r0 = r3.zza()     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzfgi<R, AdT> r0 = r2.zza     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzffx r0 = r0.zza()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzffx r3 = r3.zza()     // Catch:{ all -> 0x0035 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            r3 = 1
            r2.zzc = r3     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzfxa<com.google.android.gms.internal.ads.zzfgg<R, AdT>> r3 = r2.zzb     // Catch:{ all -> 0x0035 }
            monitor-exit(r2)
            return r3
        L_0x0031:
            monitor-exit(r2)
            return r1
        L_0x0033:
            monitor-exit(r2)
            return r1
        L_0x0035:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfgp.zza(com.google.android.gms.internal.ads.zzfgi):com.google.android.gms.internal.ads.zzfxa");
    }

    public final /* synthetic */ zzfxa zzb(zzfgh zzfgh, zzffn zzffn, zzfgi zzfgi, zzffw zzffw) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfgh.zzb(zzffw);
            if (!this.zzc) {
                zzffn.zzd(zzfgi.zza(), zzffw);
                zzfxa zzi = zzfwq.zzi(null);
                return zzi;
            }
            zzfxa zzi2 = zzfwq.zzi(new zzfgg(zzffw, zzfgi));
            return zzi2;
        }
    }

    public final /* synthetic */ zzfxa zzc(zzfgh zzfgh, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzfwm<Void> zzfwm) {
        zzfwq.zzr(zzfwq.zzn(this.zzb, zzfgo.zza, this.zza.zzb()), zzfwm, this.zza.zzb());
    }
}
