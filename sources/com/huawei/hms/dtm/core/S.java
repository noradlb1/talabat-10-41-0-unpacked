package com.huawei.hms.dtm.core;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.k;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Instrumented
public class S extends L {
    private static ContentValues a(Q q11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("create_time", Long.valueOf(q11.b()));
        contentValues.put("url", q11.h());
        contentValues.put("first_send_time", Long.valueOf(q11.c()));
        contentValues.put("method", q11.f());
        contentValues.put("unique_id", q11.g());
        contentValues.put(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS, q11.d());
        contentValues.put("body", q11.a());
        return contentValues;
    }

    public static List<Q> a(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            Logger.warn("DTM-Report", "invalid params");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            String[] strArr = {String.valueOf(i11)};
            Locale locale = Locale.ENGLISH;
            Object[] objArr = new Object[1];
            objArr[0] = "id";
            String format = String.format(locale, "%s ASC", objArr);
            String valueOf = String.valueOf(i12);
            cursor = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.query("dtm_report", (String[]) null, "id >?", strArr, (String) null, (String) null, format, valueOf) : SQLiteInstrumentation.query(sQLiteDatabase, "dtm_report", (String[]) null, "id >?", strArr, (String) null, (String) null, format, valueOf);
            if (cursor == null) {
                k.a(cursor);
                return arrayList;
            }
            a(cursor, (List<Q>) arrayList);
            k.a(cursor);
            return arrayList;
        } catch (SQLException unused) {
            Logger.warn("DTM-Report", "query report start#SQLException");
        } catch (Throwable th2) {
            k.a(cursor);
            throw th2;
        }
    }

    private static void a(Cursor cursor, List<Q> list) {
        if (cursor.moveToFirst()) {
            do {
                int i11 = cursor.getInt(cursor.getColumnIndex("id"));
                long j11 = cursor.getLong(cursor.getColumnIndex("create_time"));
                String string = cursor.getString(cursor.getColumnIndex("url"));
                long j12 = cursor.getLong(cursor.getColumnIndex("first_send_time"));
                String string2 = cursor.getString(cursor.getColumnIndex("method"));
                String string3 = cursor.getString(cursor.getColumnIndex("unique_id"));
                String string4 = cursor.getString(cursor.getColumnIndex(InstabugDbContract.NetworkLogEntry.COLUMN_HEADERS));
                String string5 = cursor.getString(cursor.getColumnIndex("body"));
                Q q11 = new Q();
                q11.a(i11);
                q11.a(j11);
                q11.e(string);
                q11.b(j12);
                q11.c(string2);
                q11.d(string3);
                q11.b(string4);
                q11.a(string5);
                list.add(q11);
            } while (cursor.moveToNext());
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, int i11) {
        String[] strArr = {String.valueOf(i11)};
        try {
            int delete = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete("dtm_report", "id=?", strArr) : SQLiteInstrumentation.delete(sQLiteDatabase, "dtm_report", "id=?", strArr);
            if (delete > 0) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete report#");
            sb2.append(delete);
            Logger.warn("DTM-Report", sb2.toString());
            return false;
        } catch (SQLException unused) {
            Logger.warn("DTM-Report", "delete report#SQLException");
            return false;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, long j11) {
        String[] strArr = {String.valueOf(j11)};
        try {
            int delete = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete("dtm_report", "create_time<?", strArr) : SQLiteInstrumentation.delete(sQLiteDatabase, "dtm_report", "create_time<?", strArr);
            if (delete > 0) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete report before#");
            sb2.append(delete);
            Logger.debug("DTM-Report", sb2.toString());
            return false;
        } catch (SQLException unused) {
            Logger.warn("DTM-Report", "delete report before#SQLException");
            return false;
        }
    }

    public static boolean a(SQLiteDatabase sQLiteDatabase, Q q11) {
        if (q11 == null) {
            return false;
        }
        ContentValues a11 = a(q11);
        try {
            long insertOrThrow = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.insertOrThrow("dtm_report", (String) null, a11) : SQLiteInstrumentation.insertOrThrow(sQLiteDatabase, "dtm_report", (String) null, a11);
            if (insertOrThrow > 0) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("insert report#");
            sb2.append(insertOrThrow);
            Logger.warn("DTM-Report", sb2.toString());
            return false;
        } catch (SQLException unused) {
            Logger.error("DTM-Report", "insert report#SQLException");
            return false;
        }
    }

    public static List<Q> b(SQLiteDatabase sQLiteDatabase, int i11) {
        Cursor query;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        if (i11 <= 0) {
            try {
                String format = String.format(Locale.ENGLISH, "%s ASC", new Object[]{"id"});
                query = !(sQLiteDatabase2 instanceof SQLiteDatabase) ? sQLiteDatabase.query("dtm_report", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, format) : SQLiteInstrumentation.query(sQLiteDatabase, "dtm_report", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, format);
            } catch (SQLException unused) {
                Logger.warn("DTM-Report", "query report#SQLException");
            } catch (Throwable th2) {
                k.a(cursor);
                throw th2;
            }
        } else {
            String format2 = String.format(Locale.ENGLISH, "%s ASC", new Object[]{"id"});
            String valueOf = String.valueOf(i11);
            query = !(sQLiteDatabase2 instanceof SQLiteDatabase) ? sQLiteDatabase.query("dtm_report", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, format2, valueOf) : SQLiteInstrumentation.query(sQLiteDatabase, "dtm_report", (String[]) null, (String) null, (String[]) null, (String) null, (String) null, format2, valueOf);
        }
        cursor = query;
        if (cursor == null) {
            k.a(cursor);
            return arrayList;
        }
        a(cursor, (List<Q>) arrayList);
        k.a(cursor);
        return arrayList;
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase, long j11) {
        if (j11 <= 0) {
            Logger.warn("DTM-Report", "should be > 0");
            return true;
        }
        try {
            Logger.info("DTM-Report", "try to delete event");
            String[] strArr = {String.valueOf(j11)};
            int delete = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.delete("dtm_report", "id IN (SELECT id FROM dtm_report ORDER BY id LIMIT ? )", strArr) : SQLiteInstrumentation.delete(sQLiteDatabase, "dtm_report", "id IN (SELECT id FROM dtm_report ORDER BY id LIMIT ? )", strArr);
            if (delete > 0) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("delete report over#");
            sb2.append(delete);
            Logger.warn("DTM-Report", sb2.toString());
            return false;
        } catch (SQLException unused) {
            Logger.warn("DTM-Report", "delete report over#SQLException");
            return false;
        }
    }

    public static boolean b(SQLiteDatabase sQLiteDatabase, Q q11) {
        if (q11 == null) {
            return false;
        }
        ContentValues a11 = a(q11);
        String[] strArr = {String.valueOf(q11.e())};
        try {
            if ((!(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.update("dtm_report", a11, "id =? ", strArr) : SQLiteInstrumentation.update(sQLiteDatabase, "dtm_report", a11, "id =? ", strArr)) > 0) {
                return true;
            }
            Logger.warn("DTM-Report", "update report < 0");
            return false;
        } catch (SQLException unused) {
            Logger.warn("DTM-Report", "update report#SQLException");
            return false;
        }
    }

    public static long c(SQLiteDatabase sQLiteDatabase) {
        Cursor cursor = null;
        try {
            cursor = !(sQLiteDatabase instanceof SQLiteDatabase) ? sQLiteDatabase.rawQuery("SELECT COUNT(*) FROM dtm_report", (String[]) null) : SQLiteInstrumentation.rawQuery(sQLiteDatabase, "SELECT COUNT(*) FROM dtm_report", (String[]) null);
            if (cursor.moveToFirst()) {
                long j11 = cursor.getLong(0);
                k.a(cursor);
                return j11;
            }
        } catch (SQLException unused) {
            Logger.warn("DTM-Report", "query report start#SQLException");
        } catch (Throwable th2) {
            k.a((Closeable) null);
            throw th2;
        }
        k.a(cursor);
        return 0;
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TRIGGER IF NOT EXISTS dtm_record_event AFTER DELETE ON dtm_report FOR EACH ROW WHEN OLD.unique_id NOTNULL BEGIN INSERT OR IGNORE INTO dtm_record(unique_id) VALUES (OLD.unique_id); END");
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TRIGGER IF NOT EXISTS dtm_unique_event BEFORE INSERT ON dtm_report FOR EACH ROW WHEN NEW.unique_id NOTNULL BEGIN SELECT RAISE(ABORT, 'Dtm Unique ID.') WHERE EXISTS (SELECT 1 FROM dtm_record WHERE unique_id = NEW.unique_id); END;");
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        d(sQLiteDatabase);
        e(sQLiteDatabase);
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "create table if not exists dtm_report(id integer PRIMARY KEY AUTOINCREMENT NOT NULL,create_time long default 0,url text not null,first_send_time long default 0,method text not null,unique_id text UNIQUE ON CONFLICT ABORT,headers text,body text )");
    }
}
