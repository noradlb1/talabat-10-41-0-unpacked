package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzit {
    private static final Class<?> zzzr = zzhv();
    private static final zzjj<?, ?> zzzs = zzn(false);
    private static final zzjj<?, ?> zzzt = zzn(true);
    private static final zzjj<?, ?> zzzu = new zzjl();

    public static void zza(int i11, List<Double> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzg(i11, list, z11);
        }
    }

    public static void zzb(int i11, List<Float> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzf(i11, list, z11);
        }
    }

    public static void zzc(int i11, List<Long> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzc(i11, list, z11);
        }
    }

    public static void zzd(int i11, List<Long> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzd(i11, list, z11);
        }
    }

    public static void zze(int i11, List<Long> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzn(i11, list, z11);
        }
    }

    public static void zzf(int i11, List<Long> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zze(i11, list, z11);
        }
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzgs.class.isAssignableFrom(cls) && (cls2 = zzzr) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i11, List<Integer> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zza(i11, list, z11);
        }
    }

    public static zzjj<?, ?> zzhs() {
        return zzzs;
    }

    public static zzjj<?, ?> zzht() {
        return zzzt;
    }

    public static zzjj<?, ?> zzhu() {
        return zzzu;
    }

    private static Class<?> zzhv() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzhw() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzi(int i11, List<Integer> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzj(i11, list, z11);
        }
    }

    public static void zzj(int i11, List<Integer> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzm(i11, list, z11);
        }
    }

    public static void zzk(int i11, List<Integer> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzb(i11, list, z11);
        }
    }

    public static void zzl(int i11, List<Integer> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzk(i11, list, z11);
        }
    }

    public static void zzm(int i11, List<Integer> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzh(i11, list, z11);
        }
    }

    public static void zzn(int i11, List<Boolean> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzi(i11, list, z11);
        }
    }

    public static int zzo(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzga.zzba(i11));
    }

    public static int zzp(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzga.zzba(i11));
    }

    public static int zzq(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzv(zzhq.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzv(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzr(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzw(zzhq.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzw(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzs(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzx(zzhq.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzx(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzt(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzbg(zzgu.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzbg(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzu(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzbb(zzgu.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzbb(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzv(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzbc(zzgu.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzbc(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzw(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzga.zzbd(zzgu.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzga.zzbd(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzx(List<?> list) {
        return list.size() << 2;
    }

    public static int zzy(List<?> list) {
        return list.size() << 3;
    }

    public static int zzz(List<?> list) {
        return list.size();
    }

    public static int zzx(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzga.zzb(i11, true);
    }

    public static void zza(int i11, List<String> list, zzkg zzkg) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zza(i11, list);
        }
    }

    public static void zzb(int i11, List<zzfh> list, zzkg zzkg) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzb(i11, list);
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
        int zzba = zzga.zzba(i11) * size;
        if (list instanceof zzhj) {
            zzhj zzhj = (zzhj) list;
            while (i14 < size) {
                Object raw = zzhj.getRaw(i14);
                if (raw instanceof zzfh) {
                    i13 = zzga.zzb((zzfh) raw);
                } else {
                    i13 = zzga.zzy((String) raw);
                }
                zzba += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof zzfh) {
                    i12 = zzga.zzb((zzfh) obj);
                } else {
                    i12 = zzga.zzy((String) obj);
                }
                zzba += i12;
                i14++;
            }
        }
        return zzba;
    }

    public static int zzd(int i11, List<zzfh> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzba = size * zzga.zzba(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzba += zzga.zzb(list.get(i12));
        }
        return zzba;
    }

    public static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    private static zzjj<?, ?> zzn(boolean z11) {
        try {
            Class<?> zzhw = zzhw();
            if (zzhw == null) {
                return null;
            }
            return (zzjj) zzhw.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzg(int i11, List<Long> list, zzkg zzkg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzl(i11, list, z11);
        }
    }

    public static void zza(int i11, List<?> list, zzkg zzkg, zzir zzir) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zza(i11, list, zzir);
        }
    }

    public static void zzb(int i11, List<?> list, zzkg zzkg, zzir zzir) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzkg.zzb(i11, list, zzir);
        }
    }

    public static int zzq(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzga.zzba(i11));
    }

    public static int zzr(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzga.zzba(i11));
    }

    public static int zzs(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzga.zzba(i11));
    }

    public static int zzt(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzga.zzba(i11));
    }

    public static int zzu(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzga.zzba(i11));
    }

    public static int zzv(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzga.zzo(i11, 0);
    }

    public static int zzw(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzga.zzg(i11, 0);
    }

    public static <T> void zza(zzhv zzhv, T t11, T t12, long j11) {
        zzjp.zza((Object) t11, j11, zzhv.zzc(zzjp.zzp(t11, j11), zzjp.zzp(t12, j11)));
    }

    public static int zzd(int i11, List<zzic> list, zzir zzir) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzga.zzc(i11, list.get(i13), zzir);
        }
        return i12;
    }

    public static <T, FT extends zzgk<FT>> void zza(zzgf<FT> zzgf, T t11, T t12) {
        zzgi<FT> zze = zzgf.zze((Object) t12);
        if (!zze.zztb.isEmpty()) {
            zzgf.zzf(t11).zza(zze);
        }
    }

    public static <T, UT, UB> void zza(zzjj<UT, UB> zzjj, T t11, T t12) {
        zzjj.zzf(t11, zzjj.zzh(zzjj.zzv(t11), zzjj.zzv(t12)));
    }

    public static int zzc(int i11, Object obj, zzir zzir) {
        if (obj instanceof zzhh) {
            return zzga.zza(i11, (zzhh) obj);
        }
        return zzga.zzb(i11, (zzic) obj, zzir);
    }

    public static <UT, UB> UB zza(int i11, List<Integer> list, zzgv<?> zzgv, UB ub2, zzjj<UT, UB> zzjj) {
        if (zzgv == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (zzgv.zzg(intValue) != null) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = zza(i11, intValue, ub2, zzjj);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (zzgv.zzg(intValue2) == null) {
                    ub2 = zza(i11, intValue2, ub2, zzjj);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static int zzc(int i11, List<?> list, zzir zzir) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzba = zzga.zzba(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof zzhh) {
                i12 = zzga.zza((zzhh) obj);
            } else {
                i12 = zzga.zza((zzic) obj, zzir);
            }
            zzba += i12;
        }
        return zzba;
    }

    public static <UT, UB> UB zza(int i11, List<Integer> list, zzgy zzgy, UB ub2, zzjj<UT, UB> zzjj) {
        if (zzgy == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (zzgy.zzf(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = zza(i11, intValue, ub2, zzjj);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzgy.zzf(intValue2)) {
                    ub2 = zza(i11, intValue2, ub2, zzjj);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static <UT, UB> UB zza(int i11, int i12, UB ub2, zzjj<UT, UB> zzjj) {
        if (ub2 == null) {
            ub2 = zzjj.zzif();
        }
        zzjj.zza(ub2, i11, (long) i12);
        return ub2;
    }
}
