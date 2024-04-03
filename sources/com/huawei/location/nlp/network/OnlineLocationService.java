package com.huawei.location.nlp.network;

import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.grs.LocationNlpGrsHelper;
import com.huawei.location.lite.common.http.HttpClientEx;
import com.huawei.location.lite.common.http.exception.OnErrorException;
import com.huawei.location.lite.common.http.exception.OnFailureException;
import com.huawei.location.lite.common.http.request.BaseRequest;
import com.huawei.location.lite.common.http.request.HeadBuilder;
import com.huawei.location.lite.common.http.request.RequestJsonBody;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import com.huawei.location.lite.common.util.GsonUtil;
import com.huawei.location.nlp.constant.yn;
import com.huawei.location.nlp.network.request.OnlineLocationRequest;
import com.huawei.location.nlp.network.response.OnlineLocationResponse;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class OnlineLocationService {
    private static final int FLAG_ACCURACY = 16;
    private static final int FLAG_BEARING = 8;
    private static final int FLAG_SPEED = 4;
    private static final String LOCATION_URL = "/networklocation/v1/onlineLocation";
    public static final String SRC_DEFAULT = "4";
    private static final String TAG = "OnlineLocationService";
    public static final String X_REQ_SRC = "X-Req-src";

    private boolean convertNativeLocation(Location location, OnlineLocationResponse onlineLocationResponse) {
        String str;
        com.huawei.location.nlp.network.response.Location position = onlineLocationResponse.getPosition();
        if (position == null) {
            str = "convertNativeLocation, responseLocation is null.";
        } else {
            short flags = position.getFlags();
            if (flags <= 0) {
                str = "convertNativeLocation, flag is invalid.";
            } else if ((flags & 1) <= 0) {
                str = "convertNativeLocation, lon&lat is invalid.";
            } else {
                location.setLatitude(position.getLatitude());
                location.setLongitude(position.getLongitude());
                if ((flags & 4) != 0) {
                    location.setSpeed(position.getSpeed());
                }
                if ((flags & 8) != 0) {
                    location.setBearing(position.getBearing());
                }
                if ((flags & 16) != 0) {
                    location.setAccuracy(position.getAccuracy());
                }
                location.setTime(position.getTime() <= 0 ? System.currentTimeMillis() : position.getTime());
                location.setProvider(SDKCoreEvent.Network.TYPE_NETWORK);
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(onlineLocationResponse.getSessionId())) {
                    bundle.putString("session_id", onlineLocationResponse.getSessionId());
                }
                bundle.putInt(LogWriteConstants.VENDOR_TYPE, 1);
                bundle.putString(LogWriteConstants.LOCATE_TYPE, onlineLocationResponse.getLocateType());
                bundle.putString(LogWriteConstants.BUILDING_ID, position.getBuildingId());
                bundle.putInt(LogWriteConstants.FLOOR, position.getFloor());
                bundle.putInt(LogWriteConstants.FLOOR_ACC, position.getFloorAcc());
                bundle.putLong("time", position.getTime());
                bundle.putShort("flags", position.getFlags());
                location.setExtras(bundle);
                return true;
            }
        }
        LogConsole.e(TAG, str);
        return false;
    }

    private OnlineLocationResponse doHttp(OnlineLocationRequest onlineLocationRequest) {
        String str;
        String str2;
        StringBuilder sb2;
        LogConsole.i(TAG, "doHttp, request is " + onlineLocationRequest.toString());
        OnlineLocationResponse onlineLocationResponse = new OnlineLocationResponse();
        Gson instance = GsonUtil.getInstance();
        try {
            try {
                RequestJsonBody build = new RequestJsonBody.Builder().build(new JSONObject(!(instance instanceof Gson) ? instance.toJson((Object) onlineLocationRequest) : GsonInstrumentation.toJson(instance, (Object) onlineLocationRequest)));
                String grsHostAddress = LocationNlpGrsHelper.getGrsHostAddress("com.huawei.hms.location");
                if (TextUtils.isEmpty(grsHostAddress)) {
                    LogConsole.e(TAG, "grsHostAddress is null");
                    return onlineLocationResponse;
                }
                String packageName = ContextUtil.getContext().getPackageName();
                HashMap hashMap = new HashMap();
                hashMap.put(X_REQ_SRC, SRC_DEFAULT);
                String uuid = UUID.randomUUID().toString();
                OnlineLocationResponse onlineLocationResponse2 = (OnlineLocationResponse) new HttpClientEx().newSubmit(new BaseRequest.Builder(LOCATION_URL).setBaseUrl(grsHostAddress).setHeads(new HeadBuilder(uuid).setPackageName(packageName).addAll(hashMap)).setBody(build).build()).execute(OnlineLocationResponse.class);
                try {
                    onlineLocationResponse2.setSessionId(uuid);
                    LogConsole.i(TAG, "doHttp, response code is " + onlineLocationResponse2.getApiCode());
                    return onlineLocationResponse2;
                } catch (OnFailureException e11) {
                    OnFailureException onFailureException = e11;
                    onlineLocationResponse = onlineLocationResponse2;
                    e = onFailureException;
                } catch (OnErrorException e12) {
                    OnErrorException onErrorException = e12;
                    onlineLocationResponse = onlineLocationResponse2;
                    e = onErrorException;
                    sb2 = new StringBuilder();
                    sb2.append("doHttp, OnErrorException: code is ");
                    sb2.append(e.getApiCode());
                    sb2.append(", msg is ");
                    str2 = e.getApiMsg();
                    sb2.append(str2);
                    str = sb2.toString();
                    LogConsole.e(TAG, str);
                    return onlineLocationResponse;
                } catch (Exception unused) {
                    onlineLocationResponse = onlineLocationResponse2;
                    str = "unknown exception";
                    LogConsole.e(TAG, str);
                    return onlineLocationResponse;
                }
            } catch (OnFailureException e13) {
                e = e13;
                sb2 = new StringBuilder();
                sb2.append("doHttp, OnFailureException: code is ");
                sb2.append(e.getErrorCode());
                sb2.append(", msg is ");
                str2 = e.getMessage();
                sb2.append(str2);
                str = sb2.toString();
                LogConsole.e(TAG, str);
                return onlineLocationResponse;
            } catch (OnErrorException e14) {
                e = e14;
                sb2 = new StringBuilder();
                sb2.append("doHttp, OnErrorException: code is ");
                sb2.append(e.getApiCode());
                sb2.append(", msg is ");
                str2 = e.getApiMsg();
                sb2.append(str2);
                str = sb2.toString();
                LogConsole.e(TAG, str);
                return onlineLocationResponse;
            } catch (Exception unused2) {
                str = "unknown exception";
                LogConsole.e(TAG, str);
                return onlineLocationResponse;
            }
        } catch (JSONException unused3) {
            LogConsole.e(TAG, "doHttp, transfer to JSONException failed");
            return onlineLocationResponse;
        }
    }

    public HwLocationResult getLocationFromCloud(OnlineLocationRequest onlineLocationRequest) {
        onlineLocationRequest.setBoottime(SystemClock.elapsedRealtimeNanos() / 1000);
        OnlineLocationResponse doHttp = doHttp(onlineLocationRequest);
        HwLocationResult hwLocationResult = new HwLocationResult();
        Location location = new Location(SDKCoreEvent.Network.TYPE_NETWORK);
        if (!doHttp.isSuccess()) {
            LogConsole.e(TAG, "getLocationFromCloud, response is failed");
            hwLocationResult.setCode(11000);
            hwLocationResult.setMessage(yn.yn(11000));
            return hwLocationResult;
        } else if (!convertNativeLocation(location, doHttp)) {
            hwLocationResult.setCode(11000);
            hwLocationResult.setMessage(yn.yn(11000));
            return hwLocationResult;
        } else {
            if (doHttp.getIndoor() == 0) {
                String locateType = doHttp.getLocateType();
                if ("wifi".equalsIgnoreCase(locateType)) {
                    location.setElapsedRealtimeNanos(com.huawei.location.nlp.logic.yn.dC().d2());
                }
                if ("cell".equalsIgnoreCase(locateType)) {
                    location.setElapsedRealtimeNanos(com.huawei.location.nlp.logic.yn.dC().LW());
                }
            }
            hwLocationResult.setCode(0);
            hwLocationResult.setMessage(yn.yn(0));
            hwLocationResult.setLocation(location);
            return hwLocationResult;
        }
    }
}
