package com.huawei.location.lite.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface ComponentType {
    public static final int LOCATION_APK_IN_HMS = 200;
    public static final int LOCATION_SDK = 100;
}
