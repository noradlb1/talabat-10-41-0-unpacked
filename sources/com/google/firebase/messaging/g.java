package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class g implements EventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging.AutoInit f47430a;

    public /* synthetic */ g(FirebaseMessaging.AutoInit autoInit) {
        this.f47430a = autoInit;
    }

    public final void handle(Event event) {
        this.f47430a.lambda$initialize$0(event);
    }
}
