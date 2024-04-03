package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zztb {
    private static final Class<?> zzbdu = zzqy();
    private static final zztr<?, ?> zzbdv = zzl(false);
    private static final zztr<?, ?> zzbdw = zzl(true);
    private static final zztr<?, ?> zzbdx = new zztt();

    public static void zza(int i11, List<Double> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzg(i11, list, z11);
        }
    }

    public static int zzaa(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzbc(zzrd.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzbc(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzab(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzbd(zzrd.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzbd(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzac(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzbe(zzrd.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzbe(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzad(List<?> list) {
        return list.size() << 2;
    }

    public static int zzae(List<?> list) {
        return list.size() << 3;
    }

    public static int zzaf(List<?> list) {
        return list.size();
    }

    public static void zzb(int i11, List<Float> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzf(i11, list, z11);
        }
    }

    public static void zzc(int i11, List<Long> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzc(i11, list, z11);
        }
    }

    public static void zzd(int i11, List<Long> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzd(i11, list, z11);
        }
    }

    public static void zze(int i11, List<Long> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzn(i11, list, z11);
        }
    }

    public static void zzf(int i11, List<Long> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zze(i11, list, z11);
        }
    }

    public static void zzg(int i11, List<Long> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzl(i11, list, z11);
        }
    }

    public static void zzh(int i11, List<Integer> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zza(i11, list, z11);
        }
    }

    public static void zzi(int i11, List<Integer> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzj(i11, list, z11);
        }
    }

    public static void zzj(Class<?> cls) {
        Class<?> cls2;
        if (!zzrc.class.isAssignableFrom(cls) && (cls2 = zzbdu) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzk(int i11, List<Integer> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzb(i11, list, z11);
        }
    }

    public static void zzl(int i11, List<Integer> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzk(i11, list, z11);
        }
    }

    public static void zzm(int i11, List<Integer> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzh(i11, list, z11);
        }
    }

    public static void zzn(int i11, List<Boolean> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzi(i11, list, z11);
        }
    }

    public static int zzo(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzw(list) + (list.size() * zzqj.zzbb(i11));
    }

    public static int zzp(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzqj.zzbb(i11));
    }

    public static int zzq(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzqj.zzbb(i11));
    }

    public static zztr<?, ?> zzqv() {
        return zzbdv;
    }

    public static zztr<?, ?> zzqw() {
        return zzbdw;
    }

    public static zztr<?, ?> zzqx() {
        return zzbdx;
    }

    private static Class<?> zzqy() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzqz() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zzr(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzz(list) + (size * zzqj.zzbb(i11));
    }

    public static int zzs(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaa(list) + (size * zzqj.zzbb(i11));
    }

    public static int zzt(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzab(list) + (size * zzqj.zzbb(i11));
    }

    public static int zzu(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zzqj.zzbb(i11));
    }

    public static int zzv(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzl(i11, 0);
    }

    public static int zzw(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzs(zzry.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzs(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzx(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzt(zzry.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzt(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzy(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzry) {
            zzry zzry = (zzry) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzu(zzry.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzu(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzz(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzrd) {
            zzrd zzrd = (zzrd) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzqj.zzbh(zzrd.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzqj.zzbh(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static void zza(int i11, List<String> list, zzum zzum) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zza(i11, list);
        }
    }

    public static void zzb(int i11, List<zzps> list, zzum zzum) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzb(i11, list);
        }
    }

    public static int zzc(int i11, List<?> list) {
        int i12;
        int i13;
        int size = list.size();
        int i14 = 0;
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i11) * size;
        if (list instanceof zzrt) {
            zzrt zzrt = (zzrt) list;
            while (i14 < size) {
                Object zzbn = zzrt.zzbn(i14);
                if (zzbn instanceof zzps) {
                    i13 = zzqj.zzb((zzps) zzbn);
                } else {
                    i13 = zzqj.zzda((String) zzbn);
                }
                zzbb += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof zzps) {
                    i12 = zzqj.zzb((zzps) obj);
                } else {
                    i12 = zzqj.zzda((String) obj);
                }
                zzbb += i12;
                i14++;
            }
        }
        return zzbb;
    }

    public static int zzd(int i11, List<zzps> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = size * zzqj.zzbb(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzbb += zzqj.zzb(list.get(i12));
        }
        return zzbb;
    }

    public static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zztr<?, ?> zzl(boolean z11) {
        try {
            Class<?> zzqz = zzqz();
            if (zzqz == null) {
                return null;
            }
            return (zztr) zzqz.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzj(int i11, List<Integer> list, zzum zzum, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzm(i11, list, z11);
        }
    }

    public static void zza(int i11, List<?> list, zzum zzum, zzsz zzsz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zza(i11, list, zzsz);
        }
    }

    public static void zzb(int i11, List<?> list, zzum zzum, zzsz zzsz) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzum.zzb(i11, list, zzsz);
        }
    }

    public static int zzw(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzg(i11, 0);
    }

    public static int zzx(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzqj.zzc(i11, true);
    }

    public static <T> void zza(zzsf zzsf, T t11, T t12, long j11) {
        zztx.zza((Object) t11, j11, zzsf.zzc(zztx.zzp(t11, j11), zztx.zzp(t12, j11)));
    }

    public static int zzd(int i11, List<zzsk> list, zzsz zzsz) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzqj.zzc(i11, list.get(i13), zzsz);
        }
        return i12;
    }

    public static <T, FT extends zzqv<FT>> void zza(zzqq<FT> zzqq, T t11, T t12) {
        zzqt<FT> zzr = zzqq.zzr(t12);
        if (!zzr.zzaxo.isEmpty()) {
            zzqq.zzs(t11).zza(zzr);
        }
    }

    public static <T, UT, UB> void zza(zztr<UT, UB> zztr, T t11, T t12) {
        zztr.zzf(t11, zztr.zzh(zztr.zzag(t11), zztr.zzag(t12)));
    }

    public static int zzc(int i11, Object obj, zzsz zzsz) {
        if (obj instanceof zzrr) {
            return zzqj.zza(i11, (zzrr) obj);
        }
        return zzqj.zzb(i11, (zzsk) obj, zzsz);
    }

    public static <UT, UB> UB zza(int i11, List<Integer> list, zzrh zzrh, UB ub2, zztr<UT, UB> zztr) {
        if (zzrh == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (zzrh.zzb(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = zza(i11, intValue, ub2, zztr);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzrh.zzb(intValue2)) {
                    ub2 = zza(i11, intValue2, ub2, zztr);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static int zzc(int i11, List<?> list, zzsz zzsz) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzbb = zzqj.zzbb(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof zzrr) {
                i12 = zzqj.zza((zzrr) obj);
            } else {
                i12 = zzqj.zzb((zzsk) obj, zzsz);
            }
            zzbb += i12;
        }
        return zzbb;
    }

    public static <UT, UB> UB zza(int i11, int i12, UB ub2, zztr<UT, UB> zztr) {
        if (ub2 == null) {
            ub2 = zztr.zzri();
        }
        zztr.zza(ub2, i11, (long) i12);
        return ub2;
    }
}
