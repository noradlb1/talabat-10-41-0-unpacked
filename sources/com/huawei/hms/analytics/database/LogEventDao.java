package com.huawei.hms.analytics.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.analytics.bj;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.talabat.wallet.features.UrlConstantsKt;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

@Instrumented
public class LogEventDao extends AbstractDao<LogEvent, Long> {
    public static final String TABLENAME = "ha_lg";

    public static class Properties {
        public static final Property hij = new Property(4, String.class, UrlConstantsKt.WALLET_EVENT_ID, false, "ev_id");
        public static final Property ijk = new Property(3, String.class, "content", false, "ev_ct");
        public static final Property ikl = new Property(2, Long.class, "evtType", false, "cf_id");
        public static final Property klm = new Property(1, String.class, "evtTime", false, "ev_t");
        public static final Property lmn = new Property(0, Long.class, "id", true, InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
    }

    public LogEventDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public LogEventDao(DaoConfig daoConfig, bj bjVar) {
        super(daoConfig, bjVar);
    }

    public static void createTable(Database database, boolean z11) {
        String str = "CREATE TABLE " + (z11 ? "IF NOT EXISTS " : "") + "\"ha_lg\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"ev_t\" TEXT,\"cf_id\" INTEGER,\"ev_ct\" TEXT,\"ev_id\" TEXT);";
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str);
        }
    }

    public static void dropTable(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"ha_lg\"");
        String sb3 = sb2.toString();
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(sb3);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, sb3);
        }
    }

    public final void bindValues(SQLiteStatement sQLiteStatement, LogEvent logEvent) {
        sQLiteStatement.clearBindings();
        Long id2 = logEvent.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String evtTime = logEvent.getEvtTime();
        if (evtTime != null) {
            sQLiteStatement.bindString(2, evtTime);
        }
        Long configId = logEvent.getConfigId();
        if (configId != null) {
            sQLiteStatement.bindLong(3, configId.longValue());
        }
        String content = logEvent.getContent();
        if (content != null) {
            sQLiteStatement.bindString(4, content);
        }
        String eventId = logEvent.getEventId();
        if (eventId != null) {
            sQLiteStatement.bindString(5, eventId);
        }
    }

    public final void bindValues(DatabaseStatement databaseStatement, LogEvent logEvent) {
        databaseStatement.clearBindings();
        Long id2 = logEvent.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String evtTime = logEvent.getEvtTime();
        if (evtTime != null) {
            databaseStatement.bindString(2, evtTime);
        }
        Long configId = logEvent.getConfigId();
        if (configId != null) {
            databaseStatement.bindLong(3, configId.longValue());
        }
        String content = logEvent.getContent();
        if (content != null) {
            databaseStatement.bindString(4, content);
        }
        String eventId = logEvent.getEventId();
        if (eventId != null) {
            databaseStatement.bindString(5, eventId);
        }
    }

    public Long getKey(LogEvent logEvent) {
        if (logEvent != null) {
            return logEvent.getId();
        }
        return null;
    }

    public boolean hasKey(LogEvent logEvent) {
        return logEvent.getId() != null;
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    public LogEvent readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        Long valueOf = cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12));
        int i13 = i11 + 1;
        String string = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i11 + 2;
        Long valueOf2 = cursor.isNull(i14) ? null : Long.valueOf(cursor.getLong(i14));
        int i15 = i11 + 3;
        return new LogEvent(valueOf, string, valueOf2, cursor.isNull(i15) ? null : cursor.getString(i15), cursor.isNull(i11 + 5) ? null : cursor.getString(i11 + 4));
    }

    public void readEntity(Cursor cursor, LogEvent logEvent, int i11) {
        int i12 = i11 + 0;
        String str = null;
        logEvent.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        logEvent.setEvtTime(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        logEvent.setConfigId(cursor.isNull(i14) ? null : Long.valueOf(cursor.getLong(i14)));
        int i15 = i11 + 3;
        logEvent.setContent(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 4;
        if (!cursor.isNull(i16)) {
            str = cursor.getString(i16);
        }
        logEvent.setEventId(str);
    }

    public Long readKey(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        if (cursor.isNull(i12)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i12));
    }

    public final Long updateKeyAfterInsert(LogEvent logEvent, long j11) {
        logEvent.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}
