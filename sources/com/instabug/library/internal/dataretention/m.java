package com.instabug.library.internal.dataretention;

import com.newrelic.agent.android.instrumentation.Instrumented;

@Instrumented
public class m {
    public n a(String str, String str2, String str3) {
        return new l(this, str, str2, str3);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0070, code lost:
        if (r11 != null) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (r11 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007f, code lost:
        r11.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0082, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0085, code lost:
        return r10;
     */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List b(java.lang.String r13, java.lang.String r14, java.lang.String r15) {
        /*
            r12 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            r1 = 2
            java.lang.String[] r4 = new java.lang.String[r1]
            r1 = 0
            r4[r1] = r14
            r1 = 1
            r4[r1] = r15
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            boolean r1 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0075 }
            if (r1 != 0) goto L_0x0032
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r1 = r0
            r2 = r13
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            android.database.Cursor r13 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0075 }
            goto L_0x003a
        L_0x0032:
            r2 = r0
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0075 }
            r3 = r13
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0075 }
        L_0x003a:
            r11 = r13
            if (r11 == 0) goto L_0x0070
            int r13 = r11.getCount()     // Catch:{ Exception -> 0x0075 }
            if (r13 <= 0) goto L_0x0070
            int r13 = r11.getColumnIndex(r14)     // Catch:{ Exception -> 0x0075 }
            int r1 = r11.getColumnIndex(r15)     // Catch:{ Exception -> 0x0075 }
        L_0x004b:
            boolean r2 = r11.moveToNext()     // Catch:{ Exception -> 0x0075 }
            if (r2 == 0) goto L_0x0070
            java.lang.String r2 = r11.getString(r13)     // Catch:{ Exception -> 0x0075 }
            long r3 = r11.getLong(r1)     // Catch:{ Exception -> 0x0075 }
            com.instabug.library.internal.dataretention.g r5 = new com.instabug.library.internal.dataretention.g     // Catch:{ Exception -> 0x0075 }
            r5.<init>(r14, r2)     // Catch:{ Exception -> 0x0075 }
            com.instabug.library.internal.dataretention.g r2 = new com.instabug.library.internal.dataretention.g     // Catch:{ Exception -> 0x0075 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ Exception -> 0x0075 }
            r2.<init>(r15, r3)     // Catch:{ Exception -> 0x0075 }
            com.instabug.library.internal.dataretention.h r3 = new com.instabug.library.internal.dataretention.h     // Catch:{ Exception -> 0x0075 }
            r3.<init>(r5, r2)     // Catch:{ Exception -> 0x0075 }
            r10.add(r3)     // Catch:{ Exception -> 0x0075 }
            goto L_0x004b
        L_0x0070:
            if (r11 == 0) goto L_0x0082
            goto L_0x007f
        L_0x0073:
            r13 = move-exception
            goto L_0x0086
        L_0x0075:
            r13 = move-exception
            java.lang.String r14 = "IBG-Core"
            java.lang.String r15 = "DB query failed: "
            com.instabug.library.util.InstabugSDKLogger.e(r14, r15, r13)     // Catch:{ all -> 0x0073 }
            if (r11 == 0) goto L_0x0082
        L_0x007f:
            r11.close()
        L_0x0082:
            r0.close()
            return r10
        L_0x0086:
            if (r11 == 0) goto L_0x008b
            r11.close()
        L_0x008b:
            r0.close()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.dataretention.m.b(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }
}
