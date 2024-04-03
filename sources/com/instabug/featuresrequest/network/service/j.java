package com.instabug.featuresrequest.network.service;

import com.instabug.library.util.InstabugSDKLogger;

class j implements Runnable {
    public j(l lVar) {
    }

    public void run() {
        try {
            l.c();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-FR", "Error " + e11.getMessage() + "occurred while voting for feature", e11);
        }
    }
}
