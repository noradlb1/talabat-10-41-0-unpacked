package com.instabug.library.sessionV3.sync;

import com.instabug.library.model.v3Session.c0;
import com.instabug.library.util.TimeUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ld.a;
import ld.b;
import ld.c;
import ld.d;
import org.jetbrains.annotations.NotNull;

public final class SessionBatchingFilterKt {
    @NotNull
    private static final SessionBatchingFilter AllFilter = new d();
    @NotNull
    private static final SessionBatchingFilter DataReadinessFilter = new b();
    @NotNull
    private static final SessionBatchingFilter IntervalAndLimitFilter = new a();
    @NotNull
    private static final SessionBatchingFilter NoneFilter = new c();

    /* access modifiers changed from: private */
    /* renamed from: AllFilter$lambda-8  reason: not valid java name */
    public static final List m9385AllFilter$lambda8(List list) {
        Intrinsics.checkNotNullParameter(list, "sessions");
        List<Pair<String, c0>> invoke = DataReadinessFilter.invoke(list);
        List<Pair<String, c0>> invoke2 = IntervalAndLimitFilter.invoke(invoke);
        if (!invoke2.isEmpty()) {
            invoke2 = null;
        }
        if (invoke2 == null) {
            return invoke;
        }
        return invoke2;
    }

    /* access modifiers changed from: private */
    /* renamed from: DataReadinessFilter$lambda-5  reason: not valid java name */
    public static final List m9386DataReadinessFilter$lambda5(List list) {
        Intrinsics.checkNotNullParameter(list, "sessions");
        Map a11 = b.f51829a.a(getIdsList(getOfflineSessions(list)));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : a11.entrySet()) {
            if (((Boolean) entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry key : linkedHashMap.entrySet()) {
            arrayList.add(new Pair(key.getKey(), c0.OFFLINE));
        }
        return CollectionsKt___CollectionsKt.plus(arrayList, getReadySessions(list));
    }

    /* access modifiers changed from: private */
    /* renamed from: IntervalAndLimitFilter$lambda-1  reason: not valid java name */
    public static final List m9387IntervalAndLimitFilter$lambda1(List list) {
        Intrinsics.checkNotNullParameter(list, "sessions");
        if (shouldSync(getIdsList(list))) {
            return list;
        }
        return CollectionsKt__CollectionsKt.emptyList();
    }

    /* access modifiers changed from: private */
    /* renamed from: NoneFilter$lambda-6  reason: not valid java name */
    public static final List m9388NoneFilter$lambda6(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        return list;
    }

    @NotNull
    public static final SessionBatchingFilter getAllFilter() {
        return AllFilter;
    }

    @NotNull
    public static final SessionBatchingFilter getDataReadinessFilter() {
        return DataReadinessFilter;
    }

    private static final List<String> getIdsList(List<? extends Pair<String, ? extends c0>> list) {
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (Pair a11 : list) {
            arrayList.add(com.instabug.library.sessionV3.cache.c.a(a11));
        }
        return arrayList;
    }

    @NotNull
    public static final SessionBatchingFilter getIntervalAndLimitFilter() {
        return IntervalAndLimitFilter;
    }

    @NotNull
    public static final SessionBatchingFilter getNoneFilter() {
        return NoneFilter;
    }

    private static final List<Pair<String, c0>> getOfflineSessions(List<? extends Pair<String, ? extends c0>> list) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (com.instabug.library.sessionV3.cache.c.b((Pair) next) == c0.OFFLINE) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static final List<Pair<String, c0>> getReadySessions(List<? extends Pair<String, ? extends c0>> list) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            if (com.instabug.library.sessionV3.cache.c.b((Pair) next) == c0.READY_FOR_SYNC) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private static final boolean isSessionsReachedRequestLimit(com.instabug.library.sessionV3.configurations.c cVar, List<String> list) {
        return list.size() >= cVar.e();
    }

    private static final boolean isSyncIntervalPassed(com.instabug.library.sessionV3.configurations.c cVar) {
        long currentTimeMillis = TimeUtils.currentTimeMillis() - cVar.h();
        if (cVar.h() == -1 || cVar.d() <= TimeUnit.MILLISECONDS.toMinutes(currentTimeMillis)) {
            return true;
        }
        return false;
    }

    private static final boolean shouldSync(List<String> list) {
        com.instabug.library.sessionV3.configurations.c l11 = com.instabug.library.sessionV3.di.c.l();
        if (isSessionsReachedRequestLimit(l11, list) || isSyncIntervalPassed(l11) || l11.c()) {
            return true;
        }
        return false;
    }
}
