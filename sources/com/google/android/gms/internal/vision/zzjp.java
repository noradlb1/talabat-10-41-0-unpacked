package com.google.android.gms.internal.vision;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzjp {
    private static final Logger logger = Logger.getLogger(zzjp.class.getName());
    private static final boolean zzaap;
    private static final boolean zzaaq;
    private static final zzd zzaar;
    private static final boolean zzaas = zzin();
    private static final long zzaat;
    private static final long zzaau;
    private static final long zzaav;
    private static final long zzaaw;
    private static final long zzaax;
    private static final long zzaay;
    private static final long zzaaz;
    private static final long zzaba;
    private static final long zzabb;
    private static final long zzabc;
    private static final long zzabd;
    private static final long zzabe;
    private static final long zzabf;
    private static final long zzabg;
    private static final int zzabh;
    static final boolean zzabi;
    private static final Class<?> zzrm = zzfa.zzds();
    private static final boolean zzsr = zzim();
    private static final Unsafe zzyt;

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            this.zzabl.putBoolean(obj, j11, z11);
        }

        public final void zze(Object obj, long j11, byte b11) {
            this.zzabl.putByte(obj, j11, b11);
        }

        public final boolean zzm(Object obj, long j11) {
            return this.zzabl.getBoolean(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return this.zzabl.getFloat(obj, j11);
        }

        public final double zzo(Object obj, long j11) {
            return this.zzabl.getDouble(obj, j11);
        }

        public final byte zzy(Object obj, long j11) {
            return this.zzabl.getByte(obj, j11);
        }

        public final void zza(Object obj, long j11, float f11) {
            this.zzabl.putFloat(obj, j11, f11);
        }

        public final void zza(Object obj, long j11, double d11) {
            this.zzabl.putDouble(obj, j11, d11);
        }
    }

    public static abstract class zzd {
        Unsafe zzabl;

        public zzd(Unsafe unsafe) {
            this.zzabl = unsafe;
        }

        public abstract void zza(Object obj, long j11, double d11);

        public abstract void zza(Object obj, long j11, float f11);

        public final void zza(Object obj, long j11, long j12) {
            this.zzabl.putLong(obj, j11, j12);
        }

        public abstract void zza(Object obj, long j11, boolean z11);

        public final void zzb(Object obj, long j11, int i11) {
            this.zzabl.putInt(obj, j11, i11);
        }

        public abstract void zze(Object obj, long j11, byte b11);

        public final int zzk(Object obj, long j11) {
            return this.zzabl.getInt(obj, j11);
        }

        public final long zzl(Object obj, long j11) {
            return this.zzabl.getLong(obj, j11);
        }

        public abstract boolean zzm(Object obj, long j11);

        public abstract float zzn(Object obj, long j11);

        public abstract double zzo(Object obj, long j11);

        public abstract byte zzy(Object obj, long j11);
    }

    static {
        long j11;
        boolean z11;
        Unsafe zzil = zzil();
        zzyt = zzil;
        boolean zzk = zzk(Long.TYPE);
        zzaap = zzk;
        boolean zzk2 = zzk(Integer.TYPE);
        zzaaq = zzk2;
        zzd zzd2 = null;
        if (zzil != null) {
            if (!zzfa.zzdr()) {
                zzd2 = new zzb(zzil);
            } else if (zzk) {
                zzd2 = new zzc(zzil);
            } else if (zzk2) {
                zzd2 = new zza(zzil);
            }
        }
        zzaar = zzd2;
        long zzi = (long) zzi(byte[].class);
        zzaat = zzi;
        Class<boolean[]> cls = boolean[].class;
        zzaau = (long) zzi(cls);
        zzaav = (long) zzj(cls);
        Class<int[]> cls2 = int[].class;
        zzaaw = (long) zzi(cls2);
        zzaax = (long) zzj(cls2);
        Class<long[]> cls3 = long[].class;
        zzaay = (long) zzi(cls3);
        zzaaz = (long) zzj(cls3);
        Class<float[]> cls4 = float[].class;
        zzaba = (long) zzi(cls4);
        zzabb = (long) zzj(cls4);
        Class<double[]> cls5 = double[].class;
        zzabc = (long) zzi(cls5);
        zzabd = (long) zzj(cls5);
        Class<Object[]> cls6 = Object[].class;
        zzabe = (long) zzi(cls6);
        zzabf = (long) zzj(cls6);
        Field zzio = zzio();
        if (zzio == null || zzd2 == null) {
            j11 = -1;
        } else {
            j11 = zzd2.zzabl.objectFieldOffset(zzio);
        }
        zzabg = j11;
        zzabh = (int) (zzi & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzabi = z11;
    }

    private zzjp() {
    }

    public static void zza(Object obj, long j11, long j12) {
        zzaar.zza(obj, j11, j12);
    }

    public static void zzb(Object obj, long j11, int i11) {
        zzaar.zzb(obj, j11, i11);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j11, boolean z11) {
        zzb(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static <T> T zzh(Class<T> cls) {
        try {
            return zzyt.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzsr) {
            return zzaar.zzabl.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static boolean zzij() {
        return zzsr;
    }

    public static boolean zzik() {
        return zzaas;
    }

    public static Unsafe zzil() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzjr());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzim() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = zzyt;
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
            if (zzfa.zzdr()) {
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

    private static boolean zzin() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzyt;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (zzio() == null) {
                return false;
            }
            if (zzfa.zzdr()) {
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

    private static Field zzio() {
        Field zzb2;
        Class<Buffer> cls = Buffer.class;
        if (zzfa.zzdr() && (zzb2 = zzb(cls, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(cls, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzj(Class<?> cls) {
        if (zzsr) {
            return zzaar.zzabl.arrayIndexScale(cls);
        }
        return -1;
    }

    public static int zzk(Object obj, long j11) {
        return zzaar.zzk(obj, j11);
    }

    public static long zzl(Object obj, long j11) {
        return zzaar.zzl(obj, j11);
    }

    public static boolean zzm(Object obj, long j11) {
        return zzaar.zzm(obj, j11);
    }

    public static float zzn(Object obj, long j11) {
        return zzaar.zzn(obj, j11);
    }

    public static double zzo(Object obj, long j11) {
        return zzaar.zzo(obj, j11);
    }

    public static Object zzp(Object obj, long j11) {
        return zzaar.zzabl.getObject(obj, j11);
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

    public static void zza(Object obj, long j11, boolean z11) {
        zzaar.zza(obj, j11, z11);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzk(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzfa.zzdr()) {
            return false;
        }
        try {
            Class<?> cls3 = zzrm;
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

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            if (zzjp.zzabi) {
                zzjp.zzb(obj, j11, z11);
            } else {
                zzjp.zzc(obj, j11, z11);
            }
        }

        public final void zze(Object obj, long j11, byte b11) {
            if (zzjp.zzabi) {
                zzjp.zza(obj, j11, b11);
            } else {
                zzjp.zzb(obj, j11, b11);
            }
        }

        public final boolean zzm(Object obj, long j11) {
            if (zzjp.zzabi) {
                return zzjp.zzs(obj, j11);
            }
            return zzjp.zzt(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return Float.intBitsToFloat(zzk(obj, j11));
        }

        public final double zzo(Object obj, long j11) {
            return Double.longBitsToDouble(zzl(obj, j11));
        }

        public final byte zzy(Object obj, long j11) {
            if (zzjp.zzabi) {
                return zzjp.zzq(obj, j11);
            }
            return zzjp.zzr(obj, j11);
        }

        public final void zza(Object obj, long j11, float f11) {
            zzb(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            if (zzjp.zzabi) {
                zzjp.zzb(obj, j11, z11);
            } else {
                zzjp.zzc(obj, j11, z11);
            }
        }

        public final void zze(Object obj, long j11, byte b11) {
            if (zzjp.zzabi) {
                zzjp.zza(obj, j11, b11);
            } else {
                zzjp.zzb(obj, j11, b11);
            }
        }

        public final boolean zzm(Object obj, long j11) {
            if (zzjp.zzabi) {
                return zzjp.zzs(obj, j11);
            }
            return zzjp.zzt(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return Float.intBitsToFloat(zzk(obj, j11));
        }

        public final double zzo(Object obj, long j11) {
            return Double.longBitsToDouble(zzl(obj, j11));
        }

        public final byte zzy(Object obj, long j11) {
            if (zzjp.zzabi) {
                return zzjp.zzq(obj, j11);
            }
            return zzjp.zzr(obj, j11);
        }

        public final void zza(Object obj, long j11, float f11) {
            zzb(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }
    }

    public static void zza(Object obj, long j11, float f11) {
        zzaar.zza(obj, j11, f11);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        zzb(obj, j12, ((255 & b11) << i11) | (zzk(obj, j12) & (~(255 << i11))));
    }

    public static void zza(Object obj, long j11, double d11) {
        zzaar.zza(obj, j11, d11);
    }

    public static void zza(Object obj, long j11, Object obj2) {
        zzaar.zzabl.putObject(obj, j11, obj2);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, boolean z11) {
        zza(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static byte zza(byte[] bArr, long j11) {
        return zzaar.zzy(bArr, zzaat + j11);
    }

    public static void zza(byte[] bArr, long j11, byte b11) {
        zzaar.zze(bArr, zzaat + j11, b11);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int zzk = zzk(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zzb(obj, j12, ((255 & b11) << i11) | (zzk & (~(255 << i11))));
    }
}
