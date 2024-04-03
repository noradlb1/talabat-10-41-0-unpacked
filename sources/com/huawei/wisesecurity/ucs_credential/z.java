package com.huawei.wisesecurity.ucs_credential;

import java.util.HashMap;
import java.util.Map;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f44914a = new HashMap();

    public String toString() {
        if (this.f44914a.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : this.f44914a.entrySet()) {
            sb2.append((String) next.getKey());
            sb2.append("=");
            sb2.append((String) next.getValue());
            sb2.append(",");
        }
        sb2.deleteCharAt(sb2.lastIndexOf(","));
        return sb2.toString();
    }
}
