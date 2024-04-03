package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicReference;

public final class zzezj implements zzdeu, zzdgq, zzfaz, zzo, zzdhc, zzdfh, zzdmd {
    private final zzffj zza;
    private final AtomicReference<zzazw> zzb = new AtomicReference<>();
    private final AtomicReference<zzazx> zzc = new AtomicReference<>();
    private final AtomicReference<zzbaa> zzd = new AtomicReference<>();
    private final AtomicReference<zzdgq> zze = new AtomicReference<>();
    private final AtomicReference<zzo> zzf = new AtomicReference<>();
    private final AtomicReference<zzbit> zzg = new AtomicReference<>();
    private zzezj zzh = null;

    public zzezj(zzffj zzffj) {
        this.zza = zzffj;
    }

    public static zzezj zzi(zzezj zzezj) {
        zzezj zzezj2 = new zzezj(zzezj.zza);
        zzezj2.zzh = zzezj;
        return zzezj2;
    }

    public final void zza(zzbew zzbew) {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zza(zzbew);
            return;
        }
        zzfaq.zza(this.zzb, new zzeza(zzbew));
        zzfaq.zza(this.zzb, new zzezb(zzbew));
    }

    public final void zzb() {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzb();
            return;
        }
        zzfaq.zza(this.zzf, zzeyx.zza);
        zzfaq.zza(this.zzd, zzeyv.zza);
        zzfaq.zza(this.zzd, zzezi.zza);
    }

    public final void zzbK() {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzbK();
        } else {
            zzfaq.zza(this.zzf, zzeyw.zza);
        }
    }

    public final void zzbS() {
    }

    public final void zzbT(zzfaz zzfaz) {
        this.zzh = (zzezj) zzfaz;
    }

    public final void zzbz() {
    }

    public final void zze() {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zze();
        } else {
            zzfaq.zza(this.zzf, zzeyy.zza);
        }
    }

    public final void zzf(int i11) {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzf(i11);
        } else {
            zzfaq.zza(this.zzf, new zzeze(i11));
        }
    }

    public final void zzg(@NonNull zzbfk zzbfk) {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzg(zzbfk);
        } else {
            zzfaq.zza(this.zzg, new zzezd(zzbfk));
        }
    }

    public final void zzh() {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzh();
        } else {
            zzfaq.zza(this.zze, zzeyz.zza);
        }
    }

    public final void zzj() {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzj();
            return;
        }
        this.zza.zza();
        zzfaq.zza(this.zzc, zzezf.zza);
        zzfaq.zza(this.zzd, zzezh.zza);
    }

    public final void zzk(zzbew zzbew) {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzk(zzbew);
        } else {
            zzfaq.zza(this.zzd, new zzezc(zzbew));
        }
    }

    public final void zzl(zzazt zzazt) {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzl(zzazt);
        } else {
            zzfaq.zza(this.zzb, new zzeyu(zzazt));
        }
    }

    public final void zzn(zzdgq zzdgq) {
        this.zze.set(zzdgq);
    }

    public final void zzo(zzo zzo) {
        this.zzf.set(zzo);
    }

    public final void zzp(zzbit zzbit) {
        this.zzg.set(zzbit);
    }

    public final void zzq() {
        zzezj zzezj = this.zzh;
        if (zzezj != null) {
            zzezj.zzq();
        } else {
            zzfaq.zza(this.zzd, zzezg.zza);
        }
    }

    public final void zzr(zzazw zzazw) {
        this.zzb.set(zzazw);
    }

    public final void zzs(zzbaa zzbaa) {
        this.zzd.set(zzbaa);
    }

    public final void zzt(zzazx zzazx) {
        this.zzc.set(zzazx);
    }
}
