package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaii  reason: invalid package */
final class zzaii<T> implements zzair<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzajv.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzaif zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaht zzm;
    private final zzajl zzn;
    private final zzago zzo;
    private final zzaik zzp;
    private final zzaia zzq;

    private zzaii(int[] iArr, Object[] objArr, int i11, int i12, zzaif zzaif, int i13, boolean z11, int[] iArr2, int i14, int i15, zzaik zzaik, zzaht zzaht, zzajl zzajl, zzago zzago, zzaia zzaia) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i11;
        this.zzf = i12;
        this.zzi = zzaif instanceof zzaha;
        boolean z12 = false;
        if (zzago != null && zzago.zzh(zzaif)) {
            z12 = true;
        }
        this.zzh = z12;
        this.zzj = iArr2;
        this.zzk = i14;
        this.zzl = i15;
        this.zzp = zzaik;
        this.zzm = zzaht;
        this.zzn = zzajl;
        this.zzo = zzago;
        this.zzg = zzaif;
        this.zzq = zzaia;
    }

    private final Object zzA(Object obj, int i11) {
        zzair zzx = zzx(i11);
        int zzu = zzu(i11) & 1048575;
        if (!zzN(obj, i11)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, (long) zzu);
        if (zzQ(object)) {
            return object;
        }
        Object zze2 = zzx.zze();
        if (object != null) {
            zzx.zzg(zze2, object);
        }
        return zze2;
    }

    private final Object zzB(Object obj, int i11, int i12) {
        zzair zzx = zzx(i12);
        if (!zzR(obj, i11, i12)) {
            return zzx.zze();
        }
        Object object = zzb.getObject(obj, (long) (zzu(i12) & 1048575));
        if (zzQ(object)) {
            return object;
        }
        Object zze2 = zzx.zze();
        if (object != null) {
            zzx.zzg(zze2, object);
        }
        return zze2;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i11) {
        if (zzN(obj2, i11)) {
            Unsafe unsafe = zzb;
            long zzu = (long) (zzu(i11) & 1048575);
            Object object = unsafe.getObject(obj2, zzu);
            if (object != null) {
                zzair zzx = zzx(i11);
                if (!zzN(obj, i11)) {
                    if (!zzQ(object)) {
                        unsafe.putObject(obj, zzu, object);
                    } else {
                        Object zze2 = zzx.zze();
                        zzx.zzg(zze2, object);
                        unsafe.putObject(obj, zzu, zze2);
                    }
                    zzH(obj, i11);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzu);
                if (!zzQ(object2)) {
                    Object zze3 = zzx.zze();
                    zzx.zzg(zze3, object2);
                    unsafe.putObject(obj, zzu, zze3);
                    object2 = zze3;
                }
                zzx.zzg(object2, object);
                return;
            }
            int i12 = this.zzc[i11];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i12 + " is present but null: " + obj3);
        }
    }

    private final void zzF(Object obj, Object obj2, int i11) {
        int i12 = this.zzc[i11];
        if (zzR(obj2, i12, i11)) {
            Unsafe unsafe = zzb;
            long zzu = (long) (zzu(i11) & 1048575);
            Object object = unsafe.getObject(obj2, zzu);
            if (object != null) {
                zzair zzx = zzx(i11);
                if (!zzR(obj, i12, i11)) {
                    if (!zzQ(object)) {
                        unsafe.putObject(obj, zzu, object);
                    } else {
                        Object zze2 = zzx.zze();
                        zzx.zzg(zze2, object);
                        unsafe.putObject(obj, zzu, zze2);
                    }
                    zzI(obj, i12, i11);
                    return;
                }
                Object object2 = unsafe.getObject(obj, zzu);
                if (!zzQ(object2)) {
                    Object zze3 = zzx.zze();
                    zzx.zzg(zze3, object2);
                    unsafe.putObject(obj, zzu, zze3);
                    object2 = zze3;
                }
                zzx.zzg(object2, object);
                return;
            }
            int i13 = this.zzc[i11];
            String obj3 = obj2.toString();
            throw new IllegalStateException("Source subfield " + i13 + " is present but null: " + obj3);
        }
    }

    private final void zzG(Object obj, int i11, zzaiq zzaiq) throws IOException {
        if (zzM(i11)) {
            zzajv.zzs(obj, (long) (i11 & 1048575), zzaiq.zzs());
        } else if (this.zzi) {
            zzajv.zzs(obj, (long) (i11 & 1048575), zzaiq.zzr());
        } else {
            zzajv.zzs(obj, (long) (i11 & 1048575), zzaiq.zzp());
        }
    }

    private final void zzH(Object obj, int i11) {
        int zzr = zzr(i11);
        long j11 = (long) (1048575 & zzr);
        if (j11 != 1048575) {
            zzajv.zzq(obj, j11, (1 << (zzr >>> 20)) | zzajv.zzc(obj, j11));
        }
    }

    private final void zzI(Object obj, int i11, int i12) {
        zzajv.zzq(obj, (long) (zzr(i12) & 1048575), i11);
    }

    private final void zzJ(Object obj, int i11, Object obj2) {
        zzb.putObject(obj, (long) (zzu(i11) & 1048575), obj2);
        zzH(obj, i11);
    }

    private final void zzK(Object obj, int i11, int i12, Object obj2) {
        zzb.putObject(obj, (long) (zzu(i12) & 1048575), obj2);
        zzI(obj, i11, i12);
    }

    private final boolean zzL(Object obj, Object obj2, int i11) {
        return zzN(obj, i11) == zzN(obj2, i11);
    }

    private static boolean zzM(int i11) {
        return (i11 & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i11) {
        int zzr = zzr(i11);
        long j11 = (long) (zzr & 1048575);
        if (j11 == 1048575) {
            int zzu = zzu(i11);
            long j12 = (long) (zzu & 1048575);
            switch (zzt(zzu)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzajv.zza(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzajv.zzb(obj, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzajv.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzajv.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzajv.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzajv.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzajv.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzajv.zzw(obj, j12);
                case 8:
                    Object zzf2 = zzajv.zzf(obj, j12);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzafv)) {
                        throw new IllegalArgumentException();
                    } else if (!zzafv.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzajv.zzf(obj, j12) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzafv.zzb.equals(zzajv.zzf(obj, j12))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzajv.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzajv.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzajv.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzajv.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzajv.zzc(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzajv.zzd(obj, j12) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzajv.zzf(obj, j12) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((zzajv.zzc(obj, j11) & (1 << (zzr >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    private final boolean zzO(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzN(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean zzP(Object obj, int i11, zzair zzair) {
        return zzair.zzk(zzajv.zzf(obj, (long) (i11 & 1048575)));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzaha) {
            return ((zzaha) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i11, int i12) {
        if (zzajv.zzc(obj, (long) (zzr(i12) & 1048575)) == i11) {
            return true;
        }
        return false;
    }

    private static boolean zzS(Object obj, long j11) {
        return ((Boolean) zzajv.zzf(obj, j11)).booleanValue();
    }

    private static final void zzT(int i11, Object obj, zzagj zzagj) throws IOException {
        if (obj instanceof String) {
            zzagj.zzF(i11, (String) obj);
        } else {
            zzagj.zzd(i11, (zzafv) obj);
        }
    }

    public static zzajm zzd(Object obj) {
        zzaha zzaha = (zzaha) obj;
        zzajm zzajm = zzaha.zzc;
        if (zzajm != zzajm.zzc()) {
            return zzajm;
        }
        zzajm zzf2 = zzajm.zzf();
        zzaha.zzc = zzf2;
        return zzf2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0252  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x026d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.p002firebaseauthapi.zzaii zzl(java.lang.Class r30, com.google.android.gms.internal.p002firebaseauthapi.zzaic r31, com.google.android.gms.internal.p002firebaseauthapi.zzaik r32, com.google.android.gms.internal.p002firebaseauthapi.zzaht r33, com.google.android.gms.internal.p002firebaseauthapi.zzajl r34, com.google.android.gms.internal.p002firebaseauthapi.zzago r35, com.google.android.gms.internal.p002firebaseauthapi.zzaia r36) {
        /*
            r0 = r31
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzaip
            if (r1 == 0) goto L_0x03e9
            com.google.android.gms.internal.firebase-auth-api.zzaip r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaip) r0
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
            com.google.android.gms.internal.firebase-auth-api.zzaif r15 = r0.zza()
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
            if (r4 >= r2) goto L_0x03c4
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
            int r6 = r20 + 1
            r17[r20] = r21
            r20 = r6
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
            int r2 = r21 / 3
            int r2 = r2 + r2
            int r2 = r2 + r5
            int r5 = r16 + 1
            r16 = r10[r16]
            r12[r2] = r16
            goto L_0x0246
        L_0x023b:
            int r2 = r21 / 3
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
            java.lang.reflect.Field r2 = zzC(r15, r2)
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
            java.lang.reflect.Field r13 = zzC(r15, r13)
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
            java.lang.reflect.Field r13 = zzC(r15, r13)
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
            r17[r22] = r21
            int r22 = r21 / 3
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
            int r14 = r21 / 3
            int r14 = r14 + r14
            int r14 = r14 + r5
            int r24 = r2 + 1
            r2 = r10[r2]
            r12[r14] = r2
            goto L_0x0304
        L_0x02f7:
            r27 = r5
            r5 = 1
            int r14 = r21 / 3
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
            int r14 = r21 / 3
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
            java.lang.reflect.Field r5 = zzC(r15, r5)
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
            int r1 = r21 + 1
            r11[r21] = r4
            int r4 = r1 + 1
            r5 = r3 & 512(0x200, float:7.175E-43)
            if (r5 == 0) goto L_0x0393
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0394
        L_0x0393:
            r5 = 0
        L_0x0394:
            r13 = r3 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x039b
            r13 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x039c
        L_0x039b:
            r13 = 0
        L_0x039c:
            r3 = r3 & 2048(0x800, float:2.87E-42)
            if (r3 == 0) goto L_0x03a3
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x03a4
        L_0x03a3:
            r3 = 0
        L_0x03a4:
            int r6 = r6 << 20
            r5 = r5 | r13
            r3 = r3 | r5
            r3 = r3 | r6
            r2 = r2 | r3
            r11[r1] = r2
            int r21 = r4 + 1
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
        L_0x03c4:
            r27 = r13
            r29 = r14
            com.google.android.gms.internal.firebase-auth-api.zzaii r1 = new com.google.android.gms.internal.firebase-auth-api.zzaii
            com.google.android.gms.internal.firebase-auth-api.zzaif r14 = r0.zza()
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
        L_0x03e9:
            com.google.android.gms.internal.firebase-auth-api.zzajf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzajf) r0
            r0 = 0
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzl(java.lang.Class, com.google.android.gms.internal.firebase-auth-api.zzaic, com.google.android.gms.internal.firebase-auth-api.zzaik, com.google.android.gms.internal.firebase-auth-api.zzaht, com.google.android.gms.internal.firebase-auth-api.zzajl, com.google.android.gms.internal.firebase-auth-api.zzago, com.google.android.gms.internal.firebase-auth-api.zzaia):com.google.android.gms.internal.firebase-auth-api.zzaii");
    }

    private static double zzn(Object obj, long j11) {
        return ((Double) zzajv.zzf(obj, j11)).doubleValue();
    }

    private static float zzo(Object obj, long j11) {
        return ((Float) zzajv.zzf(obj, j11)).floatValue();
    }

    private static int zzp(Object obj, long j11) {
        return ((Integer) zzajv.zzf(obj, j11)).intValue();
    }

    private final int zzq(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzs(i11, 0);
    }

    private final int zzr(int i11) {
        return this.zzc[i11 + 2];
    }

    private final int zzs(int i11, int i12) {
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

    private static int zzt(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzu(int i11) {
        return this.zzc[i11 + 1];
    }

    private static long zzv(Object obj, long j11) {
        return ((Long) zzajv.zzf(obj, j11)).longValue();
    }

    private final zzahe zzw(int i11) {
        int i12 = i11 / 3;
        return (zzahe) this.zzd[i12 + i12 + 1];
    }

    private final zzair zzx(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzair zzair = (zzair) this.zzd[i13];
        if (zzair != null) {
            return zzair;
        }
        zzair zzb2 = zzain.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzy(Object obj, int i11, Object obj2, zzajl zzajl, Object obj3) {
        int i12 = this.zzc[i11];
        Object zzf2 = zzajv.zzf(obj, (long) (zzu(i11) & 1048575));
        if (zzf2 == null || zzw(i11) == null) {
            return obj2;
        }
        zzahz zzahz = (zzahz) zzf2;
        zzahy zzahy = (zzahy) zzz(i11);
        throw null;
    }

    private final Object zzz(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x037e, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x039c, code lost:
        r0 = r0 + (r1 * r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0414, code lost:
        r1 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x05bc, code lost:
        r2 = r2 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x05bd, code lost:
        r12 = r12 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x066e, code lost:
        r0 = r0 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x06d8, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:255:0x075c, code lost:
        r1 = r1 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x075d, code lost:
        r12 = r12 + r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:260:0x0772, code lost:
        r0 = r0 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x0789, code lost:
        r0 = r0 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x078d, code lost:
        r11 = r11 + 3;
        r0 = r14;
        r1 = r15;
        r9 = false;
        r10 = 1048575;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(java.lang.Object r19) {
        /*
            r18 = this;
            r6 = r18
            r7 = r19
            sun.misc.Unsafe r8 = zzb
            r9 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r9
            r11 = r1
            r12 = r11
            r0 = r10
        L_0x000e:
            int[] r2 = r6.zzc
            int r2 = r2.length
            r3 = 0
            if (r11 >= r2) goto L_0x0797
            int r2 = r6.zzu(r11)
            int r4 = zzt(r2)
            int[] r5 = r6.zzc
            r13 = r5[r11]
            int r14 = r11 + 2
            r5 = r5[r14]
            r14 = r5 & r10
            r15 = 17
            r16 = 1
            if (r4 > r15) goto L_0x0040
            if (r14 == r0) goto L_0x0039
            if (r14 != r10) goto L_0x0032
            r0 = r9
            goto L_0x0037
        L_0x0032:
            long r0 = (long) r14
            int r0 = r8.getInt(r7, r0)
        L_0x0037:
            r1 = r0
            r0 = r14
        L_0x0039:
            int r5 = r5 >>> 20
            int r5 = r16 << r5
            r14 = r0
            r15 = r1
            goto L_0x0043
        L_0x0040:
            r14 = r0
            r15 = r1
            r5 = r9
        L_0x0043:
            r0 = r2 & r10
            com.google.android.gms.internal.firebase-auth-api.zzagt r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagt.DOUBLE_LIST_PACKED
            int r1 = r1.zza()
            if (r4 < r1) goto L_0x0052
            com.google.android.gms.internal.firebase-auth-api.zzagt r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagt.SINT64_LIST_PACKED
            r1.zza()
        L_0x0052:
            long r1 = (long) r0
            r17 = 63
            switch(r4) {
                case 0: goto L_0x0776;
                case 1: goto L_0x075f;
                case 2: goto L_0x0740;
                case 3: goto L_0x0723;
                case 4: goto L_0x0706;
                case 5: goto L_0x06f1;
                case 6: goto L_0x06dc;
                case 7: goto L_0x06c5;
                case 8: goto L_0x068d;
                case 9: goto L_0x0671;
                case 10: goto L_0x0649;
                case 11: goto L_0x062b;
                case 12: goto L_0x060d;
                case 13: goto L_0x05f8;
                case 14: goto L_0x05e3;
                case 15: goto L_0x05c0;
                case 16: goto L_0x059b;
                case 17: goto L_0x057d;
                case 18: goto L_0x0570;
                case 19: goto L_0x0565;
                case 20: goto L_0x0544;
                case 21: goto L_0x0528;
                case 22: goto L_0x050c;
                case 23: goto L_0x0501;
                case 24: goto L_0x04f5;
                case 25: goto L_0x04da;
                case 26: goto L_0x0478;
                case 27: goto L_0x0438;
                case 28: goto L_0x0406;
                case 29: goto L_0x03ec;
                case 30: goto L_0x03d2;
                case 31: goto L_0x03c6;
                case 32: goto L_0x03ba;
                case 33: goto L_0x03a0;
                case 34: goto L_0x0381;
                case 35: goto L_0x0368;
                case 36: goto L_0x0351;
                case 37: goto L_0x033a;
                case 38: goto L_0x0323;
                case 39: goto L_0x030c;
                case 40: goto L_0x02f4;
                case 41: goto L_0x02dc;
                case 42: goto L_0x02c2;
                case 43: goto L_0x02aa;
                case 44: goto L_0x0292;
                case 45: goto L_0x027a;
                case 46: goto L_0x0262;
                case 47: goto L_0x024a;
                case 48: goto L_0x0232;
                case 49: goto L_0x0209;
                case 50: goto L_0x01da;
                case 51: goto L_0x01cc;
                case 52: goto L_0x01be;
                case 53: goto L_0x01a8;
                case 54: goto L_0x0192;
                case 55: goto L_0x017c;
                case 56: goto L_0x016e;
                case 57: goto L_0x0160;
                case 58: goto L_0x0152;
                case 59: goto L_0x0121;
                case 60: goto L_0x010d;
                case 61: goto L_0x00ee;
                case 62: goto L_0x00d8;
                case 63: goto L_0x00c2;
                case 64: goto L_0x00b4;
                case 65: goto L_0x00a6;
                case 66: goto L_0x008b;
                case 67: goto L_0x0070;
                case 68: goto L_0x005a;
                default: goto L_0x0058;
            }
        L_0x0058:
            goto L_0x078d
        L_0x005a:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzaif r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r0
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzw(r13, r0, r1)
            goto L_0x057a
        L_0x0070:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            long r0 = zzv(r7, r1)
            int r2 = r13 << 3
            long r3 = r0 + r0
            long r0 = r0 >> r17
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            long r0 = r0 ^ r3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzB(r0)
            goto L_0x05bc
        L_0x008b:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = zzp(r7, r1)
            int r1 = r13 << 3
            int r2 = r0 + r0
            int r0 = r0 >> 31
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            r0 = r0 ^ r2
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x075c
        L_0x00a6:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0789
        L_0x00b4:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0772
        L_0x00c2:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = zzp(r7, r1)
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzx(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x00d8:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = zzp(r7, r1)
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x00ee:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzafv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r0
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzf
            int r0 = r0.zzd()
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r2 = r2 + r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x066e
        L_0x010d:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r1)
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzh(r13, r0, r1)
            goto L_0x057a
        L_0x0121:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r1)
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzafv
            if (r1 == 0) goto L_0x0144
            com.google.android.gms.internal.firebase-auth-api.zzafv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r0
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzf
            int r0 = r0.zzd()
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r2 = r2 + r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x066e
        L_0x0144:
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzz(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x0152:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x06d8
        L_0x0160:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0772
        L_0x016e:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0789
        L_0x017c:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = zzp(r7, r1)
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzx(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x0192:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            long r0 = zzv(r7, r1)
            int r2 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzB(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x075c
        L_0x01a8:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            long r0 = zzv(r7, r1)
            int r2 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzB(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x075c
        L_0x01be:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0772
        L_0x01cc:
            boolean r0 = r6.zzR(r7, r13, r11)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0789
        L_0x01da:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.lang.Object r1 = r6.zzz(r11)
            com.google.android.gms.internal.firebase-auth-api.zzahz r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahz) r0
            com.google.android.gms.internal.firebase-auth-api.zzahy r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzahy) r1
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x078d
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x01fc
            goto L_0x078d
        L_0x01fc:
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r0.getKey()
            r0.getValue()
            throw r3
        L_0x0209:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r6.zzx(r11)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x021d
            r4 = r9
            goto L_0x022f
        L_0x021d:
            r3 = r9
            r4 = r3
        L_0x021f:
            if (r3 >= r2) goto L_0x022f
            java.lang.Object r5 = r0.get(r3)
            com.google.android.gms.internal.firebase-auth-api.zzaif r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzw(r13, r5, r1)
            int r4 = r4 + r5
            int r3 = r3 + 1
            goto L_0x021f
        L_0x022f:
            int r12 = r12 + r4
            goto L_0x078d
        L_0x0232:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzj(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x024a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzi(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x0262:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zze(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x027a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzc(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x0292:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x02aa:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzk(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x02c2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x02dc:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzc(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x02f4:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zze(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x030c:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzf(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x0323:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzl(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x033a:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzg(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x0351:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzc(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x037e
        L_0x0368:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zze(r0)
            if (r0 <= 0) goto L_0x078d
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
        L_0x037e:
            int r1 = r1 + r2
            goto L_0x075c
        L_0x0381:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0392
        L_0x038f:
            r0 = r9
            goto L_0x057a
        L_0x0392:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzj(r0)
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
        L_0x039c:
            int r1 = r1 * r2
            int r0 = r0 + r1
            goto L_0x057a
        L_0x03a0:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03af
            goto L_0x038f
        L_0x03af:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzi(r0)
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x039c
        L_0x03ba:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzd(r13, r0, r9)
            goto L_0x057a
        L_0x03c6:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzb(r13, r0, r9)
            goto L_0x057a
        L_0x03d2:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03e1
            goto L_0x038f
        L_0x03e1:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza(r0)
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x039c
        L_0x03ec:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x03fb
            goto L_0x038f
        L_0x03fb:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzk(r0)
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x039c
        L_0x0406:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0417
        L_0x0414:
            r1 = r9
            goto L_0x075d
        L_0x0417:
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            int r1 = r1 * r2
            r2 = r9
        L_0x041f:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x075d
            java.lang.Object r3 = r0.get(r2)
            com.google.android.gms.internal.firebase-auth-api.zzafv r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r3
            int r3 = r3.zzd()
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r3)
            int r4 = r4 + r3
            int r1 = r1 + r4
            int r2 = r2 + 1
            goto L_0x041f
        L_0x0438:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r6.zzx(r11)
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r2 = r0.size()
            if (r2 != 0) goto L_0x044c
            r3 = r9
            goto L_0x0475
        L_0x044c:
            int r3 = r13 << 3
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r3)
            int r3 = r3 * r2
            r4 = r9
        L_0x0454:
            if (r4 >= r2) goto L_0x0475
            java.lang.Object r5 = r0.get(r4)
            boolean r13 = r5 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahl
            if (r13 == 0) goto L_0x046b
            com.google.android.gms.internal.firebase-auth-api.zzahl r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzahl) r5
            int r5 = r5.zza()
            int r13 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r5)
            int r13 = r13 + r5
            int r3 = r3 + r13
            goto L_0x0472
        L_0x046b:
            com.google.android.gms.internal.firebase-auth-api.zzaif r5 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r5
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzy(r5, r1)
            int r3 = r3 + r5
        L_0x0472:
            int r4 = r4 + 1
            goto L_0x0454
        L_0x0475:
            int r12 = r12 + r3
            goto L_0x078d
        L_0x0478:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0489
            r2 = r9
            goto L_0x05bd
        L_0x0489:
            int r2 = r13 << 3
            boolean r3 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahn
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            int r2 = r2 * r1
            if (r3 == 0) goto L_0x04b8
            com.google.android.gms.internal.firebase-auth-api.zzahn r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahn) r0
            r3 = r9
        L_0x0497:
            if (r3 >= r1) goto L_0x05bd
            java.lang.Object r4 = r0.zzf(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzafv
            if (r5 == 0) goto L_0x04ae
            com.google.android.gms.internal.firebase-auth-api.zzafv r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04b5
        L_0x04ae:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzz(r4)
            int r2 = r2 + r4
        L_0x04b5:
            int r3 = r3 + 1
            goto L_0x0497
        L_0x04b8:
            r3 = r9
        L_0x04b9:
            if (r3 >= r1) goto L_0x05bd
            java.lang.Object r4 = r0.get(r3)
            boolean r5 = r4 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzafv
            if (r5 == 0) goto L_0x04d0
            com.google.android.gms.internal.firebase-auth-api.zzafv r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r4
            int r4 = r4.zzd()
            int r5 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r4)
            int r5 = r5 + r4
            int r2 = r2 + r5
            goto L_0x04d7
        L_0x04d0:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzz(r4)
            int r2 = r2 + r4
        L_0x04d7:
            int r3 = r3 + 1
            goto L_0x04b9
        L_0x04da:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r0 = r0.size()
            if (r0 != 0) goto L_0x04ea
            goto L_0x038f
        L_0x04ea:
            int r1 = r13 << 3
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            int r1 = r1 + 1
            int r0 = r0 * r1
            goto L_0x057a
        L_0x04f5:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzb(r13, r0, r9)
            goto L_0x057a
        L_0x0501:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzd(r13, r0, r9)
            goto L_0x057a
        L_0x050c:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x051c
            goto L_0x038f
        L_0x051c:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzf(r0)
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x039c
        L_0x0528:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0538
            goto L_0x038f
        L_0x0538:
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzl(r0)
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x039c
        L_0x0544:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zza
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0554
            goto L_0x0414
        L_0x0554:
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzg(r0)
            int r0 = r0.size()
            int r2 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            int r0 = r0 * r2
            goto L_0x075c
        L_0x0565:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzb(r13, r0, r9)
            goto L_0x057a
        L_0x0570:
            java.lang.Object r0 = r8.getObject(r7, r1)
            java.util.List r0 = (java.util.List) r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzd(r13, r0, r9)
        L_0x057a:
            int r12 = r12 + r0
            goto L_0x078d
        L_0x057d:
            r0 = r18
            r3 = r1
            r1 = r19
            r2 = r11
            r9 = r3
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzaif r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r0
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzw(r13, r0, r1)
            goto L_0x057a
        L_0x059b:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            long r0 = r8.getLong(r7, r9)
            int r2 = r13 << 3
            long r3 = r0 + r0
            long r0 = r0 >> r17
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            long r0 = r0 ^ r3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzB(r0)
        L_0x05bc:
            int r2 = r2 + r0
        L_0x05bd:
            int r12 = r12 + r2
            goto L_0x078d
        L_0x05c0:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r8.getInt(r7, r9)
            int r1 = r13 << 3
            int r2 = r0 + r0
            int r0 = r0 >> 31
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            r0 = r0 ^ r2
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x075c
        L_0x05e3:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0789
        L_0x05f8:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0772
        L_0x060d:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r8.getInt(r7, r9)
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzx(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x062b:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r8.getInt(r7, r9)
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x0649:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzafv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r0
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzf
            int r0 = r0.zzd()
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r2 = r2 + r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
        L_0x066e:
            int r0 = r0 + r2
            goto L_0x057a
        L_0x0671:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r9)
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r6.zzx(r11)
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzh(r13, r0, r1)
            goto L_0x057a
        L_0x068d:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            java.lang.Object r0 = r8.getObject(r7, r9)
            boolean r1 = r0 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzafv
            if (r1 == 0) goto L_0x06b7
            com.google.android.gms.internal.firebase-auth-api.zzafv r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzafv) r0
            int r1 = r13 << 3
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzf
            int r0 = r0.zzd()
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            int r2 = r2 + r0
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x066e
        L_0x06b7:
            java.lang.String r0 = (java.lang.String) r0
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzz(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x06c5:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
        L_0x06d8:
            int r0 = r0 + 1
            goto L_0x057a
        L_0x06dc:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0772
        L_0x06f1:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
            goto L_0x0789
        L_0x0706:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r8.getInt(r7, r9)
            int r1 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzx(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r1)
            goto L_0x075c
        L_0x0723:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            long r0 = r8.getLong(r7, r9)
            int r2 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzB(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
            goto L_0x075c
        L_0x0740:
            r9 = r1
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            long r0 = r8.getLong(r7, r9)
            int r2 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzB(r0)
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r2)
        L_0x075c:
            int r1 = r1 + r0
        L_0x075d:
            int r12 = r12 + r1
            goto L_0x078d
        L_0x075f:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
        L_0x0772:
            int r0 = r0 + 4
            goto L_0x057a
        L_0x0776:
            r0 = r18
            r1 = r19
            r2 = r11
            r3 = r14
            r4 = r15
            boolean r0 = r0.zzO(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x078d
            int r0 = r13 << 3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzagi.zzA(r0)
        L_0x0789:
            int r0 = r0 + 8
            goto L_0x057a
        L_0x078d:
            int r11 = r11 + 3
            r0 = r14
            r1 = r15
            r9 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x000e
        L_0x0797:
            com.google.android.gms.internal.firebase-auth-api.zzajl r0 = r6.zzn
            java.lang.Object r1 = r0.zzd(r7)
            int r0 = r0.zza(r1)
            int r12 = r12 + r0
            boolean r0 = r6.zzh
            if (r0 != 0) goto L_0x07a7
            return r12
        L_0x07a7:
            com.google.android.gms.internal.firebase-auth-api.zzago r0 = r6.zzo
            r0.zza(r7)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaii.zza(java.lang.Object):int");
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
            int r3 = r9.zzu(r1)
            int[] r4 = r9.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            int r3 = zzt(r3)
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
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x0033:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzv(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0043:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x0051:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzv(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0061:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x006f:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x007d:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x008b:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x009d:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x00af:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x00c3:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            boolean r3 = zzS(r10, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zza(r3)
            goto L_0x0214
        L_0x00d5:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x00e3:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzv(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x00f3:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            int r3 = zzp(r10, r5)
            goto L_0x0214
        L_0x0101:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzv(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0111:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            long r3 = zzv(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0121:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            float r3 = zzo(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0214
        L_0x0133:
            boolean r3 = r9.zzR(r10, r4, r1)
            if (r3 == 0) goto L_0x0215
            int r2 = r2 * 53
            double r3 = zzn(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0147:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x0153:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x015f:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b4
            int r7 = r3.hashCode()
            goto L_0x01b4
        L_0x016a:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0174:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzc(r10, r5)
            goto L_0x0214
        L_0x017c:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x0186:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzc(r10, r5)
            goto L_0x0214
        L_0x018e:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzc(r10, r5)
            goto L_0x0214
        L_0x0196:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzc(r10, r5)
            goto L_0x0214
        L_0x019e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x01aa:
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            if (r3 == 0) goto L_0x01b4
            int r7 = r3.hashCode()
        L_0x01b4:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0215
        L_0x01b8:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r10, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0214
        L_0x01c5:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzw(r10, r5)
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zza(r3)
            goto L_0x0214
        L_0x01d0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzc(r10, r5)
            goto L_0x0214
        L_0x01d7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x01e0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzc(r10, r5)
            goto L_0x0214
        L_0x01e7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x01f0:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzd(r10, r5)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
            goto L_0x0210
        L_0x01f9:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzb(r10, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0214
        L_0x0204:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zza(r10, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            byte[] r5 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzd
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
            com.google.android.gms.internal.firebase-auth-api.zzajl r0 = r9.zzn
            java.lang.Object r0 = r0.zzd(r10)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r9.zzh
            if (r0 != 0) goto L_0x022b
            return r2
        L_0x022b:
            com.google.android.gms.internal.firebase-auth-api.zzago r0 = r9.zzo
            r0.zza(r10)
            r10 = 0
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzb(java.lang.Object):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v4, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r36v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v11, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v98, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v99, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v101, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v103, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v105, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v108, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v21, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v57, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v39, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v65, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v68, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v69, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v40, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v24, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v72, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v74, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v75, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v78, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v71, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v81, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v42, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v126, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v27, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v131, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v132, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v137, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v28, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v138, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v30, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v141, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v31, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v34, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v145, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v35, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v147, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v148, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v149, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v151, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v153, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v155, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v156, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v157, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v38, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v159, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v161, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v36, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v165, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v166, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v168, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v41, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v174, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v176, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v86, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v177, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v59, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v178, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v60, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v43, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v179, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v180, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v44, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v61, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v184, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v62, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v188, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v63, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v45, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v189, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v64, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v46, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v191, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v192, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v66, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v193, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v194, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v197, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v48, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v200, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v201, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v204, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v133, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v205, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v206, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v207, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v209, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v211, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v214, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v50, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v215, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v51, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v217, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v218, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v219, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v220, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v221, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v52, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v53, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v222, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v223, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v224, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v54, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v225, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v55, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v45, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v228, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v77, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v80, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v47, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v47, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v58, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v232, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v89, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v111, resolved type: byte} */
    /* JADX WARNING: type inference failed for: r3v73, types: [int] */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x05ef  */
    /* JADX WARNING: Removed duplicated region for block: B:542:0x0791 A[SYNTHETIC] */
    public final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.p002firebaseauthapi.zzafi r39) throws java.io.IOException {
        /*
            r33 = this;
            r6 = r33
            r7 = r34
            r15 = r35
            r14 = r37
            r13 = r38
            r12 = r39
            zzD(r34)
            sun.misc.Unsafe r11 = zzb
            r16 = 0
            r10 = -1
            r0 = r36
            r1 = r10
            r2 = r16
            r3 = r2
            r4 = r3
            r5 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r14) goto L_0x0c0e
            int r3 = r0 + 1
            byte r0 = r15[r0]
            if (r0 >= 0) goto L_0x002f
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzi(r0, r15, r3, r12)
            int r3 = r12.zza
            r8 = r3
            r3 = r0
            goto L_0x0030
        L_0x002f:
            r8 = r0
        L_0x0030:
            int r0 = r8 >>> 3
            r9 = 3
            if (r0 <= r1) goto L_0x0045
            int r2 = r2 / r9
            int r1 = r6.zze
            if (r0 < r1) goto L_0x0043
            int r1 = r6.zzf
            if (r0 > r1) goto L_0x0043
            int r1 = r6.zzs(r0, r2)
            goto L_0x0049
        L_0x0043:
            r1 = r10
            goto L_0x0049
        L_0x0045:
            int r1 = r6.zzq(r0)
        L_0x0049:
            r2 = r1
            r18 = 0
            if (r2 != r10) goto L_0x005e
            r2 = r3
            r20 = r4
            r17 = r5
            r9 = r8
            r19 = r10
            r4 = r11
            r5 = r12
            r8 = r13
            r14 = r16
            r3 = r0
            goto L_0x0bb3
        L_0x005e:
            r1 = r8 & 7
            int[] r10 = r6.zzc
            int r20 = r2 + 1
            r9 = r10[r20]
            r20 = r0
            int r0 = zzt(r9)
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r9 & r17
            long r13 = (long) r13
            r21 = r8
            r22 = 0
            java.lang.String r8 = ""
            r26 = r8
            r8 = 17
            if (r0 > r8) goto L_0x0347
            int r8 = r2 + 2
            r8 = r10[r8]
            int r10 = r8 >>> 20
            r24 = 1
            int r28 = r24 << r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r10
            if (r8 == r5) goto L_0x00a2
            if (r5 == r10) goto L_0x0094
            long r5 = (long) r5
            r11.putInt(r7, r5, r4)
        L_0x0094:
            if (r8 != r10) goto L_0x0099
            r4 = r16
            goto L_0x009e
        L_0x0099:
            long r4 = (long) r8
            int r4 = r11.getInt(r7, r4)
        L_0x009e:
            r6 = r4
            r17 = r8
            goto L_0x00a5
        L_0x00a2:
            r6 = r4
            r17 = r5
        L_0x00a5:
            switch(r0) {
                case 0: goto L_0x0305;
                case 1: goto L_0x02ec;
                case 2: goto L_0x02bb;
                case 3: goto L_0x02bb;
                case 4: goto L_0x0297;
                case 5: goto L_0x026f;
                case 6: goto L_0x025b;
                case 7: goto L_0x0240;
                case 8: goto L_0x01f0;
                case 9: goto L_0x01b3;
                case 10: goto L_0x0192;
                case 11: goto L_0x0297;
                case 12: goto L_0x0142;
                case 13: goto L_0x025b;
                case 14: goto L_0x026f;
                case 15: goto L_0x011a;
                case 16: goto L_0x00f4;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            r10 = r2
            r9 = r3
            r8 = r20
            r20 = r21
            r0 = 3
            r3 = r33
            if (r1 != r0) goto L_0x032d
            java.lang.Object r0 = r3.zzA(r7, r10)
            int r1 = r8 << 3
            r13 = r1 | 4
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r3.zzx(r10)
            r4 = r8
            r2 = r20
            r8 = r0
            r5 = r9
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r1
            r1 = r10
            r19 = -1
            r10 = r35
            r20 = r4
            r4 = r11
            r11 = r5
            r5 = r12
            r12 = r37
            r5 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzl(r8, r9, r10, r11, r12, r13, r14)
            r3.zzJ(r7, r1, r0)
            r0 = r6 | r28
            r13 = r38
            r12 = r39
            r6 = r3
            r11 = r4
            r14 = r5
            r5 = r17
            r10 = r19
            r4 = r0
            r3 = r2
            r0 = r8
            r2 = r1
            r1 = r20
            goto L_0x001e
        L_0x00f4:
            if (r1 != 0) goto L_0x0114
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r3, r12)
            long r0 = r12.zzb
            long r4 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzG(r0)
            r9 = r20
            r0 = r11
            r1 = r34
            r10 = r2
            r2 = r13
            r0.putLong(r1, r2, r4)
            r4 = r6 | r28
            r6 = r33
            r14 = r37
            r13 = r38
            r0 = r8
            goto L_0x0134
        L_0x0114:
            r5 = r37
            r1 = r2
            r0 = r3
            goto L_0x0189
        L_0x011a:
            r10 = r2
            r9 = r20
            if (r1 != 0) goto L_0x013c
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r3, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzF(r1)
            r11.putInt(r7, r13, r1)
            r4 = r6 | r28
            r6 = r33
            r14 = r37
            r13 = r38
        L_0x0134:
            r1 = r9
            r2 = r10
            r5 = r17
            r3 = r21
            goto L_0x032a
        L_0x013c:
            r5 = r37
            r0 = r3
            r20 = r9
            goto L_0x0188
        L_0x0142:
            r10 = r2
            r8 = r20
            if (r1 != 0) goto L_0x0183
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r3, r12)
            int r1 = r12.zza
            r5 = r33
            com.google.android.gms.internal.firebase-auth-api.zzahe r2 = r5.zzw(r10)
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r9
            if (r3 == 0) goto L_0x017d
            if (r2 == 0) goto L_0x017d
            boolean r2 = r2.zza()
            if (r2 == 0) goto L_0x0161
            goto L_0x017d
        L_0x0161:
            com.google.android.gms.internal.firebase-auth-api.zzajm r2 = zzd(r34)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r9 = r21
            r2.zzj(r9, r1)
            r14 = r37
            r13 = r38
            r4 = r6
            r1 = r8
            r3 = r9
            r2 = r10
            r10 = -1
            r6 = r5
            r5 = r17
            goto L_0x001e
        L_0x017d:
            r9 = r21
            r11.putInt(r7, r13, r1)
            goto L_0x01a5
        L_0x0183:
            r5 = r37
            r0 = r3
            r20 = r8
        L_0x0188:
            r1 = r10
        L_0x0189:
            r4 = r11
            r2 = r21
            r19 = -1
            r3 = r33
            goto L_0x0338
        L_0x0192:
            r5 = r33
            r10 = r2
            r8 = r20
            r9 = r21
            r0 = 2
            if (r1 != r0) goto L_0x01e3
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zza(r15, r3, r12)
            java.lang.Object r1 = r12.zzc
            r11.putObject(r7, r13, r1)
        L_0x01a5:
            r4 = r6 | r28
            r14 = r37
            r13 = r38
            r6 = r5
            r1 = r8
            r3 = r9
            r2 = r10
            r5 = r17
            goto L_0x032a
        L_0x01b3:
            r5 = r33
            r10 = r2
            r8 = r20
            r9 = r21
            r0 = 2
            if (r1 != r0) goto L_0x01e3
            java.lang.Object r13 = r5.zzA(r7, r10)
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r5.zzx(r10)
            r0 = r13
            r2 = r35
            r4 = r37
            r14 = r5
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzm(r0, r1, r2, r3, r4, r5)
            r14.zzJ(r7, r10, r13)
            r4 = r6 | r28
            r13 = r38
            r1 = r8
            r3 = r9
            r2 = r10
            r6 = r14
            r5 = r17
            r10 = -1
            r14 = r37
            goto L_0x001e
        L_0x01e3:
            r0 = r3
            r3 = r5
            r20 = r8
            r2 = r9
            r1 = r10
            r4 = r11
            r19 = -1
            r5 = r37
            goto L_0x0338
        L_0x01f0:
            r4 = r33
            r10 = r2
            r8 = r20
            r20 = r21
            r0 = 2
            if (r1 != r0) goto L_0x0291
            boolean r0 = zzM(r9)
            if (r0 == 0) goto L_0x021b
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r3, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x0216
            if (r1 != 0) goto L_0x020f
            r2 = r26
            r12.zzc = r2
            goto L_0x0234
        L_0x020f:
            java.lang.String r2 = com.google.android.gms.internal.p002firebaseauthapi.zzaka.zzd(r15, r0, r1)
            r12.zzc = r2
            goto L_0x0233
        L_0x0216:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x021b:
            r2 = r26
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r3, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x023b
            if (r1 != 0) goto L_0x022a
            r12.zzc = r2
            goto L_0x0234
        L_0x022a:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzb
            r2.<init>(r15, r0, r1, r3)
            r12.zzc = r2
        L_0x0233:
            int r0 = r0 + r1
        L_0x0234:
            java.lang.Object r1 = r12.zzc
            r11.putObject(r7, r13, r1)
            goto L_0x02aa
        L_0x023b:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x0240:
            r4 = r33
            r10 = r2
            r8 = r20
            r20 = r21
            if (r1 != 0) goto L_0x0291
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r3, r12)
            long r1 = r12.zzb
            int r1 = (r1 > r22 ? 1 : (r1 == r22 ? 0 : -1))
            if (r1 == 0) goto L_0x0255
            r1 = 1
            goto L_0x0257
        L_0x0255:
            r1 = r16
        L_0x0257:
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzm(r7, r13, r1)
            goto L_0x02aa
        L_0x025b:
            r4 = r33
            r10 = r2
            r8 = r20
            r20 = r21
            r0 = 5
            if (r1 != r0) goto L_0x0291
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r3)
            r11.putInt(r7, r13, r0)
            int r0 = r3 + 4
            goto L_0x02aa
        L_0x026f:
            r4 = r33
            r10 = r2
            r8 = r20
            r20 = r21
            r0 = 1
            if (r1 != r0) goto L_0x0291
            long r21 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r3)
            r0 = r11
            r1 = r34
            r9 = r3
            r2 = r13
            r13 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r9 + 8
            r4 = r6 | r28
            r14 = r37
            r1 = r8
            goto L_0x02dd
        L_0x0291:
            r5 = r37
            r0 = r3
            r3 = r4
            goto L_0x0330
        L_0x0297:
            r4 = r33
            r10 = r2
            r9 = r3
            r8 = r20
            r20 = r21
            if (r1 != 0) goto L_0x02e8
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r9, r12)
            int r1 = r12.zza
            r11.putInt(r7, r13, r1)
        L_0x02aa:
            r1 = r6 | r28
            r14 = r37
            r13 = r38
            r6 = r4
            r2 = r10
            r5 = r17
            r3 = r20
            r10 = -1
            r4 = r1
            r1 = r8
            goto L_0x001e
        L_0x02bb:
            r4 = r33
            r10 = r2
            r9 = r3
            r8 = r20
            r20 = r21
            if (r1 != 0) goto L_0x02e8
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r9, r12)
            long r2 = r12.zzb
            r0 = r11
            r1 = r34
            r21 = r2
            r2 = r13
            r13 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            r4 = r6 | r28
            r14 = r37
            r1 = r8
            r0 = r9
        L_0x02dd:
            r2 = r10
            r6 = r13
            r5 = r17
            r3 = r20
            r10 = -1
            r13 = r38
            goto L_0x001e
        L_0x02e8:
            r5 = r37
            r3 = r4
            goto L_0x032f
        L_0x02ec:
            r10 = r2
            r9 = r3
            r8 = r20
            r20 = r21
            r0 = 5
            r3 = r33
            if (r1 != r0) goto L_0x032d
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r9)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzp(r7, r13, r0)
            int r0 = r9 + 4
            goto L_0x031d
        L_0x0305:
            r10 = r2
            r9 = r3
            r8 = r20
            r20 = r21
            r0 = 1
            r3 = r33
            if (r1 != r0) goto L_0x032d
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r9)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzo(r7, r13, r0)
            int r0 = r9 + 8
        L_0x031d:
            r4 = r6 | r28
            r14 = r37
            r13 = r38
            r6 = r3
            r1 = r8
            r2 = r10
            r5 = r17
            r3 = r20
        L_0x032a:
            r10 = -1
            goto L_0x001e
        L_0x032d:
            r5 = r37
        L_0x032f:
            r0 = r9
        L_0x0330:
            r1 = r10
            r4 = r11
            r2 = r20
            r19 = -1
            r20 = r8
        L_0x0338:
            r8 = r38
            r14 = r1
            r9 = r2
            r5 = r12
            r2 = r0
            r31 = r6
            r6 = r3
            r3 = r20
            r20 = r31
            goto L_0x0bb3
        L_0x0347:
            r8 = r2
            r17 = r5
            r24 = r20
            r2 = r26
            r19 = -1
            r5 = r37
            r20 = r4
            r4 = r11
            r31 = r21
            r21 = r3
            r3 = r6
            r6 = r31
            r11 = 27
            r26 = 10
            if (r0 != r11) goto L_0x03bb
            r11 = 2
            if (r1 != r11) goto L_0x03af
            java.lang.Object r0 = r4.getObject(r7, r13)
            com.google.android.gms.internal.firebase-auth-api.zzahf r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzahf) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0383
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0378
            goto L_0x037a
        L_0x0378:
            int r26 = r1 + r1
        L_0x037a:
            r1 = r26
            com.google.android.gms.internal.firebase-auth-api.zzahf r0 = r0.zzd(r1)
            r4.putObject(r7, r13, r0)
        L_0x0383:
            r13 = r0
            com.google.android.gms.internal.firebase-auth-api.zzair r0 = r3.zzx(r8)
            r1 = r8
            r8 = r0
            r9 = r6
            r10 = r35
            r0 = r24
            r11 = r21
            r2 = r12
            r12 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zze(r8, r9, r10, r11, r12, r13, r14)
            r13 = r38
            r12 = r2
            r11 = r4
            r14 = r5
            r5 = r17
            r10 = r19
            r4 = r20
            r2 = r1
            r1 = r0
            r0 = r8
            r31 = r6
            r6 = r3
            r3 = r31
            goto L_0x001e
        L_0x03af:
            r28 = r4
            r4 = r5
            r2 = r8
            r8 = r12
            r12 = r21
            r5 = r3
            r3 = r24
            goto L_0x0925
        L_0x03bb:
            r11 = r24
            r3 = 49
            if (r0 > r3) goto L_0x08ed
            long r9 = (long) r9
            sun.misc.Unsafe r3 = zzb
            java.lang.Object r24 = r3.getObject(r7, r13)
            r28 = r4
            r4 = r24
            com.google.android.gms.internal.firebase-auth-api.zzahf r4 = (com.google.android.gms.internal.p002firebaseauthapi.zzahf) r4
            boolean r24 = r4.zzc()
            if (r24 != 0) goto L_0x03ea
            int r24 = r4.size()
            if (r24 != 0) goto L_0x03db
            goto L_0x03dd
        L_0x03db:
            int r26 = r24 + r24
        L_0x03dd:
            r24 = r2
            r2 = r26
            com.google.android.gms.internal.firebase-auth-api.zzahf r2 = r4.zzd(r2)
            r3.putObject(r7, r13, r2)
            r13 = r2
            goto L_0x03ed
        L_0x03ea:
            r24 = r2
            r13 = r4
        L_0x03ed:
            switch(r0) {
                case 18: goto L_0x0854;
                case 19: goto L_0x07fb;
                case 20: goto L_0x07af;
                case 21: goto L_0x07af;
                case 22: goto L_0x0780;
                case 23: goto L_0x0734;
                case 24: goto L_0x06e7;
                case 25: goto L_0x0683;
                case 26: goto L_0x05ba;
                case 27: goto L_0x0580;
                case 28: goto L_0x0520;
                case 29: goto L_0x0780;
                case 30: goto L_0x04ce;
                case 31: goto L_0x06e7;
                case 32: goto L_0x0734;
                case 33: goto L_0x046d;
                case 34: goto L_0x041b;
                case 35: goto L_0x0854;
                case 36: goto L_0x07fb;
                case 37: goto L_0x07af;
                case 38: goto L_0x07af;
                case 39: goto L_0x0780;
                case 40: goto L_0x0734;
                case 41: goto L_0x06e7;
                case 42: goto L_0x0683;
                case 43: goto L_0x0780;
                case 44: goto L_0x04ce;
                case 45: goto L_0x06e7;
                case 46: goto L_0x0734;
                case 47: goto L_0x046d;
                case 48: goto L_0x041b;
                default: goto L_0x03f0;
            }
        L_0x03f0:
            r10 = r33
            r7 = r5
            r14 = r8
            r9 = r11
            r8 = r12
            r12 = r21
            r11 = r28
            r0 = 3
            if (r1 != r0) goto L_0x08cc
            com.google.android.gms.internal.firebase-auth-api.zzair r21 = r10.zzx(r14)
            r0 = r6 & -8
            r22 = r0 | 4
            r0 = r21
            r1 = r35
            r2 = r12
            r3 = r37
            r4 = r22
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzc(r0, r1, r2, r3, r4, r5)
            java.lang.Object r1 = r8.zzc
            r13.add(r1)
            goto L_0x08ae
        L_0x041b:
            r0 = 2
            if (r1 != r0) goto L_0x0442
            com.google.android.gms.internal.firebase-auth-api.zzahu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahu) r13
            r14 = r21
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r14, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x0429:
            if (r0 >= r1) goto L_0x0439
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r0, r12)
            long r2 = r12.zzb
            long r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzG(r2)
            r13.zzf(r2)
            goto L_0x0429
        L_0x0439:
            if (r0 != r1) goto L_0x043d
            goto L_0x04bc
        L_0x043d:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x0442:
            r14 = r21
            if (r1 != 0) goto L_0x04ca
            com.google.android.gms.internal.firebase-auth-api.zzahu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahu) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r14, r12)
            long r1 = r12.zzb
            long r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzG(r1)
            r13.zzf(r1)
        L_0x0455:
            if (r0 >= r5) goto L_0x04bc
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r0, r12)
            int r2 = r12.zza
            if (r6 != r2) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r1, r12)
            long r1 = r12.zzb
            long r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzG(r1)
            r13.zzf(r1)
            goto L_0x0455
        L_0x046d:
            r14 = r21
            r0 = 2
            if (r1 != r0) goto L_0x0493
            com.google.android.gms.internal.firebase-auth-api.zzahb r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahb) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r14, r12)
            int r1 = r12.zza
            int r1 = r1 + r0
        L_0x047b:
            if (r0 >= r1) goto L_0x048b
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r0, r12)
            int r2 = r12.zza
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzF(r2)
            r13.zzf(r2)
            goto L_0x047b
        L_0x048b:
            if (r0 != r1) goto L_0x048e
            goto L_0x04bc
        L_0x048e:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x0493:
            if (r1 != 0) goto L_0x04ca
            com.google.android.gms.internal.firebase-auth-api.zzahb r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahb) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r14, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzF(r1)
            r13.zzf(r1)
        L_0x04a4:
            if (r0 >= r5) goto L_0x04bc
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r0, r12)
            int r2 = r12.zza
            if (r6 != r2) goto L_0x04bc
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r12)
            int r1 = r12.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzF(r1)
            r13.zzf(r1)
            goto L_0x04a4
        L_0x04bc:
            r10 = r33
            r7 = r5
            r9 = r11
            r11 = r28
            r31 = r14
            r14 = r8
            r8 = r12
            r12 = r31
            goto L_0x08cd
        L_0x04ca:
            r10 = r33
            r7 = r5
            goto L_0x0515
        L_0x04ce:
            r14 = r21
            r0 = 2
            if (r1 != r0) goto L_0x04df
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzf(r15, r14, r13, r12)
            r10 = r33
            r21 = r0
            r7 = r5
            r9 = r28
            goto L_0x04f5
        L_0x04df:
            if (r1 != 0) goto L_0x0512
            r0 = r6
            r1 = r35
            r2 = r14
            r10 = r33
            r3 = r37
            r9 = r28
            r4 = r13
            r7 = r5
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzj(r0, r1, r2, r3, r4, r5)
            r21 = r0
        L_0x04f5:
            com.google.android.gms.internal.firebase-auth-api.zzahe r3 = r10.zzw(r8)
            r4 = 0
            com.google.android.gms.internal.firebase-auth-api.zzajl r5 = r10.zzn
            r0 = r34
            r1 = r11
            r2 = r13
            com.google.android.gms.internal.p002firebaseauthapi.zzait.zzo(r0, r1, r2, r3, r4, r5)
            r0 = r21
        L_0x0505:
            r31 = r14
            r14 = r8
            r8 = r12
            r12 = r31
            r32 = r11
            r11 = r9
            r9 = r32
            goto L_0x08cd
        L_0x0512:
            r7 = r5
            r10 = r33
        L_0x0515:
            r9 = r11
            r11 = r28
            r31 = r14
            r14 = r8
            r8 = r12
            r12 = r31
            goto L_0x08cc
        L_0x0520:
            r10 = r33
            r7 = r5
            r14 = r21
            r9 = r28
            r0 = 2
            if (r1 != r0) goto L_0x05ad
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r14, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x057b
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x0576
            if (r1 != 0) goto L_0x053e
            com.google.android.gms.internal.firebase-auth-api.zzafv r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafv.zzb
            r13.add(r1)
            goto L_0x0546
        L_0x053e:
            com.google.android.gms.internal.firebase-auth-api.zzafv r2 = com.google.android.gms.internal.p002firebaseauthapi.zzafv.zzn(r15, r0, r1)
            r13.add(r2)
        L_0x0545:
            int r0 = r0 + r1
        L_0x0546:
            if (r0 >= r7) goto L_0x0505
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r0, r12)
            int r2 = r12.zza
            if (r6 != r2) goto L_0x0505
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r12)
            int r1 = r12.zza
            if (r1 < 0) goto L_0x0571
            int r2 = r15.length
            int r2 = r2 - r0
            if (r1 > r2) goto L_0x056c
            if (r1 != 0) goto L_0x0564
            com.google.android.gms.internal.firebase-auth-api.zzafv r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafv.zzb
            r13.add(r1)
            goto L_0x0546
        L_0x0564:
            com.google.android.gms.internal.firebase-auth-api.zzafv r2 = com.google.android.gms.internal.p002firebaseauthapi.zzafv.zzn(r15, r0, r1)
            r13.add(r2)
            goto L_0x0545
        L_0x056c:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x0571:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x0576:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x057b:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x0580:
            r10 = r33
            r7 = r5
            r14 = r21
            r9 = r28
            r0 = 2
            if (r1 != r0) goto L_0x05ad
            com.google.android.gms.internal.firebase-auth-api.zzair r0 = r10.zzx(r8)
            r5 = r8
            r8 = r0
            r4 = r9
            r9 = r6
            r3 = r10
            r10 = r35
            r2 = r11
            r11 = r14
            r0 = r12
            r12 = r37
            r1 = r14
            r14 = r39
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zze(r8, r9, r10, r11, r12, r13, r14)
            r12 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r14 = r5
            r31 = r8
            r8 = r0
            r0 = r31
            goto L_0x08cd
        L_0x05ad:
            r31 = r14
            r14 = r8
            r8 = r12
            r12 = r31
            r32 = r11
            r11 = r9
            r9 = r32
            goto L_0x08cc
        L_0x05ba:
            r3 = r33
            r7 = r5
            r5 = r8
            r2 = r11
            r0 = r12
            r12 = r21
            r4 = r28
            r8 = 2
            if (r1 != r8) goto L_0x067c
            r25 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r9 & r25
            int r1 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r1 != 0) goto L_0x061a
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r0)
            int r8 = r0.zza
            if (r8 < 0) goto L_0x0615
            if (r8 != 0) goto L_0x05e0
            r11 = r24
            r13.add(r11)
            goto L_0x05ed
        L_0x05e0:
            r11 = r24
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzb
            r9.<init>(r15, r1, r8, r10)
            r13.add(r9)
        L_0x05ec:
            int r1 = r1 + r8
        L_0x05ed:
            if (r1 >= r7) goto L_0x0791
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r0)
            int r9 = r0.zza
            if (r6 != r9) goto L_0x0791
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r8, r0)
            int r8 = r0.zza
            if (r8 < 0) goto L_0x0610
            if (r8 != 0) goto L_0x0605
            r13.add(r11)
            goto L_0x05ed
        L_0x0605:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzb
            r9.<init>(r15, r1, r8, r10)
            r13.add(r9)
            goto L_0x05ec
        L_0x0610:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x0615:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x061a:
            r11 = r24
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r0)
            int r8 = r0.zza
            if (r8 < 0) goto L_0x0677
            if (r8 != 0) goto L_0x062a
            r13.add(r11)
            goto L_0x063d
        L_0x062a:
            int r9 = r1 + r8
            boolean r10 = com.google.android.gms.internal.p002firebaseauthapi.zzaka.zzf(r15, r1, r9)
            if (r10 == 0) goto L_0x0672
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzb
            r10.<init>(r15, r1, r8, r14)
            r13.add(r10)
        L_0x063c:
            r1 = r9
        L_0x063d:
            if (r1 >= r7) goto L_0x0791
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r0)
            int r9 = r0.zza
            if (r6 != r9) goto L_0x0791
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r8, r0)
            int r8 = r0.zza
            if (r8 < 0) goto L_0x066d
            if (r8 != 0) goto L_0x0655
            r13.add(r11)
            goto L_0x063d
        L_0x0655:
            int r9 = r1 + r8
            boolean r10 = com.google.android.gms.internal.p002firebaseauthapi.zzaka.zzf(r15, r1, r9)
            if (r10 == 0) goto L_0x0668
            java.lang.String r10 = new java.lang.String
            java.nio.charset.Charset r14 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzb
            r10.<init>(r15, r1, r8, r14)
            r13.add(r10)
            goto L_0x063c
        L_0x0668:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd()
            throw r0
        L_0x066d:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x0672:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd()
            throw r0
        L_0x0677:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzf()
            throw r0
        L_0x067c:
            r8 = r0
            r9 = r2
            r10 = r3
            r11 = r4
            r14 = r5
            goto L_0x08cc
        L_0x0683:
            r3 = r33
            r7 = r5
            r5 = r8
            r2 = r11
            r0 = r12
            r12 = r21
            r4 = r28
            r8 = 2
            if (r1 != r8) goto L_0x06b6
            com.google.android.gms.internal.firebase-auth-api.zzafk r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzafk) r13
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r0)
            int r8 = r0.zza
            int r8 = r8 + r1
        L_0x0699:
            if (r1 >= r8) goto L_0x06ad
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r1, r0)
            long r9 = r0.zzb
            int r9 = (r9 > r22 ? 1 : (r9 == r22 ? 0 : -1))
            if (r9 == 0) goto L_0x06a7
            r9 = 1
            goto L_0x06a9
        L_0x06a7:
            r9 = r16
        L_0x06a9:
            r13.zze(r9)
            goto L_0x0699
        L_0x06ad:
            if (r1 != r8) goto L_0x06b1
            goto L_0x0791
        L_0x06b1:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x06b6:
            if (r1 != 0) goto L_0x067c
            com.google.android.gms.internal.firebase-auth-api.zzafk r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzafk) r13
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r12, r0)
            long r8 = r0.zzb
            int r8 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x06c6
            r8 = 1
            goto L_0x06c8
        L_0x06c6:
            r8 = r16
        L_0x06c8:
            r13.zze(r8)
        L_0x06cb:
            if (r1 >= r7) goto L_0x0791
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r0)
            int r9 = r0.zza
            if (r6 != r9) goto L_0x0791
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r8, r0)
            long r8 = r0.zzb
            int r8 = (r8 > r22 ? 1 : (r8 == r22 ? 0 : -1))
            if (r8 == 0) goto L_0x06e1
            r8 = 1
            goto L_0x06e3
        L_0x06e1:
            r8 = r16
        L_0x06e3:
            r13.zze(r8)
            goto L_0x06cb
        L_0x06e7:
            r3 = r33
            r7 = r5
            r5 = r8
            r2 = r11
            r0 = r12
            r12 = r21
            r4 = r28
            r8 = 2
            if (r1 != r8) goto L_0x0712
            com.google.android.gms.internal.firebase-auth-api.zzahb r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahb) r13
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r0)
            int r8 = r0.zza
            int r8 = r8 + r1
        L_0x06fd:
            if (r1 >= r8) goto L_0x0709
            int r9 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r1)
            r13.zzf(r9)
            int r1 = r1 + 4
            goto L_0x06fd
        L_0x0709:
            if (r1 != r8) goto L_0x070d
            goto L_0x0791
        L_0x070d:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x0712:
            r8 = 5
            if (r1 != r8) goto L_0x067c
            com.google.android.gms.internal.firebase-auth-api.zzahb r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahb) r13
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r12)
            r13.zzf(r1)
            int r1 = r12 + 4
        L_0x0720:
            if (r1 >= r7) goto L_0x0791
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r0)
            int r9 = r0.zza
            if (r6 != r9) goto L_0x0791
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r8)
            r13.zzf(r1)
            int r1 = r8 + 4
            goto L_0x0720
        L_0x0734:
            r3 = r33
            r7 = r5
            r5 = r8
            r2 = r11
            r0 = r12
            r12 = r21
            r4 = r28
            r8 = 2
            if (r1 != r8) goto L_0x075e
            com.google.android.gms.internal.firebase-auth-api.zzahu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahu) r13
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r0)
            int r8 = r0.zza
            int r8 = r8 + r1
        L_0x074a:
            if (r1 >= r8) goto L_0x0756
            long r9 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r1)
            r13.zzf(r9)
            int r1 = r1 + 8
            goto L_0x074a
        L_0x0756:
            if (r1 != r8) goto L_0x0759
            goto L_0x0791
        L_0x0759:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x075e:
            r8 = 1
            if (r1 != r8) goto L_0x067c
            com.google.android.gms.internal.firebase-auth-api.zzahu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahu) r13
            long r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r12)
            r13.zzf(r8)
            int r1 = r12 + 8
        L_0x076c:
            if (r1 >= r7) goto L_0x0791
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r1, r0)
            int r9 = r0.zza
            if (r6 != r9) goto L_0x0791
            long r9 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r8)
            r13.zzf(r9)
            int r1 = r8 + 8
            goto L_0x076c
        L_0x0780:
            r3 = r33
            r7 = r5
            r5 = r8
            r2 = r11
            r0 = r12
            r12 = r21
            r4 = r28
            r8 = 2
            if (r1 != r8) goto L_0x0799
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzf(r15, r12, r13, r0)
        L_0x0791:
            r8 = r0
            r0 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r14 = r5
            goto L_0x08cd
        L_0x0799:
            if (r1 != 0) goto L_0x067c
            r8 = r0
            r0 = r6
            r1 = r35
            r9 = r2
            r2 = r12
            r10 = r3
            r3 = r37
            r11 = r4
            r4 = r13
            r14 = r5
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzj(r0, r1, r2, r3, r4, r5)
            goto L_0x08cd
        L_0x07af:
            r10 = r33
            r7 = r5
            r14 = r8
            r9 = r11
            r8 = r12
            r12 = r21
            r11 = r28
            r0 = 2
            if (r1 != r0) goto L_0x07da
            com.google.android.gms.internal.firebase-auth-api.zzahu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahu) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r8)
            int r1 = r8.zza
            int r1 = r1 + r0
        L_0x07c5:
            if (r0 >= r1) goto L_0x07d1
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r0, r8)
            long r2 = r8.zzb
            r13.zzf(r2)
            goto L_0x07c5
        L_0x07d1:
            if (r0 != r1) goto L_0x07d5
            goto L_0x08cd
        L_0x07d5:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x07da:
            if (r1 != 0) goto L_0x08cc
            com.google.android.gms.internal.firebase-auth-api.zzahu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzahu) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r12, r8)
            long r1 = r8.zzb
            r13.zzf(r1)
        L_0x07e7:
            if (r0 >= r7) goto L_0x08cd
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r0, r8)
            int r2 = r8.zza
            if (r6 != r2) goto L_0x08cd
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r1, r8)
            long r1 = r8.zzb
            r13.zzf(r1)
            goto L_0x07e7
        L_0x07fb:
            r10 = r33
            r7 = r5
            r14 = r8
            r9 = r11
            r8 = r12
            r12 = r21
            r11 = r28
            r0 = 2
            if (r1 != r0) goto L_0x082a
            com.google.android.gms.internal.firebase-auth-api.zzagu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzagu) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r8)
            int r1 = r8.zza
            int r1 = r1 + r0
        L_0x0811:
            if (r0 >= r1) goto L_0x0821
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r0)
            float r2 = java.lang.Float.intBitsToFloat(r2)
            r13.zze(r2)
            int r0 = r0 + 4
            goto L_0x0811
        L_0x0821:
            if (r0 != r1) goto L_0x0825
            goto L_0x08cd
        L_0x0825:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x082a:
            r0 = 5
            if (r1 != r0) goto L_0x08cc
            com.google.android.gms.internal.firebase-auth-api.zzagu r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzagu) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r12)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            r13.zze(r0)
            int r3 = r12 + 4
        L_0x083c:
            if (r3 >= r7) goto L_0x08ac
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r3, r8)
            int r1 = r8.zza
            if (r6 != r1) goto L_0x08ac
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r0)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r13.zze(r1)
            int r3 = r0 + 4
            goto L_0x083c
        L_0x0854:
            r10 = r33
            r7 = r5
            r14 = r8
            r9 = r11
            r8 = r12
            r12 = r21
            r11 = r28
            r0 = 2
            if (r1 != r0) goto L_0x0882
            com.google.android.gms.internal.firebase-auth-api.zzagk r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzagk) r13
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r12, r8)
            int r1 = r8.zza
            int r1 = r1 + r0
        L_0x086a:
            if (r0 >= r1) goto L_0x087a
            long r2 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r0)
            double r2 = java.lang.Double.longBitsToDouble(r2)
            r13.zze(r2)
            int r0 = r0 + 8
            goto L_0x086a
        L_0x087a:
            if (r0 != r1) goto L_0x087d
            goto L_0x08cd
        L_0x087d:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzj()
            throw r0
        L_0x0882:
            r0 = 1
            if (r1 != r0) goto L_0x08cc
            com.google.android.gms.internal.firebase-auth-api.zzagk r13 = (com.google.android.gms.internal.p002firebaseauthapi.zzagk) r13
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r12)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            r13.zze(r0)
            int r3 = r12 + 8
        L_0x0894:
            if (r3 >= r7) goto L_0x08ac
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r3, r8)
            int r1 = r8.zza
            if (r6 != r1) goto L_0x08ac
            long r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r0)
            double r1 = java.lang.Double.longBitsToDouble(r1)
            r13.zze(r1)
            int r3 = r0 + 8
            goto L_0x0894
        L_0x08ac:
            r0 = r3
            goto L_0x08cd
        L_0x08ae:
            if (r0 >= r7) goto L_0x08cd
            int r2 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r0, r8)
            int r1 = r8.zza
            if (r6 != r1) goto L_0x08cd
            r0 = r21
            r1 = r35
            r3 = r37
            r4 = r22
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzc(r0, r1, r2, r3, r4, r5)
            java.lang.Object r1 = r8.zzc
            r13.add(r1)
            goto L_0x08ae
        L_0x08cc:
            r0 = r12
        L_0x08cd:
            if (r0 == r12) goto L_0x08e1
            r13 = r38
            r3 = r6
            r12 = r8
            r1 = r9
            r6 = r10
            r2 = r14
            r5 = r17
            r10 = r19
            r4 = r20
            r14 = r7
            r7 = r34
            goto L_0x001e
        L_0x08e1:
            r7 = r34
            r2 = r0
            r5 = r8
            r3 = r9
            r4 = r11
            r8 = r38
            r9 = r6
            r6 = r10
            goto L_0x0bb3
        L_0x08ed:
            r28 = r4
            r7 = r5
            r3 = r11
            r5 = r33
            r11 = r2
            r2 = r8
            r8 = r12
            r12 = r21
            r4 = 50
            if (r0 != r4) goto L_0x0930
            r4 = 2
            if (r1 != r4) goto L_0x0922
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r1 = r5.zzz(r2)
            r7 = r34
            java.lang.Object r2 = r0.getObject(r7, r13)
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaia.zza(r2)
            if (r3 == 0) goto L_0x091f
            com.google.android.gms.internal.firebase-auth-api.zzahz r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahz.zza()
            com.google.android.gms.internal.firebase-auth-api.zzahz r3 = r3.zzb()
            com.google.android.gms.internal.p002firebaseauthapi.zzaia.zzb(r3, r2)
            r0.putObject(r7, r13, r3)
        L_0x091f:
            com.google.android.gms.internal.firebase-auth-api.zzahy r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzahy) r1
            throw r18
        L_0x0922:
            r4 = r7
            r7 = r34
        L_0x0925:
            r14 = r2
            r9 = r6
            r2 = r12
            r4 = r28
            r6 = r5
            r5 = r8
            r8 = r38
            goto L_0x0bb3
        L_0x0930:
            r4 = r7
            r7 = r34
            int r21 = r2 + 2
            sun.misc.Unsafe r4 = zzb
            r10 = r10[r21]
            r21 = r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r10 = r10 & r4
            long r4 = (long) r10
            switch(r0) {
                case 51: goto L_0x0b73;
                case 52: goto L_0x0b4d;
                case 53: goto L_0x0b28;
                case 54: goto L_0x0b28;
                case 55: goto L_0x0b06;
                case 56: goto L_0x0ae3;
                case 57: goto L_0x0ac0;
                case 58: goto L_0x0a8e;
                case 59: goto L_0x0a48;
                case 60: goto L_0x0a10;
                case 61: goto L_0x09ef;
                case 62: goto L_0x0b06;
                case 63: goto L_0x09b8;
                case 64: goto L_0x0ac0;
                case 65: goto L_0x0ae3;
                case 66: goto L_0x0997;
                case 67: goto L_0x0975;
                case 68: goto L_0x094d;
                default: goto L_0x0943;
            }
        L_0x0943:
            r21 = r6
            r5 = r8
            r10 = r12
            r4 = r28
            r6 = r33
            goto L_0x0b99
        L_0x094d:
            r0 = 3
            if (r1 != r0) goto L_0x0943
            r5 = r33
            java.lang.Object r0 = r5.zzB(r7, r3, r2)
            r1 = r6 & -8
            r13 = r1 | 4
            com.google.android.gms.internal.firebase-auth-api.zzair r9 = r5.zzx(r2)
            r4 = r8
            r8 = r0
            r10 = r35
            r11 = r12
            r1 = r12
            r12 = r37
            r14 = r39
            int r8 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzl(r8, r9, r10, r11, r12, r13, r14)
            r5.zzK(r7, r3, r2, r0)
            r10 = r1
            r21 = r6
            r0 = r8
            goto L_0x0a0a
        L_0x0975:
            r10 = r12
            r31 = r4
            r5 = r33
            r4 = r8
            r8 = r31
            if (r1 != 0) goto L_0x0a40
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r10, r4)
            long r11 = r4.zzb
            long r11 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzG(r11)
            java.lang.Long r1 = java.lang.Long.valueOf(r11)
            r12 = r21
            r12.putObject(r7, r13, r1)
            r12.putInt(r7, r8, r3)
            goto L_0x0a08
        L_0x0997:
            r10 = r12
            r12 = r21
            r31 = r4
            r5 = r33
            r4 = r8
            r8 = r31
            if (r1 != 0) goto L_0x0a40
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r10, r4)
            int r1 = r4.zza
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagb.zzF(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.putObject(r7, r13, r1)
            r12.putInt(r7, r8, r3)
            goto L_0x0a08
        L_0x09b8:
            r10 = r12
            r12 = r21
            r31 = r4
            r5 = r33
            r4 = r8
            r8 = r31
            if (r1 != 0) goto L_0x0a40
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r10, r4)
            int r1 = r4.zza
            com.google.android.gms.internal.firebase-auth-api.zzahe r11 = r5.zzw(r2)
            if (r11 == 0) goto L_0x09e4
            boolean r11 = r11.zza()
            if (r11 == 0) goto L_0x09d7
            goto L_0x09e4
        L_0x09d7:
            com.google.android.gms.internal.firebase-auth-api.zzajm r8 = zzd(r34)
            long r11 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r11)
            r8.zzj(r6, r1)
            goto L_0x0a08
        L_0x09e4:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.putObject(r7, r13, r1)
            r12.putInt(r7, r8, r3)
            goto L_0x0a08
        L_0x09ef:
            r10 = r12
            r12 = r21
            r0 = 2
            r31 = r4
            r5 = r33
            r4 = r8
            r8 = r31
            if (r1 != r0) goto L_0x0a40
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zza(r15, r10, r4)
            java.lang.Object r1 = r4.zzc
            r12.putObject(r7, r13, r1)
            r12.putInt(r7, r8, r3)
        L_0x0a08:
            r21 = r6
        L_0x0a0a:
            r6 = r5
            r5 = r4
            r4 = r28
            goto L_0x0b9a
        L_0x0a10:
            r5 = r33
            r4 = r8
            r10 = r12
            r0 = 2
            if (r1 != r0) goto L_0x0a3e
            java.lang.Object r8 = r5.zzB(r7, r3, r2)
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r5.zzx(r2)
            r0 = r8
            r9 = r2
            r2 = r35
            r11 = r3
            r3 = r10
            r12 = r37
            r13 = r4
            r14 = r28
            r4 = r37
            r21 = r6
            r6 = r5
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzm(r0, r1, r2, r3, r4, r5)
            r6.zzK(r7, r11, r9, r8)
            r2 = r9
            r3 = r11
            r5 = r13
            r4 = r14
            goto L_0x0b9a
        L_0x0a3e:
            r12 = r37
        L_0x0a40:
            r21 = r6
            r6 = r5
            r5 = r4
            r4 = r28
            goto L_0x0b99
        L_0x0a48:
            r0 = r2
            r29 = r4
            r5 = r8
            r10 = r12
            r12 = r21
            r4 = r28
            r2 = 2
            r8 = r37
            r21 = r6
            r6 = r33
            if (r1 != r2) goto L_0x0abd
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r10, r5)
            int r2 = r5.zza
            if (r2 != 0) goto L_0x0a68
            r12.putObject(r7, r13, r11)
        L_0x0a65:
            r13 = r29
            goto L_0x0a87
        L_0x0a68:
            r11 = 536870912(0x20000000, float:1.0842022E-19)
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0a7b
            int r9 = r1 + r2
            boolean r9 = com.google.android.gms.internal.p002firebaseauthapi.zzaka.zzf(r15, r1, r9)
            if (r9 == 0) goto L_0x0a76
            goto L_0x0a7b
        L_0x0a76:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzd()
            throw r0
        L_0x0a7b:
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r11 = com.google.android.gms.internal.p002firebaseauthapi.zzahg.zzb
            r9.<init>(r15, r1, r2, r11)
            r12.putObject(r7, r13, r9)
            int r1 = r1 + r2
            goto L_0x0a65
        L_0x0a87:
            r12.putInt(r7, r13, r3)
            r2 = r0
            r0 = r1
            goto L_0x0b9a
        L_0x0a8e:
            r0 = r2
            r10 = r12
            r12 = r21
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != 0) goto L_0x0abd
            int r1 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r10, r5)
            r2 = r0
            r36 = r1
            long r0 = r5.zzb
            int r0 = (r0 > r22 ? 1 : (r0 == r22 ? 0 : -1))
            if (r0 == 0) goto L_0x0aaf
            r27 = 1
            goto L_0x0ab1
        L_0x0aaf:
            r27 = r16
        L_0x0ab1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r27)
            r12.putObject(r7, r13, r0)
            r12.putInt(r7, r8, r3)
            goto L_0x0b4a
        L_0x0abd:
            r2 = r0
            goto L_0x0b99
        L_0x0ac0:
            r10 = r12
            r12 = r21
            r0 = 5
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != r0) goto L_0x0b99
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r10)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r12.putObject(r7, r13, r0)
            int r0 = r10 + 4
            r12.putInt(r7, r8, r3)
            goto L_0x0b9a
        L_0x0ae3:
            r10 = r12
            r12 = r21
            r0 = 1
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != r0) goto L_0x0b99
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r10)
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r12.putObject(r7, r13, r0)
            int r0 = r10 + 8
            r12.putInt(r7, r8, r3)
            goto L_0x0b9a
        L_0x0b06:
            r10 = r12
            r12 = r21
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != 0) goto L_0x0b99
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzh(r15, r10, r5)
            int r1 = r5.zza
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r12.putObject(r7, r13, r1)
            r12.putInt(r7, r8, r3)
            goto L_0x0b9a
        L_0x0b28:
            r10 = r12
            r12 = r21
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != 0) goto L_0x0b99
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzk(r15, r10, r5)
            r36 = r0
            long r0 = r5.zzb
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r12.putObject(r7, r13, r0)
            r12.putInt(r7, r8, r3)
        L_0x0b4a:
            r0 = r36
            goto L_0x0b9a
        L_0x0b4d:
            r10 = r12
            r12 = r21
            r0 = 5
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != r0) goto L_0x0b99
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzb(r15, r10)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r12.putObject(r7, r13, r0)
            int r0 = r10 + 4
            r12.putInt(r7, r8, r3)
            goto L_0x0b9a
        L_0x0b73:
            r10 = r12
            r12 = r21
            r0 = 1
            r21 = r6
            r6 = r33
            r31 = r4
            r5 = r8
            r8 = r31
            r4 = r28
            if (r1 != r0) goto L_0x0b99
            long r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzn(r15, r10)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            r12.putObject(r7, r13, r0)
            int r0 = r10 + 8
            r12.putInt(r7, r8, r3)
            goto L_0x0b9a
        L_0x0b99:
            r0 = r10
        L_0x0b9a:
            if (r0 == r10) goto L_0x0bad
            r14 = r37
            r13 = r38
            r1 = r3
            r11 = r4
            r12 = r5
            r5 = r17
            r10 = r19
            r4 = r20
            r3 = r21
            goto L_0x001e
        L_0x0bad:
            r8 = r38
            r14 = r2
            r9 = r21
            r2 = r0
        L_0x0bb3:
            if (r9 != r8) goto L_0x0bc3
            if (r8 == 0) goto L_0x0bc3
            r12 = r4
            r10 = r9
            r5 = r17
            r4 = r20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r2
            goto L_0x0c19
        L_0x0bc3:
            boolean r0 = r6.zzh
            if (r0 == 0) goto L_0x0bec
            com.google.android.gms.internal.firebase-auth-api.zzagn r0 = r5.zzd
            com.google.android.gms.internal.firebase-auth-api.zzagn r1 = com.google.android.gms.internal.p002firebaseauthapi.zzagn.zza
            if (r0 == r1) goto L_0x0bec
            com.google.android.gms.internal.firebase-auth-api.zzaif r1 = r6.zzg
            com.google.android.gms.internal.firebase-auth-api.zzagy r0 = r0.zzb(r1, r3)
            if (r0 != 0) goto L_0x0be8
            com.google.android.gms.internal.firebase-auth-api.zzajm r10 = zzd(r34)
            r0 = r9
            r1 = r35
            r11 = r3
            r3 = r37
            r12 = r4
            r4 = r10
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzg(r0, r1, r2, r3, r4, r5)
            goto L_0x0bfd
        L_0x0be8:
            r0 = r7
            com.google.android.gms.internal.firebase-auth-api.zzagx r0 = (com.google.android.gms.internal.p002firebaseauthapi.zzagx) r0
            throw r18
        L_0x0bec:
            r11 = r3
            r12 = r4
            com.google.android.gms.internal.firebase-auth-api.zzajm r4 = zzd(r34)
            r0 = r9
            r1 = r35
            r3 = r37
            r5 = r39
            int r0 = com.google.android.gms.internal.p002firebaseauthapi.zzafj.zzg(r0, r1, r2, r3, r4, r5)
        L_0x0bfd:
            r13 = r8
            r3 = r9
            r1 = r11
            r11 = r12
            r2 = r14
            r5 = r17
            r10 = r19
            r4 = r20
            r14 = r37
            r12 = r39
            goto L_0x001e
        L_0x0c0e:
            r20 = r4
            r17 = r5
            r12 = r11
            r8 = r13
            r9 = r0
            r10 = r3
            r0 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0c19:
            if (r5 == r0) goto L_0x0c1f
            long r0 = (long) r5
            r12.putInt(r7, r0, r4)
        L_0x0c1f:
            int r0 = r6.zzk
            r11 = r0
        L_0x0c22:
            int r0 = r6.zzl
            if (r11 >= r0) goto L_0x0c39
            int[] r0 = r6.zzj
            r2 = r0[r11]
            r3 = 0
            com.google.android.gms.internal.firebase-auth-api.zzajl r4 = r6.zzn
            r0 = r33
            r1 = r34
            r5 = r34
            r0.zzy(r1, r2, r3, r4, r5)
            int r11 = r11 + 1
            goto L_0x0c22
        L_0x0c39:
            if (r8 != 0) goto L_0x0c45
            r0 = r37
            if (r9 != r0) goto L_0x0c40
            goto L_0x0c4b
        L_0x0c40:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzg()
            throw r0
        L_0x0c45:
            r0 = r37
            if (r9 > r0) goto L_0x0c4c
            if (r10 != r8) goto L_0x0c4c
        L_0x0c4b:
            return r9
        L_0x0c4c:
            com.google.android.gms.internal.firebase-auth-api.zzahi r0 = com.google.android.gms.internal.p002firebaseauthapi.zzahi.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.firebase-auth-api.zzafi):int");
    }

    public final Object zze() {
        return ((zzaha) this.zzg).zzw();
    }

    public final void zzf(Object obj) {
        if (zzQ(obj)) {
            if (obj instanceof zzaha) {
                zzaha zzaha = (zzaha) obj;
                zzaha.zzI(Integer.MAX_VALUE);
                zzaha.zza = 0;
                zzaha.zzG();
            }
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int zzu = zzu(i11);
                int i12 = 1048575 & zzu;
                int zzt = zzt(zzu);
                long j11 = (long) i12;
                if (zzt != 9) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj, this.zzc[i11], i11)) {
                            zzx(i11).zzf(zzb.getObject(obj, j11));
                        }
                    } else {
                        switch (zzt) {
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
                                    ((zzahz) object).zzc();
                                    unsafe.putObject(obj, j11, object);
                                    break;
                                } else {
                                    continue;
                                }
                        }
                    }
                }
                if (zzN(obj, i11)) {
                    zzx(i11).zzf(zzb.getObject(obj, j11));
                }
            }
            this.zzn.zzm(obj);
            if (this.zzh) {
                this.zzo.zze(obj);
            }
        }
    }

    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzu = zzu(i11);
            int i12 = this.zzc[i11];
            long j11 = (long) (1048575 & zzu);
            switch (zzt(zzu)) {
                case 0:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzo(obj, j11, zzajv.zza(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 1:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzp(obj, j11, zzajv.zzb(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 2:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzr(obj, j11, zzajv.zzd(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 3:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzr(obj, j11, zzajv.zzd(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 4:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzq(obj, j11, zzajv.zzc(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 5:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzr(obj, j11, zzajv.zzd(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 6:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzq(obj, j11, zzajv.zzc(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 7:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzm(obj, j11, zzajv.zzw(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 8:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzs(obj, j11, zzajv.zzf(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 9:
                    zzE(obj, obj2, i11);
                    break;
                case 10:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzs(obj, j11, zzajv.zzf(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 11:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzq(obj, j11, zzajv.zzc(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 12:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzq(obj, j11, zzajv.zzc(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 13:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzq(obj, j11, zzajv.zzc(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 14:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzr(obj, j11, zzajv.zzd(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 15:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzq(obj, j11, zzajv.zzc(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 16:
                    if (!zzN(obj2, i11)) {
                        break;
                    } else {
                        zzajv.zzr(obj, j11, zzajv.zzd(obj2, j11));
                        zzH(obj, i11);
                        break;
                    }
                case 17:
                    zzE(obj, obj2, i11);
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
                    int i13 = zzait.zza;
                    zzajv.zzs(obj, j11, zzaia.zzb(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11)));
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
                    if (!zzR(obj2, i12, i11)) {
                        break;
                    } else {
                        zzajv.zzs(obj, j11, zzajv.zzf(obj2, j11));
                        zzI(obj, i12, i11);
                        break;
                    }
                case 60:
                    zzF(obj, obj2, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzR(obj2, i12, i11)) {
                        break;
                    } else {
                        zzajv.zzs(obj, j11, zzajv.zzf(obj2, j11));
                        zzI(obj, i12, i11);
                        break;
                    }
                case 68:
                    zzF(obj, obj2, i11);
                    break;
            }
        }
        zzait.zzq(this.zzn, obj, obj2);
        if (this.zzh) {
            this.zzo.zza(obj2);
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05e5, code lost:
        r15 = r9;
        r5 = r11;
        r4 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0621, code lost:
        r4 = r10.zzc(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x062c, code lost:
        r0 = r7.zzk;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0630, code lost:
        if (r0 < r7.zzl) goto L_0x0632;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0632, code lost:
        r4 = zzy(r18, r7.zzj[r0], r4, r10, r18);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0644, code lost:
        if (r4 != null) goto L_0x0646;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0646, code lost:
        r10.zzn(r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0183, code lost:
        r13 = r4;
        r11 = r5;
        r14 = r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:179:0x061c */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0621 A[Catch:{ all -> 0x0616 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0659 A[LOOP:5: B:197:0x0655->B:199:0x0659, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x066d  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x062c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(java.lang.Object r18, com.google.android.gms.internal.p002firebaseauthapi.zzaiq r19, com.google.android.gms.internal.p002firebaseauthapi.zzagn r20) throws java.io.IOException {
        /*
            r17 = this;
            r7 = r17
            r15 = r18
            r0 = r19
            r6 = r20
            r20.getClass()
            zzD(r18)
            com.google.android.gms.internal.firebase-auth-api.zzajl r14 = r7.zzn
            com.google.android.gms.internal.firebase-auth-api.zzago r5 = r7.zzo
            r16 = 0
            r4 = r16
            r8 = r4
        L_0x0017:
            int r2 = r19.zzc()     // Catch:{ all -> 0x064d }
            int r1 = r7.zzq(r2)     // Catch:{ all -> 0x064d }
            if (r1 >= 0) goto L_0x00b6
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
            r5 = r14
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x0028
        L_0x003e:
            if (r4 == 0) goto L_0x0649
            r14.zzn(r15, r4)
            return
        L_0x0044:
            boolean r1 = r7.zzh     // Catch:{ all -> 0x00b1 }
            if (r1 != 0) goto L_0x004b
            r11 = r16
            goto L_0x0052
        L_0x004b:
            com.google.android.gms.internal.firebase-auth-api.zzaif r1 = r7.zzg     // Catch:{ all -> 0x00b1 }
            java.lang.Object r1 = r5.zzc(r6, r1, r2)     // Catch:{ all -> 0x00b1 }
            r11 = r1
        L_0x0052:
            if (r11 == 0) goto L_0x0070
            if (r8 != 0) goto L_0x005b
            com.google.android.gms.internal.firebase-auth-api.zzags r1 = r5.zzb(r15)     // Catch:{ all -> 0x064d }
            goto L_0x005c
        L_0x005b:
            r1 = r8
        L_0x005c:
            r8 = r5
            r9 = r18
            r10 = r19
            r12 = r20
            r13 = r1
            r3 = r14
            r14 = r4
            r2 = r15
            r15 = r3
            java.lang.Object r4 = r8.zzd(r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00ac }
            r8 = r1
        L_0x006d:
            r15 = r2
            r14 = r3
            goto L_0x0017
        L_0x0070:
            r3 = r14
            r2 = r15
            r3.zzq(r0)     // Catch:{ all -> 0x00ac }
            if (r4 != 0) goto L_0x007c
            java.lang.Object r1 = r3.zzc(r2)     // Catch:{ all -> 0x00ac }
            r4 = r1
        L_0x007c:
            boolean r1 = r3.zzp(r4, r0)     // Catch:{ all -> 0x00a7 }
            if (r1 != 0) goto L_0x006d
            int r0 = r7.zzk
        L_0x0084:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x009f
            int[] r1 = r7.zzj
            r5 = r1[r0]
            r1 = r17
            r9 = r2
            r2 = r18
            r10 = r3
            r3 = r5
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            r2 = r9
            r3 = r10
            goto L_0x0084
        L_0x009f:
            r9 = r2
            r10 = r3
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
            return
        L_0x00a7:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x0652
        L_0x00ac:
            r0 = move-exception
            r9 = r2
            r10 = r3
            goto L_0x064b
        L_0x00b1:
            r0 = move-exception
            r10 = r14
            r9 = r15
            goto L_0x064b
        L_0x00b6:
            r10 = r14
            r9 = r15
            int r3 = r7.zzu(r1)     // Catch:{ all -> 0x064a }
            int r11 = zzt(r3)     // Catch:{ zzahh -> 0x0618 }
            r12 = 1048575(0xfffff, float:1.469367E-39)
            switch(r11) {
                case 0: goto L_0x05d5;
                case 1: goto L_0x05c4;
                case 2: goto L_0x05b3;
                case 3: goto L_0x05a2;
                case 4: goto L_0x0591;
                case 5: goto L_0x0580;
                case 6: goto L_0x056e;
                case 7: goto L_0x055c;
                case 8: goto L_0x054e;
                case 9: goto L_0x0539;
                case 10: goto L_0x0527;
                case 11: goto L_0x0515;
                case 12: goto L_0x04f0;
                case 13: goto L_0x04de;
                case 14: goto L_0x04cc;
                case 15: goto L_0x04ba;
                case 16: goto L_0x04a8;
                case 17: goto L_0x0493;
                case 18: goto L_0x0482;
                case 19: goto L_0x0471;
                case 20: goto L_0x0460;
                case 21: goto L_0x044f;
                case 22: goto L_0x043e;
                case 23: goto L_0x042d;
                case 24: goto L_0x041c;
                case 25: goto L_0x040b;
                case 26: goto L_0x03de;
                case 27: goto L_0x03c9;
                case 28: goto L_0x03b8;
                case 29: goto L_0x03a7;
                case 30: goto L_0x038b;
                case 31: goto L_0x037a;
                case 32: goto L_0x0369;
                case 33: goto L_0x0358;
                case 34: goto L_0x0347;
                case 35: goto L_0x0336;
                case 36: goto L_0x0325;
                case 37: goto L_0x0314;
                case 38: goto L_0x0303;
                case 39: goto L_0x02f2;
                case 40: goto L_0x02e1;
                case 41: goto L_0x02d0;
                case 42: goto L_0x02bf;
                case 43: goto L_0x02ae;
                case 44: goto L_0x0291;
                case 45: goto L_0x0283;
                case 46: goto L_0x0275;
                case 47: goto L_0x0267;
                case 48: goto L_0x0259;
                case 49: goto L_0x0247;
                case 50: goto L_0x0211;
                case 51: goto L_0x01ff;
                case 52: goto L_0x01ee;
                case 53: goto L_0x01dd;
                case 54: goto L_0x01cc;
                case 55: goto L_0x01bb;
                case 56: goto L_0x01aa;
                case 57: goto L_0x0199;
                case 58: goto L_0x0188;
                case 59: goto L_0x017d;
                case 60: goto L_0x016c;
                case 61: goto L_0x015f;
                case 62: goto L_0x014e;
                case 63: goto L_0x0129;
                case 64: goto L_0x0118;
                case 65: goto L_0x0107;
                case 66: goto L_0x00f5;
                case 67: goto L_0x00e3;
                case 68: goto L_0x00d1;
                default: goto L_0x00c6;
            }
        L_0x00c6:
            r13 = r4
            r11 = r5
            r14 = r6
            if (r13 != 0) goto L_0x05ee
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05ec
        L_0x00d1:
            java.lang.Object r3 = r7.zzB(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzaif r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzair r11 = r7.zzx(r1)     // Catch:{ zzahh -> 0x0618 }
            r0.zzt(r3, r11, r6)     // Catch:{ zzahh -> 0x0618 }
            r7.zzK(r9, r2, r1, r3)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x00e3:
            r3 = r3 & r12
            long r11 = r19.zzn()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x00f5:
            r3 = r3 & r12
            int r11 = r19.zzi()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0107:
            r3 = r3 & r12
            long r11 = r19.zzm()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0118:
            r3 = r3 & r12
            int r11 = r19.zzh()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0129:
            int r11 = r19.zze()     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzahe r13 = r7.zzw(r1)     // Catch:{ zzahh -> 0x0618 }
            if (r13 == 0) goto L_0x0141
            boolean r13 = r13.zza()     // Catch:{ zzahh -> 0x0618 }
            if (r13 == 0) goto L_0x013a
            goto L_0x0141
        L_0x013a:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzp(r9, r2, r11, r4, r10)     // Catch:{ zzahh -> 0x0618 }
            r15 = r9
            goto L_0x05e9
        L_0x0141:
            r3 = r3 & r12
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x014e:
            r3 = r3 & r12
            int r11 = r19.zzj()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x015f:
            r3 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzafv r11 = r19.zzp()     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x016c:
            java.lang.Object r3 = r7.zzB(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzaif r3 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzair r11 = r7.zzx(r1)     // Catch:{ zzahh -> 0x0618 }
            r0.zzu(r3, r11, r6)     // Catch:{ zzahh -> 0x0618 }
            r7.zzK(r9, r2, r1, r3)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x017d:
            r7.zzG(r9, r3, r0)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
        L_0x0183:
            r13 = r4
            r11 = r5
            r14 = r6
            goto L_0x05e5
        L_0x0188:
            r3 = r3 & r12
            boolean r11 = r19.zzN()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0199:
            r3 = r3 & r12
            int r11 = r19.zzf()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x01aa:
            r3 = r3 & r12
            long r11 = r19.zzk()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x01bb:
            r3 = r3 & r12
            int r11 = r19.zzg()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x01cc:
            r3 = r3 & r12
            long r11 = r19.zzo()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x01dd:
            r3 = r3 & r12
            long r11 = r19.zzl()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x01ee:
            r3 = r3 & r12
            float r11 = r19.zzb()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Float r11 = java.lang.Float.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x01ff:
            r3 = r3 & r12
            double r11 = r19.zza()     // Catch:{ zzahh -> 0x0618 }
            java.lang.Double r11 = java.lang.Double.valueOf(r11)     // Catch:{ zzahh -> 0x0618 }
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r12, r11)     // Catch:{ zzahh -> 0x0618 }
            r7.zzI(r9, r2, r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0211:
            java.lang.Object r2 = r7.zzz(r1)     // Catch:{ zzahh -> 0x0618 }
            int r1 = r7.zzu(r1)     // Catch:{ zzahh -> 0x0618 }
            r1 = r1 & r12
            long r11 = (long) r1     // Catch:{ zzahh -> 0x0618 }
            java.lang.Object r1 = com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzf(r9, r11)     // Catch:{ zzahh -> 0x0618 }
            if (r1 == 0) goto L_0x0237
            boolean r3 = com.google.android.gms.internal.p002firebaseauthapi.zzaia.zza(r1)     // Catch:{ zzahh -> 0x0618 }
            if (r3 == 0) goto L_0x0242
            com.google.android.gms.internal.firebase-auth-api.zzahz r3 = com.google.android.gms.internal.p002firebaseauthapi.zzahz.zza()     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzahz r3 = r3.zzb()     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzaia.zzb(r3, r1)     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r11, r3)     // Catch:{ zzahh -> 0x0618 }
            r1 = r3
            goto L_0x0242
        L_0x0237:
            com.google.android.gms.internal.firebase-auth-api.zzahz r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahz.zza()     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzahz r1 = r1.zzb()     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r11, r1)     // Catch:{ zzahh -> 0x0618 }
        L_0x0242:
            com.google.android.gms.internal.firebase-auth-api.zzahz r1 = (com.google.android.gms.internal.p002firebaseauthapi.zzahz) r1     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzahy r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzahy) r2     // Catch:{ zzahh -> 0x0618 }
            throw r16     // Catch:{ zzahh -> 0x0618 }
        L_0x0247:
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r7.zzx(r1)     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzaht r3 = r7.zzm     // Catch:{ zzahh -> 0x0618 }
            long r11 = (long) r2     // Catch:{ zzahh -> 0x0618 }
            java.util.List r2 = r3.zza(r9, r11)     // Catch:{ zzahh -> 0x0618 }
            r0.zzC(r2, r1, r6)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0259:
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x0618 }
            r0.zzJ(r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0267:
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x0618 }
            r0.zzI(r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0275:
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x0618 }
            r0.zzH(r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0283:
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x0618 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x0618 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x0618 }
            r0.zzG(r1)     // Catch:{ zzahh -> 0x0618 }
            goto L_0x0183
        L_0x0291:
            com.google.android.gms.internal.firebase-auth-api.zzaht r11 = r7.zzm     // Catch:{ zzahh -> 0x0618 }
            r3 = r3 & r12
            long r12 = (long) r3     // Catch:{ zzahh -> 0x0618 }
            java.util.List r3 = r11.zza(r9, r12)     // Catch:{ zzahh -> 0x0618 }
            r0.zzy(r3)     // Catch:{ zzahh -> 0x0618 }
            com.google.android.gms.internal.firebase-auth-api.zzahe r11 = r7.zzw(r1)     // Catch:{ zzahh -> 0x0618 }
            r1 = r18
            r13 = r4
            r4 = r11
            r11 = r5
            r5 = r13
            r14 = r6
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzo(r1, r2, r3, r4, r5, r6)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x02ae:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzL(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02bf:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzv(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02d0:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzz(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02e1:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzA(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x02f2:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzD(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0303:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzM(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0314:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzE(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0325:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzB(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0336:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzx(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0347:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzJ(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0358:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzI(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0369:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzH(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x037a:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzG(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x038b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r4 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r3 = r3 & r12
            long r5 = (long) r3     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r3 = r4.zza(r9, r5)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzy(r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzahe r4 = r7.zzw(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r1 = r18
            r5 = r13
            r6 = r10
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzo(r1, r2, r3, r4, r5, r6)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x03a7:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzL(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03b8:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzw(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03c9:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzair r1 = r7.zzx(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzaht r3 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r2 = r3.zza(r9, r4)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzF(r2, r1, r14)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03de:
            r13 = r4
            r11 = r5
            r14 = r6
            boolean r1 = zzM(r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            if (r1 == 0) goto L_0x03f9
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r0
            com.google.android.gms.internal.firebase-auth-api.zzagc r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzagc) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x03f9:
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r0
            com.google.android.gms.internal.firebase-auth-api.zzagc r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzagc) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x040b:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzv(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x041c:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzz(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x042d:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzA(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x043e:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzD(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x044f:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzM(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0460:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzE(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0471:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzB(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0482:
            r13 = r4
            r11 = r5
            r14 = r6
            com.google.android.gms.internal.firebase-auth-api.zzaht r1 = r7.zzm     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            java.util.List r1 = r1.zza(r9, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzx(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0493:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzA(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzaif r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzair r3 = r7.zzx(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzt(r2, r3, r14)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzJ(r9, r1, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04a8:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzn()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzr(r9, r5, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04ba:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzi()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzq(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04cc:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzm()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzr(r9, r5, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04de:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzh()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzq(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x04f0:
            r13 = r4
            r11 = r5
            r14 = r6
            int r4 = r19.zze()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzahe r5 = r7.zzw(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            if (r5 == 0) goto L_0x050a
            boolean r5 = r5.zza()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            if (r5 == 0) goto L_0x0504
            goto L_0x050a
        L_0x0504:
            java.lang.Object r4 = com.google.android.gms.internal.p002firebaseauthapi.zzait.zzp(r9, r2, r4, r13, r10)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x0613
        L_0x050a:
            r2 = r3 & r12
            long r2 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzq(r9, r2, r4)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0515:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzj()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzq(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0527:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            com.google.android.gms.internal.firebase-auth-api.zzafv r3 = r19.zzp()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzs(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0539:
            r13 = r4
            r11 = r5
            r14 = r6
            java.lang.Object r2 = r7.zzA(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzaif r2 = (com.google.android.gms.internal.p002firebaseauthapi.zzaif) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.firebase-auth-api.zzair r3 = r7.zzx(r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r0.zzu(r2, r3, r14)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzJ(r9, r1, r2)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x054e:
            r13 = r4
            r11 = r5
            r14 = r6
            r7.zzG(r9, r3, r0)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0559:
            r0 = move-exception
            goto L_0x0651
        L_0x055c:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            boolean r3 = r19.zzN()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzm(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x056e:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzf()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzq(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0580:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzk()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzr(r9, r5, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x0591:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            int r3 = r19.zzg()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzq(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05a2:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzo()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzr(r9, r5, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05b3:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            long r3 = r19.zzl()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzr(r9, r5, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05c4:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            float r3 = r19.zzb()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r4 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzp(r9, r4, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            goto L_0x05e5
        L_0x05d5:
            r13 = r4
            r11 = r5
            r14 = r6
            r2 = r3 & r12
            double r3 = r19.zza()     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            long r5 = (long) r2     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            com.google.android.gms.internal.p002firebaseauthapi.zzajv.zzo(r9, r5, r3)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
            r7.zzH(r9, r1)     // Catch:{ zzahh -> 0x061b, all -> 0x0559 }
        L_0x05e5:
            r15 = r9
            r5 = r11
            r4 = r13
        L_0x05e8:
            r6 = r14
        L_0x05e9:
            r14 = r10
            goto L_0x0017
        L_0x05ec:
            r4 = r1
            goto L_0x05ef
        L_0x05ee:
            r4 = r13
        L_0x05ef:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ zzahh -> 0x061c }
            if (r1 != 0) goto L_0x0613
            int r0 = r7.zzk
        L_0x05f7:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x060d
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x05f7
        L_0x060d:
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
            return
        L_0x0613:
            r15 = r9
            r5 = r11
            goto L_0x05e8
        L_0x0616:
            r0 = move-exception
            goto L_0x0652
        L_0x0618:
            r13 = r4
            r11 = r5
            r14 = r6
        L_0x061b:
            r4 = r13
        L_0x061c:
            r10.zzq(r0)     // Catch:{ all -> 0x0616 }
            if (r4 != 0) goto L_0x0626
            java.lang.Object r1 = r10.zzc(r9)     // Catch:{ all -> 0x0616 }
            r4 = r1
        L_0x0626:
            boolean r1 = r10.zzp(r4, r0)     // Catch:{ all -> 0x0616 }
            if (r1 != 0) goto L_0x0613
            int r0 = r7.zzk
        L_0x062e:
            int r1 = r7.zzl
            if (r0 >= r1) goto L_0x0644
            int[] r1 = r7.zzj
            r3 = r1[r0]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r0 = r0 + 1
            goto L_0x062e
        L_0x0644:
            if (r4 == 0) goto L_0x0649
            r10.zzn(r9, r4)
        L_0x0649:
            return
        L_0x064a:
            r0 = move-exception
        L_0x064b:
            r13 = r4
            goto L_0x0651
        L_0x064d:
            r0 = move-exception
            r13 = r4
            r10 = r14
            r9 = r15
        L_0x0651:
            r4 = r13
        L_0x0652:
            int r1 = r7.zzk
            r8 = r1
        L_0x0655:
            int r1 = r7.zzl
            if (r8 >= r1) goto L_0x066b
            int[] r1 = r7.zzj
            r3 = r1[r8]
            r1 = r17
            r2 = r18
            r5 = r10
            r6 = r18
            java.lang.Object r4 = r1.zzy(r2, r3, r4, r5, r6)
            int r8 = r8 + 1
            goto L_0x0655
        L_0x066b:
            if (r4 == 0) goto L_0x0670
            r10.zzn(r9, r4)
        L_0x0670:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzaii.zzh(java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaiq, com.google.android.gms.internal.firebase-auth-api.zzagn):void");
    }

    public final void zzi(Object obj, byte[] bArr, int i11, int i12, zzafi zzafi) throws IOException {
        zzc(obj, bArr, i11, i12, 0, zzafi);
    }

    public final boolean zzj(Object obj, Object obj2) {
        boolean z11;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int zzu = zzu(i11);
            long j11 = (long) (zzu & 1048575);
            switch (zzt(zzu)) {
                case 0:
                    if (zzL(obj, obj2, i11) && Double.doubleToLongBits(zzajv.zza(obj, j11)) == Double.doubleToLongBits(zzajv.zza(obj2, j11))) {
                        continue;
                    }
                case 1:
                    if (zzL(obj, obj2, i11) && Float.floatToIntBits(zzajv.zzb(obj, j11)) == Float.floatToIntBits(zzajv.zzb(obj2, j11))) {
                        continue;
                    }
                case 2:
                    if (zzL(obj, obj2, i11) && zzajv.zzd(obj, j11) == zzajv.zzd(obj2, j11)) {
                        continue;
                    }
                case 3:
                    if (zzL(obj, obj2, i11) && zzajv.zzd(obj, j11) == zzajv.zzd(obj2, j11)) {
                        continue;
                    }
                case 4:
                    if (zzL(obj, obj2, i11) && zzajv.zzc(obj, j11) == zzajv.zzc(obj2, j11)) {
                        continue;
                    }
                case 5:
                    if (zzL(obj, obj2, i11) && zzajv.zzd(obj, j11) == zzajv.zzd(obj2, j11)) {
                        continue;
                    }
                case 6:
                    if (zzL(obj, obj2, i11) && zzajv.zzc(obj, j11) == zzajv.zzc(obj2, j11)) {
                        continue;
                    }
                case 7:
                    if (zzL(obj, obj2, i11) && zzajv.zzw(obj, j11) == zzajv.zzw(obj2, j11)) {
                        continue;
                    }
                case 8:
                    if (zzL(obj, obj2, i11) && zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11))) {
                        continue;
                    }
                case 9:
                    if (zzL(obj, obj2, i11) && zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11))) {
                        continue;
                    }
                case 10:
                    if (zzL(obj, obj2, i11) && zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11))) {
                        continue;
                    }
                case 11:
                    if (zzL(obj, obj2, i11) && zzajv.zzc(obj, j11) == zzajv.zzc(obj2, j11)) {
                        continue;
                    }
                case 12:
                    if (zzL(obj, obj2, i11) && zzajv.zzc(obj, j11) == zzajv.zzc(obj2, j11)) {
                        continue;
                    }
                case 13:
                    if (zzL(obj, obj2, i11) && zzajv.zzc(obj, j11) == zzajv.zzc(obj2, j11)) {
                        continue;
                    }
                case 14:
                    if (zzL(obj, obj2, i11) && zzajv.zzd(obj, j11) == zzajv.zzd(obj2, j11)) {
                        continue;
                    }
                case 15:
                    if (zzL(obj, obj2, i11) && zzajv.zzc(obj, j11) == zzajv.zzc(obj2, j11)) {
                        continue;
                    }
                case 16:
                    if (zzL(obj, obj2, i11) && zzajv.zzd(obj, j11) == zzajv.zzd(obj2, j11)) {
                        continue;
                    }
                case 17:
                    if (zzL(obj, obj2, i11) && zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11))) {
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
                    z11 = zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11));
                    break;
                case 50:
                    z11 = zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11));
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
                    long zzr = (long) (zzr(i11) & 1048575);
                    if (zzajv.zzc(obj, zzr) == zzajv.zzc(obj2, zzr) && zzait.zzs(zzajv.zzf(obj, j11), zzajv.zzf(obj2, j11))) {
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
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj);
        this.zzo.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        int i11;
        int i12;
        Object obj2 = obj;
        int i13 = 0;
        int i14 = 0;
        int i15 = 1048575;
        while (i14 < this.zzk) {
            int i16 = this.zzj[i14];
            int i17 = this.zzc[i16];
            int zzu = zzu(i16);
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
            if ((268435456 & zzu) != 0 && !zzO(obj, i16, i12, i11, i21)) {
                return false;
            }
            int zzt = zzt(zzu);
            if (zzt != 9 && zzt != 17) {
                if (zzt != 27) {
                    if (zzt == 60 || zzt == 68) {
                        if (zzR(obj2, i17, i16) && !zzP(obj2, zzu, zzx(i16))) {
                            return false;
                        }
                    } else if (zzt != 49) {
                        if (zzt == 50 && !((zzahz) zzajv.zzf(obj2, (long) (zzu & 1048575))).isEmpty()) {
                            zzahy zzahy = (zzahy) zzz(i16);
                            throw null;
                        }
                    }
                }
                List list = (List) zzajv.zzf(obj2, (long) (zzu & 1048575));
                if (!list.isEmpty()) {
                    zzair zzx = zzx(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zzx.zzk(list.get(i22))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzO(obj, i16, i12, i11, i21) && !zzP(obj2, zzu, zzx(i16))) {
                return false;
            }
            i14++;
            i15 = i12;
            i13 = i11;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzo.zza(obj2);
        throw null;
    }

    public final void zzm(Object obj, zzagj zzagj) throws IOException {
        int i11;
        int i12;
        int i13;
        int i14;
        Object obj2 = obj;
        zzagj zzagj2 = zzagj;
        if (!this.zzh) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i15 = 1048575;
            int i16 = 1048575;
            int i17 = 0;
            int i18 = 0;
            while (i18 < length) {
                int zzu = zzu(i18);
                int[] iArr = this.zzc;
                int i19 = iArr[i18];
                int zzt = zzt(zzu);
                if (zzt <= 17) {
                    int i21 = iArr[i18 + 2];
                    int i22 = i21 & i15;
                    if (i22 != i16) {
                        if (i22 == i15) {
                            i14 = 0;
                        } else {
                            i14 = unsafe.getInt(obj2, (long) i22);
                        }
                        i17 = i14;
                        i16 = i22;
                    }
                    i12 = i16;
                    i11 = i17;
                    i13 = 1 << (i21 >>> 20);
                } else {
                    i12 = i16;
                    i11 = i17;
                    i13 = 0;
                }
                long j11 = (long) (zzu & i15);
                switch (zzt) {
                    case 0:
                        long j12 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzf(i19, zzajv.zza(obj2, j12));
                            break;
                        }
                    case 1:
                        long j13 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzo(i19, zzajv.zzb(obj2, j13));
                            break;
                        }
                    case 2:
                        long j14 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzt(i19, unsafe.getLong(obj2, j14));
                            break;
                        }
                    case 3:
                        long j15 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzJ(i19, unsafe.getLong(obj2, j15));
                            break;
                        }
                    case 4:
                        long j16 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzr(i19, unsafe.getInt(obj2, j16));
                            break;
                        }
                    case 5:
                        long j17 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzm(i19, unsafe.getLong(obj2, j17));
                            break;
                        }
                    case 6:
                        long j18 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzk(i19, unsafe.getInt(obj2, j18));
                            break;
                        }
                    case 7:
                        long j19 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzb(i19, zzajv.zzw(obj2, j19));
                            break;
                        }
                    case 8:
                        long j21 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzT(i19, unsafe.getObject(obj2, j21), zzagj2);
                            break;
                        }
                    case 9:
                        long j22 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzv(i19, unsafe.getObject(obj2, j22), zzx(i18));
                            break;
                        }
                    case 10:
                        long j23 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzd(i19, (zzafv) unsafe.getObject(obj2, j23));
                            break;
                        }
                    case 11:
                        long j24 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzH(i19, unsafe.getInt(obj2, j24));
                            break;
                        }
                    case 12:
                        long j25 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzi(i19, unsafe.getInt(obj2, j25));
                            break;
                        }
                    case 13:
                        long j26 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzw(i19, unsafe.getInt(obj2, j26));
                            break;
                        }
                    case 14:
                        long j27 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzy(i19, unsafe.getLong(obj2, j27));
                            break;
                        }
                    case 15:
                        long j28 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzA(i19, unsafe.getInt(obj2, j28));
                            break;
                        }
                    case 16:
                        long j29 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzC(i19, unsafe.getLong(obj2, j29));
                            break;
                        }
                    case 17:
                        long j31 = j11;
                        if (!zzO(obj, i18, i12, i11, i13)) {
                            break;
                        } else {
                            zzagj2.zzq(i19, unsafe.getObject(obj2, j31), zzx(i18));
                            break;
                        }
                    case 18:
                        zzait.zzu(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 19:
                        zzait.zzy(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 20:
                        zzait.zzA(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 21:
                        zzait.zzG(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 22:
                        zzait.zzz(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 23:
                        zzait.zzx(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 24:
                        zzait.zzw(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 25:
                        zzait.zzt(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 26:
                        int i23 = this.zzc[i18];
                        List list = (List) unsafe.getObject(obj2, j11);
                        int i24 = zzait.zza;
                        if (list != null && !list.isEmpty()) {
                            zzagj2.zzG(i23, list);
                            break;
                        }
                    case 27:
                        int i25 = this.zzc[i18];
                        List list2 = (List) unsafe.getObject(obj2, j11);
                        zzair zzx = zzx(i18);
                        int i26 = zzait.zza;
                        if (list2 != null && !list2.isEmpty()) {
                            for (int i27 = 0; i27 < list2.size(); i27++) {
                                zzagj2.zzv(i25, list2.get(i27), zzx);
                            }
                            break;
                        }
                    case 28:
                        int i28 = this.zzc[i18];
                        List list3 = (List) unsafe.getObject(obj2, j11);
                        int i29 = zzait.zza;
                        if (list3 != null && !list3.isEmpty()) {
                            zzagj2.zze(i28, list3);
                            break;
                        }
                    case 29:
                        zzait.zzF(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 30:
                        zzait.zzv(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 31:
                        zzait.zzB(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 32:
                        zzait.zzC(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 33:
                        zzait.zzD(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 34:
                        zzait.zzE(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, false);
                        break;
                    case 35:
                        zzait.zzu(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 36:
                        zzait.zzy(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 37:
                        zzait.zzA(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 38:
                        zzait.zzG(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 39:
                        zzait.zzz(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 40:
                        zzait.zzx(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 41:
                        zzait.zzw(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 42:
                        zzait.zzt(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 43:
                        zzait.zzF(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 44:
                        zzait.zzv(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 45:
                        zzait.zzB(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 46:
                        zzait.zzC(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 47:
                        zzait.zzD(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 48:
                        zzait.zzE(this.zzc[i18], (List) unsafe.getObject(obj2, j11), zzagj2, true);
                        break;
                    case 49:
                        int i31 = this.zzc[i18];
                        List list4 = (List) unsafe.getObject(obj2, j11);
                        zzair zzx2 = zzx(i18);
                        int i32 = zzait.zza;
                        if (list4 != null && !list4.isEmpty()) {
                            for (int i33 = 0; i33 < list4.size(); i33++) {
                                zzagj2.zzq(i31, list4.get(i33), zzx2);
                            }
                            break;
                        }
                    case 50:
                        if (unsafe.getObject(obj2, j11) == null) {
                            break;
                        } else {
                            zzahy zzahy = (zzahy) zzz(i18);
                            throw null;
                        }
                    case 51:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzf(i19, zzn(obj2, j11));
                            break;
                        }
                    case 52:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzo(i19, zzo(obj2, j11));
                            break;
                        }
                    case 53:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzt(i19, zzv(obj2, j11));
                            break;
                        }
                    case 54:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzJ(i19, zzv(obj2, j11));
                            break;
                        }
                    case 55:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzr(i19, zzp(obj2, j11));
                            break;
                        }
                    case 56:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzm(i19, zzv(obj2, j11));
                            break;
                        }
                    case 57:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzk(i19, zzp(obj2, j11));
                            break;
                        }
                    case 58:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzb(i19, zzS(obj2, j11));
                            break;
                        }
                    case 59:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzT(i19, unsafe.getObject(obj2, j11), zzagj2);
                            break;
                        }
                    case 60:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzv(i19, unsafe.getObject(obj2, j11), zzx(i18));
                            break;
                        }
                    case 61:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzd(i19, (zzafv) unsafe.getObject(obj2, j11));
                            break;
                        }
                    case 62:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzH(i19, zzp(obj2, j11));
                            break;
                        }
                    case 63:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzi(i19, zzp(obj2, j11));
                            break;
                        }
                    case 64:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzw(i19, zzp(obj2, j11));
                            break;
                        }
                    case 65:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzy(i19, zzv(obj2, j11));
                            break;
                        }
                    case 66:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzA(i19, zzp(obj2, j11));
                            break;
                        }
                    case 67:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzC(i19, zzv(obj2, j11));
                            break;
                        }
                    case 68:
                        if (!zzR(obj2, i19, i18)) {
                            break;
                        } else {
                            zzagj2.zzq(i19, unsafe.getObject(obj2, j11), zzx(i18));
                            break;
                        }
                }
                i18 += 3;
                i16 = i12;
                i17 = i11;
                i15 = 1048575;
            }
            zzajl zzajl = this.zzn;
            zzajl.zzr(zzajl.zzd(obj2), zzagj2);
            return;
        }
        this.zzo.zza(obj2);
        throw null;
    }
}
