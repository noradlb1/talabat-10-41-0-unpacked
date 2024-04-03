package com.deliveryhero.perseus.data.local.db;

import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.deliveryhero.perseus.data.local.db.dao.CachedHitEventsDao;
import com.deliveryhero.perseus.data.local.db.dao.CachedHitEventsDao_Impl;
import com.deliveryhero.perseus.data.local.db.entity.HitEvent;
import com.deliveryhero.perseus.data.local.db.entity.HitEventValues;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.visa.checkout.Profile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Instrumented
public final class TrackingDatabase_Impl extends TrackingDatabase {
    private volatile CachedHitEventsDao _cachedHitEventsDao;

    public CachedHitEventsDao cachedHitEventsDao() {
        CachedHitEventsDao cachedHitEventsDao;
        if (this._cachedHitEventsDao != null) {
            return this._cachedHitEventsDao;
        }
        synchronized (this) {
            if (this._cachedHitEventsDao == null) {
                this._cachedHitEventsDao = new CachedHitEventsDao_Impl(this);
            }
            cachedHitEventsDao = this._cachedHitEventsDao;
        }
        return cachedHitEventsDao;
    }

    public void clearAllTables() {
        boolean inTransaction;
        boolean z11;
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `tracking_perseus_events`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `tracking_perseus_events`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `HitEventValues`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `HitEventValues`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), HitEvent.TABLE_NAME, HitEventValues.TABLE_NAME);
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.f37419name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(5) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `tracking_perseus_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `payloadTimeStamp` TEXT NOT NULL, `country` TEXT NOT NULL, `advertisingId` TEXT NOT NULL, `appId` TEXT NOT NULL, `appName` TEXT NOT NULL, `appVersionCode` TEXT NOT NULL, `adjustId` TEXT NOT NULL, `userId` TEXT NOT NULL, `uaId` TEXT NOT NULL, `clientId` TEXT NOT NULL, `sessionId` TEXT NOT NULL, `sdkVersionName` TEXT NOT NULL, `globalEntityId` TEXT, `consent` TEXT, `sessionOffset` INTEGER NOT NULL, `eventVariables` TEXT NOT NULL)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `tracking_perseus_events` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `payloadTimeStamp` TEXT NOT NULL, `country` TEXT NOT NULL, `advertisingId` TEXT NOT NULL, `appId` TEXT NOT NULL, `appName` TEXT NOT NULL, `appVersionCode` TEXT NOT NULL, `adjustId` TEXT NOT NULL, `userId` TEXT NOT NULL, `uaId` TEXT NOT NULL, `clientId` TEXT NOT NULL, `sessionId` TEXT NOT NULL, `sdkVersionName` TEXT NOT NULL, `globalEntityId` TEXT, `consent` TEXT, `sessionOffset` INTEGER NOT NULL, `eventVariables` TEXT NOT NULL)");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `HitEventValues` (`timestampId` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `HitEventValues` (`timestampId` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `key` TEXT NOT NULL, `value` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, RoomMasterTable.CREATE_QUERY);
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '758a7ad79beb3aa2b49da038718c1ada')");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '758a7ad79beb3aa2b49da038718c1ada')");
                }
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `tracking_perseus_events`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `tracking_perseus_events`");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `HitEventValues`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `HitEventValues`");
                }
                if (TrackingDatabase_Impl.this.mCallbacks != null) {
                    int size = TrackingDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) TrackingDatabase_Impl.this.mCallbacks.get(i11)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (TrackingDatabase_Impl.this.mCallbacks != null) {
                    int size = TrackingDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) TrackingDatabase_Impl.this.mCallbacks.get(i11)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = TrackingDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                TrackingDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (TrackingDatabase_Impl.this.mCallbacks != null) {
                    int size = TrackingDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) TrackingDatabase_Impl.this.mCallbacks.get(i11)).onOpen(supportSQLiteDatabase);
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
                HashMap hashMap = new HashMap(18);
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("payloadTimeStamp", new TableInfo.Column("payloadTimeStamp", "TEXT", true, 0, (String) null, 1));
                hashMap.put("country", new TableInfo.Column("country", "TEXT", true, 0, (String) null, 1));
                hashMap.put(ConstantsKt.GOOGLE_AD_ID, new TableInfo.Column(ConstantsKt.GOOGLE_AD_ID, "TEXT", true, 0, (String) null, 1));
                hashMap.put("appId", new TableInfo.Column("appId", "TEXT", true, 0, (String) null, 1));
                hashMap.put(AnalyticsAttribute.APP_NAME_ATTRIBUTE, new TableInfo.Column(AnalyticsAttribute.APP_NAME_ATTRIBUTE, "TEXT", true, 0, (String) null, 1));
                hashMap.put("appVersionCode", new TableInfo.Column("appVersionCode", "TEXT", true, 0, (String) null, 1));
                hashMap.put("adjustId", new TableInfo.Column("adjustId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("uaId", new TableInfo.Column("uaId", "TEXT", true, 0, (String) null, 1));
                hashMap.put(Profile.CLIENT_ID, new TableInfo.Column(Profile.CLIENT_ID, "TEXT", true, 0, (String) null, 1));
                hashMap.put("sessionId", new TableInfo.Column("sessionId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("sdkVersionName", new TableInfo.Column("sdkVersionName", "TEXT", true, 0, (String) null, 1));
                hashMap.put(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, new TableInfo.Column(FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID, "TEXT", false, 0, (String) null, 1));
                hashMap.put("consent", new TableInfo.Column("consent", "TEXT", false, 0, (String) null, 1));
                hashMap.put("sessionOffset", new TableInfo.Column("sessionOffset", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("eventVariables", new TableInfo.Column("eventVariables", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo(HitEvent.TABLE_NAME, hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, HitEvent.TABLE_NAME);
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "tracking_perseus_events(com.deliveryhero.perseus.data.local.db.entity.HitEvent).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put("timestampId", new TableInfo.Column("timestampId", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("key", new TableInfo.Column("key", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("value", new TableInfo.Column("value", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo(HitEventValues.TABLE_NAME, hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, HitEventValues.TABLE_NAME);
                if (tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "HitEventValues(com.deliveryhero.perseus.data.local.db.entity.HitEventValues).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
        }, "758a7ad79beb3aa2b49da038718c1ada", "8bd31fecc28e51e25119c9342c6c3a1c")).build());
    }

    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(CachedHitEventsDao.class, CachedHitEventsDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
