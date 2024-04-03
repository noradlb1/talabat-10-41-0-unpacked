package com.huawei.hms.analytics.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.analytics.bj;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

@Instrumented
public class LogConfigDao extends AbstractDao<LogConfig, Long> {
    public static final String TABLENAME = "ha_lgcf";

    public static class Properties {
        public static final Property ghi = new Property(5, String.class, "logTags", false, "lg_tag");
        public static final Property hij = new Property(4, String.class, "logStreamId", false, "lg_sid");
        public static final Property ijk = new Property(3, String.class, "logGroupId", false, "lg_gid");
        public static final Property ikl = new Property(2, String.class, "projectId", false, "lg_pid");
        public static final Property klm = new Property(1, String.class, "region", false, "_eg");
        public static final Property lmn = new Property(0, Long.class, "id", true, InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
    }

    public LogConfigDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public LogConfigDao(DaoConfig daoConfig, bj bjVar) {
        super(daoConfig, bjVar);
    }

    public static void createTable(Database database, boolean z11) {
        String str = "CREATE TABLE " + (z11 ? "IF NOT EXISTS " : "") + "\"ha_lgcf\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"_eg\" TEXT,\"lg_pid\" TEXT,\"lg_gid\" TEXT,\"lg_sid\" TEXT,\"lg_tag\" TEXT);";
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str);
        }
    }

    public static void dropTable(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"ha_lgcf\"");
        String sb3 = sb2.toString();
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(sb3);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, sb3);
        }
    }

    public final void bindValues(SQLiteStatement sQLiteStatement, LogConfig logConfig) {
        sQLiteStatement.clearBindings();
        Long id2 = logConfig.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String region = logConfig.getRegion();
        if (region != null) {
            sQLiteStatement.bindString(2, region);
        }
        String projectId = logConfig.getProjectId();
        if (projectId != null) {
            sQLiteStatement.bindString(3, projectId);
        }
        String logGroupId = logConfig.getLogGroupId();
        if (logGroupId != null) {
            sQLiteStatement.bindString(4, logGroupId);
        }
        String logStreamId = logConfig.getLogStreamId();
        if (logStreamId != null) {
            sQLiteStatement.bindString(5, logStreamId);
        }
        String logTags = logConfig.getLogTags();
        if (logTags != null) {
            sQLiteStatement.bindString(6, logTags);
        }
    }

    public final void bindValues(DatabaseStatement databaseStatement, LogConfig logConfig) {
        databaseStatement.clearBindings();
        Long id2 = logConfig.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String region = logConfig.getRegion();
        if (region != null) {
            databaseStatement.bindString(2, region);
        }
        String projectId = logConfig.getProjectId();
        if (projectId != null) {
            databaseStatement.bindString(3, projectId);
        }
        String logGroupId = logConfig.getLogGroupId();
        if (logGroupId != null) {
            databaseStatement.bindString(4, logGroupId);
        }
        String logStreamId = logConfig.getLogStreamId();
        if (logStreamId != null) {
            databaseStatement.bindString(5, logStreamId);
        }
        String logTags = logConfig.getLogTags();
        if (logTags != null) {
            databaseStatement.bindString(6, logTags);
        }
    }

    public Long getKey(LogConfig logConfig) {
        if (logConfig != null) {
            return logConfig.getId();
        }
        return null;
    }

    public boolean hasKey(LogConfig logConfig) {
        return logConfig.getId() != null;
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    public LogConfig readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        Long valueOf = cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12));
        int i13 = i11 + 1;
        String string = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i11 + 2;
        String string2 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i11 + 3;
        String string3 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i11 + 4;
        int i17 = i11 + 5;
        return new LogConfig(valueOf, string, string2, string3, cursor.isNull(i16) ? null : cursor.getString(i16), cursor.isNull(i17) ? null : cursor.getString(i17));
    }

    public void readEntity(Cursor cursor, LogConfig logConfig, int i11) {
        int i12 = i11 + 0;
        String str = null;
        logConfig.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        logConfig.setRegion(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        logConfig.setProjectId(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        logConfig.setLogGroupId(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 4;
        logConfig.setLogStreamId(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 5;
        if (!cursor.isNull(i17)) {
            str = cursor.getString(i17);
        }
        logConfig.setLogStreamId(str);
    }

    public Long readKey(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        if (cursor.isNull(i12)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i12));
    }

    public final Long updateKeyAfterInsert(LogConfig logConfig, long j11) {
        logConfig.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}
