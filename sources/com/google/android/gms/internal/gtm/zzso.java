package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzso<T> implements zzsz<T> {
    private static final int[] zzbcw = new int[0];
    private static final Unsafe zzbcx = zztx.zzro();
    private final int[] zzbcy;
    private final Object[] zzbcz;
    private final int zzbda;
    private final int zzbdb;
    private final zzsk zzbdc;
    private final boolean zzbdd;
    private final boolean zzbde;
    private final boolean zzbdf;
    private final boolean zzbdg;
    private final int[] zzbdh;
    private final int zzbdi;
    private final int zzbdj;
    private final zzsr zzbdk;
    private final zzru zzbdl;
    private final zztr<?, ?> zzbdm;
    private final zzqq<?> zzbdn;
    private final zzsf zzbdo;

    private zzso(int[] iArr, Object[] objArr, int i11, int i12, zzsk zzsk, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzsr zzsr, zzru zzru, zztr<?, ?> zztr, zzqq<?> zzqq, zzsf zzsf) {
        boolean z13;
        this.zzbcy = iArr;
        this.zzbcz = objArr;
        this.zzbda = i11;
        this.zzbdb = i12;
        this.zzbde = zzsk instanceof zzrc;
        this.zzbdf = z11;
        if (zzqq == null || !zzqq.zze(zzsk)) {
            z13 = false;
        } else {
            z13 = true;
        }
        this.zzbdd = z13;
        this.zzbdg = false;
        this.zzbdh = iArr2;
        this.zzbdi = i13;
        this.zzbdj = i14;
        this.zzbdk = zzsr;
        this.zzbdl = zzru;
        this.zzbdm = zztr;
        this.zzbdn = zzqq;
        this.zzbdc = zzsk;
        this.zzbdo = zzsf;
    }

    public static <T> zzso<T> zza(Class<T> cls, zzsi zzsi, zzsr zzsr, zzru zzru, zztr<?, ?> zztr, zzqq<?> zzqq, zzsf zzsf) {
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
        zzsx zzsx;
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
        zzsi zzsi2 = zzsi;
        if (zzsi2 instanceof zzsx) {
            zzsx zzsx2 = (zzsx) zzsi2;
            char c19 = 0;
            boolean z12 = zzsx2.zzql() == zzrc.zze.zzbba;
            String zzqt = zzsx2.zzqt();
            int length = zzqt.length();
            char charAt15 = zzqt.charAt(0);
            if (charAt15 >= 55296) {
                char c21 = charAt15 & 8191;
                int i36 = 1;
                int i37 = 13;
                while (true) {
                    i11 = i36 + 1;
                    charAt14 = zzqt.charAt(i36);
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
            char charAt16 = zzqt.charAt(i11);
            if (charAt16 >= 55296) {
                char c22 = charAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i35 = i38 + 1;
                    charAt13 = zzqt.charAt(i38);
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
                iArr = zzbcw;
                c14 = 0;
            } else {
                int i41 = i38 + 1;
                char charAt17 = zzqt.charAt(i38);
                if (charAt17 >= 55296) {
                    char c23 = charAt17 & 8191;
                    int i42 = 13;
                    while (true) {
                        i34 = i41 + 1;
                        charAt12 = zzqt.charAt(i41);
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
                char charAt18 = zzqt.charAt(i41);
                if (charAt18 >= 55296) {
                    char c24 = charAt18 & 8191;
                    int i44 = 13;
                    while (true) {
                        i33 = i43 + 1;
                        charAt11 = zzqt.charAt(i43);
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
                c13 = zzqt.charAt(i43);
                if (c13 >= 55296) {
                    char c25 = c13 & 8191;
                    int i46 = 13;
                    while (true) {
                        i32 = i45 + 1;
                        charAt10 = zzqt.charAt(i45);
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
                char charAt19 = zzqt.charAt(i45);
                if (charAt19 >= 55296) {
                    char c26 = charAt19 & 8191;
                    int i48 = 13;
                    while (true) {
                        i31 = i47 + 1;
                        charAt9 = zzqt.charAt(i47);
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
                c12 = zzqt.charAt(i47);
                if (c12 >= 55296) {
                    char c27 = c12 & 8191;
                    int i50 = 13;
                    while (true) {
                        i29 = i49 + 1;
                        charAt8 = zzqt.charAt(i49);
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
                char charAt20 = zzqt.charAt(i49);
                if (charAt20 >= 55296) {
                    char c28 = charAt20 & 8191;
                    int i52 = 13;
                    while (true) {
                        i28 = i51 + 1;
                        charAt7 = zzqt.charAt(i51);
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
                char charAt21 = zzqt.charAt(i51);
                if (charAt21 >= 55296) {
                    char c29 = charAt21 & 8191;
                    int i54 = i53;
                    int i55 = 13;
                    while (true) {
                        i27 = i54 + 1;
                        charAt6 = zzqt.charAt(i54);
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
                char charAt22 = zzqt.charAt(i25);
                if (charAt22 >= 55296) {
                    char c31 = charAt22 & 8191;
                    int i57 = i56;
                    int i58 = 13;
                    while (true) {
                        i26 = i57 + 1;
                        charAt5 = zzqt.charAt(i57);
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
            Unsafe unsafe = zzbcx;
            Object[] zzqu = zzsx2.zzqu();
            Class<?> cls3 = zzsx2.zzqn().getClass();
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
                int charAt23 = zzqt.charAt(i62);
                int i67 = length;
                if (charAt23 >= 55296) {
                    int i68 = charAt23 & 8191;
                    int i69 = i66;
                    int i70 = 13;
                    while (true) {
                        i24 = i69 + 1;
                        charAt4 = zzqt.charAt(i69);
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
                char charAt24 = zzqt.charAt(i13);
                int i72 = i71;
                if (charAt24 >= 55296) {
                    char c34 = charAt24 & 8191;
                    int i73 = i72;
                    int i74 = 13;
                    while (true) {
                        i23 = i73 + 1;
                        charAt3 = zzqt.charAt(i73);
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
                    char charAt25 = zzqt.charAt(i14);
                    char c38 = 55296;
                    if (charAt25 >= 55296) {
                        char c39 = charAt25 & 8191;
                        int i76 = 13;
                        while (true) {
                            i22 = i75 + 1;
                            charAt2 = zzqt.charAt(i75);
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
                        objArr[((i65 / 3) << 1) + 1] = zzqu[i12];
                        i12++;
                    } else if (i77 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i65 / 3) << 1) + 1] = zzqu[i12];
                        i12++;
                    }
                    int i79 = charAt25 << 1;
                    Object obj = zzqu[i79];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls3, (String) obj);
                        zzqu[i79] = field2;
                    }
                    zzsx = zzsx2;
                    String str2 = zzqt;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i80 = i79 + 1;
                    Object obj2 = zzqu[i80];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls3, (String) obj2);
                        zzqu[i80] = field3;
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
                    zzsx = zzsx2;
                    String str3 = zzqt;
                    int i81 = i12 + 1;
                    Field zza = zza(cls3, (String) zzqu[i12]);
                    if (c35 == 9 || c35 == 17) {
                        c18 = 1;
                        objArr[((i65 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c35 == 27 || c35 == '1') {
                            c18 = 1;
                            i21 = i81 + 1;
                            objArr[((i65 / 3) << 1) + 1] = zzqu[i81];
                        } else if (c35 == 12 || c35 == 30 || c35 == ',') {
                            c18 = 1;
                            if ((charAt15 & 1) == 1) {
                                i21 = i81 + 1;
                                objArr[((i65 / 3) << 1) + 1] = zzqu[i81];
                            }
                        } else {
                            if (c35 == '2') {
                                int i82 = c33 + 1;
                                iArr[c33] = i65;
                                int i83 = (i65 / 3) << 1;
                                int i84 = i81 + 1;
                                objArr[i83] = zzqu[i81];
                                if ((charAt24 & 2048) != 0) {
                                    i81 = i84 + 1;
                                    objArr[i83 + 1] = zzqu[i84];
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
                        Object obj3 = zzqu[i87];
                        i15 = i81;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls3, (String) obj3);
                            zzqu[i87] = field;
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
                zzqt = str;
                i62 = i14;
                cls3 = cls2;
                c14 = c36;
                length = i67;
                c11 = c16;
                z12 = z11;
                c13 = c37;
                i12 = i15;
                zzsx2 = zzsx;
            }
            char c43 = c14;
            boolean z13 = z12;
            return new zzso(iArr2, objArr, c13, c14, zzsx2.zzqn(), z12, false, iArr, c11, i61, zzsr, zzru, zztr, zzqq, zzsf);
        }
        ((zztm) zzsi2).zzql();
        int i90 = zzrc.zze.zzbar;
        throw new NoSuchMethodError();
    }

    private final void zzb(T t11, T t12, int i11) {
        int zzbr = zzbr(i11);
        int i12 = this.zzbcy[i11];
        long j11 = (long) (zzbr & 1048575);
        if (zza(t12, i12, i11)) {
            Object zzp = zztx.zzp(t11, j11);
            Object zzp2 = zztx.zzp(t12, j11);
            if (zzp != null && zzp2 != null) {
                zztx.zza((Object) t11, j11, zzre.zzb(zzp, zzp2));
                zzb(t11, i12, i11);
            } else if (zzp2 != null) {
                zztx.zza((Object) t11, j11, zzp2);
                zzb(t11, i12, i11);
            }
        }
    }

    private final zzsz zzbo(int i11) {
        int i12 = (i11 / 3) << 1;
        zzsz zzsz = (zzsz) this.zzbcz[i12];
        if (zzsz != null) {
            return zzsz;
        }
        zzsz zzi = zzsw.zzqs().zzi((Class) this.zzbcz[i12 + 1]);
        this.zzbcz[i12] = zzi;
        return zzi;
    }

    private final Object zzbp(int i11) {
        return this.zzbcz[(i11 / 3) << 1];
    }

    private final zzrh zzbq(int i11) {
        return (zzrh) this.zzbcz[((i11 / 3) << 1) + 1];
    }

    private final int zzbr(int i11) {
        return this.zzbcy[i11 + 1];
    }

    private final int zzbs(int i11) {
        return this.zzbcy[i11 + 2];
    }

    private static boolean zzbt(int i11) {
        return (i11 & 536870912) != 0;
    }

    private final boolean zzc(T t11, T t12, int i11) {
        return zzb(t11, i11) == zzb(t12, i11);
    }

    private static <E> List<E> zze(Object obj, long j11) {
        return (List) zztx.zzp(obj, j11);
    }

    private static <T> double zzf(T t11, long j11) {
        return ((Double) zztx.zzp(t11, j11)).doubleValue();
    }

    private static <T> float zzg(T t11, long j11) {
        return ((Float) zztx.zzp(t11, j11)).floatValue();
    }

    private static <T> int zzh(T t11, long j11) {
        return ((Integer) zztx.zzp(t11, j11)).intValue();
    }

    private static <T> long zzi(T t11, long j11) {
        return ((Long) zztx.zzp(t11, j11)).longValue();
    }

    private static <T> boolean zzj(T t11, long j11) {
        return ((Boolean) zztx.zzp(t11, j11)).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzm(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzk(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.gtm.zztx.zzl(r10, r6) == com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.gtm.zztx.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.gtm.zztx.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.gtm.zztx.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.gtm.zztx.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.gtm.zztb.zze(com.google.android.gms.internal.gtm.zztx.zzp(r10, r6), com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzbcy
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzbr(r2)
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
            int r4 = r9.zzbs(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.gtm.zztb.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.gtm.zztb.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.gtm.zztb.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.gtm.zztb.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.gtm.zztx.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.gtm.zztx.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.gtm.zztb.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.gtm.zztb.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.gtm.zztx.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.gtm.zztb.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.gtm.zztx.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.gtm.zztx.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.gtm.zztx.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.gtm.zztx.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.gtm.zztx.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.gtm.zztx.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.gtm.zztx.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.gtm.zztx.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.gtm.zztx.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.gtm.zztx.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.gtm.zztx.zzo(r11, r6)
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
            com.google.android.gms.internal.gtm.zztr<?, ?> r0 = r9.zzbdm
            java.lang.Object r0 = r0.zzag(r10)
            com.google.android.gms.internal.gtm.zztr<?, ?> r2 = r9.zzbdm
            java.lang.Object r2 = r2.zzag(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzbdd
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.gtm.zzqq<?> r0 = r9.zzbdn
            com.google.android.gms.internal.gtm.zzqt r10 = r0.zzr(r10)
            com.google.android.gms.internal.gtm.zzqq<?> r0 = r9.zzbdn
            com.google.android.gms.internal.gtm.zzqt r11 = r0.zzr(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.equals(java.lang.Object, java.lang.Object):boolean");
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
            int[] r0 = r8.zzbcy
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzbr(r1)
            int[] r4 = r8.zzbcy
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
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
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
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
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
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzk(r3)
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
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
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
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
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
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zztx.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zztx.zzk(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zztx.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zztx.zzk(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zztx.zzk(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zztx.zzk(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.gtm.zztx.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.gtm.zztx.zzm(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzk(r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zztx.zzk(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zztx.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.gtm.zztx.zzk(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zztx.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.gtm.zztx.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.gtm.zztx.zzn(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.gtm.zztx.zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.gtm.zzre.zzz(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.gtm.zztr<?, ?> r0 = r8.zzbdm
            java.lang.Object r0 = r0.zzag(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzbdd
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.gtm.zzqq<?> r0 = r8.zzbdn
            com.google.android.gms.internal.gtm.zzqt r9 = r0.zzr(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zzbdk.newInstance(this.zzbdc);
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
    public final int zzad(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzbdf
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzbcx
            r12 = r11
            r13 = r12
        L_0x0016:
            int[] r14 = r0.zzbcy
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzbr(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzbcy
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.gtm.zzqw r14 = com.google.android.gms.internal.gtm.zzqw.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.gtm.zzqw r14 = com.google.android.gms.internal.gtm.zzqw.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzbcy
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
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            com.google.android.gms.internal.gtm.zzsk r5 = (com.google.android.gms.internal.gtm.zzsk) r5
            com.google.android.gms.internal.gtm.zzsz r6 = r0.zzbo(r12)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzk(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzm(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzn(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzj(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            com.google.android.gms.internal.gtm.zzps r5 = (com.google.android.gms.internal.gtm.zzps) r5
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r3, (com.google.android.gms.internal.gtm.zzps) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            com.google.android.gms.internal.gtm.zzsz r6 = r0.zzbo(r12)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.gtm.zzsz) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.gtm.zzps
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.gtm.zzps r5 = (com.google.android.gms.internal.gtm.zzps) r5
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r3, (com.google.android.gms.internal.gtm.zzps) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzl(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzi(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.gtm.zzsf r14 = r0.zzbdo
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            java.lang.Object r6 = r0.zzbp(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.gtm.zzsz r6 = r0.zzbo(r12)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzy(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzac(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzae(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzad(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzz(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzab(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzaf(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzad(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzae(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzaa(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzx(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzw(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzad(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.gtm.zztb.zzae(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzbdg
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzbb(r3)
            int r6 = com.google.android.gms.internal.gtm.zzqj.zzbd(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.gtm.zzsz r6 = r0.zzbo(r12)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.gtm.zzsz) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            com.google.android.gms.internal.gtm.zzsk r5 = (com.google.android.gms.internal.gtm.zzsk) r5
            com.google.android.gms.internal.gtm.zzsz r6 = r0.zzbo(r12)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.gtm.zztx.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzk(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzm(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzn(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzj(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            com.google.android.gms.internal.gtm.zzps r5 = (com.google.android.gms.internal.gtm.zzps) r5
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r3, (com.google.android.gms.internal.gtm.zzps) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            com.google.android.gms.internal.gtm.zzsz r6 = r0.zzbo(r12)
            int r3 = com.google.android.gms.internal.gtm.zztb.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.gtm.zzsz) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.gtm.zzps
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.gtm.zzps r5 = (com.google.android.gms.internal.gtm.zzps) r5
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r3, (com.google.android.gms.internal.gtm.zzps) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzl(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.gtm.zztx.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzi(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.gtm.zztx.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.gtm.zztx.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.gtm.zztr<?, ?> r2 = r0.zzbdm
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzbcx
            r3 = -1
            r5 = r11
            r6 = r5
            r12 = r6
        L_0x04f8:
            int[] r13 = r0.zzbcy
            int r13 = r13.length
            if (r5 >= r13) goto L_0x0a32
            int r13 = r0.zzbr(r5)
            int[] r14 = r0.zzbcy
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
            boolean r8 = r0.zzbdg
            if (r8 == 0) goto L_0x053f
            com.google.android.gms.internal.gtm.zzqw r8 = com.google.android.gms.internal.gtm.zzqw.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x053f
            com.google.android.gms.internal.gtm.zzqw r8 = com.google.android.gms.internal.gtm.zzqw.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x053f
            int[] r8 = r0.zzbcy
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
            com.google.android.gms.internal.gtm.zzsk r4 = (com.google.android.gms.internal.gtm.zzsk) r4
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r5)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzc(r15, r4, r8)
            goto L_0x090a
        L_0x0560:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzf((int) r15, (long) r8)
            goto L_0x090a
        L_0x0570:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzk(r15, r4)
            goto L_0x090a
        L_0x0580:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzh((int) r15, (long) r8)
            goto L_0x090a
        L_0x058e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzm(r15, r4)
            goto L_0x0955
        L_0x059b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzn(r15, r4)
            goto L_0x090a
        L_0x05ab:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzj(r15, r4)
            goto L_0x090a
        L_0x05bb:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.gtm.zzps r4 = (com.google.android.gms.internal.gtm.zzps) r4
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r15, (com.google.android.gms.internal.gtm.zzps) r4)
            goto L_0x090a
        L_0x05cd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r5)
            int r4 = com.google.android.gms.internal.gtm.zztb.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
            goto L_0x090a
        L_0x05e1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.gtm.zzps
            if (r8 == 0) goto L_0x05f7
            com.google.android.gms.internal.gtm.zzps r4 = (com.google.android.gms.internal.gtm.zzps) r4
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r15, (com.google.android.gms.internal.gtm.zzps) r4)
            goto L_0x090a
        L_0x05f7:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x05ff:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r15, (boolean) r4)
            goto L_0x0955
        L_0x060c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzl(r15, r4)
            goto L_0x0955
        L_0x0619:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzg((int) r15, (long) r8)
            goto L_0x090a
        L_0x0627:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzi(r15, r4)
            goto L_0x090a
        L_0x0637:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zze((int) r15, (long) r8)
            goto L_0x090a
        L_0x0647:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzd((int) r15, (long) r8)
            goto L_0x090a
        L_0x0657:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r15, (float) r4)
            goto L_0x0955
        L_0x0664:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r15, (double) r8)
            goto L_0x090a
        L_0x0672:
            com.google.android.gms.internal.gtm.zzsf r4 = r0.zzbdo
            java.lang.Object r8 = r2.getObject(r1, r9)
            java.lang.Object r9 = r0.zzbp(r5)
            int r4 = r4.zzb(r15, r8, r9)
            goto L_0x090a
        L_0x0682:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r5)
            int r4 = com.google.android.gms.internal.gtm.zztb.zzd(r15, r4, r8)
            goto L_0x090a
        L_0x0692:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzy(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x06a6
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06a6:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x06b0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzac(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x06c4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06c4:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x06ce:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzae(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x06e2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06e2:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x06ec:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzad(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x0700
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0700:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x070a:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzz(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x071e
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x071e:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x0728:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzab(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x073c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x073c:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x0746:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzaf(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x075a
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x075a:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x0764:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzad(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x0778
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0778:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x0782:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzae(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x0796
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0796:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x07a0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzaa(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x07b4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07b4:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x07be:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzx(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x07d2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07d2:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x07db:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzw(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x07ef
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07ef:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x07f8:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzad(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x080c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x080c:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
            goto L_0x0831
        L_0x0815:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzae(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzbdg
            if (r9 == 0) goto L_0x0829
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0829:
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzbb(r15)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzbd(r4)
        L_0x0831:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0955
        L_0x0835:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.gtm.zztb.zzq(r15, r4, r8)
            goto L_0x08fc
        L_0x0842:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzu(r15, r4, r8)
            goto L_0x08fc
        L_0x084f:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x085c:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x0869:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzr(r15, r4, r8)
            goto L_0x08fc
        L_0x0876:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzt(r15, r4, r8)
            goto L_0x090a
        L_0x0883:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzd(r15, r4)
            goto L_0x090a
        L_0x088f:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r5)
            int r4 = com.google.android.gms.internal.gtm.zztb.zzc((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
            goto L_0x090a
        L_0x089e:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzc(r15, r4)
            goto L_0x090a
        L_0x08a9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.gtm.zztb.zzx(r15, r4, r8)
            goto L_0x08fc
        L_0x08b5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x08c1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x08cd:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzs(r15, r4, r8)
            goto L_0x08fc
        L_0x08d9:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzp(r15, r4, r8)
            goto L_0x08fc
        L_0x08e5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzo(r15, r4, r8)
            goto L_0x08fc
        L_0x08f1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzv(r15, r4, r8)
        L_0x08fc:
            int r6 = r6 + r4
            r4 = 1
            goto L_0x090d
        L_0x08ff:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.gtm.zztb.zzw(r15, r4, r8)
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
            com.google.android.gms.internal.gtm.zzsk r4 = (com.google.android.gms.internal.gtm.zzsk) r4
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r5)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzc(r15, r4, r8)
            goto L_0x090a
        L_0x0927:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            long r8 = r2.getLong(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzf((int) r15, (long) r8)
            goto L_0x090a
        L_0x0934:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzk(r15, r4)
            goto L_0x090a
        L_0x0941:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzh((int) r15, (long) r8)
            goto L_0x090a
        L_0x094c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzm(r15, r4)
        L_0x0955:
            int r6 = r6 + r8
            goto L_0x090b
        L_0x0957:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzn(r15, r4)
            goto L_0x090a
        L_0x0964:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzj(r15, r4)
            goto L_0x090a
        L_0x0971:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.gtm.zzps r4 = (com.google.android.gms.internal.gtm.zzps) r4
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r15, (com.google.android.gms.internal.gtm.zzps) r4)
            goto L_0x090a
        L_0x0980:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r5)
            int r4 = com.google.android.gms.internal.gtm.zztb.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
            goto L_0x090a
        L_0x0992:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.gtm.zzps
            if (r8 == 0) goto L_0x09a6
            com.google.android.gms.internal.gtm.zzps r4 = (com.google.android.gms.internal.gtm.zzps) r4
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r15, (com.google.android.gms.internal.gtm.zzps) r4)
            goto L_0x090a
        L_0x09a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x09ae:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.gtm.zzqj.zzc((int) r15, (boolean) r4)
            int r6 = r6 + r8
            goto L_0x090c
        L_0x09ba:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x090c
            r8 = 0
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzl(r15, r8)
            int r6 = r6 + r9
            goto L_0x090d
        L_0x09c7:
            r4 = 1
            r8 = 0
            r9 = r12 & r18
            r13 = 0
            if (r9 == 0) goto L_0x0a07
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzg((int) r15, (long) r13)
            goto L_0x0a06
        L_0x09d4:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzi(r15, r9)
            goto L_0x0a06
        L_0x09e5:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zze((int) r15, (long) r9)
            goto L_0x0a06
        L_0x09f6:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.gtm.zzqj.zzd((int) r15, (long) r9)
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
            int r10 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r15, (float) r9)
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
            int r15 = com.google.android.gms.internal.gtm.zzqj.zzb((int) r15, (double) r10)
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
            com.google.android.gms.internal.gtm.zztr<?, ?> r2 = r0.zzbdm
            int r2 = zza(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.zzbdd
            if (r2 == 0) goto L_0x0a8c
            com.google.android.gms.internal.gtm.zzqq<?> r2 = r0.zzbdn
            com.google.android.gms.internal.gtm.zzqt r1 = r2.zzr(r1)
            r11 = r8
        L_0x0a45:
            com.google.android.gms.internal.gtm.zztc<FieldDescriptorType, java.lang.Object> r2 = r1.zzaxo
            int r2 = r2.zzra()
            if (r11 >= r2) goto L_0x0a65
            com.google.android.gms.internal.gtm.zztc<FieldDescriptorType, java.lang.Object> r2 = r1.zzaxo
            java.util.Map$Entry r2 = r2.zzbv(r11)
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.gtm.zzqv r3 = (com.google.android.gms.internal.gtm.zzqv) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.gtm.zzqt.zzb((com.google.android.gms.internal.gtm.zzqv<?>) r3, (java.lang.Object) r2)
            int r8 = r8 + r2
            int r11 = r11 + 1
            goto L_0x0a45
        L_0x0a65:
            com.google.android.gms.internal.gtm.zztc<FieldDescriptorType, java.lang.Object> r1 = r1.zzaxo
            java.lang.Iterable r1 = r1.zzrb()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a6f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0a8b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.gtm.zzqv r3 = (com.google.android.gms.internal.gtm.zzqv) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.gtm.zzqt.zzb((com.google.android.gms.internal.gtm.zzqv<?>) r3, (java.lang.Object) r2)
            int r8 = r8 + r2
            goto L_0x0a6f
        L_0x0a8b:
            int r6 = r6 + r8
        L_0x0a8c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.zzad(java.lang.Object):int");
    }

    public final boolean zzae(T t11) {
        int i11;
        boolean z11;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean z12 = true;
            if (i13 < this.zzbdi) {
                int i15 = this.zzbdh[i13];
                int i16 = this.zzbcy[i15];
                int zzbr = zzbr(i15);
                if (!this.zzbdf) {
                    int i17 = this.zzbcy[i15 + 2];
                    int i18 = i17 & 1048575;
                    i11 = 1 << (i17 >>> 20);
                    if (i18 != i12) {
                        i14 = zzbcx.getInt(t11, (long) i18);
                        i12 = i18;
                    }
                } else {
                    i11 = 0;
                }
                if ((268435456 & zzbr) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && !zza(t11, i15, i14, i11)) {
                    return false;
                }
                int i19 = (267386880 & zzbr) >>> 20;
                if (i19 != 9 && i19 != 17) {
                    if (i19 != 27) {
                        if (i19 == 60 || i19 == 68) {
                            if (zza(t11, i16, i15) && !zza((Object) t11, zzbr, zzbo(i15))) {
                                return false;
                            }
                        } else if (i19 != 49) {
                            if (i19 != 50) {
                                continue;
                            } else {
                                Map<?, ?> zzy = this.zzbdo.zzy(zztx.zzp(t11, (long) (zzbr & 1048575)));
                                if (!zzy.isEmpty()) {
                                    if (this.zzbdo.zzac(zzbp(i15)).zzbcr.zzrs() == zzul.MESSAGE) {
                                        Iterator<?> it = zzy.values().iterator();
                                        zzsz<?> zzsz = null;
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            if (zzsz == null) {
                                                zzsz = zzsw.zzqs().zzi(next.getClass());
                                            }
                                            if (!zzsz.zzae(next)) {
                                                z12 = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                                if (!z12) {
                                    return false;
                                }
                            }
                        }
                    }
                    List list = (List) zztx.zzp(t11, (long) (zzbr & 1048575));
                    if (!list.isEmpty()) {
                        zzsz zzbo = zzbo(i15);
                        int i21 = 0;
                        while (true) {
                            if (i21 >= list.size()) {
                                break;
                            } else if (!zzbo.zzae(list.get(i21))) {
                                z12 = false;
                                break;
                            } else {
                                i21++;
                            }
                        }
                    }
                    if (!z12) {
                        return false;
                    }
                } else if (zza(t11, i15, i14, i11) && !zza((Object) t11, zzbr, zzbo(i15))) {
                    return false;
                }
                i13++;
            } else if (!this.zzbdd || this.zzbdn.zzr(t11).isInitialized()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public final void zzd(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.zzbcy.length; i11 += 3) {
            int zzbr = zzbr(i11);
            long j11 = (long) (1048575 & zzbr);
            int i12 = this.zzbcy[i11];
            switch ((zzbr & 267386880) >>> 20) {
                case 0:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzo(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 1:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzn(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 2:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 3:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 4:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zzb((Object) t11, j11, zztx.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 5:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 6:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zzb((Object) t11, j11, zztx.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 7:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzm(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 8:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzp(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 9:
                    zza(t11, t12, i11);
                    break;
                case 10:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzp(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 11:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zzb((Object) t11, j11, zztx.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 12:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zzb((Object) t11, j11, zztx.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 13:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zzb((Object) t11, j11, zztx.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 14:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 15:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zzb((Object) t11, j11, zztx.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 16:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zztx.zza((Object) t11, j11, zztx.zzl(t12, j11));
                        zzc(t11, i11);
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
                    this.zzbdl.zza(t11, t12, j11);
                    break;
                case 50:
                    zztb.zza(this.zzbdo, t11, t12, j11);
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
                        zztx.zza((Object) t11, j11, zztx.zzp(t12, j11));
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
                        zztx.zza((Object) t11, j11, zztx.zzp(t12, j11));
                        zzb(t11, i12, i11);
                        break;
                    }
                case 68:
                    zzb(t11, t12, i11);
                    break;
            }
        }
        if (!this.zzbdf) {
            zztb.zza(this.zzbdm, t11, t12);
            if (this.zzbdd) {
                zztb.zza(this.zzbdn, t11, t12);
            }
        }
    }

    public final void zzt(T t11) {
        int i11;
        int i12 = this.zzbdi;
        while (true) {
            i11 = this.zzbdj;
            if (i12 >= i11) {
                break;
            }
            long zzbr = (long) (zzbr(this.zzbdh[i12]) & 1048575);
            Object zzp = zztx.zzp(t11, zzbr);
            if (zzp != null) {
                zztx.zza((Object) t11, zzbr, this.zzbdo.zzaa(zzp));
            }
            i12++;
        }
        int length = this.zzbdh.length;
        while (i11 < length) {
            this.zzbdl.zzb(t11, (long) this.zzbdh[i11]);
            i11++;
        }
        this.zzbdm.zzt(t11);
        if (this.zzbdd) {
            this.zzbdn.zzt(t11);
        }
    }

    private final void zzc(T t11, int i11) {
        if (!this.zzbdf) {
            int zzbs = zzbs(i11);
            long j11 = (long) (zzbs & 1048575);
            zztx.zzb((Object) t11, j11, zztx.zzk(t11, j11) | (1 << (zzbs >>> 20)));
        }
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
    private final void zzb(T r18, com.google.android.gms.internal.gtm.zzum r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzbdd
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.gtm.zzqq<?> r3 = r0.zzbdn
            com.google.android.gms.internal.gtm.zzqt r3 = r3.zzr(r1)
            com.google.android.gms.internal.gtm.zztc<FieldDescriptorType, java.lang.Object> r5 = r3.zzaxo
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
            int[] r6 = r0.zzbcy
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzbcx
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r6) goto L_0x048a
            int r12 = r0.zzbr(r10)
            int[] r13 = r0.zzbcy
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzbdf
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
            com.google.android.gms.internal.gtm.zzqq<?> r8 = r0.zzbdn
            int r8 = r8.zzb(r5)
            if (r8 > r14) goto L_0x007a
            com.google.android.gms.internal.gtm.zzqq<?> r8 = r0.zzbdn
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
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
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
            r2.zzg(r14, r4)
            goto L_0x0080
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x0080
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x0080
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzp(r14, r4)
            goto L_0x0080
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x0080
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.gtm.zzps r4 = (com.google.android.gms.internal.gtm.zzps) r4
            r2.zza((int) r14, (com.google.android.gms.internal.gtm.zzps) r4)
            goto L_0x0080
        L_0x00f9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r10)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
            goto L_0x0080
        L_0x010c:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzum) r2)
            goto L_0x0080
        L_0x011b:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            boolean r4 = zzj(r1, r12)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x0080
        L_0x012a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzh(r14, r4)
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
            r2.zze(r14, r4)
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
            r2.zzi(r14, r12)
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
            r0.zza((com.google.android.gms.internal.gtm.zzum) r2, (int) r14, (java.lang.Object) r4, (int) r10)
            goto L_0x0080
        L_0x019c:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzsz r12 = r0.zzbo(r10)
            com.google.android.gms.internal.gtm.zztb.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.gtm.zzum) r2, (com.google.android.gms.internal.gtm.zzsz) r12)
            goto L_0x0080
        L_0x01af:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 1
            com.google.android.gms.internal.gtm.zztb.zze(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01bf:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzj(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01cf:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzg(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01df:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzl(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01ef:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzm(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01ff:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzi(r4, r8, r2, r14)
            goto L_0x0080
        L_0x020f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzn(r4, r8, r2, r14)
            goto L_0x0080
        L_0x021f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzk(r4, r8, r2, r14)
            goto L_0x0080
        L_0x022f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzf(r4, r8, r2, r14)
            goto L_0x0080
        L_0x023f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzh(r4, r8, r2, r14)
            goto L_0x0080
        L_0x024f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzd(r4, r8, r2, r14)
            goto L_0x0080
        L_0x025f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzc(r4, r8, r2, r14)
            goto L_0x0080
        L_0x026f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.gtm.zzum) r2, (boolean) r14)
            goto L_0x0080
        L_0x027f:
            r14 = 1
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.gtm.zzum) r2, (boolean) r14)
            goto L_0x0080
        L_0x028f:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
            com.google.android.gms.internal.gtm.zztb.zze(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x029e:
            r14 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzj(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzg(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02bc:
            r14 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzl(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02cb:
            r14 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzm(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02da:
            r14 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzi(r4, r8, r2, r14)
        L_0x02e8:
            r15 = r14
            goto L_0x0486
        L_0x02eb:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzb(r4, r8, r2)
            goto L_0x0080
        L_0x02fa:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzsz r12 = r0.zzbo(r10)
            com.google.android.gms.internal.gtm.zztb.zza((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.gtm.zzum) r2, (com.google.android.gms.internal.gtm.zzsz) r12)
            goto L_0x0080
        L_0x030d:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zza((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.gtm.zzum) r2)
            goto L_0x0080
        L_0x031c:
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.gtm.zztb.zzn(r4, r8, r2, r15)
            goto L_0x0486
        L_0x032c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzk(r4, r8, r2, r15)
            goto L_0x0486
        L_0x033c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzf(r4, r8, r2, r15)
            goto L_0x0486
        L_0x034c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzh(r4, r8, r2, r15)
            goto L_0x0486
        L_0x035c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzd(r4, r8, r2, r15)
            goto L_0x0486
        L_0x036c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzc(r4, r8, r2, r15)
            goto L_0x0486
        L_0x037c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzb((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.gtm.zzum) r2, (boolean) r15)
            goto L_0x0486
        L_0x038c:
            r15 = 0
            int[] r4 = r0.zzbcy
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zza((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.gtm.zzum) r2, (boolean) r15)
            goto L_0x0486
        L_0x039c:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
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
            r2.zzg(r14, r4)
            goto L_0x0486
        L_0x03c7:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x0486
        L_0x03d4:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzp(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x0486
        L_0x03fb:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.gtm.zzps r4 = (com.google.android.gms.internal.gtm.zzps) r4
            r2.zza((int) r14, (com.google.android.gms.internal.gtm.zzps) r4)
            goto L_0x0486
        L_0x040a:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.gtm.zzsz r8 = r0.zzbo(r10)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzsz) r8)
            goto L_0x0486
        L_0x041b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.gtm.zzum) r2)
            goto L_0x0486
        L_0x0427:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            boolean r4 = com.google.android.gms.internal.gtm.zztx.zzm(r1, r12)
            r2.zzb((int) r14, (boolean) r4)
            goto L_0x0486
        L_0x0433:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzh(r14, r4)
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
            r2.zze(r14, r4)
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
            r2.zzi(r14, r12)
            goto L_0x0486
        L_0x046f:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            float r4 = com.google.android.gms.internal.gtm.zztx.zzn(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x0486
        L_0x047b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            double r12 = com.google.android.gms.internal.gtm.zztx.zzo(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x0486:
            int r10 = r10 + 3
            goto L_0x002d
        L_0x048a:
            if (r5 == 0) goto L_0x04a1
            com.google.android.gms.internal.gtm.zzqq<?> r4 = r0.zzbdn
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
            com.google.android.gms.internal.gtm.zztr<?, ?> r3 = r0.zzbdm
            zza(r3, r1, (com.google.android.gms.internal.gtm.zzum) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.zzb(java.lang.Object, com.google.android.gms.internal.gtm.zzum):void");
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
        long zzbr = (long) (zzbr(i11) & 1048575);
        if (zzb(t12, i11)) {
            Object zzp = zztx.zzp(t11, zzbr);
            Object zzp2 = zztx.zzp(t12, zzbr);
            if (zzp != null && zzp2 != null) {
                zztx.zza((Object) t11, zzbr, zzre.zzb(zzp, zzp2));
                zzc(t11, i11);
            } else if (zzp2 != null) {
                zztx.zza((Object) t11, zzbr, zzp2);
                zzc(t11, i11);
            }
        }
    }

    private static <UT, UB> int zza(zztr<UT, UB> zztr, T t11) {
        return zztr.zzad(zztr.zzag(t11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.gtm.zzum r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzol()
            int r1 = com.google.android.gms.internal.gtm.zzrc.zze.zzbbd
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.gtm.zztr<?, ?> r0 = r13.zzbdm
            zza(r0, r14, (com.google.android.gms.internal.gtm.zzum) r15)
            boolean r0 = r13.zzbdd
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.gtm.zzqq<?> r0 = r13.zzbdn
            com.google.android.gms.internal.gtm.zzqt r0 = r0.zzr(r14)
            com.google.android.gms.internal.gtm.zztc<FieldDescriptorType, java.lang.Object> r1 = r0.zzaxo
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
            int[] r7 = r13.zzbcy
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzbr(r7)
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.gtm.zzqq<?> r10 = r13.zzbdn
            int r10 = r10.zzb(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.gtm.zzqq<?> r10 = r13.zzbdn
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
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            com.google.android.gms.internal.gtm.zzsz r10 = r13.zzbo(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.gtm.zzsz) r10)
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
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzp(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            com.google.android.gms.internal.gtm.zzps r8 = (com.google.android.gms.internal.gtm.zzps) r8
            r15.zza((int) r9, (com.google.android.gms.internal.gtm.zzps) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            com.google.android.gms.internal.gtm.zzsz r10 = r13.zzbo(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.gtm.zzsz) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.gtm.zzum) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
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
            r15.zze(r9, r8)
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
            r15.zzi(r9, r10)
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
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            r13.zza((com.google.android.gms.internal.gtm.zzum) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzsz r10 = r13.zzbo(r7)
            com.google.android.gms.internal.gtm.zztb.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.gtm.zzum) r15, (com.google.android.gms.internal.gtm.zzsz) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zzsz r10 = r13.zzbo(r7)
            com.google.android.gms.internal.gtm.zztb.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.gtm.zzum) r15, (com.google.android.gms.internal.gtm.zzsz) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.gtm.zzum) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzbcy
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.gtm.zztb.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            com.google.android.gms.internal.gtm.zzsz r10 = r13.zzbo(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.gtm.zzsz) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r10)
            r15.zzp(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            com.google.android.gms.internal.gtm.zzps r8 = (com.google.android.gms.internal.gtm.zzps) r8
            r15.zza((int) r9, (com.google.android.gms.internal.gtm.zzps) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            com.google.android.gms.internal.gtm.zzsz r10 = r13.zzbo(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.gtm.zzsz) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.gtm.zzum) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.gtm.zztx.zzm(r14, r10)
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.gtm.zztx.zzn(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.gtm.zztx.zzo(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.gtm.zzqq<?> r14 = r13.zzbdn
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
            boolean r0 = r13.zzbdf
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzbdd
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.gtm.zzqq<?> r0 = r13.zzbdn
            com.google.android.gms.internal.gtm.zzqt r0 = r0.zzr(r14)
            com.google.android.gms.internal.gtm.zztc<FieldDescriptorType, java.lang.Object> r1 = r0.zzaxo
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
            int[] r7 = r13.zzbcy
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzbr(r8)
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.gtm.zzqq<?> r11 = r13.zzbdn
            int r11 = r11.zzb(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.gtm.zzqq<?> r11 = r13.zzbdn
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
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            com.google.android.gms.internal.gtm.zzsz r11 = r13.zzbo(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.gtm.zzsz) r11)
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
            r15.zzg(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzp(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            com.google.android.gms.internal.gtm.zzps r9 = (com.google.android.gms.internal.gtm.zzps) r9
            r15.zza((int) r10, (com.google.android.gms.internal.gtm.zzps) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            com.google.android.gms.internal.gtm.zzsz r11 = r13.zzbo(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.gtm.zzsz) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.gtm.zzum) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
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
            r15.zze(r10, r9)
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
            r15.zzi(r10, r11)
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
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            r13.zza((com.google.android.gms.internal.gtm.zzum) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zzsz r11 = r13.zzbo(r8)
            com.google.android.gms.internal.gtm.zztb.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.gtm.zzum) r15, (com.google.android.gms.internal.gtm.zzsz) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zzsz r11 = r13.zzbo(r8)
            com.google.android.gms.internal.gtm.zztb.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.gtm.zzum) r15, (com.google.android.gms.internal.gtm.zzsz) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.gtm.zzum) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzbcy
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.gtm.zztb.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.gtm.zzum) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            com.google.android.gms.internal.gtm.zzsz r11 = r13.zzbo(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.gtm.zzsz) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r11)
            r15.zzp(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            com.google.android.gms.internal.gtm.zzps r9 = (com.google.android.gms.internal.gtm.zzps) r9
            r15.zza((int) r10, (com.google.android.gms.internal.gtm.zzps) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            com.google.android.gms.internal.gtm.zzsz r11 = r13.zzbo(r8)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.gtm.zzsz) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.gtm.zztx.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.gtm.zzum) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.gtm.zztx.zzm(r14, r11)
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.gtm.zztx.zzk(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.gtm.zztx.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.gtm.zztx.zzn(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.gtm.zztx.zzo(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.gtm.zzqq<?> r2 = r13.zzbdn
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
            com.google.android.gms.internal.gtm.zztr<?, ?> r0 = r13.zzbdm
            zza(r0, r14, (com.google.android.gms.internal.gtm.zzum) r15)
            return
        L_0x0a44:
            r13.zzb(r14, (com.google.android.gms.internal.gtm.zzum) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.zza(java.lang.Object, com.google.android.gms.internal.gtm.zzum):void");
    }

    private final boolean zzb(T t11, int i11) {
        if (this.zzbdf) {
            int zzbr = zzbr(i11);
            long j11 = (long) (zzbr & 1048575);
            switch ((zzbr & 267386880) >>> 20) {
                case 0:
                    return zztx.zzo(t11, j11) != 0.0d;
                case 1:
                    return zztx.zzn(t11, j11) != 0.0f;
                case 2:
                    return zztx.zzl(t11, j11) != 0;
                case 3:
                    return zztx.zzl(t11, j11) != 0;
                case 4:
                    return zztx.zzk(t11, j11) != 0;
                case 5:
                    return zztx.zzl(t11, j11) != 0;
                case 6:
                    return zztx.zzk(t11, j11) != 0;
                case 7:
                    return zztx.zzm(t11, j11);
                case 8:
                    Object zzp = zztx.zzp(t11, j11);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzps) {
                        return !zzps.zzavx.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zztx.zzp(t11, j11) != null;
                case 10:
                    return !zzps.zzavx.equals(zztx.zzp(t11, j11));
                case 11:
                    return zztx.zzk(t11, j11) != 0;
                case 12:
                    return zztx.zzk(t11, j11) != 0;
                case 13:
                    return zztx.zzk(t11, j11) != 0;
                case 14:
                    return zztx.zzl(t11, j11) != 0;
                case 15:
                    return zztx.zzk(t11, j11) != 0;
                case 16:
                    return zztx.zzl(t11, j11) != 0;
                case 17:
                    return zztx.zzp(t11, j11) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzbs = zzbs(i11);
            return (zztx.zzk(t11, (long) (zzbs & 1048575)) & (1 << (zzbs >>> 20))) != 0;
        }
    }

    private final void zzb(T t11, int i11, int i12) {
        zztx.zzb((Object) t11, (long) (zzbs(i12) & 1048575), i11);
    }

    private final <K, V> void zza(zzum zzum, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzum.zza(i11, this.zzbdo.zzac(zzbp(i12)), this.zzbdo.zzy(obj));
        }
    }

    private static <UT, UB> void zza(zztr<UT, UB> zztr, T t11, zzum zzum) throws IOException {
        zztr.zza(zztr.zzag(t11), zzum);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r18, com.google.android.gms.internal.gtm.zzsy r19, com.google.android.gms.internal.gtm.zzqp r20) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r0 = r19
            r10 = r20
            r20.getClass()
            com.google.android.gms.internal.gtm.zztr<?, ?> r11 = r1.zzbdm
            com.google.android.gms.internal.gtm.zzqq<?> r12 = r1.zzbdn
            r13 = 0
            r3 = r13
            r14 = r3
        L_0x0012:
            int r4 = r19.zzog()     // Catch:{ all -> 0x05d8 }
            int r5 = r1.zzbda     // Catch:{ all -> 0x05d8 }
            r6 = -1
            if (r4 < r5) goto L_0x003f
            int r5 = r1.zzbdb     // Catch:{ all -> 0x05d8 }
            if (r4 > r5) goto L_0x003f
            int[] r5 = r1.zzbcy     // Catch:{ all -> 0x05d8 }
            int r5 = r5.length     // Catch:{ all -> 0x05d8 }
            int r5 = r5 / 3
            int r5 = r5 + -1
            r7 = 0
        L_0x0027:
            if (r7 > r5) goto L_0x003f
            int r8 = r5 + r7
            int r8 = r8 >>> 1
            int r9 = r8 * 3
            int[] r15 = r1.zzbcy     // Catch:{ all -> 0x05d8 }
            r15 = r15[r9]     // Catch:{ all -> 0x05d8 }
            if (r4 != r15) goto L_0x0037
            r6 = r9
            goto L_0x003f
        L_0x0037:
            if (r4 >= r15) goto L_0x003c
            int r5 = r8 + -1
            goto L_0x0027
        L_0x003c:
            int r7 = r8 + 1
            goto L_0x0027
        L_0x003f:
            if (r6 >= 0) goto L_0x00a8
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L_0x005d
            int r0 = r1.zzbdi
        L_0x0048:
            int r3 = r1.zzbdj
            if (r0 >= r3) goto L_0x0057
            int[] r3 = r1.zzbdh
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x0048
        L_0x0057:
            if (r14 == 0) goto L_0x005c
            r11.zzg(r2, r14)
        L_0x005c:
            return
        L_0x005d:
            boolean r5 = r1.zzbdd     // Catch:{ all -> 0x05d8 }
            if (r5 != 0) goto L_0x0063
            r5 = r13
            goto L_0x006a
        L_0x0063:
            com.google.android.gms.internal.gtm.zzsk r5 = r1.zzbdc     // Catch:{ all -> 0x05d8 }
            java.lang.Object r4 = r12.zza(r10, r5, r4)     // Catch:{ all -> 0x05d8 }
            r5 = r4
        L_0x006a:
            if (r5 == 0) goto L_0x0081
            if (r3 != 0) goto L_0x0072
            com.google.android.gms.internal.gtm.zzqt r3 = r12.zzs(r2)     // Catch:{ all -> 0x05d8 }
        L_0x0072:
            r15 = r3
            r3 = r12
            r4 = r19
            r6 = r20
            r7 = r15
            r8 = r14
            r9 = r11
            java.lang.Object r14 = r3.zza(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x05d8 }
            r3 = r15
            goto L_0x0012
        L_0x0081:
            r11.zza(r0)     // Catch:{ all -> 0x05d8 }
            if (r14 != 0) goto L_0x008b
            java.lang.Object r4 = r11.zzah(r2)     // Catch:{ all -> 0x05d8 }
            r14 = r4
        L_0x008b:
            boolean r4 = r11.zza(r14, (com.google.android.gms.internal.gtm.zzsy) r0)     // Catch:{ all -> 0x05d8 }
            if (r4 != 0) goto L_0x0012
            int r0 = r1.zzbdi
        L_0x0093:
            int r3 = r1.zzbdj
            if (r0 >= r3) goto L_0x00a2
            int[] r3 = r1.zzbdh
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x0093
        L_0x00a2:
            if (r14 == 0) goto L_0x00a7
            r11.zzg(r2, r14)
        L_0x00a7:
            return
        L_0x00a8:
            int r5 = r1.zzbr(r6)     // Catch:{ all -> 0x05d8 }
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r7 = r7 & r5
            int r7 = r7 >>> 20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            switch(r7) {
                case 0: goto L_0x0584;
                case 1: goto L_0x0575;
                case 2: goto L_0x0566;
                case 3: goto L_0x0557;
                case 4: goto L_0x0548;
                case 5: goto L_0x0539;
                case 6: goto L_0x052a;
                case 7: goto L_0x051b;
                case 8: goto L_0x0513;
                case 9: goto L_0x04e2;
                case 10: goto L_0x04d3;
                case 11: goto L_0x04c4;
                case 12: goto L_0x04a2;
                case 13: goto L_0x0493;
                case 14: goto L_0x0484;
                case 15: goto L_0x0475;
                case 16: goto L_0x0466;
                case 17: goto L_0x0435;
                case 18: goto L_0x0428;
                case 19: goto L_0x041b;
                case 20: goto L_0x040e;
                case 21: goto L_0x0401;
                case 22: goto L_0x03f4;
                case 23: goto L_0x03e7;
                case 24: goto L_0x03da;
                case 25: goto L_0x03cd;
                case 26: goto L_0x03ad;
                case 27: goto L_0x039c;
                case 28: goto L_0x038f;
                case 29: goto L_0x0382;
                case 30: goto L_0x036d;
                case 31: goto L_0x0360;
                case 32: goto L_0x0353;
                case 33: goto L_0x0346;
                case 34: goto L_0x0339;
                case 35: goto L_0x032c;
                case 36: goto L_0x031f;
                case 37: goto L_0x0312;
                case 38: goto L_0x0305;
                case 39: goto L_0x02f8;
                case 40: goto L_0x02eb;
                case 41: goto L_0x02de;
                case 42: goto L_0x02d1;
                case 43: goto L_0x02c4;
                case 44: goto L_0x02af;
                case 45: goto L_0x02a2;
                case 46: goto L_0x0295;
                case 47: goto L_0x0288;
                case 48: goto L_0x027b;
                case 49: goto L_0x0269;
                case 50: goto L_0x0227;
                case 51: goto L_0x0215;
                case 52: goto L_0x0203;
                case 53: goto L_0x01f1;
                case 54: goto L_0x01df;
                case 55: goto L_0x01cd;
                case 56: goto L_0x01bb;
                case 57: goto L_0x01a9;
                case 58: goto L_0x0197;
                case 59: goto L_0x018f;
                case 60: goto L_0x015e;
                case 61: goto L_0x0150;
                case 62: goto L_0x013e;
                case 63: goto L_0x0119;
                case 64: goto L_0x0107;
                case 65: goto L_0x00f5;
                case 66: goto L_0x00e3;
                case 67: goto L_0x00d1;
                case 68: goto L_0x00bf;
                default: goto L_0x00b7;
            }
        L_0x00b7:
            if (r14 != 0) goto L_0x0594
            java.lang.Object r4 = r11.zzri()     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0593
        L_0x00bf:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r5 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r5 = r0.zzb(r5, r10)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x00d1:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            long r15 = r19.zznw()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x00e3:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            int r5 = r19.zznv()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x00f5:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            long r15 = r19.zznu()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0107:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            int r5 = r19.zznt()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0119:
            int r7 = r19.zzns()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzrh r9 = r1.zzbq(r6)     // Catch:{ zzrl -> 0x05b1 }
            if (r9 == 0) goto L_0x0130
            boolean r9 = r9.zzb(r7)     // Catch:{ zzrl -> 0x05b1 }
            if (r9 == 0) goto L_0x012a
            goto L_0x0130
        L_0x012a:
            java.lang.Object r14 = com.google.android.gms.internal.gtm.zztb.zza((int) r4, (int) r7, r14, r11)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0130:
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r8, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x013e:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            int r5 = r19.zznr()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0150:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzps r5 = r19.zznq()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x015e:
            boolean r7 = r1.zza(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            if (r7 == 0) goto L_0x017a
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zztx.zzp(r2, r7)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r9 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r9 = r0.zza(r9, r10)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r5 = com.google.android.gms.internal.gtm.zzre.zzb(r5, r9)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x018a
        L_0x017a:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r5 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r5 = r0.zza(r5, r10)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
        L_0x018a:
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x018f:
            r1.zza((java.lang.Object) r2, (int) r5, (com.google.android.gms.internal.gtm.zzsy) r0)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0197:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            boolean r5 = r19.zzno()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x01a9:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            int r5 = r19.zznn()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x01bb:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            long r15 = r19.zznm()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x01cd:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            int r5 = r19.zznl()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x01df:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            long r15 = r19.zznj()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x01f1:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            long r15 = r19.zznk()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0203:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            float r5 = r19.readFloat()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0215:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            double r15 = r19.readDouble()     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Double r5 = java.lang.Double.valueOf(r15)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0227:
            java.lang.Object r4 = r1.zzbp(r6)     // Catch:{ zzrl -> 0x05b1 }
            int r5 = r1.zzbr(r6)     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r7 = com.google.android.gms.internal.gtm.zztx.zzp(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            if (r7 != 0) goto L_0x0241
            com.google.android.gms.internal.gtm.zzsf r7 = r1.zzbdo     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r7 = r7.zzab(r4)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0258
        L_0x0241:
            com.google.android.gms.internal.gtm.zzsf r8 = r1.zzbdo     // Catch:{ zzrl -> 0x05b1 }
            boolean r8 = r8.zzz(r7)     // Catch:{ zzrl -> 0x05b1 }
            if (r8 == 0) goto L_0x0258
            com.google.android.gms.internal.gtm.zzsf r8 = r1.zzbdo     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r8 = r8.zzab(r4)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsf r9 = r1.zzbdo     // Catch:{ zzrl -> 0x05b1 }
            r9.zzc(r8, r7)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r8)     // Catch:{ zzrl -> 0x05b1 }
            r7 = r8
        L_0x0258:
            com.google.android.gms.internal.gtm.zzsf r5 = r1.zzbdo     // Catch:{ zzrl -> 0x05b1 }
            java.util.Map r5 = r5.zzx(r7)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsf r6 = r1.zzbdo     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsd r4 = r6.zzac(r4)     // Catch:{ zzrl -> 0x05b1 }
            r0.zza(r5, r4, (com.google.android.gms.internal.gtm.zzqp) r10)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0269:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r6 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzru r7 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r7.zza(r2, r4)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzb(r4, r6, r10)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x027b:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzv(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0288:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzu(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0295:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzt(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02a2:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzs(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02af:
            com.google.android.gms.internal.gtm.zzru r7 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r5 = r7.zza(r2, r8)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzr(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzrh r6 = r1.zzbq(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r14 = com.google.android.gms.internal.gtm.zztb.zza(r4, r5, r6, r14, r11)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02c4:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzq(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02d1:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzn(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02de:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzm(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02eb:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzl(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x02f8:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzk(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0305:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzi(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0312:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzj(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x031f:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzh(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x032c:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzg(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0339:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzv(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0346:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzu(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0353:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzt(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0360:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzs(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x036d:
            com.google.android.gms.internal.gtm.zzru r7 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r5 = r7.zza(r2, r8)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzr(r5)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzrh r6 = r1.zzbq(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r14 = com.google.android.gms.internal.gtm.zztb.zza(r4, r5, r6, r14, r11)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0382:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzq(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x038f:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzp(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x039c:
            com.google.android.gms.internal.gtm.zzsz r4 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzru r7 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r5 = r7.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zza(r5, r4, (com.google.android.gms.internal.gtm.zzqp) r10)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x03ad:
            boolean r4 = zzbt(r5)     // Catch:{ zzrl -> 0x05b1 }
            if (r4 == 0) goto L_0x03c0
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzo(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x03c0:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.readStringList(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x03cd:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzn(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x03da:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzm(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x03e7:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzl(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x03f4:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzk(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0401:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzi(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x040e:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzj(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x041b:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzh(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0428:
            com.google.android.gms.internal.gtm.zzru r4 = r1.zzbdl     // Catch:{ zzrl -> 0x05b1 }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzrl -> 0x05b1 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzrl -> 0x05b1 }
            r0.zzg(r4)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0435:
            boolean r4 = r1.zzb(r2, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            if (r4 == 0) goto L_0x0453
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r7 = com.google.android.gms.internal.gtm.zztx.zzp(r2, r4)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r6 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r6 = r0.zzb(r6, r10)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzre.zzb(r7, r6)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0453:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r7 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r7 = r0.zzb(r7, r10)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0466:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            long r7 = r19.zznw()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0475:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            int r7 = r19.zznv()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zzb((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0484:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            long r7 = r19.zznu()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0493:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            int r7 = r19.zznt()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zzb((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x04a2:
            int r7 = r19.zzns()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzrh r9 = r1.zzbq(r6)     // Catch:{ zzrl -> 0x05b1 }
            if (r9 == 0) goto L_0x04b9
            boolean r9 = r9.zzb(r7)     // Catch:{ zzrl -> 0x05b1 }
            if (r9 == 0) goto L_0x04b3
            goto L_0x04b9
        L_0x04b3:
            java.lang.Object r14 = com.google.android.gms.internal.gtm.zztb.zza((int) r4, (int) r7, r14, r11)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x04b9:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zzb((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x04c4:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            int r7 = r19.zznr()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zzb((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x04d3:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzps r7 = r19.zznq()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x04e2:
            boolean r4 = r1.zzb(r2, (int) r6)     // Catch:{ zzrl -> 0x05b1 }
            if (r4 == 0) goto L_0x0500
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r7 = com.google.android.gms.internal.gtm.zztx.zzp(r2, r4)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r6 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r6 = r0.zza(r6, r10)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r6 = com.google.android.gms.internal.gtm.zzre.zzb(r7, r6)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0500:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zzsz r7 = r1.zzbo(r6)     // Catch:{ zzrl -> 0x05b1 }
            java.lang.Object r7 = r0.zza(r7, r10)     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0513:
            r1.zza((java.lang.Object) r2, (int) r5, (com.google.android.gms.internal.gtm.zzsy) r0)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x051b:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            boolean r7 = r19.zzno()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (boolean) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x052a:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            int r7 = r19.zznn()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zzb((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0539:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            long r7 = r19.zznm()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0548:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            int r7 = r19.zznl()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zzb((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0557:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            long r7 = r19.zznj()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0566:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            long r7 = r19.zznk()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0575:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            float r7 = r19.readFloat()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (float) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0584:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzrl -> 0x05b1 }
            double r7 = r19.readDouble()     // Catch:{ zzrl -> 0x05b1 }
            com.google.android.gms.internal.gtm.zztx.zza((java.lang.Object) r2, (long) r4, (double) r7)     // Catch:{ zzrl -> 0x05b1 }
            r1.zzc(r2, r6)     // Catch:{ zzrl -> 0x05b1 }
            goto L_0x0012
        L_0x0593:
            r14 = r4
        L_0x0594:
            boolean r4 = r11.zza(r14, (com.google.android.gms.internal.gtm.zzsy) r0)     // Catch:{ zzrl -> 0x05b1 }
            if (r4 != 0) goto L_0x0012
            int r0 = r1.zzbdi
        L_0x059c:
            int r3 = r1.zzbdj
            if (r0 >= r3) goto L_0x05ab
            int[] r3 = r1.zzbdh
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x059c
        L_0x05ab:
            if (r14 == 0) goto L_0x05b0
            r11.zzg(r2, r14)
        L_0x05b0:
            return
        L_0x05b1:
            r11.zza(r0)     // Catch:{ all -> 0x05d8 }
            if (r14 != 0) goto L_0x05bb
            java.lang.Object r4 = r11.zzah(r2)     // Catch:{ all -> 0x05d8 }
            r14 = r4
        L_0x05bb:
            boolean r4 = r11.zza(r14, (com.google.android.gms.internal.gtm.zzsy) r0)     // Catch:{ all -> 0x05d8 }
            if (r4 != 0) goto L_0x0012
            int r0 = r1.zzbdi
        L_0x05c3:
            int r3 = r1.zzbdj
            if (r0 >= r3) goto L_0x05d2
            int[] r3 = r1.zzbdh
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x05c3
        L_0x05d2:
            if (r14 == 0) goto L_0x05d7
            r11.zzg(r2, r14)
        L_0x05d7:
            return
        L_0x05d8:
            r0 = move-exception
            int r3 = r1.zzbdi
        L_0x05db:
            int r4 = r1.zzbdj
            if (r3 >= r4) goto L_0x05ea
            int[] r4 = r1.zzbdh
            r4 = r4[r3]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r4, r14, r11)
            int r3 = r3 + 1
            goto L_0x05db
        L_0x05ea:
            if (r14 == 0) goto L_0x05ef
            r11.zzg(r2, r14)
        L_0x05ef:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzso.zza(java.lang.Object, com.google.android.gms.internal.gtm.zzsy, com.google.android.gms.internal.gtm.zzqp):void");
    }

    private final <UT, UB> UB zza(Object obj, int i11, UB ub2, zztr<UT, UB> zztr) {
        zzrh zzbq;
        int i12 = this.zzbcy[i11];
        Object zzp = zztx.zzp(obj, (long) (zzbr(i11) & 1048575));
        if (zzp == null || (zzbq = zzbq(i11)) == null) {
            return ub2;
        }
        return zza(i11, i12, this.zzbdo.zzx(zzp), zzbq, ub2, zztr);
    }

    private final <K, V, UT, UB> UB zza(int i11, int i12, Map<K, V> map, zzrh zzrh, UB ub2, zztr<UT, UB> zztr) {
        zzsd<?, ?> zzac = this.zzbdo.zzac(zzbp(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzrh.zzb(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = zztr.zzri();
                }
                zzqa zzam = zzps.zzam(zzsc.zza(zzac, next.getKey(), next.getValue()));
                try {
                    zzsc.zza(zzam.zznh(), zzac, next.getKey(), next.getValue());
                    zztr.zza(ub2, i12, zzam.zzng());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    private static boolean zza(Object obj, int i11, zzsz zzsz) {
        return zzsz.zzae(zztx.zzp(obj, (long) (i11 & 1048575)));
    }

    private static void zza(int i11, Object obj, zzum zzum) throws IOException {
        if (obj instanceof String) {
            zzum.zza(i11, (String) obj);
        } else {
            zzum.zza(i11, (zzps) obj);
        }
    }

    private final void zza(Object obj, int i11, zzsy zzsy) throws IOException {
        if (zzbt(i11)) {
            zztx.zza(obj, (long) (i11 & 1048575), (Object) zzsy.zznp());
        } else if (this.zzbde) {
            zztx.zza(obj, (long) (i11 & 1048575), (Object) zzsy.readString());
        } else {
            zztx.zza(obj, (long) (i11 & 1048575), (Object) zzsy.zznq());
        }
    }

    private final boolean zza(T t11, int i11, int i12, int i13) {
        if (this.zzbdf) {
            return zzb(t11, i11);
        }
        return (i12 & i13) != 0;
    }

    private final boolean zza(T t11, int i11, int i12) {
        return zztx.zzk(t11, (long) (zzbs(i12) & 1048575)) == i11;
    }
}
