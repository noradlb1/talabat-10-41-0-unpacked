package com.huawei.location.vdr.data.ephemeris;

import com.google.gson.JsonSyntaxException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PreferencesHelper;
import com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsIon;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.BdsTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GalileoTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassNav;
import com.huawei.riemann.gnsslocation.core.bean.eph.GlonassTim;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsEphemeris;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsIon;
import com.huawei.riemann.gnsslocation.core.bean.eph.GpsNav;
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
    private static long f50288yn;
    private FB LW = new FB();

    private JSONArray E5(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getBdsNav()).getJSONArray("ephList");
        } catch (JSONException e11) {
            LogConsole.e("EphProvider", "getBdsNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    private GalileoEphemeris FB(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb2 = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGalTim());
        fb2.getClass();
        GalileoTim build = GalileoTim.Builder.aGalileoTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withT0(jSONObject.optLong("t0", 0)).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGalNav());
        GalileoNav[] Vw2 = this.LW.Vw(jSONObject2.getJSONArray("ephList"));
        LogConsole.i("EphProvider", "galNavArray size = " + Vw2.length);
        int optInt = jSONObject2.optInt("satNumber", 0);
        return GalileoEphemeris.Builder.aGalileoEphemeris().withSatNumber(optInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGalileoNavs(Vw2).withGalileoTim(build).build();
    }

    private GlonassEphemeris LW(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb2 = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGloTim());
        fb2.getClass();
        GlonassTim build = GlonassTim.Builder.aGlonassTim().withA0(jSONObject.optDouble("a0", 0.0d) / 3.4359738368E10d).withA1(jSONObject.optDouble("a1", 0.0d) / 2.251799813685248E15d).withA2((jSONObject.optDouble("a2", 0.0d) / 1.15292150460684698E18d) / 256.0d).withGnssToId(jSONObject.optInt("gnssToId", 0)).withWeekNumber(jSONObject.optInt("weekNumber", 0)).withWeekSecond(jSONObject.optInt("weekSecond", 0) * 16).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGloNav());
        GlonassNav[] FB2 = this.LW.FB(jSONObject2.getJSONArray("gloNavItemList"));
        LogConsole.i("EphProvider", "GlonassNav size = " + FB2.length);
        int optInt = jSONObject2.optInt("satNumber", 0);
        return GlonassEphemeris.Builder.aGlonassEphemeris().withSatNumber(optInt).withNonBroadcastInd(jSONObject2.optInt("nonBroadcastInd", 0)).withGlonassNavs(FB2).withGlonassTim(build).build();
    }

    private Ephemeris Vw(EphemerisResponse ephemerisResponse) {
        String str;
        if (ephemerisResponse == null) {
            return null;
        }
        try {
            if (this.LW == null) {
                this.LW = new FB();
            }
            GpsEphemeris dC = dC(ephemerisResponse);
            BdsEphemeris yn2 = yn(ephemerisResponse);
            return Ephemeris.Builder.anEphemeris().withGpsEphemeris(dC).withBdsEphemeris(yn2).withGalileoEphemeris(FB(ephemerisResponse)).withGlonassEphemeris(LW(ephemerisResponse)).build();
        } catch (JSONException e11) {
            str = "jsonException:" + e11.getMessage();
            LogConsole.e("EphProvider", str);
            return null;
        } catch (JsonSyntaxException unused) {
            str = "json syntax error";
            LogConsole.e("EphProvider", str);
            return null;
        }
    }

    private JSONArray d2(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGalNav()).getJSONArray("ephList");
        } catch (JSONException e11) {
            LogConsole.e("EphProvider", "getGalNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    private GpsEphemeris dC(EphemerisResponse ephemerisResponse) throws JSONException, JsonSyntaxException {
        FB fb2 = this.LW;
        JSONObject jSONObject = new JSONObject(ephemerisResponse.getGpsIon());
        fb2.getClass();
        GpsIon build = GpsIon.Builder.aGpsIon().withA0(jSONObject.optDouble("a0", 0.0d) / 1.073741824E9d).withA1(jSONObject.optDouble("a1", 0.0d) / 1.34217728E8d).withA2(jSONObject.optDouble("a2", 0.0d) / 1.6777216E7d).withA3(jSONObject.optDouble("a3", 0.0d) / 1.6777216E7d).withB0(jSONObject.optInt("b0", 0) * 2048).withB1(jSONObject.optInt("b1", 0) * 16384).withB2(jSONObject.optInt("b2", 0) * 65536).withB3(jSONObject.optInt("b3", 0) * 65536).withValid(jSONObject.optBoolean("valid")).build();
        JSONObject jSONObject2 = new JSONObject(ephemerisResponse.getGpsNav());
        GpsNav[] LW2 = this.LW.LW(jSONObject2.getJSONArray("ephList"));
        LogConsole.i("EphProvider", "GpsNav size = " + LW2.length);
        return GpsEphemeris.Builder.aGpsEphemeris().withSatNumber(jSONObject2.optInt("satNumber", 0)).withGpsNavs(LW2).withGpsIon(build).build();
    }

    private JSONArray ut(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGpsNav()).getJSONArray("ephList");
        } catch (JSONException e11) {
            LogConsole.e("EphProvider", "getGpsNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
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
        LogConsole.i("EphProvider", "BdsNav size = " + yn2.length);
        int optInt = jSONObject.optInt("satNumber", 0);
        return BdsEphemeris.Builder.aBdsEphemeris().withSatNumber(optInt).withNonBroadcastInd(jSONObject.optInt("nonBroadcastInd", 0)).withBdsNavs(yn2).withBdsIons(bdsIonArr).withBdsTims(bdsTimArr).build();
    }

    private JSONArray zp(EphemerisResponse ephemerisResponse) {
        try {
            return new JSONObject(ephemerisResponse.getGloNav()).getJSONArray("gloNavItemList");
        } catch (JSONException e11) {
            LogConsole.e("EphProvider", "getGloNavs JSONException:" + e11.getMessage());
            return new JSONArray();
        }
    }

    public long FB() {
        if (f50288yn <= 0) {
            f50288yn = new PreferencesHelper("ephemeris_expire_time").getLong("ephemeris_expire_time");
        }
        LogConsole.i("EphProvider", "getExpireTime = " + f50288yn);
        return f50288yn;
    }

    /* JADX WARNING: type inference failed for: r0v76, types: [com.huawei.location.lite.common.http.response.BaseResponse] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x041b  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0560  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0603  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x015a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris Vw() {
        /*
            r31 = this;
            r1 = r31
            java.lang.String r2 = ", msg is "
            java.lang.String r3 = "ephList"
            java.lang.String r0 = "try to downloadEphemeris here"
            java.lang.String r4 = "EphProvider"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            boolean r0 = Vw
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "download task running, return empty ephemeris here"
        L_0x0013:
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
        L_0x0016:
            r5 = 0
            goto L_0x0613
        L_0x0019:
            com.huawei.location.vdr.data.ephemeris.Vw r0 = new com.huawei.location.vdr.data.ephemeris.Vw
            long r6 = java.lang.System.currentTimeMillis()
            r0.<init>(r6)
            long r6 = r0.Vw()
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = FB
            long r8 = r8 - r10
            r10 = 60000(0xea60, double:2.9644E-319)
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x0037
            java.lang.String r0 = "request too frequent, return empty ephemeris here"
            goto L_0x0013
        L_0x0037:
            r8 = 1
            Vw = r8
            com.huawei.location.vdr.data.ephemeris.net.yn r0 = new com.huawei.location.vdr.data.ephemeris.net.yn
            java.lang.String r9 = "AGNSS"
            r0.<init>(r9)
            java.lang.String r9 = "get online eph data"
            java.lang.String r10 = "OnlineEphService"
            com.huawei.location.lite.common.log.LogConsole.i(r10, r9)
            com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse r9 = new com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse
            r9.<init>()
            com.google.gson.Gson r11 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            boolean r12 = r11 instanceof com.google.gson.Gson
            if (r12 != 0) goto L_0x005a
            java.lang.String r0 = r11.toJson((java.lang.Object) r0)
            goto L_0x005e
        L_0x005a:
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r11, (java.lang.Object) r0)
        L_0x005e:
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0124 }
            r11.<init>((java.lang.String) r0)     // Catch:{ JSONException -> 0x0124 }
            com.huawei.location.lite.common.http.request.RequestJsonBody$Builder r0 = new com.huawei.location.lite.common.http.request.RequestJsonBody$Builder     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            r0.<init>()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.RequestJsonBody r0 = r0.build(r11)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.util.UUID r11 = java.util.UUID.randomUUID()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.lang.String r11 = r11.toString()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.lang.String r12 = "com.huawei.hms.location"
            java.lang.String r12 = com.huawei.location.lite.common.grs.LocationNlpGrsHelper.getGrsHostAddress(r12)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            boolean r13 = android.text.TextUtils.isEmpty(r12)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            if (r13 == 0) goto L_0x0087
            java.lang.String r0 = "grsHostAddress is null"
            com.huawei.location.lite.common.log.LogConsole.e(r10, r0)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            goto L_0x0127
        L_0x0087:
            android.content.Context r13 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.lang.String r13 = r13.getPackageName()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.HeadBuilder r14 = new com.huawei.location.lite.common.http.request.HeadBuilder     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            r14.<init>(r11)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.HeadBuilder r11 = r14.setPackageName(r13)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r13 = new com.huawei.location.lite.common.http.request.BaseRequest$Builder     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.lang.String r14 = "/networklocation/v1/gnssData"
            r13.<init>(r14)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r12 = r13.setBaseUrl(r12)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r11 = r12.setHeads(r11)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.BaseRequest$Builder r0 = r11.setBody((com.huawei.location.lite.common.http.request.RequestJsonBody) r0)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.HttpClientEx r11 = new com.huawei.location.lite.common.http.HttpClientEx     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            r11.<init>()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.request.BaseRequest r0 = r0.build()     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            com.huawei.location.lite.common.http.adapter.ISubmitAdapter r0 = r11.newSubmit(r0)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.lang.Class<com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse> r11 = com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse.class
            com.huawei.location.lite.common.http.response.BaseResponse r0 = r0.execute(r11)     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            r11 = r0
            com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse r11 = (com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse) r11     // Catch:{ OnFailureException -> 0x0100, OnErrorException -> 0x00e6, Exception -> 0x00e3 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            r0.<init>()     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            java.lang.String r9 = "doHttp, response code is "
            r0.append(r9)     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            java.lang.String r9 = r11.getApiCode()     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            r0.append(r9)     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            java.lang.String r0 = r0.toString()     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            com.huawei.location.lite.common.log.LogConsole.i(r10, r0)     // Catch:{ OnFailureException -> 0x00e0, OnErrorException -> 0x00dd, Exception -> 0x00db }
            r9 = r11
            goto L_0x0127
        L_0x00db:
            r9 = r11
            goto L_0x00e3
        L_0x00dd:
            r0 = move-exception
            r9 = r11
            goto L_0x00e7
        L_0x00e0:
            r0 = move-exception
            r9 = r11
            goto L_0x0101
        L_0x00e3:
            java.lang.String r0 = "unknown exception"
            goto L_0x0120
        L_0x00e6:
            r0 = move-exception
        L_0x00e7:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "doHttp, OnErrorException: code is "
            r11.append(r12)
            java.lang.String r12 = r0.getApiCode()
            r11.append(r12)
            r11.append(r2)
            java.lang.String r0 = r0.getApiMsg()
            goto L_0x0119
        L_0x0100:
            r0 = move-exception
        L_0x0101:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "doHttp, OnFailureException: code is "
            r11.append(r12)
            com.huawei.location.lite.common.http.exception.ErrorCode r12 = r0.getErrorCode()
            r11.append(r12)
            r11.append(r2)
            java.lang.String r0 = r0.getMessage()
        L_0x0119:
            r11.append(r0)
            java.lang.String r0 = r11.toString()
        L_0x0120:
            com.huawei.location.lite.common.log.LogConsole.e(r10, r0)
            goto L_0x0127
        L_0x0124:
            java.lang.String r0 = "doHttp, transfer to JSONException failed"
            goto L_0x0120
        L_0x0127:
            boolean r0 = r9.isSuccess()
            r2 = 0
            if (r0 != 0) goto L_0x013d
            java.lang.String r0 = "get online ephemeris failed"
        L_0x0130:
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            long r10 = java.lang.System.currentTimeMillis()
            FB = r10
            Vw = r2
            r0 = r2
            goto L_0x014f
        L_0x013d:
            java.lang.String r0 = r9.getBdsNav()
            if (r0 == 0) goto L_0x014c
            java.lang.String r0 = r9.getGpsNav()
            if (r0 != 0) goto L_0x014a
            goto L_0x014c
        L_0x014a:
            r0 = r8
            goto L_0x014f
        L_0x014c:
            java.lang.String r0 = "get online ephemeris contains illegal arguments"
            goto L_0x0130
        L_0x014f:
            if (r0 != 0) goto L_0x015a
            Vw = r2
            java.lang.String r0 = "ephemeris in cloud is invalid, return empty ephemeris here"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            goto L_0x0016
        L_0x015a:
            org.json.JSONArray r0 = r1.ut(r9)
            org.json.JSONArray r10 = r1.E5(r9)
            org.json.JSONArray r11 = r1.d2(r9)
            org.json.JSONArray r12 = r1.zp(r9)
            int r13 = r0.length()
            r14 = 7200(0x1c20, float:1.009E-41)
            r16 = 604800(0x93a80, float:8.47505E-40)
            if (r13 == 0) goto L_0x040c
            int r13 = r10.length()
            if (r13 == 0) goto L_0x040c
            int r13 = r11.length()
            if (r13 == 0) goto L_0x040c
            int r13 = r12.length()
            if (r13 != 0) goto L_0x0189
            goto L_0x040c
        L_0x0189:
            com.huawei.location.vdr.data.ephemeris.Vw r13 = new com.huawei.location.vdr.data.ephemeris.Vw
            r17 = r6
            long r5 = java.lang.System.currentTimeMillis()
            r13.<init>(r5)
            com.huawei.location.vdr.data.ephemeris.FB r5 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.GpsNav[] r5 = r5.LW(r0)
            int r6 = r0.length()
            int r6 = r6 - r8
        L_0x019f:
            if (r6 < 0) goto L_0x020c
            r7 = r5[r6]
            int r19 = r13.FB()
            int r20 = r7.getWeekNumber()
            int r2 = r19 - r20
            r15 = 512(0x200, float:7.175E-43)
            if (r2 <= r15) goto L_0x01b9
            java.lang.String r15 = "weekNumberDiff > 512"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r15)
            int r2 = r2 + -1024
            goto L_0x01c5
        L_0x01b9:
            r15 = -512(0xfffffffffffffe00, float:NaN)
            if (r2 >= r15) goto L_0x01c0
            int r2 = r2 + 1024
            goto L_0x01c5
        L_0x01c0:
            java.lang.String r15 = "between -512 and 512"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r15)
        L_0x01c5:
            int r2 = r2 * r16
            int r15 = r13.dC()
            int r2 = r2 + r15
            int r7 = r7.getToe()
            int r2 = r2 - r7
            r7 = 302400(0x49d40, float:4.23753E-40)
            if (r2 <= r7) goto L_0x01d9
            int r2 = r2 - r16
            goto L_0x01e6
        L_0x01d9:
            r7 = -302400(0xfffffffffffb62c0, float:NaN)
            if (r2 >= r7) goto L_0x01e1
            int r2 = r2 + r16
            goto L_0x01e6
        L_0x01e1:
            java.lang.String r7 = "between half day"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r7)
        L_0x01e6:
            int r7 = java.lang.Math.abs(r2)
            if (r7 > r14) goto L_0x01ee
            r2 = r8
            goto L_0x0203
        L_0x01ee:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r15 = "gpsTime diff ="
            r7.append(r15)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r4, r2)
            r2 = 0
        L_0x0203:
            if (r2 != 0) goto L_0x0208
            r0.remove(r6)
        L_0x0208:
            int r6 = r6 + -1
            r2 = 0
            goto L_0x019f
        L_0x020c:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "gpsNavs size = "
            r2.append(r6)
            int r5 = r5.length
            r2.append(r5)
            java.lang.String r5 = ", gpsNavArray size = "
            r2.append(r5)
            int r5 = r0.length()
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r4, r2)
            com.huawei.location.vdr.data.ephemeris.FB r2 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.BdsNav[] r2 = r2.yn(r10)
            int r5 = r10.length()
            int r5 = r5 - r8
        L_0x0238:
            java.lang.String r6 = "between one week"
            r21 = -302400(0xfffffffffffb62c0, double:NaN)
            r23 = 302400(0x49d40, double:1.494055E-318)
            r25 = 604800(0x93a80, double:2.98811E-318)
            if (r5 < 0) goto L_0x028d
            r7 = r2[r5]
            int r15 = r13.dC()
            int r7 = r7.getToe()
            int r15 = r15 - r7
            long r14 = (long) r15
            int r20 = (r14 > r23 ? 1 : (r14 == r23 ? 0 : -1))
            if (r20 <= 0) goto L_0x0258
            long r14 = r14 - r25
            goto L_0x0262
        L_0x0258:
            int r20 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r20 >= 0) goto L_0x025f
            long r14 = r14 + r25
            goto L_0x0262
        L_0x025f:
            com.huawei.location.lite.common.log.LogConsole.i(r4, r6)
        L_0x0262:
            long r21 = java.lang.Math.abs(r14)
            r23 = 4200(0x1068, double:2.075E-320)
            int r6 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r6 > 0) goto L_0x026e
            r6 = r8
            goto L_0x0283
        L_0x026e:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "BdsTime diff ="
            r6.append(r7)
            r6.append(r14)
            java.lang.String r6 = r6.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r4, r6)
            r6 = 0
        L_0x0283:
            if (r6 != 0) goto L_0x0288
            r10.remove(r5)
        L_0x0288:
            int r5 = r5 + -1
            r14 = 7200(0x1c20, float:1.009E-41)
            goto L_0x0238
        L_0x028d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "bdsNavs size = "
            r5.append(r7)
            int r2 = r2.length
            r5.append(r2)
            java.lang.String r2 = ", bdsNavArrays size = "
            r5.append(r2)
            int r2 = r10.length()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r4, r2)
            com.huawei.location.vdr.data.ephemeris.FB r2 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.GalileoNav[] r2 = r2.Vw(r11)
            int r5 = r11.length()
            int r5 = r5 - r8
        L_0x02b9:
            if (r5 < 0) goto L_0x0301
            r7 = r2[r5]
            int r14 = r13.dC()
            int r7 = r7.getToe()
            int r14 = r14 - r7
            long r14 = (long) r14
            int r7 = (r14 > r23 ? 1 : (r14 == r23 ? 0 : -1))
            if (r7 <= 0) goto L_0x02ce
            long r14 = r14 - r25
            goto L_0x02d8
        L_0x02ce:
            int r7 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r7 >= 0) goto L_0x02d5
            long r14 = r14 + r25
            goto L_0x02d8
        L_0x02d5:
            com.huawei.location.lite.common.log.LogConsole.i(r4, r6)
        L_0x02d8:
            long r27 = java.lang.Math.abs(r14)
            r29 = 1800(0x708, double:8.893E-321)
            int r7 = (r27 > r29 ? 1 : (r27 == r29 ? 0 : -1))
            if (r7 > 0) goto L_0x02e3
            goto L_0x02f8
        L_0x02e3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "GalTime diff ="
            r7.append(r8)
            r7.append(r14)
            java.lang.String r7 = r7.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r4, r7)
            r8 = 0
        L_0x02f8:
            if (r8 != 0) goto L_0x02fd
            r11.remove(r5)
        L_0x02fd:
            int r5 = r5 + -1
            r8 = 1
            goto L_0x02b9
        L_0x0301:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "galNavs size = "
            r5.append(r6)
            int r2 = r2.length
            r5.append(r2)
            java.lang.String r2 = ", galJSONArrays size = "
            r5.append(r2)
            int r2 = r11.length()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r4, r2)
            com.huawei.location.vdr.data.ephemeris.FB r2 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.GlonassNav[] r2 = r2.FB(r12)
            int r5 = r12.length()
            r6 = 1
            int r5 = r5 - r6
        L_0x032e:
            if (r5 < 0) goto L_0x037a
            r7 = r2[r5]
            int r7 = r7.getIod()
            int r7 = r7 * 15
            int r7 = r7 * 60
            int r7 = r7 + -10800
            r8 = 86400(0x15180, float:1.21072E-40)
            int r7 = r7 % r8
            int r14 = r13.dC()
            int r14 = r14 % r8
            int r7 = r7 - r14
            r14 = 43200(0xa8c0, float:6.0536E-41)
            if (r7 <= r14) goto L_0x034d
            int r7 = r7 - r8
            goto L_0x0353
        L_0x034d:
            r14 = -43200(0xffffffffffff5740, float:NaN)
            if (r7 >= r14) goto L_0x0353
            int r7 = r7 + r8
        L_0x0353:
            int r8 = java.lang.Math.abs(r7)
            r14 = 1800(0x708, float:2.522E-42)
            if (r8 > r14) goto L_0x035d
            r7 = r6
            goto L_0x0372
        L_0x035d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r14 = "GloTime diff ="
            r8.append(r14)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.huawei.location.lite.common.log.LogConsole.e(r4, r7)
            r7 = 0
        L_0x0372:
            if (r7 != 0) goto L_0x0377
            r12.remove(r5)
        L_0x0377:
            int r5 = r5 + -1
            goto L_0x032e
        L_0x037a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "gloNavs size = "
            r5.append(r7)
            int r2 = r2.length
            r5.append(r2)
            java.lang.String r2 = ", gloJSONArrays size = "
            r5.append(r2)
            int r2 = r12.length()
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r4, r2)
            int r2 = r0.length()
            if (r2 == 0) goto L_0x0409
            int r2 = r10.length()
            if (r2 == 0) goto L_0x0409
            int r2 = r11.length()
            if (r2 == 0) goto L_0x0409
            int r2 = r12.length()
            if (r2 != 0) goto L_0x03b4
            goto L_0x0409
        L_0x03b4:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r5 = r9.getGpsNav()     // Catch:{ JSONException -> 0x0403 }
            r2.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x0403 }
            r2.put((java.lang.String) r3, (java.lang.Object) r0)     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r2)     // Catch:{ JSONException -> 0x0403 }
            r9.setGpsNav(r0)     // Catch:{ JSONException -> 0x0403 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r2 = r9.getBdsNav()     // Catch:{ JSONException -> 0x0403 }
            r0.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0403 }
            r0.put((java.lang.String) r3, (java.lang.Object) r10)     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x0403 }
            r9.setBdsNav(r0)     // Catch:{ JSONException -> 0x0403 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r2 = r9.getGalNav()     // Catch:{ JSONException -> 0x0403 }
            r0.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0403 }
            r0.put((java.lang.String) r3, (java.lang.Object) r11)     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x0403 }
            r9.setGalNav(r0)     // Catch:{ JSONException -> 0x0403 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r2 = r9.getGloNav()     // Catch:{ JSONException -> 0x0403 }
            r0.<init>((java.lang.String) r2)     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r2 = "gloNavItemList"
            r0.put((java.lang.String) r2, (java.lang.Object) r12)     // Catch:{ JSONException -> 0x0403 }
            java.lang.String r0 = com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation.toString(r0)     // Catch:{ JSONException -> 0x0403 }
            r9.setGloNav(r0)     // Catch:{ JSONException -> 0x0403 }
            goto L_0x0415
        L_0x0403:
            java.lang.String r0 = "filteringResponse JSONException"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            goto L_0x0415
        L_0x0409:
            java.lang.String r0 = "ephemeris is not valid"
            goto L_0x0411
        L_0x040c:
            r17 = r6
            r6 = r8
            java.lang.String r0 = "parse response failed"
        L_0x0411:
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
            r9 = 0
        L_0x0415:
            r2 = 0
            if (r9 != 0) goto L_0x041b
            goto L_0x0556
        L_0x041b:
            org.json.JSONArray r0 = r1.ut(r9)
            com.huawei.location.vdr.data.ephemeris.FB r5 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.GpsNav[] r0 = r5.LW(r0)
            org.json.JSONArray r5 = r1.E5(r9)
            com.huawei.location.vdr.data.ephemeris.FB r7 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.BdsNav[] r5 = r7.yn(r5)
            org.json.JSONArray r7 = r1.d2(r9)
            com.huawei.location.vdr.data.ephemeris.FB r8 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.GalileoNav[] r7 = r8.Vw(r7)
            org.json.JSONArray r8 = r1.zp(r9)
            com.huawei.location.vdr.data.ephemeris.FB r10 = r1.LW
            com.huawei.riemann.gnsslocation.core.bean.eph.GlonassNav[] r8 = r10.FB(r8)
            int r10 = r0.length
            if (r10 == 0) goto L_0x0551
            int r10 = r5.length
            if (r10 == 0) goto L_0x0551
            int r10 = r7.length
            if (r10 == 0) goto L_0x0551
            int r10 = r8.length
            if (r10 != 0) goto L_0x0451
            goto L_0x0551
        L_0x0451:
            r10 = 0
            r2 = r0[r10]
            int r2 = r2.getToe()
            r3 = r6
        L_0x0459:
            int r11 = r0.length
            if (r3 >= r11) goto L_0x0469
            r11 = r0[r3]
            int r11 = r11.getToe()
            int r2 = java.lang.Math.min(r11, r2)
            int r3 = r3 + 1
            goto L_0x0459
        L_0x0469:
            r0 = r5[r10]
            int r0 = r0.getToe()
            r3 = r6
        L_0x0470:
            int r11 = r5.length
            if (r3 >= r11) goto L_0x0480
            r11 = r5[r3]
            int r11 = r11.getToe()
            int r0 = java.lang.Math.min(r0, r11)
            int r3 = r3 + 1
            goto L_0x0470
        L_0x0480:
            r3 = r7[r10]
            int r3 = r3.getToe()
        L_0x0486:
            int r5 = r7.length
            if (r6 >= r5) goto L_0x0496
            r5 = r7[r6]
            int r5 = r5.getToe()
            int r3 = java.lang.Math.min(r3, r5)
            int r6 = r6 + 1
            goto L_0x0486
        L_0x0496:
            r5 = r8[r10]
            int r5 = r5.getIod()
            int r6 = r8.length
            r10 = 0
        L_0x049e:
            if (r10 >= r6) goto L_0x04ad
            r7 = r8[r10]
            int r7 = r7.getIod()
            int r5 = java.lang.Math.min(r5, r7)
            int r10 = r10 + 1
            goto L_0x049e
        L_0x04ad:
            com.huawei.location.vdr.data.ephemeris.Vw r6 = new com.huawei.location.vdr.data.ephemeris.Vw
            long r7 = java.lang.System.currentTimeMillis()
            r6.<init>(r7)
            int r7 = r6.FB()
            int r8 = r6.LW()
            int r8 = r8 * 1024
            int r7 = r7 + r8
            int r7 = r7 * r16
            int r7 = r7 + r2
            r2 = 7200(0x1c20, float:1.009E-41)
            int r7 = r7 + r2
            long r7 = (long) r7
            int r2 = r6.FB()
            int r10 = r6.LW()
            int r10 = r10 * 1024
            int r2 = r2 + r10
            int r2 = r2 * r16
            int r2 = r2 + r0
            int r2 = r2 + 4200
            long r10 = (long) r2
            int r0 = r6.FB()
            int r2 = r6.LW()
            int r2 = r2 * 1024
            int r0 = r0 + r2
            int r0 = r0 * r16
            int r2 = r6.yn()
            int r0 = r0 + r2
            int r5 = r5 * 15
            int r5 = r5 * 60
            int r5 = r5 + -10800
            int r5 = r5 + -18
            int r0 = r0 + r5
            r2 = 1800(0x708, float:2.522E-42)
            int r0 = r0 + r2
            long r12 = (long) r0
            long r14 = r17 - r12
            r21 = 43200(0xa8c0, double:2.13436E-319)
            int r0 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r0 <= 0) goto L_0x0505
            r14 = 86400(0x15180, double:4.26873E-319)
            long r12 = r12 + r14
        L_0x0505:
            int r0 = r6.FB()
            int r2 = r6.LW()
            int r2 = r2 * 1024
            int r0 = r0 + r2
            int r0 = r0 * r16
            int r0 = r0 + r3
            r2 = 1800(0x708, float:2.522E-42)
            int r0 = r0 + r2
            long r2 = (long) r0
            long r5 = java.lang.Math.min(r7, r10)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r14 = "gpsExpireTime:"
            r0.append(r14)
            r0.append(r7)
            java.lang.String r7 = ", bdsExpireTime:"
            r0.append(r7)
            r0.append(r10)
            java.lang.String r7 = ", galExpireTime:"
            r0.append(r7)
            r0.append(r2)
            java.lang.String r2 = ", gloExpireTime:"
            r0.append(r2)
            r0.append(r12)
            java.lang.String r2 = ", expireTimeVdr:"
            r0.append(r2)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            r2 = r5
            goto L_0x0556
        L_0x0551:
            java.lang.String r0 = "new eph data invalid"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
        L_0x0556:
            long r5 = f50288yn
            int r0 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x0603
            int r0 = (r2 > r17 ? 1 : (r2 == r17 ? 0 : -1))
            if (r0 <= 0) goto L_0x0603
            f50288yn = r2
            com.huawei.location.lite.common.util.PreferencesHelper r0 = new com.huawei.location.lite.common.util.PreferencesHelper
            java.lang.String r2 = "ephemeris_expire_time"
            r0.<init>(r2)
            long r5 = f50288yn
            r0.saveLong(r2, r5)
            java.lang.String r0 = "get online ephemeris success"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            com.huawei.location.lite.common.security.LocationSecurityManager r0 = new com.huawei.location.lite.common.security.LocationSecurityManager
            r2 = 3
            r0.<init>(r2)
            com.google.gson.Gson r2 = com.huawei.location.lite.common.util.GsonUtil.getInstance()
            boolean r3 = r2 instanceof com.google.gson.Gson
            if (r3 != 0) goto L_0x0586
            java.lang.String r2 = r2.toJson((java.lang.Object) r9)
            goto L_0x058a
        L_0x0586:
            java.lang.String r2 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.toJson((com.google.gson.Gson) r2, (java.lang.Object) r9)
        L_0x058a:
            int r3 = r2.length()
            java.lang.String r4 = "ephData"
            java.lang.String r5 = "LOCATION_LITE_SDK"
            r6 = 4096(0x1000, float:5.74E-42)
            if (r3 <= r6) goto L_0x05f4
            int r3 = r2.length()
            double r6 = (double) r3
            java.lang.Double r3 = java.lang.Double.valueOf(r6)
            double r6 = r3.doubleValue()
            r10 = 4661225614328463360(0x40b0000000000000, double:4096.0)
            java.lang.Double r3 = java.lang.Double.valueOf(r10)
            double r10 = r3.doubleValue()
            double r6 = r6 / r10
            double r6 = java.lang.Math.ceil(r6)
            java.lang.StringBuffer r3 = new java.lang.StringBuffer
            r3.<init>()
            r10 = 0
        L_0x05b8:
            double r11 = (double) r10
            int r8 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x05ef
            r13 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r13 = r6 - r13
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 != 0) goto L_0x05cc
            int r8 = r10 * 4096
            int r11 = r2.length()
            goto L_0x05d0
        L_0x05cc:
            int r8 = r10 * 4096
            int r11 = r8 + 4096
        L_0x05d0:
            java.lang.String r8 = r2.substring(r8, r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r8 = r0.encrypt(r8, r5)
            r11.append(r8)
            java.lang.String r8 = "\n"
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r3.append(r8)
            int r10 = r10 + 1
            goto L_0x05b8
        L_0x05ef:
            java.lang.String r0 = r3.toString()
            goto L_0x05f8
        L_0x05f4:
            java.lang.String r0 = r0.encrypt(r2, r5)
        L_0x05f8:
            com.huawei.location.activity.model.Vw.dC(r0, r4)
            r0 = 0
            Vw = r0
            com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris r5 = r1.Vw(r9)
            goto L_0x0613
        L_0x0603:
            r0 = 0
            long r2 = java.lang.System.currentTimeMillis()
            FB = r2
            Vw = r0
            java.lang.String r0 = "ephemeris in cloud is expired, return empty ephemeris here"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            goto L_0x0016
        L_0x0613:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.data.ephemeris.yn.Vw():com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0083, code lost:
        if (r1 != null) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x008d, code lost:
        throw r7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris yn() {
        /*
            r11 = this;
            java.lang.String r0 = "FileUtil"
            com.huawei.location.vdr.data.ephemeris.Vw r1 = new com.huawei.location.vdr.data.ephemeris.Vw
            long r2 = java.lang.System.currentTimeMillis()
            r1.<init>(r2)
            long r2 = r1.Vw()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "gpsTime = "
            r4.append(r5)
            long r5 = r1.Vw()
            r4.append(r5)
            java.lang.String r1 = r4.toString()
            java.lang.String r4 = "EphProvider"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r1)
            long r5 = r11.FB()
            int r1 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 > 0) goto L_0x0035
            r1 = r2
            goto L_0x0036
        L_0x0035:
            r1 = r3
        L_0x0036:
            if (r1 == 0) goto L_0x00f1
            java.lang.String r1 = "try to get local Ephemeris here"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r1)
            java.lang.String r1 = "ephData"
            r5 = 0
            android.content.Context r6 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ IOException -> 0x008e }
            java.io.FileInputStream r1 = r6.openFileInput(r1)     // Catch:{ IOException -> 0x008e }
            int r6 = r1.available()     // Catch:{ all -> 0x0080 }
            if (r6 < 0) goto L_0x0076
            int r6 = r1.available()     // Catch:{ all -> 0x0080 }
            r7 = 20971520(0x1400000, float:3.526483E-38)
            if (r6 <= r7) goto L_0x0057
            goto L_0x0076
        L_0x0057:
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r7.<init>()     // Catch:{ all -> 0x0080 }
        L_0x0060:
            int r8 = r1.read(r6)     // Catch:{ all -> 0x0080 }
            if (r8 <= 0) goto L_0x0071
            java.lang.String r9 = new java.lang.String     // Catch:{ all -> 0x0080 }
            java.nio.charset.Charset r10 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x0080 }
            r9.<init>(r6, r3, r8, r10)     // Catch:{ all -> 0x0080 }
            r7.append(r9)     // Catch:{ all -> 0x0080 }
            goto L_0x0060
        L_0x0071:
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0080 }
            goto L_0x007c
        L_0x0076:
            java.lang.String r6 = "FileInputStream length is illegal"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r6)     // Catch:{ all -> 0x0080 }
            r6 = r5
        L_0x007c:
            r1.close()     // Catch:{ IOException -> 0x008e }
            goto L_0x0094
        L_0x0080:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r7 = move-exception
            if (r1 == 0) goto L_0x008d
            r1.close()     // Catch:{ all -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r1 = move-exception
            r6.addSuppressed(r1)     // Catch:{ IOException -> 0x008e }
        L_0x008d:
            throw r7     // Catch:{ IOException -> 0x008e }
        L_0x008e:
            java.lang.String r1 = "read from file failed"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)
            r6 = r5
        L_0x0094:
            if (r6 != 0) goto L_0x009c
            java.lang.String r0 = "read Ephemeris From Json is null"
            com.huawei.location.lite.common.log.LogConsole.i(r4, r0)
            goto L_0x00f0
        L_0x009c:
            com.huawei.location.lite.common.security.LocationSecurityManager r0 = new com.huawei.location.lite.common.security.LocationSecurityManager
            r1 = 3
            r0.<init>(r1)
            java.lang.String r1 = "\n"
            java.lang.String[] r1 = r6.split(r1)
            java.lang.StringBuffer r7 = new java.lang.StringBuffer
            r7.<init>()
            int r8 = r1.length
            java.lang.String r9 = "LOCATION_LITE_SDK"
            if (r8 != r2) goto L_0x00ba
            java.lang.String r0 = r0.decrypt(r6, r9)
            r7.append(r0)
            goto L_0x00c9
        L_0x00ba:
            int r2 = r1.length
            if (r3 >= r2) goto L_0x00c9
            r2 = r1[r3]
            java.lang.String r2 = r0.decrypt(r2, r9)
            r7.append(r2)
            int r3 = r3 + 1
            goto L_0x00ba
        L_0x00c9:
            com.google.gson.Gson r0 = com.huawei.location.lite.common.util.GsonUtil.getInstance()     // Catch:{ JsonSyntaxException -> 0x00eb }
            java.lang.String r1 = r7.toString()     // Catch:{ JsonSyntaxException -> 0x00eb }
            java.lang.String r1 = r1.trim()     // Catch:{ JsonSyntaxException -> 0x00eb }
            java.lang.Class<com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse> r2 = com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse.class
            boolean r3 = r0 instanceof com.google.gson.Gson     // Catch:{ JsonSyntaxException -> 0x00eb }
            if (r3 != 0) goto L_0x00e0
            java.lang.Object r0 = r0.fromJson((java.lang.String) r1, r2)     // Catch:{ JsonSyntaxException -> 0x00eb }
            goto L_0x00e4
        L_0x00e0:
            java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r0, (java.lang.String) r1, r2)     // Catch:{ JsonSyntaxException -> 0x00eb }
        L_0x00e4:
            com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse r0 = (com.huawei.location.vdr.data.ephemeris.net.EphemerisResponse) r0     // Catch:{ JsonSyntaxException -> 0x00eb }
            com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris r5 = r11.Vw(r0)
            goto L_0x00f0
        L_0x00eb:
            java.lang.String r0 = "json syntax error"
            com.huawei.location.lite.common.log.LogConsole.e(r4, r0)
        L_0x00f0:
            return r5
        L_0x00f1:
            com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris r0 = r11.Vw()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.vdr.data.ephemeris.yn.yn():com.huawei.riemann.gnsslocation.core.bean.eph.Ephemeris");
    }
}
