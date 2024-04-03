package com.instabug.survey.announcements.network;

import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;

class f implements Runnable {
    public f(g gVar) {
    }

    public void run() {
        if (Instabug.getApplicationContext() != null) {
            try {
                g.b(Instabug.getApplicationContext());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Surveys", "Error " + e11.getMessage() + " occurred while submitting announcements", e11);
            }
        } else {
            InstabugSDKLogger.d("IBG-Surveys", "Context was null while trying to submit announcements");
        }
    }
}
