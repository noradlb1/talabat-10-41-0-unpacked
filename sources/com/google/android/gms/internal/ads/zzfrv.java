package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfrv extends AbstractSet<Map.Entry> {
    final /* synthetic */ zzfsb zza;

    public zzfrv(zzfsb zzfsb) {
        this.zza = zzfsb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzd = this.zza.zzw(entry.getKey());
            if (zzd == -1 || !zzfqc.zza(zzfsb.zzj(this.zza, zzd), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator<Map.Entry> iterator() {
        zzfsb zzfsb = this.zza;
        Map zzl = zzfsb.zzl();
        if (zzl != null) {
            return zzl.entrySet().iterator();
        }
        return new zzfrt(zzfsb);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        r0 = com.google.android.gms.internal.ads.zzfsb.zzc(r9.zza);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean remove(@javax.annotation.CheckForNull java.lang.Object r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzfsb r0 = r9.zza
            java.util.Map r0 = r0.zzl()
            if (r0 == 0) goto L_0x0011
            java.util.Set r0 = r0.entrySet()
            boolean r10 = r0.remove(r10)
            return r10
        L_0x0011:
            boolean r0 = r10 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L_0x0066
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            com.google.android.gms.internal.ads.zzfsb r0 = r9.zza
            boolean r0 = r0.zzr()
            if (r0 == 0) goto L_0x0021
            return r1
        L_0x0021:
            com.google.android.gms.internal.ads.zzfsb r0 = r9.zza
            int r0 = r0.zzv()
            java.lang.Object r2 = r10.getKey()
            java.lang.Object r3 = r10.getValue()
            com.google.android.gms.internal.ads.zzfsb r10 = r9.zza
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzfsb.zzi(r10)
            com.google.android.gms.internal.ads.zzfsb r10 = r9.zza
            int[] r6 = r10.zzA()
            com.google.android.gms.internal.ads.zzfsb r10 = r9.zza
            java.lang.Object[] r7 = r10.zzB()
            com.google.android.gms.internal.ads.zzfsb r10 = r9.zza
            java.lang.Object[] r8 = r10.zzC()
            r4 = r0
            int r10 = com.google.android.gms.internal.ads.zzfsc.zzb(r2, r3, r4, r5, r6, r7, r8)
            r2 = -1
            if (r10 != r2) goto L_0x0050
            return r1
        L_0x0050:
            com.google.android.gms.internal.ads.zzfsb r1 = r9.zza
            r1.zzq(r10, r0)
            com.google.android.gms.internal.ads.zzfsb r10 = r9.zza
            int r0 = r10.zzg
            int r0 = r0 + r2
            r10.zzg = r0
            com.google.android.gms.internal.ads.zzfsb r10 = r9.zza
            r10.zzo()
            r10 = 1
            return r10
        L_0x0066:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfrv.remove(java.lang.Object):boolean");
    }

    public final int size() {
        return this.zza.size();
    }
}
