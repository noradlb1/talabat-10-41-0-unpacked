package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

public final class zzdqc {
    private int zza;
    private zzbiz zzb;
    private zzboa zzc;
    private View zzd;
    private List<?> zze;
    private List<zzbjs> zzf = Collections.emptyList();
    private zzbjs zzg;
    private Bundle zzh;
    private zzcop zzi;
    private zzcop zzj;
    @Nullable
    private zzcop zzk;
    @Nullable
    private IObjectWrapper zzl;
    private View zzm;
    private View zzn;
    private IObjectWrapper zzo;
    private double zzp;
    private zzboi zzq;
    private zzboi zzr;
    private String zzs;
    private final SimpleArrayMap<String, zzbnu> zzt = new SimpleArrayMap<>();
    private final SimpleArrayMap<String, String> zzu = new SimpleArrayMap<>();
    private float zzv;
    @Nullable
    private String zzw;

    public static zzdqc zzab(zzbxs zzbxs) {
        try {
            zzdqb zzaf = zzaf(zzbxs.zzg(), (zzbxw) null);
            zzboa zzh2 = zzbxs.zzh();
            String zzo2 = zzbxs.zzo();
            List<?> zzr2 = zzbxs.zzr();
            String zzm2 = zzbxs.zzm();
            Bundle zzf2 = zzbxs.zzf();
            String zzn2 = zzbxs.zzn();
            IObjectWrapper zzl2 = zzbxs.zzl();
            String zzq2 = zzbxs.zzq();
            String zzp2 = zzbxs.zzp();
            double zze2 = zzbxs.zze();
            zzboi zzi2 = zzbxs.zzi();
            zzdqc zzdqc = new zzdqc();
            zzdqc.zza = 2;
            zzdqc.zzb = zzaf;
            zzdqc.zzc = zzh2;
            zzdqc.zzd = (View) zzah(zzbxs.zzj());
            zzdqc.zzU("headline", zzo2);
            zzdqc.zze = zzr2;
            zzdqc.zzU("body", zzm2);
            zzdqc.zzh = zzf2;
            zzdqc.zzU("call_to_action", zzn2);
            zzdqc.zzm = (View) zzah(zzbxs.zzk());
            zzdqc.zzo = zzl2;
            zzdqc.zzU("store", zzq2);
            zzdqc.zzU(FirebaseAnalytics.Param.PRICE, zzp2);
            zzdqc.zzp = zze2;
            zzdqc.zzq = zzi2;
            return zzdqc;
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to get native ad from app install ad mapper", e11);
            return null;
        }
    }

    public static zzdqc zzac(zzbxt zzbxt) {
        try {
            zzdqb zzaf = zzaf(zzbxt.zzf(), (zzbxw) null);
            zzboa zzg2 = zzbxt.zzg();
            String zzo2 = zzbxt.zzo();
            List<?> zzp2 = zzbxt.zzp();
            String zzm2 = zzbxt.zzm();
            Bundle zze2 = zzbxt.zze();
            String zzn2 = zzbxt.zzn();
            IObjectWrapper zzk2 = zzbxt.zzk();
            String zzl2 = zzbxt.zzl();
            zzboi zzh2 = zzbxt.zzh();
            zzdqc zzdqc = new zzdqc();
            zzdqc.zza = 1;
            zzdqc.zzb = zzaf;
            zzdqc.zzc = zzg2;
            zzdqc.zzd = (View) zzah(zzbxt.zzi());
            zzdqc.zzU("headline", zzo2);
            zzdqc.zze = zzp2;
            zzdqc.zzU("body", zzm2);
            zzdqc.zzh = zze2;
            zzdqc.zzU("call_to_action", zzn2);
            zzdqc.zzm = (View) zzah(zzbxt.zzj());
            zzdqc.zzo = zzk2;
            zzdqc.zzU("advertiser", zzl2);
            zzdqc.zzr = zzh2;
            return zzdqc;
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to get native ad from content ad mapper", e11);
            return null;
        }
    }

    public static zzdqc zzad(zzbxs zzbxs) {
        try {
            return zzag(zzaf(zzbxs.zzg(), (zzbxw) null), zzbxs.zzh(), (View) zzah(zzbxs.zzj()), zzbxs.zzo(), zzbxs.zzr(), zzbxs.zzm(), zzbxs.zzf(), zzbxs.zzn(), (View) zzah(zzbxs.zzk()), zzbxs.zzl(), zzbxs.zzq(), zzbxs.zzp(), zzbxs.zze(), zzbxs.zzi(), (String) null, 0.0f);
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to get native ad assets from app install ad mapper", e11);
            return null;
        }
    }

    public static zzdqc zzae(zzbxt zzbxt) {
        try {
            return zzag(zzaf(zzbxt.zzf(), (zzbxw) null), zzbxt.zzg(), (View) zzah(zzbxt.zzi()), zzbxt.zzo(), zzbxt.zzp(), zzbxt.zzm(), zzbxt.zze(), zzbxt.zzn(), (View) zzah(zzbxt.zzj()), zzbxt.zzk(), (String) null, (String) null, -1.0d, zzbxt.zzh(), zzbxt.zzl(), 0.0f);
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to get native ad assets from content ad mapper", e11);
            return null;
        }
    }

    private static zzdqb zzaf(zzbiz zzbiz, @Nullable zzbxw zzbxw) {
        if (zzbiz == null) {
            return null;
        }
        return new zzdqb(zzbiz, zzbxw);
    }

    private static zzdqc zzag(zzbiz zzbiz, zzboa zzboa, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d11, zzboi zzboi, String str6, float f11) {
        zzdqc zzdqc = new zzdqc();
        zzdqc.zza = 6;
        zzdqc.zzb = zzbiz;
        zzdqc.zzc = zzboa;
        zzdqc.zzd = view;
        String str7 = str;
        zzdqc.zzU("headline", str);
        zzdqc.zze = list;
        String str8 = str2;
        zzdqc.zzU("body", str2);
        zzdqc.zzh = bundle;
        String str9 = str3;
        zzdqc.zzU("call_to_action", str3);
        zzdqc.zzm = view2;
        zzdqc.zzo = iObjectWrapper;
        String str10 = str4;
        zzdqc.zzU("store", str4);
        String str11 = str5;
        zzdqc.zzU(FirebaseAnalytics.Param.PRICE, str5);
        zzdqc.zzp = d11;
        zzdqc.zzq = zzboi;
        zzdqc.zzU("advertiser", str6);
        zzdqc.zzP(f11);
        return zzdqc;
    }

    private static <T> T zzah(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzdqc zzs(zzbxw zzbxw) {
        try {
            return zzag(zzaf(zzbxw.zzj(), zzbxw), zzbxw.zzk(), (View) zzah(zzbxw.zzm()), zzbxw.zzs(), zzbxw.zzv(), zzbxw.zzq(), zzbxw.zzi(), zzbxw.zzr(), (View) zzah(zzbxw.zzn()), zzbxw.zzo(), zzbxw.zzu(), zzbxw.zzt(), zzbxw.zze(), zzbxw.zzl(), zzbxw.zzp(), zzbxw.zzf());
        } catch (RemoteException e11) {
            zzciz.zzk("Failed to get native ad assets from unified ad mapper", e11);
            return null;
        }
    }

    @Nullable
    public final synchronized String zzA() {
        return this.zzw;
    }

    public final synchronized String zzB() {
        return zzD(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized String zzC() {
        return zzD("store");
    }

    public final synchronized String zzD(String str) {
        return this.zzu.get(str);
    }

    public final synchronized List<?> zzE() {
        return this.zze;
    }

    public final synchronized List<zzbjs> zzF() {
        return this.zzf;
    }

    public final synchronized void zzG() {
        zzcop zzcop = this.zzi;
        if (zzcop != null) {
            zzcop.destroy();
            this.zzi = null;
        }
        zzcop zzcop2 = this.zzj;
        if (zzcop2 != null) {
            zzcop2.destroy();
            this.zzj = null;
        }
        zzcop zzcop3 = this.zzk;
        if (zzcop3 != null) {
            zzcop3.destroy();
            this.zzk = null;
        }
        this.zzl = null;
        this.zzt.clear();
        this.zzu.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzm = null;
        this.zzn = null;
        this.zzo = null;
        this.zzq = null;
        this.zzr = null;
        this.zzs = null;
    }

    public final synchronized void zzH(zzboa zzboa) {
        this.zzc = zzboa;
    }

    public final synchronized void zzI(String str) {
        this.zzs = str;
    }

    public final synchronized void zzJ(@Nullable zzbjs zzbjs) {
        this.zzg = zzbjs;
    }

    public final synchronized void zzK(zzboi zzboi) {
        this.zzq = zzboi;
    }

    public final synchronized void zzL(String str, zzbnu zzbnu) {
        if (zzbnu == null) {
            this.zzt.remove(str);
        } else {
            this.zzt.put(str, zzbnu);
        }
    }

    public final synchronized void zzM(zzcop zzcop) {
        this.zzj = zzcop;
    }

    public final synchronized void zzN(List<zzbnu> list) {
        this.zze = list;
    }

    public final synchronized void zzO(zzboi zzboi) {
        this.zzr = zzboi;
    }

    public final synchronized void zzP(float f11) {
        this.zzv = f11;
    }

    public final synchronized void zzQ(List<zzbjs> list) {
        this.zzf = list;
    }

    public final synchronized void zzR(zzcop zzcop) {
        this.zzk = zzcop;
    }

    public final synchronized void zzS(@Nullable String str) {
        this.zzw = str;
    }

    public final synchronized void zzT(double d11) {
        this.zzp = d11;
    }

    public final synchronized void zzU(String str, String str2) {
        if (str2 == null) {
            this.zzu.remove(str);
        } else {
            this.zzu.put(str, str2);
        }
    }

    public final synchronized void zzV(int i11) {
        this.zza = i11;
    }

    public final synchronized void zzW(zzbiz zzbiz) {
        this.zzb = zzbiz;
    }

    public final synchronized void zzX(View view) {
        this.zzm = view;
    }

    public final synchronized void zzY(zzcop zzcop) {
        this.zzi = zzcop;
    }

    public final synchronized void zzZ(View view) {
        this.zzn = view;
    }

    public final synchronized double zza() {
        return this.zzp;
    }

    public final synchronized void zzaa(IObjectWrapper iObjectWrapper) {
        this.zzl = iObjectWrapper;
    }

    public final synchronized float zzb() {
        return this.zzv;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzm;
    }

    public final synchronized View zzg() {
        return this.zzn;
    }

    public final synchronized SimpleArrayMap<String, zzbnu> zzh() {
        return this.zzt;
    }

    public final synchronized SimpleArrayMap<String, String> zzi() {
        return this.zzu;
    }

    public final synchronized zzbiz zzj() {
        return this.zzb;
    }

    @Nullable
    public final synchronized zzbjs zzk() {
        return this.zzg;
    }

    public final synchronized zzboa zzl() {
        return this.zzc;
    }

    @Nullable
    public final zzboi zzm() {
        List<?> list = this.zze;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zze.get(0);
            if (obj instanceof IBinder) {
                return zzboh.zzg((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized zzboi zzn() {
        return this.zzq;
    }

    public final synchronized zzboi zzo() {
        return this.zzr;
    }

    public final synchronized zzcop zzp() {
        return this.zzj;
    }

    @Nullable
    public final synchronized zzcop zzq() {
        return this.zzk;
    }

    public final synchronized zzcop zzr() {
        return this.zzi;
    }

    public final synchronized IObjectWrapper zzt() {
        return this.zzo;
    }

    @Nullable
    public final synchronized IObjectWrapper zzu() {
        return this.zzl;
    }

    public final synchronized String zzv() {
        return zzD("advertiser");
    }

    public final synchronized String zzw() {
        return zzD("body");
    }

    public final synchronized String zzx() {
        return zzD("call_to_action");
    }

    public final synchronized String zzy() {
        return this.zzs;
    }

    public final synchronized String zzz() {
        return zzD("headline");
    }
}
