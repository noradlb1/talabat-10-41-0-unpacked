package com.huawei.hms.locationSdk;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationAvailability;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.log.logwrite.LogWriteApi;
import com.huawei.location.lite.common.util.coordinateconverter.CoordinateUtil;
import com.huawei.location.lite.common.util.coordinateconverter.LatLon;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a1 extends h0<s, Void> {

    /* renamed from: b  reason: collision with root package name */
    protected e0 f49154b;

    /* renamed from: c  reason: collision with root package name */
    protected Handler f49155c;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            a1.this.a(message);
        }
    }

    public a1(String str, String str2, String str3, e0 e0Var, Looper looper, String str4) throws ApiException {
        super(str, str2, str3, str4);
        this.f49154b = e0Var;
        if (looper != null) {
            this.f49155c = new a(looper);
            return;
        }
        throw new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
    }

    private void a(s sVar, JSONObject jSONObject) throws JSONException, ApiException {
        HMSLocationLog.i(a(), this.f49189a, "doExecute onLocationResult");
        LocationResult parseLocationResultFromJsonObject = LocationJsonUtil.parseLocationResultFromJsonObject(jSONObject);
        int g11 = this.f49154b.g();
        int size = parseLocationResultFromJsonObject.getLocations().size();
        String a11 = a();
        String str = this.f49189a;
        HMSLocationLog.i(a11, str, "modify numUpdates with callback, numUpdates:" + g11 + " , locationSize:" + size);
        if (g11 <= 0 || g11 < size) {
            b.b(sVar.getContext(), (w) null).a(this.f49154b.c());
            return;
        }
        if (g11 == size) {
            b.b(sVar.getContext(), (w) null).a(this.f49154b.c());
        } else {
            HMSLocationLog.i(a(), this.f49189a, "numUpdates greater than locationSize");
        }
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = parseLocationResultFromJsonObject;
        this.f49155c.sendMessage(obtain);
        LogWriteApi.printLocationInfo(f0.a(this.f49189a, parseLocationResultFromJsonObject), f0.b());
        int i11 = g11 - size;
        this.f49154b.a(i11);
        d0.b().a(this.f49154b, i11);
    }

    private void a(String str) throws JSONException {
        LocationAvailability parseLocationAvailabilityFromString = LocationJsonUtil.parseLocationAvailabilityFromString(str);
        HMSLocationLog.i(a(), this.f49189a, "doExecute onLocationAvailability");
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = parseLocationAvailabilityFromString;
        this.f49155c.sendMessage(obtain);
    }

    public String a() {
        return "RequestLocationUpdatesTaskApiCall";
    }

    public void a(Message message) {
        String a11 = a();
        String str = this.f49189a;
        HMSLocationLog.i(a11, str, "handleOnResultMessage code:" + message.what);
        try {
            int i11 = message.what;
            if (i11 == 1) {
                Object obj = message.obj;
                if (obj instanceof LocationResult) {
                    b((LocationResult) obj);
                }
            } else if (i11 == 2) {
                Object obj2 = message.obj;
                if (obj2 instanceof LocationAvailability) {
                    LocationAvailability locationAvailability = (LocationAvailability) obj2;
                    String a12 = a();
                    String str2 = this.f49189a;
                    HMSLocationLog.i(a12, str2, "getLocationStatus:" + locationAvailability.getLocationStatus());
                    this.f49154b.c().onLocationAvailability(locationAvailability);
                }
            }
        } catch (Exception unused) {
            HMSLocationLog.e(a(), this.f49189a, "handleOnResultMessage exception");
        }
    }

    public void a(LocationResult locationResult) {
        String a11;
        String str;
        String str2;
        if (locationResult == null) {
            a11 = a();
            str = this.f49189a;
            str2 = "locationResult is null";
        } else {
            LocationRequest d11 = this.f49154b.d();
            List<HWLocation> hWLocationList = locationResult.getHWLocationList();
            if (hWLocationList.isEmpty()) {
                a11 = a();
                str = this.f49189a;
                str2 = "hwLocationList is empty";
            } else if (1 == d11.getCoordinateType()) {
                for (HWLocation next : hWLocationList) {
                    Map<String, Object> extraInfo = next.getExtraInfo();
                    if (!extraInfo.containsKey("SourceType") || !a(((Integer) extraInfo.get("SourceType")).intValue())) {
                        LatLon convertCoord = CoordinateUtil.convertCoord(next.getLatitude(), next.getLongitude(), 1);
                        if (convertCoord != null) {
                            next.setCoordinateType(1);
                            next.setLatitude(convertCoord.getLatitude());
                            next.setLongitude(convertCoord.getLongitude());
                        } else {
                            next.setCoordinateType(0);
                            HMSLocationLog.e(a(), this.f49189a, "ConvertCoord-- result is null,reset the coordinateType to 0");
                        }
                    } else {
                        HMSLocationLog.i(a(), this.f49189a, "RTK position, no conversion required");
                    }
                }
                return;
            } else if (d11.getCoordinateType() == 0) {
                LogConsole.d(a(), "ConvertCoord-- current coordinateType is 0 --no conversion");
                return;
            } else {
                HMSLocationLog.i(a(), this.f49189a, "ConvertCoord-- current coordinateType is unKnown --return 84");
                return;
            }
        }
        HMSLocationLog.e(a11, str, str2);
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        HMSLocationLog.i(a(), this.f49189a, "doExecute");
        if (responseErrorCode != null) {
            try {
                if (responseErrorCode.getStatusCode() != 0) {
                    String a11 = a();
                    String str2 = this.f49189a;
                    HMSLocationLog.e(a11, str2, "response error,statusCode:" + responseErrorCode.getStatusCode());
                    return;
                }
                if (responseErrorCode.getErrorCode() == 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    e0 e0Var = this.f49154b;
                    if (!(e0Var == null || e0Var.d() == null)) {
                        if (this.f49154b.c() != null) {
                            if (jSONObject.has("locationResult")) {
                                a(sVar, jSONObject);
                                return;
                            } else if (jSONObject.has("locationAvailability")) {
                                a(str);
                                return;
                            } else {
                                d0.b().d(this.f49154b);
                                a(true);
                            }
                        }
                    }
                    HMSLocationLog.e(a(), this.f49189a, "INTERNAL_ERROR : doExecute requestLocationUpdatesCache is null");
                    return;
                }
                d0.b().c(this.f49154b);
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
            } catch (ApiException e11) {
                e = e11;
                d0.b().c(this.f49154b);
                a(false);
                String a12 = a();
                String str3 = this.f49189a;
                HMSLocationLog.e(a12, str3, "request location doExecute exception:" + e.getMessage());
                taskCompletionSource.setException(e);
            } catch (Exception unused) {
                d0.b().c(this.f49154b);
                a(false);
                HMSLocationLog.e(a(), this.f49189a, "request location doExecute exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
            }
        } else {
            d0.b().c(this.f49154b);
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
    }

    public void a(boolean z11) {
    }

    public void b(LocationResult locationResult) {
        a(locationResult);
        this.f49154b.c().onLocationResult(locationResult);
    }

    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
