package com.instabug.library.screenshot;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.instabug.library.core.eventbus.ScreenCaptureEventBus;
import com.instabug.library.model.i;
import com.instabug.library.screenshot.ScreenshotProvider;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import io.reactivex.functions.Consumer;

@TargetApi(21)
public class f implements Consumer {

    /* renamed from: c  reason: collision with root package name */
    public static final f f51740c = new f();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ScreenshotProvider.ScreenshotCapturingListener f51741a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Intent f51742b;

    private f() {
        ScreenCaptureEventBus.getInstance().subscribe(this);
    }

    public void a(int i11, @Nullable Intent intent, boolean z11, @Nullable ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener) {
        if (i11 != -1 || intent == null) {
            this.f51742b = null;
        } else {
            this.f51742b = intent;
        }
        if (z11 && screenshotCapturingListener != null) {
            a(screenshotCapturingListener);
        }
    }

    @UiThread
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void b(@NonNull ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener) {
        this.f51741a = screenshotCapturingListener;
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startService(ScreenshotCaptureService.a(currentActivity, this.f51742b));
        }
    }

    private void a(ScreenshotProvider.ScreenshotCapturingListener screenshotCapturingListener) {
        new Handler().postDelayed(new e(this, screenshotCapturingListener), 500);
    }

    /* renamed from: a */
    public void accept(i iVar) {
        if (this.f51741a != null) {
            int b11 = iVar.b();
            if (b11 != 0) {
                if (b11 == 1 && iVar.c() != null) {
                    this.f51741a.onScreenshotCapturingFailed(iVar.c());
                }
            } else if (iVar.a() != null) {
                this.f51741a.onScreenshotCapturedSuccessfully(iVar.a());
            }
        }
    }
}
