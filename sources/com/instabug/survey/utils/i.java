package com.instabug.survey.utils;

import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.settings.c;

class i implements Runnable {
    public void run() {
        try {
            if (c.g() != null) {
                c.g().onDismiss();
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "AfterShowingSurveyRunnable has been failed to run.", e11);
        }
    }
}
