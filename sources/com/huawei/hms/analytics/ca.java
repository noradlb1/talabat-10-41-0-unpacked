package com.huawei.hms.analytics;

import com.huawei.hms.analytics.framework.config.IConfig;

public final class ca implements IConfig {
    private final String[] klm;
    private final String lmn;

    public ca(String str, String[] strArr) {
        this.lmn = str;
        this.klm = strArr != null ? (String[]) strArr.clone() : new String[0];
    }

    public final String[] getServiceUrls() {
        return (String[]) this.klm.clone();
    }

    public final String getSite() {
        return this.lmn;
    }
}
