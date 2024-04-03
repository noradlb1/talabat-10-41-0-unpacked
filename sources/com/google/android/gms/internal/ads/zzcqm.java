package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zzb;
import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzcqm implements zzcvo {
    @GuardedBy("AppComponent.class")
    private static zzcqm zza;

    @Deprecated
    public static synchronized zzcqm zza(zzcjf zzcjf, Context context, zzcuj zzcuj) {
        zzcqm zzcqm;
        synchronized (zzcqm.class) {
            if (zza == null) {
                zzcsu zzcsu = new zzcsu((zzcst) null);
                zzcqn zzcqn = new zzcqn();
                zzcqn.zzd(zzcjf);
                zzcqn.zzc(context);
                zzcsu.zzb(new zzcqp(zzcqn, (zzcqo) null));
                zzcsu.zzc(new zzcuk(zzcuj));
                zza = zzcsu.zza();
                zzblj.zzc(context);
                zzt.zzo().zzq(context, zzcjf);
                zzt.zzc().zzi(context);
                zzt.zzp().zzr(context);
                zzt.zzp().zzq(context);
                zzt.zzp().zzl(context);
                zzd.zza(context);
                zzt.zzb().zzd(context);
                zzt.zzv().zzb(context);
                zzchi.zzd(context);
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeE)).booleanValue()) {
                    if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzap)).booleanValue()) {
                        zzbay zzbay = new zzbay(new zzbbc(context));
                        zzegh zzegh = new zzegh(new zzegd(context), zza.zzB());
                        zzt.zzp();
                        new zzegz(context, zzcjf, zzbay, zzegh, UUID.randomUUID().toString(), zza.zzz()).zzb(zzt.zzo().zzh().zzL());
                    }
                }
            }
            zzcqm = zza;
        }
        return zzcqm;
    }

    @Deprecated
    public static zzcqm zzb(Context context, int i11) {
        synchronized (zzcqm.class) {
            zzcqm zzcqm = zza;
            if (zzcqm != null) {
                return zzcqm;
            }
            return zza(new zzcjf(214106000, i11, true, false), context, new zzcrm());
        }
    }

    public static zzcqm zzc(Context context, zzbxh zzbxh, int i11) {
        zzcqm zzb = zzb(context, i11);
        zzb.zzl().zzc(zzbxh);
        return zzb;
    }

    public abstract zzfjg zzA();

    public abstract zzfxb zzB();

    public abstract Executor zzC();

    public abstract ScheduledExecutorService zzD();

    public abstract zzcuu zzd();

    public abstract zzcxy zze();

    public abstract zzcyj zzf();

    public abstract zzczs zzg();

    public abstract zzdhg zzh();

    public abstract zzdns zzi();

    public abstract zzdoo zzj();

    public abstract zzdvr zzk();

    public abstract zzdww zzl();

    public abstract zzeah zzm();

    public abstract zzebt zzn();

    public abstract zzehp zzo();

    public abstract zzb zzp();

    public abstract zzf zzq();

    public abstract zzv zzr();

    public final zzewf zzs(zzcdq zzcdq, int i11) {
        return zzt(new zzexm(zzcdq, i11));
    }

    public abstract zzewf zzt(zzexm zzexm);

    public abstract zzeyl zzu();

    public abstract zzezz zzv();

    public abstract zzfbs zzw();

    public abstract zzfdg zzx();

    public abstract zzfew<zzduy> zzy();

    public abstract zzfio zzz();
}
