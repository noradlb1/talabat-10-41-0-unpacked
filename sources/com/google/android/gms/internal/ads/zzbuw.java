package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;
import com.instabug.library.model.NetworkLog;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbuw implements zzbuo, zzbum {
    private final zzcop zza;

    public zzbuw(Context context, zzcjf zzcjf, @Nullable zzalt zzalt, zza zza2) throws zzcpa {
        zzt.zzz();
        zzcop zza3 = zzcpb.zza(context, zzcqe.zza(), "", false, false, (zzalt) null, (zzbmi) null, zzcjf, (zzbly) null, (zzl) null, (zza) null, zzbay.zza(), (zzfdn) null, (zzfdq) null);
        this.zza = zza3;
        ((View) zza3).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzbgo.zzb();
        if (zzcis.zzp()) {
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zzt.zza.post(runnable);
        }
    }

    public final void zza(String str) {
        zzs(new zzbur(this, str));
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbul.zzc(this, str, str2);
    }

    public final void zzc() {
        this.zza.destroy();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbul.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbul.zzb(this, str, jSONObject);
    }

    public final void zzf(String str) {
        zzs(new zzbus(this, str));
    }

    public final void zzg(String str) {
        zzs(new zzbut(this, str));
    }

    public final void zzh(String str) {
        zzs(new zzbuu(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final boolean zzi() {
        return this.zza.zzaB();
    }

    public final zzbvv zzj() {
        return new zzbvv(this);
    }

    public final void zzk(zzbuy zzbuy) {
        this.zza.zzP().zzF(new zzbup(zzbuy, (byte[]) null));
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbul.zzd(this, str, jSONObject);
    }

    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, NetworkLog.HTML, "UTF-8");
    }

    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, NetworkLog.HTML, "UTF-8");
    }

    public final void zzq(String str, zzbrt<? super zzbvu> zzbrt) {
        this.zza.zzaf(str, new zzbuv(this, zzbrt));
    }

    public final void zzr(String str, zzbrt<? super zzbvu> zzbrt) {
        this.zza.zzax(str, new zzbuq(zzbrt));
    }
}
