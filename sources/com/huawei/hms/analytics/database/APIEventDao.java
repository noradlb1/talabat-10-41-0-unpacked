package com.huawei.hms.analytics.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.talabat.wallet.features.UrlConstantsKt;
import com.tekartik.sqflite.Constant;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

@Instrumented
public class APIEventDao extends AbstractDao<APIEvent, Long> {
    public static final String TABLENAME = "APIEVENT";

    public static class Properties {
        public static final Property cde = new Property(9, String.class, WiseOpenHianalyticsData.UNION_COSTTIME, false, "COST_TIME");
        public static final Property def = new Property(8, String.class, "eventCnt", false, "EVENT_CNT");
        public static final Property efg = new Property(7, String.class, UrlConstantsKt.WALLET_EVENT_ID, false, "EVENT_ID");
        public static final Property fgh = new Property(6, String.class, "errorCode", false, "ERROR_CODE");
        public static final Property ghi = new Property(5, String.class, "result", false, "RESULT");
        public static final Property hij = new Property(4, String.class, "name", false, "NAME");
        public static final Property ijk = new Property(3, String.class, "type", false, "TYPE");
        public static final Property ikl = new Property(2, String.class, "timestamp", false, "TIMESTAMP");
        public static final Property klm = new Property(1, String.class, Constant.PARAM_ERROR_CODE, false, "CODE");
        public static final Property lmn = new Property(0, Long.class, "id", true, InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
    }

    public APIEventDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public APIEventDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z11) {
        String str = "CREATE TABLE " + (z11 ? "IF NOT EXISTS " : "") + "\"APIEVENT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"CODE\" TEXT,\"TIMESTAMP\" TEXT,\"TYPE\" TEXT,\"NAME\" TEXT,\"RESULT\" TEXT,\"ERROR_CODE\" TEXT,\"EVENT_ID\" TEXT,\"EVENT_CNT\" TEXT,\"COST_TIME\" TEXT);";
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str);
        }
    }

    public static void dropTable(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"APIEVENT\"");
        String sb3 = sb2.toString();
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(sb3);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, sb3);
        }
    }

    public final void bindValues(SQLiteStatement sQLiteStatement, APIEvent aPIEvent) {
        sQLiteStatement.clearBindings();
        Long id2 = aPIEvent.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String code = aPIEvent.getCode();
        if (code != null) {
            sQLiteStatement.bindString(2, code);
        }
        String timestamp = aPIEvent.getTimestamp();
        if (timestamp != null) {
            sQLiteStatement.bindString(3, timestamp);
        }
        String type = aPIEvent.getType();
        if (type != null) {
            sQLiteStatement.bindString(4, type);
        }
        String name2 = aPIEvent.getName();
        if (name2 != null) {
            sQLiteStatement.bindString(5, name2);
        }
        String result = aPIEvent.getResult();
        if (result != null) {
            sQLiteStatement.bindString(6, result);
        }
        String errorCode = aPIEvent.getErrorCode();
        if (errorCode != null) {
            sQLiteStatement.bindString(7, errorCode);
        }
        String eventId = aPIEvent.getEventId();
        if (eventId != null) {
            sQLiteStatement.bindString(8, eventId);
        }
        String eventCnt = aPIEvent.getEventCnt();
        if (eventCnt != null) {
            sQLiteStatement.bindString(9, eventCnt);
        }
        String costTime = aPIEvent.getCostTime();
        if (costTime != null) {
            sQLiteStatement.bindString(10, costTime);
        }
    }

    public final void bindValues(DatabaseStatement databaseStatement, APIEvent aPIEvent) {
        databaseStatement.clearBindings();
        Long id2 = aPIEvent.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String code = aPIEvent.getCode();
        if (code != null) {
            databaseStatement.bindString(2, code);
        }
        String timestamp = aPIEvent.getTimestamp();
        if (timestamp != null) {
            databaseStatement.bindString(3, timestamp);
        }
        String type = aPIEvent.getType();
        if (type != null) {
            databaseStatement.bindString(4, type);
        }
        String name2 = aPIEvent.getName();
        if (name2 != null) {
            databaseStatement.bindString(5, name2);
        }
        String result = aPIEvent.getResult();
        if (result != null) {
            databaseStatement.bindString(6, result);
        }
        String errorCode = aPIEvent.getErrorCode();
        if (errorCode != null) {
            databaseStatement.bindString(7, errorCode);
        }
        String eventId = aPIEvent.getEventId();
        if (eventId != null) {
            databaseStatement.bindString(8, eventId);
        }
        String eventCnt = aPIEvent.getEventCnt();
        if (eventCnt != null) {
            databaseStatement.bindString(9, eventCnt);
        }
        String costTime = aPIEvent.getCostTime();
        if (costTime != null) {
            databaseStatement.bindString(10, costTime);
        }
    }

    public Long getKey(APIEvent aPIEvent) {
        if (aPIEvent != null) {
            return aPIEvent.getId();
        }
        return null;
    }

    public boolean hasKey(APIEvent aPIEvent) {
        return aPIEvent.getId() != null;
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    public APIEvent readEntity(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        Long valueOf = cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12));
        int i13 = i11 + 1;
        String string = cursor.isNull(i13) ? null : cursor.getString(i13);
        int i14 = i11 + 2;
        String string2 = cursor.isNull(i14) ? null : cursor.getString(i14);
        int i15 = i11 + 3;
        String string3 = cursor.isNull(i15) ? null : cursor.getString(i15);
        int i16 = i11 + 4;
        String string4 = cursor.isNull(i16) ? null : cursor.getString(i16);
        int i17 = i11 + 5;
        String string5 = cursor.isNull(i17) ? null : cursor.getString(i17);
        int i18 = i11 + 6;
        String string6 = cursor.isNull(i18) ? null : cursor.getString(i18);
        int i19 = i11 + 7;
        String string7 = cursor.isNull(i19) ? null : cursor.getString(i19);
        int i21 = i11 + 8;
        int i22 = i11 + 9;
        return new APIEvent(valueOf, string, string2, string3, string4, string5, string6, string7, cursor.isNull(i21) ? null : cursor.getString(i21), cursor.isNull(i22) ? null : cursor.getString(i22));
    }

    public void readEntity(Cursor cursor, APIEvent aPIEvent, int i11) {
        int i12 = i11 + 0;
        String str = null;
        aPIEvent.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        aPIEvent.setCode(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        aPIEvent.setTimestamp(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        aPIEvent.setType(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 4;
        aPIEvent.setName(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 5;
        aPIEvent.setResult(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i11 + 6;
        aPIEvent.setErrorCode(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i11 + 7;
        aPIEvent.setEventId(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i21 = i11 + 8;
        aPIEvent.setEventCnt(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i11 + 9;
        if (!cursor.isNull(i22)) {
            str = cursor.getString(i22);
        }
        aPIEvent.setCostTime(str);
    }

    public Long readKey(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        if (cursor.isNull(i12)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i12));
    }

    public final Long updateKeyAfterInsert(APIEvent aPIEvent, long j11) {
        aPIEvent.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}
