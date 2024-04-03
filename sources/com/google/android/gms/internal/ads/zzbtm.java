package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public final class zzbtm implements zzagl {
    /* access modifiers changed from: private */
    public volatile zzbsz zza;
    private final Context zzb;

    public zzbtm(Context context) {
        this.zzb = context;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzbtm zzbtm) {
        if (zzbtm.zza != null) {
            zzbtm.zza.disconnect();
            Binder.flushPendingCommands();
        }
    }

    public final zzago zza(zzags<?> zzags) throws zzahb {
        Parcelable.Creator<zzbta> creator = zzbta.CREATOR;
        Map<String, String> zzl = zzags.zzl();
        int size = zzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i11 = 0;
        int i12 = 0;
        for (Map.Entry next : zzl.entrySet()) {
            strArr[i12] = (String) next.getKey();
            strArr2[i12] = (String) next.getValue();
            i12++;
        }
        zzbta zzbta = new zzbta(zzags.zzk(), strArr, strArr2);
        long elapsedRealtime = zzt.zzA().elapsedRealtime();
        try {
            zzcjr zzcjr = new zzcjr();
            this.zza = new zzbsz(this.zzb, zzt.zzt().zzb(), new zzbtk(this, zzcjr), new zzbtl(this, zzcjr));
            this.zza.checkAvailabilityAndConnect();
            zzbti zzbti = new zzbti(this, zzbta);
            zzfxb zzfxb = zzcjm.zza;
            zzfxa zzo = zzfwq.zzo(zzfwq.zzn(zzcjr, zzbti, zzfxb), (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzcZ)).intValue(), TimeUnit.MILLISECONDS, zzcjm.zzd);
            zzo.zzc(new zzbtj(this), zzfxb);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) zzo.get();
            long elapsedRealtime2 = zzt.zzA().elapsedRealtime();
            StringBuilder sb2 = new StringBuilder(52);
            sb2.append("Http assets remote cache took ");
            sb2.append(elapsedRealtime2 - elapsedRealtime);
            sb2.append("ms");
            zze.zza(sb2.toString());
            zzbtc zzbtc = (zzbtc) new zzcdo(parcelFileDescriptor).zza(zzbtc.CREATOR);
            if (zzbtc == null) {
                return null;
            }
            if (zzbtc.zza) {
                throw new zzahb(zzbtc.zzb);
            } else if (zzbtc.zze.length != zzbtc.zzf.length) {
                return null;
            } else {
                HashMap hashMap = new HashMap();
                while (true) {
                    String[] strArr3 = zzbtc.zze;
                    if (i11 >= strArr3.length) {
                        return new zzago(zzbtc.zzc, zzbtc.zzd, (Map<String, String>) hashMap, zzbtc.zzg, zzbtc.zzh);
                    }
                    hashMap.put(strArr3[i11], zzbtc.zzf[i11]);
                    i11++;
                }
            }
        } catch (InterruptedException | ExecutionException unused) {
            long elapsedRealtime3 = zzt.zzA().elapsedRealtime();
            StringBuilder sb3 = new StringBuilder(52);
            sb3.append("Http assets remote cache took ");
            sb3.append(elapsedRealtime3 - elapsedRealtime);
            sb3.append("ms");
            zze.zza(sb3.toString());
            return null;
        } catch (Throwable th2) {
            long elapsedRealtime4 = zzt.zzA().elapsedRealtime();
            StringBuilder sb4 = new StringBuilder(52);
            sb4.append("Http assets remote cache took ");
            sb4.append(elapsedRealtime4 - elapsedRealtime);
            sb4.append("ms");
            zze.zza(sb4.toString());
            throw th2;
        }
    }
}
