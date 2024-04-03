package com.newrelic.agent.android.instrumentation.okhttp3;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ResponseBuilderExtension extends Response.Builder {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private Response.Builder impl;

    public ResponseBuilderExtension(Response.Builder builder) {
        this.impl = builder;
    }

    public Response.Builder addHeader(String str, String str2) {
        return this.impl.addHeader(str, str2);
    }

    public Response.Builder body(ResponseBody responseBody) {
        return this.impl.body(responseBody);
    }

    public Response build() {
        return this.impl.build();
    }

    public Response.Builder cacheResponse(Response response) {
        return this.impl.cacheResponse(response);
    }

    public Response.Builder code(int i11) {
        return this.impl.code(i11);
    }

    public Response.Builder handshake(Handshake handshake) {
        return this.impl.handshake(handshake);
    }

    public Response.Builder header(String str, String str2) {
        return this.impl.header(str, str2);
    }

    public Response.Builder headers(Headers headers) {
        return this.impl.headers(headers);
    }

    public Response.Builder message(String str) {
        return this.impl.message(str);
    }

    public Response.Builder networkResponse(Response response) {
        return this.impl.networkResponse(response);
    }

    public Response.Builder priorResponse(Response response) {
        return this.impl.priorResponse(response);
    }

    public Response.Builder protocol(Protocol protocol) {
        return this.impl.protocol(protocol);
    }

    public Response.Builder removeHeader(String str) {
        return this.impl.removeHeader(str);
    }

    public Response.Builder request(Request request) {
        return this.impl.request(request);
    }
}
