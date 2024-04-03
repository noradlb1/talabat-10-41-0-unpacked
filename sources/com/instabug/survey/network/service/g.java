package com.instabug.survey.network.service;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.models.Survey;
import com.instabug.survey.network.util.a;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f52417b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f52418a = new NetworkManager();

    private g() {
    }

    public static g a() {
        if (f52417b == null) {
            f52417b = new g();
        }
        return f52417b;
    }

    public void a(Context context, Survey survey, Request.Callbacks callbacks) {
        InstabugSDKLogger.v("IBG-Surveys", "Start submitting survey");
        Request.Builder endpoint = new Request.Builder().method("POST").endpoint(Endpoints.SUBMIT_SURVEY.replaceAll(":survey_id", String.valueOf(survey.getId())));
        a.a(context, endpoint, survey);
        this.f52418a.doRequest(IBGNetworkWorker.SURVEYS, 1, endpoint.build(), (Request.Callbacks<RequestResponse, Throwable>) new e(this, callbacks));
    }

    public void a(Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-Surveys", "Resolving the IP to get country information");
        this.f52418a.doRequest(IBGNetworkWorker.SURVEYS, 1, new Request.Builder().method("GET").endpoint(Endpoints.RESOLVE_IP).build(), (Request.Callbacks<RequestResponse, Throwable>) new f(this, callbacks));
    }

    public void a(String str, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-Surveys", "fetching surveys");
        this.f52418a.doRequest(IBGNetworkWorker.SURVEYS, 1, new Request.Builder().method("GET").endpoint(Endpoints.GET_SURVEYS).addHeader(new RequestParameter(HttpHeaders.ACCEPT, "application/vnd.instabug.v2")).addHeader(new RequestParameter("version", ExifInterface.GPS_MEASUREMENT_2D)).addParameter(new RequestParameter("locale", str)).build(), (Request.Callbacks<RequestResponse, Throwable>) new d(this, callbacks));
    }
}
