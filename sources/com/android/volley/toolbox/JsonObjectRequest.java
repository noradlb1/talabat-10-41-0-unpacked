package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class JsonObjectRequest extends JsonRequest<JSONObject> {
    public JsonObjectRequest(String str, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(0, str, (String) null, listener, errorListener);
    }

    public Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONObject(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e11) {
            return Response.error(new ParseError((Throwable) e11));
        } catch (JSONException e12) {
            return Response.error(new ParseError((Throwable) e12));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Deprecated
    public JsonObjectRequest(String str, @Nullable JSONObject jSONObject, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(jSONObject == null ? 0 : 1, str, jSONObject != null ? JSONObjectInstrumentation.toString(jSONObject) : null, listener, errorListener);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonObjectRequest(int i11, String str, @Nullable JSONObject jSONObject, Response.Listener<JSONObject> listener, @Nullable Response.ErrorListener errorListener) {
        super(i11, str, jSONObject != null ? JSONObjectInstrumentation.toString(jSONObject) : null, listener, errorListener);
    }
}
