package com.huawei.hms.analytics;

import android.os.Build;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.net.Response;
import com.huawei.hms.analytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.huawei.hms.analytics.instance.CallBack;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class ap implements Runnable {
    private String ghi;
    private String hij;
    /* access modifiers changed from: private */
    public String ijk;
    private ICollectorConfig ikl;
    /* access modifiers changed from: private */
    public CallBack klm;
    private String lmn;

    public class lmn extends ci {
        public lmn(cj cjVar, String str, String str2, IConfig iConfig) {
            super(cjVar, str, str2, iConfig);
        }

        public final Map<String, String> lmn() {
            Map<String, String> lmn2 = super.lmn();
            String str = av.lmn().lmn.klm;
            String str2 = Build.MODEL;
            lmn2.put("App-Ver", str);
            lmn2.put("Device-Type", str2);
            lmn2.put("Sdk-Name", "hianalytics");
            lmn2.put("Request-Id", ap.this.ijk);
            return lmn2;
        }

        public final void onFailure(int i11) {
            HiLog.e("RequestBas", "oaid report error:".concat(String.valueOf(i11)));
            if (ap.this.klm != null) {
                ap.this.klm.onResult(i11, "");
            }
        }

        public final void onSuccess(Response response) {
            if (ap.this.klm != null) {
                HiLog.i("RequestBas", "ReportOaid:" + response.getHttpCode());
                ap.this.klm.onResult(response.getHttpCode(), "");
            }
        }
    }

    public ap(ICollectorConfig iCollectorConfig, String str, CallBack callBack) {
        this.lmn = str;
        this.klm = callBack;
        this.ikl = iCollectorConfig;
    }

    private byte[] lmn() {
        String str;
        try {
            String appId = this.ikl.getAppId();
            String str2 = this.ijk;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("protocol_version", (Object) "1");
            jSONObject.put("compress_mode", (Object) "0");
            jSONObject.put("serviceid", (Object) "hmshioperqrt");
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, (Object) appId);
            jSONObject.put("chifer", (Object) "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            jSONObject.put("timestamp", (Object) sb2.toString());
            jSONObject.put("servicetag", (Object) this.lmn);
            jSONObject.put("requestid", (Object) str2);
            EvtHeaderAttributeCollector evtCustomHeader = this.ikl.getEvtCustomHeader("oper", jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject doCollector = evtCustomHeader.doCollector();
            doCollector.remove("wxappid");
            jSONObject3.put("header", (Object) doCollector);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("aaid", (Object) this.ghi);
            jSONObject4.put("oaid", (Object) this.hij);
            jSONObject4.put("oaid_source", (Object) av.lmn().lmn.f47862i);
            jSONObject3.put("events_common", (Object) jSONObject4);
            jSONObject2.put("event", (Object) jSONObject3);
            return JSONObjectInstrumentation.toString(jSONObject2).getBytes("UTF-8");
        } catch (JSONException unused) {
            str = "get body json exception";
            HiLog.e("ReportOaidTask", str);
            return new byte[0];
        } catch (Throwable th2) {
            str = "get body error:" + th2.getMessage();
            HiLog.e("ReportOaidTask", str);
            return new byte[0];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ed A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r9 = this;
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            boolean r0 = r0.fgh
            java.lang.String r1 = "ReportOaidTask"
            if (r0 == 0) goto L_0x015e
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            java.lang.String r2 = r9.lmn
            com.huawei.hms.analytics.ay r0 = r0.lmn(r2)
            boolean r0 = r0.ikl
            if (r0 != 0) goto L_0x001c
            goto L_0x015e
        L_0x001c:
            java.lang.String r0 = r9.lmn
            boolean r0 = com.huawei.hms.analytics.be.lmn(r0)
            if (r0 != 0) goto L_0x003f
            com.huawei.hms.analytics.instance.CallBack r0 = r9.klm
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r9.lmn
            r1.append(r2)
            java.lang.String r2 = " not init"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = -101(0xffffffffffffff9b, float:NaN)
            r0.onResult(r2, r1)
            return
        L_0x003f:
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            com.huawei.hms.analytics.bc r0 = r0.f47867n
            java.lang.String r2 = r9.lmn
            com.huawei.hms.analytics.framework.config.IConfig r8 = r0.klm(r2)
            java.lang.String r0 = r8.getSite()
            java.lang.String r2 = "CN"
            boolean r0 = r2.equals(r0)
            if (r0 != 0) goto L_0x0068
            java.lang.String r0 = "Region is not CN"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)
            com.huawei.hms.analytics.instance.CallBack r0 = r9.klm
            r1 = -111(0xffffffffffffff91, float:NaN)
            java.lang.String r2 = "region invalid"
            r0.onResult(r1, r2)
            return
        L_0x0068:
            com.huawei.hms.analytics.framework.config.ICollectorConfig r0 = r9.ikl
            r0.setIConfig(r8)
            com.huawei.hms.analytics.dy r0 = new com.huawei.hms.analytics.dy
            r0.<init>()
            r0.lmn()
            com.huawei.hms.analytics.framework.config.ICollectorConfig r0 = r9.ikl
            r0.syncOaid()
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            java.lang.String r0 = r0.f47863j
            java.lang.String r2 = "false"
            boolean r0 = r2.equals(r0)
            r2 = 1
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = "oaidTracking is off"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)
            com.huawei.hms.analytics.instance.CallBack r3 = r9.klm
            r4 = -113(0xffffffffffffff8f, float:NaN)
        L_0x0094:
            r3.onResult(r4, r0)
            goto L_0x00eb
        L_0x0098:
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            java.lang.String r0 = r0.f47862i
            java.lang.String r3 = "oaid"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00ba
            java.lang.String r3 = "gaid"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00ba
            java.lang.String r0 = "oaidsoure is not oaid or gaid"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)
            com.huawei.hms.analytics.instance.CallBack r3 = r9.klm
            r4 = -115(0xffffffffffffff8d, float:NaN)
            goto L_0x0094
        L_0x00ba:
            com.huawei.hms.analytics.av r0 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r0 = r0.lmn
            java.lang.String r0 = r0.f47861h
            r9.hij = r0
            com.huawei.hms.analytics.dh r0 = com.huawei.hms.analytics.dh.lmn()
            java.lang.String r0 = r0.klm()
            r9.ghi = r0
            java.lang.String r0 = r9.hij
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00e1
            java.lang.String r0 = r9.ghi
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00df
            goto L_0x00e1
        L_0x00df:
            r2 = 0
            goto L_0x00eb
        L_0x00e1:
            java.lang.String r0 = "oaid is null or aaid is null"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)
            com.huawei.hms.analytics.instance.CallBack r3 = r9.klm
            r4 = -114(0xffffffffffffff8e, float:NaN)
            goto L_0x0094
        L_0x00eb:
            if (r2 == 0) goto L_0x00ee
            return
        L_0x00ee:
            com.huawei.hms.analytics.core.crypto.RandomUtil r0 = com.huawei.hms.analytics.core.crypto.RandomUtil.getInstance()
            r2 = 16
            java.lang.String r0 = r0.generateSecureRandomStr(r2)
            r9.ijk = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "reqID:"
            r0.<init>(r2)
            java.lang.String r2 = r9.ijk
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.huawei.hms.analytics.core.log.HiLog.d(r1, r0)
            com.huawei.hms.analytics.ap$lmn r0 = new com.huawei.hms.analytics.ap$lmn
            java.lang.String r2 = "ReportOaidRequst#execute"
            com.huawei.hms.analytics.cj r5 = com.huawei.hms.analytics.ck.lmn((java.lang.String) r2)
            java.lang.String r6 = "POST"
            java.lang.String r7 = "/ext-api/rest/v1/user/events"
            r3 = r0
            r4 = r9
            r3.<init>(r5, r6, r7, r8)
            byte[] r2 = r9.lmn()
            int r3 = r2.length
            if (r3 > 0) goto L_0x0134
            java.lang.String r0 = "body object is null or body size is 0"
            com.huawei.hms.analytics.core.log.HiLog.e(r1, r0)
            com.huawei.hms.analytics.instance.CallBack r0 = r9.klm
            r1 = -112(0xffffffffffffff90, float:NaN)
            java.lang.String r2 = "body is empty"
            r0.onResult(r1, r2)
            return
        L_0x0134:
            com.huawei.hms.analytics.core.transport.net.HttpTransportHandler r1 = new com.huawei.hms.analytics.core.transport.net.HttpTransportHandler
            r1.<init>()
            java.lang.String[] r3 = r0.ikl()
            r1.setUrls(r3)
            java.lang.String r3 = r0.klm
            r1.setRequestMethod(r3)
            r1.setReportData((byte[]) r2)
            com.huawei.hms.analytics.av r2 = com.huawei.hms.analytics.av.lmn()
            com.huawei.hms.analytics.ax r2 = r2.lmn
            android.content.Context r2 = r2.ghi
            r1.setContext(r2)
            java.util.Map r2 = r0.lmn()
            r1.setHttpHeaders(r2)
            r0.lmn((com.huawei.hms.analytics.core.transport.ITransportHandler) r1)
            return
        L_0x015e:
            java.lang.String r0 = "The Analytics Kit is disabled"
            com.huawei.hms.analytics.core.log.HiLog.w(r1, r0)
            com.huawei.hms.analytics.instance.CallBack r0 = r9.klm
            r1 = -110(0xffffffffffffff92, float:NaN)
            java.lang.String r2 = "analytics closed"
            r0.onResult(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.analytics.ap.run():void");
    }
}
