package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzgmq {
    private static final Class<?> zza;
    private static final zzgnf<?, ?> zzb = zzab(false);
    private static final zzgnf<?, ?> zzc = zzab(true);
    private static final zzgnf<?, ?> zzd = new zzgnh();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzgnf<?, ?> zzA() {
        return zzc;
    }

    public static zzgnf<?, ?> zzB() {
        return zzd;
    }

    public static <UT, UB> UB zzC(int i11, List<Integer> list, zzgkp zzgkp, UB ub2, zzgnf<UT, UB> zzgnf) {
        if (zzgkp == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (zzgkp.zza(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = zzD(i11, intValue, ub2, zzgnf);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return ub2;
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzgkp.zza(intValue2)) {
                    ub2 = zzD(i11, intValue2, ub2, zzgnf);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static <UT, UB> UB zzD(int i11, int i12, UB ub2, zzgnf<UT, UB> zzgnf) {
        if (ub2 == null) {
            ub2 = zzgnf.zzf();
        }
        zzgnf.zzl(ub2, i11, (long) i12);
        return ub2;
    }

    public static <T, FT extends zzgkb<FT>> void zzE(zzgjy<FT> zzgjy, T t11, T t12) {
        zzgjy.zza(t12);
        throw null;
    }

    public static <T, UT, UB> void zzF(zzgnf<UT, UB> zzgnf, T t11, T t12) {
        zzgnf.zzo(t11, zzgnf.zze(zzgnf.zzd(t11), zzgnf.zzd(t12)));
    }

    public static void zzG(Class<?> cls) {
        Class<?> cls2;
        if (!zzgkl.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzH(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static <T> void zzI(zzglq zzglq, T t11, T t12, long j11) {
        zzgnp.zzv(t11, j11, zzglq.zzc(zzgnp.zzh(t11, j11), zzgnp.zzh(t12, j11)));
    }

    public static void zzJ(int i11, List<Boolean> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzc(i11, list, z11);
        }
    }

    public static void zzK(int i11, List<zzgjf> list, zzgjt zzgjt) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zze(i11, list);
        }
    }

    public static void zzL(int i11, List<Double> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzg(i11, list, z11);
        }
    }

    public static void zzM(int i11, List<Integer> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzj(i11, list, z11);
        }
    }

    public static void zzN(int i11, List<Integer> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzl(i11, list, z11);
        }
    }

    public static void zzO(int i11, List<Long> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzn(i11, list, z11);
        }
    }

    public static void zzP(int i11, List<Float> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzp(i11, list, z11);
        }
    }

    public static void zzQ(int i11, List<?> list, zzgjt zzgjt, zzgmo zzgmo) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                zzgjt.zzq(i11, list.get(i12), zzgmo);
            }
        }
    }

    public static void zzR(int i11, List<Integer> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzs(i11, list, z11);
        }
    }

    public static void zzS(int i11, List<Long> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzu(i11, list, z11);
        }
    }

    public static void zzT(int i11, List<?> list, zzgjt zzgjt, zzgmo zzgmo) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                zzgjt.zzv(i11, list.get(i12), zzgmo);
            }
        }
    }

    public static void zzU(int i11, List<Integer> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzx(i11, list, z11);
        }
    }

    public static void zzV(int i11, List<Long> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzz(i11, list, z11);
        }
    }

    public static void zzW(int i11, List<Integer> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzB(i11, list, z11);
        }
    }

    public static void zzX(int i11, List<Long> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzD(i11, list, z11);
        }
    }

    public static void zzY(int i11, List<String> list, zzgjt zzgjt) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzG(i11, list);
        }
    }

    public static void zzZ(int i11, List<Integer> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzI(i11, list, z11);
        }
    }

    public static int zza(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgjs.zzA(i11 << 3) + 1);
    }

    public static void zzaa(int i11, List<Long> list, zzgjt zzgjt, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgjt.zzK(i11, list, z11);
        }
    }

    private static zzgnf<?, ?> zzab(boolean z11) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzgnf) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List<?> list) {
        return list.size();
    }

    public static int zzc(int i11, List<zzgjf> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzgjs.zzz(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzz += zzgjs.zzt(list.get(i12));
        }
        return zzz;
    }

    public static int zzd(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzgjs.zzz(i11));
    }

    public static int zze(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzgjs.zzv(zzgkm.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzgjs.zzv(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzf(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgjs.zzA(i11 << 3) + 4);
    }

    public static int zzg(List<?> list) {
        return list.size() * 4;
    }

    public static int zzh(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgjs.zzA(i11 << 3) + 8);
    }

    public static int zzi(List<?> list) {
        return list.size() * 8;
    }

    public static int zzj(int i11, List<zzglv> list, zzgmo zzgmo) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzgjs.zzu(i11, list.get(i13), zzgmo);
        }
        return i12;
    }

    public static int zzk(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzgjs.zzz(i11));
    }

    public static int zzl(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzgjs.zzv(zzgkm.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzgjs.zzv(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzm(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzgjs.zzz(i11));
    }

    public static int zzn(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzgjs.zzB(zzglk.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzgjs.zzB(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzo(int i11, Object obj, zzgmo zzgmo) {
        if (!(obj instanceof zzglb)) {
            return zzgjs.zzA(i11 << 3) + zzgjs.zzx((zzglv) obj, zzgmo);
        }
        int zzA = zzgjs.zzA(i11 << 3);
        int zza2 = ((zzglb) obj).zza();
        return zzA + zzgjs.zzA(zza2) + zza2;
    }

    public static int zzp(int i11, List<?> list, zzgmo zzgmo) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzgjs.zzz(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof zzglb) {
                i12 = zzgjs.zzw((zzglb) obj);
            } else {
                i12 = zzgjs.zzx((zzglv) obj, zzgmo);
            }
            zzz += i12;
        }
        return zzz;
    }

    public static int zzq(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzgjs.zzz(i11));
    }

    public static int zzr(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zzgkm.zze(i12);
                i11 += zzgjs.zzA((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = list.get(i12).intValue();
                i13 = i11 + zzgjs.zzA((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzs(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzgjs.zzz(i11));
    }

    public static int zzt(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            i11 = 0;
            while (i12 < size) {
                long zze = zzglk.zze(i12);
                i11 += zzgjs.zzB((zze >> 63) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = list.get(i12).longValue();
                i13 = i11 + zzgjs.zzB((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzu(int i11, List<?> list) {
        int i12;
        int i13;
        int size = list.size();
        int i14 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzgjs.zzz(i11) * size;
        if (list instanceof zzgld) {
            zzgld zzgld = (zzgld) list;
            while (i14 < size) {
                Object zzf = zzgld.zzf(i14);
                if (zzf instanceof zzgjf) {
                    i13 = zzgjs.zzt((zzgjf) zzf);
                } else {
                    i13 = zzgjs.zzy((String) zzf);
                }
                zzz += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof zzgjf) {
                    i12 = zzgjs.zzt((zzgjf) obj);
                } else {
                    i12 = zzgjs.zzy((String) obj);
                }
                zzz += i12;
                i14++;
            }
        }
        return zzz;
    }

    public static int zzv(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzgjs.zzz(i11));
    }

    public static int zzw(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgkm) {
            zzgkm zzgkm = (zzgkm) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzgjs.zzA(zzgkm.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzgjs.zzA(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzx(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzgjs.zzz(i11));
    }

    public static int zzy(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzglk) {
            zzglk zzglk = (zzglk) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzgjs.zzB(zzglk.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzgjs.zzB(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzgnf<?, ?> zzz() {
        return zzb;
    }
}
