package com.adyen.checkout.core.internal.persistence;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Query;

@Dao
interface PaymentInitiationResponseDao extends BaseDao<PaymentInitiationResponseEntity> {
    @Query("DELETE FROM payment_initiation_responses WHERE payment_session_uuid = (:paymentSessionUuid);")
    void deleteByPaymentSessionEntityUuid(@NonNull String str);

    @Nullable
    @Query("SELECT * FROM payment_initiation_responses WHERE payment_session_uuid = (:paymentSessionEntityUuid) ORDER BY id DESC LIMIT 1;")
    PaymentInitiationResponseEntity findLatestByPaymentSessionEntityUuid(@NonNull String str);
}
