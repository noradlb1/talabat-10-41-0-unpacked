package com.instabug.library.diagnostics.network;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f34290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f34291b;

    public d(a aVar, List list) {
        this.f34290a = aVar;
        this.f34291b = list;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable RequestResponse requestResponse) {
        a aVar = this.f34290a;
        if (aVar != null) {
            aVar.a(this.f34291b);
        }
    }

    /* renamed from: a */
    public void onFailed(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        a aVar = this.f34290a;
        if (aVar != null) {
            aVar.onFailed(th2);
        }
    }
}
