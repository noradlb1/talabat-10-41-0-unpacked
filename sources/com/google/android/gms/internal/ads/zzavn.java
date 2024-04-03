package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

public abstract class zzavn extends zzavr {
    private final SparseArray<Map<zzavd, zzavm>> zza = new SparseArray<>();
    private final SparseBooleanArray zzb = new SparseBooleanArray();
    private zzavl zzc;

    public abstract zzavh[] zzb(zzapm[] zzapmArr, zzavd[] zzavdArr, int[][][] iArr) throws zzaos;

    public final zzavs zzc(zzapm[] zzapmArr, zzavd zzavd) throws zzaos {
        zzapn zzapn;
        zzavm zzavm;
        int[] iArr;
        zzapm[] zzapmArr2 = zzapmArr;
        zzavd zzavd2 = zzavd;
        int[] iArr2 = new int[3];
        zzavc[][] zzavcArr = new zzavc[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i11 = 0; i11 < 3; i11++) {
            int i12 = zzavd2.zzb;
            zzavcArr[i11] = new zzavc[i12];
            iArr3[i11] = new int[i12][];
        }
        int i13 = 2;
        int[] iArr4 = new int[2];
        for (int i14 = 0; i14 < 2; i14++) {
            zzapmArr2[i14].zze();
            iArr4[i14] = 4;
        }
        int i15 = 0;
        while (i15 < zzavd2.zzb) {
            zzavc zzb2 = zzavd2.zzb(i15);
            int i16 = i13;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (i17 >= i13) {
                    i17 = i16;
                    break;
                }
                zzapm zzapm = zzapmArr2[i17];
                int i19 = 0;
                while (true) {
                    int i21 = zzb2.zza;
                    if (i19 > 0) {
                        break;
                    }
                    int zzG = zzapm.zzG(zzb2.zzb(i19)) & 3;
                    if (zzG > i18) {
                        if (zzG == 3) {
                            break;
                        }
                        i16 = i17;
                        i18 = zzG;
                    }
                    i19++;
                }
                i17++;
                i13 = 2;
            }
            if (i17 == 2) {
                int i22 = zzb2.zza;
                iArr = new int[1];
            } else {
                zzapm zzapm2 = zzapmArr2[i17];
                int i23 = zzb2.zza;
                int[] iArr5 = new int[1];
                for (int i24 = 0; i24 <= 0; i24++) {
                    iArr5[i24] = zzapm2.zzG(zzb2.zzb(i24));
                }
                iArr = iArr5;
            }
            int i25 = iArr2[i17];
            zzavcArr[i17][i25] = zzb2;
            iArr3[i17][i25] = iArr;
            iArr2[i17] = i25 + 1;
            i15++;
            i13 = 2;
        }
        int i26 = i13;
        zzavd[] zzavdArr = new zzavd[i26];
        int[] iArr6 = new int[i26];
        int i27 = 0;
        while (i27 < i26) {
            int i28 = iArr2[i27];
            zzavdArr[i27] = new zzavd((zzavc[]) Arrays.copyOf(zzavcArr[i27], i28));
            iArr3[i27] = (int[][]) Arrays.copyOf(iArr3[i27], i28);
            iArr6[i27] = zzapmArr2[i27].zzc();
            i27++;
            i26 = 2;
        }
        int i29 = i26;
        zzavd zzavd3 = new zzavd((zzavc[]) Arrays.copyOf(zzavcArr[i29], iArr2[i29]));
        zzavh[] zzb3 = zzb(zzapmArr2, zzavdArr, iArr3);
        int i31 = 0;
        while (i31 < i29) {
            if (this.zzb.get(i31)) {
                zzb3[i31] = null;
            } else {
                zzavd zzavd4 = zzavdArr[i31];
                Map map = this.zza.get(i31);
                if (map == null) {
                    zzavm = null;
                } else {
                    zzavm = (zzavm) map.get(zzavd4);
                }
                if (zzavm != null) {
                    throw null;
                }
            }
            i31++;
            i29 = 2;
        }
        zzavl zzavl = new zzavl(iArr6, zzavdArr, iArr4, iArr3, zzavd3);
        zzapn[] zzapnArr = new zzapn[2];
        for (int i32 = 0; i32 < 2; i32++) {
            if (zzb3[i32] != null) {
                zzapn = zzapn.zza;
            } else {
                zzapn = null;
            }
            zzapnArr[i32] = zzapn;
        }
        return new zzavs(zzavd2, new zzavp(zzb3, (byte[]) null), zzavl, zzapnArr);
    }

    public final void zzd(Object obj) {
        this.zzc = (zzavl) obj;
    }

    public final void zze(int i11, boolean z11) {
        if (this.zzb.get(i11) != z11) {
            this.zzb.put(i11, z11);
            zzg();
        }
    }
}
