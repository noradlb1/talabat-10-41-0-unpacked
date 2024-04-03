package com.instabug.library.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.instabug.library.R;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.memory.MemoryUtils;

public class InitialScreenshotHelper {
    /* access modifiers changed from: private */
    public static Uri screenshotUri;

    public interface InitialScreenshotCapturingListener {
        void onScreenshotCapturedSuccessfully(Uri uri);

        void onScreenshotCapturingFailed(Throwable th2);
    }

    public class a implements ScreenshotProvider.ScreenshotCapturingListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f34176a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InitialScreenshotCapturingListener f34177b;

        public a(Activity activity, InitialScreenshotCapturingListener initialScreenshotCapturingListener) {
            this.f34176a = activity;
            this.f34177b = initialScreenshotCapturingListener;
        }

        public void onScreenshotCapturedSuccessfully(Bitmap bitmap) {
            InitialScreenshotHelper.saveBitmap(bitmap, this.f34176a, this.f34177b);
        }

        public void onScreenshotCapturingFailed(Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "initial screenshot capturing got error: " + th2.getMessage());
            this.f34177b.onScreenshotCapturingFailed(th2);
        }
    }

    public class b implements ScreenshotProvider.ScreenshotCapturingListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f34178a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InitialScreenshotCapturingListener f34179b;

        public b(Activity activity, InitialScreenshotCapturingListener initialScreenshotCapturingListener) {
            this.f34178a = activity;
            this.f34179b = initialScreenshotCapturingListener;
        }

        public void onScreenshotCapturedSuccessfully(Bitmap bitmap) {
            InitialScreenshotHelper.saveBitmap(bitmap, this.f34178a, this.f34179b);
        }

        public void onScreenshotCapturingFailed(Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "initial screenshot capturing got error: " + th2.getMessage());
            this.f34179b.onScreenshotCapturingFailed(th2);
        }
    }

    public class c implements BitmapUtils.OnSaveBitmapCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ InitialScreenshotCapturingListener f34180a;

        public c(InitialScreenshotCapturingListener initialScreenshotCapturingListener) {
            this.f34180a = initialScreenshotCapturingListener;
        }

        public void onError(Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "initial screenshot capturing got error: " + th2.getMessage());
            this.f34180a.onScreenshotCapturingFailed(th2);
        }

        public void onSuccess(Uri uri) {
            Uri unused = InitialScreenshotHelper.screenshotUri = uri;
            this.f34180a.onScreenshotCapturedSuccessfully(uri);
        }
    }

    public static void captureScreenshot(@NonNull InitialScreenshotCapturingListener initialScreenshotCapturingListener) {
        Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
        if (targetActivity != null) {
            if (MemoryUtils.isLowMemory(targetActivity)) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't take initial screenshot due to low memory");
                initialScreenshotCapturingListener.onScreenshotCapturingFailed(new Throwable("Your activity is currently in low memory"));
                Toast.makeText(targetActivity, LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(targetActivity), R.string.instabug_str_capturing_screenshot_error, targetActivity), 0).show();
            } else if (isUsingMediaProjection()) {
                ScreenshotProvider.a(true, targetActivity, new a(targetActivity, initialScreenshotCapturingListener));
            } else {
                ScreenshotProvider.a(targetActivity, (ScreenshotProvider.ScreenshotCapturingListener) new b(targetActivity, initialScreenshotCapturingListener));
            }
        }
    }

    private static boolean isUsingMediaProjection() {
        return SettingsManager.getInstance().isScreenshotByMediaProjectionEnabled();
    }

    /* access modifiers changed from: private */
    public static void saveBitmap(Bitmap bitmap, Activity activity, InitialScreenshotCapturingListener initialScreenshotCapturingListener) {
        BitmapUtils.saveBitmap(bitmap, activity, new c(initialScreenshotCapturingListener));
    }
}
