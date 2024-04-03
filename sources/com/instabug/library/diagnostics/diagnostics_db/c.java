package com.instabug.library.diagnostics.diagnostics_db;

import android.content.Context;
import com.instabug.library.Instabug;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class c {
    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public final synchronized void a(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "helper");
        if (m.f34274c == null) {
            m.f34274c = new m((DefaultConstructorMarker) null);
            m.f34275d = bVar;
        }
    }

    @JvmStatic
    @NotNull
    public final synchronized m a() {
        m a11;
        a11 = m.f34274c;
        if (a11 == null) {
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext == null) {
                a11 = null;
            } else {
                m.f34273b.a(new b(applicationContext));
                a11 = m.f34274c;
            }
            if (a11 == null) {
                throw new IllegalStateException("IBG-Core is not initialized, call init(..) method first.");
            }
        }
        return a11;
    }
}
