package com.instabug.survey.utils;

import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.settings.c;

class h implements Runnable {
    public void run() {
        try {
            if (c.i() != null) {
                c.i().onShow();
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Surveys", "AfterShowingSurveyRunnable has been failed to run.", e11);
        }
    }
}
