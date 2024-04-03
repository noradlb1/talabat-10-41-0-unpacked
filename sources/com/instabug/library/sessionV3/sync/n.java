package com.instabug.library.sessionV3.sync;

import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.model.v3Session.h;
import com.instabug.library.model.v3Session.l;
import com.instabug.library.networkv2.INetworkManager;
import com.instabug.library.networkv2.limitation.RateLimiter;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.sessionV3.configurations.c;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class n extends InstabugNetworkJob {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final n f51841a = new n();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51842b = LazyKt__LazyJVMKt.lazy(m.f51840a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f51843c = LazyKt__LazyJVMKt.lazy(j.f51837a);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f51844d = LazyKt__LazyJVMKt.lazy(h.f51835a);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Lazy f51845e = LazyKt__LazyJVMKt.lazy(l.f51839a);

    private n() {
    }

    /* access modifiers changed from: private */
    public static final void e() {
        Object obj;
        n nVar = f51841a;
        try {
            Result.Companion companion = Result.Companion;
            nVar.d().b();
            nVar.f();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r12 != null) {
            String message = r12.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something Went Wrong while syncing Sessions", message));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            String message2 = r02.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something Went Wrong while syncing Sessions", str), r02);
        }
    }

    /* access modifiers changed from: private */
    public final void f() {
        h a11 = d().a();
        if (a11 != null) {
            a(a11);
        }
    }

    public void start() {
        b(IBGNetworkWorker.CORE, new ld.h());
    }

    /* access modifiers changed from: private */
    public final c a() {
        return (c) f51844d.getValue();
    }

    private final INetworkManager b() {
        return (INetworkManager) f51843c.getValue();
    }

    /* access modifiers changed from: private */
    public final RateLimiter c() {
        return (RateLimiter) f51845e.getValue();
    }

    /* access modifiers changed from: private */
    public final a0 d() {
        return (a0) f51842b.getValue();
    }

    private final i a(List list) {
        return new i(list);
    }

    private final Unit a(h hVar) {
        Request a11;
        n nVar = f51841a;
        h hVar2 = !nVar.c().applyIfPossible(hVar.c()) ? hVar : null;
        if (hVar2 == null || (a11 = l.a(l.f51616a, hVar2, (c) null, 1, (Object) null)) == null) {
            return null;
        }
        nVar.a(a11, hVar.c());
        return Unit.INSTANCE;
    }

    private final void a(Request request, List list) {
        b().doRequestOnSameThread(1, request, a(list));
    }
}
