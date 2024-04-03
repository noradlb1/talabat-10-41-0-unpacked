package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzrz extends zzsb {
    private final zzte zzd;
    private final zzfss<zzrx> zze;
    private final zzdz zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzrz(zzcf zzcf, int[] iArr, int i11, zzte zzte, long j11, long j12, long j13, int i12, int i13, float f11, float f12, List<zzrx> list, zzdz zzdz) {
        super(zzcf, iArr, 0);
        zzcf zzcf2 = zzcf;
        int[] iArr2 = iArr;
        this.zzd = zzte;
        this.zze = zzfss.zzm(list);
        this.zzf = zzdz;
    }

    public static /* bridge */ /* synthetic */ zzfss zza(zzsq[] zzsqArr) {
        int i11;
        int i12;
        zzfss zzfss;
        double d11;
        long j11;
        ArrayList arrayList = new ArrayList();
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i11 = 2;
            i12 = 1;
            if (i14 >= 2) {
                break;
            }
            zzsq zzsq = zzsqArr[i14];
            if (zzsq == null || zzsq.zzb.length <= 1) {
                arrayList.add((Object) null);
            } else {
                zzfsp zzi = zzfss.zzi();
                zzi.zze(new zzrx(0, 0));
                arrayList.add(zzi);
            }
            i14++;
        }
        long[][] jArr = new long[2][];
        for (int i15 = 0; i15 < 2; i15++) {
            zzsq zzsq2 = zzsqArr[i15];
            if (zzsq2 == null) {
                jArr[i15] = new long[0];
            } else {
                jArr[i15] = new long[zzsq2.zzb.length];
                int i16 = 0;
                while (true) {
                    int[] iArr = zzsq2.zzb;
                    if (i16 >= iArr.length) {
                        break;
                    }
                    jArr[i15][i16] = (long) zzsq2.zza.zzb(iArr[i16]).zzi;
                    i16++;
                }
                Arrays.sort(jArr[i15]);
            }
        }
        int[] iArr2 = new int[2];
        long[] jArr2 = new long[2];
        for (int i17 = 0; i17 < 2; i17++) {
            long[] jArr3 = jArr[i17];
            if (jArr3.length == 0) {
                j11 = 0;
            } else {
                j11 = jArr3[0];
            }
            jArr2[i17] = j11;
        }
        zzf(arrayList, jArr2);
        zzfth zza = zzfua.zzc(zzfuf.zzc()).zzb(2).zza();
        int i18 = 0;
        while (i18 < i11) {
            int length = jArr[i18].length;
            if (length > i12) {
                double[] dArr = new double[length];
                int i19 = i13;
                while (true) {
                    long[] jArr4 = jArr[i18];
                    double d12 = 0.0d;
                    if (i19 >= jArr4.length) {
                        break;
                    }
                    long j12 = jArr4[i19];
                    if (j12 != -1) {
                        d12 = Math.log((double) j12);
                    }
                    dArr[i19] = d12;
                    i19++;
                }
                int i21 = length - 1;
                double d13 = dArr[i21] - dArr[i13];
                int i22 = i13;
                while (i22 < i21) {
                    int i23 = i22 + 1;
                    double d14 = (dArr[i22] + dArr[i23]) * 0.5d;
                    if (d13 == 0.0d) {
                        d11 = 1.0d;
                    } else {
                        d11 = (d14 - dArr[i13]) / d13;
                    }
                    zza.zzq(Double.valueOf(d11), Integer.valueOf(i18));
                    i22 = i23;
                    i13 = 0;
                }
            }
            i18++;
            i13 = 0;
            i11 = 2;
            i12 = 1;
        }
        zzfss zzm = zzfss.zzm(zza.zzr());
        for (int i24 = 0; i24 < zzm.size(); i24++) {
            int intValue = ((Integer) zzm.get(i24)).intValue();
            int i25 = iArr2[intValue] + 1;
            iArr2[intValue] = i25;
            jArr2[intValue] = jArr[intValue][i25];
            zzf(arrayList, jArr2);
        }
        for (int i26 = 0; i26 < 2; i26++) {
            if (arrayList.get(i26) != null) {
                long j13 = jArr2[i26];
                jArr2[i26] = j13 + j13;
            }
        }
        zzf(arrayList, jArr2);
        zzfsp zzi2 = zzfss.zzi();
        for (int i27 = 0; i27 < arrayList.size(); i27++) {
            zzfsp zzfsp = (zzfsp) arrayList.get(i27);
            if (zzfsp == null) {
                zzfss = zzfss.zzo();
            } else {
                zzfss = zzfsp.zzf();
            }
            zzi2.zze(zzfss);
        }
        return zzi2.zzf();
    }

    private static void zzf(List<zzfsp<zzrx>> list, long[] jArr) {
        long j11 = 0;
        for (int i11 = 0; i11 < 2; i11++) {
            j11 += jArr[i11];
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzfsp zzfsp = list.get(i12);
            if (zzfsp != null) {
                zzfsp.zze(new zzrx(j11, jArr[i12]));
            }
        }
    }
}
