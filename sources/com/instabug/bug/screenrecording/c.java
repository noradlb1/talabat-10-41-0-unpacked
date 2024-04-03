package com.instabug.bug.screenrecording;

import android.app.Activity;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.bug.n;
import com.instabug.bug.p;
import com.instabug.library.core.eventbus.ScreenRecordingEventBus;
import com.instabug.library.internal.video.InternalScreenRecordHelper;
import com.instabug.library.internal.video.ScreenRecordingContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import io.reactivex.disposables.Disposable;

public class c implements ScreenRecordingContract {

    /* renamed from: b  reason: collision with root package name */
    private static c f45720b;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Disposable f45721a;

    public static c a() {
        if (f45720b == null) {
            f45720b = new c();
        }
        return f45720b;
    }

    @VisibleForTesting
    private void a(@Nullable Uri uri) {
        if (uri != null && n.e().c() != null) {
            n.e().c().a(uri, Attachment.Type.EXTRA_VIDEO);
        }
    }

    /* access modifiers changed from: private */
    public void b(@Nullable Uri uri) {
        a(uri);
        c();
    }

    private void c() {
        Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.startActivity(p.d(currentActivity.getApplicationContext()));
        }
    }

    private void e() {
        Disposable disposable = this.f45721a;
        if (disposable != null && !disposable.isDisposed()) {
            this.f45721a.dispose();
        }
    }

    public boolean b() {
        return InternalScreenRecordHelper.getInstance().isRecording();
    }

    public void clear() {
        e();
        InternalScreenRecordHelper.getInstance().clear();
    }

    public void d() {
        InternalScreenRecordHelper.getInstance().init();
        Disposable disposable = this.f45721a;
        if (disposable == null || disposable.isDisposed()) {
            this.f45721a = ScreenRecordingEventBus.getInstance().subscribe(new b(this));
        }
    }

    public void delete() {
        InternalScreenRecordHelper.getInstance().delete();
    }

    @Nullable
    public Uri getAutoScreenRecordingFileUri() {
        return InternalScreenRecordHelper.getInstance().getAutoScreenRecordingFileUri();
    }

    public boolean isEnabled() {
        return InternalScreenRecordHelper.getInstance().isEnabled();
    }
}
