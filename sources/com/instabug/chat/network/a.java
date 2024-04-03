package com.instabug.chat.network;

import com.instabug.chat.cache.k;
import com.instabug.library.Instabug;
import com.instabug.library.util.InstabugSDKLogger;

class a implements Runnable {
    public a(f fVar) {
    }

    public void run() {
        if (Instabug.getApplicationContext() != null) {
            try {
                f.c();
                f.b(k.f());
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-BR", "Error " + e11.getMessage() + " occurred while uploading messages", e11);
            }
        } else {
            InstabugSDKLogger.e("IBG-BR", "Context was null while uploading messages");
        }
    }
}
