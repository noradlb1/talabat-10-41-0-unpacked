package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f47421a;

    public /* synthetic */ b(String str) {
        this.f47421a = str;
    }

    public final Task then(Object obj) {
        return ((TopicsSubscriber) obj).unsubscribeFromTopic(this.f47421a);
    }
}
