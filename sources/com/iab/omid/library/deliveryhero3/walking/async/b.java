package com.iab.omid.library.deliveryhero3.walking.async;

import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

@Instrumented
public abstract class b extends AsyncTask implements TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    private a f45033a;

    /* renamed from: b  reason: collision with root package name */
    public final C0053b f45034b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.deliveryhero3.walking.async.b$b  reason: collision with other inner class name */
    public interface C0053b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0053b bVar) {
        this.f45034b = bVar;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public void a(a aVar) {
        this.f45033a = aVar;
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        AsyncTaskInstrumentation.executeOnExecutor(this, threadPoolExecutor, new Object[0]);
    }

    public void c(String str) {
        a aVar = this.f45033a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "b#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "b#onPostExecute", (ArrayList<String>) null);
        }
        c((String) obj);
        TraceMachine.exitMethod();
    }
}
