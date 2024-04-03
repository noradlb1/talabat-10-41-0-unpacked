package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;

public class s extends BaseReportMsgBuilder {
    public String getEventId() {
        return "credentialFromString";
    }
}
