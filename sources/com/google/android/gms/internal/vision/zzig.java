package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzig<T> implements zzir<T> {
    private static final int[] zzys = new int[0];
    private static final Unsafe zzyt = zzjp.zzil();
    private final int[] zzyu;
    private final Object[] zzyv;
    private final int zzyw;
    private final int zzyx;
    private final zzic zzyy;
    private final boolean zzyz;
    private final boolean zzza;
    private final boolean zzzb;
    private final boolean zzzc;
    private final int[] zzzd;
    private final int zzze;
    private final int zzzf;
    private final zzik zzzg;
    private final zzhm zzzh;
    private final zzjj<?, ?> zzzi;
    private final zzgf<?> zzzj;
    private final zzhv zzzk;

    private zzig(int[] iArr, Object[] objArr, int i11, int i12, zzic zzic, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzik zzik, zzhm zzhm, zzjj<?, ?> zzjj, zzgf<?> zzgf, zzhv zzhv) {
        boolean z13;
        this.zzyu = iArr;
        this.zzyv = objArr;
        this.zzyw = i11;
        this.zzyx = i12;
        this.zzza = zzic instanceof zzgs;
        this.zzzb = z11;
        if (zzgf == null || !zzgf.zze(zzic)) {
            z13 = false;
        } else {
            z13 = true;
        }
        this.zzyz = z13;
        this.zzzc = false;
        this.zzzd = iArr2;
        this.zzze = i13;
        this.zzzf = i14;
        this.zzzg = zzik;
        this.zzzh = zzhm;
        this.zzzi = zzjj;
        this.zzzj = zzgf;
        this.zzyy = zzic;
        this.zzzk = zzhv;
    }

    public static <T> zzig<T> zza(Class<T> cls, zzia zzia, zzik zzik, zzhm zzhm, zzjj<?, ?> zzjj, zzgf<?> zzgf, zzhv zzhv) {
        int i11;
        char c11;
        int[] iArr;
        char c12;
        int i12;
        char c13;
        char c14;
        char c15;
        char c16;
        int i13;
        boolean z11;
        int i14;
        zzip zzip;
        int i15;
        Class<?> cls2;
        int i16;
        String str;
        int i17;
        int i18;
        char c17;
        char c18;
        Field field;
        int i19;
        char charAt;
        int i21;
        Field field2;
        Field field3;
        int i22;
        char charAt2;
        int i23;
        char charAt3;
        int i24;
        char charAt4;
        int i25;
        int i26;
        char charAt5;
        int i27;
        char charAt6;
        int i28;
        char charAt7;
        int i29;
        char charAt8;
        int i31;
        char charAt9;
        int i32;
        char charAt10;
        int i33;
        char charAt11;
        int i34;
        char charAt12;
        int i35;
        char charAt13;
        char charAt14;
        zzia zzia2 = zzia;
        if (zzia2 instanceof zzip) {
            zzip zzip2 = (zzip) zzia2;
            char c19 = 0;
            boolean z12 = zzip2.zzhi() == zzgs.zzf.zzwu;
            String zzhp = zzip2.zzhp();
            int length = zzhp.length();
            char charAt15 = zzhp.charAt(0);
            if (charAt15 >= 55296) {
                char c21 = charAt15 & 8191;
                int i36 = 1;
                int i37 = 13;
                while (true) {
                    i11 = i36 + 1;
                    charAt14 = zzhp.charAt(i36);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c21 |= (charAt14 & 8191) << i37;
                    i37 += 13;
                    i36 = i11;
                }
                charAt15 = c21 | (charAt14 << i37);
            } else {
                i11 = 1;
            }
            int i38 = i11 + 1;
            char charAt16 = zzhp.charAt(i11);
            if (charAt16 >= 55296) {
                char c22 = charAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i35 = i38 + 1;
                    charAt13 = zzhp.charAt(i38);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c22 |= (charAt13 & 8191) << i39;
                    i39 += 13;
                    i38 = i35;
                }
                charAt16 = c22 | (charAt13 << i39);
                i38 = i35;
            }
            if (charAt16 == 0) {
                c15 = 0;
                c13 = 0;
                i12 = 0;
                c12 = 0;
                c11 = 0;
                iArr = zzys;
                c14 = 0;
            } else {
                int i41 = i38 + 1;
                char charAt17 = zzhp.charAt(i38);
                if (charAt17 >= 55296) {
                    char c23 = charAt17 & 8191;
                    int i42 = 13;
                    while (true) {
                        i34 = i41 + 1;
                        charAt12 = zzhp.charAt(i41);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c23 |= (charAt12 & 8191) << i42;
                        i42 += 13;
                        i41 = i34;
                    }
                    charAt17 = c23 | (charAt12 << i42);
                    i41 = i34;
                }
                int i43 = i41 + 1;
                char charAt18 = zzhp.charAt(i41);
                if (charAt18 >= 55296) {
                    char c24 = charAt18 & 8191;
                    int i44 = 13;
                    while (true) {
                        i33 = i43 + 1;
                        charAt11 = zzhp.charAt(i43);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c24 |= (charAt11 & 8191) << i44;
                        i44 += 13;
                        i43 = i33;
                    }
                    charAt18 = c24 | (charAt11 << i44);
                    i43 = i33;
                }
                int i45 = i43 + 1;
                c13 = zzhp.charAt(i43);
                if (c13 >= 55296) {
                    char c25 = c13 & 8191;
                    int i46 = 13;
                    while (true) {
                        i32 = i45 + 1;
                        charAt10 = zzhp.charAt(i45);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c25 |= (charAt10 & 8191) << i46;
                        i46 += 13;
                        i45 = i32;
                    }
                    c13 = c25 | (charAt10 << i46);
                    i45 = i32;
                }
                int i47 = i45 + 1;
                char charAt19 = zzhp.charAt(i45);
                if (charAt19 >= 55296) {
                    char c26 = charAt19 & 8191;
                    int i48 = 13;
                    while (true) {
                        i31 = i47 + 1;
                        charAt9 = zzhp.charAt(i47);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c26 |= (charAt9 & 8191) << i48;
                        i48 += 13;
                        i47 = i31;
                    }
                    charAt19 = c26 | (charAt9 << i48);
                    i47 = i31;
                }
                int i49 = i47 + 1;
                c12 = zzhp.charAt(i47);
                if (c12 >= 55296) {
                    char c27 = c12 & 8191;
                    int i50 = 13;
                    while (true) {
                        i29 = i49 + 1;
                        charAt8 = zzhp.charAt(i49);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c27 |= (charAt8 & 8191) << i50;
                        i50 += 13;
                        i49 = i29;
                    }
                    c12 = c27 | (charAt8 << i50);
                    i49 = i29;
                }
                int i51 = i49 + 1;
                char charAt20 = zzhp.charAt(i49);
                if (charAt20 >= 55296) {
                    char c28 = charAt20 & 8191;
                    int i52 = 13;
                    while (true) {
                        i28 = i51 + 1;
                        charAt7 = zzhp.charAt(i51);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c28 |= (charAt7 & 8191) << i52;
                        i52 += 13;
                        i51 = i28;
                    }
                    charAt20 = c28 | (charAt7 << i52);
                    i51 = i28;
                }
                int i53 = i51 + 1;
                char charAt21 = zzhp.charAt(i51);
                if (charAt21 >= 55296) {
                    char c29 = charAt21 & 8191;
                    int i54 = i53;
                    int i55 = 13;
                    while (true) {
                        i27 = i54 + 1;
                        charAt6 = zzhp.charAt(i54);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c29 |= (charAt6 & 8191) << i55;
                        i55 += 13;
                        i54 = i27;
                    }
                    charAt21 = c29 | (charAt6 << i55);
                    i25 = i27;
                } else {
                    i25 = i53;
                }
                int i56 = i25 + 1;
                char charAt22 = zzhp.charAt(i25);
                if (charAt22 >= 55296) {
                    char c31 = charAt22 & 8191;
                    int i57 = i56;
                    int i58 = 13;
                    while (true) {
                        i26 = i57 + 1;
                        charAt5 = zzhp.charAt(i57);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c31 |= (charAt5 & 8191) << i58;
                        i58 += 13;
                        i57 = i26;
                    }
                    charAt22 = c31 | (charAt5 << i58);
                    i56 = i26;
                }
                int i59 = (charAt17 << 1) + charAt18;
                c14 = charAt19;
                i12 = i59;
                c11 = charAt22;
                c19 = charAt17;
                i38 = i56;
                char c32 = charAt20;
                iArr = new int[(charAt22 + charAt20 + charAt21)];
                c15 = c32;
            }
            Unsafe unsafe = zzyt;
            Object[] zzhq = zzip2.zzhq();
            Class<?> cls3 = zzip2.zzhk().getClass();
            int i60 = i38;
            int[] iArr2 = new int[(c12 * 3)];
            Object[] objArr = new Object[(c12 << 1)];
            int i61 = c11 + c15;
            char c33 = c11;
            int i62 = i60;
            int i63 = i61;
            int i64 = 0;
            int i65 = 0;
            while (i62 < length) {
                int i66 = i62 + 1;
                int charAt23 = zzhp.charAt(i62);
                int i67 = length;
                if (charAt23 >= 55296) {
                    int i68 = charAt23 & 8191;
                    int i69 = i66;
                    int i70 = 13;
                    while (true) {
                        i24 = i69 + 1;
                        charAt4 = zzhp.charAt(i69);
                        c16 = c11;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i68 |= (charAt4 & 8191) << i70;
                        i70 += 13;
                        i69 = i24;
                        c11 = c16;
                    }
                    charAt23 = i68 | (charAt4 << i70);
                    i13 = i24;
                } else {
                    c16 = c11;
                    i13 = i66;
                }
                int i71 = i13 + 1;
                char charAt24 = zzhp.charAt(i13);
                int i72 = i71;
                if (charAt24 >= 55296) {
                    char c34 = charAt24 & 8191;
                    int i73 = i72;
                    int i74 = 13;
                    while (true) {
                        i23 = i73 + 1;
                        charAt3 = zzhp.charAt(i73);
                        z11 = z12;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c34 |= (charAt3 & 8191) << i74;
                        i74 += 13;
                        i73 = i23;
                        z12 = z11;
                    }
                    charAt24 = c34 | (charAt3 << i74);
                    i14 = i23;
                } else {
                    z11 = z12;
                    i14 = i72;
                }
                char c35 = charAt24 & 255;
                char c36 = c14;
                if ((charAt24 & 1024) != 0) {
                    iArr[i64] = i65;
                    i64++;
                }
                char c37 = c13;
                if (c35 >= '3') {
                    int i75 = i14 + 1;
                    char charAt25 = zzhp.charAt(i14);
                    char c38 = 55296;
                    if (charAt25 >= 55296) {
                        char c39 = charAt25 & 8191;
                        int i76 = 13;
                        while (true) {
                            i22 = i75 + 1;
                            charAt2 = zzhp.charAt(i75);
                            if (charAt2 < c38) {
                                break;
                            }
                            c39 |= (charAt2 & 8191) << i76;
                            i76 += 13;
                            i75 = i22;
                            c38 = 55296;
                        }
                        charAt25 = c39 | (charAt2 << i76);
                        i75 = i22;
                    }
                    int i77 = c35 - '3';
                    int i78 = i75;
                    if (i77 == 9 || i77 == 17) {
                        objArr[((i65 / 3) << 1) + 1] = zzhq[i12];
                        i12++;
                    } else if (i77 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i65 / 3) << 1) + 1] = zzhq[i12];
                        i12++;
                    }
                    int i79 = charAt25 << 1;
                    Object obj = zzhq[i79];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzhq[i79] = field2;
                    }
                    zzip = zzip2;
                    String str2 = zzhp;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i80 = i79 + 1;
                    Object obj2 = zzhq[i80];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzhq[i80] = field3;
                    }
                    cls2 = cls3;
                    i15 = i12;
                    i14 = i78;
                    str = str2;
                    i16 = 0;
                    i17 = (int) unsafe.objectFieldOffset(field3);
                    i18 = objectFieldOffset;
                    c17 = c19;
                } else {
                    zzip = zzip2;
                    String str3 = zzhp;
                    int i81 = i12 + 1;
                    Field zza = zza(cls3, (String) zzhq[i12]);
                    if (c35 == 9 || c35 == 17) {
                        c18 = 1;
                        objArr[((i65 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c35 == 27 || c35 == '1') {
                            c18 = 1;
                            i21 = i81 + 1;
                            objArr[((i65 / 3) << 1) + 1] = zzhq[i81];
                        } else if (c35 == 12 || c35 == 30 || c35 == ',') {
                            c18 = 1;
                            if ((charAt15 & 1) == 1) {
                                i21 = i81 + 1;
                                objArr[((i65 / 3) << 1) + 1] = zzhq[i81];
                            }
                        } else {
                            if (c35 == '2') {
                                int i82 = c33 + 1;
                                iArr[c33] = i65;
                                int i83 = (i65 / 3) << 1;
                                int i84 = i81 + 1;
                                objArr[i83] = zzhq[i81];
                                if ((charAt24 & 2048) != 0) {
                                    i81 = i84 + 1;
                                    objArr[i83 + 1] = zzhq[i84];
                                    c33 = i82;
                                } else {
                                    i81 = i84;
                                    c18 = 1;
                                    c33 = i82;
                                }
                            }
                            c18 = 1;
                        }
                        i81 = i21;
                    }
                    i18 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != c18) {
                        i15 = i81;
                        c17 = c19;
                        cls2 = cls3;
                        char c41 = c18;
                        str = str3;
                    } else if (c35 <= 17) {
                        int i85 = i14 + 1;
                        str = str3;
                        char charAt26 = str.charAt(i14);
                        if (charAt26 >= 55296) {
                            char c42 = charAt26 & 8191;
                            int i86 = 13;
                            while (true) {
                                i19 = i85 + 1;
                                charAt = str.charAt(i85);
                                if (charAt < 55296) {
                                    break;
                                }
                                c42 |= (charAt & 8191) << i86;
                                i86 += 13;
                                i85 = i19;
                            }
                            charAt26 = c42 | (charAt << i86);
                            i85 = i19;
                        }
                        int i87 = (c19 << 1) + (charAt26 / ' ');
                        Object obj3 = zzhq[i87];
                        i15 = i81;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzhq[i87] = field;
                        }
                        c17 = c19;
                        cls2 = cls3;
                        i16 = charAt26 % ' ';
                        i17 = (int) unsafe.objectFieldOffset(field);
                        i14 = i85;
                        if (c35 >= 18 && c35 <= '1') {
                            iArr[i63] = i18;
                            i63++;
                        }
                    } else {
                        i15 = i81;
                        c17 = c19;
                        cls2 = cls3;
                        str = str3;
                    }
                    i17 = 0;
                    i16 = 0;
                    iArr[i63] = i18;
                    i63++;
                }
                int i88 = i65 + 1;
                iArr2[i65] = charAt23;
                int i89 = i88 + 1;
                iArr2[i88] = i18 | ((charAt24 & 256) != 0 ? 268435456 : 0) | ((charAt24 & 512) != 0 ? 536870912 : 0) | (c35 << 20);
                i65 = i89 + 1;
                iArr2[i89] = (i16 << 20) | i17;
                c19 = c17;
                zzhp = str;
                i62 = i14;
                cls3 = cls2;
                c14 = c36;
                length = i67;
                c11 = c16;
                z12 = z11;
                c13 = c37;
                i12 = i15;
                zzip2 = zzip;
            }
            char c43 = c14;
            boolean z13 = z12;
            return new zzig(iArr2, objArr, c13, c14, zzip2.zzhk(), z12, false, iArr, c11, i61, zzik, zzhm, zzjj, zzgf, zzhv);
        }
        ((zzjg) zzia2).zzhi();
        int i90 = zzgs.zzf.zzwl;
        throw new NoSuchMethodError();
    }

    private final void zzb(T t11, T t12, int i11) {
        int zzbp = zzbp(i11);
        int i12 = this.zzyu[i11];
        long j11 = (long) (zzbp & 1048575);
        if (zza(t12, i12, i11)) {
            Object zzp = zzjp.zzp(t11, j11);
            Object zzp2 = zzjp.zzp(t12, j11);
            if (zzp != null && zzp2 != null) {
                zzjp.zza((Object) t11, j11, zzgt.zzb(zzp, zzp2));
                zzb(t11, i12, i11);
            } else if (zzp2 != null) {
                zzjp.zza((Object) t11, j11, zzp2);
                zzb(t11, i12, i11);
            }
        }
    }

    private final zzir zzbm(int i11) {
        int i12 = (i11 / 3) << 1;
        zzir zzir = (zzir) this.zzyv[i12];
        if (zzir != null) {
            return zzir;
        }
        zzir zzf = zzin.zzho().zzf((Class) this.zzyv[i12 + 1]);
        this.zzyv[i12] = zzf;
        return zzf;
    }

    private final Object zzbn(int i11) {
        return this.zzyv[(i11 / 3) << 1];
    }

    private final zzgy zzbo(int i11) {
        return (zzgy) this.zzyv[((i11 / 3) << 1) + 1];
    }

    private final int zzbp(int i11) {
        return this.zzyu[i11 + 1];
    }

    private final int zzbq(int i11) {
        return this.zzyu[i11 + 2];
    }

    private static boolean zzbr(int i11) {
        return (i11 & 536870912) != 0;
    }

    private final int zzbs(int i11) {
        if (i11 < this.zzyw || i11 > this.zzyx) {
            return -1;
        }
        return zzu(i11, 0);
    }

    private final boolean zzc(T t11, T t12, int i11) {
        return zza(t11, i11) == zza(t12, i11);
    }

    private static List<?> zze(Object obj, long j11) {
        return (List) zzjp.zzp(obj, j11);
    }

    private static <T> double zzf(T t11, long j11) {
        return ((Double) zzjp.zzp(t11, j11)).doubleValue();
    }

    private static <T> int zzh(T t11, long j11) {
        return ((Integer) zzjp.zzp(t11, j11)).intValue();
    }

    private static <T> long zzi(T t11, long j11) {
        return ((Long) zzjp.zzp(t11, j11)).longValue();
    }

    private static <T> boolean zzj(T t11, long j11) {
        return ((Boolean) zzjp.zzp(t11, j11)).booleanValue();
    }

    private static zzjm zzs(Object obj) {
        zzgs zzgs = (zzgs) obj;
        zzjm zzjm = zzgs.zzwd;
        if (zzjm != zzjm.zzig()) {
            return zzjm;
        }
        zzjm zzih = zzjm.zzih();
        zzgs.zzwd = zzih;
        return zzih;
    }

    private final int zzu(int i11, int i12) {
        int length = (this.zzyu.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int i15 = this.zzyu[i14];
            if (i11 == i15) {
                return i14;
            }
            if (i11 < i15) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzm(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzk(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzjp.zzl(r10, r6) == com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzjp.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzjp.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzjp.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzjp.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zzit.zze(com.google.android.gms.internal.vision.zzjp.zzp(r10, r6), com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzyu
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzbp(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzbq(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzit.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zzit.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zzit.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.vision.zzjp.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.zzjp.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzjp.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzjp.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzjp.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.vision.zzjp.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.vision.zzjp.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.vision.zzjp.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.vision.zzjp.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = r1
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r9.zzzi
            java.lang.Object r0 = r0.zzv(r10)
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r9.zzzi
            java.lang.Object r2 = r2.zzv(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzyz
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.vision.zzgf<?> r0 = r9.zzzj
            com.google.android.gms.internal.vision.zzgi r10 = r0.zze((java.lang.Object) r10)
            com.google.android.gms.internal.vision.zzgf<?> r0 = r9.zzzj
            com.google.android.gms.internal.vision.zzgi r11 = r0.zze((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzyu
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzbp(r1)
            int[] r4 = r8.zzyu
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzm(r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzg(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzf(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzjp.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzjp.zzk(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzjp.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzjp.zzk(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzjp.zzk(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzjp.zzk(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzjp.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.vision.zzjp.zzm(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzm(r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzjp.zzk(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzjp.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.zzjp.zzk(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzjp.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.zzjp.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.vision.zzjp.zzn(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.vision.zzjp.zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.vision.zzgt.zzab(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r8.zzzi
            java.lang.Object r0 = r0.zzv(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzyz
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.zzgf<?> r0 = r8.zzzj
            com.google.android.gms.internal.vision.zzgi r9 = r0.zze((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zzzg.newInstance(this.zzyy);
    }

    public final void zzd(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.zzyu.length; i11 += 3) {
            int zzbp = zzbp(i11);
            long j11 = (long) (1048575 & zzbp);
            int i12 = this.zzyu[i11];
            switch ((zzbp & 267386880) >>> 20) {
                case 0:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzo(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 1:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzn(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 2:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzl(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 3:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzl(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 4:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zzb((Object) t11, j11, zzjp.zzk(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 5:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzl(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 6:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zzb((Object) t11, j11, zzjp.zzk(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 7:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzm(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 8:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzp(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 9:
                    zza(t11, t12, i11);
                    break;
                case 10:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzp(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 11:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zzb((Object) t11, j11, zzjp.zzk(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 12:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zzb((Object) t11, j11, zzjp.zzk(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 13:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zzb((Object) t11, j11, zzjp.zzk(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 14:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzl(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 15:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zzb((Object) t11, j11, zzjp.zzk(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 16:
                    if (!zza(t12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzl(t12, j11));
                        zzb(t11, i11);
                        break;
                    }
                case 17:
                    zza(t11, t12, i11);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzzh.zza(t11, t12, j11);
                    break;
                case 50:
                    zzit.zza(this.zzzk, t11, t12, j11);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zza(t12, i12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzp(t12, j11));
                        zzb(t11, i12, i11);
                        break;
                    }
                case 60:
                    zzb(t11, t12, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza(t12, i12, i11)) {
                        break;
                    } else {
                        zzjp.zza((Object) t11, j11, zzjp.zzp(t12, j11));
                        zzb(t11, i12, i11);
                        break;
                    }
                case 68:
                    zzb(t11, t12, i11);
                    break;
            }
        }
        if (!this.zzzb) {
            zzit.zza(this.zzzi, t11, t12);
            if (this.zzyz) {
                zzit.zza(this.zzzj, t11, t12);
            }
        }
    }

    public final void zzg(T t11) {
        int i11;
        int i12 = this.zzze;
        while (true) {
            i11 = this.zzzf;
            if (i12 >= i11) {
                break;
            }
            long zzbp = (long) (zzbp(this.zzzd[i12]) & 1048575);
            Object zzp = zzjp.zzp(t11, zzbp);
            if (zzp != null) {
                zzjp.zza((Object) t11, zzbp, this.zzzk.zzn(zzp));
            }
            i12++;
        }
        int length = this.zzzd.length;
        while (i11 < length) {
            this.zzzh.zzb(t11, (long) this.zzzd[i11]);
            i11++;
        }
        this.zzzi.zzg(t11);
        if (this.zzyz) {
            this.zzzj.zzg(t11);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x0831, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:414:0x08fc, code lost:
        r6 = r6 + r4;
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x090d, code lost:
        r9 = false;
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:435:0x0955, code lost:
        r6 = r6 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0a06, code lost:
        r6 = r6 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0a2a, code lost:
        r5 = r5 + 3;
        r11 = r8;
        r8 = r4;
        r4 = r9;
        r9 = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzr(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzzb
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzyt
            r12 = r11
            r13 = r12
        L_0x0016:
            int[] r14 = r0.zzyu
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzbp(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzyu
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.vision.zzgn r14 = com.google.android.gms.internal.vision.zzgn.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.vision.zzgn r14 = com.google.android.gms.internal.vision.zzgn.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzyu
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x0042
        L_0x0041:
            r14 = r11
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x04d6;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04ba;
                case 3: goto L_0x04aa;
                case 4: goto L_0x049a;
                case 5: goto L_0x048e;
                case 6: goto L_0x0482;
                case 7: goto L_0x0476;
                case 8: goto L_0x0458;
                case 9: goto L_0x0444;
                case 10: goto L_0x0433;
                case 11: goto L_0x0424;
                case 12: goto L_0x0415;
                case 13: goto L_0x040a;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03f0;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03cc;
                case 18: goto L_0x03c1;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03af;
                case 21: goto L_0x03a6;
                case 22: goto L_0x039d;
                case 23: goto L_0x0394;
                case 24: goto L_0x038b;
                case 25: goto L_0x0382;
                case 26: goto L_0x0379;
                case 27: goto L_0x036c;
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0350;
                case 31: goto L_0x0346;
                case 32: goto L_0x033c;
                case 33: goto L_0x0332;
                case 34: goto L_0x0328;
                case 35: goto L_0x0308;
                case 36: goto L_0x02eb;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b1;
                case 39: goto L_0x0293;
                case 40: goto L_0x0275;
                case 41: goto L_0x0257;
                case 42: goto L_0x0239;
                case 43: goto L_0x021b;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01df;
                case 46: goto L_0x01c1;
                case 47: goto L_0x01a3;
                case 48: goto L_0x0185;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x04e4
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzic r5 = (com.google.android.gms.internal.vision.zzic) r5
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzga.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzf(r3, r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzn(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzp(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzq(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzm(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzir) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzfh
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzo(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzl(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zze(r3, r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.vision.zzhv r14 = r0.zzzk
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            java.lang.Object r6 = r0.zzbn(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzs(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzw(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzy(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzx(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzt(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzv(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzz(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzx(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzy(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzu(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzr(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzq(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzx(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.vision.zzit.zzy(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzzc
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.vision.zzga.zzba(r3)
            int r6 = com.google.android.gms.internal.vision.zzga.zzbc(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.vision.zzir) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzit.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzic r5 = (com.google.android.gms.internal.vision.zzic) r5
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzga.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.vision.zzjp.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzf(r3, r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzn(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzp(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzq(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzm(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            com.google.android.gms.internal.vision.zzir r6 = r0.zzbm(r12)
            int r3 = com.google.android.gms.internal.vision.zzit.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.vision.zzir) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.vision.zzfh
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.vision.zzfh r5 = (com.google.android.gms.internal.vision.zzfh) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzc((int) r3, (com.google.android.gms.internal.vision.zzfh) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzo(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.vision.zzjp.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzl(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.vision.zzjp.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zze(r3, r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.vision.zzjp.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.vision.zzga.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.vision.zzga.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r0.zzzi
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzyt
            r3 = -1
            r5 = r11
            r6 = r5
            r12 = r6
        L_0x04f8:
            int[] r13 = r0.zzyu
            int r13 = r13.length
            if (r5 >= r13) goto L_0x0a32
            int r13 = r0.zzbp(r5)
            int[] r14 = r0.zzyu
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0523
            int r11 = r5 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r18 = r11 >>> 20
            int r18 = r8 << r18
            if (r14 == r3) goto L_0x0521
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            r3 = r14
        L_0x0521:
            r8 = r11
            goto L_0x0542
        L_0x0523:
            boolean r8 = r0.zzzc
            if (r8 == 0) goto L_0x053f
            com.google.android.gms.internal.vision.zzgn r8 = com.google.android.gms.internal.vision.zzgn.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x053f
            com.google.android.gms.internal.vision.zzgn r8 = com.google.android.gms.internal.vision.zzgn.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x053f
            int[] r8 = r0.zzyu
            int r9 = r5 + 2
            r8 = r8[r9]
            r8 = r8 & r7
            goto L_0x0540
        L_0x053f:
            r8 = 0
        L_0x0540:
            r18 = 0
        L_0x0542:
            r9 = r13 & r7
            long r9 = (long) r9
            switch(r4) {
                case 0: goto L_0x0a1a;
                case 1: goto L_0x0a09;
                case 2: goto L_0x09f6;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d4;
                case 5: goto L_0x09c7;
                case 6: goto L_0x09ba;
                case 7: goto L_0x09ae;
                case 8: goto L_0x0992;
                case 9: goto L_0x0980;
                case 10: goto L_0x0971;
                case 11: goto L_0x0964;
                case 12: goto L_0x0957;
                case 13: goto L_0x094c;
                case 14: goto L_0x0941;
                case 15: goto L_0x0934;
                case 16: goto L_0x0927;
                case 17: goto L_0x0914;
                case 18: goto L_0x08ff;
                case 19: goto L_0x08f1;
                case 20: goto L_0x08e5;
                case 21: goto L_0x08d9;
                case 22: goto L_0x08cd;
                case 23: goto L_0x08c1;
                case 24: goto L_0x08b5;
                case 25: goto L_0x08a9;
                case 26: goto L_0x089e;
                case 27: goto L_0x088f;
                case 28: goto L_0x0883;
                case 29: goto L_0x0876;
                case 30: goto L_0x0869;
                case 31: goto L_0x085c;
                case 32: goto L_0x084f;
                case 33: goto L_0x0842;
                case 34: goto L_0x0835;
                case 35: goto L_0x0815;
                case 36: goto L_0x07f8;
                case 37: goto L_0x07db;
                case 38: goto L_0x07be;
                case 39: goto L_0x07a0;
                case 40: goto L_0x0782;
                case 41: goto L_0x0764;
                case 42: goto L_0x0746;
                case 43: goto L_0x0728;
                case 44: goto L_0x070a;
                case 45: goto L_0x06ec;
                case 46: goto L_0x06ce;
                case 47: goto L_0x06b0;
                case 48: goto L_0x0692;
                case 49: goto L_0x0682;
                case 50: goto L_0x0672;
                case 51: goto L_0x0664;
                case 52: goto L_0x0657;
                case 53: goto L_0x0647;
                case 54: goto L_0x0637;
                case 55: goto L_0x0627;
                case 56: goto L_0x0619;
                case 57: goto L_0x060c;
                case 58: goto L_0x05ff;
                case 59: goto L_0x05e1;
                case 60: goto L_0x05cd;
                case 61: goto L_0x05bb;
                case 62: goto L_0x05ab;
                case 63: goto L_0x059b;
                case 64: goto L_0x058e;
                case 65: goto L_0x0580;
                case 66: goto L_0x0570;
                case 67: goto L_0x0560;
                case 68: goto L_0x054a;
                default: goto L_0x0548;
            }
        L_0x0548:
            goto L_0x090b
        L_0x054a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzic r4 = (com.google.android.gms.internal.vision.zzic) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r5)
            int r4 = com.google.android.gms.internal.vision.zzga.zzc(r15, r4, r8)
            goto L_0x090a
        L_0x0560:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzf(r15, r8)
            goto L_0x090a
        L_0x0570:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzn(r15, r4)
            goto L_0x090a
        L_0x0580:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzh((int) r15, (long) r8)
            goto L_0x090a
        L_0x058e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzp(r15, r4)
            goto L_0x0955
        L_0x059b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzq(r15, r4)
            goto L_0x090a
        L_0x05ab:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzm(r15, r4)
            goto L_0x090a
        L_0x05bb:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r15, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x090a
        L_0x05cd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r5)
            int r4 = com.google.android.gms.internal.vision.zzit.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x090a
        L_0x05e1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.vision.zzfh
            if (r8 == 0) goto L_0x05f7
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r15, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x090a
        L_0x05f7:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x05ff:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (boolean) r4)
            goto L_0x0955
        L_0x060c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzo(r15, r4)
            goto L_0x0955
        L_0x0619:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzg((int) r15, (long) r8)
            goto L_0x090a
        L_0x0627:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzl(r15, r4)
            goto L_0x090a
        L_0x0637:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zze(r15, r8)
            goto L_0x090a
        L_0x0647:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzd((int) r15, (long) r8)
            goto L_0x090a
        L_0x0657:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (float) r4)
            goto L_0x0955
        L_0x0664:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (double) r8)
            goto L_0x090a
        L_0x0672:
            com.google.android.gms.internal.vision.zzhv r4 = r0.zzzk
            java.lang.Object r8 = r2.getObject(r1, r9)
            java.lang.Object r9 = r0.zzbn(r5)
            int r4 = r4.zzb(r15, r8, r9)
            goto L_0x090a
        L_0x0682:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r5)
            int r4 = com.google.android.gms.internal.vision.zzit.zzd(r15, r4, r8)
            goto L_0x090a
        L_0x0692:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzs(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x06a6
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06a6:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x06b0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x06c4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06c4:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x06ce:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzy(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x06e2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06e2:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x06ec:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzx(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0700
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0700:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x070a:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzt(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x071e
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x071e:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x0728:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x073c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x073c:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x0746:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzz(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x075a
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x075a:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x0764:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzx(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0778
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0778:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x0782:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzy(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0796
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0796:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x07a0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzu(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x07b4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07b4:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x07be:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzr(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x07d2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07d2:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x07db:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzq(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x07ef
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07ef:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x07f8:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzx(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x080c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x080c:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
            goto L_0x0831
        L_0x0815:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzy(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzzc
            if (r9 == 0) goto L_0x0829
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0829:
            int r8 = com.google.android.gms.internal.vision.zzga.zzba(r15)
            int r9 = com.google.android.gms.internal.vision.zzga.zzbc(r4)
        L_0x0831:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0955
        L_0x0835:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzit.zzq(r15, r4, r8)
            goto L_0x08fc
        L_0x0842:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzu(r15, r4, r8)
            goto L_0x08fc
        L_0x084f:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x085c:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x0869:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzr(r15, r4, r8)
            goto L_0x08fc
        L_0x0876:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzt(r15, r4, r8)
            goto L_0x090a
        L_0x0883:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzd(r15, r4)
            goto L_0x090a
        L_0x088f:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r5)
            int r4 = com.google.android.gms.internal.vision.zzit.zzc((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x090a
        L_0x089e:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzc(r15, r4)
            goto L_0x090a
        L_0x08a9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzit.zzx(r15, r4, r8)
            goto L_0x08fc
        L_0x08b5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x08c1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x08cd:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzs(r15, r4, r8)
            goto L_0x08fc
        L_0x08d9:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzp(r15, r4, r8)
            goto L_0x08fc
        L_0x08e5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzo(r15, r4, r8)
            goto L_0x08fc
        L_0x08f1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzv(r15, r4, r8)
        L_0x08fc:
            int r6 = r6 + r4
            r4 = 1
            goto L_0x090d
        L_0x08ff:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.vision.zzit.zzw(r15, r4, r8)
        L_0x090a:
            int r6 = r6 + r4
        L_0x090b:
            r4 = 1
        L_0x090c:
            r8 = 0
        L_0x090d:
            r9 = 0
            r10 = 0
            r13 = 0
            goto L_0x0a2a
        L_0x0914:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzic r4 = (com.google.android.gms.internal.vision.zzic) r4
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r5)
            int r4 = com.google.android.gms.internal.vision.zzga.zzc(r15, r4, r8)
            goto L_0x090a
        L_0x0927:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            long r8 = r2.getLong(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzf(r15, r8)
            goto L_0x090a
        L_0x0934:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzn(r15, r4)
            goto L_0x090a
        L_0x0941:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.vision.zzga.zzh((int) r15, (long) r8)
            goto L_0x090a
        L_0x094c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.vision.zzga.zzp(r15, r4)
        L_0x0955:
            int r6 = r6 + r8
            goto L_0x090b
        L_0x0957:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzq(r15, r4)
            goto L_0x090a
        L_0x0964:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.vision.zzga.zzm(r15, r4)
            goto L_0x090a
        L_0x0971:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r15, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x090a
        L_0x0980:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r5)
            int r4 = com.google.android.gms.internal.vision.zzit.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x090a
        L_0x0992:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.vision.zzfh
            if (r8 == 0) goto L_0x09a6
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzc((int) r15, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x090a
        L_0x09a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x09ae:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (boolean) r4)
            int r6 = r6 + r8
            goto L_0x090c
        L_0x09ba:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x090c
            r8 = 0
            int r9 = com.google.android.gms.internal.vision.zzga.zzo(r15, r8)
            int r6 = r6 + r9
            goto L_0x090d
        L_0x09c7:
            r4 = 1
            r8 = 0
            r9 = r12 & r18
            r13 = 0
            if (r9 == 0) goto L_0x0a07
            int r9 = com.google.android.gms.internal.vision.zzga.zzg((int) r15, (long) r13)
            goto L_0x0a06
        L_0x09d4:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.vision.zzga.zzl(r15, r9)
            goto L_0x0a06
        L_0x09e5:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.vision.zzga.zze(r15, r9)
            goto L_0x0a06
        L_0x09f6:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.vision.zzga.zzd((int) r15, (long) r9)
        L_0x0a06:
            int r6 = r6 + r9
        L_0x0a07:
            r9 = 0
            goto L_0x0a17
        L_0x0a09:
            r4 = 1
            r8 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a07
            r9 = 0
            int r10 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (float) r9)
            int r6 = r6 + r10
        L_0x0a17:
            r10 = 0
            goto L_0x0a2a
        L_0x0a1a:
            r4 = 1
            r8 = 0
            r9 = 0
            r13 = 0
            r10 = r12 & r18
            if (r10 == 0) goto L_0x0a17
            r10 = 0
            int r15 = com.google.android.gms.internal.vision.zzga.zzb((int) r15, (double) r10)
            int r6 = r6 + r15
        L_0x0a2a:
            int r5 = r5 + 3
            r11 = r8
            r8 = r4
            r4 = r9
            r9 = r13
            goto L_0x04f8
        L_0x0a32:
            r8 = r11
            com.google.android.gms.internal.vision.zzjj<?, ?> r2 = r0.zzzi
            int r2 = zza(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.zzyz
            if (r2 == 0) goto L_0x0a8c
            com.google.android.gms.internal.vision.zzgf<?> r2 = r0.zzzj
            com.google.android.gms.internal.vision.zzgi r1 = r2.zze((java.lang.Object) r1)
            r11 = r8
        L_0x0a45:
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r2 = r1.zztb
            int r2 = r2.zzhx()
            if (r11 >= r2) goto L_0x0a65
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r2 = r1.zztb
            java.util.Map$Entry r2 = r2.zzbu(r11)
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.vision.zzgk r3 = (com.google.android.gms.internal.vision.zzgk) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.vision.zzgi.zzc(r3, r2)
            int r8 = r8 + r2
            int r11 = r11 + 1
            goto L_0x0a45
        L_0x0a65:
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r1.zztb
            java.lang.Iterable r1 = r1.zzhy()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a6f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0a8b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.vision.zzgk r3 = (com.google.android.gms.internal.vision.zzgk) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.vision.zzgi.zzc(r3, r2)
            int r8 = r8 + r2
            goto L_0x0a6f
        L_0x0a8b:
            int r6 = r6 + r8
        L_0x0a8c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zzr(java.lang.Object):int");
    }

    public final boolean zzt(T t11) {
        int i11;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean z11 = true;
            if (i13 >= this.zzze) {
                return !this.zzyz || this.zzzj.zze((Object) t11).isInitialized();
            }
            int i15 = this.zzzd[i13];
            int i16 = this.zzyu[i15];
            int zzbp = zzbp(i15);
            if (!this.zzzb) {
                int i17 = this.zzyu[i15 + 2];
                int i18 = i17 & 1048575;
                i11 = 1 << (i17 >>> 20);
                if (i18 != i12) {
                    i14 = zzyt.getInt(t11, (long) i18);
                    i12 = i18;
                }
            } else {
                i11 = 0;
            }
            if (((268435456 & zzbp) != 0) && !zza(t11, i15, i14, i11)) {
                return false;
            }
            int i19 = (267386880 & zzbp) >>> 20;
            if (i19 != 9 && i19 != 17) {
                if (i19 != 27) {
                    if (i19 == 60 || i19 == 68) {
                        if (zza(t11, i16, i15) && !zza((Object) t11, zzbp, zzbm(i15))) {
                            return false;
                        }
                    } else if (i19 != 49) {
                        if (i19 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzl = this.zzzk.zzl(zzjp.zzp(t11, (long) (zzbp & 1048575)));
                            if (!zzl.isEmpty()) {
                                if (this.zzzk.zzp(zzbn(i15)).zzyo.zzip() == zzkd.MESSAGE) {
                                    Iterator<?> it = zzl.values().iterator();
                                    zzir<?> zzir = null;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzir == null) {
                                            zzir = zzin.zzho().zzf(next.getClass());
                                        }
                                        if (!zzir.zzt(next)) {
                                            z11 = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z11) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzjp.zzp(t11, (long) (zzbp & 1048575));
                if (!list.isEmpty()) {
                    zzir zzbm = zzbm(i15);
                    int i21 = 0;
                    while (true) {
                        if (i21 >= list.size()) {
                            break;
                        } else if (!zzbm.zzt(list.get(i21))) {
                            z11 = false;
                            break;
                        } else {
                            i21++;
                        }
                    }
                }
                if (!z11) {
                    return false;
                }
            } else if (zza(t11, i15, i14, i11) && !zza((Object) t11, zzbp, zzbm(i15))) {
                return false;
            }
            i13++;
        }
    }

    private static <T> float zzg(T t11, long j11) {
        return ((Float) zzjp.zzp(t11, j11)).floatValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02e8, code lost:
        r15 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0486, code lost:
        r10 = r10 + 3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x048c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.vision.zzkg r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzyz
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.vision.zzgf<?> r3 = r0.zzzj
            com.google.android.gms.internal.vision.zzgi r3 = r3.zze((java.lang.Object) r1)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r5 = r3.zztb
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzyu
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzyt
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r6) goto L_0x048a
            int r12 = r0.zzbp(r10)
            int[] r13 = r0.zzyu
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzzb
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005b
            r4 = 17
            if (r15 > r4) goto L_0x005b
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r9) goto L_0x0055
            long r8 = (long) r13
            int r11 = r7.getInt(r1, r8)
            r9 = r13
        L_0x0055:
            int r4 = r4 >>> 20
            r8 = 1
            int r4 = r8 << r4
            goto L_0x005c
        L_0x005b:
            r4 = 0
        L_0x005c:
            if (r5 == 0) goto L_0x007a
            com.google.android.gms.internal.vision.zzgf<?> r8 = r0.zzzj
            int r8 = r8.zza(r5)
            if (r8 > r14) goto L_0x007a
            com.google.android.gms.internal.vision.zzgf<?> r8 = r0.zzzj
            r8.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0078
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005c
        L_0x0078:
            r5 = 0
            goto L_0x005c
        L_0x007a:
            r8 = r12 & r16
            long r12 = (long) r8
            switch(r15) {
                case 0: goto L_0x047b;
                case 1: goto L_0x046f;
                case 2: goto L_0x0463;
                case 3: goto L_0x0457;
                case 4: goto L_0x044b;
                case 5: goto L_0x043f;
                case 6: goto L_0x0433;
                case 7: goto L_0x0427;
                case 8: goto L_0x041b;
                case 9: goto L_0x040a;
                case 10: goto L_0x03fb;
                case 11: goto L_0x03ee;
                case 12: goto L_0x03e1;
                case 13: goto L_0x03d4;
                case 14: goto L_0x03c7;
                case 15: goto L_0x03ba;
                case 16: goto L_0x03ad;
                case 17: goto L_0x039c;
                case 18: goto L_0x038c;
                case 19: goto L_0x037c;
                case 20: goto L_0x036c;
                case 21: goto L_0x035c;
                case 22: goto L_0x034c;
                case 23: goto L_0x033c;
                case 24: goto L_0x032c;
                case 25: goto L_0x031c;
                case 26: goto L_0x030d;
                case 27: goto L_0x02fa;
                case 28: goto L_0x02eb;
                case 29: goto L_0x02da;
                case 30: goto L_0x02cb;
                case 31: goto L_0x02bc;
                case 32: goto L_0x02ad;
                case 33: goto L_0x029e;
                case 34: goto L_0x028f;
                case 35: goto L_0x027f;
                case 36: goto L_0x026f;
                case 37: goto L_0x025f;
                case 38: goto L_0x024f;
                case 39: goto L_0x023f;
                case 40: goto L_0x022f;
                case 41: goto L_0x021f;
                case 42: goto L_0x020f;
                case 43: goto L_0x01ff;
                case 44: goto L_0x01ef;
                case 45: goto L_0x01df;
                case 46: goto L_0x01cf;
                case 47: goto L_0x01bf;
                case 48: goto L_0x01af;
                case 49: goto L_0x019c;
                case 50: goto L_0x0193;
                case 51: goto L_0x0184;
                case 52: goto L_0x0175;
                case 53: goto L_0x0166;
                case 54: goto L_0x0157;
                case 55: goto L_0x0148;
                case 56: goto L_0x0139;
                case 57: goto L_0x012a;
                case 58: goto L_0x011b;
                case 59: goto L_0x010c;
                case 60: goto L_0x00f9;
                case 61: goto L_0x00e9;
                case 62: goto L_0x00db;
                case 63: goto L_0x00cd;
                case 64: goto L_0x00bf;
                case 65: goto L_0x00b1;
                case 66: goto L_0x00a3;
                case 67: goto L_0x0095;
                case 68: goto L_0x0083;
                default: goto L_0x0080;
            }
        L_0x0080:
            r15 = 0
            goto L_0x0486
        L_0x0083:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x0080
        L_0x0095:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x0080
        L_0x00a3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzj((int) r14, (int) r4)
            goto L_0x0080
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzj((int) r14, (long) r12)
            goto L_0x0080
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzr(r14, r4)
            goto L_0x0080
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzs(r14, r4)
            goto L_0x0080
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzi((int) r14, (int) r4)
            goto L_0x0080
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            r2.zza((int) r14, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x0080
        L_0x00f9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r10)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x0080
        L_0x010c:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzkg) r2)
            goto L_0x0080
        L_0x011b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            boolean r4 = zzj(r1, r12)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x0080
        L_0x012a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzk(r14, r4)
            goto L_0x0080
        L_0x0139:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x0080
        L_0x0148:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x0080
        L_0x0157:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x0080
        L_0x0166:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzi((int) r14, (long) r12)
            goto L_0x0080
        L_0x0175:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            float r4 = zzg(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x0080
        L_0x0184:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            double r12 = zzf(r1, r12)
            r2.zza((int) r14, (double) r12)
            goto L_0x0080
        L_0x0193:
            java.lang.Object r4 = r7.getObject(r1, r12)
            r0.zza((com.google.android.gms.internal.vision.zzkg) r2, (int) r14, (java.lang.Object) r4, (int) r10)
            goto L_0x0080
        L_0x019c:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r12 = r0.zzbm(r10)
            com.google.android.gms.internal.vision.zzit.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzkg) r2, (com.google.android.gms.internal.vision.zzir) r12)
            goto L_0x0080
        L_0x01af:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 1
            com.google.android.gms.internal.vision.zzit.zze(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01bf:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01cf:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01df:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01ef:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01ff:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r4, r8, r2, r14)
            goto L_0x0080
        L_0x020f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r4, r8, r2, r14)
            goto L_0x0080
        L_0x021f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r4, r8, r2, r14)
            goto L_0x0080
        L_0x022f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r4, r8, r2, r14)
            goto L_0x0080
        L_0x023f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r4, r8, r2, r14)
            goto L_0x0080
        L_0x024f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r4, r8, r2, r14)
            goto L_0x0080
        L_0x025f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r4, r8, r2, r14)
            goto L_0x0080
        L_0x026f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r14)
            goto L_0x0080
        L_0x027f:
            r14 = 1
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r14)
            goto L_0x0080
        L_0x028f:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
            com.google.android.gms.internal.vision.zzit.zze(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x029e:
            r14 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02bc:
            r14 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02cb:
            r14 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02da:
            r14 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r4, r8, r2, r14)
        L_0x02e8:
            r15 = r14
            goto L_0x0486
        L_0x02eb:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb(r4, r8, r2)
            goto L_0x0080
        L_0x02fa:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r12 = r0.zzbm(r10)
            com.google.android.gms.internal.vision.zzit.zza((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzkg) r2, (com.google.android.gms.internal.vision.zzir) r12)
            goto L_0x0080
        L_0x030d:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.zzkg) r2)
            goto L_0x0080
        L_0x031c:
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.vision.zzit.zzn(r4, r8, r2, r15)
            goto L_0x0486
        L_0x032c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r4, r8, r2, r15)
            goto L_0x0486
        L_0x033c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r4, r8, r2, r15)
            goto L_0x0486
        L_0x034c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r4, r8, r2, r15)
            goto L_0x0486
        L_0x035c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r4, r8, r2, r15)
            goto L_0x0486
        L_0x036c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r4, r8, r2, r15)
            goto L_0x0486
        L_0x037c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r15)
            goto L_0x0486
        L_0x038c:
            r15 = 0
            int[] r4 = r0.zzyu
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzkg) r2, (boolean) r15)
            goto L_0x0486
        L_0x039c:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x0486
        L_0x03ad:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x0486
        L_0x03ba:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzj((int) r14, (int) r4)
            goto L_0x0486
        L_0x03c7:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzj((int) r14, (long) r12)
            goto L_0x0486
        L_0x03d4:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzr(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzs(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzi((int) r14, (int) r4)
            goto L_0x0486
        L_0x03fb:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzfh r4 = (com.google.android.gms.internal.vision.zzfh) r4
            r2.zza((int) r14, (com.google.android.gms.internal.vision.zzfh) r4)
            goto L_0x0486
        L_0x040a:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.vision.zzir r8 = r0.zzbm(r10)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzir) r8)
            goto L_0x0486
        L_0x041b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.vision.zzkg) r2)
            goto L_0x0486
        L_0x0427:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            boolean r4 = com.google.android.gms.internal.vision.zzjp.zzm(r1, r12)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x0486
        L_0x0433:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzk(r14, r4)
            goto L_0x0486
        L_0x043f:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzc(r14, r12)
            goto L_0x0486
        L_0x044b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzh(r14, r4)
            goto L_0x0486
        L_0x0457:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x0486
        L_0x0463:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzi((int) r14, (long) r12)
            goto L_0x0486
        L_0x046f:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            float r4 = com.google.android.gms.internal.vision.zzjp.zzn(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x0486
        L_0x047b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            double r12 = com.google.android.gms.internal.vision.zzjp.zzo(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x0486:
            int r10 = r10 + 3
            goto L_0x002d
        L_0x048a:
            if (r5 == 0) goto L_0x04a1
            com.google.android.gms.internal.vision.zzgf<?> r4 = r0.zzzj
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x049f
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x048a
        L_0x049f:
            r5 = 0
            goto L_0x048a
        L_0x04a1:
            com.google.android.gms.internal.vision.zzjj<?, ?> r3 = r0.zzzi
            zza(r3, r1, (com.google.android.gms.internal.vision.zzkg) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void");
    }

    private final int zzt(int i11, int i12) {
        if (i11 < this.zzyw || i11 > this.zzyx) {
            return -1;
        }
        return zzu(i11, i12);
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name2 = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 40 + name2.length() + String.valueOf(arrays).length());
            sb2.append("Field ");
            sb2.append(str);
            sb2.append(" for ");
            sb2.append(name2);
            sb2.append(" not found. Known fields are ");
            sb2.append(arrays);
            throw new RuntimeException(sb2.toString());
        }
    }

    private final void zza(T t11, T t12, int i11) {
        long zzbp = (long) (zzbp(i11) & 1048575);
        if (zza(t12, i11)) {
            Object zzp = zzjp.zzp(t11, zzbp);
            Object zzp2 = zzjp.zzp(t12, zzbp);
            if (zzp != null && zzp2 != null) {
                zzjp.zza((Object) t11, zzbp, zzgt.zzb(zzp, zzp2));
                zzb(t11, i11);
            } else if (zzp2 != null) {
                zzjp.zza((Object) t11, zzbp, zzp2);
                zzb(t11, i11);
            }
        }
    }

    private static <UT, UB> int zza(zzjj<UT, UB> zzjj, T t11) {
        return zzjj.zzr(zzjj.zzv(t11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzkg r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzfj()
            int r1 = com.google.android.gms.internal.vision.zzgs.zzf.zzwx
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r13.zzzi
            zza(r0, r14, (com.google.android.gms.internal.vision.zzkg) r15)
            boolean r0 = r13.zzyz
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.vision.zzgf<?> r0 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r0 = r0.zze((java.lang.Object) r14)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r0.zztb
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzyu
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzbp(r7)
            int[] r9 = r13.zzyu
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.vision.zzgf<?> r10 = r13.zzzj
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.vision.zzgf<?> r10 = r13.zzzj
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfh r8 = (com.google.android.gms.internal.vision.zzfh) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzfh) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            r13.zza((com.google.android.gms.internal.vision.zzkg) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzyu
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zzit.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfh r8 = (com.google.android.gms.internal.vision.zzfh) r8
            r15.zza((int) r9, (com.google.android.gms.internal.vision.zzfh) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzir r10 = r13.zzbm(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzir) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.zzjp.zzm(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.zzjp.zzn(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.zzjp.zzo(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.vision.zzgf<?> r14 = r13.zzzj
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzzb
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzyz
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.vision.zzgf<?> r0 = r13.zzzj
            com.google.android.gms.internal.vision.zzgi r0 = r0.zze((java.lang.Object) r14)
            com.google.android.gms.internal.vision.zziw<T, java.lang.Object> r1 = r0.zztb
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzyu
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzbp(r8)
            int[] r10 = r13.zzyu
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.vision.zzgf<?> r11 = r13.zzzj
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.vision.zzgf<?> r11 = r13.zzzj
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfh r9 = (com.google.android.gms.internal.vision.zzfh) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzfh) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            r13.zza((com.google.android.gms.internal.vision.zzkg) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            com.google.android.gms.internal.vision.zzit.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzyu
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zzit.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.zzkg) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfh r9 = (com.google.android.gms.internal.vision.zzfh) r9
            r15.zza((int) r10, (com.google.android.gms.internal.vision.zzfh) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzir r11 = r13.zzbm(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzir) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzjp.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.zzkg) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.zzjp.zzm(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzjp.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzjp.zzl(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.zzjp.zzn(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.zzjp.zzo(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.vision.zzgf<?> r2 = r13.zzzj
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.vision.zzjj<?, ?> r0 = r13.zzzi
            zza(r0, r14, (com.google.android.gms.internal.vision.zzkg) r15)
            return
        L_0x0a44:
            r13.zzb(r14, (com.google.android.gms.internal.vision.zzkg) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkg):void");
    }

    private final void zzb(T t11, int i11) {
        if (!this.zzzb) {
            int zzbq = zzbq(i11);
            long j11 = (long) (zzbq & 1048575);
            zzjp.zzb((Object) t11, j11, zzjp.zzk(t11, j11) | (1 << (zzbq >>> 20)));
        }
    }

    private final void zzb(T t11, int i11, int i12) {
        zzjp.zzb((Object) t11, (long) (zzbq(i12) & 1048575), i11);
    }

    private final <K, V> void zza(zzkg zzkg, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzkg.zza(i11, this.zzzk.zzp(zzbn(i12)), this.zzzk.zzl(obj));
        }
    }

    private static <UT, UB> void zza(zzjj<UT, UB> zzjj, T t11, zzkg zzkg) throws IOException {
        zzjj.zza(zzjj.zzv(t11), zzkg);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.vision.zzis r14, com.google.android.gms.internal.vision.zzgd r15) throws java.io.IOException {
        /*
            r12 = this;
            r15.getClass()
            com.google.android.gms.internal.vision.zzjj<?, ?> r7 = r12.zzzi
            com.google.android.gms.internal.vision.zzgf<?> r8 = r12.zzzj
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zzdu()     // Catch:{ all -> 0x05c7 }
            int r2 = r12.zzbs(r1)     // Catch:{ all -> 0x05c7 }
            if (r2 >= 0) goto L_0x0079
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0030
            int r14 = r12.zzze
        L_0x001b:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x002a
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x002a:
            if (r10 == 0) goto L_0x002f
            r7.zzg(r13, r10)
        L_0x002f:
            return
        L_0x0030:
            boolean r2 = r12.zzyz     // Catch:{ all -> 0x05c7 }
            if (r2 != 0) goto L_0x0036
            r2 = r9
            goto L_0x003d
        L_0x0036:
            com.google.android.gms.internal.vision.zzic r2 = r12.zzyy     // Catch:{ all -> 0x05c7 }
            java.lang.Object r1 = r8.zza(r15, r2, r1)     // Catch:{ all -> 0x05c7 }
            r2 = r1
        L_0x003d:
            if (r2 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0045
            com.google.android.gms.internal.vision.zzgi r0 = r8.zzf(r13)     // Catch:{ all -> 0x05c7 }
        L_0x0045:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05c7 }
            r0 = r11
            goto L_0x000a
        L_0x0052:
            r7.zza(r14)     // Catch:{ all -> 0x05c7 }
            if (r10 != 0) goto L_0x005c
            java.lang.Object r1 = r7.zzw(r13)     // Catch:{ all -> 0x05c7 }
            r10 = r1
        L_0x005c:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ all -> 0x05c7 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzze
        L_0x0064:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x0073
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0064
        L_0x0073:
            if (r10 == 0) goto L_0x0078
            r7.zzg(r13, r10)
        L_0x0078:
            return
        L_0x0079:
            int r3 = r12.zzbp(r2)     // Catch:{ all -> 0x05c7 }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0573;
                case 1: goto L_0x0564;
                case 2: goto L_0x0555;
                case 3: goto L_0x0546;
                case 4: goto L_0x0537;
                case 5: goto L_0x0528;
                case 6: goto L_0x0519;
                case 7: goto L_0x050a;
                case 8: goto L_0x0502;
                case 9: goto L_0x04d1;
                case 10: goto L_0x04c2;
                case 11: goto L_0x04b3;
                case 12: goto L_0x0491;
                case 13: goto L_0x0482;
                case 14: goto L_0x0473;
                case 15: goto L_0x0464;
                case 16: goto L_0x0455;
                case 17: goto L_0x0424;
                case 18: goto L_0x0416;
                case 19: goto L_0x0408;
                case 20: goto L_0x03fa;
                case 21: goto L_0x03ec;
                case 22: goto L_0x03de;
                case 23: goto L_0x03d0;
                case 24: goto L_0x03c2;
                case 25: goto L_0x03b4;
                case 26: goto L_0x0392;
                case 27: goto L_0x0380;
                case 28: goto L_0x0372;
                case 29: goto L_0x0364;
                case 30: goto L_0x034f;
                case 31: goto L_0x0341;
                case 32: goto L_0x0333;
                case 33: goto L_0x0325;
                case 34: goto L_0x0317;
                case 35: goto L_0x0309;
                case 36: goto L_0x02fb;
                case 37: goto L_0x02ed;
                case 38: goto L_0x02df;
                case 39: goto L_0x02d1;
                case 40: goto L_0x02c3;
                case 41: goto L_0x02b5;
                case 42: goto L_0x02a7;
                case 43: goto L_0x0299;
                case 44: goto L_0x0284;
                case 45: goto L_0x0276;
                case 46: goto L_0x0268;
                case 47: goto L_0x025a;
                case 48: goto L_0x024c;
                case 49: goto L_0x023a;
                case 50: goto L_0x01f8;
                case 51: goto L_0x01e6;
                case 52: goto L_0x01d4;
                case 53: goto L_0x01c2;
                case 54: goto L_0x01b0;
                case 55: goto L_0x019e;
                case 56: goto L_0x018c;
                case 57: goto L_0x017a;
                case 58: goto L_0x0168;
                case 59: goto L_0x0160;
                case 60: goto L_0x012f;
                case 61: goto L_0x0121;
                case 62: goto L_0x010f;
                case 63: goto L_0x00ea;
                case 64: goto L_0x00d8;
                case 65: goto L_0x00c6;
                case 66: goto L_0x00b4;
                case 67: goto L_0x00a2;
                case 68: goto L_0x0090;
                default: goto L_0x0088;
            }
        L_0x0088:
            if (r10 != 0) goto L_0x0583
            java.lang.Object r1 = r7.zzif()     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x0582
        L_0x0090:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r5 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r5 = r14.zzc(r5, r15)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x00a2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzej()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x00b4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            int r5 = r14.zzei()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x00c6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzeh()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x00d8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            int r5 = r14.zzeg()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x00ea:
            int r4 = r14.zzef()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzgy r6 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a0 }
            if (r6 == 0) goto L_0x0101
            boolean r6 = r6.zzf(r4)     // Catch:{ zzhb -> 0x05a0 }
            if (r6 == 0) goto L_0x00fb
            goto L_0x0101
        L_0x00fb:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0101:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x010f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            int r5 = r14.zzee()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0121:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzfh r5 = r14.zzed()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x012f:
            boolean r4 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            if (r4 == 0) goto L_0x014b
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r6 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r6 = r14.zza(r6, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzgt.zzb(r5, r6)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x015b
        L_0x014b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r5 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r5 = r14.zza(r5, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
        L_0x015b:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0160:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0168:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            boolean r5 = r14.zzeb()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x017a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            int r5 = r14.zzea()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x018c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzdz()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x019e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            int r5 = r14.zzdy()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x01b0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzdw()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x01c2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzdx()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x01d4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            float r5 = r14.readFloat()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x01e6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            double r5 = r14.readDouble()     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x01f8:
            java.lang.Object r1 = r12.zzbn(r2)     // Catch:{ zzhb -> 0x05a0 }
            int r2 = r12.zzbp(r2)     // Catch:{ zzhb -> 0x05a0 }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            if (r4 != 0) goto L_0x0212
            com.google.android.gms.internal.vision.zzhv r4 = r12.zzzk     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r4 = r4.zzo(r1)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r4)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x0229
        L_0x0212:
            com.google.android.gms.internal.vision.zzhv r5 = r12.zzzk     // Catch:{ zzhb -> 0x05a0 }
            boolean r5 = r5.zzm(r4)     // Catch:{ zzhb -> 0x05a0 }
            if (r5 == 0) goto L_0x0229
            com.google.android.gms.internal.vision.zzhv r5 = r12.zzzk     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r5 = r5.zzo(r1)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzhv r6 = r12.zzzk     // Catch:{ zzhb -> 0x05a0 }
            r6.zzc(r5, r4)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r5)     // Catch:{ zzhb -> 0x05a0 }
            r4 = r5
        L_0x0229:
            com.google.android.gms.internal.vision.zzhv r2 = r12.zzzk     // Catch:{ zzhb -> 0x05a0 }
            java.util.Map r2 = r2.zzk(r4)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzhv r3 = r12.zzzk     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzht r1 = r3.zzp(r1)     // Catch:{ zzhb -> 0x05a0 }
            r14.zza(r2, r1, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x023a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzhm r2 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzb(r2, r1, r15)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x024c:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzp(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x025a:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzo(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0268:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzn(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0276:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzm(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0284:
            com.google.android.gms.internal.vision.zzhm r4 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzl(r3)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzgy r2 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.zzgy) r2, r10, r7)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0299:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzk(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02a7:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzh(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02b5:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzg(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02c3:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzf(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02d1:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zze(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02df:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzc(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02ed:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzd(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x02fb:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzb(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0309:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zza(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0317:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzp(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0325:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzo(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0333:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzn(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0341:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzm(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x034f:
            com.google.android.gms.internal.vision.zzhm r4 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzl(r3)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzgy r2 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.zzgy) r2, r10, r7)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0364:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzk(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0372:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzj(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0380:
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzhm r4 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zza(r2, r1, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0392:
            boolean r1 = zzbr(r3)     // Catch:{ zzhb -> 0x05a0 }
            if (r1 == 0) goto L_0x03a6
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzi(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03a6:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.readStringList(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03b4:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzh(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03c2:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzg(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03d0:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzf(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03de:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zze(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03ec:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzc(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x03fa:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzd(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0408:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zzb(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0416:
            com.google.android.gms.internal.vision.zzhm r1 = r12.zzzh     // Catch:{ zzhb -> 0x05a0 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzhb -> 0x05a0 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzhb -> 0x05a0 }
            r14.zza(r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0424:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            if (r1 == 0) goto L_0x0442
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r2 = r14.zzc(r2, r15)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r2)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0442:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r1 = r14.zzc(r1, r15)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0455:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzej()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0464:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            int r1 = r14.zzei()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0473:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzeh()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0482:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            int r1 = r14.zzeg()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0491:
            int r4 = r14.zzef()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzgy r6 = r12.zzbo(r2)     // Catch:{ zzhb -> 0x05a0 }
            if (r6 == 0) goto L_0x04a8
            boolean r6 = r6.zzf(r4)     // Catch:{ zzhb -> 0x05a0 }
            if (r6 == 0) goto L_0x04a2
            goto L_0x04a8
        L_0x04a2:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zzit.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x04a8:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x04b3:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            int r1 = r14.zzee()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x04c2:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzfh r1 = r14.zzed()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x04d1:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            if (r1 == 0) goto L_0x04ef
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzjp.zzp(r13, r3)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r2 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r2 = r14.zza(r2, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r2)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x04ef:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzir r1 = r12.zzbm(r2)     // Catch:{ zzhb -> 0x05a0 }
            java.lang.Object r1 = r14.zza(r1, (com.google.android.gms.internal.vision.zzgd) r15)     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0502:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x050a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            boolean r1 = r14.zzeb()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0519:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            int r1 = r14.zzea()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0528:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzdz()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0537:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            int r1 = r14.zzdy()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zzb((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0546:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzdw()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0555:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            long r5 = r14.zzdx()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0564:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            float r1 = r14.readFloat()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0573:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzhb -> 0x05a0 }
            double r5 = r14.readDouble()     // Catch:{ zzhb -> 0x05a0 }
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ zzhb -> 0x05a0 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzhb -> 0x05a0 }
            goto L_0x000a
        L_0x0582:
            r10 = r1
        L_0x0583:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ zzhb -> 0x05a0 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzze
        L_0x058b:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x059a
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x058b
        L_0x059a:
            if (r10 == 0) goto L_0x059f
            r7.zzg(r13, r10)
        L_0x059f:
            return
        L_0x05a0:
            r7.zza(r14)     // Catch:{ all -> 0x05c7 }
            if (r10 != 0) goto L_0x05aa
            java.lang.Object r1 = r7.zzw(r13)     // Catch:{ all -> 0x05c7 }
            r10 = r1
        L_0x05aa:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.vision.zzis) r14)     // Catch:{ all -> 0x05c7 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzze
        L_0x05b2:
            int r15 = r12.zzzf
            if (r14 >= r15) goto L_0x05c1
            int[] r15 = r12.zzzd
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05b2
        L_0x05c1:
            if (r10 == 0) goto L_0x05c6
            r7.zzg(r13, r10)
        L_0x05c6:
            return
        L_0x05c7:
            r14 = move-exception
            int r15 = r12.zzze
        L_0x05ca:
            int r0 = r12.zzzf
            if (r15 >= r0) goto L_0x05d9
            int[] r0 = r12.zzzd
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05ca
        L_0x05d9:
            if (r10 == 0) goto L_0x05de
            r7.zzg(r13, r10)
        L_0x05de:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, com.google.android.gms.internal.vision.zzis, com.google.android.gms.internal.vision.zzgd):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.vision.zzka r4, java.lang.Class<?> r5, com.google.android.gms.internal.vision.zzfb r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.vision.zzif.zzrr
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r1, r2, r6)
            long r2 = r6.zzrp
            long r2 = com.google.android.gms.internal.vision.zzft.zzr(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzrq = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r1, r2, r6)
            int r2 = r6.zzro
            int r2 = com.google.android.gms.internal.vision.zzft.zzau(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzrq = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.vision.zzin r4 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzir r4 = r4.zzf(r5)
            int r1 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzfb) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r1, r2, r6)
            long r2 = r6.zzrp
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzrq = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r1, r2, r6)
            int r2 = r6.zzro
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzrq = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzrq = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.vision.zzez.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzrq = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzrq = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.vision.zzez.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzrq = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r1, r2, r6)
            long r2 = r6.zzrp
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzrq = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(byte[], int, int, com.google.android.gms.internal.vision.zzka, java.lang.Class, com.google.android.gms.internal.vision.zzfb):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0351 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b0  */
    private final int zza(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.vision.zzfb r29) throws java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r2 = r20
            r6 = r22
            r8 = r23
            r9 = r27
            r7 = r29
            sun.misc.Unsafe r11 = zzyt
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzgz r12 = (com.google.android.gms.internal.vision.zzgz) r12
            boolean r13 = r12.zzdo()
            r14 = 1
            if (r13 != 0) goto L_0x0033
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002b
            r13 = 10
            goto L_0x002c
        L_0x002b:
            int r13 = r13 << r14
        L_0x002c:
            com.google.android.gms.internal.vision.zzgz r12 = r12.zzag(r13)
            r11.putObject(r1, r9, r12)
        L_0x0033:
            r9 = 5
            r10 = 0
            r13 = 2
            switch(r26) {
                case 18: goto L_0x032a;
                case 19: goto L_0x0304;
                case 20: goto L_0x02db;
                case 21: goto L_0x02db;
                case 22: goto L_0x02c1;
                case 23: goto L_0x029a;
                case 24: goto L_0x0273;
                case 25: goto L_0x023b;
                case 26: goto L_0x0188;
                case 27: goto L_0x016e;
                case 28: goto L_0x0116;
                case 29: goto L_0x02c1;
                case 30: goto L_0x00de;
                case 31: goto L_0x0273;
                case 32: goto L_0x029a;
                case 33: goto L_0x00ad;
                case 34: goto L_0x007c;
                case 35: goto L_0x032a;
                case 36: goto L_0x0304;
                case 37: goto L_0x02db;
                case 38: goto L_0x02db;
                case 39: goto L_0x02c1;
                case 40: goto L_0x029a;
                case 41: goto L_0x0273;
                case 42: goto L_0x023b;
                case 43: goto L_0x02c1;
                case 44: goto L_0x00de;
                case 45: goto L_0x0273;
                case 46: goto L_0x029a;
                case 47: goto L_0x00ad;
                case 48: goto L_0x007c;
                case 49: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x0350
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x0350
            com.google.android.gms.internal.vision.zzir r1 = r15.zzbm(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.vision.zzfb) r26)
            java.lang.Object r8 = r7.zzrq
            r12.add(r8)
        L_0x005c:
            if (r4 >= r5) goto L_0x0350
            int r8 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r9 = r7.zzro
            if (r2 != r9) goto L_0x0350
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.vision.zzfb) r26)
            java.lang.Object r8 = r7.zzrq
            r12.add(r8)
            goto L_0x005c
        L_0x007c:
            if (r6 != r13) goto L_0x0084
            int r1 = com.google.android.gms.internal.vision.zzez.zzi(r3, r4, r12, r7)
            goto L_0x0351
        L_0x0084:
            if (r6 != 0) goto L_0x0350
            com.google.android.gms.internal.vision.zzhq r12 = (com.google.android.gms.internal.vision.zzhq) r12
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            long r8 = com.google.android.gms.internal.vision.zzft.zzr(r8)
            r12.zzac(r8)
        L_0x0095:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            long r8 = com.google.android.gms.internal.vision.zzft.zzr(r8)
            r12.zzac(r8)
            goto L_0x0095
        L_0x00ad:
            if (r6 != r13) goto L_0x00b5
            int r1 = com.google.android.gms.internal.vision.zzez.zzh(r3, r4, r12, r7)
            goto L_0x0351
        L_0x00b5:
            if (r6 != 0) goto L_0x0350
            com.google.android.gms.internal.vision.zzgu r12 = (com.google.android.gms.internal.vision.zzgu) r12
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            int r4 = com.google.android.gms.internal.vision.zzft.zzau(r4)
            r12.zzbl(r4)
        L_0x00c6:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            int r4 = com.google.android.gms.internal.vision.zzft.zzau(r4)
            r12.zzbl(r4)
            goto L_0x00c6
        L_0x00de:
            if (r6 != r13) goto L_0x00e5
            int r2 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzgz<?>) r12, (com.google.android.gms.internal.vision.zzfb) r7)
            goto L_0x00f6
        L_0x00e5:
            if (r6 != 0) goto L_0x0350
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.vision.zzez.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzgz<?>) r6, (com.google.android.gms.internal.vision.zzfb) r7)
        L_0x00f6:
            com.google.android.gms.internal.vision.zzgs r1 = (com.google.android.gms.internal.vision.zzgs) r1
            com.google.android.gms.internal.vision.zzjm r3 = r1.zzwd
            com.google.android.gms.internal.vision.zzjm r4 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r3 != r4) goto L_0x0101
            r3 = 0
        L_0x0101:
            com.google.android.gms.internal.vision.zzgy r4 = r15.zzbo(r8)
            com.google.android.gms.internal.vision.zzjj<?, ?> r5 = r0.zzzi
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzit.zza((int) r6, (java.util.List<java.lang.Integer>) r12, (com.google.android.gms.internal.vision.zzgy) r4, r3, r5)
            com.google.android.gms.internal.vision.zzjm r3 = (com.google.android.gms.internal.vision.zzjm) r3
            if (r3 == 0) goto L_0x0113
            r1.zzwd = r3
        L_0x0113:
            r1 = r2
            goto L_0x0351
        L_0x0116:
            if (r6 != r13) goto L_0x0350
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0169
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0164
            if (r4 != 0) goto L_0x012c
            com.google.android.gms.internal.vision.zzfh r4 = com.google.android.gms.internal.vision.zzfh.zzrx
            r12.add(r4)
            goto L_0x0134
        L_0x012c:
            com.google.android.gms.internal.vision.zzfh r6 = com.google.android.gms.internal.vision.zzfh.zza(r3, r1, r4)
            r12.add(r6)
        L_0x0133:
            int r1 = r1 + r4
        L_0x0134:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x015f
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x015a
            if (r4 != 0) goto L_0x0152
            com.google.android.gms.internal.vision.zzfh r4 = com.google.android.gms.internal.vision.zzfh.zzrx
            r12.add(r4)
            goto L_0x0134
        L_0x0152:
            com.google.android.gms.internal.vision.zzfh r6 = com.google.android.gms.internal.vision.zzfh.zza(r3, r1, r4)
            r12.add(r6)
            goto L_0x0133
        L_0x015a:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r1
        L_0x015f:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0164:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r1
        L_0x0169:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x016e:
            if (r6 != r13) goto L_0x0350
            com.google.android.gms.internal.vision.zzir r1 = r15.zzbm(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0351
        L_0x0188:
            if (r6 != r13) goto L_0x0350
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01db
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x01d6
            if (r4 != 0) goto L_0x01a3
            r12.add(r6)
            goto L_0x01ae
        L_0x01a3:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01ad:
            int r1 = r1 + r4
        L_0x01ae:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x01d1
            if (r4 != 0) goto L_0x01c6
            r12.add(r6)
            goto L_0x01ae
        L_0x01c6:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01ad
        L_0x01d1:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x01d6:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x01db:
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x0236
            if (r4 != 0) goto L_0x01e9
            r12.add(r6)
            goto L_0x01fc
        L_0x01e9:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0231
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x01fb:
            r1 = r8
        L_0x01fc:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r7)
            int r4 = r7.zzro
            if (r4 < 0) goto L_0x022c
            if (r4 != 0) goto L_0x0214
            r12.add(r6)
            goto L_0x01fc
        L_0x0214:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0227
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x01fb
        L_0x0227:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x022c:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x0231:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x0236:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgn()
            throw r1
        L_0x023b:
            if (r6 != r13) goto L_0x0243
            int r1 = com.google.android.gms.internal.vision.zzez.zzg(r3, r4, r12, r7)
            goto L_0x0351
        L_0x0243:
            if (r6 != 0) goto L_0x0350
            com.google.android.gms.internal.vision.zzff r12 = (com.google.android.gms.internal.vision.zzff) r12
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            r6 = 0
            if (r4 == 0) goto L_0x0254
            r4 = r14
            goto L_0x0255
        L_0x0254:
            r4 = r6
        L_0x0255:
            r12.addBoolean(r4)
        L_0x0258:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r8 = r7.zzro
            if (r2 != r8) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x026e
            r4 = r14
            goto L_0x026f
        L_0x026e:
            r4 = r6
        L_0x026f:
            r12.addBoolean(r4)
            goto L_0x0258
        L_0x0273:
            if (r6 != r13) goto L_0x027b
            int r1 = com.google.android.gms.internal.vision.zzez.zzc(r3, r4, r12, r7)
            goto L_0x0351
        L_0x027b:
            if (r6 != r9) goto L_0x0350
            com.google.android.gms.internal.vision.zzgu r12 = (com.google.android.gms.internal.vision.zzgu) r12
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r17, r18)
            r12.zzbl(r1)
        L_0x0286:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zza(r3, r4)
            r12.zzbl(r1)
            goto L_0x0286
        L_0x029a:
            if (r6 != r13) goto L_0x02a2
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r3, r4, r12, r7)
            goto L_0x0351
        L_0x02a2:
            if (r6 != r14) goto L_0x0350
            com.google.android.gms.internal.vision.zzhq r12 = (com.google.android.gms.internal.vision.zzhq) r12
            long r8 = com.google.android.gms.internal.vision.zzez.zzb(r17, r18)
            r12.zzac(r8)
        L_0x02ad:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            long r8 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4)
            r12.zzac(r8)
            goto L_0x02ad
        L_0x02c1:
            if (r6 != r13) goto L_0x02c9
            int r1 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.zzgz<?>) r12, (com.google.android.gms.internal.vision.zzfb) r7)
            goto L_0x0351
        L_0x02c9:
            if (r6 != 0) goto L_0x0350
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.vision.zzez.zza((int) r20, (byte[]) r21, (int) r22, (int) r23, (com.google.android.gms.internal.vision.zzgz<?>) r24, (com.google.android.gms.internal.vision.zzfb) r25)
            goto L_0x0351
        L_0x02db:
            if (r6 != r13) goto L_0x02e3
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r12, r7)
            goto L_0x0351
        L_0x02e3:
            if (r6 != 0) goto L_0x0350
            com.google.android.gms.internal.vision.zzhq r12 = (com.google.android.gms.internal.vision.zzhq) r12
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r12.zzac(r8)
        L_0x02f0:
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r7)
            long r8 = r7.zzrp
            r12.zzac(r8)
            goto L_0x02f0
        L_0x0304:
            if (r6 != r13) goto L_0x030b
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r3, r4, r12, r7)
            goto L_0x0351
        L_0x030b:
            if (r6 != r9) goto L_0x0350
            com.google.android.gms.internal.vision.zzgo r12 = (com.google.android.gms.internal.vision.zzgo) r12
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r17, r18)
            r12.zzu(r1)
        L_0x0316:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            float r1 = com.google.android.gms.internal.vision.zzez.zzd(r3, r4)
            r12.zzu(r1)
            goto L_0x0316
        L_0x032a:
            if (r6 != r13) goto L_0x0331
            int r1 = com.google.android.gms.internal.vision.zzez.zzf(r3, r4, r12, r7)
            goto L_0x0351
        L_0x0331:
            if (r6 != r14) goto L_0x0350
            com.google.android.gms.internal.vision.zzgb r12 = (com.google.android.gms.internal.vision.zzgb) r12
            double r8 = com.google.android.gms.internal.vision.zzez.zzc(r17, r18)
            r12.zzc(r8)
        L_0x033c:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0351
            int r4 = com.google.android.gms.internal.vision.zzez.zza(r3, r1, r7)
            int r6 = r7.zzro
            if (r2 != r6) goto L_0x0351
            double r8 = com.google.android.gms.internal.vision.zzez.zzc(r3, r4)
            r12.zzc(r8)
            goto L_0x033c
        L_0x0350:
            r1 = r4
        L_0x0351:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.vision.zzfb r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzyt
            java.lang.Object r12 = r7.zzbn(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.vision.zzhv r2 = r7.zzzk
            boolean r2 = r2.zzm(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.vision.zzhv r2 = r7.zzzk
            java.lang.Object r2 = r2.zzo(r12)
            com.google.android.gms.internal.vision.zzhv r3 = r7.zzzk
            r3.zzc(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.vision.zzhv r8 = r7.zzzk
            com.google.android.gms.internal.vision.zzht r8 = r8.zzp(r12)
            com.google.android.gms.internal.vision.zzhv r12 = r7.zzzk
            java.util.Map r12 = r12.zzk(r1)
            int r10 = com.google.android.gms.internal.vision.zzez.zza(r9, r10, r15)
            int r13 = r15.zzro
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzyn
            V r0 = r8.zzgc
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.vision.zzez.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.vision.zzfb) r15)
            int r10 = r15.zzro
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.vision.zzka r1 = r8.zzyo
            int r1 = r1.zziq()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzka r4 = r8.zzyo
            V r10 = r8.zzgc
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzfb) r6)
            java.lang.Object r0 = r15.zzrq
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.vision.zzka r1 = r8.zzym
            int r1 = r1.zziq()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.vision.zzka r4 = r8.zzym
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzfb) r6)
            java.lang.Object r14 = r15.zzrq
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.vision.zzez.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.vision.zzfb) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.vision.zzhc r8 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.vision.zzhc r8 = com.google.android.gms.internal.vision.zzhc.zzgm()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.vision.zzfb r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzyt
            int[] r7 = r0.zzyu
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.vision.zzir r2 = r0.zzbm(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.vision.zzfb) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzrq
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzrq
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzgt.zzb(r15, r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11)
            long r3 = r11.zzrp
            long r3 = com.google.android.gms.internal.vision.zzft.zzr(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r3 = r11.zzro
            int r3 = com.google.android.gms.internal.vision.zzft.zzau(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r4 = r11.zzro
            com.google.android.gms.internal.vision.zzgy r5 = r0.zzbo(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzf(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.vision.zzjm r1 = zzs(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzb(r2, r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzrq
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.vision.zzir r2 = r0.zzbm(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzfb) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzrq
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzrq
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzgt.zzb(r15, r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r4 = r11.zzro
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.vision.zzjs.zzf(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.vision.zzhc r1 = com.google.android.gms.internal.vision.zzhc.zzgt()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.vision.zzgt.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11)
            long r3 = r11.zzrp
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.vision.zzez.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r3, r4, r11)
            int r3 = r11.zzro
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r3, r4, r11)
            long r3 = r11.zzrp
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.vision.zzez.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.vision.zzez.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v41, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0292, code lost:
        r6 = r6 | r23;
        r7 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0296, code lost:
        r3 = r11;
        r2 = r12;
        r1 = r13;
        r13 = r36;
        r11 = r37;
        r12 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02a0, code lost:
        r2 = r7;
        r18 = r8;
        r29 = r10;
        r9 = r11;
        r27 = r12;
        r23 = r13;
        r7 = r35;
        r8 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0347, code lost:
        if (r0 == r15) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0390, code lost:
        if (r0 == r15) goto L_0x03ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04e7, code lost:
        r2 = r1;
        r35 = r6;
        r21 = r7;
        r6 = r36;
        r7 = r5;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0546, code lost:
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0655, code lost:
        r2 = r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0668, code lost:
        r2 = r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0092, code lost:
        r8 = true;
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fb, code lost:
        r5 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x015a, code lost:
        r6 = r6 | r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d6, code lost:
        r35 = r7;
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01f2, code lost:
        r35 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0230, code lost:
        r6 = r6 | r23;
        r7 = r35;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0234, code lost:
        r3 = r11;
        r2 = r12;
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0259, code lost:
        r13 = r36;
        r11 = r37;
        r12 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0260, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0279, code lost:
        r8 = true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.vision.zzfb r38) throws java.io.IOException {
        /*
            r32 = this;
            r15 = r32
            r14 = r33
            r12 = r34
            r13 = r36
            r11 = r37
            r9 = r38
            sun.misc.Unsafe r10 = zzyt
            r16 = 0
            r0 = r35
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            r17 = 0
            if (r0 >= r13) goto L_0x06e9
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzfb) r9)
            int r3 = r9.zzro
            r4 = r0
            r5 = r3
            goto L_0x002d
        L_0x002b:
            r5 = r0
            r4 = r3
        L_0x002d:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.zzt(r3, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzbs(r3)
        L_0x003e:
            r2 = r1
            r19 = 0
            r8 = -1
            if (r2 != r8) goto L_0x0051
            r23 = r3
            r2 = r4
            r9 = r5
            r29 = r10
            r8 = r11
            r27 = r16
            r18 = 1
            goto L_0x03be
        L_0x0051:
            int[] r8 = r15.zzyu
            int r22 = r2 + 1
            r1 = r8[r22]
            r22 = 267386880(0xff00000, float:2.3665827E-29)
            r22 = r1 & r22
            int r11 = r22 >>> 20
            r22 = 1048575(0xfffff, float:1.469367E-39)
            r24 = r5
            r5 = r1 & r22
            long r12 = (long) r5
            r5 = 17
            if (r11 > r5) goto L_0x02b0
            int r23 = r2 + 2
            r8 = r8[r23]
            int r23 = r8 >>> 20
            r21 = 1
            int r23 = r21 << r23
            r8 = r8 & r22
            r25 = r12
            if (r8 == r7) goto L_0x0086
            r12 = -1
            if (r7 == r12) goto L_0x0080
            long r12 = (long) r7
            r10.putInt(r14, r12, r6)
        L_0x0080:
            long r6 = (long) r8
            int r6 = r10.getInt(r14, r6)
            r7 = r8
        L_0x0086:
            r8 = 5
            switch(r11) {
                case 0: goto L_0x027b;
                case 1: goto L_0x0262;
                case 2: goto L_0x0238;
                case 3: goto L_0x0238;
                case 4: goto L_0x021a;
                case 5: goto L_0x01f6;
                case 6: goto L_0x01db;
                case 7: goto L_0x01ba;
                case 8: goto L_0x019b;
                case 9: goto L_0x015e;
                case 10: goto L_0x0146;
                case 11: goto L_0x021a;
                case 12: goto L_0x0117;
                case 13: goto L_0x01db;
                case 14: goto L_0x01f6;
                case 15: goto L_0x00ff;
                case 16: goto L_0x00d8;
                case 17: goto L_0x0096;
                default: goto L_0x008a;
            }
        L_0x008a:
            r5 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
        L_0x0092:
            r8 = 1
            r7 = r4
            goto L_0x02a0
        L_0x0096:
            r11 = 3
            if (r0 != r11) goto L_0x00d3
            int r0 = r3 << 3
            r5 = r0 | 4
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r2)
            r1 = r34
            r12 = r2
            r2 = r4
            r13 = r3
            r3 = r36
            r4 = r5
            r11 = r24
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzfb) r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x00bd
            java.lang.Object r1 = r9.zzrq
            r2 = r25
            r10.putObject(r14, r2, r1)
            goto L_0x00cc
        L_0x00bd:
            r2 = r25
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x00cc:
            r6 = r6 | r23
            r3 = r11
            r2 = r12
            r1 = r13
            goto L_0x02fe
        L_0x00d3:
            r12 = r2
            r13 = r3
            r11 = r24
            goto L_0x00fb
        L_0x00d8:
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x00fb
            r8 = r34
            int r17 = com.google.android.gms.internal.vision.zzez.zzb(r8, r4, r9)
            long r0 = r9.zzrp
            long r4 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            r0 = r10
            r1 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r3 = r11
            r2 = r12
            r1 = r13
            r0 = r17
            goto L_0x0259
        L_0x00fb:
            r5 = r34
            goto L_0x01f2
        L_0x00ff:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r8, r4, r9)
            int r1 = r9.zzro
            int r1 = com.google.android.gms.internal.vision.zzft.zzau(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x0117:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r8, r4, r9)
            int r1 = r9.zzro
            com.google.android.gms.internal.vision.zzgy r4 = r15.zzbo(r12)
            if (r4 == 0) goto L_0x0142
            boolean r4 = r4.zzf(r1)
            if (r4 == 0) goto L_0x0134
            goto L_0x0142
        L_0x0134:
            com.google.android.gms.internal.vision.zzjm r2 = zzs(r33)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzb(r11, r1)
            goto L_0x0234
        L_0x0142:
            r10.putInt(r14, r2, r1)
            goto L_0x015a
        L_0x0146:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r1 = 2
            if (r0 != r1) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zze(r8, r4, r9)
            java.lang.Object r1 = r9.zzrq
            r10.putObject(r14, r2, r1)
        L_0x015a:
            r6 = r6 | r23
            goto L_0x0234
        L_0x015e:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r1 = 2
            if (r0 != r1) goto L_0x0198
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r12)
            r1 = r36
            int r0 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r8, (int) r4, (int) r1, (com.google.android.gms.internal.vision.zzfb) r9)
            r4 = r6 & r23
            if (r4 != 0) goto L_0x017d
            java.lang.Object r4 = r9.zzrq
            r10.putObject(r14, r2, r4)
            goto L_0x018a
        L_0x017d:
            java.lang.Object r4 = r10.getObject(r14, r2)
            java.lang.Object r5 = r9.zzrq
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzgt.zzb(r4, r5)
            r10.putObject(r14, r2, r4)
        L_0x018a:
            r6 = r6 | r23
            r3 = r11
            r2 = r12
            r11 = r37
            r12 = r8
            r30 = r13
            r13 = r1
            r1 = r30
            goto L_0x0018
        L_0x0198:
            r1 = r36
            goto L_0x01d6
        L_0x019b:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r5 = 2
            if (r0 != r5) goto L_0x01d6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01b0
            int r0 = com.google.android.gms.internal.vision.zzez.zzc(r8, r4, r9)
            goto L_0x01b4
        L_0x01b0:
            int r0 = com.google.android.gms.internal.vision.zzez.zzd(r8, r4, r9)
        L_0x01b4:
            java.lang.Object r1 = r9.zzrq
            r10.putObject(r14, r2, r1)
            goto L_0x015a
        L_0x01ba:
            r8 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != 0) goto L_0x01d6
            int r0 = com.google.android.gms.internal.vision.zzez.zzb(r8, r4, r9)
            long r4 = r9.zzrp
            int r1 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r1 == 0) goto L_0x01d0
            r1 = 1
            goto L_0x01d2
        L_0x01d0:
            r1 = r16
        L_0x01d2:
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (boolean) r1)
            goto L_0x015a
        L_0x01d6:
            r35 = r7
            r5 = r8
            goto L_0x0092
        L_0x01db:
            r5 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            if (r0 != r8) goto L_0x01f2
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r5, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
            r6 = r6 | r23
            goto L_0x0296
        L_0x01f2:
            r35 = r7
            goto L_0x0092
        L_0x01f6:
            r5 = r34
            r12 = r2
            r13 = r3
            r11 = r24
            r2 = r25
            r1 = 1
            if (r0 != r1) goto L_0x0214
            long r19 = com.google.android.gms.internal.vision.zzez.zzb(r5, r4)
            r0 = r10
            r1 = r33
            r8 = r5
            r35 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0230
        L_0x0214:
            r35 = r7
            r7 = r4
            r8 = r1
            goto L_0x02a0
        L_0x021a:
            r8 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r7 = r4
            if (r0 != 0) goto L_0x0260
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r8, r7, r9)
            int r1 = r9.zzro
            r10.putInt(r14, r2, r1)
        L_0x0230:
            r6 = r6 | r23
            r7 = r35
        L_0x0234:
            r3 = r11
            r2 = r12
            r1 = r13
            goto L_0x0259
        L_0x0238:
            r8 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r7 = r4
            if (r0 != 0) goto L_0x0260
            int r7 = com.google.android.gms.internal.vision.zzez.zzb(r8, r7, r9)
            long r4 = r9.zzrp
            r0 = r10
            r1 = r33
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r0 = r7
            r3 = r11
            r2 = r12
            r1 = r13
            r7 = r35
        L_0x0259:
            r13 = r36
            r11 = r37
            r12 = r8
            goto L_0x0018
        L_0x0260:
            r5 = r8
            goto L_0x0279
        L_0x0262:
            r5 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r7 = r4
            if (r0 != r8) goto L_0x0279
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r5, r7)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x0292
        L_0x0279:
            r8 = 1
            goto L_0x02a0
        L_0x027b:
            r5 = r34
            r12 = r2
            r13 = r3
            r35 = r7
            r11 = r24
            r2 = r25
            r8 = 1
            r7 = r4
            if (r0 != r8) goto L_0x02a0
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r5, r7)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (double) r0)
            int r0 = r7 + 8
        L_0x0292:
            r6 = r6 | r23
            r7 = r35
        L_0x0296:
            r3 = r11
            r2 = r12
            r1 = r13
            r13 = r36
            r11 = r37
            r12 = r5
            goto L_0x0018
        L_0x02a0:
            r2 = r7
            r18 = r8
            r29 = r10
            r9 = r11
            r27 = r12
            r23 = r13
            r7 = r35
            r8 = r37
            goto L_0x03be
        L_0x02b0:
            r5 = r34
            r21 = r7
            r7 = r4
            r4 = r24
            r30 = r12
            r12 = r2
            r13 = r3
            r2 = r30
            r8 = 27
            if (r11 != r8) goto L_0x0315
            r8 = 2
            if (r0 != r8) goto L_0x0306
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.vision.zzgz r0 = (com.google.android.gms.internal.vision.zzgz) r0
            boolean r1 = r0.zzdo()
            if (r1 != 0) goto L_0x02e2
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d9
            r1 = 10
            goto L_0x02db
        L_0x02d9:
            int r1 = r1 << 1
        L_0x02db:
            com.google.android.gms.internal.vision.zzgz r0 = r0.zzag(r1)
            r10.putObject(r14, r2, r0)
        L_0x02e2:
            r8 = r0
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r12)
            r1 = r4
            r2 = r34
            r3 = r7
            r11 = r4
            r4 = r36
            r5 = r8
            r24 = r6
            r6 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5, r6)
            r3 = r11
            r2 = r12
            r1 = r13
            r7 = r21
            r6 = r24
        L_0x02fe:
            r12 = r34
            r13 = r36
            r11 = r37
            goto L_0x0018
        L_0x0306:
            r24 = r6
            r22 = r4
            r15 = r7
            r29 = r10
            r27 = r12
            r23 = r13
            r18 = 1
            goto L_0x0393
        L_0x0315:
            r8 = r4
            r24 = r6
            r4 = 49
            if (r11 > r4) goto L_0x0365
            long r5 = (long) r1
            r4 = r0
            r0 = r32
            r1 = r33
            r25 = r2
            r2 = r34
            r3 = r7
            r35 = r4
            r4 = r36
            r27 = r5
            r5 = r8
            r6 = r13
            r15 = r7
            r7 = r35
            r22 = r8
            r18 = 1
            r8 = r12
            r29 = r10
            r9 = r27
            r27 = r12
            r23 = r13
            r12 = r25
            r14 = r38
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzfb) r14)
            if (r0 != r15) goto L_0x034b
            goto L_0x03ba
        L_0x034b:
            r15 = r32
            r14 = r33
            r12 = r34
            r13 = r36
            r11 = r37
            r9 = r38
            r7 = r21
            r3 = r22
            r1 = r23
            r6 = r24
            r2 = r27
            r10 = r29
            goto L_0x0018
        L_0x0365:
            r35 = r0
            r25 = r2
            r15 = r7
            r22 = r8
            r29 = r10
            r27 = r12
            r23 = r13
            r18 = 1
            r0 = 50
            if (r11 != r0) goto L_0x039d
            r7 = r35
            r0 = 2
            if (r7 != r0) goto L_0x0393
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r15
            r4 = r36
            r5 = r27
            r6 = r25
            r8 = r38
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzfb) r8)
            if (r0 != r15) goto L_0x034b
            goto L_0x03ba
        L_0x0393:
            r8 = r37
            r2 = r15
        L_0x0396:
            r7 = r21
            r9 = r22
            r6 = r24
            goto L_0x03be
        L_0x039d:
            r7 = r35
            r0 = r32
            r8 = r1
            r1 = r33
            r2 = r34
            r3 = r15
            r4 = r36
            r5 = r22
            r6 = r23
            r9 = r11
            r10 = r25
            r12 = r27
            r13 = r38
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzfb) r13)
            if (r0 != r15) goto L_0x06cd
        L_0x03ba:
            r8 = r37
            r2 = r0
            goto L_0x0396
        L_0x03be:
            if (r9 != r8) goto L_0x03cf
            if (r8 != 0) goto L_0x03c3
            goto L_0x03cf
        L_0x03c3:
            r10 = r32
            r14 = r33
            r0 = r2
            r1 = r6
            r3 = r9
            r2 = -1
            r6 = r36
            goto L_0x06f5
        L_0x03cf:
            r10 = r32
            boolean r0 = r10.zzyz
            if (r0 == 0) goto L_0x069f
            r11 = r38
            com.google.android.gms.internal.vision.zzgd r0 = r11.zzcm
            com.google.android.gms.internal.vision.zzgd r1 = com.google.android.gms.internal.vision.zzgd.zzfl()
            if (r0 == r1) goto L_0x069c
            com.google.android.gms.internal.vision.zzic r0 = r10.zzyy
            com.google.android.gms.internal.vision.zzjj<?, ?> r1 = r10.zzzi
            com.google.android.gms.internal.vision.zzgd r3 = r11.zzcm
            r12 = r23
            com.google.android.gms.internal.vision.zzgs$zzg r13 = r3.zza(r0, r12)
            if (r13 != 0) goto L_0x0408
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r33)
            r0 = r9
            r1 = r34
            r3 = r36
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzjm) r4, (com.google.android.gms.internal.vision.zzfb) r5)
            r14 = r33
            r35 = r6
            r21 = r7
            r7 = r34
            r6 = r36
            goto L_0x06bc
        L_0x0408:
            r14 = r33
            r0 = r14
            com.google.android.gms.internal.vision.zzgs$zze r0 = (com.google.android.gms.internal.vision.zzgs.zze) r0
            r0.zzgk()
            com.google.android.gms.internal.vision.zzgi<com.google.android.gms.internal.vision.zzgs$zzd> r15 = r0.zzwk
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            boolean r4 = r3.zzwi
            if (r4 == 0) goto L_0x04f1
            boolean r4 = r3.zzwj
            if (r4 == 0) goto L_0x04f1
            int[] r4 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzka r3 = r3.zzwh
            int r3 = r3.ordinal()
            r3 = r4[r3]
            switch(r3) {
                case 1: goto L_0x04dc;
                case 2: goto L_0x04d0;
                case 3: goto L_0x04c4;
                case 4: goto L_0x04c4;
                case 5: goto L_0x04b8;
                case 6: goto L_0x04b8;
                case 7: goto L_0x04ac;
                case 8: goto L_0x04ac;
                case 9: goto L_0x04a0;
                case 10: goto L_0x04a0;
                case 11: goto L_0x0494;
                case 12: goto L_0x0488;
                case 13: goto L_0x047c;
                case 14: goto L_0x044e;
                default: goto L_0x0429;
            }
        L_0x0429:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            com.google.android.gms.internal.vision.zzka r1 = r1.zzwh
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r2 = r1.length()
            int r2 = r2 + 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Type cannot be packed: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x044e:
            com.google.android.gms.internal.vision.zzgu r3 = new com.google.android.gms.internal.vision.zzgu
            r3.<init>()
            r5 = r34
            int r2 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r5, (int) r2, (com.google.android.gms.internal.vision.zzgz<?>) r3, (com.google.android.gms.internal.vision.zzfb) r11)
            com.google.android.gms.internal.vision.zzjm r4 = r0.zzwd
            r35 = r2
            com.google.android.gms.internal.vision.zzjm r2 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r4 != r2) goto L_0x0465
            r4 = r17
        L_0x0465:
            com.google.android.gms.internal.vision.zzgs$zzd r2 = r13.zzxb
            com.google.android.gms.internal.vision.zzgv<?> r2 = r2.zzwg
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzit.zza((int) r12, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.zzgv<?>) r2, r4, r1)
            com.google.android.gms.internal.vision.zzjm r1 = (com.google.android.gms.internal.vision.zzjm) r1
            if (r1 == 0) goto L_0x0473
            r0.zzwd = r1
        L_0x0473:
            com.google.android.gms.internal.vision.zzgs$zzd r0 = r13.zzxb
            r15.zza(r0, (java.lang.Object) r3)
            r2 = r35
            goto L_0x051c
        L_0x047c:
            r5 = r34
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzi(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x0488:
            r5 = r34
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzh(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x0494:
            r5 = r34
            com.google.android.gms.internal.vision.zzff r0 = new com.google.android.gms.internal.vision.zzff
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzg(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x04a0:
            r5 = r34
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzc(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x04ac:
            r5 = r34
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzd(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x04b8:
            r5 = r34
            com.google.android.gms.internal.vision.zzgu r0 = new com.google.android.gms.internal.vision.zzgu
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zza((byte[]) r5, (int) r2, (com.google.android.gms.internal.vision.zzgz<?>) r0, (com.google.android.gms.internal.vision.zzfb) r11)
            goto L_0x04e7
        L_0x04c4:
            r5 = r34
            com.google.android.gms.internal.vision.zzhq r0 = new com.google.android.gms.internal.vision.zzhq
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x04d0:
            r5 = r34
            com.google.android.gms.internal.vision.zzgo r0 = new com.google.android.gms.internal.vision.zzgo
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zze(r5, r2, r0, r11)
            goto L_0x04e7
        L_0x04dc:
            r5 = r34
            com.google.android.gms.internal.vision.zzgb r0 = new com.google.android.gms.internal.vision.zzgb
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzez.zzf(r5, r2, r0, r11)
        L_0x04e7:
            r2 = r1
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            goto L_0x0695
        L_0x04f1:
            r5 = r34
            com.google.android.gms.internal.vision.zzka r3 = r3.zzwh
            com.google.android.gms.internal.vision.zzka r4 = com.google.android.gms.internal.vision.zzka.ENUM
            if (r3 != r4) goto L_0x0534
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r5, r2, r11)
            com.google.android.gms.internal.vision.zzgs$zzd r3 = r13.zzxb
            com.google.android.gms.internal.vision.zzgv<?> r3 = r3.zzwg
            int r4 = r11.zzro
            com.google.android.gms.internal.vision.zzgw r3 = r3.zzg(r4)
            if (r3 != 0) goto L_0x0525
            com.google.android.gms.internal.vision.zzjm r3 = r0.zzwd
            com.google.android.gms.internal.vision.zzjm r4 = com.google.android.gms.internal.vision.zzjm.zzig()
            if (r3 != r4) goto L_0x0517
            com.google.android.gms.internal.vision.zzjm r3 = com.google.android.gms.internal.vision.zzjm.zzih()
            r0.zzwd = r3
        L_0x0517:
            int r0 = r11.zzro
            com.google.android.gms.internal.vision.zzit.zza((int) r12, (int) r0, r3, r1)
        L_0x051c:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            goto L_0x069a
        L_0x0525:
            int r0 = r11.zzro
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            r35 = r6
            r21 = r7
            r0 = r17
            r6 = r36
            goto L_0x0565
        L_0x0534:
            int[] r0 = com.google.android.gms.internal.vision.zzfc.zzrr
            int r1 = r3.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0659;
                case 2: goto L_0x0646;
                case 3: goto L_0x0633;
                case 4: goto L_0x0633;
                case 5: goto L_0x0620;
                case 6: goto L_0x0620;
                case 7: goto L_0x0610;
                case 8: goto L_0x0610;
                case 9: goto L_0x0600;
                case 10: goto L_0x0600;
                case 11: goto L_0x05e6;
                case 12: goto L_0x05cf;
                case 13: goto L_0x05b8;
                case 14: goto L_0x05b0;
                case 15: goto L_0x05a1;
                case 16: goto L_0x0592;
                case 17: goto L_0x0568;
                case 18: goto L_0x054a;
                default: goto L_0x053f;
            }
        L_0x053f:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
        L_0x0546:
            r0 = r17
            goto L_0x066c
        L_0x054a:
            com.google.android.gms.internal.vision.zzin r0 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r1 = r13.zzxa
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzir r0 = r0.zzf(r1)
            r4 = r36
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r5, (int) r2, (int) r4, (com.google.android.gms.internal.vision.zzfb) r11)
            java.lang.Object r0 = r11.zzrq
            r35 = r6
            r21 = r7
            r6 = r4
        L_0x0565:
            r7 = r5
            goto L_0x066c
        L_0x0568:
            r4 = r36
            int r0 = r12 << 3
            r17 = r0 | 4
            com.google.android.gms.internal.vision.zzin r0 = com.google.android.gms.internal.vision.zzin.zzho()
            com.google.android.gms.internal.vision.zzic r1 = r13.zzxa
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zzir r0 = r0.zzf(r1)
            r1 = r34
            r3 = r36
            r35 = r6
            r6 = r4
            r4 = r17
            r21 = r7
            r7 = r5
            r5 = r38
            int r2 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.zzfb) r5)
            java.lang.Object r0 = r11.zzrq
            goto L_0x066c
        L_0x0592:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzc(r7, r2, r11)
            java.lang.Object r0 = r11.zzrq
            goto L_0x066c
        L_0x05a1:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zze(r7, r2, r11)
            java.lang.Object r0 = r11.zzrq
            goto L_0x066c
        L_0x05b0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x05b8:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2, r11)
            long r0 = r11.zzrp
            long r0 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0546
        L_0x05cf:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r7, r2, r11)
            int r0 = r11.zzro
            int r0 = com.google.android.gms.internal.vision.zzft.zzau(r0)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0546
        L_0x05e6:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2, r11)
            long r0 = r11.zzrp
            int r0 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x05f8
            goto L_0x05fa
        L_0x05f8:
            r18 = r16
        L_0x05fa:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r18)
            goto L_0x0546
        L_0x0600:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r7, r2)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0655
        L_0x0610:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            long r0 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0668
        L_0x0620:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zza(r7, r2, r11)
            int r0 = r11.zzro
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0546
        L_0x0633:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            int r2 = com.google.android.gms.internal.vision.zzez.zzb(r7, r2, r11)
            long r0 = r11.zzrp
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0546
        L_0x0646:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r7, r2)
            java.lang.Float r17 = java.lang.Float.valueOf(r0)
        L_0x0655:
            int r2 = r2 + 4
            goto L_0x0546
        L_0x0659:
            r35 = r6
            r21 = r7
            r6 = r36
            r7 = r5
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r7, r2)
            java.lang.Double r17 = java.lang.Double.valueOf(r0)
        L_0x0668:
            int r2 = r2 + 8
            goto L_0x0546
        L_0x066c:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            boolean r3 = r1.zzwi
            if (r3 == 0) goto L_0x0676
            r15.zzb(r1, (java.lang.Object) r0)
            goto L_0x069a
        L_0x0676:
            int[] r3 = com.google.android.gms.internal.vision.zzfc.zzrr
            com.google.android.gms.internal.vision.zzka r1 = r1.zzwh
            int r1 = r1.ordinal()
            r1 = r3[r1]
            r3 = 17
            if (r1 == r3) goto L_0x0689
            r3 = 18
            if (r1 == r3) goto L_0x0689
            goto L_0x0695
        L_0x0689:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            java.lang.Object r1 = r15.zza(r1)
            if (r1 == 0) goto L_0x0695
            java.lang.Object r0 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r0)
        L_0x0695:
            com.google.android.gms.internal.vision.zzgs$zzd r1 = r13.zzxb
            r15.zza(r1, (java.lang.Object) r0)
        L_0x069a:
            r0 = r2
            goto L_0x06bc
        L_0x069c:
            r14 = r33
            goto L_0x06a3
        L_0x069f:
            r14 = r33
            r11 = r38
        L_0x06a3:
            r35 = r6
            r21 = r7
            r12 = r23
            r7 = r34
            r6 = r36
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r33)
            r0 = r9
            r1 = r34
            r3 = r36
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzjm) r4, (com.google.android.gms.internal.vision.zzfb) r5)
        L_0x06bc:
            r13 = r6
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r27
            r10 = r29
            r6 = r35
            r12 = r7
            r11 = r8
            r7 = r21
            goto L_0x0018
        L_0x06cd:
            r9 = r22
            r12 = r23
            r15 = r32
            r14 = r33
            r13 = r36
            r11 = r37
            r3 = r9
            r1 = r12
            r7 = r21
            r6 = r24
            r2 = r27
            r10 = r29
            r12 = r34
            r9 = r38
            goto L_0x0018
        L_0x06e9:
            r24 = r6
            r21 = r7
            r29 = r10
            r8 = r11
            r6 = r13
            r10 = r15
            r1 = r24
            r2 = -1
        L_0x06f5:
            if (r7 == r2) goto L_0x06fd
            long r4 = (long) r7
            r2 = r29
            r2.putInt(r14, r4, r1)
        L_0x06fd:
            int r1 = r10.zzze
            r2 = r17
        L_0x0701:
            int r4 = r10.zzzf
            if (r1 >= r4) goto L_0x0714
            int[] r4 = r10.zzzd
            r4 = r4[r1]
            com.google.android.gms.internal.vision.zzjj<?, ?> r5 = r10.zzzi
            java.lang.Object r2 = r10.zza((java.lang.Object) r14, (int) r4, r2, r5)
            com.google.android.gms.internal.vision.zzjm r2 = (com.google.android.gms.internal.vision.zzjm) r2
            int r1 = r1 + 1
            goto L_0x0701
        L_0x0714:
            if (r2 == 0) goto L_0x071b
            com.google.android.gms.internal.vision.zzjj<?, ?> r1 = r10.zzzi
            r1.zzg(r14, r2)
        L_0x071b:
            if (r8 != 0) goto L_0x0725
            if (r0 != r6) goto L_0x0720
            goto L_0x0729
        L_0x0720:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x0725:
            if (r0 > r6) goto L_0x072a
            if (r3 != r8) goto L_0x072a
        L_0x0729:
            return r0
        L_0x072a:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzfb):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010d, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013f, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x015b, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015d, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0162, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01e4, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0211, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0230, code lost:
        if (r0 == r15) goto L_0x0232;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.vision.zzfb r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzzb
            if (r0 == 0) goto L_0x0260
            sun.misc.Unsafe r9 = zzyt
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = r10
            r2 = r16
        L_0x0018:
            if (r0 >= r13) goto L_0x0257
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.zzfb) r11)
            int r3 = r11.zzro
            r8 = r0
            r17 = r3
            goto L_0x002d
        L_0x002a:
            r17 = r0
            r8 = r3
        L_0x002d:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x003a
            int r2 = r2 / 3
            int r0 = r15.zzt(r7, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.zzbs(r7)
        L_0x003e:
            r4 = r0
            if (r4 != r10) goto L_0x004c
            r24 = r7
            r2 = r8
            r18 = r9
            r26 = r10
            r19 = r16
            goto L_0x0233
        L_0x004c:
            int[] r0 = r15.zzyu
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x016a
            r0 = 1
            switch(r3) {
                case 0: goto L_0x0150;
                case 1: goto L_0x0141;
                case 2: goto L_0x012f;
                case 3: goto L_0x012f;
                case 4: goto L_0x0121;
                case 5: goto L_0x0111;
                case 6: goto L_0x0100;
                case 7: goto L_0x00e9;
                case 8: goto L_0x00d2;
                case 9: goto L_0x00b1;
                case 10: goto L_0x00a4;
                case 11: goto L_0x0121;
                case 12: goto L_0x0095;
                case 13: goto L_0x0100;
                case 14: goto L_0x0111;
                case 15: goto L_0x0082;
                case 16: goto L_0x0067;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x01a6
        L_0x0067:
            if (r6 != 0) goto L_0x01a6
            int r6 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzrp
            long r21 = com.google.android.gms.internal.vision.zzft.zzr(r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013f
        L_0x0082:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            int r1 = com.google.android.gms.internal.vision.zzft.zzau(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x0095:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x00a4:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            int r0 = com.google.android.gms.internal.vision.zzez.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00b1:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r4)
            int r0 = com.google.android.gms.internal.vision.zzez.zza((com.google.android.gms.internal.vision.zzir) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.vision.zzfb) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c8
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00c8:
            java.lang.Object r5 = r11.zzrq
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgt.zzb(r1, r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00d2:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00df
            int r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r8, r11)
            goto L_0x00e3
        L_0x00df:
            int r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r8, r11)
        L_0x00e3:
            java.lang.Object r1 = r11.zzrq
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00e9:
            r2 = r1
            if (r6 != 0) goto L_0x01a6
            int r1 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            long r5 = r11.zzrp
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r0 = r16
        L_0x00fb:
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010d
        L_0x0100:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a6
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010d:
            r2 = r4
            r1 = r7
            goto L_0x015f
        L_0x0111:
            r2 = r1
            if (r6 != r0) goto L_0x01a6
            long r5 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x015b
        L_0x0121:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r12, r8, r11)
            int r1 = r11.zzro
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x012f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r6 = com.google.android.gms.internal.vision.zzez.zzb(r12, r8, r11)
            long r4 = r11.zzrp
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013f:
            r0 = r6
            goto L_0x015d
        L_0x0141:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x0162
            float r0 = com.google.android.gms.internal.vision.zzez.zzd(r12, r8)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015d
        L_0x0150:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0162
            double r0 = com.google.android.gms.internal.vision.zzez.zzc(r12, r8)
            com.google.android.gms.internal.vision.zzjp.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x015b:
            int r0 = r8 + 8
        L_0x015d:
            r1 = r7
            r2 = r10
        L_0x015f:
            r10 = -1
            goto L_0x0018
        L_0x0162:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ad
        L_0x016a:
            r0 = 27
            if (r3 != r0) goto L_0x01b1
            if (r6 != r10) goto L_0x01a6
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.vision.zzgz r0 = (com.google.android.gms.internal.vision.zzgz) r0
            boolean r3 = r0.zzdo()
            if (r3 != 0) goto L_0x018e
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0185
            r3 = 10
            goto L_0x0187
        L_0x0185:
            int r3 = r3 << 1
        L_0x0187:
            com.google.android.gms.internal.vision.zzgz r0 = r0.zzag(r3)
            r9.putObject(r14, r1, r0)
        L_0x018e:
            r5 = r0
            com.google.android.gms.internal.vision.zzir r0 = r15.zzbm(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.vision.zzez.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x015f
        L_0x01a6:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ad:
            r26 = -1
            goto L_0x0214
        L_0x01b1:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e7
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.zzfb) r14)
            if (r0 != r15) goto L_0x0243
            goto L_0x0232
        L_0x01e7:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0216
            r7 = r30
            if (r7 != r10) goto L_0x0214
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.vision.zzfb) r8)
            if (r0 != r15) goto L_0x0243
            goto L_0x0232
        L_0x0214:
            r2 = r15
            goto L_0x0233
        L_0x0216:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.zzfb) r13)
            if (r0 != r15) goto L_0x0243
        L_0x0232:
            r2 = r0
        L_0x0233:
            com.google.android.gms.internal.vision.zzjm r4 = zzs(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.vision.zzez.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.zzjm) r4, (com.google.android.gms.internal.vision.zzfb) r5)
        L_0x0243:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
            r10 = r26
            goto L_0x0018
        L_0x0257:
            r4 = r13
            if (r0 != r4) goto L_0x025b
            return
        L_0x025b:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x0260:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.zzfb) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzig.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzfb):void");
    }

    private final <UT, UB> UB zza(Object obj, int i11, UB ub2, zzjj<UT, UB> zzjj) {
        zzgy zzbo;
        int i12 = this.zzyu[i11];
        Object zzp = zzjp.zzp(obj, (long) (zzbp(i11) & 1048575));
        if (zzp == null || (zzbo = zzbo(i11)) == null) {
            return ub2;
        }
        return zza(i11, i12, this.zzzk.zzk(zzp), zzbo, ub2, zzjj);
    }

    private final <K, V, UT, UB> UB zza(int i11, int i12, Map<K, V> map, zzgy zzgy, UB ub2, zzjj<UT, UB> zzjj) {
        zzht<?, ?> zzp = this.zzzk.zzp(zzbn(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzgy.zzf(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = zzjj.zzif();
                }
                zzfp zzap = zzfh.zzap(zzhu.zza(zzp, next.getKey(), next.getValue()));
                try {
                    zzhu.zza(zzap.zzew(), zzp, next.getKey(), next.getValue());
                    zzjj.zza(ub2, i12, zzap.zzev());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    private static boolean zza(Object obj, int i11, zzir zzir) {
        return zzir.zzt(zzjp.zzp(obj, (long) (i11 & 1048575)));
    }

    private static void zza(int i11, Object obj, zzkg zzkg) throws IOException {
        if (obj instanceof String) {
            zzkg.zza(i11, (String) obj);
        } else {
            zzkg.zza(i11, (zzfh) obj);
        }
    }

    private final void zza(Object obj, int i11, zzis zzis) throws IOException {
        if (zzbr(i11)) {
            zzjp.zza(obj, (long) (i11 & 1048575), (Object) zzis.zzec());
        } else if (this.zzza) {
            zzjp.zza(obj, (long) (i11 & 1048575), (Object) zzis.readString());
        } else {
            zzjp.zza(obj, (long) (i11 & 1048575), (Object) zzis.zzed());
        }
    }

    private final boolean zza(T t11, int i11, int i12, int i13) {
        if (this.zzzb) {
            return zza(t11, i11);
        }
        return (i12 & i13) != 0;
    }

    private final boolean zza(T t11, int i11) {
        if (this.zzzb) {
            int zzbp = zzbp(i11);
            long j11 = (long) (zzbp & 1048575);
            switch ((zzbp & 267386880) >>> 20) {
                case 0:
                    return zzjp.zzo(t11, j11) != 0.0d;
                case 1:
                    return zzjp.zzn(t11, j11) != 0.0f;
                case 2:
                    return zzjp.zzl(t11, j11) != 0;
                case 3:
                    return zzjp.zzl(t11, j11) != 0;
                case 4:
                    return zzjp.zzk(t11, j11) != 0;
                case 5:
                    return zzjp.zzl(t11, j11) != 0;
                case 6:
                    return zzjp.zzk(t11, j11) != 0;
                case 7:
                    return zzjp.zzm(t11, j11);
                case 8:
                    Object zzp = zzjp.zzp(t11, j11);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzfh) {
                        return !zzfh.zzrx.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzjp.zzp(t11, j11) != null;
                case 10:
                    return !zzfh.zzrx.equals(zzjp.zzp(t11, j11));
                case 11:
                    return zzjp.zzk(t11, j11) != 0;
                case 12:
                    return zzjp.zzk(t11, j11) != 0;
                case 13:
                    return zzjp.zzk(t11, j11) != 0;
                case 14:
                    return zzjp.zzl(t11, j11) != 0;
                case 15:
                    return zzjp.zzk(t11, j11) != 0;
                case 16:
                    return zzjp.zzl(t11, j11) != 0;
                case 17:
                    return zzjp.zzp(t11, j11) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbq = zzbq(i11);
            return (zzjp.zzk(t11, (long) (zzbq & 1048575)) & (1 << (zzbq >>> 20))) != 0;
        }
    }

    private final boolean zza(T t11, int i11, int i12) {
        return zzjp.zzk(t11, (long) (zzbq(i12) & 1048575)) == i11;
    }
}
