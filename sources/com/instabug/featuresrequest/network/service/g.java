package com.instabug.featuresrequest.network.service;

import com.google.common.net.HttpHeaders;
import com.instabug.featuresrequest.models.f;
import com.instabug.featuresrequest.network.a;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.android.plugins.RxAndroidPlugins;
import tracking.gtm.TalabatGTM;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f46578b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f46579a = new NetworkManager();

    private g() {
    }

    public static g a() {
        if (f46578b == null) {
            f46578b = new g();
        }
        return f46578b;
    }

    public void a(int i11, boolean z11, boolean z12, boolean z13, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-FR", "fetch Features Requests started");
        try {
            Request.Builder method = new Request.Builder().endpoint("/feature_reqs").method("GET");
            method.addParameter(new RequestParameter("page", Integer.valueOf(i11)));
            method.addParameter(new RequestParameter(TalabatGTM.COMPLETED, Boolean.valueOf(z11)));
            method.addParameter(new RequestParameter("sort_top_votes", Boolean.valueOf(z12)));
            method.addParameter(new RequestParameter("my_posts", Boolean.valueOf(z13)));
            method.addHeader(new RequestParameter(HttpHeaders.ACCEPT, "application/vnd.instabug.v1"));
            method.addHeader(new RequestParameter("version", "1"));
            this.f46579a.doRequest(IBGNetworkWorker.FEATURES_REQUEST, 1, method.build(), (Request.Callbacks<RequestResponse, Throwable>) new c(this, callbacks));
        } catch (Exception e11) {
            callbacks.onFailed(e11);
        }
    }

    public void a(long j11, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-FR", "Getting feature-request with id " + j11);
        this.f46579a.doRequest(IBGNetworkWorker.FEATURES_REQUEST, 1, new Request.Builder().endpoint(Endpoints.GET_FEATURE_TIMELINE.replaceAll(":feature_req_id", String.valueOf(j11))).method("GET").addHeader(new RequestParameter(HttpHeaders.ACCEPT, "application/vnd.instabug.v1")).addHeader(new RequestParameter("version", "1")).addParameter(new RequestParameter(TtmlNode.COMBINE_ALL, "true")).build(), (Request.Callbacks<RequestResponse, Throwable>) new e(this, callbacks));
    }

    public void a(long j11, String str, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-FR", "Voting request for feature with id : " + j11);
        try {
            this.f46579a.doRequest(IBGNetworkWorker.FEATURES_REQUEST, 1, new Request.Builder().endpoint(Endpoints.VOTE_FEATURE.replaceAll(":feature_req_id", String.valueOf(j11))).method(str).build(), (Request.Callbacks<RequestResponse, Throwable>) new d(this, callbacks));
        } catch (Exception e11) {
            RxAndroidPlugins.reset();
            callbacks.onFailed(e11);
        }
    }

    public void a(f fVar, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-FR", "Adding comment...");
        Request.Builder a11 = a.a(new Request.Builder().endpoint(Endpoints.ADD_COMMENT.replaceAll(":feature_req_id", String.valueOf(fVar.l()))).method("POST"), fVar);
        a11.addHeader(new RequestParameter(HttpHeaders.ACCEPT, "application/vnd.instabug.v1"));
        a11.addHeader(new RequestParameter("version", "1"));
        a11.addParameter(new RequestParameter(TtmlNode.COMBINE_ALL, "true"));
        a11.toString();
        this.f46579a.doRequest(IBGNetworkWorker.FEATURES_REQUEST, 1, a11.build(), (Request.Callbacks<RequestResponse, Throwable>) new f(this, callbacks));
    }
}
