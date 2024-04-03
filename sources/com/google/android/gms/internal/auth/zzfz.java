package com.google.android.gms.internal.auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzfz<T> implements zzgh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhi.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfw zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzfk zzl;
    private final zzgy zzm;
    private final zzel zzn;
    private final zzgb zzo;
    private final zzfr zzp;

    private zzfz(int[] iArr, Object[] objArr, int i11, int i12, zzfw zzfw, boolean z11, boolean z12, int[] iArr2, int i13, int i14, zzgb zzgb, zzfk zzfk, zzgy zzgy, zzel zzel, zzfr zzfr, byte[] bArr) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzh = z11;
        this.zzi = iArr2;
        this.zzj = i13;
        this.zzk = i14;
        this.zzo = zzgb;
        this.zzl = zzfk;
        this.zzm = zzgy;
        this.zzn = zzel;
        this.zzg = zzfw;
        this.zzp = zzfr;
    }

    private static Field zzA(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private final void zzB(Object obj, Object obj2, int i11) {
        long zzv = (long) (zzv(i11) & 1048575);
        if (zzG(obj2, i11)) {
            Object zzf2 = zzhi.zzf(obj, zzv);
            Object zzf3 = zzhi.zzf(obj2, zzv);
            if (zzf2 != null && zzf3 != null) {
                zzhi.zzp(obj, zzv, zzez.zzg(zzf2, zzf3));
                zzD(obj, i11);
            } else if (zzf3 != null) {
                zzhi.zzp(obj, zzv, zzf3);
                zzD(obj, i11);
            }
        }
    }

    private final void zzC(Object obj, Object obj2, int i11) {
        Object obj3;
        int zzv = zzv(i11);
        int i12 = this.zzc[i11];
        long j11 = (long) (zzv & 1048575);
        if (zzJ(obj2, i12, i11)) {
            if (zzJ(obj, i12, i11)) {
                obj3 = zzhi.zzf(obj, j11);
            } else {
                obj3 = null;
            }
            Object zzf2 = zzhi.zzf(obj2, j11);
            if (obj3 != null && zzf2 != null) {
                zzhi.zzp(obj, j11, zzez.zzg(obj3, zzf2));
                zzE(obj, i12, i11);
            } else if (zzf2 != null) {
                zzhi.zzp(obj, j11, zzf2);
                zzE(obj, i12, i11);
            }
        }
    }

    private final void zzD(Object obj, int i11) {
        int zzs = zzs(i11);
        long j11 = (long) (1048575 & zzs);
        if (j11 != 1048575) {
            zzhi.zzn(obj, j11, (1 << (zzs >>> 20)) | zzhi.zzc(obj, j11));
        }
    }

    private final void zzE(Object obj, int i11, int i12) {
        zzhi.zzn(obj, (long) (zzs(i12) & 1048575), i11);
    }

    private final boolean zzF(Object obj, Object obj2, int i11) {
        return zzG(obj, i11) == zzG(obj2, i11);
    }

    private final boolean zzG(Object obj, int i11) {
        int zzs = zzs(i11);
        long j11 = (long) (zzs & 1048575);
        if (j11 == 1048575) {
            int zzv = zzv(i11);
            long j12 = (long) (zzv & 1048575);
            switch (zzu(zzv)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzhi.zza(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzhi.zzb(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzhi.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzhi.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzhi.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzhi.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzhi.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzhi.zzt(obj, j12);
                case 8:
                    Object zzf2 = zzhi.zzf(obj, j12);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzee)) {
                        throw new IllegalArgumentException();
                    } else if (!zzee.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzhi.zzf(obj, j12) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzee.zzb.equals(zzhi.zzf(obj, j12))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzhi.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzhi.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzhi.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzhi.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzhi.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzhi.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzhi.zzf(obj, j12) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzhi.zzc(obj, j11) & (1 << (zzs >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean zzH(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzG(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean zzI(Object obj, int i11, zzgh zzgh) {
        return zzgh.zzi(zzhi.zzf(obj, (long) (i11 & 1048575)));
    }

    private final boolean zzJ(Object obj, int i11, int i12) {
        if (zzhi.zzc(obj, (long) (zzs(i12) & 1048575)) == i11) {
            return true;
        }
        return false;
    }

    public static zzgz zzc(Object obj) {
        zzeu zzeu = (zzeu) obj;
        zzgz zzgz = zzeu.zzc;
        if (zzgz != zzgz.zza()) {
            return zzgz;
        }
        zzgz zzc2 = zzgz.zzc();
        zzeu.zzc = zzc2;
        return zzc2;
    }

    public static zzfz zzj(Class cls, zzft zzft, zzgb zzgb, zzfk zzfk, zzgy zzgy, zzel zzel, zzfr zzfr) {
        if (zzft instanceof zzgg) {
            return zzk((zzgg) zzft, zzgb, zzfk, zzgy, zzel, zzfr);
        }
        zzgv zzgv = (zzgv) zzft;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0279  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0391  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.auth.zzfz zzk(com.google.android.gms.internal.auth.zzgg r34, com.google.android.gms.internal.auth.zzgb r35, com.google.android.gms.internal.auth.zzfk r36, com.google.android.gms.internal.auth.zzgy r37, com.google.android.gms.internal.auth.zzel r38, com.google.android.gms.internal.auth.zzfr r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r2
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0057
            int[] r6 = zza
            r8 = r2
            r9 = r8
            r11 = r9
            r12 = r11
            r14 = r12
            r16 = r14
            r13 = r6
            r6 = r16
            goto L_0x0166
        L_0x0057:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0063:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0073
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0063
        L_0x0073:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0076:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0095
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0082:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0092
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0082
        L_0x0092:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0095:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b4
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a1
        L_0x00b1:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b4:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d3
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ef
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00df
        L_0x00ef:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f2:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010e
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fe
        L_0x010e:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0111:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012e
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011d
        L_0x012e:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0132:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x0150
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013e
        L_0x0150:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0155:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0166:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.auth.zzfw r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0184:
            if (r4 >= r1) goto L_0x03cb
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ac
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0194:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a6
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0194
        L_0x01a6:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ae
        L_0x01ac:
            r3 = r24
        L_0x01ae:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01db
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bc:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d5
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bc
        L_0x01d5:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01df
        L_0x01db:
            r28 = r1
            r1 = r24
        L_0x01df:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ed
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ed:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0223
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0204:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021d
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0204
        L_0x021d:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0227
        L_0x0223:
            r32 = r12
            r14 = r27
        L_0x0227:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0248
            r14 = 17
            if (r12 != r14) goto L_0x0234
            goto L_0x0248
        L_0x0234:
            r14 = 12
            if (r12 != r14) goto L_0x0257
            if (r10 != 0) goto L_0x0257
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0255
        L_0x0248:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0255:
            r16 = r14
        L_0x0257:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0261
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0269
        L_0x0261:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzA(r2, r12)
            r17[r1] = r12
        L_0x0269:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r7 = (int) r7
            int r1 = r1 + 1
            r8 = r17[r1]
            boolean r12 = r8 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027c
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x0284
        L_0x027c:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzA(r2, r8)
            r17[r1] = r8
        L_0x0284:
            r1 = r7
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r30 = r0
            r8 = r7
            r29 = r11
            r25 = 1
            r7 = r1
            r1 = 0
            goto L_0x0393
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzA(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r7 = (int) r7
            r8 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r8 != r11) goto L_0x0378
            r8 = 17
            if (r5 > r8) goto L_0x0378
            int r8 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0354
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r11) goto L_0x0350
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r26
            r1 = r1 | r8
            int r26 = r26 + 13
            r8 = r27
            goto L_0x033e
        L_0x0350:
            int r8 = r8 << r26
            r1 = r1 | r8
            goto L_0x0356
        L_0x0354:
            r27 = r8
        L_0x0356:
            int r8 = r6 + r6
            int r26 = r1 / 32
            int r8 = r8 + r26
            r11 = r17[r8]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzA(r2, r11)
            r17[r8] = r11
        L_0x036f:
            r0 = r12
            long r11 = r15.objectFieldOffset(r11)
            int r8 = (int) r11
            int r1 = r1 % 32
            goto L_0x0380
        L_0x0378:
            r30 = r0
            r0 = r12
            r8 = r27
            r27 = r1
            r1 = 0
        L_0x0380:
            r11 = 18
            if (r5 < r11) goto L_0x0391
            r11 = 49
            if (r5 > r11) goto L_0x0391
            int r11 = r23 + 1
            r13[r23] = r7
            r16 = r0
            r23 = r11
            goto L_0x0393
        L_0x0391:
            r16 = r0
        L_0x0393:
            int r0 = r9 + 1
            r31[r9] = r4
            int r4 = r0 + 1
            r9 = r3 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x03a0
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03a1
        L_0x03a0:
            r9 = 0
        L_0x03a1:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a8
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a9
        L_0x03a8:
            r3 = 0
        L_0x03a9:
            r3 = r3 | r9
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r7
            r31[r0] = r3
            int r9 = r4 + 1
            int r0 = r1 << 20
            r0 = r0 | r8
            r31[r4] = r0
            r8 = r14
            r14 = r24
            r4 = r27
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0184
        L_0x03cb:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.auth.zzfz r0 = new com.google.android.gms.internal.auth.zzfz
            r4 = r0
            com.google.android.gms.internal.auth.zzfw r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzk(com.google.android.gms.internal.auth.zzgg, com.google.android.gms.internal.auth.zzgb, com.google.android.gms.internal.auth.zzfk, com.google.android.gms.internal.auth.zzgy, com.google.android.gms.internal.auth.zzel, com.google.android.gms.internal.auth.zzfr):com.google.android.gms.internal.auth.zzfz");
    }

    private static int zzl(Object obj, long j11) {
        return ((Integer) zzhi.zzf(obj, j11)).intValue();
    }

    private final int zzm(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, zzds zzds) throws IOException {
        Unsafe unsafe = zzb;
        Object zzz = zzz(i13);
        Object object = unsafe.getObject(obj, j11);
        if (!((zzfq) object).zze()) {
            zzfq zzb2 = zzfq.zza().zzb();
            zzfr.zza(zzb2, object);
            unsafe.putObject(obj, j11, zzb2);
        }
        zzfp zzfp = (zzfp) zzz;
        throw null;
    }

    private final int zzn(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzds zzds) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i19 = i11;
        int i21 = i13;
        int i22 = i14;
        int i23 = i15;
        long j12 = j11;
        int i24 = i18;
        zzds zzds2 = zzds;
        Unsafe unsafe = zzb;
        long j13 = (long) (this.zzc[i24 + 2] & 1048575);
        switch (i17) {
            case 51:
                if (i23 == 1) {
                    unsafe.putObject(obj2, j12, Double.valueOf(Double.longBitsToDouble(zzdt.zzn(bArr, i11))));
                    unsafe.putInt(obj2, j13, i22);
                    return i19 + 8;
                }
                break;
            case 52:
                if (i23 == 5) {
                    unsafe.putObject(obj2, j12, Float.valueOf(Float.intBitsToFloat(zzdt.zzb(bArr, i11))));
                    unsafe.putInt(obj2, j13, i22);
                    return i19 + 4;
                }
                break;
            case 53:
            case 54:
                if (i23 == 0) {
                    int zzm2 = zzdt.zzm(bArr2, i19, zzds2);
                    unsafe.putObject(obj2, j12, Long.valueOf(zzds2.zzb));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i23 == 0) {
                    int zzj2 = zzdt.zzj(bArr2, i19, zzds2);
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzds2.zza));
                    unsafe.putInt(obj2, j13, i22);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i23 == 1) {
                    unsafe.putObject(obj2, j12, Long.valueOf(zzdt.zzn(bArr, i11)));
                    unsafe.putInt(obj2, j13, i22);
                    return i19 + 8;
                }
                break;
            case 57:
            case 64:
                if (i23 == 5) {
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzdt.zzb(bArr, i11)));
                    unsafe.putInt(obj2, j13, i22);
                    return i19 + 4;
                }
                break;
            case 58:
                if (i23 == 0) {
                    int zzm3 = zzdt.zzm(bArr2, i19, zzds2);
                    unsafe.putObject(obj2, j12, Boolean.valueOf(zzds2.zzb != 0));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm3;
                }
                break;
            case 59:
                if (i23 == 2) {
                    int zzj3 = zzdt.zzj(bArr2, i19, zzds2);
                    int i25 = zzds2.zza;
                    if (i25 == 0) {
                        unsafe.putObject(obj2, j12, "");
                    } else if ((i16 & 536870912) == 0 || zzhm.zzd(bArr2, zzj3, zzj3 + i25)) {
                        unsafe.putObject(obj2, j12, new String(bArr2, zzj3, i25, zzez.zzb));
                        zzj3 += i25;
                    } else {
                        throw zzfa.zzb();
                    }
                    unsafe.putInt(obj2, j13, i22);
                    return zzj3;
                }
                break;
            case 60:
                if (i23 == 2) {
                    int zzd2 = zzdt.zzd(zzy(i24), bArr2, i19, i12, zzds2);
                    Object object = unsafe.getInt(obj2, j13) == i22 ? unsafe.getObject(obj2, j12) : null;
                    if (object == null) {
                        unsafe.putObject(obj2, j12, zzds2.zzc);
                    } else {
                        unsafe.putObject(obj2, j12, zzez.zzg(object, zzds2.zzc));
                    }
                    unsafe.putInt(obj2, j13, i22);
                    return zzd2;
                }
                break;
            case 61:
                if (i23 == 2) {
                    int zza2 = zzdt.zza(bArr2, i19, zzds2);
                    unsafe.putObject(obj2, j12, zzds2.zzc);
                    unsafe.putInt(obj2, j13, i22);
                    return zza2;
                }
                break;
            case 63:
                if (i23 == 0) {
                    int zzj4 = zzdt.zzj(bArr2, i19, zzds2);
                    int i26 = zzds2.zza;
                    zzex zzx = zzx(i24);
                    if (zzx == null || zzx.zza()) {
                        unsafe.putObject(obj2, j12, Integer.valueOf(i26));
                        unsafe.putInt(obj2, j13, i22);
                    } else {
                        zzc(obj).zzf(i21, Long.valueOf((long) i26));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i23 == 0) {
                    int zzj5 = zzdt.zzj(bArr2, i19, zzds2);
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzei.zzb(zzds2.zza)));
                    unsafe.putInt(obj2, j13, i22);
                    return zzj5;
                }
                break;
            case 67:
                if (i23 == 0) {
                    int zzm4 = zzdt.zzm(bArr2, i19, zzds2);
                    unsafe.putObject(obj2, j12, Long.valueOf(zzei.zzc(zzds2.zzb)));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm4;
                }
                break;
            case 68:
                if (i23 == 3) {
                    int zzc2 = zzdt.zzc(zzy(i24), bArr, i11, i12, (i21 & -8) | 4, zzds);
                    Object object2 = unsafe.getInt(obj2, j13) == i22 ? unsafe.getObject(obj2, j12) : null;
                    if (object2 == null) {
                        unsafe.putObject(obj2, j12, zzds2.zzc);
                    } else {
                        unsafe.putObject(obj2, j12, zzez.zzg(object2, zzds2.zzc));
                    }
                    unsafe.putInt(obj2, j13, i22);
                    return zzc2;
                }
                break;
        }
        return i19;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02c5, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02f5, code lost:
        if (r0 != r14) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0317, code lost:
        if (r0 != r14) goto L_0x02ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fa, code lost:
        r6 = r6 | r22;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019e, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d5, code lost:
        r6 = r6 | r22;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x020c, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x020e, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0211, code lost:
        r2 = r8;
        r28 = r9;
        r24 = r10;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02a9, code lost:
        if (r0 != r32) goto L_0x02ab;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzo(java.lang.Object r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.auth.zzds r34) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            sun.misc.Unsafe r9 = zzb
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r16 = 0
            r8 = -1
            r0 = r32
            r1 = r8
            r7 = r10
            r2 = r16
            r6 = r2
        L_0x0019:
            if (r0 >= r13) goto L_0x0341
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.auth.zzdt.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x002e
        L_0x002b:
            r17 = r0
            r4 = r3
        L_0x002e:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x003b
            int r2 = r2 / 3
            int r0 = r15.zzr(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzq(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r8) goto L_0x004d
            r2 = r4
            r21 = r5
            r18 = r8
            r28 = r9
            r24 = r16
            goto L_0x031a
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r8 = zzu(r1)
            r32 = r5
            r5 = r1 & r10
            long r10 = (long) r5
            r5 = 17
            r20 = r10
            if (r8 > r5) goto L_0x021a
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r11 = 1
            int r22 = r11 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x007f
            if (r7 == r5) goto L_0x0077
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
        L_0x0077:
            if (r0 == r5) goto L_0x007e
            long r6 = (long) r0
            int r6 = r9.getInt(r14, r6)
        L_0x007e:
            r7 = r0
        L_0x007f:
            r0 = 5
            switch(r8) {
                case 0: goto L_0x01f4;
                case 1: goto L_0x01da;
                case 2: goto L_0x01b8;
                case 3: goto L_0x01b8;
                case 4: goto L_0x01a1;
                case 5: goto L_0x0182;
                case 6: goto L_0x016c;
                case 7: goto L_0x014c;
                case 8: goto L_0x0129;
                case 9: goto L_0x00ff;
                case 10: goto L_0x00e5;
                case 11: goto L_0x01a1;
                case 12: goto L_0x00d0;
                case 13: goto L_0x016c;
                case 14: goto L_0x0182;
                case 15: goto L_0x00b7;
                case 16: goto L_0x008d;
                default: goto L_0x0083;
            }
        L_0x0083:
            r21 = r32
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            goto L_0x0211
        L_0x008d:
            if (r3 != 0) goto L_0x00ae
            r11 = r34
            r0 = r20
            int r8 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r4, r11)
            long r3 = r11.zzb
            long r19 = com.google.android.gms.internal.auth.zzei.zzc(r3)
            r3 = r0
            r0 = r9
            r1 = r30
            r10 = r2
            r2 = r3
            r21 = r32
            r24 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x01d5
        L_0x00ae:
            r21 = r32
            r11 = r34
            r10 = r2
            r24 = r5
            goto L_0x019e
        L_0x00b7:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r21 = r32
            if (r3 != 0) goto L_0x019e
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.auth.zzei.zzb(r3)
            r9.putInt(r14, r0, r3)
            goto L_0x00fa
        L_0x00d0:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r21 = r32
            if (r3 != 0) goto L_0x019e
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x00fa
        L_0x00e5:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r2 = 2
            r21 = r32
            if (r3 != r2) goto L_0x019e
            int r2 = com.google.android.gms.internal.auth.zzdt.zza(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x00fa:
            r6 = r6 | r22
            r0 = r2
            goto L_0x025d
        L_0x00ff:
            r11 = r34
            r10 = r2
            r24 = r5
            r0 = r20
            r2 = 2
            r21 = r32
            if (r3 != r2) goto L_0x019e
            com.google.android.gms.internal.auth.zzgh r2 = r15.zzy(r10)
            int r2 = com.google.android.gms.internal.auth.zzdt.zzd(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x011f
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
            goto L_0x00fa
        L_0x011f:
            java.lang.Object r4 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzez.zzg(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x00fa
        L_0x0129:
            r11 = r34
            r10 = r2
            r24 = r5
            r25 = r20
            r0 = 2
            r21 = r32
            if (r3 != r0) goto L_0x019e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x013f
            int r0 = com.google.android.gms.internal.auth.zzdt.zzg(r12, r4, r11)
            goto L_0x0143
        L_0x013f:
            int r0 = com.google.android.gms.internal.auth.zzdt.zzh(r12, r4, r11)
        L_0x0143:
            java.lang.Object r1 = r11.zzc
            r2 = r25
            r9.putObject(r14, r2, r1)
            goto L_0x020e
        L_0x014c:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r21 = r32
            if (r3 != 0) goto L_0x019e
            int r0 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r4, r11)
            long r3 = r11.zzb
            r19 = 0
            int r3 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r3 == 0) goto L_0x0165
            r3 = 1
            goto L_0x0167
        L_0x0165:
            r3 = r16
        L_0x0167:
            com.google.android.gms.internal.auth.zzhi.zzk(r14, r1, r3)
            goto L_0x020e
        L_0x016c:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r21 = r32
            if (r3 != r0) goto L_0x019e
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r4)
            r9.putInt(r14, r1, r0)
            int r0 = r4 + 4
            goto L_0x020e
        L_0x0182:
            r11 = r34
            r10 = r2
            r24 = r5
            r1 = r20
            r0 = 1
            r21 = r32
            if (r3 != r0) goto L_0x019e
            long r19 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r4)
            r0 = r9
            r2 = r1
            r1 = r30
            r8 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x020c
        L_0x019e:
            r8 = r4
            goto L_0x0211
        L_0x01a1:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != 0) goto L_0x0211
            int r0 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r4, r1)
            goto L_0x020e
        L_0x01b8:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != 0) goto L_0x0211
            int r8 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r8, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r19 = r2
            r2 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
        L_0x01d5:
            r6 = r6 | r22
            r0 = r8
            goto L_0x025d
        L_0x01da:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r21 = r32
            if (r3 != r0) goto L_0x0211
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r8)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.zzhi.zzm(r14, r4, r0)
            int r0 = r8 + 4
            goto L_0x020e
        L_0x01f4:
            r11 = r34
            r10 = r2
            r8 = r4
            r24 = r5
            r4 = r20
            r0 = 1
            r21 = r32
            if (r3 != r0) goto L_0x0211
            long r0 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r8)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.zzhi.zzl(r14, r4, r0)
        L_0x020c:
            int r0 = r8 + 8
        L_0x020e:
            r6 = r6 | r22
            goto L_0x025d
        L_0x0211:
            r2 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x031a
        L_0x021a:
            r11 = r34
            r10 = r2
            r2 = r4
            r4 = r20
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r21 = r32
            r0 = 27
            if (r8 != r0) goto L_0x0271
            r0 = 2
            if (r3 != r0) goto L_0x0265
            java.lang.Object r0 = r9.getObject(r14, r4)
            com.google.android.gms.internal.auth.zzey r0 = (com.google.android.gms.internal.auth.zzey) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0249
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0241
            r1 = 10
            goto L_0x0242
        L_0x0241:
            int r1 = r1 + r1
        L_0x0242:
            com.google.android.gms.internal.auth.zzey r0 = r0.zzd(r1)
            r9.putObject(r14, r4, r0)
        L_0x0249:
            r5 = r0
            com.google.android.gms.internal.auth.zzgh r0 = r15.zzy(r10)
            r1 = r17
            r3 = r2
            r2 = r31
            r4 = r33
            r8 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.auth.zzdt.zze(r0, r1, r2, r3, r4, r5, r6)
            r6 = r8
        L_0x025d:
            r2 = r10
            r1 = r21
            r10 = r24
            r8 = -1
            goto L_0x0019
        L_0x0265:
            r14 = r2
            r23 = r6
            r15 = r7
            r28 = r9
            r24 = r10
            r18 = -1
            goto L_0x02f8
        L_0x0271:
            r0 = 49
            if (r8 > r0) goto L_0x02c7
            long r0 = (long) r1
            r19 = r0
            r0 = r29
            r1 = r30
            r32 = r2
            r2 = r31
            r22 = r3
            r3 = r32
            r25 = r4
            r4 = r33
            r5 = r17
            r15 = r6
            r6 = r21
            r23 = r15
            r15 = r7
            r7 = r22
            r27 = r8
            r18 = -1
            r8 = r10
            r28 = r9
            r24 = r10
            r9 = r19
            r11 = r27
            r12 = r25
            r14 = r34
            int r0 = r0.zzp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r32
            if (r0 == r14) goto L_0x02c5
        L_0x02ab:
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r7 = r15
            r8 = r18
            r1 = r21
            r6 = r23
            r2 = r24
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r29
            goto L_0x0019
        L_0x02c5:
            r2 = r0
            goto L_0x02f9
        L_0x02c7:
            r14 = r2
            r22 = r3
            r25 = r4
            r23 = r6
            r15 = r7
            r27 = r8
            r28 = r9
            r24 = r10
            r18 = -1
            r0 = 50
            r9 = r27
            if (r9 != r0) goto L_0x02fd
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x02f8
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r24
            r6 = r25
            r8 = r34
            int r0 = r0.zzm(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r14) goto L_0x02c5
            goto L_0x02ab
        L_0x02f8:
            r2 = r14
        L_0x02f9:
            r7 = r15
            r6 = r23
            goto L_0x031a
        L_0x02fd:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r14
            r4 = r33
            r5 = r17
            r6 = r21
            r10 = r25
            r12 = r24
            r13 = r34
            int r0 = r0.zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r14) goto L_0x02c5
            goto L_0x02ab
        L_0x031a:
            com.google.android.gms.internal.auth.zzgz r4 = zzc(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.auth.zzdt.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r8 = r18
            r1 = r21
            r2 = r24
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0341:
            r23 = r6
            r15 = r7
            r28 = r9
            r1 = r10
            if (r15 == r1) goto L_0x0353
            long r1 = (long) r15
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0353:
            r1 = r33
            if (r0 != r1) goto L_0x0358
            return r0
        L_0x0358:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzo(java.lang.Object, byte[], int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzp(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.auth.zzds r29) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r12 = r11.getObject(r1, r9)
            com.google.android.gms.internal.auth.zzey r12 = (com.google.android.gms.internal.auth.zzey) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.auth.zzey r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03e1;
                case 19: goto L_0x0394;
                case 20: goto L_0x0351;
                case 21: goto L_0x0351;
                case 22: goto L_0x0336;
                case 23: goto L_0x02f5;
                case 24: goto L_0x02b4;
                case 25: goto L_0x025a;
                case 26: goto L_0x01a7;
                case 27: goto L_0x018c;
                case 28: goto L_0x0132;
                case 29: goto L_0x0336;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02b4;
                case 32: goto L_0x02f5;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03e1;
                case 36: goto L_0x0394;
                case 37: goto L_0x0351;
                case 38: goto L_0x0351;
                case 39: goto L_0x0336;
                case 40: goto L_0x02f5;
                case 41: goto L_0x02b4;
                case 42: goto L_0x025a;
                case 43: goto L_0x0336;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02b4;
                case 46: goto L_0x02f5;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x044f
            com.google.android.gms.internal.auth.zzgh r1 = r15.zzy(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.auth.zzdt.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.auth.zzei.zzc(r4)
            r12.zze(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.auth.zzei.zzc(r8)
            r12.zze(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.auth.zzei.zzc(r8)
            r12.zze(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzei.zzb(r4)
            r12.zze(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzei.zzb(r4)
            r12.zze(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.auth.zzei.zzb(r4)
            r12.zze(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.auth.zzdt.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.auth.zzdt.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.auth.zzeu r1 = (com.google.android.gms.internal.auth.zzeu) r1
            com.google.android.gms.internal.auth.zzgz r3 = r1.zzc
            com.google.android.gms.internal.auth.zzgz r4 = com.google.android.gms.internal.auth.zzgz.zza()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.auth.zzex r4 = r15.zzx(r8)
            com.google.android.gms.internal.auth.zzgy r5 = r0.zzm
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzgj.zzd(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.auth.zzgz r3 = (com.google.android.gms.internal.auth.zzgz) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.auth.zzee r4 = com.google.android.gms.internal.auth.zzee.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.auth.zzee r6 = com.google.android.gms.internal.auth.zzee.zzk(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.auth.zzee r4 = com.google.android.gms.internal.auth.zzee.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.auth.zzee r6 = com.google.android.gms.internal.auth.zzee.zzk(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.auth.zzgh r1 = r15.zzy(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.auth.zzdt.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzez.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.auth.zzez.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.auth.zzhm.zzd(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzez.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.auth.zzhm.zzd(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.auth.zzez.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzb()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzb()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzc()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.auth.zzdu r12 = (com.google.android.gms.internal.auth.zzdu) r12
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            r5 = r13
            goto L_0x0275
        L_0x0274:
            r5 = r1
        L_0x0275:
            r12.zze(r5)
            goto L_0x0266
        L_0x0279:
            if (r2 != r4) goto L_0x027e
        L_0x027b:
            r1 = r2
            goto L_0x0450
        L_0x027e:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzdu r12 = (com.google.android.gms.internal.auth.zzdu) r12
            int r4 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0293
            r6 = r13
            goto L_0x0294
        L_0x0293:
            r6 = r1
        L_0x0294:
            r12.zze(r6)
        L_0x0297:
            if (r4 >= r5) goto L_0x02b3
            int r6 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = r13
            goto L_0x02af
        L_0x02ae:
            r6 = r1
        L_0x02af:
            r12.zze(r6)
            goto L_0x0297
        L_0x02b3:
            return r4
        L_0x02b4:
            if (r6 != r14) goto L_0x02d4
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r1)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.auth.zzev r12 = (com.google.android.gms.internal.auth.zzev) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r17, r18)
            r12.zze(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r4)
            r12.zze(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r1)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r17, r18)
            r12.zze(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r4)
            r12.zze(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.auth.zzdt.zzf(r3, r4, r12, r7)
            goto L_0x0450
        L_0x033e:
            if (r6 == 0) goto L_0x0342
            goto L_0x044f
        L_0x0342:
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.gms.internal.auth.zzdt.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zze(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.auth.zzfl r12 = (com.google.android.gms.internal.auth.zzfl) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zze(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zze(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.auth.zzeq r12 = (com.google.android.gms.internal.auth.zzeq) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.auth.zzeq r12 = (com.google.android.gms.internal.auth.zzeq) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.auth.zzdt.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.auth.zzej r12 = (com.google.android.gms.internal.auth.zzej) r12
            int r1 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.auth.zzfa r1 = com.google.android.gms.internal.auth.zzfa.zzf()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.auth.zzej r12 = (com.google.android.gms.internal.auth.zzej) r12
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.auth.zzdt.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.auth.zzdt.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x0438
            goto L_0x044e
        L_0x0438:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.auth.zzdt.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x044e:
            return r4
        L_0x044f:
            r1 = r4
        L_0x0450:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzp(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.auth.zzds):int");
    }

    private final int zzq(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzt(i11, 0);
    }

    private final int zzr(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzt(i11, i12);
    }

    private final int zzs(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzt(int i11, int i12) {
        int length = (this.zzc.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int i15 = this.zzc[i14];
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

    private static int zzu(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzv(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzw(Object obj, long j11) {
        return ((Long) zzhi.zzf(obj, j11)).longValue();
    }

    private final zzex zzx(int i11) {
        int i12 = i11 / 3;
        return (zzex) this.zzd[i12 + i12 + 1];
    }

    private final zzgh zzy(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzgh zzgh = (zzgh) this.zzd[i13];
        if (zzgh != null) {
            return zzgh;
        }
        zzgh zzb2 = zzge.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzz(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01d4, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0238, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0239, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x023d
            int r3 = r8.zzv(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzu(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x022a;
                case 1: goto L_0x021f;
                case 2: goto L_0x0214;
                case 3: goto L_0x0209;
                case 4: goto L_0x0202;
                case 5: goto L_0x01f7;
                case 6: goto L_0x01f0;
                case 7: goto L_0x01e5;
                case 8: goto L_0x01d8;
                case 9: goto L_0x01ca;
                case 10: goto L_0x01be;
                case 11: goto L_0x01b6;
                case 12: goto L_0x01ae;
                case 13: goto L_0x01a6;
                case 14: goto L_0x019a;
                case 15: goto L_0x0192;
                case 16: goto L_0x0186;
                case 17: goto L_0x017b;
                case 18: goto L_0x016f;
                case 19: goto L_0x016f;
                case 20: goto L_0x016f;
                case 21: goto L_0x016f;
                case 22: goto L_0x016f;
                case 23: goto L_0x016f;
                case 24: goto L_0x016f;
                case 25: goto L_0x016f;
                case 26: goto L_0x016f;
                case 27: goto L_0x016f;
                case 28: goto L_0x016f;
                case 29: goto L_0x016f;
                case 30: goto L_0x016f;
                case 31: goto L_0x016f;
                case 32: goto L_0x016f;
                case 33: goto L_0x016f;
                case 34: goto L_0x016f;
                case 35: goto L_0x016f;
                case 36: goto L_0x016f;
                case 37: goto L_0x016f;
                case 38: goto L_0x016f;
                case 39: goto L_0x016f;
                case 40: goto L_0x016f;
                case 41: goto L_0x016f;
                case 42: goto L_0x016f;
                case 43: goto L_0x016f;
                case 44: goto L_0x016f;
                case 45: goto L_0x016f;
                case 46: goto L_0x016f;
                case 47: goto L_0x016f;
                case 48: goto L_0x016f;
                case 49: goto L_0x016f;
                case 50: goto L_0x0163;
                case 51: goto L_0x0147;
                case 52: goto L_0x012f;
                case 53: goto L_0x011d;
                case 54: goto L_0x010b;
                case 55: goto L_0x00fd;
                case 56: goto L_0x00eb;
                case 57: goto L_0x00dd;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0239
        L_0x001f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x0031:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0043:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x0051:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0063:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x0071:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x007f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x008d:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x009f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x00b1:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x00c5:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            int r3 = com.google.android.gms.internal.auth.zzez.zza(r3)
            goto L_0x0238
        L_0x00dd:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x00eb:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x00fd:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            int r3 = zzl(r9, r5)
            goto L_0x0238
        L_0x010b:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x011d:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            long r3 = zzw(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x012f:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0238
        L_0x0147:
            boolean r3 = r8.zzJ(r9, r4, r1)
            if (r3 == 0) goto L_0x0239
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.Double r3 = (java.lang.Double) r3
            double r3 = r3.doubleValue()
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0163:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x016f:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x017b:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            if (r3 == 0) goto L_0x01d4
            int r7 = r3.hashCode()
            goto L_0x01d4
        L_0x0186:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0192:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x019a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x01a6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01ae:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01b6:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01be:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x01ca:
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            if (r3 == 0) goto L_0x01d4
            int r7 = r3.hashCode()
        L_0x01d4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0239
        L_0x01d8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzhi.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0238
        L_0x01e5:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.auth.zzhi.zzt(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zza(r3)
            goto L_0x0238
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0202:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.auth.zzhi.zzc(r9, r5)
            goto L_0x0238
        L_0x0209:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x0214:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.auth.zzhi.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
            goto L_0x0238
        L_0x021f:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.auth.zzhi.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0238
        L_0x022a:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.auth.zzhi.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.auth.zzez.zzc(r3)
        L_0x0238:
            int r2 = r2 + r3
        L_0x0239:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x023d:
            int r2 = r2 * 53
            com.google.android.gms.internal.auth.zzgy r0 = r8.zzm
            java.lang.Object r9 = r0.zza(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zza(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v27, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0335, code lost:
        if (r0 != r15) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x034f, code lost:
        r7 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0372, code lost:
        if (r0 != r15) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0398, code lost:
        if (r0 != r15) goto L_0x0337;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0157, code lost:
        r5 = r6 | r23;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e7, code lost:
        r5 = r6 | r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e9, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ea, code lost:
        r3 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x020e, code lost:
        r13 = r3;
        r17 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0279, code lost:
        r0 = r13 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x027b, code lost:
        r5 = r6 | r23;
        r13 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x027f, code lost:
        r3 = r11;
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0282, code lost:
        r2 = r19;
        r6 = r25;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0298, code lost:
        r7 = r34;
        r22 = r6;
        r28 = r10;
        r21 = r11;
        r2 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.auth.zzds r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x03c9
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.auth.zzdt.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            r4 = r1
            r1 = r0
            goto L_0x002c
        L_0x002b:
            r4 = r0
        L_0x002c:
            int r0 = r4 >>> 3
            r8 = r4 & 7
            r7 = 3
            if (r0 <= r2) goto L_0x0039
            int r3 = r3 / r7
            int r2 = r15.zzr(r0, r3)
            goto L_0x003d
        L_0x0039:
            int r2 = r15.zzq(r0)
        L_0x003d:
            r3 = -1
            if (r2 != r3) goto L_0x004f
            r19 = r0
            r2 = r1
            r20 = r3
            r8 = r4
            r22 = r5
            r28 = r10
            r7 = r11
            r21 = r16
            goto L_0x039b
        L_0x004f:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r7 = r3[r19]
            int r11 = zzu(r7)
            r19 = r0
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r7 & r17
            r20 = r1
            long r0 = (long) r0
            r21 = r0
            r0 = 17
            if (r11 > r0) goto L_0x02a3
            int r0 = r2 + 2
            r0 = r3[r0]
            int r3 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r3
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r3
            if (r0 == r6) goto L_0x0088
            r17 = r4
            if (r6 == r3) goto L_0x0080
            long r3 = (long) r6
            r10.putInt(r14, r3, r5)
        L_0x0080:
            long r3 = (long) r0
            int r5 = r10.getInt(r14, r3)
            r25 = r0
            goto L_0x008c
        L_0x0088:
            r17 = r4
            r25 = r6
        L_0x008c:
            r6 = r5
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0261;
                case 1: goto L_0x0247;
                case 2: goto L_0x0229;
                case 3: goto L_0x0229;
                case 4: goto L_0x0213;
                case 5: goto L_0x01ed;
                case 6: goto L_0x01d0;
                case 7: goto L_0x01ae;
                case 8: goto L_0x018b;
                case 9: goto L_0x015c;
                case 10: goto L_0x013f;
                case 11: goto L_0x0213;
                case 12: goto L_0x0109;
                case 13: goto L_0x01d0;
                case 14: goto L_0x01ed;
                case 15: goto L_0x00ec;
                case 16: goto L_0x00bd;
                default: goto L_0x0091;
            }
        L_0x0091:
            r11 = r2
            r13 = r20
            r2 = r21
            r0 = 3
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0298
            com.google.android.gms.internal.auth.zzgh r0 = r15.zzy(r11)
            int r1 = r19 << 3
            r4 = r1 | 4
            r1 = r31
            r7 = r2
            r2 = r13
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.auth.zzdt.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r23
            if (r1 != 0) goto L_0x028a
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r7, r1)
            goto L_0x027b
        L_0x00bd:
            if (r8 != 0) goto L_0x00e1
            r3 = r20
            int r7 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.auth.zzei.zzc(r0)
            r0 = r10
            r1 = r30
            r11 = r2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r2 = r21
            r8 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r23
            r0 = r7
            r1 = r8
            goto L_0x01ea
        L_0x00e1:
            r11 = r2
            r3 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r13 = r3
            goto L_0x0298
        L_0x00ec:
            r11 = r2
            r4 = r17
            r3 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x020e
            int r0 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.auth.zzei.zzb(r1)
            r7 = r21
            r10.putInt(r14, r7, r1)
            goto L_0x01e7
        L_0x0109:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x020e
            int r2 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r3, r9)
            int r3 = r9.zza
            com.google.android.gms.internal.auth.zzex r5 = r15.zzx(r11)
            if (r5 == 0) goto L_0x013b
            boolean r5 = r5.zza()
            if (r5 == 0) goto L_0x012a
            goto L_0x013b
        L_0x012a:
            com.google.android.gms.internal.auth.zzgz r0 = zzc(r30)
            long r7 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0.zzf(r4, r1)
            r0 = r2
            r1 = r4
            r5 = r6
            goto L_0x01ea
        L_0x013b:
            r10.putInt(r14, r0, r3)
            goto L_0x0157
        L_0x013f:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r2 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x020e
            int r2 = com.google.android.gms.internal.auth.zzdt.zza(r12, r3, r9)
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
        L_0x0157:
            r5 = r6 | r23
            r0 = r2
            goto L_0x01e9
        L_0x015c:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r2 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x020e
            com.google.android.gms.internal.auth.zzgh r2 = r15.zzy(r11)
            int r2 = com.google.android.gms.internal.auth.zzdt.zzd(r2, r12, r3, r13, r9)
            r3 = r6 & r23
            if (r3 != 0) goto L_0x017d
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0157
        L_0x017d:
            java.lang.Object r3 = r10.getObject(r14, r0)
            java.lang.Object r5 = r9.zzc
            java.lang.Object r3 = com.google.android.gms.internal.auth.zzez.zzg(r3, r5)
            r10.putObject(r14, r0, r3)
            goto L_0x0157
        L_0x018b:
            r11 = r2
            r4 = r17
            r3 = r20
            r0 = r21
            r2 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r2) goto L_0x020e
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            r2 = r2 & r7
            if (r2 != 0) goto L_0x01a4
            int r2 = com.google.android.gms.internal.auth.zzdt.zzg(r12, r3, r9)
            goto L_0x01a8
        L_0x01a4:
            int r2 = com.google.android.gms.internal.auth.zzdt.zzh(r12, r3, r9)
        L_0x01a8:
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
            goto L_0x0157
        L_0x01ae:
            r11 = r2
            r4 = r17
            r3 = r20
            r1 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x020e
            int r0 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r3, r9)
            long r7 = r9.zzb
            r21 = 0
            int r3 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r3 == 0) goto L_0x01ca
            r3 = 1
            goto L_0x01cc
        L_0x01ca:
            r3 = r16
        L_0x01cc:
            com.google.android.gms.internal.auth.zzhi.zzk(r14, r1, r3)
            goto L_0x01e7
        L_0x01d0:
            r11 = r2
            r4 = r17
            r3 = r20
            r1 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x020e
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r3)
            r10.putInt(r14, r1, r0)
            int r0 = r3 + 4
        L_0x01e7:
            r5 = r6 | r23
        L_0x01e9:
            r1 = r4
        L_0x01ea:
            r3 = r11
            goto L_0x0282
        L_0x01ed:
            r0 = r1
            r11 = r2
            r4 = r17
            r3 = r20
            r1 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x020e
            long r7 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r3)
            r0 = r10
            r5 = r3
            r2 = r1
            r1 = r30
            r17 = r4
            r13 = r5
            r4 = r7
            r0.putLong(r1, r2, r4)
            goto L_0x0279
        L_0x020e:
            r13 = r3
            r17 = r4
            goto L_0x0298
        L_0x0213:
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0298
            int r0 = com.google.android.gms.internal.auth.zzdt.zzj(r12, r13, r9)
            int r1 = r9.zza
            r10.putInt(r14, r2, r1)
            goto L_0x027b
        L_0x0229:
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != 0) goto L_0x0298
            int r7 = com.google.android.gms.internal.auth.zzdt.zzm(r12, r13, r9)
            long r4 = r9.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r5 = r6 | r23
            r13 = r33
            r0 = r7
            goto L_0x027f
        L_0x0247:
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0298
            int r0 = com.google.android.gms.internal.auth.zzdt.zzb(r12, r13)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.auth.zzhi.zzm(r14, r2, r0)
            int r0 = r13 + 4
            goto L_0x027b
        L_0x0261:
            r0 = r1
            r11 = r2
            r13 = r20
            r2 = r21
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            if (r8 != r0) goto L_0x0298
            long r0 = com.google.android.gms.internal.auth.zzdt.zzn(r12, r13)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.auth.zzhi.zzl(r14, r2, r0)
        L_0x0279:
            int r0 = r13 + 8
        L_0x027b:
            r5 = r6 | r23
            r13 = r33
        L_0x027f:
            r3 = r11
            r1 = r17
        L_0x0282:
            r2 = r19
            r6 = r25
            r11 = r34
            goto L_0x001a
        L_0x028a:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.auth.zzez.zzg(r1, r2)
            r10.putObject(r14, r7, r1)
            goto L_0x027b
        L_0x0298:
            r7 = r34
            r22 = r6
            r28 = r10
            r21 = r11
            r2 = r13
            goto L_0x0378
        L_0x02a3:
            r17 = r4
            r13 = r20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r20 = -1
            r4 = r2
            r2 = r21
            r0 = 27
            if (r11 != r0) goto L_0x0305
            r0 = 2
            if (r8 != r0) goto L_0x02fa
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.auth.zzey r0 = (com.google.android.gms.internal.auth.zzey) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02d3
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02cb
            r1 = 10
            goto L_0x02cc
        L_0x02cb:
            int r1 = r1 + r1
        L_0x02cc:
            com.google.android.gms.internal.auth.zzey r0 = r0.zzd(r1)
            r10.putObject(r14, r2, r0)
        L_0x02d3:
            r7 = r0
            com.google.android.gms.internal.auth.zzgh r0 = r15.zzy(r4)
            r1 = r17
            r2 = r31
            r3 = r13
            r21 = r4
            r4 = r33
            r22 = r5
            r5 = r7
            r25 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.auth.zzdt.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r33
            r11 = r34
            r2 = r19
            r3 = r21
            r5 = r22
            r6 = r25
            goto L_0x001a
        L_0x02fa:
            r21 = r4
            r22 = r5
            r25 = r6
            r28 = r10
            r15 = r13
            goto L_0x0375
        L_0x0305:
            r21 = r4
            r22 = r5
            r25 = r6
            r0 = 49
            if (r11 > r0) goto L_0x0353
            long r6 = (long) r7
            r0 = r29
            r1 = r30
            r23 = r2
            r2 = r31
            r3 = r13
            r4 = r33
            r5 = r17
            r26 = r6
            r6 = r19
            r7 = r8
            r15 = r18
            r8 = r21
            r28 = r10
            r9 = r26
            r15 = r34
            r15 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.zzp(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x034f
        L_0x0337:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r1 = r17
            r2 = r19
            r3 = r21
            r5 = r22
            r6 = r25
            goto L_0x03c5
        L_0x034f:
            r7 = r34
            r2 = r0
            goto L_0x0378
        L_0x0353:
            r23 = r2
            r28 = r10
            r15 = r13
            r0 = 50
            if (r11 != r0) goto L_0x037d
            r0 = 2
            if (r8 != r0) goto L_0x0375
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r21
            r6 = r23
            r8 = r35
            int r0 = r0.zzm(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x034f
            goto L_0x0337
        L_0x0375:
            r7 = r34
            r2 = r15
        L_0x0378:
            r8 = r17
            r6 = r25
            goto L_0x039b
        L_0x037d:
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r19
            r9 = r7
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r23
            r12 = r21
            r13 = r35
            int r0 = r0.zzn(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x034f
            goto L_0x0337
        L_0x039b:
            if (r8 != r7) goto L_0x03a4
            if (r7 == 0) goto L_0x03a4
            r0 = r2
            r1 = r8
            r5 = r22
            goto L_0x03d0
        L_0x03a4:
            com.google.android.gms.internal.auth.zzgz r4 = zzc(r30)
            r0 = r8
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.auth.zzdt.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r9 = r35
            r11 = r7
            r1 = r8
            r2 = r19
            r3 = r21
            r5 = r22
        L_0x03c5:
            r10 = r28
            goto L_0x001a
        L_0x03c9:
            r22 = r5
            r25 = r6
            r28 = r10
            r7 = r11
        L_0x03d0:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r2) goto L_0x03de
            long r3 = (long) r6
            r6 = r30
            r8 = r28
            r8.putInt(r6, r3, r5)
            goto L_0x03e0
        L_0x03de:
            r6 = r30
        L_0x03e0:
            r3 = r2
            r2 = r29
            int r4 = r2.zzj
        L_0x03e5:
            int r5 = r2.zzk
            if (r4 >= r5) goto L_0x0411
            int[] r5 = r2.zzi
            r5 = r5[r4]
            int[] r8 = r2.zzc
            r8 = r8[r5]
            int r8 = r2.zzv(r5)
            r8 = r8 & r3
            long r8 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.auth.zzhi.zzf(r6, r8)
            if (r8 != 0) goto L_0x03fe
            goto L_0x0404
        L_0x03fe:
            com.google.android.gms.internal.auth.zzex r9 = r2.zzx(r5)
            if (r9 != 0) goto L_0x0407
        L_0x0404:
            int r4 = r4 + 1
            goto L_0x03e5
        L_0x0407:
            com.google.android.gms.internal.auth.zzfq r8 = (com.google.android.gms.internal.auth.zzfq) r8
            java.lang.Object r0 = r2.zzz(r5)
            com.google.android.gms.internal.auth.zzfp r0 = (com.google.android.gms.internal.auth.zzfp) r0
            r0 = 0
            throw r0
        L_0x0411:
            if (r7 != 0) goto L_0x041d
            r3 = r33
            if (r0 != r3) goto L_0x0418
            goto L_0x0423
        L_0x0418:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        L_0x041d:
            r3 = r33
            if (r0 > r3) goto L_0x0424
            if (r1 != r7) goto L_0x0424
        L_0x0423:
            return r0
        L_0x0424:
            com.google.android.gms.internal.auth.zzfa r0 = com.google.android.gms.internal.auth.zzfa.zzd()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzfz.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzds):int");
    }

    public final Object zzd() {
        return ((zzeu) this.zzg).zzi(4, (Object) null, (Object) null);
    }

    public final void zze(Object obj) {
        int i11;
        int i12 = this.zzj;
        while (true) {
            i11 = this.zzk;
            if (i12 >= i11) {
                break;
            }
            long zzv = (long) (zzv(this.zzi[i12]) & 1048575);
            Object zzf2 = zzhi.zzf(obj, zzv);
            if (zzf2 != null) {
                ((zzfq) zzf2).zzc();
                zzhi.zzp(obj, zzv, zzf2);
            }
            i12++;
        }
        int length = this.zzi.length;
        while (i11 < length) {
            this.zzl.zza(obj, (long) this.zzi[i11]);
            i11++;
        }
        this.zzm.zze(obj);
    }

    public final void zzf(Object obj, Object obj2) {
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzv = zzv(i11);
            long j11 = (long) (1048575 & zzv);
            int i12 = this.zzc[i11];
            switch (zzu(zzv)) {
                case 0:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzl(obj, j11, zzhi.zza(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 1:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzm(obj, j11, zzhi.zzb(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 2:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 3:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 4:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 5:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 6:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 7:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzk(obj, j11, zzhi.zzt(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 8:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 9:
                    zzB(obj, obj2, i11);
                    break;
                case 10:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 11:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 12:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 13:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 14:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 15:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzn(obj, j11, zzhi.zzc(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 16:
                    if (!zzG(obj2, i11)) {
                        break;
                    } else {
                        zzhi.zzo(obj, j11, zzhi.zzd(obj2, j11));
                        zzD(obj, i11);
                        break;
                    }
                case 17:
                    zzB(obj, obj2, i11);
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
                    this.zzl.zzb(obj, obj2, j11);
                    break;
                case 50:
                    zzgj.zzi(this.zzp, obj, obj2, j11);
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
                    if (!zzJ(obj2, i12, i11)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzE(obj, i12, i11);
                        break;
                    }
                case 60:
                    zzC(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzJ(obj2, i12, i11)) {
                        break;
                    } else {
                        zzhi.zzp(obj, j11, zzhi.zzf(obj2, j11));
                        zzE(obj, i12, i11);
                        break;
                    }
                case 68:
                    zzC(obj, obj2, i11);
                    break;
            }
        }
        zzgj.zzf(this.zzm, obj, obj2);
    }

    public final void zzg(Object obj, byte[] bArr, int i11, int i12, zzds zzds) throws IOException {
        if (this.zzh) {
            zzo(obj, bArr, i11, i12, zzds);
        } else {
            zzb(obj, bArr, i11, i12, 0, zzds);
        }
    }

    public final boolean zzh(Object obj, Object obj2) {
        boolean z11;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int zzv = zzv(i11);
            long j11 = (long) (zzv & 1048575);
            switch (zzu(zzv)) {
                case 0:
                    if (zzF(obj, obj2, i11) && Double.doubleToLongBits(zzhi.zza(obj, j11)) == Double.doubleToLongBits(zzhi.zza(obj2, j11))) {
                        continue;
                    }
                case 1:
                    if (zzF(obj, obj2, i11) && Float.floatToIntBits(zzhi.zzb(obj, j11)) == Float.floatToIntBits(zzhi.zzb(obj2, j11))) {
                        continue;
                    }
                case 2:
                    if (zzF(obj, obj2, i11) && zzhi.zzd(obj, j11) == zzhi.zzd(obj2, j11)) {
                        continue;
                    }
                case 3:
                    if (zzF(obj, obj2, i11) && zzhi.zzd(obj, j11) == zzhi.zzd(obj2, j11)) {
                        continue;
                    }
                case 4:
                    if (zzF(obj, obj2, i11) && zzhi.zzc(obj, j11) == zzhi.zzc(obj2, j11)) {
                        continue;
                    }
                case 5:
                    if (zzF(obj, obj2, i11) && zzhi.zzd(obj, j11) == zzhi.zzd(obj2, j11)) {
                        continue;
                    }
                case 6:
                    if (zzF(obj, obj2, i11) && zzhi.zzc(obj, j11) == zzhi.zzc(obj2, j11)) {
                        continue;
                    }
                case 7:
                    if (zzF(obj, obj2, i11) && zzhi.zzt(obj, j11) == zzhi.zzt(obj2, j11)) {
                        continue;
                    }
                case 8:
                    if (zzF(obj, obj2, i11) && zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        continue;
                    }
                case 9:
                    if (zzF(obj, obj2, i11) && zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        continue;
                    }
                case 10:
                    if (zzF(obj, obj2, i11) && zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        continue;
                    }
                case 11:
                    if (zzF(obj, obj2, i11) && zzhi.zzc(obj, j11) == zzhi.zzc(obj2, j11)) {
                        continue;
                    }
                case 12:
                    if (zzF(obj, obj2, i11) && zzhi.zzc(obj, j11) == zzhi.zzc(obj2, j11)) {
                        continue;
                    }
                case 13:
                    if (zzF(obj, obj2, i11) && zzhi.zzc(obj, j11) == zzhi.zzc(obj2, j11)) {
                        continue;
                    }
                case 14:
                    if (zzF(obj, obj2, i11) && zzhi.zzd(obj, j11) == zzhi.zzd(obj2, j11)) {
                        continue;
                    }
                case 15:
                    if (zzF(obj, obj2, i11) && zzhi.zzc(obj, j11) == zzhi.zzc(obj2, j11)) {
                        continue;
                    }
                case 16:
                    if (zzF(obj, obj2, i11) && zzhi.zzd(obj, j11) == zzhi.zzd(obj2, j11)) {
                        continue;
                    }
                case 17:
                    if (zzF(obj, obj2, i11) && zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        continue;
                    }
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
                    z11 = zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11));
                    break;
                case 50:
                    z11 = zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11));
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
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzs = (long) (zzs(i11) & 1048575);
                    if (zzhi.zzc(obj, zzs) == zzhi.zzc(obj2, zzs) && zzgj.zzh(zzhi.zzf(obj, j11), zzhi.zzf(obj2, j11))) {
                        continue;
                    }
            }
            if (!z11) {
                return false;
            }
        }
        if (!this.zzm.zza(obj).equals(this.zzm.zza(obj2))) {
            return false;
        }
        return true;
    }

    public final boolean zzi(Object obj) {
        int i11;
        int i12;
        Object obj2 = obj;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.zzj) {
            int i16 = this.zzi[i15];
            int i17 = this.zzc[i16];
            int zzv = zzv(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i21 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = zzb.getInt(obj2, (long) i19);
                }
                i11 = i14;
                i12 = i19;
            } else {
                i12 = i13;
                i11 = i14;
            }
            if ((268435456 & zzv) != 0 && !zzH(obj, i16, i12, i11, i21)) {
                return false;
            }
            int zzu = zzu(zzv);
            if (zzu != 9 && zzu != 17) {
                if (zzu != 27) {
                    if (zzu == 60 || zzu == 68) {
                        if (zzJ(obj2, i17, i16) && !zzI(obj2, zzv, zzy(i16))) {
                            return false;
                        }
                    } else if (zzu != 49) {
                        if (zzu == 50 && !((zzfq) zzhi.zzf(obj2, (long) (zzv & 1048575))).isEmpty()) {
                            zzfp zzfp = (zzfp) zzz(i16);
                            throw null;
                        }
                    }
                }
                List list = (List) zzhi.zzf(obj2, (long) (zzv & 1048575));
                if (!list.isEmpty()) {
                    zzgh zzy = zzy(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zzy.zzi(list.get(i22))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzH(obj, i16, i12, i11, i21) && !zzI(obj2, zzv, zzy(i16))) {
                return false;
            }
            i15++;
            i13 = i12;
            i14 = i11;
        }
        return true;
    }
}
