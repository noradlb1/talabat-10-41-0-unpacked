package com.instabug.chat;

import com.instabug.chat.cache.k;
import com.instabug.chat.network.f;
import java.util.List;

class d implements Runnable {
    public void run() {
        List e11 = k.e();
        List f11 = k.f();
        if (!e11.isEmpty() || !f11.isEmpty()) {
            f.b().start();
        }
    }
}
