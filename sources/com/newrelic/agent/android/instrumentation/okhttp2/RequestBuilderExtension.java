package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.util.Constants;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.net.URL;

public class RequestBuilderExtension extends Request.Builder {
    private Request.Builder impl;

    public RequestBuilderExtension(Request.Builder builder) {
        this.impl = builder;
        setCrossProcessHeader();
    }

    public Request.Builder addHeader(String str, String str2) {
        return this.impl.addHeader(str, str2);
    }

    public Request build() {
        return this.impl.build();
    }

    public Request.Builder cacheControl(CacheControl cacheControl) {
        return this.impl.cacheControl(cacheControl);
    }

    public Request.Builder delete() {
        return this.impl.delete();
    }

    public Request.Builder get() {
        return this.impl.get();
    }

    public Request.Builder head() {
        return this.impl.head();
    }

    public Request.Builder header(String str, String str2) {
        return this.impl.header(str, str2);
    }

    public Request.Builder headers(Headers headers) {
        return this.impl.headers(headers);
    }

    public Request.Builder method(String str, RequestBody requestBody) {
        return this.impl.method(str, requestBody);
    }

    public Request.Builder patch(RequestBody requestBody) {
        return this.impl.patch(requestBody);
    }

    public Request.Builder post(RequestBody requestBody) {
        return this.impl.post(requestBody);
    }

    public Request.Builder put(RequestBody requestBody) {
        return this.impl.put(requestBody);
    }

    public Request.Builder removeHeader(String str) {
        return this.impl.removeHeader(str);
    }

    public void setCrossProcessHeader() {
        String crossProcessId = Agent.getCrossProcessId();
        if (crossProcessId != null) {
            this.impl.removeHeader(Constants.Network.CROSS_PROCESS_ID_HEADER);
            this.impl.addHeader(Constants.Network.CROSS_PROCESS_ID_HEADER, crossProcessId);
        }
    }

    public Request.Builder tag(Object obj) {
        return this.impl.tag(obj);
    }

    public Request.Builder url(String str) {
        return this.impl.url(str);
    }

    public Request.Builder url(URL url) {
        return this.impl.url(url);
    }
}
