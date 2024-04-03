package com.huawei.location.lite.common.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface LocationSecurityType {
    public static final int BASE_SECURITY_TYPE_FLAG = 0;
    public static final int SECURITY_TYPE_FLAG_AES = 3;
    public static final int SECURITY_TYPE_FLAG_SM4 = 1;
    public static final int SECURITY_TYPE_FLAG_SM4_GCM = 2;
    public static final int SECURITY_TYPE_FLAG_THREE = 4;
}
