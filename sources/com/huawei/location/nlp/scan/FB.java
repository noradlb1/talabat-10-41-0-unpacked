package com.huawei.location.nlp.scan;

import com.huawei.location.nlp.network.request.wifi.WifiInfo;
import java.util.Comparator;

class FB implements Comparator<WifiInfo> {
    public FB(LW lw2) {
    }

    public int compare(Object obj, Object obj2) {
        WifiInfo wifiInfo = (WifiInfo) obj;
        WifiInfo wifiInfo2 = (WifiInfo) obj2;
        if (!(wifiInfo == null && wifiInfo2 == null)) {
            if (wifiInfo != null) {
                if (wifiInfo2 == null || wifiInfo.getTime() > wifiInfo2.getTime() || (wifiInfo.getTime() == wifiInfo2.getTime() && wifiInfo.getRssi() > wifiInfo2.getRssi())) {
                    return -1;
                }
                if (!(wifiInfo.getTime() == wifiInfo2.getTime() && wifiInfo.getRssi() == wifiInfo2.getRssi())) {
                    return 1;
                }
            }
            return 1;
        }
        return 0;
    }
}
