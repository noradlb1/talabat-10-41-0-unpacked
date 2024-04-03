package com.huawei.location;

import android.location.Location;
import com.google.gson.Gson;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationRequest;
import com.huawei.hms.support.api.entity.location.lastlocation.GetLastLocationResponse;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.location.activity.model.Vw;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.logic.LW;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.huawei.location.utils.yn;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class GetLastLocationTaskCall extends BaseApiRequest {
    private static final String TAG = "GetLastLocationApi";

    private String buildRpt(GetLastLocationRequest getLastLocationRequest) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("buildRpt:");
        Gson instance = GsonUtil.getInstance();
        sb2.append(!(instance instanceof Gson) ? instance.toJson((Object) getLastLocationRequest) : GsonInstrumentation.toJson(instance, (Object) getLastLocationRequest));
        LogConsole.i(TAG, sb2.toString());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("needAddress", getLastLocationRequest.getNeedAddress());
            return JSONObjectInstrumentation.toString(jSONObject);
        } catch (JSONException unused) {
            LogConsole.e(TAG, "buildRpt failed by exception");
            return "";
        }
    }

    public void onRequest(String str) {
        String str2;
        LogConsole.i(TAG, "onRequest GetLastLocationTaskCall");
        GetLastLocationRequest getLastLocationRequest = new GetLastLocationRequest(ContextUtil.getContext());
        this.apiName = "Location_getLocation";
        try {
            checkApproximatelyPermission();
            Location Vw = LW.yn().Vw();
            StatusInfo statusInfo = new StatusInfo(0, 0, "");
            GetLastLocationResponse getLastLocationResponse = new GetLastLocationResponse();
            yn.yn(str, (IMessageEntity) getLastLocationRequest);
            getLastLocationResponse.setLocation(Vw);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject = Vw.yn(getLastLocationResponse.getLocation());
            } catch (JSONException unused) {
                LogConsole.e("LocationInnerUtil", "buildEntityFromResponse get jsonException .");
            }
            if (!(jSONObject instanceof JSONObject)) {
                str2 = jSONObject.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(jSONObject);
            }
            doExecute(new RouterResponse(str2, statusInfo));
            this.reportBuilder.Vw(buildRpt(getLastLocationRequest));
        } catch (LocationServiceException e11) {
            this.errorCode = String.valueOf(e11.getExceptionCode());
            onRequestFail(e11.getExceptionCode(), e11.getMessage());
        } catch (Exception unused2) {
            this.errorCode = String.valueOf(10000);
            onRequestFail(10000, LocationStatusCode.getStatusCodeString(10000));
        }
        report(getLastLocationRequest);
    }
}
