package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class c implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f47422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f47423b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f47424c;

    public /* synthetic */ c(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f47422a = firebaseMessaging;
        this.f47423b = str;
        this.f47424c = token;
    }

    public final Task then(Object obj) {
        return this.f47422a.lambda$blockingGetToken$9(this.f47423b, this.f47424c, (String) obj);
    }
}
