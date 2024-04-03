package com.instabug.apm.cache.handler.executiontraces;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.c;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;

@Instrumented
public class b implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseManager f45119a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final a f45120b;

    public b(@Nullable DatabaseManager databaseManager, @NonNull a aVar) {
        this.f45119a = databaseManager;
        this.f45120b = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x012a  */
    @android.annotation.SuppressLint({"Range"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List a(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r10.f45119a
            r2 = 0
            if (r1 == 0) goto L_0x012e
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = r10.f45119a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r3 = r3.openDatabase()
            boolean r4 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
            if (r4 != 0) goto L_0x001b
            android.database.Cursor r11 = r3.rawQuery(r11, r2)     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
            goto L_0x0022
        L_0x001b:
            r4 = r3
            android.database.sqlite.SQLiteDatabase r4 = (android.database.sqlite.SQLiteDatabase) r4     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
            android.database.Cursor r11 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r4, r11, r2)     // Catch:{ Exception -> 0x00f0, all -> 0x00ee }
        L_0x0022:
            if (r11 == 0) goto L_0x00e5
        L_0x0024:
            boolean r4 = r11.moveToNext()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            if (r4 == 0) goto L_0x00e5
            com.instabug.apm.cache.model.c r4 = new com.instabug.apm.cache.model.c     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r4.<init>()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = "trace_id"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            long r5 = r11.getLong(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r4.b((long) r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = "name"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = r11.getString(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r4.a((java.lang.String) r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = "start_time"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            long r5 = r11.getLong(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r4.c(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = "duration"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            long r5 = r11.getLong(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r4.a((long) r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = "started_on_background"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            int r5 = r11.getInt(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r6 = 0
            r7 = 1
            if (r5 != r7) goto L_0x0073
            r5 = r7
            goto L_0x0074
        L_0x0073:
            r5 = r6
        L_0x0074:
            r4.b((boolean) r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = "ended_on_background"
            int r5 = r11.getColumnIndex(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            int r5 = r11.getInt(r5)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            if (r5 != r7) goto L_0x0084
            r6 = r7
        L_0x0084:
            r4.a((boolean) r6)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r5.<init>()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r6 = "select * from dangling_execution_traces_attributes where trace_id = "
            r5.append(r6)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            long r6 = r4.d()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r5.append(r6)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            boolean r6 = r3 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            if (r6 != 0) goto L_0x00a5
            android.database.Cursor r5 = r3.rawQuery(r5, r2)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            goto L_0x00ac
        L_0x00a5:
            r6 = r3
            android.database.sqlite.SQLiteDatabase r6 = (android.database.sqlite.SQLiteDatabase) r6     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            android.database.Cursor r5 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r6, r5, r2)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
        L_0x00ac:
            if (r5 == 0) goto L_0x00d7
            androidx.collection.ArrayMap r6 = new androidx.collection.ArrayMap     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r6.<init>()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
        L_0x00b3:
            boolean r7 = r5.moveToNext()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            if (r7 == 0) goto L_0x00d1
            java.lang.String r7 = "attribute_key"
            int r7 = r5.getColumnIndex(r7)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r7 = r5.getString(r7)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r8 = "attribute_value"
            int r8 = r5.getColumnIndex(r8)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            java.lang.String r8 = r5.getString(r8)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r6.put(r7, r8)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            goto L_0x00b3
        L_0x00d1:
            r5.close()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            r4.a((java.util.Map) r6)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
        L_0x00d7:
            r1.add(r4)     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            goto L_0x0024
        L_0x00dc:
            r0 = move-exception
            r2 = r11
            r11 = r0
            goto L_0x0128
        L_0x00e0:
            r1 = move-exception
            r9 = r1
            r1 = r11
            r11 = r9
            goto L_0x00f2
        L_0x00e5:
            r3.close()     // Catch:{ Exception -> 0x00e0, all -> 0x00dc }
            if (r11 == 0) goto L_0x00ed
            r11.close()
        L_0x00ed:
            return r1
        L_0x00ee:
            r11 = move-exception
            goto L_0x0128
        L_0x00f0:
            r11 = move-exception
            r1 = r2
        L_0x00f2:
            com.instabug.apm.logger.internal.a r3 = r10.f45120b     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r4.<init>()     // Catch:{ all -> 0x0126 }
            r4.append(r0)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = r11.getMessage()     // Catch:{ all -> 0x0126 }
            r4.append(r5)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0126 }
            r3.a(r4, r11)     // Catch:{ all -> 0x0126 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r3.<init>()     // Catch:{ all -> 0x0126 }
            r3.append(r0)     // Catch:{ all -> 0x0126 }
            java.lang.String r0 = r11.getMessage()     // Catch:{ all -> 0x0126 }
            r3.append(r0)     // Catch:{ all -> 0x0126 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0126 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r11, r0)     // Catch:{ all -> 0x0126 }
            if (r1 == 0) goto L_0x012e
            r1.close()
            goto L_0x012e
        L_0x0126:
            r11 = move-exception
            r2 = r1
        L_0x0128:
            if (r2 == 0) goto L_0x012d
            r2.close()
        L_0x012d:
            throw r11
        L_0x012e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.executiontraces.b.a(java.lang.String):java.util.List");
    }

    @Nullable
    public List a(long j11) {
        return a("Select * from dangling_execution_traces where duration != -1 limit " + j11);
    }

    public void a() {
        DatabaseManager databaseManager = this.f45119a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from dangling_execution_traces");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from dangling_execution_traces");
            }
            openDatabase.close();
        }
    }

    public boolean a(@NonNull c cVar) {
        DatabaseManager databaseManager = this.f45119a;
        if (databaseManager != null) {
            try {
                SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put("trace_id", Long.valueOf(cVar.d()));
                if (cVar.e() != null) {
                    contentValues.put("name", cVar.e());
                }
                contentValues.put("start_time", Long.valueOf(cVar.f()));
                contentValues.put("started_on_background", Integer.valueOf(cVar.g() ? 1 : 0));
                contentValues.put("ended_on_background", Integer.valueOf(cVar.a() ? 1 : 0));
                contentValues.put("duration", Long.valueOf(cVar.c()));
                long insert = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.DanglingExecutionTracesEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.DanglingExecutionTracesEntry.TABLE_NAME, (String) null, contentValues);
                openDatabase.close();
                return insert != -1;
            } catch (Throwable th2) {
                a aVar = this.f45120b;
                aVar.a("Inserting execution trace failed: " + th2.getMessage(), th2);
                IBGDiagnostics.reportNonFatal(th2, "Inserting execution trace failed: " + th2.getMessage());
            }
        }
        return false;
    }

    public void b() {
        if (this.f45119a != null) {
            List<c> a11 = a("select * from dangling_execution_traces where duration = -1");
            if (a11 != null) {
                for (c cVar : a11) {
                    if (cVar.e() != null) {
                        this.f45120b.e("Execution trace \"$s\" wasn't saved because it didn't end last session.".replace("$s", cVar.e()));
                    }
                }
            }
            SQLiteDatabaseWrapper openDatabase = this.f45119a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from dangling_execution_traces where duration = -1");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from dangling_execution_traces where duration = -1");
            }
            openDatabase.close();
        }
    }

    public void b(long j11) {
        if (this.f45119a != null) {
            String str = "delete from dangling_execution_traces where trace_id in (select trace_id from dangling_execution_traces where duration != -1 limit " + j11 + ")";
            SQLiteDatabaseWrapper openDatabase = this.f45119a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, str);
            }
            openDatabase.close();
        }
    }
}
