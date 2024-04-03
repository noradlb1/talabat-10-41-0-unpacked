package com.huawei.hms.dtm.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.analytics.type.HAParamType;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.l;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class Wd {

    /* renamed from: a  reason: collision with root package name */
    private String f48432a;

    /* renamed from: b  reason: collision with root package name */
    private long f48433b;

    private void a(JSONObject jSONObject) {
        String str;
        Bundle bundle = new Bundle();
        try {
            if (!jSONObject.isNull("id")) {
                bundle.putString("$DTM_AT_XPATH", jSONObject.getString("id"));
            }
            if (!jSONObject.isNull("idList")) {
                bundle.putString("$DTM_AT_XPATH_LIST", jSONObject.getString("idList"));
            }
            if (!jSONObject.isNull("pageId")) {
                bundle.putString("$DTM_AT_TARGET", jSONObject.getString("pageId"));
            }
            if (!jSONObject.isNull(NativeProtocol.WEB_DIALOG_PARAMS)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(l.a(next), jSONObject2.getString(next));
                }
            }
            if (!jSONObject.isNull("name")) {
                str = jSONObject.getString("name");
                bundle.putString("$DTM_AT_EVENT", str);
            } else {
                str = null;
            }
            DynamicTagManager.getInstance().logEvent(str, bundle);
        } catch (JSONException e11) {
            Logger.debug("DTM-AutoTrace", "JsBridge.handleClick " + e11.toString());
        }
    }

    private void b(JSONObject jSONObject) {
        try {
            String str = null;
            String string = !jSONObject.isNull("_preUrl") ? jSONObject.getString("_preUrl") : null;
            if (!jSONObject.isNull("_curUrl")) {
                str = jSONObject.getString("_curUrl");
                if (!TextUtils.isEmpty(this.f48432a)) {
                    a(this.f48432a);
                }
                this.f48432a = str;
                this.f48433b = System.currentTimeMillis();
            }
            Bundle bundle = new Bundle();
            bundle.putString("$PrevActivityName", string);
            bundle.putString("$PrevActivityClass", string);
            bundle.putString("$PrevActivityId", "");
            bundle.putString("$CurActivityName", str);
            bundle.putString("$CurActivityClass", str);
            bundle.putString("$CurActivityId", "");
            bundle.putString(HAParamType.TASKID, "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("JsBridge.handlePageEnter ");
            sb2.append(str);
            Logger.debug("DTM-AutoTrace", sb2.toString());
            DynamicTagManager.getInstance().onEventExecuted("$EnterScreen", bundle);
        } catch (JSONException e11) {
            Logger.error("DTM-AutoTrace", "handlePageEnter Error#" + e11.getMessage());
        }
    }

    public void a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("$CurActivityName", str);
        bundle.putString("$CurActivityClass", str);
        bundle.putString("$CurActivityId", "");
        long currentTimeMillis = System.currentTimeMillis() - this.f48433b;
        bundle.putString(HAParamType.DURATION, String.valueOf(currentTimeMillis));
        bundle.putString(HAParamType.TASKID, "");
        Logger.debug("DTM-AutoTrace", "JsBridge.logPageLeave " + str + " " + currentTimeMillis);
        DynamicTagManager.getInstance().onEventExecuted("$ExitScreen", bundle);
    }

    @JavascriptInterface
    public void onEvent(String str) {
        Logger.debug("DTM-AutoTrace", "JsBridge.onEvent:" + str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = !jSONObject.isNull("type") ? jSONObject.getString("type") : null;
            if (TextUtils.isEmpty(string)) {
                return;
            }
            if (string.equals("CLICK")) {
                a(jSONObject);
            } else if (string.equals("PAGE_ENTER")) {
                b(jSONObject);
            }
        } catch (JSONException e11) {
            Logger.debug("DTM-AutoTrace", "JsBridge.onEvent " + e11.toString());
        }
    }
}
