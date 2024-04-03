package com.huawei.location.lite.common.util;

import com.huawei.secure.android.common.util.SafeString;
import java.util.SortedMap;
import java.util.TreeMap;

public class CanonicalQueryString {
    private static final int INIT_BUFFER_SIZE = 128;
    private static final String PARAMETER_EQ = "=";
    private static final String PARAMETER_SEP = "&";
    private SortedMap<String, String> params = new TreeMap();

    public CanonicalQueryString(String str) {
        if (str != null && str.length() > 0) {
            for (String str2 : str.split("&")) {
                int indexOf = str2.indexOf("=");
                if (indexOf != -1) {
                    this.params.put(SafeString.substring(str2, 0, indexOf), SafeString.substring(str2, indexOf + 1));
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        for (String next : this.params.keySet()) {
            if (sb2.length() > 0) {
                sb2.append("&");
            }
            sb2.append(next);
            sb2.append("=");
            sb2.append(this.params.get(next));
        }
        return sb2.toString();
    }
}
