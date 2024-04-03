package com.instabug.survey.announcements.network;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.announcements.models.a;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f52264b;

    /* renamed from: a  reason: collision with root package name */
    private final NetworkManager f52265a = new NetworkManager();

    private d() {
    }

    public static d a() {
        if (f52264b == null) {
            f52264b = new d();
        }
        return f52264b;
    }

    public void a(Context context, a aVar, Request.Callbacks callbacks) {
        InstabugSDKLogger.v("IBG-Surveys", "submitting announcement");
        Request.Builder endpoint = new Request.Builder().method("POST").endpoint(Endpoints.SUBMIT_ANNOUNCEMENT.replaceAll(":announcement_id", String.valueOf(aVar.i())));
        a.a(endpoint, InstabugDeviceProperties.getAppVersion(context), aVar);
        this.f52265a.doRequest(IBGNetworkWorker.SURVEYS, 1, endpoint.build(), (Request.Callbacks<RequestResponse, Throwable>) new c(this, callbacks));
    }

    public void a(String str, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-Surveys", "fetching announcements");
        this.f52265a.doRequest(IBGNetworkWorker.ANNOUNCEMENTS, 1, new Request.Builder().endpoint(Endpoints.GET_ANNOUNCEMENTS).method("GET").addParameter(new RequestParameter("locale", str)).addHeader(new RequestParameter(HttpHeaders.ACCEPT, "application/vnd.instabug.v2")).addHeader(new RequestParameter("version", ExifInterface.GPS_MEASUREMENT_2D)).build(), (Request.Callbacks<RequestResponse, Throwable>) new b(this, callbacks));
    }
}
