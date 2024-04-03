package com.talabat.feature.darkstorescart.data.local;

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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Instrumented
public final class CartDatabase_Impl extends CartDatabase {
    private volatile CartDao _cartDao;

    public CartDao cartDao() {
        CartDao cartDao;
        if (this._cartDao != null) {
            return this._cartDao;
        }
        synchronized (this) {
            if (this._cartDao == null) {
                this._cartDao = new CartDao_Impl(this);
            }
            cartDao = this._cartDao;
        }
        return cartDao;
    }

    public void clearAllTables() {
        boolean inTransaction;
        boolean z11;
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `Product`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `Product`");
            }
            if (!(writableDatabase instanceof SQLiteDatabase)) {
                writableDatabase.execSQL("DELETE FROM `CartInfo`");
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) writableDatabase, "DELETE FROM `CartInfo`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Product", "CartInfo");
    }

    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.f37419name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(18) {
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Product` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `imageUrl` TEXT, `price` REAL NOT NULL, `previousPrice` REAL, `cartCount` INTEGER NOT NULL, `syncedCount` INTEGER NOT NULL, `freeCount` INTEGER, `absoluteDiscount` REAL, `vendorId` TEXT NOT NULL, `stock` INTEGER NOT NULL, `isAvailable` INTEGER NOT NULL, `imageUrls` TEXT NOT NULL, `description` TEXT, `categoryId` TEXT NOT NULL, `isFavorite` INTEGER NOT NULL, `sku` TEXT NOT NULL, `isSponsored` INTEGER NOT NULL, `campaignTrigger` TEXT, `ageLimit` INTEGER NOT NULL, `hasBeenMarkedOOS` INTEGER, `predictedToBeOOS` INTEGER, `hasPriceChanged` INTEGER, `hasQuantityChanged` INTEGER, `offerText` TEXT, `tooltipAlertText` TEXT, PRIMARY KEY(`id`))");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `Product` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, `imageUrl` TEXT, `price` REAL NOT NULL, `previousPrice` REAL, `cartCount` INTEGER NOT NULL, `syncedCount` INTEGER NOT NULL, `freeCount` INTEGER, `absoluteDiscount` REAL, `vendorId` TEXT NOT NULL, `stock` INTEGER NOT NULL, `isAvailable` INTEGER NOT NULL, `imageUrls` TEXT NOT NULL, `description` TEXT, `categoryId` TEXT NOT NULL, `isFavorite` INTEGER NOT NULL, `sku` TEXT NOT NULL, `isSponsored` INTEGER NOT NULL, `campaignTrigger` TEXT, `ageLimit` INTEGER NOT NULL, `hasBeenMarkedOOS` INTEGER, `predictedToBeOOS` INTEGER, `hasPriceChanged` INTEGER, `hasQuantityChanged` INTEGER, `offerText` TEXT, `tooltipAlertText` TEXT, PRIMARY KEY(`id`))");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `CartInfo` (`cartId` TEXT NOT NULL, `globalVendorId` TEXT NOT NULL, `vendorName` TEXT NOT NULL, `branchId` TEXT NOT NULL, `restaurantJson` TEXT NOT NULL, PRIMARY KEY(`cartId`))");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `CartInfo` (`cartId` TEXT NOT NULL, `globalVendorId` TEXT NOT NULL, `vendorName` TEXT NOT NULL, `branchId` TEXT NOT NULL, `restaurantJson` TEXT NOT NULL, PRIMARY KEY(`cartId`))");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, RoomMasterTable.CREATE_QUERY);
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ab162fb23495fa84ec3235d3072a0c9f')");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'ab162fb23495fa84ec3235d3072a0c9f')");
                }
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Product`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `Product`");
                }
                if (!z11) {
                    supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `CartInfo`");
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE IF EXISTS `CartInfo`");
                }
                if (CartDatabase_Impl.this.mCallbacks != null) {
                    int size = CartDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) CartDatabase_Impl.this.mCallbacks.get(i11)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (CartDatabase_Impl.this.mCallbacks != null) {
                    int size = CartDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) CartDatabase_Impl.this.mCallbacks.get(i11)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = CartDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                CartDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (CartDatabase_Impl.this.mCallbacks != null) {
                    int size = CartDatabase_Impl.this.mCallbacks.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        ((RoomDatabase.Callback) CartDatabase_Impl.this.mCallbacks.get(i11)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap hashMap = new HashMap(26);
                hashMap.put("id", new TableInfo.Column("id", "TEXT", true, 1, (String) null, 1));
                hashMap.put("name", new TableInfo.Column("name", "TEXT", true, 0, (String) null, 1));
                hashMap.put(ObservableAttributesNames.IMAGE_URL_V2, new TableInfo.Column(ObservableAttributesNames.IMAGE_URL_V2, "TEXT", false, 0, (String) null, 1));
                hashMap.put(FirebaseAnalytics.Param.PRICE, new TableInfo.Column(FirebaseAnalytics.Param.PRICE, "REAL", true, 0, (String) null, 1));
                hashMap.put("previousPrice", new TableInfo.Column("previousPrice", "REAL", false, 0, (String) null, 1));
                hashMap.put("cartCount", new TableInfo.Column("cartCount", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("syncedCount", new TableInfo.Column("syncedCount", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("freeCount", new TableInfo.Column("freeCount", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("absoluteDiscount", new TableInfo.Column("absoluteDiscount", "REAL", false, 0, (String) null, 1));
                hashMap.put("vendorId", new TableInfo.Column("vendorId", "TEXT", true, 0, (String) null, 1));
                hashMap.put("stock", new TableInfo.Column("stock", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("isAvailable", new TableInfo.Column("isAvailable", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("imageUrls", new TableInfo.Column("imageUrls", "TEXT", true, 0, (String) null, 1));
                hashMap.put("description", new TableInfo.Column("description", "TEXT", false, 0, (String) null, 1));
                hashMap.put("categoryId", new TableInfo.Column("categoryId", "TEXT", true, 0, (String) null, 1));
                hashMap.put(ProductTrackingProvider.FAVOURITE, new TableInfo.Column(ProductTrackingProvider.FAVOURITE, "INTEGER", true, 0, (String) null, 1));
                hashMap.put("sku", new TableInfo.Column("sku", "TEXT", true, 0, (String) null, 1));
                hashMap.put("isSponsored", new TableInfo.Column("isSponsored", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("campaignTrigger", new TableInfo.Column("campaignTrigger", "TEXT", false, 0, (String) null, 1));
                hashMap.put("ageLimit", new TableInfo.Column("ageLimit", "INTEGER", true, 0, (String) null, 1));
                hashMap.put("hasBeenMarkedOOS", new TableInfo.Column("hasBeenMarkedOOS", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("predictedToBeOOS", new TableInfo.Column("predictedToBeOOS", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("hasPriceChanged", new TableInfo.Column("hasPriceChanged", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("hasQuantityChanged", new TableInfo.Column("hasQuantityChanged", "INTEGER", false, 0, (String) null, 1));
                hashMap.put("offerText", new TableInfo.Column("offerText", "TEXT", false, 0, (String) null, 1));
                hashMap.put("tooltipAlertText", new TableInfo.Column("tooltipAlertText", "TEXT", false, 0, (String) null, 1));
                TableInfo tableInfo = new TableInfo("Product", hashMap, new HashSet(0), new HashSet(0));
                TableInfo read = TableInfo.read(supportSQLiteDatabase, "Product");
                if (!tableInfo.equals(read)) {
                    return new RoomOpenHelper.ValidationResult(false, "Product(com.talabat.feature.darkstorescart.data.model.Product).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
                }
                HashMap hashMap2 = new HashMap(5);
                hashMap2.put(FoodCartFlutterDataSourceImpl.cartIdKey, new TableInfo.Column(FoodCartFlutterDataSourceImpl.cartIdKey, "TEXT", true, 1, (String) null, 1));
                hashMap2.put("globalVendorId", new TableInfo.Column("globalVendorId", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("vendorName", new TableInfo.Column("vendorName", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("branchId", new TableInfo.Column("branchId", "TEXT", true, 0, (String) null, 1));
                hashMap2.put("restaurantJson", new TableInfo.Column("restaurantJson", "TEXT", true, 0, (String) null, 1));
                TableInfo tableInfo2 = new TableInfo("CartInfo", hashMap2, new HashSet(0), new HashSet(0));
                TableInfo read2 = TableInfo.read(supportSQLiteDatabase, "CartInfo");
                if (tableInfo2.equals(read2)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "CartInfo(com.talabat.feature.darkstorescart.data.model.CartInfo).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
            }
        }, "ab162fb23495fa84ec3235d3072a0c9f", "942ab813b91458bb0164ab38e7211df2")).build());
    }

    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(CartDao.class, CartDao_Impl.getRequiredConverters());
        return hashMap;
    }
}
