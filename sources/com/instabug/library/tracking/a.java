package com.instabug.library.tracking;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.invocation.invocationdialog.InstabugDialogActivity;

public class a implements Application.ActivityLifecycleCallbacks {
    public void a(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
    }

    public void onActivityDestroyed(@NonNull Activity activity) {
    }

    public void onActivityPaused(@NonNull Activity activity) {
    }

    public void onActivityResumed(@NonNull Activity activity) {
        a(activity);
    }

    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
    }

    public void onActivityStarted(@NonNull Activity activity) {
        Activity currentRealActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentRealActivity();
        if (currentRealActivity instanceof InstabugDialogActivity) {
            currentRealActivity.finish();
        }
        a(activity);
    }

    public void onActivityStopped(@NonNull Activity activity) {
    }

    private void a(@NonNull Activity activity) {
        InstabugInternalTrackingDelegate instance = InstabugInternalTrackingDelegate.getInstance();
        if (instance != null) {
            instance.setCurrentActivity(activity);
        }
    }
}
