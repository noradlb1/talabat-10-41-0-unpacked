package io.flutter.plugin.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.braze.ui.actions.brazeactions.steps.StepData;
import java.nio.ByteBuffer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JSONMethodCodec implements MethodCodec {
    public static final JSONMethodCodec INSTANCE = new JSONMethodCodec();

    private JSONMethodCodec() {
    }

    public Object a(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj;
    }

    @NonNull
    public Object decodeEnvelope(@NonNull ByteBuffer byteBuffer) {
        try {
            Object decodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
            if (decodeMessage instanceof JSONArray) {
                JSONArray jSONArray = (JSONArray) decodeMessage;
                if (jSONArray.length() == 1) {
                    return a(jSONArray.opt(0));
                }
                if (jSONArray.length() == 3) {
                    Object obj = jSONArray.get(0);
                    Object a11 = a(jSONArray.opt(1));
                    Object a12 = a(jSONArray.opt(2));
                    if ((obj instanceof String) && (a11 == null || (a11 instanceof String))) {
                        throw new FlutterException((String) obj, (String) a11, a12);
                    }
                }
            }
            throw new IllegalArgumentException("Invalid envelope: " + decodeMessage);
        } catch (JSONException e11) {
            throw new IllegalArgumentException("Invalid JSON", e11);
        }
    }

    @NonNull
    public MethodCall decodeMethodCall(@NonNull ByteBuffer byteBuffer) {
        try {
            Object decodeMessage = JSONMessageCodec.INSTANCE.decodeMessage(byteBuffer);
            if (decodeMessage instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) decodeMessage;
                Object obj = jSONObject.get("method");
                Object a11 = a(jSONObject.opt(StepData.ARGS));
                if (obj instanceof String) {
                    return new MethodCall((String) obj, a11);
                }
            }
            throw new IllegalArgumentException("Invalid method call: " + decodeMessage);
        } catch (JSONException e11) {
            throw new IllegalArgumentException("Invalid JSON", e11);
        }
    }

    @NonNull
    public ByteBuffer encodeErrorEnvelope(@NonNull String str, @Nullable String str2, @Nullable Object obj) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put((Object) str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)));
    }

    @NonNull
    public ByteBuffer encodeErrorEnvelopeWithStacktrace(@NonNull String str, @Nullable String str2, @Nullable Object obj, @Nullable String str3) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put((Object) str).put(JSONUtil.wrap(str2)).put(JSONUtil.wrap(obj)).put(JSONUtil.wrap(str3)));
    }

    @NonNull
    public ByteBuffer encodeMethodCall(@NonNull MethodCall methodCall) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("method", (Object) methodCall.method);
            jSONObject.put(StepData.ARGS, JSONUtil.wrap(methodCall.arguments));
            return JSONMessageCodec.INSTANCE.encodeMessage(jSONObject);
        } catch (JSONException e11) {
            throw new IllegalArgumentException("Invalid JSON", e11);
        }
    }

    @NonNull
    public ByteBuffer encodeSuccessEnvelope(@Nullable Object obj) {
        return JSONMessageCodec.INSTANCE.encodeMessage(new JSONArray().put(JSONUtil.wrap(obj)));
    }
}
