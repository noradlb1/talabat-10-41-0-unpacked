package com.instabug.survey.ui.popup;

import com.google.android.gms.tasks.Task;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.b;

class p implements b {
    public p(q qVar) {
    }

    public void onComplete(Task task) {
        InstabugSDKLogger.d("IBG-Surveys", "Google Play In-app review ready to show");
    }

    public void onFailure(Exception exc) {
        InstabugSDKLogger.e("IBG-Surveys", "Showing Google Play In-app review failed", exc);
    }
}
