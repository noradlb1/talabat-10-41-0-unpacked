package com.google.android.gms.internal.ads;

final class zzaex implements zzaeq {
    final /* synthetic */ zzaez zza;
    private final zzfc zzb = new zzfc(new byte[4], 4);

    public zzaex(zzaez zzaez) {
        this.zza = zzaez;
    }

    public final void zza(zzfd zzfd) {
        if (zzfd.zzk() == 0 && (zzfd.zzk() & 128) != 0) {
            zzfd.zzG(6);
            int zza2 = zzfd.zza() / 4;
            for (int i11 = 0; i11 < zza2; i11++) {
                zzfd.zzA(this.zzb, 4);
                int zzc = this.zzb.zzc(16);
                this.zzb.zzj(3);
                if (zzc == 0) {
                    this.zzb.zzj(13);
                } else {
                    int zzc2 = this.zzb.zzc(13);
                    if (this.zza.zzf.get(zzc2) == null) {
                        this.zza.zzf.put(zzc2, new zzaer(new zzaey(this.zza, zzc2)));
                        zzaez zzaez = this.zza;
                        zzaez.zzl = zzaez.zzl + 1;
                    }
                }
            }
            this.zza.zzf.remove(0);
        }
    }

    public final void zzb(zzfk zzfk, zzws zzws, zzafd zzafd) {
    }
}
