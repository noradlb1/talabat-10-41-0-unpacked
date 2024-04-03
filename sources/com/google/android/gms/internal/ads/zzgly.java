package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzgly<T> implements zzgmo<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzgnp.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzglv zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final int[] zzk;
    private final int zzl;
    private final int zzm;
    private final zzglj zzn;
    private final zzgnf<?, ?> zzo;
    private final zzgjy<?> zzp;
    private final zzgma zzq;
    private final zzglq zzr;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.ads.zzglv} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.google.android.gms.internal.ads.zzgma} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.ads.zzglq} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.ads.zzgjy, com.google.android.gms.internal.ads.zzgjy<?>] */
    /* JADX WARNING: type inference failed for: r3v2, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [int] */
    /* JADX WARNING: type inference failed for: r3v12, types: [com.google.android.gms.internal.ads.zzglj] */
    /* JADX WARNING: type inference failed for: r3v13, types: [com.google.android.gms.internal.ads.zzgnf<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzgly(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.ads.zzglv r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.ads.zzgma r17, com.google.android.gms.internal.ads.zzglj r18, com.google.android.gms.internal.ads.zzgnf<?, ?> r19, com.google.android.gms.internal.ads.zzgjy<?> r20, com.google.android.gms.internal.ads.zzglq r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r8
            r0.zze = r3
            r3 = r9
            r0.zzf = r3
            boolean r3 = r1 instanceof com.google.android.gms.internal.ads.zzgkl
            r0.zzi = r3
            r3 = r11
            r0.zzj = r3
            r3 = 0
            if (r2 == 0) goto L_0x0024
            boolean r4 = r2.zzh(r10)
            if (r4 == 0) goto L_0x0024
            r3 = 1
        L_0x0024:
            r0.zzh = r3
            r3 = r13
            r0.zzk = r3
            r3 = r14
            r0.zzl = r3
            r3 = r15
            r0.zzm = r3
            r3 = r16
            r0.zzq = r3
            r3 = r17
            r0.zzn = r3
            r3 = r18
            r0.zzo = r3
            r0.zzp = r2
            r0.zzg = r1
            r1 = r20
            r0.zzr = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.ads.zzglv, boolean, boolean, int[], int, int, com.google.android.gms.internal.ads.zzgma, com.google.android.gms.internal.ads.zzglj, com.google.android.gms.internal.ads.zzgnf, com.google.android.gms.internal.ads.zzgjy, com.google.android.gms.internal.ads.zzglq, byte[]):void");
    }

    private final int zzA(int i11, int i12) {
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

    private static int zzB(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzC(int i11) {
        return this.zzc[i11 + 1];
    }

    private static <T> long zzD(T t11, long j11) {
        return ((Long) zzgnp.zzh(t11, j11)).longValue();
    }

    private final zzgkp zzE(int i11) {
        int i12 = i11 / 3;
        return (zzgkp) this.zzd[i12 + i12 + 1];
    }

    private final zzgmo zzF(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzgmo zzgmo = (zzgmo) this.zzd[i13];
        if (zzgmo != null) {
            return zzgmo;
        }
        zzgmo zzb2 = zzgmd.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final <UT, UB> UB zzG(Object obj, int i11, UB ub2, zzgnf<UT, UB> zzgnf) {
        int i12 = this.zzc[i11];
        Object zzh2 = zzgnp.zzh(obj, (long) (zzC(i11) & 1048575));
        if (zzh2 == null || zzE(i11) == null) {
            return ub2;
        }
        zzglp zzglp = (zzglp) zzh2;
        zzglo zzglo = (zzglo) zzH(i11);
        throw null;
    }

    private final Object zzH(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private static Field zzI(Class<?> cls, String str) {
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

    private final void zzJ(T t11, T t12, int i11) {
        long zzC = (long) (zzC(i11) & 1048575);
        if (zzQ(t12, i11)) {
            Object zzh2 = zzgnp.zzh(t11, zzC);
            Object zzh3 = zzgnp.zzh(t12, zzC);
            if (zzh2 != null && zzh3 != null) {
                zzgnp.zzv(t11, zzC, zzgkv.zzg(zzh2, zzh3));
                zzM(t11, i11);
            } else if (zzh3 != null) {
                zzgnp.zzv(t11, zzC, zzh3);
                zzM(t11, i11);
            }
        }
    }

    private final void zzK(T t11, T t12, int i11) {
        Object obj;
        int zzC = zzC(i11);
        int i12 = this.zzc[i11];
        long j11 = (long) (zzC & 1048575);
        if (zzT(t12, i12, i11)) {
            if (zzT(t11, i12, i11)) {
                obj = zzgnp.zzh(t11, j11);
            } else {
                obj = null;
            }
            Object zzh2 = zzgnp.zzh(t12, j11);
            if (obj != null && zzh2 != null) {
                zzgnp.zzv(t11, j11, zzgkv.zzg(obj, zzh2));
                zzN(t11, i12, i11);
            } else if (zzh2 != null) {
                zzgnp.zzv(t11, j11, zzh2);
                zzN(t11, i12, i11);
            }
        }
    }

    private final void zzL(Object obj, int i11, zzgmg zzgmg) throws IOException {
        if (zzP(i11)) {
            zzgnp.zzv(obj, (long) (i11 & 1048575), zzgmg.zzu());
        } else if (this.zzi) {
            zzgnp.zzv(obj, (long) (i11 & 1048575), zzgmg.zzt());
        } else {
            zzgnp.zzv(obj, (long) (i11 & 1048575), zzgmg.zzp());
        }
    }

    private final void zzM(T t11, int i11) {
        int zzz = zzz(i11);
        long j11 = (long) (1048575 & zzz);
        if (j11 != 1048575) {
            zzgnp.zzt(t11, j11, (1 << (zzz >>> 20)) | zzgnp.zzd(t11, j11));
        }
    }

    private final void zzN(T t11, int i11, int i12) {
        zzgnp.zzt(t11, (long) (zzz(i12) & 1048575), i11);
    }

    private final boolean zzO(T t11, T t12, int i11) {
        return zzQ(t11, i11) == zzQ(t12, i11);
    }

    private static boolean zzP(int i11) {
        return (i11 & 536870912) != 0;
    }

    private final boolean zzQ(T t11, int i11) {
        int zzz = zzz(i11);
        long j11 = (long) (zzz & 1048575);
        if (j11 == 1048575) {
            int zzC = zzC(i11);
            long j12 = (long) (zzC & 1048575);
            switch (zzB(zzC)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzgnp.zzb(t11, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzgnp.zzc(t11, j12)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzgnp.zzf(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzgnp.zzf(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzgnp.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzgnp.zzf(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzgnp.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzgnp.zzz(t11, j12);
                case 8:
                    Object zzh2 = zzgnp.zzh(t11, j12);
                    if (zzh2 instanceof String) {
                        if (!((String) zzh2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzh2 instanceof zzgjf)) {
                        throw new IllegalArgumentException();
                    } else if (!zzgjf.zzb.equals(zzh2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzgnp.zzh(t11, j12) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzgjf.zzb.equals(zzgnp.zzh(t11, j12))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzgnp.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzgnp.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzgnp.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzgnp.zzf(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzgnp.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzgnp.zzf(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzgnp.zzh(t11, j12) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzgnp.zzd(t11, j11) & (1 << (zzz >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean zzR(T t11, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzQ(t11, i11) : (i13 & i14) != 0;
    }

    private static boolean zzS(Object obj, int i11, zzgmo zzgmo) {
        return zzgmo.zzk(zzgnp.zzh(obj, (long) (i11 & 1048575)));
    }

    private final boolean zzT(T t11, int i11, int i12) {
        if (zzgnp.zzd(t11, (long) (zzz(i12) & 1048575)) == i11) {
            return true;
        }
        return false;
    }

    private static <T> boolean zzU(T t11, long j11) {
        return ((Boolean) zzgnp.zzh(t11, j11)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044e, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029d, code lost:
        r12 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzV(T r17, com.google.android.gms.internal.ads.zzgjt r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzh
            if (r3 != 0) goto L_0x045f
            int[] r3 = r0.zzc
            int r3 = r3.length
            sun.misc.Unsafe r4 = zzb
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r5
            r7 = 0
            r8 = 0
        L_0x0015:
            if (r7 >= r3) goto L_0x0455
            int r10 = r0.zzC(r7)
            int[] r11 = r0.zzc
            r11 = r11[r7]
            int r12 = zzB(r10)
            r13 = 17
            r14 = 1
            if (r12 > r13) goto L_0x003d
            int[] r13 = r0.zzc
            int r15 = r7 + 2
            r13 = r13[r15]
            r15 = r13 & r5
            if (r15 == r9) goto L_0x0038
            long r8 = (long) r15
            int r8 = r4.getInt(r1, r8)
            r9 = r15
        L_0x0038:
            int r13 = r13 >>> 20
            int r13 = r14 << r13
            goto L_0x003e
        L_0x003d:
            r13 = 0
        L_0x003e:
            r10 = r10 & r5
            long r5 = (long) r10
            switch(r12) {
                case 0: goto L_0x0442;
                case 1: goto L_0x0435;
                case 2: goto L_0x0428;
                case 3: goto L_0x041b;
                case 4: goto L_0x040e;
                case 5: goto L_0x0401;
                case 6: goto L_0x03f4;
                case 7: goto L_0x03e7;
                case 8: goto L_0x03d9;
                case 9: goto L_0x03c7;
                case 10: goto L_0x03b7;
                case 11: goto L_0x03a9;
                case 12: goto L_0x039b;
                case 13: goto L_0x038d;
                case 14: goto L_0x037f;
                case 15: goto L_0x0371;
                case 16: goto L_0x0363;
                case 17: goto L_0x0351;
                case 18: goto L_0x0341;
                case 19: goto L_0x0331;
                case 20: goto L_0x0321;
                case 21: goto L_0x0311;
                case 22: goto L_0x0301;
                case 23: goto L_0x02f1;
                case 24: goto L_0x02e1;
                case 25: goto L_0x02d1;
                case 26: goto L_0x02c2;
                case 27: goto L_0x02af;
                case 28: goto L_0x02a0;
                case 29: goto L_0x028f;
                case 30: goto L_0x0280;
                case 31: goto L_0x0271;
                case 32: goto L_0x0262;
                case 33: goto L_0x0253;
                case 34: goto L_0x0244;
                case 35: goto L_0x0235;
                case 36: goto L_0x0226;
                case 37: goto L_0x0217;
                case 38: goto L_0x0208;
                case 39: goto L_0x01f9;
                case 40: goto L_0x01ea;
                case 41: goto L_0x01db;
                case 42: goto L_0x01cc;
                case 43: goto L_0x01bd;
                case 44: goto L_0x01ae;
                case 45: goto L_0x019f;
                case 46: goto L_0x0190;
                case 47: goto L_0x0181;
                case 48: goto L_0x0172;
                case 49: goto L_0x015f;
                case 50: goto L_0x0156;
                case 51: goto L_0x0147;
                case 52: goto L_0x0138;
                case 53: goto L_0x0129;
                case 54: goto L_0x011a;
                case 55: goto L_0x010b;
                case 56: goto L_0x00fc;
                case 57: goto L_0x00ed;
                case 58: goto L_0x00de;
                case 59: goto L_0x00cf;
                case 60: goto L_0x00bc;
                case 61: goto L_0x00ac;
                case 62: goto L_0x009e;
                case 63: goto L_0x0090;
                case 64: goto L_0x0082;
                case 65: goto L_0x0074;
                case 66: goto L_0x0066;
                case 67: goto L_0x0058;
                case 68: goto L_0x0046;
                default: goto L_0x0043;
            }
        L_0x0043:
            r12 = 0
            goto L_0x044e
        L_0x0046:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.ads.zzgmo r6 = r0.zzF(r7)
            r2.zzq(r11, r5, r6)
            goto L_0x0043
        L_0x0058:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzC(r11, r5)
            goto L_0x0043
        L_0x0066:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzA(r11, r5)
            goto L_0x0043
        L_0x0074:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzy(r11, r5)
            goto L_0x0043
        L_0x0082:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzw(r11, r5)
            goto L_0x0043
        L_0x0090:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x0043
        L_0x009e:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x0043
        L_0x00ac:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.ads.zzgjf r5 = (com.google.android.gms.internal.ads.zzgjf) r5
            r2.zzd(r11, r5)
            goto L_0x0043
        L_0x00bc:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.ads.zzgmo r6 = r0.zzF(r7)
            r2.zzv(r11, r5, r6)
            goto L_0x0043
        L_0x00cf:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzX(r11, r5, r2)
            goto L_0x0043
        L_0x00de:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            boolean r5 = zzU(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x0043
        L_0x00ed:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x0043
        L_0x00fc:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzm(r11, r5)
            goto L_0x0043
        L_0x010b:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzs(r1, r5)
            r2.zzr(r11, r5)
            goto L_0x0043
        L_0x011a:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzJ(r11, r5)
            goto L_0x0043
        L_0x0129:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzD(r1, r5)
            r2.zzt(r11, r5)
            goto L_0x0043
        L_0x0138:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            float r5 = zzp(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x0043
        L_0x0147:
            boolean r10 = r0.zzT(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            double r5 = zzo(r1, r5)
            r2.zzf(r11, r5)
            goto L_0x0043
        L_0x0156:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzW(r2, r11, r5, r7)
            goto L_0x0043
        L_0x015f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmo r6 = r0.zzF(r7)
            com.google.android.gms.internal.ads.zzgmq.zzQ(r10, r5, r2, r6)
            goto L_0x0043
        L_0x0172:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzX(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0181:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzW(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0190:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzV(r10, r5, r2, r14)
            goto L_0x0043
        L_0x019f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzU(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ae:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzM(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01bd:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzZ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01cc:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzJ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01db:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzN(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ea:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzO(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01f9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzR(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0208:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzaa(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0217:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzS(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0226:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzP(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0235:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzL(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0244:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.gms.internal.ads.zzgmq.zzX(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0253:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzW(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0262:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzV(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0271:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzU(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0280:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzM(r10, r5, r2, r11)
            goto L_0x029d
        L_0x028f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzZ(r10, r5, r2, r11)
        L_0x029d:
            r12 = r11
            goto L_0x044e
        L_0x02a0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzK(r10, r5, r2)
            goto L_0x0043
        L_0x02af:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmo r6 = r0.zzF(r7)
            com.google.android.gms.internal.ads.zzgmq.zzT(r10, r5, r2, r6)
            goto L_0x0043
        L_0x02c2:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzY(r10, r5, r2)
            goto L_0x0043
        L_0x02d1:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.android.gms.internal.ads.zzgmq.zzJ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02e1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzN(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02f1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzO(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0301:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzR(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0311:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzaa(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0321:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzS(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0331:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzP(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0341:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.gms.internal.ads.zzgmq.zzL(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0351:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.ads.zzgmo r6 = r0.zzF(r7)
            r2.zzq(r11, r5, r6)
            goto L_0x044e
        L_0x0363:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzC(r11, r5)
            goto L_0x044e
        L_0x0371:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzA(r11, r5)
            goto L_0x044e
        L_0x037f:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzy(r11, r5)
            goto L_0x044e
        L_0x038d:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzw(r11, r5)
            goto L_0x044e
        L_0x039b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzi(r11, r5)
            goto L_0x044e
        L_0x03a9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x044e
        L_0x03b7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.ads.zzgjf r5 = (com.google.android.gms.internal.ads.zzgjf) r5
            r2.zzd(r11, r5)
            goto L_0x044e
        L_0x03c7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.gms.internal.ads.zzgmo r6 = r0.zzF(r7)
            r2.zzv(r11, r5, r6)
            goto L_0x044e
        L_0x03d9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzX(r11, r5, r2)
            goto L_0x044e
        L_0x03e7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            boolean r5 = com.google.android.gms.internal.ads.zzgnp.zzz(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x044e
        L_0x03f4:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzk(r11, r5)
            goto L_0x044e
        L_0x0401:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzm(r11, r5)
            goto L_0x044e
        L_0x040e:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzr(r11, r5)
            goto L_0x044e
        L_0x041b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzJ(r11, r5)
            goto L_0x044e
        L_0x0428:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzt(r11, r5)
            goto L_0x044e
        L_0x0435:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            float r5 = com.google.android.gms.internal.ads.zzgnp.zzc(r1, r5)
            r2.zzo(r11, r5)
            goto L_0x044e
        L_0x0442:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            double r5 = com.google.android.gms.internal.ads.zzgnp.zzb(r1, r5)
            r2.zzf(r11, r5)
        L_0x044e:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0455:
            com.google.android.gms.internal.ads.zzgnf<?, ?> r3 = r0.zzo
            java.lang.Object r1 = r3.zzd(r1)
            r3.zzr(r1, r2)
            return
        L_0x045f:
            com.google.android.gms.internal.ads.zzgjy<?> r2 = r0.zzp
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzV(java.lang.Object, com.google.android.gms.internal.ads.zzgjt):void");
    }

    private final <K, V> void zzW(zzgjt zzgjt, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzglo zzglo = (zzglo) zzH(i12);
            throw null;
        }
    }

    private static final void zzX(int i11, Object obj, zzgjt zzgjt) throws IOException {
        if (obj instanceof String) {
            zzgjt.zzF(i11, (String) obj);
        } else {
            zzgjt.zzd(i11, (zzgjf) obj);
        }
    }

    public static zzgng zzd(Object obj) {
        zzgkl zzgkl = (zzgkl) obj;
        zzgng zzgng = zzgkl.zzc;
        if (zzgng != zzgng.zzc()) {
            return zzgng;
        }
        zzgng zze2 = zzgng.zze();
        zzgkl.zzc = zze2;
        return zze2;
    }

    public static <T> zzgly<T> zzl(Class<T> cls, zzgls zzgls, zzgma zzgma, zzglj zzglj, zzgnf<?, ?> zzgnf, zzgjy<?> zzgjy, zzglq zzglq) {
        if (zzgls instanceof zzgmf) {
            return zzm((zzgmf) zzgls, zzgma, zzglj, zzgnf, zzgjy, zzglq);
        }
        zzgnc zzgnc = (zzgnc) zzgls;
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
    public static <T> com.google.android.gms.internal.ads.zzgly<T> zzm(com.google.android.gms.internal.ads.zzgmf r34, com.google.android.gms.internal.ads.zzgma r35, com.google.android.gms.internal.ads.zzglj r36, com.google.android.gms.internal.ads.zzgnf<?, ?> r37, com.google.android.gms.internal.ads.zzgjy<?> r38, com.google.android.gms.internal.ads.zzglq r39) {
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
            com.google.android.gms.internal.ads.zzglv r18 = r34.zza()
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
            java.lang.reflect.Field r12 = zzI(r2, r12)
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
            java.lang.reflect.Field r8 = zzI(r2, r8)
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
            java.lang.reflect.Field r8 = zzI(r2, r8)
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
            java.lang.reflect.Field r11 = zzI(r2, r11)
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
            com.google.android.gms.internal.ads.zzgly r0 = new com.google.android.gms.internal.ads.zzgly
            r4 = r0
            com.google.android.gms.internal.ads.zzglv r9 = r34.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzm(com.google.android.gms.internal.ads.zzgmf, com.google.android.gms.internal.ads.zzgma, com.google.android.gms.internal.ads.zzglj, com.google.android.gms.internal.ads.zzgnf, com.google.android.gms.internal.ads.zzgjy, com.google.android.gms.internal.ads.zzglq):com.google.android.gms.internal.ads.zzgly");
    }

    private static <T> double zzo(T t11, long j11) {
        return ((Double) zzgnp.zzh(t11, j11)).doubleValue();
    }

    private static <T> float zzp(T t11, long j11) {
        return ((Float) zzgnp.zzh(t11, j11)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0302, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0469, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b3, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04de, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04df, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0506, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0513, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0521, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0525, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzq(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r2
        L_0x000a:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x0529
            int r7 = r14.zzC(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzB(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0035
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r2
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0036
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0036
        L_0x0035:
            r10 = r1
        L_0x0036:
            r7 = r7 & r2
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0517;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e1;
                case 4: goto L_0x04cc;
                case 5: goto L_0x04c1;
                case 6: goto L_0x04b6;
                case 7: goto L_0x04a9;
                case 8: goto L_0x047f;
                case 9: goto L_0x046d;
                case 10: goto L_0x0451;
                case 11: goto L_0x043d;
                case 12: goto L_0x0429;
                case 13: goto L_0x041d;
                case 14: goto L_0x0411;
                case 15: goto L_0x03f8;
                case 16: goto L_0x03e0;
                case 17: goto L_0x03cd;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03b5;
                case 20: goto L_0x03aa;
                case 21: goto L_0x039f;
                case 22: goto L_0x0394;
                case 23: goto L_0x0389;
                case 24: goto L_0x037e;
                case 25: goto L_0x0373;
                case 26: goto L_0x0368;
                case 27: goto L_0x0359;
                case 28: goto L_0x034d;
                case 29: goto L_0x0341;
                case 30: goto L_0x0335;
                case 31: goto L_0x0329;
                case 32: goto L_0x031d;
                case 33: goto L_0x0311;
                case 34: goto L_0x0305;
                case 35: goto L_0x02ee;
                case 36: goto L_0x02d9;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02af;
                case 39: goto L_0x029a;
                case 40: goto L_0x0285;
                case 41: goto L_0x026f;
                case 42: goto L_0x0259;
                case 43: goto L_0x0243;
                case 44: goto L_0x022d;
                case 45: goto L_0x0217;
                case 46: goto L_0x0201;
                case 47: goto L_0x01eb;
                case 48: goto L_0x01d5;
                case 49: goto L_0x01c5;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01aa;
                case 52: goto L_0x019c;
                case 53: goto L_0x0186;
                case 54: goto L_0x0170;
                case 55: goto L_0x015a;
                case 56: goto L_0x014c;
                case 57: goto L_0x013e;
                case 58: goto L_0x0130;
                case 59: goto L_0x0102;
                case 60: goto L_0x00ee;
                case 61: goto L_0x00d2;
                case 62: goto L_0x00bc;
                case 63: goto L_0x00a6;
                case 64: goto L_0x0098;
                case 65: goto L_0x008a;
                case 66: goto L_0x006f;
                case 67: goto L_0x0055;
                case 68: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0525
        L_0x003f:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzglv r7 = (com.google.android.gms.internal.ads.zzglv) r7
            com.google.android.gms.internal.ads.zzgmo r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzu(r8, r7, r9)
            goto L_0x03ca
        L_0x0055:
            boolean r9 = r14.zzT(r15, r8, r3)
            if (r9 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzB(r9)
            goto L_0x04de
        L_0x006f:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x04de
        L_0x008a:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0521
        L_0x0098:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0513
        L_0x00a6:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzv(r7)
            goto L_0x04de
        L_0x00bc:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x04de
        L_0x00d2:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgjf r7 = (com.google.android.gms.internal.ads.zzgjf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0469
        L_0x00ee:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgmo r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x0102:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.ads.zzgjf
            if (r9 == 0) goto L_0x0122
            com.google.android.gms.internal.ads.zzgjf r7 = (com.google.android.gms.internal.ads.zzgjf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0469
        L_0x0122:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzy(r7)
            goto L_0x04de
        L_0x0130:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x04b3
        L_0x013e:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0513
        L_0x014c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0521
        L_0x015a:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzs(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzv(r7)
            goto L_0x04de
        L_0x0170:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzB(r9)
            goto L_0x0506
        L_0x0186:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzD(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzB(r9)
            goto L_0x0506
        L_0x019c:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0513
        L_0x01aa:
            boolean r7 = r14.zzT(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0521
        L_0x01b8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzH(r3)
            com.google.android.gms.internal.ads.zzglq.zza(r8, r7, r9)
            goto L_0x0525
        L_0x01c5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzgmo r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzj(r8, r7, r9)
            goto L_0x03ca
        L_0x01d5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzt(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x01eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x0201:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zze(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzw(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzb(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x026f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x0285:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x029a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzl(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x02af:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzy(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x02c4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzn(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x02d9:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0302
        L_0x02ee:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzz(r8)
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
        L_0x0302:
            int r8 = r8 + r9
            goto L_0x04de
        L_0x0305:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzs(r8, r7, r1)
            goto L_0x03ca
        L_0x0311:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzq(r8, r7, r1)
            goto L_0x03ca
        L_0x031d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzh(r8, r7, r1)
            goto L_0x03ca
        L_0x0329:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzf(r8, r7, r1)
            goto L_0x03ca
        L_0x0335:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzd(r8, r7, r1)
            goto L_0x03ca
        L_0x0341:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzv(r8, r7, r1)
            goto L_0x03ca
        L_0x034d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzc(r8, r7)
            goto L_0x03ca
        L_0x0359:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.ads.zzgmo r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzp(r8, r7, r9)
            goto L_0x03ca
        L_0x0368:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzu(r8, r7)
            goto L_0x03ca
        L_0x0373:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zza(r8, r7, r1)
            goto L_0x03ca
        L_0x037e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzf(r8, r7, r1)
            goto L_0x03ca
        L_0x0389:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzh(r8, r7, r1)
            goto L_0x03ca
        L_0x0394:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzk(r8, r7, r1)
            goto L_0x03ca
        L_0x039f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzx(r8, r7, r1)
            goto L_0x03ca
        L_0x03aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzm(r8, r7, r1)
            goto L_0x03ca
        L_0x03b5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzf(r8, r7, r1)
            goto L_0x03ca
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzh(r8, r7, r1)
        L_0x03ca:
            int r4 = r4 + r7
            goto L_0x0525
        L_0x03cd:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzglv r7 = (com.google.android.gms.internal.ads.zzglv) r7
            com.google.android.gms.internal.ads.zzgmo r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzu(r8, r7, r9)
            goto L_0x03ca
        L_0x03e0:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzB(r9)
            goto L_0x04de
        L_0x03f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x04de
        L_0x0411:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0521
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0513
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzv(r7)
            goto L_0x04de
        L_0x043d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x04de
        L_0x0451:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgjf r7 = (com.google.android.gms.internal.ads.zzgjf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
        L_0x0469:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04df
        L_0x046d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.ads.zzgmo r9 = r14.zzF(r3)
            int r7 = com.google.android.gms.internal.ads.zzgmq.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x047f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.ads.zzgjf
            if (r9 == 0) goto L_0x049c
            com.google.android.gms.internal.ads.zzgjf r7 = (com.google.android.gms.internal.ads.zzgjf) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0469
        L_0x049c:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzy(r7)
            goto L_0x04de
        L_0x04a9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
        L_0x04b3:
            int r7 = r7 + r11
            goto L_0x03ca
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0513
        L_0x04c1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            goto L_0x0521
        L_0x04cc:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzA(r8)
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzv(r7)
        L_0x04de:
            int r8 = r8 + r7
        L_0x04df:
            int r4 = r4 + r8
            goto L_0x0525
        L_0x04e1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzB(r9)
            goto L_0x0506
        L_0x04f4:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
            int r8 = com.google.android.gms.internal.ads.zzgjs.zzB(r9)
        L_0x0506:
            int r7 = r7 + r8
            goto L_0x03ca
        L_0x0509:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
        L_0x0513:
            int r7 = r7 + 4
            goto L_0x03ca
        L_0x0517:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.ads.zzgjs.zzA(r7)
        L_0x0521:
            int r7 = r7 + 8
            goto L_0x03ca
        L_0x0525:
            int r3 = r3 + 3
            goto L_0x000a
        L_0x0529:
            com.google.android.gms.internal.ads.zzgnf<?, ?> r0 = r14.zzo
            java.lang.Object r1 = r0.zzd(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzh
            if (r0 != 0) goto L_0x0539
            return r4
        L_0x0539:
            com.google.android.gms.internal.ads.zzgjy<?> r0 = r14.zzp
            r0.zza(r15)
            r15 = 0
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzq(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzr(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzC(r2)
            int r5 = zzB(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.ads.zzgkd r4 = com.google.android.gms.internal.ads.zzgkd.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.ads.zzgkd r4 = com.google.android.gms.internal.ads.zzgkd.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzglv r4 = (com.google.android.gms.internal.ads.zzglv) r4
            com.google.android.gms.internal.ads.zzgmo r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzT(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzD(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgjf r4 = (com.google.android.gms.internal.ads.zzgjf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgmo r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgjf
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.ads.zzgjf r4 = (com.google.android.gms.internal.ads.zzgjf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzs(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r6)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzD(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r6)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzT(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.lang.Object r5 = r11.zzH(r2)
            com.google.android.gms.internal.ads.zzglq.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgmo r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzz(r6)
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.ads.zzgmo r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzglv r4 = (com.google.android.gms.internal.ads.zzglv) r4
            com.google.android.gms.internal.ads.zzgmo r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzQ(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.ads.zzgnp.zzf(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgnp.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgnp.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgnp.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgjf r4 = (com.google.android.gms.internal.ads.zzgjf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            com.google.android.gms.internal.ads.zzgmo r5 = r11.zzF(r2)
            int r4 = com.google.android.gms.internal.ads.zzgmq.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzgjf
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.ads.zzgjf r4 = (com.google.android.gms.internal.ads.zzgjf) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.ads.zzgnp.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.ads.zzgjs.zzA(r5)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.ads.zzgnp.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r6)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.ads.zzgnp.zzf(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.ads.zzgjs.zzA(r6)
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzQ(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.ads.zzgjs.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.ads.zzgnf<?, ?> r0 = r11.zzo
            java.lang.Object r12 = r0.zzd(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzr(java.lang.Object):int");
    }

    private static <T> int zzs(T t11, long j11) {
        return ((Integer) zzgnp.zzh(t11, j11)).intValue();
    }

    private final <K, V> int zzt(T t11, byte[] bArr, int i11, int i12, int i13, long j11, zzgiq zzgiq) throws IOException {
        Unsafe unsafe = zzb;
        Object zzH = zzH(i13);
        Object object = unsafe.getObject(t11, j11);
        if (zzglq.zzb(object)) {
            zzglp zzb2 = zzglp.zza().zzb();
            zzglq.zzc(zzb2, object);
            unsafe.putObject(t11, j11, zzb2);
        }
        zzglo zzglo = (zzglo) zzH;
        throw null;
    }

    private final int zzu(T t11, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, zzgiq zzgiq) throws IOException {
        T t12 = t11;
        byte[] bArr2 = bArr;
        int i19 = i11;
        int i21 = i13;
        int i22 = i14;
        int i23 = i15;
        long j12 = j11;
        int i24 = i18;
        zzgiq zzgiq2 = zzgiq;
        Unsafe unsafe = zzb;
        long j13 = (long) (this.zzc[i24 + 2] & 1048575);
        switch (i17) {
            case 51:
                if (i23 == 1) {
                    unsafe.putObject(t12, j12, Double.valueOf(Double.longBitsToDouble(zzgir.zzn(bArr, i11))));
                    unsafe.putInt(t12, j13, i22);
                    return i19 + 8;
                }
                break;
            case 52:
                if (i23 == 5) {
                    unsafe.putObject(t12, j12, Float.valueOf(Float.intBitsToFloat(zzgir.zzb(bArr, i11))));
                    unsafe.putInt(t12, j13, i22);
                    return i19 + 4;
                }
                break;
            case 53:
            case 54:
                if (i23 == 0) {
                    int zzm2 = zzgir.zzm(bArr2, i19, zzgiq2);
                    unsafe.putObject(t12, j12, Long.valueOf(zzgiq2.zzb));
                    unsafe.putInt(t12, j13, i22);
                    return zzm2;
                }
                break;
            case 55:
            case 62:
                if (i23 == 0) {
                    int zzj2 = zzgir.zzj(bArr2, i19, zzgiq2);
                    unsafe.putObject(t12, j12, Integer.valueOf(zzgiq2.zza));
                    unsafe.putInt(t12, j13, i22);
                    return zzj2;
                }
                break;
            case 56:
            case 65:
                if (i23 == 1) {
                    unsafe.putObject(t12, j12, Long.valueOf(zzgir.zzn(bArr, i11)));
                    unsafe.putInt(t12, j13, i22);
                    return i19 + 8;
                }
                break;
            case 57:
            case 64:
                if (i23 == 5) {
                    unsafe.putObject(t12, j12, Integer.valueOf(zzgir.zzb(bArr, i11)));
                    unsafe.putInt(t12, j13, i22);
                    return i19 + 4;
                }
                break;
            case 58:
                if (i23 == 0) {
                    int zzm3 = zzgir.zzm(bArr2, i19, zzgiq2);
                    unsafe.putObject(t12, j12, Boolean.valueOf(zzgiq2.zzb != 0));
                    unsafe.putInt(t12, j13, i22);
                    return zzm3;
                }
                break;
            case 59:
                if (i23 == 2) {
                    int zzj3 = zzgir.zzj(bArr2, i19, zzgiq2);
                    int i25 = zzgiq2.zza;
                    if (i25 == 0) {
                        unsafe.putObject(t12, j12, "");
                    } else if ((i16 & 536870912) == 0 || zzgnu.zzj(bArr2, zzj3, zzj3 + i25)) {
                        unsafe.putObject(t12, j12, new String(bArr2, zzj3, i25, zzgkv.zzb));
                        zzj3 += i25;
                    } else {
                        throw zzgkx.zzd();
                    }
                    unsafe.putInt(t12, j13, i22);
                    return zzj3;
                }
                break;
            case 60:
                if (i23 == 2) {
                    int zzd2 = zzgir.zzd(zzF(i24), bArr2, i19, i12, zzgiq2);
                    Object object = unsafe.getInt(t12, j13) == i22 ? unsafe.getObject(t12, j12) : null;
                    if (object == null) {
                        unsafe.putObject(t12, j12, zzgiq2.zzc);
                    } else {
                        unsafe.putObject(t12, j12, zzgkv.zzg(object, zzgiq2.zzc));
                    }
                    unsafe.putInt(t12, j13, i22);
                    return zzd2;
                }
                break;
            case 61:
                if (i23 == 2) {
                    int zza2 = zzgir.zza(bArr2, i19, zzgiq2);
                    unsafe.putObject(t12, j12, zzgiq2.zzc);
                    unsafe.putInt(t12, j13, i22);
                    return zza2;
                }
                break;
            case 63:
                if (i23 == 0) {
                    int zzj4 = zzgir.zzj(bArr2, i19, zzgiq2);
                    int i26 = zzgiq2.zza;
                    zzgkp zzE = zzE(i24);
                    if (zzE == null || zzE.zza(i26)) {
                        unsafe.putObject(t12, j12, Integer.valueOf(i26));
                        unsafe.putInt(t12, j13, i22);
                    } else {
                        zzd(t11).zzh(i21, Long.valueOf((long) i26));
                    }
                    return zzj4;
                }
                break;
            case 66:
                if (i23 == 0) {
                    int zzj5 = zzgir.zzj(bArr2, i19, zzgiq2);
                    unsafe.putObject(t12, j12, Integer.valueOf(zzgjn.zzF(zzgiq2.zza)));
                    unsafe.putInt(t12, j13, i22);
                    return zzj5;
                }
                break;
            case 67:
                if (i23 == 0) {
                    int zzm4 = zzgir.zzm(bArr2, i19, zzgiq2);
                    unsafe.putObject(t12, j12, Long.valueOf(zzgjn.zzG(zzgiq2.zzb)));
                    unsafe.putInt(t12, j13, i22);
                    return zzm4;
                }
                break;
            case 68:
                if (i23 == 3) {
                    int zzc2 = zzgir.zzc(zzF(i24), bArr, i11, i12, (i21 & -8) | 4, zzgiq);
                    Object object2 = unsafe.getInt(t12, j13) == i22 ? unsafe.getObject(t12, j12) : null;
                    if (object2 == null) {
                        unsafe.putObject(t12, j12, zzgiq2.zzc);
                    } else {
                        unsafe.putObject(t12, j12, zzgkv.zzg(object2, zzgiq2.zzc));
                    }
                    unsafe.putInt(t12, j13, i22);
                    return zzc2;
                }
                break;
        }
        return i19;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02e8, code lost:
        if (r0 != r15) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x030b, code lost:
        if (r0 != r15) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        r19 = r32;
        r11 = r34;
        r8 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        r32 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f2, code lost:
        r6 = r6 | r20;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c9, code lost:
        r2 = r8;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e4, code lost:
        r0 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0200, code lost:
        r6 = r32 | r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0202, code lost:
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0203, code lost:
        r1 = r19;
        r8 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0208, code lost:
        r6 = r32;
        r2 = r4;
        r18 = r8;
        r28 = r9;
        r27 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02a1, code lost:
        if (r0 != r15) goto L_0x02a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02b7, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzv(T r30, byte[] r31, int r32, int r33, com.google.android.gms.internal.ads.zzgiq r34) throws java.io.IOException {
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
            if (r0 >= r13) goto L_0x0335
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002b
            int r0 = com.google.android.gms.internal.ads.zzgir.zzk(r0, r12, r3, r11)
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
            int r0 = r15.zzy(r5, r2)
            goto L_0x003f
        L_0x003b:
            int r0 = r15.zzx(r5)
        L_0x003f:
            r2 = r0
            if (r2 != r8) goto L_0x004d
            r2 = r4
            r19 = r5
            r27 = r8
            r28 = r9
            r18 = r16
            goto L_0x030e
        L_0x004d:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            int r0 = zzB(r1)
            r8 = r1 & r10
            long r10 = (long) r8
            r8 = 17
            r32 = r5
            if (r0 > r8) goto L_0x0213
            int[] r8 = r15.zzc
            int r20 = r2 + 2
            r8 = r8[r20]
            int r20 = r8 >>> 20
            r5 = 1
            int r20 = r5 << r20
            r22 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r10
            if (r8 == r7) goto L_0x0084
            if (r7 == r10) goto L_0x007c
            long r10 = (long) r7
            r9.putInt(r14, r10, r6)
            r10 = 1048575(0xfffff, float:1.469367E-39)
        L_0x007c:
            if (r8 == r10) goto L_0x0083
            long r6 = (long) r8
            int r6 = r9.getInt(r14, r6)
        L_0x0083:
            r7 = r8
        L_0x0084:
            r8 = 5
            switch(r0) {
                case 0: goto L_0x01e7;
                case 1: goto L_0x01cd;
                case 2: goto L_0x01ab;
                case 3: goto L_0x01ab;
                case 4: goto L_0x0196;
                case 5: goto L_0x0178;
                case 6: goto L_0x0163;
                case 7: goto L_0x0140;
                case 8: goto L_0x011f;
                case 9: goto L_0x00f7;
                case 10: goto L_0x00df;
                case 11: goto L_0x0196;
                case 12: goto L_0x00cc;
                case 13: goto L_0x0163;
                case 14: goto L_0x0178;
                case 15: goto L_0x00b2;
                case 16: goto L_0x0091;
                default: goto L_0x0088;
            }
        L_0x0088:
            r19 = r32
            r11 = r34
            r8 = r2
        L_0x008d:
            r32 = r6
            goto L_0x0208
        L_0x0091:
            if (r3 != 0) goto L_0x0088
            r11 = r34
            r0 = r22
            int r8 = com.google.android.gms.internal.ads.zzgir.zzm(r12, r4, r11)
            long r3 = r11.zzb
            long r4 = com.google.android.gms.internal.ads.zzgjn.zzG(r3)
            r0 = r9
            r1 = r30
            r17 = r8
            r8 = r2
            r2 = r22
            r19 = r32
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            goto L_0x01c9
        L_0x00b2:
            r19 = r32
            r11 = r34
            r8 = r2
            if (r3 != 0) goto L_0x008d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzj(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.ads.zzgjn.zzF(r1)
            r2 = r22
            r9.putInt(r14, r2, r1)
            r6 = r6 | r20
            goto L_0x0202
        L_0x00cc:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            if (r3 != 0) goto L_0x008d
            int r2 = com.google.android.gms.internal.ads.zzgir.zzj(r12, r4, r11)
            int r3 = r11.zza
            r9.putInt(r14, r0, r3)
            goto L_0x00f2
        L_0x00df:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x008d
            int r2 = com.google.android.gms.internal.ads.zzgir.zza(r12, r4, r11)
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
        L_0x00f2:
            r6 = r6 | r20
            r0 = r2
            goto L_0x0202
        L_0x00f7:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r22
            r2 = 2
            if (r3 != r2) goto L_0x008d
            com.google.android.gms.internal.ads.zzgmo r2 = r15.zzF(r8)
            int r2 = com.google.android.gms.internal.ads.zzgir.zzd(r2, r12, r4, r13, r11)
            java.lang.Object r3 = r9.getObject(r14, r0)
            if (r3 != 0) goto L_0x0115
            java.lang.Object r3 = r11.zzc
            r9.putObject(r14, r0, r3)
            goto L_0x00f2
        L_0x0115:
            java.lang.Object r4 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgkv.zzg(r3, r4)
            r9.putObject(r14, r0, r3)
            goto L_0x00f2
        L_0x011f:
            r19 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            r0 = 2
            if (r3 != r0) goto L_0x0208
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0135
            int r0 = com.google.android.gms.internal.ads.zzgir.zzg(r12, r4, r11)
            goto L_0x0139
        L_0x0135:
            int r0 = com.google.android.gms.internal.ads.zzgir.zzh(r12, r4, r11)
        L_0x0139:
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r5, r1)
            goto L_0x0200
        L_0x0140:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0208
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r12, r4, r11)
            long r2 = r11.zzb
            r21 = 0
            int r2 = (r2 > r21 ? 1 : (r2 == r21 ? 0 : -1))
            if (r2 == 0) goto L_0x0159
            goto L_0x015b
        L_0x0159:
            r0 = r16
        L_0x015b:
            com.google.android.gms.internal.ads.zzgnp.zzp(r14, r5, r0)
            r6 = r32 | r20
            r0 = r1
            goto L_0x0202
        L_0x0163:
            r19 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0208
            int r0 = com.google.android.gms.internal.ads.zzgir.zzb(r12, r4)
            r9.putInt(r14, r5, r0)
            goto L_0x01e4
        L_0x0178:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0208
            long r21 = com.google.android.gms.internal.ads.zzgir.zzn(r12, r4)
            r0 = r9
            r1 = r30
            r2 = r5
            r6 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r6 + 8
            goto L_0x0200
        L_0x0196:
            r19 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0208
            int r0 = com.google.android.gms.internal.ads.zzgir.zzj(r12, r4, r11)
            int r1 = r11.zza
            r9.putInt(r14, r5, r1)
            goto L_0x0200
        L_0x01ab:
            r19 = r32
            r11 = r34
            r8 = r2
            r32 = r6
            r5 = r22
            if (r3 != 0) goto L_0x0208
            int r17 = com.google.android.gms.internal.ads.zzgir.zzm(r12, r4, r11)
            long r2 = r11.zzb
            r0 = r9
            r1 = r30
            r21 = r2
            r2 = r5
            r4 = r21
            r0.putLong(r1, r2, r4)
            r6 = r32 | r20
        L_0x01c9:
            r2 = r8
            r0 = r17
            goto L_0x0203
        L_0x01cd:
            r19 = r32
            r11 = r34
            r32 = r6
            r0 = r8
            r5 = r22
            r8 = r2
            if (r3 != r0) goto L_0x0208
            int r0 = com.google.android.gms.internal.ads.zzgir.zzb(r12, r4)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzgnp.zzs(r14, r5, r0)
        L_0x01e4:
            int r0 = r4 + 4
            goto L_0x0200
        L_0x01e7:
            r19 = r32
            r11 = r34
            r8 = r2
            r0 = r5
            r32 = r6
            r5 = r22
            if (r3 != r0) goto L_0x0208
            long r0 = com.google.android.gms.internal.ads.zzgir.zzn(r12, r4)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzgnp.zzr(r14, r5, r0)
            int r0 = r4 + 8
        L_0x0200:
            r6 = r32 | r20
        L_0x0202:
            r2 = r8
        L_0x0203:
            r1 = r19
            r8 = -1
            goto L_0x0019
        L_0x0208:
            r6 = r32
            r2 = r4
            r18 = r8
            r28 = r9
            r27 = -1
            goto L_0x030e
        L_0x0213:
            r19 = r32
            r8 = r2
            r20 = r6
            r5 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r11 = r34
            r2 = 27
            if (r0 != r2) goto L_0x026c
            r2 = 2
            if (r3 != r2) goto L_0x025f
            java.lang.Object r0 = r9.getObject(r14, r5)
            com.google.android.gms.internal.ads.zzgku r0 = (com.google.android.gms.internal.ads.zzgku) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x0242
            int r1 = r0.size()
            if (r1 != 0) goto L_0x023a
            r1 = 10
            goto L_0x023b
        L_0x023a:
            int r1 = r1 + r1
        L_0x023b:
            com.google.android.gms.internal.ads.zzgku r0 = r0.zzd(r1)
            r9.putObject(r14, r5, r0)
        L_0x0242:
            r5 = r0
            com.google.android.gms.internal.ads.zzgmo r0 = r15.zzF(r8)
            r1 = r17
            r2 = r31
            r3 = r4
            r4 = r33
            r15 = r20
            r6 = r34
            int r0 = com.google.android.gms.internal.ads.zzgir.zze(r0, r1, r2, r3, r4, r5, r6)
            r2 = r8
            r6 = r15
            r1 = r19
            r8 = -1
            r15 = r29
            goto L_0x0019
        L_0x025f:
            r15 = r4
            r26 = r7
            r18 = r8
            r28 = r9
            r23 = r20
            r27 = -1
            goto L_0x02eb
        L_0x026c:
            r15 = r20
            r2 = 49
            if (r0 > r2) goto L_0x02b9
            long r1 = (long) r1
            r32 = r0
            r0 = r29
            r20 = r1
            r1 = r30
            r2 = r31
            r22 = r3
            r3 = r4
            r23 = r15
            r15 = r4
            r4 = r33
            r24 = r5
            r5 = r17
            r6 = r19
            r26 = r7
            r7 = r22
            r18 = r8
            r27 = -1
            r28 = r9
            r9 = r20
            r11 = r32
            r12 = r24
            r14 = r34
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x02b7
        L_0x02a3:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r2 = r18
            r1 = r19
            r6 = r23
            r7 = r26
            goto L_0x032c
        L_0x02b7:
            r2 = r0
            goto L_0x02ec
        L_0x02b9:
            r32 = r0
            r22 = r3
            r24 = r5
            r26 = r7
            r18 = r8
            r28 = r9
            r23 = r15
            r27 = -1
            r15 = r4
            r0 = 50
            r9 = r32
            if (r9 != r0) goto L_0x02f1
            r7 = r22
            r0 = 2
            if (r7 != r0) goto L_0x02eb
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r24
            r8 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x02b7
            goto L_0x02a3
        L_0x02eb:
            r2 = r15
        L_0x02ec:
            r6 = r23
            r7 = r26
            goto L_0x030e
        L_0x02f1:
            r7 = r22
            r0 = r29
            r8 = r1
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r17
            r6 = r19
            r10 = r24
            r12 = r18
            r13 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x02b7
            goto L_0x02a3
        L_0x030e:
            com.google.android.gms.internal.ads.zzgng r4 = zzd(r30)
            r0 = r17
            r1 = r31
            r3 = r33
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgir.zzi(r0, r1, r2, r3, r4, r5)
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r2 = r18
            r1 = r19
        L_0x032c:
            r8 = r27
            r9 = r28
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0019
        L_0x0335:
            r23 = r6
            r28 = r9
            r1 = r10
            if (r7 == r1) goto L_0x0346
            long r1 = (long) r7
            r3 = r30
            r6 = r23
            r4 = r28
            r4.putInt(r3, r1, r6)
        L_0x0346:
            r1 = r33
            if (r0 != r1) goto L_0x034b
            return r0
        L_0x034b:
            com.google.android.gms.internal.ads.zzgkx r0 = com.google.android.gms.internal.ads.zzgkx.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzv(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzgiq):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0450 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01cf  */
    private final int zzw(T r16, byte[] r17, int r18, int r19, int r20, int r21, int r22, int r23, long r24, int r26, long r27, com.google.android.gms.internal.ads.zzgiq r29) throws java.io.IOException {
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
            com.google.android.gms.internal.ads.zzgku r12 = (com.google.android.gms.internal.ads.zzgku) r12
            boolean r13 = r12.zzc()
            if (r13 != 0) goto L_0x0032
            int r13 = r12.size()
            if (r13 != 0) goto L_0x002a
            r13 = 10
            goto L_0x002b
        L_0x002a:
            int r13 = r13 + r13
        L_0x002b:
            com.google.android.gms.internal.ads.zzgku r12 = r12.zzd(r13)
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
            com.google.android.gms.internal.ads.zzgmo r1 = r15.zzF(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r21 = r1
            r22 = r17
            r23 = r18
            r24 = r19
            r25 = r6
            r26 = r29
            int r4 = com.google.android.gms.internal.ads.zzgir.zzc(r21, r22, r23, r24, r25, r26)
            java.lang.Object r8 = r7.zzc
            r12.add(r8)
            goto L_0x042d
        L_0x005c:
            if (r6 != r14) goto L_0x0080
            com.google.android.gms.internal.ads.zzglk r12 = (com.google.android.gms.internal.ads.zzglk) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0067:
            if (r1 >= r2) goto L_0x0077
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.ads.zzgjn.zzG(r4)
            r12.zzg(r4)
            goto L_0x0067
        L_0x0077:
            if (r1 != r2) goto L_0x007b
            goto L_0x0450
        L_0x007b:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x0080:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzglk r12 = (com.google.android.gms.internal.ads.zzglk) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgjn.zzG(r8)
            r12.zzg(r8)
        L_0x0091:
            if (r1 >= r5) goto L_0x00aa
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x009c
            goto L_0x00aa
        L_0x009c:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.ads.zzgjn.zzG(r8)
            r12.zzg(r8)
            goto L_0x0091
        L_0x00aa:
            return r1
        L_0x00ab:
            if (r6 != r14) goto L_0x00cf
            com.google.android.gms.internal.ads.zzgkm r12 = (com.google.android.gms.internal.ads.zzgkm) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00b6:
            if (r1 >= r2) goto L_0x00c6
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgjn.zzF(r4)
            r12.zzh(r4)
            goto L_0x00b6
        L_0x00c6:
            if (r1 != r2) goto L_0x00ca
            goto L_0x0450
        L_0x00ca:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x00cf:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzgkm r12 = (com.google.android.gms.internal.ads.zzgkm) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgjn.zzF(r4)
            r12.zzh(r4)
        L_0x00e0:
            if (r1 >= r5) goto L_0x00f9
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x00eb
            goto L_0x00f9
        L_0x00eb:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.ads.zzgjn.zzF(r4)
            r12.zzh(r4)
            goto L_0x00e0
        L_0x00f9:
            return r1
        L_0x00fa:
            if (r6 != r14) goto L_0x0101
            int r2 = com.google.android.gms.internal.ads.zzgir.zzf(r3, r4, r12, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x044f
            r2 = r20
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r12
            r7 = r29
            int r2 = com.google.android.gms.internal.ads.zzgir.zzl(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.ads.zzgkl r1 = (com.google.android.gms.internal.ads.zzgkl) r1
            com.google.android.gms.internal.ads.zzgng r3 = r1.zzc
            com.google.android.gms.internal.ads.zzgng r4 = com.google.android.gms.internal.ads.zzgng.zzc()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.ads.zzgkp r4 = r15.zzE(r8)
            com.google.android.gms.internal.ads.zzgnf<?, ?> r5 = r0.zzo
            r6 = r21
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgmq.zzC(r6, r12, r4, r3, r5)
            if (r3 != 0) goto L_0x012d
            goto L_0x027b
        L_0x012d:
            com.google.android.gms.internal.ads.zzgng r3 = (com.google.android.gms.internal.ads.zzgng) r3
            r1.zzc = r3
            return r2
        L_0x0132:
            if (r6 != r14) goto L_0x044f
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0187
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0182
            if (r4 != 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzgjf r4 = com.google.android.gms.internal.ads.zzgjf.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x0148:
            com.google.android.gms.internal.ads.zzgjf r6 = com.google.android.gms.internal.ads.zzgjf.zzw(r3, r1, r4)
            r12.add(r6)
        L_0x014f:
            int r1 = r1 + r4
        L_0x0150:
            if (r1 >= r5) goto L_0x0181
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x015b
            goto L_0x0181
        L_0x015b:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x017c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0177
            if (r4 != 0) goto L_0x016f
            com.google.android.gms.internal.ads.zzgjf r4 = com.google.android.gms.internal.ads.zzgjf.zzb
            r12.add(r4)
            goto L_0x0150
        L_0x016f:
            com.google.android.gms.internal.ads.zzgjf r6 = com.google.android.gms.internal.ads.zzgjf.zzw(r3, r1, r4)
            r12.add(r6)
            goto L_0x014f
        L_0x0177:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x017c:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzf()
            throw r1
        L_0x0181:
            return r1
        L_0x0182:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x0187:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzf()
            throw r1
        L_0x018c:
            if (r6 == r14) goto L_0x0190
            goto L_0x044f
        L_0x0190:
            com.google.android.gms.internal.ads.zzgmo r1 = r15.zzF(r8)
            r21 = r1
            r22 = r20
            r23 = r17
            r24 = r18
            r25 = r19
            r26 = r12
            r27 = r29
            int r1 = com.google.android.gms.internal.ads.zzgir.zze(r21, r22, r23, r24, r25, r26, r27)
            return r1
        L_0x01a7:
            if (r6 != r14) goto L_0x044f
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r24 & r8
            int r1 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            java.lang.String r6 = ""
            if (r1 != 0) goto L_0x01fa
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f5
            if (r4 != 0) goto L_0x01c2
            r12.add(r6)
            goto L_0x01cd
        L_0x01c2:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgkv.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
        L_0x01cc:
            int r1 = r1 + r4
        L_0x01cd:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01f0
            if (r4 != 0) goto L_0x01e5
            r12.add(r6)
            goto L_0x01cd
        L_0x01e5:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzgkv.zzb
            r8.<init>(r3, r1, r4, r9)
            r12.add(r8)
            goto L_0x01cc
        L_0x01f0:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzf()
            throw r1
        L_0x01f5:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzf()
            throw r1
        L_0x01fa:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x0255
            if (r4 != 0) goto L_0x0208
            r12.add(r6)
            goto L_0x021b
        L_0x0208:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.ads.zzgnu.zzj(r3, r1, r8)
            if (r9 == 0) goto L_0x0250
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgkv.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
        L_0x021a:
            r1 = r8
        L_0x021b:
            if (r1 >= r5) goto L_0x0450
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0450
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x024b
            if (r4 != 0) goto L_0x0233
            r12.add(r6)
            goto L_0x021b
        L_0x0233:
            int r8 = r1 + r4
            boolean r9 = com.google.android.gms.internal.ads.zzgnu.zzj(r3, r1, r8)
            if (r9 == 0) goto L_0x0246
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzgkv.zzb
            r9.<init>(r3, r1, r4, r10)
            r12.add(r9)
            goto L_0x021a
        L_0x0246:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzd()
            throw r1
        L_0x024b:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzf()
            throw r1
        L_0x0250:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzd()
            throw r1
        L_0x0255:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzf()
            throw r1
        L_0x025a:
            r1 = 0
            if (r6 != r14) goto L_0x0283
            com.google.android.gms.internal.ads.zzgis r12 = (com.google.android.gms.internal.ads.zzgis) r12
            int r2 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0266:
            if (r2 >= r4) goto L_0x0279
            int r2 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r2, r7)
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
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x0283:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzgis r12 = (com.google.android.gms.internal.ads.zzgis) r12
            int r4 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r4, r7)
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
            int r6 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r8 = r7.zza
            if (r2 == r8) goto L_0x02a2
            goto L_0x02b3
        L_0x02a2:
            int r4 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r6, r7)
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
            com.google.android.gms.internal.ads.zzgkm r12 = (com.google.android.gms.internal.ads.zzgkm) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02bf:
            if (r1 >= r2) goto L_0x02cb
            int r4 = com.google.android.gms.internal.ads.zzgir.zzb(r3, r1)
            r12.zzh(r4)
            int r1 = r1 + 4
            goto L_0x02bf
        L_0x02cb:
            if (r1 != r2) goto L_0x02cf
            goto L_0x0450
        L_0x02cf:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x02d4:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.ads.zzgkm r12 = (com.google.android.gms.internal.ads.zzgkm) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzb(r17, r18)
            r12.zzh(r1)
        L_0x02df:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x02f4
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x02ec
            goto L_0x02f4
        L_0x02ec:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzb(r3, r4)
            r12.zzh(r1)
            goto L_0x02df
        L_0x02f4:
            return r1
        L_0x02f5:
            if (r6 != r14) goto L_0x0315
            com.google.android.gms.internal.ads.zzglk r12 = (com.google.android.gms.internal.ads.zzglk) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0300:
            if (r1 >= r2) goto L_0x030c
            long r4 = com.google.android.gms.internal.ads.zzgir.zzn(r3, r1)
            r12.zzg(r4)
            int r1 = r1 + 8
            goto L_0x0300
        L_0x030c:
            if (r1 != r2) goto L_0x0310
            goto L_0x0450
        L_0x0310:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x0315:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.ads.zzglk r12 = (com.google.android.gms.internal.ads.zzglk) r12
            long r8 = com.google.android.gms.internal.ads.zzgir.zzn(r17, r18)
            r12.zzg(r8)
        L_0x0320:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0335
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x032d
            goto L_0x0335
        L_0x032d:
            long r8 = com.google.android.gms.internal.ads.zzgir.zzn(r3, r4)
            r12.zzg(r8)
            goto L_0x0320
        L_0x0335:
            return r1
        L_0x0336:
            if (r6 != r14) goto L_0x033e
            int r1 = com.google.android.gms.internal.ads.zzgir.zzf(r3, r4, r12, r7)
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
            int r1 = com.google.android.gms.internal.ads.zzgir.zzl(r20, r21, r22, r23, r24, r25)
            return r1
        L_0x0351:
            if (r6 != r14) goto L_0x0371
            com.google.android.gms.internal.ads.zzglk r12 = (com.google.android.gms.internal.ads.zzglk) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x035c:
            if (r1 >= r2) goto L_0x0368
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r1, r7)
            long r4 = r7.zzb
            r12.zzg(r4)
            goto L_0x035c
        L_0x0368:
            if (r1 != r2) goto L_0x036c
            goto L_0x0450
        L_0x036c:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x0371:
            if (r6 != 0) goto L_0x044f
            com.google.android.gms.internal.ads.zzglk r12 = (com.google.android.gms.internal.ads.zzglk) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
        L_0x037e:
            if (r1 >= r5) goto L_0x0393
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0389
            goto L_0x0393
        L_0x0389:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzm(r3, r4, r7)
            long r8 = r7.zzb
            r12.zzg(r8)
            goto L_0x037e
        L_0x0393:
            return r1
        L_0x0394:
            if (r6 != r14) goto L_0x03b8
            com.google.android.gms.internal.ads.zzgke r12 = (com.google.android.gms.internal.ads.zzgke) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x039f:
            if (r1 >= r2) goto L_0x03af
            int r4 = com.google.android.gms.internal.ads.zzgir.zzb(r3, r1)
            float r4 = java.lang.Float.intBitsToFloat(r4)
            r12.zze(r4)
            int r1 = r1 + 4
            goto L_0x039f
        L_0x03af:
            if (r1 != r2) goto L_0x03b3
            goto L_0x0450
        L_0x03b3:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x03b8:
            if (r6 != r9) goto L_0x044f
            com.google.android.gms.internal.ads.zzgke r12 = (com.google.android.gms.internal.ads.zzgke) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzb(r17, r18)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
        L_0x03c7:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x03e0
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x03d4
            goto L_0x03e0
        L_0x03d4:
            int r1 = com.google.android.gms.internal.ads.zzgir.zzb(r3, r4)
            float r1 = java.lang.Float.intBitsToFloat(r1)
            r12.zze(r1)
            goto L_0x03c7
        L_0x03e0:
            return r1
        L_0x03e1:
            if (r6 != r14) goto L_0x0404
            com.google.android.gms.internal.ads.zzgju r12 = (com.google.android.gms.internal.ads.zzgju) r12
            int r1 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ec:
            if (r1 >= r2) goto L_0x03fc
            long r4 = com.google.android.gms.internal.ads.zzgir.zzn(r3, r1)
            double r4 = java.lang.Double.longBitsToDouble(r4)
            r12.zze(r4)
            int r1 = r1 + 8
            goto L_0x03ec
        L_0x03fc:
            if (r1 != r2) goto L_0x03ff
            goto L_0x0450
        L_0x03ff:
            com.google.android.gms.internal.ads.zzgkx r1 = com.google.android.gms.internal.ads.zzgkx.zzj()
            throw r1
        L_0x0404:
            if (r6 != r13) goto L_0x044f
            com.google.android.gms.internal.ads.zzgju r12 = (com.google.android.gms.internal.ads.zzgju) r12
            long r8 = com.google.android.gms.internal.ads.zzgir.zzn(r17, r18)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
        L_0x0413:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x042c
            int r4 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r1, r7)
            int r6 = r7.zza
            if (r2 == r6) goto L_0x0420
            goto L_0x042c
        L_0x0420:
            long r8 = com.google.android.gms.internal.ads.zzgir.zzn(r3, r4)
            double r8 = java.lang.Double.longBitsToDouble(r8)
            r12.zze(r8)
            goto L_0x0413
        L_0x042c:
            return r1
        L_0x042d:
            if (r4 >= r5) goto L_0x044e
            int r8 = com.google.android.gms.internal.ads.zzgir.zzj(r3, r4, r7)
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
            int r4 = com.google.android.gms.internal.ads.zzgir.zzc(r21, r22, r23, r24, r25, r26)
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzw(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzgiq):int");
    }

    private final int zzx(int i11) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzA(i11, 0);
    }

    private final int zzy(int i11, int i12) {
        if (i11 < this.zze || i11 > this.zzf) {
            return -1;
        }
        return zzA(i11, i12);
    }

    private final int zzz(int i11) {
        return this.zzc[i11 + 2];
    }

    public final int zza(T t11) {
        return this.zzj ? zzr(t11) : zzq(t11);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = r1
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzC(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzB(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
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
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzU(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzs(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzD(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzp(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzT(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzo(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgnp.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgnp.zzd(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgnp.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgnp.zzd(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgnp.zzd(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgnp.zzd(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzgnp.zzh(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.ads.zzgnp.zzz(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgnp.zzd(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgnp.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.ads.zzgnp.zzd(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgnp.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.ads.zzgnp.zzf(r9, r5)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.ads.zzgnp.zzc(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.ads.zzgnp.zzb(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.ads.zzgkv.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.ads.zzgnf<?, ?> r0 = r8.zzo
            java.lang.Object r0 = r0.zzd(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.ads.zzgjy<?> r0 = r8.zzp
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzb(java.lang.Object):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:108:0x033b, code lost:
        if (r0 != r15) goto L_0x033d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0357, code lost:
        r7 = r33;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0381, code lost:
        if (r0 != r15) goto L_0x033d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x03a3, code lost:
        if (r0 != r15) goto L_0x033d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x020d, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0247, code lost:
        r5 = r6 | r24;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0283, code lost:
        r5 = r6 | r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0285, code lost:
        r3 = r8;
        r1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029d, code lost:
        r7 = r33;
        r18 = r6;
        r19 = r8;
        r26 = r10;
        r8 = r11;
        r23 = r20;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzc(T r29, byte[] r30, int r31, int r32, int r33, com.google.android.gms.internal.ads.zzgiq r34) throws java.io.IOException {
        /*
            r28 = this;
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r31
            r1 = r16
            r3 = r1
            r5 = r3
            r2 = -1
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001a:
            if (r0 >= r13) goto L_0x0417
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.ads.zzgir.zzk(r0, r12, r1, r9)
            int r1 = r9.zza
            goto L_0x002e
        L_0x0029:
            r27 = r1
            r1 = r0
            r0 = r27
        L_0x002e:
            int r8 = r1 >>> 3
            r7 = r1 & 7
            r4 = 3
            if (r8 <= r2) goto L_0x003b
            int r3 = r3 / r4
            int r2 = r15.zzy(r8, r3)
            goto L_0x003f
        L_0x003b:
            int r2 = r15.zzx(r8)
        L_0x003f:
            r3 = -1
            if (r2 != r3) goto L_0x0051
            r2 = r0
            r17 = r3
            r18 = r5
            r23 = r8
            r26 = r10
            r7 = r11
            r19 = r16
            r8 = r1
            goto L_0x03a6
        L_0x0051:
            int[] r3 = r15.zzc
            int r19 = r2 + 1
            r3 = r3[r19]
            int r4 = zzB(r3)
            r20 = r1
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r3 & r17
            r21 = r0
            long r0 = (long) r1
            r22 = r0
            r0 = 17
            if (r4 > r0) goto L_0x02aa
            int[] r0 = r15.zzc
            int r24 = r2 + 2
            r0 = r0[r24]
            int r24 = r0 >>> 20
            r1 = 1
            int r24 = r1 << r24
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r11
            if (r0 == r6) goto L_0x008c
            r17 = r2
            if (r6 == r11) goto L_0x0084
            long r1 = (long) r6
            r10.putInt(r14, r1, r5)
        L_0x0084:
            long r1 = (long) r0
            int r5 = r10.getInt(r14, r1)
            r25 = r0
            goto L_0x0090
        L_0x008c:
            r17 = r2
            r25 = r6
        L_0x0090:
            r6 = r5
            r0 = 5
            switch(r4) {
                case 0: goto L_0x0267;
                case 1: goto L_0x024b;
                case 2: goto L_0x0228;
                case 3: goto L_0x0228;
                case 4: goto L_0x0210;
                case 5: goto L_0x01ec;
                case 6: goto L_0x01d3;
                case 7: goto L_0x01b0;
                case 8: goto L_0x018c;
                case 9: goto L_0x015b;
                case 10: goto L_0x0141;
                case 11: goto L_0x0210;
                case 12: goto L_0x010c;
                case 13: goto L_0x01d3;
                case 14: goto L_0x01ec;
                case 15: goto L_0x00ef;
                case 16: goto L_0x00c3;
                default: goto L_0x0095;
            }
        L_0x0095:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 3
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x029d
            com.google.android.gms.internal.ads.zzgmo r0 = r15.zzF(r8)
            int r1 = r20 << 3
            r7 = r1 | 4
            r1 = r30
            r3 = r32
            r12 = r4
            r4 = r7
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgir.zzc(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x0289
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x0296
        L_0x00c3:
            if (r7 != 0) goto L_0x00e3
            r1 = r21
            int r7 = com.google.android.gms.internal.ads.zzgir.zzm(r12, r1, r9)
            long r0 = r9.zzb
            long r4 = com.google.android.gms.internal.ads.zzgjn.zzG(r0)
            r2 = r22
            r0 = r10
            r11 = r20
            r1 = r29
            r20 = r8
            r8 = r17
            r17 = -1
            r0.putLong(r1, r2, r4)
            goto L_0x0247
        L_0x00e3:
            r11 = r20
            r20 = r8
            r8 = r17
            r17 = -1
            r2 = r21
            goto L_0x029d
        L_0x00ef:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzj(r12, r1, r9)
            int r1 = r9.zza
            int r1 = com.google.android.gms.internal.ads.zzgjn.zzF(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x0283
        L_0x010c:
            r11 = r20
            r1 = r21
            r2 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzj(r12, r1, r9)
            int r1 = r9.zza
            com.google.android.gms.internal.ads.zzgkp r4 = r15.zzE(r8)
            if (r4 == 0) goto L_0x013c
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x012d
            goto L_0x013c
        L_0x012d:
            com.google.android.gms.internal.ads.zzgng r2 = zzd(r29)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzh(r11, r1)
            r5 = r6
            goto L_0x0285
        L_0x013c:
            r10.putInt(r14, r2, r1)
            goto L_0x0283
        L_0x0141:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x020d
            int r0 = com.google.android.gms.internal.ads.zzgir.zza(r12, r1, r9)
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0283
        L_0x015b:
            r11 = r20
            r1 = r21
            r2 = r22
            r0 = 2
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x020d
            com.google.android.gms.internal.ads.zzgmo r0 = r15.zzF(r8)
            int r0 = com.google.android.gms.internal.ads.zzgir.zzd(r0, r12, r1, r13, r9)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x017d
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0283
        L_0x017d:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgkv.zzg(r1, r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0283
        L_0x018c:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 2
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x020d
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r3
            if (r0 != 0) goto L_0x01a5
            int r0 = com.google.android.gms.internal.ads.zzgir.zzg(r12, r1, r9)
            goto L_0x01a9
        L_0x01a5:
            int r0 = com.google.android.gms.internal.ads.zzgir.zzh(r12, r1, r9)
        L_0x01a9:
            java.lang.Object r1 = r9.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x0283
        L_0x01b0:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != 0) goto L_0x020d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzm(r12, r1, r9)
            long r1 = r9.zzb
            r21 = 0
            int r1 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r1 == 0) goto L_0x01cc
            r1 = 1
            goto L_0x01ce
        L_0x01cc:
            r1 = r16
        L_0x01ce:
            com.google.android.gms.internal.ads.zzgnp.zzp(r14, r4, r1)
            goto L_0x0283
        L_0x01d3:
            r11 = r20
            r1 = r21
            r4 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x020d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzb(r12, r1)
            r10.putInt(r14, r4, r0)
            int r0 = r1 + 4
            goto L_0x0283
        L_0x01ec:
            r11 = r20
            r1 = r21
            r4 = r22
            r0 = 1
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x020d
            long r21 = com.google.android.gms.internal.ads.zzgir.zzn(r12, r1)
            r7 = r1
            r0 = r10
            r1 = r29
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0283
        L_0x020d:
            r2 = r1
            goto L_0x029d
        L_0x0210:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != 0) goto L_0x029d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzj(r12, r2, r9)
            int r1 = r9.zza
            r10.putInt(r14, r4, r1)
            goto L_0x0283
        L_0x0228:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != 0) goto L_0x029d
            int r7 = com.google.android.gms.internal.ads.zzgir.zzm(r12, r2, r9)
            long r2 = r9.zzb
            r0 = r10
            r1 = r29
            r21 = r2
            r2 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
        L_0x0247:
            r5 = r6 | r24
            r0 = r7
            goto L_0x0285
        L_0x024b:
            r11 = r20
            r2 = r21
            r4 = r22
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x029d
            int r0 = com.google.android.gms.internal.ads.zzgir.zzb(r12, r2)
            float r0 = java.lang.Float.intBitsToFloat(r0)
            com.google.android.gms.internal.ads.zzgnp.zzs(r14, r4, r0)
            int r0 = r2 + 4
            goto L_0x0283
        L_0x0267:
            r11 = r20
            r2 = r21
            r4 = r22
            r0 = 1
            r20 = r8
            r8 = r17
            r17 = -1
            if (r7 != r0) goto L_0x029d
            long r0 = com.google.android.gms.internal.ads.zzgir.zzn(r12, r2)
            double r0 = java.lang.Double.longBitsToDouble(r0)
            com.google.android.gms.internal.ads.zzgnp.zzr(r14, r4, r0)
            int r0 = r2 + 8
        L_0x0283:
            r5 = r6 | r24
        L_0x0285:
            r3 = r8
            r1 = r11
            goto L_0x02f6
        L_0x0289:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r9.zzc
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgkv.zzg(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x0296:
            r5 = r6 | r24
            r12 = r30
            r13 = r32
            goto L_0x0285
        L_0x029d:
            r7 = r33
            r18 = r6
            r19 = r8
            r26 = r10
            r8 = r11
            r23 = r20
            goto L_0x0389
        L_0x02aa:
            r11 = r20
            r12 = r22
            r17 = -1
            r20 = r8
            r8 = r2
            r2 = r21
            r0 = 27
            if (r4 != r0) goto L_0x030d
            r0 = 2
            if (r7 != r0) goto L_0x02fe
            java.lang.Object r0 = r10.getObject(r14, r12)
            com.google.android.gms.internal.ads.zzgku r0 = (com.google.android.gms.internal.ads.zzgku) r0
            boolean r1 = r0.zzc()
            if (r1 != 0) goto L_0x02d9
            int r1 = r0.size()
            if (r1 != 0) goto L_0x02d1
            r1 = 10
            goto L_0x02d2
        L_0x02d1:
            int r1 = r1 + r1
        L_0x02d2:
            com.google.android.gms.internal.ads.zzgku r0 = r0.zzd(r1)
            r10.putObject(r14, r12, r0)
        L_0x02d9:
            r7 = r0
            com.google.android.gms.internal.ads.zzgmo r0 = r15.zzF(r8)
            r1 = r11
            r3 = r2
            r2 = r30
            r4 = r32
            r18 = r5
            r5 = r7
            r25 = r6
            r6 = r34
            int r0 = com.google.android.gms.internal.ads.zzgir.zze(r0, r1, r2, r3, r4, r5, r6)
            r12 = r30
            r13 = r32
            r3 = r8
            r5 = r18
        L_0x02f6:
            r2 = r20
            r6 = r25
            r11 = r33
            goto L_0x001a
        L_0x02fe:
            r18 = r5
            r25 = r6
            r15 = r2
            r19 = r8
            r26 = r10
            r23 = r20
            r20 = r11
            goto L_0x0384
        L_0x030d:
            r18 = r5
            r25 = r6
            r6 = r2
            r0 = 49
            if (r4 > r0) goto L_0x035b
            long r2 = (long) r3
            r0 = r28
            r1 = r29
            r21 = r2
            r2 = r30
            r3 = r6
            r5 = r4
            r4 = r32
            r31 = r5
            r5 = r11
            r15 = r6
            r6 = r20
            r19 = r8
            r23 = r20
            r26 = r10
            r9 = r21
            r20 = r11
            r11 = r31
            r14 = r34
            int r0 = r0.zzw(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 == r15) goto L_0x0357
        L_0x033d:
            r15 = r28
            r14 = r29
            r12 = r30
            r13 = r32
            r11 = r33
            r9 = r34
            r5 = r18
            r3 = r19
            r1 = r20
            r2 = r23
            r6 = r25
            r10 = r26
            goto L_0x001a
        L_0x0357:
            r7 = r33
            r2 = r0
            goto L_0x0387
        L_0x035b:
            r31 = r4
            r15 = r6
            r19 = r8
            r26 = r10
            r23 = r20
            r20 = r11
            r0 = 50
            r9 = r31
            if (r9 != r0) goto L_0x038c
            r0 = 2
            if (r7 != r0) goto L_0x0384
            r0 = r28
            r1 = r29
            r2 = r30
            r3 = r15
            r4 = r32
            r5 = r19
            r6 = r12
            r8 = r34
            int r0 = r0.zzt(r1, r2, r3, r4, r5, r6, r8)
            if (r0 == r15) goto L_0x0357
            goto L_0x033d
        L_0x0384:
            r7 = r33
            r2 = r15
        L_0x0387:
            r8 = r20
        L_0x0389:
            r6 = r25
            goto L_0x03a6
        L_0x038c:
            r0 = r28
            r1 = r29
            r2 = r30
            r8 = r3
            r3 = r15
            r4 = r32
            r5 = r20
            r6 = r23
            r10 = r12
            r12 = r19
            r13 = r34
            int r0 = r0.zzu(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 == r15) goto L_0x0357
            goto L_0x033d
        L_0x03a6:
            if (r8 != r7) goto L_0x03b8
            if (r7 == 0) goto L_0x03b8
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r28
            r12 = r29
            r0 = r2
            r1 = r8
            r5 = r18
            r2 = 0
            goto L_0x0424
        L_0x03b8:
            r9 = r28
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x03f0
            r10 = r34
            com.google.android.gms.internal.ads.zzgjx r0 = r10.zzd
            com.google.android.gms.internal.ads.zzgjx r1 = com.google.android.gms.internal.ads.zzgjx.zza()
            if (r0 == r1) goto L_0x03ed
            com.google.android.gms.internal.ads.zzglv r0 = r9.zzg
            com.google.android.gms.internal.ads.zzgjx r1 = r10.zzd
            r11 = r23
            com.google.android.gms.internal.ads.zzgkj r0 = r1.zzc(r0, r11)
            if (r0 != 0) goto L_0x03e6
            com.google.android.gms.internal.ads.zzgng r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgir.zzi(r0, r1, r2, r3, r4, r5)
            r12 = r29
            goto L_0x0405
        L_0x03e6:
            r12 = r29
            r0 = r12
            com.google.android.gms.internal.ads.zzgki r0 = (com.google.android.gms.internal.ads.zzgki) r0
            r2 = 0
            throw r2
        L_0x03ed:
            r12 = r29
            goto L_0x03f4
        L_0x03f0:
            r12 = r29
            r10 = r34
        L_0x03f4:
            r11 = r23
            com.google.android.gms.internal.ads.zzgng r4 = zzd(r29)
            r0 = r8
            r1 = r30
            r3 = r32
            r5 = r34
            int r0 = com.google.android.gms.internal.ads.zzgir.zzi(r0, r1, r2, r3, r4, r5)
        L_0x0405:
            r13 = r32
            r1 = r8
            r15 = r9
            r9 = r10
            r2 = r11
            r14 = r12
            r5 = r18
            r3 = r19
            r10 = r26
            r12 = r30
            r11 = r7
            goto L_0x001a
        L_0x0417:
            r18 = r5
            r25 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
            r2 = 0
            r3 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0424:
            if (r6 == r3) goto L_0x042c
            long r3 = (long) r6
            r6 = r26
            r6.putInt(r12, r3, r5)
        L_0x042c:
            int r3 = r9.zzl
        L_0x042e:
            int r4 = r9.zzm
            if (r3 >= r4) goto L_0x043e
            int[] r4 = r9.zzk
            r4 = r4[r3]
            com.google.android.gms.internal.ads.zzgnf<?, ?> r5 = r9.zzo
            r9.zzG(r12, r4, r2, r5)
            int r3 = r3 + 1
            goto L_0x042e
        L_0x043e:
            if (r7 != 0) goto L_0x044a
            r2 = r32
            if (r0 != r2) goto L_0x0445
            goto L_0x0450
        L_0x0445:
            com.google.android.gms.internal.ads.zzgkx r0 = com.google.android.gms.internal.ads.zzgkx.zzg()
            throw r0
        L_0x044a:
            r2 = r32
            if (r0 > r2) goto L_0x0451
            if (r1 != r7) goto L_0x0451
        L_0x0450:
            return r0
        L_0x0451:
            com.google.android.gms.internal.ads.zzgkx r0 = com.google.android.gms.internal.ads.zzgkx.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgiq):int");
    }

    public final T zze() {
        return ((zzgkl) this.zzg).zzb(4, (Object) null, (Object) null);
    }

    public final void zzf(T t11) {
        int i11;
        int i12 = this.zzl;
        while (true) {
            i11 = this.zzm;
            if (i12 >= i11) {
                break;
            }
            long zzC = (long) (zzC(this.zzk[i12]) & 1048575);
            Object zzh2 = zzgnp.zzh(t11, zzC);
            if (zzh2 != null) {
                ((zzglp) zzh2).zzc();
                zzgnp.zzv(t11, zzC, zzh2);
            }
            i12++;
        }
        int length = this.zzk.length;
        while (i11 < length) {
            this.zzn.zzb(t11, (long) this.zzk[i11]);
            i11++;
        }
        this.zzo.zzm(t11);
        if (this.zzh) {
            this.zzp.zze(t11);
        }
    }

    public final void zzg(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzC = zzC(i11);
            long j11 = (long) (1048575 & zzC);
            int i12 = this.zzc[i11];
            switch (zzB(zzC)) {
                case 0:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzr(t11, j11, zzgnp.zzb(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 1:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzs(t11, j11, zzgnp.zzc(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 2:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzu(t11, j11, zzgnp.zzf(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 3:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzu(t11, j11, zzgnp.zzf(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 4:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzt(t11, j11, zzgnp.zzd(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 5:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzu(t11, j11, zzgnp.zzf(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 6:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzt(t11, j11, zzgnp.zzd(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 7:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzp(t11, j11, zzgnp.zzz(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 8:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzv(t11, j11, zzgnp.zzh(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 9:
                    zzJ(t11, t12, i11);
                    break;
                case 10:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzv(t11, j11, zzgnp.zzh(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 11:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzt(t11, j11, zzgnp.zzd(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 12:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzt(t11, j11, zzgnp.zzd(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 13:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzt(t11, j11, zzgnp.zzd(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 14:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzu(t11, j11, zzgnp.zzf(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 15:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzt(t11, j11, zzgnp.zzd(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 16:
                    if (!zzQ(t12, i11)) {
                        break;
                    } else {
                        zzgnp.zzu(t11, j11, zzgnp.zzf(t12, j11));
                        zzM(t11, i11);
                        break;
                    }
                case 17:
                    zzJ(t11, t12, i11);
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
                    this.zzn.zzc(t11, t12, j11);
                    break;
                case 50:
                    zzgmq.zzI(this.zzr, t11, t12, j11);
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
                    if (!zzT(t12, i12, i11)) {
                        break;
                    } else {
                        zzgnp.zzv(t11, j11, zzgnp.zzh(t12, j11));
                        zzN(t11, i12, i11);
                        break;
                    }
                case 60:
                    zzK(t11, t12, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzT(t12, i12, i11)) {
                        break;
                    } else {
                        zzgnp.zzv(t11, j11, zzgnp.zzh(t12, j11));
                        zzN(t11, i12, i11);
                        break;
                    }
                case 68:
                    zzK(t11, t12, i11);
                    break;
            }
        }
        zzgmq.zzF(this.zzo, t11, t12);
        if (this.zzh) {
            zzgmq.zzE(this.zzp, t11, t12);
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zzh(T r13, com.google.android.gms.internal.ads.zzgmg r14, com.google.android.gms.internal.ads.zzgjx r15) throws java.io.IOException {
        /*
            r12 = this;
            r15.getClass()
            com.google.android.gms.internal.ads.zzgnf<?, ?> r7 = r12.zzo
            com.google.android.gms.internal.ads.zzgjy<?> r8 = r12.zzp
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x000a:
            int r1 = r14.zzc()     // Catch:{ all -> 0x0079 }
            int r2 = r12.zzx(r1)     // Catch:{ all -> 0x0079 }
            if (r2 >= 0) goto L_0x007c
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0030
            int r14 = r12.zzl
        L_0x001b:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x002a
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001b
        L_0x002a:
            if (r10 == 0) goto L_0x05c4
            r7.zzn(r13, r10)
            return
        L_0x0030:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x0079 }
            if (r2 != 0) goto L_0x0036
            r2 = r9
            goto L_0x003d
        L_0x0036:
            com.google.android.gms.internal.ads.zzglv r2 = r12.zzg     // Catch:{ all -> 0x0079 }
            java.lang.Object r1 = r8.zzc(r15, r2, r1)     // Catch:{ all -> 0x0079 }
            r2 = r1
        L_0x003d:
            if (r2 == 0) goto L_0x0052
            if (r0 != 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzgkc r0 = r8.zzb(r13)     // Catch:{ all -> 0x0079 }
        L_0x0045:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zzd(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0079 }
            r0 = r11
            goto L_0x000a
        L_0x0052:
            r7.zzq(r14)     // Catch:{ all -> 0x0079 }
            if (r10 != 0) goto L_0x005c
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x0079 }
            r10 = r1
        L_0x005c:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0079 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0064:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0073
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0064
        L_0x0073:
            if (r10 == 0) goto L_0x05c4
            r7.zzn(r13, r10)
            return
        L_0x0079:
            r14 = move-exception
            goto L_0x05c5
        L_0x007c:
            int r3 = r12.zzC(r2)     // Catch:{ all -> 0x0079 }
            int r4 = zzB(r3)     // Catch:{ zzgkw -> 0x059e }
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0571;
                case 1: goto L_0x0562;
                case 2: goto L_0x0553;
                case 3: goto L_0x0544;
                case 4: goto L_0x0535;
                case 5: goto L_0x0526;
                case 6: goto L_0x0517;
                case 7: goto L_0x0508;
                case 8: goto L_0x0500;
                case 9: goto L_0x04cf;
                case 10: goto L_0x04c0;
                case 11: goto L_0x04b1;
                case 12: goto L_0x048f;
                case 13: goto L_0x0480;
                case 14: goto L_0x0471;
                case 15: goto L_0x0462;
                case 16: goto L_0x0453;
                case 17: goto L_0x0422;
                case 18: goto L_0x0414;
                case 19: goto L_0x0406;
                case 20: goto L_0x03f8;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dc;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03c0;
                case 25: goto L_0x03b2;
                case 26: goto L_0x0388;
                case 27: goto L_0x0376;
                case 28: goto L_0x0368;
                case 29: goto L_0x035a;
                case 30: goto L_0x0345;
                case 31: goto L_0x0337;
                case 32: goto L_0x0329;
                case 33: goto L_0x031b;
                case 34: goto L_0x030d;
                case 35: goto L_0x02ff;
                case 36: goto L_0x02f1;
                case 37: goto L_0x02e3;
                case 38: goto L_0x02d5;
                case 39: goto L_0x02c7;
                case 40: goto L_0x02b9;
                case 41: goto L_0x02ab;
                case 42: goto L_0x029d;
                case 43: goto L_0x028f;
                case 44: goto L_0x027a;
                case 45: goto L_0x026c;
                case 46: goto L_0x025e;
                case 47: goto L_0x0250;
                case 48: goto L_0x0242;
                case 49: goto L_0x0230;
                case 50: goto L_0x01fa;
                case 51: goto L_0x01e8;
                case 52: goto L_0x01d6;
                case 53: goto L_0x01c4;
                case 54: goto L_0x01b2;
                case 55: goto L_0x01a0;
                case 56: goto L_0x018e;
                case 57: goto L_0x017c;
                case 58: goto L_0x016a;
                case 59: goto L_0x0162;
                case 60: goto L_0x0131;
                case 61: goto L_0x0123;
                case 62: goto L_0x0111;
                case 63: goto L_0x00ec;
                case 64: goto L_0x00da;
                case 65: goto L_0x00c8;
                case 66: goto L_0x00b6;
                case 67: goto L_0x00a4;
                case 68: goto L_0x0092;
                default: goto L_0x008a;
            }     // Catch:{ zzgkw -> 0x059e }
        L_0x008a:
            if (r10 != 0) goto L_0x0581
            java.lang.Object r1 = r7.zzf()     // Catch:{ zzgkw -> 0x059e }
            goto L_0x0580
        L_0x0092:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r5 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r5 = r14.zzr(r5, r15)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x00a4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzn()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x00b6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            int r5 = r14.zzi()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x00c8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzm()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x00da:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            int r5 = r14.zzh()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x00ec:
            int r4 = r14.zze()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgkp r6 = r12.zzE(r2)     // Catch:{ zzgkw -> 0x059e }
            if (r6 == 0) goto L_0x0103
            boolean r6 = r6.zza(r4)     // Catch:{ zzgkw -> 0x059e }
            if (r6 == 0) goto L_0x00fd
            goto L_0x0103
        L_0x00fd:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgmq.zzD(r1, r4, r10, r7)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0103:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r5, r3)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0111:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            int r5 = r14.zzj()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0123:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgjf r5 = r14.zzp()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0131:
            boolean r4 = r12.zzT(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            if (r4 == 0) goto L_0x014d
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzgnp.zzh(r13, r3)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r6 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r6 = r14.zzs(r6, r15)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzgkv.zzg(r5, r6)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x015d
        L_0x014d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r5 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r5 = r14.zzs(r5, r15)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
        L_0x015d:
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0162:
            r12.zzL(r13, r3, r14)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x016a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            boolean r5 = r14.zzN()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x017c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            int r5 = r14.zzf()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x018e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzk()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x01a0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            int r5 = r14.zzg()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x01b2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzo()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x01c4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzl()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x01d6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            float r5 = r14.zzb()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x01e8:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            double r5 = r14.zza()     // Catch:{ zzgkw -> 0x059e }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzN(r13, r1, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x01fa:
            java.lang.Object r1 = r12.zzH(r2)     // Catch:{ zzgkw -> 0x059e }
            int r2 = r12.zzC(r2)     // Catch:{ zzgkw -> 0x059e }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzgnp.zzh(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            if (r4 == 0) goto L_0x0220
            boolean r5 = com.google.android.gms.internal.ads.zzglq.zzb(r4)     // Catch:{ zzgkw -> 0x059e }
            if (r5 == 0) goto L_0x022b
            com.google.android.gms.internal.ads.zzglp r5 = com.google.android.gms.internal.ads.zzglp.zza()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzglp r5 = r5.zzb()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzglq.zzc(r5, r4)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r2, r5)     // Catch:{ zzgkw -> 0x059e }
            r4 = r5
            goto L_0x022b
        L_0x0220:
            com.google.android.gms.internal.ads.zzglp r4 = com.google.android.gms.internal.ads.zzglp.zza()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzglp r4 = r4.zzb()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r2, r4)     // Catch:{ zzgkw -> 0x059e }
        L_0x022b:
            com.google.android.gms.internal.ads.zzglp r4 = (com.google.android.gms.internal.ads.zzglp) r4     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzglo r1 = (com.google.android.gms.internal.ads.zzglo) r1     // Catch:{ zzgkw -> 0x059e }
            throw r9     // Catch:{ zzgkw -> 0x059e }
        L_0x0230:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r1 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzglj r2 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzgkw -> 0x059e }
            r14.zzC(r2, r1, r15)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0242:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzJ(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0250:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzI(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x025e:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzH(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x026c:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzG(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x027a:
            com.google.android.gms.internal.ads.zzglj r4 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzgkw -> 0x059e }
            r14.zzy(r3)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgkp r2 = r12.zzE(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgmq.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x028f:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzL(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x029d:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzv(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02ab:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzz(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02b9:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzA(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02c7:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzD(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02d5:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzM(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02e3:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzE(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02f1:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzB(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x02ff:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzx(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x030d:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzJ(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x031b:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzI(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0329:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzH(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0337:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzG(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0345:
            com.google.android.gms.internal.ads.zzglj r4 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzgkw -> 0x059e }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzgkw -> 0x059e }
            r14.zzy(r3)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgkp r2 = r12.zzE(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgmq.zzC(r1, r3, r2, r10, r7)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x035a:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzL(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0368:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzw(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0376:
            com.google.android.gms.internal.ads.zzgmo r1 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzglj r4 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzF(r2, r1, r15)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0388:
            boolean r1 = zzP(r3)     // Catch:{ zzgkw -> 0x059e }
            if (r1 == 0) goto L_0x03a0
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r2 = r14
            com.google.android.gms.internal.ads.zzgjo r2 = (com.google.android.gms.internal.ads.zzgjo) r2     // Catch:{ zzgkw -> 0x059e }
            r3 = 1
            r2.zzK(r1, r3)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03a0:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r2 = r14
            com.google.android.gms.internal.ads.zzgjo r2 = (com.google.android.gms.internal.ads.zzgjo) r2     // Catch:{ zzgkw -> 0x059e }
            r3 = 0
            r2.zzK(r1, r3)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03b2:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzv(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03c0:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzz(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03ce:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzA(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03dc:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzD(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03ea:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzM(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x03f8:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzE(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0406:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzB(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0414:
            com.google.android.gms.internal.ads.zzglj r1 = r12.zzn     // Catch:{ zzgkw -> 0x059e }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzgkw -> 0x059e }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            r14.zzx(r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0422:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            if (r1 == 0) goto L_0x0440
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgnp.zzh(r13, r3)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r2 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r2 = r14.zzr(r2, r15)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgkv.zzg(r1, r2)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0440:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r1 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r1 = r14.zzr(r1, r15)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0453:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzn()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzu(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0462:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            int r1 = r14.zzi()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzt(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0471:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzm()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzu(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0480:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            int r1 = r14.zzh()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzt(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x048f:
            int r4 = r14.zze()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgkp r6 = r12.zzE(r2)     // Catch:{ zzgkw -> 0x059e }
            if (r6 == 0) goto L_0x04a6
            boolean r6 = r6.zza(r4)     // Catch:{ zzgkw -> 0x059e }
            if (r6 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzgmq.zzD(r1, r4, r10, r7)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x04a6:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzt(r13, r5, r4)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x04b1:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            int r1 = r14.zzj()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzt(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x04c0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgjf r1 = r14.zzp()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x04cf:
            boolean r1 = r12.zzQ(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            if (r1 == 0) goto L_0x04ed
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgnp.zzh(r13, r3)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r2 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r2 = r14.zzs(r2, r15)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgkv.zzg(r1, r2)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x04ed:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgmo r1 = r12.zzF(r2)     // Catch:{ zzgkw -> 0x059e }
            java.lang.Object r1 = r14.zzs(r1, r15)     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzv(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0500:
            r12.zzL(r13, r3, r14)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0508:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            boolean r1 = r14.zzN()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzp(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0517:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            int r1 = r14.zzf()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzt(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0526:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzk()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzu(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0535:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            int r1 = r14.zzg()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzt(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0544:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzo()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzu(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0553:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            long r5 = r14.zzl()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzu(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0562:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            float r1 = r14.zzb()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzs(r13, r3, r1)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0571:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzgkw -> 0x059e }
            double r5 = r14.zza()     // Catch:{ zzgkw -> 0x059e }
            com.google.android.gms.internal.ads.zzgnp.zzr(r13, r3, r5)     // Catch:{ zzgkw -> 0x059e }
            r12.zzM(r13, r2)     // Catch:{ zzgkw -> 0x059e }
            goto L_0x000a
        L_0x0580:
            r10 = r1
        L_0x0581:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ zzgkw -> 0x059e }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x0589:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x0598
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0589
        L_0x0598:
            if (r10 == 0) goto L_0x05c4
            r7.zzn(r13, r10)
            return
        L_0x059e:
            r7.zzq(r14)     // Catch:{ all -> 0x0079 }
            if (r10 != 0) goto L_0x05a8
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x0079 }
            r10 = r1
        L_0x05a8:
            boolean r1 = r7.zzp(r10, r14)     // Catch:{ all -> 0x0079 }
            if (r1 != 0) goto L_0x000a
            int r14 = r12.zzl
        L_0x05b0:
            int r15 = r12.zzm
            if (r14 >= r15) goto L_0x05bf
            int[] r15 = r12.zzk
            r15 = r15[r14]
            java.lang.Object r10 = r12.zzG(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05b0
        L_0x05bf:
            if (r10 == 0) goto L_0x05c4
            r7.zzn(r13, r10)
        L_0x05c4:
            return
        L_0x05c5:
            int r15 = r12.zzl
        L_0x05c7:
            int r0 = r12.zzm
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzk
            r0 = r0[r15]
            java.lang.Object r10 = r12.zzG(r13, r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r7.zzn(r13, r10)
        L_0x05db:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgly.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzgmg, com.google.android.gms.internal.ads.zzgjx):void");
    }

    public final void zzi(T t11, byte[] bArr, int i11, int i12, zzgiq zzgiq) throws IOException {
        if (this.zzj) {
            zzv(t11, bArr, i11, i12, zzgiq);
        } else {
            zzc(t11, bArr, i11, i12, 0, zzgiq);
        }
    }

    public final boolean zzj(T t11, T t12) {
        boolean z11;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int zzC = zzC(i11);
            long j11 = (long) (zzC & 1048575);
            switch (zzB(zzC)) {
                case 0:
                    if (zzO(t11, t12, i11) && Double.doubleToLongBits(zzgnp.zzb(t11, j11)) == Double.doubleToLongBits(zzgnp.zzb(t12, j11))) {
                        continue;
                    }
                case 1:
                    if (zzO(t11, t12, i11) && Float.floatToIntBits(zzgnp.zzc(t11, j11)) == Float.floatToIntBits(zzgnp.zzc(t12, j11))) {
                        continue;
                    }
                case 2:
                    if (zzO(t11, t12, i11) && zzgnp.zzf(t11, j11) == zzgnp.zzf(t12, j11)) {
                        continue;
                    }
                case 3:
                    if (zzO(t11, t12, i11) && zzgnp.zzf(t11, j11) == zzgnp.zzf(t12, j11)) {
                        continue;
                    }
                case 4:
                    if (zzO(t11, t12, i11) && zzgnp.zzd(t11, j11) == zzgnp.zzd(t12, j11)) {
                        continue;
                    }
                case 5:
                    if (zzO(t11, t12, i11) && zzgnp.zzf(t11, j11) == zzgnp.zzf(t12, j11)) {
                        continue;
                    }
                case 6:
                    if (zzO(t11, t12, i11) && zzgnp.zzd(t11, j11) == zzgnp.zzd(t12, j11)) {
                        continue;
                    }
                case 7:
                    if (zzO(t11, t12, i11) && zzgnp.zzz(t11, j11) == zzgnp.zzz(t12, j11)) {
                        continue;
                    }
                case 8:
                    if (zzO(t11, t12, i11) && zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11))) {
                        continue;
                    }
                case 9:
                    if (zzO(t11, t12, i11) && zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11))) {
                        continue;
                    }
                case 10:
                    if (zzO(t11, t12, i11) && zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11))) {
                        continue;
                    }
                case 11:
                    if (zzO(t11, t12, i11) && zzgnp.zzd(t11, j11) == zzgnp.zzd(t12, j11)) {
                        continue;
                    }
                case 12:
                    if (zzO(t11, t12, i11) && zzgnp.zzd(t11, j11) == zzgnp.zzd(t12, j11)) {
                        continue;
                    }
                case 13:
                    if (zzO(t11, t12, i11) && zzgnp.zzd(t11, j11) == zzgnp.zzd(t12, j11)) {
                        continue;
                    }
                case 14:
                    if (zzO(t11, t12, i11) && zzgnp.zzf(t11, j11) == zzgnp.zzf(t12, j11)) {
                        continue;
                    }
                case 15:
                    if (zzO(t11, t12, i11) && zzgnp.zzd(t11, j11) == zzgnp.zzd(t12, j11)) {
                        continue;
                    }
                case 16:
                    if (zzO(t11, t12, i11) && zzgnp.zzf(t11, j11) == zzgnp.zzf(t12, j11)) {
                        continue;
                    }
                case 17:
                    if (zzO(t11, t12, i11) && zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11))) {
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
                    z11 = zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11));
                    break;
                case 50:
                    z11 = zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11));
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
                    long zzz = (long) (zzz(i11) & 1048575);
                    if (zzgnp.zzd(t11, zzz) == zzgnp.zzd(t12, zzz) && zzgmq.zzH(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11))) {
                        continue;
                    }
            }
            if (!z11) {
                return false;
            }
        }
        if (!this.zzo.zzd(t11).equals(this.zzo.zzd(t12))) {
            return false;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(t11);
        this.zzp.zza(t12);
        throw null;
    }

    public final boolean zzk(T t11) {
        int i11;
        int i12;
        T t12 = t11;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.zzl) {
            int i16 = this.zzk[i15];
            int i17 = this.zzc[i16];
            int zzC = zzC(i16);
            int i18 = this.zzc[i16 + 2];
            int i19 = i18 & 1048575;
            int i21 = 1 << (i18 >>> 20);
            if (i19 != i13) {
                if (i19 != 1048575) {
                    i14 = zzb.getInt(t12, (long) i19);
                }
                i11 = i14;
                i12 = i19;
            } else {
                i12 = i13;
                i11 = i14;
            }
            if ((268435456 & zzC) != 0 && !zzR(t11, i16, i12, i11, i21)) {
                return false;
            }
            int zzB = zzB(zzC);
            if (zzB != 9 && zzB != 17) {
                if (zzB != 27) {
                    if (zzB == 60 || zzB == 68) {
                        if (zzT(t12, i17, i16) && !zzS(t12, zzC, zzF(i16))) {
                            return false;
                        }
                    } else if (zzB != 49) {
                        if (zzB == 50 && !((zzglp) zzgnp.zzh(t12, (long) (zzC & 1048575))).isEmpty()) {
                            zzglo zzglo = (zzglo) zzH(i16);
                            throw null;
                        }
                    }
                }
                List list = (List) zzgnp.zzh(t12, (long) (zzC & 1048575));
                if (!list.isEmpty()) {
                    zzgmo zzF = zzF(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zzF.zzk(list.get(i22))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzR(t11, i16, i12, i11, i21) && !zzS(t12, zzC, zzF(i16))) {
                return false;
            }
            i15++;
            i13 = i12;
            i14 = i11;
        }
        if (!this.zzh) {
            return true;
        }
        this.zzp.zza(t12);
        throw null;
    }

    public final void zzn(T t11, zzgjt zzgjt) throws IOException {
        if (!this.zzj) {
            zzV(t11, zzgjt);
        } else if (!this.zzh) {
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int zzC = zzC(i11);
                int i12 = this.zzc[i11];
                switch (zzB(zzC)) {
                    case 0:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzf(i12, zzgnp.zzb(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzo(i12, zzgnp.zzc(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzt(i12, zzgnp.zzf(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzJ(i12, zzgnp.zzf(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzr(i12, zzgnp.zzd(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzm(i12, zzgnp.zzf(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzk(i12, zzgnp.zzd(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzb(i12, zzgnp.zzz(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzX(i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt);
                            break;
                        }
                    case 9:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzv(i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), zzF(i11));
                            break;
                        }
                    case 10:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzd(i12, (zzgjf) zzgnp.zzh(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzH(i12, zzgnp.zzd(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzi(i12, zzgnp.zzd(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzw(i12, zzgnp.zzd(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzy(i12, zzgnp.zzf(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzA(i12, zzgnp.zzd(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzC(i12, zzgnp.zzf(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzQ(t11, i11)) {
                            break;
                        } else {
                            zzgjt.zzq(i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), zzF(i11));
                            break;
                        }
                    case 18:
                        zzgmq.zzL(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 19:
                        zzgmq.zzP(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 20:
                        zzgmq.zzS(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 21:
                        zzgmq.zzaa(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 22:
                        zzgmq.zzR(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 23:
                        zzgmq.zzO(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 24:
                        zzgmq.zzN(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 25:
                        zzgmq.zzJ(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 26:
                        zzgmq.zzY(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt);
                        break;
                    case 27:
                        zzgmq.zzT(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, zzF(i11));
                        break;
                    case 28:
                        zzgmq.zzK(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt);
                        break;
                    case 29:
                        zzgmq.zzZ(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 30:
                        zzgmq.zzM(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 31:
                        zzgmq.zzU(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 32:
                        zzgmq.zzV(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 33:
                        zzgmq.zzW(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 34:
                        zzgmq.zzX(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, false);
                        break;
                    case 35:
                        zzgmq.zzL(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 36:
                        zzgmq.zzP(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 37:
                        zzgmq.zzS(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 38:
                        zzgmq.zzaa(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 39:
                        zzgmq.zzR(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 40:
                        zzgmq.zzO(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 41:
                        zzgmq.zzN(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 42:
                        zzgmq.zzJ(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 43:
                        zzgmq.zzZ(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 44:
                        zzgmq.zzM(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 45:
                        zzgmq.zzU(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 46:
                        zzgmq.zzV(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 47:
                        zzgmq.zzW(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 48:
                        zzgmq.zzX(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, true);
                        break;
                    case 49:
                        zzgmq.zzQ(this.zzc[i11], (List) zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt, zzF(i11));
                        break;
                    case 50:
                        zzW(zzgjt, i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), i11);
                        break;
                    case 51:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzf(i12, zzo(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzo(i12, zzp(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzt(i12, zzD(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzJ(i12, zzD(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzr(i12, zzs(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzm(i12, zzD(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzk(i12, zzs(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzb(i12, zzU(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzX(i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), zzgjt);
                            break;
                        }
                    case 60:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzv(i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), zzF(i11));
                            break;
                        }
                    case 61:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzd(i12, (zzgjf) zzgnp.zzh(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzH(i12, zzs(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzi(i12, zzs(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzw(i12, zzs(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzy(i12, zzD(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzA(i12, zzs(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzC(i12, zzD(t11, (long) (zzC & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzT(t11, i12, i11)) {
                            break;
                        } else {
                            zzgjt.zzq(i12, zzgnp.zzh(t11, (long) (zzC & 1048575)), zzF(i11));
                            break;
                        }
                }
            }
            zzgnf<?, ?> zzgnf = this.zzo;
            zzgnf.zzr(zzgnf.zzd(t11), zzgjt);
        } else {
            this.zzp.zza(t11);
            throw null;
        }
    }
}
