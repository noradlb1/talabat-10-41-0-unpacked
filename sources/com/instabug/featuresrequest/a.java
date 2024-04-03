package com.instabug.featuresrequest;

import android.app.Activity;
import android.content.Intent;
import com.instabug.featuresrequest.ui.FeaturesRequestActivity;
import com.instabug.featuresrequest.utils.d;
import com.instabug.library.Feature;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;

public abstract class a {
    public static void a() {
        Activity currentActivity;
        if (d.a() && d.b() && Instabug.isAppOnForeground() && !InstabugCore.isForegroundBusy() && (currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity()) != null) {
            currentActivity.startActivity(new Intent(currentActivity, FeaturesRequestActivity.class));
        }
    }

    public static void a(Feature.State state) {
        InstabugCore.setFeatureState(Feature.FEATURE_REQUESTS, state);
        InvocationManager.getInstance().notifyInvocationOptionChanged();
    }

    public static void a(boolean z11, int... iArr) {
        if (iArr == null || iArr.length == 0) {
            com.instabug.featuresrequest.settings.a.a().b(z11);
            com.instabug.featuresrequest.settings.a.a().a(z11);
            return;
        }
        for (int i11 : iArr) {
            if (i11 == 2) {
                com.instabug.featuresrequest.settings.a.a().b(z11);
            } else if (i11 == 4) {
                com.instabug.featuresrequest.settings.a.a().a(z11);
            }
        }
    }
}
