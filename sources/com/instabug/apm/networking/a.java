package com.instabug.apm.networking;

public class a extends Exception {
    public a(String str) {
        super("APM sync request error - " + str);
    }
}
