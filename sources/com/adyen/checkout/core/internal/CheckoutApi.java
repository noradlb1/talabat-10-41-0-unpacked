package com.adyen.checkout.core.internal;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Api;
import com.adyen.checkout.base.internal.Json;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.base.internal.JsonSerializable;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.internal.model.AddressAndNameResponse;
import com.adyen.checkout.core.internal.model.GiroPayConfiguration;
import com.adyen.checkout.core.internal.model.GiroPayIssuersResponse;
import com.adyen.checkout.core.internal.model.PaymentInitiation;
import com.adyen.checkout.core.internal.model.PaymentInitiationResponse;
import com.adyen.checkout.core.internal.model.PaymentMethodDeletion;
import com.adyen.checkout.core.internal.model.PaymentMethodDeletionResponse;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.internal.model.PaymentSessionImpl;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.core.model.PersonalDetails;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import com.talabat.feature.pickup.data.events.ConstantsKt;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class CheckoutApi extends Api {
    private static CheckoutApi sInstance;

    private CheckoutApi(@NonNull Application application) {
    }

    @NonNull
    public static synchronized CheckoutApi getInstance(@NonNull Application application) {
        CheckoutApi checkoutApi;
        synchronized (CheckoutApi.class) {
            if (sInstance == null) {
                sInstance = new CheckoutApi(application);
            }
            checkoutApi = sInstance;
        }
        return checkoutApi;
    }

    /* access modifiers changed from: private */
    @NonNull
    public JSONObject post(@NonNull String str, @NonNull JsonSerializable jsonSerializable) throws IOException {
        String str2;
        try {
            Map<String, String> defaultHeaders = Json.getDefaultHeaders();
            JSONObject serialize = jsonSerializable.serialize();
            if (!(serialize instanceof JSONObject)) {
                str2 = serialize.toString();
            } else {
                str2 = JSONObjectInstrumentation.toString(serialize);
            }
            Charset charset = Api.CHARSET;
            return new JSONObject(new String(super.c(str, defaultHeaders, str2.getBytes(charset)), charset));
        } catch (JSONException e11) {
            throw new RuntimeException("Error serializing " + jsonSerializable.getClass().getSimpleName(), e11);
        }
    }

    @NonNull
    public IOException b(@Nullable byte[] bArr) {
        if (bArr != null) {
            try {
                String str = new String(bArr, Api.CHARSET);
                new JSONObject(str);
                throw new RuntimeException("Received JSON error response: " + str);
            } catch (JSONException unused) {
            }
        }
        return super.b(bArr);
    }

    @NonNull
    public Callable<PaymentMethodDeletionResponse> deletePaymentMethod(@NonNull final PaymentSessionImpl paymentSessionImpl, @NonNull PaymentMethodImpl paymentMethodImpl) {
        final PaymentMethodDeletion build = new PaymentMethodDeletion.Builder(paymentSessionImpl.getPaymentData(), paymentMethodImpl.getPaymentMethodData()).build();
        return new Callable<PaymentMethodDeletionResponse>() {
            public PaymentMethodDeletionResponse call() throws Exception {
                JSONObject d11 = CheckoutApi.this.post(paymentSessionImpl.getDisableRecurringDetailUrl(), build);
                try {
                    PaymentInitiationResponse.ErrorFields errorFields = (PaymentInitiationResponse.ErrorFields) JsonObject.parseFrom(d11, PaymentInitiationResponse.ErrorFields.class);
                    throw new CheckoutException.Builder(errorFields.getErrorMessage(), (Throwable) null).setPayload(errorFields.getPayload()).setFatal(errorFields.getErrorCode() == PaymentInitiationResponse.ErrorCode.PAYMENT_SESSION_EXPIRED).build();
                } catch (JSONException unused) {
                    return (PaymentMethodDeletionResponse) JsonObject.parseFrom(d11, PaymentMethodDeletionResponse.class);
                }
            }
        };
    }

    @NonNull
    public Callable<GiroPayIssuersResponse> getGiroPayIssuers(@NonNull final PaymentMethod paymentMethod, @NonNull final String str) {
        return new Callable<GiroPayIssuersResponse>() {
            public GiroPayIssuersResponse call() throws Exception {
                return (GiroPayIssuersResponse) JsonObject.parseFrom(CheckoutApi.this.post(((GiroPayConfiguration) paymentMethod.getConfiguration(GiroPayConfiguration.class)).getIssuersUrl(), new JsonSerializable() {
                    @NonNull
                    public JSONObject serialize() throws JSONException {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(ConstantsKt.CLICK_SEARCH_STRING, (Object) str);
                        return jSONObject;
                    }
                }), GiroPayIssuersResponse.class);
            }
        };
    }

    @NonNull
    public Callable<AddressAndNameResponse> getSsnLookup(@NonNull PaymentMethod paymentMethod, @NonNull PaymentSession paymentSession, @NonNull String str, @NonNull String str2) {
        final PaymentMethod paymentMethod2 = paymentMethod;
        final PaymentSession paymentSession2 = paymentSession;
        final String str3 = str2;
        final String str4 = str;
        return new Callable<AddressAndNameResponse>() {
            public AddressAndNameResponse call() throws Exception {
                final String paymentMethodData = ((PaymentMethodImpl) paymentMethod2).getPaymentMethodData();
                final String paymentData = ((PaymentSessionImpl) paymentSession2).getPaymentData();
                JSONObject d11 = CheckoutApi.this.post(str4, new JsonSerializable() {
                    @NonNull
                    public JSONObject serialize() throws JSONException {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("paymentData", (Object) paymentData);
                        jSONObject.put("paymentMethodData", (Object) paymentMethodData);
                        jSONObject.put(PersonalDetails.KEY_SOCIAL_SECURITY_NUMBER, (Object) str3);
                        return jSONObject;
                    }
                });
                if (d11.length() == 0) {
                    return null;
                }
                return (AddressAndNameResponse) JsonObject.parseFrom(d11, AddressAndNameResponse.class);
            }
        };
    }

    @NonNull
    public Callable<PaymentInitiationResponse> initiatePayment(@NonNull final PaymentSessionImpl paymentSessionImpl, @NonNull final PaymentInitiation paymentInitiation) {
        return new Callable<PaymentInitiationResponse>() {
            public PaymentInitiationResponse call() throws Exception {
                return (PaymentInitiationResponse) JsonObject.parseFrom(CheckoutApi.this.post(paymentSessionImpl.getInitiationUrl(), paymentInitiation), PaymentInitiationResponse.class);
            }
        };
    }
}
