package com.instabug.library.experiments.cache;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.instabug.library.experiments.di.a;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Iterator;
import java.util.List;

@Instrumented
public class b implements a {
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x000c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(@androidx.annotation.NonNull java.util.List r7) {
        /*
            r6 = this;
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.experiments.di.a.a()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r0 = r0.openDatabase()
            java.util.Iterator r7 = r7.iterator()
        L_0x000c:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0088
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            r2 = 1
            r3 = 0
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ Exception -> 0x0060 }
            r4 = 0
            r2[r4] = r1     // Catch:{ Exception -> 0x0060 }
            boolean r4 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0060 }
            java.lang.String r5 = "select * from experiments_table where experiment = ?"
            if (r4 != 0) goto L_0x002a
            android.database.Cursor r2 = r0.rawQuery(r5, r2)     // Catch:{ Exception -> 0x0060 }
            goto L_0x0031
        L_0x002a:
            r4 = r0
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x0060 }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r4, r5, r2)     // Catch:{ Exception -> 0x0060 }
        L_0x0031:
            if (r2 == 0) goto L_0x005b
            boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            if (r4 == 0) goto L_0x003a
            goto L_0x007e
        L_0x003a:
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            r4.<init>()     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            java.lang.String r5 = "experiment"
            r4.put(r5, r1)     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            java.lang.String r1 = "experiments_table"
            boolean r5 = r0 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            if (r5 != 0) goto L_0x004e
            r0.insert(r1, r3, r4)     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            goto L_0x005b
        L_0x004e:
            r5 = r0
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.insert(r5, r1, r3, r4)     // Catch:{ Exception -> 0x0058, all -> 0x0055 }
            goto L_0x005b
        L_0x0055:
            r7 = move-exception
            r3 = r2
            goto L_0x0082
        L_0x0058:
            r1 = move-exception
            r3 = r2
            goto L_0x0061
        L_0x005b:
            if (r2 == 0) goto L_0x000c
            goto L_0x007e
        L_0x005e:
            r7 = move-exception
            goto L_0x0082
        L_0x0060:
            r1 = move-exception
        L_0x0061:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005e }
            r2.<init>()     // Catch:{ all -> 0x005e }
            java.lang.String r4 = "Inserting an experiment to DB failed: "
            r2.append(r4)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r1.getMessage()     // Catch:{ all -> 0x005e }
            r2.append(r4)     // Catch:{ all -> 0x005e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005e }
            java.lang.String r4 = "IBG-Core"
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatalAndLog(r1, r2, r4)     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x000c
            r2 = r3
        L_0x007e:
            r2.close()
            goto L_0x000c
        L_0x0082:
            if (r3 == 0) goto L_0x0087
            r3.close()
        L_0x0087:
            throw r7
        L_0x0088:
            r0.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.experiments.cache.b.a(java.util.List):void");
    }

    public void b(@NonNull List list) {
        SQLiteDatabaseWrapper openDatabase = a.a().openDatabase();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String[] strArr = {(String) it.next()};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.ExperimentsEntry.TABLE_NAME, "experiment = ?", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.ExperimentsEntry.TABLE_NAME, "experiment = ?", strArr);
            }
        }
        openDatabase.close();
    }

    public int trimToLimit(int i11) {
        int i12;
        SQLiteDatabaseWrapper openDatabase = a.a().openDatabase();
        String[] strArr = {String.valueOf(i11)};
        if (!(openDatabase instanceof SQLiteDatabase)) {
            i12 = openDatabase.delete(InstabugDbContract.ExperimentsEntry.TABLE_NAME, "experiment_id not in ( select experiment_id from experiments_table order by experiment_id desc limit ? )", strArr);
        } else {
            i12 = SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.ExperimentsEntry.TABLE_NAME, "experiment_id not in ( select experiment_id from experiments_table order by experiment_id desc limit ? )", strArr);
        }
        openDatabase.close();
        return i12;
    }

    public void a() {
        SQLiteDatabaseWrapper openDatabase = a.a().openDatabase();
        if (!(openDatabase instanceof SQLiteDatabase)) {
            openDatabase.delete(InstabugDbContract.ExperimentsEntry.TABLE_NAME, (String) null, (String[]) null);
        } else {
            SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.ExperimentsEntry.TABLE_NAME, (String) null, (String[]) null);
        }
        openDatabase.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        if (r2 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a1, code lost:
        if (r2 != null) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a3, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a6, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(float r12) {
        /*
            r11 = this;
            java.lang.String r0 = "Error while getting experiments: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.library.experiments.di.a.a()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            int r2 = com.instabug.library.experiments.di.a.d()
            float r2 = (float) r2
            float r2 = r2 * r12
            int r12 = java.lang.Math.round(r2)
            java.lang.String r10 = java.lang.String.valueOf(r12)
            r12 = 0
            java.lang.String r3 = "experiments_table"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r2 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0071, OutOfMemoryError -> 0x006e, all -> 0x006c }
            if (r2 != 0) goto L_0x0031
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r1
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0071, OutOfMemoryError -> 0x006e, all -> 0x006c }
            goto L_0x0038
        L_0x0031:
            r2 = r1
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0071, OutOfMemoryError -> 0x006e, all -> 0x006c }
            android.database.Cursor r2 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0071, OutOfMemoryError -> 0x006e, all -> 0x006c }
        L_0x0038:
            if (r2 == 0) goto L_0x0062
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            r3.<init>()     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            boolean r4 = r2.moveToFirst()     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            if (r4 == 0) goto L_0x0058
        L_0x0045:
            java.lang.String r4 = "experiment"
            int r4 = r2.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            r3.add(r4)     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            boolean r4 = r2.moveToNext()     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            if (r4 != 0) goto L_0x0045
        L_0x0058:
            r2.close()     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            r1.close()     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            r2.close()
            return r3
        L_0x0062:
            r1.close()     // Catch:{ Exception -> 0x006a, OutOfMemoryError -> 0x0068 }
            if (r2 == 0) goto L_0x00a6
            goto L_0x00a3
        L_0x0068:
            r1 = move-exception
            goto L_0x0073
        L_0x006a:
            r1 = move-exception
            goto L_0x0073
        L_0x006c:
            r0 = move-exception
            goto L_0x00a9
        L_0x006e:
            r1 = move-exception
        L_0x006f:
            r2 = r12
            goto L_0x0073
        L_0x0071:
            r1 = move-exception
            goto L_0x006f
        L_0x0073:
            java.lang.String r3 = "IBG-Core"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r4.<init>()     // Catch:{ all -> 0x00a7 }
            r4.append(r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x00a7 }
            r4.append(r5)     // Catch:{ all -> 0x00a7 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00a7 }
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4)     // Catch:{ all -> 0x00a7 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
            r3.<init>()     // Catch:{ all -> 0x00a7 }
            r3.append(r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x00a7 }
            r3.append(r0)     // Catch:{ all -> 0x00a7 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00a7 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r1, r0)     // Catch:{ all -> 0x00a7 }
            if (r2 == 0) goto L_0x00a6
        L_0x00a3:
            r2.close()
        L_0x00a6:
            return r12
        L_0x00a7:
            r0 = move-exception
            r12 = r2
        L_0x00a9:
            if (r12 == 0) goto L_0x00ae
            r12.close()
        L_0x00ae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.experiments.cache.b.a(float):java.util.List");
    }
}
