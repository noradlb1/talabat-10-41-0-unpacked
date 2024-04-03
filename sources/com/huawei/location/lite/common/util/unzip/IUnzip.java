package com.huawei.location.lite.common.util.unzip;

import java.util.List;

public interface IUnzip {
    boolean doUnzip(String str, String str2);

    boolean doUnzip(String str, String str2, List<String> list, List<String> list2);

    boolean isSupportUnZip(String str);
}
