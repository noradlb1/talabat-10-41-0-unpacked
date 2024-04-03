package com.instabug.library.sessionV3.cache;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGDBManagerExtKt;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.model.State;
import com.instabug.library.model.v3Session.c;
import com.instabug.library.model.v3Session.j;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class e implements SessionExperimentsCacheManager {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f51766a = new e();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51767b = LazyKt__LazyJVMKt.lazy(d.f51765a);

    private e() {
    }

    private final IBGDbManager a() {
        return (IBGDbManager) f51767b.getValue();
    }

    public void insert(@NotNull j jVar) {
        Object obj;
        Intrinsics.checkNotNullParameter(jVar, State.KEY_EXPERIMENTS);
        IBGDbManager a11 = a();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(Long.valueOf(a11.insertWithOnConflictReplace("session_experiment_table", (String) null, c.a(jVar))));
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
            InstabugCore.reportError(r02, Intrinsics.stringPlus("something went wrong while inserting experiments", message));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            String message2 = r52.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("something went wrong while inserting experiments", str), r52);
        }
    }

    @NotNull
    public Map queryExperiments(@NotNull List list) {
        Object obj;
        HashMap hashMap;
        Intrinsics.checkNotNullParameter(list, "sessionsSerials");
        IBGDbManager a11 = a();
        Map map = null;
        try {
            Result.Companion companion = Result.Companion;
            IBGCursor kQuery$default = IBGDBManagerExtKt.kQuery$default(a11, "session_experiment_table", (String[]) null, (String) null, (String) null, (String) null, (String) null, f51766a.a(list), 62, (Object) null);
            if (kQuery$default == null) {
                hashMap = null;
            } else {
                hashMap = c.a(kQuery$default);
            }
            obj = Result.m6329constructorimpl(hashMap);
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
            InstabugCore.reportError(r12, Intrinsics.stringPlus("something went wrong while querying experiments", message));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        if (r13 != null) {
            String message2 = r13.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("something went wrong while querying experiments", str), r13);
        }
        if (!Result.m6335isFailureimpl(obj)) {
            map = obj;
        }
        Map map2 = map;
        if (map2 == null) {
            return MapsKt__MapsKt.emptyMap();
        }
        return map2;
    }

    private final Pair a(List list) {
        String stringPlus = Intrinsics.stringPlus("session_serial IN ", IBGDBManagerExtKt.joinToArgs(list));
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return TuplesKt.to(stringPlus, IBGDBManagerExtKt.asArgs$default(arrayList, false, 1, (Object) null));
    }
}
