package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public final class zzavj extends zzavn {
    private final AtomicReference<zzavi> zza;

    public zzavj() {
        this((zzavo) null);
    }

    public static boolean zza(int i11, boolean z11) {
        int i12 = i11 & 3;
        if (i12 == 3) {
            return true;
        }
        if (z11) {
            return i12 == 2;
        }
        return false;
    }

    private static int zzh(int i11, int i12) {
        if (i11 == -1) {
            return i12 != -1 ? -1 : 0;
        }
        if (i12 == -1) {
            return 1;
        }
        return i11 - i12;
    }

    public final zzavh[] zzb(zzapm[] zzapmArr, zzavd[] zzavdArr, int[][][] iArr) throws zzaos {
        boolean z11;
        zzavk zzavk;
        int i11;
        zzavk zzavk2;
        int[] iArr2;
        ArrayList arrayList;
        zzavc zzavc;
        boolean z12;
        boolean z13;
        int i12;
        boolean z14;
        int i13;
        int i14 = 2;
        zzavh[] zzavhArr = new zzavh[2];
        zzavi zzavi = this.zza.get();
        int i15 = 0;
        boolean z15 = false;
        while (true) {
            int i16 = -1;
            int i17 = 1;
            if (i15 >= i14) {
                break;
            }
            if (zzapmArr[i15].zzc() == i14) {
                if (!z15) {
                    zzapm zzapm = zzapmArr[i15];
                    zzavd zzavd = zzavdArr[i15];
                    int[][] iArr3 = iArr[i15];
                    int i18 = zzavi.zzd;
                    int i19 = -1;
                    int i21 = 0;
                    zzavc zzavc2 = null;
                    int i22 = 0;
                    int i23 = 0;
                    while (i21 < zzavd.zzb) {
                        zzavc zzb = zzavd.zzb(i21);
                        int i24 = zzb.zza;
                        ArrayList arrayList2 = new ArrayList(i17);
                        for (int i25 = 0; i25 <= 0; i25++) {
                            arrayList2.add(Integer.valueOf(i25));
                        }
                        int[] iArr4 = iArr3[i21];
                        int i26 = 0;
                        while (i26 <= 0) {
                            zzavd zzavd2 = zzavd;
                            if (zza(iArr4[i26], true)) {
                                zzapg zzb2 = zzb.zzb(i26);
                                if (arrayList2.contains(Integer.valueOf(i26))) {
                                    int i27 = zzb2.zzj;
                                    zzavc = zzb;
                                    z13 = true;
                                    z12 = true;
                                } else {
                                    zzavc = zzb;
                                    z13 = true;
                                    z12 = false;
                                }
                                if (z13 != z12) {
                                    arrayList = arrayList2;
                                    i12 = 1;
                                } else {
                                    arrayList = arrayList2;
                                    i12 = 2;
                                }
                                iArr2 = iArr4;
                                boolean zza2 = zza(iArr4[i26], false);
                                if (zza2) {
                                    i12 += 1000;
                                }
                                if (i12 > i23) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                if (i12 == i23) {
                                    if (zzb2.zza() != i19) {
                                        i13 = zzh(zzb2.zza(), i19);
                                    } else {
                                        i13 = zzh(zzb2.zzb, i16);
                                    }
                                    if (!zza2 || !z12 ? i13 >= 0 : i13 <= 0) {
                                        z14 = false;
                                    } else {
                                        z14 = true;
                                    }
                                }
                                if (z14) {
                                    i16 = zzb2.zzb;
                                    i19 = zzb2.zza();
                                    i23 = i12;
                                    i22 = i26;
                                    zzavc2 = zzavc;
                                }
                            } else {
                                zzavc = zzb;
                                iArr2 = iArr4;
                                arrayList = arrayList2;
                            }
                            i26++;
                            zzavd = zzavd2;
                            zzb = zzavc;
                            arrayList2 = arrayList;
                            iArr4 = iArr2;
                        }
                        zzavd zzavd3 = zzavd;
                        i21++;
                        i17 = 1;
                    }
                    if (zzavc2 == null) {
                        zzavk2 = null;
                    } else {
                        zzavk2 = new zzavk(zzavc2, i22, 0, (Object) null);
                    }
                    zzavhArr[i15] = zzavk2;
                    if (zzavk2 != null) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                }
                int i28 = zzavdArr[i15].zzb;
            }
            i15++;
            i14 = 2;
        }
        int i29 = 0;
        boolean z16 = false;
        while (i29 < i14) {
            if (zzapmArr[i29].zzc() == 1 && !z16) {
                zzavd zzavd4 = zzavdArr[i29];
                int[][] iArr5 = iArr[i29];
                String str = zzavi.zza;
                int i31 = -1;
                int i32 = -1;
                int i33 = 0;
                int i34 = 0;
                while (i33 < zzavd4.zzb) {
                    zzavc zzb3 = zzavd4.zzb(i33);
                    int[] iArr6 = iArr5[i33];
                    int i35 = i32;
                    int i36 = i31;
                    int i37 = i34;
                    int i38 = 0;
                    while (true) {
                        int i39 = zzb3.zza;
                        if (i38 > 0) {
                            break;
                        }
                        if (zza(iArr6[i38], true)) {
                            zzapg zzb4 = zzb3.zzb(i38);
                            int i41 = iArr6[i38];
                            if (1 != (zzb4.zzx & 1)) {
                                i11 = 1;
                            } else {
                                i11 = 2;
                            }
                            if (zza(i41, false)) {
                                i11 += 1000;
                            }
                            if (i11 > i37) {
                                i36 = i33;
                                i35 = i38;
                                i37 = i11;
                            }
                        }
                        i38++;
                    }
                    i33++;
                    i34 = i37;
                    i31 = i36;
                    i32 = i35;
                }
                if (i31 == -1) {
                    zzavk = null;
                    z11 = false;
                } else {
                    z11 = false;
                    zzavk = new zzavk(zzavd4.zzb(i31), i32, 0, (Object) null);
                }
                zzavhArr[i29] = zzavk;
                if (zzavk != null) {
                    z16 = true;
                } else {
                    z16 = z11;
                }
            }
            i29++;
            i14 = 2;
        }
        return zzavhArr;
    }

    public zzavj(zzavo zzavo) {
        this.zza = new AtomicReference<>(new zzavi());
    }
}
