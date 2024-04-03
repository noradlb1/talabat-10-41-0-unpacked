package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzayq {
    @VisibleForTesting
    int zza;
    private final Object zzb = new Object();
    private final List<zzayp> zzc = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        return r1;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzayp zza(boolean r9) {
        /*
            r8 = this;
            java.lang.Object r0 = r8.zzb
            monitor-enter(r0)
            java.util.List<com.google.android.gms.internal.ads.zzayp> r1 = r8.zzc     // Catch:{ all -> 0x0061 }
            int r1 = r1.size()     // Catch:{ all -> 0x0061 }
            r2 = 0
            if (r1 != 0) goto L_0x0013
            java.lang.String r9 = "Queue empty"
            com.google.android.gms.internal.ads.zzciz.zze(r9)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r2
        L_0x0013:
            java.util.List<com.google.android.gms.internal.ads.zzayp> r1 = r8.zzc     // Catch:{ all -> 0x0061 }
            int r1 = r1.size()     // Catch:{ all -> 0x0061 }
            r3 = 2
            r4 = 0
            if (r1 < r3) goto L_0x004c
            java.util.List<com.google.android.gms.internal.ads.zzayp> r9 = r8.zzc     // Catch:{ all -> 0x0061 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0061 }
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r4
        L_0x0026:
            boolean r5 = r9.hasNext()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r9.next()     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzayp r5 = (com.google.android.gms.internal.ads.zzayp) r5     // Catch:{ all -> 0x0061 }
            int r6 = r5.zzb()     // Catch:{ all -> 0x0061 }
            if (r6 <= r1) goto L_0x0039
            r4 = r3
        L_0x0039:
            if (r6 <= r1) goto L_0x003d
            r7 = r6
            goto L_0x003e
        L_0x003d:
            r7 = r1
        L_0x003e:
            if (r6 <= r1) goto L_0x0041
            r2 = r5
        L_0x0041:
            int r3 = r3 + 1
            r1 = r7
            goto L_0x0026
        L_0x0045:
            java.util.List<com.google.android.gms.internal.ads.zzayp> r9 = r8.zzc     // Catch:{ all -> 0x0061 }
            r9.remove(r4)     // Catch:{ all -> 0x0061 }
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r2
        L_0x004c:
            java.util.List<com.google.android.gms.internal.ads.zzayp> r1 = r8.zzc     // Catch:{ all -> 0x0061 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0061 }
            com.google.android.gms.internal.ads.zzayp r1 = (com.google.android.gms.internal.ads.zzayp) r1     // Catch:{ all -> 0x0061 }
            if (r9 == 0) goto L_0x005c
            java.util.List<com.google.android.gms.internal.ads.zzayp> r9 = r8.zzc     // Catch:{ all -> 0x0061 }
            r9.remove(r4)     // Catch:{ all -> 0x0061 }
            goto L_0x005f
        L_0x005c:
            r1.zzi()     // Catch:{ all -> 0x0061 }
        L_0x005f:
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            return r1
        L_0x0061:
            r9 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0061 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayq.zza(boolean):com.google.android.gms.internal.ads.zzayp");
    }

    public final void zzb(zzayp zzayp) {
        synchronized (this.zzb) {
            if (this.zzc.size() >= 10) {
                int size = this.zzc.size();
                StringBuilder sb2 = new StringBuilder(41);
                sb2.append("Queue is full, current size = ");
                sb2.append(size);
                zzciz.zze(sb2.toString());
                this.zzc.remove(0);
            }
            int i11 = this.zza;
            this.zza = i11 + 1;
            zzayp.zzj(i11);
            zzayp.zzn();
            this.zzc.add(zzayp);
        }
    }

    public final boolean zzc(zzayp zzayp) {
        synchronized (this.zzb) {
            Iterator<zzayp> it = this.zzc.iterator();
            while (it.hasNext()) {
                zzayp next = it.next();
                if (!zzt.zzo().zzh().zzI()) {
                    if (zzayp != next && next.zzd().equals(zzayp.zzd())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzt.zzo().zzh().zzJ() && zzayp != next && next.zzf().equals(zzayp.zzf())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean zzd(zzayp zzayp) {
        synchronized (this.zzb) {
            if (this.zzc.contains(zzayp)) {
                return true;
            }
            return false;
        }
    }
}
