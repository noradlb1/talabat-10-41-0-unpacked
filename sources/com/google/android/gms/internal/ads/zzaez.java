package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public final class zzaez implements zzwp {
    public static final zzww zza = zzaew.zza;
    /* access modifiers changed from: private */
    public final List<zzfk> zzb;
    private final zzfd zzc;
    private final SparseIntArray zzd;
    /* access modifiers changed from: private */
    public final zzafc zze;
    /* access modifiers changed from: private */
    public final SparseArray<zzafe> zzf;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzg;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzh;
    private final zzaev zzi;
    private zzaeu zzj;
    /* access modifiers changed from: private */
    public zzws zzk;
    /* access modifiers changed from: private */
    public int zzl;
    /* access modifiers changed from: private */
    public boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp;
    /* access modifiers changed from: private */
    public int zzq;

    public zzaez() {
        this(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ae, code lost:
        if (r2 == false) goto L_0x01b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzwq r19, com.google.android.gms.internal.ads.zzxm r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            long r11 = r19.zzc()
            boolean r3 = r0.zzm
            r13 = -1
            r15 = 1
            r10 = 0
            if (r3 == 0) goto L_0x00a8
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0028
            com.google.android.gms.internal.ads.zzaev r3 = r0.zzi
            boolean r3 = r3.zzd()
            if (r3 == 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            com.google.android.gms.internal.ads.zzaev r3 = r0.zzi
            int r4 = r0.zzq
            int r1 = r3.zza(r1, r2, r4)
            return r1
        L_0x0028:
            boolean r3 = r0.zzn
            r7 = 0
            if (r3 != 0) goto L_0x007d
            r0.zzn = r15
            com.google.android.gms.internal.ads.zzaev r3 = r0.zzi
            long r3 = r3.zzb()
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x006b
            com.google.android.gms.internal.ads.zzaeu r9 = new com.google.android.gms.internal.ads.zzaeu
            com.google.android.gms.internal.ads.zzaev r3 = r0.zzi
            com.google.android.gms.internal.ads.zzfk r4 = r3.zzc()
            com.google.android.gms.internal.ads.zzaev r3 = r0.zzi
            long r5 = r3.zzb()
            int r3 = r0.zzq
            r16 = 112800(0x1b8a0, float:1.58066E-40)
            r17 = r3
            r3 = r9
            r13 = r7
            r7 = r11
            r15 = r9
            r9 = r17
            r10 = r16
            r3.<init>(r4, r5, r7, r9, r10)
            r0.zzj = r15
            com.google.android.gms.internal.ads.zzws r3 = r0.zzk
            com.google.android.gms.internal.ads.zzxp r4 = r15.zzb()
            r3.zzL(r4)
            goto L_0x007e
        L_0x006b:
            r13 = r7
            com.google.android.gms.internal.ads.zzws r3 = r0.zzk
            com.google.android.gms.internal.ads.zzxo r4 = new com.google.android.gms.internal.ads.zzxo
            com.google.android.gms.internal.ads.zzaev r5 = r0.zzi
            long r5 = r5.zzb()
            r4.<init>(r5, r13)
            r3.zzL(r4)
            goto L_0x007e
        L_0x007d:
            r13 = r7
        L_0x007e:
            boolean r3 = r0.zzo
            if (r3 == 0) goto L_0x0095
            r3 = 0
            r0.zzo = r3
            r0.zzc(r13, r13)
            long r4 = r19.zze()
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0091
            goto L_0x0096
        L_0x0091:
            r2.zza = r13
            r1 = 1
            return r1
        L_0x0095:
            r3 = 0
        L_0x0096:
            com.google.android.gms.internal.ads.zzaeu r4 = r0.zzj
            if (r4 == 0) goto L_0x00a9
            boolean r4 = r4.zze()
            if (r4 != 0) goto L_0x00a1
            goto L_0x00a9
        L_0x00a1:
            com.google.android.gms.internal.ads.zzaeu r3 = r0.zzj
            int r1 = r3.zza(r1, r2)
            return r1
        L_0x00a8:
            r3 = r10
        L_0x00a9:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            byte[] r2 = r2.zzH()
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            int r4 = r4.zzc()
            int r4 = 9400 - r4
            r5 = 188(0xbc, float:2.63E-43)
            if (r4 < r5) goto L_0x00bc
            goto L_0x00d2
        L_0x00bc:
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            int r4 = r4.zza()
            if (r4 <= 0) goto L_0x00cd
            com.google.android.gms.internal.ads.zzfd r6 = r0.zzc
            int r6 = r6.zzc()
            java.lang.System.arraycopy(r2, r6, r2, r3, r4)
        L_0x00cd:
            com.google.android.gms.internal.ads.zzfd r6 = r0.zzc
            r6.zzD(r2, r4)
        L_0x00d2:
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            int r4 = r4.zza()
            r6 = -1
            if (r4 >= r5) goto L_0x00f1
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            int r4 = r4.zzd()
            int r7 = 9400 - r4
            int r7 = r1.zzg(r2, r4, r7)
            if (r7 != r6) goto L_0x00ea
            return r6
        L_0x00ea:
            com.google.android.gms.internal.ads.zzfd r6 = r0.zzc
            int r4 = r4 + r7
            r6.zzE(r4)
            goto L_0x00d2
        L_0x00f1:
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzc
            int r1 = r1.zzc()
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            int r2 = r2.zzd()
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            byte[] r4 = r4.zzH()
            int r4 = com.google.android.gms.internal.ads.zzaff.zza(r4, r1, r2)
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzc
            r5.zzF(r4)
            int r5 = r4 + 188
            if (r5 <= r2) goto L_0x0117
            int r2 = r0.zzp
            int r4 = r4 - r1
            int r2 = r2 + r4
            r0.zzp = r2
            goto L_0x0119
        L_0x0117:
            r0.zzp = r3
        L_0x0119:
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzc
            int r1 = r1.zzd()
            if (r5 <= r1) goto L_0x0122
            return r3
        L_0x0122:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            int r2 = r2.zze()
            r4 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 & r2
            if (r4 == 0) goto L_0x0133
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzc
            r1.zzF(r5)
            return r3
        L_0x0133:
            r4 = 4194304(0x400000, float:5.877472E-39)
            r4 = r4 & r2
            if (r4 == 0) goto L_0x013a
            r10 = 1
            goto L_0x013b
        L_0x013a:
            r10 = r3
        L_0x013b:
            int r4 = r2 >> 8
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r7 = r2 & 32
            r8 = r2 & 16
            if (r8 == 0) goto L_0x014e
            android.util.SparseArray<com.google.android.gms.internal.ads.zzafe> r8 = r0.zzf
            java.lang.Object r8 = r8.get(r4)
            com.google.android.gms.internal.ads.zzafe r8 = (com.google.android.gms.internal.ads.zzafe) r8
            goto L_0x014f
        L_0x014e:
            r8 = 0
        L_0x014f:
            if (r8 != 0) goto L_0x0157
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzc
            r1.zzF(r5)
            return r3
        L_0x0157:
            r2 = r2 & 15
            android.util.SparseIntArray r9 = r0.zzd
            int r13 = r2 + -1
            int r9 = r9.get(r4, r13)
            android.util.SparseIntArray r13 = r0.zzd
            r13.put(r4, r2)
            if (r9 != r2) goto L_0x016e
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzc
            r1.zzF(r5)
            return r3
        L_0x016e:
            r13 = 1
            int r9 = r9 + r13
            r9 = r9 & 15
            if (r2 == r9) goto L_0x0177
            r8.zzc()
        L_0x0177:
            if (r7 == 0) goto L_0x0193
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            int r2 = r2.zzk()
            com.google.android.gms.internal.ads.zzfd r7 = r0.zzc
            int r7 = r7.zzk()
            r7 = r7 & 64
            if (r7 == 0) goto L_0x018b
            r7 = 2
            goto L_0x018c
        L_0x018b:
            r7 = r3
        L_0x018c:
            r10 = r10 | r7
            com.google.android.gms.internal.ads.zzfd r7 = r0.zzc
            int r2 = r2 + r6
            r7.zzG(r2)
        L_0x0193:
            boolean r2 = r0.zzm
            if (r2 != 0) goto L_0x019f
            android.util.SparseBooleanArray r6 = r0.zzh
            boolean r4 = r6.get(r4, r3)
            if (r4 != 0) goto L_0x01b0
        L_0x019f:
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            r4.zzE(r5)
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            r8.zza(r4, r10)
            com.google.android.gms.internal.ads.zzfd r4 = r0.zzc
            r4.zzE(r1)
            if (r2 != 0) goto L_0x01bd
        L_0x01b0:
            boolean r1 = r0.zzm
            if (r1 == 0) goto L_0x01bd
            r1 = -1
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x01bd
            r1 = 1
            r0.zzo = r1
        L_0x01bd:
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzc
            r1.zzF(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaez.zza(com.google.android.gms.internal.ads.zzwq, com.google.android.gms.internal.ads.zzxm):int");
    }

    public final void zzb(zzws zzws) {
        this.zzk = zzws;
    }

    public final void zzc(long j11, long j12) {
        zzaeu zzaeu;
        int size = this.zzb.size();
        for (int i11 = 0; i11 < size; i11++) {
            zzfk zzfk = this.zzb.get(i11);
            if (zzfk.zze() != C.TIME_UNSET) {
                long zzc2 = zzfk.zzc();
                if (zzc2 != C.TIME_UNSET) {
                    if (zzc2 != 0) {
                        if (zzc2 == j12) {
                        }
                    }
                }
            }
            zzfk.zzf(j12);
        }
        if (!(j12 == 0 || (zzaeu = this.zzj) == null)) {
            zzaeu.zzd(j12);
        }
        this.zzc.zzC(0);
        this.zzd.clear();
        for (int i12 = 0; i12 < this.zzf.size(); i12++) {
            this.zzf.valueAt(i12).zzc();
        }
        this.zzp = 0;
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        byte[] zzH = this.zzc.zzH();
        zzwk zzwk = (zzwk) zzwq;
        zzwk.zzm(zzH, 0, 940, false);
        int i11 = 0;
        while (i11 < 188) {
            int i12 = 0;
            while (i12 < 5) {
                if (zzH[(i12 * 188) + i11] != 71) {
                    i11++;
                } else {
                    i12++;
                }
            }
            zzwk.zzo(i11, false);
            return true;
        }
        return false;
    }

    public zzaez(int i11) {
        this(1, 0, TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public zzaez(int i11, int i12, int i13) {
        zzfk zzfk = new zzfk(0);
        this.zze = new zzado(0);
        this.zzb = Collections.singletonList(zzfk);
        this.zzc = new zzfd(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzg = sparseBooleanArray;
        this.zzh = new SparseBooleanArray();
        SparseArray<zzafe> sparseArray = new SparseArray<>();
        this.zzf = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzi = new zzaev(TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
        this.zzk = zzws.zza;
        this.zzq = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i14 = 0; i14 < size; i14++) {
            this.zzf.put(sparseArray2.keyAt(i14), (zzafe) sparseArray2.valueAt(i14));
        }
        this.zzf.put(0, new zzaer(new zzaex(this)));
    }
}
