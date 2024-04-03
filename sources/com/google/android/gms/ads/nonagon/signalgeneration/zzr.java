package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzfwm;
import org.json.JSONException;
import org.json.JSONObject;

final class zzr implements zzfwm<zzah> {
    final /* synthetic */ zzchq zza;
    final /* synthetic */ zzv zzb;

    public zzr(zzv zzv, zzchq zzchq) {
        this.zzb = zzv;
        this.zza = zzchq;
    }

    public final void zza(Throwable th2) {
        String str;
        String message = th2.getMessage();
        zzt.zzo().zzs(th2, "SignalGeneratorImpl.generateSignals");
        zzv.zzy(this.zzb, "sgf", "sgf_reason", message);
        try {
            zzchq zzchq = this.zza;
            String valueOf = String.valueOf(message);
            if (valueOf.length() != 0) {
                str = "Internal error. ".concat(valueOf);
            } else {
                str = new String("Internal error. ");
            }
            zzchq.zzb(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nullable Object obj) {
        zzah zzah = (zzah) obj;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfE)).booleanValue()) {
            try {
                this.zza.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e11) {
                zzciz.zzg("QueryInfo generation has been disabled.".concat(e11.toString()));
            }
        } else if (zzah == null) {
            try {
                this.zza.zzc((String) null, (String) null, (Bundle) null);
                zzv.zzy(this.zzb, "sgs", "rid", "-1");
            } catch (RemoteException e12) {
                zzciz.zzh("", e12);
            }
        } else {
            try {
                String optString = new JSONObject(zzah.zzb).optString("request_id", "");
                if (TextUtils.isEmpty(optString)) {
                    zzciz.zzj("The request ID is empty in request JSON.");
                    this.zza.zzb("Internal error: request ID is empty in request JSON.");
                    zzv.zzy(this.zzb, "sgf", "sgf_reason", "rid_missing");
                    return;
                }
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfp)).booleanValue()) {
                    this.zzb.zzp.zzc(optString, zzah.zzb);
                }
                Bundle bundle = zzah.zzc;
                if (this.zzb.zzw && bundle != null && bundle.getInt(this.zzb.zzy, -1) == -1) {
                    bundle.putInt(this.zzb.zzy, this.zzb.zzz.get());
                }
                if (this.zzb.zzv && bundle != null && TextUtils.isEmpty(bundle.getString(this.zzb.zzx))) {
                    if (TextUtils.isEmpty(this.zzb.zzB)) {
                        this.zzb.zzB = zzt.zzp().zzd(this.zzb.zzg, this.zzb.zzA.zza);
                    }
                    bundle.putString(this.zzb.zzx, this.zzb.zzB);
                }
                this.zza.zzc(zzah.zza, zzah.zzb, bundle);
                zzv.zzy(this.zzb, "sgs", "rid", optString);
            } catch (JSONException e13) {
                zzciz.zzj("Failed to create JSON object from the request string.");
                zzchq zzchq = this.zza;
                String obj2 = e13.toString();
                StringBuilder sb2 = new StringBuilder(obj2.length() + 33);
                sb2.append("Internal error for request JSON: ");
                sb2.append(obj2);
                zzchq.zzb(sb2.toString());
                zzv.zzy(this.zzb, "sgf", "sgf_reason", "request_invalid");
            }
        }
    }
}
