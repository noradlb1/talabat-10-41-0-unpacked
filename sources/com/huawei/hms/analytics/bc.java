package com.huawei.hms.analytics;

import com.huawei.hms.analytics.framework.config.IConfig;
import java.util.HashMap;
import java.util.Map;

public final class bc {
    private final Map<String, String> efg = new HashMap();
    private final Map<String, IConfig> fgh = new HashMap();
    public String ghi;
    public String hij;
    public String ijk;
    public String ikl;
    public String klm;
    public Map<String, String[]> lmn;

    public final IConfig klm(String str) {
        return this.fgh.get(str);
    }

    public final String lmn(String str) {
        return this.efg.containsKey(str) ? this.efg.get(str) : this.hij;
    }

    public final void lmn(String str, IConfig iConfig) {
        this.fgh.put(str, iConfig);
        lmn(str, iConfig.getSite());
    }

    public final void lmn(String str, String str2) {
        this.efg.put(str, str2);
    }
}
