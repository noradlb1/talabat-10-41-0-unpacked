package com.instabug.library.model;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.logging.d;
import com.instabug.library.networkv2.BodyBufferHelper;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkLog {
    public static final String CONTENT_TYPE = "content-type";
    public static final String HTML = "text/html";
    public static final String JSON = "application/json";
    public static final String PLAIN_TEXT = "text/plain";
    public static final String PROTOBUF = "application/protobuf";
    public static final int SQL_RECORD_CHAR_LIMIT = 1000000;
    public static final String XML_1 = "application/xml";
    public static final String XML_2 = "text/xml";
    @Nullable
    private String date;
    @Nullable
    private String method;
    @Nullable
    private String request;
    @Nullable
    private String requestHeaders;
    @Nullable
    private String response;
    private int responseCode;
    @Nullable
    private String responseHeaders;
    private long totalDuration;
    @Nullable
    private String url;
    private boolean userModified = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d.a(NetworkLog.this);
        }
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkLog)) {
            return false;
        }
        NetworkLog networkLog = (NetworkLog) obj;
        if (this.responseCode != networkLog.responseCode) {
            return false;
        }
        String str = this.date;
        if (str == null ? networkLog.date != null : !str.equals(networkLog.date)) {
            return false;
        }
        String str2 = this.url;
        if (str2 == null ? networkLog.url != null : !str2.equals(networkLog.url)) {
            return false;
        }
        String str3 = this.request;
        if (str3 == null ? networkLog.request != null : !str3.equals(networkLog.request)) {
            return false;
        }
        String str4 = this.response;
        if (str4 == null ? networkLog.response != null : !str4.equals(networkLog.response)) {
            return false;
        }
        String str5 = this.method;
        if (str5 == null ? networkLog.method != null : !str5.equals(networkLog.method)) {
            return false;
        }
        if (this.totalDuration != networkLog.totalDuration) {
            return false;
        }
        String str6 = this.responseHeaders;
        if (str6 == null ? networkLog.responseHeaders != null : !str6.equals(networkLog.responseHeaders)) {
            return false;
        }
        if (this.userModified != networkLog.userModified) {
            return false;
        }
        String str7 = this.requestHeaders;
        String str8 = networkLog.requestHeaders;
        if (str7 != null) {
            return str7.equals(str8);
        }
        if (str8 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public String getDate() {
        return this.date;
    }

    @Nullable
    public String getMethod() {
        return this.method;
    }

    @Nullable
    public String getRequest() {
        return this.request;
    }

    @Nullable
    public String getRequestHeaders() {
        return this.requestHeaders;
    }

    @Nullable
    public String getResponse() {
        return this.response;
    }

    public int getResponseCode() {
        return this.responseCode;
    }

    @Nullable
    public String getResponseHeaders() {
        return this.responseHeaders;
    }

    public long getTotalDuration() {
        return this.totalDuration;
    }

    @Nullable
    public String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        String str = this.date;
        int i17 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i18 = i11 * 31;
        String str2 = this.url;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i19 = (i18 + i12) * 31;
        String str3 = this.request;
        if (str3 != null) {
            i13 = str3.hashCode();
        } else {
            i13 = 0;
        }
        int i21 = (i19 + i13) * 31;
        String str4 = this.response;
        if (str4 != null) {
            i14 = str4.hashCode();
        } else {
            i14 = 0;
        }
        int i22 = (i21 + i14) * 31;
        String str5 = this.method;
        if (str5 != null) {
            i15 = str5.hashCode();
        } else {
            i15 = 0;
        }
        int i23 = (((i22 + i15) * 31) + this.responseCode) * 31;
        String str6 = this.responseHeaders;
        if (str6 != null) {
            i16 = str6.hashCode();
        } else {
            i16 = 0;
        }
        int i24 = (i23 + i16) * 31;
        String str7 = this.requestHeaders;
        if (str7 != null) {
            i17 = str7.hashCode();
        }
        return ((((i24 + i17) * 31) + Long.valueOf(this.totalDuration).hashCode()) * 31) + (this.userModified ? 1 : 0);
    }

    public void insert() {
        com.instabug.library.experiments.di.a.e().execute(new a());
    }

    public boolean isUserModified() {
        return this.userModified;
    }

    public void setDate(@Nullable String str) {
        this.date = str;
    }

    public void setMethod(@Nullable String str) {
        this.method = str;
    }

    public void setRequest(@Nullable String str) {
        if (str != null) {
            if (!BodyBufferHelper.isBodySizeAllowed(str)) {
                str = BodyBufferHelper.MAX_SIZE_ALERT;
            }
            this.request = str;
        }
    }

    public void setRequestHeaders(@Nullable String str) {
        this.requestHeaders = str;
    }

    public void setResponse(@Nullable String str) {
        if (str != null) {
            if (!BodyBufferHelper.isBodySizeAllowed(str)) {
                str = BodyBufferHelper.MAX_SIZE_ALERT;
            }
            this.response = str;
        }
    }

    public void setResponseCode(int i11) {
        this.responseCode = i11;
    }

    public void setResponseHeaders(@Nullable String str) {
        this.responseHeaders = str;
    }

    public void setTotalDuration(long j11) {
        this.totalDuration = j11;
    }

    public void setUrl(@Nullable String str) {
        this.url = str;
    }

    public void setUserModified(boolean z11) {
        this.userModified = z11;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public JSONObject toJsonObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("date", (Object) getDate());
        jSONObject.put("method", (Object) getMethod());
        jSONObject.put("status", getResponseCode());
        jSONObject.put("url", (Object) getUrl());
        jSONObject.put(InstabugDbContract.NetworkLogEntry.COLUMN_NETWORK_TIME, getTotalDuration());
        jSONObject.put(InstabugDbContract.NetworkLogEntry.COLUMN_USER_MODIFIED, isUserModified());
        try {
            jSONObject.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, (Object) new JSONObject(getRequestHeaders()));
        } catch (Exception unused) {
            jSONObject.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, (Object) getRequestHeaders());
        }
        try {
            jSONObject.put("response_headers", (Object) new JSONObject(getResponseHeaders()));
        } catch (Exception unused2) {
            jSONObject.put("response_headers", (Object) getResponseHeaders());
        }
        try {
            jSONObject.put("request", (Object) new JSONObject(getRequest()));
        } catch (Exception unused3) {
            jSONObject.put("request", (Object) getRequest());
        }
        try {
            jSONObject.put("response", (Object) new JSONObject(getResponse()));
        } catch (Exception unused4) {
            jSONObject.put("response", (Object) getResponse());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        return "NetworkLog{date='" + this.date + '\'' + ", url='" + this.url + '\'' + ", request='" + this.request + '\'' + ", method='" + this.method + '\'' + ", responseCode=" + this.responseCode + ", headers='" + this.requestHeaders + '\'' + ", response='" + this.response + '\'' + ", response_headers='" + this.responseHeaders + '\'' + ", totalDuration='" + this.totalDuration + '\'' + ", modifiedByUser='" + this.userModified + '\'' + AbstractJsonLexerKt.END_OBJ;
    }
}
