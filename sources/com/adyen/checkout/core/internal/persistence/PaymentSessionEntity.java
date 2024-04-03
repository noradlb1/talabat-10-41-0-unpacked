package com.adyen.checkout.core.internal.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.internal.model.PaymentSessionImpl;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

@Entity(tableName = "payment_sessions")
public final class PaymentSessionEntity {
    @ColumnInfo(name = "generation_timestamp")
    @NonNull
    public Date generationTime;
    @ColumnInfo(name = "payment_session_json")
    @NonNull
    @TypeConverters({PaymentSessionConverter.class})
    public PaymentSessionImpl paymentSession;
    @ColumnInfo(name = "uuid")
    @NonNull
    @PrimaryKey
    public String uuid;

    @Instrumented
    public static final class PaymentSessionConverter {
        @TypeConverter
        @NonNull
        public String fromPaymentSession(@NonNull PaymentSessionImpl paymentSessionImpl) {
            try {
                JSONObject serialize = JsonObject.serialize(paymentSessionImpl);
                if (!(serialize instanceof JSONObject)) {
                    return serialize.toString();
                }
                return JSONObjectInstrumentation.toString(serialize);
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }

        @TypeConverter
        @NonNull
        public PaymentSessionImpl toPaymentSession(@NonNull String str) {
            try {
                return (PaymentSessionImpl) JsonObject.parseFrom(new JSONObject(str), PaymentSessionImpl.class);
            } catch (JSONException e11) {
                throw new RuntimeException(e11);
            }
        }
    }
}
