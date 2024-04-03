package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import com.facebook.AuthenticationTokenClaims;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DelayMetCommandHandler implements WorkConstraintsCallback, ExecutionListener, WorkTimer.TimeLimitExceededListener {
    private static final int STATE_INITIAL = 0;
    private static final int STATE_START_REQUESTED = 1;
    private static final int STATE_STOP_REQUESTED = 2;
    private static final String TAG = Logger.tagWithPrefix("DelayMetCommandHandler");
    private final Context mContext;
    private int mCurrentState = 0;
    private final SystemAlarmDispatcher mDispatcher;
    private boolean mHasConstraints = false;
    private final Object mLock = new Object();
    private final int mStartId;
    @Nullable
    private PowerManager.WakeLock mWakeLock;
    private final WorkConstraintsTracker mWorkConstraintsTracker;
    private final String mWorkSpecId;

    public DelayMetCommandHandler(@NonNull Context context, int i11, @NonNull String str, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i11;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkSpecId = str;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, systemAlarmDispatcher.c(), this);
    }

    private void cleanUp() {
        synchronized (this.mLock) {
            this.mWorkConstraintsTracker.reset();
            this.mDispatcher.e().stopTimer(this.mWorkSpecId);
            PowerManager.WakeLock wakeLock = this.mWakeLock;
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.get().debug(TAG, String.format("Releasing wakelock %s for WorkSpec %s", new Object[]{this.mWakeLock, this.mWorkSpecId}), new Throwable[0]);
                this.mWakeLock.release();
            }
        }
    }

    private void stopWork() {
        synchronized (this.mLock) {
            if (this.mCurrentState < 2) {
                this.mCurrentState = 2;
                Logger logger = Logger.get();
                String str = TAG;
                logger.debug(str, String.format("Stopping work for WorkSpec %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                Intent e11 = CommandHandler.e(this.mContext, this.mWorkSpecId);
                SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
                systemAlarmDispatcher.g(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, e11, this.mStartId));
                if (this.mDispatcher.b().isEnqueued(this.mWorkSpecId)) {
                    Logger.get().debug(str, String.format("WorkSpec %s needs to be rescheduled", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    Intent d11 = CommandHandler.d(this.mContext, this.mWorkSpecId);
                    SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
                    systemAlarmDispatcher2.g(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, d11, this.mStartId));
                } else {
                    Logger.get().debug(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                }
            } else {
                Logger.get().debug(TAG, String.format("Already stopped work for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            }
        }
    }

    @WorkerThread
    public void a() {
        this.mWakeLock = WakeLocks.newWakeLock(this.mContext, String.format("%s (%s)", new Object[]{this.mWorkSpecId, Integer.valueOf(this.mStartId)}));
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, String.format("Acquiring wakelock %s for WorkSpec %s", new Object[]{this.mWakeLock, this.mWorkSpecId}), new Throwable[0]);
        this.mWakeLock.acquire();
        WorkSpec workSpec = this.mDispatcher.d().getWorkDatabase().workSpecDao().getWorkSpec(this.mWorkSpecId);
        if (workSpec == null) {
            stopWork();
            return;
        }
        boolean hasConstraints = workSpec.hasConstraints();
        this.mHasConstraints = hasConstraints;
        if (!hasConstraints) {
            Logger.get().debug(str, String.format("No constraints for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
            onAllConstraintsMet(Collections.singletonList(this.mWorkSpecId));
            return;
        }
        this.mWorkConstraintsTracker.replace(Collections.singletonList(workSpec));
    }

    public void onAllConstraintsMet(@NonNull List<String> list) {
        if (list.contains(this.mWorkSpecId)) {
            synchronized (this.mLock) {
                if (this.mCurrentState == 0) {
                    this.mCurrentState = 1;
                    Logger.get().debug(TAG, String.format("onAllConstraintsMet for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                    if (this.mDispatcher.b().startWork(this.mWorkSpecId)) {
                        this.mDispatcher.e().startTimer(this.mWorkSpecId, AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED, this);
                    } else {
                        cleanUp();
                    }
                } else {
                    Logger.get().debug(TAG, String.format("Already started work for %s", new Object[]{this.mWorkSpecId}), new Throwable[0]);
                }
            }
        }
    }

    public void onAllConstraintsNotMet(@NonNull List<String> list) {
        stopWork();
    }

    public void onExecuted(@NonNull String str, boolean z11) {
        Logger.get().debug(TAG, String.format("onExecuted %s, %s", new Object[]{str, Boolean.valueOf(z11)}), new Throwable[0]);
        cleanUp();
        if (z11) {
            Intent d11 = CommandHandler.d(this.mContext, this.mWorkSpecId);
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.g(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, d11, this.mStartId));
        }
        if (this.mHasConstraints) {
            Intent a11 = CommandHandler.a(this.mContext);
            SystemAlarmDispatcher systemAlarmDispatcher2 = this.mDispatcher;
            systemAlarmDispatcher2.g(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher2, a11, this.mStartId));
        }
    }

    public void onTimeLimitExceeded(@NonNull String str) {
        Logger.get().debug(TAG, String.format("Exceeded time limits on execution for %s", new Object[]{str}), new Throwable[0]);
        stopWork();
    }
}
