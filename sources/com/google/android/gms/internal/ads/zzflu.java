package com.google.android.gms.internal.ads;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class zzflu extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;
    private zzflv zza;
    protected final zzflm zzd;

    public zzflu(zzflm zzflm, byte[] bArr) {
        this.zzd = zzflm;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "zzflu#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zzflu#onPostExecute", (ArrayList<String>) null);
        }
        zza((String) obj);
        TraceMachine.exitMethod();
    }

    public void zza(String str) {
        zzflv zzflv = this.zza;
        if (zzflv != null) {
            zzflv.zza(this);
        }
    }

    public final void zzb(zzflv zzflv) {
        this.zza = zzflv;
    }
}
