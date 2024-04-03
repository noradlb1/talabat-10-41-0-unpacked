package com.adyen.checkout.base.internal;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class Base64Coder {
    private static final Charset DEFAULT_CHARSET = Api.CHARSET;
    public static final int DEFAULT_FLAGS = 0;

    private Base64Coder() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static <D extends JsonDecodable> D decode(@NonNull String str, @NonNull Class<D> cls) throws JSONException {
        return decode(str, cls, 0);
    }

    @NonNull
    public static JSONObject decodeToJSONObject(@NonNull String str) throws JSONException {
        return decodeToJSONObject(str, 0);
    }

    @NonNull
    public static String decodeToString(@NonNull String str) {
        return decodeToString(str, 0);
    }

    @NonNull
    public static <E extends JsonEncodable> String encode(@NonNull E e11) throws JSONException {
        return encode(e11, 0);
    }

    @NonNull
    public static String encodeToString(@NonNull JSONObject jSONObject) {
        return encodeToString(jSONObject, 0);
    }

    @NonNull
    public static <D extends JsonDecodable> D decode(@NonNull String str, @NonNull Class<D> cls, int i11) throws JSONException {
        return JsonDecodable.decodeFrom(str, cls, i11);
    }

    @NonNull
    public static JSONObject decodeToJSONObject(@NonNull String str, int i11) throws JSONException {
        return new JSONObject(decodeToString(str, i11));
    }

    @NonNull
    public static String decodeToString(@NonNull String str, int i11) {
        return new String(Base64.decode(str, i11), DEFAULT_CHARSET);
    }

    @NonNull
    public static <E extends JsonEncodable> String encode(@NonNull E e11, int i11) throws JSONException {
        return JsonEncodable.b(e11, i11);
    }

    @NonNull
    public static String encodeToString(@NonNull JSONObject jSONObject, int i11) {
        return encodeToString(!(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject), i11);
    }

    @NonNull
    public static String encodeToString(@NonNull String str) {
        return encodeToString(str, 0);
    }

    @NonNull
    public static String encodeToString(@NonNull String str, int i11) {
        return Base64.encodeToString(str.getBytes(DEFAULT_CHARSET), i11);
    }
}
