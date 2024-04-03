package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzeh {
    private static final Class<?> zzoh = zzdp();
    private static final zzex<?, ?> zzoi = zzd(false);
    private static final zzex<?, ?> zzoj = zzd(true);
    private static final zzex<?, ?> zzok = new zzez();

    public static int zza(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zze(zzdc.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zze(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    private static <UT, UB> UB zza(int i11, int i12, UB ub2, zzex<UT, UB> zzex) {
        if (ub2 == null) {
            ub2 = zzex.zzdz();
        }
        zzex.zza(ub2, i11, (long) i12);
        return ub2;
    }

    public static <UT, UB> UB zza(int i11, List<Integer> list, zzck<?> zzck, UB ub2, zzex<UT, UB> zzex) {
        if (zzck == null) {
            return ub2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = list.get(i13).intValue();
                if (zzck.zzb(intValue) != null) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    ub2 = zza(i11, intValue, ub2, zzex);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (zzck.zzb(intValue2) == null) {
                    ub2 = zza(i11, intValue2, ub2, zzex);
                    it.remove();
                }
            }
        }
        return ub2;
    }

    public static void zza(int i11, List<String> list, zzfr zzfr) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zza(i11, list);
        }
    }

    public static void zza(int i11, List<?> list, zzfr zzfr, zzef zzef) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zza(i11, list, zzef);
        }
    }

    public static void zza(int i11, List<Double> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzg(i11, list, z11);
        }
    }

    public static <T, FT extends zzca<FT>> void zza(zzbu<FT> zzbu, T t11, T t12) {
        zzby<FT> zza = zzbu.zza((Object) t12);
        if (!zza.isEmpty()) {
            zzbu.zzb(t11).zza(zza);
        }
    }

    public static <T> void zza(zzdj zzdj, T t11, T t12, long j11) {
        zzfd.zza((Object) t11, j11, zzdj.zzb(zzfd.zzo(t11, j11), zzfd.zzo(t12, j11)));
    }

    public static <T, UT, UB> void zza(zzex<UT, UB> zzex, T t11, T t12) {
        zzex.zze(t11, zzex.zzg(zzex.zzq(t11), zzex.zzq(t12)));
    }

    public static int zzb(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zzf(zzdc.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zzf(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static void zzb(int i11, List<zzbb> list, zzfr zzfr) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzb(i11, list);
        }
    }

    public static void zzb(int i11, List<?> list, zzfr zzfr, zzef zzef) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzb(i11, list, zzef);
        }
    }

    public static void zzb(int i11, List<Float> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzf(i11, list, z11);
        }
    }

    public static int zzc(int i11, Object obj, zzef zzef) {
        return obj instanceof zzcv ? zzbn.zza(i11, (zzcv) obj) : zzbn.zzb(i11, (zzdo) obj, zzef);
    }

    public static int zzc(int i11, List<?> list) {
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        int zzr = zzbn.zzr(i11) * size;
        if (list instanceof zzcx) {
            zzcx zzcx = (zzcx) list;
            while (i12 < size) {
                Object raw = zzcx.getRaw(i12);
                zzr += raw instanceof zzbb ? zzbn.zzb((zzbb) raw) : zzbn.zzh((String) raw);
                i12++;
            }
        } else {
            while (i12 < size) {
                Object obj = list.get(i12);
                zzr += obj instanceof zzbb ? zzbn.zzb((zzbb) obj) : zzbn.zzh((String) obj);
                i12++;
            }
        }
        return zzr;
    }

    public static int zzc(int i11, List<?> list, zzef zzef) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = zzbn.zzr(i11) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            zzr += obj instanceof zzcv ? zzbn.zza((zzcv) obj) : zzbn.zzb((zzdo) obj, zzef);
        }
        return zzr;
    }

    public static int zzc(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zzg(zzdc.getLong(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zzg(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static void zzc(int i11, List<Long> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzc(i11, list, z11);
        }
    }

    public static boolean zzc(int i11, int i12, int i13) {
        if (i12 < 40) {
            return true;
        }
        long j11 = (long) i13;
        return ((((long) i12) - ((long) i11)) + 1) + 9 <= ((2 * j11) + 3) + ((j11 + 3) * 3);
    }

    public static int zzd(int i11, List<zzbb> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzr = size * zzbn.zzr(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzr += zzbn.zzb(list.get(i12));
        }
        return zzr;
    }

    public static int zzd(int i11, List<zzdo> list, zzef zzef) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzbn.zzc(i11, list.get(i13), zzef);
        }
        return i12;
    }

    public static int zzd(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzch = (zzch) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zzx(zzch.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zzx(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    private static zzex<?, ?> zzd(boolean z11) {
        try {
            Class<?> zzdq = zzdq();
            if (zzdq == null) {
                return null;
            }
            return (zzex) zzdq.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzd(int i11, List<Long> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzd(i11, list, z11);
        }
    }

    public static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static zzex<?, ?> zzdm() {
        return zzoi;
    }

    public static zzex<?, ?> zzdn() {
        return zzoj;
    }

    public static zzex<?, ?> zzdo() {
        return zzok;
    }

    private static Class<?> zzdp() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzdq() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zze(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzch = (zzch) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zzs(zzch.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zzs(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static void zze(int i11, List<Long> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzn(i11, list, z11);
        }
    }

    public static int zzf(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzch = (zzch) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zzt(zzch.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zzt(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static void zzf(int i11, List<Long> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zze(i11, list, z11);
        }
    }

    public static void zzf(Class<?> cls) {
        Class<?> cls2;
        if (!zzcg.class.isAssignableFrom(cls) && (cls2 = zzoh) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static int zzg(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzch) {
            zzch zzch = (zzch) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzbn.zzu(zzch.getInt(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzbn.zzu(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static void zzg(int i11, List<Long> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzl(i11, list, z11);
        }
    }

    public static int zzh(List<?> list) {
        return list.size() << 2;
    }

    public static void zzh(int i11, List<Integer> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zza(i11, list, z11);
        }
    }

    public static int zzi(List<?> list) {
        return list.size() << 3;
    }

    public static void zzi(int i11, List<Integer> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzj(i11, list, z11);
        }
    }

    public static int zzj(List<?> list) {
        return list.size();
    }

    public static void zzj(int i11, List<Integer> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzm(i11, list, z11);
        }
    }

    public static void zzk(int i11, List<Integer> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzb(i11, list, z11);
        }
    }

    public static void zzl(int i11, List<Integer> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzk(i11, list, z11);
        }
    }

    public static void zzm(int i11, List<Integer> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzh(i11, list, z11);
        }
    }

    public static void zzn(int i11, List<Boolean> list, zzfr zzfr, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzfr.zzi(i11, list, z11);
        }
    }

    public static int zzo(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzbn.zzr(i11));
    }

    public static int zzp(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzbn.zzr(i11));
    }

    public static int zzq(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzbn.zzr(i11));
    }

    public static int zzr(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzbn.zzr(i11));
    }

    public static int zzs(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzbn.zzr(i11));
    }

    public static int zzt(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzbn.zzr(i11));
    }

    public static int zzu(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzbn.zzr(i11));
    }

    public static int zzv(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzj(i11, 0);
    }

    public static int zzw(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzg(i11, 0);
    }

    public static int zzx(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzbn.zzc(i11, true);
    }
}
