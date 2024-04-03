package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class e implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f47426a;

    public /* synthetic */ e(String str) {
        this.f47426a = str;
    }

    public final Task then(Object obj) {
        return ((TopicsSubscriber) obj).subscribeToTopic(this.f47426a);
    }
}
