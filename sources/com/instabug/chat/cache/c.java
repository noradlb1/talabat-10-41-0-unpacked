package com.instabug.chat.cache;

import com.instabug.library.util.InstabugSDKLogger;

class c implements Runnable {
    public void run() {
        try {
            k.k();
            m.d();
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "failed to dump chat cache " + e11.getMessage());
        }
    }
}
