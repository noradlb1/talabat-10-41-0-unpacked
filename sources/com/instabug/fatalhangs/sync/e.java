package com.instabug.fatalhangs.sync;

import com.instabug.fatalhangs.model.c;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f46497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f46498b;

    public e(c cVar, i iVar) {
        this.f46497a = cVar;
        this.f46498b = iVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable RequestResponse requestResponse) {
        this.f46497a.a(3);
        this.f46498b.f46508b.a(this.f46497a);
        this.f46498b.b(this.f46497a);
    }

    /* renamed from: a */
    public void onFailed(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        InstabugSDKLogger.e("IBG-CR", "Failed to send Fatal hang logs request", th2);
    }
}
