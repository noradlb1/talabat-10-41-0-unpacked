package com.huawei.agconnect.exception;

public class AGCNetworkException extends AGCException {
    public static final int NETWORK_UNAVAILABLE = 0;
    public static final int SERVER_NOT_REACH = 1;

    public AGCNetworkException(String str, int i11) {
        super(str, i11);
    }
}
