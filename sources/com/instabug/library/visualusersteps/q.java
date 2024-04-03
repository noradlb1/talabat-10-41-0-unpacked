package com.instabug.library.visualusersteps;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;
import java.util.List;

class q implements Consumer {
    public q(r rVar) {
    }

    /* renamed from: a */
    public void accept(List list) {
        if (list != null && !list.isEmpty()) {
            InstabugSDKLogger.e("IBG-Core", "Can't clean visual user steps directory");
        }
    }
}
