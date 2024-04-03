package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzeun implements zzevn<zzeuo> {
    final String zza;
    private final zzfxb zzb;
    private final ScheduledExecutorService zzc;
    private final zzenu zzd;
    private final Context zze;
    private final zzfef zzf;
    private final zzenq zzg;
    private final zzdww zzh;

    public zzeun(zzfxb zzfxb, ScheduledExecutorService scheduledExecutorService, String str, zzenu zzenu, Context context, zzfef zzfef, zzenq zzenq, zzdww zzdww) {
        this.zzb = zzfxb;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzenu;
        this.zze = context;
        this.zzf = zzfef;
        this.zzg = zzenq;
        this.zzh = zzdww;
    }

    public static /* synthetic */ zzfxa zza(zzeun zzeun) {
        String str;
        Class<Throwable> cls;
        Bundle bundle;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhp)).booleanValue()) {
            str = zzeun.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzeun.zzf.zzf;
        }
        Map<String, List<Bundle>> zza2 = zzeun.zzd.zza(zzeun.zza, str);
        ArrayList arrayList = new ArrayList();
        Iterator it = ((zzfsw) zza2).entrySet().iterator();
        while (true) {
            cls = Throwable.class;
            Bundle bundle2 = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            Bundle bundle3 = zzeun.zzf.zzd.zzm;
            if (bundle3 != null) {
                bundle2 = bundle3.getBundle(str2);
            }
            arrayList.add(zzfwq.zzf((zzfwh) zzfwq.zzo(zzfwh.zzw(zzfwq.zzl(new zzeul(zzeun, str2, list, bundle2), zzeun.zzb)), ((Long) zzbgq.zzc().zzb(zzblj.zzbd)).longValue(), TimeUnit.MILLISECONDS, zzeun.zzc), cls, new zzeuh(str2), zzeun.zzb));
        }
        for (Map.Entry value : ((zzfsw) zzeun.zzd.zzb()).entrySet()) {
            zzeny zzeny = (zzeny) value.getValue();
            String str3 = zzeny.zza;
            Bundle bundle4 = zzeun.zzf.zzd.zzm;
            if (bundle4 != null) {
                bundle = bundle4.getBundle(str3);
            } else {
                bundle = null;
            }
            arrayList.add(zzfwq.zzf((zzfwh) zzfwq.zzo(zzfwh.zzw(zzfwq.zzl(new zzeuk(zzeun, str3, zzeny, bundle), zzeun.zzb)), ((Long) zzbgq.zzc().zzb(zzblj.zzbd)).longValue(), TimeUnit.MILLISECONDS, zzeun.zzc), cls, new zzeui(str3), zzeun.zzb));
        }
        return zzfwq.zzc(arrayList).zza(new zzeum(arrayList), zzeun.zzb);
    }

    private final zzfxa<JSONObject> zze(String str, List<Bundle> list, Bundle bundle, boolean z11, boolean z12) throws RemoteException {
        zzbzo zzbzo;
        zzcjr zzcjr = new zzcjr();
        if (z12) {
            this.zzg.zzb(str);
            zzbzo = this.zzg.zza(str);
        } else {
            try {
                zzbzo = this.zzh.zza(str);
            } catch (RemoteException e11) {
                zzciz.zzh("Couldn't create RTB adapter : ", e11);
                zzbzo = null;
            }
        }
        zzbzo zzbzo2 = zzbzo;
        zzbzo2.getClass();
        zzenx zzenx = new zzenx(str, zzbzo2, zzcjr);
        if (z11) {
            zzbzo2.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, list.get(0), this.zzf.zze, zzenx);
        } else {
            zzenx.zzb();
        }
        return zzcjr;
    }

    public final zzfxa<zzeuo> zzb() {
        return zzfwq.zzl(new zzeuj(this), this.zzb);
    }

    public final /* synthetic */ zzfxa zzc(String str, List list, Bundle bundle) throws Exception {
        return zze(str, list, bundle, true, true);
    }

    public final /* synthetic */ zzfxa zzd(String str, zzeny zzeny, Bundle bundle) throws Exception {
        return zze(str, Collections.singletonList(zzeny.zzd), bundle, zzeny.zzb, zzeny.zzc);
    }
}
