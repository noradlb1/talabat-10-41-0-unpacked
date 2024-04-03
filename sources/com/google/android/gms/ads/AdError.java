package com.google.android.gms.ads;

import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbew;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.apache.commons.compress.harmony.unpack200.AttributeLayout;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class AdError {
    @RecentlyNonNull
    public static final String UNDEFINED_DOMAIN = "undefined";
    private final int zza;
    @NonNull
    private final String zzb;
    @NonNull
    private final String zzc;
    @Nullable
    private final AdError zzd;

    public AdError(int i11, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        this(i11, str, str2, (AdError) null);
    }

    public AdError(int i11, @RecentlyNonNull String str, @RecentlyNonNull String str2, @Nullable AdError adError) {
        this.zza = i11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = adError;
    }

    @RecentlyNullable
    public AdError getCause() {
        return this.zzd;
    }

    public int getCode() {
        return this.zza;
    }

    @NonNull
    public String getDomain() {
        return this.zzc;
    }

    @NonNull
    public String getMessage() {
        return this.zzb;
    }

    @RecentlyNonNull
    public String toString() {
        try {
            JSONObject zzb2 = zzb();
            return !(zzb2 instanceof JSONObject) ? zzb2.toString(2) : JSONObjectInstrumentation.toString(zzb2, 2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @NonNull
    public final zzbew zza() {
        zzbew zzbew;
        AdError adError = this.zzd;
        if (adError == null) {
            zzbew = null;
        } else {
            zzbew = new zzbew(adError.zza, adError.zzb, adError.zzc, (zzbew) null, (IBinder) null);
        }
        return new zzbew(this.zza, this.zzb, this.zzc, zzbew, (IBinder) null);
    }

    @RecentlyNonNull
    public JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AttributeLayout.ATTRIBUTE_CODE, this.zza);
        jSONObject.put("Message", (Object) this.zzb);
        jSONObject.put("Domain", (Object) this.zzc);
        AdError adError = this.zzd;
        if (adError == null) {
            jSONObject.put("Cause", (Object) "null");
        } else {
            jSONObject.put("Cause", (Object) adError.zzb());
        }
        return jSONObject;
    }
}
