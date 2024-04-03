package com.instabug.fatalhangs.sync;

import com.instabug.crash.settings.b;
import com.instabug.fatalhangs.model.c;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

public final class g implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f46500a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f46501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f46502c;

    public g(c cVar, i iVar, Ref.ObjectRef objectRef) {
        this.f46500a = cVar;
        this.f46501b = iVar;
        this.f46502c = objectRef;
    }

    /* renamed from: a */
    public void onSucceeded(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        b.a().setLastRequestStartedAt(0);
        c cVar = this.f46500a;
        cVar.f(str);
        cVar.a(2);
        this.f46501b.f46508b.a(this.f46500a);
        this.f46501b.c(this.f46500a);
    }

    /* renamed from: a */
    public void onFailed(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        if (th2 instanceof RateLimitedException) {
            this.f46501b.a(this.f46500a, (RateLimitedException) th2);
        } else {
            InstabugSDKLogger.e("IBG-CR", "Failed to send fatal hang", th2);
        }
        this.f46502c.element = null;
    }
}
