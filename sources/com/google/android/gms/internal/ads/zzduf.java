package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

public final class zzduf extends zzbpb {
    private final Context zza;
    private final zzdqc zzb;
    private zzdrb zzc;
    /* access modifiers changed from: private */
    public zzdpx zzd;

    public zzduf(Context context, zzdqc zzdqc, zzdrb zzdrb, zzdpx zzdpx) {
        this.zza = context;
        this.zzb = zzdqc;
        this.zzc = zzdrb;
        this.zzd = zzdpx;
    }

    public final zzbiz zze() {
        return this.zzb.zzj();
    }

    public final zzboi zzf(String str) {
        return this.zzb.zzh().get(str);
    }

    public final IObjectWrapper zzg() {
        return ObjectWrapper.wrap(this.zza);
    }

    public final String zzh() {
        return this.zzb.zzy();
    }

    public final String zzi(String str) {
        return this.zzb.zzi().get(str);
    }

    public final List<String> zzj() {
        SimpleArrayMap<String, zzbnu> zzh = this.zzb.zzh();
        SimpleArrayMap<String, String> zzi = this.zzb.zzi();
        String[] strArr = new String[(zzh.size() + zzi.size())];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < zzh.size()) {
            strArr[i13] = zzh.keyAt(i12);
            i12++;
            i13++;
        }
        while (i11 < zzi.size()) {
            strArr[i13] = zzi.keyAt(i11);
            i11++;
            i13++;
        }
        return Arrays.asList(strArr);
    }

    public final void zzk() {
        zzdpx zzdpx = this.zzd;
        if (zzdpx != null) {
            zzdpx.zzT();
        }
        this.zzd = null;
        this.zzc = null;
    }

    public final void zzl() {
        String zzA = this.zzb.zzA();
        if ("Google".equals(zzA)) {
            zzciz.zzj("Illegal argument specified for omid partner name.");
        } else if (TextUtils.isEmpty(zzA)) {
            zzciz.zzj("Not starting OMID session. OM partner name has not been configured.");
        } else {
            zzdpx zzdpx = this.zzd;
            if (zzdpx != null) {
                zzdpx.zzq(zzA, false);
            }
        }
    }

    public final void zzm(String str) {
        zzdpx zzdpx = this.zzd;
        if (zzdpx != null) {
            zzdpx.zzy(str);
        }
    }

    public final void zzn() {
        zzdpx zzdpx = this.zzd;
        if (zzdpx != null) {
            zzdpx.zzB();
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        zzdpx zzdpx;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzu() != null && (zzdpx = this.zzd) != null) {
            zzdpx.zzC((View) unwrap);
        }
    }

    public final boolean zzp() {
        zzdpx zzdpx = this.zzd;
        if ((zzdpx == null || zzdpx.zzO()) && this.zzb.zzq() != null && this.zzb.zzr() == null) {
            return true;
        }
        return false;
    }

    public final boolean zzq(IObjectWrapper iObjectWrapper) {
        zzdrb zzdrb;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdrb = this.zzc) == null || !zzdrb.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzr().zzaq(new zzdue(this));
        return true;
    }

    public final boolean zzr() {
        IObjectWrapper zzu = this.zzb.zzu();
        if (zzu != null) {
            zzt.zzh().zzh(zzu);
            if (this.zzb.zzq() == null) {
                return true;
            }
            this.zzb.zzq().zzd("onSdkLoaded", new ArrayMap());
            return true;
        }
        zzciz.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
