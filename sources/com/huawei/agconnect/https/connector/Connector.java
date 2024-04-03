package com.huawei.agconnect.https.connector;

public interface Connector {
    boolean hasActiveNetwork();

    void logger(String str, String str2);
}
