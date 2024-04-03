package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import com.huawei.hms.push.constant.RemoteMessageConst;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String TAG = Logger.tagWithPrefix("SystemFgService");
    @Nullable
    private static SystemForegroundService sForegroundService = null;

    /* renamed from: b  reason: collision with root package name */
    public SystemForegroundDispatcher f38068b;

    /* renamed from: c  reason: collision with root package name */
    public NotificationManager f38069c;
    private Handler mHandler;
    private boolean mIsShutdown;

    @Nullable
    public static SystemForegroundService getInstance() {
        return sForegroundService;
    }

    @MainThread
    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.f38069c = (NotificationManager) getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.f38068b = systemForegroundDispatcher;
        systemForegroundDispatcher.d(this);
    }

    public void cancelNotification(final int i11) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.f38069c.cancel(i11);
            }
        });
    }

    public void notify(final int i11, @NonNull final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                SystemForegroundService.this.f38069c.notify(i11, notification);
            }
        });
    }

    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f38068b.b();
    }

    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        super.onStartCommand(intent, i11, i12);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f38068b.b();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f38068b.c(intent);
        return 3;
    }

    public void startForeground(final int i11, final int i12, @NonNull final Notification notification) {
        this.mHandler.post(new Runnable() {
            public void run() {
                if (Build.VERSION.SDK_INT >= 29) {
                    SystemForegroundService.this.startForeground(i11, notification, i12);
                } else {
                    SystemForegroundService.this.startForeground(i11, notification);
                }
            }
        });
    }

    @MainThread
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        sForegroundService = null;
        stopSelf();
    }
}
