package com.adyen.checkout.base.internal;

import androidx.annotation.NonNull;
import org.json.JSONException;
import org.json.JSONObject;

public interface JsonSerializable {
    @NonNull
    JSONObject serialize() throws JSONException;
}
