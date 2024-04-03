package com.google.android.gms.internal.places;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzdc {
    private static final Class<?> zzlv = zzdc();
    private static final zzds<?, ?> zzlw = zzf(false);
    private static final zzds<?, ?> zzlx = zzf(true);
    private static final zzds<?, ?> zzly = new zzdu();

    public static void zzb(int i11, List<Double> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzh(i11, list, z11);
        }
    }

    public static void zzc(int i11, List<Float> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzg(i11, list, z11);
        }
    }

    public static zzds<?, ?> zzcz() {
        return zzlw;
    }

    public static void zzd(int i11, List<Long> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzd(i11, list, z11);
        }
    }

    public static zzds<?, ?> zzda() {
        return zzlx;
    }

    public static zzds<?, ?> zzdb() {
        return zzly;
    }

    private static Class<?> zzdc() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdd() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zze(int i11, List<Long> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zze(i11, list, z11);
        }
    }

    public static void zzf(int i11, List<Long> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzo(i11, list, z11);
        }
    }

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzbc.class.isAssignableFrom(cls) && (cls2 = zzlv) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzh(int i11, List<Long> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzm(i11, list, z11);
        }
    }

    public static void zzi(int i11, List<Integer> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzb(i11, list, z11);
        }
    }

    public static void zzj(int i11, List<Integer> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzk(i11, list, z11);
        }
    }

    public static void zzk(int i11, List<Integer> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzn(i11, list, z11);
        }
    }

    public static void zzl(int i11, List<Integer> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzc(i11, list, z11);
        }
    }

    public static void zzm(int i11, List<Integer> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzl(i11, list, z11);
        }
    }

    public static void zzn(int i11, List<Integer> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzi(i11, list, z11);
        }
    }

    public static void zzo(int i11, List<Boolean> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzj(i11, list, z11);
        }
    }

    public static int zzp(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zze(list) + (list.size() * zzaj.zzr(i11));
    }

    public static int zzq(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzaj.zzr(i11));
    }

    public static int zzr(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzaj.zzr(i11));
    }

    public static int zzs(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzaj.zzr(i11));
    }

    public static int zzt(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzi(list) + (size * zzaj.zzr(i11));
    }

    public static int zzu(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzaj.zzr(i11));
    }

    public static int zzv(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzaj.zzr(i11));
    }

    public static int zzw(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzk(i11, 0);
    }

    public static int zzx(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzh(i11, 0);
    }

    public static int zzy(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzaj.zzd(i11, true);
    }

    public static void zzb(int i11, List<String> list, zzel zzel) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzb(i11, list);
        }
    }

    public static void zzc(int i11, List<zzw> list, zzel zzel) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzc(i11, list);
        }
    }

    public static int zzd(int i11, List<?> list) {
        int i12;
        int i13;
        int size = list.size();
        int i14 = 0;
        if (size == 0) {
            return 0;
        }
        int zzr = zzaj.zzr(i11) * size;
        if (list instanceof zzbr) {
            zzbr zzbr = (zzbr) list;
            while (i14 < size) {
                Object zzae = zzbr.zzae(i14);
                if (zzae instanceof zzw) {
                    i13 = zzaj.zzc((zzw) zzae);
                } else {
                    i13 = zzaj.zzk((String) zzae);
                }
                zzr += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof zzw) {
                    i12 = zzaj.zzc((zzw) obj);
                } else {
                    i12 = zzaj.zzk((String) obj);
                }
                zzr += i12;
                i14++;
            }
        }
        return zzr;
    }

    public static int zze(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzby = (zzby) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzf(zzby.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzf(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzf(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzby = (zzby) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzg(zzby.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzg(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzh(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbe = (zzbe) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzx(zzbe.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzx(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzi(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbe = (zzbe) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzs(zzbe.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzs(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzj(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbe = (zzbe) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzt(zzbe.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzt(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzk(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzbe) {
            zzbe zzbe = (zzbe) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzu(zzbe.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzu(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzl(List<?> list) {
        return list.size() << 2;
    }

    public static int zzm(List<?> list) {
        return list.size() << 3;
    }

    public static int zzn(List<?> list) {
        return list.size();
    }

    public static void zzg(int i11, List<Long> list, zzel zzel, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzf(i11, list, z11);
        }
    }

    public static void zzb(int i11, List<?> list, zzel zzel, zzda zzda) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzb(i11, list, zzda);
        }
    }

    public static void zzc(int i11, List<?> list, zzel zzel, zzda zzda) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzel.zzc(i11, list, zzda);
        }
    }

    public static int zzg(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzby) {
            zzby zzby = (zzby) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzaj.zzh(zzby.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzaj.zzh(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static <T> void zzb(zzcd zzcd, T t11, T t12, long j11) {
        zzdy.zzb((Object) t11, j11, zzcd.zzc(zzdy.zzp(t11, j11), zzdy.zzp(t12, j11)));
    }

    public static int zze(int i11, List<zzw> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = size * zzaj.zzr(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzr += zzaj.zzc(list.get(i12));
        }
        return zzr;
    }

    private static zzds<?, ?> zzf(boolean z11) {
        try {
            Class<?> zzdd = zzdd();
            if (zzdd == null) {
                return null;
            }
            return (zzds) zzdd.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends zzax<FT>> void zzb(zzar<FT> zzar, T t11, T t12) {
        zzav<FT> zzb = zzar.zzb((Object) t12);
        if (!zzb.zzfj.isEmpty()) {
            zzar.zzc(t11).zzb(zzb);
        }
    }

    public static int zze(int i11, List<zzck> list, zzda zzda) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzaj.zzd(i11, list.get(i13), zzda);
        }
        return i12;
    }

    public static <T, UT, UB> void zzb(zzds<UT, UB> zzds, T t11, T t12) {
        zzds.zzf(t11, zzds.zzh(zzds.zzr(t11), zzds.zzr(t12)));
    }

    public static boolean zze(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int zzd(int i11, Object obj, zzda zzda) {
        if (obj instanceof zzbp) {
            return zzaj.zzb(i11, (zzbp) obj);
        }
        return zzaj.zzc(i11, (zzck) obj, zzda);
    }

    public static <UT, UB> UB zzb(int i11, List<Integer> list, zzbf zzbf, UB ub2, zzds<UT, UB> zzds) {
        if (zzbf == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (zzbf.zzad(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = zzb(i11, intValue, ub2, zzds);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!zzbf.zzad(intValue2)) {
                    ub2 = zzb(i11, intValue2, ub2, zzds);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static int zzd(int i11, List<?> list, zzda zzda) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = zzaj.zzr(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof zzbp) {
                i12 = zzaj.zzb((zzbp) obj);
            } else {
                i12 = zzaj.zzb((zzck) obj, zzda);
            }
            zzr += i12;
        }
        return zzr;
    }

    private static <UT, UB> UB zzb(int i11, int i12, UB ub2, zzds<UT, UB> zzds) {
        if (ub2 == null) {
            ub2 = zzds.zzdk();
        }
        zzds.zzb(ub2, i11, (long) i12);
        return ub2;
    }
}
