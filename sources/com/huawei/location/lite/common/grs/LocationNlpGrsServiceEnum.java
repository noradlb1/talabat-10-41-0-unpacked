package com.huawei.location.lite.common.grs;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.SOURCE)
public @interface LocationNlpGrsServiceEnum {
    public static final String AGREE_SERVICE = "AGREEMENTROUTE";
    public static final String CONFIG_SERVER = "com.huawei.configserver";
    public static final String DNKEEPER = "com.huawei.dnkeeper";
    public static final String EXT_SERVICE = "com.huawei.location.extService";
    public static final String HIANALYTICS = "HIANALYTICROUTE";
    public static final String HIGEO = "HIGEOROUTE";
    public static final String LOCATION = "com.huawei.hms.location";
    public static final String LOG_SERVICE = "LOGSERVERROUTE";
    public static final String MAP_SERVICE = "MAPROUTE";
    public static final String OOBE = "com.huawei.hms.oobe";
    public static final String SITE = "SITEROUTE";
    public static final String TSMS_SERVICE = "com.huawei.tsms";
}
