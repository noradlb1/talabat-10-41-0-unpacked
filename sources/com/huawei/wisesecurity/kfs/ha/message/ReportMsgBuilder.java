package com.huawei.wisesecurity.kfs.ha.message;

import java.util.LinkedHashMap;

public interface ReportMsgBuilder {
    LinkedHashMap<String, String> build();

    String getEventId();
}
