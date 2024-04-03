package com.huawei.hms.analytics;

import android.os.Looper;
import com.huawei.hms.analytics.core.transport.CallbackListener;
import com.huawei.hms.analytics.core.transport.ITransportHandler;
import com.huawei.hms.analytics.core.transport.net.HttpTransportHandler;
import com.huawei.hms.analytics.core.transport.net.Response;
import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.HashMap;
import java.util.Map;

public abstract class ci implements CallbackListener {
    private final CallbackListener hij = this;
    protected IConfig ijk;
    protected cj ikl;
    public final String klm;
    private final String lmn;

    public ci(cj cjVar, String str, String str2, IConfig iConfig) {
        this.ikl = cjVar;
        this.klm = str;
        this.lmn = str2;
        this.ijk = iConfig;
    }

    public final String[] ikl() {
        String[] serviceUrls = this.ijk.getServiceUrls();
        int length = serviceUrls.length;
        for (int i11 = 0; i11 < length; i11++) {
            serviceUrls[i11] = serviceUrls[i11] + this.lmn;
        }
        return serviceUrls;
    }

    public void klm() {
        HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
        httpTransportHandler.setUrls(ikl());
        httpTransportHandler.setRequestMethod(this.klm);
        httpTransportHandler.setContext(av.lmn().lmn.ghi);
        httpTransportHandler.setHttpHeaders(lmn());
        lmn((ITransportHandler) httpTransportHandler);
    }

    public Map<String, String> lmn() {
        ax axVar = av.lmn().lmn;
        HashMap hashMap = new HashMap();
        hashMap.put("App-Id", axVar.f47867n.klm);
        hashMap.put("x-hasdk-productid", axVar.f47867n.ikl);
        hashMap.put("x-hasdk-resourceid", axVar.f47867n.ijk);
        hashMap.put("x-hasdk-token", axVar.hij);
        hashMap.put("x-hasdk-clientid", axVar.f47867n.ghi);
        hashMap.put("Sdk-Ver", "6.9.0.302");
        return hashMap;
    }

    public final void lmn(int i11) {
        this.ikl.klm = String.valueOf(i11);
        ck.lmn(this.ikl);
    }

    public final void lmn(ITransportHandler iTransportHandler) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iTransportHandler.execute(this.hij);
            return;
        }
        Response execute = iTransportHandler.execute();
        int httpCode = execute.getHttpCode();
        if (200 == httpCode) {
            this.hij.onSuccess(execute);
        } else {
            this.hij.onFailure(httpCode);
        }
    }
}
