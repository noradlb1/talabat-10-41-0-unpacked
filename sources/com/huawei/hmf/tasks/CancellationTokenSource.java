package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.c;

public class CancellationTokenSource {
    private c impl = new c();

    public void cancel() {
        c cVar = this.impl;
        if (!cVar.f47675c) {
            synchronized (cVar.f47674b) {
                cVar.f47675c = true;
                for (Runnable run : cVar.f47673a) {
                    run.run();
                }
            }
        }
    }

    public CancellationToken getToken() {
        return this.impl;
    }
}
