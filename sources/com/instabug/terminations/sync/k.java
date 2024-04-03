package com.instabug.terminations.sync;

import android.content.Context;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.limitation.RateLimiter;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.terminations.di.d;
import com.instabug.terminations.model.b;
import fe.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class k extends InstabugNetworkJob {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f52661a = LazyKt__LazyJVMKt.lazy(f.f52654a);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f52662b = LazyKt__LazyJVMKt.lazy(h.f52656a);

    /* access modifiers changed from: private */
    public final void c(b bVar) {
        if (bVar.c() != 2) {
            a(bVar);
            return;
        }
        Request b11 = new d().b(bVar);
        j jVar = new j(bVar, this);
        InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("Uploading logs for termination ", Long.valueOf(bVar.b())));
        a().doRequestOnSameThread(1, b11, (Request.Callbacks<RequestResponse, Throwable>) jVar);
    }

    public void start() {
        b("terminations-sync", new a(this));
    }

    /* access modifiers changed from: private */
    public final RateLimiter b() {
        return (RateLimiter) this.f52662b.getValue();
    }

    /* access modifiers changed from: private */
    public static final void b(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "this$0");
        InstabugSDKLogger.d("IBG-CR", "Starting terminations sync job");
        d dVar = d.f52610a;
        Context a11 = dVar.a();
        if (a11 != null) {
            List a12 = dVar.b().a(a11);
            ArrayList<b> arrayList = new ArrayList<>();
            for (Object next : a12) {
                if (((b) next).c() > 0) {
                    arrayList.add(next);
                }
            }
            for (b bVar : arrayList) {
                bVar.a(a11);
                kVar.b(bVar);
            }
        }
    }

    private final NetworkManager a() {
        return (NetworkManager) this.f52661a.getValue();
    }

    /* access modifiers changed from: private */
    public final void a(b bVar) {
        if (bVar.c() == 3) {
            d dVar = d.f52610a;
            Context a11 = dVar.a();
            if (a11 != null) {
                dVar.b().a(a11, bVar);
            }
            bVar.a();
        }
    }

    /* access modifiers changed from: private */
    public final Object a(Object obj, Object obj2, String str) {
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 == null) {
            return obj;
        }
        InstabugSDKLogger.e("IBG-CR", str, r02);
        InstabugCore.reportError(r02, str);
        return obj2;
    }

    private final void b(b bVar) {
        if (bVar.c() != 1) {
            c(bVar);
        } else if (!b().applyIfPossible(bVar)) {
            Request a11 = new d().a(bVar);
            i iVar = new i(this, bVar);
            InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("Reporting termination ", Long.valueOf(bVar.b())));
            a().doRequestOnSameThread(1, a11, (Request.Callbacks<RequestResponse, Throwable>) iVar);
        }
    }
}
