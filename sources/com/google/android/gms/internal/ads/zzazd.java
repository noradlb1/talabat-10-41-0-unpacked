package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
final class zzazd {
    @VisibleForTesting
    ByteArrayOutputStream zza = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    public final String toString() {
        try {
            this.zzb.close();
        } catch (IOException e11) {
            zzciz.zzh("HashManager: Unable to convert to Base64.", e11);
        }
        try {
            this.zza.close();
            return this.zza.toString();
        } catch (IOException e12) {
            zzciz.zzh("HashManager: Unable to convert to Base64.", e12);
            return "";
        } finally {
            this.zza = null;
            this.zzb = null;
        }
    }
}
