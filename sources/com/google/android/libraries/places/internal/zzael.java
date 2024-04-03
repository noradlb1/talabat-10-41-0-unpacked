package com.google.android.libraries.places.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzael {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzaal.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzaek zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0137  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = zzg()
            zzc = r1
            java.lang.Class r2 = com.google.android.libraries.places.internal.zzaal.zza()
            zzd = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = zzv(r2)
            zze = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = zzv(r4)
            zzf = r4
            r5 = 0
            if (r1 != 0) goto L_0x0022
            goto L_0x0031
        L_0x0022:
            if (r3 == 0) goto L_0x002a
            com.google.android.libraries.places.internal.zzaej r5 = new com.google.android.libraries.places.internal.zzaej
            r5.<init>(r1)
            goto L_0x0031
        L_0x002a:
            if (r4 == 0) goto L_0x0031
            com.google.android.libraries.places.internal.zzaei r5 = new com.google.android.libraries.places.internal.zzaei
            r5.<init>(r1)
        L_0x0031:
            zzg = r5
            java.lang.String r1 = "getLong"
            java.lang.String r3 = "objectFieldOffset"
            java.lang.Class<java.lang.reflect.Field> r4 = java.lang.reflect.Field.class
            r6 = 2
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r8 = 1
            r9 = 0
            if (r5 != 0) goto L_0x0042
        L_0x0040:
            r2 = r9
            goto L_0x0069
        L_0x0042:
            sun.misc.Unsafe r5 = r5.zza
            if (r5 != 0) goto L_0x0047
            goto L_0x0040
        L_0x0047:
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x0064 }
            java.lang.Class[] r10 = new java.lang.Class[r8]     // Catch:{ all -> 0x0064 }
            r10[r9] = r4     // Catch:{ all -> 0x0064 }
            r5.getMethod(r3, r10)     // Catch:{ all -> 0x0064 }
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch:{ all -> 0x0064 }
            r10[r9] = r7     // Catch:{ all -> 0x0064 }
            r10[r8] = r2     // Catch:{ all -> 0x0064 }
            r5.getMethod(r1, r10)     // Catch:{ all -> 0x0064 }
            java.lang.reflect.Field r2 = zzB()     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0062
            goto L_0x0040
        L_0x0062:
            r2 = r8
            goto L_0x0069
        L_0x0064:
            r2 = move-exception
            zzh(r2)
            goto L_0x0040
        L_0x0069:
            zzh = r2
            com.google.android.libraries.places.internal.zzaek r2 = zzg
            if (r2 != 0) goto L_0x0072
        L_0x006f:
            r0 = r9
            goto L_0x00e6
        L_0x0072:
            sun.misc.Unsafe r2 = r2.zza
            if (r2 != 0) goto L_0x0077
            goto L_0x006f
        L_0x0077:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r5 = new java.lang.Class[r8]     // Catch:{ all -> 0x00e1 }
            r5[r9] = r4     // Catch:{ all -> 0x00e1 }
            r2.getMethod(r3, r5)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r3 = new java.lang.Class[r8]     // Catch:{ all -> 0x00e1 }
            r3[r9] = r0     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "arrayBaseOffset"
            r2.getMethod(r4, r3)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r3 = new java.lang.Class[r8]     // Catch:{ all -> 0x00e1 }
            r3[r9] = r0     // Catch:{ all -> 0x00e1 }
            java.lang.String r0 = "arrayIndexScale"
            r2.getMethod(r0, r3)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e1 }
            r0[r9] = r7     // Catch:{ all -> 0x00e1 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x00e1 }
            r0[r8] = r3     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "getInt"
            r2.getMethod(r4, r0)     // Catch:{ all -> 0x00e1 }
            r0 = 3
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ all -> 0x00e1 }
            r4[r9] = r7     // Catch:{ all -> 0x00e1 }
            r4[r8] = r3     // Catch:{ all -> 0x00e1 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e1 }
            r4[r6] = r5     // Catch:{ all -> 0x00e1 }
            java.lang.String r5 = "putInt"
            r2.getMethod(r5, r4)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r4 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e1 }
            r4[r9] = r7     // Catch:{ all -> 0x00e1 }
            r4[r8] = r3     // Catch:{ all -> 0x00e1 }
            r2.getMethod(r1, r4)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ all -> 0x00e1 }
            r1[r9] = r7     // Catch:{ all -> 0x00e1 }
            r1[r8] = r3     // Catch:{ all -> 0x00e1 }
            r1[r6] = r3     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "putLong"
            r2.getMethod(r4, r1)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e1 }
            r1[r9] = r7     // Catch:{ all -> 0x00e1 }
            r1[r8] = r3     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "getObject"
            r2.getMethod(r4, r1)     // Catch:{ all -> 0x00e1 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00e1 }
            r0[r9] = r7     // Catch:{ all -> 0x00e1 }
            r0[r8] = r3     // Catch:{ all -> 0x00e1 }
            r0[r6] = r7     // Catch:{ all -> 0x00e1 }
            java.lang.String r1 = "putObject"
            r2.getMethod(r1, r0)     // Catch:{ all -> 0x00e1 }
            r0 = r8
            goto L_0x00e6
        L_0x00e1:
            r0 = move-exception
            zzh(r0)
            goto L_0x006f
        L_0x00e6:
            zzi = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzz(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x012e
            com.google.android.libraries.places.internal.zzaek r1 = zzg
            if (r1 == 0) goto L_0x012e
            r1.zzl(r0)
        L_0x012e:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0137
            goto L_0x0138
        L_0x0137:
            r8 = r9
        L_0x0138:
            zzb = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzael.<clinit>():void");
    }

    private zzael() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i11 = zzaal.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzC = zzC(cls, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(cls, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        zzaek zzaek = zzg;
        int zzj = zzaek.zzj(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zzaek.zzn(obj, j12, ((255 & b11) << i11) | (zzj & (~(255 << i11))));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        zzaek zzaek = zzg;
        int i11 = (((int) j11) & 3) << 3;
        zzaek.zzn(obj, j12, ((255 & b11) << i11) | (zzaek.zzj(obj, j12) & (~(255 << i11))));
    }

    public static double zza(Object obj, long j11) {
        return zzg.zza(obj, j11);
    }

    public static float zzb(Object obj, long j11) {
        return zzg.zzb(obj, j11);
    }

    public static int zzc(Object obj, long j11) {
        return zzg.zzj(obj, j11);
    }

    public static long zzd(Object obj, long j11) {
        return zzg.zzk(obj, j11);
    }

    public static <T> T zze(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static Object zzf(Object obj, long j11) {
        return zzg.zzm(obj, j11);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzaeh());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th2) {
        Logger logger = Logger.getLogger(zzael.class.getName());
        Level level = Level.WARNING;
        String valueOf = String.valueOf(th2);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
        sb2.append("platform method missing - proto runtime falling back to safer methods: ");
        sb2.append(valueOf);
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", sb2.toString());
    }

    public static void zzm(Object obj, long j11, boolean z11) {
        zzg.zzc(obj, j11, z11);
    }

    public static void zzn(byte[] bArr, long j11, byte b11) {
        zzg.zzd(bArr, zza + j11, b11);
    }

    public static void zzo(Object obj, long j11, double d11) {
        zzg.zze(obj, j11, d11);
    }

    public static void zzp(Object obj, long j11, float f11) {
        zzg.zzf(obj, j11, f11);
    }

    public static void zzq(Object obj, long j11, int i11) {
        zzg.zzn(obj, j11, i11);
    }

    public static void zzr(Object obj, long j11, long j12) {
        zzg.zzo(obj, j11, j12);
    }

    public static void zzs(Object obj, long j11, Object obj2) {
        zzg.zzp(obj, j11, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j11) {
        return ((byte) ((zzg.zzj(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j11) {
        return ((byte) ((zzg.zzj(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzv(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i11 = zzaal.zza;
        try {
            Class<?> cls3 = zzd;
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

    public static boolean zzw(Object obj, long j11) {
        return zzg.zzg(obj, j11);
    }

    public static boolean zzx() {
        return zzi;
    }

    public static boolean zzy() {
        return zzh;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzh(cls);
        }
        return -1;
    }
}
