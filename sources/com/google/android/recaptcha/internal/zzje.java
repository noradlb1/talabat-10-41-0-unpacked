package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzje {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzjw zzc;
    private static final zzjw zzd = new zzjy();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzjw zzjw = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzjw = (zzjw) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzjw;
    }

    public static Object zzA(Object obj, int i11, List list, zzhj zzhj, Object obj2, zzjw zzjw) {
        if (zzhj == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = ((Integer) list.get(i13)).intValue();
                if (zzhj.zza(intValue)) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    obj2 = zzB(obj, i11, intValue, obj2, zzjw);
                }
            }
            if (i12 != size) {
                list.subList(i12, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzhj.zza(intValue2)) {
                    obj2 = zzB(obj, i11, intValue2, obj2, zzjw);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static Object zzB(Object obj, int i11, int i12, Object obj2, zzjw zzjw) {
        if (obj2 == null) {
            obj2 = zzjw.zzc(obj);
        }
        zzjw.zzl(obj2, i11, (long) i12);
        return obj2;
    }

    public static void zzC(zzgr zzgr, Object obj, Object obj2) {
        zzgv zzb2 = zzgr.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzgr.zzc(obj).zzh(zzb2);
        }
    }

    public static void zzD(zzjw zzjw, Object obj, Object obj2) {
        zzjw.zzo(obj, zzjw.zze(zzjw.zzd(obj), zzjw.zzd(obj2)));
    }

    public static void zzE(Class cls) {
        Class cls2;
        if (!zzhf.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzF(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzc(i11, list, z11);
        }
    }

    public static void zzG(int i11, List list, zzko zzko) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zze(i11, list);
        }
    }

    public static void zzH(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzg(i11, list, z11);
        }
    }

    public static void zzI(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzj(i11, list, z11);
        }
    }

    public static void zzJ(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzl(i11, list, z11);
        }
    }

    public static void zzK(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzn(i11, list, z11);
        }
    }

    public static void zzL(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzp(i11, list, z11);
        }
    }

    public static void zzM(int i11, List list, zzko zzko, zzjc zzjc) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((zzfu) zzko).zzq(i11, list.get(i12), zzjc);
            }
        }
    }

    public static void zzN(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzs(i11, list, z11);
        }
    }

    public static void zzO(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzu(i11, list, z11);
        }
    }

    public static void zzP(int i11, List list, zzko zzko, zzjc zzjc) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i12 = 0; i12 < list.size(); i12++) {
                ((zzfu) zzko).zzv(i11, list.get(i12), zzjc);
            }
        }
    }

    public static void zzQ(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzy(i11, list, z11);
        }
    }

    public static void zzR(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzA(i11, list, z11);
        }
    }

    public static void zzS(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzC(i11, list, z11);
        }
    }

    public static void zzT(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzE(i11, list, z11);
        }
    }

    public static void zzU(int i11, List list, zzko zzko) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzH(i11, list);
        }
    }

    public static void zzV(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzJ(i11, list, z11);
        }
    }

    public static void zzW(int i11, List list, zzko zzko, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzko.zzL(i11, list, z11);
        }
    }

    public static boolean zzX(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static int zza(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzft.zzy(i11 << 3) + 1);
    }

    public static int zzb(int i11, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = size * zzft.zzy(i11 << 3);
        for (int i12 = 0; i12 < list.size(); i12++) {
            int zzd2 = ((zzfi) list.get(i12)).zzd();
            zzy += zzft.zzy(zzd2) + zzd2;
        }
        return zzy;
    }

    public static int zzc(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzft.zzy(i11 << 3));
    }

    public static int zzd(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzft.zzu(zzhg.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzft.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zze(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzft.zzy(i11 << 3) + 4);
    }

    public static int zzf(List list) {
        return list.size() * 4;
    }

    public static int zzg(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzft.zzy(i11 << 3) + 8);
    }

    public static int zzh(List list) {
        return list.size() * 8;
    }

    public static int zzi(int i11, List list, zzjc zzjc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += zzft.zzt(i11, (zzip) list.get(i13), zzjc);
        }
        return i12;
    }

    public static int zzj(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzk(list) + (size * zzft.zzy(i11 << 3));
    }

    public static int zzk(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzft.zzu(zzhg.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzft.zzu(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzl(int i11, List list, boolean z11) {
        if (list.size() == 0) {
            return 0;
        }
        return zzm(list) + (list.size() * zzft.zzy(i11 << 3));
    }

    public static int zzm(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzft.zzz(zzie.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzft.zzz(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzn(int i11, Object obj, zzjc zzjc) {
        if (obj instanceof zzhv) {
            int i12 = zzft.zzb;
            int zza2 = ((zzhv) obj).zza();
            return zzft.zzy(i11 << 3) + zzft.zzy(zza2) + zza2;
        }
        return zzft.zzy(i11 << 3) + zzft.zzw((zzip) obj, zzjc);
    }

    public static int zzo(int i11, List list, zzjc zzjc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzy = zzft.zzy(i11 << 3) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof zzhv) {
                int zza2 = ((zzhv) obj).zza();
                zzy += zzft.zzy(zza2) + zza2;
            } else {
                zzy += zzft.zzw((zzip) obj, zzjc);
            }
        }
        return zzy;
    }

    public static int zzp(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzq(list) + (size * zzft.zzy(i11 << 3));
    }

    public static int zzq(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zzhg.zze(i12);
                i11 += zzft.zzy((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = ((Integer) list.get(i12)).intValue();
                i13 = i11 + zzft.zzy((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzr(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzft.zzy(i11 << 3));
    }

    public static int zzs(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            i11 = 0;
            while (i12 < size) {
                long zze = zzie.zze(i12);
                i11 += zzft.zzz((zze >> 63) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = ((Long) list.get(i12)).longValue();
                i13 = i11 + zzft.zzz((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzt(int i11, List list) {
        int zzx;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z11 = list instanceof zzhx;
        int zzy = zzft.zzy(i11 << 3) * size;
        if (z11) {
            zzhx zzhx = (zzhx) list;
            while (i12 < size) {
                Object zzf = zzhx.zzf(i12);
                if (zzf instanceof zzfi) {
                    int zzd2 = ((zzfi) zzf).zzd();
                    zzy += zzft.zzy(zzd2) + zzd2;
                } else {
                    zzy += zzft.zzx((String) zzf);
                }
                i12++;
            }
        } else {
            while (i12 < size) {
                Object obj = list.get(i12);
                if (obj instanceof zzfi) {
                    int zzd3 = ((zzfi) obj).zzd();
                    zzx = zzy + zzft.zzy(zzd3) + zzd3;
                } else {
                    zzx = zzy + zzft.zzx((String) obj);
                }
                i12++;
            }
        }
        return zzy;
    }

    public static int zzu(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzft.zzy(i11 << 3));
    }

    public static int zzv(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhg) {
            zzhg zzhg = (zzhg) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzft.zzy(zzhg.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzft.zzy(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzw(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzx(list) + (size * zzft.zzy(i11 << 3));
    }

    public static int zzx(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzie) {
            zzie zzie = (zzie) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzft.zzz(zzie.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzft.zzz(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzjw zzy() {
        return zzc;
    }

    public static zzjw zzz() {
        return zzd;
    }
}
