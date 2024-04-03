package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.hms.network.NetworkKit;
import com.huawei.hms.network.httpclient.HttpClient;
import com.huawei.hms.network.httpclient.Response;
import com.huawei.hms.network.restclient.RestClient;
import com.huawei.wisesecurity.ucs.common.exception.UcsException;
import com.huawei.wisesecurity.ucs.common.log.LogUcs;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkCapability;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkRequest;
import com.huawei.wisesecurity.ucs.credential.outer.NetworkResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class p implements NetworkCapability {

    /* renamed from: a  reason: collision with root package name */
    public q f44887a;

    /* renamed from: b  reason: collision with root package name */
    public Context f44888b;

    public p(Context context) {
        this.f44888b = context;
    }

    public final String a(Response<String> response) {
        if (response.isSuccessful()) {
            return (String) response.getBody();
        }
        try {
            return new String(response.getErrorBody().bytes(), StandardCharsets.UTF_8);
        } catch (IOException e11) {
            LogUcs.e("RemoteRestClient", "getErrorBody fail : " + e11.getMessage(), new Object[0]);
            return "";
        }
    }

    public NetworkResponse get(NetworkRequest networkRequest) throws IOException {
        NetworkResponse networkResponse = new NetworkResponse();
        Response execute = this.f44887a.a(networkRequest.getUrl(), networkRequest.getHeaders()).execute();
        networkResponse.setCode(execute.getCode());
        networkResponse.setHeaders(execute.getHeaders());
        networkResponse.setBody(a(execute));
        return networkResponse;
    }

    public void initConfig(int i11, int i12) throws UcsException {
        try {
            NetworkKit.init(this.f44888b, new o(this));
            this.f44887a = (q) new RestClient.Builder().httpClient(new HttpClient.Builder().connectTimeout(i11).callTimeout(i11).retryTimeOnConnectionFailure(i12).build()).build().create(q.class);
        } catch (Exception e11) {
            String str = "RemoteRestClient init failed, " + e11.getMessage();
            LogUcs.e("RemoteRestClient", str, new Object[0]);
            throw new UcsException(2001, str);
        }
    }

    public NetworkResponse post(NetworkRequest networkRequest) throws IOException {
        NetworkResponse networkResponse = new NetworkResponse();
        Response execute = this.f44887a.a(networkRequest.getUrl(), networkRequest.getHeaders(), networkRequest.getBody()).execute();
        networkResponse.setCode(execute.getCode());
        networkResponse.setHeaders(execute.getHeaders());
        networkResponse.setBody(a(execute));
        return networkResponse;
    }
}
