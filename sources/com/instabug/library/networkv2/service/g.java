package com.instabug.library.networkv2.service;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.model.session.SessionParameter;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.f;
import org.json.JSONException;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f51675b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f51676a = new NetworkManager();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f51675b == null) {
                f51675b = new g();
            }
            gVar = f51675b;
        }
        return gVar;
    }

    public void a(String str, String str2, Request.Callbacks callbacks) throws JSONException {
        if (str != null && str2 != null && callbacks != null) {
            this.f51676a.doRequest(IBGNetworkWorker.CORE, 1, a(str, str2), (Request.Callbacks<RequestResponse, Throwable>) new f(this, callbacks));
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public Request a(String str, String str2) {
        return new Request.Builder().hasUuid(false).endpoint(Endpoints.MIGRATE_UUID).method("PUT").addParameter(new RequestParameter("old_uuid", str)).addParameter(new RequestParameter("new_uuid", str2)).addParameter(new RequestParameter(SessionParameter.APP_TOKEN, SettingsManager.getInstance().getAppToken())).addParameter(new RequestParameter("name", f.i())).addParameter(new RequestParameter("email", f.h())).build();
    }
}
