package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

final class zzcyz extends zzcyw {
    private final Context zzc;
    private final View zzd;
    @Nullable
    private final zzcop zze;
    private final zzfdo zzf;
    private final zzdat zzg;
    private final zzdqn zzh;
    private final zzdmf zzi;
    private final zzgpl<zzenz> zzj;
    private final Executor zzk;
    private zzbfi zzl;

    public zzcyz(zzdau zzdau, Context context, zzfdo zzfdo, View view, @Nullable zzcop zzcop, zzdat zzdat, zzdqn zzdqn, zzdmf zzdmf, zzgpl<zzenz> zzgpl, Executor executor) {
        super(zzdau);
        this.zzc = context;
        this.zzd = view;
        this.zze = zzcop;
        this.zzf = zzfdo;
        this.zzg = zzdat;
        this.zzh = zzdqn;
        this.zzi = zzdmf;
        this.zzj = zzgpl;
        this.zzk = executor;
    }

    public static /* synthetic */ void zzi(zzcyz zzcyz) {
        if (zzcyz.zzh.zze() != null) {
            try {
                zzcyz.zzh.zze().zze(zzcyz.zzj.zzb(), ObjectWrapper.wrap(zzcyz.zzc));
            } catch (RemoteException e11) {
                zzciz.zzh("RemoteException when notifyAdLoad is called", e11);
            }
        }
    }

    public final void zzU() {
        this.zzk.execute(new zzcyy(this));
        super.zzU();
    }

    public final int zza() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfI)).booleanValue() && this.zzb.zzae) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfJ)).booleanValue()) {
                return 0;
            }
        }
        return this.zza.zzb.zzb.zzc;
    }

    public final View zzc() {
        return this.zzd;
    }

    public final zzbiz zzd() {
        try {
            return this.zzg.zza();
        } catch (zzfek unused) {
            return null;
        }
    }

    public final zzfdo zze() {
        zzbfi zzbfi = this.zzl;
        if (zzbfi != null) {
            return zzfej.zzc(zzbfi);
        }
        zzfdn zzfdn = this.zzb;
        if (zzfdn.zzZ) {
            for (String next : zzfdn.zza) {
                if (next == null || !next.contains("FirstParty")) {
                }
            }
            return new zzfdo(this.zzd.getWidth(), this.zzd.getHeight(), false);
        }
        return zzfej.zzb(this.zzb.zzs, this.zzf);
    }

    public final zzfdo zzf() {
        return this.zzf;
    }

    public final void zzg() {
        this.zzi.zza();
    }

    public final void zzh(ViewGroup viewGroup, zzbfi zzbfi) {
        zzcop zzcop;
        if (viewGroup != null && (zzcop = this.zze) != null) {
            zzcop.zzai(zzcqe.zzc(zzbfi));
            viewGroup.setMinimumHeight(zzbfi.zzc);
            viewGroup.setMinimumWidth(zzbfi.zzf);
            this.zzl = zzbfi;
        }
    }
}
