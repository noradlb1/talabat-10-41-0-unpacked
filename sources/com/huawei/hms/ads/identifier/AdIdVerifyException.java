package com.huawei.hms.ads.identifier;

import android.support.annotation.Keep;

@Keep
public class AdIdVerifyException extends Exception {
    public AdIdVerifyException(String str) {
        super(str);
    }
}
