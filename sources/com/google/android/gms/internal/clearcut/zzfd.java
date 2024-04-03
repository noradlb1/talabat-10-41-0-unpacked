package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzfd {
    private static final Logger logger = Logger.getLogger(zzfd.class.getName());
    private static final Class<?> zzfb = zzaw.zzy();
    private static final boolean zzfy = zzeg();
    private static final Unsafe zzmh;
    private static final boolean zzpg;
    private static final boolean zzph;
    private static final zzd zzpi;
    private static final boolean zzpj = zzeh();
    /* access modifiers changed from: private */
    public static final long zzpk = ((long) zzg(byte[].class));
    private static final long zzpl;
    private static final long zzpm;
    private static final long zzpn;
    private static final long zzpo;
    private static final long zzpp;
    private static final long zzpq;
    private static final long zzpr;
    private static final long zzps;
    private static final long zzpt;
    private static final long zzpu;
    private static final long zzpv;
    private static final long zzpw;
    private static final long zzpx = zzb(zzei());
    private static final long zzpy;
    /* access modifiers changed from: private */
    public static final boolean zzpz = (ByteOrder.nativeOrder() != ByteOrder.BIG_ENDIAN);

    public static final class zza extends zzd {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j11, byte b11) {
            Memory.pokeByte((int) (j11 & -1), b11);
        }

        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }

        public final void zza(Object obj, long j11, float f11) {
            zza(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zza(Object obj, long j11, boolean z11) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j11, z11);
            } else {
                zzfd.zzc(obj, j11, z11);
            }
        }

        public final void zza(byte[] bArr, long j11, long j12, long j13) {
            Memory.pokeByteArray((int) (j12 & -1), bArr, (int) j11, (int) j13);
        }

        public final void zze(Object obj, long j11, byte b11) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j11, b11);
            } else {
                zzfd.zzb(obj, j11, b11);
            }
        }

        public final boolean zzl(Object obj, long j11) {
            return zzfd.zzpz ? zzfd.zzr(obj, j11) : zzfd.zzs(obj, j11);
        }

        public final float zzm(Object obj, long j11) {
            return Float.intBitsToFloat(zzj(obj, j11));
        }

        public final double zzn(Object obj, long j11) {
            return Double.longBitsToDouble(zzk(obj, j11));
        }

        public final byte zzx(Object obj, long j11) {
            return zzfd.zzpz ? zzfd.zzp(obj, j11) : zzfd.zzq(obj, j11);
        }
    }

    public static final class zzb extends zzd {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j11, byte b11) {
            Memory.pokeByte(j11, b11);
        }

        public final void zza(Object obj, long j11, double d11) {
            zza(obj, j11, Double.doubleToLongBits(d11));
        }

        public final void zza(Object obj, long j11, float f11) {
            zza(obj, j11, Float.floatToIntBits(f11));
        }

        public final void zza(Object obj, long j11, boolean z11) {
            if (zzfd.zzpz) {
                zzfd.zzb(obj, j11, z11);
            } else {
                zzfd.zzc(obj, j11, z11);
            }
        }

        public final void zza(byte[] bArr, long j11, long j12, long j13) {
            Memory.pokeByteArray(j12, bArr, (int) j11, (int) j13);
        }

        public final void zze(Object obj, long j11, byte b11) {
            if (zzfd.zzpz) {
                zzfd.zza(obj, j11, b11);
            } else {
                zzfd.zzb(obj, j11, b11);
            }
        }

        public final boolean zzl(Object obj, long j11) {
            return zzfd.zzpz ? zzfd.zzr(obj, j11) : zzfd.zzs(obj, j11);
        }

        public final float zzm(Object obj, long j11) {
            return Float.intBitsToFloat(zzj(obj, j11));
        }

        public final double zzn(Object obj, long j11) {
            return Double.longBitsToDouble(zzk(obj, j11));
        }

        public final byte zzx(Object obj, long j11) {
            return zzfd.zzpz ? zzfd.zzp(obj, j11) : zzfd.zzq(obj, j11);
        }
    }

    public static final class zzc extends zzd {
        public zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j11, byte b11) {
            this.zzqa.putByte(j11, b11);
        }

        public final void zza(Object obj, long j11, double d11) {
            this.zzqa.putDouble(obj, j11, d11);
        }

        public final void zza(Object obj, long j11, float f11) {
            this.zzqa.putFloat(obj, j11, f11);
        }

        public final void zza(Object obj, long j11, boolean z11) {
            this.zzqa.putBoolean(obj, j11, z11);
        }

        public final void zza(byte[] bArr, long j11, long j12, long j13) {
            this.zzqa.copyMemory(bArr, zzfd.zzpk + j11, (Object) null, j12, j13);
        }

        public final void zze(Object obj, long j11, byte b11) {
            this.zzqa.putByte(obj, j11, b11);
        }

        public final boolean zzl(Object obj, long j11) {
            return this.zzqa.getBoolean(obj, j11);
        }

        public final float zzm(Object obj, long j11) {
            return this.zzqa.getFloat(obj, j11);
        }

        public final double zzn(Object obj, long j11) {
            return this.zzqa.getDouble(obj, j11);
        }

        public final byte zzx(Object obj, long j11) {
            return this.zzqa.getByte(obj, j11);
        }
    }

    public static abstract class zzd {
        Unsafe zzqa;

        public zzd(Unsafe unsafe) {
            this.zzqa = unsafe;
        }

        public final long zza(Field field) {
            return this.zzqa.objectFieldOffset(field);
        }

        public abstract void zza(long j11, byte b11);

        public abstract void zza(Object obj, long j11, double d11);

        public abstract void zza(Object obj, long j11, float f11);

        public final void zza(Object obj, long j11, int i11) {
            this.zzqa.putInt(obj, j11, i11);
        }

        public final void zza(Object obj, long j11, long j12) {
            this.zzqa.putLong(obj, j11, j12);
        }

        public abstract void zza(Object obj, long j11, boolean z11);

        public abstract void zza(byte[] bArr, long j11, long j12, long j13);

        public abstract void zze(Object obj, long j11, byte b11);

        public final int zzj(Object obj, long j11) {
            return this.zzqa.getInt(obj, j11);
        }

        public final long zzk(Object obj, long j11) {
            return this.zzqa.getLong(obj, j11);
        }

        public abstract boolean zzl(Object obj, long j11);

        public abstract float zzm(Object obj, long j11);

        public abstract double zzn(Object obj, long j11);

        public abstract byte zzx(Object obj, long j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00ec  */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.clearcut.zzfd> r0 = com.google.android.gms.internal.clearcut.zzfd.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzef()
            zzmh = r0
            java.lang.Class r1 = com.google.android.gms.internal.clearcut.zzaw.zzy()
            zzfb = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = zzi(r1)
            zzpg = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = zzi(r2)
            zzph = r2
            r3 = 0
            if (r0 != 0) goto L_0x002d
        L_0x002b:
            r1 = r3
            goto L_0x0048
        L_0x002d:
            boolean r4 = com.google.android.gms.internal.clearcut.zzaw.zzx()
            if (r4 == 0) goto L_0x0043
            if (r1 == 0) goto L_0x003b
            com.google.android.gms.internal.clearcut.zzfd$zzb r1 = new com.google.android.gms.internal.clearcut.zzfd$zzb
            r1.<init>(r0)
            goto L_0x0048
        L_0x003b:
            if (r2 == 0) goto L_0x002b
            com.google.android.gms.internal.clearcut.zzfd$zza r1 = new com.google.android.gms.internal.clearcut.zzfd$zza
            r1.<init>(r0)
            goto L_0x0048
        L_0x0043:
            com.google.android.gms.internal.clearcut.zzfd$zzc r1 = new com.google.android.gms.internal.clearcut.zzfd$zzc
            r1.<init>(r0)
        L_0x0048:
            zzpi = r1
            boolean r0 = zzeh()
            zzpj = r0
            boolean r0 = zzeg()
            zzfy = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzg(r0)
            long r0 = (long) r0
            zzpk = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpl = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpm = r0
            java.lang.Class<int[]> r0 = int[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpn = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpo = r0
            java.lang.Class<long[]> r0 = long[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpp = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpq = r0
            java.lang.Class<float[]> r0 = float[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpr = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzps = r0
            java.lang.Class<double[]> r0 = double[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpt = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpu = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r1 = zzg(r0)
            long r1 = (long) r1
            zzpv = r1
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzpw = r0
            java.lang.reflect.Field r0 = zzei()
            long r0 = zzb((java.lang.reflect.Field) r0)
            zzpx = r0
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.String r1 = "value"
            java.lang.reflect.Field r0 = zzb(r0, r1)
            if (r0 == 0) goto L_0x00dc
            java.lang.Class r1 = r0.getType()
            java.lang.Class<char[]> r2 = char[].class
            if (r1 != r2) goto L_0x00dc
            r3 = r0
        L_0x00dc:
            long r0 = zzb((java.lang.reflect.Field) r3)
            zzpy = r0
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00ec
            r0 = 1
            goto L_0x00ed
        L_0x00ec:
            r0 = 0
        L_0x00ed:
            zzpz = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzfd.<clinit>():void");
    }

    private zzfd() {
    }

    public static byte zza(byte[] bArr, long j11) {
        return zzpi.zzx(bArr, zzpk + j11);
    }

    public static long zza(Field field) {
        return zzpi.zza(field);
    }

    public static void zza(long j11, byte b11) {
        zzpi.zza(j11, b11);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int zzj = zzj(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zza(obj, j12, ((255 & b11) << i11) | (zzj & (~(255 << i11))));
    }

    public static void zza(Object obj, long j11, double d11) {
        zzpi.zza(obj, j11, d11);
    }

    public static void zza(Object obj, long j11, float f11) {
        zzpi.zza(obj, j11, f11);
    }

    public static void zza(Object obj, long j11, int i11) {
        zzpi.zza(obj, j11, i11);
    }

    public static void zza(Object obj, long j11, long j12) {
        zzpi.zza(obj, j11, j12);
    }

    public static void zza(Object obj, long j11, Object obj2) {
        zzpi.zzqa.putObject(obj, j11, obj2);
    }

    public static void zza(Object obj, long j11, boolean z11) {
        zzpi.zza(obj, j11, z11);
    }

    public static void zza(byte[] bArr, long j11, byte b11) {
        zzpi.zze(bArr, zzpk + j11, b11);
    }

    public static void zza(byte[] bArr, long j11, long j12, long j13) {
        zzpi.zza(bArr, j11, j12, j13);
    }

    private static long zzb(Field field) {
        zzd zzd2;
        if (field == null || (zzd2 = zzpi) == null) {
            return -1;
        }
        return zzd2.zza(field);
    }

    public static long zzb(ByteBuffer byteBuffer) {
        return zzpi.zzk(byteBuffer, zzpx);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        int i11 = (((int) j11) & 3) << 3;
        zza(obj, j12, ((255 & b11) << i11) | (zzj(obj, j12) & (~(255 << i11))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j11, boolean z11) {
        zza(obj, j11, z11 ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j11, boolean z11) {
        zzb(obj, j11, z11 ? (byte) 1 : 0);
    }

    public static boolean zzed() {
        return zzfy;
    }

    public static boolean zzee() {
        return zzpj;
    }

    public static Unsafe zzef() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfe());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzeg() {
        Class<Class> cls = Class.class;
        Class<Object> cls2 = Object.class;
        Unsafe unsafe = zzmh;
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
            if (zzaw.zzx()) {
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

    private static boolean zzeh() {
        Class<Object> cls = Object.class;
        Unsafe unsafe = zzmh;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls2 = unsafe.getClass();
            cls2.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls3 = Long.TYPE;
            cls2.getMethod("getLong", new Class[]{cls, cls3});
            if (zzei() == null) {
                return false;
            }
            if (zzaw.zzx()) {
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

    private static Field zzei() {
        Field zzb2;
        Class<Buffer> cls = Buffer.class;
        if (zzaw.zzx() && (zzb2 = zzb(cls, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(cls, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzg(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzh(Class<?> cls) {
        if (zzfy) {
            return zzpi.zzqa.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzi(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        if (!zzaw.zzx()) {
            return false;
        }
        try {
            Class<?> cls3 = zzfb;
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

    public static int zzj(Object obj, long j11) {
        return zzpi.zzj(obj, j11);
    }

    public static long zzk(Object obj, long j11) {
        return zzpi.zzk(obj, j11);
    }

    public static boolean zzl(Object obj, long j11) {
        return zzpi.zzl(obj, j11);
    }

    public static float zzm(Object obj, long j11) {
        return zzpi.zzm(obj, j11);
    }

    public static double zzn(Object obj, long j11) {
        return zzpi.zzn(obj, j11);
    }

    public static Object zzo(Object obj, long j11) {
        return zzpi.zzqa.getObject(obj, j11);
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j11) {
        return (byte) (zzj(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j11) {
        return (byte) (zzj(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j11) {
        return zzp(obj, j11) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j11) {
        return zzq(obj, j11) != 0;
    }
}
