package com.instabug.apm.cache.handler.session;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.cache.model.f;
import com.instabug.apm.logger.internal.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.internal.utils.stability.handler.exception.ExceptionHandler;
import com.instabug.library.model.common.Session;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mb.b;
import mb.c;
import mb.d;
import net.bytebuddy.description.type.TypeDescription;

@Instrumented
public class e implements a {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ExceptionHandler f45154a;
    /* access modifiers changed from: private */
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public final a f45155b;

    public e(@NonNull ExceptionHandler exceptionHandler, @NonNull a aVar) {
        this.f45154a = exceptionHandler;
        this.f45155b = aVar;
    }

    /* access modifiers changed from: private */
    public f a(@NonNull Cursor cursor) {
        Cursor cursor2 = cursor;
        int columnIndex = cursor2.getColumnIndex("session_id");
        int columnIndex2 = cursor2.getColumnIndex(InstabugDbContract.APMSessionEntry.COLUMN_CORE_ID);
        int columnIndex3 = cursor2.getColumnIndex(InstabugDbContract.APMSessionEntry.COLUMN_CORE_VERSION);
        return new f(cursor2.getString(columnIndex), cursor2.getString(columnIndex2), cursor2.getString(cursor2.getColumnIndex("os")), cursor2.getString(cursor2.getColumnIndex("app_version")), cursor2.getString(cursor2.getColumnIndex("uuid")), cursor2.getLong(cursor2.getColumnIndex("duration")), cursor2.getLong(cursor2.getColumnIndex("started_at")), 0, cursor2.getString(columnIndex3), cursor2.getInt(cursor2.getColumnIndex(InstabugDbContract.APMSessionEntry.COLUMN_TERMINATION_CODE)), cursor2.getInt(cursor2.getColumnIndex("sync_status")));
    }

    /* access modifiers changed from: private */
    public ContentValues b(@NonNull f fVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", fVar.getId());
        contentValues.put(InstabugDbContract.APMSessionEntry.COLUMN_CORE_ID, fVar.b());
        contentValues.put("os", fVar.getOs());
        contentValues.put("uuid", fVar.getUuid());
        contentValues.put("app_version", fVar.getAppVersion());
        contentValues.put("started_at", Long.valueOf(fVar.getStartTimestampMicros()));
        contentValues.put("duration", Long.valueOf(fVar.c()));
        contentValues.put(InstabugDbContract.APMSessionEntry.COLUMN_CORE_VERSION, fVar.getVersion());
        contentValues.put(InstabugDbContract.APMSessionEntry.COLUMN_TERMINATION_CODE, Integer.valueOf(fVar.i()));
        return contentValues;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ f b(Session session) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 == null) {
            return null;
        }
        ContentValues c11 = c(session);
        SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
        try {
            return new f(String.valueOf(openDatabase.insertWithOnConflict(InstabugDbContract.APMSessionEntry.TABLE_NAME, (String) null, c11)), session);
        } finally {
            openDatabase.close();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private ContentValues c(Session session) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.APMSessionEntry.COLUMN_CORE_ID, session.getId());
        contentValues.put("os", session.getOs());
        contentValues.put("uuid", session.getUuid());
        contentValues.put(InstabugDbContract.APMSessionEntry.COLUMN_CORE_VERSION, session.getVersion());
        contentValues.put("app_version", session.getAppVersion());
        contentValues.put("started_at", Long.valueOf(session.getStartTimestampMicros()));
        return contentValues;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer c(int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 == null) {
            return 0;
        }
        String str = "session_id NOT IN (" + ("SELECT session_id FROM apm_session_table ORDER BY session_id DESC LIMIT " + i11) + ")";
        SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
        return Integer.valueOf(!(openDatabase instanceof SQLiteDatabase) ? openDatabase.delete(InstabugDbContract.APMSessionEntry.TABLE_NAME, str, (String[]) null) : SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, str, (String[]) null));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(List list) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
            try {
                String str = "core_session_id IN " + d(list.size());
                String[] strArr = (String[]) list.toArray(new String[0]);
                int delete = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.delete(InstabugDbContract.APMSessionEntry.TABLE_NAME, str, strArr) : SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, str, strArr);
                this.f45155b.g("Deleted " + delete + " row/s associated with session IDs: " + mb.a.a(",", list));
            } catch (Exception e11) {
                this.f45155b.a("Error while deleting sessions: " + e11.getMessage(), e11);
                IBGDiagnostics.reportNonFatal(e11, "Error while deleting sessions: " + e11.getMessage());
            }
        }
    }

    private String d(int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append(TypeDescription.Generic.OfWildcardType.SYMBOL);
            if (i12 < i11 - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        return sb2.toString();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List d(List list) {
        Cursor query;
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        String str = "core_session_id IN " + d(list.size());
        if (v11 != null) {
            SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
            try {
                String[] strArr = (String[]) list.toArray(new String[0]);
                query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.APMSessionEntry.TABLE_NAME, (String[]) null, str, strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, (String[]) null, str, strArr, (String) null, (String) null, (String) null);
                if (query != null) {
                    if (query.moveToFirst()) {
                        ArrayList arrayList = new ArrayList();
                        do {
                            arrayList.add(a(query));
                        } while (query.moveToNext());
                        query.close();
                        return arrayList;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e11) {
                this.f45155b.a("Error while querying sessions by core ids: " + e11.getMessage(), e11);
                IBGDiagnostics.reportNonFatal(e11, "Error while querying sessions by core ids: " + e11.getMessage());
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
        }
        return Collections.emptyList();
        throw th;
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public int a(@NonNull f fVar) {
        return ((Integer) this.f45154a.executeAndGet(new b(this, fVar), 0)).intValue();
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public int a(@NonNull String str, long j11, int i11) {
        return ((Integer) this.f45154a.executeAndGet(new c(this, i11, j11, str), 0)).intValue();
    }

    @Nullable
    public f a(@NonNull Session session) {
        return (f) this.f45154a.executeAndGet(new mb.e(this, session));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0093  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.instabug.apm.cache.model.f a(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "Error while getting next session: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.apm.di.a.v()
            r2 = 0
            if (r1 == 0) goto L_0x0097
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.String r6 = "session_id > ? and core_session_version = ?  and (session_id not in (select MAX(session_id) from apm_session_table) or (session_id in(select MAX(session_id) from apm_session_table) and (duration not null)))"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            r7[r3] = r14
            r14 = 1
            java.lang.String r3 = "V2"
            r7[r14] = r3
            java.lang.String r10 = "session_id ASC"
            java.lang.String r4 = "apm_session_table"
            r5 = 0
            r8 = 0
            r9 = 0
            java.lang.String r11 = "1"
            boolean r14 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            if (r14 != 0) goto L_0x0030
            r5 = 0
            r8 = 0
            r9 = 0
            r3 = r1
            android.database.Cursor r14 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            goto L_0x0037
        L_0x0030:
            r3 = r1
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
            android.database.Cursor r14 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0059, all -> 0x0057 }
        L_0x0037:
            if (r14 == 0) goto L_0x0044
            boolean r3 = r14.moveToFirst()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            if (r3 == 0) goto L_0x0044
            com.instabug.apm.cache.model.f r3 = r13.a((android.database.Cursor) r14)     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            r1.close()     // Catch:{ Exception -> 0x0052, all -> 0x004e }
            if (r14 == 0) goto L_0x004d
            r14.close()
        L_0x004d:
            return r3
        L_0x004e:
            r0 = move-exception
            r2 = r14
            r14 = r0
            goto L_0x0091
        L_0x0052:
            r1 = move-exception
            r12 = r1
            r1 = r14
            r14 = r12
            goto L_0x005b
        L_0x0057:
            r14 = move-exception
            goto L_0x0091
        L_0x0059:
            r14 = move-exception
            r1 = r2
        L_0x005b:
            com.instabug.apm.logger.internal.a r3 = r13.f45155b     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r4.<init>()     // Catch:{ all -> 0x008f }
            r4.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r5 = r14.getMessage()     // Catch:{ all -> 0x008f }
            r4.append(r5)     // Catch:{ all -> 0x008f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008f }
            r3.a(r4, r14)     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r3.<init>()     // Catch:{ all -> 0x008f }
            r3.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r14.getMessage()     // Catch:{ all -> 0x008f }
            r3.append(r0)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x008f }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r14, r0)     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x0097
            r1.close()
            goto L_0x0097
        L_0x008f:
            r14 = move-exception
            r2 = r1
        L_0x0091:
            if (r2 == 0) goto L_0x0096
            r2.close()
        L_0x0096:
            throw r14
        L_0x0097:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.session.e.a(java.lang.String):com.instabug.apm.cache.model.f");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0059  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a() {
        /*
            r12 = this;
            java.lang.String r0 = "Error while getting ready to sync sessions: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = com.instabug.apm.di.a.v()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r1 == 0) goto L_0x009a
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.String r6 = "sync_status = ? and core_session_version = ?"
            r3 = 2
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            java.lang.String r4 = java.lang.String.valueOf(r3)
            r7[r3] = r4
            r3 = 1
            java.lang.String r4 = "V2"
            r7[r3] = r4
            r11 = 0
            java.lang.String r4 = "apm_session_table"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r3 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x005f }
            if (r3 != 0) goto L_0x0037
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r1
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x005f }
            goto L_0x003e
        L_0x0037:
            r3 = r1
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x005f }
            android.database.Cursor r3 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x005f }
        L_0x003e:
            r11 = r3
            if (r11 == 0) goto L_0x0054
            boolean r3 = r11.moveToFirst()     // Catch:{ Exception -> 0x005f }
            if (r3 == 0) goto L_0x0054
        L_0x0047:
            com.instabug.apm.cache.model.f r3 = r12.a((android.database.Cursor) r11)     // Catch:{ Exception -> 0x005f }
            r2.add(r3)     // Catch:{ Exception -> 0x005f }
            boolean r3 = r11.moveToNext()     // Catch:{ Exception -> 0x005f }
            if (r3 != 0) goto L_0x0047
        L_0x0054:
            r1.close()     // Catch:{ Exception -> 0x005f }
            if (r11 == 0) goto L_0x005c
            r11.close()
        L_0x005c:
            return r2
        L_0x005d:
            r0 = move-exception
            goto L_0x0094
        L_0x005f:
            r1 = move-exception
            com.instabug.apm.logger.internal.a r3 = r12.f45155b     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r4.<init>()     // Catch:{ all -> 0x005d }
            r4.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r5 = r1.getMessage()     // Catch:{ all -> 0x005d }
            r4.append(r5)     // Catch:{ all -> 0x005d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x005d }
            r3.a(r4, r1)     // Catch:{ all -> 0x005d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x005d }
            r3.<init>()     // Catch:{ all -> 0x005d }
            r3.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x005d }
            r3.append(r0)     // Catch:{ all -> 0x005d }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x005d }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r1, r0)     // Catch:{ all -> 0x005d }
            if (r11 == 0) goto L_0x009a
            r11.close()
            goto L_0x009a
        L_0x0094:
            if (r11 == 0) goto L_0x0099
            r11.close()
        L_0x0099:
            throw r0
        L_0x009a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.session.e.a():java.util.List");
    }

    @NonNull
    public List a(@NonNull List list) {
        return (List) this.f45154a.executeAndGet(new d(this, list), Collections.emptyList());
    }

    public void a(int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
            String[] strArr = {String.valueOf(i11)};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.APMSessionEntry.TABLE_NAME, "sync_status = ?", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, "sync_status = ?", strArr);
            }
            openDatabase.close();
        }
    }

    public void a(@NonNull List list, int i11) {
        DatabaseManager v11 = com.instabug.apm.di.a.v();
        if (v11 != null) {
            SQLiteDatabaseWrapper openDatabase = v11.openDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("sync_status", Integer.valueOf(i11));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String[] strArr = {(String) it.next()};
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.APMSessionEntry.TABLE_NAME, contentValues, "session_id in (?)", strArr);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.APMSessionEntry.TABLE_NAME, contentValues, "session_id in (?)", strArr);
                }
            }
            openDatabase.close();
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public int b(int i11) {
        return ((Integer) this.f45154a.executeAndGet(new b(i11), 0)).intValue();
    }

    @Nullable
    public f b(String str) {
        return (f) this.f45154a.executeAndGet(new d(this, str));
    }

    public void b(@NonNull List list) {
        this.f45154a.execute(new c(this, list));
    }
}
