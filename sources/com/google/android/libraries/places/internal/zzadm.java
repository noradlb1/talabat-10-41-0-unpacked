package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;

final class zzadm {
    private static final Class<?> zza;
    private static final zzaeb<?, ?> zzb = zzZ(false);
    private static final zzaeb<?, ?> zzc = zzZ(true);
    private static final zzaeb<?, ?> zzd = new zzaed();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzaeb<?, ?> zzA() {
        return zzc;
    }

    public static zzaeb<?, ?> zzB() {
        return zzd;
    }

    public static <T, FT extends zzabl<FT>> void zzC(zzabi<FT> zzabi, T t11, T t12) {
        zzabi.zza(t12);
        throw null;
    }

    public static <T, UT, UB> void zzD(zzaeb<UT, UB> zzaeb, T t11, T t12) {
        zzaeb.zzf(t11, zzaeb.zzd(zzaeb.zzc(t11), zzaeb.zzc(t12)));
    }

    public static void zzE(Class<?> cls) {
        Class<?> cls2;
        if (!zzabs.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static <T> void zzG(zzacu zzacu, T t11, T t12, long j11) {
        zzact zzact = (zzact) zzael.zzf(t11, j11);
        zzact zzact2 = (zzact) zzael.zzf(t12, j11);
        if (!zzact2.isEmpty()) {
            if (!zzact.zzd()) {
                zzact = zzact.zza();
            }
            zzact.zzc(zzact2);
        }
        zzael.zzs(t11, j11, zzact);
    }

    public static void zzH(int i11, List<Boolean> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzc(i11, list, z11);
        }
    }

    public static void zzI(int i11, List<zzaax> list, zzabg zzabg) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zze(i11, list);
        }
    }

    public static void zzJ(int i11, List<Double> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzg(i11, list, z11);
        }
    }

    public static void zzK(int i11, List<Integer> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzi(i11, list, z11);
        }
    }

    public static void zzL(int i11, List<Integer> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzk(i11, list, z11);
        }
    }

    public static void zzM(int i11, List<Long> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzm(i11, list, z11);
        }
    }

    public static void zzN(int i11, List<Float> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzo(i11, list, z11);
        }
    }

    public static void zzO(int i11, List<?> list, zzabg zzabg, zzadk zzadk) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                zzabg.zzp(i11, list.get(i12), zzadk);
            }
        }
    }

    public static void zzP(int i11, List<Integer> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzr(i11, list, z11);
        }
    }

    public static void zzQ(int i11, List<Long> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzt(i11, list, z11);
        }
    }

    public static void zzR(int i11, List<?> list, zzabg zzabg, zzadk zzadk) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                zzabg.zzu(i11, list.get(i12), zzadk);
            }
        }
    }

    public static void zzS(int i11, List<Integer> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzw(i11, list, z11);
        }
    }

    public static void zzT(int i11, List<Long> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzy(i11, list, z11);
        }
    }

    public static void zzU(int i11, List<Integer> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzA(i11, list, z11);
        }
    }

    public static void zzV(int i11, List<Long> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzC(i11, list, z11);
        }
    }

    public static void zzW(int i11, List<String> list, zzabg zzabg) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzE(i11, list);
        }
    }

    public static void zzX(int i11, List<Integer> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzG(i11, list, z11);
        }
    }

    public static void zzY(int i11, List<Long> list, zzabg zzabg, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzabg.zzI(i11, list, z11);
        }
    }

    private static zzaeb<?, ?> zzZ(boolean z11) {
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
            return (zzaeb) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z11)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zza(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzabf.zzA(i11 << 3) + 1);
    }

    public static int zzb(List<?> list) {
        return list.size();
    }

    public static int zzc(int i11, List<zzaax> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzabf.zzz(i11);
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzz += zzabf.zzt(list.get(i12));
        }
        return zzz;
    }

    public static int zzd(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzabf.zzz(i11));
    }

    public static int zze(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzabt) {
            zzabt zzabt = (zzabt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzabf.zzv(zzabt.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzabf.zzv(list.get(i12).intValue());
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
        return size * (zzabf.zzA(i11 << 3) + 4);
    }

    public static int zzg(List<?> list) {
        return list.size() * 4;
    }

    public static int zzh(int i11, List<?> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzabf.zzA(i11 << 3) + 8);
    }

    public static int zzi(List<?> list) {
        return list.size() * 8;
    }

    public static int zzj(int i11, List<zzacz> list, zzadk zzadk) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzabf.zzu(i11, list.get(i13), zzadk);
        }
        return i12;
    }

    public static int zzk(int i11, List<Integer> list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzabf.zzz(i11));
    }

    public static int zzl(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzabt) {
            zzabt zzabt = (zzabt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzabf.zzv(zzabt.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzabf.zzv(list.get(i12).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzm(int i11, List<Long> list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzabf.zzz(i11));
    }

    public static int zzn(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaco) {
            zzaco zzaco = (zzaco) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzabf.zzB(zzaco.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzabf.zzB(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzo(int i11, Object obj, zzadk zzadk) {
        if (!(obj instanceof zzacf)) {
            return zzabf.zzA(i11 << 3) + zzabf.zzx((zzacz) obj, zzadk);
        }
        int zzA = zzabf.zzA(i11 << 3);
        int zza2 = ((zzacf) obj).zza();
        return zzA + zzabf.zzA(zza2) + zza2;
    }

    public static int zzp(int i11, List<?> list, zzadk zzadk) {
        int i12;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzabf.zzz(i11) * size;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            if (obj instanceof zzacf) {
                i12 = zzabf.zzw((zzacf) obj);
            } else {
                i12 = zzabf.zzx((zzacz) obj, zzadk);
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
        return zzr(list) + (size * zzabf.zzz(i11));
    }

    public static int zzr(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzabt) {
            zzabt zzabt = (zzabt) list;
            i11 = 0;
            while (i12 < size) {
                int zzd2 = zzabt.zzd(i12);
                i11 += zzabf.zzA((zzd2 >> 31) ^ (zzd2 + zzd2));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = list.get(i12).intValue();
                i13 = i11 + zzabf.zzA((intValue >> 31) ^ (intValue + intValue));
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
        return zzt(list) + (size * zzabf.zzz(i11));
    }

    public static int zzt(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaco) {
            zzaco zzaco = (zzaco) list;
            i11 = 0;
            while (i12 < size) {
                long zzd2 = zzaco.zzd(i12);
                i11 += zzabf.zzB((zzd2 >> 63) ^ (zzd2 + zzd2));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = list.get(i12).longValue();
                i13 = i11 + zzabf.zzB((longValue >> 63) ^ (longValue + longValue));
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
        int zzz = zzabf.zzz(i11) * size;
        if (list instanceof zzach) {
            zzach zzach = (zzach) list;
            while (i14 < size) {
                Object zze = zzach.zze(i14);
                if (zze instanceof zzaax) {
                    i13 = zzabf.zzt((zzaax) zze);
                } else {
                    i13 = zzabf.zzy((String) zze);
                }
                zzz += i13;
                i14++;
            }
        } else {
            while (i14 < size) {
                Object obj = list.get(i14);
                if (obj instanceof zzaax) {
                    i12 = zzabf.zzt((zzaax) obj);
                } else {
                    i12 = zzabf.zzy((String) obj);
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
        return zzw(list) + (size * zzabf.zzz(i11));
    }

    public static int zzw(List<Integer> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzabt) {
            zzabt zzabt = (zzabt) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzabf.zzA(zzabt.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzabf.zzA(list.get(i12).intValue());
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
        return zzy(list) + (size * zzabf.zzz(i11));
    }

    public static int zzy(List<Long> list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzaco) {
            zzaco zzaco = (zzaco) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzabf.zzB(zzaco.zzd(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzabf.zzB(list.get(i12).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzaeb<?, ?> zzz() {
        return zzb;
    }
}
