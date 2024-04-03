package com.huawei.location.lite.common.http.request;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.location.lite.common.http.adapter.RequestBodyAdapter;
import com.huawei.location.lite.common.log.LogConsole;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class RequestJsonBody extends RequestBodyAdapter {
    public static final String APPLICATION_JSON_UTF_8 = "application/json; charset=utf-8";
    private static final String TAG = "RequestJsonBody";
    private String body;

    public static final class Builder {
        public static final int DATA_FORMAT_TYPE_RAW = 1;
        /* access modifiers changed from: private */
        public int dataFormatType;
        /* access modifiers changed from: private */
        public JSONObject jsonBody;
        /* access modifiers changed from: private */
        public StringBuilder rawBody;

        public Builder() {
            this.jsonBody = new JSONObject();
        }

        public Builder(int i11) {
            this.jsonBody = new JSONObject();
            this.rawBody = new StringBuilder("");
            this.dataFormatType = i11;
        }

        public Builder add(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                try {
                    if (this.dataFormatType == 1) {
                        StringBuilder sb2 = this.rawBody;
                        sb2.append(str);
                        sb2.append("=");
                        sb2.append(str2);
                        sb2.append(ContainerUtils.FIELD_DELIMITER);
                    } else {
                        this.jsonBody.put(str, (Object) str2);
                    }
                } catch (JSONException unused) {
                    LogConsole.e(RequestJsonBody.TAG, "add: failed");
                }
            }
            return this;
        }

        public RequestJsonBody build() {
            return new RequestJsonBody(this);
        }

        public RequestJsonBody build(JSONObject jSONObject) {
            this.jsonBody = jSONObject;
            return new RequestJsonBody(this);
        }

        public Builder setBody(JSONObject jSONObject) {
            this.jsonBody = jSONObject;
            return this;
        }
    }

    public RequestJsonBody(Builder builder) {
        String jSONObject;
        if (builder.dataFormatType != 1) {
            JSONObject c11 = builder.jsonBody;
            jSONObject = !(c11 instanceof JSONObject) ? c11.toString() : JSONObjectInstrumentation.toString(c11);
        } else if (!TextUtils.isEmpty(builder.rawBody)) {
            jSONObject = builder.rawBody.substring(0, builder.rawBody.length() - 1);
        } else {
            return;
        }
        this.body = jSONObject;
    }

    public String contentType() {
        return APPLICATION_JSON_UTF_8;
    }

    public String getBody() {
        return this.body;
    }
}
