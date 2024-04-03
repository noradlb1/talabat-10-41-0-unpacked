package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzis<T> implements zzjc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkg.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzip zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzid zzm;
    private final zzjw zzn;
    private final zzgr zzo;
    private final int zzp;
    private final zziv zzq;
    private final zzik zzr;

    private zzis(int[] iArr, Object[] objArr, int i11, int i12, zzip zzip, int i13, boolean z11, int[] iArr2, int i14, int i15, zziv zziv, zzid zzid, zzjw zzjw, zzgr zzgr, zzik zzik) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = zzip instanceof zzhf;
        this.zzp = i13;
        boolean z12 = false;
        if (zzgr != null && zzgr.zzj(zzip)) {
            z12 = true;
        }
        this.zzh = z12;
        this.zzj = iArr2;
        this.zzk = i14;
        this.zzl = i15;
        this.zzq = zziv;
        this.zzm = zzid;
        this.zzn = zzjw;
        this.zzo = zzgr;
        this.zzg = zzip;
        this.zzr = zzik;
    }

    private static long zzA(Object obj, long j11) {
        return ((Long) zzkg.zzf(obj, j11)).longValue();
    }

    private final zzhj zzB(int i11) {
        int i12 = i11 / 3;
        return (zzhj) this.zzd[i12 + i12 + 1];
    }

    private final zzjc zzC(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzjc zzjc = (zzjc) this.zzd[i13];
        if (zzjc != null) {
            return zzjc;
        }
        zzjc zzb2 = zziy.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzD(Object obj, int i11, Object obj2, zzjw zzjw, Object obj3) {
        int i12 = this.zzc[i11];
        Object zzf2 = zzkg.zzf(obj, (long) (zzz(i11) & 1048575));
        if (zzf2 == null || zzB(i11) == null) {
            return obj2;
        }
        zzij zzij = (zzij) zzf2;
        zzii zzii = (zzii) zzE(i11);
        throw null;
    }

    private final Object zzE(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private final Object zzF(Object obj, int i11) {
        zzjc zzC = zzC(i11);
        int zzz = zzz(i11) & 1048575;
        if (!zzT(obj, i11)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, (long) zzz);
        if (zzW(object)) {
            return object;
        }
        Object zze2 = zzC.zze();
        if (object != null) {
            zzC.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzG(Object obj, int i11, int i12) {
        zzjc zzC = zzC(i12);
        if (!zzX(obj, i11, i12)) {
            return zzC.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzz(i12) & 1048575));
        if (zzW(object)) {
            return object;
        }
        Object zze2 = zzC.zze();
        if (object != null) {
            zzC.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzH(Class cls, String str) {
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

    private static void zzI(Object obj) {
        if (!zzW(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzJ(Object obj, Object obj2, int i11) {
        if (zzT(obj2, i11)) {
            Unsafe unsafe = zzb;
            long zzz = (long) (zzz(i11) & 1048575);
            Object object = unsafe.getObject(obj2, zzz);
            if (object != null) {
                zzjc zzC = zzC(i11);
                if (!zzT(obj, i11)) {
                    if (!zzW(object)) {
                        unsafe.putObject(obj, zzz, object);
                    } else {
                        Object zze2 = zzC.zze();
                        zzC.zzg(zze2, object);
                        unsafe.putObject(obj, zzz, zze2);
                    }
                    zzM(obj, i11);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzz);
                if (!zzW(object2)) {
                    Object zze3 = zzC.zze();
                    zzC.zzg(zze3, object2);
                    unsafe.putObject(obj, zzz, zze3);
                    object2 = zze3;
                }
                zzC.zzg(object2, object);
                return;
            }
            int i12 = this.zzc[i11];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i12 + " is present but null: " + obj3);
        }
    }

    private final void zzK(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzX(obj2, i12, i11)) {
            Unsafe unsafe = zzb;
            long zzz = (long) (zzz(i11) & 1048575);
            Object object = unsafe.getObject(obj2, zzz);
            if (object != null) {
                zzjc zzC = zzC(i11);
                if (!zzX(obj, i12, i11)) {
                    if (!zzW(object)) {
                        unsafe.putObject(obj, zzz, object);
                    } else {
                        Object zze2 = zzC.zze();
                        zzC.zzg(zze2, object);
                        unsafe.putObject(obj, zzz, zze2);
                    }
                    zzN(obj, i12, i11);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzz);
                if (!zzW(object2)) {
                    Object zze3 = zzC.zze();
                    zzC.zzg(zze3, object2);
                    unsafe.putObject(obj, zzz, zze3);
                    object2 = zze3;
                }
                zzC.zzg(object2, object);
                return;
            }
            int i13 = this.zzc[i11];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i13 + " is present but null: " + obj3);
        }
    }

    private final void zzL(Object obj, int i11, zzjb zzjb) throws IOException {
        if (zzS(i11)) {
            zzkg.zzs(obj, (long) (i11 & 1048575), zzjb.zzs());
        } else if (this.zzi) {
            zzkg.zzs(obj, (long) (i11 & 1048575), zzjb.zzr());
        } else {
            zzkg.zzs(obj, (long) (i11 & 1048575), zzjb.zzp());
        }
    }

    private final void zzM(Object obj, int i11) {
        int zzw = zzw(i11);
        long j11 = (long) (1048575 & zzw);
        if (j11 != 1048575) {
            zzkg.zzq(obj, j11, (1 << (zzw >>> 20)) | zzkg.zzc(obj, j11));
        }
    }

    private final void zzN(Object obj, int i11, int i12) {
        zzkg.zzq(obj, (long) (zzw(i12) & 1048575), i11);
    }

    private final void zzO(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, (long) (zzz(i11) & 1048575), obj2);
        zzM(obj, i11);
    }

    private final void zzP(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, (long) (zzz(i12) & 1048575), obj2);
        zzN(obj, i11, i12);
    }

    private final void zzQ(zzko zzko, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzii zzii = (zzii) zzE(i12);
            throw null;
        }
    }

    private final boolean zzR(Object obj, Object obj2, int i11) {
        return zzT(obj, i11) == zzT(obj2, i11);
    }

    private static boolean zzS(int i11) {
        return (i11 & 536870912) != 0;
    }

    private final boolean zzT(Object obj, int i11) {
        int zzw = zzw(i11);
        long j11 = (long) (zzw & 1048575);
        if (j11 == 1048575) {
            int zzz = zzz(i11);
            long j12 = (long) (zzz & 1048575);
            switch (zzy(zzz)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzkg.zza(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzkg.zzb(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzkg.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzkg.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzkg.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzkg.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzkg.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzkg.zzw(obj, j12);
                case 8:
                    Object zzf2 = zzkg.zzf(obj, j12);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzfi)) {
                        throw new IllegalArgumentException();
                    } else if (!zzfi.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzkg.zzf(obj, j12) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzfi.zzb.equals(zzkg.zzf(obj, j12))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzkg.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzkg.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzkg.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzkg.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzkg.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzkg.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzkg.zzf(obj, j12) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((zzkg.zzc(obj, j11) & (1 << (zzw >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final boolean zzU(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzT(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean zzV(Object obj, int i11, zzjc zzjc) {
        return zzjc.zzl(zzkg.zzf(obj, (long) (i11 & 1048575)));
    }

    private static boolean zzW(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzhf) {
            return ((zzhf) obj).zzF();
        }
        return true;
    }

    private final boolean zzX(Object obj, int i11, int i12) {
        if (zzkg.zzc(obj, (long) (zzw(i12) & 1048575)) == i11) {
            return true;
        }
        return false;
    }

    private static boolean zzY(Object obj, long j11) {
        return ((Boolean) zzkg.zzf(obj, j11)).booleanValue();
    }

    private static final void zzZ(int i11, Object obj, zzko zzko) throws IOException {
        if (obj instanceof String) {
            zzko.zzG(i11, (String) obj);
        } else {
            zzko.zzd(i11, (zzfi) obj);
        }
    }

    public static zzjx zzd(Object obj) {
        zzhf zzhf = (zzhf) obj;
        zzjx zzjx = zzhf.zzc;
        if (zzjx != zzjx.zzc()) {
            return zzjx;
        }
        zzjx zzf2 = zzjx.zzf();
        zzhf.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.recaptcha.internal.zzis zzm(java.lang.Class r30, com.google.android.recaptcha.internal.zzim r31, com.google.android.recaptcha.internal.zziv r32, com.google.android.recaptcha.internal.zzid r33, com.google.android.recaptcha.internal.zzjw r34, com.google.android.recaptcha.internal.zzgr r35, com.google.android.recaptcha.internal.zzik r36) {
        /*
            r0 = r31
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzja
            if (r1 == 0) goto L_0x03e0
            com.google.android.recaptcha.internal.zzja r0 = (com.google.android.recaptcha.internal.zzja) r0
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            r3 = 0
            char r4 = r1.charAt(r3)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0025
            r4 = 1
        L_0x001b:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0026
            r4 = r7
            goto L_0x001b
        L_0x0025:
            r7 = 1
        L_0x0026:
            int r4 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0045
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0032:
            int r10 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0042
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r9
            r7 = r7 | r4
            int r9 = r9 + 13
            r4 = r10
            goto L_0x0032
        L_0x0042:
            int r4 = r4 << r9
            r7 = r7 | r4
            r4 = r10
        L_0x0045:
            if (r7 != 0) goto L_0x0057
            int[] r7 = zza
            r11 = r3
            r12 = r11
            r13 = r12
            r14 = r13
            r16 = r14
            r18 = r16
            r17 = r7
            r7 = r18
            goto L_0x0167
        L_0x0057:
            int r7 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x0076
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0063:
            int r10 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0073
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r9
            r4 = r4 | r7
            int r9 = r9 + 13
            r7 = r10
            goto L_0x0063
        L_0x0073:
            int r7 = r7 << r9
            r4 = r4 | r7
            r7 = r10
        L_0x0076:
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r5) goto L_0x0095
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x0082:
            int r11 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x0092
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r10
            r7 = r7 | r9
            int r10 = r10 + 13
            r9 = r11
            goto L_0x0082
        L_0x0092:
            int r9 = r9 << r10
            r7 = r7 | r9
            r9 = r11
        L_0x0095:
            int r10 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r5) goto L_0x00b4
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a1:
            int r12 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00b1
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r10 = r10 << r11
            r9 = r9 | r10
            int r11 = r11 + 13
            r10 = r12
            goto L_0x00a1
        L_0x00b1:
            int r10 = r10 << r11
            r9 = r9 | r10
            r10 = r12
        L_0x00b4:
            int r11 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r5) goto L_0x00d3
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00c0:
            int r13 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00d0
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r10 = r10 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00c0
        L_0x00d0:
            int r11 = r11 << r12
            r10 = r10 | r11
            r11 = r13
        L_0x00d3:
            int r12 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r5) goto L_0x00f2
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00df:
            int r14 = r12 + 1
            char r12 = r1.charAt(r12)
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
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x0111
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fe:
            int r15 = r13 + 1
            char r13 = r1.charAt(r13)
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
            char r13 = r1.charAt(r13)
            if (r13 < r5) goto L_0x0132
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011d:
            int r16 = r14 + 1
            char r14 = r1.charAt(r14)
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
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0155
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013e:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
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
            int r16 = r4 + r4
            int r16 = r16 + r7
            int[] r7 = new int[r13]
            r17 = r7
            r13 = r9
            r18 = r14
            r7 = r4
            r14 = r10
            r4 = r15
        L_0x0167:
            sun.misc.Unsafe r9 = zzb
            java.lang.Object[] r10 = r0.zze()
            com.google.android.recaptcha.internal.zzip r15 = r0.zza()
            java.lang.Class r15 = r15.getClass()
            int r19 = r18 + r12
            int r12 = r11 + r11
            int r11 = r11 * 3
            int[] r11 = new int[r11]
            java.lang.Object[] r12 = new java.lang.Object[r12]
            r20 = r3
            r21 = r20
            r22 = r18
            r23 = r19
        L_0x0187:
            if (r4 >= r2) goto L_0x03bb
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r5) goto L_0x01af
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0197:
            int r25 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01a9
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r25
            goto L_0x0197
        L_0x01a9:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r25
            goto L_0x01b1
        L_0x01af:
            r3 = r24
        L_0x01b1:
            int r24 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r5) goto L_0x01d7
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r8 = r24
            r24 = 13
        L_0x01bf:
            int r25 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r5) goto L_0x01d1
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r24
            r3 = r3 | r8
            int r24 = r24 + 13
            r8 = r25
            goto L_0x01bf
        L_0x01d1:
            int r8 = r8 << r24
            r3 = r3 | r8
            r8 = r25
            goto L_0x01d9
        L_0x01d7:
            r8 = r24
        L_0x01d9:
            r6 = r3 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x01e3
            int r6 = r21 + 1
            r17[r21] = r20
            r21 = r6
        L_0x01e3:
            r6 = r3 & 255(0xff, float:3.57E-43)
            r5 = 51
            if (r6 < r5) goto L_0x0285
            int r5 = r8 + 1
            char r8 = r1.charAt(r8)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x0214
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r28 = 13
        L_0x01fa:
            int r29 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r2) goto L_0x020f
            r2 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r28
            r8 = r8 | r2
            int r28 = r28 + 13
            r5 = r29
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01fa
        L_0x020f:
            int r2 = r5 << r28
            r8 = r8 | r2
            r5 = r29
        L_0x0214:
            int r2 = r6 + -51
            r28 = r5
            r5 = 9
            if (r2 == r5) goto L_0x023b
            r5 = 17
            if (r2 != r5) goto L_0x0221
            goto L_0x023b
        L_0x0221:
            r5 = 12
            if (r2 != r5) goto L_0x0248
            int r2 = r0.zzc()
            r5 = 1
            if (r2 == r5) goto L_0x0230
            r2 = r3 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0248
        L_0x0230:
            int r2 = r20 / 3
            int r2 = r2 + r2
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
            goto L_0x0246
        L_0x023b:
            int r2 = r20 / 3
            int r2 = r2 + r2
            r5 = 1
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
        L_0x0246:
            r16 = r5
        L_0x0248:
            int r8 = r8 + r8
            r2 = r10[r8]
            boolean r5 = r2 instanceof java.lang.reflect.Field
            if (r5 == 0) goto L_0x0252
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            goto L_0x025a
        L_0x0252:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r2 = zzH(r15, r2)
            r10[r8] = r2
        L_0x025a:
            r5 = r13
            r29 = r14
            long r13 = r9.objectFieldOffset(r2)
            int r2 = (int) r13
            int r8 = r8 + 1
            r13 = r10[r8]
            boolean r14 = r13 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x026d
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x0275
        L_0x026d:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzH(r15, r13)
            r10[r8] = r13
        L_0x0275:
            long r13 = r9.objectFieldOffset(r13)
            int r8 = (int) r13
            r27 = r5
            r24 = r8
            r25 = r28
            r8 = 0
            r28 = r1
            goto L_0x0386
        L_0x0285:
            r26 = r2
            r5 = r13
            r29 = r14
            int r2 = r16 + 1
            r13 = r10[r16]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = zzH(r15, r13)
            r14 = 9
            if (r6 == r14) goto L_0x0307
            r14 = 17
            if (r6 != r14) goto L_0x029e
            goto L_0x0307
        L_0x029e:
            r14 = 27
            if (r6 == r14) goto L_0x02f7
            r14 = 49
            if (r6 != r14) goto L_0x02a7
            goto L_0x02f7
        L_0x02a7:
            r14 = 12
            if (r6 == r14) goto L_0x02df
            r14 = 30
            if (r6 == r14) goto L_0x02df
            r14 = 44
            if (r6 != r14) goto L_0x02b4
            goto L_0x02df
        L_0x02b4:
            r14 = 50
            if (r6 != r14) goto L_0x02db
            int r14 = r22 + 1
            r17[r22] = r20
            int r22 = r20 / 3
            int r27 = r2 + 1
            r2 = r10[r2]
            int r22 = r22 + r22
            r12[r22] = r2
            r2 = r3 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x02d7
            int r22 = r22 + 1
            int r2 = r27 + 1
            r27 = r10[r27]
            r12[r22] = r27
            r27 = r5
            r22 = r14
            goto L_0x02dd
        L_0x02d7:
            r22 = r14
            r2 = r27
        L_0x02db:
            r27 = r5
        L_0x02dd:
            r5 = 1
            goto L_0x0314
        L_0x02df:
            int r14 = r0.zzc()
            r27 = r5
            r5 = 1
            if (r14 == r5) goto L_0x02ec
            r14 = r3 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0314
        L_0x02ec:
            int r14 = r20 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r24 = r2 + 1
            r2 = r10[r2]
            r12[r14] = r2
            goto L_0x0304
        L_0x02f7:
            r27 = r5
            r5 = 1
            int r14 = r20 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r24 = r2 + 1
            r2 = r10[r2]
            r12[r14] = r2
        L_0x0304:
            r2 = r24
            goto L_0x0314
        L_0x0307:
            r27 = r5
            r5 = 1
            int r14 = r20 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            java.lang.Class r24 = r13.getType()
            r12[r14] = r24
        L_0x0314:
            long r13 = r9.objectFieldOffset(r13)
            int r13 = (int) r13
            r14 = r3 & 4096(0x1000, float:5.74E-42)
            r24 = 1048575(0xfffff, float:1.469367E-39)
            if (r14 == 0) goto L_0x036f
            r14 = 17
            if (r6 > r14) goto L_0x036f
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r5) goto L_0x0349
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r24 = 13
        L_0x0333:
            int r25 = r14 + 1
            char r14 = r1.charAt(r14)
            if (r14 < r5) goto L_0x0345
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r24
            r8 = r8 | r14
            int r24 = r24 + 13
            r14 = r25
            goto L_0x0333
        L_0x0345:
            int r14 = r14 << r24
            r8 = r8 | r14
            goto L_0x034b
        L_0x0349:
            r25 = r14
        L_0x034b:
            int r14 = r7 + r7
            int r24 = r8 / 32
            int r14 = r14 + r24
            r5 = r10[r14]
            r28 = r1
            boolean r1 = r5 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x035c
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x0364
        L_0x035c:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zzH(r15, r5)
            r10[r14] = r5
        L_0x0364:
            r14 = r2
            long r1 = r9.objectFieldOffset(r5)
            int r1 = (int) r1
            int r8 = r8 % 32
            r24 = r1
            goto L_0x0375
        L_0x036f:
            r28 = r1
            r14 = r2
            r25 = r8
            r8 = 0
        L_0x0375:
            r1 = 18
            if (r6 < r1) goto L_0x0383
            r1 = 49
            if (r6 > r1) goto L_0x0383
            int r1 = r23 + 1
            r17[r23] = r13
            r23 = r1
        L_0x0383:
            r2 = r13
            r16 = r14
        L_0x0386:
            int r1 = r20 + 1
            r11[r20] = r4
            int r4 = r1 + 1
            r5 = r3 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0393
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0394
        L_0x0393:
            r5 = 0
        L_0x0394:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x039b
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039c
        L_0x039b:
            r3 = 0
        L_0x039c:
            int r6 = r6 << 20
            r3 = r3 | r5
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r1] = r2
            int r20 = r4 + 1
            int r1 = r8 << 20
            r1 = r1 | r24
            r11[r4] = r1
            r4 = r25
            r2 = r26
            r13 = r27
            r1 = r28
            r14 = r29
            r3 = 0
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0187
        L_0x03bb:
            r27 = r13
            r29 = r14
            com.google.android.recaptcha.internal.zzis r1 = new com.google.android.recaptcha.internal.zzis
            com.google.android.recaptcha.internal.zzip r14 = r0.zza()
            int r15 = r0.zzc()
            r16 = 0
            r9 = r1
            r10 = r11
            r11 = r12
            r12 = r27
            r13 = r29
            r20 = r32
            r21 = r33
            r22 = r34
            r23 = r35
            r24 = r36
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return r1
        L_0x03e0:
            com.google.android.recaptcha.internal.zzjq r0 = (com.google.android.recaptcha.internal.zzjq) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzm(java.lang.Class, com.google.android.recaptcha.internal.zzim, com.google.android.recaptcha.internal.zziv, com.google.android.recaptcha.internal.zzid, com.google.android.recaptcha.internal.zzjw, com.google.android.recaptcha.internal.zzgr, com.google.android.recaptcha.internal.zzik):com.google.android.recaptcha.internal.zzis");
    }

    private static double zzn(Object obj, long j11) {
        return ((Double) zzkg.zzf(obj, j11)).doubleValue();
    }

    private static float zzo(Object obj, long j11) {
        return ((Float) zzkg.zzf(obj, j11)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x032c, code lost:
        r4 = r4 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x036c, code lost:
        r6 = r6 + r3;
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x03a0, code lost:
        r6 = r6 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x04ae, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0561, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0570, code lost:
        r3 = r3 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0574, code lost:
        r5 = r5 + 3;
        r4 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00f1, code lost:
        r3 = r3 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01af, code lost:
        r3 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01bf, code lost:
        r3 = r3 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzp(java.lang.Object r16) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            sun.misc.Unsafe r2 = zzb
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r4
            r5 = 0
            r6 = 0
            r8 = 0
        L_0x000c:
            int[] r9 = r0.zzc
            int r9 = r9.length
            if (r5 >= r9) goto L_0x057b
            int r9 = r15.zzz(r5)
            int[] r10 = r0.zzc
            r11 = r10[r5]
            int r12 = zzy(r9)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x0035
            int r13 = r5 + 2
            r10 = r10[r13]
            r13 = r10 & r4
            int r10 = r10 >>> 20
            if (r13 == r7) goto L_0x0032
            long r7 = (long) r13
            int r8 = r2.getInt(r1, r7)
            r7 = r13
        L_0x0032:
            int r10 = r14 << r10
            goto L_0x0036
        L_0x0035:
            r10 = 0
        L_0x0036:
            r9 = r9 & r4
            long r3 = (long) r9
            r9 = 63
            switch(r12) {
                case 0: goto L_0x0565;
                case 1: goto L_0x0556;
                case 2: goto L_0x0540;
                case 3: goto L_0x052c;
                case 4: goto L_0x0518;
                case 5: goto L_0x050c;
                case 6: goto L_0x0500;
                case 7: goto L_0x04f2;
                case 8: goto L_0x04c4;
                case 9: goto L_0x04b1;
                case 10: goto L_0x0492;
                case 11: goto L_0x047d;
                case 12: goto L_0x0468;
                case 13: goto L_0x045b;
                case 14: goto L_0x044e;
                case 15: goto L_0x0434;
                case 16: goto L_0x041a;
                case 17: goto L_0x0406;
                case 18: goto L_0x03f8;
                case 19: goto L_0x03ec;
                case 20: goto L_0x03e0;
                case 21: goto L_0x03d4;
                case 22: goto L_0x03c8;
                case 23: goto L_0x03bc;
                case 24: goto L_0x03b0;
                case 25: goto L_0x03a4;
                case 26: goto L_0x0396;
                case 27: goto L_0x0387;
                case 28: goto L_0x037c;
                case 29: goto L_0x0370;
                case 30: goto L_0x0361;
                case 31: goto L_0x0355;
                case 32: goto L_0x0349;
                case 33: goto L_0x033d;
                case 34: goto L_0x0331;
                case 35: goto L_0x0316;
                case 36: goto L_0x02ff;
                case 37: goto L_0x02e8;
                case 38: goto L_0x02d1;
                case 39: goto L_0x02ba;
                case 40: goto L_0x02a2;
                case 41: goto L_0x028a;
                case 42: goto L_0x0270;
                case 43: goto L_0x0258;
                case 44: goto L_0x0240;
                case 45: goto L_0x0228;
                case 46: goto L_0x0210;
                case 47: goto L_0x01f8;
                case 48: goto L_0x01e0;
                case 49: goto L_0x01d0;
                case 50: goto L_0x01c3;
                case 51: goto L_0x01b3;
                case 52: goto L_0x01a3;
                case 53: goto L_0x018d;
                case 54: goto L_0x0177;
                case 55: goto L_0x0161;
                case 56: goto L_0x0154;
                case 57: goto L_0x0147;
                case 58: goto L_0x0138;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f4;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00be;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x0071;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x03a1
        L_0x003f:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.recaptcha.internal.zzip r3 = (com.google.android.recaptcha.internal.zzip) r3
            com.google.android.recaptcha.internal.zzjc r4 = r15.zzC(r5)
            int r3 = com.google.android.recaptcha.internal.zzft.zzt(r11, r3, r4)
            goto L_0x03a0
        L_0x0055:
            boolean r10 = r15.zzX(r1, r11, r5)
            if (r10 == 0) goto L_0x03a1
            long r3 = zzA(r1, r3)
            int r10 = r11 << 3
            long r11 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r10)
            long r3 = r3 ^ r11
            int r3 = com.google.android.recaptcha.internal.zzft.zzz(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x03a1
        L_0x0071:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x032d
        L_0x008c:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x01bf
        L_0x009a:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x01af
        L_0x00a8:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzu(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032d
        L_0x00be:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032d
        L_0x00d4:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.recaptcha.internal.zzfi r3 = (com.google.android.recaptcha.internal.zzfi) r3
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r4)
        L_0x00f1:
            int r3 = r3 + r9
            goto L_0x03a0
        L_0x00f4:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.recaptcha.internal.zzjc r4 = r15.zzC(r5)
            int r3 = com.google.android.recaptcha.internal.zzje.zzn(r11, r3, r4)
            goto L_0x03a0
        L_0x0108:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.recaptcha.internal.zzfi
            if (r4 == 0) goto L_0x012a
            com.google.android.recaptcha.internal.zzfi r3 = (com.google.android.recaptcha.internal.zzfi) r3
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x00f1
        L_0x012a:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzx(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032d
        L_0x0138:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r3 = r3 + r14
            goto L_0x03a0
        L_0x0147:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x01af
        L_0x0154:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x01bf
        L_0x0161:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            int r3 = zzq(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzu(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032d
        L_0x0177:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            long r3 = zzA(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzz(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r9)
            goto L_0x032d
        L_0x018d:
            boolean r9 = r15.zzX(r1, r11, r5)
            if (r9 == 0) goto L_0x03a1
            long r3 = zzA(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzz(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r9)
            goto L_0x032d
        L_0x01a3:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
        L_0x01af:
            int r3 = r3 + 4
            goto L_0x03a0
        L_0x01b3:
            boolean r3 = r15.zzX(r1, r11, r5)
            if (r3 == 0) goto L_0x03a1
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
        L_0x01bf:
            int r3 = r3 + 8
            goto L_0x03a0
        L_0x01c3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r15.zzE(r5)
            com.google.android.recaptcha.internal.zzik.zza(r11, r3, r4)
            goto L_0x03a1
        L_0x01d0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.recaptcha.internal.zzjc r4 = r15.zzC(r5)
            int r3 = com.google.android.recaptcha.internal.zzje.zzi(r11, r3, r4)
            goto L_0x03a0
        L_0x01e0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzs(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x01f8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzq(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x0210:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x0228:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x0240:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzd(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x0258:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzv(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x0270:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r4 = com.google.android.recaptcha.internal.zzje.zza
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x028a:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x02a2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x02ba:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzk(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x02d1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzx(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x02e8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzm(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x02ff:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzf(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x032c
        L_0x0316:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzh(r3)
            if (r3 <= 0) goto L_0x03a1
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
        L_0x032c:
            int r4 = r4 + r9
        L_0x032d:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x03a1
        L_0x0331:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r9 = 0
            int r3 = com.google.android.recaptcha.internal.zzje.zzr(r11, r3, r9)
            goto L_0x036c
        L_0x033d:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzp(r11, r3, r9)
            goto L_0x036c
        L_0x0349:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzg(r11, r3, r9)
            goto L_0x036c
        L_0x0355:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zze(r11, r3, r9)
            goto L_0x036c
        L_0x0361:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzc(r11, r3, r9)
        L_0x036c:
            int r6 = r6 + r3
            r12 = r9
            goto L_0x0574
        L_0x0370:
            r9 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzu(r11, r3, r9)
            goto L_0x03a0
        L_0x037c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzb(r11, r3)
            goto L_0x03a0
        L_0x0387:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.recaptcha.internal.zzjc r4 = r15.zzC(r5)
            int r3 = com.google.android.recaptcha.internal.zzje.zzo(r11, r3, r4)
            goto L_0x03a0
        L_0x0396:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzt(r11, r3)
        L_0x03a0:
            int r6 = r6 + r3
        L_0x03a1:
            r12 = 0
            goto L_0x0574
        L_0x03a4:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            r12 = 0
            int r3 = com.google.android.recaptcha.internal.zzje.zza(r11, r3, r12)
            goto L_0x0403
        L_0x03b0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zze(r11, r3, r12)
            goto L_0x0403
        L_0x03bc:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzg(r11, r3, r12)
            goto L_0x0403
        L_0x03c8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzj(r11, r3, r12)
            goto L_0x0403
        L_0x03d4:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzw(r11, r3, r12)
            goto L_0x0403
        L_0x03e0:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzl(r11, r3, r12)
            goto L_0x0403
        L_0x03ec:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zze(r11, r3, r12)
            goto L_0x0403
        L_0x03f8:
            r12 = 0
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.recaptcha.internal.zzje.zzg(r11, r3, r12)
        L_0x0403:
            int r6 = r6 + r3
            goto L_0x0574
        L_0x0406:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.recaptcha.internal.zzip r3 = (com.google.android.recaptcha.internal.zzip) r3
            com.google.android.recaptcha.internal.zzjc r4 = r15.zzC(r5)
            int r3 = com.google.android.recaptcha.internal.zzft.zzt(r11, r3, r4)
            goto L_0x0403
        L_0x041a:
            r12 = 0
            r10 = r10 & r8
            if (r10 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r10 = r11 << 3
            long r13 = r3 + r3
            long r3 = r3 >> r9
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r10)
            long r3 = r3 ^ r13
            int r3 = com.google.android.recaptcha.internal.zzft.zzz(r3)
            int r9 = r9 + r3
            int r6 = r6 + r9
            goto L_0x0574
        L_0x0434:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r9 = r3 + r3
            int r3 = r3 >> 31
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            r3 = r3 ^ r9
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x0553
        L_0x044e:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x0570
        L_0x045b:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x0561
        L_0x0468:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzu(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0553
        L_0x047d:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0553
        L_0x0492:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.recaptcha.internal.zzfi r3 = (com.google.android.recaptcha.internal.zzfi) r3
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r4)
        L_0x04ae:
            int r3 = r3 + r9
            goto L_0x0403
        L_0x04b1:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.recaptcha.internal.zzjc r4 = r15.zzC(r5)
            int r3 = com.google.android.recaptcha.internal.zzje.zzn(r11, r3, r4)
            goto L_0x0403
        L_0x04c4:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.recaptcha.internal.zzfi
            if (r4 == 0) goto L_0x04e5
            com.google.android.recaptcha.internal.zzfi r3 = (com.google.android.recaptcha.internal.zzfi) r3
            int r4 = r11 << 3
            int r9 = com.google.android.recaptcha.internal.zzft.zzb
            int r3 = r3.zzd()
            int r9 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r9 = r9 + r3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x04ae
        L_0x04e5:
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzx(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0553
        L_0x04f2:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            int r3 = r3 + r14
            goto L_0x0403
        L_0x0500:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x0561
        L_0x050c:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
            goto L_0x0570
        L_0x0518:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            int r3 = r2.getInt(r1, r3)
            int r4 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzu(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0553
        L_0x052c:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzz(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r9)
            goto L_0x0553
        L_0x0540:
            r12 = 0
            r9 = r8 & r10
            if (r9 == 0) goto L_0x0574
            long r3 = r2.getLong(r1, r3)
            int r9 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzz(r3)
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r9)
        L_0x0553:
            int r4 = r4 + r3
            int r6 = r6 + r4
            goto L_0x0574
        L_0x0556:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
        L_0x0561:
            int r3 = r3 + 4
            goto L_0x0403
        L_0x0565:
            r12 = 0
            r3 = r8 & r10
            if (r3 == 0) goto L_0x0574
            int r3 = r11 << 3
            int r3 = com.google.android.recaptcha.internal.zzft.zzy(r3)
        L_0x0570:
            int r3 = r3 + 8
            goto L_0x0403
        L_0x0574:
            int r5 = r5 + 3
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000c
        L_0x057b:
            r12 = 0
            com.google.android.recaptcha.internal.zzjw r2 = r0.zzn
            java.lang.Object r3 = r2.zzd(r1)
            int r2 = r2.zza(r3)
            int r6 = r6 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x05d9
            com.google.android.recaptcha.internal.zzgr r2 = r0.zzo
            com.google.android.recaptcha.internal.zzgv r1 = r2.zzb(r1)
            r3 = r12
        L_0x0592:
            com.google.android.recaptcha.internal.zzjp r2 = r1.zza
            int r2 = r2.zzb()
            if (r3 >= r2) goto L_0x05b2
            com.google.android.recaptcha.internal.zzjp r2 = r1.zza
            java.util.Map$Entry r2 = r2.zzg(r3)
            java.lang.Object r4 = r2.getKey()
            com.google.android.recaptcha.internal.zzgu r4 = (com.google.android.recaptcha.internal.zzgu) r4
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.recaptcha.internal.zzgv.zza(r4, r2)
            int r12 = r12 + r2
            int r3 = r3 + 1
            goto L_0x0592
        L_0x05b2:
            com.google.android.recaptcha.internal.zzjp r1 = r1.zza
            java.lang.Iterable r1 = r1.zzc()
            java.util.Iterator r1 = r1.iterator()
        L_0x05bc:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x05d8
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            com.google.android.recaptcha.internal.zzgu r3 = (com.google.android.recaptcha.internal.zzgu) r3
            java.lang.Object r2 = r2.getValue()
            int r2 = com.google.android.recaptcha.internal.zzgv.zza(r3, r2)
            int r12 = r12 + r2
            goto L_0x05bc
        L_0x05d8:
            int r6 = r6 + r12
        L_0x05d9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzp(java.lang.Object):int");
    }

    private static int zzq(Object obj, long j11) {
        return ((Integer) zzkg.zzf(obj, j11)).intValue();
    }

    private final int zzr(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, zzev zzev) throws IOException {
        Unsafe unsafe = zzb;
        Object zzE = zzE(i13);
        Object object = unsafe.getObject(obj, j11);
        if (zzik.zzb(object)) {
            zzij zzb2 = zzij.zza().zzb();
            zzik.zzc(zzb2, object);
            unsafe.putObject(obj, j11, zzb2);
        }
        zzii zzii = (zzii) zzE;
        throw null;
    }

    private final int zzs(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzev zzev) throws IOException {
        Object obj2 = obj;
        byte[] bArr2 = bArr;
        int i19 = i11;
        int i21 = i13;
        int i22 = i14;
        int i23 = i15;
        long j12 = j11;
        int i24 = i18;
        zzev zzev2 = zzev;
        Unsafe unsafe = zzb;
        long j13 = (long) (this.zzc[i24 + 2] & 1048575);
        switch (i17) {
            case 51:
                if (i23 == 1) {
                    unsafe.putObject(obj2, j12, Double.valueOf(Double.longBitsToDouble(zzew.zzq(bArr, i11))));
                    int i25 = i19 + 8;
                    unsafe.putInt(obj2, j13, i22);
                    return i25;
                }
                break;
            case 52:
                if (i23 == 5) {
                    unsafe.putObject(obj2, j12, Float.valueOf(Float.intBitsToFloat(zzew.zzb(bArr, i11))));
                    int i26 = i19 + 4;
                    unsafe.putInt(obj2, j13, i22);
                    return i26;
                }
                break;
            case 53:
            case 54:
                if (i23 == 0) {
                    int zzm2 = zzew.zzm(bArr2, i19, zzev2);
                    unsafe.putObject(obj2, j12, Long.valueOf(zzev2.zzb));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i23 == 0) {
                    int zzj2 = zzew.zzj(bArr2, i19, zzev2);
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzev2.zza));
                    unsafe.putInt(obj2, j13, i22);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i23 == 1) {
                    unsafe.putObject(obj2, j12, Long.valueOf(zzew.zzq(bArr, i11)));
                    int i27 = i19 + 8;
                    unsafe.putInt(obj2, j13, i22);
                    return i27;
                }
                break;
            case 57:
            case 64:
                if (i23 == 5) {
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzew.zzb(bArr, i11)));
                    int i28 = i19 + 4;
                    unsafe.putInt(obj2, j13, i22);
                    return i28;
                }
                break;
            case 58:
                if (i23 == 0) {
                    int zzm3 = zzew.zzm(bArr2, i19, zzev2);
                    unsafe.putObject(obj2, j12, Boolean.valueOf(zzev2.zzb != 0));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm3;
                }
                break;
            case 59:
                if (i23 == 2) {
                    int zzj3 = zzew.zzj(bArr2, i19, zzev2);
                    int i29 = zzev2.zza;
                    if (i29 == 0) {
                        unsafe.putObject(obj2, j12, "");
                    } else if ((i16 & 536870912) == 0 || zzkl.zzf(bArr2, zzj3, zzj3 + i29)) {
                        unsafe.putObject(obj2, j12, new String(bArr2, zzj3, i29, zzhn.zzb));
                        zzj3 += i29;
                    } else {
                        throw zzhp.zzd();
                    }
                    unsafe.putInt(obj2, j13, i22);
                    return zzj3;
                }
                break;
            case 60:
                if (i23 == 2) {
                    Object zzG = zzG(obj2, i22, i24);
                    int zzo2 = zzew.zzo(zzG, zzC(i24), bArr, i11, i12, zzev);
                    zzP(obj2, i22, i24, zzG);
                    return zzo2;
                }
                break;
            case 61:
                if (i23 == 2) {
                    int zza2 = zzew.zza(bArr2, i19, zzev2);
                    unsafe.putObject(obj2, j12, zzev2.zzc);
                    unsafe.putInt(obj2, j13, i22);
                    return zza2;
                }
                break;
            case 63:
                if (i23 == 0) {
                    int zzj4 = zzew.zzj(bArr2, i19, zzev2);
                    int i31 = zzev2.zza;
                    zzhj zzB = zzB(i24);
                    if (zzB == null || zzB.zza(i31)) {
                        unsafe.putObject(obj2, j12, Integer.valueOf(i31));
                        unsafe.putInt(obj2, j13, i22);
                    } else {
                        zzd(obj).zzj(i21, Long.valueOf((long) i31));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i23 == 0) {
                    int zzj5 = zzew.zzj(bArr2, i19, zzev2);
                    unsafe.putObject(obj2, j12, Integer.valueOf(zzfo.zzF(zzev2.zza)));
                    unsafe.putInt(obj2, j13, i22);
                    return zzj5;
                }
                break;
            case 67:
                if (i23 == 0) {
                    int zzm4 = zzew.zzm(bArr2, i19, zzev2);
                    unsafe.putObject(obj2, j12, Long.valueOf(zzfo.zzG(zzev2.zzb)));
                    unsafe.putInt(obj2, j13, i22);
                    return zzm4;
                }
                break;
            case 68:
                if (i23 == 3) {
                    Object zzG2 = zzG(obj2, i22, i24);
                    int zzn2 = zzew.zzn(zzG2, zzC(i24), bArr, i11, i12, (i21 & -8) | 4, zzev);
                    zzP(obj2, i22, i24, zzG2);
                    return zzn2;
                }
                break;
        }
        return i19;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0444 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01c6  */
    private final int zzt(java.lang.Object r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.recaptcha.internal.zzev r29) throws java.io.IOException {
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
            com.google.android.recaptcha.internal.zzhm r12 = (com.google.android.recaptcha.internal.zzhm) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.recaptcha.internal.zzhm r12 = r12.zzd(r13)
            r11.putObject(r1, r9, r12)
        L_0x0032:
            r9 = 5
            r10 = 0
            r13 = 1
            r14 = 2
            switch(r26) {
                case 18: goto L_0x03d5;
                case 19: goto L_0x0388;
                case 20: goto L_0x0345;
                case 21: goto L_0x0345;
                case 22: goto L_0x032c;
                case 23: goto L_0x02eb;
                case 24: goto L_0x02aa;
                case 25: goto L_0x0251;
                case 26: goto L_0x019e;
                case 27: goto L_0x0185;
                case 28: goto L_0x012b;
                case 29: goto L_0x032c;
                case 30: goto L_0x00fa;
                case 31: goto L_0x02aa;
                case 32: goto L_0x02eb;
                case 33: goto L_0x00ab;
                case 34: goto L_0x005c;
                case 35: goto L_0x03d5;
                case 36: goto L_0x0388;
                case 37: goto L_0x0345;
                case 38: goto L_0x0345;
                case 39: goto L_0x032c;
                case 40: goto L_0x02eb;
                case 41: goto L_0x02aa;
                case 42: goto L_0x0251;
                case 43: goto L_0x032c;
                case 44: goto L_0x00fa;
                case 45: goto L_0x02aa;
                case 46: goto L_0x02eb;
                case 47: goto L_0x00ab;
                case 48: goto L_0x005c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r1 = 3
            if (r6 != r1) goto L_0x0443
            com.google.android.recaptcha.internal.zzjc r1 = r15.zzC(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.recaptcha.internal.zzew.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x0421
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.recaptcha.internal.zzie r12 = (com.google.android.recaptcha.internal.zzie) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.recaptcha.internal.zzew.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.recaptcha.internal.zzfo.zzG(r4)
            r12.zzf(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0444
        L_0x007b:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x0443
            com.google.android.recaptcha.internal.zzie r12 = (com.google.android.recaptcha.internal.zzie) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.recaptcha.internal.zzfo.zzG(r8)
            r12.zzf(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.recaptcha.internal.zzew.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.recaptcha.internal.zzfo.zzG(r8)
            r12.zzf(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.recaptcha.internal.zzhg r12 = (com.google.android.recaptcha.internal.zzhg) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.recaptcha.internal.zzfo.zzF(r4)
            r12.zzg(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0444
        L_0x00ca:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x0443
            com.google.android.recaptcha.internal.zzhg r12 = (com.google.android.recaptcha.internal.zzhg) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.recaptcha.internal.zzfo.zzF(r4)
            r12.zzg(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.recaptcha.internal.zzfo.zzF(r4)
            r12.zzg(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.recaptcha.internal.zzew.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x0443
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.recaptcha.internal.zzew.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.recaptcha.internal.zzhj r3 = r15.zzB(r8)
            r4 = 0
            com.google.android.recaptcha.internal.zzjw r5 = r0.zzn
            r22 = r16
            r23 = r21
            r24 = r12
            r25 = r3
            r26 = r4
            r27 = r5
            com.google.android.recaptcha.internal.zzje.zzA(r22, r23, r24, r25, r26, r27)
        L_0x0128:
            r1 = r2
            goto L_0x0444
        L_0x012b:
            if (r6 != r14) goto L_0x0443
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0180
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x017b
            if (r4 != 0) goto L_0x0141
            com.google.android.recaptcha.internal.zzfi r4 = com.google.android.recaptcha.internal.zzfi.zzb
            r12.add(r4)
            goto L_0x0149
        L_0x0141:
            com.google.android.recaptcha.internal.zzfi r6 = com.google.android.recaptcha.internal.zzfi.zzm(r3, r1, r4)
            r12.add(r6)
        L_0x0148:
            int r1 = r1 + r4
        L_0x0149:
            if (r1 >= r5) goto L_0x017a
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0154
            goto L_0x017a
        L_0x0154:
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0175
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0170
            if (r4 != 0) goto L_0x0168
            com.google.android.recaptcha.internal.zzfi r4 = com.google.android.recaptcha.internal.zzfi.zzb
            r12.add(r4)
            goto L_0x0149
        L_0x0168:
            com.google.android.recaptcha.internal.zzfi r6 = com.google.android.recaptcha.internal.zzfi.zzm(r3, r1, r4)
            r12.add(r6)
            goto L_0x0148
        L_0x0170:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x0175:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzf()
            throw r1
        L_0x017a:
            return r1
        L_0x017b:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x0180:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzf()
            throw r1
        L_0x0185:
            if (r6 != r14) goto L_0x0443
            com.google.android.recaptcha.internal.zzjc r1 = r15.zzC(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.recaptcha.internal.zzew.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x019e:
            if (r6 != r14) goto L_0x0443
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01f1
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01ec
            if (r4 != 0) goto L_0x01b9
            r12.add(r6)
            goto L_0x01c4
        L_0x01b9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.recaptcha.internal.zzhn.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01c3:
            int r1 = r1 + r4
        L_0x01c4:
            if (r1 >= r5) goto L_0x0444
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0444
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01e7
            if (r4 != 0) goto L_0x01dc
            r12.add(r6)
            goto L_0x01c4
        L_0x01dc:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.recaptcha.internal.zzhn.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01c3
        L_0x01e7:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzf()
            throw r1
        L_0x01ec:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzf()
            throw r1
        L_0x01f1:
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024c
            if (r4 != 0) goto L_0x01ff
            r12.add(r6)
            goto L_0x0212
        L_0x01ff:
            int r8 = r1 + r4
            boolean r9 = com.google.android.recaptcha.internal.zzkl.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x0247
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.recaptcha.internal.zzhn.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x0211:
            r1 = r8
        L_0x0212:
            if (r1 >= r5) goto L_0x0444
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0444
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0242
            if (r4 != 0) goto L_0x022a
            r12.add(r6)
            goto L_0x0212
        L_0x022a:
            int r8 = r1 + r4
            boolean r9 = com.google.android.recaptcha.internal.zzkl.zzf(r3, r1, r8)
            if (r9 == 0) goto L_0x023d
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.recaptcha.internal.zzhn.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x0211
        L_0x023d:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzd()
            throw r1
        L_0x0242:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzf()
            throw r1
        L_0x0247:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzd()
            throw r1
        L_0x024c:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzf()
            throw r1
        L_0x0251:
            r1 = 0
            if (r6 != r14) goto L_0x0279
            com.google.android.recaptcha.internal.zzex r12 = (com.google.android.recaptcha.internal.zzex) r12
            int r2 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x025d:
            if (r2 >= r4) goto L_0x0270
            int r2 = com.google.android.recaptcha.internal.zzew.zzm(r3, r2, r7)
            long r5 = r7.zzb
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x026b
            r5 = r13
            goto L_0x026c
        L_0x026b:
            r5 = r1
        L_0x026c:
            r12.zze(r5)
            goto L_0x025d
        L_0x0270:
            if (r2 != r4) goto L_0x0274
            goto L_0x0128
        L_0x0274:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x0279:
            if (r6 != 0) goto L_0x0443
            com.google.android.recaptcha.internal.zzex r12 = (com.google.android.recaptcha.internal.zzex) r12
            int r4 = com.google.android.recaptcha.internal.zzew.zzm(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x0289
            r6 = r13
            goto L_0x028a
        L_0x0289:
            r6 = r1
        L_0x028a:
            r12.zze(r6)
        L_0x028d:
            if (r4 >= r5) goto L_0x02a9
            int r6 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x0298
            goto L_0x02a9
        L_0x0298:
            int r4 = com.google.android.recaptcha.internal.zzew.zzm(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 == 0) goto L_0x02a4
            r6 = r13
            goto L_0x02a5
        L_0x02a4:
            r6 = r1
        L_0x02a5:
            r12.zze(r6)
            goto L_0x028d
        L_0x02a9:
            return r4
        L_0x02aa:
            if (r6 != r14) goto L_0x02ca
            com.google.android.recaptcha.internal.zzhg r12 = (com.google.android.recaptcha.internal.zzhg) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02b5:
            if (r1 >= r2) goto L_0x02c1
            int r4 = com.google.android.recaptcha.internal.zzew.zzb(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 4
            goto L_0x02b5
        L_0x02c1:
            if (r1 != r2) goto L_0x02c5
            goto L_0x0444
        L_0x02c5:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x02ca:
            if (r6 != r9) goto L_0x0443
            com.google.android.recaptcha.internal.zzhg r12 = (com.google.android.recaptcha.internal.zzhg) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzb(r17, r18)
            r12.zzg(r1)
        L_0x02d5:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02ea
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02e2
            goto L_0x02ea
        L_0x02e2:
            int r1 = com.google.android.recaptcha.internal.zzew.zzb(r3, r4)
            r12.zzg(r1)
            goto L_0x02d5
        L_0x02ea:
            return r1
        L_0x02eb:
            if (r6 != r14) goto L_0x030b
            com.google.android.recaptcha.internal.zzie r12 = (com.google.android.recaptcha.internal.zzie) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02f6:
            if (r1 >= r2) goto L_0x0302
            long r4 = com.google.android.recaptcha.internal.zzew.zzq(r3, r1)
            r12.zzf(r4)
            int r1 = r1 + 8
            goto L_0x02f6
        L_0x0302:
            if (r1 != r2) goto L_0x0306
            goto L_0x0444
        L_0x0306:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x030b:
            if (r6 != r13) goto L_0x0443
            com.google.android.recaptcha.internal.zzie r12 = (com.google.android.recaptcha.internal.zzie) r12
            long r8 = com.google.android.recaptcha.internal.zzew.zzq(r17, r18)
            r12.zzf(r8)
        L_0x0316:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x032b
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0323
            goto L_0x032b
        L_0x0323:
            long r8 = com.google.android.recaptcha.internal.zzew.zzq(r3, r4)
            r12.zzf(r8)
            goto L_0x0316
        L_0x032b:
            return r1
        L_0x032c:
            if (r6 != r14) goto L_0x0334
            int r1 = com.google.android.recaptcha.internal.zzew.zzf(r3, r4, r12, r7)
            goto L_0x0444
        L_0x0334:
            if (r6 != 0) goto L_0x0443
            r21 = r17
            r22 = r18
            r23 = r19
            r24 = r12
            r25 = r29
            int r1 = com.google.android.recaptcha.internal.zzew.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0345:
            if (r6 != r14) goto L_0x0365
            com.google.android.recaptcha.internal.zzie r12 = (com.google.android.recaptcha.internal.zzie) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0350:
            if (r1 >= r2) goto L_0x035c
            int r1 = com.google.android.recaptcha.internal.zzew.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzf(r4)
            goto L_0x0350
        L_0x035c:
            if (r1 != r2) goto L_0x0360
            goto L_0x0444
        L_0x0360:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x0365:
            if (r6 != 0) goto L_0x0443
            com.google.android.recaptcha.internal.zzie r12 = (com.google.android.recaptcha.internal.zzie) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
        L_0x0372:
            if (r1 >= r5) goto L_0x0387
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x037d
            goto L_0x0387
        L_0x037d:
            int r1 = com.google.android.recaptcha.internal.zzew.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzf(r8)
            goto L_0x0372
        L_0x0387:
            return r1
        L_0x0388:
            if (r6 != r14) goto L_0x03ac
            com.google.android.recaptcha.internal.zzgx r12 = (com.google.android.recaptcha.internal.zzgx) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0393:
            if (r1 >= r2) goto L_0x03a3
            int r4 = com.google.android.recaptcha.internal.zzew.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x0393
        L_0x03a3:
            if (r1 != r2) goto L_0x03a7
            goto L_0x0444
        L_0x03a7:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x03ac:
            if (r6 != r9) goto L_0x0443
            com.google.android.recaptcha.internal.zzgx r12 = (com.google.android.recaptcha.internal.zzgx) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03bb:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03d4
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03c8
            goto L_0x03d4
        L_0x03c8:
            int r1 = com.google.android.recaptcha.internal.zzew.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03bb
        L_0x03d4:
            return r1
        L_0x03d5:
            if (r6 != r14) goto L_0x03f8
            com.google.android.recaptcha.internal.zzgk r12 = (com.google.android.recaptcha.internal.zzgk) r12
            int r1 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03e0:
            if (r1 >= r2) goto L_0x03f0
            long r4 = com.google.android.recaptcha.internal.zzew.zzq(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03e0
        L_0x03f0:
            if (r1 != r2) goto L_0x03f3
            goto L_0x0444
        L_0x03f3:
            com.google.android.recaptcha.internal.zzhp r1 = com.google.android.recaptcha.internal.zzhp.zzj()
            throw r1
        L_0x03f8:
            if (r6 != r13) goto L_0x0443
            com.google.android.recaptcha.internal.zzgk r12 = (com.google.android.recaptcha.internal.zzgk) r12
            long r8 = com.google.android.recaptcha.internal.zzew.zzq(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0407:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0420
            int r4 = com.google.android.recaptcha.internal.zzew.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0414
            goto L_0x0420
        L_0x0414:
            long r8 = com.google.android.recaptcha.internal.zzew.zzq(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0407
        L_0x0420:
            return r1
        L_0x0421:
            if (r4 >= r5) goto L_0x0442
            int r8 = com.google.android.recaptcha.internal.zzew.zzj(r3, r4, r7)
            int r9 = r7.zza
            if (r2 == r9) goto L_0x042c
            goto L_0x0442
        L_0x042c:
            r21 = r1
            r22 = r17
            r23 = r8
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.recaptcha.internal.zzew.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x0421
        L_0x0442:
            return r4
        L_0x0443:
            r1 = r4
        L_0x0444:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzt(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.recaptcha.internal.zzev):int");
    }

    private final int zzu(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzx(i11, 0);
    }

    private final int zzv(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzx(i11, i12);
    }

    private final int zzw(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzx(int i11, int i12) {
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

    private static int zzy(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzz(int i11) {
        return this.zzc[i11 + 1];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x032a, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0424, code lost:
        r4 = r4 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a6, code lost:
        r4 = r4 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x04f8, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0563, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0573, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0577, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r12) {
        /*
            r11 = this;
            com.google.android.recaptcha.internal.zzkm r0 = com.google.android.recaptcha.internal.zzkm.DOUBLE
            int r0 = r11.zzp
            int r0 = r0 + -1
            if (r0 == 0) goto L_0x0587
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x000d:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x057b
            int r4 = r11.zzz(r2)
            int r5 = zzy(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            com.google.android.recaptcha.internal.zzgw r7 = com.google.android.recaptcha.internal.zzgw.DOUBLE_LIST_PACKED
            int r7 = r7.zza()
            if (r5 < r7) goto L_0x0038
            com.google.android.recaptcha.internal.zzgw r7 = com.google.android.recaptcha.internal.zzgw.SINT64_LIST_PACKED
            int r7 = r7.zza()
            if (r5 > r7) goto L_0x0038
            int[] r7 = r11.zzc
            int r8 = r2 + 2
            r7 = r7[r8]
        L_0x0038:
            long r7 = (long) r4
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0567;
                case 1: goto L_0x0557;
                case 2: goto L_0x0540;
                case 3: goto L_0x052b;
                case 4: goto L_0x0516;
                case 5: goto L_0x0509;
                case 6: goto L_0x04fc;
                case 7: goto L_0x04ec;
                case 8: goto L_0x04bd;
                case 9: goto L_0x04a9;
                case 10: goto L_0x0489;
                case 11: goto L_0x0473;
                case 12: goto L_0x045d;
                case 13: goto L_0x044f;
                case 14: goto L_0x0441;
                case 15: goto L_0x0426;
                case 16: goto L_0x040a;
                case 17: goto L_0x03f5;
                case 18: goto L_0x03e8;
                case 19: goto L_0x03dd;
                case 20: goto L_0x03d2;
                case 21: goto L_0x03c7;
                case 22: goto L_0x03bc;
                case 23: goto L_0x03b1;
                case 24: goto L_0x03a6;
                case 25: goto L_0x039b;
                case 26: goto L_0x0390;
                case 27: goto L_0x0381;
                case 28: goto L_0x0375;
                case 29: goto L_0x0369;
                case 30: goto L_0x035d;
                case 31: goto L_0x0351;
                case 32: goto L_0x0345;
                case 33: goto L_0x0339;
                case 34: goto L_0x032d;
                case 35: goto L_0x0314;
                case 36: goto L_0x02fd;
                case 37: goto L_0x02e6;
                case 38: goto L_0x02cf;
                case 39: goto L_0x02b8;
                case 40: goto L_0x02a0;
                case 41: goto L_0x0288;
                case 42: goto L_0x026e;
                case 43: goto L_0x0256;
                case 44: goto L_0x023e;
                case 45: goto L_0x0226;
                case 46: goto L_0x020e;
                case 47: goto L_0x01f6;
                case 48: goto L_0x01de;
                case 49: goto L_0x01ce;
                case 50: goto L_0x01c1;
                case 51: goto L_0x01b3;
                case 52: goto L_0x01a5;
                case 53: goto L_0x018f;
                case 54: goto L_0x0179;
                case 55: goto L_0x0163;
                case 56: goto L_0x0155;
                case 57: goto L_0x0147;
                case 58: goto L_0x0139;
                case 59: goto L_0x0108;
                case 60: goto L_0x00f4;
                case 61: goto L_0x00d5;
                case 62: goto L_0x00bf;
                case 63: goto L_0x00a9;
                case 64: goto L_0x009b;
                case 65: goto L_0x008d;
                case 66: goto L_0x0072;
                case 67: goto L_0x0056;
                case 68: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0577
        L_0x0040:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            com.google.android.recaptcha.internal.zzip r4 = (com.google.android.recaptcha.internal.zzip) r4
            com.google.android.recaptcha.internal.zzjc r5 = r11.zzC(r2)
            int r4 = com.google.android.recaptcha.internal.zzft.zzt(r6, r4, r5)
            goto L_0x03f2
        L_0x0056:
            boolean r5 = r11.zzX(r12, r6, r2)
            if (r5 == 0) goto L_0x0577
            long r7 = zzA(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.recaptcha.internal.zzft.zzz(r5)
            goto L_0x0424
        L_0x0072:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0554
        L_0x008d:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0573
        L_0x009b:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0563
        L_0x00a9:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzu(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x00bf:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x00d5:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            com.google.android.recaptcha.internal.zzfi r4 = (com.google.android.recaptcha.internal.zzfi) r4
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x04a6
        L_0x00f4:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            com.google.android.recaptcha.internal.zzjc r5 = r11.zzC(r2)
            int r4 = com.google.android.recaptcha.internal.zzje.zzn(r6, r4, r5)
            goto L_0x03f2
        L_0x0108:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.recaptcha.internal.zzfi
            if (r5 == 0) goto L_0x012b
            com.google.android.recaptcha.internal.zzfi r4 = (com.google.android.recaptcha.internal.zzfi) r4
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x04a6
        L_0x012b:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzx(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x0139:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x04f8
        L_0x0147:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0563
        L_0x0155:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0573
        L_0x0163:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = zzq(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzu(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x0179:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = zzA(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzz(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r6)
            goto L_0x0554
        L_0x018f:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = zzA(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzz(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r6)
            goto L_0x0554
        L_0x01a5:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0563
        L_0x01b3:
            boolean r4 = r11.zzX(r12, r6, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0573
        L_0x01c1:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.lang.Object r5 = r11.zzE(r2)
            com.google.android.recaptcha.internal.zzik.zza(r6, r4, r5)
            goto L_0x0577
        L_0x01ce:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.recaptcha.internal.zzjc r5 = r11.zzC(r2)
            int r4 = com.google.android.recaptcha.internal.zzje.zzi(r6, r4, r5)
            goto L_0x03f2
        L_0x01de:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzs(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x01f6:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzq(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x020e:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzh(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x0226:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzf(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x023e:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzd(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x0256:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzv(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x026e:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r5 = com.google.android.recaptcha.internal.zzje.zza
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x0288:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzf(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x02a0:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzh(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x02b8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzk(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x02cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzx(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x02e6:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzm(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x02fd:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzf(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x032a
        L_0x0314:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzh(r4)
            if (r4 <= 0) goto L_0x0577
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
        L_0x032a:
            int r5 = r5 + r6
            goto L_0x0554
        L_0x032d:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzr(r6, r4, r1)
            goto L_0x03f2
        L_0x0339:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzp(r6, r4, r1)
            goto L_0x03f2
        L_0x0345:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzg(r6, r4, r1)
            goto L_0x03f2
        L_0x0351:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zze(r6, r4, r1)
            goto L_0x03f2
        L_0x035d:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzc(r6, r4, r1)
            goto L_0x03f2
        L_0x0369:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzu(r6, r4, r1)
            goto L_0x03f2
        L_0x0375:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzb(r6, r4)
            goto L_0x03f2
        L_0x0381:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.recaptcha.internal.zzjc r5 = r11.zzC(r2)
            int r4 = com.google.android.recaptcha.internal.zzje.zzo(r6, r4, r5)
            goto L_0x03f2
        L_0x0390:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzt(r6, r4)
            goto L_0x03f2
        L_0x039b:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zza(r6, r4, r1)
            goto L_0x03f2
        L_0x03a6:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zze(r6, r4, r1)
            goto L_0x03f2
        L_0x03b1:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzg(r6, r4, r1)
            goto L_0x03f2
        L_0x03bc:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzj(r6, r4, r1)
            goto L_0x03f2
        L_0x03c7:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzw(r6, r4, r1)
            goto L_0x03f2
        L_0x03d2:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzl(r6, r4, r1)
            goto L_0x03f2
        L_0x03dd:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zze(r6, r4, r1)
            goto L_0x03f2
        L_0x03e8:
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.recaptcha.internal.zzje.zzg(r6, r4, r1)
        L_0x03f2:
            int r3 = r3 + r4
            goto L_0x0577
        L_0x03f5:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            com.google.android.recaptcha.internal.zzip r4 = (com.google.android.recaptcha.internal.zzip) r4
            com.google.android.recaptcha.internal.zzjc r5 = r11.zzC(r2)
            int r4 = com.google.android.recaptcha.internal.zzft.zzt(r6, r4, r5)
            goto L_0x03f2
        L_0x040a:
            boolean r5 = r11.zzT(r12, r2)
            if (r5 == 0) goto L_0x0577
            long r7 = com.google.android.recaptcha.internal.zzkg.zzd(r12, r7)
            int r5 = r6 << 3
            long r9 = r7 + r7
            long r6 = r7 >> r4
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            long r5 = r9 ^ r6
            int r5 = com.google.android.recaptcha.internal.zzft.zzz(r5)
        L_0x0424:
            int r4 = r4 + r5
            goto L_0x03f2
        L_0x0426:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.recaptcha.internal.zzkg.zzc(r12, r7)
            int r5 = r6 << 3
            int r6 = r4 + r4
            int r4 = r4 >> 31
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            r4 = r4 ^ r6
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0554
        L_0x0441:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0573
        L_0x044f:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0563
        L_0x045d:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.recaptcha.internal.zzkg.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzu(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x0473:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.recaptcha.internal.zzkg.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x0489:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            com.google.android.recaptcha.internal.zzfi r4 = (com.google.android.recaptcha.internal.zzfi) r4
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r5)
        L_0x04a6:
            int r4 = r4 + r6
            goto L_0x03f2
        L_0x04a9:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            com.google.android.recaptcha.internal.zzjc r5 = r11.zzC(r2)
            int r4 = com.google.android.recaptcha.internal.zzje.zzn(r6, r4, r5)
            goto L_0x03f2
        L_0x04bd:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            java.lang.Object r4 = com.google.android.recaptcha.internal.zzkg.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.recaptcha.internal.zzfi
            if (r5 == 0) goto L_0x04df
            com.google.android.recaptcha.internal.zzfi r4 = (com.google.android.recaptcha.internal.zzfi) r4
            int r5 = r6 << 3
            int r6 = com.google.android.recaptcha.internal.zzft.zzb
            int r4 = r4.zzd()
            int r6 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            int r6 = r6 + r4
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x04a6
        L_0x04df:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzx(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x04ec:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
        L_0x04f8:
            int r4 = r4 + 1
            goto L_0x03f2
        L_0x04fc:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0563
        L_0x0509:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
            goto L_0x0573
        L_0x0516:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = com.google.android.recaptcha.internal.zzkg.zzc(r12, r7)
            int r5 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzu(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r5)
            goto L_0x0554
        L_0x052b:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = com.google.android.recaptcha.internal.zzkg.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzz(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r6)
            goto L_0x0554
        L_0x0540:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            long r4 = com.google.android.recaptcha.internal.zzkg.zzd(r12, r7)
            int r6 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzz(r4)
            int r5 = com.google.android.recaptcha.internal.zzft.zzy(r6)
        L_0x0554:
            int r5 = r5 + r4
            int r3 = r3 + r5
            goto L_0x0577
        L_0x0557:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
        L_0x0563:
            int r4 = r4 + 4
            goto L_0x03f2
        L_0x0567:
            boolean r4 = r11.zzT(r12, r2)
            if (r4 == 0) goto L_0x0577
            int r4 = r6 << 3
            int r4 = com.google.android.recaptcha.internal.zzft.zzy(r4)
        L_0x0573:
            int r4 = r4 + 8
            goto L_0x03f2
        L_0x0577:
            int r2 = r2 + 3
            goto L_0x000d
        L_0x057b:
            com.google.android.recaptcha.internal.zzjw r0 = r11.zzn
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        L_0x0587:
            int r12 = r11.zzp(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zza(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b4, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0210, code lost:
        r3 = (int) (r3 ^ (r3 >>> 32));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0214, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0215, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(java.lang.Object r10) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x0219
            int r3 = r9.zzz(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzy(r3)
            long r5 = (long) r5
            r7 = 37
            r8 = 32
            switch(r3) {
                case 0: goto L_0x0204;
                case 1: goto L_0x01f9;
                case 2: goto L_0x01f0;
                case 3: goto L_0x01e7;
                case 4: goto L_0x01e0;
                case 5: goto L_0x01d7;
                case 6: goto L_0x01d0;
                case 7: goto L_0x01c5;
                case 8: goto L_0x01b8;
                case 9: goto L_0x01aa;
                case 10: goto L_0x019e;
                case 11: goto L_0x0196;
                case 12: goto L_0x018e;
                case 13: goto L_0x0186;
                case 14: goto L_0x017c;
                case 15: goto L_0x0174;
                case 16: goto L_0x016a;
                case 17: goto L_0x015f;
                case 18: goto L_0x0153;
                case 19: goto L_0x0153;
                case 20: goto L_0x0153;
                case 21: goto L_0x0153;
                case 22: goto L_0x0153;
                case 23: goto L_0x0153;
                case 24: goto L_0x0153;
                case 25: goto L_0x0153;
                case 26: goto L_0x0153;
                case 27: goto L_0x0153;
                case 28: goto L_0x0153;
                case 29: goto L_0x0153;
                case 30: goto L_0x0153;
                case 31: goto L_0x0153;
                case 32: goto L_0x0153;
                case 33: goto L_0x0153;
                case 34: goto L_0x0153;
                case 35: goto L_0x0153;
                case 36: goto L_0x0153;
                case 37: goto L_0x0153;
                case 38: goto L_0x0153;
                case 39: goto L_0x0153;
                case 40: goto L_0x0153;
                case 41: goto L_0x0153;
                case 42: goto L_0x0153;
                case 43: goto L_0x0153;
                case 44: goto L_0x0153;
                case 45: goto L_0x0153;
                case 46: goto L_0x0153;
                case 47: goto L_0x0153;
                case 48: goto L_0x0153;
                case 49: goto L_0x0153;
                case 50: goto L_0x0147;
                case 51: goto L_0x0133;
                case 52: goto L_0x0121;
                case 53: goto L_0x0111;
                case 54: goto L_0x0101;
                case 55: goto L_0x00f3;
                case 56: goto L_0x00e3;
                case 57: goto L_0x00d5;
                case 58: goto L_0x00c3;
                case 59: goto L_0x00af;
                case 60: goto L_0x009d;
                case 61: goto L_0x008b;
                case 62: goto L_0x007d;
                case 63: goto L_0x006f;
                case 64: goto L_0x0061;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0033;
                case 68: goto L_0x0021;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x0215
        L_0x0021:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x0033:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0043:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0214
        L_0x0051:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0061:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0214
        L_0x006f:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0214
        L_0x007d:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0214
        L_0x008b:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x009d:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x00af:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x00c3:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            boolean r3 = zzY(r10, r5)
            int r3 = com.google.android.recaptcha.internal.zzhn.zza(r3)
            goto L_0x0214
        L_0x00d5:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0214
        L_0x00e3:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x00f3:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzq(r10, r5)
            goto L_0x0214
        L_0x0101:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0111:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzA(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0121:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            float r3 = zzo(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0214
        L_0x0133:
            boolean r3 = r9.zzX(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            double r3 = zzn(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x015f:
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b4
            int r7 = r3.hashCode()
            goto L_0x01b4
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.recaptcha.internal.zzkg.zzd(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.recaptcha.internal.zzkg.zzc(r10, r5)
            goto L_0x0214
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.recaptcha.internal.zzkg.zzd(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.recaptcha.internal.zzkg.zzc(r10, r5)
            goto L_0x0214
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.recaptcha.internal.zzkg.zzc(r10, r5)
            goto L_0x0214
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.recaptcha.internal.zzkg.zzc(r10, r5)
            goto L_0x0214
        L_0x019e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x01aa:
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b4
            int r7 = r3.hashCode()
        L_0x01b4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0215
        L_0x01b8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.recaptcha.internal.zzkg.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x01c5:
            int r2 = r2 * 53
            boolean r3 = com.google.android.recaptcha.internal.zzkg.zzw(r10, r5)
            int r3 = com.google.android.recaptcha.internal.zzhn.zza(r3)
            goto L_0x0214
        L_0x01d0:
            int r2 = r2 * 53
            int r3 = com.google.android.recaptcha.internal.zzkg.zzc(r10, r5)
            goto L_0x0214
        L_0x01d7:
            int r2 = r2 * 53
            long r3 = com.google.android.recaptcha.internal.zzkg.zzd(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x01e0:
            int r2 = r2 * 53
            int r3 = com.google.android.recaptcha.internal.zzkg.zzc(r10, r5)
            goto L_0x0214
        L_0x01e7:
            int r2 = r2 * 53
            long r3 = com.google.android.recaptcha.internal.zzkg.zzd(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x01f0:
            int r2 = r2 * 53
            long r3 = com.google.android.recaptcha.internal.zzkg.zzd(r10, r5)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
            goto L_0x0210
        L_0x01f9:
            int r2 = r2 * 53
            float r3 = com.google.android.recaptcha.internal.zzkg.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0214
        L_0x0204:
            int r2 = r2 * 53
            double r3 = com.google.android.recaptcha.internal.zzkg.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.recaptcha.internal.zzhn.zzd
        L_0x0210:
            long r5 = r3 >>> r8
            long r3 = r3 ^ r5
            int r3 = (int) r3
        L_0x0214:
            int r2 = r2 + r3
        L_0x0215:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x0219:
            int r2 = r2 * 53
            com.google.android.recaptcha.internal.zzjw r0 = r9.zzn
            java.lang.Object r0 = r0.zzd(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x0239
            int r2 = r2 * 53
            com.google.android.recaptcha.internal.zzgr r0 = r9.zzo
            com.google.android.recaptcha.internal.zzgv r10 = r0.zzb(r10)
            com.google.android.recaptcha.internal.zzjp r10 = r10.zza
            int r10 = r10.hashCode()
            int r2 = r2 + r10
        L_0x0239:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v31, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x032c, code lost:
        if (r0 != r15) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x034a, code lost:
        r8 = r36;
        r7 = r38;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0374, code lost:
        if (r0 != r15) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x039a, code lost:
        if (r0 != r15) goto L_0x032e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0490, code lost:
        r2 = r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x04a1, code lost:
        r2 = r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a3, code lost:
        r1.zzi(r0.zzb, r5);
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x016b, code lost:
        r0 = r13 | r7;
        r13 = r37;
        r3 = r6;
        r1 = r11;
        r6 = r26;
        r8 = -1;
        r11 = r38;
        r32 = r5;
        r5 = r0;
        r0 = r2;
        r2 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x017e, code lost:
        r12 = r5;
        r36 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0251, code lost:
        r0 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0254, code lost:
        r12 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0255, code lost:
        r36 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0257, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x026e, code lost:
        r5 = r13 | r7;
        r13 = r37;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0273, code lost:
        r1 = r11;
        r3 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0276, code lost:
        r6 = r26;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0279, code lost:
        r11 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x027d, code lost:
        r12 = r6;
        r36 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0280, code lost:
        r8 = r36;
        r7 = r38;
        r24 = r2;
        r2 = r3;
        r31 = r10;
        r21 = r11;
        r25 = r12;
        r17 = r13;
        r6 = r26;
        r20 = -1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.recaptcha.internal.zzev r39) throws java.io.IOException {
        /*
            r33 = this;
            r15 = r33
            r14 = r34
            r12 = r35
            r13 = r37
            r11 = r38
            r9 = r39
            zzI(r34)
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r8 = -1
            r0 = r36
            r1 = r8
            r2 = r16
            r3 = r2
            r5 = r3
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x04df
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002f
            int r0 = com.google.android.recaptcha.internal.zzew.zzk(r0, r12, r3, r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x0030
        L_0x002f:
            r4 = r0
        L_0x0030:
            int r0 = r4 >>> 3
            r7 = 3
            if (r0 <= r1) goto L_0x003b
            int r2 = r2 / r7
            int r1 = r15.zzv(r0, r2)
            goto L_0x003f
        L_0x003b:
            int r1 = r15.zzu(r0)
        L_0x003f:
            r2 = r1
            r18 = 0
            if (r2 != r8) goto L_0x0055
            r21 = r0
            r2 = r3
            r17 = r5
            r20 = r8
            r31 = r10
            r7 = r11
            r25 = r16
            r24 = 1
            r8 = r4
            goto L_0x039d
        L_0x0055:
            r8 = r4 & 7
            int[] r7 = r15.zzc
            int r21 = r2 + 1
            r1 = r7[r21]
            int r11 = zzy(r1)
            r17 = r0
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r1 & r13
            long r13 = (long) r0
            r0 = 17
            r23 = r4
            r4 = 2
            if (r11 > r0) goto L_0x0295
            int r0 = r2 + 2
            r0 = r7[r0]
            int r7 = r0 >>> 20
            r22 = 1
            int r7 = r22 << r7
            r24 = r13
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r13
            if (r0 == r6) goto L_0x0097
            if (r6 == r13) goto L_0x008b
            long r13 = (long) r6
            r6 = r34
            r10.putInt(r6, r13, r5)
            goto L_0x008d
        L_0x008b:
            r6 = r34
        L_0x008d:
            long r13 = (long) r0
            int r5 = r10.getInt(r6, r13)
            r26 = r0
            r13 = r5
            r14 = r6
            goto L_0x009c
        L_0x0097:
            r14 = r34
            r13 = r5
            r26 = r6
        L_0x009c:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0259;
                case 1: goto L_0x023f;
                case 2: goto L_0x0220;
                case 3: goto L_0x0220;
                case 4: goto L_0x020f;
                case 5: goto L_0x01f2;
                case 6: goto L_0x01e2;
                case 7: goto L_0x01c8;
                case 8: goto L_0x01aa;
                case 9: goto L_0x0183;
                case 10: goto L_0x0159;
                case 11: goto L_0x020f;
                case 12: goto L_0x0121;
                case 13: goto L_0x01e2;
                case 14: goto L_0x01f2;
                case 15: goto L_0x00fe;
                case 16: goto L_0x00d3;
                default: goto L_0x00a0;
            }
        L_0x00a0:
            r6 = r2
            r11 = r17
            r0 = 3
            r2 = 1
            if (r8 != r0) goto L_0x027d
            java.lang.Object r8 = r15.zzF(r14, r6)
            int r0 = r11 << 3
            r5 = r0 | 4
            com.google.android.recaptcha.internal.zzjc r1 = r15.zzC(r6)
            r0 = r8
            r2 = r35
            r4 = r37
            r12 = r6
            r36 = r23
            r6 = r39
            int r0 = com.google.android.recaptcha.internal.zzew.zzn(r0, r1, r2, r3, r4, r5, r6)
            r15.zzO(r14, r12, r8)
            r5 = r13 | r7
            r3 = r36
            r13 = r37
            r1 = r11
            r2 = r12
            r6 = r26
            r8 = -1
            r12 = r35
            goto L_0x0279
        L_0x00d3:
            if (r8 != 0) goto L_0x00f9
            int r6 = com.google.android.recaptcha.internal.zzew.zzm(r12, r3, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.recaptcha.internal.zzfo.zzG(r0)
            r11 = r17
            r0 = r10
            r1 = r34
            r8 = r2
            r2 = r24
            r36 = r6
            r6 = r23
            r0.putLong(r1, r2, r4)
            r5 = r13 | r7
            r0 = r36
            r13 = r37
            r3 = r6
            r2 = r8
            r1 = r11
            goto L_0x0276
        L_0x00f9:
            r11 = r17
            r12 = r2
            goto L_0x0255
        L_0x00fe:
            r5 = r2
            r11 = r17
            r6 = r23
            if (r8 != 0) goto L_0x017e
            int r0 = com.google.android.recaptcha.internal.zzew.zzj(r12, r3, r9)
            int r1 = r9.zza
            int r1 = com.google.android.recaptcha.internal.zzfo.zzF(r1)
            r2 = r24
            r10.putInt(r14, r2, r1)
            r1 = r13 | r7
            r13 = r37
            r2 = r5
            r3 = r6
            r6 = r26
            r8 = -1
            r5 = r1
            r1 = r11
            goto L_0x0279
        L_0x0121:
            r5 = r2
            r11 = r17
            r6 = r23
            r0 = r24
            if (r8 != 0) goto L_0x017e
            int r2 = com.google.android.recaptcha.internal.zzew.zzj(r12, r3, r9)
            int r3 = r9.zza
            com.google.android.recaptcha.internal.zzhj r4 = r15.zzB(r5)
            if (r4 == 0) goto L_0x0155
            boolean r4 = r4.zza(r3)
            if (r4 == 0) goto L_0x013d
            goto L_0x0155
        L_0x013d:
            com.google.android.recaptcha.internal.zzjx r0 = zzd(r34)
            long r3 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r0.zzj(r6, r1)
            r0 = r2
            r2 = r5
            r3 = r6
            r1 = r11
            r5 = r13
            r6 = r26
            r8 = -1
            r13 = r37
            goto L_0x0279
        L_0x0155:
            r10.putInt(r14, r0, r3)
            goto L_0x016b
        L_0x0159:
            r5 = r2
            r11 = r17
            r6 = r23
            r0 = r24
            if (r8 != r4) goto L_0x017e
            int r2 = com.google.android.recaptcha.internal.zzew.zza(r12, r3, r9)
            java.lang.Object r3 = r9.zzc
            r10.putObject(r14, r0, r3)
        L_0x016b:
            r0 = r13 | r7
            r13 = r37
            r3 = r6
            r1 = r11
            r6 = r26
            r8 = -1
            r11 = r38
            r32 = r5
            r5 = r0
            r0 = r2
            r2 = r32
            goto L_0x001e
        L_0x017e:
            r12 = r5
            r36 = r6
            goto L_0x0257
        L_0x0183:
            r5 = r2
            r11 = r17
            r6 = r23
            if (r8 != r4) goto L_0x01a5
            java.lang.Object r8 = r15.zzF(r14, r5)
            com.google.android.recaptcha.internal.zzjc r1 = r15.zzC(r5)
            r0 = r8
            r2 = r35
            r4 = r37
            r23 = r6
            r6 = r5
            r5 = r39
            int r0 = com.google.android.recaptcha.internal.zzew.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r6, r8)
            goto L_0x026e
        L_0x01a5:
            r23 = r6
            r12 = r5
            goto L_0x0255
        L_0x01aa:
            r6 = r2
            r11 = r17
            r27 = r24
            if (r8 != r4) goto L_0x0254
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01bb
            int r0 = com.google.android.recaptcha.internal.zzew.zzg(r12, r3, r9)
            goto L_0x01bf
        L_0x01bb:
            int r0 = com.google.android.recaptcha.internal.zzew.zzh(r12, r3, r9)
        L_0x01bf:
            java.lang.Object r1 = r9.zzc
            r4 = r27
            r10.putObject(r14, r4, r1)
            goto L_0x026e
        L_0x01c8:
            r6 = r2
            r11 = r17
            r4 = r24
            if (r8 != 0) goto L_0x0254
            int r0 = com.google.android.recaptcha.internal.zzew.zzm(r12, r3, r9)
            long r1 = r9.zzb
            int r1 = (r1 > r18 ? 1 : (r1 == r18 ? 0 : -1))
            if (r1 == 0) goto L_0x01db
            r1 = 1
            goto L_0x01dd
        L_0x01db:
            r1 = r16
        L_0x01dd:
            com.google.android.recaptcha.internal.zzkg.zzm(r14, r4, r1)
            goto L_0x026e
        L_0x01e2:
            r6 = r2
            r11 = r17
            r4 = r24
            if (r8 != r0) goto L_0x0254
            int r0 = com.google.android.recaptcha.internal.zzew.zzb(r12, r3)
            r10.putInt(r14, r4, r0)
            goto L_0x0251
        L_0x01f2:
            r6 = r2
            r11 = r17
            r4 = r24
            r0 = 1
            if (r8 != r0) goto L_0x020c
            long r17 = com.google.android.recaptcha.internal.zzew.zzq(r12, r3)
            r0 = r10
            r1 = r34
            r8 = r3
            r2 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x026e
        L_0x020c:
            r2 = r0
            goto L_0x027d
        L_0x020f:
            r6 = r2
            r11 = r17
            r4 = r24
            if (r8 != 0) goto L_0x0254
            int r0 = com.google.android.recaptcha.internal.zzew.zzj(r12, r3, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x026e
        L_0x0220:
            r6 = r2
            r11 = r17
            r4 = r24
            if (r8 != 0) goto L_0x0254
            int r8 = com.google.android.recaptcha.internal.zzew.zzm(r12, r3, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r34
            r17 = r2
            r2 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r13 | r7
            r13 = r37
            r2 = r6
            r0 = r8
            goto L_0x0273
        L_0x023f:
            r6 = r2
            r11 = r17
            r4 = r24
            if (r8 != r0) goto L_0x0254
            int r0 = com.google.android.recaptcha.internal.zzew.zzb(r12, r3)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.recaptcha.internal.zzkg.zzp(r14, r4, r0)
        L_0x0251:
            int r0 = r3 + 4
            goto L_0x026e
        L_0x0254:
            r12 = r6
        L_0x0255:
            r36 = r23
        L_0x0257:
            r2 = 1
            goto L_0x0280
        L_0x0259:
            r6 = r2
            r11 = r17
            r4 = r24
            r2 = 1
            if (r8 != r2) goto L_0x027d
            long r0 = com.google.android.recaptcha.internal.zzew.zzq(r12, r3)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.recaptcha.internal.zzkg.zzo(r14, r4, r0)
            int r0 = r3 + 8
        L_0x026e:
            r5 = r13 | r7
            r13 = r37
            r2 = r6
        L_0x0273:
            r1 = r11
            r3 = r23
        L_0x0276:
            r6 = r26
            r8 = -1
        L_0x0279:
            r11 = r38
            goto L_0x001e
        L_0x027d:
            r12 = r6
            r36 = r23
        L_0x0280:
            r8 = r36
            r7 = r38
            r24 = r2
            r2 = r3
            r31 = r10
            r21 = r11
            r25 = r12
            r17 = r13
            r6 = r26
            r20 = -1
            goto L_0x039d
        L_0x0295:
            r12 = r2
            r29 = r13
            r13 = r17
            r36 = r23
            r2 = 1
            r14 = r34
            r0 = 27
            if (r11 != r0) goto L_0x02fc
            if (r8 != r4) goto L_0x02eb
            r0 = r29
            java.lang.Object r2 = r10.getObject(r14, r0)
            com.google.android.recaptcha.internal.zzhm r2 = (com.google.android.recaptcha.internal.zzhm) r2
            boolean r4 = r2.zzc()
            if (r4 != 0) goto L_0x02c4
            int r4 = r2.size()
            if (r4 != 0) goto L_0x02bc
            r4 = 10
            goto L_0x02bd
        L_0x02bc:
            int r4 = r4 + r4
        L_0x02bd:
            com.google.android.recaptcha.internal.zzhm r2 = r2.zzd(r4)
            r10.putObject(r14, r0, r2)
        L_0x02c4:
            r7 = r2
            com.google.android.recaptcha.internal.zzjc r0 = r15.zzC(r12)
            r1 = r36
            r2 = r35
            r4 = r37
            r17 = r5
            r5 = r7
            r26 = r6
            r6 = r39
            int r0 = com.google.android.recaptcha.internal.zzew.zze(r0, r1, r2, r3, r4, r5, r6)
            r3 = r36
            r11 = r38
            r2 = r12
            r1 = r13
            r5 = r17
            r6 = r26
            r8 = -1
            r12 = r35
            r13 = r37
            goto L_0x001e
        L_0x02eb:
            r17 = r5
            r26 = r6
            r24 = r2
            r15 = r3
            r31 = r10
            r25 = r12
            r21 = r13
            r20 = -1
            goto L_0x0377
        L_0x02fc:
            r17 = r5
            r26 = r6
            r22 = r29
            r0 = 49
            if (r11 > r0) goto L_0x0350
            long r6 = (long) r1
            r0 = r33
            r24 = r2
            r1 = r34
            r2 = r35
            r5 = r3
            r4 = r37
            r15 = r5
            r5 = r36
            r27 = r6
            r6 = r13
            r7 = r8
            r20 = -1
            r8 = r12
            r31 = r10
            r9 = r27
            r25 = r12
            r21 = r13
            r12 = r22
            r14 = r39
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x034a
        L_0x032e:
            r15 = r33
            r14 = r34
            r12 = r35
            r3 = r36
            r13 = r37
            r11 = r38
            r9 = r39
            r5 = r17
            r8 = r20
            r1 = r21
            r2 = r25
            r6 = r26
            r10 = r31
            goto L_0x001e
        L_0x034a:
            r8 = r36
            r7 = r38
            r2 = r0
            goto L_0x037c
        L_0x0350:
            r24 = r2
            r15 = r3
            r31 = r10
            r25 = r12
            r21 = r13
            r20 = -1
            r0 = 50
            if (r11 != r0) goto L_0x037f
            if (r8 != r4) goto L_0x0377
            r0 = r33
            r1 = r34
            r2 = r35
            r3 = r15
            r4 = r37
            r5 = r25
            r6 = r22
            r8 = r39
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x034a
            goto L_0x032e
        L_0x0377:
            r8 = r36
            r7 = r38
            r2 = r15
        L_0x037c:
            r6 = r26
            goto L_0x039d
        L_0x037f:
            r0 = r33
            r9 = r1
            r1 = r34
            r2 = r35
            r3 = r15
            r4 = r37
            r5 = r36
            r6 = r21
            r7 = r8
            r8 = r9
            r9 = r11
            r10 = r22
            r12 = r25
            r13 = r39
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x034a
            goto L_0x032e
        L_0x039d:
            if (r8 != r7) goto L_0x03ae
            if (r7 == 0) goto L_0x03ae
            r9 = r33
            r12 = r34
            r0 = r6
            r5 = r17
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r2
            goto L_0x04ef
        L_0x03ae:
            r9 = r33
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x04b5
            r10 = r39
            com.google.android.recaptcha.internal.zzgq r0 = r10.zzd
            com.google.android.recaptcha.internal.zzgq r1 = com.google.android.recaptcha.internal.zzgq.zza
            if (r0 == r1) goto L_0x04b0
            com.google.android.recaptcha.internal.zzip r1 = r9.zzg
            r11 = r21
            com.google.android.recaptcha.internal.zzhd r0 = r0.zza(r1, r11)
            if (r0 != 0) goto L_0x03db
            com.google.android.recaptcha.internal.zzjx r4 = zzd(r34)
            r0 = r8
            r1 = r35
            r3 = r37
            r5 = r39
            int r0 = com.google.android.recaptcha.internal.zzew.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r34
            r13 = r35
            goto L_0x04cc
        L_0x03db:
            r12 = r34
            r1 = r12
            com.google.android.recaptcha.internal.zzhb r1 = (com.google.android.recaptcha.internal.zzhb) r1
            r1.zzi()
            com.google.android.recaptcha.internal.zzgv r1 = r1.zzb
            com.google.android.recaptcha.internal.zzhc r3 = r0.zzb
            com.google.android.recaptcha.internal.zzkm r3 = r3.zzb
            com.google.android.recaptcha.internal.zzkm r4 = com.google.android.recaptcha.internal.zzkm.ENUM
            r5 = 0
            if (r3 == r4) goto L_0x04aa
            int r3 = r3.ordinal()
            switch(r3) {
                case 0: goto L_0x0493;
                case 1: goto L_0x0482;
                case 2: goto L_0x0475;
                case 3: goto L_0x0475;
                case 4: goto L_0x0468;
                case 5: goto L_0x045d;
                case 6: goto L_0x0452;
                case 7: goto L_0x043e;
                case 8: goto L_0x0435;
                case 9: goto L_0x0432;
                case 10: goto L_0x042f;
                case 11: goto L_0x0425;
                case 12: goto L_0x0468;
                case 13: goto L_0x041d;
                case 14: goto L_0x0452;
                case 15: goto L_0x045d;
                case 16: goto L_0x040b;
                case 17: goto L_0x03f9;
                default: goto L_0x03f5;
            }
        L_0x03f5:
            r13 = r35
            goto L_0x04a3
        L_0x03f9:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zzm(r13, r2, r10)
            long r3 = r10.zzb
            long r3 = com.google.android.recaptcha.internal.zzfo.zzG(r3)
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
            goto L_0x04a3
        L_0x040b:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zzj(r13, r2, r10)
            int r3 = r10.zza
            int r3 = com.google.android.recaptcha.internal.zzfo.zzF(r3)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            goto L_0x04a3
        L_0x041d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x0425:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zza(r13, r2, r10)
            java.lang.Object r5 = r10.zzc
            goto L_0x04a3
        L_0x042f:
            int r0 = com.google.android.recaptcha.internal.zziy.zza
            throw r5
        L_0x0432:
            int r0 = com.google.android.recaptcha.internal.zziy.zza
            throw r5
        L_0x0435:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zzg(r13, r2, r10)
            java.lang.Object r5 = r10.zzc
            goto L_0x04a3
        L_0x043e:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zzm(r13, r2, r10)
            long r3 = r10.zzb
            int r3 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r3 == 0) goto L_0x044b
            goto L_0x044d
        L_0x044b:
            r24 = r16
        L_0x044d:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r24)
            goto L_0x04a3
        L_0x0452:
            r13 = r35
            int r3 = com.google.android.recaptcha.internal.zzew.zzb(r13, r2)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            goto L_0x0490
        L_0x045d:
            r13 = r35
            long r3 = com.google.android.recaptcha.internal.zzew.zzq(r13, r2)
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
            goto L_0x04a1
        L_0x0468:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zzj(r13, r2, r10)
            int r3 = r10.zza
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            goto L_0x04a3
        L_0x0475:
            r13 = r35
            int r2 = com.google.android.recaptcha.internal.zzew.zzm(r13, r2, r10)
            long r3 = r10.zzb
            java.lang.Long r5 = java.lang.Long.valueOf(r3)
            goto L_0x04a3
        L_0x0482:
            r13 = r35
            int r3 = com.google.android.recaptcha.internal.zzew.zzb(r13, r2)
            float r3 = java.lang.Float.intBitsToFloat(r3)
            java.lang.Float r5 = java.lang.Float.valueOf(r3)
        L_0x0490:
            int r2 = r2 + 4
            goto L_0x04a3
        L_0x0493:
            r13 = r35
            long r3 = com.google.android.recaptcha.internal.zzew.zzq(r13, r2)
            double r3 = java.lang.Double.longBitsToDouble(r3)
            java.lang.Double r5 = java.lang.Double.valueOf(r3)
        L_0x04a1:
            int r2 = r2 + 8
        L_0x04a3:
            com.google.android.recaptcha.internal.zzhc r0 = r0.zzb
            r1.zzi(r0, r5)
            r0 = r2
            goto L_0x04cc
        L_0x04aa:
            r13 = r35
            com.google.android.recaptcha.internal.zzew.zzj(r13, r2, r10)
            throw r5
        L_0x04b0:
            r12 = r34
            r13 = r35
            goto L_0x04bb
        L_0x04b5:
            r12 = r34
            r13 = r35
            r10 = r39
        L_0x04bb:
            r11 = r21
            com.google.android.recaptcha.internal.zzjx r4 = zzd(r34)
            r0 = r8
            r1 = r35
            r3 = r37
            r5 = r39
            int r0 = com.google.android.recaptcha.internal.zzew.zzi(r0, r1, r2, r3, r4, r5)
        L_0x04cc:
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r14 = r12
            r12 = r13
            r5 = r17
            r8 = r20
            r2 = r25
            r10 = r31
            r13 = r37
            r11 = r7
            goto L_0x001e
        L_0x04df:
            r17 = r5
            r26 = r6
            r31 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r6 = r0
            r8 = r3
            r0 = r26
            r1 = 1048575(0xfffff, float:1.469367E-39)
        L_0x04ef:
            if (r0 == r1) goto L_0x04f7
            long r0 = (long) r0
            r2 = r31
            r2.putInt(r12, r0, r5)
        L_0x04f7:
            int r0 = r9.zzk
            r10 = r0
        L_0x04fa:
            int r0 = r9.zzl
            if (r10 >= r0) goto L_0x0511
            int[] r0 = r9.zzj
            r2 = r0[r10]
            r3 = 0
            com.google.android.recaptcha.internal.zzjw r4 = r9.zzn
            r0 = r33
            r1 = r34
            r5 = r34
            r0.zzD(r1, r2, r3, r4, r5)
            int r10 = r10 + 1
            goto L_0x04fa
        L_0x0511:
            if (r7 != 0) goto L_0x051d
            r0 = r37
            if (r6 != r0) goto L_0x0518
            goto L_0x0523
        L_0x0518:
            com.google.android.recaptcha.internal.zzhp r0 = com.google.android.recaptcha.internal.zzhp.zzg()
            throw r0
        L_0x051d:
            r0 = r37
            if (r6 > r0) goto L_0x0524
            if (r8 != r7) goto L_0x0524
        L_0x0523:
            return r6
        L_0x0524:
            com.google.android.recaptcha.internal.zzhp r0 = com.google.android.recaptcha.internal.zzhp.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzc(java.lang.Object, byte[], int, int, int, com.google.android.recaptcha.internal.zzev):int");
    }

    public final Object zze() {
        return ((zzhf) this.zzg).zzs();
    }

    public final void zzf(Object obj) {
        if (zzW(obj)) {
            if (obj instanceof zzhf) {
                zzhf zzhf = (zzhf) obj;
                zzhf.zzD(Integer.MAX_VALUE);
                zzhf.zza = 0;
                zzhf.zzB();
            }
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int zzz = zzz(i11);
                int i12 = 1048575 & zzz;
                int zzy = zzy(zzz);
                long j11 = (long) i12;
                if (zzy != 9) {
                    if (zzy == 60 || zzy == 68) {
                        if (zzX(obj, this.zzc[i11], i11)) {
                            zzC(i11).zzf(zzb.getObject(obj, j11));
                        }
                    } else {
                        switch (zzy) {
                            case 17:
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
                                this.zzm.zzb(obj, j11);
                                continue;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j11);
                                if (object != null) {
                                    ((zzij) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzT(obj, i11)) {
                    zzC(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zzf(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzI(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzz = zzz(i11);
            int i12 = this.zzc[i11];
            long j11 = (long) (1048575 & zzz);
            switch (zzy(zzz)) {
                case 0:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzo(obj, j11, zzkg.zza(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 1:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzp(obj, j11, zzkg.zzb(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 2:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzr(obj, j11, zzkg.zzd(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 3:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzr(obj, j11, zzkg.zzd(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 4:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzq(obj, j11, zzkg.zzc(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 5:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzr(obj, j11, zzkg.zzd(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 6:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzq(obj, j11, zzkg.zzc(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 7:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzm(obj, j11, zzkg.zzw(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 8:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzs(obj, j11, zzkg.zzf(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 9:
                    zzJ(obj, obj2, i11);
                    break;
                case 10:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzs(obj, j11, zzkg.zzf(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 11:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzq(obj, j11, zzkg.zzc(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 12:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzq(obj, j11, zzkg.zzc(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 13:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzq(obj, j11, zzkg.zzc(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 14:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzr(obj, j11, zzkg.zzd(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 15:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzq(obj, j11, zzkg.zzc(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 16:
                    if (!zzT(obj2, i11)) {
                        break;
                    } else {
                        zzkg.zzr(obj, j11, zzkg.zzd(obj2, j11));
                        zzM(obj, i11);
                        break;
                    }
                case 17:
                    zzJ(obj, obj2, i11);
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
                    this.zzm.zzc(obj, obj2, j11);
                    break;
                case 50:
                    int i13 = zzje.zza;
                    zzkg.zzs(obj, j11, zzik.zzc(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11)));
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
                    if (!zzX(obj2, i12, i11)) {
                        break;
                    } else {
                        zzkg.zzs(obj, j11, zzkg.zzf(obj2, j11));
                        zzN(obj, i12, i11);
                        break;
                    }
                case 60:
                    zzK(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzX(obj2, i12, i11)) {
                        break;
                    } else {
                        zzkg.zzs(obj, j11, zzkg.zzf(obj2, j11));
                        zzN(obj, i12, i11);
                        break;
                    }
                case 68:
                    zzK(obj, obj2, i11);
                    break;
            }
        }
        zzje.zzD(this.zzn, obj, obj2);
        if (this.zzh) {
            zzje.zzC(this.zzo, obj, obj2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:168|169|(1:171)|172|(5:193|174|(2:177|175)|203|(2:179|205)(1:209))) */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x05e6, code lost:
        r15 = r9;
        r5 = r11;
        r6 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x05e9, code lost:
        r14 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x0611, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:?, code lost:
        r10.zzs(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0619, code lost:
        if (r13 == null) goto L_0x061b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x061b, code lost:
        r13 = r10.zzc(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0624, code lost:
        if (r10.zzr(r13, r0) == false) goto L_0x0626;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0626, code lost:
        r0 = r7.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x062a, code lost:
        if (r0 < r7.zzl) goto L_0x062c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x062c, code lost:
        zzD(r18, r7.zzj[r0], r13, r10, r18);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x063e, code lost:
        if (r13 != null) goto L_0x0640;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0640, code lost:
        r10.zzn(r9, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0651, code lost:
        zzD(r18, r7.zzj[r8], r13, r10, r18);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0665, code lost:
        r10.zzn(r9, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0187, code lost:
        r13 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:168:0x0616 */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0651 A[LOOP:5: B:185:0x064d->B:187:0x0651, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0665  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r18, com.google.android.recaptcha.internal.zzjb r19, com.google.android.recaptcha.internal.zzgq r20) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            r15 = r18
            r0 = r19
            r6 = r20
            r20.getClass()
            zzI(r18)
            com.google.android.recaptcha.internal.zzjw r14 = r7.zzn
            com.google.android.recaptcha.internal.zzgr r5 = r7.zzo
            r16 = 0
            r8 = r16
            r13 = r8
        L_0x0017:
            int r2 = r19.zzc()     // Catch:{ all -> 0x0647 }
            int r1 = r7.zzu(r2)     // Catch:{ all -> 0x0647 }
            if (r1 >= 0) goto L_0x00b9
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0044
            int r0 = r7.zzk
        L_0x0028:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x003e
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r4 = r13
            r5 = r14
            r6 = r18
            r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003e:
            if (r13 == 0) goto L_0x0643
            r14.zzn(r15, r13)
            return
        L_0x0044:
            boolean r1 = r7.zzh     // Catch:{ all -> 0x0647 }
            if (r1 != 0) goto L_0x004b
            r11 = r16
            goto L_0x0052
        L_0x004b:
            com.google.android.recaptcha.internal.zzip r1 = r7.zzg     // Catch:{ all -> 0x0647 }
            java.lang.Object r1 = r5.zzd(r6, r1, r2)     // Catch:{ all -> 0x0647 }
            r11 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x0071
            if (r8 != 0) goto L_0x005b
            com.google.android.recaptcha.internal.zzgv r1 = r5.zzc(r15)     // Catch:{ all -> 0x0647 }
            goto L_0x005c
        L_0x005b:
            r1 = r8
        L_0x005c:
            r8 = r5
            r9 = r18
            r10 = r19
            r12 = r20
            r4 = r13
            r13 = r1
            r3 = r14
            r14 = r4
            r2 = r15
            r15 = r3
            r8.zze(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00b4 }
            r8 = r1
            r15 = r2
            r14 = r3
            r13 = r4
            goto L_0x0017
        L_0x0071:
            r4 = r13
            r3 = r14
            r2 = r15
            r3.zzs(r0)     // Catch:{ all -> 0x00b4 }
            if (r4 != 0) goto L_0x007f
            java.lang.Object r1 = r3.zzc(r2)     // Catch:{ all -> 0x00b4 }
            r13 = r1
            goto L_0x0080
        L_0x007f:
            r13 = r4
        L_0x0080:
            boolean r1 = r3.zzr(r13, r0)     // Catch:{ all -> 0x00af }
            if (r1 != 0) goto L_0x00ab
            int r0 = r7.zzk
        L_0x0088:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x00a3
            int[] r1 = r7.zzj
            r4 = r1[r0]
            r1 = r17
            r9 = r2
            r2 = r18
            r10 = r3
            r3 = r4
            r4 = r13
            r5 = r10
            r6 = r18
            r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r2 = r9
            r3 = r10
            goto L_0x0088
        L_0x00a3:
            r9 = r2
            r10 = r3
            if (r13 == 0) goto L_0x0643
            r10.zzn(r9, r13)
            return
        L_0x00ab:
            r15 = r2
            r14 = r3
            goto L_0x0017
        L_0x00af:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x064a
        L_0x00b4:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x0645
        L_0x00b9:
            r4 = r13
            r10 = r14
            r9 = r15
            int r3 = r7.zzz(r1)     // Catch:{ all -> 0x0644 }
            int r11 = zzy(r3)     // Catch:{ zzho -> 0x0613 }
            r12 = 1048575(0xfffff, float:1.469367E-39)
            switch(r11) {
                case 0: goto L_0x05d6;
                case 1: goto L_0x05c5;
                case 2: goto L_0x05b4;
                case 3: goto L_0x05a3;
                case 4: goto L_0x0592;
                case 5: goto L_0x0581;
                case 6: goto L_0x056f;
                case 7: goto L_0x055d;
                case 8: goto L_0x0552;
                case 9: goto L_0x053d;
                case 10: goto L_0x052b;
                case 11: goto L_0x0519;
                case 12: goto L_0x04f4;
                case 13: goto L_0x04e2;
                case 14: goto L_0x04d0;
                case 15: goto L_0x04be;
                case 16: goto L_0x04ac;
                case 17: goto L_0x0497;
                case 18: goto L_0x0486;
                case 19: goto L_0x0475;
                case 20: goto L_0x0464;
                case 21: goto L_0x0453;
                case 22: goto L_0x0442;
                case 23: goto L_0x0431;
                case 24: goto L_0x0420;
                case 25: goto L_0x040f;
                case 26: goto L_0x03e2;
                case 27: goto L_0x03cd;
                case 28: goto L_0x03bc;
                case 29: goto L_0x03ab;
                case 30: goto L_0x038f;
                case 31: goto L_0x037e;
                case 32: goto L_0x036d;
                case 33: goto L_0x035c;
                case 34: goto L_0x034b;
                case 35: goto L_0x033a;
                case 36: goto L_0x0329;
                case 37: goto L_0x0318;
                case 38: goto L_0x0307;
                case 39: goto L_0x02f6;
                case 40: goto L_0x02e5;
                case 41: goto L_0x02d4;
                case 42: goto L_0x02c3;
                case 43: goto L_0x02b2;
                case 44: goto L_0x0295;
                case 45: goto L_0x0287;
                case 46: goto L_0x0279;
                case 47: goto L_0x026b;
                case 48: goto L_0x025d;
                case 49: goto L_0x024b;
                case 50: goto L_0x0215;
                case 51: goto L_0x0203;
                case 52: goto L_0x01f2;
                case 53: goto L_0x01e1;
                case 54: goto L_0x01d0;
                case 55: goto L_0x01bf;
                case 56: goto L_0x01ae;
                case 57: goto L_0x019d;
                case 58: goto L_0x018c;
                case 59: goto L_0x0181;
                case 60: goto L_0x0170;
                case 61: goto L_0x0163;
                case 62: goto L_0x0152;
                case 63: goto L_0x012d;
                case 64: goto L_0x011c;
                case 65: goto L_0x010b;
                case 66: goto L_0x00f9;
                case 67: goto L_0x00e7;
                case 68: goto L_0x00d5;
                default: goto L_0x00ca;
            }
        L_0x00ca:
            r13 = r4
            r11 = r5
            r14 = r6
            if (r13 != 0) goto L_0x05ed
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05ec
        L_0x00d5:
            java.lang.Object r3 = r7.zzG(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzip r3 = (com.google.android.recaptcha.internal.zzip) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzjc r11 = r7.zzC(r1)     // Catch:{ zzho -> 0x0613 }
            r0.zzt(r3, r11, r6)     // Catch:{ zzho -> 0x0613 }
            r7.zzP(r9, r2, r1, r3)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x00e7:
            r3 = r3 & r12
            long r11 = r19.zzn()     // Catch:{ zzho -> 0x0613 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x00f9:
            r3 = r3 & r12
            int r11 = r19.zzi()     // Catch:{ zzho -> 0x0613 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x010b:
            r3 = r3 & r12
            long r11 = r19.zzm()     // Catch:{ zzho -> 0x0613 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x011c:
            r3 = r3 & r12
            int r11 = r19.zzh()     // Catch:{ zzho -> 0x0613 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x012d:
            int r11 = r19.zze()     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzhj r13 = r7.zzB(r1)     // Catch:{ zzho -> 0x0613 }
            if (r13 == 0) goto L_0x0145
            boolean r13 = r13.zza(r11)     // Catch:{ zzho -> 0x0613 }
            if (r13 == 0) goto L_0x013e
            goto L_0x0145
        L_0x013e:
            java.lang.Object r13 = com.google.android.recaptcha.internal.zzje.zzB(r9, r2, r11, r4, r10)     // Catch:{ zzho -> 0x0613 }
            r15 = r9
            goto L_0x05e9
        L_0x0145:
            r3 = r3 & r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0152:
            r3 = r3 & r12
            int r11 = r19.zzj()     // Catch:{ zzho -> 0x0613 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0163:
            r3 = r3 & r12
            com.google.android.recaptcha.internal.zzfi r11 = r19.zzp()     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0170:
            java.lang.Object r3 = r7.zzG(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzip r3 = (com.google.android.recaptcha.internal.zzip) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzjc r11 = r7.zzC(r1)     // Catch:{ zzho -> 0x0613 }
            r0.zzu(r3, r11, r6)     // Catch:{ zzho -> 0x0613 }
            r7.zzP(r9, r2, r1, r3)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0181:
            r7.zzL(r9, r3, r0)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
        L_0x0187:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05e6
        L_0x018c:
            r3 = r3 & r12
            boolean r11 = r19.zzN()     // Catch:{ zzho -> 0x0613 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x019d:
            r3 = r3 & r12
            int r11 = r19.zzf()     // Catch:{ zzho -> 0x0613 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x01ae:
            r3 = r3 & r12
            long r11 = r19.zzk()     // Catch:{ zzho -> 0x0613 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x01bf:
            r3 = r3 & r12
            int r11 = r19.zzg()     // Catch:{ zzho -> 0x0613 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x01d0:
            r3 = r3 & r12
            long r11 = r19.zzo()     // Catch:{ zzho -> 0x0613 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x01e1:
            r3 = r3 & r12
            long r11 = r19.zzl()     // Catch:{ zzho -> 0x0613 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x01f2:
            r3 = r3 & r12
            float r11 = r19.zzb()     // Catch:{ zzho -> 0x0613 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0203:
            r3 = r3 & r12
            double r11 = r19.zza()     // Catch:{ zzho -> 0x0613 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ zzho -> 0x0613 }
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r12, r11)     // Catch:{ zzho -> 0x0613 }
            r7.zzN(r9, r2, r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0215:
            java.lang.Object r2 = r7.zzE(r1)     // Catch:{ zzho -> 0x0613 }
            int r1 = r7.zzz(r1)     // Catch:{ zzho -> 0x0613 }
            r1 = r1 & r12
            long r11 = (long) r1     // Catch:{ zzho -> 0x0613 }
            java.lang.Object r1 = com.google.android.recaptcha.internal.zzkg.zzf(r9, r11)     // Catch:{ zzho -> 0x0613 }
            if (r1 == 0) goto L_0x023b
            boolean r3 = com.google.android.recaptcha.internal.zzik.zzb(r1)     // Catch:{ zzho -> 0x0613 }
            if (r3 == 0) goto L_0x0246
            com.google.android.recaptcha.internal.zzij r3 = com.google.android.recaptcha.internal.zzij.zza()     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzij r3 = r3.zzb()     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzik.zzc(r3, r1)     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r11, r3)     // Catch:{ zzho -> 0x0613 }
            r1 = r3
            goto L_0x0246
        L_0x023b:
            com.google.android.recaptcha.internal.zzij r1 = com.google.android.recaptcha.internal.zzij.zza()     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzij r1 = r1.zzb()     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r11, r1)     // Catch:{ zzho -> 0x0613 }
        L_0x0246:
            com.google.android.recaptcha.internal.zzij r1 = (com.google.android.recaptcha.internal.zzij) r1     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzii r2 = (com.google.android.recaptcha.internal.zzii) r2     // Catch:{ zzho -> 0x0613 }
            throw r16     // Catch:{ zzho -> 0x0613 }
        L_0x024b:
            r2 = r3 & r12
            com.google.android.recaptcha.internal.zzjc r1 = r7.zzC(r1)     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzid r3 = r7.zzm     // Catch:{ zzho -> 0x0613 }
            long r11 = (long) r2     // Catch:{ zzho -> 0x0613 }
            java.util.List r2 = r3.zza(r9, r11)     // Catch:{ zzho -> 0x0613 }
            r0.zzC(r2, r1, r6)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x025d:
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0613 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0613 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0613 }
            r0.zzJ(r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x026b:
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0613 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0613 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0613 }
            r0.zzI(r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0279:
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0613 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0613 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0613 }
            r0.zzH(r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0287:
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0613 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0613 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0613 }
            r0.zzG(r1)     // Catch:{ zzho -> 0x0613 }
            goto L_0x0187
        L_0x0295:
            com.google.android.recaptcha.internal.zzid r11 = r7.zzm     // Catch:{ zzho -> 0x0613 }
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{ zzho -> 0x0613 }
            java.util.List r3 = r11.zza(r9, r12)     // Catch:{ zzho -> 0x0613 }
            r0.zzy(r3)     // Catch:{ zzho -> 0x0613 }
            com.google.android.recaptcha.internal.zzhj r11 = r7.zzB(r1)     // Catch:{ zzho -> 0x0613 }
            r1 = r18
            r13 = r4
            r4 = r11
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r10
            java.lang.Object r13 = com.google.android.recaptcha.internal.zzje.zzA(r1, r2, r3, r4, r5, r6)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x02b2:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzL(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x02c3:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzv(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x02d4:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzz(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x02e5:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzA(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x02f6:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzD(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0307:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzM(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0318:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzE(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0329:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzB(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x033a:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzx(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x034b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzJ(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x035c:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzI(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x036d:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzH(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x037e:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzG(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x038f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r4 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r3 = r3 & r12
            long r5 = (long) r3     // Catch:{ zzho -> 0x0616 }
            java.util.List r3 = r4.zza(r9, r5)     // Catch:{ zzho -> 0x0616 }
            r0.zzy(r3)     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzhj r4 = r7.zzB(r1)     // Catch:{ zzho -> 0x0616 }
            r1 = r18
            r5 = r13
            r6 = r10
            java.lang.Object r13 = com.google.android.recaptcha.internal.zzje.zzA(r1, r2, r3, r4, r5, r6)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x03ab:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzL(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x03bc:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzw(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x03cd:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzjc r1 = r7.zzC(r1)     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            com.google.android.recaptcha.internal.zzid r3 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r2 = r3.zza(r9, r4)     // Catch:{ zzho -> 0x0616 }
            r0.zzF(r2, r1, r14)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x03e2:
            r13 = r4
            r11 = r5
            r14 = r6
            boolean r1 = zzS(r3)     // Catch:{ zzho -> 0x0616 }
            if (r1 == 0) goto L_0x03fd
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r2 = r0
            com.google.android.recaptcha.internal.zzfp r2 = (com.google.android.recaptcha.internal.zzfp) r2     // Catch:{ zzho -> 0x0616 }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x03fd:
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r2 = r0
            com.google.android.recaptcha.internal.zzfp r2 = (com.google.android.recaptcha.internal.zzfp) r2     // Catch:{ zzho -> 0x0616 }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x040f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzv(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0420:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzz(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0431:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzA(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0442:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzD(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0453:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzM(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0464:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzE(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0475:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzB(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0486:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.recaptcha.internal.zzid r1 = r7.zzm     // Catch:{ zzho -> 0x0616 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzho -> 0x0616 }
            r0.zzx(r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0497:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzF(r9, r1)     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzip r2 = (com.google.android.recaptcha.internal.zzip) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzjc r3 = r7.zzC(r1)     // Catch:{ zzho -> 0x0616 }
            r0.zzt(r2, r3, r14)     // Catch:{ zzho -> 0x0616 }
            r7.zzO(r9, r1, r2)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x04ac:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzn()     // Catch:{ zzho -> 0x0616 }
            long r5 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzr(r9, r5, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x04be:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzi()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzq(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x04d0:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzm()     // Catch:{ zzho -> 0x0616 }
            long r5 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzr(r9, r5, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x04e2:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzh()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzq(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x04f4:
            r13 = r4
            r11 = r5
            r14 = r6
            int r4 = r19.zze()     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzhj r5 = r7.zzB(r1)     // Catch:{ zzho -> 0x0616 }
            if (r5 == 0) goto L_0x050e
            boolean r5 = r5.zza(r4)     // Catch:{ zzho -> 0x0616 }
            if (r5 == 0) goto L_0x0508
            goto L_0x050e
        L_0x0508:
            java.lang.Object r13 = com.google.android.recaptcha.internal.zzje.zzB(r9, r2, r4, r13, r10)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x050e:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzq(r9, r2, r4)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0519:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzj()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzq(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x052b:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            com.google.android.recaptcha.internal.zzfi r3 = r19.zzp()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzs(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x053d:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzF(r9, r1)     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzip r2 = (com.google.android.recaptcha.internal.zzip) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzjc r3 = r7.zzC(r1)     // Catch:{ zzho -> 0x0616 }
            r0.zzu(r2, r3, r14)     // Catch:{ zzho -> 0x0616 }
            r7.zzO(r9, r1, r2)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0552:
            r13 = r4
            r11 = r5
            r14 = r6
            r7.zzL(r9, r3, r0)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x055d:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            boolean r3 = r19.zzN()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzm(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x056f:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzf()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzq(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0581:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzk()     // Catch:{ zzho -> 0x0616 }
            long r5 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzr(r9, r5, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x0592:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzg()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzq(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x05a3:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzo()     // Catch:{ zzho -> 0x0616 }
            long r5 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzr(r9, r5, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x05b4:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzl()     // Catch:{ zzho -> 0x0616 }
            long r5 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzr(r9, r5, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x05c5:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            float r3 = r19.zzb()     // Catch:{ zzho -> 0x0616 }
            long r4 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzp(r9, r4, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
            goto L_0x05e6
        L_0x05d6:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            double r3 = r19.zza()     // Catch:{ zzho -> 0x0616 }
            long r5 = (long) r2     // Catch:{ zzho -> 0x0616 }
            com.google.android.recaptcha.internal.zzkg.zzo(r9, r5, r3)     // Catch:{ zzho -> 0x0616 }
            r7.zzM(r9, r1)     // Catch:{ zzho -> 0x0616 }
        L_0x05e6:
            r15 = r9
            r5 = r11
            r6 = r14
        L_0x05e9:
            r14 = r10
            goto L_0x0017
        L_0x05ec:
            r13 = r1
        L_0x05ed:
            boolean r1 = r10.zzr(r13, r0)     // Catch:{ zzho -> 0x0616 }
            if (r1 != 0) goto L_0x05e6
            int r0 = r7.zzk
        L_0x05f5:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x060b
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r4 = r13
            r5 = r10
            r6 = r18
            r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x05f5
        L_0x060b:
            if (r13 == 0) goto L_0x0643
            r10.zzn(r9, r13)
            return
        L_0x0611:
            r0 = move-exception
            goto L_0x064a
        L_0x0613:
            r13 = r4
            r11 = r5
            r14 = r6
        L_0x0616:
            r10.zzs(r0)     // Catch:{ all -> 0x0611 }
            if (r13 != 0) goto L_0x0620
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ all -> 0x0611 }
            r13 = r1
        L_0x0620:
            boolean r1 = r10.zzr(r13, r0)     // Catch:{ all -> 0x0611 }
            if (r1 != 0) goto L_0x05e6
            int r0 = r7.zzk
        L_0x0628:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x063e
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r4 = r13
            r5 = r10
            r6 = r18
            r1.zzD(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0628
        L_0x063e:
            if (r13 == 0) goto L_0x0643
            r10.zzn(r9, r13)
        L_0x0643:
            return
        L_0x0644:
            r0 = move-exception
        L_0x0645:
            r13 = r4
            goto L_0x064a
        L_0x0647:
            r0 = move-exception
            r10 = r14
            r9 = r15
        L_0x064a:
            int r1 = r7.zzk
            r8 = r1
        L_0x064d:
            int r1 = r7.zzl
            if (r8 >= r1) goto L_0x0663
            int[] r1 = r7.zzj
            r3 = r1[r8]
            r1 = r17
            r2 = r18
            r4 = r13
            r5 = r10
            r6 = r18
            r1.zzD(r2, r3, r4, r5, r6)
            int r8 = r8 + 1
            goto L_0x064d
        L_0x0663:
            if (r13 == 0) goto L_0x0668
            r10.zzn(r9, r13)
        L_0x0668:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzjb, com.google.android.recaptcha.internal.zzgq):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02d9, code lost:
        if (r0 != r15) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02fd, code lost:
        if (r0 != r15) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01ec, code lost:
        r6 = r6 | r22;
        r2 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ef, code lost:
        r1 = r19;
        r8 = r24;
        r9 = -1;
        r13 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01f8, code lost:
        r2 = r5;
        r27 = r10;
        r22 = r13;
        r18 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0294, code lost:
        if (r0 != r15) goto L_0x0296;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ac, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(java.lang.Object r31, byte[] r32, int r33, int r34, com.google.android.recaptcha.internal.zzev r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            com.google.android.recaptcha.internal.zzkm r0 = com.google.android.recaptcha.internal.zzkm.DOUBLE
            int r0 = r15.zzp
            r9 = -1
            int r0 = r0 + r9
            if (r0 == 0) goto L_0x0342
            zzI(r31)
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r7 = r8
            r1 = r9
            r2 = r16
            r6 = r2
        L_0x0023:
            if (r0 >= r13) goto L_0x0327
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0035
            int r0 = com.google.android.recaptcha.internal.zzew.zzk(r0, r12, r3, r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0038
        L_0x0035:
            r17 = r0
            r4 = r3
        L_0x0038:
            int r5 = r17 >>> 3
            if (r5 <= r1) goto L_0x0043
            int r2 = r2 / 3
            int r0 = r15.zzv(r5, r2)
            goto L_0x0047
        L_0x0043:
            int r0 = r15.zzu(r5)
        L_0x0047:
            r2 = r0
            if (r2 != r9) goto L_0x0055
            r2 = r4
            r19 = r5
            r18 = r9
            r27 = r10
            r22 = r16
            goto L_0x0300
        L_0x0055:
            r3 = r17 & 7
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r13 = zzy(r1)
            r9 = r1 & r8
            long r8 = (long) r9
            r33 = r5
            r5 = 17
            r20 = r1
            if (r13 > r5) goto L_0x0201
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r22 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r19 = r2
            if (r0 == r7) goto L_0x008c
            if (r7 == r5) goto L_0x0083
            long r1 = (long) r7
            r10.putInt(r14, r1, r6)
        L_0x0083:
            if (r0 == r5) goto L_0x008b
            long r1 = (long) r0
            int r1 = r10.getInt(r14, r1)
            r6 = r1
        L_0x008b:
            r7 = r0
        L_0x008c:
            r0 = 5
            switch(r13) {
                case 0: goto L_0x01d5;
                case 1: goto L_0x01be;
                case 2: goto L_0x01a2;
                case 3: goto L_0x01a2;
                case 4: goto L_0x018f;
                case 5: goto L_0x0174;
                case 6: goto L_0x0161;
                case 7: goto L_0x0144;
                case 8: goto L_0x0125;
                case 9: goto L_0x0103;
                case 10: goto L_0x00ef;
                case 11: goto L_0x018f;
                case 12: goto L_0x00dc;
                case 13: goto L_0x0161;
                case 14: goto L_0x0174;
                case 15: goto L_0x00c5;
                case 16: goto L_0x0099;
                default: goto L_0x0090;
            }
        L_0x0090:
            r24 = r5
            r13 = r19
            r19 = r33
        L_0x0096:
            r5 = r4
            goto L_0x01f8
        L_0x0099:
            if (r3 != 0) goto L_0x00bb
            int r13 = com.google.android.recaptcha.internal.zzew.zzm(r12, r4, r11)
            long r0 = r11.zzb
            long r20 = com.google.android.recaptcha.internal.zzfo.zzG(r0)
            r0 = r10
            r1 = r31
            r4 = r19
            r2 = r8
            r19 = r33
            r8 = r4
            r24 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r2 = r8
            r0 = r13
            goto L_0x01ef
        L_0x00bb:
            r24 = r5
            r8 = r19
            r19 = r33
            r5 = r4
            r13 = r8
            goto L_0x01f8
        L_0x00c5:
            r24 = r5
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x0096
            int r0 = com.google.android.recaptcha.internal.zzew.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.recaptcha.internal.zzfo.zzF(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x01ec
        L_0x00dc:
            r24 = r5
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x0096
            int r0 = com.google.android.recaptcha.internal.zzew.zzj(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x01ec
        L_0x00ef:
            r24 = r5
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x0096
            int r0 = com.google.android.recaptcha.internal.zzew.zza(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x01ec
        L_0x0103:
            r24 = r5
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x0096
            java.lang.Object r8 = r15.zzF(r14, r13)
            com.google.android.recaptcha.internal.zzjc r1 = r15.zzC(r13)
            r0 = r8
            r2 = r32
            r3 = r4
            r4 = r34
            r5 = r35
            int r0 = com.google.android.recaptcha.internal.zzew.zzo(r0, r1, r2, r3, r4, r5)
            r15.zzO(r14, r13, r8)
            goto L_0x01ec
        L_0x0125:
            r24 = r5
            r13 = r19
            r0 = 2
            r19 = r33
            if (r3 != r0) goto L_0x0096
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x0139
            int r0 = com.google.android.recaptcha.internal.zzew.zzg(r12, r4, r11)
            goto L_0x013d
        L_0x0139:
            int r0 = com.google.android.recaptcha.internal.zzew.zzh(r12, r4, r11)
        L_0x013d:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x01ec
        L_0x0144:
            r24 = r5
            r13 = r19
            r19 = r33
            if (r3 != 0) goto L_0x0096
            int r0 = com.google.android.recaptcha.internal.zzew.zzm(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x015a
            r1 = 1
            goto L_0x015c
        L_0x015a:
            r1 = r16
        L_0x015c:
            com.google.android.recaptcha.internal.zzkg.zzm(r14, r8, r1)
            goto L_0x01ec
        L_0x0161:
            r24 = r5
            r13 = r19
            r19 = r33
            if (r3 != r0) goto L_0x0096
            int r0 = com.google.android.recaptcha.internal.zzew.zzb(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x01ec
        L_0x0174:
            r24 = r5
            r13 = r19
            r0 = 1
            r19 = r33
            if (r3 != r0) goto L_0x0096
            long r20 = com.google.android.recaptcha.internal.zzew.zzq(r12, r4)
            r0 = r10
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x01ec
        L_0x018f:
            r24 = r5
            r13 = r19
            r19 = r33
            r5 = r4
            if (r3 != 0) goto L_0x01f8
            int r0 = com.google.android.recaptcha.internal.zzew.zzj(r12, r5, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x01ec
        L_0x01a2:
            r24 = r5
            r13 = r19
            r19 = r33
            r5 = r4
            if (r3 != 0) goto L_0x01f8
            int r17 = com.google.android.recaptcha.internal.zzew.zzm(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r2 = r13
            r0 = r17
            goto L_0x01ef
        L_0x01be:
            r24 = r5
            r13 = r19
            r19 = r33
            r5 = r4
            if (r3 != r0) goto L_0x01f8
            int r0 = com.google.android.recaptcha.internal.zzew.zzb(r12, r5)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.recaptcha.internal.zzkg.zzp(r14, r8, r0)
            int r0 = r5 + 4
            goto L_0x01ec
        L_0x01d5:
            r24 = r5
            r13 = r19
            r0 = 1
            r19 = r33
            r5 = r4
            if (r3 != r0) goto L_0x01f8
            long r0 = com.google.android.recaptcha.internal.zzew.zzq(r12, r5)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.recaptcha.internal.zzkg.zzo(r14, r8, r0)
            int r0 = r5 + 8
        L_0x01ec:
            r6 = r6 | r22
            r2 = r13
        L_0x01ef:
            r1 = r19
            r8 = r24
            r9 = -1
            r13 = r34
            goto L_0x0023
        L_0x01f8:
            r2 = r5
            r27 = r10
            r22 = r13
            r18 = -1
            goto L_0x0300
        L_0x0201:
            r19 = r33
            r5 = r4
            r24 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r0 = 27
            if (r13 != r0) goto L_0x025b
            r0 = 2
            if (r3 != r0) goto L_0x024e
            java.lang.Object r0 = r10.getObject(r14, r8)
            com.google.android.recaptcha.internal.zzhm r0 = (com.google.android.recaptcha.internal.zzhm) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x022c
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0224
            r1 = 10
            goto L_0x0225
        L_0x0224:
            int r1 = r1 + r1
        L_0x0225:
            com.google.android.recaptcha.internal.zzhm r0 = r0.zzd(r1)
            r10.putObject(r14, r8, r0)
        L_0x022c:
            r8 = r0
            com.google.android.recaptcha.internal.zzjc r0 = r15.zzC(r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r22 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.recaptcha.internal.zzew.zze(r0, r1, r2, r3, r4, r5, r6)
            r13 = r34
            r6 = r8
            r1 = r19
            r2 = r22
            r8 = r24
            r9 = -1
            goto L_0x0023
        L_0x024e:
            r22 = r4
            r15 = r5
            r25 = r6
            r26 = r7
            r27 = r10
            r18 = -1
            goto L_0x02dc
        L_0x025b:
            r22 = r4
            r0 = 49
            if (r13 > r0) goto L_0x02ae
            r1 = r20
            long r1 = (long) r1
            r0 = r30
            r20 = r1
            r1 = r31
            r2 = r32
            r4 = r3
            r3 = r5
            r33 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r25 = r6
            r6 = r19
            r26 = r7
            r7 = r33
            r28 = r8
            r9 = r24
            r23 = r28
            r8 = r22
            r27 = r10
            r18 = -1
            r9 = r20
            r11 = r13
            r12 = r23
            r14 = r35
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02ac
        L_0x0296:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r18
            r1 = r19
            r2 = r22
            r6 = r25
            r7 = r26
            goto L_0x0320
        L_0x02ac:
            r2 = r0
            goto L_0x02dd
        L_0x02ae:
            r33 = r3
            r15 = r5
            r25 = r6
            r26 = r7
            r23 = r8
            r27 = r10
            r1 = r20
            r18 = -1
            r0 = 50
            if (r13 != r0) goto L_0x02e2
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x02dc
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r22
            r6 = r23
            r8 = r35
            int r0 = r0.zzr(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02ac
            goto L_0x0296
        L_0x02dc:
            r2 = r15
        L_0x02dd:
            r6 = r25
            r7 = r26
            goto L_0x0300
        L_0x02e2:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r19
            r9 = r13
            r10 = r23
            r12 = r22
            r13 = r35
            int r0 = r0.zzs(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02ac
            goto L_0x0296
        L_0x0300:
            com.google.android.recaptcha.internal.zzjx r4 = zzd(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.recaptcha.internal.zzew.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r9 = r18
            r1 = r19
            r2 = r22
        L_0x0320:
            r10 = r27
            r8 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0023
        L_0x0327:
            r25 = r6
            r1 = r8
            r27 = r10
            if (r7 == r1) goto L_0x0338
            long r1 = (long) r7
            r3 = r31
            r6 = r25
            r4 = r27
            r4.putInt(r3, r1, r6)
        L_0x0338:
            r4 = r34
            if (r0 != r4) goto L_0x033d
            return
        L_0x033d:
            com.google.android.recaptcha.internal.zzhp r0 = com.google.android.recaptcha.internal.zzhp.zzg()
            throw r0
        L_0x0342:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zzc(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzi(java.lang.Object, byte[], int, int, com.google.android.recaptcha.internal.zzev):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Map$Entry} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v144, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: java.util.Map$Entry} */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x05a0, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x05a1, code lost:
        r16 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x085a, code lost:
        r16 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x08cd, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x09e0, code lost:
        r11 = r11 + 3;
        r5 = r6;
        r6 = r16;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0510  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0558  */
    /* JADX WARNING: Removed duplicated region for block: B:340:0x09e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(java.lang.Object r18, com.google.android.recaptcha.internal.zzko r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            com.google.android.recaptcha.internal.zzkm r3 = com.google.android.recaptcha.internal.zzkm.DOUBLE
            int r3 = r0.zzp
            int r3 = r3 + -1
            r5 = 1
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            if (r3 == 0) goto L_0x052f
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0030
            com.google.android.recaptcha.internal.zzgr r3 = r0.zzo
            com.google.android.recaptcha.internal.zzgv r3 = r3.zzb(r1)
            com.google.android.recaptcha.internal.zzjp r8 = r3.zza
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x0030
            java.util.Iterator r3 = r3.zzf()
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0032
        L_0x0030:
            r3 = 0
            r8 = 0
        L_0x0032:
            int[] r9 = r0.zzc
            int r9 = r9.length
            r10 = r6
        L_0x0036:
            if (r10 >= r9) goto L_0x050e
            int r11 = r0.zzz(r10)
            int[] r12 = r0.zzc
            r12 = r12[r10]
        L_0x0040:
            if (r8 == 0) goto L_0x005e
            com.google.android.recaptcha.internal.zzgr r13 = r0.zzo
            int r13 = r13.zza(r8)
            if (r13 > r12) goto L_0x005e
            com.google.android.recaptcha.internal.zzgr r13 = r0.zzo
            r13.zzi(r2, r8)
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x005c
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0040
        L_0x005c:
            r8 = 0
            goto L_0x0040
        L_0x005e:
            int r13 = zzy(r11)
            switch(r13) {
                case 0: goto L_0x04fb;
                case 1: goto L_0x04eb;
                case 2: goto L_0x04db;
                case 3: goto L_0x04cb;
                case 4: goto L_0x04bb;
                case 5: goto L_0x04ab;
                case 6: goto L_0x049b;
                case 7: goto L_0x048a;
                case 8: goto L_0x0479;
                case 9: goto L_0x0464;
                case 10: goto L_0x0451;
                case 11: goto L_0x0440;
                case 12: goto L_0x042f;
                case 13: goto L_0x041e;
                case 14: goto L_0x040d;
                case 15: goto L_0x03fc;
                case 16: goto L_0x03eb;
                case 17: goto L_0x03d6;
                case 18: goto L_0x03c5;
                case 19: goto L_0x03b4;
                case 20: goto L_0x03a3;
                case 21: goto L_0x0392;
                case 22: goto L_0x0381;
                case 23: goto L_0x0370;
                case 24: goto L_0x035f;
                case 25: goto L_0x034e;
                case 26: goto L_0x033d;
                case 27: goto L_0x0328;
                case 28: goto L_0x0317;
                case 29: goto L_0x0306;
                case 30: goto L_0x02f5;
                case 31: goto L_0x02e4;
                case 32: goto L_0x02d3;
                case 33: goto L_0x02c2;
                case 34: goto L_0x02b1;
                case 35: goto L_0x02a0;
                case 36: goto L_0x028f;
                case 37: goto L_0x027e;
                case 38: goto L_0x026d;
                case 39: goto L_0x025c;
                case 40: goto L_0x024b;
                case 41: goto L_0x023a;
                case 42: goto L_0x0229;
                case 43: goto L_0x0218;
                case 44: goto L_0x0207;
                case 45: goto L_0x01f6;
                case 46: goto L_0x01e5;
                case 47: goto L_0x01d4;
                case 48: goto L_0x01c3;
                case 49: goto L_0x01ae;
                case 50: goto L_0x01a3;
                case 51: goto L_0x0192;
                case 52: goto L_0x0181;
                case 53: goto L_0x0170;
                case 54: goto L_0x015f;
                case 55: goto L_0x014e;
                case 56: goto L_0x013d;
                case 57: goto L_0x012c;
                case 58: goto L_0x011b;
                case 59: goto L_0x010a;
                case 60: goto L_0x00f5;
                case 61: goto L_0x00e2;
                case 62: goto L_0x00d1;
                case 63: goto L_0x00c0;
                case 64: goto L_0x00af;
                case 65: goto L_0x009e;
                case 66: goto L_0x008d;
                case 67: goto L_0x007c;
                case 68: goto L_0x0067;
                default: goto L_0x0065;
            }
        L_0x0065:
            goto L_0x050a
        L_0x0067:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            com.google.android.recaptcha.internal.zzjc r13 = r0.zzC(r10)
            r2.zzq(r12, r11, r13)
            goto L_0x050a
        L_0x007c:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = zzA(r1, r13)
            r2.zzD(r12, r13)
            goto L_0x050a
        L_0x008d:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = zzq(r1, r13)
            r2.zzB(r12, r11)
            goto L_0x050a
        L_0x009e:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = zzA(r1, r13)
            r2.zzz(r12, r13)
            goto L_0x050a
        L_0x00af:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = zzq(r1, r13)
            r2.zzx(r12, r11)
            goto L_0x050a
        L_0x00c0:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = zzq(r1, r13)
            r2.zzi(r12, r11)
            goto L_0x050a
        L_0x00d1:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = zzq(r1, r13)
            r2.zzI(r12, r11)
            goto L_0x050a
        L_0x00e2:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            com.google.android.recaptcha.internal.zzfi r11 = (com.google.android.recaptcha.internal.zzfi) r11
            r2.zzd(r12, r11)
            goto L_0x050a
        L_0x00f5:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            com.google.android.recaptcha.internal.zzjc r13 = r0.zzC(r10)
            r2.zzv(r12, r11, r13)
            goto L_0x050a
        L_0x010a:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            zzZ(r12, r11, r2)
            goto L_0x050a
        L_0x011b:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            boolean r11 = zzY(r1, r13)
            r2.zzb(r12, r11)
            goto L_0x050a
        L_0x012c:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = zzq(r1, r13)
            r2.zzk(r12, r11)
            goto L_0x050a
        L_0x013d:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = zzA(r1, r13)
            r2.zzm(r12, r13)
            goto L_0x050a
        L_0x014e:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = zzq(r1, r13)
            r2.zzr(r12, r11)
            goto L_0x050a
        L_0x015f:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = zzA(r1, r13)
            r2.zzK(r12, r13)
            goto L_0x050a
        L_0x0170:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = zzA(r1, r13)
            r2.zzt(r12, r13)
            goto L_0x050a
        L_0x0181:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            float r11 = zzo(r1, r13)
            r2.zzo(r12, r11)
            goto L_0x050a
        L_0x0192:
            boolean r13 = r0.zzX(r1, r12, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            double r13 = zzn(r1, r13)
            r2.zzf(r12, r13)
            goto L_0x050a
        L_0x01a3:
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            r0.zzQ(r2, r12, r11, r10)
            goto L_0x050a
        L_0x01ae:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzjc r13 = r0.zzC(r10)
            com.google.android.recaptcha.internal.zzje.zzM(r12, r11, r2, r13)
            goto L_0x050a
        L_0x01c3:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzT(r12, r11, r2, r5)
            goto L_0x050a
        L_0x01d4:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzS(r12, r11, r2, r5)
            goto L_0x050a
        L_0x01e5:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzR(r12, r11, r2, r5)
            goto L_0x050a
        L_0x01f6:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzQ(r12, r11, r2, r5)
            goto L_0x050a
        L_0x0207:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzI(r12, r11, r2, r5)
            goto L_0x050a
        L_0x0218:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzV(r12, r11, r2, r5)
            goto L_0x050a
        L_0x0229:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzF(r12, r11, r2, r5)
            goto L_0x050a
        L_0x023a:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzJ(r12, r11, r2, r5)
            goto L_0x050a
        L_0x024b:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzK(r12, r11, r2, r5)
            goto L_0x050a
        L_0x025c:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzN(r12, r11, r2, r5)
            goto L_0x050a
        L_0x026d:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzW(r12, r11, r2, r5)
            goto L_0x050a
        L_0x027e:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzO(r12, r11, r2, r5)
            goto L_0x050a
        L_0x028f:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzL(r12, r11, r2, r5)
            goto L_0x050a
        L_0x02a0:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzH(r12, r11, r2, r5)
            goto L_0x050a
        L_0x02b1:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzT(r12, r11, r2, r6)
            goto L_0x050a
        L_0x02c2:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzS(r12, r11, r2, r6)
            goto L_0x050a
        L_0x02d3:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzR(r12, r11, r2, r6)
            goto L_0x050a
        L_0x02e4:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzQ(r12, r11, r2, r6)
            goto L_0x050a
        L_0x02f5:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzI(r12, r11, r2, r6)
            goto L_0x050a
        L_0x0306:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzV(r12, r11, r2, r6)
            goto L_0x050a
        L_0x0317:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzG(r12, r11, r2)
            goto L_0x050a
        L_0x0328:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzjc r13 = r0.zzC(r10)
            com.google.android.recaptcha.internal.zzje.zzP(r12, r11, r2, r13)
            goto L_0x050a
        L_0x033d:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzU(r12, r11, r2)
            goto L_0x050a
        L_0x034e:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzF(r12, r11, r2, r6)
            goto L_0x050a
        L_0x035f:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzJ(r12, r11, r2, r6)
            goto L_0x050a
        L_0x0370:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzK(r12, r11, r2, r6)
            goto L_0x050a
        L_0x0381:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzN(r12, r11, r2, r6)
            goto L_0x050a
        L_0x0392:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzW(r12, r11, r2, r6)
            goto L_0x050a
        L_0x03a3:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzO(r12, r11, r2, r6)
            goto L_0x050a
        L_0x03b4:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzL(r12, r11, r2, r6)
            goto L_0x050a
        L_0x03c5:
            int[] r12 = r0.zzc
            r12 = r12[r10]
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            java.util.List r11 = (java.util.List) r11
            com.google.android.recaptcha.internal.zzje.zzH(r12, r11, r2, r6)
            goto L_0x050a
        L_0x03d6:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            com.google.android.recaptcha.internal.zzjc r13 = r0.zzC(r10)
            r2.zzq(r12, r11, r13)
            goto L_0x050a
        L_0x03eb:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = com.google.android.recaptcha.internal.zzkg.zzd(r1, r13)
            r2.zzD(r12, r13)
            goto L_0x050a
        L_0x03fc:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = com.google.android.recaptcha.internal.zzkg.zzc(r1, r13)
            r2.zzB(r12, r11)
            goto L_0x050a
        L_0x040d:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = com.google.android.recaptcha.internal.zzkg.zzd(r1, r13)
            r2.zzz(r12, r13)
            goto L_0x050a
        L_0x041e:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = com.google.android.recaptcha.internal.zzkg.zzc(r1, r13)
            r2.zzx(r12, r11)
            goto L_0x050a
        L_0x042f:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = com.google.android.recaptcha.internal.zzkg.zzc(r1, r13)
            r2.zzi(r12, r11)
            goto L_0x050a
        L_0x0440:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = com.google.android.recaptcha.internal.zzkg.zzc(r1, r13)
            r2.zzI(r12, r11)
            goto L_0x050a
        L_0x0451:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            com.google.android.recaptcha.internal.zzfi r11 = (com.google.android.recaptcha.internal.zzfi) r11
            r2.zzd(r12, r11)
            goto L_0x050a
        L_0x0464:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            com.google.android.recaptcha.internal.zzjc r13 = r0.zzC(r10)
            r2.zzv(r12, r11, r13)
            goto L_0x050a
        L_0x0479:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            java.lang.Object r11 = com.google.android.recaptcha.internal.zzkg.zzf(r1, r13)
            zzZ(r12, r11, r2)
            goto L_0x050a
        L_0x048a:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            boolean r11 = com.google.android.recaptcha.internal.zzkg.zzw(r1, r13)
            r2.zzb(r12, r11)
            goto L_0x050a
        L_0x049b:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = com.google.android.recaptcha.internal.zzkg.zzc(r1, r13)
            r2.zzk(r12, r11)
            goto L_0x050a
        L_0x04ab:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = com.google.android.recaptcha.internal.zzkg.zzd(r1, r13)
            r2.zzm(r12, r13)
            goto L_0x050a
        L_0x04bb:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            int r11 = com.google.android.recaptcha.internal.zzkg.zzc(r1, r13)
            r2.zzr(r12, r11)
            goto L_0x050a
        L_0x04cb:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = com.google.android.recaptcha.internal.zzkg.zzd(r1, r13)
            r2.zzK(r12, r13)
            goto L_0x050a
        L_0x04db:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            long r13 = com.google.android.recaptcha.internal.zzkg.zzd(r1, r13)
            r2.zzt(r12, r13)
            goto L_0x050a
        L_0x04eb:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            float r11 = com.google.android.recaptcha.internal.zzkg.zzb(r1, r13)
            r2.zzo(r12, r11)
            goto L_0x050a
        L_0x04fb:
            boolean r13 = r0.zzT(r1, r10)
            if (r13 == 0) goto L_0x050a
            r11 = r11 & r7
            long r13 = (long) r11
            double r13 = com.google.android.recaptcha.internal.zzkg.zza(r1, r13)
            r2.zzf(r12, r13)
        L_0x050a:
            int r10 = r10 + 3
            goto L_0x0036
        L_0x050e:
            if (r8 == 0) goto L_0x0525
            com.google.android.recaptcha.internal.zzgr r5 = r0.zzo
            r5.zzi(r2, r8)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0523
            java.lang.Object r5 = r3.next()
            r8 = r5
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x050e
        L_0x0523:
            r8 = 0
            goto L_0x050e
        L_0x0525:
            com.google.android.recaptcha.internal.zzjw r3 = r0.zzn
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzq(r1, r2)
            return
        L_0x052f:
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x054c
            com.google.android.recaptcha.internal.zzgr r3 = r0.zzo
            com.google.android.recaptcha.internal.zzgv r3 = r3.zzb(r1)
            com.google.android.recaptcha.internal.zzjp r8 = r3.zza
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L_0x054c
            java.util.Iterator r3 = r3.zzf()
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x054e
        L_0x054c:
            r3 = 0
            r8 = 0
        L_0x054e:
            int[] r9 = r0.zzc
            int r9 = r9.length
            sun.misc.Unsafe r10 = zzb
            r11 = r6
            r13 = r11
            r12 = r7
        L_0x0556:
            if (r11 >= r9) goto L_0x09e7
            int r14 = r0.zzz(r11)
            int[] r15 = r0.zzc
            r4 = r15[r11]
            int r6 = zzy(r14)
            r5 = 17
            if (r6 > r5) goto L_0x057c
            int r5 = r11 + 2
            r5 = r15[r5]
            r15 = r5 & r7
            if (r15 == r12) goto L_0x0576
            long r12 = (long) r15
            int r13 = r10.getInt(r1, r12)
            r12 = r15
        L_0x0576:
            int r5 = r5 >>> 20
            r15 = 1
            int r5 = r15 << r5
            goto L_0x057d
        L_0x057c:
            r5 = 0
        L_0x057d:
            if (r8 == 0) goto L_0x059b
            com.google.android.recaptcha.internal.zzgr r15 = r0.zzo
            int r15 = r15.zza(r8)
            if (r15 > r4) goto L_0x059b
            com.google.android.recaptcha.internal.zzgr r15 = r0.zzo
            r15.zzi(r2, r8)
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0599
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x057d
        L_0x0599:
            r8 = 0
            goto L_0x057d
        L_0x059b:
            r14 = r14 & r7
            long r14 = (long) r14
            switch(r6) {
                case 0: goto L_0x09d3;
                case 1: goto L_0x09c5;
                case 2: goto L_0x09b7;
                case 3: goto L_0x09a9;
                case 4: goto L_0x099b;
                case 5: goto L_0x098d;
                case 6: goto L_0x097f;
                case 7: goto L_0x0971;
                case 8: goto L_0x0962;
                case 9: goto L_0x094f;
                case 10: goto L_0x093e;
                case 11: goto L_0x092f;
                case 12: goto L_0x0920;
                case 13: goto L_0x0911;
                case 14: goto L_0x0902;
                case 15: goto L_0x08f3;
                case 16: goto L_0x08e4;
                case 17: goto L_0x08d1;
                case 18: goto L_0x08be;
                case 19: goto L_0x08ae;
                case 20: goto L_0x089e;
                case 21: goto L_0x088e;
                case 22: goto L_0x087e;
                case 23: goto L_0x086e;
                case 24: goto L_0x085e;
                case 25: goto L_0x084b;
                case 26: goto L_0x083b;
                case 27: goto L_0x0827;
                case 28: goto L_0x0817;
                case 29: goto L_0x0806;
                case 30: goto L_0x07f5;
                case 31: goto L_0x07e4;
                case 32: goto L_0x07d3;
                case 33: goto L_0x07c2;
                case 34: goto L_0x07b1;
                case 35: goto L_0x07a1;
                case 36: goto L_0x0791;
                case 37: goto L_0x0781;
                case 38: goto L_0x0771;
                case 39: goto L_0x0761;
                case 40: goto L_0x0751;
                case 41: goto L_0x0741;
                case 42: goto L_0x0731;
                case 43: goto L_0x0721;
                case 44: goto L_0x0711;
                case 45: goto L_0x0701;
                case 46: goto L_0x06f1;
                case 47: goto L_0x06e1;
                case 48: goto L_0x06d1;
                case 49: goto L_0x06be;
                case 50: goto L_0x06b5;
                case 51: goto L_0x06a6;
                case 52: goto L_0x0697;
                case 53: goto L_0x0688;
                case 54: goto L_0x0679;
                case 55: goto L_0x066a;
                case 56: goto L_0x065b;
                case 57: goto L_0x064c;
                case 58: goto L_0x063d;
                case 59: goto L_0x062e;
                case 60: goto L_0x061b;
                case 61: goto L_0x060b;
                case 62: goto L_0x05fd;
                case 63: goto L_0x05ef;
                case 64: goto L_0x05e1;
                case 65: goto L_0x05d3;
                case 66: goto L_0x05c5;
                case 67: goto L_0x05b7;
                case 68: goto L_0x05a5;
                default: goto L_0x05a0;
            }
        L_0x05a0:
            r6 = 1
        L_0x05a1:
            r16 = 0
            goto L_0x09e0
        L_0x05a5:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            java.lang.Object r5 = r10.getObject(r1, r14)
            com.google.android.recaptcha.internal.zzjc r6 = r0.zzC(r11)
            r2.zzq(r4, r5, r6)
            goto L_0x05a0
        L_0x05b7:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            long r5 = zzA(r1, r14)
            r2.zzD(r4, r5)
            goto L_0x05a0
        L_0x05c5:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            int r5 = zzq(r1, r14)
            r2.zzB(r4, r5)
            goto L_0x05a0
        L_0x05d3:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            long r5 = zzA(r1, r14)
            r2.zzz(r4, r5)
            goto L_0x05a0
        L_0x05e1:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            int r5 = zzq(r1, r14)
            r2.zzx(r4, r5)
            goto L_0x05a0
        L_0x05ef:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            int r5 = zzq(r1, r14)
            r2.zzi(r4, r5)
            goto L_0x05a0
        L_0x05fd:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            int r5 = zzq(r1, r14)
            r2.zzI(r4, r5)
            goto L_0x05a0
        L_0x060b:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            java.lang.Object r5 = r10.getObject(r1, r14)
            com.google.android.recaptcha.internal.zzfi r5 = (com.google.android.recaptcha.internal.zzfi) r5
            r2.zzd(r4, r5)
            goto L_0x05a0
        L_0x061b:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            java.lang.Object r5 = r10.getObject(r1, r14)
            com.google.android.recaptcha.internal.zzjc r6 = r0.zzC(r11)
            r2.zzv(r4, r5, r6)
            goto L_0x05a0
        L_0x062e:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            java.lang.Object r5 = r10.getObject(r1, r14)
            zzZ(r4, r5, r2)
            goto L_0x05a0
        L_0x063d:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            boolean r5 = zzY(r1, r14)
            r2.zzb(r4, r5)
            goto L_0x05a0
        L_0x064c:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            int r5 = zzq(r1, r14)
            r2.zzk(r4, r5)
            goto L_0x05a0
        L_0x065b:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            long r5 = zzA(r1, r14)
            r2.zzm(r4, r5)
            goto L_0x05a0
        L_0x066a:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            int r5 = zzq(r1, r14)
            r2.zzr(r4, r5)
            goto L_0x05a0
        L_0x0679:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            long r5 = zzA(r1, r14)
            r2.zzK(r4, r5)
            goto L_0x05a0
        L_0x0688:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            long r5 = zzA(r1, r14)
            r2.zzt(r4, r5)
            goto L_0x05a0
        L_0x0697:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            float r5 = zzo(r1, r14)
            r2.zzo(r4, r5)
            goto L_0x05a0
        L_0x06a6:
            boolean r5 = r0.zzX(r1, r4, r11)
            if (r5 == 0) goto L_0x05a0
            double r5 = zzn(r1, r14)
            r2.zzf(r4, r5)
            goto L_0x05a0
        L_0x06b5:
            java.lang.Object r5 = r10.getObject(r1, r14)
            r0.zzQ(r2, r4, r5, r11)
            goto L_0x05a0
        L_0x06be:
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzjc r6 = r0.zzC(r11)
            com.google.android.recaptcha.internal.zzje.zzM(r4, r5, r2, r6)
            goto L_0x05a0
        L_0x06d1:
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            r6 = 1
            com.google.android.recaptcha.internal.zzje.zzT(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x06e1:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzS(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x06f1:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzR(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0701:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzQ(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0711:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzI(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0721:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzV(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0731:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzF(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0741:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzJ(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0751:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzK(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0761:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzN(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0771:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzW(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0781:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzO(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x0791:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzL(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x07a1:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzH(r4, r5, r2, r6)
            goto L_0x05a1
        L_0x07b1:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            r14 = 0
            com.google.android.recaptcha.internal.zzje.zzT(r4, r5, r2, r14)
            goto L_0x085a
        L_0x07c2:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzS(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x07d3:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzR(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x07e4:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzQ(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x07f5:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzI(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x0806:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzV(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x0817:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzG(r4, r5, r2)
            goto L_0x05a1
        L_0x0827:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzjc r14 = r0.zzC(r11)
            com.google.android.recaptcha.internal.zzje.zzP(r4, r5, r2, r14)
            goto L_0x05a1
        L_0x083b:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            com.google.android.recaptcha.internal.zzje.zzU(r4, r5, r2)
            goto L_0x05a1
        L_0x084b:
            r6 = 1
            int[] r4 = r0.zzc
            r4 = r4[r11]
            java.lang.Object r5 = r10.getObject(r1, r14)
            java.util.List r5 = (java.util.List) r5
            r14 = 0
            com.google.android.recaptcha.internal.zzje.zzF(r4, r5, r2, r14)
        L_0x085a:
            r16 = r14
            goto L_0x09e0
        L_0x085e:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzJ(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x086e:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzK(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x087e:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzN(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x088e:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzW(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x089e:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzO(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x08ae:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzL(r5, r14, r2, r4)
            goto L_0x08cd
        L_0x08be:
            r4 = 0
            r6 = 1
            int[] r5 = r0.zzc
            r5 = r5[r11]
            java.lang.Object r14 = r10.getObject(r1, r14)
            java.util.List r14 = (java.util.List) r14
            com.google.android.recaptcha.internal.zzje.zzH(r5, r14, r2, r4)
        L_0x08cd:
            r16 = r4
            goto L_0x09e0
        L_0x08d1:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            java.lang.Object r5 = r10.getObject(r1, r14)
            com.google.android.recaptcha.internal.zzjc r14 = r0.zzC(r11)
            r2.zzq(r4, r5, r14)
            goto L_0x09e0
        L_0x08e4:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            long r14 = r10.getLong(r1, r14)
            r2.zzD(r4, r14)
            goto L_0x09e0
        L_0x08f3:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            int r5 = r10.getInt(r1, r14)
            r2.zzB(r4, r5)
            goto L_0x09e0
        L_0x0902:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            long r14 = r10.getLong(r1, r14)
            r2.zzz(r4, r14)
            goto L_0x09e0
        L_0x0911:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            int r5 = r10.getInt(r1, r14)
            r2.zzx(r4, r5)
            goto L_0x09e0
        L_0x0920:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            int r5 = r10.getInt(r1, r14)
            r2.zzi(r4, r5)
            goto L_0x09e0
        L_0x092f:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            int r5 = r10.getInt(r1, r14)
            r2.zzI(r4, r5)
            goto L_0x09e0
        L_0x093e:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            java.lang.Object r5 = r10.getObject(r1, r14)
            com.google.android.recaptcha.internal.zzfi r5 = (com.google.android.recaptcha.internal.zzfi) r5
            r2.zzd(r4, r5)
            goto L_0x09e0
        L_0x094f:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            java.lang.Object r5 = r10.getObject(r1, r14)
            com.google.android.recaptcha.internal.zzjc r14 = r0.zzC(r11)
            r2.zzv(r4, r5, r14)
            goto L_0x09e0
        L_0x0962:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            java.lang.Object r5 = r10.getObject(r1, r14)
            zzZ(r4, r5, r2)
            goto L_0x09e0
        L_0x0971:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            boolean r5 = com.google.android.recaptcha.internal.zzkg.zzw(r1, r14)
            r2.zzb(r4, r5)
            goto L_0x09e0
        L_0x097f:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            int r5 = r10.getInt(r1, r14)
            r2.zzk(r4, r5)
            goto L_0x09e0
        L_0x098d:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            long r14 = r10.getLong(r1, r14)
            r2.zzm(r4, r14)
            goto L_0x09e0
        L_0x099b:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            int r5 = r10.getInt(r1, r14)
            r2.zzr(r4, r5)
            goto L_0x09e0
        L_0x09a9:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            long r14 = r10.getLong(r1, r14)
            r2.zzK(r4, r14)
            goto L_0x09e0
        L_0x09b7:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            long r14 = r10.getLong(r1, r14)
            r2.zzt(r4, r14)
            goto L_0x09e0
        L_0x09c5:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            float r5 = com.google.android.recaptcha.internal.zzkg.zzb(r1, r14)
            r2.zzo(r4, r5)
            goto L_0x09e0
        L_0x09d3:
            r6 = 1
            r16 = 0
            r5 = r5 & r13
            if (r5 == 0) goto L_0x09e0
            double r14 = com.google.android.recaptcha.internal.zzkg.zza(r1, r14)
            r2.zzf(r4, r14)
        L_0x09e0:
            int r11 = r11 + 3
            r5 = r6
            r6 = r16
            goto L_0x0556
        L_0x09e7:
            if (r8 == 0) goto L_0x09fe
            com.google.android.recaptcha.internal.zzgr r4 = r0.zzo
            r4.zzi(r2, r8)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x09fc
            java.lang.Object r4 = r3.next()
            r8 = r4
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x09e7
        L_0x09fc:
            r8 = 0
            goto L_0x09e7
        L_0x09fe:
            com.google.android.recaptcha.internal.zzjw r3 = r0.zzn
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzq(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzis.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzko):void");
    }

    public final boolean zzk(Object obj, Object obj2) {
        boolean z11;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int zzz = zzz(i11);
            long j11 = (long) (zzz & 1048575);
            switch (zzy(zzz)) {
                case 0:
                    if (zzR(obj, obj2, i11) && Double.doubleToLongBits(zzkg.zza(obj, j11)) == Double.doubleToLongBits(zzkg.zza(obj2, j11))) {
                        continue;
                    }
                case 1:
                    if (zzR(obj, obj2, i11) && Float.floatToIntBits(zzkg.zzb(obj, j11)) == Float.floatToIntBits(zzkg.zzb(obj2, j11))) {
                        continue;
                    }
                case 2:
                    if (zzR(obj, obj2, i11) && zzkg.zzd(obj, j11) == zzkg.zzd(obj2, j11)) {
                        continue;
                    }
                case 3:
                    if (zzR(obj, obj2, i11) && zzkg.zzd(obj, j11) == zzkg.zzd(obj2, j11)) {
                        continue;
                    }
                case 4:
                    if (zzR(obj, obj2, i11) && zzkg.zzc(obj, j11) == zzkg.zzc(obj2, j11)) {
                        continue;
                    }
                case 5:
                    if (zzR(obj, obj2, i11) && zzkg.zzd(obj, j11) == zzkg.zzd(obj2, j11)) {
                        continue;
                    }
                case 6:
                    if (zzR(obj, obj2, i11) && zzkg.zzc(obj, j11) == zzkg.zzc(obj2, j11)) {
                        continue;
                    }
                case 7:
                    if (zzR(obj, obj2, i11) && zzkg.zzw(obj, j11) == zzkg.zzw(obj2, j11)) {
                        continue;
                    }
                case 8:
                    if (zzR(obj, obj2, i11) && zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11))) {
                        continue;
                    }
                case 9:
                    if (zzR(obj, obj2, i11) && zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11))) {
                        continue;
                    }
                case 10:
                    if (zzR(obj, obj2, i11) && zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11))) {
                        continue;
                    }
                case 11:
                    if (zzR(obj, obj2, i11) && zzkg.zzc(obj, j11) == zzkg.zzc(obj2, j11)) {
                        continue;
                    }
                case 12:
                    if (zzR(obj, obj2, i11) && zzkg.zzc(obj, j11) == zzkg.zzc(obj2, j11)) {
                        continue;
                    }
                case 13:
                    if (zzR(obj, obj2, i11) && zzkg.zzc(obj, j11) == zzkg.zzc(obj2, j11)) {
                        continue;
                    }
                case 14:
                    if (zzR(obj, obj2, i11) && zzkg.zzd(obj, j11) == zzkg.zzd(obj2, j11)) {
                        continue;
                    }
                case 15:
                    if (zzR(obj, obj2, i11) && zzkg.zzc(obj, j11) == zzkg.zzc(obj2, j11)) {
                        continue;
                    }
                case 16:
                    if (zzR(obj, obj2, i11) && zzkg.zzd(obj, j11) == zzkg.zzd(obj2, j11)) {
                        continue;
                    }
                case 17:
                    if (zzR(obj, obj2, i11) && zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11))) {
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
                    z11 = zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11));
                    break;
                case 50:
                    z11 = zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11));
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
                    long zzw = (long) (zzw(i11) & 1048575);
                    if (zzkg.zzc(obj, zzw) == zzkg.zzc(obj2, zzw) && zzje.zzX(zzkg.zzf(obj, j11), zzkg.zzf(obj2, j11))) {
                        continue;
                    }
            }
            if (!z11) {
                return false;
            }
        }
        if (!this.zzn.zzd(obj).equals(this.zzn.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzo.zzb(obj).equals(this.zzo.zzb(obj2));
        }
        return true;
    }

    public final boolean zzl(Object obj) {
        int i11;
        int i12;
        Object obj2 = obj;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i14 < this.zzk) {
            int i16 = this.zzj[i14];
            int i17 = this.zzc[i16];
            int zzz = zzz(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i21 = 1 << (i18 >>> 20);
            if (i19 != i15) {
                if (i19 != 1048575) {
                    i13 = zzb.getInt(obj2, (long) i19);
                }
                i11 = i13;
                i12 = i19;
            } else {
                i12 = i15;
                i11 = i13;
            }
            if ((268435456 & zzz) != 0 && !zzU(obj, i16, i12, i11, i21)) {
                return false;
            }
            int zzy = zzy(zzz);
            if (zzy != 9 && zzy != 17) {
                if (zzy != 27) {
                    if (zzy == 60 || zzy == 68) {
                        if (zzX(obj2, i17, i16) && !zzV(obj2, zzz, zzC(i16))) {
                            return false;
                        }
                    } else if (zzy != 49) {
                        if (zzy == 50 && !((zzij) zzkg.zzf(obj2, (long) (zzz & 1048575))).isEmpty()) {
                            zzii zzii = (zzii) zzE(i16);
                            throw null;
                        }
                    }
                }
                List list = (List) zzkg.zzf(obj2, (long) (zzz & 1048575));
                if (!list.isEmpty()) {
                    zzjc zzC = zzC(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zzC.zzl(list.get(i22))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzU(obj, i16, i12, i11, i21) && !zzV(obj2, zzz, zzC(i16))) {
                return false;
            }
            i14++;
            i15 = i12;
            i13 = i11;
        }
        if (!this.zzh || this.zzo.zzb(obj2).zzk()) {
            return true;
        }
        return false;
    }
}
