package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.invocation.InstabugInvocationEvent;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.a;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.PermissionsUtils;

public class r implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private ContentResolver f51389a;

    /* renamed from: b  reason: collision with root package name */
    private t f51390b;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f51391c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f51392d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f51393e = true;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f51394f;

    @SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED", "ERADICATE_PARAMETER_NOT_NULLABLE"})
    public r(a aVar) {
        if (Instabug.getApplicationContext() == null) {
            InstabugSDKLogger.e("IBG-Core", "ScreenshotGestureInvoker() called with null context");
            return;
        }
        this.f51389a = Instabug.getApplicationContext().getContentResolver();
        HandlerThread handlerThread = new HandlerThread("ScreenshotObserver");
        this.f51391c = handlerThread;
        handlerThread.start();
        this.f51392d = new Handler(this.f51391c.getLooper());
        this.f51390b = new t(this.f51392d, this.f51389a, aVar);
        d();
    }

    private boolean a() {
        boolean isMediaStoragePermissionGranted = PermissionsUtils.isMediaStoragePermissionGranted(InstabugInternalTrackingDelegate.getInstance().getCurrentActivity());
        InstabugSDKLogger.v("IBG-Core", "isStoragePermissionGranted = [" + isMediaStoragePermissionGranted + "]");
        return isMediaStoragePermissionGranted;
    }

    private void c() {
        ContentResolver contentResolver;
        if (a() && (contentResolver = this.f51389a) != null) {
            contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.f51390b);
            this.f51394f = true;
        }
    }

    private void d() {
        SessionStateEventBus.getInstance().subscribe(new q(this));
    }

    /* renamed from: a */
    public void handle(Void voidR) {
    }

    public boolean isActive() {
        return this.f51394f;
    }

    public void listen() {
        if (!this.f51393e || a()) {
            c();
        } else {
            b();
        }
    }

    public void sleep() {
        ContentResolver contentResolver = this.f51389a;
        if (contentResolver != null) {
            contentResolver.unregisterContentObserver(this.f51390b);
            this.f51394f = false;
        }
    }

    private void b() {
        InstabugInvocationEvent[] currentInstabugInvocationEvents = InvocationManager.getInstance().getCurrentInstabugInvocationEvents();
        if (currentInstabugInvocationEvents != null) {
            for (InstabugInvocationEvent instabugInvocationEvent : currentInstabugInvocationEvents) {
                if (instabugInvocationEvent == InstabugInvocationEvent.SCREENSHOT) {
                    Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
                    if (currentActivity != null) {
                        PermissionsUtils.requestPermission(currentActivity, PermissionsUtils.mediaStoragePermission(), 1, (Runnable) null, (Runnable) null);
                        this.f51393e = false;
                        return;
                    }
                    return;
                }
            }
        }
    }
}
