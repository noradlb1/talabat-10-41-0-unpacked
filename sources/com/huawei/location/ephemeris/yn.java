package com.huawei.location.ephemeris;

import com.google.gson.JsonSyntaxException;
import com.huawei.location.ephemeris.net.EphemerisResponse;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.utils.FB;
import com.huawei.riemann.location.bean.eph.BdsEphemeris;
import com.huawei.riemann.location.bean.eph.BdsIon;
import com.huawei.riemann.location.bean.eph.BdsNav;
import com.huawei.riemann.location.bean.eph.BdsTim;
import com.huawei.riemann.location.bean.eph.GalileoEphemeris;
import com.huawei.riemann.location.bean.eph.GalileoNav;
import com.huawei.riemann.location.bean.eph.GalileoTim;
import com.huawei.riemann.location.bean.eph.GlonassEphemeris;
import com.huawei.riemann.location.bean.eph.GlonassNav;
import com.huawei.riemann.location.bean.eph.GlonassTim;
import com.huawei.riemann.location.bean.eph.GpsEphemeris;
import com.huawei.riemann.location.bean.eph.GpsIon;
import com.huawei.riemann.location.bean.eph.GpsNav;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class yn {
    private static long FB = 0;
    private static boolean Vw = false;

    /* renamed from: yn  reason: collision with root package name */
    private static long f50092yn;
    private FB LW = new FB();

    private JSONArray E5(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGalNav()).getJSONArray("ephList");
        } catch (JSONException e11) {
            LogConsole.e("EphModule", "getGalNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    private GlonassEphemeris FB(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb2 = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGloTim());
        fb2.getClass();
        GlonassTim build = GlonassTim.Builder.aGlonassTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((jSONObject.optDouble("a2", 0.0d) / 1.15292150460684698E18d) / 256.0d).withGnssToId(jSONObject.optInt("gnssToId", 0)).withWeekNumber(jSONObject.optInt("weekNumber", 0)).withWeekSecond(jSONObject.optInt("weekSecond", 0) * 16).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGloNav());
        GlonassNav[] FB2 = this.LW.FB(jSONObject2.getJSONArray("gloNavItemList"));
        LogConsole.i("EphModule", "GlonassNav size = " + FB2.length);
        int optInt = jSONObject2.optInt("satNumber", 0);
        return GlonassEphemeris.Builder.aGlonassEphemeris().withSatNumber(optInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGlonassNavs(FB2).withGlonassTim(build).build();
    }

    private GpsEphemeris LW(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb2 = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGpsIon());
        fb2.getClass();
        GpsIon build = GpsIon.Builder.aGpsIon().withA0(jSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(jSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(jSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(jSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(jSONObject.optInt("b0", 0) * 2048).withB1(jSONObject.optInt("b1", 0) * 16384).withB2(jSONObject.optInt("b2", 0) * 65536).withB3(jSONObject.optInt("b3", 0) * 65536).withValid(jSONObject.optBoolean("valid")).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGpsNav());
        GpsNav[] LW2 = this.LW.LW(jSONObject2.getJSONArray("ephList"));
        LogConsole.i("EphModule", "GpsNav size = " + LW2.length);
        return GpsEphemeris.Builder.aGpsEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withGpsNavs(LW2).withGpsIon(build).build();
    }

    private GalileoEphemeris Vw(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb2 = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGalTim());
        fb2.getClass();
        GalileoTim build = GalileoTim.Builder.aGalileoTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withT0(jSONObject.optLong("t0", 0)).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGalNav());
        GalileoNav[] Vw2 = this.LW.Vw(jSONObject2.getJSONArray("ephList"));
        LogConsole.i("EphModule", "galNavArray size = " + Vw2.length);
        int optInt = jSONObject2.optInt("satNumber", 0);
        return GalileoEphemeris.Builder.aGalileoEphemeris().withSatNumber(optInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGalileoNavs(Vw2).withGalileoTim(build).build();
    }

    private JSONArray d2(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGloNav()).getJSONArray("gloNavItemList");
        } catch (JSONException e11) {
            LogConsole.e("EphModule", "getGloNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    private JSONArray dC(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getBdsNav()).getJSONArray("ephList");
        } catch (JSONException e11) {
            LogConsole.e("EphModule", "getBdsNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    private JSONArray zp(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGpsNav()).getJSONArray("ephList");
        } catch (JSONException e11) {
            LogConsole.e("EphModule", "getGpsNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    public long FB() {
        if (f50092yn <= 0) {
            f50092yn = new PreferencesHelper("ephemeris_expire_time").getLong("ephemeris_expire_time");
        }
        LogConsole.i("EphModule", "getExpireTime = " + f50092yn);
        return f50092yn;
    }

    /* JADX WARNING: type inference failed for: r0v77, types: [com.huawei.location.lite.common.http.response.BaseResponse] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0593  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x0633  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0642  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0170  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean yn() {
        /*
            r33 = this;
            r1 = r33
            java.lang.String r2 = ", msg is "
            java.lang.String r3 = "ephList"
            com.huawei.location.ephemeris.Vw r0 = new com.huawei.location.ephemeris.Vw
            long r4 = java.lang.System.currentTimeMillis()
            r0.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "gpsTime = "
            r4.append(r5)
            long r5 = r0.Vw()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.String r5 = "EphModule"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r4)
            long r6 = r0.Vw()
            long r8 = r33.FB()
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r4 = 1
            if (r0 > 0) goto L_0x003c
            java.lang.String r0 = "local ephemeris is valid"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            return r4
        L_0x003c:
            boolean r0 = Vw
            r8 = 0
            if (r0 == 0) goto L_0x0042
            return r8
        L_0x0042:
            long r9 = java.lang.System.currentTimeMillis()
            long r11 = FB
            long r9 = r9 - r11
            r11 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x0058
            java.lang.String r0 = "refreshEphemeris not ready"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            r4 = r8
            goto L_0x0644
        L_0x0058:
            Vw = r4
            com.huawei.location.ephemeris.net.yn r0 = new com.huawei.location.ephemeris.net.yn
            java.lang.String r9 = "AGNSS"
            r0.<init>(r9)
            java.lang.String r9 = "get online eph data"
            java.lang.String r10 = "OnlineEphService"
            com.huawei.location.lite.common.log.LogConsole.i(r10, r9)
            com.huawei.location.ephemeris.net.EphemerisResponse r9 = new com.huawei.location.ephemeris.net.EphemerisResponse
            r9.<init>()
            com.google.gson.Gson r11 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            boolean r12 = r11 instanceof com.google.gson.Gson
            if (r12 != 0) goto L_0x007a
            java.lang.String r0 = r11.toJson((java.lang.Object) r0)
            goto L_0x007e
        L_0x007a:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r11, (java.lang.Object) r0)
        L_0x007e:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0144 }
            r11.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0144 }
            com.huawei.location.lite.common.http.request.RequestJsonBody$Builder r0 = new com.huawei.location.lite.common.http.request.RequestJsonBody$Builder     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            r0.<init>()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.RequestJsonBody r0 = r0.build(r11)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.lang.String r11 = "com.huawei.hms.location"
            java.lang.String r11 = com.huawei.location.lite.common.grs.LocationNlpGrsHelper.getGrsHostAddress(r11)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            if (r12 == 0) goto L_0x009f
            java.lang.String r0 = "grsHostAddress is null"
            com.huawei.location.lite.common.log.LogConsole.e(r10, r0)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            goto L_0x0147
        L_0x009f:
            android.content.Context r12 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.lang.String r12 = r12.getPackageName()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.HeadBuilder r13 = new com.huawei.location.lite.common.http.request.HeadBuilder     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.util.UUID r14 = java.util.UUID.randomUUID()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.lang.String r14 = r14.toString()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            r13.<init>(r14)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.HeadBuilder r12 = r13.setPackageName(r12)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r13 = new com.huawei.location.lite.common.http.request.BaseRequest$Builder     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.lang.String r14 = "/networklocation/v1/gnssData"
            r13.<init>(r14)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r11 = r13.setBaseUrl(r11)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r11 = r11.setHeads(r12)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r0 = r11.setBody((com.huawei.location.lite.common.http.request.RequestJsonBody) r0)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.HttpClientEx r11 = new com.huawei.location.lite.common.http.HttpClientEx     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            r11.<init>()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.request.BaseRequest r0 = r0.build()     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            com.huawei.location.lite.common.http.adapter.ISubmitAdapter r0 = r11.newSubmit(r0)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.lang.Class<com.huawei.location.ephemeris.net.EphemerisResponse> r11 = com.huawei.location.ephemeris.net.EphemerisResponse.class
            com.huawei.location.lite.common.http.response.BaseResponse r0 = r0.execute(r11)     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            r11 = r0
            com.huawei.location.ephemeris.net.EphemerisResponse r11 = (com.huawei.location.ephemeris.net.EphemerisResponse) r11     // Catch:{ OnFailureException -> 0x0120, OnErrorException -> 0x0106, Exception -> 0x0103 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            r0.<init>()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            java.lang.String r9 = "doHttp, response code is "
            r0.append(r9)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            java.lang.String r9 = r11.getApiCode()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            r0.append(r9)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            java.lang.String r0 = r0.toString()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            com.huawei.location.lite.common.log.LogConsole.i(r10, r0)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00fd, Exception -> 0x00fb }
            r9 = r11
            goto L_0x0147
        L_0x00fb:
            r9 = r11
            goto L_0x0103
        L_0x00fd:
            r0 = move-exception
            r9 = r11
            goto L_0x0107
        L_0x0100:
            r0 = move-exception
            r9 = r11
            goto L_0x0121
        L_0x0103:
            java.lang.String r0 = "unknown exception"
            goto L_0x0140
        L_0x0106:
            r0 = move-exception
        L_0x0107:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "doHttp, OnErrorException: code is "
            r11.append(r12)
            java.lang.String r12 = r0.getApiCode()
            r11.append(r12)
            r11.append(r2)
            java.lang.String r0 = r0.getApiMsg()
            goto L_0x0139
        L_0x0120:
            r0 = move-exception
        L_0x0121:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "doHttp, OnFailureException: code is "
            r11.append(r12)
            com.huawei.location.lite.common.http.exception.ErrorCode r12 = r0.getErrorCode()
            r11.append(r12)
            r11.append(r2)
            java.lang.String r0 = r0.getMessage()
        L_0x0139:
            r11.append(r0)
            java.lang.String r0 = r11.toString()
        L_0x0140:
            com.huawei.location.lite.common.log.LogConsole.e(r10, r0)
            goto L_0x0147
        L_0x0144:
            java.lang.String r0 = "doHttp, transfer to JSONException failed"
            goto L_0x0140
        L_0x0147:
            boolean r0 = r9.isSuccess()
            if (r0 != 0) goto L_0x015c
            java.lang.String r0 = "get online ephemeris failed"
        L_0x014f:
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            long r10 = java.lang.System.currentTimeMillis()
            FB = r10
            Vw = r8
            r0 = r8
            goto L_0x016e
        L_0x015c:
            java.lang.String r0 = r9.getBdsNav()
            if (r0 == 0) goto L_0x016b
            java.lang.String r0 = r9.getGpsNav()
            if (r0 != 0) goto L_0x0169
            goto L_0x016b
        L_0x0169:
            r0 = r4
            goto L_0x016e
        L_0x016b:
            java.lang.String r0 = "get online ephemeris contains illegal arguments"
            goto L_0x014f
        L_0x016e:
            if (r0 == 0) goto L_0x0642
            org.json.JSONArray r0 = r1.zp(r9)
            org.json.JSONArray r2 = r1.dC(r9)
            org.json.JSONArray r10 = r1.E5(r9)
            org.json.JSONArray r11 = r1.d2(r9)
            int r12 = r0.length()
            r13 = 7200(0x1c20, float:1.009E-41)
            r16 = 604800(0x93a80, float:8.47505E-40)
            if (r12 == 0) goto L_0x0434
            int r12 = r2.length()
            if (r12 == 0) goto L_0x0434
            int r12 = r10.length()
            if (r12 == 0) goto L_0x0434
            int r12 = r11.length()
            if (r12 != 0) goto L_0x019f
            goto L_0x0434
        L_0x019f:
            com.huawei.location.ephemeris.Vw r12 = new com.huawei.location.ephemeris.Vw
            r17 = r9
            long r8 = java.lang.System.currentTimeMillis()
            r12.<init>(r8)
            com.huawei.location.utils.FB r8 = r1.LW
            com.huawei.riemann.location.bean.eph.GpsNav[] r8 = r8.LW(r0)
            int r9 = r0.length()
            int r9 = r9 - r4
        L_0x01b5:
            if (r9 < 0) goto L_0x0223
            r18 = r8[r9]
            int r19 = r12.FB()
            int r20 = r18.getWeekNumber()
            int r14 = r19 - r20
            r15 = 512(0x200, float:7.175E-43)
            if (r14 <= r15) goto L_0x01cf
            java.lang.String r15 = "weekNumberDiff > 512"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r15)
            int r14 = r14 + -1024
            goto L_0x01db
        L_0x01cf:
            r15 = -512(0xfffffffffffffe00, float:NaN)
            if (r14 >= r15) goto L_0x01d6
            int r14 = r14 + 1024
            goto L_0x01db
        L_0x01d6:
            java.lang.String r15 = "between -512 and 512"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r15)
        L_0x01db:
            int r14 = r14 * r16
            int r15 = r12.dC()
            int r14 = r14 + r15
            int r15 = r18.getToe()
            int r14 = r14 - r15
            r15 = 302400(0x49d40, float:4.23753E-40)
            if (r14 <= r15) goto L_0x01ef
            int r14 = r14 - r16
            goto L_0x01fc
        L_0x01ef:
            r15 = -302400(0xfffffffffffb62c0, float:NaN)
            if (r14 >= r15) goto L_0x01f7
            int r14 = r14 + r16
            goto L_0x01fc
        L_0x01f7:
            java.lang.String r15 = "between half day"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r15)
        L_0x01fc:
            int r15 = java.lang.Math.abs(r14)
            if (r15 > r13) goto L_0x0204
            r13 = r4
            goto L_0x0219
        L_0x0204:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r13 = "gpsTime diff ="
            r15.append(r13)
            r15.append(r14)
            java.lang.String r13 = r15.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r5, r13)
            r13 = 0
        L_0x0219:
            if (r13 != 0) goto L_0x021e
            r0.remove(r9)
        L_0x021e:
            int r9 = r9 + -1
            r13 = 7200(0x1c20, float:1.009E-41)
            goto L_0x01b5
        L_0x0223:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r13 = "gpsNavs size = "
            r9.append(r13)
            int r8 = r8.length
            r9.append(r8)
            java.lang.String r8 = ", gpsNavArray size = "
            r9.append(r8)
            int r8 = r0.length()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r5, r8)
            com.huawei.location.utils.FB r8 = r1.LW
            com.huawei.riemann.location.bean.eph.BdsNav[] r8 = r8.yn(r2)
            int r9 = r2.length()
            int r9 = r9 - r4
        L_0x024f:
            java.lang.String r13 = "between one week"
            r22 = 302400(0x49d40, double:1.494055E-318)
            r24 = 604800(0x93a80, double:2.98811E-318)
            if (r9 < 0) goto L_0x02a4
            r20 = r8[r9]
            int r26 = r12.dC()
            int r20 = r20.getToe()
            int r4 = r26 - r20
            long r14 = (long) r4
            int r4 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r4 <= 0) goto L_0x026d
            long r14 = r14 - r24
            goto L_0x027a
        L_0x026d:
            r22 = -302400(0xfffffffffffb62c0, double:NaN)
            int r4 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r4 >= 0) goto L_0x0277
            long r14 = r14 + r24
            goto L_0x027a
        L_0x0277:
            com.huawei.location.lite.common.log.LogConsole.i(r5, r13)
        L_0x027a:
            long r22 = java.lang.Math.abs(r14)
            r24 = 4200(0x1068, double:2.075E-320)
            int r4 = (r22 > r24 ? 1 : (r22 == r24 ? 0 : -1))
            if (r4 > 0) goto L_0x0286
            r4 = 1
            goto L_0x029b
        L_0x0286:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r13 = "BdsTime diff ="
            r4.append(r13)
            r4.append(r14)
            java.lang.String r4 = r4.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r5, r4)
            r4 = 0
        L_0x029b:
            if (r4 != 0) goto L_0x02a0
            r2.remove(r9)
        L_0x02a0:
            int r9 = r9 + -1
            r4 = 1
            goto L_0x024f
        L_0x02a4:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r9 = "bdsNavs size = "
            r4.append(r9)
            int r8 = r8.length
            r4.append(r8)
            java.lang.String r8 = ", bdsNavArrays size = "
            r4.append(r8)
            int r8 = r2.length()
            r4.append(r8)
            java.lang.String r4 = r4.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r5, r4)
            com.huawei.location.utils.FB r4 = r1.LW
            com.huawei.riemann.location.bean.eph.GalileoNav[] r4 = r4.Vw(r10)
            int r8 = r10.length()
            r9 = 1
            int r8 = r8 - r9
        L_0x02d1:
            if (r8 < 0) goto L_0x0325
            r9 = r4[r8]
            int r14 = r12.dC()
            int r9 = r9.getToe()
            int r14 = r14 - r9
            long r14 = (long) r14
            int r9 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r9 <= 0) goto L_0x02e9
            long r14 = r14 - r24
            r27 = -302400(0xfffffffffffb62c0, double:NaN)
            goto L_0x02f6
        L_0x02e9:
            r27 = -302400(0xfffffffffffb62c0, double:NaN)
            int r9 = (r14 > r27 ? 1 : (r14 == r27 ? 0 : -1))
            if (r9 >= 0) goto L_0x02f3
            long r14 = r14 + r24
            goto L_0x02f6
        L_0x02f3:
            com.huawei.location.lite.common.log.LogConsole.i(r5, r13)
        L_0x02f6:
            long r29 = java.lang.Math.abs(r14)
            r31 = 1800(0x708, double:8.893E-321)
            int r9 = (r29 > r31 ? 1 : (r29 == r31 ? 0 : -1))
            if (r9 > 0) goto L_0x0304
            r20 = r13
            r9 = 1
            goto L_0x031b
        L_0x0304:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r20 = r13
            java.lang.String r13 = "GalTime diff ="
            r9.append(r13)
            r9.append(r14)
            java.lang.String r9 = r9.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r5, r9)
            r9 = 0
        L_0x031b:
            if (r9 != 0) goto L_0x0320
            r10.remove(r8)
        L_0x0320:
            int r8 = r8 + -1
            r13 = r20
            goto L_0x02d1
        L_0x0325:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "galNavs size = "
            r8.append(r9)
            int r4 = r4.length
            r8.append(r4)
            java.lang.String r4 = ", galJSONArrays size = "
            r8.append(r4)
            int r4 = r10.length()
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r5, r4)
            com.huawei.location.utils.FB r4 = r1.LW
            com.huawei.riemann.location.bean.eph.GlonassNav[] r4 = r4.FB(r11)
            int r8 = r11.length()
            r9 = 1
            int r8 = r8 - r9
        L_0x0352:
            if (r8 < 0) goto L_0x039e
            r13 = r4[r8]
            int r13 = r13.getIod()
            int r13 = r13 * 15
            int r13 = r13 * 60
            int r13 = r13 + -10800
            r14 = 86400(0x15180, float:1.21072E-40)
            int r13 = r13 % r14
            int r15 = r12.dC()
            int r15 = r15 % r14
            int r13 = r13 - r15
            r15 = 43200(0xa8c0, float:6.0536E-41)
            if (r13 <= r15) goto L_0x0371
            int r13 = r13 - r14
            goto L_0x0377
        L_0x0371:
            r15 = -43200(0xffffffffffff5740, float:NaN)
            if (r13 >= r15) goto L_0x0377
            int r13 = r13 + r14
        L_0x0377:
            int r14 = java.lang.Math.abs(r13)
            r15 = 1800(0x708, float:2.522E-42)
            if (r14 > r15) goto L_0x0381
            r13 = r9
            goto L_0x0396
        L_0x0381:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "GloTime diff ="
            r14.append(r15)
            r14.append(r13)
            java.lang.String r13 = r14.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r5, r13)
            r13 = 0
        L_0x0396:
            if (r13 != 0) goto L_0x039b
            r11.remove(r8)
        L_0x039b:
            int r8 = r8 + -1
            goto L_0x0352
        L_0x039e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r12 = "gloNavs size = "
            r8.append(r12)
            int r4 = r4.length
            r8.append(r4)
            java.lang.String r4 = ", gloJSONArrays size = "
            r8.append(r4)
            int r4 = r11.length()
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r5, r4)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x0431
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0431
            int r4 = r10.length()
            if (r4 == 0) goto L_0x0431
            int r4 = r11.length()
            if (r4 != 0) goto L_0x03d8
            goto L_0x0431
        L_0x03d8:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0429 }
            java.lang.String r8 = r17.getGpsNav()     // Catch:{ JSONException -> 0x0429 }
            r4.<init>((java.lang.String) r8)     // Catch:{ JSONException -> 0x0429 }
            r4.put((java.lang.String) r3, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0429 }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r4)     // Catch:{ JSONException -> 0x0429 }
            r4 = r17
            r4.setGpsNav(r0)     // Catch:{ JSONException -> 0x042b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x042b }
            java.lang.String r8 = r4.getBdsNav()     // Catch:{ JSONException -> 0x042b }
            r0.<init>((java.lang.String) r8)     // Catch:{ JSONException -> 0x042b }
            r0.put((java.lang.String) r3, (java.lang.Object) r2)     // Catch:{ JSONException -> 0x042b }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x042b }
            r4.setBdsNav(r0)     // Catch:{ JSONException -> 0x042b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x042b }
            java.lang.String r2 = r4.getGalNav()     // Catch:{ JSONException -> 0x042b }
            r0.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x042b }
            r0.put((java.lang.String) r3, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x042b }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x042b }
            r4.setGalNav(r0)     // Catch:{ JSONException -> 0x042b }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x042b }
            java.lang.String r2 = r4.getGloNav()     // Catch:{ JSONException -> 0x042b }
            r0.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x042b }
            java.lang.String r2 = "gloNavItemList"
            r0.put((java.lang.String) r2, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x042b }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x042b }
            r4.setGloNav(r0)     // Catch:{ JSONException -> 0x042b }
            goto L_0x043b
        L_0x0429:
            r4 = r17
        L_0x042b:
            java.lang.String r0 = "filteringResponse JSONException"
            com.huawei.location.lite.common.log.LogConsole.e(r5, r0)
            goto L_0x043b
        L_0x0431:
            java.lang.String r0 = "ephemeris is not valid"
            goto L_0x0437
        L_0x0434:
            r9 = r4
            java.lang.String r0 = "parse response failed"
        L_0x0437:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r0)
            r4 = 0
        L_0x043b:
            r2 = 0
            if (r4 != 0) goto L_0x0441
            goto L_0x0589
        L_0x0441:
            org.json.JSONArray r0 = r1.zp(r4)
            com.huawei.location.utils.FB r8 = r1.LW
            com.huawei.riemann.location.bean.eph.GpsNav[] r0 = r8.LW(r0)
            org.json.JSONArray r8 = r1.dC(r4)
            com.huawei.location.utils.FB r10 = r1.LW
            com.huawei.riemann.location.bean.eph.BdsNav[] r8 = r10.yn(r8)
            org.json.JSONArray r10 = r1.E5(r4)
            com.huawei.location.utils.FB r11 = r1.LW
            com.huawei.riemann.location.bean.eph.GalileoNav[] r10 = r11.Vw(r10)
            org.json.JSONArray r11 = r1.d2(r4)
            com.huawei.location.utils.FB r12 = r1.LW
            com.huawei.riemann.location.bean.eph.GlonassNav[] r11 = r12.FB(r11)
            int r12 = r0.length
            if (r12 != 0) goto L_0x0473
            java.lang.String r0 = "new eph data invalid no gps"
        L_0x046e:
            com.huawei.location.lite.common.log.LogConsole.e(r5, r0)
            goto L_0x0589
        L_0x0473:
            int r12 = r8.length
            if (r12 != 0) goto L_0x0479
            java.lang.String r0 = "new eph data invalid no bds"
            goto L_0x046e
        L_0x0479:
            int r12 = r10.length
            if (r12 != 0) goto L_0x047f
            java.lang.String r0 = "new eph data invalid no gal"
            goto L_0x046e
        L_0x047f:
            int r12 = r11.length
            if (r12 != 0) goto L_0x0485
            java.lang.String r0 = "new eph data invalid no glo"
            goto L_0x046e
        L_0x0485:
            r2 = 0
            r3 = r0[r2]
            int r3 = r3.getToe()
            r12 = r9
        L_0x048d:
            int r13 = r0.length
            if (r12 >= r13) goto L_0x049d
            r13 = r0[r12]
            int r13 = r13.getToe()
            int r3 = java.lang.Math.min(r13, r3)
            int r12 = r12 + 1
            goto L_0x048d
        L_0x049d:
            r0 = r8[r2]
            int r0 = r0.getToe()
            r12 = r9
        L_0x04a4:
            int r13 = r8.length
            if (r12 >= r13) goto L_0x04b4
            r13 = r8[r12]
            int r13 = r13.getToe()
            int r0 = java.lang.Math.min(r0, r13)
            int r12 = r12 + 1
            goto L_0x04a4
        L_0x04b4:
            r8 = r10[r2]
            int r8 = r8.getToe()
            r12 = r9
        L_0x04bb:
            int r13 = r10.length
            if (r12 >= r13) goto L_0x04cb
            r13 = r10[r12]
            int r13 = r13.getToe()
            int r8 = java.lang.Math.min(r8, r13)
            int r12 = r12 + 1
            goto L_0x04bb
        L_0x04cb:
            r10 = r11[r2]
            int r2 = r10.getIod()
            int r10 = r11.length
            r12 = r2
            r2 = 0
        L_0x04d4:
            if (r2 >= r10) goto L_0x04e3
            r13 = r11[r2]
            int r13 = r13.getIod()
            int r12 = java.lang.Math.min(r12, r13)
            int r2 = r2 + 1
            goto L_0x04d4
        L_0x04e3:
            com.huawei.location.ephemeris.Vw r2 = new com.huawei.location.ephemeris.Vw
            long r10 = java.lang.System.currentTimeMillis()
            r2.<init>(r10)
            int r10 = r2.FB()
            int r11 = r2.LW()
            int r11 = r11 * 1024
            int r10 = r10 + r11
            int r10 = r10 * r16
            int r10 = r10 + r3
            r3 = 7200(0x1c20, float:1.009E-41)
            int r10 = r10 + r3
            long r10 = (long) r10
            int r3 = r2.FB()
            int r13 = r2.LW()
            int r13 = r13 * 1024
            int r3 = r3 + r13
            int r3 = r3 * r16
            int r3 = r3 + r0
            int r3 = r3 + 4200
            long r13 = (long) r3
            int r0 = r2.FB()
            int r3 = r2.LW()
            int r3 = r3 * 1024
            int r0 = r0 + r3
            int r0 = r0 * r16
            int r3 = r2.yn()
            int r0 = r0 + r3
            int r12 = r12 * 15
            int r12 = r12 * 60
            int r12 = r12 + -10800
            int r12 = r12 + -18
            int r0 = r0 + r12
            r3 = 1800(0x708, float:2.522E-42)
            int r0 = r0 + r3
            r17 = r10
            long r9 = (long) r0
            long r11 = r6 - r9
            r20 = 43200(0xa8c0, double:2.13436E-319)
            int r0 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r0 <= 0) goto L_0x053d
            r11 = 86400(0x15180, double:4.26873E-319)
            long r9 = r9 + r11
        L_0x053d:
            int r0 = r2.FB()
            int r2 = r2.LW()
            int r2 = r2 * 1024
            int r0 = r0 + r2
            int r0 = r0 * r16
            int r0 = r0 + r8
            r2 = 1800(0x708, float:2.522E-42)
            int r0 = r0 + r2
            long r2 = (long) r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "gpsExpireTime:"
            r0.append(r8)
            r11 = r17
            r0.append(r11)
            java.lang.String r8 = ", bdsExpireTime:"
            r0.append(r8)
            r0.append(r13)
            java.lang.String r8 = ", galExpireTime:"
            r0.append(r8)
            r0.append(r2)
            java.lang.String r8 = ", gloExpireTime:"
            r0.append(r8)
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            long r11 = java.lang.Math.min(r11, r13)
            long r8 = java.lang.Math.min(r11, r9)
            long r2 = java.lang.Math.min(r8, r2)
        L_0x0589:
            long r8 = f50092yn
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 < 0) goto L_0x0633
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0633
            f50092yn = r2
            com.huawei.location.lite.common.util.PreferencesHelper r0 = new com.huawei.location.lite.common.util.PreferencesHelper
            java.lang.String r2 = "ephemeris_expire_time"
            r0.<init>(r2)
            long r6 = f50092yn
            r0.saveLong(r2, r6)
            java.lang.String r0 = "get online ephemeris success"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            com.huawei.location.lite.common.security.LocationSecurityManager r0 = new com.huawei.location.lite.common.security.LocationSecurityManager
            r2 = 3
            r0.<init>(r2)
            com.google.gson.Gson r2 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            boolean r3 = r2 instanceof com.google.gson.Gson
            if (r3 != 0) goto L_0x05b9
            java.lang.String r2 = r2.toJson((java.lang.Object) r4)
            goto L_0x05bd
        L_0x05b9:
            java.lang.String r2 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r2, (java.lang.Object) r4)
        L_0x05bd:
            int r3 = r2.length()
            java.lang.String r4 = "ephData"
            java.lang.String r5 = "LOCATION_LITE_SDK"
            r6 = 4096(0x1000, float:5.74E-42)
            if (r3 <= r6) goto L_0x0627
            int r3 = r2.length()
            double r6 = (double) r3
            java.lang.Double r3 = java.lang.Double.valueOf(r6)
            double r6 = r3.doubleValue()
            r8 = 4661225614328463360(0x40b0000000000000, double:4096.0)
            java.lang.Double r3 = java.lang.Double.valueOf(r8)
            double r8 = r3.doubleValue()
            double r6 = r6 / r8
            double r6 = java.lang.Math.ceil(r6)
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r8 = 0
        L_0x05eb:
            double r9 = (double) r8
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 >= 0) goto L_0x0622
            r11 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r11 = r6 - r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x05ff
            int r9 = r8 * 4096
            int r10 = r2.length()
            goto L_0x0603
        L_0x05ff:
            int r9 = r8 * 4096
            int r10 = r9 + 4096
        L_0x0603:
            java.lang.String r9 = r2.substring(r9, r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r9 = r0.encrypt(r9, r5)
            r10.append(r9)
            java.lang.String r9 = "\n"
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            r3.append(r9)
            int r8 = r8 + 1
            goto L_0x05eb
        L_0x0622:
            java.lang.String r0 = r3.toString()
            goto L_0x062b
        L_0x0627:
            java.lang.String r0 = r0.encrypt(r2, r5)
        L_0x062b:
            com.huawei.location.activity.model.Vw.LW(r0, r4)
            r2 = 0
            Vw = r2
            r4 = 1
            goto L_0x0644
        L_0x0633:
            r2 = 0
            long r3 = java.lang.System.currentTimeMillis()
            FB = r3
            java.lang.String r0 = "cloudtime is expired"
            com.huawei.location.lite.common.log.LogConsole.i(r5, r0)
            Vw = r2
            goto L_0x0643
        L_0x0642:
            r2 = r8
        L_0x0643:
            r4 = r2
        L_0x0644:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.ephemeris.yn.yn():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r1 != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003d, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.riemann.location.bean.eph.Ephemeris Vw() {
        /*
            r11 = this;
            java.lang.String r0 = "json syntax error"
            java.lang.String r1 = "ephData"
            r2 = 0
            r3 = 0
            android.content.Context r4 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ IOException -> 0x003e }
            java.io.FileInputStream r1 = r4.openFileInput(r1)     // Catch:{ IOException -> 0x003e }
            r4 = 1024(0x400, float:1.435E-42)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x0030 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0030 }
            r5.<init>()     // Catch:{ all -> 0x0030 }
        L_0x0017:
            int r6 = r1.read(r4)     // Catch:{ all -> 0x0030 }
            if (r6 <= 0) goto L_0x0028
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0030 }
            java.nio.charset.Charset r8 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0030 }
            r7.<init>(r4, r2, r6, r8)     // Catch:{ all -> 0x0030 }
            r5.append(r7)     // Catch:{ all -> 0x0030 }
            goto L_0x0017
        L_0x0028:
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0030 }
            r1.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0046
        L_0x0030:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r5 = move-exception
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ all -> 0x0039 }
            goto L_0x003d
        L_0x0039:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch:{ IOException -> 0x003e }
        L_0x003d:
            throw r5     // Catch:{ IOException -> 0x003e }
        L_0x003e:
            java.lang.String r1 = "FileUtil"
            java.lang.String r4 = "read from file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r1, r4)
            r4 = r3
        L_0x0046:
            java.lang.String r1 = "EphModule"
            if (r4 != 0) goto L_0x0051
            java.lang.String r0 = "read Ephemeris From Json is null"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r0)
            goto L_0x00f0
        L_0x0051:
            com.huawei.location.lite.common.security.LocationSecurityManager r5 = new com.huawei.location.lite.common.security.LocationSecurityManager
            r6 = 3
            r5.<init>(r6)
            java.lang.String r6 = "\n"
            java.lang.String[] r6 = r4.split(r6)
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            int r8 = r6.length
            java.lang.String r9 = "LOCATION_LITE_SDK"
            r10 = 1
            if (r8 != r10) goto L_0x0070
            java.lang.String r2 = r5.decrypt(r4, r9)
            r7.append(r2)
            goto L_0x007f
        L_0x0070:
            int r4 = r6.length
            if (r2 >= r4) goto L_0x007f
            r4 = r6[r2]
            java.lang.String r4 = r5.decrypt(r4, r9)
            r7.append(r4)
            int r2 = r2 + 1
            goto L_0x0070
        L_0x007f:
            com.google.gson.Gson r2 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x00ed }
            java.lang.String r4 = r7.toString()     // Catch:{ JsonSyntaxException -> 0x00ed }
            java.lang.String r4 = r4.trim()     // Catch:{ JsonSyntaxException -> 0x00ed }
            java.lang.Class<com.huawei.location.ephemeris.net.EphemerisResponse> r5 = com.huawei.location.ephemeris.net.EphemerisResponse.class
            boolean r6 = r2 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x00ed }
            if (r6 != 0) goto L_0x0096
            java.lang.Object r2 = r2.fromJson((java.lang.String) r4, r5)     // Catch:{ JsonSyntaxException -> 0x00ed }
            goto L_0x009a
        L_0x0096:
            java.lang.Object r2 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r2, (java.lang.String) r4, r5)     // Catch:{ JsonSyntaxException -> 0x00ed }
        L_0x009a:
            com.huawei.location.ephemeris.net.EphemerisResponse r2 = (com.huawei.location.ephemeris.net.EphemerisResponse) r2     // Catch:{ JsonSyntaxException -> 0x00ed }
            if (r2 != 0) goto L_0x009f
            goto L_0x00f0
        L_0x009f:
            com.huawei.location.utils.FB r4 = r11.LW     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            if (r4 != 0) goto L_0x00aa
            com.huawei.location.utils.FB r4 = new com.huawei.location.utils.FB     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            r4.<init>()     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            r11.LW = r4     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
        L_0x00aa:
            com.huawei.riemann.location.bean.eph.GpsEphemeris r4 = r11.LW(r2)     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            com.huawei.riemann.location.bean.eph.BdsEphemeris r5 = r11.yn(r2)     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            com.huawei.riemann.location.bean.eph.GalileoEphemeris r6 = r11.Vw(r2)     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            com.huawei.riemann.location.bean.eph.GlonassEphemeris r0 = r11.FB(r2)     // Catch:{ JSONException -> 0x00d3, JsonSyntaxException -> 0x00e9 }
            com.huawei.riemann.location.bean.eph.Ephemeris$Builder r1 = com.huawei.riemann.location.bean.eph.Ephemeris.Builder.anEphemeris()
            com.huawei.riemann.location.bean.eph.Ephemeris$Builder r1 = r1.withGpsEphemeris(r4)
            com.huawei.riemann.location.bean.eph.Ephemeris$Builder r1 = r1.withBdsEphemeris(r5)
            com.huawei.riemann.location.bean.eph.Ephemeris$Builder r1 = r1.withGalileoEphemeris(r6)
            com.huawei.riemann.location.bean.eph.Ephemeris$Builder r0 = r1.withGlonassEphemeris(r0)
            com.huawei.riemann.location.bean.eph.Ephemeris r3 = r0.build()
            goto L_0x00f0
        L_0x00d3:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "jsonException:"
            r2.append(r4)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x00e9:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
            goto L_0x00f0
        L_0x00ed:
            com.huawei.location.lite.common.log.LogConsole.e(r1, r0)
        L_0x00f0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.ephemeris.yn.Vw():com.huawei.riemann.location.bean.eph.Ephemeris");
    }

    private BdsEphemeris yn(EphemerisResponse ephemerisResponse) throws JSONException {
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getBdsNav());
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getBdsIon());
        JSONObject jSONObject3 = new JSONObject(ephemerisResponse.getBdsTim());
        BdsNav[] yn2 = this.LW.yn(jSONObject.getJSONArray("ephList"));
        FB fb2 = this.LW;
        JSONArray jSONArray = jSONObject2.getJSONArray("ionList");
        fb2.getClass();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i11);
            arrayList.add(BdsIon.Builder.aBdsIon().withA0(optJSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(optJSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(optJSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(optJSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(optJSONObject.optInt("b0", 0) * 2048).withB1(optJSONObject.optInt("b1", 0) * 16384).withB2(optJSONObject.optInt("b2", 0) * 65536).withB3(optJSONObject.optInt("b3", 0) * 65536).withSvid(optJSONObject.optInt("svid", 0) + 1).withToe(optJSONObject.optInt("toe", 0) * 8).withSvid(optJSONObject.optInt("svid", 0) + 1).build());
        }
        BdsIon[] bdsIonArr = new BdsIon[arrayList.size()];
        arrayList.toArray(bdsIonArr);
        FB fb3 = this.LW;
        JSONArray jSONArray2 = jSONObject3.getJSONArray("timList");
        fb3.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
            JSONObject optJSONObject2 = jSONArray2.optJSONObject(i12);
            arrayList2.add(BdsTim.Builder.aBdsTim().withA0(optJSONObject2.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(optJSONObject2.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((optJSONObject2.optDouble("a2", 0.0d) / 1.15292150460684698E18d) / 256.0d).withDeltaT(optJSONObject2.optInt("deltaT", 0)).withGnssToId(optJSONObject2.optInt("gnssToId", 0)).withWeekNumber(optJSONObject2.optInt("weekNumber", 0)).withWeekSecond(optJSONObject2.optInt("weekSecond", 0) * 16).build());
        }
        BdsTim[] bdsTimArr = new BdsTim[arrayList2.size()];
        arrayList2.toArray(bdsTimArr);
        LogConsole.i("EphModule", "BdsNav size = " + yn2.length);
        int optInt = jSONObject.optInt("satNumber", 0);
        return BdsEphemeris.Builder.aBdsEphemeris().withSatNumber(optInt).withNonBroadcastInd(jSONObject.optInt("nonBroadcastInd", 0)).withBdsNavs(yn2).withBdsIons(bdsIonArr).withBdsTims(bdsTimArr).build();
    }
}
