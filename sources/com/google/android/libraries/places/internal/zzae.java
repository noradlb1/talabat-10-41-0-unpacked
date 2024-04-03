package com.google.android.libraries.places.internal;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import org.json.JSONObject;

@Instrumented
public final class zzae {
    private final RequestQueue zza;
    private final zzbq zzb;

    public zzae(RequestQueue requestQueue, zzbq zzbq, byte[] bArr) {
        this.zza = requestQueue;
        this.zzb = zzbq;
    }

    public static /* synthetic */ void zzc(TaskCompletionSource taskCompletionSource, VolleyError volleyError) {
        try {
            taskCompletionSource.trySetException(zzy.zza(volleyError));
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public final <HttpJsonResponseT extends zzan> Task<HttpJsonResponseT> zza(zzam<Object, ? extends zzcz> zzam, Class<HttpJsonResponseT> cls) {
        TaskCompletionSource taskCompletionSource;
        String zzc = zzam.zzc();
        Map<String, String> zzd = zzam.zzd();
        CancellationToken zza2 = zzam.zza();
        if (zza2 != null) {
            taskCompletionSource = new TaskCompletionSource(zza2);
        } else {
            taskCompletionSource = new TaskCompletionSource();
        }
        TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
        zzad zzad = new zzad(this, 0, zzc, (JSONObject) null, new zzab(this, cls, taskCompletionSource2), new zzaa(taskCompletionSource2), zzd);
        if (zza2 != null) {
            zza2.onCanceledRequested(new zzac(zzad));
        }
        this.zza.add(zzad);
        return taskCompletionSource2.getTask();
    }

    public final /* synthetic */ void zzb(Class cls, TaskCompletionSource taskCompletionSource, JSONObject jSONObject) {
        String str;
        try {
            zzbq zzbq = this.zzb;
            if (!(jSONObject instanceof JSONObject)) {
                str = jSONObject.toString();
            } else {
                str = JSONObjectInstrumentation.toString(jSONObject);
            }
            taskCompletionSource.trySetResult((zzan) zzbq.zza(str, cls));
        } catch (zzao e11) {
            try {
                taskCompletionSource.trySetException(new ApiException(new Status(8, e11.getMessage())));
            } catch (Error | RuntimeException e12) {
                zzdh.zzb(e12);
                throw e12;
            }
        }
    }
}
