package com.google.android.gms.internal.ads;

import android.util.SparseArray;

final class zzrt<V> {
    private int zza;
    private final SparseArray<V> zzb;
    private final zzec<V> zzc;

    public zzrt() {
        zzrs zzrs = zzrs.zza;
        throw null;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x001a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    public final V zza(int r4) {
        /*
            r3 = this;
            int r0 = r3.zza
            r1 = -1
            if (r0 == r1) goto L_0x0006
            goto L_0x0009
        L_0x0006:
            r0 = 0
        L_0x0007:
            r3.zza = r0
        L_0x0009:
            int r0 = r3.zza
            if (r0 > 0) goto L_0x000e
            goto L_0x001a
        L_0x000e:
            android.util.SparseArray<V> r2 = r3.zzb
            int r0 = r2.keyAt(r0)
            if (r4 >= r0) goto L_0x001a
            int r0 = r3.zza
            int r0 = r0 + r1
            goto L_0x0007
        L_0x001a:
            int r0 = r3.zza
            android.util.SparseArray<V> r2 = r3.zzb
            int r2 = r2.size()
            int r2 = r2 + r1
            if (r0 >= r2) goto L_0x0038
            android.util.SparseArray<V> r0 = r3.zzb
            int r2 = r3.zza
            int r2 = r2 + 1
            int r0 = r0.keyAt(r2)
            if (r4 < r0) goto L_0x0038
            int r0 = r3.zza
            int r0 = r0 + 1
            r3.zza = r0
            goto L_0x001a
        L_0x0038:
            android.util.SparseArray<V> r4 = r3.zzb
            int r0 = r3.zza
            java.lang.Object r4 = r4.valueAt(r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrt.zza(int):java.lang.Object");
    }

    public final V zzb() {
        SparseArray<V> sparseArray = this.zzb;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public final void zzc(int i11, V v11) {
        boolean z11;
        boolean z12 = true;
        if (this.zza == -1) {
            if (this.zzb.size() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzdy.zzf(z11);
            this.zza = 0;
        }
        if (this.zzb.size() > 0) {
            SparseArray<V> sparseArray = this.zzb;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i11 < keyAt) {
                z12 = false;
            }
            zzdy.zzd(z12);
            if (keyAt == i11) {
                SparseArray<V> sparseArray2 = this.zzb;
                zzrm.zzl((zzrk) sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.zzb.append(i11, v11);
    }

    public final void zzd() {
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            zzrm.zzl((zzrk) this.zzb.valueAt(i11));
        }
        this.zza = -1;
        this.zzb.clear();
    }

    public final void zze(int i11) {
        int i12 = 0;
        while (i12 < this.zzb.size() - 1) {
            int i13 = i12 + 1;
            if (i11 >= this.zzb.keyAt(i13)) {
                zzrm.zzl((zzrk) this.zzb.valueAt(i12));
                this.zzb.removeAt(i12);
                int i14 = this.zza;
                if (i14 > 0) {
                    this.zza = i14 - 1;
                }
                i12 = i13;
            } else {
                return;
            }
        }
    }

    public final boolean zzf() {
        return this.zzb.size() == 0;
    }

    public zzrt(zzec<V> zzec) {
        this.zzb = new SparseArray<>();
        this.zzc = zzec;
        this.zza = -1;
    }
}
