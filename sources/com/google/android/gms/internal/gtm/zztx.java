package com.google.android.gms.internal.gtm;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zztx {
    private static final Logger logger = Logger.getLogger(zztx.class.getName());
    private static final Class<?> zzavt = zzpp.zznb();
    private static final boolean zzawt = zzrp();
    private static final Unsafe zzbcx;
    private static final boolean zzbet;
    private static final boolean zzbeu;
    private static final zzd zzbev;
    private static final boolean zzbew = zzrq();
    static final long zzbex;
    private static final long zzbey;
    private static final long zzbez;
    private static final long zzbfa;
    private static final long zzbfb;
    private static final long zzbfc;
    private static final long zzbfd;
    private static final long zzbfe;
    private static final long zzbff;
    private static final long zzbfg;
    private static final long zzbfh;
    private static final long zzbfi;
    private static final long zzbfj;
    private static final long zzbfk;
    private static final int zzbfl;
    static final boolean zzbfm;

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j11, byte b11) {
            Memory.pokeByte((int) (j11 & -1), b11);
        }

        public final void zze(Object obj, long j11, byte b11) {
            if (zztx.zzbfm) {
                zztx.zza(obj, j11, b11);
            } else {
                zztx.zzb(obj, j11, b11);
            }
        }

        public final boolean zzm(Object obj, long j11) {
            if (zztx.zzbfm) {
                return zztx.zzs(obj, j11);
            }
            return zztx.zzt(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return Float.intBitsToFloat(zzk(obj, j11));
        }

        public final double zzo(Object obj, long j11) {
            return Double.longBitsToDouble(zzl(obj, j11));
        }

        public final byte zzy(Object obj, long j11) {
            if (zztx.zzbfm) {
                return zztx.zzq(obj, j11);
            }
            return zztx.zzr(obj, j11);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            if (zztx.zzbfm) {
                zztx.zzb(obj, j11, z11);
            } else {
                zztx.zzc(obj, j11, z11);
            }
        }

        public final void zza(Object obj, long j11, float f11) {
            zzb(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }

        public final void zza(byte[] bArr, long j11, long j12, long j13) {
            Memory.pokeByteArray((int) (j12 & -1), bArr, (int) j11, (int) j13);
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j11, byte b11) {
            Memory.pokeByte(j11, b11);
        }

        public final void zze(Object obj, long j11, byte b11) {
            if (zztx.zzbfm) {
                zztx.zza(obj, j11, b11);
            } else {
                zztx.zzb(obj, j11, b11);
            }
        }

        public final boolean zzm(Object obj, long j11) {
            if (zztx.zzbfm) {
                return zztx.zzs(obj, j11);
            }
            return zztx.zzt(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return Float.intBitsToFloat(zzk(obj, j11));
        }

        public final double zzo(Object obj, long j11) {
            return Double.longBitsToDouble(zzl(obj, j11));
        }

        public final byte zzy(Object obj, long j11) {
            if (zztx.zzbfm) {
                return zztx.zzq(obj, j11);
            }
            return zztx.zzr(obj, j11);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            if (zztx.zzbfm) {
                zztx.zzb(obj, j11, z11);
            } else {
                zztx.zzc(obj, j11, z11);
            }
        }

        public final void zza(Object obj, long j11, float f11) {
            zzb(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }

        public final void zza(byte[] bArr, long j11, long j12, long j13) {
            Memory.pokeByteArray(j12, bArr, (int) j11, (int) j13);
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j11, byte b11) {
            this.zzbfn.putByte(j11, b11);
        }

        public final void zze(Object obj, long j11, byte b11) {
            this.zzbfn.putByte(obj, j11, b11);
        }

        public final boolean zzm(Object obj, long j11) {
            return this.zzbfn.getBoolean(obj, j11);
        }

        public final float zzn(Object obj, long j11) {
            return this.zzbfn.getFloat(obj, j11);
        }

        public final double zzo(Object obj, long j11) {
            return this.zzbfn.getDouble(obj, j11);
        }

        public final byte zzy(Object obj, long j11) {
            return this.zzbfn.getByte(obj, j11);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            this.zzbfn.putBoolean(obj, j11, z11);
        }

        public final void zza(Object obj, long j11, float f11) {
            this.zzbfn.putFloat(obj, j11, f11);
        }

        public final void zza(Object obj, long j11, double d11) {
            this.zzbfn.putDouble(obj, j11, d11);
        }

        public final void zza(byte[] bArr, long j11, long j12, long j13) {
            this.zzbfn.copyMemory(bArr, zztx.zzbex + j11, (Object) null, j12, j13);
        }
    }

    public static abstract class zzd {
        Unsafe zzbfn;

        public zzd(Unsafe unsafe) {
            this.zzbfn = unsafe;
        }

        public abstract void zza(long j11, byte b11);

        public abstract void zza(Object obj, long j11, double d11);

        public abstract void zza(Object obj, long j11, float f11);

        public final void zza(Object obj, long j11, long j12) {
            this.zzbfn.putLong(obj, j11, j12);
        }

        public abstract void zza(Object obj, long j11, boolean z11);

        public abstract void zza(byte[] bArr, long j11, long j12, long j13);

        public final void zzb(Object obj, long j11, int i11) {
            this.zzbfn.putInt(obj, j11, i11);
        }

        public abstract void zze(Object obj, long j11, byte b11);

        public final int zzk(Object obj, long j11) {
            return this.zzbfn.getInt(obj, j11);
        }

        public final long zzl(Object obj, long j11) {
            return this.zzbfn.getLong(obj, j11);
        }

        public abstract boolean zzm(Object obj, long j11);

        public abstract float zzn(Object obj, long j11);

        public abstract double zzo(Object obj, long j11);

        public abstract byte zzy(Object obj, long j11);
    }

    static {
        long j11;
        boolean z11;
        Unsafe zzro = zzro();
        zzbcx = zzro;
        boolean zzn = zzn(Long.TYPE);
        zzbet = zzn;
        boolean zzn2 = zzn(Integer.TYPE);
        zzbeu = zzn2;
        zzd zzd2 = null;
        if (zzro != null) {
            if (!zzpp.zzna()) {
                zzd2 = new zzc(zzro);
            } else if (zzn) {
                zzd2 = new zzb(zzro);
            } else if (zzn2) {
                zzd2 = new zza(zzro);
            }
        }
        zzbev = zzd2;
        long zzl = (long) zzl(byte[].class);
        zzbex = zzl;
        Class<boolean[]> cls = boolean[].class;
        zzbey = (long) zzl(cls);
        zzbez = (long) zzm(cls);
        Class<int[]> cls2 = int[].class;
        zzbfa = (long) zzl(cls2);
        zzbfb = (long) zzm(cls2);
        Class<long[]> cls3 = long[].class;
        zzbfc = (long) zzl(cls3);
        zzbfd = (long) zzm(cls3);
        Class<float[]> cls4 = float[].class;
        zzbfe = (long) zzl(cls4);
        zzbff = (long) zzm(cls4);
        Class<double[]> cls5 = double[].class;
        zzbfg = (long) zzl(cls5);
        zzbfh = (long) zzm(cls5);
        Class<Object[]> cls6 = Object[].class;
        zzbfi = (long) zzl(cls6);
        zzbfj = (long) zzm(cls6);
        Field zzrr = zzrr();
        if (zzrr == null || zzd2 == null) {
            j11 = -1;
        } else {
            j11 = zzd2.zzbfn.objectFieldOffset(zzrr);
        }
        zzbfk = j11;
        zzbfl = (int) (zzl & 7);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzbfm = z11;
    }

    private zztx() {
    }

    public static void zza(Object obj, long j11, long j12) {
        zzbev.zza(obj, j11, j12);
    }

    public static void zzb(Object obj, long j11, int i11) {
        zzbev.zzb(obj, j11, i11);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j11, boolean z11) {
        zzb(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static <T> T zzk(Class<T> cls) {
        try {
            return zzbcx.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    private static int zzl(Class<?> cls) {
        if (zzawt) {
            return zzbev.zzbfn.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzm(Class<?> cls) {
        if (zzawt) {
            return zzbev.zzbfn.arrayIndexScale(cls);
        }
        return -1;
    }

    public static float zzn(Object obj, long j11) {
        return zzbev.zzn(obj, j11);
    }

    public static double zzo(Object obj, long j11) {
        return zzbev.zzo(obj, j11);
    }

    public static Object zzp(Object obj, long j11) {
        return zzbev.zzbfn.getObject(obj, j11);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j11) {
        return (byte) (zzk(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j11) {
        return (byte) (zzk(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3)));
    }

    public static boolean zzrm() {
        return zzawt;
    }

    public static boolean zzrn() {
        return zzbew;
    }

    public static Unsafe zzro() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzty());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzrp() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = zzbcx;
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
            if (zzpp.zzna()) {
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

    private static boolean zzrq() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzbcx;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (zzrr() == null) {
                return false;
            }
            if (zzpp.zzna()) {
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

    private static Field zzrr() {
        Field zzb2;
        Class<Buffer> cls = Buffer.class;
        if (zzpp.zzna() && (zzb2 = zzb(cls, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(cls, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
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
        zzbev.zza(obj, j11, z11);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        return zzbev.zzl(byteBuffer, zzbfk);
    }

    private static boolean zzn(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzpp.zzna()) {
            return false;
        }
        try {
            Class<?> cls3 = zzavt;
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

    public static void zza(Object obj, long j11, float f11) {
        zzbev.zza(obj, j11, f11);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int zzk(Object obj, long j11) {
        return zzbev.zzk(obj, j11);
    }

    public static long zzl(Object obj, long j11) {
        return zzbev.zzl(obj, j11);
    }

    public static boolean zzm(Object obj, long j11) {
        return zzbev.zzm(obj, j11);
    }

    public static void zza(Object obj, long j11, double d11) {
        zzbev.zza(obj, j11, d11);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        zzb(obj, j12, ((255 & b11) << i11) | (zzk(obj, j12) & (~(255 << i11))));
    }

    public static void zza(Object obj, long j11, Object obj2) {
        zzbev.zzbfn.putObject(obj, j11, obj2);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, boolean z11) {
        zza(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static byte zza(byte[] bArr, long j11) {
        return zzbev.zzy(bArr, zzbex + j11);
    }

    public static void zza(byte[] bArr, long j11, byte b11) {
        zzbev.zze(bArr, zzbex + j11, b11);
    }

    public static void zza(byte[] bArr, long j11, long j12, long j13) {
        zzbev.zza(bArr, j11, j12, j13);
    }

    public static void zza(long j11, byte b11) {
        zzbev.zza(j11, b11);
    }

    public static int zza(byte[] bArr, int i11, byte[] bArr2, int i12, int i13) {
        int i14;
        if (i11 < 0 || i12 < 0 || i13 < 0 || i11 + i13 > bArr.length || i12 + i13 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i15 = 0;
        if (zzawt) {
            int i16 = (zzbfl + i11) & 7;
            while (i15 < i13 && (i16 & 7) != 0) {
                if (bArr[i11 + i15] != bArr2[i12 + i15]) {
                    return i15;
                }
                i15++;
                i16++;
            }
            int i17 = ((i13 - i15) & -8) + i15;
            while (i15 < i17) {
                long j11 = zzbex;
                long j12 = (long) i15;
                long zzl = zzl(bArr, ((long) i11) + j11 + j12);
                long zzl2 = zzl(bArr2, j11 + ((long) i12) + j12);
                if (zzl != zzl2) {
                    if (zzbfm) {
                        i14 = Long.numberOfLeadingZeros(zzl ^ zzl2);
                    } else {
                        i14 = Long.numberOfTrailingZeros(zzl ^ zzl2);
                    }
                    return i15 + (i14 >> 3);
                }
                i15 += 8;
            }
        }
        while (i15 < i13) {
            if (bArr[i11 + i15] != bArr2[i12 + i15]) {
                return i15;
            }
            i15++;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int zzk = zzk(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zzb(obj, j12, ((255 & b11) << i11) | (zzk & (~(255 << i11))));
    }
}
