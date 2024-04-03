package com.huawei.agconnect.https;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.huawei.agconnect.https.connector.HttpsPlatform;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class d implements Service {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public OkHttpClient f47651a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f47652b;

    public d(OkHttpClient okHttpClient, Executor executor) {
        this.f47651a = okHttpClient;
        this.f47652b = executor;
    }

    public Task<HttpsResult> execute(final Method method) {
        return Tasks.callInBackground(this.f47652b, new Callable<HttpsResult>() {
            /* renamed from: a */
            public HttpsResult call() throws Exception {
                if (HttpsPlatform.getInstance().getConnector().hasActiveNetwork()) {
                    Request.Builder create = method.create();
                    Request build = !(create instanceof Request.Builder) ? create.build() : OkHttp3Instrumentation.build(create);
                    try {
                        OkHttpClient a11 = d.this.f47651a;
                        Response execute = FirebasePerfOkHttpClient.execute(!(a11 instanceof OkHttpClient) ? a11.newCall(build) : OkHttp3Instrumentation.newCall(a11, build));
                        return new HttpsResult(true, execute.code(), execute);
                    } catch (IOException e11) {
                        throw new HttpsException(true, e11);
                    }
                } else {
                    throw new HttpsException(false, "There's no network");
                }
            }
        });
    }
}
