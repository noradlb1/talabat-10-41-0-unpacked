package com.instabug.library.model.v3Session;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.model.common.Session;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class n extends o {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Session f51618a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n(@NotNull Session session) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(session, SDKCoreEvent.Session.TYPE_SESSION);
        this.f51618a = session;
    }

    @NotNull
    public final Session a() {
        return this.f51618a;
    }
}
