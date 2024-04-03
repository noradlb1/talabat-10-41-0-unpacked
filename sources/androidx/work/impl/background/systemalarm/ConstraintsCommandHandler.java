package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.work.Logger;
import androidx.work.impl.background.systemalarm.SystemAlarmDispatcher;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
class ConstraintsCommandHandler {
    private static final String TAG = Logger.tagWithPrefix("ConstraintsCmdHandler");
    private final Context mContext;
    private final SystemAlarmDispatcher mDispatcher;
    private final int mStartId;
    private final WorkConstraintsTracker mWorkConstraintsTracker;

    public ConstraintsCommandHandler(@NonNull Context context, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher) {
        this.mContext = context;
        this.mStartId = i11;
        this.mDispatcher = systemAlarmDispatcher;
        this.mWorkConstraintsTracker = new WorkConstraintsTracker(context, systemAlarmDispatcher.c(), (WorkConstraintsCallback) null);
    }

    @WorkerThread
    public void a() {
        List<WorkSpec> scheduledWork = this.mDispatcher.d().getWorkDatabase().workSpecDao().getScheduledWork();
        ConstraintProxy.a(this.mContext, scheduledWork);
        this.mWorkConstraintsTracker.replace(scheduledWork);
        ArrayList<WorkSpec> arrayList = new ArrayList<>(scheduledWork.size());
        long currentTimeMillis = System.currentTimeMillis();
        for (WorkSpec next : scheduledWork) {
            String str = next.f38092id;
            if (currentTimeMillis >= next.calculateNextRunTime() && (!next.hasConstraints() || this.mWorkConstraintsTracker.areAllConstraintsMet(str))) {
                arrayList.add(next);
            }
        }
        for (WorkSpec workSpec : arrayList) {
            String str2 = workSpec.f38092id;
            Intent b11 = CommandHandler.b(this.mContext, str2);
            Logger.get().debug(TAG, String.format("Creating a delay_met command for workSpec with id (%s)", new Object[]{str2}), new Throwable[0]);
            SystemAlarmDispatcher systemAlarmDispatcher = this.mDispatcher;
            systemAlarmDispatcher.g(new SystemAlarmDispatcher.AddRunnable(systemAlarmDispatcher, b11, this.mStartId));
        }
        this.mWorkConstraintsTracker.reset();
    }
}
