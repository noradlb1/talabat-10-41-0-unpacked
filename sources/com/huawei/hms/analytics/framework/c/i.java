package com.huawei.hms.analytics.framework.c;

import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.storage.Event;
import com.huawei.hms.analytics.core.storage.IStorageHandler;
import com.huawei.hms.analytics.core.transport.net.HttpTransportHandler;
import com.huawei.hms.analytics.framework.b.b;
import com.huawei.hms.analytics.framework.c.a.a;
import com.huawei.hms.analytics.framework.config.ICallback;
import com.huawei.hms.analytics.framework.config.ICollectorConfig;
import com.huawei.hms.analytics.framework.config.IMandatoryParameters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    ICallback f47980a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f47981b;

    /* renamed from: c  reason: collision with root package name */
    private List<Event> f47982c;

    /* renamed from: d  reason: collision with root package name */
    private a f47983d;

    public i(byte[] bArr, a aVar, List<Event> list) {
        this.f47981b = bArr != null ? (byte[]) bArr.clone() : null;
        this.f47982c = list;
        this.f47983d = aVar;
    }

    private String[] a() {
        String[] serviceUrls = this.f47983d.f47944c.getServiceUrls();
        for (int i11 = 0; i11 < serviceUrls.length; i11++) {
            if (!"oper".equals(this.f47983d.f47943b)) {
                if ("maint".equals(this.f47983d.f47943b)) {
                    serviceUrls[i11] = "{url}/common/hmshimaintqrt".replace("{url}", serviceUrls[i11]);
                } else if ("diffprivacy".equals(this.f47983d.f47943b)) {
                    serviceUrls[i11] = "{url}/common/common2".replace("{url}", serviceUrls[i11]);
                } else if ("preins".equals(this.f47983d.f47943b)) {
                    serviceUrls[i11] = "{url}/common/hmshioperbatch".replace("{url}", serviceUrls[i11]);
                }
            }
            serviceUrls[i11] = "{url}/common/hmshioperqrt".replace("{url}", serviceUrls[i11]);
        }
        return serviceUrls;
    }

    public final void run() {
        IStorageHandler a11;
        List<Event> list;
        HiLog.d("SendMission", "send data running");
        long currentTimeMillis = System.currentTimeMillis();
        HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
        IMandatoryParameters iMandatoryParameters = b.a().f47924a;
        httpTransportHandler.setUrls(a());
        httpTransportHandler.setRequestMethod("POST");
        httpTransportHandler.setReportData(this.f47981b);
        ICollectorConfig a12 = b.a().a(this.f47983d.f47942a);
        String str = this.f47983d.f47945d;
        ICollectorConfig a13 = b.a().a(this.f47983d.f47942a);
        String appVer = b.a().f47924a.getAppVer();
        String model = b.a().f47924a.getModel();
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", a13.getAppId());
        hashMap.put("App-Ver", appVer);
        hashMap.put("Sdk-Name", "hianalytics");
        hashMap.put("Sdk-Ver", "6.9.0.302");
        hashMap.put("Device-Type", model);
        hashMap.put("servicetag", this.f47983d.f47942a);
        HiLog.i("SendMission", "sendData RequestId : ".concat(String.valueOf(str)));
        hashMap.put("Request-Id", str);
        Map<String, String> httpHeader = a12.getHttpHeader(this.f47983d.f47943b);
        if (httpHeader != null) {
            hashMap.putAll(httpHeader);
        }
        httpTransportHandler.setHttpHeaders(hashMap);
        httpTransportHandler.setContext(iMandatoryParameters.getContext());
        int httpCode = httpTransportHandler.execute().getHttpCode();
        if (httpCode == 200) {
            try {
                a aVar = this.f47983d;
                if (!aVar.f47946e && !aVar.f47947f && (a11 = com.huawei.hms.analytics.framework.a.a.a(aVar.f47942a)) != null && (list = this.f47982c) != null && list.size() > 0) {
                    HiLog.i("SendMission", "storageHandler deleteEvents");
                    a11.deleteEvents(this.f47982c);
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                ICallback iCallback = this.f47980a;
                if (iCallback != null) {
                    iCallback.onResult(httpCode, currentTimeMillis, this.f47983d.f47947f ? -2 : 0, this.f47982c);
                }
                a aVar2 = this.f47983d;
                HiLog.i("SendMission", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f47983d.f47945d, aVar2.f47943b, aVar2.f47942a, Integer.valueOf(httpCode));
                throw th3;
            }
        }
        ICallback iCallback2 = this.f47980a;
        if (iCallback2 != null) {
            iCallback2.onResult(httpCode, currentTimeMillis, this.f47983d.f47947f ? -2 : 0, this.f47982c);
        }
        a aVar3 = this.f47983d;
        HiLog.i("SendMission", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f47983d.f47945d, aVar3.f47943b, aVar3.f47942a, Integer.valueOf(httpCode));
    }
}
