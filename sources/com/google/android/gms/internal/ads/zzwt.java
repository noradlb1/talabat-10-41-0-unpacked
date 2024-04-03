package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

public final class zzwt {
    public static int zza(zzwq zzwq, byte[] bArr, int i11, int i12) throws IOException {
        int i13 = 0;
        while (i13 < i12) {
            int zza = zzwq.zza(bArr, i11 + i13, i12 - i13);
            if (zza == -1) {
                break;
            }
            i13 += zza;
        }
        return i13;
    }

    @Pure
    public static void zzb(boolean z11, @Nullable String str) throws zzbj {
        if (!z11) {
            throw zzbj.zza(str, (Throwable) null);
        }
    }

    public static boolean zzc(zzwq zzwq, byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        try {
            return zzwq.zzm(bArr, 0, i12, z11);
        } catch (EOFException e11) {
            if (z11) {
                return false;
            }
            throw e11;
        }
    }

    public static boolean zzd(zzwq zzwq, byte[] bArr, int i11, int i12) throws IOException {
        try {
            ((zzwk) zzwq).zzn(bArr, i11, i12, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean zze(zzwq zzwq, int i11) throws IOException {
        try {
            ((zzwk) zzwq).zzo(i11, false);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
