package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class zzgnp {
    static final long zza = ((long) zzC(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zzgip.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzgno zzg;
    private static final boolean zzh;
    private static final boolean zzi;
    private static final long zzj;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x013d  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = zzi()
            zzc = r1
            java.lang.Class r2 = com.google.android.gms.internal.ads.zzgip.zza()
            zzd = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = zzy(r2)
            zze = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = zzy(r4)
            zzf = r4
            r5 = 0
            if (r1 != 0) goto L_0x0022
            goto L_0x0031
        L_0x0022:
            if (r3 == 0) goto L_0x002a
            com.google.android.gms.internal.ads.zzgnn r5 = new com.google.android.gms.internal.ads.zzgnn
            r5.<init>(r1)
            goto L_0x0031
        L_0x002a:
            if (r4 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzgnm r5 = new com.google.android.gms.internal.ads.zzgnm
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
            java.lang.reflect.Field r2 = zzE()     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0062
            goto L_0x0040
        L_0x0062:
            r2 = r8
            goto L_0x0069
        L_0x0064:
            r2 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.ads.zzgnp.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r2.toString()))
            goto L_0x0040
        L_0x0069:
            zzh = r2
            com.google.android.gms.internal.ads.zzgno r2 = zzg
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
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.ads.zzgnp.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006f
        L_0x00e6:
            zzi = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzC(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzC(r0)
            zzD(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzC(r0)
            zzD(r0)
            java.lang.reflect.Field r0 = zzE()
            r1 = -1
            if (r0 == 0) goto L_0x0132
            com.google.android.gms.internal.ads.zzgno r3 = zzg
            if (r3 != 0) goto L_0x012e
            goto L_0x0132
        L_0x012e:
            long r1 = r3.zzn(r0)
        L_0x0132:
            zzj = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x013d
            goto L_0x013e
        L_0x013d:
            r8 = r9
        L_0x013e:
            zzb = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgnp.<clinit>():void");
    }

    private zzgnp() {
    }

    public static boolean zzA() {
        return zzi;
    }

    public static boolean zzB() {
        return zzh;
    }

    private static int zzC(Class<?> cls) {
        if (zzi) {
            return zzg.zzj(cls);
        }
        return -1;
    }

    private static int zzD(Class<?> cls) {
        if (zzi) {
            return zzg.zzk(cls);
        }
        return -1;
    }

    private static Field zzE() {
        int i11 = zzgip.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzF = zzF(cls, "effectiveDirectAddress");
        if (zzF != null) {
            return zzF;
        }
        Field zzF2 = zzF(cls, "address");
        if (zzF2 == null || zzF2.getType() != Long.TYPE) {
            return null;
        }
        return zzF2;
    }

    private static Field zzF(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzG(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        zzgno zzgno = zzg;
        int zzl = zzgno.zzl(obj, j12);
        int i11 = ((~((int) j11)) & 3) << 3;
        zzgno.zzp(obj, j12, ((255 & b11) << i11) | (zzl & (~(255 << i11))));
    }

    /* access modifiers changed from: private */
    public static void zzH(Object obj, long j11, byte b11) {
        long j12 = -4 & j11;
        zzgno zzgno = zzg;
        int i11 = (((int) j11) & 3) << 3;
        zzgno.zzp(obj, j12, ((255 & b11) << i11) | (zzgno.zzl(obj, j12) & (~(255 << i11))));
    }

    public static byte zza(long j11) {
        return zzg.zza(j11);
    }

    public static double zzb(Object obj, long j11) {
        return zzg.zzb(obj, j11);
    }

    public static float zzc(Object obj, long j11) {
        return zzg.zzc(obj, j11);
    }

    public static int zzd(Object obj, long j11) {
        return zzg.zzl(obj, j11);
    }

    public static long zze(ByteBuffer byteBuffer) {
        return zzg.zzm(byteBuffer, zzj);
    }

    public static long zzf(Object obj, long j11) {
        return zzg.zzm(obj, j11);
    }

    public static <T> T zzg(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public static Object zzh(Object obj, long j11) {
        return zzg.zzo(obj, j11);
    }

    public static Unsafe zzi() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzgnl());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzo(long j11, byte[] bArr, long j12, long j13) {
        zzg.zzd(j11, bArr, j12, j13);
    }

    public static void zzp(Object obj, long j11, boolean z11) {
        zzg.zze(obj, j11, z11);
    }

    public static void zzq(byte[] bArr, long j11, byte b11) {
        zzg.zzf(bArr, zza + j11, b11);
    }

    public static void zzr(Object obj, long j11, double d11) {
        zzg.zzg(obj, j11, d11);
    }

    public static void zzs(Object obj, long j11, float f11) {
        zzg.zzh(obj, j11, f11);
    }

    public static void zzt(Object obj, long j11, int i11) {
        zzg.zzp(obj, j11, i11);
    }

    public static void zzu(Object obj, long j11, long j12) {
        zzg.zzq(obj, j11, j12);
    }

    public static void zzv(Object obj, long j11, Object obj2) {
        zzg.zzr(obj, j11, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzw(Object obj, long j11) {
        return ((byte) ((zzg.zzl(obj, -4 & j11) >>> ((int) (((~j11) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzx(Object obj, long j11) {
        return ((byte) ((zzg.zzl(obj, -4 & j11) >>> ((int) ((j11 & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzy(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i11 = zzgip.zza;
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

    public static boolean zzz(Object obj, long j11) {
        return zzg.zzi(obj, j11);
    }
}
