package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.ads.internal.util.zzaf;
import com.google.android.gms.ads.internal.zzt;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxb implements zzbwa<zzcxe> {
    private final Context zza;
    private final zzaxw zzb;
    private final PowerManager zzc;

    public zzcxb(Context context, zzaxw zzaxw) {
        this.zza = context;
        this.zzb = zzaxw;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcxe zzcxe) throws JSONException {
        JSONObject jSONObject;
        Integer num;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzaxz zzaxz = zzcxe.zzf;
        if (zzaxz == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z11 = zzaxz.zza;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", (Object) this.zzb.zzb()).put("activeViewJSON", (Object) this.zzb.zzd()).put("timestamp", zzcxe.zzd).put("adFormat", (Object) this.zzb.zza()).put("hashCode", (Object) this.zzb.zzc()).put("isMraid", false).put("isStopped", false).put("isPaused", zzcxe.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", zzt.zzr().zze()).put("appVolume", (double) zzt.zzr().zza()).put("deviceVolume", (double) zzaf.zzb(this.zza.getApplicationContext()));
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzef)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                if (audioManager == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(audioManager.getMode());
                }
                if (num != null) {
                    jSONObject3.put("audioMode", (Object) num);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzaxz.zzb).put("isAttachedToWindow", z11).put("viewBox", (Object) new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzaxz.zzc.top).put("bottom", zzaxz.zzc.bottom).put("left", zzaxz.zzc.left).put(TtmlNode.RIGHT, zzaxz.zzc.right)).put("adBox", (Object) new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzaxz.zzd.top).put("bottom", zzaxz.zzd.bottom).put("left", zzaxz.zzd.left).put(TtmlNode.RIGHT, zzaxz.zzd.right)).put("globalVisibleBox", (Object) new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzaxz.zze.top).put("bottom", zzaxz.zze.bottom).put("left", zzaxz.zze.left).put(TtmlNode.RIGHT, zzaxz.zze.right)).put("globalVisibleBoxVisible", zzaxz.zzf).put("localVisibleBox", (Object) new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzaxz.zzg.top).put("bottom", zzaxz.zzg.bottom).put("left", zzaxz.zzg.left).put(TtmlNode.RIGHT, zzaxz.zzg.right)).put("localVisibleBoxVisible", zzaxz.zzh).put("hitBox", (Object) new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, zzaxz.zzi.top).put("bottom", zzaxz.zzi.bottom).put("left", zzaxz.zzi.left).put(TtmlNode.RIGHT, zzaxz.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcxe.zza);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzba)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzaxz.zzk;
                if (list != null) {
                    for (Rect next : list) {
                        jSONArray2.put((Object) new JSONObject().put(ViewHierarchyConstants.DIMENSION_TOP_KEY, next.top).put("bottom", next.bottom).put("left", next.left).put(TtmlNode.RIGHT, next.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", (Object) jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcxe.zze)) {
                jSONObject3.put("doneReasonCode", (Object) "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put((Object) jSONObject);
        jSONObject2.put("units", (Object) jSONArray);
        return jSONObject2;
    }
}
