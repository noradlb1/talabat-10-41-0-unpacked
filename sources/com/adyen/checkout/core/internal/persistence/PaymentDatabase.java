package com.adyen.checkout.core.internal.persistence;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import java.util.Date;

@Database(entities = {PaymentSessionEntity.class, PaymentInitiationResponseEntity.class}, exportSchema = false, version = 1)
@TypeConverters({DateConverter.class})
abstract class PaymentDatabase extends RoomDatabase {

    public static final class DateConverter {
        @TypeConverter
        @NonNull
        public static Date fromTimestamp(long j11) {
            return new Date(j11);
        }

        @TypeConverter
        @NonNull
        public static long toTimestamp(@NonNull Date date) {
            return date.getTime();
        }
    }

    @NonNull
    public abstract PaymentInitiationResponseDao getPaymentInitiationResponseDao();

    @NonNull
    public abstract PaymentSessionDao getPaymentSessionDao();
}
