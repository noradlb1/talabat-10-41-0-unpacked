package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import androidx.work.impl.utils.PackageManagerHelper;

public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final String f38037a = Logger.tagWithPrefix("ConstrntProxyUpdtRecvr");

    public static Intent newConstraintProxyUpdateIntent(Context context, boolean z11, boolean z12, boolean z13, boolean z14) {
        Intent intent = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        intent.setComponent(new ComponentName(context, ConstraintProxyUpdateReceiver.class));
        intent.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", z11).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", z12).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", z13).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", z14);
        return intent;
    }

    public void onReceive(@NonNull final Context context, @Nullable final Intent intent) {
        String str;
        if (intent != null) {
            str = intent.getAction();
        } else {
            str = null;
        }
        if (!"androidx.work.impl.background.systemalarm.UpdateProxies".equals(str)) {
            Logger.get().debug(f38037a, String.format("Ignoring unknown action %s", new Object[]{str}), new Throwable[0]);
            return;
        }
        final BroadcastReceiver.PendingResult goAsync = goAsync();
        WorkManagerImpl.getInstance(context).getWorkTaskExecutor().executeOnBackgroundThread(new Runnable() {
            public void run() {
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    Logger.get().debug(ConstraintProxyUpdateReceiver.f38037a, String.format("Updating proxies: BatteryNotLowProxy enabled (%s), BatteryChargingProxy enabled (%s), StorageNotLowProxy (%s), NetworkStateProxy enabled (%s)", new Object[]{Boolean.valueOf(booleanExtra), Boolean.valueOf(booleanExtra2), Boolean.valueOf(booleanExtra3), Boolean.valueOf(booleanExtra4)}), new Throwable[0]);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                    PackageManagerHelper.setComponentEnabled(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
                } finally {
                    goAsync.finish();
                }
            }
        });
    }
}
