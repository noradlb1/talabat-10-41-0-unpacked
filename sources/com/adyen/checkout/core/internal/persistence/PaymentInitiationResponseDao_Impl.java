package com.adyen.checkout.core.internal.persistence;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.adyen.checkout.core.internal.persistence.PaymentInitiationResponseEntity;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;

public class PaymentInitiationResponseDao_Impl implements PaymentInitiationResponseDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfPaymentInitiationResponseEntity;
    /* access modifiers changed from: private */
    public final PaymentInitiationResponseEntity.PaymentInitiationResponseConverter __paymentInitiationResponseConverter = new PaymentInitiationResponseEntity.PaymentInitiationResponseConverter();
    /* access modifiers changed from: private */
    public final PaymentInitiationResponseEntity.PaymentMethodConverter __paymentMethodConverter = new PaymentInitiationResponseEntity.PaymentMethodConverter();
    private final SharedSQLiteStatement __preparedStmtOfDeleteByPaymentSessionEntityUuid;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfPaymentInitiationResponseEntity;

    public PaymentInitiationResponseDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPaymentInitiationResponseEntity = new EntityInsertionAdapter<PaymentInitiationResponseEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR FAIL INTO `payment_initiation_responses`(`id`,`payment_session_uuid`,`payment_method_json`,`payment_initiation_response_json`,`handled`) VALUES (nullif(?, 0),?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
                supportSQLiteStatement.bindLong(1, paymentInitiationResponseEntity.f40126id);
                String str = paymentInitiationResponseEntity.paymentSessionUuid;
                if (str == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, str);
                }
                String fromPaymentMethod = PaymentInitiationResponseDao_Impl.this.__paymentMethodConverter.fromPaymentMethod(paymentInitiationResponseEntity.paymentMethod);
                if (fromPaymentMethod == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, fromPaymentMethod);
                }
                String fromPaymentInitiationResponse = PaymentInitiationResponseDao_Impl.this.__paymentInitiationResponseConverter.fromPaymentInitiationResponse(paymentInitiationResponseEntity.paymentInitiationResponse);
                if (fromPaymentInitiationResponse == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, fromPaymentInitiationResponse);
                }
                supportSQLiteStatement.bindLong(5, paymentInitiationResponseEntity.handled ? 1 : 0);
            }
        };
        this.__updateAdapterOfPaymentInitiationResponseEntity = new EntityDeletionOrUpdateAdapter<PaymentInitiationResponseEntity>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `payment_initiation_responses` SET `id` = ?,`payment_session_uuid` = ?,`payment_method_json` = ?,`payment_initiation_response_json` = ?,`handled` = ? WHERE `id` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
                supportSQLiteStatement.bindLong(1, paymentInitiationResponseEntity.f40126id);
                String str = paymentInitiationResponseEntity.paymentSessionUuid;
                if (str == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, str);
                }
                String fromPaymentMethod = PaymentInitiationResponseDao_Impl.this.__paymentMethodConverter.fromPaymentMethod(paymentInitiationResponseEntity.paymentMethod);
                if (fromPaymentMethod == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, fromPaymentMethod);
                }
                String fromPaymentInitiationResponse = PaymentInitiationResponseDao_Impl.this.__paymentInitiationResponseConverter.fromPaymentInitiationResponse(paymentInitiationResponseEntity.paymentInitiationResponse);
                if (fromPaymentInitiationResponse == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, fromPaymentInitiationResponse);
                }
                supportSQLiteStatement.bindLong(5, paymentInitiationResponseEntity.handled ? 1 : 0);
                supportSQLiteStatement.bindLong(6, paymentInitiationResponseEntity.f40126id);
            }
        };
        this.__preparedStmtOfDeleteByPaymentSessionEntityUuid = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM payment_initiation_responses WHERE payment_session_uuid = (?);";
            }
        };
    }

    public void deleteByPaymentSessionEntityUuid(String str) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByPaymentSessionEntityUuid.acquire();
        this.__db.beginTransaction();
        if (str == null) {
            try {
                acquire.bindNull(1);
            } catch (Throwable th2) {
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByPaymentSessionEntityUuid.release(acquire);
                throw th2;
            }
        } else {
            acquire.bindString(1, str);
        }
        acquire.executeUpdateDelete();
        this.__db.setTransactionSuccessful();
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByPaymentSessionEntityUuid.release(acquire);
    }

    public PaymentInitiationResponseEntity findLatestByPaymentSessionEntityUuid(String str) {
        PaymentInitiationResponseEntity paymentInitiationResponseEntity;
        boolean z11 = true;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM payment_initiation_responses WHERE payment_session_uuid = (?) ORDER BY id DESC LIMIT 1;", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("id");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payment_session_uuid");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("payment_method_json");
            int columnIndexOrThrow4 = query.getColumnIndexOrThrow("payment_initiation_response_json");
            int columnIndexOrThrow5 = query.getColumnIndexOrThrow(InstabugDbContract.CrashEntry.COLUMN_HANDLED);
            if (query.moveToFirst()) {
                paymentInitiationResponseEntity = new PaymentInitiationResponseEntity();
                paymentInitiationResponseEntity.f40126id = query.getLong(columnIndexOrThrow);
                paymentInitiationResponseEntity.paymentSessionUuid = query.getString(columnIndexOrThrow2);
                paymentInitiationResponseEntity.paymentMethod = this.__paymentMethodConverter.toPaymentMethod(query.getString(columnIndexOrThrow3));
                paymentInitiationResponseEntity.paymentInitiationResponse = this.__paymentInitiationResponseConverter.toPaymentInitiationResponse(query.getString(columnIndexOrThrow4));
                if (query.getInt(columnIndexOrThrow5) == 0) {
                    z11 = false;
                }
                paymentInitiationResponseEntity.handled = z11;
            } else {
                paymentInitiationResponseEntity = null;
            }
            return paymentInitiationResponseEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insert(PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPaymentInitiationResponseEntity.insert(paymentInitiationResponseEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPaymentInitiationResponseEntity.handle(paymentInitiationResponseEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
