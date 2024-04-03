package com.instabug.apm.cache.handler.executiontraces;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.c;
import com.instabug.apm.di.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;
import java.util.Map;

@Instrumented
public class d implements c {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private DatabaseManager f45121a = a.v();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.logger.internal.a f45122b = a.f();

    public d() {
        a.y();
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v5, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v6, types: [android.database.Cursor] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"Range"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList a(com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r9, @androidx.annotation.Nullable android.database.Cursor r10) {
        /*
            r8 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r10 == 0) goto L_0x00ff
        L_0x0009:
            boolean r2 = r10.moveToNext()
            if (r2 == 0) goto L_0x00ff
            com.instabug.apm.cache.model.c r2 = new com.instabug.apm.cache.model.c
            r2.<init>()
            java.lang.String r3 = "trace_id"
            int r3 = r10.getColumnIndex(r3)
            long r3 = r10.getLong(r3)
            r2.b((long) r3)
            java.lang.String r3 = "name"
            int r3 = r10.getColumnIndex(r3)
            java.lang.String r3 = r10.getString(r3)
            r2.a((java.lang.String) r3)
            java.lang.String r3 = "start_time"
            int r3 = r10.getColumnIndex(r3)
            long r3 = r10.getLong(r3)
            r2.c(r3)
            java.lang.String r3 = "duration"
            int r3 = r10.getColumnIndex(r3)
            long r3 = r10.getLong(r3)
            r2.a((long) r3)
            java.lang.String r3 = "started_on_background"
            int r3 = r10.getColumnIndex(r3)
            int r3 = r10.getInt(r3)
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L_0x0058
            r3 = r5
            goto L_0x0059
        L_0x0058:
            r3 = r4
        L_0x0059:
            r2.b((boolean) r3)
            java.lang.String r3 = "ended_on_background"
            int r3 = r10.getColumnIndex(r3)
            int r3 = r10.getInt(r3)
            if (r3 != r5) goto L_0x0069
            r4 = r5
        L_0x0069:
            r2.a((boolean) r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "select* from execution_traces_attributes where trace_id = "
            r3.append(r4)
            long r4 = r2.d()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            boolean r5 = r9 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00c0 }
            if (r5 != 0) goto L_0x008b
            android.database.Cursor r3 = r9.rawQuery(r3, r4)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x0092
        L_0x008b:
            r5 = r9
            android.database.sqlite.SQLiteDatabase r5 = (android.database.sqlite.SQLiteDatabase) r5     // Catch:{ Exception -> 0x00c0 }
            android.database.Cursor r3 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r5, r3, r4)     // Catch:{ Exception -> 0x00c0 }
        L_0x0092:
            r4 = r3
            if (r4 == 0) goto L_0x00bb
            androidx.collection.ArrayMap r3 = new androidx.collection.ArrayMap     // Catch:{ Exception -> 0x00c0 }
            r3.<init>()     // Catch:{ Exception -> 0x00c0 }
        L_0x009a:
            boolean r5 = r4.moveToNext()     // Catch:{ Exception -> 0x00c0 }
            if (r5 == 0) goto L_0x00b8
            java.lang.String r5 = "attribute_key"
            int r5 = r4.getColumnIndex(r5)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r5 = r4.getString(r5)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r6 = "attribute_value"
            int r6 = r4.getColumnIndex(r6)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r6 = r4.getString(r6)     // Catch:{ Exception -> 0x00c0 }
            r3.put(r5, r6)     // Catch:{ Exception -> 0x00c0 }
            goto L_0x009a
        L_0x00b8:
            r2.a((java.util.Map) r3)     // Catch:{ Exception -> 0x00c0 }
        L_0x00bb:
            if (r4 == 0) goto L_0x00f4
            goto L_0x00f1
        L_0x00be:
            r9 = move-exception
            goto L_0x00f9
        L_0x00c0:
            r3 = move-exception
            com.instabug.apm.logger.internal.a r5 = r8.f45122b     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r6.<init>()     // Catch:{ all -> 0x00be }
            r6.append(r0)     // Catch:{ all -> 0x00be }
            java.lang.String r7 = r3.getMessage()     // Catch:{ all -> 0x00be }
            r6.append(r7)     // Catch:{ all -> 0x00be }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00be }
            r5.a(r6, r3)     // Catch:{ all -> 0x00be }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00be }
            r5.<init>()     // Catch:{ all -> 0x00be }
            r5.append(r0)     // Catch:{ all -> 0x00be }
            java.lang.String r6 = r3.getMessage()     // Catch:{ all -> 0x00be }
            r5.append(r6)     // Catch:{ all -> 0x00be }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00be }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r3, r5)     // Catch:{ all -> 0x00be }
            if (r4 == 0) goto L_0x00f4
        L_0x00f1:
            r4.close()
        L_0x00f4:
            r1.add(r2)
            goto L_0x0009
        L_0x00f9:
            if (r4 == 0) goto L_0x00fe
            r4.close()
        L_0x00fe:
            throw r9
        L_0x00ff:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.executiontraces.d.a(com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper, android.database.Cursor):java.util.ArrayList");
    }

    private void a(long j11, @NonNull String str, @Nullable String str2) {
        if (this.f45121a != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("trace_id", Long.valueOf(j11));
            contentValues.put("attribute_key", str);
            if (str2 != null) {
                contentValues.put("attribute_value", str2);
            }
            SQLiteDatabaseWrapper openDatabase = this.f45121a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.insert(InstabugDbContract.ExecutionTracesAttributesEntry.TABLE_NAME, (String) null, contentValues);
            } else {
                SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.ExecutionTracesAttributesEntry.TABLE_NAME, (String) null, contentValues);
            }
            openDatabase.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List b(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r7.f45121a
            r2 = 0
            if (r1 == 0) goto L_0x0071
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            boolean r3 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            if (r3 != 0) goto L_0x0014
            android.database.Cursor r8 = r1.rawQuery(r8, r2)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            goto L_0x001b
        L_0x0014:
            r3 = r1
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
            android.database.Cursor r8 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.rawQuery(r3, r8, r2)     // Catch:{ Exception -> 0x0033, all -> 0x0031 }
        L_0x001b:
            java.util.ArrayList r3 = r7.a((com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r1, (android.database.Cursor) r8)     // Catch:{ Exception -> 0x002c, all -> 0x0028 }
            r1.close()     // Catch:{ Exception -> 0x002c, all -> 0x0028 }
            if (r8 == 0) goto L_0x0027
            r8.close()
        L_0x0027:
            return r3
        L_0x0028:
            r0 = move-exception
            r2 = r8
            r8 = r0
            goto L_0x006b
        L_0x002c:
            r1 = move-exception
            r6 = r1
            r1 = r8
            r8 = r6
            goto L_0x0035
        L_0x0031:
            r8 = move-exception
            goto L_0x006b
        L_0x0033:
            r8 = move-exception
            r1 = r2
        L_0x0035:
            com.instabug.apm.logger.internal.a r3 = r7.f45122b     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            r4.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = r8.getMessage()     // Catch:{ all -> 0x0069 }
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0069 }
            r3.a(r4, r8)     // Catch:{ all -> 0x0069 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r3.<init>()     // Catch:{ all -> 0x0069 }
            r3.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r8.getMessage()     // Catch:{ all -> 0x0069 }
            r3.append(r0)     // Catch:{ all -> 0x0069 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0069 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r8, r0)     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0071
            r1.close()
            goto L_0x0071
        L_0x0069:
            r8 = move-exception
            r2 = r1
        L_0x006b:
            if (r2 == 0) goto L_0x0070
            r2.close()
        L_0x0070:
            throw r8
        L_0x0071:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.executiontraces.d.b(java.lang.String):java.util.List");
    }

    public int a(String str, long j11) {
        if (this.f45121a == null) {
            return -1;
        }
        String str2 = "session_id = ? AND start_time NOT IN (" + "SELECT start_time FROM execution_traces where session_id = ? ORDER BY start_time DESC LIMIT ?" + ")";
        String[] strArr = {str, str, String.valueOf(j11)};
        SQLiteDatabaseWrapper openDatabase = this.f45121a.openDatabase();
        int delete = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.delete(InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, str2, strArr) : SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, str2, strArr);
        openDatabase.close();
        return delete;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "DB execution a sql failed: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r12.f45121a
            r2 = 0
            if (r1 == 0) goto L_0x0089
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.String r6 = "session_id = ? AND duration > ?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            r7[r3] = r13
            r13 = 1
            java.lang.String r3 = "0"
            r7[r13] = r3
            java.lang.String r4 = "execution_traces"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r13 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r13 != 0) goto L_0x002c
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r1
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            goto L_0x0033
        L_0x002c:
            r3 = r1
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        L_0x0033:
            java.util.ArrayList r3 = r12.a((com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r1, (android.database.Cursor) r13)     // Catch:{ Exception -> 0x0044, all -> 0x0040 }
            r1.close()     // Catch:{ Exception -> 0x0044, all -> 0x0040 }
            if (r13 == 0) goto L_0x003f
            r13.close()
        L_0x003f:
            return r3
        L_0x0040:
            r0 = move-exception
            r2 = r13
            r13 = r0
            goto L_0x0083
        L_0x0044:
            r1 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x004d
        L_0x0049:
            r13 = move-exception
            goto L_0x0083
        L_0x004b:
            r13 = move-exception
            r1 = r2
        L_0x004d:
            com.instabug.apm.logger.internal.a r3 = r12.f45122b     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r4.<init>()     // Catch:{ all -> 0x0081 }
            r4.append(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r5 = r13.getMessage()     // Catch:{ all -> 0x0081 }
            r4.append(r5)     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0081 }
            r3.a(r4, r13)     // Catch:{ all -> 0x0081 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0081 }
            r3.<init>()     // Catch:{ all -> 0x0081 }
            r3.append(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r13.getMessage()     // Catch:{ all -> 0x0081 }
            r3.append(r0)     // Catch:{ all -> 0x0081 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0081 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r13, r0)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0089
            r1.close()
            goto L_0x0089
        L_0x0081:
            r13 = move-exception
            r2 = r1
        L_0x0083:
            if (r2 == 0) goto L_0x0088
            r2.close()
        L_0x0088:
            throw r13
        L_0x0089:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.executiontraces.d.a(java.lang.String):java.util.List");
    }

    public void a() {
        DatabaseManager databaseManager = this.f45121a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from execution_traces");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from execution_traces");
            }
            openDatabase.close();
        }
    }

    public void a(long j11) {
        if (this.f45121a != null) {
            String str = "start_time IN (" + "SELECT start_time FROM execution_traces ORDER BY start_time DESC LIMIT ? OFFSET ?" + ")";
            String[] strArr = {"-1", String.valueOf(j11)};
            SQLiteDatabaseWrapper openDatabase = this.f45121a.openDatabase();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, str, strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, str, strArr);
                }
            } catch (Exception e11) {
                this.f45122b.a("DB execution a sql failed: " + e11.getMessage(), e11);
                IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed: " + e11.getMessage());
                if (openDatabase == null) {
                    return;
                }
            } catch (Throwable th2) {
                if (openDatabase != null) {
                    openDatabase.close();
                }
                throw th2;
            }
            openDatabase.close();
        }
    }

    public void a(long j11, @NonNull String str, @NonNull String str2, @Nullable String str3) {
        a(j11, str2, str3);
    }

    public void a(long j11, @NonNull String str, @NonNull Map map) {
        for (Map.Entry entry : map.entrySet()) {
            a(j11, str, (String) entry.getKey(), (String) entry.getValue());
        }
    }

    public boolean a(@NonNull String str, @NonNull c cVar) {
        DatabaseManager databaseManager = this.f45121a;
        if (databaseManager == null) {
            return false;
        }
        SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("trace_id", Long.valueOf(cVar.d()));
        contentValues.put("session_id", str);
        if (cVar.e() != null) {
            contentValues.put("name", cVar.e());
        }
        contentValues.put("start_time", Long.valueOf(cVar.f()));
        contentValues.put("duration", Long.valueOf(cVar.c()));
        contentValues.put("started_on_background", Integer.valueOf(cVar.g() ? 1 : 0));
        contentValues.put("ended_on_background", Integer.valueOf(cVar.a() ? 1 : 0));
        int i11 = ((!(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, (String) null, contentValues)) > -1 ? 1 : ((!(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.ExecutionTracesEntry.TABLE_NAME, (String) null, contentValues)) == -1 ? 0 : -1));
        if (!(i11 == 0 || cVar.e() == null || cVar.b() == null)) {
            a(cVar.d(), cVar.e(), cVar.b());
        }
        openDatabase.close();
        return i11 != 0;
    }

    public void b() {
        if (this.f45121a != null) {
            List<c> b11 = b("select * from execution_traces where duration = -1");
            if (b11 != null) {
                for (c cVar : b11) {
                    if (cVar.e() != null) {
                        this.f45122b.e("Execution trace \"$s\" wasn't saved because it didn't end last session.".replace("$s", cVar.e()));
                    }
                }
            }
            SQLiteDatabaseWrapper openDatabase = this.f45121a.openDatabase();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL("delete from execution_traces where duration = -1");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from execution_traces where duration = -1");
            }
            openDatabase.close();
        }
    }
}
