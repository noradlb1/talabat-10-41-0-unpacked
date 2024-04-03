package com.instabug.chat.cache;

import com.instabug.library.util.InstabugSDKLogger;

class b implements Runnable {
    public void run() {
        try {
            k.a();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "failed to clean chat cache " + e11.getMessage());
        }
    }
}
