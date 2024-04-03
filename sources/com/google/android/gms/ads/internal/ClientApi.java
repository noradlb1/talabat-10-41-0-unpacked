package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzab;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbht;
import com.google.android.gms.internal.ads.zzbib;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbos;
import com.google.android.gms.internal.ads.zzbso;
import com.google.android.gms.internal.ads.zzbsr;
import com.google.android.gms.internal.ads.zzbxh;
import com.google.android.gms.internal.ads.zzcbg;
import com.google.android.gms.internal.ads.zzcbs;
import com.google.android.gms.internal.ads.zzcej;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcht;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcqm;
import com.google.android.gms.internal.ads.zzdqv;
import com.google.android.gms.internal.ads.zzdqx;
import com.google.android.gms.internal.ads.zzeah;
import com.google.android.gms.internal.ads.zzeob;
import com.google.android.gms.internal.ads.zzeyl;
import com.google.android.gms.internal.ads.zzeym;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfbs;
import com.google.android.gms.internal.ads.zzfdg;
import java.util.HashMap;

public class ClientApi extends zzbht {
    public final zzbhg zzb(IObjectWrapper iObjectWrapper, String str, zzbxh zzbxh, int i11) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeob(zzcqm.zzc(context, zzbxh, i11), context, str);
    }

    public final zzbhk zzc(IObjectWrapper iObjectWrapper, zzbfi zzbfi, String str, zzbxh zzbxh, int i11) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeyl zzu = zzcqm.zzc(context, zzbxh, i11).zzu();
        zzu.zza(str);
        zzu.zzb(context);
        zzeym zzc = zzu.zzc();
        if (i11 >= ((Integer) zzbgq.zzc().zzb(zzblj.zzdJ)).intValue()) {
            return zzc.zzb();
        }
        return zzc.zza();
    }

    public final zzbhk zzd(IObjectWrapper iObjectWrapper, zzbfi zzbfi, String str, zzbxh zzbxh, int i11) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezz zzv = zzcqm.zzc(context, zzbxh, i11).zzv();
        zzv.zzc(context);
        zzv.zza(zzbfi);
        zzv.zzb(str);
        return zzv.zzd().zza();
    }

    public final zzbhk zze(IObjectWrapper iObjectWrapper, zzbfi zzbfi, String str, zzbxh zzbxh, int i11) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfbs zzw = zzcqm.zzc(context, zzbxh, i11).zzw();
        zzw.zzc(context);
        zzw.zza(zzbfi);
        zzw.zzb(str);
        return zzw.zzd().zza();
    }

    public final zzbhk zzf(IObjectWrapper iObjectWrapper, zzbfi zzbfi, String str, int i11) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbfi, str, new zzcjf(214106000, i11, true, false));
    }

    public final zzbib zzg(IObjectWrapper iObjectWrapper, int i11) {
        return zzcqm.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), i11).zzd();
    }

    public final zzbom zzh(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdqx((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 214106000);
    }

    public final zzbos zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdqv((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzbsr zzj(IObjectWrapper iObjectWrapper, zzbxh zzbxh, int i11, zzbso zzbso) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeah zzm = zzcqm.zzc(context, zzbxh, i11).zzm();
        zzm.zzb(context);
        zzm.zza(zzbso);
        return zzm.zzc().zzd();
    }

    public final zzcbg zzk(IObjectWrapper iObjectWrapper, zzbxh zzbxh, int i11) {
        return zzcqm.zzc((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbxh, i11).zzo();
    }

    public final zzcbs zzl(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new zzt(activity);
        }
        int i11 = zza.zzk;
        if (i11 == 1) {
            return new zzs(activity);
        }
        if (i11 == 2) {
            return new zzab(activity);
        }
        if (i11 == 3) {
            return new zzac(activity);
        }
        if (i11 == 4) {
            return new zzv(activity, zza);
        }
        if (i11 != 5) {
            return new zzt(activity);
        }
        return new zzz(activity);
    }

    public final zzcej zzm(IObjectWrapper iObjectWrapper, zzbxh zzbxh, int i11) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfdg zzx = zzcqm.zzc(context, zzbxh, i11).zzx();
        zzx.zzb(context);
        return zzx.zzc().zzb();
    }

    public final zzcez zzn(IObjectWrapper iObjectWrapper, String str, zzbxh zzbxh, int i11) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfdg zzx = zzcqm.zzc(context, zzbxh, i11).zzx();
        zzx.zzb(context);
        zzx.zza(str);
        return zzx.zzc().zza();
    }

    public final zzcht zzo(IObjectWrapper iObjectWrapper, zzbxh zzbxh, int i11) {
        return zzcqm.zzc((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbxh, i11).zzr();
    }
}
