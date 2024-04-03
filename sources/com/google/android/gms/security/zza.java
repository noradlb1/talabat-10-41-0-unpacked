package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
final class zza extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;
    final /* synthetic */ Context zza;
    final /* synthetic */ ProviderInstaller.ProviderInstallListener zzb;

    public zza(Context context, ProviderInstaller.ProviderInstallListener providerInstallListener) {
        this.zza = context;
        this.zzb = providerInstallListener;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        int i11;
        try {
            TraceMachine.enterMethod(this._nr_trace, "zza#doInBackground", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zza#doInBackground", (ArrayList<String>) null);
        }
        Void[] voidArr = (Void[]) objArr;
        try {
            ProviderInstaller.installIfNeeded(this.zza);
            i11 = 0;
        } catch (GooglePlayServicesRepairableException e11) {
            i11 = Integer.valueOf(e11.getConnectionStatusCode());
        } catch (GooglePlayServicesNotAvailableException e12) {
            i11 = Integer.valueOf(e12.errorCode);
        }
        TraceMachine.exitMethod();
        return i11;
    }

    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "zza#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zza#onPostExecute", (ArrayList<String>) null);
        }
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzb.onProviderInstalled();
            TraceMachine.exitMethod();
            return;
        }
        this.zzb.onProviderInstallFailed(num.intValue(), ProviderInstaller.zza.getErrorResolutionIntent(this.zza, num.intValue(), "pi"));
        TraceMachine.exitMethod();
    }
}
