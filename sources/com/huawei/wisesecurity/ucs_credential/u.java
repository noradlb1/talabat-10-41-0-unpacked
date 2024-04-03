package com.huawei.wisesecurity.ucs_credential;

import android.content.Context;
import com.huawei.wisesecurity.kfs.ha.HaReporter;
import com.huawei.wisesecurity.kfs.ha.message.ReportMsgBuilder;
import com.huawei.wisesecurity.ucs.common.report.BaseReporter;
import com.huawei.wisesecurity.ucs.common.report.ReportOption;
import com.huawei.wisesecurity.ucs.credential.outer.HACapability;

public class u extends BaseReporter implements HACapability {

    /* renamed from: a  reason: collision with root package name */
    public static HaReporter f44889a;

    public u(l lVar, ReportOption reportOption) {
        super(lVar.a(), reportOption);
    }

    public String getLogTag() {
        return "UCS-Credential";
    }

    public String getReporterTag() {
        return HACapability.UCS_CREDENTIAL_HA_SERVICE_TAG;
    }

    public void onEvent(Context context, String str, ReportMsgBuilder reportMsgBuilder) {
        synchronized (u.class) {
            if (f44889a == null) {
                f44889a = getInstance(context, HACapability.UCS_CREDENTIAL_HA_SERVICE_TAG, "UCS-Credential");
            }
            HaReporter haReporter = f44889a;
            if (haReporter != null) {
                setOobeCheck(haReporter);
                f44889a.onEvent(context, reportMsgBuilder);
            }
        }
    }
}
