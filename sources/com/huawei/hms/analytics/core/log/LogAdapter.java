package com.huawei.hms.analytics.core.log;

public interface LogAdapter {
    void init(int i11, String str);

    boolean isLoggable(int i11);

    void println(int i11, String str, String str2);

    void println(int i11, String str, String str2, String str3);
}
