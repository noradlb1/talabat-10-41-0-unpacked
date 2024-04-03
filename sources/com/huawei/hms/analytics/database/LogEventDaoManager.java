package com.huawei.hms.analytics.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.analytics.bj;
import com.huawei.hms.analytics.core.log.HiLog;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class LogEventDaoManager extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 1;

    public static abstract class klm extends DatabaseOpenHelper {
        public klm(Context context, String str) {
            super(context, str, 1);
        }

        public klm(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 1);
        }

        public void onCreate(Database database) {
            HiLog.i("greenDAO", "Creating tables for schema version 1");
            LogEventDaoManager.createAllTables(database, false);
        }
    }

    public static class lmn extends klm {
        public lmn(Context context, String str) {
            super(context, str);
        }

        public lmn(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory);
        }

        public final void onUpgrade(Database database, int i11, int i12) {
            HiLog.i("greenDAO", "Upgrading schema from version " + i11 + " to " + i12 + " by dropping all tables");
        }
    }

    public LogEventDaoManager(SQLiteDatabase sQLiteDatabase) {
        this((Database) new StandardDatabase(sQLiteDatabase));
    }

    public LogEventDaoManager(Database database) {
        super(database, 1);
        registerDaoClass(LogEventDao.class);
        registerDaoClass(LogConfigDao.class);
    }

    public static void createAllTables(Database database, boolean z11) {
        LogEventDao.createTable(database, z11);
        LogConfigDao.createTable(database, z11);
    }

    public static bj newDevSession(Context context, String str) {
        return new LogEventDaoManager(new lmn(context, str).getWritableDb()).newSession();
    }

    public bj newSession() {
        return new bj(this.f27859db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public bj newSession(IdentityScopeType identityScopeType) {
        return new bj(this.f27859db, identityScopeType, this.daoConfigMap);
    }
}
