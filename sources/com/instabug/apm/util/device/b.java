package com.instabug.apm.util.device;

import android.app.Activity;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.PowerManager;
import android.view.Display;
import androidx.annotation.Nullable;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.util.DeviceStateProvider;

public class b implements a {
    public int a(Context context) {
        return DeviceStateProvider.getBatteryLevel(context);
    }

    public String a(Activity activity) {
        return activity.getResources().getConfiguration().orientation == 2 ? "landscape" : "portrait";
    }

    public boolean a() {
        return InstabugDeviceProperties.isProbablyAnEmulator();
    }

    public int b(Context context) {
        Display display = ((DisplayManager) context.getSystemService("display")).getDisplay(0);
        if (display != null) {
            return (int) display.getRefreshRate();
        }
        return 60;
    }

    @Nullable
    public Boolean c(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return Boolean.valueOf(powerManager != null && powerManager.isPowerSaveMode());
    }
}
