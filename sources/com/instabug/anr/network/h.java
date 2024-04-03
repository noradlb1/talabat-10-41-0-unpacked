package com.instabug.anr.network;

import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;

class h implements Runnable {
    public h(i iVar) {
    }

    public void run() {
        if (Instabug.getApplicationContext() != null) {
            try {
                i.b(Instabug.getApplicationContext());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-CR", "Error " + e11.getMessage() + " occurred while uploading ANRs", e11);
            }
        } else {
            InstabugSDKLogger.e("IBG-CR", "Couldn't upload ANRs due to null context");
        }
    }
}
