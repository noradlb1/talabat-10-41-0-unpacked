package androidx.work.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.WorkInfo;
import androidx.work.impl.Processor;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkSpecDao;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StopWorkRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("StopWorkRunnable");
    private final boolean mStopInForeground;
    private final WorkManagerImpl mWorkManagerImpl;
    private final String mWorkSpecId;

    public StopWorkRunnable(@NonNull WorkManagerImpl workManagerImpl, @NonNull String str, boolean z11) {
        this.mWorkManagerImpl = workManagerImpl;
        this.mWorkSpecId = str;
        this.mStopInForeground = z11;
    }

    public void run() {
        boolean z11;
        WorkDatabase workDatabase = this.mWorkManagerImpl.getWorkDatabase();
        Processor processor = this.mWorkManagerImpl.getProcessor();
        WorkSpecDao workSpecDao = workDatabase.workSpecDao();
        workDatabase.beginTransaction();
        try {
            boolean isEnqueuedInForeground = processor.isEnqueuedInForeground(this.mWorkSpecId);
            if (this.mStopInForeground) {
                z11 = this.mWorkManagerImpl.getProcessor().stopForegroundWork(this.mWorkSpecId);
            } else {
                if (!isEnqueuedInForeground && workSpecDao.getState(this.mWorkSpecId) == WorkInfo.State.RUNNING) {
                    workSpecDao.setState(WorkInfo.State.ENQUEUED, this.mWorkSpecId);
                }
                z11 = this.mWorkManagerImpl.getProcessor().stopWork(this.mWorkSpecId);
            }
            Logger.get().debug(TAG, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", new Object[]{this.mWorkSpecId, Boolean.valueOf(z11)}), new Throwable[0]);
            workDatabase.setTransactionSuccessful();
        } finally {
            workDatabase.endTransaction();
        }
    }
}
