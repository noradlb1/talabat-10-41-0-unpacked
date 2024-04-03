package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AdInspectorError extends AdError {
    public static final int ERROR_CODE_ALREADY_OPEN = 3;
    public static final int ERROR_CODE_FAILED_TO_LOAD = 1;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_NOT_IN_TEST_MODE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdInspectorErrorCode {
    }

    public AdInspectorError(int i11, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        super(i11, str, str2);
    }

    public int getCode() {
        return super.getCode();
    }
}
