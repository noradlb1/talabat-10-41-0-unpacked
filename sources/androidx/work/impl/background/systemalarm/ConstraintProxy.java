package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.List;

abstract class ConstraintProxy extends BroadcastReceiver {
    private static final String TAG = Logger.tagWithPrefix("ConstraintProxy");

    public static class BatteryChargingProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public /* bridge */ /* synthetic */ void onReceive(Context context, Intent intent) {
            ConstraintProxy.super.onReceive(context, intent);
        }
    }

    public static void a(Context context, List<WorkSpec> list) {
        boolean z11;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        for (WorkSpec workSpec : list) {
            Constraints constraints = workSpec.constraints;
            z12 |= constraints.requiresBatteryNotLow();
            z13 |= constraints.requiresCharging();
            z14 |= constraints.requiresStorageNotLow();
            if (constraints.getRequiredNetworkType() != NetworkType.NOT_REQUIRED) {
                z11 = true;
            } else {
                z11 = false;
            }
            z15 |= z11;
            if (z12 && z13 && z14 && z15) {
                break;
            }
        }
        context.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(context, z12, z13, z14, z15));
    }

    public void onReceive(Context context, Intent intent) {
        Logger.get().debug(TAG, String.format("onReceive : %s", new Object[]{intent}), new Throwable[0]);
        context.startService(CommandHandler.a(context));
    }
}
