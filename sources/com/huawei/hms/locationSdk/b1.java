package com.huawei.hms.locationSdk;

import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.LocationJsonUtil;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor;
import org.json.JSONObject;

public class b1 extends h0<s, Void> {

    /* renamed from: b  reason: collision with root package name */
    private e0 f49158b;

    public b1(String str, String str2, String str3, e0 e0Var, String str4) {
        super(str, str2, str3, str4);
        this.f49158b = e0Var;
    }

    /* renamed from: a */
    public void doExecute(s sVar, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<Void> taskCompletionSource) {
        HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", this.f49189a, "doExecute");
        if (responseErrorCode != null) {
            try {
                if (responseErrorCode.getErrorCode() == 0) {
                    JSONObject jSONObject = new JSONObject(str);
                    e0 e0Var = this.f49158b;
                    if (e0Var != null) {
                        if (e0Var.d() != null) {
                            if (jSONObject.has("locationResult")) {
                                int size = LocationJsonUtil.parseLocationResultFromJsonObject(jSONObject).getLocations().size();
                                int g11 = this.f49158b.g();
                                String str2 = this.f49189a;
                                HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", str2, "modify numUpdates with callback, numUpdates:" + g11 + " , locationSize:" + size);
                                if (g11 > 0) {
                                    if (g11 >= size) {
                                        if (g11 == size) {
                                            HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", this.f49189a, "modify numUpdates last need remove request");
                                            b.b(sVar.getContext(), (w) null).a(this.f49158b.b());
                                        } else {
                                            HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", this.f49189a, "numUpdates greater than locationSize");
                                        }
                                        d0.b().a(this.f49158b, g11 - size);
                                        return;
                                    }
                                }
                                HMSLocationLog.i("RequestLocationUpdatesWithIntentTaskApiCall", this.f49189a, "modify numUpdates exception need remove request");
                                b.b(sVar.getContext(), (w) null).a(this.f49158b.b());
                                return;
                            } else if (!jSONObject.has("locationAvailability")) {
                                d0.b().d(this.f49158b);
                            } else {
                                return;
                            }
                        }
                    }
                    HMSLocationLog.e("RequestLocationUpdatesWithIntentTaskApiCall", this.f49189a, "INTERNAL_ERROR : doExecute requestLocationUpdatesCache is null");
                    return;
                }
                d0.b().c(this.f49158b);
                ServiceErrorCodeAdaptor.getInstance().setTaskByServiceErrorCode(taskCompletionSource, responseErrorCode, null);
            } catch (ApiException e11) {
                e = e11;
                d0.b().c(this.f49158b);
                String str3 = this.f49189a;
                HMSLocationLog.e("RequestLocationUpdatesWithIntentTaskApiCall", str3, "doExecute exception:" + e.getMessage());
                taskCompletionSource.setException(e);
            } catch (Exception unused) {
                d0.b().c(this.f49158b);
                HMSLocationLog.e("RequestLocationUpdatesWithIntentTaskApiCall", this.f49189a, "doExecute exception");
                e = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
                taskCompletionSource.setException(e);
            }
        } else {
            d0.b().c(this.f49158b);
            throw new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
        }
    }

    public int getApiLevel() {
        return 4;
    }

    public int getMinApkVersion() {
        return HuaweiApiAvailability.HMS_VERSION_CODE_KIT_UPDATE;
    }
}
