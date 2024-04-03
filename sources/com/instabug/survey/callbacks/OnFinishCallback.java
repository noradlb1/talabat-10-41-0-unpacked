package com.instabug.survey.callbacks;

import androidx.annotation.Keep;
import org.json.JSONObject;

@Keep
public interface OnFinishCallback {
    void onFinish(String str, String str2, JSONObject jSONObject);
}
