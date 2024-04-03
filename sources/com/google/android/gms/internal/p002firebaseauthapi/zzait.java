package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzait  reason: invalid package */
final class zzait {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzajl zzc;
    private static final zzajl zzd = new zzajn();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzajl zzajl = null;
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
                zzajl = (zzajl) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzajl;
    }

    public static void zzA(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzu(i11, list, z11);
        }
    }

    public static void zzB(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzx(i11, list, z11);
        }
    }

    public static void zzC(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzz(i11, list, z11);
        }
    }

    public static void zzD(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzB(i11, list, z11);
        }
    }

    public static void zzE(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzD(i11, list, z11);
        }
    }

    public static void zzF(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzI(i11, list, z11);
        }
    }

    public static void zzG(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzK(i11, list, z11);
        }
    }

    public static int zza(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzagi.zzx(zzahb.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzagi.zzx(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzb(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzagi.zzA(i11 << 3) + 4);
    }

    public static int zzc(List list) {
        return list.size() * 4;
    }

    public static int zzd(int i11, List list, boolean z11) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzagi.zzA(i11 << 3) + 8);
    }

    public static int zze(List list) {
        return list.size() * 8;
    }

    public static int zzf(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzagi.zzx(zzahb.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzagi.zzx(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzg(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzagi.zzB(zzahu.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzagi.zzB(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzh(int i11, Object obj, zzair zzair) {
        if (obj instanceof zzahl) {
            int i12 = zzagi.zzf;
            int zza2 = ((zzahl) obj).zza();
            return zzagi.zzA(i11 << 3) + zzagi.zzA(zza2) + zza2;
        }
        return zzagi.zzA(i11 << 3) + zzagi.zzy((zzaif) obj, zzair);
    }

    public static int zzi(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            i11 = 0;
            while (i12 < size) {
                int zze = zzahb.zze(i12);
                i11 += zzagi.zzA((zze >> 31) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                int intValue = ((Integer) list.get(i12)).intValue();
                i13 = i11 + zzagi.zzA((intValue >> 31) ^ (intValue + intValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzj(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            i11 = 0;
            while (i12 < size) {
                long zze = zzahu.zze(i12);
                i11 += zzagi.zzB((zze >> 63) ^ (zze + zze));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                long longValue = ((Long) list.get(i12)).longValue();
                i13 = i11 + zzagi.zzB((longValue >> 63) ^ (longValue + longValue));
                i12++;
            }
        }
        return i11;
    }

    public static int zzk(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahb) {
            zzahb zzahb = (zzahb) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzagi.zzA(zzahb.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzagi.zzA(((Integer) list.get(i12)).intValue());
                i12++;
            }
        }
        return i11;
    }

    public static int zzl(List list) {
        int i11;
        int size = list.size();
        int i12 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzahu) {
            zzahu zzahu = (zzahu) list;
            i11 = 0;
            while (i12 < size) {
                i11 += zzagi.zzB(zzahu.zze(i12));
                i12++;
            }
        } else {
            int i13 = 0;
            while (i12 < size) {
                i13 = i11 + zzagi.zzB(((Long) list.get(i12)).longValue());
                i12++;
            }
        }
        return i11;
    }

    public static zzajl zzm() {
        return zzc;
    }

    public static zzajl zzn() {
        return zzd;
    }

    public static Object zzo(Object obj, int i11, List list, zzahe zzahe, Object obj2, zzajl zzajl) {
        if (zzahe == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                int intValue = ((Integer) list.get(i13)).intValue();
                if (zzahe.zza()) {
                    if (i13 != i12) {
                        list.set(i12, Integer.valueOf(intValue));
                    }
                    i12++;
                } else {
                    obj2 = zzp(obj, i11, intValue, obj2, zzajl);
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
                if (!zzahe.zza()) {
                    obj2 = zzp(obj, i11, intValue2, obj2, zzajl);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static Object zzp(Object obj, int i11, int i12, Object obj2, zzajl zzajl) {
        if (obj2 == null) {
            obj2 = zzajl.zzc(obj);
        }
        zzajl.zzl(obj2, i11, (long) i12);
        return obj2;
    }

    public static void zzq(zzajl zzajl, Object obj, Object obj2) {
        zzajl.zzo(obj, zzajl.zze(zzajl.zzd(obj), zzajl.zzd(obj2)));
    }

    public static void zzr(Class cls) {
        Class cls2;
        if (!zzaha.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzs(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static void zzt(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzc(i11, list, z11);
        }
    }

    public static void zzu(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzg(i11, list, z11);
        }
    }

    public static void zzv(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzj(i11, list, z11);
        }
    }

    public static void zzw(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzl(i11, list, z11);
        }
    }

    public static void zzx(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzn(i11, list, z11);
        }
    }

    public static void zzy(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzp(i11, list, z11);
        }
    }

    public static void zzz(int i11, List list, zzagj zzagj, boolean z11) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzagj.zzs(i11, list, z11);
        }
    }
}
