package com.instabug.library;

import com.instabug.library.core.eventbus.NDKSessionCrashedEvent;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.functions.Consumer;

class a0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f50529b;

    public a0(c0 c0Var) {
        this.f50529b = c0Var;
    }

    /* renamed from: a */
    public void accept(NDKSessionCrashedEvent nDKSessionCrashedEvent) {
        InstabugSDKLogger.d("IBG-Core", "NDK crashing session found. Sync old sessions");
        PoolProvider.postIOTask(new z(this));
    }
}
