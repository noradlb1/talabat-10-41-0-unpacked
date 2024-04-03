package com.google.android.gms.internal.icing;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzdh {
    static final Charset zza = Charset.forName("UTF-8");
    static final Charset zzb = Charset.forName("ISO-8859-1");
    public static final byte[] zzc;
    public static final ByteBuffer zzd;
    public static final zzci zze;

    static {
        byte[] bArr = new byte[0];
        zzc = bArr;
        zzd = ByteBuffer.wrap(bArr);
        zzch zzch = new zzch(bArr, 0, 0, false, (zzcg) null);
        try {
            zzch.zza(0);
            zze = zzch;
        } catch (zzdj e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public static <T> T zza(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T zzb(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzc(byte[] bArr) {
        return zzfr.zza(bArr);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zze(long j11) {
        return (int) (j11 ^ (j11 >>> 32));
    }

    public static int zzf(boolean z11) {
        return z11 ? 1231 : 1237;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        int zzh = zzh(length, bArr, 0, length);
        if (zzh == 0) {
            return 1;
        }
        return zzh;
    }

    public static int zzh(int i11, byte[] bArr, int i12, int i13) {
        for (int i14 = 0; i14 < i13; i14++) {
            i11 = (i11 * 31) + bArr[i14];
        }
        return i11;
    }

    public static Object zzi(Object obj, Object obj2) {
        return ((zzee) obj).zzy().zzf((zzee) obj2).zzl();
    }
}
