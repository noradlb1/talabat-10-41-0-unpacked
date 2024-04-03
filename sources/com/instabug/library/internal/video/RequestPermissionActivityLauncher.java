package com.instabug.library.internal.video;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.instabug.library.screenshot.ScreenshotProvider;

public class RequestPermissionActivityLauncher {
    public static void start(Activity activity, boolean z11, boolean z12, @Nullable ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener) {
        Intent intent = new Intent(activity, RequestPermissionActivity.class);
        intent.putExtra("isVideo", z11);
        intent.putExtra("isInitial", z12);
        activity.overridePendingTransition(0, 0);
        activity.startActivityForResult(intent, RequestPermissionActivity.REQUEST_MEDIA_PROJECTION_PERMISSION);
        RequestPermissionActivity.f51125k = screenshotCapturingListener;
    }
}
