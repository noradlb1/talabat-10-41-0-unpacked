package com.instabug.survey.common;

import android.app.Activity;
import com.instabug.library.internal.device.InstabugDeviceProperties;
import com.instabug.library.util.DisplayUtils;
import com.instabug.library.util.OrientationUtils;
import com.instabug.survey.ui.n;

public abstract class f {
    public static int a(Activity activity, n nVar) {
        int i11;
        int displayHeightInPx = DisplayUtils.getDisplayHeightInPx(activity);
        int i12 = e.f52323a[nVar.ordinal()];
        if (i12 != 2) {
            if (i12 == 3) {
                i11 = InstabugDeviceProperties.isTablet(activity) ? 80 : OrientationUtils.isInLandscape(activity) ? 95 : 88;
            } else if (!OrientationUtils.isInLandscape(activity)) {
                i11 = InstabugDeviceProperties.isTablet(activity) ? 25 : 38;
            } else if (InstabugDeviceProperties.isTablet(activity)) {
                i11 = 40;
            }
            return (int) (((float) ((displayHeightInPx * i11) / 100)) * activity.getResources().getConfiguration().fontScale);
        }
        if (!InstabugDeviceProperties.isTablet(activity)) {
            i11 = OrientationUtils.isInLandscape(activity) ? 75 : 52;
        } else if (OrientationUtils.isInLandscape(activity)) {
            i11 = 60;
        }
        return (int) (((float) ((displayHeightInPx * i11) / 100)) * activity.getResources().getConfiguration().fontScale);
        i11 = 45;
        return (int) (((float) ((displayHeightInPx * i11) / 100)) * activity.getResources().getConfiguration().fontScale);
    }
}
