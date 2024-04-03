package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonDecodable extends JsonObject {
    public JsonDecodable(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    @NonNull
    public static <T extends JsonDecodable> T decodeFrom(@NonNull String str, @NonNull Class<T> cls) throws JSONException {
        return decodeFrom(str, cls, 0);
    }

    @NonNull
    public static <T extends JsonDecodable> T decodeFrom(@NonNull String str, @NonNull Class<T> cls, int i11) throws JSONException {
        return (JsonDecodable) JsonObject.parseFrom(Base64Coder.decodeToJSONObject(str, i11), cls);
    }
}
