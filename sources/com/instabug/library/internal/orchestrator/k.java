package com.instabug.library.internal.orchestrator;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;

public class k implements Action {
    public void run() {
        SDKCoreEventPublisher.post(new SDKCoreEvent("user", SDKCoreEvent.User.VALUE_LOGGED_IN));
    }
}
