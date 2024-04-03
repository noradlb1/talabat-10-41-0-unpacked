package com.adyen.checkout.core.internal.persistence;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@Instrumented
public class PaymentDatabase_Impl extends PaymentDatabase {
    private volatile PaymentInitiationResponseDao _paymentInitiationResponseDao;
    private volatile PaymentSessionDao _paymentSessionDao;

    public void clearAllTables() {
        boolean inTransaction;
        boolean z11;
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "PRAGMA defer_foreign_keys = TRUE");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `payment_sessions`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `payment_sessions`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `payment_initiation_responses`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `payment_initiation_responses`");
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
        return new InvalidationTracker(this, "payment_sessions", "payment_initiation_responses");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.f37419name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(1) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `payment_sessions` (`uuid` TEXT NOT NULL, `payment_session_json` TEXT NOT NULL, `generation_timestamp` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `payment_sessions` (`uuid` TEXT NOT NULL, `payment_session_json` TEXT NOT NULL, `generation_timestamp` INTEGER NOT NULL, PRIMARY KEY(`uuid`))");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `payment_initiation_responses` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payment_session_uuid` TEXT NOT NULL, `payment_method_json` TEXT NOT NULL, `payment_initiation_response_json` TEXT NOT NULL, `handled` INTEGER NOT NULL, FOREIGN KEY(`payment_session_uuid`) REFERENCES `payment_sessions`(`uuid`) ON UPDATE CASCADE ON DELETE CASCADE )");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `payment_initiation_responses` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `payment_session_uuid` TEXT NOT NULL, `payment_method_json` TEXT NOT NULL, `payment_initiation_response_json` TEXT NOT NULL, `handled` INTEGER NOT NULL, FOREIGN KEY(`payment_session_uuid`) REFERENCES `payment_sessions`(`uuid`) ON UPDATE CASCADE ON DELETE CASCADE )");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE  INDEX `index_payment_initiation_responses_payment_session_uuid` ON `payment_initiation_responses` (`payment_session_uuid`)");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE  INDEX `index_payment_initiation_responses_payment_session_uuid` ON `payment_initiation_responses` (`payment_session_uuid`)");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, RoomMasterTable.CREATE_QUERY);
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b14d9e2e362fefef0ac6f3c63633cffa\")");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"b14d9e2e362fefef0ac6f3c63633cffa\")");
                }
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `payment_sessions`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `payment_sessions`");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `payment_initiation_responses`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `payment_initiation_responses`");
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (PaymentDatabase_Impl.this.mCallbacks != null) {
                    int size = PaymentDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) PaymentDatabase_Impl.this.mCallbacks.get(i11)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = PaymentDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
                    supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "PRAGMA foreign_keys = ON");
                }
                PaymentDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (PaymentDatabase_Impl.this.mCallbacks != null) {
                    int size = PaymentDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) PaymentDatabase_Impl.this.mCallbacks.get(i11)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(3);
                hashMap.put("uuid", new TableInfo.Column("uuid", "TEXT", true, 1));
                hashMap.put("payment_session_json", new TableInfo.Column("payment_session_json", "TEXT", true, 0));
                hashMap.put("generation_timestamp", new TableInfo.Column("generation_timestamp", "INTEGER", true, 0));
                TableInfo tableInfo = new TableInfo("payment_sessions", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "payment_sessions");
                if (tableInfo.equals(read)) {
                    HashMap hashMap2 = new HashMap(5);
                    hashMap2.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                    hashMap2.put("payment_session_uuid", new TableInfo.Column("payment_session_uuid", "TEXT", true, 0));
                    hashMap2.put("payment_method_json", new TableInfo.Column("payment_method_json", "TEXT", true, 0));
                    hashMap2.put("payment_initiation_response_json", new TableInfo.Column("payment_initiation_response_json", "TEXT", true, 0));
                    hashMap2.put(InstabugDbContract.CrashEntry.COLUMN_HANDLED, new TableInfo.Column(InstabugDbContract.CrashEntry.COLUMN_HANDLED, "INTEGER", true, 0));
                    HashSet hashSet = new HashSet(1);
                    hashSet.add(new TableInfo.ForeignKey("payment_sessions", "CASCADE", "CASCADE", Arrays.asList(new String[]{"payment_session_uuid"}), Arrays.asList(new String[]{"uuid"})));
                    HashSet hashSet2 = new HashSet(1);
                    hashSet2.add(new TableInfo.Index("index_payment_initiation_responses_payment_session_uuid", false, Arrays.asList(new String[]{"payment_session_uuid"})));
                    TableInfo tableInfo2 = new TableInfo("payment_initiation_responses", hashMap2, hashSet, hashSet2);
                    TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "payment_initiation_responses");
                    if (!tableInfo2.equals(read2)) {
                        throw new IllegalStateException("Migration didn't properly handle payment_initiation_responses(com.adyen.checkout.core.internal.persistence.PaymentInitiationResponseEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                    }
                    return;
                }
                throw new IllegalStateException("Migration didn't properly handle payment_sessions(com.adyen.checkout.core.internal.persistence.PaymentSessionEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "b14d9e2e362fefef0ac6f3c63633cffa", "83c6e5d7a02d2ffea95e1021b5c96b3a")).build());
    }

    public PaymentInitiationResponseDao getPaymentInitiationResponseDao() {
        PaymentInitiationResponseDao paymentInitiationResponseDao;
        if (this._paymentInitiationResponseDao != null) {
            return this._paymentInitiationResponseDao;
        }
        synchronized (this) {
            if (this._paymentInitiationResponseDao == null) {
                this._paymentInitiationResponseDao = new PaymentInitiationResponseDao_Impl(this);
            }
            paymentInitiationResponseDao = this._paymentInitiationResponseDao;
        }
        return paymentInitiationResponseDao;
    }

    public PaymentSessionDao getPaymentSessionDao() {
        PaymentSessionDao paymentSessionDao;
        if (this._paymentSessionDao != null) {
            return this._paymentSessionDao;
        }
        synchronized (this) {
            if (this._paymentSessionDao == null) {
                this._paymentSessionDao = new PaymentSessionDao_Impl(this);
            }
            paymentSessionDao = this._paymentSessionDao;
        }
        return paymentSessionDao;
    }
}
