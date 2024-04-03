package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzayz;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbmq;
import com.google.android.gms.internal.ads.zzcif;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzfxa;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class zzj implements zzg {
    @GuardedBy("lock")
    private long zzA = 0;
    private final Object zza = new Object();
    private boolean zzb;
    private final List<Runnable> zzc = new ArrayList();
    private zzfxa<?> zzd;
    @GuardedBy("lock")
    @Nullable
    private zzayz zze = null;
    @GuardedBy("lock")
    @Nullable
    private SharedPreferences zzf;
    @GuardedBy("lock")
    @Nullable
    private SharedPreferences.Editor zzg;
    @GuardedBy("lock")
    private boolean zzh = true;
    @GuardedBy("lock")
    @Nullable
    private String zzi;
    @GuardedBy("lock")
    @Nullable
    private String zzj;
    @GuardedBy("lock")
    private boolean zzk = true;
    @GuardedBy("lock")
    private zzcif zzl = new zzcif("", 0);
    @GuardedBy("lock")
    private long zzm = 0;
    @GuardedBy("lock")
    private long zzn = 0;
    @GuardedBy("lock")
    private int zzo = -1;
    @GuardedBy("lock")
    private int zzp = 0;
    @GuardedBy("lock")
    private Set<String> zzq = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject zzr = new JSONObject();
    @GuardedBy("lock")
    private boolean zzs = true;
    @GuardedBy("lock")
    private boolean zzt = true;
    @GuardedBy("lock")
    private String zzu = null;
    @GuardedBy("lock")
    private String zzv = "";
    @GuardedBy("lock")
    private boolean zzw = false;
    @GuardedBy("lock")
    private String zzx = "";
    @GuardedBy("lock")
    private int zzy = -1;
    @GuardedBy("lock")
    private int zzz = -1;

    private final void zzN() {
        zzfxa<?> zzfxa = this.zzd;
        if (zzfxa != null && !zzfxa.isDone()) {
            try {
                this.zzd.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e11) {
                Thread.currentThread().interrupt();
                zzciz.zzk("Interrupted while waiting for preferences loaded.", e11);
            } catch (CancellationException | ExecutionException | TimeoutException e12) {
                zzciz.zzh("Fail to initialize AdSharedPreferenceManager.", e12);
            }
        }
    }

    private final void zzO() {
        zzcjm.zza.execute(new zzh(this));
    }

    public final void zzA(String str) {
        zzN();
        synchronized (this.zza) {
            if (!TextUtils.equals(this.zzu, str)) {
                this.zzu = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzB(long j11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzn != j11) {
                this.zzn = j11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzC(String str) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue()) {
            zzN();
            synchronized (this.zza) {
                if (!this.zzv.equals(str)) {
                    this.zzv = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzO();
                }
            }
        }
    }

    public final void zzD(boolean z11) {
        zzN();
        synchronized (this.zza) {
            if (z11 != this.zzk) {
                this.zzk = z11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzE(String str, String str2, boolean z11) {
        String str3;
        zzN();
        synchronized (this.zza) {
            JSONArray optJSONArray = this.zzr.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i11 = 0;
            while (true) {
                if (i11 < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        if (str2.equals(optJSONObject.optString("template_id"))) {
                            if (z11) {
                                if (optJSONObject.optBoolean("uses_media_view", false)) {
                                    return;
                                }
                            }
                            length = i11;
                        } else {
                            i11++;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", (Object) str2);
                jSONObject.put("uses_media_view", z11);
                jSONObject.put("timestamp_ms", zzt.zzA().currentTimeMillis());
                optJSONArray.put(length, (Object) jSONObject);
                this.zzr.put(str, (Object) optJSONArray);
            } catch (JSONException e11) {
                zzciz.zzk("Could not update native advanced settings", e11);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                JSONObject jSONObject2 = this.zzr;
                if (!(jSONObject2 instanceof JSONObject)) {
                    str3 = jSONObject2.toString();
                } else {
                    str3 = JSONObjectInstrumentation.toString(jSONObject2);
                }
                editor.putString("native_advanced_settings", str3);
                this.zzg.apply();
            }
            zzO();
        }
    }

    public final void zzF(int i11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzo != i11) {
                this.zzo = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzG(int i11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzz != i11) {
                this.zzz = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzH(long j11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzA != j11) {
                this.zzA = j11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final boolean zzI() {
        boolean z11;
        zzN();
        synchronized (this.zza) {
            z11 = this.zzs;
        }
        return z11;
    }

    public final boolean zzJ() {
        boolean z11;
        zzN();
        synchronized (this.zza) {
            z11 = this.zzt;
        }
        return z11;
    }

    public final boolean zzK() {
        boolean z11;
        zzN();
        synchronized (this.zza) {
            z11 = this.zzw;
        }
        return z11;
    }

    public final boolean zzL() {
        boolean z11;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzao)).booleanValue()) {
            return false;
        }
        zzN();
        synchronized (this.zza) {
            z11 = this.zzk;
        }
        return z11;
    }

    public final /* synthetic */ void zzM(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.zza) {
            this.zzf = sharedPreferences;
            this.zzg = edit;
            if (PlatformVersion.isAtLeastM()) {
                NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
            }
            this.zzh = this.zzf.getBoolean("use_https", this.zzh);
            this.zzs = this.zzf.getBoolean("content_url_opted_out", this.zzs);
            this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
            this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
            this.zzt = this.zzf.getBoolean("content_vertical_opted_out", this.zzt);
            this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
            this.zzp = this.zzf.getInt("version_code", this.zzp);
            this.zzl = new zzcif(this.zzf.getString("app_settings_json", this.zzl.zzc()), this.zzf.getLong("app_settings_last_update_ms", this.zzl.zza()));
            this.zzm = this.zzf.getLong("app_last_background_time_ms", this.zzm);
            this.zzo = this.zzf.getInt("request_in_session_count", this.zzo);
            this.zzn = this.zzf.getLong("first_ad_req_time_ms", this.zzn);
            this.zzq = this.zzf.getStringSet("never_pool_slots", this.zzq);
            this.zzu = this.zzf.getString("display_cutout", this.zzu);
            this.zzy = this.zzf.getInt("app_measurement_npa", this.zzy);
            this.zzz = this.zzf.getInt("sd_app_measure_npa", this.zzz);
            this.zzA = this.zzf.getLong("sd_app_measure_npa_ts", this.zzA);
            this.zzv = this.zzf.getString("inspector_info", this.zzv);
            this.zzw = this.zzf.getBoolean("linked_device", this.zzw);
            this.zzx = this.zzf.getString("linked_ad_unit", this.zzx);
            try {
                this.zzr = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
            } catch (JSONException e11) {
                zzciz.zzk("Could not convert native advanced settings to json object", e11);
            }
            zzO();
        }
    }

    public final int zza() {
        int i11;
        zzN();
        synchronized (this.zza) {
            i11 = this.zzp;
        }
        return i11;
    }

    public final int zzb() {
        int i11;
        zzN();
        synchronized (this.zza) {
            i11 = this.zzo;
        }
        return i11;
    }

    public final long zzc() {
        long j11;
        zzN();
        synchronized (this.zza) {
            j11 = this.zzm;
        }
        return j11;
    }

    public final long zzd() {
        long j11;
        zzN();
        synchronized (this.zza) {
            j11 = this.zzn;
        }
        return j11;
    }

    public final long zze() {
        long j11;
        zzN();
        synchronized (this.zza) {
            j11 = this.zzA;
        }
        return j11;
    }

    @Nullable
    public final zzayz zzf() {
        if (!this.zzb) {
            return null;
        }
        if ((zzI() && zzJ()) || !zzbmq.zzb.zze().booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzayz();
            }
            this.zze.zze();
            zzciz.zzi("start fetching content...");
            zzayz zzayz = this.zze;
            return zzayz;
        }
    }

    public final zzcif zzg() {
        zzcif zzcif;
        zzN();
        synchronized (this.zza) {
            zzcif = this.zzl;
        }
        return zzcif;
    }

    public final zzcif zzh() {
        zzcif zzcif;
        synchronized (this.zza) {
            zzcif = this.zzl;
        }
        return zzcif;
    }

    @Nullable
    public final String zzi() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    @Nullable
    public final String zzj() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    public final String zzk() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzx;
        }
        return str;
    }

    public final String zzl() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzu;
        }
        return str;
    }

    public final String zzm() {
        String str;
        zzN();
        synchronized (this.zza) {
            str = this.zzv;
        }
        return str;
    }

    public final JSONObject zzn() {
        JSONObject jSONObject;
        zzN();
        synchronized (this.zza) {
            jSONObject = this.zzr;
        }
        return jSONObject;
    }

    public final void zzo(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzp(Context context) {
        synchronized (this.zza) {
            if (this.zzf == null) {
                this.zzd = zzcjm.zza.zza(new zzi(this, context, "admob"));
                this.zzb = true;
            }
        }
    }

    public final void zzq() {
        zzN();
        synchronized (this.zza) {
            this.zzr = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzO();
        }
    }

    public final void zzr(long j11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzm != j11) {
                this.zzm = j11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzs(String str) {
        zzN();
        synchronized (this.zza) {
            long currentTimeMillis = zzt.zzA().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzl.zzc())) {
                    this.zzl = new zzcif(str, currentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzg.apply();
                    }
                    zzO();
                    for (Runnable run : this.zzc) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzl.zzg(currentTimeMillis);
        }
    }

    public final void zzt(int i11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzp != i11) {
                this.zzp = i11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzu(@Nullable String str) {
        zzN();
        synchronized (this.zza) {
            if (!str.equals(this.zzi)) {
                this.zzi = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_url_hashes", str);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzv(boolean z11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzs != z11) {
                this.zzs = z11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzw(@Nullable String str) {
        zzN();
        synchronized (this.zza) {
            if (!str.equals(this.zzj)) {
                this.zzj = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzx(boolean z11) {
        zzN();
        synchronized (this.zza) {
            if (this.zzt != z11) {
                this.zzt = z11;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z11);
                    this.zzg.apply();
                }
                zzO();
            }
        }
    }

    public final void zzy(String str) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue()) {
            zzN();
            synchronized (this.zza) {
                if (!this.zzx.equals(str)) {
                    this.zzx = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzO();
                }
            }
        }
    }

    public final void zzz(boolean z11) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgP)).booleanValue()) {
            zzN();
            synchronized (this.zza) {
                if (this.zzw != z11) {
                    this.zzw = z11;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z11);
                        this.zzg.apply();
                    }
                    zzO();
                }
            }
        }
    }
}
