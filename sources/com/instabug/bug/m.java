package com.instabug.bug;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class m implements Consumer {
    public m(n nVar) {
    }

    /* renamed from: a */
    public void accept(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "something went wrong while getting Visual User Steps File Observable", th2);
    }
}
