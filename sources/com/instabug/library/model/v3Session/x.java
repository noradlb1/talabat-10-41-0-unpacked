package com.instabug.library.model.v3Session;

import com.instabug.library.sessionV3.providers.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class x {
    private x() {
    }

    public /* synthetic */ x(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final y a(@NotNull g gVar) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(gVar, "userDataProvider");
        String uuid = gVar.getUuid();
        String l11 = gVar.l();
        String f11 = gVar.f();
        boolean m11 = gVar.m();
        if (gVar.m()) {
            str = gVar.a(gVar.j());
        } else {
            str = gVar.b(gVar.j());
        }
        String str3 = str;
        if (gVar.m()) {
            str2 = gVar.a(gVar.n());
        } else {
            str2 = gVar.b(gVar.n());
        }
        return new y(uuid, l11, f11, str2, m11, str3);
    }
}
