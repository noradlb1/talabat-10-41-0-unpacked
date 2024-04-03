package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.coordinateconverter.CoordinateUtil;
import com.huawei.location.lite.common.util.coordinateconverter.LatLon;
import java.util.Map;
import org.json.JSONObject;

public class n0 extends h0<s, HWLocation> {

    /* renamed from: b  reason: collision with root package name */
    private int f49207b;

    public n0(String str, String str2, String str3, String str4, int i11) {
        super(str, str2, str3, str4);
        this.f49207b = i11;
    }

    private void a(HWLocation hWLocation) {
        int i11 = this.f49207b;
        if (1 == i11) {
            Map<String, Object> extraInfo = hWLocation.getExtraInfo();
            if (!extraInfo.containsKey("SourceType") || !a(((Integer) extraInfo.get("SourceType")).intValue())) {
                LatLon convertCoord = CoordinateUtil.convertCoord(hWLocation.getLatitude(), hWLocation.getLongitude(), 1);
                if (convertCoord != null) {
                    hWLocation.setCoordinateType(1);
                    hWLocation.setLatitude(convertCoord.getLatitude());
                    hWLocation.setLongitude(convertCoord.getLongitude());
                    return;
                }
                hWLocation.setCoordinateType(0);
                HMSLocationLog.e("GetLastLocationTaskApiCall", this.f49189a, "ConvertCoord-- result is null,reset the coordinateType to 0");
                return;
            }
            HMSLocationLog.i("GetLastLocationTaskApiCall", this.f49189a, "RTK position, no conversion required");
        } else if (i11 == 0) {
            LogConsole.d("GetLastLocationTaskApiCall", "ConvertCoord-- current coordinateType is 0 --no conversion");
        } else {
            HMSLocationLog.i("GetLastLocationTaskApiCall", this.f49189a, "ConvertCoord-- current coordinateType is unKnown --return 84");
        }
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<HWLocation> taskCompletionSource) {
        HWLocation hWLocation;
        try {
            HMSLocationLog.i("GetLastLocationTaskApiCall", this.f49189a, "doExecute");
            if (responseErrorCode != null) {
                if (responseErrorCode.getErrorCode() == 0) {
                    hWLocation = LocationJsonUtil.parseLocationFromJsonObject(new JSONObject(str));
                    if (hWLocation != null) {
                        a(hWLocation);
                    }
                } else {
                    hWLocation = null;
                }
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, hWLocation);
                return;
            }
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        } catch (ApiException e11) {
            String str2 = this.f49189a;
            HMSLocationLog.e("GetLastLocationTaskApiCall", str2, "get last locationEn doExecute exception:" + e11.getMessage());
            taskCompletionSource.setException(e11);
        } catch (Exception unused) {
            HMSLocationLog.e("GetLastLocationTaskApiCall", this.f49189a, "get last locationEn doExecute exception");
            taskCompletionSource.setException(new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000))));
        }
    }

    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
