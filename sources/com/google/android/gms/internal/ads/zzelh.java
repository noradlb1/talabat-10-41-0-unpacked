package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import javax.annotation.Nullable;

public final class zzelh {
    private final zzfer zza;
    private final zzdwt zzb;
    private final zzdyz zzc;
    private final zzfio zzd;

    public zzelh(zzfer zzfer, zzdwt zzdwt, zzdyz zzdyz, zzfio zzfio) {
        this.zza = zzfer;
        this.zzb = zzdwt;
        this.zzc = zzdyz;
        this.zzd = zzfio;
    }

    public final void zza(zzfdq zzfdq, zzfdn zzfdn, int i11, @Nullable zzehx zzehx, long j11) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
            zzfin zzb2 = zzfin.zzb("adapter_status");
            zzb2.zzg(zzfdq);
            zzb2.zzf(zzfdn);
            zzb2.zza("adapter_l", String.valueOf(j11));
            zzb2.zza("sc", Integer.toString(i11));
            if (zzehx != null) {
                zzb2.zza("arec", Integer.toString(zzehx.zzb().zza));
                String zza2 = this.zza.zza(zzehx.getMessage());
                if (zza2 != null) {
                    zzb2.zza("areec", zza2);
                }
            }
            zzdws zzb3 = this.zzb.zzb(zzfdn.zzu);
            if (zzb3 != null) {
                zzb2.zza("ancn", zzb3.zza);
                zzcab zzcab = zzb3.zzb;
                if (zzcab != null) {
                    zzb2.zza("adapter_v", zzcab.toString());
                }
                zzcab zzcab2 = zzb3.zzc;
                if (zzcab2 != null) {
                    zzb2.zza("adapter_sv", zzcab2.toString());
                }
            }
            this.zzd.zzb(zzb2);
            return;
        }
        zzdyy zza3 = this.zzc.zza();
        zza3.zzd(zzfdq);
        zza3.zzc(zzfdn);
        zza3.zzb(NativeProtocol.WEB_DIALOG_ACTION, "adapter_status");
        zza3.zzb("adapter_l", String.valueOf(j11));
        zza3.zzb("sc", Integer.toString(i11));
        if (zzehx != null) {
            zza3.zzb("arec", Integer.toString(zzehx.zzb().zza));
            String zza4 = this.zza.zza(zzehx.getMessage());
            if (zza4 != null) {
                zza3.zzb("areec", zza4);
            }
        }
        zzdws zzb4 = this.zzb.zzb(zzfdn.zzu);
        if (zzb4 != null) {
            zza3.zzb("ancn", zzb4.zza);
            zzcab zzcab3 = zzb4.zzb;
            if (zzcab3 != null) {
                zza3.zzb("adapter_v", zzcab3.toString());
            }
            zzcab zzcab4 = zzb4.zzc;
            if (zzcab4 != null) {
                zza3.zzb("adapter_sv", zzcab4.toString());
            }
        }
        zza3.zzf();
    }
}
