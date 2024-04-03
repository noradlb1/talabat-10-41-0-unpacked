package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class f implements RequestDeduplicator.GetTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f47427a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47428b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f47429c;

    public /* synthetic */ f(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f47427a = firebaseMessaging;
        this.f47428b = str;
        this.f47429c = token;
    }

    public final Task start() {
        return this.f47427a.lambda$blockingGetToken$10(this.f47428b, this.f47429c);
    }
}
