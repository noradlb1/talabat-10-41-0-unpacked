package com.instabug.apm.cache.handler.applaunch;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.instabug.apm.di.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.ArrayList;
import java.util.Map;

@Instrumented
public class b implements a {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private DatabaseManager f45116a = a.v();

    /* renamed from: b  reason: collision with root package name */
    private com.instabug.apm.logger.internal.a f45117b = a.f();

    /* renamed from: c  reason: collision with root package name */
    private String[] f45118c = {"eal_mus", "eal_mus_st"};

    private ArrayList a(SQLiteDatabaseWrapper sQLiteDatabaseWrapper, @Nullable Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                com.instabug.apm.cache.model.b bVar = new com.instabug.apm.cache.model.b();
                bVar.b(cursor.getLong(cursor.getColumnIndex("app_launch_id")));
                bVar.b(cursor.getString(cursor.getColumnIndex("name")));
                bVar.a(cursor.getString(cursor.getColumnIndex("screen_name")));
                bVar.c(cursor.getLong(cursor.getColumnIndex("start_time")));
                bVar.a(cursor.getLong(cursor.getColumnIndex("duration")));
                bVar.a(a(bVar.b(), sQLiteDatabaseWrapper));
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public int a(String str, long j11) {
        if (this.f45116a == null) {
            return -1;
        }
        String str2 = "session_id = ? AND app_launch_id NOT IN (" + "SELECT app_launch_id FROM app_launch where session_id = ? ORDER BY app_launch_id DESC LIMIT ?" + ")";
        String[] strArr = {str, str, String.valueOf(j11)};
        SQLiteDatabaseWrapper openDatabase = this.f45116a.openDatabase();
        int delete = !(openDatabase instanceof SQLiteDatabase) ? openDatabase.delete(InstabugDbContract.AppLaunchEntry.TABLE_NAME, str2, strArr) : SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchEntry.TABLE_NAME, str2, strArr);
        openDatabase.close();
        return delete;
    }

    public long a(String str, com.instabug.apm.cache.model.b bVar) {
        if (this.f45116a == null || bVar == null) {
            return -1;
        }
        this.f45117b.g("inserting app launch");
        SQLiteDatabaseWrapper openDatabase = this.f45116a.openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("session_id", str);
        if (bVar.f() != null) {
            contentValues.put("name", bVar.f());
        }
        if (bVar.c() != null) {
            contentValues.put("screen_name", bVar.c());
        }
        contentValues.put("start_time", Long.valueOf(bVar.e()));
        contentValues.put("duration", Long.valueOf(bVar.a()));
        boolean z11 = openDatabase instanceof SQLiteDatabase;
        long insert = !z11 ? openDatabase.insert(InstabugDbContract.AppLaunchEntry.TABLE_NAME, (String) null, contentValues) : SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchEntry.TABLE_NAME, (String) null, contentValues);
        if (bVar.d() != null) {
            for (Map.Entry entry : bVar.d().entrySet()) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_launch_id", Long.valueOf(insert));
                contentValues2.put("attribute_key", (String) entry.getKey());
                contentValues2.put("attribute_value", (String) entry.getValue());
                if (!z11) {
                    openDatabase.insert(InstabugDbContract.AppLaunchAttributesEntry.TABLE_NAME, (String) null, contentValues2);
                } else {
                    SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchAttributesEntry.TABLE_NAME, (String) null, contentValues2);
                }
            }
        }
        openDatabase.close();
        com.instabug.apm.logger.internal.a aVar = this.f45117b;
        aVar.g("inserting app launch done with id " + insert);
        return insert;
    }

    @Nullable
    public Map a(long j11, @Nullable SQLiteDatabaseWrapper sQLiteDatabaseWrapper) {
        DatabaseManager databaseManager = this.f45116a;
        if (databaseManager == null) {
            return null;
        }
        boolean z11 = sQLiteDatabaseWrapper != null;
        if (!z11) {
            sQLiteDatabaseWrapper = databaseManager.openDatabase();
        }
        ArrayMap arrayMap = new ArrayMap();
        String str = "select * from app_launch_attributes where app_launch_id = " + j11;
        if (sQLiteDatabaseWrapper != null) {
            Cursor rawQuery = !(sQLiteDatabaseWrapper instanceof SQLiteDatabase) ? sQLiteDatabaseWrapper.rawQuery(str, (String[]) null) : SQLiteInstrumentation.rawQuery((SQLiteDatabase) sQLiteDatabaseWrapper, str, (String[]) null);
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    arrayMap.put(rawQuery.getString(rawQuery.getColumnIndex("attribute_key")), rawQuery.getString(rawQuery.getColumnIndex("attribute_value")));
                }
                rawQuery.close();
            }
        }
        if (!z11 && sQLiteDatabaseWrapper != null) {
            sQLiteDatabaseWrapper.close();
        }
        return arrayMap;
    }

    public void a() {
        DatabaseManager databaseManager = this.f45116a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            boolean z11 = openDatabase instanceof SQLiteDatabase;
            if (!z11) {
                openDatabase.execSQL("delete from app_launch_attributes");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from app_launch_attributes");
            }
            if (!z11) {
                openDatabase.execSQL("delete from app_launch");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) openDatabase, "delete from app_launch");
            }
            openDatabase.close();
        }
    }

    public void a(long j11) {
        if (this.f45116a != null) {
            String str = "app_launch_id IN (" + "SELECT app_launch_id FROM app_launch ORDER BY app_launch_id DESC LIMIT ? OFFSET ?" + ")";
            String[] strArr = {"-1", String.valueOf(j11)};
            SQLiteDatabaseWrapper openDatabase = this.f45116a.openDatabase();
            try {
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.delete(InstabugDbContract.AppLaunchEntry.TABLE_NAME, str, strArr);
                } else {
                    SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchEntry.TABLE_NAME, str, strArr);
                }
            } catch (Exception e11) {
                this.f45117b.a("Error while trimming app launches: " + e11.getMessage(), e11);
                IBGDiagnostics.reportNonFatal(e11, "Error while trimming app launches: " + e11.getMessage());
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

    public void a(com.instabug.apm.cache.model.b bVar) {
        if (this.f45116a != null && bVar != null) {
            this.f45117b.g("updating app launch");
            SQLiteDatabaseWrapper openDatabase = this.f45116a.openDatabase();
            ContentValues contentValues = new ContentValues();
            if (bVar.c() != null) {
                contentValues.put("screen_name", bVar.c());
            }
            contentValues.put("duration", Long.valueOf(bVar.a()));
            String[] strArr = {String.valueOf(bVar.b())};
            boolean z11 = openDatabase instanceof SQLiteDatabase;
            if (!z11) {
                openDatabase.update(InstabugDbContract.AppLaunchEntry.TABLE_NAME, contentValues, "app_launch_id = ?", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchEntry.TABLE_NAME, contentValues, "app_launch_id = ?", strArr);
            }
            Map d11 = bVar.d();
            if (d11 != null) {
                for (String str : this.f45118c) {
                    if (d11.containsKey(str)) {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("app_launch_id", Long.valueOf(bVar.b()));
                        contentValues2.put("attribute_key", str);
                        contentValues2.put("attribute_value", (String) d11.get(str));
                        if (!z11) {
                            openDatabase.insert(InstabugDbContract.AppLaunchAttributesEntry.TABLE_NAME, (String) null, contentValues2);
                        } else {
                            SQLiteInstrumentation.insert((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchAttributesEntry.TABLE_NAME, (String) null, contentValues2);
                        }
                    }
                }
            }
            openDatabase.close();
            this.f45117b.g("updating app launch done with id: " + bVar.b());
        }
    }

    public void a(@NonNull String str) {
        DatabaseManager databaseManager = this.f45116a;
        if (databaseManager != null) {
            SQLiteDatabaseWrapper openDatabase = databaseManager.openDatabase();
            String[] strArr = {str};
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.delete(InstabugDbContract.AppLaunchEntry.TABLE_NAME, "name = ? ", strArr);
            } else {
                SQLiteInstrumentation.delete((SQLiteDatabase) openDatabase, InstabugDbContract.AppLaunchEntry.TABLE_NAME, "name = ? ", strArr);
            }
            openDatabase.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List b(java.lang.String r13) {
        /*
            r12 = this;
            java.lang.String r0 = "Error while getting app launches for session: "
            com.instabug.library.internal.storage.cache.db.DatabaseManager r1 = r12.f45116a
            r2 = 0
            if (r1 == 0) goto L_0x0084
            com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper r1 = r1.openDatabase()
            java.lang.String r6 = "session_id = ?"
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]
            r3 = 0
            r7[r3] = r13
            java.lang.String r4 = "app_launch"
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            boolean r13 = r1 instanceof android.database.sqlite.SQLiteDatabase     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            if (r13 != 0) goto L_0x0027
            r5 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r1
            android.database.Cursor r13 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            goto L_0x002e
        L_0x0027:
            r3 = r1
            android.database.sqlite.SQLiteDatabase r3 = (android.database.sqlite.SQLiteDatabase) r3     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
            android.database.Cursor r13 = com.newrelic.agent.android.instrumentation.SQLiteInstrumentation.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0046, all -> 0x0044 }
        L_0x002e:
            java.util.ArrayList r3 = r12.a((com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper) r1, (android.database.Cursor) r13)     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            r1.close()     // Catch:{ Exception -> 0x003f, all -> 0x003b }
            if (r13 == 0) goto L_0x003a
            r13.close()
        L_0x003a:
            return r3
        L_0x003b:
            r0 = move-exception
            r2 = r13
            r13 = r0
            goto L_0x007e
        L_0x003f:
            r1 = move-exception
            r11 = r1
            r1 = r13
            r13 = r11
            goto L_0x0048
        L_0x0044:
            r13 = move-exception
            goto L_0x007e
        L_0x0046:
            r13 = move-exception
            r1 = r2
        L_0x0048:
            com.instabug.apm.logger.internal.a r3 = r12.f45117b     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r4.<init>()     // Catch:{ all -> 0x007c }
            r4.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r13.getMessage()     // Catch:{ all -> 0x007c }
            r4.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x007c }
            r3.a(r4, r13)     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r3.<init>()     // Catch:{ all -> 0x007c }
            r3.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r13.getMessage()     // Catch:{ all -> 0x007c }
            r3.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x007c }
            com.instabug.library.diagnostics.IBGDiagnostics.reportNonFatal(r13, r0)     // Catch:{ all -> 0x007c }
            if (r1 == 0) goto L_0x0084
            r1.close()
            goto L_0x0084
        L_0x007c:
            r13 = move-exception
            r2 = r1
        L_0x007e:
            if (r2 == 0) goto L_0x0083
            r2.close()
        L_0x0083:
            throw r13
        L_0x0084:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.cache.handler.applaunch.b.b(java.lang.String):java.util.List");
    }
}
