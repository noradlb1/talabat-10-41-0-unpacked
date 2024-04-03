package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzciz;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Instrumented
final class zzq extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;
    final /* synthetic */ zzs zza;

    public /* synthetic */ zzq(zzs zzs, zzp zzp) {
        this.zza = zzs;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "zzq#doInBackground", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zzq#doInBackground", (ArrayList<String>) null);
        }
        String zza2 = zza((Void[]) objArr);
        TraceMachine.exitMethod();
        return zza2;
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "zzq#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zzq#onPostExecute", (ArrayList<String>) null);
        }
        String str = (String) obj;
        if (this.zza.zzf == null || str == null) {
            TraceMachine.exitMethod();
            return;
        }
        this.zza.zzf.loadUrl(str);
        TraceMachine.exitMethod();
    }

    public final String zza(Void... voidArr) {
        try {
            zzs zzs = this.zza;
            zzs.zzh = (zzalt) zzs.zzc.get(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e11) {
            zzciz.zzk("", e11);
        } catch (TimeoutException e12) {
            zzciz.zzk("", e12);
        }
        return this.zza.zzp();
    }
}
