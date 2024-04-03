package com.instabug.library.sessionV3.sync;

import com.facebook.AuthenticationTokenClaims;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.v3Session.IBGSessionData;
import com.instabug.library.model.v3Session.c0;
import com.instabug.library.model.v3Session.g;
import com.instabug.library.model.v3Session.h;
import com.instabug.library.model.v3Session.j;
import com.instabug.library.model.v3Session.l;
import com.instabug.library.sessionV3.cache.SessionCacheManager;
import com.instabug.library.sessionV3.cache.e;
import com.instabug.library.sessionV3.configurations.c;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import ld.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class a0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f51824a = new a0();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51825b = LazyKt__LazyJVMKt.lazy(y.f51859a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Lazy f51826c = LazyKt__LazyJVMKt.lazy(u.f51855a);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Lazy f51827d = LazyKt__LazyJVMKt.lazy(z.f51860a);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Lazy f51828e = LazyKt__LazyJVMKt.lazy(v.f51856a);

    private a0() {
    }

    /* access modifiers changed from: private */
    public static final Map b(FeatureSessionDataController featureSessionDataController, List list) {
        Intrinsics.checkNotNullParameter(list, "$sessionsIds");
        return featureSessionDataController.collectSessionsData(list);
    }

    private final c c() {
        return (c) f51826c.getValue();
    }

    private final e d() {
        return (e) f51828e.getValue();
    }

    private final List e() {
        List c11 = com.instabug.library.core.plugin.c.c();
        Intrinsics.checkNotNullExpressionValue(c11, "getFeaturesSessionDataControllers()");
        return c11;
    }

    private final List f() {
        List<g> querySessions = g().querySessions(c0.READY_FOR_SYNC, Integer.valueOf(c().e()));
        if (!querySessions.isEmpty()) {
            return querySessions;
        }
        return null;
    }

    private final SessionCacheManager g() {
        return (SessionCacheManager) f51825b.getValue();
    }

    private final f h() {
        return (f) f51827d.getValue();
    }

    @Nullable
    public h a() {
        List f11;
        List f12 = f();
        a0 a0Var = f51824a;
        a0Var.e(f12);
        if (f12 == null || (f11 = f(f12)) == null) {
            return null;
        }
        return a0Var.h().a(f11);
    }

    private final void b(List list) {
        List<FeatureSessionDataController> e11 = e();
        ArrayList<Future> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(e11, 10));
        for (FeatureSessionDataController eVar : e11) {
            arrayList.add(PoolProvider.submitIOTask(new ld.e(eVar, list)));
        }
        for (Future future : arrayList) {
            future.get();
        }
        g().deleteSessionByID(list);
    }

    private final Set c(List list) {
        return SequencesKt___SequencesKt.toSet(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.flatMapIterable(CollectionsKt___CollectionsKt.asSequence(list), w.f51857a), x.f51858a));
    }

    private final List d(List list) {
        Object obj;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((g) it.next()).c());
        }
        try {
            Result.Companion companion = Result.Companion;
            List<FeatureSessionDataController> e11 = f51824a.e();
            ArrayList<Future> arrayList2 = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(e11, 10));
            for (FeatureSessionDataController fVar : e11) {
                arrayList2.add(PoolProvider.submitIOTask(new f(fVar, arrayList)));
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10));
            for (Future future : arrayList2) {
                arrayList3.add((Map) future.get());
            }
            obj = Result.m6329constructorimpl(arrayList3);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        String str = "";
        if (r02 != null) {
            String message = r02.getMessage();
            if (message == null) {
                message = str;
            }
            InstabugCore.reportError(r02, Intrinsics.stringPlus("couldn't collect data from other modules ", message));
        }
        Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
        if (r03 != null) {
            String message2 = r03.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("couldn't collect data from other modules ", str), r03);
        }
        Throwable r04 = Result.m6332exceptionOrNullimpl(obj);
        if (r04 != null) {
            IBGDiagnostics.reportNonFatal(r04, "error while collecting data from other modules");
        }
        if (Result.m6332exceptionOrNullimpl(obj) != null) {
            obj = CollectionsKt__CollectionsKt.emptyList();
        }
        return (List) obj;
    }

    private final void e(List list) {
        if (list == null || list.isEmpty()) {
            InstabugSDKLogger.d("IBG-Core", "No sessions ready for sync. Skipping...");
            return;
        }
        InstabugSDKLogger.d("IBG-Core", "Synced a batch of " + list.size() + " session/s.");
    }

    private final Map a(g gVar, Map map, List list) {
        j jVar = (j) map.get(Long.valueOf(gVar.e()));
        String b11 = jVar == null ? null : com.instabug.library.model.v3Session.c.b(jVar);
        List a11 = a(gVar, list);
        Map a12 = gVar.a((Map) new HashMap());
        if (b11 != null) {
            a12.put(AuthenticationTokenClaims.JSON_KEY_EXP, b11);
        }
        MapsKt__MapsKt.putAll(a12, a11);
        return a12;
    }

    private final List f(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((g) it.next()).e()));
        }
        List d11 = d(list);
        h().a((Iterable) c(d11));
        Map queryExperiments = d().queryExperiments(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f51824a.a((g) it2.next(), queryExperiments, d11));
        }
        return arrayList2;
    }

    public void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        g().changeSyncStatus(c0.READY_FOR_SYNC, c0.SYNCED, list);
        b(list);
    }

    public void b() {
        List<Pair<String, c0>> querySessionsIdsBySyncStatus = g().querySessionsIdsBySyncStatus(c0.SYNCED);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(querySessionsIdsBySyncStatus, 10));
        for (Pair a11 : querySessionsIdsBySyncStatus) {
            arrayList.add(com.instabug.library.sessionV3.cache.c.a(a11));
        }
        b(arrayList);
    }

    /* access modifiers changed from: private */
    public static final Unit a(FeatureSessionDataController featureSessionDataController, List list) {
        Intrinsics.checkNotNullParameter(list, "$sessionsIds");
        featureSessionDataController.dropSessionData(list);
        return Unit.INSTANCE;
    }

    private final List a(g gVar, List list) {
        ArrayList<IBGSessionData> arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            IBGSessionData iBGSessionData = (IBGSessionData) ((Map) it.next()).get(gVar.c());
            if (iBGSessionData != null) {
                arrayList.add(iBGSessionData);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (IBGSessionData a11 : arrayList) {
            arrayList2.add(l.f51616a.a(a11));
        }
        return arrayList2;
    }
}
