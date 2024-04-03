package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzadc<T> implements zzadk<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzael.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzacz zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzacn zzk;
    private final zzaeb<?, ?> zzl;
    private final zzabi<?> zzm;
    private final zzade zzn;
    private final zzacu zzo;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.libraries.places.internal.zzacz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.google.android.libraries.places.internal.zzade} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.libraries.places.internal.zzacu} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.libraries.places.internal.zzabi<?>, com.google.android.libraries.places.internal.zzabi] */
    /* JADX WARNING: type inference failed for: r3v6, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.libraries.places.internal.zzacn] */
    /* JADX WARNING: type inference failed for: r3v10, types: [com.google.android.libraries.places.internal.zzaeb<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzadc(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.libraries.places.internal.zzacz r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.libraries.places.internal.zzade r17, com.google.android.libraries.places.internal.zzacn r18, com.google.android.libraries.places.internal.zzaeb<?, ?> r19, com.google.android.libraries.places.internal.zzabi<?> r20, com.google.android.libraries.places.internal.zzacu r21) {
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
            r3 = r11
            r0.zzg = r3
            r3 = 0
            if (r2 == 0) goto L_0x001a
            boolean r4 = r2.zzc(r10)
            if (r4 == 0) goto L_0x001a
            r3 = 1
        L_0x001a:
            r0.zzf = r3
            r3 = r13
            r0.zzh = r3
            r3 = r14
            r0.zzi = r3
            r3 = r15
            r0.zzj = r3
            r3 = r16
            r0.zzn = r3
            r3 = r17
            r0.zzk = r3
            r3 = r18
            r0.zzl = r3
            r0.zzm = r2
            r0.zze = r1
            r1 = r20
            r0.zzo = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzadc.<init>(int[], java.lang.Object[], int, int, com.google.android.libraries.places.internal.zzacz, boolean, boolean, int[], int, int, com.google.android.libraries.places.internal.zzade, com.google.android.libraries.places.internal.zzacn, com.google.android.libraries.places.internal.zzaeb, com.google.android.libraries.places.internal.zzabi, com.google.android.libraries.places.internal.zzacu, byte[]):void");
    }

    private final boolean zzA(T t11, int i11) {
        int zzo2 = zzo(i11);
        long j11 = (long) (zzo2 & 1048575);
        if (j11 == 1048575) {
            int zzq = zzq(i11);
            long j12 = (long) (zzq & 1048575);
            switch (zzp(zzq)) {
                case 0:
                    if (zzael.zza(t11, j12) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (zzael.zzb(t11, j12) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzael.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzael.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzael.zzc(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzael.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzael.zzc(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzael.zzw(t11, j12);
                case 8:
                    Object zzf2 = zzael.zzf(t11, j12);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzaax)) {
                        throw new IllegalArgumentException();
                    } else if (!zzaax.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzael.zzf(t11, j12) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzaax.zzb.equals(zzael.zzf(t11, j12))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzael.zzc(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzael.zzc(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzael.zzc(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzael.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzael.zzc(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzael.zzd(t11, j12) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzael.zzf(t11, j12) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzael.zzc(t11, j11) & (1 << (zzo2 >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean zzB(T t11, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? zzA(t11, i11) : (i13 & i14) != 0;
    }

    private static boolean zzC(Object obj, int i11, zzadk zzadk) {
        return zzadk.zzf(zzael.zzf(obj, (long) (i11 & 1048575)));
    }

    private final boolean zzD(T t11, int i11, int i12) {
        if (zzael.zzc(t11, (long) (zzo(i12) & 1048575)) == i11) {
            return true;
        }
        return false;
    }

    private static <T> boolean zzE(T t11, long j11) {
        return ((Boolean) zzael.zzf(t11, j11)).booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:156:0x044e, code lost:
        r7 = r7 + 3;
        r5 = 1048575;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x029d, code lost:
        r12 = r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzF(T r17, com.google.android.libraries.places.internal.zzabg r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r0.zzf
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
            int r10 = r0.zzq(r7)
            int[] r11 = r0.zzc
            r11 = r11[r7]
            int r12 = zzp(r10)
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
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.libraries.places.internal.zzadk r6 = r0.zzs(r7)
            r2.zzp(r11, r5, r6)
            goto L_0x0043
        L_0x0058:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzr(r1, r5)
            r2.zzB(r11, r5)
            goto L_0x0043
        L_0x0066:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzn(r1, r5)
            r2.zzz(r11, r5)
            goto L_0x0043
        L_0x0074:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzr(r1, r5)
            r2.zzx(r11, r5)
            goto L_0x0043
        L_0x0082:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzn(r1, r5)
            r2.zzv(r11, r5)
            goto L_0x0043
        L_0x0090:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzn(r1, r5)
            r2.zzh(r11, r5)
            goto L_0x0043
        L_0x009e:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzn(r1, r5)
            r2.zzF(r11, r5)
            goto L_0x0043
        L_0x00ac:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.libraries.places.internal.zzaax r5 = (com.google.android.libraries.places.internal.zzaax) r5
            r2.zzd(r11, r5)
            goto L_0x0043
        L_0x00bc:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.libraries.places.internal.zzadk r6 = r0.zzs(r7)
            r2.zzu(r11, r5, r6)
            goto L_0x0043
        L_0x00cf:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzH(r11, r5, r2)
            goto L_0x0043
        L_0x00de:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            boolean r5 = zzE(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x0043
        L_0x00ed:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzn(r1, r5)
            r2.zzj(r11, r5)
            goto L_0x0043
        L_0x00fc:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzr(r1, r5)
            r2.zzl(r11, r5)
            goto L_0x0043
        L_0x010b:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            int r5 = zzn(r1, r5)
            r2.zzq(r11, r5)
            goto L_0x0043
        L_0x011a:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzr(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x0043
        L_0x0129:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            long r5 = zzr(r1, r5)
            r2.zzs(r11, r5)
            goto L_0x0043
        L_0x0138:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            float r5 = zzk(r1, r5)
            r2.zzn(r11, r5)
            goto L_0x0043
        L_0x0147:
            boolean r10 = r0.zzD(r1, r11, r7)
            if (r10 == 0) goto L_0x0043
            double r5 = zzj(r1, r5)
            r2.zzf(r11, r5)
            goto L_0x0043
        L_0x0156:
            java.lang.Object r5 = r4.getObject(r1, r5)
            r0.zzG(r2, r11, r5, r7)
            goto L_0x0043
        L_0x015f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadk r6 = r0.zzs(r7)
            com.google.android.libraries.places.internal.zzadm.zzO(r10, r5, r2, r6)
            goto L_0x0043
        L_0x0172:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzV(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0181:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzU(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0190:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzT(r10, r5, r2, r14)
            goto L_0x0043
        L_0x019f:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzS(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ae:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzK(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01bd:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzX(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01cc:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzH(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01db:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzL(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01ea:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzM(r10, r5, r2, r14)
            goto L_0x0043
        L_0x01f9:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzP(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0208:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzY(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0217:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzQ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0226:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzN(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0235:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzJ(r10, r5, r2, r14)
            goto L_0x0043
        L_0x0244:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r11 = 0
            com.google.android.libraries.places.internal.zzadm.zzV(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0253:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzU(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0262:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzT(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0271:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzS(r10, r5, r2, r11)
            goto L_0x029d
        L_0x0280:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzK(r10, r5, r2, r11)
            goto L_0x029d
        L_0x028f:
            r11 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzX(r10, r5, r2, r11)
        L_0x029d:
            r12 = r11
            goto L_0x044e
        L_0x02a0:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzI(r10, r5, r2)
            goto L_0x0043
        L_0x02af:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadk r6 = r0.zzs(r7)
            com.google.android.libraries.places.internal.zzadm.zzR(r10, r5, r2, r6)
            goto L_0x0043
        L_0x02c2:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzW(r10, r5, r2)
            goto L_0x0043
        L_0x02d1:
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            r12 = 0
            com.google.android.libraries.places.internal.zzadm.zzH(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02e1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzL(r10, r5, r2, r12)
            goto L_0x044e
        L_0x02f1:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzM(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0301:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzP(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0311:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzY(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0321:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzQ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0331:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzN(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0341:
            r12 = 0
            int[] r10 = r0.zzc
            r10 = r10[r7]
            java.lang.Object r5 = r4.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            com.google.android.libraries.places.internal.zzadm.zzJ(r10, r5, r2, r12)
            goto L_0x044e
        L_0x0351:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.libraries.places.internal.zzadk r6 = r0.zzs(r7)
            r2.zzp(r11, r5, r6)
            goto L_0x044e
        L_0x0363:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzB(r11, r5)
            goto L_0x044e
        L_0x0371:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzz(r11, r5)
            goto L_0x044e
        L_0x037f:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzx(r11, r5)
            goto L_0x044e
        L_0x038d:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzv(r11, r5)
            goto L_0x044e
        L_0x039b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzh(r11, r5)
            goto L_0x044e
        L_0x03a9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzF(r11, r5)
            goto L_0x044e
        L_0x03b7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.libraries.places.internal.zzaax r5 = (com.google.android.libraries.places.internal.zzaax) r5
            r2.zzd(r11, r5)
            goto L_0x044e
        L_0x03c7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            com.google.android.libraries.places.internal.zzadk r6 = r0.zzs(r7)
            r2.zzu(r11, r5, r6)
            goto L_0x044e
        L_0x03d9:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            java.lang.Object r5 = r4.getObject(r1, r5)
            zzH(r11, r5, r2)
            goto L_0x044e
        L_0x03e7:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            boolean r5 = com.google.android.libraries.places.internal.zzael.zzw(r1, r5)
            r2.zzb(r11, r5)
            goto L_0x044e
        L_0x03f4:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzj(r11, r5)
            goto L_0x044e
        L_0x0401:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzl(r11, r5)
            goto L_0x044e
        L_0x040e:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            int r5 = r4.getInt(r1, r5)
            r2.zzq(r11, r5)
            goto L_0x044e
        L_0x041b:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzH(r11, r5)
            goto L_0x044e
        L_0x0428:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            long r5 = r4.getLong(r1, r5)
            r2.zzs(r11, r5)
            goto L_0x044e
        L_0x0435:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            float r5 = com.google.android.libraries.places.internal.zzael.zzb(r1, r5)
            r2.zzn(r11, r5)
            goto L_0x044e
        L_0x0442:
            r12 = 0
            r10 = r8 & r13
            if (r10 == 0) goto L_0x044e
            double r5 = com.google.android.libraries.places.internal.zzael.zza(r1, r5)
            r2.zzf(r11, r5)
        L_0x044e:
            int r7 = r7 + 3
            r5 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0015
        L_0x0455:
            com.google.android.libraries.places.internal.zzaeb<?, ?> r3 = r0.zzl
            java.lang.Object r1 = r3.zzc(r1)
            r3.zzg(r1, r2)
            return
        L_0x045f:
            com.google.android.libraries.places.internal.zzabi<?> r2 = r0.zzm
            r2.zza(r1)
            r1 = 0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzadc.zzF(java.lang.Object, com.google.android.libraries.places.internal.zzabg):void");
    }

    private final <K, V> void zzG(zzabg zzabg, int i11, Object obj, int i12) throws IOException {
        if (obj != null) {
            zzacs zzacs = (zzacs) zzt(i12);
            throw null;
        }
    }

    private static final void zzH(int i11, Object obj, zzabg zzabg) throws IOException {
        if (obj instanceof String) {
            zzabg.zzD(i11, (String) obj);
        } else {
            zzabg.zzd(i11, (zzaax) obj);
        }
    }

    public static <T> zzadc<T> zzg(Class<T> cls, zzacw zzacw, zzade zzade, zzacn zzacn, zzaeb<?, ?> zzaeb, zzabi<?> zzabi, zzacu zzacu) {
        if (zzacw instanceof zzadj) {
            return zzh((zzadj) zzacw, zzade, zzacn, zzaeb, zzabi, zzacu);
        }
        zzady zzady = (zzady) zzacw;
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
    public static <T> com.google.android.libraries.places.internal.zzadc<T> zzh(com.google.android.libraries.places.internal.zzadj r34, com.google.android.libraries.places.internal.zzade r35, com.google.android.libraries.places.internal.zzacn r36, com.google.android.libraries.places.internal.zzaeb<?, ?> r37, com.google.android.libraries.places.internal.zzabi<?> r38, com.google.android.libraries.places.internal.zzacu r39) {
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
            com.google.android.libraries.places.internal.zzacz r18 = r34.zza()
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
            java.lang.reflect.Field r12 = zzu(r2, r12)
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
            java.lang.reflect.Field r8 = zzu(r2, r8)
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
            java.lang.reflect.Field r8 = zzu(r2, r8)
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
            java.lang.reflect.Field r11 = zzu(r2, r11)
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
            com.google.android.libraries.places.internal.zzadc r0 = new com.google.android.libraries.places.internal.zzadc
            r4 = r0
            com.google.android.libraries.places.internal.zzacz r9 = r34.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzadc.zzh(com.google.android.libraries.places.internal.zzadj, com.google.android.libraries.places.internal.zzade, com.google.android.libraries.places.internal.zzacn, com.google.android.libraries.places.internal.zzaeb, com.google.android.libraries.places.internal.zzabi, com.google.android.libraries.places.internal.zzacu):com.google.android.libraries.places.internal.zzadc");
    }

    private static <T> double zzj(T t11, long j11) {
        return ((Double) zzael.zzf(t11, j11)).doubleValue();
    }

    private static <T> float zzk(T t11, long j11) {
        return ((Float) zzael.zzf(t11, j11)).floatValue();
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
    private final int zzl(T r15) {
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
            int r7 = r14.zzq(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzp(r7)
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
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.libraries.places.internal.zzacz r7 = (com.google.android.libraries.places.internal.zzacz) r7
            com.google.android.libraries.places.internal.zzadk r9 = r14.zzs(r3)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzu(r8, r7, r9)
            goto L_0x03ca
        L_0x0055:
            boolean r9 = r14.zzD(r15, r8, r3)
            if (r9 == 0) goto L_0x0525
            long r9 = zzr(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.libraries.places.internal.zzabf.zzB(r9)
            goto L_0x04de
        L_0x006f:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x04de
        L_0x008a:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0521
        L_0x0098:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0513
        L_0x00a6:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzv(r7)
            goto L_0x04de
        L_0x00bc:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x04de
        L_0x00d2:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.libraries.places.internal.zzaax r7 = (com.google.android.libraries.places.internal.zzaax) r7
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0469
        L_0x00ee:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.libraries.places.internal.zzadk r9 = r14.zzs(r3)
            int r7 = com.google.android.libraries.places.internal.zzadm.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x0102:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.libraries.places.internal.zzaax
            if (r9 == 0) goto L_0x0122
            com.google.android.libraries.places.internal.zzaax r7 = (com.google.android.libraries.places.internal.zzaax) r7
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0469
        L_0x0122:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzy(r7)
            goto L_0x04de
        L_0x0130:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x04b3
        L_0x013e:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0513
        L_0x014c:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0521
        L_0x015a:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzv(r7)
            goto L_0x04de
        L_0x0170:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzr(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            int r8 = com.google.android.libraries.places.internal.zzabf.zzB(r9)
            goto L_0x0506
        L_0x0186:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            long r9 = zzr(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            int r8 = com.google.android.libraries.places.internal.zzabf.zzB(r9)
            goto L_0x0506
        L_0x019c:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0513
        L_0x01aa:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0521
        L_0x01b8:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzt(r3)
            com.google.android.libraries.places.internal.zzacu.zza(r8, r7, r9)
            goto L_0x0525
        L_0x01c5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.libraries.places.internal.zzadk r9 = r14.zzs(r3)
            int r7 = com.google.android.libraries.places.internal.zzadm.zzj(r8, r7, r9)
            goto L_0x03ca
        L_0x01d5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzt(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x01eb:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzr(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x0201:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x0217:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x022d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zze(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x0243:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzw(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x0259:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzb(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x026f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x0285:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x029a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzl(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x02af:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzy(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x02c4:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzn(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x02d9:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzg(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0302
        L_0x02ee:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzi(r7)
            if (r7 <= 0) goto L_0x0525
            int r8 = com.google.android.libraries.places.internal.zzabf.zzz(r8)
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
        L_0x0302:
            int r8 = r8 + r9
            goto L_0x04de
        L_0x0305:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzs(r8, r7, r1)
            goto L_0x03ca
        L_0x0311:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzq(r8, r7, r1)
            goto L_0x03ca
        L_0x031d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzh(r8, r7, r1)
            goto L_0x03ca
        L_0x0329:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzf(r8, r7, r1)
            goto L_0x03ca
        L_0x0335:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzd(r8, r7, r1)
            goto L_0x03ca
        L_0x0341:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzv(r8, r7, r1)
            goto L_0x03ca
        L_0x034d:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzc(r8, r7)
            goto L_0x03ca
        L_0x0359:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.libraries.places.internal.zzadk r9 = r14.zzs(r3)
            int r7 = com.google.android.libraries.places.internal.zzadm.zzp(r8, r7, r9)
            goto L_0x03ca
        L_0x0368:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzu(r8, r7)
            goto L_0x03ca
        L_0x0373:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zza(r8, r7, r1)
            goto L_0x03ca
        L_0x037e:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzf(r8, r7, r1)
            goto L_0x03ca
        L_0x0389:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzh(r8, r7, r1)
            goto L_0x03ca
        L_0x0394:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzk(r8, r7, r1)
            goto L_0x03ca
        L_0x039f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzx(r8, r7, r1)
            goto L_0x03ca
        L_0x03aa:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzm(r8, r7, r1)
            goto L_0x03ca
        L_0x03b5:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzf(r8, r7, r1)
            goto L_0x03ca
        L_0x03c0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.libraries.places.internal.zzadm.zzh(r8, r7, r1)
        L_0x03ca:
            int r4 = r4 + r7
            goto L_0x0525
        L_0x03cd:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.libraries.places.internal.zzacz r7 = (com.google.android.libraries.places.internal.zzacz) r7
            com.google.android.libraries.places.internal.zzadk r9 = r14.zzs(r3)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzu(r8, r7, r9)
            goto L_0x03ca
        L_0x03e0:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.libraries.places.internal.zzabf.zzB(r9)
            goto L_0x04de
        L_0x03f8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x04de
        L_0x0411:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0521
        L_0x041d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0513
        L_0x0429:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzv(r7)
            goto L_0x04de
        L_0x043d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x04de
        L_0x0451:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.libraries.places.internal.zzaax r7 = (com.google.android.libraries.places.internal.zzaax) r7
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
        L_0x0469:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04df
        L_0x046d:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.libraries.places.internal.zzadk r9 = r14.zzs(r3)
            int r7 = com.google.android.libraries.places.internal.zzadm.zzo(r8, r7, r9)
            goto L_0x03ca
        L_0x047f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.libraries.places.internal.zzaax
            if (r9 == 0) goto L_0x049c
            com.google.android.libraries.places.internal.zzaax r7 = (com.google.android.libraries.places.internal.zzaax) r7
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0469
        L_0x049c:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzy(r7)
            goto L_0x04de
        L_0x04a9:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
        L_0x04b3:
            int r7 = r7 + r11
            goto L_0x03ca
        L_0x04b6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0513
        L_0x04c1:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            goto L_0x0521
        L_0x04cc:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.libraries.places.internal.zzabf.zzA(r8)
            int r7 = com.google.android.libraries.places.internal.zzabf.zzv(r7)
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
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            int r8 = com.google.android.libraries.places.internal.zzabf.zzB(r9)
            goto L_0x0506
        L_0x04f4:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
            int r8 = com.google.android.libraries.places.internal.zzabf.zzB(r9)
        L_0x0506:
            int r7 = r7 + r8
            goto L_0x03ca
        L_0x0509:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
        L_0x0513:
            int r7 = r7 + 4
            goto L_0x03ca
        L_0x0517:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0525
            int r7 = r8 << 3
            int r7 = com.google.android.libraries.places.internal.zzabf.zzA(r7)
        L_0x0521:
            int r7 = r7 + 8
            goto L_0x03ca
        L_0x0525:
            int r3 = r3 + 3
            goto L_0x000a
        L_0x0529:
            com.google.android.libraries.places.internal.zzaeb<?, ?> r0 = r14.zzl
            java.lang.Object r1 = r0.zzc(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzf
            if (r0 != 0) goto L_0x0539
            return r4
        L_0x0539:
            com.google.android.libraries.places.internal.zzabi<?> r0 = r14.zzm
            r0.zza(r15)
            r15 = 0
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzadc.zzl(java.lang.Object):int");
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
    private final int zzm(T r12) {
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
            int r4 = r11.zzq(r2)
            int r5 = zzp(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.libraries.places.internal.zzabn r4 = com.google.android.libraries.places.internal.zzabn.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.libraries.places.internal.zzabn r4 = com.google.android.libraries.places.internal.zzabn.SINT64_LIST_PACKED
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
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            com.google.android.libraries.places.internal.zzacz r4 = (com.google.android.libraries.places.internal.zzacz) r4
            com.google.android.libraries.places.internal.zzadk r5 = r11.zzs(r2)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzD(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.libraries.places.internal.zzabf.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            com.google.android.libraries.places.internal.zzaax r4 = (com.google.android.libraries.places.internal.zzaax) r4
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            com.google.android.libraries.places.internal.zzadk r5 = r11.zzs(r2)
            int r4 = com.google.android.libraries.places.internal.zzadm.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.libraries.places.internal.zzaax
            if (r5 == 0) goto L_0x011c
            com.google.android.libraries.places.internal.zzaax r4 = (com.google.android.libraries.places.internal.zzaax) r4
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzr(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r6)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzr(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r6)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.lang.Object r5 = r11.zzt(r2)
            com.google.android.libraries.places.internal.zzacu.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.libraries.places.internal.zzadk r5 = r11.zzs(r2)
            int r4 = com.google.android.libraries.places.internal.zzadm.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.libraries.places.internal.zzabf.zzz(r6)
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.libraries.places.internal.zzadk r5 = r11.zzs(r2)
            int r4 = com.google.android.libraries.places.internal.zzadm.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.libraries.places.internal.zzadm.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            com.google.android.libraries.places.internal.zzacz r4 = (com.google.android.libraries.places.internal.zzacz) r4
            com.google.android.libraries.places.internal.zzadk r5 = r11.zzs(r2)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzA(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.libraries.places.internal.zzael.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.libraries.places.internal.zzabf.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.libraries.places.internal.zzael.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.libraries.places.internal.zzael.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.libraries.places.internal.zzael.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            com.google.android.libraries.places.internal.zzaax r4 = (com.google.android.libraries.places.internal.zzaax) r4
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            com.google.android.libraries.places.internal.zzadk r5 = r11.zzs(r2)
            int r4 = com.google.android.libraries.places.internal.zzadm.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.libraries.places.internal.zzael.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.libraries.places.internal.zzaax
            if (r5 == 0) goto L_0x04ab
            com.google.android.libraries.places.internal.zzaax r4 = (com.google.android.libraries.places.internal.zzaax) r4
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.libraries.places.internal.zzael.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.libraries.places.internal.zzabf.zzA(r5)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.libraries.places.internal.zzael.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r6)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.libraries.places.internal.zzael.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.libraries.places.internal.zzabf.zzA(r6)
            int r4 = com.google.android.libraries.places.internal.zzabf.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.libraries.places.internal.zzabf.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.libraries.places.internal.zzaeb<?, ?> r0 = r11.zzl
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzadc.zzm(java.lang.Object):int");
    }

    private static <T> int zzn(T t11, long j11) {
        return ((Integer) zzael.zzf(t11, j11)).intValue();
    }

    private final int zzo(int i11) {
        return this.zzc[i11 + 2];
    }

    private static int zzp(int i11) {
        return (i11 >>> 20) & 255;
    }

    private final int zzq(int i11) {
        return this.zzc[i11 + 1];
    }

    private static <T> long zzr(T t11, long j11) {
        return ((Long) zzael.zzf(t11, j11)).longValue();
    }

    private final zzadk zzs(int i11) {
        int i12 = i11 / 3;
        int i13 = i12 + i12;
        zzadk zzadk = (zzadk) this.zzd[i13];
        if (zzadk != null) {
            return zzadk;
        }
        zzadk zzb2 = zzadh.zza().zzb((Class) this.zzd[i13 + 1]);
        this.zzd[i13] = zzb2;
        return zzb2;
    }

    private final Object zzt(int i11) {
        int i12 = i11 / 3;
        return this.zzd[i12 + i12];
    }

    private static Field zzu(Class<?> cls, String str) {
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

    private final void zzv(T t11, T t12, int i11) {
        long zzq = (long) (zzq(i11) & 1048575);
        if (zzA(t12, i11)) {
            Object zzf2 = zzael.zzf(t11, zzq);
            Object zzf3 = zzael.zzf(t12, zzq);
            if (zzf2 != null && zzf3 != null) {
                zzael.zzs(t11, zzq, zzaca.zzg(zzf2, zzf3));
                zzx(t11, i11);
            } else if (zzf3 != null) {
                zzael.zzs(t11, zzq, zzf3);
                zzx(t11, i11);
            }
        }
    }

    private final void zzw(T t11, T t12, int i11) {
        Object obj;
        int zzq = zzq(i11);
        int i12 = this.zzc[i11];
        long j11 = (long) (zzq & 1048575);
        if (zzD(t12, i12, i11)) {
            if (zzD(t11, i12, i11)) {
                obj = zzael.zzf(t11, j11);
            } else {
                obj = null;
            }
            Object zzf2 = zzael.zzf(t12, j11);
            if (obj != null && zzf2 != null) {
                zzael.zzs(t11, j11, zzaca.zzg(obj, zzf2));
                zzy(t11, i12, i11);
            } else if (zzf2 != null) {
                zzael.zzs(t11, j11, zzf2);
                zzy(t11, i12, i11);
            }
        }
    }

    private final void zzx(T t11, int i11) {
        int zzo2 = zzo(i11);
        long j11 = (long) (1048575 & zzo2);
        if (j11 != 1048575) {
            zzael.zzq(t11, j11, (1 << (zzo2 >>> 20)) | zzael.zzc(t11, j11));
        }
    }

    private final void zzy(T t11, int i11, int i12) {
        zzael.zzq(t11, (long) (zzo(i12) & 1048575), i11);
    }

    private final boolean zzz(T t11, T t12, int i11) {
        return zzA(t11, i11) == zzA(t12, i11);
    }

    public final int zza(T t11) {
        return this.zzg ? zzm(t11) : zzl(t11);
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
            int r3 = r8.zzq(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzp(r3)
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
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzE(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzk(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzj(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.zzael.zzd(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.zzael.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.zzael.zzd(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.zzael.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.zzael.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.zzael.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.libraries.places.internal.zzael.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.libraries.places.internal.zzael.zzw(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.zzael.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.zzael.zzd(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.libraries.places.internal.zzael.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.zzael.zzd(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.libraries.places.internal.zzael.zzd(r9, r5)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.libraries.places.internal.zzael.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.libraries.places.internal.zzael.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.libraries.places.internal.zzaca.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.libraries.places.internal.zzaeb<?, ?> r0 = r8.zzl
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzf
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.libraries.places.internal.zzabi<?> r0 = r8.zzm
            r0.zza(r9)
            r9 = 0
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzadc.zzb(java.lang.Object):int");
    }

    public final void zzc(T t11) {
        int i11;
        int i12 = this.zzi;
        while (true) {
            i11 = this.zzj;
            if (i12 >= i11) {
                break;
            }
            long zzq = (long) (zzq(this.zzh[i12]) & 1048575);
            Object zzf2 = zzael.zzf(t11, zzq);
            if (zzf2 != null) {
                ((zzact) zzf2).zzb();
                zzael.zzs(t11, zzq, zzf2);
            }
            i12++;
        }
        int length = this.zzh.length;
        while (i11 < length) {
            this.zzk.zza(t11, (long) this.zzh[i11]);
            i11++;
        }
        this.zzl.zze(t11);
        if (this.zzf) {
            this.zzm.zzb(t11);
        }
    }

    public final void zzd(T t11, T t12) {
        t12.getClass();
        for (int i11 = 0; i11 < this.zzc.length; i11 += 3) {
            int zzq = zzq(i11);
            long j11 = (long) (1048575 & zzq);
            int i12 = this.zzc[i11];
            switch (zzp(zzq)) {
                case 0:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzo(t11, j11, zzael.zza(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 1:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzp(t11, j11, zzael.zzb(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 2:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzr(t11, j11, zzael.zzd(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 3:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzr(t11, j11, zzael.zzd(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 4:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzq(t11, j11, zzael.zzc(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 5:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzr(t11, j11, zzael.zzd(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 6:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzq(t11, j11, zzael.zzc(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 7:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzm(t11, j11, zzael.zzw(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 8:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzs(t11, j11, zzael.zzf(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 9:
                    zzv(t11, t12, i11);
                    break;
                case 10:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzs(t11, j11, zzael.zzf(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 11:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzq(t11, j11, zzael.zzc(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 12:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzq(t11, j11, zzael.zzc(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 13:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzq(t11, j11, zzael.zzc(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 14:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzr(t11, j11, zzael.zzd(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 15:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzq(t11, j11, zzael.zzc(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 16:
                    if (!zzA(t12, i11)) {
                        break;
                    } else {
                        zzael.zzr(t11, j11, zzael.zzd(t12, j11));
                        zzx(t11, i11);
                        break;
                    }
                case 17:
                    zzv(t11, t12, i11);
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
                    this.zzk.zzb(t11, t12, j11);
                    break;
                case 50:
                    zzadm.zzG(this.zzo, t11, t12, j11);
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
                    if (!zzD(t12, i12, i11)) {
                        break;
                    } else {
                        zzael.zzs(t11, j11, zzael.zzf(t12, j11));
                        zzy(t11, i12, i11);
                        break;
                    }
                case 60:
                    zzw(t11, t12, i11);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzD(t12, i12, i11)) {
                        break;
                    } else {
                        zzael.zzs(t11, j11, zzael.zzf(t12, j11));
                        zzy(t11, i12, i11);
                        break;
                    }
                case 68:
                    zzw(t11, t12, i11);
                    break;
            }
        }
        zzadm.zzD(this.zzl, t11, t12);
        if (this.zzf) {
            zzadm.zzC(this.zzm, t11, t12);
        }
    }

    public final boolean zze(T t11, T t12) {
        boolean z11;
        int length = this.zzc.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            int zzq = zzq(i11);
            long j11 = (long) (zzq & 1048575);
            switch (zzp(zzq)) {
                case 0:
                    if (zzz(t11, t12, i11) && Double.doubleToLongBits(zzael.zza(t11, j11)) == Double.doubleToLongBits(zzael.zza(t12, j11))) {
                        continue;
                    }
                case 1:
                    if (zzz(t11, t12, i11) && Float.floatToIntBits(zzael.zzb(t11, j11)) == Float.floatToIntBits(zzael.zzb(t12, j11))) {
                        continue;
                    }
                case 2:
                    if (zzz(t11, t12, i11) && zzael.zzd(t11, j11) == zzael.zzd(t12, j11)) {
                        continue;
                    }
                case 3:
                    if (zzz(t11, t12, i11) && zzael.zzd(t11, j11) == zzael.zzd(t12, j11)) {
                        continue;
                    }
                case 4:
                    if (zzz(t11, t12, i11) && zzael.zzc(t11, j11) == zzael.zzc(t12, j11)) {
                        continue;
                    }
                case 5:
                    if (zzz(t11, t12, i11) && zzael.zzd(t11, j11) == zzael.zzd(t12, j11)) {
                        continue;
                    }
                case 6:
                    if (zzz(t11, t12, i11) && zzael.zzc(t11, j11) == zzael.zzc(t12, j11)) {
                        continue;
                    }
                case 7:
                    if (zzz(t11, t12, i11) && zzael.zzw(t11, j11) == zzael.zzw(t12, j11)) {
                        continue;
                    }
                case 8:
                    if (zzz(t11, t12, i11) && zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11))) {
                        continue;
                    }
                case 9:
                    if (zzz(t11, t12, i11) && zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11))) {
                        continue;
                    }
                case 10:
                    if (zzz(t11, t12, i11) && zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11))) {
                        continue;
                    }
                case 11:
                    if (zzz(t11, t12, i11) && zzael.zzc(t11, j11) == zzael.zzc(t12, j11)) {
                        continue;
                    }
                case 12:
                    if (zzz(t11, t12, i11) && zzael.zzc(t11, j11) == zzael.zzc(t12, j11)) {
                        continue;
                    }
                case 13:
                    if (zzz(t11, t12, i11) && zzael.zzc(t11, j11) == zzael.zzc(t12, j11)) {
                        continue;
                    }
                case 14:
                    if (zzz(t11, t12, i11) && zzael.zzd(t11, j11) == zzael.zzd(t12, j11)) {
                        continue;
                    }
                case 15:
                    if (zzz(t11, t12, i11) && zzael.zzc(t11, j11) == zzael.zzc(t12, j11)) {
                        continue;
                    }
                case 16:
                    if (zzz(t11, t12, i11) && zzael.zzd(t11, j11) == zzael.zzd(t12, j11)) {
                        continue;
                    }
                case 17:
                    if (zzz(t11, t12, i11) && zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11))) {
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
                    z11 = zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11));
                    break;
                case 50:
                    z11 = zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11));
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
                    long zzo2 = (long) (zzo(i11) & 1048575);
                    if (zzael.zzc(t11, zzo2) == zzael.zzc(t12, zzo2) && zzadm.zzF(zzael.zzf(t11, j11), zzael.zzf(t12, j11))) {
                        continue;
                    }
            }
            if (!z11) {
                return false;
            }
        }
        if (!this.zzl.zzc(t11).equals(this.zzl.zzc(t12))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zza(t11);
        this.zzm.zza(t12);
        throw null;
    }

    public final boolean zzf(T t11) {
        int i11;
        int i12;
        T t12 = t11;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.zzi) {
            int i16 = this.zzh[i15];
            int i17 = this.zzc[i16];
            int zzq = zzq(i16);
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
            if ((268435456 & zzq) != 0 && !zzB(t11, i16, i12, i11, i21)) {
                return false;
            }
            int zzp = zzp(zzq);
            if (zzp != 9 && zzp != 17) {
                if (zzp != 27) {
                    if (zzp == 60 || zzp == 68) {
                        if (zzD(t12, i17, i16) && !zzC(t12, zzq, zzs(i16))) {
                            return false;
                        }
                    } else if (zzp != 49) {
                        if (zzp == 50 && !((zzact) zzael.zzf(t12, (long) (zzq & 1048575))).isEmpty()) {
                            zzacs zzacs = (zzacs) zzt(i16);
                            throw null;
                        }
                    }
                }
                List list = (List) zzael.zzf(t12, (long) (zzq & 1048575));
                if (!list.isEmpty()) {
                    zzadk zzs = zzs(i16);
                    for (int i22 = 0; i22 < list.size(); i22++) {
                        if (!zzs.zzf(list.get(i22))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzB(t11, i16, i12, i11, i21) && !zzC(t12, zzq, zzs(i16))) {
                return false;
            }
            i15++;
            i13 = i12;
            i14 = i11;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zza(t12);
        throw null;
    }

    public final void zzi(T t11, zzabg zzabg) throws IOException {
        if (!this.zzg) {
            zzF(t11, zzabg);
        } else if (!this.zzf) {
            int length = this.zzc.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int zzq = zzq(i11);
                int i12 = this.zzc[i11];
                switch (zzp(zzq)) {
                    case 0:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzf(i12, zzael.zza(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzn(i12, zzael.zzb(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzs(i12, zzael.zzd(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzH(i12, zzael.zzd(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzq(i12, zzael.zzc(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzl(i12, zzael.zzd(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzj(i12, zzael.zzc(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzb(i12, zzael.zzw(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzH(i12, zzael.zzf(t11, (long) (zzq & 1048575)), zzabg);
                            break;
                        }
                    case 9:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzu(i12, zzael.zzf(t11, (long) (zzq & 1048575)), zzs(i11));
                            break;
                        }
                    case 10:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzd(i12, (zzaax) zzael.zzf(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzF(i12, zzael.zzc(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzh(i12, zzael.zzc(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzv(i12, zzael.zzc(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzx(i12, zzael.zzd(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzz(i12, zzael.zzc(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzB(i12, zzael.zzd(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzA(t11, i11)) {
                            break;
                        } else {
                            zzabg.zzp(i12, zzael.zzf(t11, (long) (zzq & 1048575)), zzs(i11));
                            break;
                        }
                    case 18:
                        zzadm.zzJ(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 19:
                        zzadm.zzN(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 20:
                        zzadm.zzQ(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 21:
                        zzadm.zzY(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 22:
                        zzadm.zzP(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 23:
                        zzadm.zzM(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 24:
                        zzadm.zzL(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 25:
                        zzadm.zzH(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 26:
                        zzadm.zzW(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg);
                        break;
                    case 27:
                        zzadm.zzR(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, zzs(i11));
                        break;
                    case 28:
                        zzadm.zzI(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg);
                        break;
                    case 29:
                        zzadm.zzX(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 30:
                        zzadm.zzK(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 31:
                        zzadm.zzS(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 32:
                        zzadm.zzT(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 33:
                        zzadm.zzU(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 34:
                        zzadm.zzV(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, false);
                        break;
                    case 35:
                        zzadm.zzJ(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 36:
                        zzadm.zzN(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 37:
                        zzadm.zzQ(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 38:
                        zzadm.zzY(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 39:
                        zzadm.zzP(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 40:
                        zzadm.zzM(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 41:
                        zzadm.zzL(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 42:
                        zzadm.zzH(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 43:
                        zzadm.zzX(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 44:
                        zzadm.zzK(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 45:
                        zzadm.zzS(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 46:
                        zzadm.zzT(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 47:
                        zzadm.zzU(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 48:
                        zzadm.zzV(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, true);
                        break;
                    case 49:
                        zzadm.zzO(this.zzc[i11], (List) zzael.zzf(t11, (long) (zzq & 1048575)), zzabg, zzs(i11));
                        break;
                    case 50:
                        zzG(zzabg, i12, zzael.zzf(t11, (long) (zzq & 1048575)), i11);
                        break;
                    case 51:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzf(i12, zzj(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzn(i12, zzk(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzs(i12, zzr(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzH(i12, zzr(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzq(i12, zzn(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzl(i12, zzr(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzj(i12, zzn(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzb(i12, zzE(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzH(i12, zzael.zzf(t11, (long) (zzq & 1048575)), zzabg);
                            break;
                        }
                    case 60:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzu(i12, zzael.zzf(t11, (long) (zzq & 1048575)), zzs(i11));
                            break;
                        }
                    case 61:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzd(i12, (zzaax) zzael.zzf(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzF(i12, zzn(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzh(i12, zzn(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzv(i12, zzn(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzx(i12, zzr(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzz(i12, zzn(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzB(i12, zzr(t11, (long) (zzq & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzD(t11, i12, i11)) {
                            break;
                        } else {
                            zzabg.zzp(i12, zzael.zzf(t11, (long) (zzq & 1048575)), zzs(i11));
                            break;
                        }
                }
            }
            zzaeb<?, ?> zzaeb = this.zzl;
            zzaeb.zzg(zzaeb.zzc(t11), zzabg);
        } else {
            this.zzm.zza(t11);
            throw null;
        }
    }
}
