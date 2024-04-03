package com.instabug.library.model.v3Session;

import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
import com.instabug.library.util.extenstions.b;
import com.instabug.library.util.extenstions.d;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Instrumented
public abstract class c {
    @NotNull
    public static final IBGContentValues a(@NotNull j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        IBGContentValues iBGContentValues = new IBGContentValues();
        iBGContentValues.put("session_serial", Long.valueOf(jVar.c()), true);
        iBGContentValues.put(InstabugDbContract.APMExperimentEntry.COLUMN_EXPERIMENT_ARRAY, b.f51592a.mapForwards(jVar.b()), false);
        iBGContentValues.put("experiments_dropped_count", Integer.valueOf(jVar.a()), false);
        return iBGContentValues;
    }

    private static final j b(IBGCursor iBGCursor) {
        return new j(b.c(iBGCursor, "session_serial"), b.f51592a.mapBackwards(b.e(iBGCursor, InstabugDbContract.APMExperimentEntry.COLUMN_EXPERIMENT_ARRAY)), b.b(iBGCursor, "experiments_dropped_count"));
    }

    @Nullable
    public static final String b(@NotNull j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        boolean z11 = true;
        if (!(!jVar.b().isEmpty()) && jVar.a() <= 0) {
            z11 = false;
        }
        if ((z11 ? jVar : null) == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("expl", (Object) d.a(jVar.b()));
        if (jVar.a() > 0) {
            jSONObject.put("dxsl", jVar.a());
        }
        return JSONObjectInstrumentation.toString(jSONObject);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.HashMap a(@org.jetbrains.annotations.NotNull com.instabug.library.internal.storage.cache.dbv2.IBGCursor r4) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ all -> 0x0025 }
            r0.<init>()     // Catch:{ all -> 0x0025 }
        L_0x000a:
            boolean r1 = r4.moveToNext()     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0020
            com.instabug.library.model.v3Session.j r1 = b((com.instabug.library.internal.storage.cache.dbv2.IBGCursor) r4)     // Catch:{ all -> 0x0025 }
            long r2 = r1.c()     // Catch:{ all -> 0x0025 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0025 }
            r0.put(r2, r1)     // Catch:{ all -> 0x0025 }
            goto L_0x000a
        L_0x0020:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r1)
            return r0
        L_0x0025:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0027 }
        L_0x0027:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.model.v3Session.c.a(com.instabug.library.internal.storage.cache.dbv2.IBGCursor):java.util.HashMap");
    }
}
