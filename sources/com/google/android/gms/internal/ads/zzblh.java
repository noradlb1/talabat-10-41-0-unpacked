package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzblh implements SharedPreferences.OnSharedPreferenceChangeListener {
    @VisibleForTesting
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    /* access modifiers changed from: private */
    @Nullable
    public SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();

    private final void zzf() {
        if (this.zze != null) {
            try {
                this.zzh = new JSONObject((String) zzbll.zza(new zzble(this)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf();
        }
    }

    public final <T> T zzb(zzblb<T> zzblb) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd) {
                    if (this.zze == null) {
                    }
                }
                T zzl = zzblb.zzl();
                return zzl;
            }
        }
        if (zzblb.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzblb.zzl();
            }
            return zzblb.zzb(bundle);
        } else if (zzblb.zze() != 1 || !this.zzh.has(zzblb.zzm())) {
            return zzbll.zza(new zzblf(this, zzblb));
        } else {
            return zzblb.zza(this.zzh);
        }
    }

    public final /* synthetic */ Object zzc(zzblb zzblb) {
        return zzblb.zzc(this.zze);
    }

    public final /* synthetic */ String zzd() {
        return this.zze.getString("flag_configuration", "{}");
    }

    public final void zze(Context context) {
        Context context2;
        if (!this.zzd) {
            synchronized (this.zzb) {
                if (!this.zzd) {
                    if (!this.zza) {
                        this.zza = true;
                    }
                    if (context.getApplicationContext() == null) {
                        context2 = context;
                    } else {
                        context2 = context.getApplicationContext();
                    }
                    this.zzg = context2;
                    try {
                        this.zzf = Wrappers.packageManager(context2).getApplicationInfo(this.zzg.getPackageName(), 128).metaData;
                    } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
                    }
                    try {
                        Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                        if (!(remoteContext == null && (remoteContext = context.getApplicationContext()) == null)) {
                            context = remoteContext;
                        }
                        if (context != null) {
                            zzbgq.zzb();
                            SharedPreferences zza2 = zzbld.zza(context);
                            this.zze = zza2;
                            if (zza2 != null) {
                                zza2.registerOnSharedPreferenceChangeListener(this);
                            }
                            zzbnn.zzc(new zzblg(this));
                            zzf();
                            this.zzd = true;
                            this.zza = false;
                            this.zzc.open();
                        }
                    } finally {
                        this.zza = false;
                        this.zzc.open();
                    }
                }
            }
        }
    }
}
