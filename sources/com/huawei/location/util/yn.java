package com.huawei.location.util;

import com.huawei.hms.location.api.request.BaseLocationReq;
import com.huawei.location.lite.common.report.ReportBuilder;
import com.huawei.location.lite.common.report.Tracker;
import com.huawei.location.lite.common.util.APKUtil;

public class yn {

    /* renamed from: yn  reason: collision with root package name */
    private ReportBuilder f50267yn;

    /* renamed from: com.huawei.location.util.yn$yn  reason: collision with other inner class name */
    public static class C0091yn {

        /* renamed from: yn  reason: collision with root package name */
        private ReportBuilder f50268yn = new ReportBuilder();

        public C0091yn yn(BaseLocationReq baseLocationReq) {
            if (baseLocationReq != null) {
                this.f50268yn.setTransactionID(baseLocationReq.getLocTransactionId());
                this.f50268yn.setPackage(baseLocationReq.getPackageName());
                this.f50268yn.setCpAppVersion(String.valueOf(APKUtil.getThirdAppVersionCode(baseLocationReq.getPackageName())));
            }
            return this;
        }

        public C0091yn yn(String str) {
            this.f50268yn.setApiName(str);
            return this;
        }

        public yn yn() {
            return new yn(this.f50268yn);
        }
    }

    public yn(ReportBuilder reportBuilder) {
        this.f50267yn = reportBuilder;
    }

    public void Vw(String str) {
        this.f50267yn.setResult(str);
        this.f50267yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.f50267yn);
        Tracker.getInstance().onOperationEvent(this.f50267yn);
        this.f50267yn.setCallTime();
    }

    public void yn(String str) {
        this.f50267yn.setErrorCode(str);
        this.f50267yn.setCostTime();
        Tracker.getInstance().onMaintEvent(this.f50267yn);
        Tracker.getInstance().onOperationEvent(this.f50267yn);
    }
}
