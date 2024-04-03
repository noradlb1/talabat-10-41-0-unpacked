package com.huawei.hms.dtm.core;

import android.app.Activity;
import android.view.Window;

public class be {
    public static void a(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            Window window = activity.getWindow();
            Window.Callback callback = window.getCallback();
            if (callback instanceof ae) {
                window.setCallback(((ae) callback).a());
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            Window window = activity.getWindow();
            Window.Callback callback = window.getCallback();
            if (callback == null) {
                window.setCallback(new ae((Window.Callback) null));
            } else if (!(callback instanceof ae)) {
                window.setCallback(new ae(callback));
            }
        }
    }
}
