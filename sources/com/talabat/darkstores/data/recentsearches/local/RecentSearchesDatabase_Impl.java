package com.talabat.darkstores.data.recentsearches.local;

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
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Instrumented
public final class RecentSearchesDatabase_Impl extends RecentSearchesDatabase {
    private volatile RecentSearchesDao _recentSearchesDao;

    public void clearAllTables() {
        boolean inTransaction;
        boolean z11;
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `SearchQueryRecord`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `SearchQueryRecord`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "SearchQueryRecord");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.f37419name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `SearchQueryRecord` (`query` TEXT NOT NULL, `vendor_id` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `SearchQueryRecord` (`query` TEXT NOT NULL, `vendor_id` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, RoomMasterTable.CREATE_QUERY);
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b8a89b4df0b5fec8f46c04d69d0c6566')");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b8a89b4df0b5fec8f46c04d69d0c6566')");
                }
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `SearchQueryRecord`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `SearchQueryRecord`");
                }
                if (RecentSearchesDatabase_Impl.this.mCallbacks != null) {
                    int size = RecentSearchesDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) RecentSearchesDatabase_Impl.this.mCallbacks.get(i11)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (RecentSearchesDatabase_Impl.this.mCallbacks != null) {
                    int size = RecentSearchesDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) RecentSearchesDatabase_Impl.this.mCallbacks.get(i11)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = RecentSearchesDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                RecentSearchesDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (RecentSearchesDatabase_Impl.this.mCallbacks != null) {
                    int size = RecentSearchesDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) RecentSearchesDatabase_Impl.this.mCallbacks.get(i11)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("query", new TableInfo.Column("query", "TEXT", true, 0, (String) null, 1));
                hashMap.put("vendor_id", new TableInfo.Column("vendor_id", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("id", new TableInfo.Column("id", "INTEGER", true, 1, (String) null, 1));
                TableInfo tableInfo = new TableInfo("SearchQueryRecord", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "SearchQueryRecord");
                if (tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "SearchQueryRecord(com.talabat.darkstores.data.recentsearches.local.SearchQueryRecord).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "b8a89b4df0b5fec8f46c04d69d0c6566", "f1a7dded13234cfb9be30e67d7dbc3d8")).build());
    }

    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(RecentSearchesDao.class, RecentSearchesDao_Impl.getRequiredConverters());
        return hashMap;
    }

    public RecentSearchesDao recentSearchesDao() {
        RecentSearchesDao recentSearchesDao;
        if (this._recentSearchesDao != null) {
            return this._recentSearchesDao;
        }
        synchronized (this) {
            if (this._recentSearchesDao == null) {
                this._recentSearchesDao = new RecentSearchesDao_Impl(this);
            }
            recentSearchesDao = this._recentSearchesDao;
        }
        return recentSearchesDao;
    }
}
