package com.google.android.datatransport.runtime.dagger.internal;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;

public final class Preconditions {
    private Preconditions() {
    }

    public static <T> void checkBuilderRequirement(T t11, Class<T> cls) {
        if (t11 == null) {
            throw new IllegalStateException(cls.getCanonicalName() + " must be set");
        }
    }

    public static <T> T checkNotNull(T t11) {
        t11.getClass();
        return t11;
    }

    public static <T> T checkNotNull(T t11, String str) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(str);
    }

    public static <T> T checkNotNull(T t11, String str, Object obj) {
        String str2;
        if (t11 != null) {
            return t11;
        }
        if (!str.contains(LogWriteConstants.LOCATION_MSG_FORMAT)) {
            throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
        } else if (str.indexOf(LogWriteConstants.LOCATION_MSG_FORMAT) == str.lastIndexOf(LogWriteConstants.LOCATION_MSG_FORMAT)) {
            if (obj instanceof Class) {
                str2 = ((Class) obj).getCanonicalName();
            } else {
                str2 = String.valueOf(obj);
            }
            throw new NullPointerException(str.replace(LogWriteConstants.LOCATION_MSG_FORMAT, str2));
        } else {
            throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
        }
    }
}
