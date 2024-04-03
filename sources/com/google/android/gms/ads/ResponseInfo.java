package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzciz;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class ResponseInfo {
    @Nullable
    private final zzbiw zza;
    private final List<AdapterResponseInfo> zzb = new ArrayList();

    private ResponseInfo(@Nullable zzbiw zzbiw) {
        this.zza = zzbiw;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzge)).booleanValue() && zzbiw != null) {
            try {
                List<zzbfm> zzg = zzbiw.zzg();
                if (zzg != null) {
                    for (zzbfm zza2 : zzg) {
                        AdapterResponseInfo zza3 = AdapterResponseInfo.zza(zza2);
                        if (zza3 != null) {
                            this.zzb.add(zza3);
                        }
                    }
                }
            } catch (RemoteException e11) {
                zzciz.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", e11);
            }
        }
    }

    @Nullable
    public static ResponseInfo zza(@Nullable zzbiw zzbiw) {
        if (zzbiw != null) {
            return new ResponseInfo(zzbiw);
        }
        return null;
    }

    @NonNull
    public static ResponseInfo zzb(@Nullable zzbiw zzbiw) {
        return new ResponseInfo(zzbiw);
    }

    @NonNull
    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzb;
    }

    @RecentlyNullable
    public String getMediationAdapterClassName() {
        try {
            zzbiw zzbiw = this.zza;
            if (zzbiw != null) {
                return zzbiw.zze();
            }
            return null;
        } catch (RemoteException e11) {
            zzciz.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", e11);
            return null;
        }
    }

    @RecentlyNullable
    public String getResponseId() {
        try {
            zzbiw zzbiw = this.zza;
            if (zzbiw != null) {
                return zzbiw.zzf();
            }
            return null;
        } catch (RemoteException e11) {
            zzciz.zzh("Could not forward getResponseId to ResponseInfo.", e11);
            return null;
        }
    }

    @RecentlyNonNull
    public String toString() {
        try {
            JSONObject zzc = zzc();
            return !(zzc instanceof JSONObject) ? zzc.toString(2) : JSONObjectInstrumentation.toString(zzc, 2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    @RecentlyNonNull
    public final JSONObject zzc() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", (Object) "null");
        } else {
            jSONObject.put("Response ID", (Object) responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", (Object) "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", (Object) mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzb2 : this.zzb) {
            jSONArray.put((Object) zzb2.zzb());
        }
        jSONObject.put("Adapter Responses", (Object) jSONArray);
        return jSONObject;
    }
}
