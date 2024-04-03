package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzco<T> implements zzda<T> {
    private static final int[] zzkq = new int[0];
    private static final Unsafe zzkr = zzdy.zzdn();
    private final int[] zzks;
    private final Object[] zzkt;
    private final int zzku;
    private final int zzkv;
    private final zzck zzkw;
    private final boolean zzkx;
    private final boolean zzky;
    private final boolean zzkz;
    private final boolean zzla;
    private final int[] zzlb;
    private final int zzlc;
    private final int zzld;
    private final zzcs zzle;
    private final zzbu zzlf;
    private final zzds<?, ?> zzlg;
    private final zzar<?> zzlh;
    private final zzcd zzli;

    private zzco(int[] iArr, Object[] objArr, int i11, int i12, zzck zzck, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzcs zzcs, zzbu zzbu, zzds<?, ?> zzds, zzar<?> zzar, zzcd zzcd) {
        boolean z13;
        this.zzks = iArr;
        this.zzkt = objArr;
        this.zzku = i11;
        this.zzkv = i12;
        this.zzky = zzck instanceof zzbc;
        this.zzkz = z11;
        if (zzar == null || !zzar.zzf(zzck)) {
            z13 = false;
        } else {
            z13 = true;
        }
        this.zzkx = z13;
        this.zzla = false;
        this.zzlb = iArr2;
        this.zzlc = i13;
        this.zzld = i14;
        this.zzle = zzcs;
        this.zzlf = zzbu;
        this.zzlg = zzds;
        this.zzlh = zzar;
        this.zzkw = zzck;
        this.zzli = zzcd;
    }

    private final zzda zzaf(int i11) {
        int i12 = (i11 / 3) << 1;
        zzda zzda = (zzda) this.zzkt[i12];
        if (zzda != null) {
            return zzda;
        }
        zzda zzf = zzcv.zzcq().zzf((Class) this.zzkt[i12 + 1]);
        this.zzkt[i12] = zzf;
        return zzf;
    }

    private final Object zzag(int i11) {
        return this.zzkt[(i11 / 3) << 1];
    }

    private final zzbf zzah(int i11) {
        return (zzbf) this.zzkt[((i11 / 3) << 1) + 1];
    }

    private final int zzai(int i11) {
        return this.zzks[i11 + 1];
    }

    private final int zzaj(int i11) {
        return this.zzks[i11 + 2];
    }

    private final int zzak(int i11) {
        if (i11 < this.zzku || i11 > this.zzkv) {
            return -1;
        }
        return zzr(i11, 0);
    }

    public static <T> zzco<T> zzb(Class<T> cls, zzci zzci, zzcs zzcs, zzbu zzbu, zzds<?, ?> zzds, zzar<?> zzar, zzcd zzcd) {
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
        zzcx zzcx;
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
        zzci zzci2 = zzci;
        if (zzci2 instanceof zzcx) {
            zzcx zzcx2 = (zzcx) zzci2;
            char c19 = 0;
            boolean z12 = zzcx2.zzcj() == zzbc.zze.zziu;
            String zzcr = zzcx2.zzcr();
            int length = zzcr.length();
            char charAt15 = zzcr.charAt(0);
            if (charAt15 >= 55296) {
                char c21 = charAt15 & 8191;
                int i36 = 1;
                int i37 = 13;
                while (true) {
                    i11 = i36 + 1;
                    charAt14 = zzcr.charAt(i36);
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
            char charAt16 = zzcr.charAt(i11);
            if (charAt16 >= 55296) {
                char c22 = charAt16 & 8191;
                int i39 = 13;
                while (true) {
                    i35 = i38 + 1;
                    charAt13 = zzcr.charAt(i38);
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
                iArr = zzkq;
                c14 = 0;
            } else {
                int i41 = i38 + 1;
                char charAt17 = zzcr.charAt(i38);
                if (charAt17 >= 55296) {
                    char c23 = charAt17 & 8191;
                    int i42 = 13;
                    while (true) {
                        i34 = i41 + 1;
                        charAt12 = zzcr.charAt(i41);
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
                char charAt18 = zzcr.charAt(i41);
                if (charAt18 >= 55296) {
                    char c24 = charAt18 & 8191;
                    int i44 = 13;
                    while (true) {
                        i33 = i43 + 1;
                        charAt11 = zzcr.charAt(i43);
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
                c13 = zzcr.charAt(i43);
                if (c13 >= 55296) {
                    char c25 = c13 & 8191;
                    int i46 = 13;
                    while (true) {
                        i32 = i45 + 1;
                        charAt10 = zzcr.charAt(i45);
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
                char charAt19 = zzcr.charAt(i45);
                if (charAt19 >= 55296) {
                    char c26 = charAt19 & 8191;
                    int i48 = 13;
                    while (true) {
                        i31 = i47 + 1;
                        charAt9 = zzcr.charAt(i47);
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
                c12 = zzcr.charAt(i47);
                if (c12 >= 55296) {
                    char c27 = c12 & 8191;
                    int i50 = 13;
                    while (true) {
                        i29 = i49 + 1;
                        charAt8 = zzcr.charAt(i49);
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
                char charAt20 = zzcr.charAt(i49);
                if (charAt20 >= 55296) {
                    char c28 = charAt20 & 8191;
                    int i52 = 13;
                    while (true) {
                        i28 = i51 + 1;
                        charAt7 = zzcr.charAt(i51);
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
                char charAt21 = zzcr.charAt(i51);
                if (charAt21 >= 55296) {
                    char c29 = charAt21 & 8191;
                    int i54 = i53;
                    int i55 = 13;
                    while (true) {
                        i27 = i54 + 1;
                        charAt6 = zzcr.charAt(i54);
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
                char charAt22 = zzcr.charAt(i25);
                if (charAt22 >= 55296) {
                    char c31 = charAt22 & 8191;
                    int i57 = i56;
                    int i58 = 13;
                    while (true) {
                        i26 = i57 + 1;
                        charAt5 = zzcr.charAt(i57);
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
            Unsafe unsafe = zzkr;
            Object[] zzcs2 = zzcx2.zzcs();
            Class<?> cls3 = zzcx2.zzcl().getClass();
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
                int charAt23 = zzcr.charAt(i62);
                int i67 = length;
                if (charAt23 >= 55296) {
                    int i68 = charAt23 & 8191;
                    int i69 = i66;
                    int i70 = 13;
                    while (true) {
                        i24 = i69 + 1;
                        charAt4 = zzcr.charAt(i69);
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
                char charAt24 = zzcr.charAt(i13);
                int i72 = i71;
                if (charAt24 >= 55296) {
                    char c34 = charAt24 & 8191;
                    int i73 = i72;
                    int i74 = 13;
                    while (true) {
                        i23 = i73 + 1;
                        charAt3 = zzcr.charAt(i73);
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
                    char charAt25 = zzcr.charAt(i14);
                    char c38 = 55296;
                    if (charAt25 >= 55296) {
                        char c39 = charAt25 & 8191;
                        int i76 = 13;
                        while (true) {
                            i22 = i75 + 1;
                            charAt2 = zzcr.charAt(i75);
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
                        objArr[((i65 / 3) << 1) + 1] = zzcs2[i12];
                        i12++;
                    } else if (i77 == 12 && (charAt15 & 1) == 1) {
                        objArr[((i65 / 3) << 1) + 1] = zzcs2[i12];
                        i12++;
                    }
                    int i79 = charAt25 << 1;
                    Object obj = zzcs2[i79];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zzb(cls3, (String) obj);
                        zzcs2[i79] = field2;
                    }
                    zzcx = zzcx2;
                    String str2 = zzcr;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i80 = i79 + 1;
                    Object obj2 = zzcs2[i80];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zzb(cls3, (String) obj2);
                        zzcs2[i80] = field3;
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
                    zzcx = zzcx2;
                    String str3 = zzcr;
                    int i81 = i12 + 1;
                    Field zzb = zzb(cls3, (String) zzcs2[i12]);
                    if (c35 == 9 || c35 == 17) {
                        c18 = 1;
                        objArr[((i65 / 3) << 1) + 1] = zzb.getType();
                    } else {
                        if (c35 == 27 || c35 == '1') {
                            c18 = 1;
                            i21 = i81 + 1;
                            objArr[((i65 / 3) << 1) + 1] = zzcs2[i81];
                        } else if (c35 == 12 || c35 == 30 || c35 == ',') {
                            c18 = 1;
                            if ((charAt15 & 1) == 1) {
                                i21 = i81 + 1;
                                objArr[((i65 / 3) << 1) + 1] = zzcs2[i81];
                            }
                        } else {
                            if (c35 == '2') {
                                int i82 = c33 + 1;
                                iArr[c33] = i65;
                                int i83 = (i65 / 3) << 1;
                                int i84 = i81 + 1;
                                objArr[i83] = zzcs2[i81];
                                if ((charAt24 & 2048) != 0) {
                                    i81 = i84 + 1;
                                    objArr[i83 + 1] = zzcs2[i84];
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
                    i18 = (int) unsafe.objectFieldOffset(zzb);
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
                        Object obj3 = zzcs2[i87];
                        i15 = i81;
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zzb(cls3, (String) obj3);
                            zzcs2[i87] = field;
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
                zzcr = str;
                i62 = i14;
                cls3 = cls2;
                c14 = c36;
                length = i67;
                c11 = c16;
                z12 = z11;
                c13 = c37;
                i12 = i15;
                zzcx2 = zzcx;
            }
            char c43 = c14;
            boolean z13 = z12;
            return new zzco(iArr2, objArr, c13, c14, zzcx2.zzcl(), z12, false, iArr, c11, i61, zzcs, zzbu, zzds, zzar, zzcd);
        }
        ((zzdl) zzci2).zzcj();
        int i90 = zzbc.zze.zzil;
        throw new NoSuchMethodError();
    }

    private final void zzc(T t11, T t12, int i11) {
        int zzai = zzai(i11);
        int i12 = this.zzks[i11];
        long j11 = (long) (zzai & 1048575);
        if (zzb(t12, i12, i11)) {
            Object zzp = zzdy.zzp(t11, j11);
            Object zzp2 = zzdy.zzp(t12, j11);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb((Object) t11, j11, zzbd.zzb(zzp, zzp2));
                zzc(t11, i12, i11);
            } else if (zzp2 != null) {
                zzdy.zzb((Object) t11, j11, zzp2);
                zzc(t11, i12, i11);
            }
        }
    }

    private static List<?> zze(Object obj, long j11) {
        return (List) zzdy.zzp(obj, j11);
    }

    private static <T> double zzf(T t11, long j11) {
        return ((Double) zzdy.zzp(t11, j11)).doubleValue();
    }

    private static <T> float zzg(T t11, long j11) {
        return ((Float) zzdy.zzp(t11, j11)).floatValue();
    }

    private static <T> int zzh(T t11, long j11) {
        return ((Integer) zzdy.zzp(t11, j11)).intValue();
    }

    private static <T> long zzi(T t11, long j11) {
        return ((Long) zzdy.zzp(t11, j11)).longValue();
    }

    private static <T> boolean zzj(T t11, long j11) {
        return ((Boolean) zzdy.zzp(t11, j11)).booleanValue();
    }

    private static zzdr zzo(Object obj) {
        zzbc zzbc = (zzbc) obj;
        zzdr zzdr = zzbc.zzih;
        if (zzdr != zzdr.zzdh()) {
            return zzdr;
        }
        zzdr zzdi = zzdr.zzdi();
        zzbc.zzih = zzdi;
        return zzdi;
    }

    private final int zzq(int i11, int i12) {
        if (i11 < this.zzku || i11 > this.zzkv) {
            return -1;
        }
        return zzr(i11, i12);
    }

    private final int zzr(int i11, int i12) {
        int length = (this.zzks.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int i15 = this.zzks[i14];
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
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzm(r10, r6) == com.google.android.gms.internal.places.zzdy.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzk(r10, r6) == com.google.android.gms.internal.places.zzdy.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.places.zzdy.zzl(r10, r6) == com.google.android.gms.internal.places.zzdy.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.places.zzdy.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.places.zzdy.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.places.zzdc.zze(com.google.android.gms.internal.places.zzdy.zzp(r10, r6), com.google.android.gms.internal.places.zzdy.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzks
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzai(r2)
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
            int r4 = r9.zzaj(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.places.zzdy.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.places.zzdc.zze((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.places.zzdy.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.places.zzdy.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.places.zzdy.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.places.zzdy.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.places.zzdy.zzl(r11, r6)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.places.zzdy.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.places.zzdy.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzd(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.places.zzdy.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.places.zzdy.zzo(r11, r6)
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
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r9.zzlg
            java.lang.Object r0 = r0.zzr(r10)
            com.google.android.gms.internal.places.zzds<?, ?> r2 = r9.zzlg
            java.lang.Object r2 = r2.zzr(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzkx
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.places.zzar<?> r0 = r9.zzlh
            com.google.android.gms.internal.places.zzav r10 = r0.zzb((java.lang.Object) r10)
            com.google.android.gms.internal.places.zzar<?> r0 = r9.zzlh
            com.google.android.gms.internal.places.zzav r11 = r0.zzb((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.equals(java.lang.Object, java.lang.Object):boolean");
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
            int[] r0 = r8.zzks
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzai(r1)
            int[] r4 = r8.zzks
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
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzj(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zze((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzh(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzg(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zzb(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzf(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdy.zzp(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.places.zzdy.zzm(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zze((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.places.zzdy.zzk(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.places.zzdy.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.places.zzdy.zzn(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.places.zzdy.zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.places.zzbd.zzl(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r8.zzlg
            java.lang.Object r0 = r0.zzr(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzkx
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.places.zzar<?> r0 = r8.zzlh
            com.google.android.gms.internal.places.zzav r9 = r0.zzb((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zzle.newInstance(this.zzkw);
    }

    public final void zzd(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.zzks.length; i11 += 3) {
            int zzai = zzai(i11);
            long j11 = (long) (1048575 & zzai);
            int i12 = this.zzks[i11];
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzo(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 1:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzn(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 2:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 3:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 4:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 5:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 6:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 7:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzm(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 8:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzp(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 9:
                    zzb(t11, t12, i11);
                    break;
                case 10:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzp(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 11:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 12:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 13:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 14:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 15:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzk(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 16:
                    if (!zzb(t12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzl(t12, j11));
                        zzc(t11, i11);
                        break;
                    }
                case 17:
                    zzb(t11, t12, i11);
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
                    this.zzlf.zzb(t11, t12, j11);
                    break;
                case 50:
                    zzdc.zzb(this.zzli, t11, t12, j11);
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
                    if (!zzb(t12, i12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzp(t12, j11));
                        zzc(t11, i12, i11);
                        break;
                    }
                case 60:
                    zzc(t11, t12, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzb(t12, i12, i11)) {
                        break;
                    } else {
                        zzdy.zzb((Object) t11, j11, zzdy.zzp(t12, j11));
                        zzc(t11, i12, i11);
                        break;
                    }
                case 68:
                    zzc(t11, t12, i11);
                    break;
            }
        }
        if (!this.zzkz) {
            zzdc.zzb(this.zzlg, t11, t12);
            if (this.zzkx) {
                zzdc.zzb(this.zzlh, t11, t12);
            }
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
    public final int zzn(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzkz
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzkr
            r12 = r11
            r13 = r12
        L_0x0016:
            int[] r14 = r0.zzks
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzai(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzks
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.places.zzaw r14 = com.google.android.gms.internal.places.zzaw.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.places.zzaw r14 = com.google.android.gms.internal.places.zzaw.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzks
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
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzck r5 = (com.google.android.gms.internal.places.zzck) r5
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzaj.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzg((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzj(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzl(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzm(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (int) r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.places.zzda) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.places.zzw
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzk(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zzb(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzi(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zzb(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.places.zzcd r14 = r0.zzli
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            java.lang.Object r6 = r0.zzag(r12)
            int r3 = r14.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zze(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzg((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzn(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzf((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.places.zzdc.zzm(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzla
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.places.zzaj.zzr(r3)
            int r6 = com.google.android.gms.internal.places.zzaj.zzt(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zze((int) r3, (java.util.List<com.google.android.gms.internal.places.zzw>) r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zze(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.places.zzda) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzy(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzdc.zzx(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzck r5 = (com.google.android.gms.internal.places.zzck) r5
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzaj.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.places.zzdy.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzg((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzj(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzl(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzm(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzi((int) r3, (int) r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            com.google.android.gms.internal.places.zzda r6 = r0.zzaf(r12)
            int r3 = com.google.android.gms.internal.places.zzdc.zzd((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.places.zzda) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.places.zzdy.zzp(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.places.zzw
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.places.zzw r5 = (com.google.android.gms.internal.places.zzw) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (com.google.android.gms.internal.places.zzw) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzd((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzk(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.places.zzdy.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.places.zzdy.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zzb(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.places.zzdy.zzl(r1, r5)
            int r3 = com.google.android.gms.internal.places.zzaj.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zzb(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.places.zzaj.zzc((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.places.zzds<?, ?> r2 = r0.zzlg
            int r1 = zzb(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzkr
            r3 = -1
            r5 = r11
            r6 = r5
            r12 = r6
        L_0x04f8:
            int[] r13 = r0.zzks
            int r13 = r13.length
            if (r5 >= r13) goto L_0x0a32
            int r13 = r0.zzai(r5)
            int[] r14 = r0.zzks
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
            boolean r8 = r0.zzla
            if (r8 == 0) goto L_0x053f
            com.google.android.gms.internal.places.zzaw r8 = com.google.android.gms.internal.places.zzaw.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r4 < r8) goto L_0x053f
            com.google.android.gms.internal.places.zzaw r8 = com.google.android.gms.internal.places.zzaw.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r4 > r8) goto L_0x053f
            int[] r8 = r0.zzks
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
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.places.zzck r4 = (com.google.android.gms.internal.places.zzck) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r5)
            int r4 = com.google.android.gms.internal.places.zzaj.zzd(r15, r4, r8)
            goto L_0x090a
        L_0x0560:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzg((int) r15, (long) r8)
            goto L_0x090a
        L_0x0570:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzj(r15, r4)
            goto L_0x090a
        L_0x0580:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (long) r8)
            goto L_0x090a
        L_0x058e:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzl(r15, r4)
            goto L_0x0955
        L_0x059b:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzm(r15, r4)
            goto L_0x090a
        L_0x05ab:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (int) r4)
            goto L_0x090a
        L_0x05bb:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x090a
        L_0x05cd:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r5)
            int r4 = com.google.android.gms.internal.places.zzdc.zzd((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x090a
        L_0x05e1:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.places.zzw
            if (r8 == 0) goto L_0x05f7
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x090a
        L_0x05f7:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x05ff:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (boolean) r4)
            goto L_0x0955
        L_0x060c:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzk(r15, r4)
            goto L_0x0955
        L_0x0619:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (long) r8)
            goto L_0x090a
        L_0x0627:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            int r4 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (int) r4)
            goto L_0x090a
        L_0x0637:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzf((int) r15, (long) r8)
            goto L_0x090a
        L_0x0647:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            long r8 = zzi(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zze((int) r15, (long) r8)
            goto L_0x090a
        L_0x0657:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (float) r4)
            goto L_0x0955
        L_0x0664:
            boolean r4 = r0.zzb(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (double) r8)
            goto L_0x090a
        L_0x0672:
            com.google.android.gms.internal.places.zzcd r4 = r0.zzli
            java.lang.Object r8 = r2.getObject(r1, r9)
            java.lang.Object r9 = r0.zzag(r5)
            int r4 = r4.zzc(r15, r8, r9)
            goto L_0x090a
        L_0x0682:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r5)
            int r4 = com.google.android.gms.internal.places.zzdc.zze(r15, r4, r8)
            goto L_0x090a
        L_0x0692:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzg((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x06a6
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06a6:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x06b0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzk(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x06c4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06c4:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x06ce:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzm(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x06e2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x06e2:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x06ec:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzl(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x0700
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0700:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x070a:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzh(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x071e
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x071e:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x0728:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzj(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x073c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x073c:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x0746:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzn(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x075a
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x075a:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x0764:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzl(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x0778
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0778:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x0782:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzm(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x0796
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0796:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x07a0:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzi(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x07b4
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07b4:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x07be:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzf((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x07d2
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07d2:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x07db:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zze(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x07ef
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x07ef:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x07f8:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzl(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x080c
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x080c:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
            goto L_0x0831
        L_0x0815:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzm(r4)
            if (r4 <= 0) goto L_0x090b
            boolean r9 = r0.zzla
            if (r9 == 0) goto L_0x0829
            long r8 = (long) r8
            r2.putInt(r1, r8, r4)
        L_0x0829:
            int r8 = com.google.android.gms.internal.places.zzaj.zzr(r15)
            int r9 = com.google.android.gms.internal.places.zzaj.zzt(r4)
        L_0x0831:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0955
        L_0x0835:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzdc.zzr(r15, r4, r8)
            goto L_0x08fc
        L_0x0842:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzv(r15, r4, r8)
            goto L_0x08fc
        L_0x084f:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzx(r15, r4, r8)
            goto L_0x08fc
        L_0x085c:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x0869:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzs(r15, r4, r8)
            goto L_0x08fc
        L_0x0876:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzu(r15, r4, r8)
            goto L_0x090a
        L_0x0883:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zze((int) r15, (java.util.List<com.google.android.gms.internal.places.zzw>) r4)
            goto L_0x090a
        L_0x088f:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r5)
            int r4 = com.google.android.gms.internal.places.zzdc.zzd((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x090a
        L_0x089e:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzd(r15, r4)
            goto L_0x090a
        L_0x08a9:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzdc.zzy(r15, r4, r8)
            goto L_0x08fc
        L_0x08b5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzw(r15, r4, r8)
            goto L_0x08fc
        L_0x08c1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzx(r15, r4, r8)
            goto L_0x08fc
        L_0x08cd:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzt(r15, r4, r8)
            goto L_0x08fc
        L_0x08d9:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzq(r15, r4, r8)
            goto L_0x08fc
        L_0x08e5:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzp(r15, r4, r8)
            goto L_0x08fc
        L_0x08f1:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzw(r15, r4, r8)
        L_0x08fc:
            int r6 = r6 + r4
            r4 = 1
            goto L_0x090d
        L_0x08ff:
            r8 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.places.zzdc.zzx(r15, r4, r8)
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
            com.google.android.gms.internal.places.zzck r4 = (com.google.android.gms.internal.places.zzck) r4
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r5)
            int r4 = com.google.android.gms.internal.places.zzaj.zzd(r15, r4, r8)
            goto L_0x090a
        L_0x0927:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            long r8 = r2.getLong(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzg((int) r15, (long) r8)
            goto L_0x090a
        L_0x0934:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzj(r15, r4)
            goto L_0x090a
        L_0x0941:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r8 = 0
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (long) r8)
            goto L_0x090a
        L_0x094c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 0
            int r8 = com.google.android.gms.internal.places.zzaj.zzl(r15, r4)
        L_0x0955:
            int r6 = r6 + r8
            goto L_0x090b
        L_0x0957:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzm(r15, r4)
            goto L_0x090a
        L_0x0964:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.places.zzaj.zzi((int) r15, (int) r4)
            goto L_0x090a
        L_0x0971:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x090a
        L_0x0980:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r5)
            int r4 = com.google.android.gms.internal.places.zzdc.zzd((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x090a
        L_0x0992:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r8 = r4 instanceof com.google.android.gms.internal.places.zzw
            if (r8 == 0) goto L_0x09a6
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x090a
        L_0x09a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (java.lang.String) r4)
            goto L_0x090a
        L_0x09ae:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090b
            r4 = 1
            int r8 = com.google.android.gms.internal.places.zzaj.zzd((int) r15, (boolean) r4)
            int r6 = r6 + r8
            goto L_0x090c
        L_0x09ba:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x090c
            r8 = 0
            int r9 = com.google.android.gms.internal.places.zzaj.zzk(r15, r8)
            int r6 = r6 + r9
            goto L_0x090d
        L_0x09c7:
            r4 = 1
            r8 = 0
            r9 = r12 & r18
            r13 = 0
            if (r9 == 0) goto L_0x0a07
            int r9 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (long) r13)
            goto L_0x0a06
        L_0x09d4:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.places.zzaj.zzh((int) r15, (int) r9)
            goto L_0x0a06
        L_0x09e5:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.places.zzaj.zzf((int) r15, (long) r9)
            goto L_0x0a06
        L_0x09f6:
            r4 = 1
            r8 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a07
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.places.zzaj.zze((int) r15, (long) r9)
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
            int r10 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (float) r9)
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
            int r15 = com.google.android.gms.internal.places.zzaj.zzc((int) r15, (double) r10)
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
            com.google.android.gms.internal.places.zzds<?, ?> r2 = r0.zzlg
            int r2 = zzb(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.zzkx
            if (r2 == 0) goto L_0x0a8c
            com.google.android.gms.internal.places.zzar<?> r2 = r0.zzlh
            com.google.android.gms.internal.places.zzav r1 = r2.zzb((java.lang.Object) r1)
            r11 = r8
        L_0x0a45:
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r2 = r1.zzfj
            int r2 = r2.zzcu()
            if (r11 >= r2) goto L_0x0a65
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r2 = r1.zzfj
            java.util.Map$Entry r2 = r2.zzam(r11)
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.places.zzax r3 = (com.google.android.gms.internal.places.zzax) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.places.zzav.zzc((com.google.android.gms.internal.places.zzax<?>) r3, (java.lang.Object) r2)
            int r8 = r8 + r2
            int r11 = r11 + 1
            goto L_0x0a45
        L_0x0a65:
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r1 = r1.zzfj
            java.lang.Iterable r1 = r1.zzcv()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a6f:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0a8b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.google.android.gms.internal.places.zzax r3 = (com.google.android.gms.internal.places.zzax) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.gms.internal.places.zzav.zzc((com.google.android.gms.internal.places.zzax<?>) r3, (java.lang.Object) r2)
            int r8 = r8 + r2
            goto L_0x0a6f
        L_0x0a8b:
            int r6 = r6 + r8
        L_0x0a8c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzn(java.lang.Object):int");
    }

    public final boolean zzp(T t11) {
        int i11;
        boolean z11;
        int i12 = -1;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            boolean z12 = true;
            if (i13 < this.zzlc) {
                int i15 = this.zzlb[i13];
                int i16 = this.zzks[i15];
                int zzai = zzai(i15);
                if (!this.zzkz) {
                    int i17 = this.zzks[i15 + 2];
                    int i18 = i17 & 1048575;
                    i11 = 1 << (i17 >>> 20);
                    if (i18 != i12) {
                        i14 = zzkr.getInt(t11, (long) i18);
                        i12 = i18;
                    }
                } else {
                    i11 = 0;
                }
                if ((268435456 & zzai) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && !zzb(t11, i15, i14, i11)) {
                    return false;
                }
                int i19 = (267386880 & zzai) >>> 20;
                if (i19 != 9 && i19 != 17) {
                    if (i19 != 27) {
                        if (i19 == 60 || i19 == 68) {
                            if (zzb(t11, i16, i15) && !zzb((Object) t11, zzai, zzaf(i15))) {
                                return false;
                            }
                        } else if (i19 != 49) {
                            if (i19 != 50) {
                                continue;
                            } else {
                                Map<?, ?> zzh = this.zzli.zzh(zzdy.zzp(t11, (long) (zzai & 1048575)));
                                if (!zzh.isEmpty()) {
                                    if (this.zzli.zzl(zzag(i15)).zzkl.zzdr() == zzem.MESSAGE) {
                                        Iterator<?> it = zzh.values().iterator();
                                        zzda<?> zzda = null;
                                        while (true) {
                                            if (!it.hasNext()) {
                                                break;
                                            }
                                            Object next = it.next();
                                            if (zzda == null) {
                                                zzda = zzcv.zzcq().zzf(next.getClass());
                                            }
                                            if (!zzda.zzp(next)) {
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
                    List list = (List) zzdy.zzp(t11, (long) (zzai & 1048575));
                    if (!list.isEmpty()) {
                        zzda zzaf = zzaf(i15);
                        int i21 = 0;
                        while (true) {
                            if (i21 >= list.size()) {
                                break;
                            } else if (!zzaf.zzp(list.get(i21))) {
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
                } else if (zzb(t11, i15, i14, i11) && !zzb((Object) t11, zzai, zzaf(i15))) {
                    return false;
                }
                i13++;
            } else if (!this.zzkx || this.zzlh.zzb((Object) t11).isInitialized()) {
                return true;
            } else {
                return false;
            }
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
    private final void zzc(T r18, com.google.android.gms.internal.places.zzel r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzkx
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.places.zzar<?> r3 = r0.zzlh
            com.google.android.gms.internal.places.zzav r3 = r3.zzb((java.lang.Object) r1)
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r5 = r3.zzfj
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
            int[] r6 = r0.zzks
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzkr
            r9 = -1
            r10 = 0
            r11 = 0
        L_0x002d:
            if (r10 >= r6) goto L_0x048a
            int r12 = r0.zzai(r10)
            int[] r13 = r0.zzks
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzkz
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
            com.google.android.gms.internal.places.zzar<?> r8 = r0.zzlh
            int r8 = r8.zzb((java.util.Map.Entry<?, ?>) r5)
            if (r8 > r14) goto L_0x007a
            com.google.android.gms.internal.places.zzar<?> r8 = r0.zzlh
            r8.zzb(r2, r5)
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
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r10)
            r2.zzc((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0080
        L_0x0095:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x0080
        L_0x00a3:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x0080
        L_0x00b1:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzk(r14, r12)
            goto L_0x0080
        L_0x00bf:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x0080
        L_0x00cd:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x0080
        L_0x00db:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zze(r14, r4)
            goto L_0x0080
        L_0x00e9:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            r2.zzb((int) r14, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x0080
        L_0x00f9:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0080
        L_0x010c:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            java.lang.Object r4 = r7.getObject(r1, r12)
            zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzel) r2)
            goto L_0x0080
        L_0x011b:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            boolean r4 = zzj(r1, r12)
            r2.zzc((int) r14, (boolean) r4)
            goto L_0x0080
        L_0x012a:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x0080
        L_0x0139:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzd((int) r14, (long) r12)
            goto L_0x0080
        L_0x0148:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            int r4 = zzh(r1, r12)
            r2.zzd((int) r14, (int) r4)
            goto L_0x0080
        L_0x0157:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x0080
        L_0x0166:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            long r12 = zzi(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x0080
        L_0x0175:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            float r4 = zzg(r1, r12)
            r2.zzb((int) r14, (float) r4)
            goto L_0x0080
        L_0x0184:
            boolean r4 = r0.zzb(r1, (int) r14, (int) r10)
            if (r4 == 0) goto L_0x0080
            double r12 = zzf(r1, r12)
            r2.zzb((int) r14, (double) r12)
            goto L_0x0080
        L_0x0193:
            java.lang.Object r4 = r7.getObject(r1, r12)
            r0.zzb((com.google.android.gms.internal.places.zzel) r2, (int) r14, (java.lang.Object) r4, (int) r10)
            goto L_0x0080
        L_0x019c:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzda r12 = r0.zzaf(r10)
            com.google.android.gms.internal.places.zzdc.zzc((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.places.zzel) r2, (com.google.android.gms.internal.places.zzda) r12)
            goto L_0x0080
        L_0x01af:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 1
            com.google.android.gms.internal.places.zzdc.zzf(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01bf:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzk(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01cf:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzh(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01df:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzm(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01ef:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzn(r4, r8, r2, r14)
            goto L_0x0080
        L_0x01ff:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzj(r4, r8, r2, r14)
            goto L_0x0080
        L_0x020f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzo(r4, r8, r2, r14)
            goto L_0x0080
        L_0x021f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzl(r4, r8, r2, r14)
            goto L_0x0080
        L_0x022f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzg(r4, r8, r2, r14)
            goto L_0x0080
        L_0x023f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzi(r4, r8, r2, r14)
            goto L_0x0080
        L_0x024f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zze(r4, r8, r2, r14)
            goto L_0x0080
        L_0x025f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzd(r4, r8, r2, r14)
            goto L_0x0080
        L_0x026f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.places.zzel) r2, (boolean) r14)
            goto L_0x0080
        L_0x027f:
            r14 = 1
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.places.zzel) r2, (boolean) r14)
            goto L_0x0080
        L_0x028f:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r14 = 0
            com.google.android.gms.internal.places.zzdc.zzf(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x029e:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzk(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzh(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02bc:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzm(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02cb:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzn(r4, r8, r2, r14)
            goto L_0x02e8
        L_0x02da:
            r14 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzj(r4, r8, r2, r14)
        L_0x02e8:
            r15 = r14
            goto L_0x0486
        L_0x02eb:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc(r4, r8, r2)
            goto L_0x0080
        L_0x02fa:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzda r12 = r0.zzaf(r10)
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<?>) r8, (com.google.android.gms.internal.places.zzel) r2, (com.google.android.gms.internal.places.zzda) r12)
            goto L_0x0080
        L_0x030d:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.places.zzel) r2)
            goto L_0x0080
        L_0x031c:
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.places.zzdc.zzo(r4, r8, r2, r15)
            goto L_0x0486
        L_0x032c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzl(r4, r8, r2, r15)
            goto L_0x0486
        L_0x033c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzg(r4, r8, r2, r15)
            goto L_0x0486
        L_0x034c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzi(r4, r8, r2, r15)
            goto L_0x0486
        L_0x035c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zze(r4, r8, r2, r15)
            goto L_0x0486
        L_0x036c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzd(r4, r8, r2, r15)
            goto L_0x0486
        L_0x037c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc((int) r4, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.places.zzel) r2, (boolean) r15)
            goto L_0x0486
        L_0x038c:
            r15 = 0
            int[] r4 = r0.zzks
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r12)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r4, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.places.zzel) r2, (boolean) r15)
            goto L_0x0486
        L_0x039c:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r10)
            r2.zzc((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0486
        L_0x03ad:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x0486
        L_0x03ba:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x0486
        L_0x03c7:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzk(r14, r12)
            goto L_0x0486
        L_0x03d4:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzn(r14, r4)
            goto L_0x0486
        L_0x03e1:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzo(r14, r4)
            goto L_0x0486
        L_0x03ee:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zze(r14, r4)
            goto L_0x0486
        L_0x03fb:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.places.zzw r4 = (com.google.android.gms.internal.places.zzw) r4
            r2.zzb((int) r14, (com.google.android.gms.internal.places.zzw) r4)
            goto L_0x0486
        L_0x040a:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            com.google.android.gms.internal.places.zzda r8 = r0.zzaf(r10)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzda) r8)
            goto L_0x0486
        L_0x041b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            java.lang.Object r4 = r7.getObject(r1, r12)
            zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.places.zzel) r2)
            goto L_0x0486
        L_0x0427:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            boolean r4 = com.google.android.gms.internal.places.zzdy.zzm(r1, r12)
            r2.zzc((int) r14, (boolean) r4)
            goto L_0x0486
        L_0x0433:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzg(r14, r4)
            goto L_0x0486
        L_0x043f:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzd((int) r14, (long) r12)
            goto L_0x0486
        L_0x044b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            int r4 = r7.getInt(r1, r12)
            r2.zzd((int) r14, (int) r4)
            goto L_0x0486
        L_0x0457:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x0486
        L_0x0463:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            long r12 = r7.getLong(r1, r12)
            r2.zzj(r14, r12)
            goto L_0x0486
        L_0x046f:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            float r4 = com.google.android.gms.internal.places.zzdy.zzn(r1, r12)
            r2.zzb((int) r14, (float) r4)
            goto L_0x0486
        L_0x047b:
            r15 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x0486
            double r12 = com.google.android.gms.internal.places.zzdy.zzo(r1, r12)
            r2.zzb((int) r14, (double) r12)
        L_0x0486:
            int r10 = r10 + 3
            goto L_0x002d
        L_0x048a:
            if (r5 == 0) goto L_0x04a1
            com.google.android.gms.internal.places.zzar<?> r4 = r0.zzlh
            r4.zzb(r2, r5)
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
            com.google.android.gms.internal.places.zzds<?, ?> r3 = r0.zzlg
            zzb(r3, r1, (com.google.android.gms.internal.places.zzel) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzc(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    public final void zzd(T t11) {
        int i11;
        int i12 = this.zzlc;
        while (true) {
            i11 = this.zzld;
            if (i12 >= i11) {
                break;
            }
            long zzai = (long) (zzai(this.zzlb[i12]) & 1048575);
            Object zzp = zzdy.zzp(t11, zzai);
            if (zzp != null) {
                zzdy.zzb((Object) t11, zzai, this.zzli.zzj(zzp));
            }
            i12++;
        }
        int length = this.zzlb.length;
        while (i11 < length) {
            this.zzlf.zzb(t11, (long) this.zzlb[i11]);
            i11++;
        }
        this.zzlg.zzd(t11);
        if (this.zzkx) {
            this.zzlh.zzd(t11);
        }
    }

    private final boolean zzd(T t11, T t12, int i11) {
        return zzb(t11, i11) == zzb(t12, i11);
    }

    private static Field zzb(Class<?> cls, String str) {
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

    private final void zzb(T t11, T t12, int i11) {
        long zzai = (long) (zzai(i11) & 1048575);
        if (zzb(t12, i11)) {
            Object zzp = zzdy.zzp(t11, zzai);
            Object zzp2 = zzdy.zzp(t12, zzai);
            if (zzp != null && zzp2 != null) {
                zzdy.zzb((Object) t11, zzai, zzbd.zzb(zzp, zzp2));
                zzc(t11, i11);
            } else if (zzp2 != null) {
                zzdy.zzb((Object) t11, zzai, zzp2);
                zzc(t11, i11);
            }
        }
    }

    private static <UT, UB> int zzb(zzds<UT, UB> zzds, T t11) {
        return zzds.zzn(zzds.zzr(t11));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(T r14, com.google.android.gms.internal.places.zzel r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzam()
            int r1 = com.google.android.gms.internal.places.zzbc.zze.zzix
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r13.zzlg
            zzb(r0, r14, (com.google.android.gms.internal.places.zzel) r15)
            boolean r0 = r13.zzkx
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.places.zzar<?> r0 = r13.zzlh
            com.google.android.gms.internal.places.zzav r0 = r0.zzb((java.lang.Object) r14)
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r1 = r0.zzfj
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
            int[] r7 = r13.zzks
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzai(r7)
            int[] r9 = r13.zzks
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.places.zzar<?> r10 = r13.zzlh
            int r10 = r10.zzb((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.places.zzar<?> r10 = r13.zzlh
            r10.zzb(r15, r1)
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
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzc((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzk(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzw r8 = (com.google.android.gms.internal.places.zzw) r8
            r15.zzb((int) r9, (com.google.android.gms.internal.places.zzw) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzc((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zzb((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zzb(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zzb((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            r13.zzb((com.google.android.gms.internal.places.zzel) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            com.google.android.gms.internal.places.zzdc.zzc((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzo(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzo(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzc((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzks
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.places.zzdc.zzb((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzc((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzk(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzn(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzw r8 = (com.google.android.gms.internal.places.zzw) r8
            r15.zzb((int) r9, (com.google.android.gms.internal.places.zzw) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            com.google.android.gms.internal.places.zzda r10 = r13.zzaf(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzda) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.places.zzdy.zzp(r14, r10)
            zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.places.zzdy.zzm(r14, r10)
            r15.zzc((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.places.zzdy.zzk(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.places.zzdy.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.places.zzdy.zzn(r14, r10)
            r15.zzb((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zzb(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.places.zzdy.zzo(r14, r10)
            r15.zzb((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.places.zzar<?> r14 = r13.zzlh
            r14.zzb(r15, r1)
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
            boolean r0 = r13.zzkz
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzkx
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.places.zzar<?> r0 = r13.zzlh
            com.google.android.gms.internal.places.zzav r0 = r0.zzb((java.lang.Object) r14)
            com.google.android.gms.internal.places.zzdb<FieldDescriptorType, java.lang.Object> r1 = r0.zzfj
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
            int[] r7 = r13.zzks
            int r7 = r7.length
            r8 = r5
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzai(r8)
            int[] r10 = r13.zzks
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.places.zzar<?> r11 = r13.zzlh
            int r11 = r11.zzb((java.util.Map.Entry<?, ?>) r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.places.zzar<?> r11 = r13.zzlh
            r11.zzb(r15, r1)
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
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r8)
            r15.zzc((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzk(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzw r9 = (com.google.android.gms.internal.places.zzw) r9
            r15.zzb((int) r10, (com.google.android.gms.internal.places.zzw) r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzc((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zzb((int) r10, (float) r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zzb(r14, (int) r10, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zzb((int) r10, (double) r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            r13.zzb((com.google.android.gms.internal.places.zzel) r15, (int) r10, (java.lang.Object) r9, (int) r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r8)
            com.google.android.gms.internal.places.zzdc.zzc((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzo(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r8)
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.places.zzel) r15, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzo(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzc((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzks
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.places.zzdc.zzb((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.places.zzel) r15, (boolean) r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r8)
            r15.zzc((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzk(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzn(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzw r9 = (com.google.android.gms.internal.places.zzw) r9
            r15.zzb((int) r10, (com.google.android.gms.internal.places.zzw) r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            com.google.android.gms.internal.places.zzda r11 = r13.zzaf(r8)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzda) r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.places.zzdy.zzp(r14, r11)
            zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.places.zzel) r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.places.zzdy.zzm(r14, r11)
            r15.zzc((int) r10, (boolean) r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.places.zzdy.zzk(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.places.zzdy.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.places.zzdy.zzn(r14, r11)
            r15.zzb((int) r10, (float) r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zzb(r14, (int) r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.places.zzdy.zzo(r14, r11)
            r15.zzb((int) r10, (double) r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.places.zzar<?> r2 = r13.zzlh
            r2.zzb(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r13.zzlg
            zzb(r0, r14, (com.google.android.gms.internal.places.zzel) r15)
            return
        L_0x0a44:
            r13.zzc(r14, (com.google.android.gms.internal.places.zzel) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, com.google.android.gms.internal.places.zzel):void");
    }

    private final void zzc(T t11, int i11) {
        if (!this.zzkz) {
            int zzaj = zzaj(i11);
            long j11 = (long) (zzaj & 1048575);
            zzdy.zzb((Object) t11, j11, zzdy.zzk(t11, j11) | (1 << (zzaj >>> 20)));
        }
    }

    private final void zzc(T t11, int i11, int i12) {
        zzdy.zzb((Object) t11, (long) (zzaj(i12) & 1048575), i11);
    }

    private final <K, V> void zzb(zzel zzel, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzel.zzb(i11, this.zzli.zzl(zzag(i12)), this.zzli.zzh(obj));
        }
    }

    private static <UT, UB> void zzb(zzds<UT, UB> zzds, T t11, zzel zzel) throws IOException {
        zzds.zzb(zzds.zzr(t11), zzel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(byte[] r1, int r2, int r3, com.google.android.gms.internal.places.zzef r4, java.lang.Class<?> r5, com.google.android.gms.internal.places.zzr r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.places.zzcn.zzfi
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
            int r1 = com.google.android.gms.internal.places.zzs.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r1, r2, r6)
            long r2 = r6.zzea
            long r2 = com.google.android.gms.internal.places.zzai.zzb(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r1, r2, r6)
            int r2 = r6.zzdz
            int r2 = com.google.android.gms.internal.places.zzai.zzm(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.places.zzcv r4 = com.google.android.gms.internal.places.zzcv.zzcq()
            com.google.android.gms.internal.places.zzda r4 = r4.zzf(r5)
            int r1 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzr) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r1, r2, r6)
            long r2 = r6.zzea
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r1, r2, r6)
            int r2 = r6.zzdz
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzeb = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.places.zzs.zze(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzeb = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.places.zzs.zzc(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzeb = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzeb = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.places.zzs.zzd(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzeb = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.places.zzs.zzf(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r1, r2, r6)
            long r2 = r6.zzea
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzeb = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(byte[], int, int, com.google.android.gms.internal.places.zzef, java.lang.Class, com.google.android.gms.internal.places.zzr):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0420 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01e8  */
    private final int zzb(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.places.zzr r29) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = zzkr
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.places.zzbh r12 = (com.google.android.gms.internal.places.zzbh) r12
            boolean r13 = r12.zzaa()
            r14 = 1
            if (r13 != 0) goto L_0x0033
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002b
            r13 = 10
            goto L_0x002c
        L_0x002b:
            int r13 = r13 << r14
        L_0x002c:
            com.google.android.gms.internal.places.zzbh r12 = r12.zzh(r13)
            r11.putObject(r1, r9, r12)
        L_0x0033:
            r9 = 5
            r10 = 0
            r13 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x03a3;
                case 20: goto L_0x0362;
                case 21: goto L_0x0362;
                case 22: goto L_0x0348;
                case 23: goto L_0x0309;
                case 24: goto L_0x02ca;
                case 25: goto L_0x0273;
                case 26: goto L_0x01c0;
                case 27: goto L_0x01a6;
                case 28: goto L_0x014e;
                case 29: goto L_0x0348;
                case 30: goto L_0x0116;
                case 31: goto L_0x02ca;
                case 32: goto L_0x0309;
                case 33: goto L_0x00c9;
                case 34: goto L_0x007c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x03a3;
                case 37: goto L_0x0362;
                case 38: goto L_0x0362;
                case 39: goto L_0x0348;
                case 40: goto L_0x0309;
                case 41: goto L_0x02ca;
                case 42: goto L_0x0273;
                case 43: goto L_0x0348;
                case 44: goto L_0x0116;
                case 45: goto L_0x02ca;
                case 46: goto L_0x0309;
                case 47: goto L_0x00c9;
                case 48: goto L_0x007c;
                case 49: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            goto L_0x041f
        L_0x003c:
            r1 = 3
            if (r6 != r1) goto L_0x041f
            com.google.android.gms.internal.places.zzda r1 = r15.zzaf(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.places.zzr) r26)
            java.lang.Object r8 = r7.zzeb
            r12.add(r8)
        L_0x005c:
            if (r4 >= r5) goto L_0x041f
            int r8 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r9 = r7.zzdz
            if (r2 != r9) goto L_0x041f
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r21, (byte[]) r22, (int) r23, (int) r24, (int) r25, (com.google.android.gms.internal.places.zzr) r26)
            java.lang.Object r8 = r7.zzeb
            r12.add(r8)
            goto L_0x005c
        L_0x007c:
            if (r6 != r13) goto L_0x00a0
            com.google.android.gms.internal.places.zzby r12 = (com.google.android.gms.internal.places.zzby) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x0087:
            if (r1 >= r2) goto L_0x0097
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r1, r7)
            long r4 = r7.zzea
            long r4 = com.google.android.gms.internal.places.zzai.zzb(r4)
            r12.zzm(r4)
            goto L_0x0087
        L_0x0097:
            if (r1 != r2) goto L_0x009b
            goto L_0x0420
        L_0x009b:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x00a0:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.places.zzby r12 = (com.google.android.gms.internal.places.zzby) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            long r8 = com.google.android.gms.internal.places.zzai.zzb(r8)
            r12.zzm(r8)
        L_0x00b1:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            long r8 = com.google.android.gms.internal.places.zzai.zzb(r8)
            r12.zzm(r8)
            goto L_0x00b1
        L_0x00c9:
            if (r6 != r13) goto L_0x00ed
            com.google.android.gms.internal.places.zzbe r12 = (com.google.android.gms.internal.places.zzbe) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x00d4:
            if (r1 >= r2) goto L_0x00e4
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r4 = r7.zzdz
            int r4 = com.google.android.gms.internal.places.zzai.zzm(r4)
            r12.zzac(r4)
            goto L_0x00d4
        L_0x00e4:
            if (r1 != r2) goto L_0x00e8
            goto L_0x0420
        L_0x00e8:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x00ed:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.places.zzbe r12 = (com.google.android.gms.internal.places.zzbe) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            int r4 = com.google.android.gms.internal.places.zzai.zzm(r4)
            r12.zzac(r4)
        L_0x00fe:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            int r4 = com.google.android.gms.internal.places.zzai.zzm(r4)
            r12.zzac(r4)
            goto L_0x00fe
        L_0x0116:
            if (r6 != r13) goto L_0x011d
            int r2 = com.google.android.gms.internal.places.zzs.zzb((byte[]) r3, (int) r4, (com.google.android.gms.internal.places.zzbh<?>) r12, (com.google.android.gms.internal.places.zzr) r7)
            goto L_0x012e
        L_0x011d:
            if (r6 != 0) goto L_0x041f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.places.zzs.zzb((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzbh<?>) r6, (com.google.android.gms.internal.places.zzr) r7)
        L_0x012e:
            com.google.android.gms.internal.places.zzbc r1 = (com.google.android.gms.internal.places.zzbc) r1
            com.google.android.gms.internal.places.zzdr r3 = r1.zzih
            com.google.android.gms.internal.places.zzdr r4 = com.google.android.gms.internal.places.zzdr.zzdh()
            if (r3 != r4) goto L_0x0139
            r3 = 0
        L_0x0139:
            com.google.android.gms.internal.places.zzbf r4 = r15.zzah(r8)
            com.google.android.gms.internal.places.zzds<?, ?> r5 = r0.zzlg
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.places.zzdc.zzb(r6, r12, r4, r3, r5)
            com.google.android.gms.internal.places.zzdr r3 = (com.google.android.gms.internal.places.zzdr) r3
            if (r3 == 0) goto L_0x014b
            r1.zzih = r3
        L_0x014b:
            r1 = r2
            goto L_0x0420
        L_0x014e:
            if (r6 != r13) goto L_0x041f
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x01a1
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019c
            if (r4 != 0) goto L_0x0164
            com.google.android.gms.internal.places.zzw r4 = com.google.android.gms.internal.places.zzw.zzeg
            r12.add(r4)
            goto L_0x016c
        L_0x0164:
            com.google.android.gms.internal.places.zzw r6 = com.google.android.gms.internal.places.zzw.zzc((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
        L_0x016b:
            int r1 = r1 + r4
        L_0x016c:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x0197
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0192
            if (r4 != 0) goto L_0x018a
            com.google.android.gms.internal.places.zzw r4 = com.google.android.gms.internal.places.zzw.zzeg
            r12.add(r4)
            goto L_0x016c
        L_0x018a:
            com.google.android.gms.internal.places.zzw r6 = com.google.android.gms.internal.places.zzw.zzc((byte[]) r3, (int) r1, (int) r4)
            r12.add(r6)
            goto L_0x016b
        L_0x0192:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x0197:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x019c:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x01a1:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x01a6:
            if (r6 != r13) goto L_0x041f
            com.google.android.gms.internal.places.zzda r1 = r15.zzaf(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r21, r22, r23, r24, r25, r26, r27)
            goto L_0x0420
        L_0x01c0:
            if (r6 != r13) goto L_0x041f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x0213
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x020e
            if (r4 != 0) goto L_0x01db
            r12.add(r6)
            goto L_0x01e6
        L_0x01db:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.places.zzbd.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01e5:
            int r1 = r1 + r4
        L_0x01e6:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r8 = r7.zzdz
            if (r2 != r8) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x0209
            if (r4 != 0) goto L_0x01fe
            r12.add(r6)
            goto L_0x01e6
        L_0x01fe:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.places.zzbd.UTF_8
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01e5
        L_0x0209:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x020e:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x0213:
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x026e
            if (r4 != 0) goto L_0x0221
            r12.add(r6)
            goto L_0x0234
        L_0x0221:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.places.zzea.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0269
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.places.zzbd.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x0233:
            r1 = r8
        L_0x0234:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r8 = r7.zzdz
            if (r2 != r8) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            if (r4 < 0) goto L_0x0264
            if (r4 != 0) goto L_0x024c
            r12.add(r6)
            goto L_0x0234
        L_0x024c:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.places.zzea.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x025f
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.places.zzbd.UTF_8
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x0233
        L_0x025f:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbu()
            throw r1
        L_0x0264:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x0269:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbu()
            throw r1
        L_0x026e:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbq()
            throw r1
        L_0x0273:
            r1 = 0
            if (r6 != r13) goto L_0x029b
            com.google.android.gms.internal.places.zzu r12 = (com.google.android.gms.internal.places.zzu) r12
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r4 = r7.zzdz
            int r4 = r4 + r2
        L_0x027f:
            if (r2 >= r4) goto L_0x0292
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r2, r7)
            long r5 = r7.zzea
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x028d
            r5 = r14
            goto L_0x028e
        L_0x028d:
            r5 = r1
        L_0x028e:
            r12.addBoolean(r5)
            goto L_0x027f
        L_0x0292:
            if (r2 != r4) goto L_0x0296
            goto L_0x014b
        L_0x0296:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x029b:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.places.zzu r12 = (com.google.android.gms.internal.places.zzu) r12
            int r4 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ab
            r6 = r14
            goto L_0x02ac
        L_0x02ab:
            r6 = r1
        L_0x02ac:
            r12.addBoolean(r6)
        L_0x02af:
            if (r4 >= r5) goto L_0x041f
            int r6 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r8 = r7.zzdz
            if (r2 != r8) goto L_0x041f
            int r4 = com.google.android.gms.internal.places.zzs.zzc(r3, r6, r7)
            long r8 = r7.zzea
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02c5
            r6 = r14
            goto L_0x02c6
        L_0x02c5:
            r6 = r1
        L_0x02c6:
            r12.addBoolean(r6)
            goto L_0x02af
        L_0x02ca:
            if (r6 != r13) goto L_0x02ea
            com.google.android.gms.internal.places.zzbe r12 = (com.google.android.gms.internal.places.zzbe) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x02d5:
            if (r1 >= r2) goto L_0x02e1
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1)
            r12.zzac(r4)
            int r1 = r1 + 4
            goto L_0x02d5
        L_0x02e1:
            if (r1 != r2) goto L_0x02e5
            goto L_0x0420
        L_0x02e5:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x02ea:
            if (r6 != r9) goto L_0x041f
            com.google.android.gms.internal.places.zzbe r12 = (com.google.android.gms.internal.places.zzbe) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r17, r18)
            r12.zzac(r1)
        L_0x02f5:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4)
            r12.zzac(r1)
            goto L_0x02f5
        L_0x0309:
            if (r6 != r13) goto L_0x0329
            com.google.android.gms.internal.places.zzby r12 = (com.google.android.gms.internal.places.zzby) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x0314:
            if (r1 >= r2) goto L_0x0320
            long r4 = com.google.android.gms.internal.places.zzs.zzc(r3, r1)
            r12.zzm(r4)
            int r1 = r1 + 8
            goto L_0x0314
        L_0x0320:
            if (r1 != r2) goto L_0x0324
            goto L_0x0420
        L_0x0324:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x0329:
            if (r6 != r14) goto L_0x041f
            com.google.android.gms.internal.places.zzby r12 = (com.google.android.gms.internal.places.zzby) r12
            long r8 = com.google.android.gms.internal.places.zzs.zzc(r17, r18)
            r12.zzm(r8)
        L_0x0334:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            long r8 = com.google.android.gms.internal.places.zzs.zzc(r3, r4)
            r12.zzm(r8)
            goto L_0x0334
        L_0x0348:
            if (r6 != r13) goto L_0x0350
            int r1 = com.google.android.gms.internal.places.zzs.zzb((byte[]) r3, (int) r4, (com.google.android.gms.internal.places.zzbh<?>) r12, (com.google.android.gms.internal.places.zzr) r7)
            goto L_0x0420
        L_0x0350:
            if (r6 != 0) goto L_0x041f
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.places.zzs.zzb((int) r20, (byte[]) r21, (int) r22, (int) r23, (com.google.android.gms.internal.places.zzbh<?>) r24, (com.google.android.gms.internal.places.zzr) r25)
            goto L_0x0420
        L_0x0362:
            if (r6 != r13) goto L_0x0382
            com.google.android.gms.internal.places.zzby r12 = (com.google.android.gms.internal.places.zzby) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x036d:
            if (r1 >= r2) goto L_0x0379
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r1, r7)
            long r4 = r7.zzea
            r12.zzm(r4)
            goto L_0x036d
        L_0x0379:
            if (r1 != r2) goto L_0x037d
            goto L_0x0420
        L_0x037d:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x0382:
            if (r6 != 0) goto L_0x041f
            com.google.android.gms.internal.places.zzby r12 = (com.google.android.gms.internal.places.zzby) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            r12.zzm(r8)
        L_0x038f:
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r7)
            long r8 = r7.zzea
            r12.zzm(r8)
            goto L_0x038f
        L_0x03a3:
            if (r6 != r13) goto L_0x03c2
            com.google.android.gms.internal.places.zzbb r12 = (com.google.android.gms.internal.places.zzbb) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x03ae:
            if (r1 >= r2) goto L_0x03ba
            float r4 = com.google.android.gms.internal.places.zzs.zze(r3, r1)
            r12.zzf((float) r4)
            int r1 = r1 + 4
            goto L_0x03ae
        L_0x03ba:
            if (r1 != r2) goto L_0x03bd
            goto L_0x0420
        L_0x03bd:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x03c2:
            if (r6 != r9) goto L_0x041f
            com.google.android.gms.internal.places.zzbb r12 = (com.google.android.gms.internal.places.zzbb) r12
            float r1 = com.google.android.gms.internal.places.zzs.zze(r17, r18)
            r12.zzf((float) r1)
        L_0x03cd:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            float r1 = com.google.android.gms.internal.places.zzs.zze(r3, r4)
            r12.zzf((float) r1)
            goto L_0x03cd
        L_0x03e1:
            if (r6 != r13) goto L_0x0400
            com.google.android.gms.internal.places.zzao r12 = (com.google.android.gms.internal.places.zzao) r12
            int r1 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r7)
            int r2 = r7.zzdz
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03f8
            double r4 = com.google.android.gms.internal.places.zzs.zzd(r3, r1)
            r12.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03f8:
            if (r1 != r2) goto L_0x03fb
            goto L_0x0420
        L_0x03fb:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r1
        L_0x0400:
            if (r6 != r14) goto L_0x041f
            com.google.android.gms.internal.places.zzao r12 = (com.google.android.gms.internal.places.zzao) r12
            double r8 = com.google.android.gms.internal.places.zzs.zzd(r17, r18)
            r12.zzd(r8)
        L_0x040b:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.gms.internal.places.zzs.zzb(r3, r1, r7)
            int r6 = r7.zzdz
            if (r2 != r6) goto L_0x0420
            double r8 = com.google.android.gms.internal.places.zzs.zzd(r3, r4)
            r12.zzd(r8)
            goto L_0x040b
        L_0x041f:
            r1 = r4
        L_0x0420:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zzb(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.places.zzr r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzkr
            java.lang.Object r12 = r7.zzag(r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.places.zzcd r2 = r7.zzli
            boolean r2 = r2.zzi(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.places.zzcd r2 = r7.zzli
            java.lang.Object r2 = r2.zzk(r12)
            com.google.android.gms.internal.places.zzcd r3 = r7.zzli
            r3.zzc(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.places.zzcd r8 = r7.zzli
            com.google.android.gms.internal.places.zzcb r8 = r8.zzl(r12)
            com.google.android.gms.internal.places.zzcd r12 = r7.zzli
            java.util.Map r12 = r12.zzg(r1)
            int r10 = com.google.android.gms.internal.places.zzs.zzb(r9, r10, r15)
            int r13 = r15.zzdz
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzkk
            V r0 = r8.zzkm
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.places.zzs.zzb((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.places.zzr) r15)
            int r10 = r15.zzdz
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
            com.google.android.gms.internal.places.zzef r1 = r8.zzkl
            int r1 = r1.zzds()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.places.zzef r4 = r8.zzkl
            V r10 = r8.zzkm
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zzb((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzef) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.places.zzr) r6)
            java.lang.Object r0 = r15.zzeb
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.places.zzef r1 = r8.zzkj
            int r1 = r1.zzds()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.places.zzef r4 = r8.zzkj
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zzb((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzef) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.places.zzr) r6)
            java.lang.Object r14 = r15.zzeb
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.places.zzs.zzb((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.places.zzr) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.places.zzbk r8 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.places.zzbk r8 = com.google.android.gms.internal.places.zzbk.zzbp()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.places.zzr):int");
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
    private final int zzb(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.places.zzr r29) throws java.io.IOException {
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
            sun.misc.Unsafe r12 = zzkr
            int[] r7 = r0.zzks
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
            com.google.android.gms.internal.places.zzda r2 = r0.zzaf(r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.places.zzr) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzeb
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzeb
            java.lang.Object r3 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r11)
            long r3 = r11.zzea
            long r3 = com.google.android.gms.internal.places.zzai.zzb(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r3 = r11.zzdz
            int r3 = com.google.android.gms.internal.places.zzai.zzm(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r4 = r11.zzdz
            com.google.android.gms.internal.places.zzbf r5 = r0.zzah(r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zzad(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.places.zzdr r1 = zzo(r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zzc(r2, r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzf(r3, r4, r11)
            java.lang.Object r3 = r11.zzeb
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.places.zzda r2 = r0.zzaf(r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzr) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzeb
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzeb
            java.lang.Object r3 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r4 = r11.zzdz
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.places.zzea.zzf(r3, r2, r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.places.zzbk r1 = com.google.android.gms.internal.places.zzbk.zzbu()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.places.zzbd.UTF_8
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r11)
            long r3 = r11.zzea
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
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.places.zzs.zzc(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzb(r3, r4, r11)
            int r3 = r11.zzdz
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.places.zzs.zzc(r3, r4, r11)
            long r3 = r11.zzea
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.places.zzs.zze(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.places.zzs.zzd(r18, r19)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.places.zzr):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v17, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v32, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x036d, code lost:
        if (r0 == r15) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03b6, code lost:
        if (r0 == r15) goto L_0x03e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0175, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0215, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0217, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r34;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0241, code lost:
        r32 = r7;
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02b9, code lost:
        r0 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02bb, code lost:
        r6 = r6 | r22;
        r7 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bf, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02c3, code lost:
        r13 = r33;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02c9, code lost:
        r2 = r7;
        r19 = r9;
        r26 = r10;
        r7 = r32;
        r9 = r8;
        r32 = r11;
        r8 = r34;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.places.zzr r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzkr
            r16 = 0
            r0 = r32
            r2 = r16
            r3 = r2
            r6 = r3
            r1 = -1
            r7 = -1
        L_0x0018:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x0482
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.places.zzr) r9)
            int r3 = r9.zzdz
            r4 = r0
            r5 = r3
            goto L_0x002e
        L_0x002c:
            r5 = r0
            r4 = r3
        L_0x002e:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x003b
            int r2 = r2 / r8
            int r1 = r15.zzq(r3, r2)
            goto L_0x003f
        L_0x003b:
            int r1 = r15.zzak(r3)
        L_0x003f:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004e
            r32 = r3
            r2 = r4
            r9 = r5
            r26 = r10
            r8 = r11
            r19 = r16
            goto L_0x03e4
        L_0x004e:
            int[] r1 = r15.zzks
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02d7
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r17
            r5 = -1
            if (r1 == r7) goto L_0x007f
            if (r7 == r5) goto L_0x0079
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0079:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
        L_0x007f:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02a1;
                case 1: goto L_0x0287;
                case 2: goto L_0x0261;
                case 3: goto L_0x0261;
                case 4: goto L_0x0246;
                case 5: goto L_0x0220;
                case 6: goto L_0x01fd;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01af;
                case 9: goto L_0x0179;
                case 10: goto L_0x015e;
                case 11: goto L_0x0246;
                case 12: goto L_0x012c;
                case 13: goto L_0x01fd;
                case 14: goto L_0x0220;
                case 15: goto L_0x0111;
                case 16: goto L_0x00e4;
                case 17: goto L_0x0092;
                default: goto L_0x0083;
            }
        L_0x0083:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r32 = r7
            r8 = r19
            r7 = r4
            r19 = r5
            goto L_0x02c9
        L_0x0092:
            r8 = 3
            if (r0 != r8) goto L_0x00d8
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r8 = r19
            r19 = r5
            r5 = r35
            int r0 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.places.zzr) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00bb
            r5 = r35
            java.lang.Object r1 = r5.zzeb
            r10.putObject(r14, r12, r1)
            goto L_0x00ca
        L_0x00bb:
            r5 = r35
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzeb
            java.lang.Object r1 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00ca:
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x0018
        L_0x00d8:
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = r5
            r12 = r31
            r13 = r35
            goto L_0x0241
        L_0x00e4:
            r9 = r2
            r11 = r3
            r8 = r19
            r19 = r5
            r5 = r35
            if (r0 != 0) goto L_0x010c
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.places.zzs.zzc(r12, r4, r5)
            long r0 = r5.zzea
            long r17 = com.google.android.gms.internal.places.zzai.zzb(r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            goto L_0x02bf
        L_0x010c:
            r12 = r31
            r13 = r5
            goto L_0x0241
        L_0x0111:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r19 = r5
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r4, r13)
            int r1 = r13.zzdz
            int r1 = com.google.android.gms.internal.places.zzai.zzm(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0175
        L_0x012c:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r19 = r5
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r4, r13)
            int r1 = r13.zzdz
            com.google.android.gms.internal.places.zzbf r4 = r15.zzah(r9)
            if (r4 == 0) goto L_0x015a
            boolean r4 = r4.zzad(r1)
            if (r4 == 0) goto L_0x014c
            goto L_0x015a
        L_0x014c:
            com.google.android.gms.internal.places.zzdr r2 = zzo(r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzc(r8, r1)
            goto L_0x02bf
        L_0x015a:
            r10.putInt(r14, r2, r1)
            goto L_0x0175
        L_0x015e:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r31
            r13 = r35
            r19 = r5
            if (r0 != r1) goto L_0x0241
            int r0 = com.google.android.gms.internal.places.zzs.zzf(r12, r4, r13)
            java.lang.Object r1 = r13.zzeb
            r10.putObject(r14, r2, r1)
        L_0x0175:
            r6 = r6 | r22
            goto L_0x02bf
        L_0x0179:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r31
            r13 = r35
            r19 = r5
            if (r0 != r1) goto L_0x01ab
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzr) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x019c
            java.lang.Object r1 = r13.zzeb
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x019c:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzeb
            java.lang.Object r1 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x01ab:
            r5 = r33
            goto L_0x0241
        L_0x01af:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r12 = r31
            r13 = r35
            r19 = r5
            r5 = r33
            if (r0 != r1) goto L_0x0241
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r4, r13)
            goto L_0x01ce
        L_0x01ca:
            int r0 = com.google.android.gms.internal.places.zzs.zze(r12, r4, r13)
        L_0x01ce:
            java.lang.Object r1 = r13.zzeb
            r10.putObject(r14, r2, r1)
            goto L_0x0215
        L_0x01d4:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r19 = r5
            r5 = r33
            if (r0 != 0) goto L_0x0241
            int r0 = com.google.android.gms.internal.places.zzs.zzc(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzea
            r20 = 0
            int r0 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r0 == 0) goto L_0x01f3
            r0 = 1
            goto L_0x01f5
        L_0x01f3:
            r0 = r16
        L_0x01f5:
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r32
            goto L_0x0217
        L_0x01fd:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r19 = r5
            r5 = r33
            if (r0 != r1) goto L_0x0241
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0215:
            r6 = r6 | r22
        L_0x0217:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x0018
        L_0x0220:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r12 = r31
            r13 = r35
            r19 = r5
            r5 = r33
            if (r0 != r1) goto L_0x0241
            long r17 = com.google.android.gms.internal.places.zzs.zzc(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            goto L_0x02b9
        L_0x0241:
            r32 = r7
            r7 = r4
            goto L_0x02c9
        L_0x0246:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r7 = r4
            r19 = r5
            if (r0 != 0) goto L_0x02c9
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r7, r13)
            int r1 = r13.zzdz
            r10.putInt(r14, r2, r1)
            goto L_0x02bb
        L_0x0261:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r7 = r4
            r19 = r5
            if (r0 != 0) goto L_0x02c9
            int r7 = com.google.android.gms.internal.places.zzs.zzc(r12, r7, r13)
            long r4 = r13.zzea
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            goto L_0x02c3
        L_0x0287:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r12 = r31
            r13 = r35
            r7 = r4
            r19 = r5
            if (r0 != r1) goto L_0x02c9
            float r0 = com.google.android.gms.internal.places.zzs.zze(r12, r7)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x02bb
        L_0x02a1:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r12 = r31
            r13 = r35
            r7 = r4
            r19 = r5
            if (r0 != r1) goto L_0x02c9
            double r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r7)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x02b9:
            int r0 = r7 + 8
        L_0x02bb:
            r6 = r6 | r22
            r7 = r32
        L_0x02bf:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c3:
            r13 = r33
            r11 = r34
            goto L_0x0018
        L_0x02c9:
            r2 = r7
            r19 = r9
            r26 = r10
            r7 = r32
            r9 = r8
            r32 = r11
            r8 = r34
            goto L_0x03e4
        L_0x02d7:
            r5 = r3
            r18 = r7
            r8 = r19
            r19 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x033c
            r1 = 2
            if (r0 != r1) goto L_0x032f
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.places.zzbh r0 = (com.google.android.gms.internal.places.zzbh) r0
            boolean r1 = r0.zzaa()
            if (r1 != 0) goto L_0x030c
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0303
            r1 = 10
            goto L_0x0305
        L_0x0303:
            int r1 = r1 << 1
        L_0x0305:
            com.google.android.gms.internal.places.zzbh r0 = r0.zzh(r1)
            r10.putObject(r14, r2, r0)
        L_0x030c:
            r11 = r0
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r22 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r18
            r6 = r22
            r13 = r33
            goto L_0x0018
        L_0x032f:
            r22 = r6
            r32 = r5
            r15 = r7
            r25 = r8
            r19 = r9
            r26 = r10
            goto L_0x03b9
        L_0x033c:
            r22 = r6
            r1 = 49
            if (r11 > r1) goto L_0x038b
            r6 = r20
            long r12 = (long) r6
            r6 = r0
            r0 = r29
            r1 = r30
            r23 = r2
            r2 = r31
            r3 = r7
            r4 = r33
            r32 = r5
            r5 = r8
            r20 = r6
            r6 = r32
            r15 = r7
            r7 = r20
            r25 = r8
            r8 = r9
            r19 = r9
            r26 = r10
            r9 = r12
            r12 = r34
            r12 = r23
            r14 = r35
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.places.zzr) r14)
            if (r0 != r15) goto L_0x0371
            goto L_0x03e0
        L_0x0371:
            r15 = r29
            r14 = r30
            r12 = r31
            r1 = r32
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r18
            r2 = r19
            r6 = r22
            r3 = r25
            r10 = r26
            goto L_0x0018
        L_0x038b:
            r23 = r2
            r32 = r5
            r15 = r7
            r25 = r8
            r19 = r9
            r26 = r10
            r6 = r20
            r20 = r0
            r0 = 50
            if (r11 != r0) goto L_0x03c3
            r7 = r20
            r0 = 2
            if (r7 != r0) goto L_0x03b9
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r19
            r6 = r23
            r8 = r35
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.places.zzr) r8)
            if (r0 != r15) goto L_0x0371
            goto L_0x03e0
        L_0x03b9:
            r8 = r34
            r2 = r15
        L_0x03bc:
            r7 = r18
            r6 = r22
            r9 = r25
            goto L_0x03e4
        L_0x03c3:
            r7 = r20
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r25
            r8 = r6
            r6 = r32
            r9 = r11
            r10 = r23
            r12 = r19
            r13 = r35
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.places.zzr) r13)
            if (r0 != r15) goto L_0x0466
        L_0x03e0:
            r8 = r34
            r2 = r0
            goto L_0x03bc
        L_0x03e4:
            if (r9 != r8) goto L_0x03f2
            if (r8 != 0) goto L_0x03e9
            goto L_0x03f2
        L_0x03e9:
            r10 = r29
            r13 = r30
            r0 = r7
            r1 = -1
            r7 = r2
            goto L_0x0490
        L_0x03f2:
            r10 = r29
            boolean r0 = r10.zzkx
            if (r0 == 0) goto L_0x0441
            r11 = r35
            com.google.android.gms.internal.places.zzap r0 = r11.zzec
            com.google.android.gms.internal.places.zzap r1 = com.google.android.gms.internal.places.zzap.zzao()
            if (r0 == r1) goto L_0x043c
            com.google.android.gms.internal.places.zzck r0 = r10.zzkw
            com.google.android.gms.internal.places.zzap r1 = r11.zzec
            r12 = r32
            com.google.android.gms.internal.places.zzbc$zzf r0 = r1.zzb(r0, r12)
            if (r0 != 0) goto L_0x042c
            com.google.android.gms.internal.places.zzdr r4 = zzo(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzdr) r4, (com.google.android.gms.internal.places.zzr) r5)
            r14 = r30
            r13 = r33
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r2 = r19
            r10 = r26
            r12 = r31
            goto L_0x0463
        L_0x042c:
            r13 = r30
            r0 = r13
            com.google.android.gms.internal.places.zzbc$zzc r0 = (com.google.android.gms.internal.places.zzbc.zzc) r0
            r0.zzbm()
            com.google.android.gms.internal.places.zzav<java.lang.Object> r0 = r0.zzik
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x043c:
            r13 = r30
            r12 = r32
            goto L_0x0447
        L_0x0441:
            r13 = r30
            r12 = r32
            r11 = r35
        L_0x0447:
            com.google.android.gms.internal.places.zzdr r4 = zzo(r30)
            r0 = r9
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzdr) r4, (com.google.android.gms.internal.places.zzr) r5)
            r3 = r9
            r15 = r10
            r9 = r11
            r1 = r12
            r14 = r13
            r2 = r19
            r10 = r26
            r12 = r31
            r13 = r33
        L_0x0463:
            r11 = r8
            goto L_0x0018
        L_0x0466:
            r12 = r32
            r9 = r25
            r15 = r29
            r14 = r30
            r13 = r33
            r11 = r34
            r3 = r9
            r1 = r12
            r7 = r18
            r2 = r19
            r6 = r22
            r10 = r26
            r12 = r31
            r9 = r35
            goto L_0x0018
        L_0x0482:
            r22 = r6
            r18 = r7
            r26 = r10
            r8 = r11
            r13 = r14
            r10 = r15
            r7 = r0
            r9 = r3
            r0 = r18
            r1 = -1
        L_0x0490:
            if (r0 == r1) goto L_0x0498
            long r0 = (long) r0
            r2 = r26
            r2.putInt(r13, r0, r6)
        L_0x0498:
            int r0 = r10.zzlc
            r1 = 0
            r11 = r0
            r5 = r1
        L_0x049d:
            int r0 = r10.zzld
            if (r11 >= r0) goto L_0x04d1
            int[] r0 = r10.zzlb
            r1 = r0[r11]
            com.google.android.gms.internal.places.zzds<?, ?> r6 = r10.zzlg
            int[] r0 = r10.zzks
            r2 = r0[r1]
            int r0 = r10.zzai(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.places.zzdy.zzp(r13, r3)
            if (r0 != 0) goto L_0x04b9
            goto L_0x04cc
        L_0x04b9:
            com.google.android.gms.internal.places.zzbf r4 = r10.zzah(r1)
            if (r4 != 0) goto L_0x04c0
            goto L_0x04cc
        L_0x04c0:
            com.google.android.gms.internal.places.zzcd r3 = r10.zzli
            java.util.Map r3 = r3.zzg(r0)
            r0 = r29
            java.lang.Object r5 = r0.zzb((int) r1, (int) r2, r3, (com.google.android.gms.internal.places.zzbf) r4, r5, r6)
        L_0x04cc:
            com.google.android.gms.internal.places.zzdr r5 = (com.google.android.gms.internal.places.zzdr) r5
            int r11 = r11 + 1
            goto L_0x049d
        L_0x04d1:
            if (r5 == 0) goto L_0x04d8
            com.google.android.gms.internal.places.zzds<?, ?> r0 = r10.zzlg
            r0.zzg(r13, r5)
        L_0x04d8:
            if (r8 != 0) goto L_0x04e4
            r0 = r33
            if (r7 != r0) goto L_0x04df
            goto L_0x04ea
        L_0x04df:
            com.google.android.gms.internal.places.zzbk r0 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r0
        L_0x04e4:
            r0 = r33
            if (r7 > r0) goto L_0x04eb
            if (r9 != r8) goto L_0x04eb
        L_0x04ea:
            return r7
        L_0x04eb:
            com.google.android.gms.internal.places.zzbk r0 = com.google.android.gms.internal.places.zzbk.zzbt()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.places.zzr):int");
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
    public final void zzb(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.places.zzr r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzkz
            if (r0 == 0) goto L_0x0260
            sun.misc.Unsafe r9 = zzkr
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
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.places.zzr) r11)
            int r3 = r11.zzdz
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
            int r0 = r15.zzq(r7, r2)
            goto L_0x003e
        L_0x003a:
            int r0 = r15.zzak(r7)
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
            int[] r0 = r15.zzks
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
            int r6 = com.google.android.gms.internal.places.zzs.zzc(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzea
            long r21 = com.google.android.gms.internal.places.zzai.zzb(r0)
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
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8, r11)
            int r1 = r11.zzdz
            int r1 = com.google.android.gms.internal.places.zzai.zzm(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x0095:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8, r11)
            int r1 = r11.zzdz
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x00a4:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            int r0 = com.google.android.gms.internal.places.zzs.zzf(r12, r8, r11)
            java.lang.Object r1 = r11.zzeb
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00b1:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r4)
            int r0 = com.google.android.gms.internal.places.zzs.zzb((com.google.android.gms.internal.places.zzda) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.places.zzr) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c8
            java.lang.Object r1 = r11.zzeb
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00c8:
            java.lang.Object r5 = r11.zzeb
            java.lang.Object r1 = com.google.android.gms.internal.places.zzbd.zzb((java.lang.Object) r1, (java.lang.Object) r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00d2:
            r2 = r1
            if (r6 != r10) goto L_0x01a6
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00df
            int r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r8, r11)
            goto L_0x00e3
        L_0x00df:
            int r0 = com.google.android.gms.internal.places.zzs.zze(r12, r8, r11)
        L_0x00e3:
            java.lang.Object r1 = r11.zzeb
            r9.putObject(r14, r2, r1)
            goto L_0x010d
        L_0x00e9:
            r2 = r1
            if (r6 != 0) goto L_0x01a6
            int r1 = com.google.android.gms.internal.places.zzs.zzc(r12, r8, r11)
            long r5 = r11.zzea
            r19 = 0
            int r5 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r5 == 0) goto L_0x00f9
            goto L_0x00fb
        L_0x00f9:
            r0 = r16
        L_0x00fb:
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010d
        L_0x0100:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a6
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010d:
            r2 = r4
            r1 = r7
            goto L_0x015f
        L_0x0111:
            r2 = r1
            if (r6 != r0) goto L_0x01a6
            long r5 = com.google.android.gms.internal.places.zzs.zzc(r12, r8)
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
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r12, r8, r11)
            int r1 = r11.zzdz
            r9.putInt(r14, r2, r1)
            goto L_0x015d
        L_0x012f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x0162
            int r6 = com.google.android.gms.internal.places.zzs.zzc(r12, r8, r11)
            long r4 = r11.zzea
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
            float r0 = com.google.android.gms.internal.places.zzs.zze(r12, r8)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015d
        L_0x0150:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x0162
            double r0 = com.google.android.gms.internal.places.zzs.zzd(r12, r8)
            com.google.android.gms.internal.places.zzdy.zzb((java.lang.Object) r14, (long) r2, (double) r0)
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
            com.google.android.gms.internal.places.zzbh r0 = (com.google.android.gms.internal.places.zzbh) r0
            boolean r3 = r0.zzaa()
            if (r3 != 0) goto L_0x018e
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0185
            r3 = 10
            goto L_0x0187
        L_0x0185:
            int r3 = r3 << 1
        L_0x0187:
            com.google.android.gms.internal.places.zzbh r0 = r0.zzh(r3)
            r9.putObject(r14, r1, r0)
        L_0x018e:
            r5 = r0
            com.google.android.gms.internal.places.zzda r0 = r15.zzaf(r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.places.zzs.zzb(r0, r1, r2, r3, r4, r5, r6)
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
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.places.zzr) r14)
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
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.places.zzr) r8)
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
            int r0 = r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.places.zzr) r13)
            if (r0 != r15) goto L_0x0243
        L_0x0232:
            r2 = r0
        L_0x0233:
            com.google.android.gms.internal.places.zzdr r4 = zzo(r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.places.zzs.zzb((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.places.zzdr) r4, (com.google.android.gms.internal.places.zzr) r5)
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
            com.google.android.gms.internal.places.zzbk r0 = com.google.android.gms.internal.places.zzbk.zzbt()
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
            r0.zzb(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.places.zzr) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzco.zzb(java.lang.Object, byte[], int, int, com.google.android.gms.internal.places.zzr):void");
    }

    private final <K, V, UT, UB> UB zzb(int i11, int i12, Map<K, V> map, zzbf zzbf, UB ub2, zzds<UT, UB> zzds) {
        zzcb<?, ?> zzl = this.zzli.zzl(zzag(i11));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzbf.zzad(((Integer) next.getValue()).intValue())) {
                if (ub2 == null) {
                    ub2 = zzds.zzdk();
                }
                zzae zzk = zzw.zzk(zzcc.zzb(zzl, next.getKey(), next.getValue()));
                try {
                    zzcc.zzb(zzk.zzai(), zzl, next.getKey(), next.getValue());
                    zzds.zzb(ub2, i12, zzk.zzah());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return ub2;
    }

    private static boolean zzb(Object obj, int i11, zzda zzda) {
        return zzda.zzp(zzdy.zzp(obj, (long) (i11 & 1048575)));
    }

    private static void zzb(int i11, Object obj, zzel zzel) throws IOException {
        if (obj instanceof String) {
            zzel.zzb(i11, (String) obj);
        } else {
            zzel.zzb(i11, (zzw) obj);
        }
    }

    private final boolean zzb(T t11, int i11, int i12, int i13) {
        if (this.zzkz) {
            return zzb(t11, i11);
        }
        return (i12 & i13) != 0;
    }

    private final boolean zzb(T t11, int i11) {
        if (this.zzkz) {
            int zzai = zzai(i11);
            long j11 = (long) (zzai & 1048575);
            switch ((zzai & 267386880) >>> 20) {
                case 0:
                    return zzdy.zzo(t11, j11) != 0.0d;
                case 1:
                    return zzdy.zzn(t11, j11) != 0.0f;
                case 2:
                    return zzdy.zzl(t11, j11) != 0;
                case 3:
                    return zzdy.zzl(t11, j11) != 0;
                case 4:
                    return zzdy.zzk(t11, j11) != 0;
                case 5:
                    return zzdy.zzl(t11, j11) != 0;
                case 6:
                    return zzdy.zzk(t11, j11) != 0;
                case 7:
                    return zzdy.zzm(t11, j11);
                case 8:
                    Object zzp = zzdy.zzp(t11, j11);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzw) {
                        return !zzw.zzeg.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzdy.zzp(t11, j11) != null;
                case 10:
                    return !zzw.zzeg.equals(zzdy.zzp(t11, j11));
                case 11:
                    return zzdy.zzk(t11, j11) != 0;
                case 12:
                    return zzdy.zzk(t11, j11) != 0;
                case 13:
                    return zzdy.zzk(t11, j11) != 0;
                case 14:
                    return zzdy.zzl(t11, j11) != 0;
                case 15:
                    return zzdy.zzk(t11, j11) != 0;
                case 16:
                    return zzdy.zzl(t11, j11) != 0;
                case 17:
                    return zzdy.zzp(t11, j11) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzaj = zzaj(i11);
            return (zzdy.zzk(t11, (long) (zzaj & 1048575)) & (1 << (zzaj >>> 20))) != 0;
        }
    }

    private final boolean zzb(T t11, int i11, int i12) {
        return zzdy.zzk(t11, (long) (zzaj(i12) & 1048575)) == i11;
    }
}
