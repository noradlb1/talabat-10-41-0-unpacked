package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

final class zzij extends zzfp {
    private final int zzc;
    private final int zzd;
    private final int[] zze;
    private final int[] zzf;
    private final zzcd[] zzg;
    private final Object[] zzh;
    private final HashMap<Object, Integer> zzi = new HashMap<>();

    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.android.gms.internal.ads.zzrq, java.util.Collection<? extends com.google.android.gms.internal.ads.zzhy>] */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzij(java.util.Collection r5, java.util.Collection<? extends com.google.android.gms.internal.ads.zzhy> r6, com.google.android.gms.internal.ads.zzrq r7) {
        /*
            r4 = this;
            r7 = 0
            r0 = 0
            r4.<init>(r0, r6, r7)
            int r6 = r5.size()
            int[] r7 = new int[r6]
            r4.zze = r7
            int[] r7 = new int[r6]
            r4.zzf = r7
            com.google.android.gms.internal.ads.zzcd[] r7 = new com.google.android.gms.internal.ads.zzcd[r6]
            r4.zzg = r7
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.zzh = r6
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            r4.zzi = r6
            java.util.Iterator r5 = r5.iterator()
            r6 = r0
            r7 = r6
        L_0x0026:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x006d
            java.lang.Object r1 = r5.next()
            com.google.android.gms.internal.ads.zzhy r1 = (com.google.android.gms.internal.ads.zzhy) r1
            com.google.android.gms.internal.ads.zzcd[] r2 = r4.zzg
            com.google.android.gms.internal.ads.zzcd r3 = r1.zza()
            r2[r7] = r3
            int[] r2 = r4.zzf
            r2[r7] = r0
            int[] r2 = r4.zze
            r2[r7] = r6
            com.google.android.gms.internal.ads.zzcd[] r2 = r4.zzg
            r2 = r2[r7]
            int r2 = r2.zzc()
            int r0 = r0 + r2
            com.google.android.gms.internal.ads.zzcd[] r2 = r4.zzg
            r2 = r2[r7]
            int r2 = r2.zzb()
            int r6 = r6 + r2
            java.lang.Object[] r2 = r4.zzh
            java.lang.Object r1 = r1.zzb()
            r2[r7] = r1
            int r1 = r7 + 1
            java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r4.zzi
            java.lang.Object[] r3 = r4.zzh
            r3 = r3[r7]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r2.put(r3, r7)
            r7 = r1
            goto L_0x0026
        L_0x006d:
            r4.zzc = r0
            r4.zzd = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzij.<init>(java.util.Collection, com.google.android.gms.internal.ads.zzrq, byte[]):void");
    }

    public final int zzb() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzp(Object obj) {
        Integer num = this.zzi.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final int zzq(int i11) {
        return zzfn.zzc(this.zze, i11 + 1, false, false);
    }

    public final int zzr(int i11) {
        return zzfn.zzc(this.zzf, i11 + 1, false, false);
    }

    public final int zzs(int i11) {
        return this.zze[i11];
    }

    public final int zzt(int i11) {
        return this.zzf[i11];
    }

    public final zzcd zzu(int i11) {
        return this.zzg[i11];
    }

    public final Object zzv(int i11) {
        return this.zzh[i11];
    }

    public final List<zzcd> zzw() {
        return Arrays.asList(this.zzg);
    }
}
