package com.instabug.library.diagnostics.network;

import com.instabug.library.diagnostics.mappers.b;
import com.instabug.library.diagnostics.nonfatals.di.a;
import com.instabug.library.networkv2.INetworkManager;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class e implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final List f34292a = CollectionsKt__CollectionsKt.listOf(a.h(), com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.d(), com.instabug.library.diagnostics.customtraces.di.a.f34228a.f());

    private final INetworkManager b() {
        return com.instabug.library.diagnostics.di.a.d();
    }

    private final SettingsManager c() {
        SettingsManager instance = SettingsManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    private final boolean d() {
        if (System.currentTimeMillis() - c().getDiagnosticsLastSyncTime() >= ((long) c().getDiagnosticsSyncInterval()) * 60000) {
            return true;
        }
        return false;
    }

    @NotNull
    public String a() {
        return b.a(this);
    }

    public void a(@Nullable a aVar) {
        Object obj;
        List list = this.f34292a;
        if (!d()) {
            list = null;
        }
        if (list != null) {
            InstabugSDKLogger.d("IBG-Core", "Sync Interval Passed syncing some exceptions");
            try {
                Result.Companion companion = Result.Companion;
                a(list, aVar);
                obj = Result.m6329constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
            if (!(r12 == null || aVar == null)) {
                aVar.onFailed(r12);
            }
            Result.m6328boximpl(obj);
        }
    }

    private final void a(List list, a aVar) {
        boolean z11;
        List unused = CollectionsKt__CollectionsKt.emptyList();
        ArrayList<Pair> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((com.instabug.library.diagnostics.mappers.a) it.next()).a());
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Pair a11 : arrayList) {
            arrayList2.add(b.a(a11));
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                z11 = true;
                if (!b.b((Pair) it2.next())) {
                    break;
                }
            }
        }
        z11 = false;
        if (z11) {
            a(a((List) arrayList2), aVar);
        }
    }

    private final Unit a(Request request, a aVar) {
        Unit unit;
        if (request == null) {
            unit = null;
        } else {
            INetworkManager b11 = b();
            List<RequestParameter> requestBodyParameters = request.getRequestBodyParameters();
            Intrinsics.checkNotNullExpressionValue(requestBodyParameters, "request.requestBodyParameters");
            b11.doRequestOnSameThread(1, request, a(aVar, (List) requestBodyParameters));
            unit = Unit.INSTANCE;
        }
        if (unit != null) {
            return unit;
        }
        if (aVar == null) {
            return null;
        }
        aVar.onFailed(new com.instabug.library.diagnostics.nonfatals.networking.a("Request object can't be null"));
        return Unit.INSTANCE;
    }

    private final d a(a aVar, List list) {
        return new d(aVar, list);
    }

    private final Request a(List list) {
        Request.Builder method = new Request.Builder().url(a()).method("POST");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            method.addParameter((RequestParameter) it.next());
        }
        Request build = method.shorten(false).hasUuid(false).disableDefaultParameters(true).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .url(D…rs(true)\n        .build()");
        return build;
    }
}
