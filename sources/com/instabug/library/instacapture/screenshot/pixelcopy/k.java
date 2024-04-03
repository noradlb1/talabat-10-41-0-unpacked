package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.os.Handler;
import android.os.HandlerThread;
import kotlin.Lazy;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

public final class k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final k f34408a = new k();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f34409b = LazyKt__LazyJVMKt.lazy(j.f34407a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f34410c = LazyKt__LazyJVMKt.lazy(i.f34406a);

    private k() {
    }

    /* access modifiers changed from: private */
    public final HandlerThread b() {
        return (HandlerThread) f34409b.getValue();
    }

    @JvmStatic
    @NotNull
    public static final Handler a() {
        return (Handler) f34410c.getValue();
    }
}
