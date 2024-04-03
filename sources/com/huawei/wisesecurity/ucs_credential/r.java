package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;

public class r extends BaseReportMsgBuilder {
    public String getEventId() {
        return "applyCredential";
    }
}
