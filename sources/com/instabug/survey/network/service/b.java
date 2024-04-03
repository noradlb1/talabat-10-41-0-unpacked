package com.instabug.survey.network.service;

import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;

class b implements Runnable {
    public b(c cVar) {
    }

    public void run() {
        if (Instabug.getApplicationContext() != null) {
            try {
                c.b(Instabug.getApplicationContext());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Surveys", "Error " + e11.getMessage() + " occurred while submitting survey", e11);
            }
        } else {
            InstabugSDKLogger.d("IBG-Surveys", "Context was null while submitting surveys");
        }
    }
}
