package com.instabug.survey.announcements.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.announcements.models.c;
import com.instabug.survey.common.models.b;
import com.instabug.survey.common.models.g;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

@Instrumented
public abstract class f {
    public static int a(long j11, int i11) {
        String[] strArr = {String.valueOf(j11)};
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_ASSETS_STATUS, Integer.valueOf(i11));
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        return !(openDatabase instanceof SQLiteDatabase) ? openDatabase.update(InstabugDbContract.AnnouncementEntry.TABLE_NAME, contentValues, "announcement_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementEntry.TABLE_NAME, contentValues, "announcement_id=? ", strArr);
    }

    @WorkerThread
    private static synchronized long a(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, long j11, ContentValues contentValues) {
        long update;
        synchronized (f.class) {
            String[] strArr = {String.valueOf(j11)};
            update = (long) (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.update(InstabugDbContract.AnnouncementEntry.TABLE_NAME, contentValues, "announcement_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.AnnouncementEntry.TABLE_NAME, contentValues, "announcement_id=? ", strArr));
            InstabugSDKLogger.d("IBG-Surveys", "announcement with id: " + j11 + " has been updated in DB");
        }
        return update;
    }

    @WorkerThread
    public static synchronized long a(a aVar, boolean z11, boolean z12) {
        long insertWithOnConflict;
        synchronized (f.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String) null, a(aVar));
                if (insertWithOnConflict == -1) {
                    if (z11) {
                        a(openDatabase, aVar);
                    }
                    if (z12) {
                        b(openDatabase, aVar);
                    }
                }
                openDatabase.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-Surveys", "Announcement with id: " + aVar.i() + " has been added to DB");
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception | OutOfMemoryError e11) {
                try {
                    IBGDiagnostics.reportNonFatalAndLog(e11, "announcement insertion failed due to " + e11.getMessage(), "IBG-Surveys");
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflict;
    }

    private static ContentValues a(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_ID, Long.valueOf(aVar.i()));
        if (aVar.o() != null) {
            contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_TITLE, aVar.o());
        }
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_TYPE, Integer.valueOf(aVar.p()));
        contentValues.put("conditions_operator", aVar.f());
        contentValues.put("answered", Integer.valueOf(aVar.t() ? 1 : 0));
        contentValues.put("dismissed_at", Long.valueOf(aVar.g()));
        contentValues.put("shown_at", Long.valueOf(aVar.m()));
        contentValues.put("isCancelled", Integer.valueOf(aVar.u() ? 1 : 0));
        contentValues.put("eventIndex", Integer.valueOf(aVar.h()));
        contentValues.put("shouldShowAgain", Integer.valueOf(aVar.z() ? 1 : 0));
        contentValues.put("paused", Integer.valueOf(aVar.v() ? 1 : 0));
        contentValues.put("sessionCounter", Integer.valueOf(aVar.l()));
        JSONArray c11 = c.c(aVar.c());
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCEMENT, !(c11 instanceof JSONArray) ? c11.toString() : JSONArrayInstrumentation.toString(c11));
        JSONObject a11 = g.a(aVar.n());
        contentValues.put("targetAudiences", !(a11 instanceof JSONObject) ? a11.toString() : JSONObjectInstrumentation.toString(a11));
        JSONArray a12 = com.instabug.survey.common.models.a.a(aVar.b());
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCE_EVENTS, !(a12 instanceof JSONArray) ? a12.toString() : JSONArrayInstrumentation.toString(a12));
        contentValues.put("surveyState", aVar.d().toString());
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_ASSETS_STATUS, Integer.valueOf(aVar.e()));
        contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_IS_SHOWN, Integer.valueOf(aVar.s() ? 1 : 0));
        contentValues.put("isLocalized", Boolean.valueOf(aVar.j().c()));
        contentValues.put("supportedLocales", JSONArrayInstrumentation.toString(new JSONArray((Collection<?>) aVar.j().b())));
        if (!(aVar.j() == null || aVar.j().a() == null)) {
            contentValues.put("currentLocale", aVar.j().a());
        }
        return contentValues;
    }

    @WorkerThread
    public static List a(int i11) {
        SQLiteDatabaseWrapper sQLiteDatabaseWrapper;
        String str;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {String.valueOf(i11)};
        Cursor query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String[]) null, "announcement_type=? ", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String[]) null, "announcement_type=? ", strArr, (String) null, (String) null, (String) null);
        if (query == null) {
            return new ArrayList();
        }
        int columnIndex = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_ID);
        int columnIndex2 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_TYPE);
        int columnIndex3 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_TITLE);
        int columnIndex4 = query.getColumnIndex("conditions_operator");
        int columnIndex5 = query.getColumnIndex("answered");
        int columnIndex6 = query.getColumnIndex("dismissed_at");
        int columnIndex7 = query.getColumnIndex("shown_at");
        int columnIndex8 = query.getColumnIndex("isCancelled");
        int columnIndex9 = query.getColumnIndex("eventIndex");
        int columnIndex10 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_IS_SHOWN);
        int columnIndex11 = query.getColumnIndex("paused");
        int columnIndex12 = query.getColumnIndex("targetAudiences");
        int columnIndex13 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCEMENT);
        String str2 = "IBG-Surveys";
        int columnIndex14 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_ASSETS_STATUS);
        int columnIndex15 = query.getColumnIndex("supportedLocales");
        int columnIndex16 = query.getColumnIndex("isLocalized");
        int columnIndex17 = query.getColumnIndex("currentLocale");
        try {
            if (!query.moveToFirst()) {
                query.close();
                ArrayList arrayList = new ArrayList();
                query.close();
                openDatabase.close();
                return arrayList;
            }
            sQLiteDatabaseWrapper = openDatabase;
            try {
                ArrayList arrayList2 = new ArrayList();
                int i12 = columnIndex13;
                int i13 = columnIndex17;
                while (true) {
                    long j11 = query.getLong(columnIndex);
                    int i14 = columnIndex;
                    int i15 = query.getInt(columnIndex2);
                    int i16 = columnIndex2;
                    String string = query.getString(columnIndex3);
                    int i17 = columnIndex3;
                    String string2 = query.getString(columnIndex4);
                    int i18 = columnIndex4;
                    int i19 = query.getInt(columnIndex5);
                    int i21 = columnIndex5;
                    int i22 = query.getInt(columnIndex6);
                    int i23 = columnIndex6;
                    int i24 = query.getInt(columnIndex7);
                    int i25 = columnIndex7;
                    int i26 = query.getInt(columnIndex8);
                    int i27 = columnIndex8;
                    int i28 = query.getInt(columnIndex9);
                    int i29 = columnIndex9;
                    int i31 = query.getInt(columnIndex10);
                    int i32 = columnIndex10;
                    int i33 = query.getInt(columnIndex11);
                    int i34 = columnIndex11;
                    String string3 = query.getString(columnIndex12);
                    int i35 = columnIndex12;
                    int i36 = i12;
                    ArrayList arrayList3 = arrayList2;
                    String string4 = query.getString(i36);
                    int i37 = i36;
                    int i38 = columnIndex14;
                    String str3 = string3;
                    int i39 = query.getInt(i38);
                    int i41 = i38;
                    int i42 = columnIndex15;
                    int i43 = i39;
                    String string5 = query.getString(i42);
                    int i44 = i42;
                    int i45 = columnIndex16;
                    String str4 = string5;
                    int i46 = query.getInt(i45);
                    int i47 = i45;
                    int i48 = i13;
                    int i49 = i46;
                    String string6 = query.getString(i48);
                    int i50 = i48;
                    a aVar = new a();
                    aVar.b(j11);
                    aVar.d(i15);
                    aVar.b(string);
                    aVar.a(string2);
                    aVar.b(i19 == 1);
                    aVar.a((long) i22);
                    aVar.c((long) i24);
                    aVar.c(i26 == 1);
                    aVar.b(i28);
                    aVar.a(i31 == 1);
                    aVar.d(i33 == 1);
                    aVar.d(i33 == 1);
                    aVar.a(c.a(new JSONArray(string4)));
                    aVar.a(i43);
                    aVar.j().a(new JSONArray(str4));
                    aVar.j().a(string6);
                    aVar.j().a(i49 == 1);
                    g gVar = new g();
                    gVar.fromJson(str3);
                    aVar.a(gVar);
                    ArrayList arrayList4 = arrayList3;
                    arrayList4.add(aVar);
                    if (!query.moveToNext()) {
                        str = str2;
                        try {
                            InstabugSDKLogger.d(str, arrayList4.size() + " announcements have been retrieved from DB");
                            query.close();
                            sQLiteDatabaseWrapper.close();
                            return arrayList4;
                        } catch (Exception | OutOfMemoryError e11) {
                            e = e11;
                            try {
                                IBGDiagnostics.reportNonFatalAndLog(e, "announcement conversion failed due to " + e.getMessage(), str);
                                ArrayList arrayList5 = new ArrayList();
                                query.close();
                                sQLiteDatabaseWrapper.close();
                                return arrayList5;
                            } catch (Throwable th2) {
                                th = th2;
                                query.close();
                                sQLiteDatabaseWrapper.close();
                                throw th;
                            }
                        }
                    } else {
                        arrayList2 = arrayList4;
                        columnIndex = i14;
                        columnIndex2 = i16;
                        columnIndex3 = i17;
                        columnIndex4 = i18;
                        columnIndex5 = i21;
                        columnIndex6 = i23;
                        columnIndex7 = i25;
                        columnIndex8 = i27;
                        columnIndex9 = i29;
                        columnIndex10 = i32;
                        columnIndex11 = i34;
                        columnIndex12 = i35;
                        i12 = i37;
                        columnIndex14 = i41;
                        columnIndex15 = i44;
                        columnIndex16 = i47;
                        i13 = i50;
                    }
                }
            } catch (Exception | OutOfMemoryError e12) {
                e = e12;
                str = str2;
                IBGDiagnostics.reportNonFatalAndLog(e, "announcement conversion failed due to " + e.getMessage(), str);
                ArrayList arrayList52 = new ArrayList();
                query.close();
                sQLiteDatabaseWrapper.close();
                return arrayList52;
            }
        } catch (Exception | OutOfMemoryError e13) {
            e = e13;
            sQLiteDatabaseWrapper = openDatabase;
            str = str2;
            IBGDiagnostics.reportNonFatalAndLog(e, "announcement conversion failed due to " + e.getMessage(), str);
            ArrayList arrayList522 = new ArrayList();
            query.close();
            sQLiteDatabaseWrapper.close();
            return arrayList522;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabaseWrapper = openDatabase;
            query.close();
            sQLiteDatabaseWrapper.close();
            throw th;
        }
    }

    @WorkerThread
    public static void a() {
        for (a aVar : b()) {
            aVar.a(0);
            c(aVar);
        }
    }

    @WorkerThread
    private static void a(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("paused", Boolean.valueOf(aVar.v()));
        a(sQLiteDatabaseWrapper, aVar.i(), contentValues);
    }

    @WorkerThread
    public static synchronized void a(String str) {
        synchronized (f.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            String[] strArr = {str};
            openDatabase.beginTransaction();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.AnnouncementEntry.TABLE_NAME, "announcement_id=? ", strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementEntry.TABLE_NAME, "announcement_id=? ", strArr);
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    @WorkerThread
    public static boolean a(long j11) {
        Cursor query;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        try {
            String[] strArr = {String.valueOf(j11)};
            query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String[]) null, "announcement_id=? ", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String[]) null, "announcement_id=? ", strArr, (String) null, (String) null, (String) null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                openDatabase.close();
                return false;
            }
            boolean moveToFirst = query.moveToFirst();
            query.close();
            openDatabase.close();
            return moveToFirst;
        } catch (Exception | OutOfMemoryError e11) {
            try {
                IBGDiagnostics.reportNonFatal(e11, "check announcement Existing failed due to " + e11.getMessage());
                return false;
            } finally {
                openDatabase.close();
            }
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    @WorkerThread
    public static synchronized long b(a aVar) {
        long insertWithOnConflict;
        synchronized (f.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                insertWithOnConflict = openDatabase.insertWithOnConflict(InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String) null, a(aVar));
                if (insertWithOnConflict == -1) {
                    c(aVar);
                }
                openDatabase.setTransactionSuccessful();
                InstabugSDKLogger.d("IBG-Surveys", "announcement id: " + aVar.i() + " has been added to DB");
                openDatabase.endTransaction();
                openDatabase.close();
            } catch (Exception | OutOfMemoryError e11) {
                try {
                    IBGDiagnostics.reportNonFatal(e11, "announcement insertion failed due to " + e11.getMessage());
                    return -1;
                } finally {
                    openDatabase.endTransaction();
                    openDatabase.close();
                }
            }
        }
        return insertWithOnConflict;
    }

    @WorkerThread
    @Nullable
    public static a b(long j11) {
        SQLiteDatabaseWrapper sQLiteDatabaseWrapper;
        Cursor cursor;
        int i11;
        String str;
        String string;
        int i12;
        String string2;
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        String[] strArr = {String.valueOf(j11)};
        Cursor query = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.query(InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String[]) null, "announcement_id=? ", strArr, (String) null, (String) null, (String) null) : SQLiteInstrumentation.query((SQLiteDatabase) openDatabase, InstabugDbContract.AnnouncementEntry.TABLE_NAME, (String[]) null, "announcement_id=? ", strArr, (String) null, (String) null, (String) null);
        if (query == null) {
            return null;
        }
        int columnIndex = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_ID);
        int columnIndex2 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_TYPE);
        int columnIndex3 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_TITLE);
        int columnIndex4 = query.getColumnIndex("conditions_operator");
        int columnIndex5 = query.getColumnIndex("answered");
        int columnIndex6 = query.getColumnIndex("dismissed_at");
        int columnIndex7 = query.getColumnIndex("shown_at");
        int columnIndex8 = query.getColumnIndex("isCancelled");
        int columnIndex9 = query.getColumnIndex("eventIndex");
        int columnIndex10 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_IS_SHOWN);
        int columnIndex11 = query.getColumnIndex("paused");
        int columnIndex12 = query.getColumnIndex("targetAudiences");
        int columnIndex13 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCEMENT);
        int columnIndex14 = query.getColumnIndex(InstabugDbContract.AnnouncementEntry.COLUMN_ASSETS_STATUS);
        int columnIndex15 = query.getColumnIndex("supportedLocales");
        int columnIndex16 = query.getColumnIndex("isLocalized");
        int columnIndex17 = query.getColumnIndex("currentLocale");
        try {
            if (!query.moveToFirst()) {
                query.close();
                query.close();
                openDatabase.close();
                return null;
            }
            int i13 = columnIndex17;
            long j12 = query.getLong(columnIndex);
            String string3 = query.getString(columnIndex3);
            int i14 = query.getInt(columnIndex2);
            String string4 = query.getString(columnIndex4);
            int i15 = query.getInt(columnIndex5);
            int i16 = query.getInt(columnIndex6);
            int i17 = query.getInt(columnIndex7);
            int i18 = query.getInt(columnIndex8);
            int i19 = query.getInt(columnIndex9);
            int i21 = query.getInt(columnIndex10);
            int i22 = query.getInt(columnIndex11);
            String string5 = query.getString(columnIndex12);
            String string6 = query.getString(columnIndex13);
            sQLiteDatabaseWrapper = openDatabase;
            try {
                i11 = query.getInt(columnIndex14);
                str = string5;
                string = query.getString(columnIndex15);
                i12 = query.getInt(columnIndex16);
                string2 = query.getString(i13);
                cursor = query;
            } catch (Exception | OutOfMemoryError e11) {
                e = e11;
                cursor = query;
                try {
                    IBGDiagnostics.reportNonFatal(e, "announcement conversion failed due to " + e.getMessage());
                    cursor.close();
                    sQLiteDatabaseWrapper.close();
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    cursor.close();
                    sQLiteDatabaseWrapper.close();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor = query;
                cursor.close();
                sQLiteDatabaseWrapper.close();
                throw th;
            }
            try {
                a aVar = new a();
                aVar.b(j12);
                aVar.d(i14);
                aVar.b(string3);
                aVar.a(string4);
                aVar.b(i15 == 1);
                aVar.a((long) i16);
                aVar.c((long) i17);
                aVar.c(i18 == 1);
                aVar.b(i19);
                aVar.a(i21 == 1);
                aVar.d(i22 == 1);
                aVar.a(c.a(new JSONArray(string6)));
                aVar.a(i11);
                aVar.j().a(new JSONArray(string));
                aVar.j().a(string2);
                b j13 = aVar.j();
                boolean z11 = true;
                if (i12 != 1) {
                    z11 = false;
                }
                j13.a(z11);
                g gVar = new g();
                gVar.fromJson(str);
                aVar.a(gVar);
                cursor.close();
                sQLiteDatabaseWrapper.close();
                return aVar;
            } catch (Exception | OutOfMemoryError e12) {
                e = e12;
                IBGDiagnostics.reportNonFatal(e, "announcement conversion failed due to " + e.getMessage());
                cursor.close();
                sQLiteDatabaseWrapper.close();
                return null;
            }
        } catch (Exception | OutOfMemoryError e13) {
            e = e13;
            cursor = query;
            sQLiteDatabaseWrapper = openDatabase;
            IBGDiagnostics.reportNonFatal(e, "announcement conversion failed due to " + e.getMessage());
            cursor.close();
            sQLiteDatabaseWrapper.close();
            return null;
        } catch (Throwable th4) {
            th = th4;
            cursor = query;
            sQLiteDatabaseWrapper = openDatabase;
            cursor.close();
            sQLiteDatabaseWrapper.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0244  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x024e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List b() {
        /*
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r9 = r0.openDatabase()
            r10 = 0
            java.lang.String r2 = "announcement_table"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            boolean r0 = r9 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            if (r0 != 0) goto L_0x0021
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r9
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            goto L_0x002f
        L_0x0021:
            r0 = r9
            android.database.sqlite.SQLiteDatabase r0 = (android.database.sqlite.SQLiteDatabase) r0     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            android.database.Cursor r0 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
        L_0x002f:
            r10 = r0
            if (r10 != 0) goto L_0x0040
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r0.<init>()     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            if (r10 == 0) goto L_0x003c
            r10.close()
        L_0x003c:
            r9.close()
            return r0
        L_0x0040:
            java.lang.String r0 = "announcement_id"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r1 = "announcement_type"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r2 = "announcement_title"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r3 = "conditions_operator"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r4 = "answered"
            int r4 = r10.getColumnIndex(r4)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r5 = "dismissed_at"
            int r5 = r10.getColumnIndex(r5)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r6 = "shown_at"
            int r6 = r10.getColumnIndex(r6)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r7 = "isCancelled"
            int r7 = r10.getColumnIndex(r7)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r8 = "eventIndex"
            int r8 = r10.getColumnIndex(r8)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r11 = "isAlreadyShown"
            int r11 = r10.getColumnIndex(r11)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r12 = "paused"
            int r12 = r10.getColumnIndex(r12)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r13 = "targetAudiences"
            int r13 = r10.getColumnIndex(r13)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r14 = "announcement"
            int r14 = r10.getColumnIndex(r14)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.lang.String r15 = "announceAssetsStatus"
            int r15 = r10.getColumnIndex(r15)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r16 = r15
            java.lang.String r15 = "supportedLocales"
            int r15 = r10.getColumnIndex(r15)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r17 = r15
            java.lang.String r15 = "isLocalized"
            int r15 = r10.getColumnIndex(r15)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r18 = r15
            java.lang.String r15 = "currentLocale"
            int r15 = r10.getColumnIndex(r15)     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            boolean r19 = r10.moveToFirst()     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            if (r19 != 0) goto L_0x00c4
            r10.close()     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r0.<init>()     // Catch:{ Exception -> 0x0223, OutOfMemoryError -> 0x021f, all -> 0x021b }
            r10.close()
            r9.close()
            return r0
        L_0x00c4:
            r19 = r9
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r9.<init>()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r20 = r14
            r21 = r15
        L_0x00cf:
            long r14 = r10.getLong(r0)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r22 = r0
            java.lang.String r0 = r10.getString(r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r23 = r2
            int r2 = r10.getInt(r1)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r24 = r1
            java.lang.String r1 = r10.getString(r3)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r25 = r3
            int r3 = r10.getInt(r4)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r26 = r4
            int r4 = r10.getInt(r5)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r27 = r5
            int r5 = r10.getInt(r6)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r28 = r6
            int r6 = r10.getInt(r7)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r29 = r7
            int r7 = r10.getInt(r8)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r30 = r8
            int r8 = r10.getInt(r11)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r31 = r11
            int r11 = r10.getInt(r12)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r32 = r12
            java.lang.String r12 = r10.getString(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r33 = r13
            r13 = r20
            r20 = r9
            java.lang.String r9 = r10.getString(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r34 = r13
            r13 = r16
            r16 = r12
            int r12 = r10.getInt(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r35 = r13
            r13 = r17
            r17 = r12
            java.lang.String r12 = r10.getString(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r36 = r13
            r13 = r18
            r18 = r12
            int r12 = r10.getInt(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r37 = r13
            r13 = r21
            r21 = r12
            java.lang.String r12 = r10.getString(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r38 = r13
            com.instabug.survey.announcements.models.a r13 = new com.instabug.survey.announcements.models.a     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.<init>()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.b((long) r14)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.d((int) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.b((java.lang.String) r0)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.a((java.lang.String) r1)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r0 = 0
            r1 = 1
            if (r3 != r1) goto L_0x0160
            r2 = r1
            goto L_0x0161
        L_0x0160:
            r2 = r0
        L_0x0161:
            r13.b((boolean) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            long r2 = (long) r4     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.a((long) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            long r2 = (long) r5     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.c((long) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            if (r6 != r1) goto L_0x0170
            r2 = r1
            goto L_0x0171
        L_0x0170:
            r2 = r0
        L_0x0171:
            r13.c((boolean) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.b((int) r7)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            if (r8 != r1) goto L_0x017b
            r2 = r1
            goto L_0x017c
        L_0x017b:
            r2 = r0
        L_0x017c:
            r13.a((boolean) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            if (r11 != r1) goto L_0x0183
            r2 = r1
            goto L_0x0184
        L_0x0183:
            r2 = r0
        L_0x0184:
            r13.d((boolean) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r2.<init>((java.lang.String) r9)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            java.util.ArrayList r2 = com.instabug.survey.announcements.models.c.a((org.json.JSONArray) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.a((java.util.ArrayList) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r2 = r17
            r13.a((int) r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            com.instabug.survey.common.models.b r2 = r13.j()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r4 = r18
            r3.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r2.a((org.json.JSONArray) r3)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            com.instabug.survey.common.models.b r2 = r13.j()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r2.a((java.lang.String) r12)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            com.instabug.survey.common.models.b r2 = r13.j()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r3 = r21
            if (r3 != r1) goto L_0x01b6
            r0 = r1
        L_0x01b6:
            r2.a((boolean) r0)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            com.instabug.survey.common.models.g r0 = new com.instabug.survey.common.models.g     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r0.<init>()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r1 = r16
            r0.fromJson(r1)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r13.a((com.instabug.survey.common.models.g) r0)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r0 = r20
            r0.add(r13)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            boolean r1 = r10.moveToNext()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            if (r1 != 0) goto L_0x01f2
            java.lang.String r1 = "IBG-Surveys"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r2.<init>()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            int r3 = r0.size()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r2.append(r3)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            java.lang.String r3 = " announcements have been retrieved from DB"
            r2.append(r3)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            com.instabug.library.util.InstabugSDKLogger.d(r1, r2)     // Catch:{ Exception -> 0x0219, OutOfMemoryError -> 0x0217 }
            r10.close()
            r19.close()
            return r0
        L_0x01f2:
            r9 = r0
            r0 = r22
            r2 = r23
            r1 = r24
            r3 = r25
            r4 = r26
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r11 = r31
            r12 = r32
            r13 = r33
            r20 = r34
            r16 = r35
            r17 = r36
            r18 = r37
            r21 = r38
            goto L_0x00cf
        L_0x0217:
            r0 = move-exception
            goto L_0x0225
        L_0x0219:
            r0 = move-exception
            goto L_0x0225
        L_0x021b:
            r0 = move-exception
            r19 = r9
            goto L_0x024c
        L_0x021f:
            r0 = move-exception
        L_0x0220:
            r19 = r9
            goto L_0x0225
        L_0x0223:
            r0 = move-exception
            goto L_0x0220
        L_0x0225:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x024b }
            r1.<init>()     // Catch:{ all -> 0x024b }
            java.lang.String r2 = " Retrieving announcements failed: "
            r1.append(r2)     // Catch:{ all -> 0x024b }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x024b }
            r1.append(r2)     // Catch:{ all -> 0x024b }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x024b }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r1)     // Catch:{ all -> 0x024b }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x024b }
            r0.<init>()     // Catch:{ all -> 0x024b }
            if (r10 == 0) goto L_0x0247
            r10.close()
        L_0x0247:
            r19.close()
            return r0
        L_0x024b:
            r0 = move-exception
        L_0x024c:
            if (r10 == 0) goto L_0x0251
            r10.close()
        L_0x0251:
            r19.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.announcements.cache.f.b():java.util.List");
    }

    @VisibleForTesting
    @WorkerThread
    private static void b(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, a aVar) {
        ContentValues contentValues = new ContentValues();
        if (!(aVar == null || aVar.j() == null || aVar.j().a() == null)) {
            contentValues.put("currentLocale", aVar.j().a());
        }
        if (!(aVar == null || aVar.j() == null || aVar.c() == null)) {
            JSONArray c11 = c.c(aVar.c());
            contentValues.put(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCEMENT, !(c11 instanceof JSONArray) ? c11.toString() : JSONArrayInstrumentation.toString(c11));
        }
        if (aVar != null) {
            a(sQLiteDatabaseWrapper, aVar.i(), contentValues);
        }
    }

    @WorkerThread
    public static synchronized void b(List list) {
        synchronized (f.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    c(openDatabase, (a) it.next());
                }
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
    }

    @WorkerThread
    private static synchronized long c(@NonNull SQLiteDatabaseWrapper sQLiteDatabaseWrapper, a aVar) {
        long update;
        synchronized (f.class) {
            String[] strArr = {String.valueOf(aVar.i())};
            try {
                ContentValues a11 = a(aVar);
                update = (long) (!(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.update(InstabugDbContract.AnnouncementEntry.TABLE_NAME, a11, "announcement_id=? ", strArr) : SQLiteInstrumentation.update((SQLiteDatabase) sQLiteDatabaseWrapper, InstabugDbContract.AnnouncementEntry.TABLE_NAME, a11, "announcement_id=? ", strArr));
                InstabugSDKLogger.d("IBG-Surveys", "announcement id: " + aVar.i() + " has been updated");
            } catch (Exception | OutOfMemoryError e11) {
                IBGDiagnostics.reportNonFatal(e11, "announcement updating failed due to " + e11.getMessage());
                return -1;
            }
        }
        return update;
    }

    @WorkerThread
    public static synchronized long c(a aVar) {
        long c11;
        synchronized (f.class) {
            SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
            try {
                openDatabase.beginTransaction();
                c11 = c(openDatabase, aVar);
                openDatabase.setTransactionSuccessful();
            } finally {
                openDatabase.endTransaction();
                openDatabase.close();
            }
        }
        return c11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List c() {
        /*
            r1 = 0
            com.instabug.library.internal.storage.cache.db.DatabaseManager r0 = com.instabug.library.internal.storage.cache.db.DatabaseManager.getInstance()     // Catch:{ Exception -> 0x0230, OutOfMemoryError -> 0x022c, all -> 0x0228 }
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r10 = r0.openDatabase()     // Catch:{ Exception -> 0x0230, OutOfMemoryError -> 0x022c, all -> 0x0228 }
            java.lang.String r3 = "announcement_table"
            r4 = 0
            java.lang.String r5 = "surveyState=? "
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            com.instabug.survey.common.models.f r2 = com.instabug.survey.common.models.f.READY_TO_SEND     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r11 = 0
            r6[r11] = r2     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r7 = 0
            r8 = 0
            r9 = 0
            boolean r2 = r10 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            if (r2 != 0) goto L_0x002c
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r10
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            goto L_0x0033
        L_0x002c:
            r2 = r10
            android.database.sqlite.SQLiteDatabase r2 = (android.database.sqlite.SQLiteDatabase) r2     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            android.database.Cursor r1 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
        L_0x0033:
            if (r1 != 0) goto L_0x0043
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r0.<init>()     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            if (r1 == 0) goto L_0x003f
            r1.close()
        L_0x003f:
            r10.close()
            return r0
        L_0x0043:
            java.lang.String r2 = "announcement_id"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r3 = "announcement_type"
            int r3 = r1.getColumnIndex(r3)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r4 = "announcement_title"
            int r4 = r1.getColumnIndex(r4)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r5 = "conditions_operator"
            int r5 = r1.getColumnIndex(r5)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r6 = "answered"
            int r6 = r1.getColumnIndex(r6)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r7 = "dismissed_at"
            int r7 = r1.getColumnIndex(r7)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r8 = "shown_at"
            int r8 = r1.getColumnIndex(r8)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r9 = "isCancelled"
            int r9 = r1.getColumnIndex(r9)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r12 = "eventIndex"
            int r12 = r1.getColumnIndex(r12)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r13 = "isAlreadyShown"
            int r13 = r1.getColumnIndex(r13)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r14 = "paused"
            int r14 = r1.getColumnIndex(r14)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r15 = "targetAudiences"
            int r15 = r1.getColumnIndex(r15)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r11 = "announcement"
            int r11 = r1.getColumnIndex(r11)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.lang.String r0 = "announceAssetsStatus"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r16 = r0
            java.lang.String r0 = "supportedLocales"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r17 = r0
            java.lang.String r0 = "isLocalized"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r18 = r0
            java.lang.String r0 = "currentLocale"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            boolean r19 = r1.moveToFirst()     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            if (r19 != 0) goto L_0x00c7
            r1.close()     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r0.<init>()     // Catch:{ Exception -> 0x0226, OutOfMemoryError -> 0x0222, all -> 0x021e }
            r1.close()
            r10.close()
            return r0
        L_0x00c7:
            r19 = r10
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r10.<init>()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r21 = r10
            r20 = r11
        L_0x00d2:
            long r10 = r1.getLong(r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r22 = r2
            java.lang.String r2 = r1.getString(r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r23 = r4
            int r4 = r1.getInt(r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r24 = r3
            java.lang.String r3 = r1.getString(r5)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r25 = r5
            int r5 = r1.getInt(r6)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r26 = r6
            int r6 = r1.getInt(r7)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r27 = r7
            int r7 = r1.getInt(r8)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r28 = r8
            int r8 = r1.getInt(r9)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r29 = r9
            int r9 = r1.getInt(r12)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r30 = r12
            int r12 = r1.getInt(r13)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r31 = r13
            int r13 = r1.getInt(r14)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r32 = r14
            java.lang.String r14 = r1.getString(r15)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r33 = r15
            r15 = r20
            r20 = r14
            java.lang.String r14 = r1.getString(r15)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r34 = r15
            r15 = r16
            r16 = r14
            int r14 = r1.getInt(r15)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r35 = r15
            r15 = r17
            r17 = r14
            java.lang.String r14 = r1.getString(r15)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r36 = r15
            r15 = r18
            r18 = r14
            int r14 = r1.getInt(r15)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r37 = r15
            java.lang.String r15 = r1.getString(r0)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r38 = r0
            com.instabug.survey.announcements.models.a r0 = new com.instabug.survey.announcements.models.a     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.<init>()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.b((long) r10)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.d((int) r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.b((java.lang.String) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.a((java.lang.String) r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2 = 1
            if (r5 != r2) goto L_0x015e
            r2 = 1
            goto L_0x015f
        L_0x015e:
            r2 = 0
        L_0x015f:
            r0.b((boolean) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            long r2 = (long) r6     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.a((long) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            long r2 = (long) r7     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.c((long) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2 = 1
            if (r8 != r2) goto L_0x016f
            r3 = r2
            goto L_0x0170
        L_0x016f:
            r3 = 0
        L_0x0170:
            r0.c((boolean) r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.b((int) r9)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            if (r12 != r2) goto L_0x017a
            r3 = r2
            goto L_0x017b
        L_0x017a:
            r3 = 0
        L_0x017b:
            r0.a((boolean) r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            if (r13 != r2) goto L_0x0182
            r2 = 1
            goto L_0x0183
        L_0x0182:
            r2 = 0
        L_0x0183:
            r0.d((boolean) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r3 = r16
            r2.<init>((java.lang.String) r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            java.util.ArrayList r2 = com.instabug.survey.announcements.models.c.a((org.json.JSONArray) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.a((java.util.ArrayList) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2 = r17
            r0.a((int) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            com.instabug.survey.common.models.b r2 = r0.j()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r4 = r18
            r3.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2.a((org.json.JSONArray) r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            com.instabug.survey.common.models.b r2 = r0.j()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2.a((java.lang.String) r15)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            com.instabug.survey.common.models.b r2 = r0.j()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r3 = 1
            if (r14 != r3) goto L_0x01b7
            r4 = r3
            goto L_0x01b8
        L_0x01b7:
            r4 = 0
        L_0x01b8:
            r2.a((boolean) r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            com.instabug.survey.common.models.g r2 = new com.instabug.survey.common.models.g     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2.<init>()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r4 = r20
            r2.fromJson(r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r0.a((com.instabug.survey.common.models.g) r2)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r2 = r21
            r2.add(r0)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            boolean r0 = r1.moveToNext()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            if (r0 != 0) goto L_0x01f4
            java.lang.String r0 = "IBG-Surveys"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r3.<init>()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            int r4 = r2.size()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r3.append(r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            java.lang.String r4 = " announcements have been retrieved from DB"
            r3.append(r4)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            com.instabug.library.util.InstabugSDKLogger.d(r0, r3)     // Catch:{ Exception -> 0x021c, OutOfMemoryError -> 0x021a }
            r1.close()
            r19.close()
            return r2
        L_0x01f4:
            r21 = r2
            r2 = r22
            r4 = r23
            r3 = r24
            r5 = r25
            r6 = r26
            r7 = r27
            r8 = r28
            r9 = r29
            r12 = r30
            r13 = r31
            r14 = r32
            r15 = r33
            r20 = r34
            r16 = r35
            r17 = r36
            r18 = r37
            r0 = r38
            goto L_0x00d2
        L_0x021a:
            r0 = move-exception
            goto L_0x0232
        L_0x021c:
            r0 = move-exception
            goto L_0x0232
        L_0x021e:
            r0 = move-exception
            r19 = r10
            goto L_0x025b
        L_0x0222:
            r0 = move-exception
        L_0x0223:
            r19 = r10
            goto L_0x0232
        L_0x0226:
            r0 = move-exception
            goto L_0x0223
        L_0x0228:
            r0 = move-exception
            r19 = r1
            goto L_0x025b
        L_0x022c:
            r0 = move-exception
        L_0x022d:
            r19 = r1
            goto L_0x0232
        L_0x0230:
            r0 = move-exception
            goto L_0x022d
        L_0x0232:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x025a }
            r2.<init>()     // Catch:{ all -> 0x025a }
            java.lang.String r3 = "announcement conversion failed due to "
            r2.append(r3)     // Catch:{ all -> 0x025a }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x025a }
            r2.append(r3)     // Catch:{ all -> 0x025a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x025a }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r0, r2)     // Catch:{ all -> 0x025a }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x025a }
            r0.<init>()     // Catch:{ all -> 0x025a }
            if (r1 == 0) goto L_0x0254
            r1.close()
        L_0x0254:
            if (r19 == 0) goto L_0x0259
            r19.close()
        L_0x0259:
            return r0
        L_0x025a:
            r0 = move-exception
        L_0x025b:
            if (r1 == 0) goto L_0x0260
            r1.close()
        L_0x0260:
            if (r19 == 0) goto L_0x0265
            r19.close()
        L_0x0265:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.announcements.cache.f.c():java.util.List");
    }
}
