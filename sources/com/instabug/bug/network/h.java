package com.instabug.bug.network;

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
                InstabugSDKLogger.e("IBG-BR", "Error occurred while uploading bugs", e11);
            }
        } else {
            InstabugSDKLogger.d("IBG-BR", "Context was null during Bugs syncing");
        }
    }
}
