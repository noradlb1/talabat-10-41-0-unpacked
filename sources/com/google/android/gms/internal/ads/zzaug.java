package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

final class zzaug {
    private final zzarj[] zza;
    private final zzark zzb;
    private zzarj zzc;

    public zzaug(zzarj[] zzarjArr, zzark zzark) {
        this.zza = zzarjArr;
        this.zzb = zzark;
    }

    public final void zza() {
        if (this.zzc != null) {
            this.zzc = null;
        }
    }

    public final zzarj zzb(zzari zzari, Uri uri) throws IOException, InterruptedException {
        zzarj zzarj = this.zzc;
        if (zzarj != null) {
            return zzarj;
        }
        zzarj[] zzarjArr = this.zza;
        int length = zzarjArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            zzarj zzarj2 = zzarjArr[i11];
            try {
                if (zzarj2.zzg(zzari)) {
                    this.zzc = zzarj2;
                    zzari.zze();
                    break;
                }
                zzari.zze();
                i11++;
            } catch (EOFException unused) {
            } catch (Throwable th2) {
                zzari.zze();
                throw th2;
            }
        }
        zzarj zzarj3 = this.zzc;
        if (zzarj3 != null) {
            zzarj3.zzd(this.zzb);
            return this.zzc;
        }
        String zzk = zzaxb.zzk(this.zza);
        StringBuilder sb2 = new StringBuilder(zzk.length() + 58);
        sb2.append("None of the available extractors (");
        sb2.append(zzk);
        sb2.append(") could read the stream.");
        throw new zzave(sb2.toString(), uri);
    }
}
