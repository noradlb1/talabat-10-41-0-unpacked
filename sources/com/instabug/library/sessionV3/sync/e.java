package com.instabug.library.sessionV3.sync;

import com.instabug.library.model.v3Session.c0;
import com.instabug.library.sessionV3.cache.SessionCacheManager;
import com.instabug.library.sessionV3.cache.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class e implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final e f51831a = new e();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51832b = LazyKt__LazyJVMKt.lazy(d.f51830a);

    private e() {
    }

    private final SessionCacheManager a() {
        return (SessionCacheManager) f51832b.getValue();
    }

    public void a(@NotNull SessionBatchingFilter sessionBatchingFilter) {
        Intrinsics.checkNotNullParameter(sessionBatchingFilter, "batchingFilter");
        List<Pair<String, c0>> invoke = sessionBatchingFilter.invoke(a(a()));
        if (!(!invoke.isEmpty())) {
            invoke = null;
        }
        if (invoke != null) {
            ArrayList<Pair> arrayList = new ArrayList<>();
            for (T next : invoke) {
                if (c.b((Pair) next) == c0.OFFLINE) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
            for (Pair a11 : arrayList) {
                arrayList2.add(c.a(a11));
            }
            a((List) arrayList2);
        }
    }

    private final List a(SessionCacheManager sessionCacheManager) {
        return sessionCacheManager.querySessionsIdsBySyncStatus(c0.OFFLINE, c0.READY_FOR_SYNC);
    }

    private final Unit a(List list) {
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        f51831a.a().changeSyncStatus(c0.OFFLINE, c0.READY_FOR_SYNC, list);
        return Unit.INSTANCE;
    }
}
