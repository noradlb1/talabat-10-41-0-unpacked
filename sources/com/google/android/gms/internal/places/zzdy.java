package com.google.android.gms.internal.places;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzdy {
    private static final Logger logger = Logger.getLogger(zzdy.class.getName());
    private static final Class<?> zzdw = zzp.zzz();
    private static final boolean zzer = zzdo();
    private static final Unsafe zzkr;
    private static final boolean zzmn;
    private static final boolean zzmo;
    private static final zzd zzmp;
    private static final boolean zzmq = zzdp();
    private static final long zzmr;
    private static final long zzms;
    private static final long zzmt;
    private static final long zzmu;
    private static final long zzmv;
    private static final long zzmw;
    private static final long zzmx;
    private static final long zzmy;
    private static final long zzmz;
    private static final long zzna;
    private static final long zznb;
    private static final long zznc;
    private static final long zznd;
    private static final long zzne;
    private static final int zznf;
    static final boolean zzng;

    public static abstract class zzd {
        Unsafe zznh;

        public zzd(Unsafe unsafe) {
            this.zznh = unsafe;
        }

        public abstract void zzb(Object obj, long j11, double d11);

        public abstract void zzb(Object obj, long j11, float f11);

        public final void zzb(Object obj, long j11, int i11) {
            this.zznh.putInt(obj, j11, i11);
        }

        public abstract void zzb(Object obj, long j11, boolean z11);

        public abstract void zzf(Object obj, long j11, byte b11);

        public final int zzk(Object obj, long j11) {
            return this.zznh.getInt(obj, j11);
        }

        public final long zzl(Object obj, long j11) {
            return this.zznh.getLong(obj, j11);
        }

        public abstract boolean zzm(Object obj, long j11);

        public abstract float zzn(Object obj, long j11);

        public abstract double zzo(Object obj, long j11);

        public abstract byte zzy(Object obj, long j11);

        public final void zzb(Object obj, long j11, long j12) {
            this.zznh.putLong(obj, j11, j12);
        }
    }

    public static final class zze extends zzd {
        public zze(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zzb(Object obj, long j11, boolean z11) {
            this.zznh.putBoolean(obj, j11, z11);
        }

        public final void zzf(Object obj, long j11, byte b11) {
            this.zznh.putByte(obj, j11, b11);
        }

        public final boolean zzm(Object obj, long j11) {
            return this.zznh.getBoolean(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return this.zznh.getFloat(obj, j11);
        }

        public final double zzo(Object obj, long j11) {
            return this.zznh.getDouble(obj, j11);
        }

        public final byte zzy(Object obj, long j11) {
            return this.zznh.getByte(obj, j11);
        }

        public final void zzb(Object obj, long j11, float f11) {
            this.zznh.putFloat(obj, j11, f11);
        }

        public final void zzb(Object obj, long j11, double d11) {
            this.zznh.putDouble(obj, j11, d11);
        }
    }

    static {
        long j11;
        boolean z11;
        Unsafe zzdn = zzdn();
        zzkr = zzdn;
        boolean zzk = zzk(Long.TYPE);
        zzmn = zzk;
        boolean zzk2 = zzk(Integer.TYPE);
        zzmo = zzk2;
        zzd zzd2 = null;
        if (zzdn != null) {
            if (!zzp.zzy()) {
                zzd2 = new zze(zzdn);
            } else if (zzk) {
                zzd2 = new zzb(zzdn);
            } else if (zzk2) {
                zzd2 = new zzc(zzdn);
            }
        }
        zzmp = zzd2;
        long zzi = (long) zzi(byte[].class);
        zzmr = zzi;
        Class<boolean[]> cls = boolean[].class;
        zzms = (long) zzi(cls);
        zzmt = (long) zzj(cls);
        Class<int[]> cls2 = int[].class;
        zzmu = (long) zzi(cls2);
        zzmv = (long) zzj(cls2);
        Class<long[]> cls3 = long[].class;
        zzmw = (long) zzi(cls3);
        zzmx = (long) zzj(cls3);
        Class<float[]> cls4 = float[].class;
        zzmy = (long) zzi(cls4);
        zzmz = (long) zzj(cls4);
        Class<double[]> cls5 = double[].class;
        zzna = (long) zzi(cls5);
        zznb = (long) zzj(cls5);
        Class<Object[]> cls6 = Object[].class;
        zznc = (long) zzi(cls6);
        zznd = (long) zzj(cls6);
        Field zzdq = zzdq();
        if (zzdq == null || zzd2 == null) {
            j11 = -1;
        } else {
            j11 = zzd2.zznh.objectFieldOffset(zzdq);
        }
        zzne = j11;
        zznf = (int) (zzi & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzng = z11;
    }

    private zzdy() {
    }

    public static void zzb(Object obj, long j11, int i11) {
        zzmp.zzb(obj, j11, i11);
    }

    private static Field zzc(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzd(Object obj, long j11, boolean z11) {
        zzc(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static boolean zzdl() {
        return zzer;
    }

    public static boolean zzdm() {
        return zzmq;
    }

    public static Unsafe zzdn() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzdx());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzdo() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = zzkr;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls3 = unsafe.getClass();
            cls3.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls3.getMethod("arrayBaseOffset", new Class[]{cls});
            cls3.getMethod("arrayIndexScale", new Class[]{cls});
            Class cls4 = Long.TYPE;
            cls3.getMethod("getInt", new Class[]{cls2, cls4});
            cls3.getMethod("putInt", new Class[]{cls2, cls4, Integer.TYPE});
            cls3.getMethod("getLong", new Class[]{cls2, cls4});
            cls3.getMethod("putLong", new Class[]{cls2, cls4, cls4});
            cls3.getMethod("getObject", new Class[]{cls2, cls4});
            cls3.getMethod("putObject", new Class[]{cls2, cls4, cls2});
            if (zzp.zzy()) {
                return true;
            }
            cls3.getMethod("getByte", new Class[]{cls2, cls4});
            cls3.getMethod("putByte", new Class[]{cls2, cls4, Byte.TYPE});
            cls3.getMethod("getBoolean", new Class[]{cls2, cls4});
            cls3.getMethod("putBoolean", new Class[]{cls2, cls4, Boolean.TYPE});
            cls3.getMethod("getFloat", new Class[]{cls2, cls4});
            cls3.getMethod("putFloat", new Class[]{cls2, cls4, Float.TYPE});
            cls3.getMethod("getDouble", new Class[]{cls2, cls4});
            cls3.getMethod("putDouble", new Class[]{cls2, cls4, Double.TYPE});
            return true;
        } catch (Throwable th2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
            return false;
        }
    }

    private static boolean zzdp() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzkr;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (zzdq() == null) {
                return false;
            }
            if (zzp.zzy()) {
                return true;
            }
            cls2.getMethod("getByte", new Class[]{cls3});
            cls2.getMethod("putByte", new Class[]{cls3, Byte.TYPE});
            cls2.getMethod("getInt", new Class[]{cls3});
            cls2.getMethod("putInt", new Class[]{cls3, Integer.TYPE});
            cls2.getMethod("getLong", new Class[]{cls3});
            cls2.getMethod("putLong", new Class[]{cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls3, cls3, cls3});
            cls2.getMethod("copyMemory", new Class[]{cls, cls3, cls, cls3, cls3});
            return true;
        } catch (Throwable th2) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th2);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb2.toString());
            return false;
        }
    }

    private static Field zzdq() {
        Field zzc2;
        Class<Buffer> cls = Buffer.class;
        if (zzp.zzy() && (zzc2 = zzc(cls, "effectiveDirectAddress")) != null) {
            return zzc2;
        }
        Field zzc3 = zzc(cls, "address");
        if (zzc3 == null || zzc3.getType() != Long.TYPE) {
            return null;
        }
        return zzc3;
    }

    public static <T> T zzh(Class<T> cls) {
        try {
            return zzkr.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzer) {
            return zzmp.zznh.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzer) {
            return zzmp.zznh.arrayIndexScale(cls);
        }
        return -1;
    }

    public static int zzk(Object obj, long j11) {
        return zzmp.zzk(obj, j11);
    }

    public static long zzl(Object obj, long j11) {
        return zzmp.zzl(obj, j11);
    }

    public static boolean zzm(Object obj, long j11) {
        return zzmp.zzm(obj, j11);
    }

    public static float zzn(Object obj, long j11) {
        return zzmp.zzn(obj, j11);
    }

    public static double zzo(Object obj, long j11) {
        return zzmp.zzo(obj, j11);
    }

    public static Object zzp(Object obj, long j11) {
        return zzmp.zznh.getObject(obj, j11);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j11) {
        return (byte) (zzk(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j11) {
        return (byte) (zzk(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j11) {
        return zzq(obj, j11) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j11) {
        return zzr(obj, j11) != 0;
    }

    public static void zzb(Object obj, long j11, long j12) {
        zzmp.zzb(obj, j11, j12);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        zzb(obj, j12, ((255 & b11) << i11) | (zzk(obj, j12) & (~(255 << i11))));
    }

    private static boolean zzk(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzp.zzy()) {
            return false;
        }
        try {
            Class<?> cls3 = zzdw;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zzb(Object obj, long j11, boolean z11) {
            if (zzdy.zzng) {
                zzdy.zzc(obj, j11, z11);
            } else {
                zzdy.zzd(obj, j11, z11);
            }
        }

        public final void zzf(Object obj, long j11, byte b11) {
            if (zzdy.zzng) {
                zzdy.zzb(obj, j11, b11);
            } else {
                zzdy.zzc(obj, j11, b11);
            }
        }

        public final boolean zzm(Object obj, long j11) {
            if (zzdy.zzng) {
                return zzdy.zzs(obj, j11);
            }
            return zzdy.zzt(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return Float.intBitsToFloat(zzk(obj, j11));
        }

        public final double zzo(Object obj, long j11) {
            return Double.longBitsToDouble(zzl(obj, j11));
        }

        public final byte zzy(Object obj, long j11) {
            if (zzdy.zzng) {
                return zzdy.zzq(obj, j11);
            }
            return zzdy.zzr(obj, j11);
        }

        public final void zzb(Object obj, long j11, float f11) {
            zzb(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zzb(Object obj, long j11, double d11) {
            zzb(obj, j11, Double.doubleToLongBits(d11));
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zzb(Object obj, long j11, boolean z11) {
            if (zzdy.zzng) {
                zzdy.zzc(obj, j11, z11);
            } else {
                zzdy.zzd(obj, j11, z11);
            }
        }

        public final void zzf(Object obj, long j11, byte b11) {
            if (zzdy.zzng) {
                zzdy.zzb(obj, j11, b11);
            } else {
                zzdy.zzc(obj, j11, b11);
            }
        }

        public final boolean zzm(Object obj, long j11) {
            if (zzdy.zzng) {
                return zzdy.zzs(obj, j11);
            }
            return zzdy.zzt(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return Float.intBitsToFloat(zzk(obj, j11));
        }

        public final double zzo(Object obj, long j11) {
            return Double.longBitsToDouble(zzl(obj, j11));
        }

        public final byte zzy(Object obj, long j11) {
            if (zzdy.zzng) {
                return zzdy.zzq(obj, j11);
            }
            return zzdy.zzr(obj, j11);
        }

        public final void zzb(Object obj, long j11, float f11) {
            zzb(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zzb(Object obj, long j11, double d11) {
            zzb(obj, j11, Double.doubleToLongBits(d11));
        }
    }

    public static void zzb(Object obj, long j11, boolean z11) {
        zzmp.zzb(obj, j11, z11);
    }

    public static void zzb(Object obj, long j11, float f11) {
        zzmp.zzb(obj, j11, f11);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j11, boolean z11) {
        zzb(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static void zzb(Object obj, long j11, double d11) {
        zzmp.zzb(obj, j11, d11);
    }

    public static void zzb(Object obj, long j11, Object obj2) {
        zzmp.zznh.putObject(obj, j11, obj2);
    }

    public static byte zzb(byte[] bArr, long j11) {
        return zzmp.zzy(bArr, zzmr + j11);
    }

    public static void zzb(byte[] bArr, long j11, byte b11) {
        zzmp.zzf(bArr, zzmr + j11, b11);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int zzk = zzk(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zzb(obj, j12, ((255 & b11) << i11) | (zzk & (~(255 << i11))));
    }
}
