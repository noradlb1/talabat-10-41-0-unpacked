package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.model.WorkSpec;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CommandHandler implements ExecutionListener {
    private static final String KEY_NEEDS_RESCHEDULE = "KEY_NEEDS_RESCHEDULE";
    private static final String KEY_WORKSPEC_ID = "KEY_WORKSPEC_ID";
    private static final String TAG = Logger.tagWithPrefix("CommandHandler");
    private final Context mContext;
    private final Object mLock = new Object();
    private final Map<String, ExecutionListener> mPendingDelayMet = new HashMap();

    public CommandHandler(@NonNull Context context) {
        this.mContext = context;
    }

    public static Intent a(@NonNull Context context) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_CONSTRAINTS_CHANGED");
        return intent;
    }

    public static Intent b(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_DELAY_MET");
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    public static Intent c(@NonNull Context context, @NonNull String str, boolean z11) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_EXECUTION_COMPLETED");
        intent.putExtra(KEY_WORKSPEC_ID, str);
        intent.putExtra(KEY_NEEDS_RESCHEDULE, z11);
        return intent;
    }

    public static Intent d(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_SCHEDULE_WORK");
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    public static Intent e(@NonNull Context context, @NonNull String str) {
        Intent intent = new Intent(context, SystemAlarmService.class);
        intent.setAction("ACTION_STOP_WORK");
        intent.putExtra(KEY_WORKSPEC_ID, str);
        return intent;
    }

    private void handleConstraintsChanged(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, String.format("Handling constraints changed %s", new Object[]{intent}), new Throwable[0]);
        new ConstraintsCommandHandler(this.mContext, i11, systemAlarmDispatcher).a();
    }

    private void handleDelayMet(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Bundle extras = intent.getExtras();
        synchronized (this.mLock) {
            String string = extras.getString(KEY_WORKSPEC_ID);
            Logger logger = Logger.get();
            String str = TAG;
            logger.debug(str, String.format("Handing delay met for %s", new Object[]{string}), new Throwable[0]);
            if (!this.mPendingDelayMet.containsKey(string)) {
                DelayMetCommandHandler delayMetCommandHandler = new DelayMetCommandHandler(this.mContext, i11, string, systemAlarmDispatcher);
                this.mPendingDelayMet.put(string, delayMetCommandHandler);
                delayMetCommandHandler.a();
            } else {
                Logger.get().debug(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", new Object[]{string}), new Throwable[0]);
            }
        }
    }

    private void handleExecutionCompleted(@NonNull Intent intent, int i11) {
        Bundle extras = intent.getExtras();
        String string = extras.getString(KEY_WORKSPEC_ID);
        boolean z11 = extras.getBoolean(KEY_NEEDS_RESCHEDULE);
        Logger.get().debug(TAG, String.format("Handling onExecutionCompleted %s, %s", new Object[]{intent, Integer.valueOf(i11)}), new Throwable[0]);
        onExecuted(string, z11);
    }

    private void handleReschedule(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        Logger.get().debug(TAG, String.format("Handling reschedule %s, %s", new Object[]{intent, Integer.valueOf(i11)}), new Throwable[0]);
        systemAlarmDispatcher.d().rescheduleEligibleWork();
    }

    private void handleScheduleWorkIntent(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString(KEY_WORKSPEC_ID);
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Handling schedule work for %s", new Object[]{string}), new Throwable[0]);
        WorkDatabase workDatabase = systemAlarmDispatcher.d().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            WorkSpec workSpec = workDatabase.workSpecDao().getWorkSpec(string);
            if (workSpec == null) {
                Logger logger2 = Logger.get();
                logger2.warning(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
            } else if (workSpec.state.isFinished()) {
                Logger logger3 = Logger.get();
                logger3.warning(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                workDatabase.endTransaction();
            } else {
                long calculateNextRunTime = workSpec.calculateNextRunTime();
                if (!workSpec.hasConstraints()) {
                    Logger.get().debug(str, String.format("Setting up Alarms for %s at %s", new Object[]{string, Long.valueOf(calculateNextRunTime)}), new Throwable[0]);
                    Alarms.setAlarm(this.mContext, systemAlarmDispatcher.d(), string, calculateNextRunTime);
                } else {
                    Logger.get().debug(str, String.format("Opportunistically setting an alarm for %s at %s", new Object[]{string, Long.valueOf(calculateNextRunTime)}), new Throwable[0]);
                    Alarms.setAlarm(this.mContext, systemAlarmDispatcher.d(), string, calculateNextRunTime);
                    systemAlarmDispatcher.g(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, a(this.mContext), i11));
                }
                workDatabase.setTransactionSuccessful();
                workDatabase.endTransaction();
            }
        } finally {
            workDatabase.endTransaction();
        }
    }

    private void handleStopWork(@NonNull Intent intent, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String string = intent.getExtras().getString(KEY_WORKSPEC_ID);
        Logger.get().debug(TAG, String.format("Handing stopWork work for %s", new Object[]{string}), new Throwable[0]);
        systemAlarmDispatcher.d().stopWork(string);
        Alarms.cancelAlarm(this.mContext, systemAlarmDispatcher.d(), string);
        systemAlarmDispatcher.onExecuted(string, false);
    }

    private static boolean hasKeys(@Nullable Bundle bundle, @NonNull String... strArr) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : strArr) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        boolean z11;
        synchronized (this.mLock) {
            if (!this.mPendingDelayMet.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
        }
        return z11;
    }

    @WorkerThread
    public void g(@NonNull Intent intent, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        String action = intent.getAction();
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action)) {
            handleConstraintsChanged(intent, i11, systemAlarmDispatcher);
        } else if ("ACTION_RESCHEDULE".equals(action)) {
            handleReschedule(intent, i11, systemAlarmDispatcher);
        } else if (!hasKeys(intent.getExtras(), KEY_WORKSPEC_ID)) {
            Logger.get().error(TAG, String.format("Invalid request for %s, requires %s.", new Object[]{action, KEY_WORKSPEC_ID}), new Throwable[0]);
        } else if ("ACTION_SCHEDULE_WORK".equals(action)) {
            handleScheduleWorkIntent(intent, i11, systemAlarmDispatcher);
        } else if ("ACTION_DELAY_MET".equals(action)) {
            handleDelayMet(intent, i11, systemAlarmDispatcher);
        } else if ("ACTION_STOP_WORK".equals(action)) {
            handleStopWork(intent, systemAlarmDispatcher);
        } else if ("ACTION_EXECUTION_COMPLETED".equals(action)) {
            handleExecutionCompleted(intent, i11);
        } else {
            Logger.get().warning(TAG, String.format("Ignoring intent %s", new Object[]{intent}), new Throwable[0]);
        }
    }

    public void onExecuted(@NonNull String str, boolean z11) {
        synchronized (this.mLock) {
            ExecutionListener remove = this.mPendingDelayMet.remove(str);
            if (remove != null) {
                remove.onExecuted(str, z11);
            }
        }
    }
}
