package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import org.json.JSONException;

public abstract class JsonEncodable implements JsonSerializable {
    @NonNull
    public static <E extends JsonEncodable> String b(@NonNull E e11, int i11) throws JSONException {
        return e11.a(i11);
    }

    @NonNull
    public String a(int i11) throws JSONException {
        return Base64Coder.encodeToString(serialize(), i11);
    }
}
