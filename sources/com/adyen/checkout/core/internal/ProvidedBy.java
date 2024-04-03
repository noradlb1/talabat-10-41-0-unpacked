package com.adyen.checkout.core.internal;

import androidx.annotation.NonNull;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.CheckoutException;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.json.JSONException;
import org.json.JSONObject;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProvidedBy {

    public static final class Util {
        private Util() {
            throw new IllegalStateException("No instances.");
        }

        @NonNull
        public static <T> T parse(@NonNull JSONObject jSONObject, @NonNull Class<T> cls) throws CheckoutException {
            try {
                return JsonObject.parseFrom(jSONObject, ((ProvidedBy) cls.getAnnotation(ProvidedBy.class)).value());
            } catch (Exception e11) {
                if (e11 instanceof JSONException) {
                    throw new CheckoutException.Builder("Data does not match fields of " + cls.getSimpleName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER, e11).build();
                }
                throw new RuntimeException(cls.getSimpleName() + " could not be parsed.", e11);
            }
        }
    }

    @NonNull
    Class<? extends JsonObject> value();
}
