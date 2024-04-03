package com.adyen.checkout.core.internal.persistence;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.adyen.checkout.core.internal.persistence.PaymentDatabase;
import com.adyen.checkout.core.internal.persistence.PaymentSessionEntity;

public class PaymentSessionDao_Impl implements PaymentSessionDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfPaymentSessionEntity;
    /* access modifiers changed from: private */
    public final PaymentSessionEntity.PaymentSessionConverter __paymentSessionConverter = new PaymentSessionEntity.PaymentSessionConverter();
    private final SharedSQLiteStatement __preparedStmtOfDeleteByUuid;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfPaymentSessionEntity;

    public PaymentSessionDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPaymentSessionEntity = new EntityInsertionAdapter<PaymentSessionEntity>(roomDatabase) {
            public String createQuery() {
                return "INSERT OR FAIL INTO `payment_sessions`(`uuid`,`payment_session_json`,`generation_timestamp`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PaymentSessionEntity paymentSessionEntity) {
                String str = paymentSessionEntity.uuid;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                String fromPaymentSession = PaymentSessionDao_Impl.this.__paymentSessionConverter.fromPaymentSession(paymentSessionEntity.paymentSession);
                if (fromPaymentSession == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, fromPaymentSession);
                }
                supportSQLiteStatement.bindLong(3, PaymentDatabase.DateConverter.toTimestamp(paymentSessionEntity.generationTime));
            }
        };
        this.__updateAdapterOfPaymentSessionEntity = new EntityDeletionOrUpdateAdapter<PaymentSessionEntity>(roomDatabase) {
            public String createQuery() {
                return "UPDATE OR ABORT `payment_sessions` SET `uuid` = ?,`payment_session_json` = ?,`generation_timestamp` = ? WHERE `uuid` = ?";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PaymentSessionEntity paymentSessionEntity) {
                String str = paymentSessionEntity.uuid;
                if (str == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, str);
                }
                String fromPaymentSession = PaymentSessionDao_Impl.this.__paymentSessionConverter.fromPaymentSession(paymentSessionEntity.paymentSession);
                if (fromPaymentSession == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, fromPaymentSession);
                }
                supportSQLiteStatement.bindLong(3, PaymentDatabase.DateConverter.toTimestamp(paymentSessionEntity.generationTime));
                String str2 = paymentSessionEntity.uuid;
                if (str2 == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, str2);
                }
            }
        };
        this.__preparedStmtOfDeleteByUuid = new SharedSQLiteStatement(roomDatabase) {
            public String createQuery() {
                return "DELETE FROM payment_sessions WHERE uuid = (?);";
            }
        };
    }

    public void deleteByUuid(String str) {
        SupportSQLiteStatement acquire = this.__preparedStmtOfDeleteByUuid.acquire();
        this.__db.beginTransaction();
        if (str == null) {
            try {
                acquire.bindNull(1);
            } catch (Throwable th2) {
                this.__db.endTransaction();
                this.__preparedStmtOfDeleteByUuid.release(acquire);
                throw th2;
            }
        } else {
            acquire.bindString(1, str);
        }
        acquire.executeUpdateDelete();
        this.__db.setTransactionSuccessful();
        this.__db.endTransaction();
        this.__preparedStmtOfDeleteByUuid.release(acquire);
    }

    public PaymentSessionEntity findByUuid(String str) {
        PaymentSessionEntity paymentSessionEntity;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM payment_sessions WHERE uuid = (?);", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        Cursor query = this.__db.query(acquire);
        try {
            int columnIndexOrThrow = query.getColumnIndexOrThrow("uuid");
            int columnIndexOrThrow2 = query.getColumnIndexOrThrow("payment_session_json");
            int columnIndexOrThrow3 = query.getColumnIndexOrThrow("generation_timestamp");
            if (query.moveToFirst()) {
                paymentSessionEntity = new PaymentSessionEntity();
                paymentSessionEntity.uuid = query.getString(columnIndexOrThrow);
                paymentSessionEntity.paymentSession = this.__paymentSessionConverter.toPaymentSession(query.getString(columnIndexOrThrow2));
                paymentSessionEntity.generationTime = PaymentDatabase.DateConverter.fromTimestamp(query.getLong(columnIndexOrThrow3));
            } else {
                paymentSessionEntity = null;
            }
            return paymentSessionEntity;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insert(PaymentSessionEntity paymentSessionEntity) {
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPaymentSessionEntity.insert(paymentSessionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    public void update(PaymentSessionEntity paymentSessionEntity) {
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPaymentSessionEntity.handle(paymentSessionEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
