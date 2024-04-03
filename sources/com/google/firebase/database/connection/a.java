package com.google.firebase.database.connection;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import java.util.Map;

public final /* synthetic */ class a implements PersistentConnectionImpl.ConnectionRequestCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f47396a;

    public /* synthetic */ a(TaskCompletionSource taskCompletionSource) {
        this.f47396a = taskCompletionSource;
    }

    public final void onResponse(Map map) {
        PersistentConnectionImpl.lambda$get$0(this.f47396a, map);
    }
}
