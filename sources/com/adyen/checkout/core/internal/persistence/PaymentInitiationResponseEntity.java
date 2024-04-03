package com.adyen.checkout.core.internal.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.internal.model.PaymentInitiationResponse;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"payment_session_uuid"}, entity = PaymentSessionEntity.class, onDelete = 5, onUpdate = 5, parentColumns = {"uuid"})}, indices = {@Index({"payment_session_uuid"})}, tableName = "payment_initiation_responses")
public final class PaymentInitiationResponseEntity {
    @ColumnInfo(name = "handled")
    public boolean handled;
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id  reason: collision with root package name */
    public long f40126id;
    @ColumnInfo(name = "payment_initiation_response_json")
    @NonNull
    @TypeConverters({PaymentInitiationResponseConverter.class})
    public PaymentInitiationResponse paymentInitiationResponse;
    @ColumnInfo(name = "payment_method_json")
    @NonNull
    @TypeConverters({PaymentMethodConverter.class})
    public PaymentMethodImpl paymentMethod;
    @ColumnInfo(name = "payment_session_uuid")
    @NonNull
    public String paymentSessionUuid;

    @Instrumented
    public static final class PaymentInitiationResponseConverter {
        @TypeConverter
        @NonNull
        public String fromPaymentInitiationResponse(@NonNull PaymentInitiationResponse paymentInitiationResponse) {
            JSONObject serialize = JsonObject.serialize(paymentInitiationResponse);
            return !(serialize instanceof JSONObject) ? serialize.toString() : JSONObjectInstrumentation.toString(serialize);
        }

        @TypeConverter
        @NonNull
        public PaymentInitiationResponse toPaymentInitiationResponse(@NonNull String str) {
            try {
                return (PaymentInitiationResponse) JsonObject.parseFrom(new JSONObject(str), PaymentInitiationResponse.class);
            } catch (JSONException e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    @Instrumented
    public static final class PaymentMethodConverter {
        @TypeConverter
        @NonNull
        public String fromPaymentMethod(@NonNull PaymentMethodImpl paymentMethodImpl) {
            try {
                JSONObject serialize = JsonObject.serialize(paymentMethodImpl);
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
        public PaymentMethodImpl toPaymentMethod(@NonNull String str) {
            try {
                return (PaymentMethodImpl) JsonObject.parseFrom(new JSONObject(str), PaymentMethodImpl.class);
            } catch (JSONException e11) {
                throw new RuntimeException(e11);
            }
        }
    }
}
