package com.instabug.crash.utils;

import com.instabug.crash.models.a;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class c implements DiskOperationCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f46450a;

    public c(a aVar) {
        this.f46450a = aVar;
    }

    /* renamed from: a */
    public void onSuccess(@Nullable Boolean bool) {
        InstabugSDKLogger.v("IBG-CR", Intrinsics.stringPlus("deleting crash:", this.f46450a.e()));
        e.b(this.f46450a);
    }

    public void onFailure(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "t");
        InstabugSDKLogger.e("IBG-CR", "Error " + th2.getMessage() + " while deleting crash state file");
    }
}
