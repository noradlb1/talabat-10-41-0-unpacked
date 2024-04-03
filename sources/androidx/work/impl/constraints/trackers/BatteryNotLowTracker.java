package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String TAG = Logger.tagWithPrefix("BatteryNotLowTracker");

    public BatteryNotLowTracker(@NonNull Context context, @NonNull TaskExecutor taskExecutor) {
        super(context, taskExecutor);
    }

    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    public void onBroadcastReceive(Context context, @NonNull Intent intent) {
        if (intent.getAction() != null) {
            Logger.get().debug(TAG, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.BATTERY_OKAY")) {
                setState(Boolean.TRUE);
            } else if (action.equals("android.intent.action.BATTERY_LOW")) {
                setState(Boolean.FALSE);
            }
        }
    }

    public Boolean getInitialState() {
        Intent registerReceiver = this.f38051b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z11 = false;
        if (registerReceiver == null) {
            Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }
}
