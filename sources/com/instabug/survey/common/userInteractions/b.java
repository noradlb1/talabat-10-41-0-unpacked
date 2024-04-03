package com.instabug.survey.common.userInteractions;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.common.models.i;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

@Instrumented
public abstract class b {
    private static ContentValues a(i iVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("survey_id", Long.valueOf(iVar.g()));
        contentValues.put("uuid", iVar.j() != null ? iVar.j() : "null");
        contentValues.put(InstabugDbContract.UserInteractions.COLUMN_USER_INTERACTION_ON_TYPE, Integer.valueOf(iVar.a()));
        contentValues.put("surveyTargeting", iVar.i().toJson());
        contentValues.put("answered", Integer.valueOf(iVar.o() ? 1 : 0));
        contentValues.put("dismissed_at", Long.valueOf(iVar.c()));
        contentValues.put("shown_at", Long.valueOf(iVar.f()));
        contentValues.put("isCancelled", Integer.valueOf(iVar.p() ? 1 : 0));
        contentValues.put("attemptCount", Integer.valueOf(iVar.b()));
        contentValues.put("eventIndex", Integer.valueOf(iVar.d()));
        contentValues.put("shouldShowAgain", Integer.valueOf(iVar.q() ? 1 : 0));
        contentValues.put("sessionCounter", Integer.valueOf(iVar.e()));
        contentValues.put(InstabugDbContract.UserInteractions.COLUMN_ALREADY_SHOWN, Integer.valueOf(iVar.n() ? 1 : 0));
        return contentValues;
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x017a A[SYNTHETIC, Splitter:B:80:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0187 A[SYNTHETIC, Splitter:B:88:0x0187] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.instabug.survey.common.models.i a(java.lang.Long r18, java.lang.String r19, int r20) {
        /*
            r0 = r19
            java.lang.Class<com.instabug.survey.common.userInteractions.b> r1 = com.instabug.survey.common.userInteractions.b.class
            monitor-enter(r1)
            com.instabug.library.internal.storage.cache.db.DatabaseManager r2 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ all -> 0x018e }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r2 = r2.openDatabase()     // Catch:{ all -> 0x018e }
            r11 = 0
            java.lang.String r4 = "user_interaction"
            r5 = 0
            java.lang.String r6 = "survey_id=? AND uuid=? AND action_on_type=?"
            r3 = 3
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            java.lang.String r3 = java.lang.String.valueOf(r18)     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            r12 = 0
            r7[r12] = r3     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            r13 = 1
            r7[r13] = r0     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            java.lang.String r3 = java.lang.String.valueOf(r20)     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            r8 = 2
            r7[r8] = r3     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r3 = r2 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            if (r3 != 0) goto L_0x0043
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x003e, all -> 0x003a }
            goto L_0x004a
        L_0x003a:
            r0 = move-exception
            r13 = r2
            goto L_0x0185
        L_0x003e:
            r0 = move-exception
            r13 = r2
            r3 = r11
            goto L_0x0144
        L_0x0043:
            r3 = r2
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x0141, all -> 0x013d }
            android.database.Cursor r3 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0141, all -> 0x013d }
        L_0x004a:
            if (r3 != 0) goto L_0x0056
            if (r3 == 0) goto L_0x0051
            r3.close()     // Catch:{ all -> 0x018e }
        L_0x0051:
            r2.close()     // Catch:{ all -> 0x018e }
            monitor-exit(r1)
            return r11
        L_0x0056:
            java.lang.String r4 = "answered"
            int r4 = r3.getColumnIndex(r4)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r5 = "dismissed_at"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r6 = "shown_at"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r7 = "isCancelled"
            int r7 = r3.getColumnIndex(r7)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r8 = "attemptCount"
            int r8 = r3.getColumnIndex(r8)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r9 = "eventIndex"
            int r9 = r3.getColumnIndex(r9)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r10 = "shouldShowAgain"
            int r10 = r3.getColumnIndex(r10)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r14 = "sessionCounter"
            int r14 = r3.getColumnIndex(r14)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r15 = "surveyTargeting"
            int r15 = r3.getColumnIndex(r15)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r12 = "is_already_shown"
            int r12 = r3.getColumnIndex(r12)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            boolean r16 = r3.moveToFirst()     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            if (r16 != 0) goto L_0x00ae
            r3.close()     // Catch:{ Exception -> 0x00aa, all -> 0x00a6 }
            r3.close()     // Catch:{ all -> 0x018e }
            r2.close()     // Catch:{ all -> 0x018e }
            monitor-exit(r1)
            return r11
        L_0x00a6:
            r0 = move-exception
            r13 = r2
            goto L_0x0184
        L_0x00aa:
            r0 = move-exception
            r13 = r2
            goto L_0x0144
        L_0x00ae:
            int r4 = r3.getInt(r4)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r5 = r3.getInt(r5)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r6 = r3.getInt(r6)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r7 = r3.getInt(r7)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r8 = r3.getInt(r8)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r9 = r3.getInt(r9)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r10 = r3.getInt(r10)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r14 = r3.getInt(r14)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            java.lang.String r15 = r3.getString(r15)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            int r12 = r3.getInt(r12)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            com.instabug.survey.common.models.i r11 = new com.instabug.survey.common.models.i     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            r13 = r20
            r11.<init>(r13)     // Catch:{ Exception -> 0x0138, all -> 0x0131 }
            r13 = r2
            r17 = r3
            long r2 = r18.longValue()     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.c((long) r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.a((java.lang.String) r0)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.a((int) r8)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            long r2 = (long) r6     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.b((long) r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.b((int) r9)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r0 = 1
            if (r7 != r0) goto L_0x00f9
            r2 = r0
            goto L_0x00fa
        L_0x00f9:
            r2 = 0
        L_0x00fa:
            r11.c((boolean) r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            if (r4 != r0) goto L_0x0101
            r2 = r0
            goto L_0x0102
        L_0x0101:
            r2 = 0
        L_0x0102:
            r11.b((boolean) r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            long r2 = (long) r5     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.a((long) r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.c((int) r14)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            if (r10 != r0) goto L_0x0110
            r2 = r0
            goto L_0x0111
        L_0x0110:
            r2 = 0
        L_0x0111:
            r11.d(r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            com.instabug.survey.common.models.g r2 = com.instabug.survey.common.models.g.a((java.lang.String) r15)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r11.a((com.instabug.survey.common.models.g) r2)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            if (r12 != r0) goto L_0x011f
            r12 = r0
            goto L_0x0120
        L_0x011f:
            r12 = 0
        L_0x0120:
            r11.a((boolean) r12)     // Catch:{ Exception -> 0x012d, all -> 0x012b }
            r17.close()     // Catch:{ all -> 0x018e }
            r13.close()     // Catch:{ all -> 0x018e }
            monitor-exit(r1)
            return r11
        L_0x012b:
            r0 = move-exception
            goto L_0x0135
        L_0x012d:
            r0 = move-exception
            r3 = r17
            goto L_0x0144
        L_0x0131:
            r0 = move-exception
            r13 = r2
            r17 = r3
        L_0x0135:
            r11 = r17
            goto L_0x0185
        L_0x0138:
            r0 = move-exception
            r13 = r2
            r17 = r3
            goto L_0x0144
        L_0x013d:
            r0 = move-exception
            r13 = r2
            r11 = 0
            goto L_0x0185
        L_0x0141:
            r0 = move-exception
            r13 = r2
            r3 = 0
        L_0x0144:
            java.lang.String r2 = "IBG-Surveys"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0183 }
            r4.<init>()     // Catch:{ all -> 0x0183 }
            java.lang.String r5 = "user interaction retrieveBySurveyIdAndUUID failed due to "
            r4.append(r5)     // Catch:{ all -> 0x0183 }
            java.lang.String r5 = r0.getMessage()     // Catch:{ all -> 0x0183 }
            r4.append(r5)     // Catch:{ all -> 0x0183 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0183 }
            com.instabug.library.util.InstabugSDKLogger.e(r2, r4)     // Catch:{ all -> 0x0183 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0183 }
            r2.<init>()     // Catch:{ all -> 0x0183 }
            java.lang.String r4 = "user interaction retrieveBySurveyIdAndUUID failed due to "
            r2.append(r4)     // Catch:{ all -> 0x0183 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0183 }
            r2.append(r4)     // Catch:{ all -> 0x0183 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0183 }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r2)     // Catch:{ all -> 0x0183 }
            if (r3 == 0) goto L_0x017d
            r3.close()     // Catch:{ all -> 0x018e }
        L_0x017d:
            r13.close()     // Catch:{ all -> 0x018e }
            monitor-exit(r1)
            r1 = 0
            return r1
        L_0x0183:
            r0 = move-exception
        L_0x0184:
            r11 = r3
        L_0x0185:
            if (r11 == 0) goto L_0x018a
            r11.close()     // Catch:{ all -> 0x018e }
        L_0x018a:
            r13.close()     // Catch:{ all -> 0x018e }
            throw r0     // Catch:{ all -> 0x018e }
        L_0x018e:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.common.userInteractions.b.a(java.lang.Long, java.lang.String, int):com.instabug.survey.common.models.i");
    }

    public static synchronized void a(@NonNull List list) {
        synchronized (b.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            openDatabase.beginTransaction();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    String[] strArr = {String.valueOf(iVar.g()), iVar.j(), String.valueOf(iVar.a())};
                    if (!(openDatabase instanceof SQLiteDatabase)) {
                        openDatabase.delete(InstabugDbContract.UserInteractions.TABLE_NAME, "survey_id=? AND uuid=? AND action_on_type=?", strArr);
                    } else {
                        SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.UserInteractions.TABLE_NAME, "survey_id=? AND uuid=? AND action_on_type=?", strArr);
                    }
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    public static synchronized void b(@NonNull List list) {
        synchronized (b.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i iVar = (i) it.next();
                    if (!b(iVar)) {
                        InstabugSDKLogger.e("IBG-Surveys", "Couldn't insert user interaction to DB, user interaction is invalid");
                    } else {
                        if (openDatabase.insertWithOnConflict(InstabugDbContract.UserInteractions.TABLE_NAME, (String) null, a(iVar)) == -1) {
                            c(iVar);
                        }
                        InstabugSDKLogger.d("IBG-Surveys", "survey user interaction with survey id: " + iVar.g() + " and uuid: " + iVar.j() + " has been added to " + InstabugDbContract.UserInteractions.TABLE_NAME);
                    }
                }
                openDatabase.setTransactionSuccessful();
                openDatabase.endTransaction();
            } catch (JSONException e11) {
                try {
                    InstabugSDKLogger.e("IBG-Surveys", "survey insertion failed due to " + e11.getMessage());
                    IBGDiagnostics.reportNonFatal(e11, "survey insertion failed due to " + e11.getMessage());
                    openDatabase.endTransaction();
                } catch (Throwable th2) {
                    openDatabase.endTransaction();
                    openDatabase.close();
                    throw th2;
                }
            }
            openDatabase.close();
        }
        return;
    }

    private static boolean b(i iVar) {
        return (iVar == null || iVar.g() == 0 || iVar.j() == null || iVar.j().isEmpty()) ? false : true;
    }

    public static synchronized long c(i iVar) {
        long update;
        synchronized (b.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {String.valueOf(iVar.g()), iVar.j(), String.valueOf(iVar.a())};
            try {
                openDatabase.beginTransaction();
                ContentValues a11 = a(iVar);
                update = (long) (!(openDatabase instanceof SQLiteDatabase) ? openDatabase.update(InstabugDbContract.UserInteractions.TABLE_NAME, a11, "survey_id=? AND uuid=? AND action_on_type=?", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.UserInteractions.TABLE_NAME, a11, "survey_id=? AND uuid=? AND action_on_type=?", strArr));
                openDatabase.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-Surveys", "survey user interaction with survey id: " + iVar.g() + " and uuid: " + iVar.j() + " has been updated ");
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (JSONException e11) {
                try {
                    InstabugSDKLogger.e("IBG-Surveys", "survey updating failed due to " + e11.getMessage());
                    IBGDiagnostics.reportNonFatal(e11, "survey updating failed due to " + e11.getMessage());
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return update;
    }
}
