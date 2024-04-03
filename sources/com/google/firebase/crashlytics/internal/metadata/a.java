package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserMetadata.SerializeableKeysMap f47378b;

    public /* synthetic */ a(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.f47378b = serializeableKeysMap;
    }

    public final Object call() {
        return this.f47378b.lambda$scheduleSerializationTaskIfNeeded$0();
    }
}
