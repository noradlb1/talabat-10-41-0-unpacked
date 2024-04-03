package com.instabug.library.internal.orchestrator;

import com.instabug.library.logging.e;
import com.instabug.library.user.f;
import java.util.Map;

public class h implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final String f51000a;

    public h(String str) {
        this.f51000a = str;
    }

    public void run() throws Exception {
        for (Map.Entry entry : e.b().entrySet()) {
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            if (!e.a(str, this.f51000a)) {
                e.a(str, intValue, this.f51000a, !f.p());
            }
        }
        e.a();
    }
}
