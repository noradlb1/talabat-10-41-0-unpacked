package fwfd.com.fwfsdk.util;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.model.dao.FWFDBDAO;
import fwfd.com.fwfsdk.model.dao.FWFDBDAO_Impl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Instrumented
public final class FWFDBRoom_Impl extends FWFDBRoom {
    private volatile FWFDBDAO _fWFDBDAO;

    public void clearAllTables() {
        boolean inTransaction;
        boolean z11;
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `FWFFlagKey`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `FWFFlagKey`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `FWFSDKInfo`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `FWFSDKInfo`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `FWFFeature`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `FWFFeature`");
            }
            super.setTransactionSuccessful();
            if (inTransaction) {
                return;
            }
            if (z11) {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "VACUUM");
            }
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                if (!(writableDatabase instanceof SQLiteDatabase)) {
                    writableDatabase.execSQL("VACUUM");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "VACUUM");
                }
            }
        }
    }

    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "FWFFlagKey", "FWFSDKInfo", "FWFFeature");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.f37419name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(12) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FWFFlagKey` (`key` TEXT NOT NULL, `token` TEXT NOT NULL, `kind` TEXT, `enabled` INTEGER, `date` INTEGER, PRIMARY KEY(`key`, `token`))");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `FWFFlagKey` (`key` TEXT NOT NULL, `token` TEXT NOT NULL, `kind` TEXT, `enabled` INTEGER, `date` INTEGER, PRIMARY KEY(`key`, `token`))");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FWFSDKInfo` (`sdkVersion` TEXT NOT NULL, `versionNumber` INTEGER, PRIMARY KEY(`sdkVersion`))");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `FWFSDKInfo` (`sdkVersion` TEXT NOT NULL, `versionNumber` INTEGER, PRIMARY KEY(`sdkVersion`))");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `FWFFeature` (`key` TEXT NOT NULL, `variation` BLOB, `abTest` INTEGER NOT NULL, `accessToken` TEXT NOT NULL, `date` INTEGER NOT NULL, `relevantContext` TEXT, `subscribe` INTEGER NOT NULL, `holdoutsEvaluations` TEXT, `kind` TEXT, `from` TEXT, `ruleIndex` TEXT, `evaluatedAttributes` TEXT, `evaluatedFlags` TEXT, `error` TEXT, `variationName` BLOB, `flagType` TEXT, `flagEnabled` INTEGER, `trackerServices` TEXT, PRIMARY KEY(`key`, `accessToken`))");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `FWFFeature` (`key` TEXT NOT NULL, `variation` BLOB, `abTest` INTEGER NOT NULL, `accessToken` TEXT NOT NULL, `date` INTEGER NOT NULL, `relevantContext` TEXT, `subscribe` INTEGER NOT NULL, `holdoutsEvaluations` TEXT, `kind` TEXT, `from` TEXT, `ruleIndex` TEXT, `evaluatedAttributes` TEXT, `evaluatedFlags` TEXT, `error` TEXT, `variationName` BLOB, `flagType` TEXT, `flagEnabled` INTEGER, `trackerServices` TEXT, PRIMARY KEY(`key`, `accessToken`))");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, RoomMasterTable.CREATE_QUERY);
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '94743e275c3fcfce8bc483b591df18c0')");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '94743e275c3fcfce8bc483b591df18c0')");
                }
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FWFFlagKey`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `FWFFlagKey`");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FWFSDKInfo`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `FWFSDKInfo`");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `FWFFeature`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `FWFFeature`");
                }
                if (FWFDBRoom_Impl.this.mCallbacks != null) {
                    int size = FWFDBRoom_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) FWFDBRoom_Impl.this.mCallbacks.get(i11)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (FWFDBRoom_Impl.this.mCallbacks != null) {
                    int size = FWFDBRoom_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) FWFDBRoom_Impl.this.mCallbacks.get(i11)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = FWFDBRoom_Impl.this.mDatabase = supportSQLiteDatabase;
                FWFDBRoom_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (FWFDBRoom_Impl.this.mCallbacks != null) {
                    int size = FWFDBRoom_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) FWFDBRoom_Impl.this.mCallbacks.get(i11)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(5);
                hashMap.put("key", new TableInfo.Column("key", "TEXT", true, 1, (String) null, 1));
                hashMap.put(LegacyTokenLocalDataSourceImpl.KEY, new TableInfo.Column(LegacyTokenLocalDataSourceImpl.KEY, "TEXT", true, 2, (String) null, 1));
                hashMap.put(FWFConstants.EXPLANATION_TYPE_KIND, new TableInfo.Column(FWFConstants.EXPLANATION_TYPE_KIND, "TEXT", false, 0, (String) null, 1));
                hashMap.put("enabled", new TableInfo.Column("enabled", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("date", new TableInfo.Column("date", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("FWFFlagKey", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "FWFFlagKey");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "FWFFlagKey(fwfd.com.fwfsdk.model.db.FWFFlagKey).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(2);
                hashMap2.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, new TableInfo.Column(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "TEXT", true, 1, (String) null, 1));
                hashMap2.put("versionNumber", new TableInfo.Column("versionNumber", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("FWFSDKInfo", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "FWFSDKInfo");
                if (!tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(false, "FWFSDKInfo(fwfd.com.fwfsdk.model.db.FWFSDKInfo).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                HashMap hashMap3 = new HashMap(18);
                hashMap3.put("key", new TableInfo.Column("key", "TEXT", true, 1, (String) null, 1));
                hashMap3.put("variation", new TableInfo.Column("variation", "BLOB", false, 0, (String) null, 1));
                hashMap3.put("abTest", new TableInfo.Column("abTest", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("accessToken", new TableInfo.Column("accessToken", "TEXT", true, 2, (String) null, 1));
                hashMap3.put("date", new TableInfo.Column("date", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("relevantContext", new TableInfo.Column("relevantContext", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("subscribe", new TableInfo.Column("subscribe", "INTEGER", true, 0, (String) null, 1));
                hashMap3.put("holdoutsEvaluations", new TableInfo.Column("holdoutsEvaluations", "TEXT", false, 0, (String) null, 1));
                hashMap3.put(FWFConstants.EXPLANATION_TYPE_KIND, new TableInfo.Column(FWFConstants.EXPLANATION_TYPE_KIND, "TEXT", false, 0, (String) null, 1));
                hashMap3.put("from", new TableInfo.Column("from", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("ruleIndex", new TableInfo.Column("ruleIndex", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("evaluatedAttributes", new TableInfo.Column("evaluatedAttributes", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("evaluatedFlags", new TableInfo.Column("evaluatedFlags", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("error", new TableInfo.Column("error", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("variationName", new TableInfo.Column("variationName", "BLOB", false, 0, (String) null, 1));
                hashMap3.put("flagType", new TableInfo.Column("flagType", "TEXT", false, 0, (String) null, 1));
                hashMap3.put("flagEnabled", new TableInfo.Column("flagEnabled", "INTEGER", false, 0, (String) null, 1));
                hashMap3.put("trackerServices", new TableInfo.Column("trackerServices", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo3 = new TableInfo("FWFFeature", hashMap3, new HashSet(0), new HashSet(0));
                TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "FWFFeature");
                if (tableInfo3.equals(read3)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "FWFFeature(fwfd.com.fwfsdk.model.db.FWFFeature).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
            }
        }, "94743e275c3fcfce8bc483b591df18c0", "7e7b6b9433a233b86855e980acbe0689")).build());
    }

    public FWFDBDAO dao() {
        FWFDBDAO fwfdbdao;
        if (this._fWFDBDAO != null) {
            return this._fWFDBDAO;
        }
        synchronized (this) {
            if (this._fWFDBDAO == null) {
                this._fWFDBDAO = new FWFDBDAO_Impl(this);
            }
            fwfdbdao = this._fWFDBDAO;
        }
        return fwfdbdao;
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(FWFDBDAO.class, FWFDBDAO_Impl.getRequiredConverters());
        return hashMap;
    }
}
