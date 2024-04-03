package com.instabug.library.internal.resolver;

import com.instabug.library.internal.dataretention.core.c;
import com.instabug.library.internal.dataretention.files.d;
import com.instabug.library.internal.orchestrator.ActionsOrchestrator;
import com.instabug.library.internal.orchestrator.b;
import com.instabug.library.util.InstabugSDKLogger;

class a implements b {
    public a(c cVar) {
    }

    public void a(int i11) {
        InstabugSDKLogger.onDiskLoggingLevelChanged(i11);
        if (i11 == 0) {
            ActionsOrchestrator.obtainOrchestrator().addWorkerThreadAction(new b(d.b(), new c[0])).orchestrate();
        }
    }
}
