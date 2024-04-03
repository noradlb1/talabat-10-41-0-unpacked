package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Arrays;

public abstract class zzst extends zzsv {
    @Nullable
    private zzss zza;

    public abstract Pair<zzin[], zzsb[]> zzb(zzss zzss, int[][][] iArr, int[] iArr2, zzpz zzpz, zzcd zzcd) throws zzgg;

    public final zzsw zzi(zzim[] zzimArr, zzch zzch, zzpz zzpz, zzcd zzcd) throws zzgg {
        boolean z11;
        char c11;
        int[] iArr;
        boolean z12;
        zzch zzch2 = zzch;
        int[] iArr2 = new int[3];
        zzcf[][] zzcfArr = new zzcf[3][];
        int[][][] iArr3 = new int[3][][];
        int i11 = 0;
        for (int i12 = 0; i12 < 3; i12++) {
            int i13 = zzch2.zzc;
            zzcfArr[i12] = new zzcf[i13];
            iArr3[i12] = new int[i13][];
        }
        int i14 = 2;
        int[] iArr4 = new int[2];
        for (int i15 = 0; i15 < 2; i15++) {
            iArr4[i15] = zzimArr[i15].zze();
        }
        int i16 = 0;
        while (i16 < zzch2.zzc) {
            zzcf zzb = zzch2.zzb(i16);
            int zza2 = zzbi.zza(zzb.zzb(i11).zzm);
            int i17 = i14;
            int i18 = i11;
            int i19 = i18;
            boolean z13 = true;
            while (i18 < i14) {
                zzim zzim = zzimArr[i18];
                int i21 = i11;
                while (i11 <= 0) {
                    i21 = Math.max(i21, zzim.zzN(zzb.zzb(i11)) & 7);
                    i11++;
                }
                if (iArr2[i18] == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (i21 > i19) {
                    z13 = z12;
                    i17 = i18;
                    i19 = i21;
                } else if (i21 == i19 && zza2 == 5 && !z13 && z12) {
                    i17 = i18;
                    i19 = i21;
                    z13 = true;
                }
                i18++;
                i14 = 2;
                i11 = 0;
            }
            if (i17 == i14) {
                iArr = new int[1];
            } else {
                zzim zzim2 = zzimArr[i17];
                int[] iArr5 = new int[1];
                for (int i22 = 0; i22 <= 0; i22++) {
                    iArr5[i22] = zzim2.zzN(zzb.zzb(i22));
                }
                iArr = iArr5;
            }
            int i23 = iArr2[i17];
            zzcfArr[i17][i23] = zzb;
            iArr3[i17][i23] = iArr;
            iArr2[i17] = i23 + 1;
            i16++;
            i14 = 2;
            i11 = 0;
        }
        zzch[] zzchArr = new zzch[i14];
        String[] strArr = new String[i14];
        int[] iArr6 = new int[i14];
        int i24 = 0;
        while (i24 < i14) {
            int i25 = iArr2[i24];
            zzchArr[i24] = new zzch((zzcf[]) zzfn.zzaa(zzcfArr[i24], i25));
            iArr3[i24] = (int[][]) zzfn.zzaa(iArr3[i24], i25);
            strArr[i24] = zzimArr[i24].zzJ();
            iArr6[i24] = zzimArr[i24].zzb();
            i24++;
            i14 = 2;
        }
        int i26 = i14;
        zzss zzss = new zzss(strArr, iArr6, zzchArr, iArr4, iArr3, new zzch((zzcf[]) zzfn.zzaa(zzcfArr[i26], iArr2[i26])));
        Pair<zzin[], zzsb[]> zzb2 = zzb(zzss, iArr3, iArr4, zzpz, zzcd);
        zzsb[] zzsbArr = (zzsb[]) zzb2.second;
        zzfsp zzfsp = new zzfsp();
        for (int i27 = 0; i27 < 2; i27++) {
            zzch zzc = zzss.zzc(i27);
            zzsb zzsb = zzsbArr[i27];
            for (int i28 = 0; i28 < zzc.zzc; i28++) {
                zzcf zzb3 = zzc.zzb(i28);
                int i29 = zzb3.zzb;
                int[] iArr7 = new int[1];
                boolean[] zArr = new boolean[1];
                for (char c12 = 0; c12 <= 0; c12 = 1) {
                    iArr7[0] = zzss.zzb(i27, i28, 0);
                    if (zzsb != null && zzsb.zza == zzb3) {
                        int i31 = 0;
                        while (true) {
                            if (i31 >= zzsb.zzb) {
                                break;
                            } else if (zzsb.zzc[i31] != 0) {
                                i31++;
                            } else if (i31 != -1) {
                                c11 = 0;
                                z11 = true;
                            }
                        }
                    }
                    c11 = 0;
                    z11 = false;
                    zArr[c11] = z11;
                }
                zzfsp.zze(new zzcq(zzb3, iArr7, zzss.zza(i27), zArr));
            }
        }
        zzch zzd = zzss.zzd();
        for (int i32 = 0; i32 < zzd.zzc; i32++) {
            zzcf zzb4 = zzd.zzb(i32);
            int i33 = zzb4.zzb;
            int[] iArr8 = new int[1];
            Arrays.fill(iArr8, 0);
            zzfsp.zze(new zzcq(zzb4, iArr8, zzbi.zza(zzb4.zzb(0).zzm), new boolean[1]));
        }
        return new zzsw((zzin[]) zzb2.first, (zzsb[]) zzb2.second, new zzcr(zzfsp.zzf()), zzss, (byte[]) null);
    }

    public final void zzj(@Nullable Object obj) {
        this.zza = (zzss) obj;
    }
}
