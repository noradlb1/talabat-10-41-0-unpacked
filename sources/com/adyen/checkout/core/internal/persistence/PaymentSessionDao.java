package com.adyen.checkout.core.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
interface PaymentSessionDao extends BaseDao<PaymentSessionEntity> {
    @Query("DELETE FROM payment_sessions WHERE uuid = (:uuid);")
    void deleteByUuid(@NonNull String str);

    @Nullable
    @Query("SELECT * FROM payment_sessions WHERE uuid = (:uuid);")
    PaymentSessionEntity findByUuid(@NonNull String str);
}
