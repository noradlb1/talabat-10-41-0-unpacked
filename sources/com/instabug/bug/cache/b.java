package com.instabug.bug.cache;

import android.database.sqlite.SQLiteDatabase;
import com.instabug.bug.model.d;
import com.instabug.library.internal.storage.cache.AttachmentsDbHelper;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGDbManager;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.instabug.library.model.Attachment;
import com.instabug.library.util.InstabugSDKLogger;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

@Instrumented
public class b implements a {
    public long a(d dVar) {
        IBGDbManager instance = IBGDbManager.getInstance();
        if (instance == null) {
            return -1;
        }
        if (dVar.getId() == null) {
            InstabugSDKLogger.e("IBG-BR", "Couldn't save the bug to DB because its ID is null");
            return -1;
        }
        try {
            IBGContentValues iBGContentValues = new IBGContentValues();
            iBGContentValues.put("id", dVar.getId(), true);
            iBGContentValues.put("message", dVar.g(), false);
            iBGContentValues.put(InstabugDbContract.BugEntry.COLUMN_BUG_STATE, dVar.b().name(), false);
            if (dVar.h() != null) {
                iBGContentValues.put("temporary_server_token", dVar.h(), false);
            }
            iBGContentValues.put("type", dVar.i(), false);
            JSONArray c11 = dVar.c();
            iBGContentValues.put(InstabugDbContract.BugEntry.COLUMN_CATEGORIES_LIST, !(c11 instanceof JSONArray) ? c11.toString() : JSONArrayInstrumentation.toString(c11), false);
            if (dVar.j() != null) {
                iBGContentValues.put(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY, dVar.j(), false);
            }
            if (!(dVar.getState() == null || dVar.getState().getUri() == null)) {
                iBGContentValues.put("state", dVar.getState().getUri().toString(), false);
            }
            for (Attachment attachment : dVar.a()) {
                long insert = AttachmentsDbHelper.insert(attachment, dVar.getId());
                if (insert != -1) {
                    attachment.setId(insert);
                }
            }
            long insertWithOnConflictReplace = instance.insertWithOnConflictReplace(InstabugDbContract.BugEntry.TABLE_NAME, (String) null, iBGContentValues);
            instance.setTransactionSuccessful();
            return insertWithOnConflictReplace;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Something went wrong while inserting bug", e11);
            return -1;
        } finally {
            instance.endTransaction();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b4, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.instabug.library.core.InstabugCore.reportError(r3, "retrieving bug state throws error");
        com.instabug.library.util.InstabugSDKLogger.e("IBG-BR", "Retrieving bug state throws an exception", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e4, code lost:
        r14 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e5, code lost:
        r12 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ea, code lost:
        if (r1 != null) goto L_0x010c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0112, code lost:
        r12.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e4 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:10:0x0027] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List a(android.content.Context r14) {
        /*
            r13 = this;
            java.lang.String r0 = "retrieve bug reports failed: "
            com.instabug.library.internal.storage.cache.dbv2.IBGDbManager r1 = com.instabug.library.internal.storage.cache.dbv2.IBGDbManager.getInstance()
            if (r1 != 0) goto L_0x000e
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            return r14
        L_0x000e:
            java.lang.String r10 = "IBG-BR"
            if (r14 == 0) goto L_0x0116
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r12 = 0
            java.lang.String r2 = "bugs_table"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            com.instabug.library.internal.storage.cache.dbv2.IBGCursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x00ef }
            if (r1 == 0) goto L_0x00ea
            boolean r2 = r1.moveToFirst()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            if (r2 == 0) goto L_0x00ea
        L_0x002d:
            com.instabug.bug.model.d r2 = new com.instabug.bug.model.d     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.<init>()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "id"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.setId((java.lang.String) r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "message"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.d(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "bug_state"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.Class<com.instabug.bug.model.a> r4 = com.instabug.bug.model.a.class
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.Enum r3 = java.lang.Enum.valueOf(r4, r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            com.instabug.bug.model.a r3 = (com.instabug.bug.model.a) r3     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.a((com.instabug.bug.model.a) r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "temporary_server_token"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.e(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "type"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.f(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "categories_list"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r4.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.a((org.json.JSONArray) r4)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "view_hierarchy"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.g(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = "state"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r3 = r1.getString(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            if (r3 == 0) goto L_0x00ab
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            goto L_0x00ac
        L_0x00ab:
            r3 = r12
        L_0x00ac:
            com.instabug.library.model.State r3 = com.instabug.library.model.State.getState((android.content.Context) r14, (android.net.Uri) r3)     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00b4, all -> 0x00e4 }
            r2.setState((com.instabug.library.model.State) r3)     // Catch:{ OutOfMemoryError -> 0x00b6, Exception -> 0x00b4, all -> 0x00e4 }
            goto L_0x00c1
        L_0x00b4:
            r3 = move-exception
            goto L_0x00b7
        L_0x00b6:
            r3 = move-exception
        L_0x00b7:
            java.lang.String r4 = "retrieving bug state throws error"
            com.instabug.library.core.InstabugCore.reportError(r3, r4)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r4 = "Retrieving bug state throws an exception"
            com.instabug.library.util.InstabugSDKLogger.e(r10, r4, r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
        L_0x00c1:
            java.lang.String r3 = r2.getId()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            if (r3 == 0) goto L_0x00dd
            com.instabug.library.internal.storage.cache.db.DatabaseManager r3 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r3 = r3.openDatabase()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.lang.String r4 = r2.getId()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            java.util.ArrayList r3 = com.instabug.library.internal.storage.cache.AttachmentsDbHelper.retrieve((java.lang.String) r4, (com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r2.a((java.util.List) r3)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            r11.add(r2)     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
        L_0x00dd:
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x00e7, all -> 0x00e4 }
            if (r2 != 0) goto L_0x002d
            goto L_0x00ea
        L_0x00e4:
            r14 = move-exception
            r12 = r1
            goto L_0x0110
        L_0x00e7:
            r14 = move-exception
            r12 = r1
            goto L_0x00f0
        L_0x00ea:
            if (r1 == 0) goto L_0x010f
            goto L_0x010c
        L_0x00ed:
            r14 = move-exception
            goto L_0x0110
        L_0x00ef:
            r14 = move-exception
        L_0x00f0:
            com.instabug.library.util.InstabugSDKLogger.e(r10, r0, r14)     // Catch:{ all -> 0x00ed }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ed }
            r1.<init>()     // Catch:{ all -> 0x00ed }
            r1.append(r0)     // Catch:{ all -> 0x00ed }
            java.lang.String r0 = r14.getMessage()     // Catch:{ all -> 0x00ed }
            r1.append(r0)     // Catch:{ all -> 0x00ed }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x00ed }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r14, r0)     // Catch:{ all -> 0x00ed }
            if (r12 == 0) goto L_0x010f
            r1 = r12
        L_0x010c:
            r1.close()
        L_0x010f:
            return r11
        L_0x0110:
            if (r12 == 0) goto L_0x0115
            r12.close()
        L_0x0115:
            throw r14
        L_0x0116:
            java.lang.String r14 = "Context was null while retrieving bugs from DB."
            com.instabug.library.util.InstabugSDKLogger.e(r10, r14)
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.bug.cache.b.a(android.content.Context):java.util.List");
    }

    public void a() {
        IBGDbManager instance = IBGDbManager.getInstance();
        if (instance != null) {
            instance.beginTransaction();
            try {
                instance.delete(InstabugDbContract.BugEntry.TABLE_NAME, (String) null, (List<IBGWhereArg>) null);
                instance.setTransactionSuccessful();
            } finally {
                instance.endTransaction();
            }
        }
    }

    public void a(String str) {
        IBGDbManager instance = IBGDbManager.getInstance();
        if (instance != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new IBGWhereArg(str, true));
            try {
                instance.delete(InstabugDbContract.BugEntry.TABLE_NAME, "id=? ", arrayList);
                instance.setTransactionSuccessful();
            } finally {
                instance.endTransaction();
            }
        }
    }

    public void a(String str, IBGContentValues iBGContentValues) {
        IBGDbManager instance = IBGDbManager.getInstance();
        if (instance != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new IBGWhereArg(str, true));
            try {
                instance.update(InstabugDbContract.BugEntry.TABLE_NAME, iBGContentValues, "id=? ", arrayList);
                instance.setTransactionSuccessful();
            } finally {
                instance.endTransaction();
            }
        }
    }

    public void b() {
        IBGDbManager instance = IBGDbManager.getInstance();
        if (instance != null) {
            instance.beginTransaction();
            try {
                if (!(instance instanceof SQLiteDatabase)) {
                    instance.execSQL(InstabugDbContract.BugEntry.DROP_TABLE);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) instance, InstabugDbContract.BugEntry.DROP_TABLE);
                }
                instance.setTransactionSuccessful();
            } finally {
                instance.endTransaction();
            }
        }
    }
}
