package com.huawei.hms.dtm.core;

import android.database.sqlite.SQLiteDatabase;

public class P extends L {
    public void a(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "CREATE TRIGGER IF NOT EXISTS dtm_unique_event BEFORE INSERT ON dtm_report FOR EACH ROW WHEN NEW.unique_id NOTNULL BEGIN SELECT RAISE(ABORT, 'Dtm Unique ID.')     WHERE EXISTS (SELECT 1 FROM dtm_record WHERE unique_id = NEW.unique_id); END;");
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, "create table if not exists dtm_record(unique_id text UNIQUE )");
    }
}
