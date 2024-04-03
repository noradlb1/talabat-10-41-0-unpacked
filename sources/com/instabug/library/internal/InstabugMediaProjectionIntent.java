package com.instabug.library.internal;

import android.content.Intent;
import androidx.annotation.Nullable;

public class InstabugMediaProjectionIntent {
    @Nullable
    private static Intent mediaProjectionIntent;
    private static int staticResultCode;

    @Nullable
    public static Intent getMediaProjectionIntent() {
        return mediaProjectionIntent;
    }

    public static int getStaticResultCode() {
        return staticResultCode;
    }

    public static void release() {
        mediaProjectionIntent = null;
        staticResultCode = -1;
    }

    public static void setMediaProjectionIntent(@Nullable Intent intent) {
        mediaProjectionIntent = intent;
    }

    public static void setStaticResultCode(int i11) {
        staticResultCode = i11;
    }
}
