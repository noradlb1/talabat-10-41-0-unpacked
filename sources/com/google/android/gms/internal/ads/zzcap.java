package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzt;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcap extends zzcaq implements zzbrt<zzcop> {
    DisplayMetrics zza;
    int zzb = -1;
    int zzc = -1;
    int zzd = -1;
    int zze = -1;
    int zzf = -1;
    int zzg = -1;
    private final zzcop zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbkt zzk;
    private float zzl;
    private int zzm;

    public zzcap(zzcop zzcop, Context context, zzbkt zzbkt) {
        super(zzcop, "");
        this.zzh = zzcop;
        this.zzi = context;
        this.zzk = zzbkt;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObject;
        zzcop zzcop = (zzcop) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        zzbgo.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzcis.zzq(displayMetrics, displayMetrics.widthPixels);
        zzbgo.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzcis.zzq(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzk2 = this.zzh.zzk();
        if (zzk2 == null || zzk2.getWindow() == null) {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        } else {
            zzt.zzp();
            int[] zzU = com.google.android.gms.ads.internal.util.zzt.zzU(zzk2);
            zzbgo.zzb();
            this.zzd = zzcis.zzq(this.zza, zzU[0]);
            zzbgo.zzb();
            this.zze = zzcis.zzq(this.zza, zzU[1]);
        }
        if (this.zzh.zzQ().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzi(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzcao zzcao = new zzcao();
        zzbkt zzbkt = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzcao.zze(zzbkt.zza(intent));
        zzbkt zzbkt2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzcao.zzc(zzbkt2.zza(intent2));
        zzcao.zza(this.zzk.zzb());
        zzcao.zzd(this.zzk.zzc());
        zzcao.zzb(true);
        boolean zzh2 = zzcao.zza;
        boolean zzj2 = zzcao.zzb;
        boolean zzf2 = zzcao.zzc;
        boolean zzi2 = zzcao.zzd;
        boolean zzg2 = zzcao.zze;
        zzcop zzcop2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", zzh2).put("tel", zzj2).put("calendar", zzf2).put("storePicture", zzi2).put("inlineVideo", zzg2);
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while obtaining the MRAID capabilities.", e11);
            jSONObject = null;
        }
        zzcop2.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(zzbgo.zzb().zzb(this.zzi, iArr[0]), zzbgo.zzb().zzb(this.zzi, iArr[1]));
        if (zzciz.zzm(2)) {
            zzciz.zzi("Dispatching Ready Event.");
        }
        zzh(this.zzh.zzp().zza);
    }

    public final void zzb(int i11, int i12) {
        int i13;
        int i14 = 0;
        if (this.zzi instanceof Activity) {
            zzt.zzp();
            i13 = com.google.android.gms.ads.internal.util.zzt.zzW((Activity) this.zzi)[0];
        } else {
            i13 = 0;
        }
        if (this.zzh.zzQ() == null || !this.zzh.zzQ().zzi()) {
            int width = this.zzh.getWidth();
            int height = this.zzh.getHeight();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzM)).booleanValue()) {
                if (width == 0) {
                    if (this.zzh.zzQ() != null) {
                        width = this.zzh.zzQ().zzb;
                    } else {
                        width = 0;
                    }
                }
                if (height == 0) {
                    if (this.zzh.zzQ() != null) {
                        i14 = this.zzh.zzQ().zza;
                    }
                    this.zzf = zzbgo.zzb().zzb(this.zzi, width);
                    this.zzg = zzbgo.zzb().zzb(this.zzi, i14);
                }
            }
            i14 = height;
            this.zzf = zzbgo.zzb().zzb(this.zzi, width);
            this.zzg = zzbgo.zzb().zzb(this.zzi, i14);
        }
        zzf(i11, i12 - i13, this.zzf, this.zzg);
        this.zzh.zzP().zzA(i11, i12);
    }
}
