package com.instabug.commons.session;

import android.database.Cursor;
import com.instabug.commons.models.Incident;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.internal.storage.cache.dbv2.IBGDBManagerExtKt;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements f {
    private final IBGDbManager a() {
        IBGDbManager instance = IBGDbManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    private final Pair c(List list) {
        return new Pair(Intrinsics.stringPlus("session_id IN ", IBGDBManagerExtKt.joinToArgs(list)), IBGDBManagerExtKt.asArgs$default(list, false, 1, (Object) null));
    }

    @NotNull
    public List b(@NotNull List list) {
        Object obj;
        List list2;
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        try {
            Result.Companion companion = Result.Companion;
            IBGCursor kQuery$default = IBGDBManagerExtKt.kQuery$default(a(), "session_incident", (String[]) null, (String) null, (String) null, (String) null, (String) null, c(list), 62, (Object) null);
            if (kQuery$default == null) {
                list2 = null;
            } else {
                list2 = a(kQuery$default);
            }
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            obj = Result.m6329constructorimpl(list2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        return (List) a(obj, (Object) CollectionsKt__CollectionsKt.emptyList(), "Failed to query incidents by sessions ids");
    }

    public void a(@NotNull e eVar) {
        Object obj;
        Intrinsics.checkNotNullParameter(eVar, "sessionIncident");
        try {
            Result.Companion companion = Result.Companion;
            a().insert("session_incident", (String) null, b(eVar));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        a(obj, (Object) Unit.INSTANCE, "Failed to store session incident");
    }

    private final IBGContentValues b(e eVar) {
        IBGContentValues iBGContentValues = new IBGContentValues();
        iBGContentValues.put("id", Long.valueOf(eVar.a()), true);
        iBGContentValues.put("session_id", eVar.d(), true);
        iBGContentValues.put("incident_id", eVar.b(), true);
        iBGContentValues.put("incident_type", eVar.c().name(), true);
        iBGContentValues.put("validation_status", Integer.valueOf(eVar.e()), true);
        return iBGContentValues;
    }

    public void a(@NotNull String str, @Nullable String str2, @NotNull Incident.Type type, int i11) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(type, "incidentType");
        try {
            Result.Companion companion = Result.Companion;
            IBGDbManager a11 = a();
            IBGContentValues iBGContentValues = new IBGContentValues();
            iBGContentValues.put("incident_id", str2, true);
            iBGContentValues.put("validation_status", Integer.valueOf(i11), true);
            Unit unit = Unit.INSTANCE;
            a11.update("session_incident", iBGContentValues, "session_id = ? AND incident_type = ?", CollectionsKt__CollectionsKt.listOf(new IBGWhereArg(str, true), new IBGWhereArg(type.name(), true)));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        a(obj, (Object) Unit.INSTANCE, Intrinsics.stringPlus("Failed to validate Session-Incident link by incident Id: ", str2));
    }

    public void a(@NotNull String str, @NotNull Incident.Type type, int i11) {
        Object obj;
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(type, "incidentType");
        try {
            Result.Companion companion = Result.Companion;
            IBGDBManagerExtKt.kDelete(a(), "session_incident", "id IN ( SELECT id FROM session_incident WHERE session_id = ? AND incident_type = ? ORDER BY id DESC limit ? OFFSET ? )", CollectionsKt__CollectionsKt.listOf(new IBGWhereArg(str, true), new IBGWhereArg(type.name(), true), new IBGWhereArg("-1", true), new IBGWhereArg(String.valueOf(i11), true)));
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        a(obj, (Object) Unit.INSTANCE, "Failed to trim session incidents");
    }

    public void a(@NotNull List list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "sessionsIds");
        try {
            Result.Companion companion = Result.Companion;
            Pair c11 = c(list);
            obj = Result.m6329constructorimpl(Integer.valueOf(IBGDBManagerExtKt.kDelete(a(), "session_incident", IBGDBManagerExtKt.getSelection(c11), IBGDBManagerExtKt.getArgs(c11))));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        a(obj, (Object) Unit.INSTANCE, "Failed to delete incidents by sessions ids ");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List a(com.instabug.library.internal.storage.cache.dbv2.IBGCursor r3) {
        /*
            r2 = this;
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.createListBuilder()     // Catch:{ all -> 0x001b }
        L_0x0004:
            boolean r1 = r3.moveToNext()     // Catch:{ all -> 0x001b }
            if (r1 == 0) goto L_0x0012
            com.instabug.commons.session.e r1 = r2.a((android.database.Cursor) r3)     // Catch:{ all -> 0x001b }
            r0.add(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0004
        L_0x0012:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.build(r0)     // Catch:{ all -> 0x001b }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            return r0
        L_0x001b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x001d }
        L_0x001d:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.commons.session.b.a(com.instabug.library.internal.storage.cache.dbv2.IBGCursor):java.util.List");
    }

    private final e a(Cursor cursor) {
        long j11 = cursor.getLong(cursor.getColumnIndexOrThrow("id"));
        String string = cursor.getString(cursor.getColumnIndexOrThrow("session_id"));
        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("incident_id"));
        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("incident_type"));
        Intrinsics.checkNotNullExpressionValue(string3, "getString(getColumnIndex…ry.COLUMN_INCIDENT_TYPE))");
        Incident.Type valueOf = Incident.Type.valueOf(string3);
        int i11 = cursor.getInt(cursor.getColumnIndexOrThrow("validation_status"));
        Intrinsics.checkNotNullExpressionValue(string, "getString(getColumnIndex…Entry.COLUMN_SESSION_ID))");
        return new e(string, string2, valueOf, i11, j11);
    }

    private final Object a(Object obj, Object obj2, String str) {
        Throwable r02 = Result.m6332exceptionOrNullimpl(obj);
        if (r02 == null) {
            return obj;
        }
        InstabugSDKLogger.e("IBG-CR", str, r02);
        InstabugCore.reportError(r02, str);
        return obj2;
    }
}
