package com.huawei.secure.android.common.ssl.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.io.InputStream;
import java.util.ArrayList;

@Instrumented
public class c extends AsyncTask implements TraceFieldInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33959a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static final long f33960b = 432000000;

    /* renamed from: c  reason: collision with root package name */
    private static final String f33961c = "lastCheckTime";

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f33962d = false;
    public Trace _nr_trace;

    @SuppressLint({"NewApi"})
    public static void a() {
        if (b()) {
            e.c(f33959a, "checkUpgradeBks, execute check task");
            AsyncTaskInstrumentation.executeOnExecutor(new c(), AsyncTask.THREAD_POOL_EXECUTOR, ContextUtil.getInstance());
        }
    }

    private static boolean b() {
        if (f33962d) {
            return false;
        }
        Context instance = ContextUtil.getInstance();
        if (instance == null) {
            e.e(f33959a, "checkUpgradeBks, context is null");
            return false;
        }
        f33962d = true;
        long a11 = g.a(f33961c, 0, instance);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a11 > f33960b) {
            g.b(f33961c, currentTimeMillis, instance);
            return true;
        }
        e.c(f33959a, "checkUpgradeBks, ignore");
        return false;
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public void onProgressUpdate(Integer... numArr) {
        e.c(f33959a, "onProgressUpdate");
    }

    public /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "c#doInBackground", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "c#doInBackground", (ArrayList<String>) null);
        }
        Boolean a11 = a((Context[]) objArr);
        TraceMachine.exitMethod();
        return a11;
    }

    public /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "c#onPostExecute", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "c#onPostExecute", (ArrayList<String>) null);
        }
        b((Boolean) obj);
        TraceMachine.exitMethod();
    }

    public void onPreExecute() {
        e.a(f33959a, "onPreExecute");
    }

    public Boolean a(Context... contextArr) {
        InputStream inputStream;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            inputStream = BksUtil.getBksFromTss(contextArr[0]);
        } catch (Exception e11) {
            String str = f33959a;
            e.b(str, "doInBackground: exception : " + e11.getMessage());
            inputStream = null;
        }
        String str2 = f33959a;
        e.a(str2, "doInBackground: get bks from hms tss cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        if (inputStream == null) {
            return Boolean.FALSE;
        }
        d.a(inputStream);
        return Boolean.TRUE;
    }

    public void b(Boolean bool) {
        if (bool.booleanValue()) {
            e.c(f33959a, "onPostExecute: upate done");
        } else {
            e.b(f33959a, "onPostExecute: upate failed");
        }
    }
}
