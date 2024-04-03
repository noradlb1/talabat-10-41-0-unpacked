package com.talabat.helpers;

import JsonModels.parser.UniversalGson;
import android.text.TextUtils;
import com.adjust.sdk.AdjustAttribution;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.common.net.HttpHeaders;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.core.network.network.TalabatNetworkModuleJWTTokenIntegrator;
import com.talabat.talabatcore.logger.LogManager;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import tracking.perseus.TalabatPerseus;

@Instrumented
public class GsonRequest<T> extends Request<T> {
    private static final String BRAND_TYPE_TALABAT = "1";
    private String appVersion;
    private final Class<T> clazz;
    private final Gson gson;
    private final Map<String, String> headers;
    private final Response.Listener<T> listener;
    private Map<String, String> params;
    private JSONObject requestBody;

    public static class Builder<T> {
        private String appVersion = "";
        private Class<T> clazz = null;
        private Response.ErrorListener errorListener = null;
        private Map<String, String> headers = null;
        private Response.Listener<T> listener = null;
        private int method = 0;
        private Map<String, String> params = null;
        private JSONObject requestBody = null;
        private String url = null;

        public GsonRequest<T> build() {
            return new GsonRequest(this.method, this.url, this.clazz, this.headers, this.params, this.listener, this.errorListener, this.requestBody, this.appVersion);
        }

        public Builder<T> setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder<T> setClazz(Class<T> cls) {
            this.clazz = cls;
            return this;
        }

        public Builder<T> setErrorListener(final Response.ErrorListener errorListener2) {
            this.errorListener = new Response.ErrorListener() {
                public void onErrorResponse(VolleyError volleyError) {
                    Response.ErrorListener errorListener = errorListener2;
                    if (errorListener != null) {
                        errorListener.onErrorResponse(volleyError);
                    }
                }
            };
            return this;
        }

        public Builder<T> setHeaders(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public Builder<T> setListener(Response.Listener<T> listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder<T> setMethod(int i11) {
            this.method = i11;
            return this;
        }

        public Builder<T> setParams(Map<String, String> map) {
            this.params = map;
            return this;
        }

        public Builder<T> setRequestBody(JSONObject jSONObject) {
            this.requestBody = jSONObject;
            return this;
        }

        public Builder<T> setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    private GsonRequest(int i11, String str, Class<T> cls, Map<String, String> map, Map<String, String> map2, Response.Listener<T> listener2, Response.ErrorListener errorListener, JSONObject jSONObject, String str2) {
        super(i11, str, errorListener);
        this.gson = UniversalGson.INSTANCE.gson;
        this.clazz = cls;
        this.headers = map;
        this.params = map2;
        this.listener = listener2;
        this.requestBody = jSONObject;
        this.appVersion = str2;
        setRetryPolicy(new DefaultRetryPolicy(60, 1, 1.0f));
    }

    public void deliverResponse(T t11) {
        this.listener.onResponse(t11);
    }

    public byte[] getBody() throws AuthFailureError {
        String str;
        JSONObject jSONObject = this.requestBody;
        if (jSONObject != null) {
            try {
                if (!(jSONObject instanceof JSONObject)) {
                    str = jSONObject.toString();
                } else {
                    str = JSONObjectInstrumentation.toString(jSONObject);
                }
                return str.getBytes(getParamsEncoding());
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return super.getBody();
    }

    public String getBodyContentType() {
        if (this.requestBody != null) {
            return "application/json";
        }
        return super.getBodyContentType();
    }

    public Class<T> getClazz() {
        return this.clazz;
    }

    public Gson getGson() {
        return this.gson;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, GlobalDataModel.SelectedLanguage);
        hashMap.put("X-Device-Source", "6");
        hashMap.put("BrandType", "1");
        hashMap.put("AppBrand", "1");
        hashMap.put("X-Device-Version", this.appVersion);
        TalabatPerseus.Companion companion = TalabatPerseus.Companion;
        hashMap.put("X-PerseusSessionId", companion.getNetworkHeaderSessionId());
        hashMap.put("X-PerseusClientId", companion.getNetworkHeaderClientId());
        AdjustAttribution adjustAttribution = GlobalDataModel.adjustAttribution;
        if (adjustAttribution != null) {
            str = adjustAttribution.adid;
        } else {
            str = null;
        }
        hashMap.put("X-AdjustId", str);
        hashMap.put("X-AdvertisingId", GlobalDataModel.googleAdId);
        TalabatNetworkModuleJWTTokenIntegrator talabatNetworkModuleJWTTokenIntegrator = TalabatNetworkModuleJWTTokenIntegrator.INSTANCE;
        talabatNetworkModuleJWTTokenIntegrator.getJWTFeatureEnable().invoke(getUrl());
        String invoke = talabatNetworkModuleJWTTokenIntegrator.getObtainAccessToken().invoke(getUrl());
        if (!TextUtils.isEmpty(invoke) && !"null".equals(invoke)) {
            hashMap.put("Authorization", "Bearer " + invoke);
            hashMap.put("AuthTokenType", "jwt");
        } else if (GlobalDataModel.token != null) {
            hashMap.put("Authorization", GlobalDataModel.token.token_type + " " + GlobalDataModel.token.access_token);
            hashMap.put("AuthTokenType", "owin");
        } else {
            hashMap.put("AuthTokenType", "guest");
        }
        Map<String, String> map = this.headers;
        if (map != null) {
            map.putAll(hashMap);
        }
        LogManager.debug("headers: " + hashMap);
        Map<String, String> map2 = this.headers;
        if (map2 != null) {
            return map2;
        }
        return hashMap;
    }

    public Map<String, String> getParams() throws AuthFailureError {
        Map<String, String> map = this.params;
        return map != null ? map : super.getParams();
    }

    public Response<T> parseNetworkResponse(NetworkResponse networkResponse) {
        T t11;
        try {
            String str = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));
            LogManager.debug("Api: " + getUrl() + " Response: " + str);
            Gson gson2 = this.gson;
            Class<T> cls = this.clazz;
            if (!(gson2 instanceof Gson)) {
                t11 = gson2.fromJson(str, cls);
            } else {
                t11 = GsonInstrumentation.fromJson(gson2, str, cls);
            }
            return Response.success(t11, HttpHeaderParser.parseCacheHeaders(networkResponse));
        } catch (UnsupportedEncodingException e11) {
            return Response.error(new ParseError((Throwable) e11));
        } catch (JsonSyntaxException e12) {
            return Response.error(new ParseError((Throwable) e12));
        }
    }
}
