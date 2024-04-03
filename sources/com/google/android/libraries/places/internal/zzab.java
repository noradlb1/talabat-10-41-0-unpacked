package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.google.android.gms.tasks.TaskCompletionSource;
import org.json.JSONObject;

public final /* synthetic */ class zzab implements Response.Listener {
    public final /* synthetic */ zzae zza;
    public final /* synthetic */ Class zzb;
    public final /* synthetic */ TaskCompletionSource zzc;

    public /* synthetic */ zzab(zzae zzae, Class cls, TaskCompletionSource taskCompletionSource) {
        this.zza = zzae;
        this.zzb = cls;
        this.zzc = taskCompletionSource;
    }

    public final void onResponse(Object obj) {
        this.zza.zzb(this.zzb, this.zzc, (JSONObject) obj);
    }
}
