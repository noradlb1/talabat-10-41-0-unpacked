package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

final class zzauf implements zzawi {
    final /* synthetic */ zzaui zza;
    private final Uri zzb;
    private final zzavw zzc;
    private final zzaug zzd;
    private final zzawo zze;
    private final zzaro zzf = new zzaro();
    private volatile boolean zzg;
    private boolean zzh = true;
    private long zzi;
    /* access modifiers changed from: private */
    public long zzj = -1;

    public zzauf(zzaui zzaui, Uri uri, zzavw zzavw, zzaug zzaug, zzawo zzawo) {
        this.zza = zzaui;
        uri.getClass();
        this.zzb = uri;
        zzavw.getClass();
        this.zzc = zzavw;
        zzaug.getClass();
        this.zzd = zzaug;
        this.zze = zzawo;
    }

    public final void zzb() {
        this.zzg = true;
    }

    public final void zzc() throws IOException, InterruptedException {
        zzari zzari;
        long j11;
        while (!this.zzg) {
            int i11 = 0;
            try {
                long j12 = this.zzf.zza;
                zzavw zzavw = this.zzc;
                zzavy zzavy = r4;
                long j13 = j12;
                zzavy zzavy2 = new zzavy(this.zzb, (byte[]) null, j12, j12, -1, (String) null, 0);
                long zzb2 = zzavw.zzb(zzavy);
                this.zzj = zzb2;
                if (zzb2 != -1) {
                    j11 = j13;
                    zzb2 += j11;
                    this.zzj = zzb2;
                } else {
                    j11 = j13;
                }
                zzari = new zzari(this.zzc, j11, zzb2);
                try {
                    zzarj zzb3 = this.zzd.zzb(zzari, this.zzc.zzc());
                    if (this.zzh) {
                        zzb3.zze(j11, this.zzi);
                        this.zzh = false;
                    }
                    int i12 = 0;
                    long j14 = j11;
                    while (true) {
                        if (i12 != 0) {
                            break;
                        }
                        try {
                            if (this.zzg) {
                                i12 = 0;
                                break;
                            }
                            this.zze.zza();
                            i12 = zzb3.zzf(zzari, this.zzf);
                            if (zzari.zzd() > this.zza.zzg + j14) {
                                j14 = zzari.zzd();
                                this.zze.zzb();
                                this.zza.zzm.post(this.zza.zzl);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            i11 = i12;
                            this.zzf.zza = zzari.zzd();
                            zzaxb.zzm(this.zzc);
                            throw th;
                        }
                    }
                    if (i12 != 1) {
                        this.zzf.zza = zzari.zzd();
                        i11 = i12;
                    }
                    zzaxb.zzm(this.zzc);
                    if (i11 != 0) {
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    this.zzf.zza = zzari.zzd();
                    zzaxb.zzm(this.zzc);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                zzari = null;
                if (!(i11 == 1 || zzari == null)) {
                    this.zzf.zza = zzari.zzd();
                }
                zzaxb.zzm(this.zzc);
                throw th;
            }
        }
    }

    public final void zzd(long j11, long j12) {
        this.zzf.zza = j11;
        this.zzi = j12;
        this.zzh = true;
    }

    public final boolean zze() {
        return this.zzg;
    }
}
