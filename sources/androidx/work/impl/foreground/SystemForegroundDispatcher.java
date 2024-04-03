package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundDispatcher implements WorkConstraintsCallback, ExecutionListener {
    private static final String ACTION_CANCEL_WORK = "ACTION_CANCEL_WORK";
    private static final String ACTION_NOTIFY = "ACTION_NOTIFY";
    private static final String ACTION_START_FOREGROUND = "ACTION_START_FOREGROUND";
    private static final String ACTION_STOP_FOREGROUND = "ACTION_STOP_FOREGROUND";
    private static final String KEY_FOREGROUND_SERVICE_TYPE = "KEY_FOREGROUND_SERVICE_TYPE";
    private static final String KEY_NOTIFICATION = "KEY_NOTIFICATION";
    private static final String KEY_NOTIFICATION_ID = "KEY_NOTIFICATION_ID";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";

    /* renamed from: h  reason: collision with root package name */
    public static final String f38058h = Logger.tagWithPrefix("SystemFgDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public final Object f38059b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public String f38060c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, ForegroundInfo> f38061d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, WorkSpec> f38062e;

    /* renamed from: f  reason: collision with root package name */
    public final Set<WorkSpec> f38063f;

    /* renamed from: g  reason: collision with root package name */
    public final WorkConstraintsTracker f38064g;
    @Nullable
    private Callback mCallback;
    private Context mContext;
    private final TaskExecutor mTaskExecutor;
    private WorkManagerImpl mWorkManagerImpl;

    public interface Callback {
        void cancelNotification(int i11);

        void notify(int i11, @NonNull Notification notification);

        void startForeground(int i11, int i12, @NonNull Notification notification);

        void stop();
    }

    public SystemForegroundDispatcher(@NonNull Context context) {
        this.mContext = context;
        WorkManagerImpl instance = WorkManagerImpl.getInstance(context);
        this.mWorkManagerImpl = instance;
        TaskExecutor workTaskExecutor = instance.getWorkTaskExecutor();
        this.mTaskExecutor = workTaskExecutor;
        this.f38060c = null;
        this.f38061d = new LinkedHashMap();
        this.f38063f = new HashSet();
        this.f38062e = new HashMap();
        this.f38064g = new WorkConstraintsTracker(this.mContext, workTaskExecutor, this);
        this.mWorkManagerImpl.getProcessor().addExecutionListener(this);
    }

    @NonNull
    public static Intent createCancelWorkIntent(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_CANCEL_WORK);
        intent.setData(Uri.parse(String.format("workspec://%s", new Object[]{str})));
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    @NonNull
    public static Intent createNotifyIntent(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_NOTIFY);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    @NonNull
    public static Intent createStartForegroundIntent(@NonNull Context context, @NonNull String str, @NonNull ForegroundInfo foregroundInfo) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_START_FOREGROUND);
        intent.putExtra(KEY_WORKSPEC_ID, str);
        intent.putExtra(KEY_NOTIFICATION_ID, foregroundInfo.getNotificationId());
        intent.putExtra(KEY_FOREGROUND_SERVICE_TYPE, foregroundInfo.getForegroundServiceType());
        intent.putExtra(KEY_NOTIFICATION, foregroundInfo.getNotification());
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    @NonNull
    public static Intent createStopForegroundIntent(@NonNull Context context) {
        Intent intent = new Intent(context, SystemForegroundService.class);
        intent.setAction(ACTION_STOP_FOREGROUND);
        return intent;
    }

    @MainThread
    private void handleCancelWork(@NonNull Intent intent) {
        Logger.get().info(f38058h, String.format("Stopping foreground work for %s", new Object[]{intent}), new Throwable[0]);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        if (stringExtra != null && !TextUtils.isEmpty(stringExtra)) {
            this.mWorkManagerImpl.cancelWorkById(UUID.fromString(stringExtra));
        }
    }

    @MainThread
    private void handleNotify(@NonNull Intent intent) {
        int i11 = 0;
        int intExtra = intent.getIntExtra(KEY_NOTIFICATION_ID, 0);
        int intExtra2 = intent.getIntExtra(KEY_FOREGROUND_SERVICE_TYPE, 0);
        String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        Notification notification = (Notification) intent.getParcelableExtra(KEY_NOTIFICATION);
        Logger.get().debug(f38058h, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", new Object[]{Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)}), new Throwable[0]);
        if (notification != null && this.mCallback != null) {
            this.f38061d.put(stringExtra, new ForegroundInfo(intExtra, notification, intExtra2));
            if (TextUtils.isEmpty(this.f38060c)) {
                this.f38060c = stringExtra;
                this.mCallback.startForeground(intExtra, intExtra2, notification);
                return;
            }
            this.mCallback.notify(intExtra, notification);
            if (intExtra2 != 0 && Build.VERSION.SDK_INT >= 29) {
                for (Map.Entry<String, ForegroundInfo> value : this.f38061d.entrySet()) {
                    i11 |= ((ForegroundInfo) value.getValue()).getForegroundServiceType();
                }
                ForegroundInfo foregroundInfo = this.f38061d.get(this.f38060c);
                if (foregroundInfo != null) {
                    this.mCallback.startForeground(foregroundInfo.getNotificationId(), i11, foregroundInfo.getNotification());
                }
            }
        }
    }

    @MainThread
    private void handleStartForeground(@NonNull Intent intent) {
        Logger.get().info(f38058h, String.format("Started foreground service %s", new Object[]{intent}), new Throwable[0]);
        final String stringExtra = intent.getStringExtra(KEY_WORKSPEC_ID);
        final WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        this.mTaskExecutor.executeOnBackgroundThread(new Runnable() {
            public void run() {
                WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(stringExtra);
                if (workSpec != null && workSpec.hasConstraints()) {
                    synchronized (SystemForegroundDispatcher.this.f38059b) {
                        SystemForegroundDispatcher.this.f38062e.put(stringExtra, workSpec);
                        SystemForegroundDispatcher.this.f38063f.add(workSpec);
                        SystemForegroundDispatcher systemForegroundDispatcher = SystemForegroundDispatcher.this;
                        systemForegroundDispatcher.f38064g.replace(systemForegroundDispatcher.f38063f);
                    }
                }
            }
        });
    }

    @MainThread
    public void a(@NonNull Intent intent) {
        Logger.get().info(f38058h, "Stopping foreground service", new Throwable[0]);
        Callback callback = this.mCallback;
        if (callback != null) {
            callback.stop();
        }
    }

    @MainThread
    public void b() {
        this.mCallback = null;
        synchronized (this.f38059b) {
            this.f38064g.reset();
        }
        this.mWorkManagerImpl.getProcessor().removeExecutionListener(this);
    }

    public void c(@NonNull Intent intent) {
        String action = intent.getAction();
        if (ACTION_START_FOREGROUND.equals(action)) {
            handleStartForeground(intent);
            handleNotify(intent);
        } else if (ACTION_NOTIFY.equals(action)) {
            handleNotify(intent);
        } else if (ACTION_CANCEL_WORK.equals(action)) {
            handleCancelWork(intent);
        } else if (ACTION_STOP_FOREGROUND.equals(action)) {
            a(intent);
        }
    }

    @MainThread
    public void d(@NonNull Callback callback) {
        if (this.mCallback != null) {
            Logger.get().error(f38058h, "A callback already exists.", new Throwable[0]);
        } else {
            this.mCallback = callback;
        }
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        if (!list.isEmpty()) {
            for (String next : list) {
                Logger.get().debug(f38058h, String.format("Constraints unmet for WorkSpec %s", new Object[]{next}), new Throwable[0]);
                this.mWorkManagerImpl.stopForegroundWork(next);
            }
        }
    }

    @MainThread
    public void onExecuted(@NonNull String str, boolean z11) {
        boolean z12;
        Map.Entry entry;
        synchronized (this.f38059b) {
            WorkSpec remove = this.f38062e.remove(str);
            if (remove != null) {
                z12 = this.f38063f.remove(remove);
            } else {
                z12 = false;
            }
            if (z12) {
                this.f38064g.replace(this.f38063f);
            }
        }
        ForegroundInfo remove2 = this.f38061d.remove(str);
        if (str.equals(this.f38060c) && this.f38061d.size() > 0) {
            Iterator it = this.f38061d.entrySet().iterator();
            Object next = it.next();
            while (true) {
                entry = (Map.Entry) next;
                if (!it.hasNext()) {
                    break;
                }
                next = it.next();
            }
            this.f38060c = (String) entry.getKey();
            if (this.mCallback != null) {
                ForegroundInfo foregroundInfo = (ForegroundInfo) entry.getValue();
                this.mCallback.startForeground(foregroundInfo.getNotificationId(), foregroundInfo.getForegroundServiceType(), foregroundInfo.getNotification());
                this.mCallback.cancelNotification(foregroundInfo.getNotificationId());
            }
        }
        Callback callback = this.mCallback;
        if (remove2 != null && callback != null) {
            Logger.get().debug(f38058h, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", new Object[]{Integer.valueOf(remove2.getNotificationId()), str, Integer.valueOf(remove2.getForegroundServiceType())}), new Throwable[0]);
            callback.cancelNotification(remove2.getNotificationId());
        }
    }
}
