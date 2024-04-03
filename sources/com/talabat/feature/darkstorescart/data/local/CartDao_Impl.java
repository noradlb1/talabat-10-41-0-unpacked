package com.talabat.feature.darkstorescart.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.data.tracking.ProductTrackingProvider;
import com.talabat.feature.darkstorescart.data.local.CartDao;
import com.talabat.feature.darkstorescart.data.model.CartInfo;
import com.talabat.feature.darkstorescart.data.model.CartResponseProduct;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.observability.squads.nfv.ObservableAttributesNames;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class CartDao_Impl implements CartDao {
    /* access modifiers changed from: private */
    public final CampaignTriggerConverter __campaignTriggerConverter = new CampaignTriggerConverter();
    /* access modifiers changed from: private */
    public final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Product> __deletionAdapterOfProduct;
    private final EntityInsertionAdapter<CartInfo> __insertionAdapterOfCartInfo;
    private final EntityInsertionAdapter<Product> __insertionAdapterOfProduct;
    private final SharedSQLiteStatement __preparedStmtOfClearCartInfo;
    private final SharedSQLiteStatement __preparedStmtOfDeleteALlZeros;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteCartInfo;
    private final SharedSQLiteStatement __preparedStmtOfMarkOOS;
    private final SharedSQLiteStatement __preparedStmtOfMarkPriceChanged;
    private final SharedSQLiteStatement __preparedStmtOfRollbackCartCountsToSynced;
    private final SharedSQLiteStatement __preparedStmtOfUpdateFreeProductCount;
    private final SharedSQLiteStatement __preparedStmtOfUpdatePrice;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductAbsoluteDiscount;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductCategory;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductCount;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductOOSPrediction;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductOfferText;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductSku;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductStockAmount;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductSyncCount;
    private final SharedSQLiteStatement __preparedStmtOfUpdateProductToolTipAlertText;
    /* access modifiers changed from: private */
    public final ProductUrlListTypeConverter __productUrlListTypeConverter = new ProductUrlListTypeConverter();

    public CartDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfCartInfo = new EntityInsertionAdapter<CartInfo>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR REPLACE INTO `CartInfo` (`cartId`,`globalVendorId`,`vendorName`,`branchId`,`restaurantJson`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, CartInfo cartInfo) {
                if (cartInfo.getCartId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, cartInfo.getCartId());
                }
                if (cartInfo.getGlobalVendorId() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, cartInfo.getGlobalVendorId());
                }
                if (cartInfo.getVendorName() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, cartInfo.getVendorName());
                }
                if (cartInfo.getBranchId() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, cartInfo.getBranchId());
                }
                if (cartInfo.getRestaurantJson() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, cartInfo.getRestaurantJson());
                }
            }
        };
        this.__insertionAdapterOfProduct = new EntityInsertionAdapter<Product>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR ABORT INTO `Product` (`id`,`name`,`imageUrl`,`price`,`previousPrice`,`cartCount`,`syncedCount`,`freeCount`,`absoluteDiscount`,`vendorId`,`stock`,`isAvailable`,`imageUrls`,`description`,`categoryId`,`isFavorite`,`sku`,`isSponsored`,`campaignTrigger`,`ageLimit`,`hasBeenMarkedOOS`,`predictedToBeOOS`,`hasPriceChanged`,`hasQuantityChanged`,`offerText`,`tooltipAlertText`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Product product) {
                if (product.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, product.getId());
                }
                if (product.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, product.getName());
                }
                if (product.getImageUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, product.getImageUrl());
                }
                supportSQLiteStatement.bindDouble(4, (double) product.getPrice());
                if (product.getPreviousPrice() == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindDouble(5, (double) product.getPreviousPrice().floatValue());
                }
                supportSQLiteStatement.bindLong(6, (long) product.getCartCount());
                supportSQLiteStatement.bindLong(7, (long) product.getSyncedCount());
                if (product.getFreeCount() == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, (long) product.getFreeCount().intValue());
                }
                if (product.getAbsoluteDiscount() == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindDouble(9, (double) product.getAbsoluteDiscount().floatValue());
                }
                if (product.getVendorId() == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, product.getVendorId());
                }
                supportSQLiteStatement.bindLong(11, (long) product.getStock());
                supportSQLiteStatement.bindLong(12, product.isAvailable() ? 1 : 0);
                String fromProductUrlList = CartDao_Impl.this.__productUrlListTypeConverter.fromProductUrlList(product.getImageUrls());
                if (fromProductUrlList == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, fromProductUrlList);
                }
                if (product.getDescription() == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, product.getDescription());
                }
                if (product.getCategoryId() == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, product.getCategoryId());
                }
                supportSQLiteStatement.bindLong(16, product.isFavorite() ? 1 : 0);
                if (product.getSku() == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, product.getSku());
                }
                supportSQLiteStatement.bindLong(18, product.isSponsored() ? 1 : 0);
                String fromTriggerJson = CartDao_Impl.this.__campaignTriggerConverter.fromTriggerJson(product.getCampaignTrigger());
                if (fromTriggerJson == null) {
                    supportSQLiteStatement.bindNull(19);
                } else {
                    supportSQLiteStatement.bindString(19, fromTriggerJson);
                }
                supportSQLiteStatement.bindLong(20, (long) product.getAgeLimit());
                Integer num = null;
                Integer valueOf = product.getHasBeenMarkedOOS() == null ? null : Integer.valueOf(product.getHasBeenMarkedOOS().booleanValue() ? 1 : 0);
                if (valueOf == null) {
                    supportSQLiteStatement.bindNull(21);
                } else {
                    supportSQLiteStatement.bindLong(21, (long) valueOf.intValue());
                }
                Integer valueOf2 = product.getPredictedToBeOOS() == null ? null : Integer.valueOf(product.getPredictedToBeOOS().booleanValue() ? 1 : 0);
                if (valueOf2 == null) {
                    supportSQLiteStatement.bindNull(22);
                } else {
                    supportSQLiteStatement.bindLong(22, (long) valueOf2.intValue());
                }
                Integer valueOf3 = product.getHasPriceChanged() == null ? null : Integer.valueOf(product.getHasPriceChanged().booleanValue() ? 1 : 0);
                if (valueOf3 == null) {
                    supportSQLiteStatement.bindNull(23);
                } else {
                    supportSQLiteStatement.bindLong(23, (long) valueOf3.intValue());
                }
                if (product.getHasQuantityChanged() != null) {
                    num = Integer.valueOf(product.getHasQuantityChanged().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    supportSQLiteStatement.bindNull(24);
                } else {
                    supportSQLiteStatement.bindLong(24, (long) num.intValue());
                }
                if (product.getOfferText() == null) {
                    supportSQLiteStatement.bindNull(25);
                } else {
                    supportSQLiteStatement.bindString(25, product.getOfferText());
                }
                if (product.getTooltipAlertText() == null) {
                    supportSQLiteStatement.bindNull(26);
                } else {
                    supportSQLiteStatement.bindString(26, product.getTooltipAlertText());
                }
            }
        };
        this.__deletionAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM `Product` WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, Product product) {
                if (product.getId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, product.getId());
                }
            }
        };
        this.__preparedStmtOfDeleteCartInfo = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE from CartInfo WHERE cartId = ?";
            }
        };
        this.__preparedStmtOfUpdateProductSku = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET sku = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductCategory = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET categoryId = ? WHERE id = ? AND categoryId = ''";
            }
        };
        this.__preparedStmtOfUpdateProductAbsoluteDiscount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET absoluteDiscount = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductOfferText = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET offerText = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductToolTipAlertText = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET toolTipAlertText = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateFreeProductCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET freeCount = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET cartCount = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductSyncCount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET syncedCount = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductStockAmount = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET stock = ?, hasQuantityChanged = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdateProductOOSPrediction = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET predictedToBeOOS = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM Product";
            }
        };
        this.__preparedStmtOfClearCartInfo = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM CartInfo";
            }
        };
        this.__preparedStmtOfMarkOOS = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET hasBeenMarkedOOS = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfMarkPriceChanged = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET hasPriceChanged = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfUpdatePrice = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET price = ? WHERE id = ?";
            }
        };
        this.__preparedStmtOfRollbackCartCountsToSynced = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "UPDATE Product SET cartCount = syncedCount";
            }
        };
        this.__preparedStmtOfDeleteALlZeros = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM Product WHERE cartCount = 0";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    public void addProduct(Product product, CartInfo cartInfo) {
        this.__db.beginTransaction();
        try {
            CartDao.DefaultImpls.addProduct(this, product, cartInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void clearCart(String str) {
        this.__db.beginTransaction();
        try {
            CartDao.DefaultImpls.clearCart(this, str);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void clearCartInfo() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfClearCartInfo.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfClearCartInfo.release(acquire);
        }
    }

    public void deleteALlZeros() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteALlZeros.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteALlZeros.release(acquire);
        }
    }

    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(acquire);
        }
    }

    public void deleteCartInfo(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteCartInfo.acquire();
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteCartInfo.release(acquire);
        }
    }

    public void deleteEntry(Product product) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfProduct.handle(product);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public Maybe<CartInfo> getCartInfo(String str) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM CartInfo WHERE cartId = ?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        return Maybe.fromCallable(new Callable<CartInfo>() {
            public void finalize() {
                acquire.release();
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.talabat.feature.darkstorescart.data.model.CartInfo} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.talabat.feature.darkstorescart.data.model.CartInfo} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.talabat.feature.darkstorescart.data.model.CartInfo} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v0, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.talabat.feature.darkstorescart.data.model.CartInfo} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: com.talabat.feature.darkstorescart.data.model.CartInfo} */
            /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.String] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.talabat.feature.darkstorescart.data.model.CartInfo call() throws java.lang.Exception {
                /*
                    r13 = this;
                    com.talabat.feature.darkstorescart.data.local.CartDao_Impl r0 = com.talabat.feature.darkstorescart.data.local.CartDao_Impl.this
                    androidx.room.RoomDatabase r0 = r0.__db
                    androidx.room.RoomSQLiteQuery r1 = r0
                    r2 = 0
                    r3 = 0
                    android.database.Cursor r0 = androidx.room.util.DBUtil.query(r0, r1, r2, r3)
                    java.lang.String r1 = "cartId"
                    int r1 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r1)     // Catch:{ all -> 0x007e }
                    java.lang.String r2 = "globalVendorId"
                    int r2 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r2)     // Catch:{ all -> 0x007e }
                    java.lang.String r4 = "vendorName"
                    int r4 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r4)     // Catch:{ all -> 0x007e }
                    java.lang.String r5 = "branchId"
                    int r5 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r5)     // Catch:{ all -> 0x007e }
                    java.lang.String r6 = "restaurantJson"
                    int r6 = androidx.room.util.CursorUtil.getColumnIndexOrThrow(r0, r6)     // Catch:{ all -> 0x007e }
                    boolean r7 = r0.moveToFirst()     // Catch:{ all -> 0x007e }
                    if (r7 == 0) goto L_0x007a
                    boolean r7 = r0.isNull(r1)     // Catch:{ all -> 0x007e }
                    if (r7 == 0) goto L_0x003b
                    r8 = r3
                    goto L_0x0040
                L_0x003b:
                    java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x007e }
                    r8 = r1
                L_0x0040:
                    boolean r1 = r0.isNull(r2)     // Catch:{ all -> 0x007e }
                    if (r1 == 0) goto L_0x0048
                    r9 = r3
                    goto L_0x004d
                L_0x0048:
                    java.lang.String r1 = r0.getString(r2)     // Catch:{ all -> 0x007e }
                    r9 = r1
                L_0x004d:
                    boolean r1 = r0.isNull(r4)     // Catch:{ all -> 0x007e }
                    if (r1 == 0) goto L_0x0055
                    r10 = r3
                    goto L_0x005a
                L_0x0055:
                    java.lang.String r1 = r0.getString(r4)     // Catch:{ all -> 0x007e }
                    r10 = r1
                L_0x005a:
                    boolean r1 = r0.isNull(r5)     // Catch:{ all -> 0x007e }
                    if (r1 == 0) goto L_0x0062
                    r11 = r3
                    goto L_0x0067
                L_0x0062:
                    java.lang.String r1 = r0.getString(r5)     // Catch:{ all -> 0x007e }
                    r11 = r1
                L_0x0067:
                    boolean r1 = r0.isNull(r6)     // Catch:{ all -> 0x007e }
                    if (r1 == 0) goto L_0x006f
                L_0x006d:
                    r12 = r3
                    goto L_0x0074
                L_0x006f:
                    java.lang.String r3 = r0.getString(r6)     // Catch:{ all -> 0x007e }
                    goto L_0x006d
                L_0x0074:
                    com.talabat.feature.darkstorescart.data.model.CartInfo r3 = new com.talabat.feature.darkstorescart.data.model.CartInfo     // Catch:{ all -> 0x007e }
                    r7 = r3
                    r7.<init>(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x007e }
                L_0x007a:
                    r0.close()
                    return r3
                L_0x007e:
                    r1 = move-exception
                    r0.close()
                    throw r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.darkstorescart.data.local.CartDao_Impl.AnonymousClass22.call():com.talabat.feature.darkstorescart.data.model.CartInfo");
            }
        });
    }

    public void insertCartInfo(CartInfo cartInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfCartInfo.insert(cartInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public long insertEntry(Product product) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            long insertAndReturnId = this.__insertionAdapterOfProduct.insertAndReturnId(product);
            this.__db.setTransactionSuccessful();
            return insertAndReturnId;
        } finally {
            this.__db.endTransaction();
        }
    }

    public void insertProducts(List<Product> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfProduct.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void markOOS(String str, boolean z11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkOOS.acquire();
        acquire.bindLong(1, z11 ? 1 : 0);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkOOS.release(acquire);
        }
    }

    public void markPriceChanged(String str, boolean z11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkPriceChanged.acquire();
        acquire.bindLong(1, z11 ? 1 : 0);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkPriceChanged.release(acquire);
        }
    }

    public void removeProduct(String str, CartInfo cartInfo) {
        this.__db.beginTransaction();
        try {
            CartDao.DefaultImpls.removeProduct(this, str, cartInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void rollbackCartCountsToSynced() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfRollbackCartCountsToSynced.acquire();
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRollbackCartCountsToSynced.release(acquire);
        }
    }

    public List<Product> selectAll() {
        RoomSQLiteQuery roomSQLiteQuery;
        int i11;
        String str;
        String str2;
        String str3;
        Float f11;
        Integer num;
        Float f12;
        String str4;
        boolean z11;
        String string;
        int i12;
        int i13;
        String str5;
        int i14;
        String str6;
        boolean z12;
        String str7;
        boolean z13;
        int i15;
        String str8;
        Integer num2;
        int i16;
        Boolean bool;
        Integer num3;
        Boolean bool2;
        Integer num4;
        Boolean bool3;
        Integer num5;
        Boolean bool4;
        String str9;
        String str10;
        boolean z14;
        boolean z15;
        boolean z16;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Product", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ObservableAttributesNames.IMAGE_URL_V2);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.PRICE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "previousPrice");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "cartCount");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "syncedCount");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "freeCount");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "absoluteDiscount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "vendorId");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stock");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isAvailable");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "imageUrls");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "description");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "categoryId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ProductTrackingProvider.FAVOURITE);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "sku");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "isSponsored");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "campaignTrigger");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "ageLimit");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "hasBeenMarkedOOS");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "predictedToBeOOS");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "hasPriceChanged");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "hasQuantityChanged");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "offerText");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "tooltipAlertText");
                try {
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        Product product = new Product();
                        if (query.isNull(columnIndexOrThrow)) {
                            i11 = columnIndexOrThrow;
                            str = null;
                        } else {
                            i11 = columnIndexOrThrow;
                            str = query.getString(columnIndexOrThrow);
                        }
                        product.setId(str);
                        if (query.isNull(columnIndexOrThrow2)) {
                            str2 = null;
                        } else {
                            str2 = query.getString(columnIndexOrThrow2);
                        }
                        product.setName(str2);
                        if (query.isNull(columnIndexOrThrow3)) {
                            str3 = null;
                        } else {
                            str3 = query.getString(columnIndexOrThrow3);
                        }
                        product.setImageUrl(str3);
                        product.setPrice(query.getFloat(columnIndexOrThrow4));
                        if (query.isNull(columnIndexOrThrow5)) {
                            f11 = null;
                        } else {
                            f11 = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                        }
                        product.setPreviousPrice(f11);
                        product.setCartCount(query.getInt(columnIndexOrThrow6));
                        product.setSyncedCount(query.getInt(columnIndexOrThrow7));
                        if (query.isNull(columnIndexOrThrow8)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                        }
                        product.setFreeCount(num);
                        if (query.isNull(columnIndexOrThrow9)) {
                            f12 = null;
                        } else {
                            f12 = Float.valueOf(query.getFloat(columnIndexOrThrow9));
                        }
                        product.setAbsoluteDiscount(f12);
                        if (query.isNull(columnIndexOrThrow10)) {
                            str4 = null;
                        } else {
                            str4 = query.getString(columnIndexOrThrow10);
                        }
                        product.setVendorId(str4);
                        product.setStock(query.getInt(columnIndexOrThrow11));
                        boolean z17 = true;
                        if (query.getInt(columnIndexOrThrow12) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        product.setAvailable(z11);
                        if (query.isNull(columnIndexOrThrow13)) {
                            i12 = columnIndexOrThrow12;
                            i13 = columnIndexOrThrow13;
                            string = null;
                        } else {
                            string = query.getString(columnIndexOrThrow13);
                            i12 = columnIndexOrThrow12;
                            i13 = columnIndexOrThrow13;
                        }
                        try {
                            product.setImageUrls(this.__productUrlListTypeConverter.toProductUrlList(string));
                            int i17 = columnIndexOrThrow14;
                            if (query.isNull(i17)) {
                                str5 = null;
                            } else {
                                str5 = query.getString(i17);
                            }
                            product.setDescription(str5);
                            int i18 = columnIndexOrThrow15;
                            if (query.isNull(i18)) {
                                i14 = i17;
                                str6 = null;
                            } else {
                                i14 = i17;
                                str6 = query.getString(i18);
                            }
                            product.setCategoryId(str6);
                            int i19 = columnIndexOrThrow16;
                            columnIndexOrThrow16 = i19;
                            if (query.getInt(i19) != 0) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            product.setFavorite(z12);
                            int i21 = columnIndexOrThrow17;
                            if (query.isNull(i21)) {
                                columnIndexOrThrow17 = i21;
                                str7 = null;
                            } else {
                                columnIndexOrThrow17 = i21;
                                str7 = query.getString(i21);
                            }
                            product.setSku(str7);
                            int i22 = columnIndexOrThrow18;
                            columnIndexOrThrow18 = i22;
                            if (query.getInt(i22) != 0) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            product.setSponsored(z13);
                            int i23 = columnIndexOrThrow19;
                            if (query.isNull(i23)) {
                                columnIndexOrThrow19 = i23;
                                i15 = i18;
                                str8 = null;
                            } else {
                                columnIndexOrThrow19 = i23;
                                str8 = query.getString(i23);
                                i15 = i18;
                            }
                            product.setCampaignTrigger(this.__campaignTriggerConverter.toTrigger(str8));
                            int i24 = columnIndexOrThrow20;
                            product.setAgeLimit(query.getInt(i24));
                            int i25 = columnIndexOrThrow21;
                            if (query.isNull(i25)) {
                                num2 = null;
                            } else {
                                num2 = Integer.valueOf(query.getInt(i25));
                            }
                            if (num2 == null) {
                                i16 = i24;
                                bool = null;
                            } else {
                                if (num2.intValue() != 0) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                i16 = i24;
                                bool = Boolean.valueOf(z16);
                            }
                            product.setHasBeenMarkedOOS(bool);
                            int i26 = columnIndexOrThrow22;
                            if (query.isNull(i26)) {
                                num3 = null;
                            } else {
                                num3 = Integer.valueOf(query.getInt(i26));
                            }
                            if (num3 == null) {
                                columnIndexOrThrow22 = i26;
                                bool2 = null;
                            } else {
                                if (num3.intValue() != 0) {
                                    z15 = true;
                                } else {
                                    z15 = false;
                                }
                                columnIndexOrThrow22 = i26;
                                bool2 = Boolean.valueOf(z15);
                            }
                            product.setPredictedToBeOOS(bool2);
                            int i27 = columnIndexOrThrow23;
                            if (query.isNull(i27)) {
                                num4 = null;
                            } else {
                                num4 = Integer.valueOf(query.getInt(i27));
                            }
                            if (num4 == null) {
                                columnIndexOrThrow23 = i27;
                                bool3 = null;
                            } else {
                                if (num4.intValue() != 0) {
                                    z14 = true;
                                } else {
                                    z14 = false;
                                }
                                columnIndexOrThrow23 = i27;
                                bool3 = Boolean.valueOf(z14);
                            }
                            product.setHasPriceChanged(bool3);
                            int i28 = columnIndexOrThrow24;
                            if (query.isNull(i28)) {
                                num5 = null;
                            } else {
                                num5 = Integer.valueOf(query.getInt(i28));
                            }
                            if (num5 == null) {
                                columnIndexOrThrow24 = i28;
                                bool4 = null;
                            } else {
                                if (num5.intValue() == 0) {
                                    z17 = false;
                                }
                                columnIndexOrThrow24 = i28;
                                bool4 = Boolean.valueOf(z17);
                            }
                            product.setHasQuantityChanged(bool4);
                            int i29 = columnIndexOrThrow25;
                            if (query.isNull(i29)) {
                                columnIndexOrThrow25 = i29;
                                str9 = null;
                            } else {
                                columnIndexOrThrow25 = i29;
                                str9 = query.getString(i29);
                            }
                            product.setOfferText(str9);
                            int i31 = columnIndexOrThrow26;
                            if (query.isNull(i31)) {
                                columnIndexOrThrow26 = i31;
                                str10 = null;
                            } else {
                                columnIndexOrThrow26 = i31;
                                str10 = query.getString(i31);
                            }
                            product.setTooltipAlertText(str10);
                            arrayList.add(product);
                            columnIndexOrThrow20 = i16;
                            columnIndexOrThrow = i11;
                            columnIndexOrThrow12 = i12;
                            columnIndexOrThrow21 = i25;
                            columnIndexOrThrow13 = i13;
                            int i32 = i14;
                            columnIndexOrThrow15 = i15;
                            columnIndexOrThrow14 = i32;
                        } catch (Throwable th2) {
                            th = th2;
                            query.close();
                            roomSQLiteQuery.release();
                            throw th;
                        }
                    }
                    query.close();
                    roomSQLiteQuery.release();
                    return arrayList;
                } catch (Throwable th3) {
                    th = th3;
                    query.close();
                    roomSQLiteQuery.release();
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public Maybe<List<Product>> selectAllMaybe(boolean z11) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Product WHERE hasBeenMarkedOOS = ?", 1);
        acquire.bindLong(1, z11 ? 1 : 0);
        return Maybe.fromCallable(new Callable<List<Product>>() {
            public void finalize() {
                acquire.release();
            }

            public List<Product> call() throws Exception {
                int i11;
                String str;
                String str2;
                String str3;
                Float f11;
                Integer num;
                Float f12;
                String str4;
                String string;
                int i12;
                int i13;
                String str5;
                int i14;
                String str6;
                String str7;
                int i15;
                String str8;
                Integer num2;
                int i16;
                Boolean bool;
                Integer num3;
                Boolean bool2;
                Integer num4;
                Boolean bool3;
                Integer num5;
                Boolean bool4;
                String str9;
                String str10;
                Cursor query = DBUtil.query(CartDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ObservableAttributesNames.IMAGE_URL_V2);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.PRICE);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "previousPrice");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "cartCount");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "syncedCount");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "freeCount");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "absoluteDiscount");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "vendorId");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stock");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isAvailable");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "imageUrls");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "categoryId");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ProductTrackingProvider.FAVOURITE);
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "sku");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "isSponsored");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "campaignTrigger");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "ageLimit");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "hasBeenMarkedOOS");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "predictedToBeOOS");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "hasPriceChanged");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "hasQuantityChanged");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "offerText");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "tooltipAlertText");
                    try {
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            Product product = new Product();
                            if (query.isNull(columnIndexOrThrow)) {
                                i11 = columnIndexOrThrow;
                                str = null;
                            } else {
                                i11 = columnIndexOrThrow;
                                str = query.getString(columnIndexOrThrow);
                            }
                            product.setId(str);
                            if (query.isNull(columnIndexOrThrow2)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow2);
                            }
                            product.setName(str2);
                            if (query.isNull(columnIndexOrThrow3)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow3);
                            }
                            product.setImageUrl(str3);
                            product.setPrice(query.getFloat(columnIndexOrThrow4));
                            if (query.isNull(columnIndexOrThrow5)) {
                                f11 = null;
                            } else {
                                f11 = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                            }
                            product.setPreviousPrice(f11);
                            product.setCartCount(query.getInt(columnIndexOrThrow6));
                            product.setSyncedCount(query.getInt(columnIndexOrThrow7));
                            if (query.isNull(columnIndexOrThrow8)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            product.setFreeCount(num);
                            if (query.isNull(columnIndexOrThrow9)) {
                                f12 = null;
                            } else {
                                f12 = Float.valueOf(query.getFloat(columnIndexOrThrow9));
                            }
                            product.setAbsoluteDiscount(f12);
                            if (query.isNull(columnIndexOrThrow10)) {
                                str4 = null;
                            } else {
                                str4 = query.getString(columnIndexOrThrow10);
                            }
                            product.setVendorId(str4);
                            product.setStock(query.getInt(columnIndexOrThrow11));
                            boolean z11 = true;
                            product.setAvailable(query.getInt(columnIndexOrThrow12) != 0);
                            if (query.isNull(columnIndexOrThrow13)) {
                                i12 = columnIndexOrThrow13;
                                i13 = columnIndexOrThrow2;
                                string = null;
                            } else {
                                string = query.getString(columnIndexOrThrow13);
                                i12 = columnIndexOrThrow13;
                                i13 = columnIndexOrThrow2;
                            }
                            try {
                                product.setImageUrls(CartDao_Impl.this.__productUrlListTypeConverter.toProductUrlList(string));
                                int i17 = columnIndexOrThrow14;
                                if (query.isNull(i17)) {
                                    str5 = null;
                                } else {
                                    str5 = query.getString(i17);
                                }
                                product.setDescription(str5);
                                int i18 = columnIndexOrThrow15;
                                if (query.isNull(i18)) {
                                    i14 = i17;
                                    str6 = null;
                                } else {
                                    i14 = i17;
                                    str6 = query.getString(i18);
                                }
                                product.setCategoryId(str6);
                                int i19 = columnIndexOrThrow16;
                                columnIndexOrThrow16 = i19;
                                product.setFavorite(query.getInt(i19) != 0);
                                int i21 = columnIndexOrThrow17;
                                if (query.isNull(i21)) {
                                    columnIndexOrThrow17 = i21;
                                    str7 = null;
                                } else {
                                    columnIndexOrThrow17 = i21;
                                    str7 = query.getString(i21);
                                }
                                product.setSku(str7);
                                int i22 = columnIndexOrThrow18;
                                columnIndexOrThrow18 = i22;
                                product.setSponsored(query.getInt(i22) != 0);
                                int i23 = columnIndexOrThrow19;
                                if (query.isNull(i23)) {
                                    columnIndexOrThrow19 = i23;
                                    i15 = i18;
                                    str8 = null;
                                } else {
                                    columnIndexOrThrow19 = i23;
                                    str8 = query.getString(i23);
                                    i15 = i18;
                                }
                                product.setCampaignTrigger(CartDao_Impl.this.__campaignTriggerConverter.toTrigger(str8));
                                int i24 = columnIndexOrThrow20;
                                product.setAgeLimit(query.getInt(i24));
                                int i25 = columnIndexOrThrow21;
                                if (query.isNull(i25)) {
                                    num2 = null;
                                } else {
                                    num2 = Integer.valueOf(query.getInt(i25));
                                }
                                if (num2 == null) {
                                    i16 = i24;
                                    bool = null;
                                } else {
                                    i16 = i24;
                                    bool = Boolean.valueOf(num2.intValue() != 0);
                                }
                                product.setHasBeenMarkedOOS(bool);
                                int i26 = columnIndexOrThrow22;
                                if (query.isNull(i26)) {
                                    num3 = null;
                                } else {
                                    num3 = Integer.valueOf(query.getInt(i26));
                                }
                                if (num3 == null) {
                                    columnIndexOrThrow22 = i26;
                                    bool2 = null;
                                } else {
                                    columnIndexOrThrow22 = i26;
                                    bool2 = Boolean.valueOf(num3.intValue() != 0);
                                }
                                product.setPredictedToBeOOS(bool2);
                                int i27 = columnIndexOrThrow23;
                                if (query.isNull(i27)) {
                                    num4 = null;
                                } else {
                                    num4 = Integer.valueOf(query.getInt(i27));
                                }
                                if (num4 == null) {
                                    columnIndexOrThrow23 = i27;
                                    bool3 = null;
                                } else {
                                    columnIndexOrThrow23 = i27;
                                    bool3 = Boolean.valueOf(num4.intValue() != 0);
                                }
                                product.setHasPriceChanged(bool3);
                                int i28 = columnIndexOrThrow24;
                                if (query.isNull(i28)) {
                                    num5 = null;
                                } else {
                                    num5 = Integer.valueOf(query.getInt(i28));
                                }
                                if (num5 == null) {
                                    columnIndexOrThrow24 = i28;
                                    bool4 = null;
                                } else {
                                    if (num5.intValue() == 0) {
                                        z11 = false;
                                    }
                                    columnIndexOrThrow24 = i28;
                                    bool4 = Boolean.valueOf(z11);
                                }
                                product.setHasQuantityChanged(bool4);
                                int i29 = columnIndexOrThrow25;
                                if (query.isNull(i29)) {
                                    columnIndexOrThrow25 = i29;
                                    str9 = null;
                                } else {
                                    columnIndexOrThrow25 = i29;
                                    str9 = query.getString(i29);
                                }
                                product.setOfferText(str9);
                                int i31 = columnIndexOrThrow26;
                                if (query.isNull(i31)) {
                                    columnIndexOrThrow26 = i31;
                                    str10 = null;
                                } else {
                                    columnIndexOrThrow26 = i31;
                                    str10 = query.getString(i31);
                                }
                                product.setTooltipAlertText(str10);
                                arrayList.add(product);
                                columnIndexOrThrow20 = i16;
                                columnIndexOrThrow = i11;
                                columnIndexOrThrow13 = i12;
                                columnIndexOrThrow21 = i25;
                                columnIndexOrThrow2 = i13;
                                int i32 = i14;
                                columnIndexOrThrow15 = i15;
                                columnIndexOrThrow14 = i32;
                            } catch (Throwable th2) {
                                th = th2;
                                query.close();
                                throw th;
                            }
                        }
                        query.close();
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        query.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    query.close();
                    throw th;
                }
            }
        });
    }

    public Observable<List<Product>> selectAllObservable(boolean z11) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Product WHERE hasBeenMarkedOOS = ?", 1);
        acquire.bindLong(1, z11 ? 1 : 0);
        return RxRoom.createObservable(this.__db, false, new String[]{"Product"}, new Callable<List<Product>>() {
            public void finalize() {
                acquire.release();
            }

            public List<Product> call() throws Exception {
                int i11;
                String str;
                String str2;
                String str3;
                Float f11;
                Integer num;
                Float f12;
                String str4;
                String string;
                int i12;
                int i13;
                String str5;
                int i14;
                String str6;
                String str7;
                int i15;
                String str8;
                Integer num2;
                int i16;
                Boolean bool;
                Integer num3;
                Boolean bool2;
                Integer num4;
                Boolean bool3;
                Integer num5;
                Boolean bool4;
                String str9;
                String str10;
                Cursor query = DBUtil.query(CartDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ObservableAttributesNames.IMAGE_URL_V2);
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.PRICE);
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "previousPrice");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "cartCount");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "syncedCount");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "freeCount");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "absoluteDiscount");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "vendorId");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stock");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isAvailable");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "imageUrls");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "description");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "categoryId");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ProductTrackingProvider.FAVOURITE);
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "sku");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "isSponsored");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "campaignTrigger");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "ageLimit");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "hasBeenMarkedOOS");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "predictedToBeOOS");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "hasPriceChanged");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "hasQuantityChanged");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "offerText");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "tooltipAlertText");
                    try {
                        ArrayList arrayList = new ArrayList(query.getCount());
                        while (query.moveToNext()) {
                            Product product = new Product();
                            if (query.isNull(columnIndexOrThrow)) {
                                i11 = columnIndexOrThrow;
                                str = null;
                            } else {
                                i11 = columnIndexOrThrow;
                                str = query.getString(columnIndexOrThrow);
                            }
                            product.setId(str);
                            if (query.isNull(columnIndexOrThrow2)) {
                                str2 = null;
                            } else {
                                str2 = query.getString(columnIndexOrThrow2);
                            }
                            product.setName(str2);
                            if (query.isNull(columnIndexOrThrow3)) {
                                str3 = null;
                            } else {
                                str3 = query.getString(columnIndexOrThrow3);
                            }
                            product.setImageUrl(str3);
                            product.setPrice(query.getFloat(columnIndexOrThrow4));
                            if (query.isNull(columnIndexOrThrow5)) {
                                f11 = null;
                            } else {
                                f11 = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                            }
                            product.setPreviousPrice(f11);
                            product.setCartCount(query.getInt(columnIndexOrThrow6));
                            product.setSyncedCount(query.getInt(columnIndexOrThrow7));
                            if (query.isNull(columnIndexOrThrow8)) {
                                num = null;
                            } else {
                                num = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                            }
                            product.setFreeCount(num);
                            if (query.isNull(columnIndexOrThrow9)) {
                                f12 = null;
                            } else {
                                f12 = Float.valueOf(query.getFloat(columnIndexOrThrow9));
                            }
                            product.setAbsoluteDiscount(f12);
                            if (query.isNull(columnIndexOrThrow10)) {
                                str4 = null;
                            } else {
                                str4 = query.getString(columnIndexOrThrow10);
                            }
                            product.setVendorId(str4);
                            product.setStock(query.getInt(columnIndexOrThrow11));
                            boolean z11 = true;
                            product.setAvailable(query.getInt(columnIndexOrThrow12) != 0);
                            if (query.isNull(columnIndexOrThrow13)) {
                                i12 = columnIndexOrThrow13;
                                i13 = columnIndexOrThrow2;
                                string = null;
                            } else {
                                string = query.getString(columnIndexOrThrow13);
                                i12 = columnIndexOrThrow13;
                                i13 = columnIndexOrThrow2;
                            }
                            try {
                                product.setImageUrls(CartDao_Impl.this.__productUrlListTypeConverter.toProductUrlList(string));
                                int i17 = columnIndexOrThrow14;
                                if (query.isNull(i17)) {
                                    str5 = null;
                                } else {
                                    str5 = query.getString(i17);
                                }
                                product.setDescription(str5);
                                int i18 = columnIndexOrThrow15;
                                if (query.isNull(i18)) {
                                    i14 = i17;
                                    str6 = null;
                                } else {
                                    i14 = i17;
                                    str6 = query.getString(i18);
                                }
                                product.setCategoryId(str6);
                                int i19 = columnIndexOrThrow16;
                                columnIndexOrThrow16 = i19;
                                product.setFavorite(query.getInt(i19) != 0);
                                int i21 = columnIndexOrThrow17;
                                if (query.isNull(i21)) {
                                    columnIndexOrThrow17 = i21;
                                    str7 = null;
                                } else {
                                    columnIndexOrThrow17 = i21;
                                    str7 = query.getString(i21);
                                }
                                product.setSku(str7);
                                int i22 = columnIndexOrThrow18;
                                columnIndexOrThrow18 = i22;
                                product.setSponsored(query.getInt(i22) != 0);
                                int i23 = columnIndexOrThrow19;
                                if (query.isNull(i23)) {
                                    columnIndexOrThrow19 = i23;
                                    i15 = i18;
                                    str8 = null;
                                } else {
                                    columnIndexOrThrow19 = i23;
                                    str8 = query.getString(i23);
                                    i15 = i18;
                                }
                                product.setCampaignTrigger(CartDao_Impl.this.__campaignTriggerConverter.toTrigger(str8));
                                int i24 = columnIndexOrThrow20;
                                product.setAgeLimit(query.getInt(i24));
                                int i25 = columnIndexOrThrow21;
                                if (query.isNull(i25)) {
                                    num2 = null;
                                } else {
                                    num2 = Integer.valueOf(query.getInt(i25));
                                }
                                if (num2 == null) {
                                    i16 = i24;
                                    bool = null;
                                } else {
                                    i16 = i24;
                                    bool = Boolean.valueOf(num2.intValue() != 0);
                                }
                                product.setHasBeenMarkedOOS(bool);
                                int i26 = columnIndexOrThrow22;
                                if (query.isNull(i26)) {
                                    num3 = null;
                                } else {
                                    num3 = Integer.valueOf(query.getInt(i26));
                                }
                                if (num3 == null) {
                                    columnIndexOrThrow22 = i26;
                                    bool2 = null;
                                } else {
                                    columnIndexOrThrow22 = i26;
                                    bool2 = Boolean.valueOf(num3.intValue() != 0);
                                }
                                product.setPredictedToBeOOS(bool2);
                                int i27 = columnIndexOrThrow23;
                                if (query.isNull(i27)) {
                                    num4 = null;
                                } else {
                                    num4 = Integer.valueOf(query.getInt(i27));
                                }
                                if (num4 == null) {
                                    columnIndexOrThrow23 = i27;
                                    bool3 = null;
                                } else {
                                    columnIndexOrThrow23 = i27;
                                    bool3 = Boolean.valueOf(num4.intValue() != 0);
                                }
                                product.setHasPriceChanged(bool3);
                                int i28 = columnIndexOrThrow24;
                                if (query.isNull(i28)) {
                                    num5 = null;
                                } else {
                                    num5 = Integer.valueOf(query.getInt(i28));
                                }
                                if (num5 == null) {
                                    columnIndexOrThrow24 = i28;
                                    bool4 = null;
                                } else {
                                    if (num5.intValue() == 0) {
                                        z11 = false;
                                    }
                                    columnIndexOrThrow24 = i28;
                                    bool4 = Boolean.valueOf(z11);
                                }
                                product.setHasQuantityChanged(bool4);
                                int i29 = columnIndexOrThrow25;
                                if (query.isNull(i29)) {
                                    columnIndexOrThrow25 = i29;
                                    str9 = null;
                                } else {
                                    columnIndexOrThrow25 = i29;
                                    str9 = query.getString(i29);
                                }
                                product.setOfferText(str9);
                                int i31 = columnIndexOrThrow26;
                                if (query.isNull(i31)) {
                                    columnIndexOrThrow26 = i31;
                                    str10 = null;
                                } else {
                                    columnIndexOrThrow26 = i31;
                                    str10 = query.getString(i31);
                                }
                                product.setTooltipAlertText(str10);
                                arrayList.add(product);
                                columnIndexOrThrow20 = i16;
                                columnIndexOrThrow = i11;
                                columnIndexOrThrow13 = i12;
                                columnIndexOrThrow21 = i25;
                                columnIndexOrThrow2 = i13;
                                int i32 = i14;
                                columnIndexOrThrow15 = i15;
                                columnIndexOrThrow14 = i32;
                            } catch (Throwable th2) {
                                th = th2;
                                query.close();
                                throw th;
                            }
                        }
                        query.close();
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        query.close();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    query.close();
                    throw th;
                }
            }
        });
    }

    public Product selectById(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Product product;
        String str2;
        String str3;
        String str4;
        Float f11;
        Integer num;
        Float f12;
        String str5;
        boolean z11;
        String str6;
        String str7;
        String str8;
        boolean z12;
        String str9;
        boolean z13;
        String str10;
        Integer num2;
        Boolean bool;
        Integer num3;
        Boolean bool2;
        Integer num4;
        Boolean bool3;
        Integer num5;
        Boolean bool4;
        String str11;
        String str12;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        String str13 = str;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM Product WHERE id = ? LIMIT 1", 1);
        if (str13 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str13);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, ObservableAttributesNames.IMAGE_URL_V2);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, FirebaseAnalytics.Param.PRICE);
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "previousPrice");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(query, "cartCount");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(query, "syncedCount");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(query, "freeCount");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(query, "absoluteDiscount");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(query, "vendorId");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(query, "stock");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(query, "isAvailable");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(query, "imageUrls");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(query, "description");
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(query, "categoryId");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(query, ProductTrackingProvider.FAVOURITE);
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(query, "sku");
                int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(query, "isSponsored");
                int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(query, "campaignTrigger");
                int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(query, "ageLimit");
                int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(query, "hasBeenMarkedOOS");
                int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(query, "predictedToBeOOS");
                int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(query, "hasPriceChanged");
                int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(query, "hasQuantityChanged");
                int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(query, "offerText");
                int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(query, "tooltipAlertText");
                if (query.moveToFirst()) {
                    int i11 = columnIndexOrThrow26;
                    Product product2 = new Product();
                    if (query.isNull(columnIndexOrThrow)) {
                        str2 = null;
                    } else {
                        str2 = query.getString(columnIndexOrThrow);
                    }
                    product2.setId(str2);
                    if (query.isNull(columnIndexOrThrow2)) {
                        str3 = null;
                    } else {
                        str3 = query.getString(columnIndexOrThrow2);
                    }
                    product2.setName(str3);
                    if (query.isNull(columnIndexOrThrow3)) {
                        str4 = null;
                    } else {
                        str4 = query.getString(columnIndexOrThrow3);
                    }
                    product2.setImageUrl(str4);
                    product2.setPrice(query.getFloat(columnIndexOrThrow4));
                    if (query.isNull(columnIndexOrThrow5)) {
                        f11 = null;
                    } else {
                        f11 = Float.valueOf(query.getFloat(columnIndexOrThrow5));
                    }
                    product2.setPreviousPrice(f11);
                    product2.setCartCount(query.getInt(columnIndexOrThrow6));
                    product2.setSyncedCount(query.getInt(columnIndexOrThrow7));
                    if (query.isNull(columnIndexOrThrow8)) {
                        num = null;
                    } else {
                        num = Integer.valueOf(query.getInt(columnIndexOrThrow8));
                    }
                    product2.setFreeCount(num);
                    if (query.isNull(columnIndexOrThrow9)) {
                        f12 = null;
                    } else {
                        f12 = Float.valueOf(query.getFloat(columnIndexOrThrow9));
                    }
                    product2.setAbsoluteDiscount(f12);
                    if (query.isNull(columnIndexOrThrow10)) {
                        str5 = null;
                    } else {
                        str5 = query.getString(columnIndexOrThrow10);
                    }
                    product2.setVendorId(str5);
                    product2.setStock(query.getInt(columnIndexOrThrow11));
                    if (query.getInt(columnIndexOrThrow12) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    product2.setAvailable(z11);
                    if (query.isNull(columnIndexOrThrow13)) {
                        str6 = null;
                    } else {
                        str6 = query.getString(columnIndexOrThrow13);
                    }
                    product2.setImageUrls(this.__productUrlListTypeConverter.toProductUrlList(str6));
                    int i12 = columnIndexOrThrow14;
                    if (query.isNull(i12)) {
                        str7 = null;
                    } else {
                        str7 = query.getString(i12);
                    }
                    product2.setDescription(str7);
                    int i13 = columnIndexOrThrow15;
                    if (query.isNull(i13)) {
                        str8 = null;
                    } else {
                        str8 = query.getString(i13);
                    }
                    product2.setCategoryId(str8);
                    if (query.getInt(columnIndexOrThrow16) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    product2.setFavorite(z12);
                    int i14 = columnIndexOrThrow17;
                    if (query.isNull(i14)) {
                        str9 = null;
                    } else {
                        str9 = query.getString(i14);
                    }
                    product2.setSku(str9);
                    if (query.getInt(columnIndexOrThrow18) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    product2.setSponsored(z13);
                    int i15 = columnIndexOrThrow19;
                    if (query.isNull(i15)) {
                        str10 = null;
                    } else {
                        str10 = query.getString(i15);
                    }
                    product2.setCampaignTrigger(this.__campaignTriggerConverter.toTrigger(str10));
                    product2.setAgeLimit(query.getInt(columnIndexOrThrow20));
                    int i16 = columnIndexOrThrow21;
                    if (query.isNull(i16)) {
                        num2 = null;
                    } else {
                        num2 = Integer.valueOf(query.getInt(i16));
                    }
                    if (num2 == null) {
                        bool = null;
                    } else {
                        if (num2.intValue() != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        bool = Boolean.valueOf(z17);
                    }
                    product2.setHasBeenMarkedOOS(bool);
                    int i17 = columnIndexOrThrow22;
                    if (query.isNull(i17)) {
                        num3 = null;
                    } else {
                        num3 = Integer.valueOf(query.getInt(i17));
                    }
                    if (num3 == null) {
                        bool2 = null;
                    } else {
                        if (num3.intValue() != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        bool2 = Boolean.valueOf(z16);
                    }
                    product2.setPredictedToBeOOS(bool2);
                    int i18 = columnIndexOrThrow23;
                    if (query.isNull(i18)) {
                        num4 = null;
                    } else {
                        num4 = Integer.valueOf(query.getInt(i18));
                    }
                    if (num4 == null) {
                        bool3 = null;
                    } else {
                        if (num4.intValue() != 0) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        bool3 = Boolean.valueOf(z15);
                    }
                    product2.setHasPriceChanged(bool3);
                    int i19 = columnIndexOrThrow24;
                    if (query.isNull(i19)) {
                        num5 = null;
                    } else {
                        num5 = Integer.valueOf(query.getInt(i19));
                    }
                    if (num5 == null) {
                        bool4 = null;
                    } else {
                        if (num5.intValue() != 0) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        bool4 = Boolean.valueOf(z14);
                    }
                    product2.setHasQuantityChanged(bool4);
                    int i21 = columnIndexOrThrow25;
                    if (query.isNull(i21)) {
                        str11 = null;
                    } else {
                        str11 = query.getString(i21);
                    }
                    product2.setOfferText(str11);
                    int i22 = i11;
                    if (query.isNull(i22)) {
                        str12 = null;
                    } else {
                        str12 = query.getString(i22);
                    }
                    product2.setTooltipAlertText(str12);
                    product = product2;
                } else {
                    product = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return product;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int selectTotalProductsCount() {
        int i11 = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT TOTAL(cartCount) FROM Product", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, (CancellationSignal) null);
        try {
            if (query.moveToFirst()) {
                i11 = query.getInt(0);
            }
            return i11;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public Single<Integer> selectTotalProductsCountAsSingle(boolean z11) {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT TOTAL(cartCount) FROM Product WHERE hasBeenMarkedOOS = ?", 1);
        acquire.bindLong(1, z11 ? 1 : 0);
        return RxRoom.createSingle(new Callable<Integer>() {
            public void finalize() {
                acquire.release();
            }

            public Integer call() throws Exception {
                Integer num = null;
                Cursor query = DBUtil.query(CartDao_Impl.this.__db, acquire, false, (CancellationSignal) null);
                try {
                    if (query.moveToFirst()) {
                        if (!query.isNull(0)) {
                            num = Integer.valueOf(query.getInt(0));
                        }
                    }
                    if (num != null) {
                        return num;
                    }
                    throw new EmptyResultSetException("Query returned empty result set: " + acquire.getSql());
                } finally {
                    query.close();
                }
            }
        });
    }

    public void setProductCount(Product product, int i11, CartInfo cartInfo) {
        this.__db.beginTransaction();
        try {
            CartDao.DefaultImpls.setProductCount(this, product, i11, cartInfo);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateAllSyncFailure() {
        this.__db.beginTransaction();
        try {
            CartDao.DefaultImpls.updateAllSyncFailure(this);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public List<Product> updateAllSyncSuccess(List<CartResponseProduct> list) {
        this.__db.beginTransaction();
        try {
            List<Product> updateAllSyncSuccess = CartDao.DefaultImpls.updateAllSyncSuccess(this, list);
            this.__db.setTransactionSuccessful();
            return updateAllSyncSuccess;
        } finally {
            this.__db.endTransaction();
        }
    }

    public List<Product> updateAllSyncSuccessV2(List<CartResponseProduct> list) {
        this.__db.beginTransaction();
        try {
            List<Product> updateAllSyncSuccessV2 = CartDao.DefaultImpls.updateAllSyncSuccessV2(this, list);
            this.__db.setTransactionSuccessful();
            return updateAllSyncSuccessV2;
        } finally {
            this.__db.endTransaction();
        }
    }

    public void updateFreeProductCount(String str, int i11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateFreeProductCount.acquire();
        acquire.bindLong(1, (long) i11);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateFreeProductCount.release(acquire);
        }
    }

    public void updatePrice(String str, float f11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdatePrice.acquire();
        acquire.bindDouble(1, (double) f11);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdatePrice.release(acquire);
        }
    }

    public void updateProductAbsoluteDiscount(String str, float f11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductAbsoluteDiscount.acquire();
        acquire.bindDouble(1, (double) f11);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductAbsoluteDiscount.release(acquire);
        }
    }

    public void updateProductCategory(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductCategory.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductCategory.release(acquire);
        }
    }

    public void updateProductCount(String str, int i11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductCount.acquire();
        acquire.bindLong(1, (long) i11);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductCount.release(acquire);
        }
    }

    public void updateProductOOSPrediction(String str, boolean z11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductOOSPrediction.acquire();
        acquire.bindLong(1, z11 ? 1 : 0);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductOOSPrediction.release(acquire);
        }
    }

    public void updateProductOfferText(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductOfferText.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductOfferText.release(acquire);
        }
    }

    public void updateProductSku(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductSku.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductSku.release(acquire);
        }
    }

    public void updateProductStockAmount(String str, int i11, boolean z11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductStockAmount.acquire();
        acquire.bindLong(1, (long) i11);
        acquire.bindLong(2, z11 ? 1 : 0);
        if (str == null) {
            acquire.bindNull(3);
        } else {
            acquire.bindString(3, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductStockAmount.release(acquire);
        }
    }

    public void updateProductSyncCount(String str, int i11) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductSyncCount.acquire();
        acquire.bindLong(1, (long) i11);
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductSyncCount.release(acquire);
        }
    }

    public void updateProductToolTipAlertText(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfUpdateProductToolTipAlertText.acquire();
        if (str2 == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str2);
        }
        if (str == null) {
            acquire.bindNull(2);
        } else {
            acquire.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateProductToolTipAlertText.release(acquire);
        }
    }
}
