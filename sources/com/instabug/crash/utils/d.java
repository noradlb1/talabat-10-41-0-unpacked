package com.instabug.crash.utils;

import com.instabug.anr.model.b;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d implements DiskOperationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f46451a;

    public d(b bVar) {
        this.f46451a = bVar;
    }

    /* renamed from: a */
    public void onSuccess(@Nullable Boolean bool) {
        e.a(this.f46451a);
    }

    public void onFailure(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "t");
        InstabugSDKLogger.e("IBG-CR", "Error while deleting ANR state file", th2);
    }
}
