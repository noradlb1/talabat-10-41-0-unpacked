package com.instabug.library.internal.video;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.instabug.library.InstabugState;
import com.instabug.library.InstabugStateProvider;
import com.instabug.library._InstabugActivity;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.AutoScreenRecordingEventBus;
import com.instabug.library.core.eventbus.CurrentActivityLifeCycleEventBus;
import com.instabug.library.core.eventbus.SessionStateEventBus;
import com.instabug.library.internal.InstabugMediaProjectionIntent;
import com.instabug.library.internal.video.ScreenRecordingService;
import com.instabug.library.model.session.SessionState;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.tracking.ActivityLifeCycleEvent;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;

public class InternalAutoScreenRecorderHelper implements ScreenRecordingContract {
    private static InternalAutoScreenRecorderHelper INSTANCE;
    private Disposable activityLifeCycleDisposable;
    private ScreenRecordingFileHolder fileHolder = new ScreenRecordingFileHolder();
    private boolean isCrashOccurred = false;
    private Disposable sessionDisposable;

    public class a implements Consumer {
        public a() {
        }

        /* renamed from: a */
        public void accept(SessionState sessionState) {
            if (sessionState == SessionState.FINISH && !InternalAutoScreenRecorderHelper.this.isCrashOccurred() && InternalAutoScreenRecorderHelper.this.isEnabled()) {
                AutoScreenRecordingEventBus.getInstance().post(ScreenRecordingService.Action.STOP_DELETE);
                SettingsManager.getInstance().setAutoScreenRecordingDenied(false);
                InternalAutoScreenRecorderHelper.this.unsubscribeFromSessionEvents();
            }
        }
    }

    public class b implements Consumer {
        public b() {
        }

        /* renamed from: a */
        public void accept(ActivityLifeCycleEvent activityLifeCycleEvent) {
            if (activityLifeCycleEvent == ActivityLifeCycleEvent.RESUMED && InternalAutoScreenRecorderHelper.this.isEnabled() && !SettingsManager.getInstance().isProcessingForeground()) {
                InternalAutoScreenRecorderHelper.this.subscribeToSessionEvents();
                new Handler().postDelayed(new b(this), 700);
            }
        }
    }

    public InternalAutoScreenRecorderHelper() {
        subscribeToSessionEvents();
        subscribeToActivityLifeCycleEvents();
    }

    @Nullable
    public static Intent c() {
        return InstabugMediaProjectionIntent.getMediaProjectionIntent();
    }

    public static int d() {
        return InstabugMediaProjectionIntent.getStaticResultCode();
    }

    public static void e(@Nullable Intent intent) {
        InstabugMediaProjectionIntent.setMediaProjectionIntent(intent);
    }

    public static void f(int i11) {
        InstabugMediaProjectionIntent.setStaticResultCode(i11);
    }

    public static InternalAutoScreenRecorderHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InternalAutoScreenRecorderHelper();
        }
        return INSTANCE;
    }

    private void subscribeToActivityLifeCycleEvents() {
        Disposable disposable = this.activityLifeCycleDisposable;
        if (disposable == null || disposable.isDisposed()) {
            this.activityLifeCycleDisposable = CurrentActivityLifeCycleEventBus.getInstance().subscribe(new b());
        }
    }

    /* access modifiers changed from: private */
    public void subscribeToSessionEvents() {
        Disposable disposable = this.sessionDisposable;
        if (disposable == null || disposable.isDisposed()) {
            this.sessionDisposable = SessionStateEventBus.getInstance().subscribe(new a());
        }
    }

    /* access modifiers changed from: private */
    public void unsubscribeFromSessionEvents() {
        if (!this.sessionDisposable.isDisposed()) {
            this.sessionDisposable.dispose();
        }
    }

    public void clear() {
        this.fileHolder.clear();
    }

    public void delete() {
        this.fileHolder.delete();
    }

    @Nullable
    public Uri getAutoScreenRecordingFileUri() {
        return this.fileHolder.getAutoScreenRecordingFileUri();
    }

    public boolean isCrashOccurred() {
        return this.isCrashOccurred;
    }

    public boolean isEnabled() {
        return SettingsManager.getInstance().autoScreenRecordingEnabled();
    }

    public void setAutoScreenRecordingFile(File file) {
        this.fileHolder.setAutoScreenRecordingFile(file);
    }

    public void setCrashOccurred(boolean z11) {
        this.isCrashOccurred = z11;
    }

    public void start() {
        Activity targetActivity;
        if (!SettingsManager.getInstance().isScreenCurrentlyRecorded() && !SettingsManager.getInstance().isAutoScreenRecordingDenied() && isEnabled() && (targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity()) != null && !(targetActivity instanceof _InstabugActivity) && SettingsManager.getInstance().isAppOnForeground() && InstabugStateProvider.getInstance().getState() == InstabugState.ENABLED && !InstabugCore.isForegroundBusy()) {
            targetActivity.startActivity(new Intent(targetActivity, RequestPermissionActivity.class));
            targetActivity.overridePendingTransition(0, 0);
        }
    }
}
