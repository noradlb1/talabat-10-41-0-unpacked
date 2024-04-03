package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BuildCompat;
import androidx.work.Configuration;
import androidx.work.InitializationExceptionHandler;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabasePathHelper;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemjob.SystemJobScheduler;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {
    private static final int ALARM_ID = -1;
    private static final long BACKOFF_DURATION_MS = 300;
    private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable");
    private static final long TEN_YEARS = TimeUnit.DAYS.toMillis(3650);
    private final Context mContext;
    private int mRetryCount = 0;
    private final WorkManagerImpl mWorkManager;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {
        private static final String TAG = Logger.tagWithPrefix("ForceStopRunnable$Rcvr");

        public void onReceive(@NonNull Context context, @Nullable Intent intent) {
            if (intent != null && "ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
                Logger.get().verbose(TAG, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
                ForceStopRunnable.b(context);
            }
        }
    }

    public ForceStopRunnable(@NonNull Context context, @NonNull WorkManagerImpl workManagerImpl) {
        this.mContext = context.getApplicationContext();
        this.mWorkManager = workManagerImpl;
    }

    @VisibleForTesting
    public static Intent a(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, BroadcastReceiver.class));
        intent.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        return intent;
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void b(Context context) {
        int i11;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (BuildCompat.isAtLeastS()) {
            i11 = 167772160;
        } else {
            i11 = C.BUFFER_FLAG_FIRST_SAMPLE;
        }
        PendingIntent pendingIntent = getPendingIntent(context, i11);
        long currentTimeMillis = System.currentTimeMillis() + TEN_YEARS;
        if (alarmManager != null) {
            alarmManager.setExact(0, currentTimeMillis, pendingIntent);
        }
    }

    private static PendingIntent getPendingIntent(Context context, int i11) {
        return PendingIntent.getBroadcast(context, -1, a(context), i11);
    }

    @VisibleForTesting
    public boolean c() {
        return this.mWorkManager.getPreferenceUtils().getNeedsReschedule();
    }

    @VisibleForTesting
    public boolean cleanUp() {
        boolean z11;
        boolean reconcileJobs = SystemJobScheduler.reconcileJobs(this.mContext, this.mWorkManager);
        WorkDatabase workDatabase = this.mWorkManager.getWorkDatabase();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        WorkProgressDao workProgressDao = workDatabase.workProgressDao();
        workDatabase.beginTransaction();
        try {
            List<WorkSpec> runningWork = workSpecDao.getRunningWork();
            if (runningWork == null || runningWork.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                for (WorkSpec next : runningWork) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, next.f38092id);
                    workSpecDao.markWorkSpecScheduled(next.f38092id, -1);
                }
            }
            workProgressDao.deleteAll();
            workDatabase.setTransactionSuccessful();
            if (z11 || reconcileJobs) {
                return true;
            }
            return false;
        } finally {
            workDatabase.endTransaction();
        }
    }

    @VisibleForTesting
    public void forceStopRunnable() {
        boolean cleanUp = cleanUp();
        if (c()) {
            Logger.get().debug(TAG, "Rescheduling Workers.", new Throwable[0]);
            this.mWorkManager.rescheduleEligibleWork();
            this.mWorkManager.getPreferenceUtils().setNeedsReschedule(false);
        } else if (isForceStopped()) {
            Logger.get().debug(TAG, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.mWorkManager.rescheduleEligibleWork();
        } else if (cleanUp) {
            Logger.get().debug(TAG, "Found unfinished work, scheduling it.", new Throwable[0]);
            Schedulers.schedule(this.mWorkManager.getConfiguration(), this.mWorkManager.getWorkDatabase(), this.mWorkManager.getSchedulers());
        }
    }

    @VisibleForTesting
    @SuppressLint({"ClassVerificationFailure"})
    public boolean isForceStopped() {
        int i11;
        try {
            if (BuildCompat.isAtLeastS()) {
                i11 = 570425344;
            } else {
                i11 = 536870912;
            }
            PendingIntent pendingIntent = getPendingIntent(this.mContext, i11);
            if (Build.VERSION.SDK_INT >= 30) {
                if (pendingIntent != null) {
                    pendingIntent.cancel();
                }
                List a11 = ((ActivityManager) this.mContext.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
                if (a11 != null && !a11.isEmpty()) {
                    for (int i12 = 0; i12 < a11.size(); i12++) {
                        if (((ApplicationExitInfo) a11.get(i12)).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntent == null) {
                b(this.mContext);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e11) {
            Logger.get().warning(TAG, "Ignoring exception", e11);
            return true;
        }
    }

    @VisibleForTesting
    public boolean multiProcessChecks() {
        Configuration configuration = this.mWorkManager.getConfiguration();
        if (TextUtils.isEmpty(configuration.getDefaultProcessName())) {
            Logger.get().debug(TAG, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean isDefaultProcess = ProcessUtils.isDefaultProcess(this.mContext, configuration);
        Logger.get().debug(TAG, String.format("Is default app process = %s", new Object[]{Boolean.valueOf(isDefaultProcess)}), new Throwable[0]);
        return isDefaultProcess;
    }

    public void run() {
        try {
            if (!multiProcessChecks()) {
                this.mWorkManager.onForceStopRunnableCompleted();
                return;
            }
            while (true) {
                WorkDatabasePathHelper.migrateDatabase(this.mContext);
                Logger.get().debug(TAG, "Performing cleanup operations.", new Throwable[0]);
                forceStopRunnable();
                break;
            }
            this.mWorkManager.onForceStopRunnableCompleted();
        } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e11) {
            int i11 = this.mRetryCount + 1;
            this.mRetryCount = i11;
            if (i11 >= 3) {
                Logger logger = Logger.get();
                String str = TAG;
                logger.error(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e11);
                IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e11);
                InitializationExceptionHandler exceptionHandler = this.mWorkManager.getConfiguration().getExceptionHandler();
                if (exceptionHandler != null) {
                    Logger.get().debug(str, "Routing exception to the specified exception handler", illegalStateException);
                    exceptionHandler.handleException(illegalStateException);
                } else {
                    throw illegalStateException;
                }
            } else {
                long j11 = ((long) i11) * BACKOFF_DURATION_MS;
                Logger.get().debug(TAG, String.format("Retrying after %s", new Object[]{Long.valueOf(j11)}), e11);
                sleep(((long) this.mRetryCount) * BACKOFF_DURATION_MS);
            }
        } catch (Throwable th2) {
            this.mWorkManager.onForceStopRunnableCompleted();
            throw th2;
        }
    }

    @VisibleForTesting
    public void sleep(long j11) {
        try {
            Thread.sleep(j11);
        } catch (InterruptedException unused) {
        }
    }
}
