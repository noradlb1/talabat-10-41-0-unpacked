package com.huawei.hms.dtm.core.util;

import android.text.TextUtils;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public class l {
    public static String a(String str) {
        if (TextUtils.isEmpty(str) || !str.contains(RealDiscoveryConfigurationRepository.VERSION_DELIMETER)) {
            return str;
        }
        String[] split = str.split("\\.");
        return split.length > 1 ? split[1] : str;
    }
}
