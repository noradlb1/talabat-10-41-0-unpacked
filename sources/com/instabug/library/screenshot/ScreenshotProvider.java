package com.instabug.library.screenshot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.Toast;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.instacapture.d;
import com.instabug.library.internal.video.RequestPermissionActivityLauncher;
import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.memory.MemoryUtils;
import hd.c;
import java.util.concurrent.Callable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ScreenshotProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ScreenshotProvider f51730a = new ScreenshotProvider();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Callable f51731b;

    public interface ScreenshotCapturingListener {
        void onScreenshotCapturedSuccessfully(@NotNull Bitmap bitmap);

        void onScreenshotCapturingFailed(@NotNull Throwable th2);
    }

    private ScreenshotProvider() {
    }

    @JvmStatic
    public static final void a(@Nullable Callable callable) {
        f51731b = callable;
    }

    @JvmStatic
    public static final synchronized void a(@Nullable Activity activity, @NotNull ScreenshotCapturingListener screenshotCapturingListener) {
        synchronized (ScreenshotProvider.class) {
            Intrinsics.checkNotNullParameter(screenshotCapturingListener, "screenshotCapturingListener");
            if (activity == null || activity.isFinishing()) {
                screenshotCapturingListener.onScreenshotCapturingFailed(new Exception("Can't capture screenshot due to null activity"));
            } else if (MemoryUtils.isLowMemory(activity)) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't take initial screenshot due to low memory");
                screenshotCapturingListener.onScreenshotCapturingFailed(new Throwable("Your activity is currently in low memory"));
                Toast.makeText(activity, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(activity), R.string.instabug_str_capturing_screenshot_error, activity), 0).show();
            } else {
                InstabugSDKLogger.d("IBG-Core", "start capture screenshot");
                try {
                    Callable callable = f51731b;
                    if (callable == null) {
                        d.a(activity).a(new g(screenshotCapturingListener), R.id.instabug_decor_view, R.id.instabug_extra_screenshot_button, R.id.instabug_floating_button, R.id.instabug_in_app_notification, R.id.instabug_intro_dialog);
                    } else {
                        InstabugSDKLogger.i("IBG-Core", "Using the supplied screenshotProvider to capture the screenshot");
                        activity.runOnUiThread(new c(screenshotCapturingListener, callable));
                    }
                } catch (OutOfMemoryError e11) {
                    screenshotCapturingListener.onScreenshotCapturingFailed(e11);
                } catch (Exception e12) {
                    screenshotCapturingListener.onScreenshotCapturingFailed(e12);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(ScreenshotCapturingListener screenshotCapturingListener, Callable callable) {
        Intrinsics.checkNotNullParameter(screenshotCapturingListener, "$screenshotCapturingListener");
        Intrinsics.checkNotNullParameter(callable, "$it");
        Object call = callable.call();
        Intrinsics.checkNotNullExpressionValue(call, "it.call()");
        screenshotCapturingListener.onScreenshotCapturedSuccessfully((Bitmap) call);
    }

    @JvmStatic
    public static final synchronized void a(boolean z11, @Nullable Activity activity, @NotNull ScreenshotCapturingListener screenshotCapturingListener) {
        synchronized (ScreenshotProvider.class) {
            Intrinsics.checkNotNullParameter(screenshotCapturingListener, "screenshotCapturingListener");
            InstabugSDKLogger.d("IBG-Core", "start capture screenshot Using MediaProjection");
            if (activity != null && !activity.isFinishing()) {
                if (SettingsManager.getInstance().isScreenCurrentlyRecorded()) {
                    AutoScreenRecordingEventBus.getInstance().post(ScreenRecordingService.Action.STOP_TRIM_KEEP);
                }
                RequestPermissionActivityLauncher.start(activity, false, z11, screenshotCapturingListener);
            }
        }
    }
}
