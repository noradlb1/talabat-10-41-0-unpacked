package com.instabug.apm.cache.handler.session;

import com.instabug.library.internal.utils.stability.execution.ReturnableExecutable;
import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
class d implements ReturnableExecutable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f45152a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f45153b;

    public d(e eVar, String str) {
        this.f45153b = eVar;
        this.f45152a = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    @androidx.annotation.Nullable
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.instabug.apm.cache.model.f execute() {
        /*
            r9 = this;
            java.lang.String r0 = "Error while getting previous session from DB: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.apm.di.a.v()
            r2 = 0
            if (r1 == 0) goto L_0x00ab
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r3.<init>()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = "SELECT * FROM apm_session_table where session_id < "
            r3.append(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = r9.f45152a     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            r3.append(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = " ORDER BY "
            r3.append(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = "started_at"
            r3.append(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r4 = " DESC LIMIT 1"
            r3.append(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            boolean r4 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            if (r4 != 0) goto L_0x0038
            android.database.Cursor r3 = r1.rawQuery(r3, r2)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            goto L_0x003f
        L_0x0038:
            r4 = r1
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
            android.database.Cursor r3 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r4, r3, r2)     // Catch:{ Exception -> 0x0067, all -> 0x0065 }
        L_0x003f:
            if (r3 == 0) goto L_0x005c
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            if (r4 == 0) goto L_0x005c
            com.instabug.apm.cache.handler.session.e r4 = r9.f45153b     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            com.instabug.apm.cache.model.f r0 = r4.a((android.database.Cursor) r3)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r3.close()
            r1.close()
            return r0
        L_0x0054:
            r0 = move-exception
            r2 = r3
            goto L_0x00a2
        L_0x0057:
            r4 = move-exception
            r8 = r4
            r4 = r3
            r3 = r8
            goto L_0x0069
        L_0x005c:
            if (r3 == 0) goto L_0x0061
            r3.close()
        L_0x0061:
            r1.close()
            return r2
        L_0x0065:
            r0 = move-exception
            goto L_0x00a2
        L_0x0067:
            r3 = move-exception
            r4 = r2
        L_0x0069:
            java.lang.String r5 = "IBG-APM"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r6.<init>()     // Catch:{ all -> 0x00a0 }
            r6.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r7 = r3.getMessage()     // Catch:{ all -> 0x00a0 }
            r6.append(r7)     // Catch:{ all -> 0x00a0 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00a0 }
            com.instabug.library.util.InstabugSDKLogger.e(r5, r6, r3)     // Catch:{ all -> 0x00a0 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a0 }
            r5.<init>()     // Catch:{ all -> 0x00a0 }
            r5.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r3.getMessage()     // Catch:{ all -> 0x00a0 }
            r5.append(r0)     // Catch:{ all -> 0x00a0 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x00a0 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r3, r0)     // Catch:{ all -> 0x00a0 }
            if (r4 == 0) goto L_0x009c
            r4.close()
        L_0x009c:
            r1.close()
            return r2
        L_0x00a0:
            r0 = move-exception
            r2 = r4
        L_0x00a2:
            if (r2 == 0) goto L_0x00a7
            r2.close()
        L_0x00a7:
            r1.close()
            throw r0
        L_0x00ab:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.session.d.execute():com.instabug.apm.cache.model.f");
    }
}
