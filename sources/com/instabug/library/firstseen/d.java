package com.instabug.library.firstseen;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f34369b;

    /* renamed from: a  reason: collision with root package name */
    private final NetworkManager f34370a = new NetworkManager();

    private d() {
    }

    public static d a() {
        if (f34369b == null) {
            f34369b = new d();
        }
        return f34369b;
    }

    public void a(Context context, Request.Callbacks callbacks) throws JSONException {
        if (context != null && callbacks != null) {
            InstabugSDKLogger.d("IBG-Core", "fetch first_seen");
            Request.Builder method = new Request.Builder().endpoint(Endpoints.FIRST_SEEN).method("GET");
            a(context, method);
            Request build = method.build();
            InstabugSDKLogger.d("IBG-Core", "First seen request started: " + build);
            this.f34370a.doRequest(IBGNetworkWorker.CORE, 1, build, (Request.Callbacks<RequestResponse, Throwable>) new c(this, callbacks));
        }
    }

    private void a(@NonNull Context context, @NonNull Request.Builder builder) {
        builder.addHeader(new RequestParameter(Header.APP_VERSION, DeviceStateProvider.getAppVersion(context)));
    }
}
