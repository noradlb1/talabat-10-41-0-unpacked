package com.huawei.location;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.huawei.hms.location.LocationSettingsStates;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationBaseRequest;
import com.huawei.location.activity.model.Vw;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.lite.common.util.LocationUtil;
import com.huawei.location.logic.LW;
import com.huawei.location.req.CheckLocationSettingsReq;
import com.huawei.location.resp.CheckLocationSettingsResp;
import com.huawei.location.resp.FB;
import com.huawei.location.resp.StatusCheck;
import com.huawei.location.router.RouterResponse;
import com.huawei.location.router.entity.StatusInfo;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class CheckSettingsTaskCall extends BaseApiRequest {
    private static final String LOCATION_SETTING_REQUEST = "locationSettingsRequest";
    private static final String TAG = "CheckLocationSettingsApi";

    private CheckLocationSettingsResp changeResponse(FB fb2) {
        CheckLocationSettingsResp checkLocationSettingsResp = new CheckLocationSettingsResp();
        StatusCheck statusCheck = new StatusCheck();
        statusCheck.setStatusCode(fb2.Vw().getStatusCode());
        statusCheck.setStatusMessage(fb2.Vw().getStatusMessage());
        checkLocationSettingsResp.setStatusCheck(statusCheck);
        checkLocationSettingsResp.setLocationSettingsStates(fb2.yn());
        return checkLocationSettingsResp;
    }

    private void parseCheckSettingJson(CheckLocationSettingsReq checkLocationSettingsReq, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            checkLocationSettingsReq.setTid(jSONObject.getString("locTransactionId"));
            checkLocationSettingsReq.setPackageName(jSONObject.getString(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME));
            String string = jSONObject.getString(LOCATION_SETTING_REQUEST);
            if (TextUtils.isEmpty(string)) {
                LogConsole.e(TAG, "parseCheckSettingString locationSettingsRequest is null");
            }
            JSONObject jSONObject2 = new JSONObject(string);
            checkLocationSettingsReq.setAlwaysShow(jSONObject2.getBoolean("alwaysShow"));
            checkLocationSettingsReq.setNeedBle(jSONObject2.getBoolean("needBle"));
        } catch (JSONException unused) {
            LogConsole.i(TAG, "parseCheckSettingString JSONException");
        }
    }

    public void onRequest(String str) {
        String str2;
        boolean z11;
        LogConsole.i(TAG, "onRequest json begin");
        CheckLocationSettingsReq checkLocationSettingsReq = new CheckLocationSettingsReq();
        parseCheckSettingJson(checkLocationSettingsReq, str);
        LW.yn().getClass();
        LocationSettingsStates locationSettingsStates = new LocationSettingsStates();
        boolean yn2 = Vw.yn("gps");
        boolean yn3 = Vw.yn(SDKCoreEvent.Network.TYPE_NETWORK);
        locationSettingsStates.setGnssUsable(yn2);
        locationSettingsStates.setGnssPresent(yn2);
        locationSettingsStates.setGpsUsable(yn2);
        locationSettingsStates.setGpsPresent(yn2);
        locationSettingsStates.setHmsLocationUsable(false);
        locationSettingsStates.setHMSLocationPresent(false);
        locationSettingsStates.setNetworkLocationUsable(yn3);
        locationSettingsStates.setNetworkLocationPresent(yn3);
        boolean isLocationEnabled = LocationUtil.isLocationEnabled(ContextUtil.getContext());
        locationSettingsStates.setLocationUsable(isLocationEnabled);
        locationSettingsStates.setLocationPresent(isLocationEnabled);
        if (checkLocationSettingsReq.isNeedBle()) {
            locationSettingsStates.setBlePresent(LocationUtil.isBlePresent(ContextUtil.getContext()));
            if (LocationUtil.isScanBleEnabled(ContextUtil.getContext()) || LocationUtil.isBlueBoothEnabled(ContextUtil.getContext())) {
                z11 = true;
            } else {
                z11 = false;
            }
            locationSettingsStates.setBleUsable(z11);
        } else {
            locationSettingsStates.setBleUsable(false);
            locationSettingsStates.setBlePresent(false);
        }
        FB fb2 = new FB();
        fb2.yn(Status.SUCCESS);
        fb2.yn(locationSettingsStates);
        StatusInfo statusInfo = new StatusInfo(0, 0, "SUCCESS");
        Gson instance = GsonUtil.getInstance();
        CheckLocationSettingsResp changeResponse = changeResponse(fb2);
        if (!(instance instanceof Gson)) {
            str2 = instance.toJson((Object) changeResponse);
        } else {
            str2 = GsonInstrumentation.toJson(instance, (Object) changeResponse);
        }
        onComplete(new RouterResponse(str2, statusInfo));
        this.reportBuilder.yn("Location_checkSettings");
        this.reportBuilder.yn((LocationBaseRequest) checkLocationSettingsReq);
        this.reportBuilder.yn().yn("0");
    }
}
