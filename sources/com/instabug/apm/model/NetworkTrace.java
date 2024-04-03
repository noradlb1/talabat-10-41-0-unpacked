package com.instabug.apm.model;

import androidx.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class NetworkTrace {
    @Nullable
    private String carrier;
    @Nullable
    private String errorMessage;
    private String method = "get";
    @Nullable
    private String radio;
    @Nullable
    private String requestBody;
    private long requestBodySize;
    @Nullable
    private String requestContentType;
    @Nullable
    private String requestHeaders;
    @Nullable
    private String responseBody;
    private long responseBodySize;
    private int responseCode;
    @Nullable
    private String responseContentType;
    @Nullable
    private String responseHeaders;
    @Nullable
    private Long startTime;
    private long totalDuration;
    @Nullable
    private String url;

    public void a(@Nullable String str) {
        this.carrier = str;
    }

    public void b(@Nullable String str) {
        this.errorMessage = str;
    }

    public void c(String str) {
        this.method = str;
    }

    public void d(@Nullable String str) {
        this.radio = str;
    }

    public void e(@Nullable String str) {
        this.requestBody = str;
    }

    public void f(long j11) {
        this.requestBodySize = j11;
    }

    public void g(@Nullable String str) {
        this.requestContentType = str;
    }

    @Nullable
    public String getCarrier() {
        return this.carrier;
    }

    @Nullable
    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getMethod() {
        return this.method;
    }

    @Nullable
    public String getRadio() {
        return this.radio;
    }

    @Nullable
    public String getRequestBody() {
        return this.requestBody;
    }

    public long getRequestBodySize() {
        return this.requestBodySize;
    }

    @Nullable
    public String getRequestContentType() {
        return this.requestContentType;
    }

    @Nullable
    public String getRequestHeaders() {
        return this.requestHeaders;
    }

    @Nullable
    public String getResponseBody() {
        return this.responseBody;
    }

    public long getResponseBodySize() {
        return this.responseBodySize;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public String getResponseContentType() {
        return this.responseContentType;
    }

    @Nullable
    public String getResponseHeaders() {
        return this.responseHeaders;
    }

    @Nullable
    public Long getStartTime() {
        return this.startTime;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public void h(@Nullable String str) {
        this.requestHeaders = str;
    }

    public void i(@Nullable String str) {
        this.responseBody = str;
    }

    public void j(long j11) {
        this.responseBodySize = j11;
    }

    public void k(int i11) {
        this.responseCode = i11;
    }

    public void l(@Nullable String str) {
        this.responseContentType = str;
    }

    public void m(@Nullable String str) {
        this.responseHeaders = str;
    }

    public void n(@Nullable Long l11) {
        this.startTime = l11;
    }

    public void o(long j11) {
        this.totalDuration = j11;
    }

    public void p(@Nullable String str) {
        this.url = str;
    }

    public String toString() {
        return "APMNetworkLog{url = " + this.url + ", \nmethod = " + this.method + ", \nstartTime = " + this.startTime + ", \nradio = " + this.radio + ", \ncarrier = " + this.carrier + ", \ntotalDuration = " + this.totalDuration + ", \nresponseCode = " + this.responseCode + ", \nerrorMessage = " + this.errorMessage + ", \nrequestHeaders = " + this.requestHeaders + ", \nrequestContentType = " + this.requestContentType + ", \nrequestBodySize = " + this.requestBodySize + ", \nrequestBody = " + this.requestBody + ", \nresponseHeaders = " + this.responseHeaders + ", \nresponseContentType = " + this.responseContentType + ", \nresponseBodySize = " + this.responseBodySize + ", \nresponseBody = " + this.responseBody + AbstractJsonLexerKt.END_OBJ;
    }
}
