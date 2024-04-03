package com.instabug.bug;

import android.content.Context;
import com.instabug.library.internal.orchestrator.Action;
import com.instabug.library.model.State;
import com.instabug.library.util.InstabugSDKLogger;

public class u implements Action {

    /* renamed from: a  reason: collision with root package name */
    private final Context f45790a;

    public u(Context context) {
        this.f45790a = context;
    }

    public void run() {
        if (this.f45790a != null) {
            InstabugSDKLogger.v("IBG-BR", "Start Building state");
            if (n.e().c() != null) {
                n.e().c().setState(new State.Builder(this.f45790a).build(false));
            }
            InstabugSDKLogger.v("IBG-BR", "State Building finished, sending event");
            v.a().post(State.Action.FINISHED);
        }
    }
}
