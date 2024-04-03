package androidx.work.impl.constraints.controllers;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class BatteryNotLowController extends ConstraintController<Boolean> {
    public BatteryNotLowController(Context context, TaskExecutor taskExecutor) {
        super(Trackers.getInstance(context, taskExecutor).getBatteryNotLowTracker());
    }

    public boolean a(@NonNull WorkSpec workSpec) {
        return workSpec.constraints.requiresBatteryNotLow();
    }

    /* renamed from: c */
    public boolean b(@NonNull Boolean bool) {
        return !bool.booleanValue();
    }
}
