package com.google.android.libraries.places.internal;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzaca {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzabb zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        int i11 = zzabb.zza;
        zzaaz zzaaz = new zzaaz(bArr, 0, 0, false, (zzaay) null);
        try {
            zzaaz.zza(0);
            zze = zzaaz;
        } catch (zzacc e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static int zza(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    public static int zzc(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int zzd(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static <T> T zze(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T zzf(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static Object zzg(Object obj, Object obj2) {
        return ((zzacz) obj).zzD().zzq((zzacz) obj2).zzv();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static boolean zzi(byte[] bArr) {
        return zzaep.zzd(bArr);
    }
}
