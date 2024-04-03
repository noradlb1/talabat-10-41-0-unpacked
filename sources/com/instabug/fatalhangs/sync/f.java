package com.instabug.fatalhangs.sync;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46499a;

    public f(Request.Callbacks callbacks) {
        this.f46499a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable RequestResponse requestResponse) {
        if (requestResponse != null) {
            Request.Callbacks callbacks = this.f46499a;
            InstabugSDKLogger.v("IBG-CR", "sendFatalHangRequest Succeeded, Response code: " + requestResponse.getResponseCode() + "Response body: " + requestResponse.getResponseBody());
            try {
                if (requestResponse.getResponseBody() != null) {
                    Object responseBody = requestResponse.getResponseBody();
                    if (responseBody != null) {
                        callbacks.onSucceeded(new JSONObject((String) responseBody).getString("id"));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                callbacks.onFailed(new JSONException("response.getResponseBody() returned null"));
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-CR", "Couldn't parse Fatal Hang request response.", e11);
            }
        }
    }

    /* renamed from: a */
    public void onFailed(@Nullable Throwable th2) {
        this.f46499a.onFailed(th2);
    }
}
