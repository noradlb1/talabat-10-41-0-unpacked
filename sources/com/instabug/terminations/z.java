package com.instabug.terminations;

import android.content.Context;
import com.instabug.commons.b;
import com.instabug.commons.c;
import com.instabug.commons.logging.a;
import com.instabug.commons.snapshot.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class z extends g implements b {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final c f52676b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(@NotNull e eVar, @NotNull c cVar) {
        super(eVar);
        Intrinsics.checkNotNullParameter(eVar, "configurations");
        Intrinsics.checkNotNullParameter(cVar, "listenersRegistry");
        this.f52676b = cVar;
    }

    @NotNull
    /* renamed from: b */
    public x a(@NotNull Context context, @Nullable Object obj) {
        x xVar;
        Intrinsics.checkNotNullParameter(context, "ctx");
        w wVar = w.f52670a;
        if (obj instanceof x) {
            xVar = (x) obj;
        } else {
            xVar = null;
        }
        return w.a(wVar, context, xVar, (String) null, 4, (Object) null);
    }

    public void i() {
        this.f52676b.a(this);
    }

    public void j() {
        this.f52676b.b(this);
    }

    public void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "detection");
        synchronized (this) {
            if (!isShutdown()) {
                a.b(Intrinsics.stringPlus("Trm snapshot captor received detection: ", str));
                g();
                f().execute(new de.c(this, new y(str)));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a(z zVar, Function2 function2) {
        Intrinsics.checkNotNullParameter(zVar, "this$0");
        Intrinsics.checkNotNullParameter(function2, "$snapshotGetter");
        zVar.k(function2);
        zVar.h(zVar.e());
    }
}
