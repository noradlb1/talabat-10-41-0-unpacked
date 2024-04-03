package io.flutter.plugin.common;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class JSONMessageCodec implements MessageCodec<Object> {
    public static final JSONMessageCodec INSTANCE = new JSONMessageCodec();

    private JSONMessageCodec() {
    }

    @Nullable
    public Object decodeMessage(@Nullable ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            JSONTokener jSONTokener = new JSONTokener(StringCodec.INSTANCE.decodeMessage(byteBuffer));
            Object nextValue = jSONTokener.nextValue();
            if (!jSONTokener.more()) {
                return nextValue;
            }
            throw new IllegalArgumentException("Invalid JSON");
        } catch (JSONException e11) {
            throw new IllegalArgumentException("Invalid JSON", e11);
        }
    }

    @Nullable
    public ByteBuffer encodeMessage(@Nullable Object obj) {
        if (obj == null) {
            return null;
        }
        Object wrap = JSONUtil.wrap(obj);
        if (wrap instanceof String) {
            return StringCodec.INSTANCE.encodeMessage(JSONObject.quote((String) wrap));
        }
        return StringCodec.INSTANCE.encodeMessage(wrap.toString());
    }
}
