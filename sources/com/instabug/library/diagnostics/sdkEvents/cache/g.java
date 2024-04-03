package com.instabug.library.diagnostics.sdkEvents.cache;

import com.instabug.library.diagnostics.diagnostics_db.m;
import com.instabug.library.diagnostics.diagnostics_db.o;
import com.instabug.library.diagnostics.sdkEvents.mappers.a;
import com.instabug.library.internal.storage.cache.dbv2.IBGDBManagerExtKt;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g implements c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final a f34330a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final m f34331b;

    public g(@NotNull a aVar, @Nullable m mVar) {
        Intrinsics.checkNotNullParameter(aVar, "sdkEventDbMapper");
        this.f34330a = aVar;
        this.f34331b = mVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Long} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@org.jetbrains.annotations.NotNull com.instabug.library.diagnostics.sdkEvents.models.a r6) {
        /*
            r5 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = r6.b()
            boolean r0 = com.instabug.library.util.extenstions.e.a(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0012
            r0 = r6
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            if (r0 != 0) goto L_0x0016
            goto L_0x0089
        L_0x0016:
            com.instabug.library.diagnostics.diagnostics_db.o r0 = com.instabug.library.diagnostics.diagnostics_db.o.f34283a
            kotlin.Pair r2 = r0.b()
            java.lang.Object r2 = r2.getFirst()
            java.lang.String r2 = (java.lang.String) r2
            kotlin.Pair r0 = r0.a()
            java.lang.Object r0 = r0.getFirst()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "INSERT OR REPLACE INTO sdk_events ("
            r3.append(r4)
            r3.append(r2)
            r4 = 44
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = ") VALUES( ?, COALESCE((SELECT "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " FROM sdk_events WHERE "
            r3.append(r0)
            r3.append(r2)
            java.lang.String r0 = "=?),0)+?)"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.instabug.library.diagnostics.diagnostics_db.m r2 = r5.f34331b
            if (r2 != 0) goto L_0x005f
            goto L_0x006b
        L_0x005f:
            com.instabug.library.diagnostics.sdkEvents.cache.d r1 = new com.instabug.library.diagnostics.sdkEvents.cache.d
            r1.<init>(r6)
            java.lang.Object r0 = r2.a((java.lang.String) r0, (kotlin.jvm.functions.Function1) r1)
            r1 = r0
            java.lang.Long r1 = (java.lang.Long) r1
        L_0x006b:
            if (r1 == 0) goto L_0x007e
            long r0 = r1.longValue()
            r2 = -1
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x007e
            java.lang.String r0 = "Succeeded insertOrUpdateEvent "
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r6)
            goto L_0x0084
        L_0x007e:
            java.lang.String r0 = "Failed insertOrUpdateEvent "
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r6)
        L_0x0084:
            java.lang.String r0 = "IBG-Core"
            com.instabug.library.util.InstabugSDKLogger.i(r0, r6)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.sdkEvents.cache.g.a(com.instabug.library.diagnostics.sdkEvents.models.a):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: java.util.List} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0033, code lost:
        throw r2;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List b() {
        /*
            r13 = this;
            com.instabug.library.diagnostics.diagnostics_db.m r0 = r13.f34331b
            java.lang.String r11 = "IBG-Core"
            r12 = 0
            if (r0 != 0) goto L_0x0009
            goto L_0x0075
        L_0x0009:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x0034 }
            java.lang.String r1 = "sdk_events"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 254(0xfe, float:3.56E-43)
            r10 = 0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r0 = com.instabug.library.diagnostics.diagnostics_db.m.a(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x0034 }
            if (r0 != 0) goto L_0x001f
            r1 = r12
            goto L_0x0028
        L_0x001f:
            com.instabug.library.diagnostics.sdkEvents.mappers.a r1 = r13.f34330a     // Catch:{ all -> 0x0034 }
            java.util.List r1 = r1.b(r0)     // Catch:{ all -> 0x002d }
            kotlin.io.CloseableKt.closeFinally(r0, r12)     // Catch:{ all -> 0x0034 }
        L_0x0028:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r1)     // Catch:{ all -> 0x0034 }
            goto L_0x003f
        L_0x002d:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002f }
        L_0x002f:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ all -> 0x0034 }
            throw r2     // Catch:{ all -> 0x0034 }
        L_0x0034:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x003f:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0048
            goto L_0x0056
        L_0x0048:
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x004f
            r3 = r2
        L_0x004f:
            java.lang.String r3 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            com.instabug.library.core.InstabugCore.reportError(r1, r3)
        L_0x0056:
            java.lang.Throwable r1 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r1 != 0) goto L_0x005d
            goto L_0x006b
        L_0x005d:
            java.lang.String r3 = r1.getMessage()
            if (r3 != 0) goto L_0x0064
            r3 = r2
        L_0x0064:
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            com.instabug.library.util.InstabugSDKLogger.e(r11, r2, r1)
        L_0x006b:
            boolean r1 = kotlin.Result.m6335isFailureimpl(r0)
            if (r1 == 0) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r12 = r0
        L_0x0073:
            java.util.List r12 = (java.util.List) r12
        L_0x0075:
            if (r12 == 0) goto L_0x0080
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L_0x007e
            goto L_0x0080
        L_0x007e:
            r0 = 0
            goto L_0x0081
        L_0x0080:
            r0 = 1
        L_0x0081:
            java.lang.String r1 = "queryAllEvents "
            if (r0 == 0) goto L_0x008a
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r12)
            goto L_0x008e
        L_0x008a:
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r12)
        L_0x008e:
            com.instabug.library.util.InstabugSDKLogger.d(r11, r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.sdkEvents.cache.g.b():java.util.List");
    }

    public void c() {
        m mVar = this.f34331b;
        if (mVar != null) {
            m.a(mVar, "sdk_events", (String) null, (List) null, 6, (Object) null);
        }
    }

    public void a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "syncedEvents");
        if (!list.isEmpty()) {
            o oVar = o.f34283a;
            String str = (String) oVar.a().getFirst();
            String str2 = "UPDATE sdk_events SET " + str + "= CASE WHEN " + str + "-?>0 THEN (" + str + "-?) ELSE 0 END WHERE " + ((String) oVar.b().getFirst()) + "=?";
            for (com.instabug.library.diagnostics.sdkEvents.models.a aVar : SequencesKt___SequencesKt.filterNot(CollectionsKt___CollectionsKt.asSequence(list), e.f34328a)) {
                m mVar = this.f34331b;
                Integer num = mVar == null ? null : (Integer) mVar.a(str2, (Function1) new f(aVar));
                InstabugSDKLogger.i("IBG-Core", (num == null || num.intValue() <= 0) ? "Failed updateSyncedRecords" : "Succeeded updateSyncedRecords");
            }
        }
    }

    public void a(@Nullable Collection collection) {
        List list;
        if (collection != null && (list = CollectionsKt___CollectionsKt.toList(collection)) != null) {
            Pair pair = TuplesKt.to(((String) o.f34283a.b().getFirst()) + " IN " + IBGDBManagerExtKt.joinToArgs(list), IBGDBManagerExtKt.asArgs$default(list, false, 1, (Object) null));
            m mVar = this.f34331b;
            if (mVar != null) {
                mVar.a("sdk_events", IBGDBManagerExtKt.getSelection(pair), (List) IBGDBManagerExtKt.getArgs(pair));
            }
        }
    }

    public void a() {
        m mVar = this.f34331b;
        if (mVar != null) {
            o oVar = o.f34283a;
            mVar.a("sdk_events", Intrinsics.stringPlus((String) oVar.a().getFirst(), "=? "), CollectionsKt__CollectionsJVMKt.listOf(new IBGWhereArg("0", ((Boolean) oVar.a().getSecond()).booleanValue())));
        }
    }
}
