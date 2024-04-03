package com.huawei.wisesecurity.ucs_credential;

import com.huawei.wisesecurity.kfs.ha.message.BaseReportMsgBuilder;

public class t extends BaseReportMsgBuilder {
    public t a() {
        this.linkedHashMap.put("flavor", "developers");
        return this;
    }

    public String getEventId() {
        return "crypto";
    }
}
