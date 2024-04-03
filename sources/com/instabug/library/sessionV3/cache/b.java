package com.instabug.library.sessionV3.cache;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGDBManagerExtKt;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.model.v3Session.c0;
import com.instabug.library.model.v3Session.g;
import com.instabug.library.model.v3Session.l;
import com.instabug.library.sessionV3.cache.SessionCacheManager;
import com.instabug.library.sessionV3.configurations.c;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;
import jd.a;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements SessionCacheManager {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f51763a = new b();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Lazy f51764b = LazyKt__LazyJVMKt.lazy(a.f51762a);

    private b() {
    }

    private final c a() {
        return (c) f51764b.getValue();
    }

    private final IBGDbManager b() {
        return com.instabug.library.sessionV3.di.c.f51790a.d();
    }

    private final List c() {
        List c11 = com.instabug.library.core.plugin.c.c();
        Intrinsics.checkNotNullExpressionValue(c11, "getFeaturesSessionDataControllers()");
        return c11;
    }

    public void changeSyncStatus(@NotNull c0 c0Var, @NotNull c0 c0Var2, @Nullable List list) {
        Object obj;
        Pair pair;
        String str;
        Intrinsics.checkNotNullParameter(c0Var, "from");
        Intrinsics.checkNotNullParameter(c0Var2, "to");
        String str2 = "Something wen wrong while changing sync status from " + c0Var.name() + " to " + c0Var2.name();
        try {
            Result.Companion companion = Result.Companion;
            IBGContentValues iBGContentValues = new IBGContentValues();
            iBGContentValues.put("sync_status", c0Var2.name(), true);
            List<IBGWhereArg> list2 = null;
            if (list == null) {
                pair = null;
            } else {
                pair = b(list);
            }
            IBGDbManager b11 = b();
            if (pair == null) {
                str = null;
            } else {
                str = IBGDBManagerExtKt.getSelection(pair);
            }
            String and = IBGDBManagerExtKt.and("sync_status = ?", str);
            List listOf = CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg(c0Var.name(), true));
            if (pair != null) {
                list2 = IBGDBManagerExtKt.getArgs(pair);
            }
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            obj = Result.m6329constructorimpl(Integer.valueOf(b11.update(InstabugDbContract.SessionEntry.TABLE_NAME, iBGContentValues, and, CollectionsKt___CollectionsKt.plus(listOf, list2))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r92 = Result.m6332exceptionOrNullimpl(obj);
        String str3 = "";
        if (r92 != null) {
            String message = r92.getMessage();
            if (message == null) {
                message = str3;
            }
            InstabugCore.reportError(r92, Intrinsics.stringPlus(str2, message));
        }
        Throwable r82 = Result.m6332exceptionOrNullimpl(obj);
        if (r82 != null) {
            String message2 = r82.getMessage();
            if (message2 != null) {
                str3 = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus(str2, str3), r82);
        }
    }

    public void deleteAllSessions() {
        Object obj;
        IBGDbManager b11 = b();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(Integer.valueOf(IBGDBManagerExtKt.kDelete$default(b11, InstabugDbContract.SessionEntry.TABLE_NAME, (String) null, (List) null, 6, (Object) null)));
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
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while deleting all sessions", message));
        }
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 != null) {
            String message2 = r02.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while deleting all sessions", str), r02);
        }
    }

    public void deleteSessionByID(@NotNull List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "ids");
        IBGDbManager b11 = b();
        try {
            Result.Companion companion = Result.Companion;
            Pair b12 = f51763a.b(list);
            obj = Result.m6329constructorimpl(Integer.valueOf(IBGDBManagerExtKt.kDelete(b11, InstabugDbContract.SessionEntry.TABLE_NAME, IBGDBManagerExtKt.getSelection(b12), IBGDBManagerExtKt.getArgs(b12))));
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
            InstabugCore.reportError(r02, Intrinsics.stringPlus("Something went wrong while deleting session by id", message));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            String message2 = r52.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while deleting session by id", str), r52);
        }
    }

    public long insertOrUpdate(@NotNull g gVar) {
        boolean z11;
        g gVar2;
        Intrinsics.checkNotNullParameter(gVar, SDKCoreEvent.Session.TYPE_SESSION);
        if (gVar.e() == -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Long l11 = null;
        if (z11) {
            gVar2 = gVar;
        } else {
            gVar2 = null;
        }
        if (gVar2 != null) {
            b bVar = f51763a;
            SessionCacheManager.a.a(bVar, c0.RUNNING, c0.OFFLINE, (List) null, 4, (Object) null);
            l11 = Long.valueOf(bVar.a(gVar));
            l11.longValue();
            bVar.trimToLimit(bVar.a().k());
        }
        if (l11 == null) {
            return b(gVar);
        }
        return l11.longValue();
    }

    public void migrateUUID(@NotNull String str, @NotNull String str2) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "oldUUID");
        Intrinsics.checkNotNullParameter(str2, "newUUID");
        IBGDbManager b11 = b();
        try {
            Result.Companion companion = Result.Companion;
            IBGContentValues iBGContentValues = new IBGContentValues();
            iBGContentValues.put("uuid", str2, true);
            obj = Result.m6329constructorimpl(Integer.valueOf(b11.update(InstabugDbContract.SessionEntry.TABLE_NAME, iBGContentValues, "uuid = ?", CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg(str, true)))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r62 = Result.m6332exceptionOrNullimpl(obj);
        String str3 = "";
        if (r62 != null) {
            String message = r62.getMessage();
            if (message == null) {
                message = str3;
            }
            InstabugCore.reportError(r62, Intrinsics.stringPlus("Something went wrong while migrate old uuid to the new uuid", message));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            String message2 = r52.getMessage();
            if (message2 != null) {
                str3 = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while migrate old uuid to the new uuid", str3), r52);
        }
    }

    @Nullable
    public g queryLastSession() {
        Object obj;
        IBGDbManager b11 = b();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(IBGDBManagerExtKt.kQuery$default(b11, InstabugDbContract.SessionEntry.TABLE_NAME, (String[]) null, (String) null, (String) null, "session_serial DESC", "1", (Pair) null, 78, (Object) null));
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
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while getting the Last session", message));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        if (r13 != null) {
            String message2 = r13.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while getting the Last session", str), r13);
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        IBGCursor iBGCursor = (IBGCursor) obj;
        if (iBGCursor == null) {
            return null;
        }
        return l.f51616a.e(iBGCursor);
    }

    @NotNull
    public List querySessions(@Nullable c0 c0Var, @Nullable Integer num) {
        Object obj;
        Pair pair;
        String str;
        IBGDbManager b11 = b();
        List list = null;
        try {
            Result.Companion companion = Result.Companion;
            if (c0Var == null) {
                pair = null;
            } else {
                pair = f51763a.a(c0Var);
            }
            if (num == null) {
                str = null;
            } else {
                str = num.toString();
            }
            obj = Result.m6329constructorimpl(IBGDBManagerExtKt.kQuery$default(b11, InstabugDbContract.SessionEntry.TABLE_NAME, (String[]) null, (String) null, (String) null, (String) null, str, pair, 30, (Object) null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        String str2 = "";
        if (r13 != null) {
            String message = r13.getMessage();
            if (message == null) {
                message = str2;
            }
            InstabugCore.reportError(r13, Intrinsics.stringPlus("Something went wrong while query sessions", message));
        }
        Throwable r132 = Result.m6332exceptionOrNullimpl(obj);
        if (r132 != null) {
            String message2 = r132.getMessage();
            if (message2 != null) {
                str2 = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while query sessions", str2), r132);
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        IBGCursor iBGCursor = (IBGCursor) obj;
        if (iBGCursor != null) {
            list = l.f51616a.f(iBGCursor);
        }
        if (list == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list;
    }

    @NotNull
    public List querySessionsIdsBySyncStatus(@NotNull c0... c0VarArr) {
        Object obj;
        List list;
        Intrinsics.checkNotNullParameter(c0VarArr, "statuses");
        IBGDbManager b11 = b();
        List list2 = null;
        try {
            Result.Companion companion = Result.Companion;
            b bVar = f51763a;
            IBGCursor kQuery$default = IBGDBManagerExtKt.kQuery$default(b11, InstabugDbContract.SessionEntry.TABLE_NAME, new String[]{"session_id", "sync_status"}, (String) null, (String) null, (String) null, (String) null, bVar.a((c0[]) Arrays.copyOf(c0VarArr, c0VarArr.length)), 60, (Object) null);
            if (kQuery$default == null) {
                list = null;
            } else {
                list = bVar.a(kQuery$default);
            }
            obj = Result.m6329constructorimpl(list);
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
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while getting simple sessions by status", message));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        if (r13 != null) {
            String message2 = r13.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while getting simple sessions by status", str), r13);
        }
        if (!Result.m6335isFailureimpl(obj)) {
            list2 = obj;
        }
        List list3 = list2;
        if (list3 == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return list3;
    }

    public void trimToLimit(int i11) {
        Object obj;
        ArrayList arrayList;
        Throwable th2;
        IBGDbManager b11 = b();
        boolean z11 = false;
        List list = null;
        try {
            Result.Companion companion = Result.Companion;
            IBGCursor kQuery$default = IBGDBManagerExtKt.kQuery$default(b11, InstabugDbContract.SessionEntry.TABLE_NAME, new String[]{"session_id"}, (String) null, (String) null, (String) null, (String) null, TuplesKt.to("session_serial IN ( SELECT session_serial FROM session_table ORDER BY session_serial DESC limit ? OFFSET ? )", CollectionsKt__CollectionsKt.listOf(new IBGWhereArg("-1", true), new IBGWhereArg(String.valueOf(i11), true))), 60, (Object) null);
            if (kQuery$default == null) {
                arrayList = null;
            } else {
                try {
                    arrayList = new ArrayList();
                    while (kQuery$default.moveToNext()) {
                        arrayList.add(com.instabug.library.util.extenstions.b.e(kQuery$default, "session_id"));
                    }
                    CloseableKt.closeFinally(kQuery$default, (Throwable) null);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    CloseableKt.closeFinally(kQuery$default, th2);
                    throw th4;
                }
            }
            obj = Result.m6329constructorimpl(arrayList);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 != null) {
            String message = r22.getMessage();
            if (message == null) {
                message = "";
            }
            InstabugCore.reportError(r22, Intrinsics.stringPlus("", message));
        }
        Throwable r23 = Result.m6332exceptionOrNullimpl(obj);
        if (r23 != null) {
            String message2 = r23.getMessage();
            if (message2 == null) {
                message2 = "";
            }
            InstabugSDKLogger.e("Something went wrong while trimming sessions ", Intrinsics.stringPlus("", message2), r23);
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        List list2 = (List) obj;
        if (list2 == null || list2.isEmpty()) {
            z11 = true;
        }
        if (!z11) {
            list = obj;
        }
        List list3 = list;
        if (list3 != null) {
            a(list3);
            deleteSessionByID(list3);
            a().e(list3.size());
        }
    }

    public void updateSessionDuration(@NotNull String str, long j11) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "sessionId");
        IBGDbManager b11 = b();
        String str2 = "Something went wrong while updating session " + str + " duration";
        try {
            Result.Companion companion = Result.Companion;
            IBGContentValues iBGContentValues = new IBGContentValues();
            iBGContentValues.put("duration", Long.valueOf(j11), false);
            obj = Result.m6329constructorimpl(Integer.valueOf(b11.update(InstabugDbContract.SessionEntry.TABLE_NAME, iBGContentValues, "session_id = ?", CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg(str, true)))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r72 = Result.m6332exceptionOrNullimpl(obj);
        String str3 = "";
        if (r72 != null) {
            String message = r72.getMessage();
            if (message == null) {
                message = str3;
            }
            InstabugCore.reportError(r72, Intrinsics.stringPlus(str2, message));
        }
        Throwable r62 = Result.m6332exceptionOrNullimpl(obj);
        if (r62 != null) {
            String message2 = r62.getMessage();
            if (message2 != null) {
                str3 = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus(str2, str3), r62);
        }
    }

    private final long a(g gVar) {
        Object obj;
        IBGDbManager b11 = b();
        Long l11 = null;
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(Long.valueOf(b11.insert(InstabugDbContract.SessionEntry.TABLE_NAME, (String) null, l.f51616a.a(gVar))));
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
            InstabugCore.reportError(r02, Intrinsics.stringPlus("Something went wrong while inserting the new session ", message));
        }
        Throwable r03 = Result.m6332exceptionOrNullimpl(obj);
        if (r03 != null) {
            String message2 = r03.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while inserting the new session ", str), r03);
        }
        if (!Result.m6335isFailureimpl(obj)) {
            l11 = obj;
        }
        Long l12 = l11;
        if (l12 == null) {
            return -1;
        }
        return l12.longValue();
    }

    private final long b(g gVar) {
        Object obj;
        IBGDbManager b11 = b();
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(Integer.valueOf(b11.update(InstabugDbContract.SessionEntry.TABLE_NAME, l.f51616a.a(gVar), " session_id = ? AND session_serial = ? ", CollectionsKt__CollectionsKt.listOf(new IBGWhereArg(gVar.c(), true), new IBGWhereArg(String.valueOf(gVar.e()), true)))));
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
            InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while updating the new session ", message));
        }
        Throwable r13 = Result.m6332exceptionOrNullimpl(obj);
        if (r13 != null) {
            String message2 = r13.getMessage();
            if (message2 != null) {
                str = message2;
            }
            InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while updating the new session ", str), r13);
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        return gVar.e();
    }

    private final void a(List list) {
        Object obj;
        List<FeatureSessionDataController> c11 = c();
        ArrayList<Future> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(c11, 10));
        for (FeatureSessionDataController aVar : c11) {
            arrayList.add(PoolProvider.submitIOTask(new a(aVar, list)));
        }
        for (Future future : arrayList) {
            try {
                Result.Companion companion = Result.Companion;
                future.get();
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
                InstabugCore.reportError(r12, Intrinsics.stringPlus("Something went wrong while deleting Features Sessions Data", message));
            }
            Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
            if (r02 != null) {
                String message2 = r02.getMessage();
                if (message2 != null) {
                    str = message2;
                }
                InstabugSDKLogger.e("IBG-Core", Intrinsics.stringPlus("Something went wrong while deleting Features Sessions Data", str), r02);
            }
        }
    }

    private final Pair b(List list) {
        return TuplesKt.to(Intrinsics.stringPlus("session_id IN ", IBGDBManagerExtKt.joinToArgs(list)), IBGDBManagerExtKt.asArgs$default(list, false, 1, (Object) null));
    }

    /* access modifiers changed from: private */
    public static final Unit a(FeatureSessionDataController featureSessionDataController, List list) {
        Intrinsics.checkNotNullParameter(list, "$sessionsIds");
        featureSessionDataController.dropSessionData(list);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002f, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0030, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List a(com.instabug.library.internal.storage.cache.dbv2.IBGCursor r5) {
        /*
            r4 = this;
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.createListBuilder()     // Catch:{ all -> 0x002d }
        L_0x0004:
            boolean r1 = r5.moveToNext()     // Catch:{ all -> 0x002d }
            if (r1 == 0) goto L_0x0024
            kotlin.Pair r1 = new kotlin.Pair     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "session_id"
            java.lang.String r2 = com.instabug.library.util.extenstions.b.e(r5, r2)     // Catch:{ all -> 0x002d }
            java.lang.String r3 = "sync_status"
            java.lang.String r3 = com.instabug.library.util.extenstions.b.e(r5, r3)     // Catch:{ all -> 0x002d }
            com.instabug.library.model.v3Session.c0 r3 = com.instabug.library.model.v3Session.c0.valueOf(r3)     // Catch:{ all -> 0x002d }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x002d }
            r0.add(r1)     // Catch:{ all -> 0x002d }
            goto L_0x0004
        L_0x0024:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.build(r0)     // Catch:{ all -> 0x002d }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r5, r1)
            return r0
        L_0x002d:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x002f }
        L_0x002f:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.sessionV3.cache.b.a(com.instabug.library.internal.storage.cache.dbv2.IBGCursor):java.util.List");
    }

    private final Pair a(c0... c0VarArr) {
        List<c0> list = ArraysKt___ArraysKt.toList((T[]) c0VarArr);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (c0 name2 : list) {
            arrayList.add(name2.name());
        }
        return TuplesKt.to(Intrinsics.stringPlus("sync_status IN ", IBGDBManagerExtKt.joinToArgs(arrayList)), IBGDBManagerExtKt.asArgs$default(arrayList, false, 1, (Object) null));
    }
}
