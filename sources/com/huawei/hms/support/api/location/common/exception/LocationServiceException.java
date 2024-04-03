package com.huawei.hms.support.api.location.common.exception;

public class LocationServiceException extends BaseException {
    private static final long serialVersionUID = -856689149107230903L;

    public LocationServiceException(int i11, String str) {
        super(i11, str);
    }

    public LocationServiceException(int i11, String str, Throwable th2) {
        super(i11, str, th2);
    }
}
