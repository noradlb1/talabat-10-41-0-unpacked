package com.instabug.library;

import com.instabug.library.logging.InstabugLog;
import com.instabug.library.logging.d;

class t implements Runnable {
    public t(c0 c0Var) {
    }

    public void run() {
        d.b();
        InstabugLog.trimLogs();
    }
}
