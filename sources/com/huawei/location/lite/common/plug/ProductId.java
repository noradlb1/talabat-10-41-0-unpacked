package com.huawei.location.lite.common.plug;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface ProductId {
    @ProductPlugPath(paths = {"com.huawei.location.common.LocationCommonPluginImpl"})
    public static final int HMS_COMMON = 102;
}
