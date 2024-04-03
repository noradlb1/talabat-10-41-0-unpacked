package com.huawei.hms.locationSdk;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.location.GetFromLocationNameRequest;
import com.huawei.hms.location.GetFromLocationRequest;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.location.common.LocationNaming;
import com.huawei.hms.support.api.entity.location.geocoder.GeocoderRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.support.api.location.common.exception.LocationStatusCode;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.List;
import java.util.Locale;

public class n extends HuaweiApi<w> implements l {

    /* renamed from: c  reason: collision with root package name */
    private static final m f49203c = new m();

    /* renamed from: d  reason: collision with root package name */
    private static final Api<w> f49204d = new Api<>("HmsLocation.API");

    /* renamed from: a  reason: collision with root package name */
    private f1 f49205a;

    /* renamed from: b  reason: collision with root package name */
    private Locale f49206b;

    public n(Activity activity, Locale locale, w wVar) {
        super(activity, f49204d, wVar, (AbstractClientBuilder) f49203c);
        this.f49206b = locale;
    }

    public n(Context context, Locale locale, w wVar) {
        super(context, f49204d, wVar, (AbstractClientBuilder) f49203c);
        this.f49206b = locale;
    }

    private boolean b(GetFromLocationNameRequest getFromLocationNameRequest) {
        boolean z11 = getFromLocationNameRequest.getLowerLeftLatitude() < -90.0d || getFromLocationNameRequest.getLowerLeftLatitude() > 90.0d;
        boolean z12 = getFromLocationNameRequest.getLowerLeftLongitude() < -180.0d || getFromLocationNameRequest.getLowerLeftLongitude() > 180.0d;
        boolean z13 = getFromLocationNameRequest.getUpperRightLatitude() < -90.0d || getFromLocationNameRequest.getUpperRightLatitude() > 90.0d;
        if (!z11 && !z12 && !z13) {
            return ((getFromLocationNameRequest.getUpperRightLongitude() > -180.0d ? 1 : (getFromLocationNameRequest.getUpperRightLongitude() == -180.0d ? 0 : -1)) < 0 || (getFromLocationNameRequest.getUpperRightLongitude() > 180.0d ? 1 : (getFromLocationNameRequest.getUpperRightLongitude() == 180.0d ? 0 : -1)) > 0) || (getFromLocationNameRequest.getMaxResults() < 0);
        }
    }

    private boolean b(GetFromLocationRequest getFromLocationRequest) {
        boolean z11 = getFromLocationRequest.getLatitude() < -90.0d || getFromLocationRequest.getLatitude() > 90.0d;
        boolean z12 = getFromLocationRequest.getLongitude() < -180.0d || getFromLocationRequest.getLongitude() > 180.0d;
        boolean z13 = getFromLocationRequest.getMaxResults() < 0;
        LogConsole.i("LocationGeocoderClientImpl", "isValidReversesRequest latitudeState = " + z11 + ",longitudeState = " + z12 + ",maxState = " + z13);
        return z11 || z12 || z13;
    }

    public Task<List<HWLocation>> a(GetFromLocationNameRequest getFromLocationNameRequest) {
        ApiException apiException;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (getFromLocationNameRequest == null || getFromLocationNameRequest.getLocationName() == null || getFromLocationNameRequest.getLocationName().isEmpty()) {
            apiException = new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } else if (b(getFromLocationNameRequest)) {
            apiException = new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        } else {
            LogConsole.i("LocationGeocoderClientImpl", "getFromLocationName checkParams success");
            GeocoderRequest geocoderRequest = new GeocoderRequest(getContext(), getFromLocationNameRequest.getLocationName(), getFromLocationNameRequest.getMaxResults());
            geocoderRequest.setLowerLeftLatitude(getFromLocationNameRequest.getLowerLeftLatitude());
            geocoderRequest.setLowerLeftLongitude(getFromLocationNameRequest.getLowerLeftLongitude());
            geocoderRequest.setUpperRightLatitude(getFromLocationNameRequest.getUpperRightLatitude());
            geocoderRequest.setUpperRightLongitude(getFromLocationNameRequest.getUpperRightLongitude());
            Locale locale = this.f49206b;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            geocoderRequest.setLanguage(locale.getLanguage());
            Locale locale2 = this.f49206b;
            if (locale2 == null) {
                locale2 = Locale.getDefault();
            }
            geocoderRequest.setCountry(locale2.getCountry());
            String tid = geocoderRequest.getTid();
            try {
                HMSLocationLog.i("LocationGeocoderClientImpl", tid, "getFromLocationName begin. Version Code = 60700300");
                String createJsonString = JsonUtil.createJsonString(geocoderRequest);
                return doWrite(new l0(getContext(), LocationNaming.GET_FROM_LOCATION_NAME, createJsonString, geocoderRequest.getTid(), ""));
            } catch (Exception unused) {
                HMSLocationLog.e("LocationGeocoderClientImpl", tid, "getFromLocationName exception");
                apiException = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
        }
        taskCompletionSource.setException(apiException);
        return taskCompletionSource.getTask();
    }

    public Task<List<HWLocation>> a(GetFromLocationRequest getFromLocationRequest) {
        ApiException apiException;
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (getFromLocationRequest == null) {
            apiException = new ApiException(new Status(LocationStatusCode.PARAM_ERROR_EMPTY, LocationStatusCode.getStatusCodeString(LocationStatusCode.PARAM_ERROR_EMPTY)));
        } else if (b(getFromLocationRequest)) {
            apiException = new ApiException(new Status(10802, LocationStatusCode.getStatusCodeString(10802)));
        } else {
            LogConsole.i("LocationGeocoderClientImpl", "getFromLocation checkParams success");
            GeocoderRequest geocoderRequest = new GeocoderRequest(getContext(), getFromLocationRequest.getLatitude(), getFromLocationRequest.getLongitude(), getFromLocationRequest.getMaxResults());
            Locale locale = this.f49206b;
            if (locale == null) {
                locale = Locale.getDefault();
            }
            geocoderRequest.setLanguage(locale.getLanguage());
            Locale locale2 = this.f49206b;
            if (locale2 == null) {
                locale2 = Locale.getDefault();
            }
            geocoderRequest.setCountry(locale2.getCountry());
            String tid = geocoderRequest.getTid();
            try {
                HMSLocationLog.i("LocationGeocoderClientImpl", tid, "getFromLocation begin. Version Code = 60700300");
                String createJsonString = JsonUtil.createJsonString(geocoderRequest);
                return doWrite(new m0(getContext(), LocationNaming.GET_FROM_LOCATION, createJsonString, geocoderRequest.getTid(), ""));
            } catch (Exception unused) {
                HMSLocationLog.e("LocationGeocoderClientImpl", tid, "getFromLocation exception");
                apiException = new ApiException(new Status(10000, LocationStatusCode.getStatusCodeString(10000)));
            }
        }
        taskCompletionSource.setException(apiException);
        return taskCompletionSource.getTask();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        r0 = r2.f49205a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <TResult, TClient extends com.huawei.hms.common.internal.AnyClient> com.huawei.hmf.tasks.Task<TResult> doWrite(com.huawei.hms.common.internal.TaskApiCall<TClient, TResult> r3) {
        /*
            r2 = this;
            com.huawei.hms.locationSdk.f1 r0 = r2.f49205a
            if (r0 != 0) goto L_0x0019
            android.content.Context r0 = r2.getContext()
            com.huawei.hms.locationSdk.j1 r1 = new com.huawei.hms.locationSdk.j1
            r1.<init>()
            java.lang.Object r0 = com.huawei.hms.locationSdk.i1.a(r0, r1)
            boolean r1 = r0 instanceof com.huawei.hms.locationSdk.f1
            if (r1 == 0) goto L_0x0019
            com.huawei.hms.locationSdk.f1 r0 = (com.huawei.hms.locationSdk.f1) r0
            r2.f49205a = r0
        L_0x0019:
            android.content.Context r0 = r2.getContext()
            boolean r0 = com.huawei.hms.locationSdk.j1.a(r0)
            if (r0 != 0) goto L_0x002f
            com.huawei.hms.locationSdk.f1 r0 = r2.f49205a
            if (r0 != 0) goto L_0x0028
            goto L_0x002f
        L_0x0028:
            com.huawei.hms.locationSdk.m r1 = f49203c
            com.huawei.hmf.tasks.Task r3 = r0.a(r2, r3, r1)
            return r3
        L_0x002f:
            com.huawei.hmf.tasks.Task r3 = super.doWrite(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.n.doWrite(com.huawei.hms.common.internal.TaskApiCall):com.huawei.hmf.tasks.Task");
    }

    public int getApiLevel() {
        return 5;
    }

    public int getKitSdkVersion() {
        return 60700300;
    }
}
