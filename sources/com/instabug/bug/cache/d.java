package com.instabug.bug.cache;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.Attachment;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.json.JSONArray;

@Instrumented
public class d implements a {
    public long a(com.instabug.bug.model.d dVar) {
        if (dVar.getId() == null) {
            InstabugSDKLogger.e("IBG-BR", "Couldn't save the bug to DB because its ID is null");
            return -1;
        }
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        openDatabase.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", dVar.getId());
            contentValues.put("message", dVar.g());
            contentValues.put(InstabugDbContract.BugEntry.COLUMN_BUG_STATE, dVar.b().name());
            if (dVar.h() != null) {
                contentValues.put("temporary_server_token", dVar.h());
            }
            contentValues.put("type", dVar.i());
            JSONArray c11 = dVar.c();
            contentValues.put(InstabugDbContract.BugEntry.COLUMN_CATEGORIES_LIST, !(c11 instanceof JSONArray) ? c11.toString() : JSONArrayInstrumentation.toString(c11));
            if (dVar.j() != null) {
                contentValues.put(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY, dVar.j());
            }
            if (!(dVar.getState() == null || dVar.getState().getUri() == null)) {
                contentValues.put("state", dVar.getState().getUri().toString());
            }
            for (Attachment attachment : dVar.a()) {
                long insert = AttachmentsDbHelper.insert(attachment, dVar.getId());
                if (insert != -1) {
                    attachment.setId(insert);
                }
            }
            long insert2 = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.insert(InstabugDbContract.BugEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.BugEntry.TABLE_NAME, (String) null, contentValues);
            openDatabase.setTransactionSuccessful();
            return insert2;
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ec, code lost:
        r15 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00ed, code lost:
        r13 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ef, code lost:
        r15 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f0, code lost:
        r13 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f2, code lost:
        if (r3 != null) goto L_0x0114;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0113, code lost:
        r3 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ec A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(android.content.Context r15) {
        /*
            r14 = this;
            java.lang.String r0 = "retrieve bug reports failed: "
            java.lang.String r1 = "IBG-BR"
            if (r15 == 0) goto L_0x0124
            com.instabug.library.internal.storage.cache.db.DatabaseManager r2 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r2 = r2.openDatabase()
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r13 = 0
            java.lang.String r4 = "bugs_table"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            boolean r3 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x00f7 }
            if (r3 != 0) goto L_0x002e
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00f7 }
            goto L_0x0035
        L_0x002e:
            r3 = r2
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x00f7 }
            android.database.Cursor r3 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x00f7 }
        L_0x0035:
            if (r3 == 0) goto L_0x00f2
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            if (r4 == 0) goto L_0x00f2
        L_0x003d:
            com.instabug.bug.model.d r4 = new com.instabug.bug.model.d     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.<init>()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "id"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.setId((java.lang.String) r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "message"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.d(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "bug_state"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.Class<com.instabug.bug.model.a> r6 = com.instabug.bug.model.a.class
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.Enum r5 = java.lang.Enum.valueOf(r6, r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            com.instabug.bug.model.a r5 = (com.instabug.bug.model.a) r5     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.a((com.instabug.bug.model.a) r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "temporary_server_token"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.e(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "type"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.f(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "categories_list"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            org.json.JSONArray r6 = new org.json.JSONArray     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r6.<init>((java.lang.String) r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.a((org.json.JSONArray) r6)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "view_hierarchy"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.g(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = "state"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            if (r5 == 0) goto L_0x00bb
            android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            goto L_0x00bc
        L_0x00bb:
            r5 = r13
        L_0x00bc:
            com.instabug.library.model.State r5 = com.instabug.library.model.State.getState((android.content.Context) r15, (android.net.Uri) r5)     // Catch:{ OutOfMemoryError -> 0x00c6, Exception -> 0x00c4, all -> 0x00ec }
            r4.setState((com.instabug.library.model.State) r5)     // Catch:{ OutOfMemoryError -> 0x00c6, Exception -> 0x00c4, all -> 0x00ec }
            goto L_0x00d1
        L_0x00c4:
            r5 = move-exception
            goto L_0x00c7
        L_0x00c6:
            r5 = move-exception
        L_0x00c7:
            java.lang.String r6 = "retrieving bug state throws OOM"
            com.instabug.library.core.InstabugCore.reportError(r5, r6)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.lang.String r6 = "Retrieving bug state throws an exception"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r6, r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        L_0x00d1:
            java.lang.String r5 = r4.getId()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            if (r5 == 0) goto L_0x00e5
            java.lang.String r5 = r4.getId()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            java.util.ArrayList r5 = com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve((java.lang.String) r5, (com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r2)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r4.a((java.util.List) r5)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            r12.add(r4)     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
        L_0x00e5:
            boolean r4 = r3.moveToNext()     // Catch:{ Exception -> 0x00ef, all -> 0x00ec }
            if (r4 != 0) goto L_0x003d
            goto L_0x00f2
        L_0x00ec:
            r15 = move-exception
            r13 = r3
            goto L_0x011b
        L_0x00ef:
            r15 = move-exception
            r13 = r3
            goto L_0x00f8
        L_0x00f2:
            if (r3 == 0) goto L_0x0117
            goto L_0x0114
        L_0x00f5:
            r15 = move-exception
            goto L_0x011b
        L_0x00f7:
            r15 = move-exception
        L_0x00f8:
            com.instabug.library.util.InstabugSDKLogger.e(r1, r0, r15)     // Catch:{ all -> 0x00f5 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f5 }
            r1.<init>()     // Catch:{ all -> 0x00f5 }
            r1.append(r0)     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = r15.getMessage()     // Catch:{ all -> 0x00f5 }
            r1.append(r0)     // Catch:{ all -> 0x00f5 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00f5 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r15, r0)     // Catch:{ all -> 0x00f5 }
            if (r13 == 0) goto L_0x0117
            r3 = r13
        L_0x0114:
            r3.close()
        L_0x0117:
            r2.close()
            return r12
        L_0x011b:
            if (r13 == 0) goto L_0x0120
            r13.close()
        L_0x0120:
            r2.close()
            throw r15
        L_0x0124:
            java.lang.String r15 = "Context is null while retrieving bugs from DB."
            com.instabug.library.util.InstabugSDKLogger.e(r1, r15)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.cache.d.a(android.content.Context):java.util.List");
    }

    public void a() {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.BugEntry.TABLE_NAME, (String) null, (String[]) null);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.BugEntry.TABLE_NAME, (String) null, (String[]) null);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public void a(String str) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.BugEntry.TABLE_NAME, "id=? ", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.BugEntry.TABLE_NAME, "id=? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public void a(String str, ContentValues contentValues) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {str};
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.BugEntry.TABLE_NAME, contentValues, "id=? ", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.BugEntry.TABLE_NAME, contentValues, "id=? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }

    public void b() {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        openDatabase.beginTransaction();
        try {
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.execSQL(InstabugDbContract.BugEntry.DROP_TABLE);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, InstabugDbContract.BugEntry.DROP_TABLE);
            }
            openDatabase.setTransactionSuccessful();
        } finally {
            openDatabase.endTransaction();
            openDatabase.close();
        }
    }
}
