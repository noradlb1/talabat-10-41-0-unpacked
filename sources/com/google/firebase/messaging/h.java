package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class h implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GmsRpc f47431a;

    public /* synthetic */ h(GmsRpc gmsRpc) {
        this.f47431a = gmsRpc;
    }

    public final Object then(Task task) {
        return this.f47431a.lambda$extractResponseWhenComplete$0(task);
    }
}
