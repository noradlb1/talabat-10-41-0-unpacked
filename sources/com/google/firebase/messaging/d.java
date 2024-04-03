package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class d implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f47425a;

    public /* synthetic */ d(FirebaseMessaging firebaseMessaging) {
        this.f47425a = firebaseMessaging;
    }

    public final void onSuccess(Object obj) {
        this.f47425a.lambda$new$2((TopicsSubscriber) obj);
    }
}
