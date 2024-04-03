package com.huawei.hms.analytics.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.huawei.hms.analytics.bk;
import com.huawei.hms.analytics.core.log.HiLog;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoMaster;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;
import org.greenrobot.greendao.database.StandardDatabase;
import org.greenrobot.greendao.identityscope.IdentityScopeType;

public class DaoManager extends AbstractDaoMaster {
    public static final int SCHEMA_VERSION = 2;

    public static abstract class klm extends DatabaseOpenHelper {
        public klm(Context context, String str) {
            super(context, str, 2);
        }

        public klm(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory) {
            super(context, str, cursorFactory, 2);
        }

        public void onCreate(Database database) {
            HiLog.i("greenDAO", "Creating tables for schema version 2");
            DaoManager.createAllTables(database, false);
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
            Class[] clsArr = {EventDao.class};
            bk.klm(database, clsArr);
            DaoManager.createEventTable(database, false);
            bk.lmn(database, (Class<? extends AbstractDao<?, ?>>[]) clsArr);
        }
    }

    public DaoManager(SQLiteDatabase sQLiteDatabase) {
        this((Database) new StandardDatabase(sQLiteDatabase));
    }

    public DaoManager(Database database) {
        super(database, 2);
        registerDaoClass(APIEventDao.class);
        registerDaoClass(EventDao.class);
    }

    public static void createAPIEventTable(Database database, boolean z11) {
        APIEventDao.createTable(database, z11);
    }

    public static void createAllTables(Database database, boolean z11) {
        APIEventDao.createTable(database, z11);
        EventDao.createTable(database, z11);
    }

    public static void createEventTable(Database database, boolean z11) {
        EventDao.createTable(database, z11);
    }

    public static void dropAllTables(Database database, boolean z11) {
        APIEventDao.dropTable(database, z11);
        EventDao.dropTable(database, z11);
    }

    public static DaoSession newDevSession(Context context, String str) {
        return new DaoManager(new lmn(context, str).getWritableDb()).newSession();
    }

    public DaoSession newSession() {
        return new DaoSession(this.f27859db, IdentityScopeType.Session, this.daoConfigMap);
    }

    public DaoSession newSession(IdentityScopeType identityScopeType) {
        return new DaoSession(this.f27859db, identityScopeType, this.daoConfigMap);
    }
}
