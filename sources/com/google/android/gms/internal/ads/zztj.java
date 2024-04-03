package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;

public final class zztj extends zzdf {
    @Nullable
    private zzdm zza;
    @Nullable
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zztj() {
        super(false);
    }

    public final int zzg(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.zzd;
        if (i13 == 0) {
            return -1;
        }
        int min = Math.min(i12, i13);
        System.arraycopy(zzfn.zzC(this.zzb), this.zzc, bArr, i11, min);
        this.zzc += min;
        this.zzd -= min;
        zzc(min);
        return min;
    }

    public final long zzh(zzdm zzdm) throws IOException {
        String str;
        String str2;
        zze(zzdm);
        this.zza = zzdm;
        Uri uri = zzdm.zza;
        String scheme = uri.getScheme();
        boolean equals = "data".equals(scheme);
        String valueOf = String.valueOf(scheme);
        if (valueOf.length() != 0) {
            str = "Unsupported scheme: ".concat(valueOf);
        } else {
            str = new String("Unsupported scheme: ");
        }
        zzdy.zze(equals, str);
        String[] zzac = zzfn.zzac(uri.getSchemeSpecificPart(), ",");
        if (zzac.length == 2) {
            String str3 = zzac[1];
            if (zzac[0].contains(";base64")) {
                try {
                    this.zzb = Base64.decode(str3, 0);
                } catch (IllegalArgumentException e11) {
                    String valueOf2 = String.valueOf(str3);
                    if (valueOf2.length() != 0) {
                        str2 = "Error while parsing Base64 encoded string: ".concat(valueOf2);
                    } else {
                        str2 = new String("Error while parsing Base64 encoded string: ");
                    }
                    throw zzbj.zzb(str2, e11);
                }
            } else {
                this.zzb = zzfn.zzW(URLDecoder.decode(str3, zzfpt.zza.name()));
            }
            long j11 = zzdm.zzf;
            int length = this.zzb.length;
            if (j11 <= ((long) length)) {
                int i11 = (int) j11;
                this.zzc = i11;
                int i12 = length - i11;
                this.zzd = i12;
                long j12 = zzdm.zzg;
                if (j12 != -1) {
                    this.zzd = (int) Math.min((long) i12, j12);
                }
                zzf(zzdm);
                long j13 = zzdm.zzg;
                if (j13 != -1) {
                    return j13;
                }
                return (long) this.zzd;
            }
            this.zzb = null;
            throw new zzdj(2008);
        }
        throw zzbj.zzb("Unexpected URI format: ".concat(String.valueOf(uri)), (Throwable) null);
    }

    @Nullable
    public final Uri zzi() {
        zzdm zzdm = this.zza;
        if (zzdm != null) {
            return zzdm.zza;
        }
        return null;
    }

    public final void zzj() {
        if (this.zzb != null) {
            this.zzb = null;
            zzd();
        }
        this.zza = null;
    }
}
