package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.model.State;
import org.json.JSONException;
import org.json.JSONObject;

public class zzcaq {
    private final zzcop zza;
    private final String zzb;

    public zzcaq(zzcop zzcop, String str) {
        this.zza = zzcop;
        this.zzb = str;
    }

    public final void zzf(int i11, int i12, int i13, int i14) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put(Param.X, i11).put(Param.Y, i12).put("width", i13).put("height", i14));
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while dispatching default position.", e11);
        }
    }

    public final void zzg(String str) {
        try {
            JSONObject put = new JSONObject().put("message", (Object) str).put(NativeProtocol.WEB_DIALOG_ACTION, (Object) this.zzb);
            zzcop zzcop = this.zza;
            if (zzcop != null) {
                zzcop.zze("onError", put);
            }
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while dispatching error event.", e11);
        }
    }

    public final void zzh(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", (Object) str));
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while dispatching ready Event.", e11);
        }
    }

    public final void zzi(int i11, int i12, int i13, int i14, float f11, int i15) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i11).put("height", i12).put("maxSizeWidth", i13).put("maxSizeHeight", i14).put(State.KEY_DENSITY, (double) f11).put("rotation", i15));
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while obtaining screen information.", e11);
        }
    }

    public final void zzj(int i11, int i12, int i13, int i14) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put(Param.X, i11).put(Param.Y, i12).put("width", i13).put("height", i14));
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while dispatching size change.", e11);
        }
    }

    public final void zzk(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put("state", (Object) str));
        } catch (JSONException e11) {
            zzciz.zzh("Error occurred while dispatching state change.", e11);
        }
    }
}
