package com.huawei.hms.locationSdk;

import com.huawei.hms.location.LocationSettingsResponse;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class i0 extends h0<s, LocationSettingsResponse> {
    public i0(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.huawei.hms.support.api.client.Status} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.huawei.hms.location.LocationSettingsStates} */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doExecute(com.huawei.hms.locationSdk.s r9, com.huawei.hms.common.internal.ResponseErrorCode r10, java.lang.String r11, com.huawei.hmf.tasks.TaskCompletionSource<com.huawei.hms.location.LocationSettingsResponse> r12) {
        /*
            r8 = this;
            java.lang.String r9 = "statusMessage"
            java.lang.String r0 = "statusCode"
            java.lang.String r1 = "locationSettingsStates"
            java.lang.String r2 = "statusCheck"
            java.lang.String r3 = "CheckLocationSettingsTaskApiCall"
            r4 = 10000(0x2710, float:1.4013E-41)
            java.lang.String r5 = r8.f49189a     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r6 = "doExecute"
            com.huawei.hms.support.api.location.common.HMSLocationLog.i(r3, r5, r6)     // Catch:{ Exception -> 0x00c4 }
            if (r10 == 0) goto L_0x00b5
            int r5 = r10.getErrorCode()     // Catch:{ Exception -> 0x00c4 }
            r6 = 0
            if (r5 != 0) goto L_0x009a
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            r5.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00c4 }
            boolean r11 = r5.has(r2)     // Catch:{ Exception -> 0x00c4 }
            if (r11 == 0) goto L_0x0059
            org.json.JSONObject r11 = r5.getJSONObject(r2)     // Catch:{ Exception -> 0x00c4 }
            android.os.Parcelable r2 = r10.getParcelable()     // Catch:{ Exception -> 0x00c4 }
            if (r2 == 0) goto L_0x0038
            boolean r7 = r2 instanceof android.app.PendingIntent     // Catch:{ Exception -> 0x00c4 }
            if (r7 == 0) goto L_0x0038
            android.app.PendingIntent r2 = (android.app.PendingIntent) r2     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0039
        L_0x0038:
            r2 = r6
        L_0x0039:
            boolean r7 = r11.has(r0)     // Catch:{ Exception -> 0x00c4 }
            if (r7 == 0) goto L_0x0044
            int r0 = r11.getInt(r0)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0046
        L_0x0044:
            r0 = -100
        L_0x0046:
            boolean r7 = r11.has(r9)     // Catch:{ Exception -> 0x00c4 }
            if (r7 == 0) goto L_0x0051
            java.lang.String r9 = r11.getString(r9)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0053
        L_0x0051:
            java.lang.String r9 = ""
        L_0x0053:
            com.huawei.hms.support.api.client.Status r11 = new com.huawei.hms.support.api.client.Status     // Catch:{ Exception -> 0x00c4 }
            r11.<init>((int) r0, (java.lang.String) r9, (android.app.PendingIntent) r2)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x005a
        L_0x0059:
            r11 = r6
        L_0x005a:
            boolean r9 = r5.has(r1)     // Catch:{ Exception -> 0x00c4 }
            if (r9 == 0) goto L_0x0087
            com.huawei.hms.location.LocationSettingsStates r6 = new com.huawei.hms.location.LocationSettingsStates     // Catch:{ Exception -> 0x00c4 }
            r6.<init>()     // Catch:{ Exception -> 0x00c4 }
            org.json.JSONObject r9 = r5.getJSONObject(r1)     // Catch:{ Exception -> 0x00c4 }
            boolean r0 = r9 instanceof org.json.JSONObject     // Catch:{ Exception -> 0x00c4 }
            if (r0 != 0) goto L_0x0072
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00c4 }
            goto L_0x0076
        L_0x0072:
            java.lang.String r9 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r9)     // Catch:{ Exception -> 0x00c4 }
        L_0x0076:
            com.huawei.hms.utils.JsonUtil.jsonToEntity(r9, r6)     // Catch:{ Exception -> 0x00c4 }
            boolean r9 = r6.isGpsPresent()     // Catch:{ Exception -> 0x00c4 }
            r6.setGnssPresent(r9)     // Catch:{ Exception -> 0x00c4 }
            boolean r9 = r6.isGpsUsable()     // Catch:{ Exception -> 0x00c4 }
            r6.setGnssUsable(r9)     // Catch:{ Exception -> 0x00c4 }
        L_0x0087:
            com.huawei.hms.location.LocationSettingsResult r9 = new com.huawei.hms.location.LocationSettingsResult     // Catch:{ Exception -> 0x00c4 }
            r9.<init>()     // Catch:{ Exception -> 0x00c4 }
            r9.setLocationSettingsStates(r6)     // Catch:{ Exception -> 0x00c4 }
            r9.setStatus(r11)     // Catch:{ Exception -> 0x00c4 }
            com.huawei.hms.location.LocationSettingsResponse r6 = new com.huawei.hms.location.LocationSettingsResponse     // Catch:{ Exception -> 0x00c4 }
            r6.<init>(r9)     // Catch:{ Exception -> 0x00c4 }
            r9 = r6
            r6 = r11
            goto L_0x009b
        L_0x009a:
            r9 = r6
        L_0x009b:
            if (r6 == 0) goto L_0x00ad
            int r11 = r6.getStatusCode()     // Catch:{ Exception -> 0x00c4 }
            r0 = 6
            if (r11 != r0) goto L_0x00ad
            com.huawei.hms.common.ResolvableApiException r9 = new com.huawei.hms.common.ResolvableApiException     // Catch:{ Exception -> 0x00c4 }
            r9.<init>((com.huawei.hms.support.api.client.Status) r6)     // Catch:{ Exception -> 0x00c4 }
            r12.setException(r9)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00dc
        L_0x00ad:
            com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor r11 = com.huawei.hms.support.api.location.common.exception.ServiceErrorCodeAdaptor.getInstance()     // Catch:{ Exception -> 0x00c4 }
            r11.setTaskByServiceErrorCode(r12, r10, r9)     // Catch:{ Exception -> 0x00c4 }
            goto L_0x00dc
        L_0x00b5:
            com.huawei.hms.common.ApiException r9 = new com.huawei.hms.common.ApiException     // Catch:{ Exception -> 0x00c4 }
            com.huawei.hms.support.api.client.Status r10 = new com.huawei.hms.support.api.client.Status     // Catch:{ Exception -> 0x00c4 }
            java.lang.String r11 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r4)     // Catch:{ Exception -> 0x00c4 }
            r10.<init>(r4, r11)     // Catch:{ Exception -> 0x00c4 }
            r9.<init>(r10)     // Catch:{ Exception -> 0x00c4 }
            throw r9     // Catch:{ Exception -> 0x00c4 }
        L_0x00c4:
            java.lang.String r9 = r8.f49189a
            java.lang.String r10 = "doExecute exception"
            com.huawei.hms.support.api.location.common.HMSLocationLog.e(r3, r9, r10)
            com.huawei.hms.common.ApiException r9 = new com.huawei.hms.common.ApiException
            com.huawei.hms.support.api.client.Status r10 = new com.huawei.hms.support.api.client.Status
            java.lang.String r11 = com.huawei.hms.support.api.location.common.exception.LocationStatusCode.getStatusCodeString(r4)
            r10.<init>(r4, r11)
            r9.<init>(r10)
            r12.setException(r9)
        L_0x00dc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.locationSdk.i0.doExecute(com.huawei.hms.locationSdk.s, com.huawei.hms.common.internal.ResponseErrorCode, java.lang.String, com.huawei.hmf.tasks.TaskCompletionSource):void");
    }
}
