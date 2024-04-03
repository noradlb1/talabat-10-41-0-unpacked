package com.huawei.hms.analytics;

import android.os.Build;
import com.huawei.hms.analytics.bg;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.net.HttpTransportHandler;
import com.huawei.hms.analytics.framework.config.IConfig;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@Instrumented
public final class cx {
    public static final Charset lmn = Charset.forName("UTF-8");
    private boolean ijk;
    private IConfig ikl;
    private cu klm;

    public cx(cu cuVar, IConfig iConfig, boolean z11) {
        this.klm = cuVar;
        this.ikl = iConfig;
        this.ijk = z11;
    }

    private Map<String, String> ijk() {
        ax axVar = av.lmn().lmn;
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", axVar.f47867n.klm);
        hashMap.put("App-Ver", axVar.klm);
        hashMap.put("x-hasdk-productid", axVar.f47867n.ikl);
        hashMap.put("x-hasdk-resourceid", axVar.f47867n.ijk);
        hashMap.put("x-hasdk-token", axVar.hij);
        hashMap.put("x-hasdk-clientid", axVar.f47867n.ghi);
        hashMap.put("Sdk-Ver", "6.9.0.302");
        hashMap.put("Device-Type", Build.MODEL);
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("servicetag", "_openness_log_tag");
        hashMap.put("x-hasdk-log-region", this.klm.fgh);
        return hashMap;
    }

    private String[] ikl() {
        String[] serviceUrls = this.ikl.getServiceUrls();
        for (int i11 = 0; i11 < serviceUrls.length; i11++) {
            serviceUrls[i11] = "{url}/common/hmshimaintqrt".replace("{url}", serviceUrls[i11]);
        }
        return serviceUrls;
    }

    private void klm() {
        bi.lmn().lmn(this.klm.klm);
        if (this.klm.ikl()) {
            bi.lmn().ijk();
            this.klm.hij();
        }
    }

    public final void lmn() {
        HiLog.d("LgEvtSend", "start report");
        JSONObject klm2 = this.klm.klm();
        String jSONObject = !(klm2 instanceof JSONObject) ? klm2.toString() : JSONObjectInstrumentation.toString(klm2);
        String str = this.klm.hij;
        HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
        httpTransportHandler.setUrls(ikl());
        httpTransportHandler.setRequestMethod("POST");
        httpTransportHandler.setContext(av.lmn().lmn.ghi);
        httpTransportHandler.setHttpHeaders(ijk());
        httpTransportHandler.setReportData(dw.lmn(jSONObject.getBytes(lmn)));
        int httpCode = httpTransportHandler.execute().getHttpCode();
        HiLog.i("LgEvtSend", "log evts PostRequest, resultCode: %d ,reqID:".concat(String.valueOf(str)), Integer.valueOf(httpCode));
        if (httpCode == 200 || this.ijk) {
            try {
                klm();
            } catch (bg.lmn unused) {
                HiLog.e("LgEvtSend", "log db init failed");
            }
        }
        this.klm.ijk();
    }
}
