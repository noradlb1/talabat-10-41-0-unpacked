package com.iab.omid.library.deliveryhero3.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.iab.omid.library.deliveryhero3.adsession.DeviceCategory;
import com.iab.omid.library.deliveryhero3.adsession.OutputDeviceStatus;

public class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static OutputDeviceStatus f45004a = OutputDeviceStatus.UNKNOWN;

    public class a extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            OutputDeviceStatus outputDeviceStatus;
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    outputDeviceStatus = OutputDeviceStatus.NOT_DETECTED;
                } else if (intExtra == 1) {
                    outputDeviceStatus = OutputDeviceStatus.UNKNOWN;
                } else {
                    return;
                }
                OutputDeviceStatus unused = e.f45004a = outputDeviceStatus;
            }
        }
    }

    public static OutputDeviceStatus a() {
        return a.a() != DeviceCategory.CTV ? OutputDeviceStatus.UNKNOWN : f45004a;
    }

    public static void a(@NonNull Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}
