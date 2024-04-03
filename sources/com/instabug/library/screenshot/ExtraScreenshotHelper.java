package com.instabug.library.screenshot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.instabug.library.PresentationManager;
import com.instabug.library.R;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.Colorizer;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.instabug.library.util.ScreenUtility;
import com.instabug.library.view.ViewUtils;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;

public class ExtraScreenshotHelper {
    @Nullable
    private WeakReference<ImageButton> captureButtonWeakReference;
    @Nullable
    private Disposable currentActivityLifeCycleDisposable;
    private boolean isCaptureButtonShown = false;
    @Nullable
    private OnCaptureListener onCaptureListener;

    public interface OnCaptureListener {
        void onExtraScreenshotCaptured(Uri uri);

        void onExtraScreenshotError(Throwable th2);
    }

    public class a implements ScreenshotProvider.ScreenshotCapturingListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f51712a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnCaptureListener f51713b;

        public a(Activity activity, OnCaptureListener onCaptureListener) {
            this.f51712a = activity;
            this.f51713b = onCaptureListener;
        }

        public void onScreenshotCapturedSuccessfully(Bitmap bitmap) {
            Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                BitmapUtils.maskBitmap(currentActivity, bitmap, SettingsManager.getInstance(), (Canvas) null);
                BitmapUtils.saveBitmap(bitmap, this.f51712a, new b(this));
            }
        }

        public void onScreenshotCapturingFailed(Throwable th2) {
            OnCaptureListener onCaptureListener = this.f51713b;
            if (onCaptureListener != null) {
                onCaptureListener.onExtraScreenshotError(th2);
            }
            ExtraScreenshotHelper.this.reset();
            InstabugSDKLogger.e("IBG-Core", "Error capturing screenshot" + th2.getMessage());
        }
    }

    public class b implements ScreenshotProvider.ScreenshotCapturingListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f51715a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ OnCaptureListener f51716b;

        public b(ExtraScreenshotHelper extraScreenshotHelper, Activity activity, OnCaptureListener onCaptureListener) {
            this.f51715a = activity;
            this.f51716b = onCaptureListener;
        }

        public void onScreenshotCapturedSuccessfully(Bitmap bitmap) {
            BitmapUtils.saveBitmap(bitmap, this.f51715a, new c(this));
        }

        public void onScreenshotCapturingFailed(Throwable th2) {
            OnCaptureListener onCaptureListener = this.f51716b;
            if (onCaptureListener != null) {
                onCaptureListener.onExtraScreenshotError(th2);
            }
            InstabugSDKLogger.e("IBG-Core", "Error while capturing screenshot" + th2.getMessage());
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f51717a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.instabug.library.tracking.ActivityLifeCycleEvent[] r0 = com.instabug.library.tracking.ActivityLifeCycleEvent.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f51717a = r0
                com.instabug.library.tracking.ActivityLifeCycleEvent r1 = com.instabug.library.tracking.ActivityLifeCycleEvent.RESUMED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f51717a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.tracking.ActivityLifeCycleEvent r1 = com.instabug.library.tracking.ActivityLifeCycleEvent.PAUSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.screenshot.ExtraScreenshotHelper.c.<clinit>():void");
        }
    }

    private void captureExtraScreenshot(Activity activity, @Nullable OnCaptureListener onCaptureListener2) {
        if (isUsingMediaProjection()) {
            f.f51740c.b(new a(activity, onCaptureListener2));
        } else {
            ScreenshotProvider.a(activity, (ScreenshotProvider.ScreenshotCapturingListener) new b(this, activity, onCaptureListener2));
        }
    }

    private ImageButton createCaptureButton(Activity activity) {
        ImageButton imageButton = new ImageButton(activity);
        imageButton.setId(R.id.instabug_extra_screenshot_button);
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
        imageButton.setContentDescription(LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(imageButton.getContext()), R.string.ibg_extra_screenshot_button_content_description, imageButton.getContext()));
        Drawable drawable = ContextCompat.getDrawable(activity, R.drawable.ibg_core_bg_white_oval);
        Drawable drawable2 = AppCompatResources.getDrawable(activity, R.drawable.ibg_core_ic_screenshot);
        if (drawable != null) {
            imageButton.setBackgroundDrawable(Colorizer.getPrimaryColorTintedDrawable(drawable));
        }
        if (drawable2 != null) {
            imageButton.setImageDrawable(drawable2);
        }
        return imageButton;
    }

    private FrameLayout.LayoutParams createCaptureButtonContainer(Activity activity) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, 81);
        layoutParams.setMargins(0, 0, 0, 20);
        Resources resources = activity.getResources();
        if (ScreenUtility.hasNavBar(activity) && !ScreenUtility.isLandscape(activity)) {
            layoutParams.bottomMargin += ScreenUtility.getNavigationBarHeight(resources);
        }
        return layoutParams;
    }

    private void handleCurrentActivityPauseEvent() {
        hide();
    }

    private void handleCurrentActivityResumeEvent() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            show(currentActivity);
        } else {
            InstabugSDKLogger.v("IBG-Core", "Couldn't handle resume event current activity equal null");
        }
    }

    private void hide() {
        WeakReference<ImageButton> weakReference = this.captureButtonWeakReference;
        if (weakReference != null) {
            ImageButton imageButton = weakReference.get();
            if (this.isCaptureButtonShown && imageButton != null && imageButton.getParent() != null && (imageButton.getParent() instanceof ViewGroup)) {
                ((ViewGroup) imageButton.getParent()).removeView(imageButton);
                this.isCaptureButtonShown = false;
            }
        }
    }

    private boolean isUsingMediaProjection() {
        return SettingsManager.getInstance().isScreenshotByMediaProjectionEnabled();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$show$0(Activity activity, View view) {
        hide();
        captureExtraScreenshot(activity, this.onCaptureListener);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$subscribeToCurranActivityLifeCycle$1(ActivityLifeCycleEvent activityLifeCycleEvent) throws Exception {
        int i11 = c.f51717a[activityLifeCycleEvent.ordinal()];
        if (i11 == 1) {
            handleCurrentActivityResumeEvent();
        } else if (i11 == 2) {
            handleCurrentActivityPauseEvent();
        }
    }

    /* access modifiers changed from: private */
    public void reset() {
        hide();
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            show(currentActivity);
        }
    }

    private void show(@NonNull Activity activity) {
        if (!this.isCaptureButtonShown && !SettingsManager.getInstance().isProcessingForeground()) {
            ImageButton createCaptureButton = createCaptureButton(activity);
            ViewCompat.setElevation(createCaptureButton, (float) ViewUtils.convertDpToPx(activity.getApplicationContext(), 5.0f));
            ((ViewGroup) activity.getWindow().getDecorView()).addView(createCaptureButton, createCaptureButtonContainer(activity));
            this.isCaptureButtonShown = true;
            createCaptureButton.setOnClickListener(new hd.b(this, activity));
            this.captureButtonWeakReference = new WeakReference<>(createCaptureButton);
        }
    }

    private void subscribeToCurranActivityLifeCycle() {
        if (this.currentActivityLifeCycleDisposable == null) {
            this.currentActivityLifeCycleDisposable = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new hd.a(this));
        }
    }

    public void cancel() {
        hide();
        release();
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public void init(OnCaptureListener onCaptureListener2) {
        this.onCaptureListener = onCaptureListener2;
        subscribeToCurranActivityLifeCycle();
        InvocationManager.getInstance().switchOffInvocation();
        PresentationManager.getInstance().setInInstabugContext(true);
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void release() {
        ImageButton imageButton;
        WeakReference<ImageButton> weakReference = this.captureButtonWeakReference;
        if (!(weakReference == null || (imageButton = weakReference.get()) == null)) {
            imageButton.setOnClickListener((View.OnClickListener) null);
        }
        this.captureButtonWeakReference = null;
        this.onCaptureListener = null;
        Disposable disposable = this.currentActivityLifeCycleDisposable;
        if (disposable != null && !disposable.isDisposed()) {
            this.currentActivityLifeCycleDisposable.dispose();
        }
        this.currentActivityLifeCycleDisposable = null;
        PresentationManager.getInstance().setInInstabugContext(false);
        InvocationManager.getInstance().switchOnInvocation();
    }
}
