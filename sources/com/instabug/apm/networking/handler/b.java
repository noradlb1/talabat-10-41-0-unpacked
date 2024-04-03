package com.instabug.apm.networking.handler;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.apm.configuration.g;
import com.instabug.apm.networking.mapping.sessions.a;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final a f45528a = com.instabug.apm.di.a.X();
    @VisibleForTesting
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public Request f45529b;

    private void a(@Nullable Request request, Request.Callbacks callbacks) {
        if (request != null) {
            com.instabug.apm.di.a.S().doRequest(IBGNetworkWorker.CORE, 1, request, (Request.Callbacks<RequestResponse, Throwable>) callbacks);
        } else {
            callbacks.onFailed(new com.instabug.apm.networking.a("Request object can't be null"));
        }
    }

    @VisibleForTesting
    public Request a(JSONArray jSONArray) {
        RequestParameter requestParameter;
        int p11;
        com.instabug.apm.util.debug.a w11 = com.instabug.apm.di.a.w();
        com.instabug.apm.util.device.a x11 = com.instabug.apm.di.a.x();
        Request.Builder hasUuid = new Request.Builder().url("https://api-apm.instabug.com/api/sdk/v3/apm/v1/sessions").method("POST").addParameter(new RequestParameter("ses", jSONArray)).shorten(true).hasUuid(false);
        String o11 = com.instabug.apm.di.a.o();
        if (o11 != null) {
            hasUuid.addHeader(new RequestParameter(Header.APP_TOKEN, o11)).addParameter(new RequestParameter("at", o11));
        }
        if (x11.a()) {
            requestParameter = new RequestParameter("dv", "Emulator - " + InstabugDeviceProperties.getDeviceType());
        } else {
            requestParameter = new RequestParameter("dv", InstabugDeviceProperties.getDeviceType());
        }
        hasUuid.addParameter(requestParameter);
        if (w11.a()) {
            hasUuid.addHeader(new RequestParameter(Header.DEBUG_MODE_HEADER, "true"));
            hasUuid.addParameter(new RequestParameter("dm", Boolean.TRUE));
        }
        g h11 = com.instabug.apm.di.a.h();
        if (h11 != null && (p11 = h11.p()) > 0) {
            hasUuid.addParameter(new RequestParameter("dssl", Integer.valueOf(p11)));
            com.instabug.apm.logger.internal.a f11 = com.instabug.apm.di.a.f();
            if (f11 != null) {
                f11.i(String.format(Locale.ENGLISH, "%d sessions have been dropped due to reaching sessions storage limit. Please contact support for more information.", new Object[]{Integer.valueOf(p11)}));
            }
        }
        return hasUuid.build();
    }

    public void a(@NonNull List list, Request.Callbacks callbacks) {
        try {
            Request a11 = a(this.f45528a.a(list));
            this.f45529b = a11;
            a(a11, callbacks);
        } catch (Exception e11) {
            callbacks.onFailed(e11);
        }
    }
}
