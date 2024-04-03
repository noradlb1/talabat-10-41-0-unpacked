package com.instabug.featuresrequest.network.service;

import androidx.annotation.NonNull;
import com.instabug.featuresrequest.models.d;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import kc.a;
import org.json.JSONException;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f46572b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f46573a;

    private b() {
        if (f46572b == null) {
            this.f46573a = new NetworkManager();
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class");
    }

    public static b a() {
        if (f46572b == null) {
            synchronized (b.class) {
                if (f46572b == null) {
                    f46572b = new b();
                }
            }
        }
        return f46572b;
    }

    private Request.Callbacks a(Request.Callbacks callbacks) {
        return new a(this, callbacks);
    }

    private Request a(@NonNull d dVar) {
        return new Request.Builder().endpoint("/feature_reqs").method("POST").addParameter(new RequestParameter("email", dVar.j())).addParameter(new RequestParameter("name", dVar.k())).addParameter(new RequestParameter(State.KEY_PUSH_TOKEN, dVar.f())).addParameter(new RequestParameter("feature_request", dVar.h())).build();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(d dVar, Request.Callbacks callbacks) {
        try {
            this.f46573a.doRequest(IBGNetworkWorker.FEATURES_REQUEST, 1, a(dVar), (Request.Callbacks<RequestResponse, Throwable>) a(callbacks));
        } catch (JSONException e11) {
            callbacks.onFailed(e11);
        }
    }

    public void b(d dVar, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-FR", "Sending new feature");
        PoolProvider.postIOTask(new a(this, dVar, callbacks));
    }
}
