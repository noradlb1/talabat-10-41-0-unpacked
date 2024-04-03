package com.android.volley.toolbox;

import androidx.annotation.Nullable;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

@Instrumented
public class JsonArrayRequest extends JsonRequest<JSONArray> {
    public JsonArrayRequest(String str, Response.Listener<JSONArray> listener, @Nullable Response.ErrorListener errorListener) {
        super(0, str, (String) null, listener, errorListener);
    }

    public Response<JSONArray> parseNetworkResponse(NetworkResponse networkResponse) {
        try {
            return Response.success(new JSONArray(new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers, "utf-8"))), HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e11) {
            return Response.error(new ParseError((Throwable) e11));
        } catch (JSONException e12) {
            return Response.error(new ParseError((Throwable) e12));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonArrayRequest(int i11, String str, @Nullable JSONArray jSONArray, Response.Listener<JSONArray> listener, @Nullable Response.ErrorListener errorListener) {
        super(i11, str, jSONArray != null ? JSONArrayInstrumentation.toString(jSONArray) : null, listener, errorListener);
    }
}
