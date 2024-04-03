package com.instabug.bug.view.actionList.service;

import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;

class b implements Runnable {
    public b(c cVar) {
    }

    public void run() {
        if (Instabug.getApplicationContext() != null) {
            try {
                d.e();
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-BR", "Error occurred while getting report categories", e11);
            }
        } else {
            InstabugSDKLogger.d("IBG-BR", "Context was null while getting report categories");
        }
    }
}
