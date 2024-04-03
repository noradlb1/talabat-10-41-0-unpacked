package com.adyen.checkout.core.internal.persistence;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class PaymentRepository {
    private static final String PAYMENT_DATABASE = "payment-database.db";
    private static PaymentRepository sInstance;
    private final ExecutorService mExecutorService = Executors.newFixedThreadPool(2);
    /* access modifiers changed from: private */
    public final PaymentDatabase mPaymentDatabase;

    private PaymentRepository(@NonNull Context context) {
        this.mPaymentDatabase = Room.databaseBuilder(context.getApplicationContext(), PaymentDatabase.class, PAYMENT_DATABASE).allowMainThreadQueries().build();
    }

    @NonNull
    public static synchronized PaymentRepository getInstance(@NonNull Context context) {
        PaymentRepository paymentRepository;
        synchronized (PaymentRepository.class) {
            if (sInstance == null) {
                sInstance = new PaymentRepository(context);
            }
            paymentRepository = sInstance;
        }
        return paymentRepository;
    }

    @Nullable
    public PaymentInitiationResponseEntity findLatestPaymentInitiationResponseEntityByPaymentSessionEntityUuid(@NonNull String str) {
        return this.mPaymentDatabase.getPaymentInitiationResponseDao().findLatestByPaymentSessionEntityUuid(str);
    }

    @Nullable
    public PaymentSessionEntity findPaymentSessionEntityByUuid(@NonNull String str) {
        return this.mPaymentDatabase.getPaymentSessionDao().findByUuid(str);
    }

    public void insertPaymentInitiationResponseEntity(@NonNull final PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                PaymentRepository.this.mPaymentDatabase.getPaymentInitiationResponseDao().insert(paymentInitiationResponseEntity);
            }
        });
    }

    public void insertPaymentSessionEntity(@NonNull final PaymentSessionEntity paymentSessionEntity) {
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                PaymentRepository.this.mPaymentDatabase.getPaymentSessionDao().insert(paymentSessionEntity);
            }
        });
    }

    public void updatePaymentInitiationResponseEntity(@NonNull final PaymentInitiationResponseEntity paymentInitiationResponseEntity) {
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                PaymentRepository.this.mPaymentDatabase.getPaymentInitiationResponseDao().update(paymentInitiationResponseEntity);
            }
        });
    }

    public void updatePaymentSessionEntity(@NonNull final PaymentSessionEntity paymentSessionEntity) {
        this.mExecutorService.submit(new Runnable() {
            public void run() {
                PaymentRepository.this.mPaymentDatabase.getPaymentSessionDao().update(paymentSessionEntity);
            }
        });
    }
}
