package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.HostProvider;
import com.adyen.checkout.base.internal.JsonDecodable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public final class PaymentSessionImpl extends JsonDecodable implements PaymentSession {
    @NonNull
    public static final Parcelable.Creator<PaymentSessionImpl> CREATOR = new JsonObject.DefaultCreator(PaymentSessionImpl.class);
    private static final String KEY_CHECKOUTSHOPPER_BASE_URL = "checkoutshopperBaseUrl";
    private static final String KEY_DISABLE_RECURRING_DETAIL_URL = "disableRecurringDetailUrl";
    private static final String KEY_ENVIRONMENT = "environment";
    private static final String KEY_GENERATIONTIME = "generationtime";
    private static final String KEY_INITIATION_URL = "initiationUrl";
    private static final String KEY_ONE_CLICK_PAYMENT_METHODS = "oneClickPaymentMethods";
    private static final String KEY_PAYMENT = "payment";
    private static final String KEY_PAYMENT_DATA = "paymentData";
    private static final String KEY_PAYMENT_METHODS = "paymentMethods";
    private static final String KEY_PUBLIC_KEY = "publicKey";
    private final String mCheckoutshopperBaseUrl;
    private final String mDisableRecurringDetailUrl;
    private final String mEnvironment;
    private final Date mGenerationTime = c(KEY_GENERATIONTIME);
    private final String mInitiationUrl;
    private final List<PaymentMethodImpl> mOneClickPaymentMethods;
    private final PaymentImpl mPayment;
    private final String mPaymentData;
    private final List<PaymentMethodImpl> mPaymentMethods;
    private final String mPublicKey;

    public static final class LogoApiHostProvider implements HostProvider {
        private final String mUrl;

        @NonNull
        public String getUrl() {
            return this.mUrl;
        }

        private LogoApiHostProvider(@NonNull String str) {
            this.mUrl = str.substring(0, str.lastIndexOf("checkoutshopper"));
        }
    }

    private PaymentSessionImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mCheckoutshopperBaseUrl = jSONObject.getString(KEY_CHECKOUTSHOPPER_BASE_URL);
        this.mInitiationUrl = jSONObject.getString(KEY_INITIATION_URL);
        this.mDisableRecurringDetailUrl = jSONObject.getString(KEY_DISABLE_RECURRING_DETAIL_URL);
        this.mPaymentData = jSONObject.getString(KEY_PAYMENT_DATA);
        this.mPayment = (PaymentImpl) b("payment", PaymentImpl.class);
        this.mEnvironment = jSONObject.optString("environment");
        Class<PaymentMethodImpl> cls = PaymentMethodImpl.class;
        this.mPaymentMethods = e(KEY_PAYMENT_METHODS, cls);
        this.mPublicKey = jSONObject.optString("publicKey", (String) null);
        this.mOneClickPaymentMethods = g(KEY_ONE_CLICK_PAYMENT_METHODS, cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0020, code lost:
        return (com.adyen.checkout.core.internal.model.PaymentSessionImpl) com.adyen.checkout.base.internal.Base64Coder.decode(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        throw new com.adyen.checkout.core.CheckoutException.Builder("Error parsing payment session data.", r3).setFatal(true).build();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x001a */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.adyen.checkout.core.internal.model.PaymentSessionImpl decode(@androidx.annotation.NonNull java.lang.String r3) throws com.adyen.checkout.core.CheckoutException {
        /*
            java.lang.Class<com.adyen.checkout.core.internal.model.PaymentSessionImpl> r0 = com.adyen.checkout.core.internal.model.PaymentSessionImpl.class
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            r1.<init>((java.lang.String) r3)     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            java.lang.Class<com.adyen.checkout.core.internal.model.PaymentSessionResponse> r2 = com.adyen.checkout.core.internal.model.PaymentSessionResponse.class
            com.adyen.checkout.base.internal.JsonObject r1 = com.adyen.checkout.base.internal.JsonObject.parseFrom(r1, r2)     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            com.adyen.checkout.core.internal.model.PaymentSessionResponse r1 = (com.adyen.checkout.core.internal.model.PaymentSessionResponse) r1     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            java.lang.String r1 = r1.getPaymentSession()     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            com.adyen.checkout.base.internal.JsonDecodable r1 = com.adyen.checkout.base.internal.Base64Coder.decode(r1, r0)     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            com.adyen.checkout.core.internal.model.PaymentSessionImpl r1 = (com.adyen.checkout.core.internal.model.PaymentSessionImpl) r1     // Catch:{ IllegalArgumentException | JSONException -> 0x001a }
            return r1
        L_0x001a:
            com.adyen.checkout.base.internal.JsonDecodable r3 = com.adyen.checkout.base.internal.Base64Coder.decode(r3, r0)     // Catch:{ IllegalArgumentException -> 0x0023, JSONException -> 0x0021 }
            com.adyen.checkout.core.internal.model.PaymentSessionImpl r3 = (com.adyen.checkout.core.internal.model.PaymentSessionImpl) r3     // Catch:{ IllegalArgumentException -> 0x0023, JSONException -> 0x0021 }
            return r3
        L_0x0021:
            r3 = move-exception
            goto L_0x0024
        L_0x0023:
            r3 = move-exception
        L_0x0024:
            com.adyen.checkout.core.CheckoutException$Builder r0 = new com.adyen.checkout.core.CheckoutException$Builder
            java.lang.String r1 = "Error parsing payment session data."
            r0.<init>(r1, r3)
            r3 = 1
            com.adyen.checkout.core.CheckoutException$Builder r3 = r0.setFatal(r3)
            com.adyen.checkout.core.CheckoutException r3 = r3.build()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.core.internal.model.PaymentSessionImpl.decode(java.lang.String):com.adyen.checkout.core.internal.model.PaymentSessionImpl");
    }

    @NonNull
    public PaymentSessionImpl copyByRemovingOneClickPaymentMethod(@NonNull PaymentMethodImpl paymentMethodImpl) {
        String str;
        String str2;
        try {
            JSONObject a11 = a();
            Iterator<String> keys = a11.keys();
            JSONObject jSONObject = new JSONObject();
            while (keys.hasNext()) {
                String next = keys.next();
                if (KEY_ONE_CLICK_PAYMENT_METHODS.equals(next)) {
                    JSONArray jSONArray = a11.getJSONArray(next);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                        if (!(jSONObject2 instanceof JSONObject)) {
                            str = jSONObject2.toString();
                        } else {
                            str = JSONObjectInstrumentation.toString(jSONObject2);
                        }
                        JSONObject serialize = JsonObject.serialize(paymentMethodImpl);
                        if (!(serialize instanceof JSONObject)) {
                            str2 = serialize.toString();
                        } else {
                            str2 = JSONObjectInstrumentation.toString(serialize);
                        }
                        if (!str.equals(str2)) {
                            jSONArray2.put((Object) jSONObject2);
                        }
                    }
                    jSONObject.put(next, (Object) jSONArray2);
                } else {
                    jSONObject.put(next, a11.get(next));
                }
            }
            return new PaymentSessionImpl(jSONObject);
        } catch (JSONException unused) {
            throw new RuntimeException("Invalid JSON.");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentSessionImpl.class != obj.getClass()) {
            return false;
        }
        PaymentSessionImpl paymentSessionImpl = (PaymentSessionImpl) obj;
        Date date = this.mGenerationTime;
        if (date == null ? paymentSessionImpl.mGenerationTime != null : !date.equals(paymentSessionImpl.mGenerationTime)) {
            return false;
        }
        String str = this.mCheckoutshopperBaseUrl;
        if (str == null ? paymentSessionImpl.mCheckoutshopperBaseUrl != null : !str.equals(paymentSessionImpl.mCheckoutshopperBaseUrl)) {
            return false;
        }
        String str2 = this.mInitiationUrl;
        if (str2 == null ? paymentSessionImpl.mInitiationUrl != null : !str2.equals(paymentSessionImpl.mInitiationUrl)) {
            return false;
        }
        String str3 = this.mDisableRecurringDetailUrl;
        if (str3 == null ? paymentSessionImpl.mDisableRecurringDetailUrl != null : !str3.equals(paymentSessionImpl.mDisableRecurringDetailUrl)) {
            return false;
        }
        String str4 = this.mPaymentData;
        if (str4 == null ? paymentSessionImpl.mPaymentData != null : !str4.equals(paymentSessionImpl.mPaymentData)) {
            return false;
        }
        PaymentImpl paymentImpl = this.mPayment;
        if (paymentImpl == null ? paymentSessionImpl.mPayment != null : !paymentImpl.equals(paymentSessionImpl.mPayment)) {
            return false;
        }
        String str5 = this.mEnvironment;
        if (str5 == null ? paymentSessionImpl.mEnvironment != null : !str5.equals(paymentSessionImpl.mEnvironment)) {
            return false;
        }
        String str6 = this.mPublicKey;
        if (str6 == null ? paymentSessionImpl.mPublicKey != null : !str6.equals(paymentSessionImpl.mPublicKey)) {
            return false;
        }
        List<PaymentMethodImpl> list = this.mPaymentMethods;
        if (list == null ? paymentSessionImpl.mPaymentMethods != null : !list.equals(paymentSessionImpl.mPaymentMethods)) {
            return false;
        }
        List<PaymentMethodImpl> list2 = this.mOneClickPaymentMethods;
        List<PaymentMethodImpl> list3 = paymentSessionImpl.mOneClickPaymentMethods;
        if (list2 != null) {
            return list2.equals(list3);
        }
        if (list3 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getCheckoutshopperBaseUrl() {
        return this.mCheckoutshopperBaseUrl;
    }

    @NonNull
    public String getDisableRecurringDetailUrl() {
        return this.mDisableRecurringDetailUrl;
    }

    @Nullable
    public String getEnvironment() {
        return this.mEnvironment;
    }

    @NonNull
    public Date getGenerationTime() {
        return this.mGenerationTime;
    }

    @NonNull
    public String getInitiationUrl() {
        return this.mInitiationUrl;
    }

    @NonNull
    public HostProvider getLogoApiHostProvider() {
        return new LogoApiHostProvider(this.mCheckoutshopperBaseUrl);
    }

    @Nullable
    public List<PaymentMethodImpl> getOneClickPaymentMethodImpls() {
        return this.mOneClickPaymentMethods;
    }

    @Nullable
    public List<PaymentMethod> getOneClickPaymentMethods() {
        if (this.mOneClickPaymentMethods != null) {
            return new ArrayList(this.mOneClickPaymentMethods);
        }
        return null;
    }

    @NonNull
    public String getPaymentData() {
        return this.mPaymentData;
    }

    @NonNull
    public List<PaymentMethodImpl> getPaymentMethodImpls() {
        return this.mPaymentMethods;
    }

    @NonNull
    public List<PaymentMethod> getPaymentMethods() {
        return new ArrayList(this.mPaymentMethods);
    }

    @Nullable
    public String getPublicKey() {
        return this.mPublicKey;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Date date = this.mGenerationTime;
        int i21 = 0;
        if (date != null) {
            i11 = date.hashCode();
        } else {
            i11 = 0;
        }
        int i22 = i11 * 31;
        String str = this.mCheckoutshopperBaseUrl;
        if (str != null) {
            i12 = str.hashCode();
        } else {
            i12 = 0;
        }
        int i23 = (i22 + i12) * 31;
        String str2 = this.mInitiationUrl;
        if (str2 != null) {
            i13 = str2.hashCode();
        } else {
            i13 = 0;
        }
        int i24 = (i23 + i13) * 31;
        String str3 = this.mDisableRecurringDetailUrl;
        if (str3 != null) {
            i14 = str3.hashCode();
        } else {
            i14 = 0;
        }
        int i25 = (i24 + i14) * 31;
        String str4 = this.mPaymentData;
        if (str4 != null) {
            i15 = str4.hashCode();
        } else {
            i15 = 0;
        }
        int i26 = (i25 + i15) * 31;
        PaymentImpl paymentImpl = this.mPayment;
        if (paymentImpl != null) {
            i16 = paymentImpl.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str5 = this.mEnvironment;
        if (str5 != null) {
            i17 = str5.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str6 = this.mPublicKey;
        if (str6 != null) {
            i18 = str6.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        List<PaymentMethodImpl> list = this.mPaymentMethods;
        if (list != null) {
            i19 = list.hashCode();
        } else {
            i19 = 0;
        }
        int i31 = (i29 + i19) * 31;
        List<PaymentMethodImpl> list2 = this.mOneClickPaymentMethods;
        if (list2 != null) {
            i21 = list2.hashCode();
        }
        return i31 + i21;
    }

    @NonNull
    public PaymentImpl getPayment() {
        return this.mPayment;
    }
}
