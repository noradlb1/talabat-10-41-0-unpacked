package com.instabug.apm.model;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.huawei.hms.flutter.map.constants.Param;
import com.visa.checkout.Profile;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Keep
@Retention(RetentionPolicy.SOURCE)
public @interface LogLevel {
    public static final int DEBUG = 4;
    public static final int ERROR = 1;
    public static final int INFO = 3;
    public static final int NONE = 0;
    public static final int VERBOSE = 5;
    public static final int WARNING = 2;

    public static final class a {
        @NonNull
        public static String a(int i11) {
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "UNKNOWN" : "VERBOSE" : "DEBUG" : "INFO" : "WARNING" : Param.ERROR : Profile.DataLevel.NONE;
        }
    }
}
