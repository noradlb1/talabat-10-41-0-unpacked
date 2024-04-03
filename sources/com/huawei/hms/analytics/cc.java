package com.huawei.hms.analytics;

import android.text.TextUtils;
import com.huawei.hms.analytics.core.log.HiLog;
import com.huawei.hms.analytics.core.transport.net.Response;
import com.huawei.hms.analytics.framework.config.IConfig;

public final class cc extends ci {
    public lmn lmn;

    public interface lmn {
        void lmn();
    }

    public cc(IConfig iConfig) {
        super(ck.lmn("GETInstanceEventRequest#execute"), "GET", "/analytics/api/events/online", iConfig);
        new dy().lmn();
    }

    public final void klm() {
        super.klm();
    }

    public final void onFailure(int i11) {
        HiLog.w("InstanceRequest", "GET instance event exception,errorCode: ".concat(String.valueOf(i11)));
        lmn(i11);
    }

    public final void onSuccess(Response response) {
        lmn lmn2;
        this.ikl.lmn = "0";
        lmn(response.getHttpCode());
        if (response.getHttpCode() == 200) {
            HiLog.i("InstanceRequest", "get instance events result code : " + response.getHttpCode());
            String content = response.getContent();
            ax axVar = av.lmn().lmn;
            if (TextUtils.isEmpty(content)) {
                HiLog.i("InstanceRequest", "instance events config is empty");
                axVar.f47871r = null;
                dv.lmn(axVar.ghi, "global_v2", "instance_event_info");
                return;
            }
            az lmn3 = ch.lmn(axVar.ghi, content);
            if (lmn3 != null) {
                av.lmn().lmn.f47871r = lmn3;
                if (lmn3.ghi && (lmn2 = this.lmn) != null) {
                    lmn2.lmn();
                }
            }
        }
    }
}
