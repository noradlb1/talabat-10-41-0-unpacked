package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.List;

final class zzer {
    private static final Class<?> zza;
    private static final zzfd<?, ?> zzb = zzZ(false);
    private static final zzfd<?, ?> zzc = zzZ(true);
    private static final zzfd<?, ?> zzd = new zzff();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzfd<?, ?> zzA() {
        return zzb;
    }

    public static zzfd<?, ?> zzB() {
        return zzc;
    }

    public static zzfd<?, ?> zzC() {
        return zzd;
    }

    public static boolean zzD(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static <T, FT extends zzct<FT>> void zzE(zzcq<FT> zzcq, T t11, T t12) {
        zzcq.zzb(t12);
        throw null;
    }

    public static <T, UT, UB> void zzF(zzfd<UT, UB> zzfd, T t11, T t12) {
        zzfd.zza(t11, zzfd.zzd(zzfd.zzb(t11), zzfd.zzb(t12)));
    }

    public static <T> void zzG(zzdz zzdz, T t11, T t12, long j11) {
        zzdy zzdy = (zzdy) zzfn.zzn(t11, j11);
        zzdy zzdy2 = (zzdy) zzfn.zzn(t12, j11);
        if (!zzdy2.isEmpty()) {
            if (!zzdy.zzd()) {
                zzdy = zzdy.zzb();
            }
            zzdy.zza(zzdy2);
        }
        zzfn.zzo(t11, j11, zzdy);
    }

    public static void zzH(int i11, List<Double> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzz(i11, list, z11);
        }
    }

    public static void zzI(int i11, List<Float> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzy(i11, list, z11);
        }
    }

    public static void zzJ(int i11, List<Long> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzv(i11, list, z11);
        }
    }

    public static void zzK(int i11, List<Long> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzw(i11, list, z11);
        }
    }

    public static void zzL(int i11, List<Long> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzI(i11, list, z11);
        }
    }

    public static void zzM(int i11, List<Long> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzx(i11, list, z11);
        }
    }

    public static void zzN(int i11, List<Long> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzG(i11, list, z11);
        }
    }

    public static void zzO(int i11, List<Integer> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzt(i11, list, z11);
        }
    }

    public static void zzP(int i11, List<Integer> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzE(i11, list, z11);
        }
    }

    public static void zzQ(int i11, List<Integer> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzH(i11, list, z11);
        }
    }

    public static void zzR(int i11, List<Integer> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzu(i11, list, z11);
        }
    }

    public static void zzS(int i11, List<Integer> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzF(i11, list, z11);
        }
    }

    public static void zzT(int i11, List<Integer> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzA(i11, list, z11);
        }
    }

    public static void zzU(int i11, List<Boolean> list, zzcn zzcn, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzB(i11, list, z11);
        }
    }

    public static void zzV(int i11, List<String> list, zzcn zzcn) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzC(i11, list);
        }
    }

    public static void zzW(int i11, List<zzcf> list, zzcn zzcn) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzcn.zzD(i11, list);
        }
    }

    public static void zzX(int i11, List<?> list, zzcn zzcn, zzep zzep) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                zzcn.zzr(i11, list.get(i12), zzep);
            }
        }
    }

    public static void zzY(int i11, List<?> list, zzcn zzcn, zzep zzep) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                zzcn.zzs(i11, list.get(i12), zzep);
            }
        }
    }

    private static zzfd<?, ?> zzZ(boolean z11) {
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
            return (zzfd) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzda.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static int zzb(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzcm.zzx(zzdt.zzf(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzcm.zzx(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzc(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzb(list) + (list.size() * zzcm.zzu(i11));
    }

    public static int zzd(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzcm.zzx(zzdt.zzf(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzcm.zzx(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zze(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzcm.zzu(i11));
    }

    public static int zzf(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdt) {
            zzdt zzdt = (zzdt) list;
            i11 = 0;
            while (i12 < size) {
                long zzf = zzdt.zzf(i12);
                i11 += zzcm.zzx((zzf >> 63) ^ (zzf + zzf));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = list.get(i12).longValue();
                i13 = i11 + zzcm.zzx((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzg(int i11, List<Long> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzcm.zzu(i11));
    }

    public static int zzh(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdb = (zzdb) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzcm.zzv(zzdb.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzcm.zzv(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzi(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzh(list) + (size * zzcm.zzu(i11));
    }

    public static int zzj(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdb = (zzdb) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzcm.zzv(zzdb.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzcm.zzv(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzk(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzj(list) + (size * zzcm.zzu(i11));
    }

    public static int zzl(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdb = (zzdb) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzcm.zzw(zzdb.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzcm.zzw(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzm(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzcm.zzu(i11));
    }

    public static int zzn(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdb) {
            zzdb zzdb = (zzdb) list;
            i11 = 0;
            while (i12 < size) {
                int zzd2 = zzdb.zzd(i12);
                i11 += zzcm.zzw((zzd2 >> 31) ^ (zzd2 + zzd2));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = list.get(i12).intValue();
                i13 = i11 + zzcm.zzw((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzo(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzn(list) + (size * zzcm.zzu(i11));
    }

    public static int zzp(List<?> list) {
        return list.size() * 4;
    }

    public static int zzq(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzcm.zzw(i11 << 3) + 4);
    }

    public static int zzr(List<?> list) {
        return list.size() * 8;
    }

    public static int zzs(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzcm.zzw(i11 << 3) + 8);
    }

    public static int zzt(List<?> list) {
        return list.size();
    }

    public static int zzu(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzcm.zzw(i11 << 3) + 1);
    }

    public static int zzv(int i11, List<?> list) {
        int i12;
        int i13;
        int size = list.size();
        int i14 = 0;
        if (size == 0) {
            return 0;
        }
        int zzu = zzcm.zzu(i11) * size;
        if (list instanceof zzdo) {
            zzdo zzdo = (zzdo) list;
            while (i14 < size) {
                Object zzg = zzdo.zzg(i14);
                if (zzg instanceof zzcf) {
                    i13 = zzcm.zzA((zzcf) zzg);
                } else {
                    i13 = zzcm.zzy((String) zzg);
                }
                zzu += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof zzcf) {
                    i12 = zzcm.zzA((zzcf) obj);
                } else {
                    i12 = zzcm.zzy((String) obj);
                }
                zzu += i12;
                i14++;
            }
        }
        return zzu;
    }

    public static int zzw(int i11, Object obj, zzep zzep) {
        if (!(obj instanceof zzdm)) {
            return zzcm.zzw(i11 << 3) + zzcm.zzB((zzee) obj, zzep);
        }
        int zzw = zzcm.zzw(i11 << 3);
        int zza2 = ((zzdm) obj).zza();
        return zzw + zzcm.zzw(zza2) + zza2;
    }

    public static int zzx(int i11, List<?> list, zzep zzep) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = zzcm.zzu(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof zzdm) {
                i12 = zzcm.zzz((zzdm) obj);
            } else {
                i12 = zzcm.zzB((zzee) obj, zzep);
            }
            zzu += i12;
        }
        return zzu;
    }

    public static int zzy(int i11, List<zzcf> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzu = size * zzcm.zzu(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzu += zzcm.zzA(list.get(i12));
        }
        return zzu;
    }

    public static int zzz(int i11, List<zzee> list, zzep zzep) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzcm.zzE(i11, list.get(i13), zzep);
        }
        return i12;
    }
}
