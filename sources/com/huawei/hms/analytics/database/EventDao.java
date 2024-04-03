package com.huawei.hms.analytics.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.huawei.hms.analytics.core.storage.Event;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

@Instrumented
public class EventDao extends AbstractDao<Event, Long> {
    public static final String TABLENAME = "EVENT";

    public static class Properties {
        public static final Property cde = new Property(9, String.class, "pid", false, "PID");
        public static final Property def = new Property(8, String.class, "associationId", false, "ID");
        public static final Property efg = new Property(7, String.class, "sessionname", false, "SESSIONNAME");
        public static final Property fgh = new Property(6, String.class, "sessionid", false, "SESSIONID");
        public static final Property ghi = new Property(5, String.class, "servicetag", false, "SERVICETAG");
        public static final Property hij = new Property(4, String.class, "evttime", false, "EVTTIME");
        public static final Property ijk = new Property(3, String.class, "content", false, "CONTENT");
        public static final Property ikl = new Property(2, String.class, "evttype", false, "EVTTYPE");
        public static final Property klm = new Property(1, String.class, "evtid", false, "EVTID");
        public static final Property lmn = new Property(0, Long.class, "id", true, InstabugDbContract.FeatureRequestEntry.COLUMN_ID);
    }

    public EventDao(DaoConfig daoConfig) {
        super(daoConfig);
    }

    public EventDao(DaoConfig daoConfig, DaoSession daoSession) {
        super(daoConfig, daoSession);
    }

    public static void createTable(Database database, boolean z11) {
        String str = "CREATE TABLE " + (z11 ? "IF NOT EXISTS " : "") + "\"EVENT\" (\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ,\"EVTID\" TEXT,\"EVTTYPE\" TEXT,\"CONTENT\" TEXT,\"EVTTIME\" TEXT,\"SERVICETAG\" TEXT,\"SESSIONID\" TEXT,\"SESSIONNAME\" TEXT,\"ID\" TEXT,\"PID\" TEXT)";
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, str);
        }
    }

    public static void dropTable(Database database, boolean z11) {
        StringBuilder sb2 = new StringBuilder("DROP TABLE ");
        sb2.append(z11 ? "IF EXISTS " : "");
        sb2.append("\"EVENT\"");
        String sb3 = sb2.toString();
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL(sb3);
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, sb3);
        }
    }

    public final void bindValues(SQLiteStatement sQLiteStatement, Event event) {
        sQLiteStatement.clearBindings();
        Long id2 = event.getId();
        if (id2 != null) {
            sQLiteStatement.bindLong(1, id2.longValue());
        }
        String evtId = event.getEvtId();
        if (evtId != null) {
            sQLiteStatement.bindString(2, evtId);
        }
        String evtType = event.getEvtType();
        if (evtType != null) {
            sQLiteStatement.bindString(3, evtType);
        }
        String content = event.getContent();
        if (content != null) {
            sQLiteStatement.bindString(4, content);
        }
        String evtTime = event.getEvtTime();
        if (evtTime != null) {
            sQLiteStatement.bindString(5, evtTime);
        }
        String serviceTag = event.getServiceTag();
        if (serviceTag != null) {
            sQLiteStatement.bindString(6, serviceTag);
        }
        String sessionid = event.getSessionid();
        if (sessionid != null) {
            sQLiteStatement.bindString(7, sessionid);
        }
        String sessionName = event.getSessionName();
        if (sessionName != null) {
            sQLiteStatement.bindString(8, sessionName);
        }
        String associationid = event.getAssociationid();
        if (associationid != null) {
            sQLiteStatement.bindString(9, associationid);
        }
        String pid = event.getPid();
        if (pid != null) {
            sQLiteStatement.bindString(10, pid);
        }
    }

    public final void bindValues(DatabaseStatement databaseStatement, Event event) {
        databaseStatement.clearBindings();
        Long id2 = event.getId();
        if (id2 != null) {
            databaseStatement.bindLong(1, id2.longValue());
        }
        String evtId = event.getEvtId();
        if (evtId != null) {
            databaseStatement.bindString(2, evtId);
        }
        String evtType = event.getEvtType();
        if (evtType != null) {
            databaseStatement.bindString(3, evtType);
        }
        String content = event.getContent();
        if (content != null) {
            databaseStatement.bindString(4, content);
        }
        String evtTime = event.getEvtTime();
        if (evtTime != null) {
            databaseStatement.bindString(5, evtTime);
        }
        String serviceTag = event.getServiceTag();
        if (serviceTag != null) {
            databaseStatement.bindString(6, serviceTag);
        }
        String sessionid = event.getSessionid();
        if (sessionid != null) {
            databaseStatement.bindString(7, sessionid);
        }
        String sessionName = event.getSessionName();
        if (sessionName != null) {
            databaseStatement.bindString(8, sessionName);
        }
        String associationid = event.getAssociationid();
        if (associationid != null) {
            databaseStatement.bindString(9, associationid);
        }
        String pid = event.getPid();
        if (pid != null) {
            databaseStatement.bindString(10, pid);
        }
    }

    public Long getKey(Event event) {
        if (event != null) {
            return event.getId();
        }
        return null;
    }

    public boolean hasKey(Event event) {
        return event.getId() != null;
    }

    public final boolean isEntityUpdateable() {
        return true;
    }

    public Event readEntity(Cursor cursor, int i11) {
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
        return new Event(valueOf, string, string2, string3, string4, string5, string6, string7, cursor.isNull(i21) ? null : cursor.getString(i21), cursor.isNull(i22) ? null : cursor.getString(i22));
    }

    public void readEntity(Cursor cursor, Event event, int i11) {
        int i12 = i11 + 0;
        String str = null;
        event.setId(cursor.isNull(i12) ? null : Long.valueOf(cursor.getLong(i12)));
        int i13 = i11 + 1;
        event.setEvtId(cursor.isNull(i13) ? null : cursor.getString(i13));
        int i14 = i11 + 2;
        event.setEvtType(cursor.isNull(i14) ? null : cursor.getString(i14));
        int i15 = i11 + 3;
        event.setContent(cursor.isNull(i15) ? null : cursor.getString(i15));
        int i16 = i11 + 4;
        event.setEvtTime(cursor.isNull(i16) ? null : cursor.getString(i16));
        int i17 = i11 + 5;
        event.setServiceTag(cursor.isNull(i17) ? null : cursor.getString(i17));
        int i18 = i11 + 6;
        event.setSessionid(cursor.isNull(i18) ? null : cursor.getString(i18));
        int i19 = i11 + 7;
        event.setSessionName(cursor.isNull(i19) ? null : cursor.getString(i19));
        int i21 = i11 + 8;
        event.setAssociationid(cursor.isNull(i21) ? null : cursor.getString(i21));
        int i22 = i11 + 9;
        if (!cursor.isNull(i22)) {
            str = cursor.getString(i22);
        }
        event.setPid(str);
    }

    public Long readKey(Cursor cursor, int i11) {
        int i12 = i11 + 0;
        if (cursor.isNull(i12)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i12));
    }

    public final Long updateKeyAfterInsert(Event event, long j11) {
        event.setId(Long.valueOf(j11));
        return Long.valueOf(j11);
    }
}
