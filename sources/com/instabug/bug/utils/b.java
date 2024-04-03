package com.instabug.bug.utils;

import com.instabug.bug.model.d;
import com.instabug.bug.testingreport.a;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements DiskOperationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f45791a;

    public b(d dVar) {
        this.f45791a = dVar;
    }

    /* renamed from: a */
    public void onSuccess(@Nullable Boolean bool) {
        c.b(this.f45791a);
        a.f45789a.post(1);
    }

    public void onFailure(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "t");
        InstabugSDKLogger.e("IBG-BR", Intrinsics.stringPlus("Deleting attachment file failed due to: ", th2.getMessage()), th2);
        a.f45789a.post(1);
    }
}
