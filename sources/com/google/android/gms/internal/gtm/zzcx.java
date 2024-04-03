package com.google.android.gms.internal.gtm;

final class zzcx extends zzam implements zzbp<zzcy> {
    private final zzcy zzacl = new zzcy();

    public zzcx(zzap zzap) {
        super(zzap);
    }

    public final void zza(String str, boolean z11) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.zzacl.zzacp = z11;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.zzacl.zzacq = z11;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.zzacl.zzacr = z11 ? 1 : 0;
        } else {
            zzd("bool configuration name not recognized", str);
        }
    }

    public final void zzb(String str, String str2) {
        this.zzacl.zzacs.put(str, str2);
    }

    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.zzacl.zzacm = str2;
        } else if ("ga_sampleFrequency".equals(str)) {
            try {
                this.zzacl.zzacn = Double.parseDouble(str2);
            } catch (NumberFormatException e11) {
                zzc("Error parsing ga_sampleFrequency value", str2, e11);
            }
        } else {
            zzd("string configuration name not recognized", str);
        }
    }

    public final /* synthetic */ zzbn zzel() {
        return this.zzacl;
    }

    public final void zzb(String str, int i11) {
        if ("ga_sessionTimeout".equals(str)) {
            this.zzacl.zzaco = i11;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }
}
