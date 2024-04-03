package com.adyen.checkout.core.internal.model;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.AdditionalDetails;
import com.adyen.checkout.core.AuthenticationDetails;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.PaymentResult;
import com.adyen.checkout.core.RedirectDetails;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.Authentication;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentResultCode;
import com.adyen.checkout.core.model.RedirectData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentInitiationResponse extends JsonObject {
    @NonNull
    public static final JsonObject.Creator<PaymentInitiationResponse> CREATOR = new JsonObject.DefaultCreator(PaymentInitiationResponse.class);
    private static final String KEY_TYPE = "type";
    private final AuthenticationFields mAuthenticationFields;
    private final CompleteFields mCompleteFields;
    private final DetailFields mDetailFields;
    private final ErrorFields mErrorFields;
    private final RedirectFields mRedirectFields;
    private final Type mType;

    /* renamed from: com.adyen.checkout.core.internal.model.PaymentInitiationResponse$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40121a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type[] r0 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40121a = r0
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40121a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.DETAILS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f40121a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.REDIRECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f40121a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.IDENTIFY_SHOPPER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f40121a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.CHALLENGE_SHOPPER     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f40121a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.ERROR     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f40121a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.adyen.checkout.core.internal.model.PaymentInitiationResponse$Type r1 = com.adyen.checkout.core.internal.model.PaymentInitiationResponse.Type.VALIDATION     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.core.internal.model.PaymentInitiationResponse.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class AuthenticationFields extends JsonObject implements AuthenticationDetails {
        public static final Parcelable.Creator<AuthenticationFields> CREATOR = new JsonObject.DefaultCreator(AuthenticationFields.class);
        private static final String KEY_AUTHENTICATION = "authentication";
        private static final String KEY_PAYMENT_DATA = "paymentData";
        private static final String KEY_PAYMENT_METHOD = "paymentMethod";
        private static final String KEY_RESPONSE_DETAILS = "responseDetails";
        private static final String KEY_RESULT_CODE = "resultCode";
        private final JSONObject mAuthentication;
        private final String mPaymentData;
        private final PaymentMethodBase mPaymentMethod;
        private final List<InputDetailImpl> mResponseDetails;
        private final PaymentResultCode mResultCode;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AuthenticationFields)) {
                return false;
            }
            AuthenticationFields authenticationFields = (AuthenticationFields) obj;
            JSONObject jSONObject = this.mAuthentication;
            if (jSONObject == null ? authenticationFields.mAuthentication != null : !jSONObject.equals(authenticationFields.mAuthentication)) {
                return false;
            }
            String str = this.mPaymentData;
            if (str == null ? authenticationFields.mPaymentData != null : !str.equals(authenticationFields.mPaymentData)) {
                return false;
            }
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            if (paymentMethodBase == null ? authenticationFields.mPaymentMethod != null : !paymentMethodBase.equals(authenticationFields.mPaymentMethod)) {
                return false;
            }
            List<InputDetailImpl> list = this.mResponseDetails;
            if (list == null ? authenticationFields.mResponseDetails != null : !list.equals(authenticationFields.mResponseDetails)) {
                return false;
            }
            if (this.mResultCode == authenticationFields.mResultCode) {
                return true;
            }
            return false;
        }

        @NonNull
        public <T extends Authentication> T getAuthentication(@NonNull Class<T> cls) throws CheckoutException {
            if (cls != null) {
                return (Authentication) ProvidedBy.Util.parse(this.mAuthentication, cls);
            }
            throw new CheckoutException.Builder("No Authentication is available.", (Throwable) null).build();
        }

        @NonNull
        public List<InputDetail> getInputDetails() {
            return new ArrayList(this.mResponseDetails);
        }

        @NonNull
        public String getPaymentData() {
            return this.mPaymentData;
        }

        @NonNull
        public String getPaymentMethodType() {
            return this.mPaymentMethod.getType();
        }

        @NonNull
        public PaymentResultCode getResultCode() {
            return this.mResultCode;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            int i14;
            JSONObject jSONObject = this.mAuthentication;
            int i15 = 0;
            if (jSONObject != null) {
                i11 = jSONObject.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = i11 * 31;
            String str = this.mPaymentData;
            if (str != null) {
                i12 = str.hashCode();
            } else {
                i12 = 0;
            }
            int i17 = (i16 + i12) * 31;
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            if (paymentMethodBase != null) {
                i13 = paymentMethodBase.hashCode();
            } else {
                i13 = 0;
            }
            int i18 = (i17 + i13) * 31;
            List<InputDetailImpl> list = this.mResponseDetails;
            if (list != null) {
                i14 = list.hashCode();
            } else {
                i14 = 0;
            }
            int i19 = (i18 + i14) * 31;
            PaymentResultCode paymentResultCode = this.mResultCode;
            if (paymentResultCode != null) {
                i15 = paymentResultCode.hashCode();
            }
            return i19 + i15;
        }
    }

    public static final class CompleteFields extends JsonObject implements PaymentResult {
        @NonNull
        public static final Parcelable.Creator<CompleteFields> CREATOR = new JsonObject.DefaultCreator(CompleteFields.class);
        private static final String KEY_PAYLOAD = "payload";
        private static final String KEY_PAYMENT_METHOD = "paymentMethod";
        private static final String KEY_RESULT_CODE = "resultCode";
        private final String mPayload;
        private final PaymentMethodBase mPaymentMethod = ((PaymentMethodBase) f(KEY_PAYMENT_METHOD, PaymentMethodBase.class));
        private final PaymentResultCode mResultCode = ((PaymentResultCode) d("resultCode", PaymentResultCode.class));

        private CompleteFields(@NonNull JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            this.mPayload = jSONObject.getString(KEY_PAYLOAD);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || CompleteFields.class != obj.getClass()) {
                return false;
            }
            CompleteFields completeFields = (CompleteFields) obj;
            String str = this.mPayload;
            if (str == null ? completeFields.mPayload != null : !str.equals(completeFields.mPayload)) {
                return false;
            }
            if (this.mResultCode != completeFields.mResultCode) {
                return false;
            }
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            PaymentMethodBase paymentMethodBase2 = completeFields.mPaymentMethod;
            if (paymentMethodBase != null) {
                return paymentMethodBase.equals(paymentMethodBase2);
            }
            if (paymentMethodBase2 == null) {
                return true;
            }
            return false;
        }

        @NonNull
        public String getPayload() {
            return this.mPayload;
        }

        @Nullable
        public PaymentMethodBase getPaymentMethod() {
            return this.mPaymentMethod;
        }

        @NonNull
        public PaymentResultCode getResultCode() {
            return this.mResultCode;
        }

        public int hashCode() {
            int i11;
            int i12;
            String str = this.mPayload;
            int i13 = 0;
            if (str != null) {
                i11 = str.hashCode();
            } else {
                i11 = 0;
            }
            int i14 = i11 * 31;
            PaymentResultCode paymentResultCode = this.mResultCode;
            if (paymentResultCode != null) {
                i12 = paymentResultCode.hashCode();
            } else {
                i12 = 0;
            }
            int i15 = (i14 + i12) * 31;
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            if (paymentMethodBase != null) {
                i13 = paymentMethodBase.hashCode();
            }
            return i15 + i13;
        }
    }

    public static final class DetailFields extends JsonObject implements AdditionalDetails {
        @NonNull
        public static final Parcelable.Creator<DetailFields> CREATOR = new JsonObject.DefaultCreator(DetailFields.class);
        private static final String KEY_PAYMENT_METHOD = "paymentMethod";
        private static final String KEY_PAYMENT_METHOD_RETURN_DATA = "paymentMethodReturnData";
        private static final String KEY_REDIRECT_DATA = "redirectData";
        private static final String KEY_RESPONSE_DETAILS = "responseDetails";
        private final PaymentMethodBase mPaymentMethod;
        private final String mPaymentMethodReturnData;
        private final JSONObject mRedirectData;
        private final List<InputDetailImpl> mResponseDetails = e(KEY_RESPONSE_DETAILS, InputDetailImpl.class);

        private DetailFields(@NonNull JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            this.mPaymentMethod = (PaymentMethodBase) JsonObject.parseFrom(jSONObject.getJSONObject(KEY_PAYMENT_METHOD), PaymentMethodBase.class);
            this.mPaymentMethodReturnData = jSONObject.optString(KEY_PAYMENT_METHOD_RETURN_DATA);
            this.mRedirectData = jSONObject.getJSONObject(KEY_REDIRECT_DATA);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || DetailFields.class != obj.getClass()) {
                return false;
            }
            DetailFields detailFields = (DetailFields) obj;
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            if (paymentMethodBase == null ? detailFields.mPaymentMethod != null : !paymentMethodBase.equals(detailFields.mPaymentMethod)) {
                return false;
            }
            String str = this.mPaymentMethodReturnData;
            if (str == null ? detailFields.mPaymentMethodReturnData != null : !str.equals(detailFields.mPaymentMethodReturnData)) {
                return false;
            }
            JSONObject jSONObject = this.mRedirectData;
            if (jSONObject == null ? detailFields.mRedirectData != null : !jSONObject.equals(detailFields.mRedirectData)) {
                return false;
            }
            List<InputDetailImpl> list = this.mResponseDetails;
            List<InputDetailImpl> list2 = detailFields.mResponseDetails;
            if (list != null) {
                return list.equals(list2);
            }
            if (list2 == null) {
                return true;
            }
            return false;
        }

        @NonNull
        public List<InputDetail> getInputDetails() {
            ArrayList arrayList = new ArrayList();
            for (InputDetail next : this.mResponseDetails) {
                String key = next.getKey();
                boolean z11 = !this.mRedirectData.has(key);
                boolean z12 = !KEY_PAYMENT_METHOD_RETURN_DATA.equals(key);
                if (z11 && z12) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }

        @NonNull
        public PaymentMethodBase getPaymentMethod() {
            return this.mPaymentMethod;
        }

        @Nullable
        public String getPaymentMethodReturnData() {
            return this.mPaymentMethodReturnData;
        }

        @NonNull
        public String getPaymentMethodType() {
            return this.mPaymentMethod.getType();
        }

        @NonNull
        public <T extends RedirectData> T getRedirectData(@NonNull Class<T> cls) throws CheckoutException {
            JSONObject jSONObject = this.mRedirectData;
            if (jSONObject != null) {
                return (RedirectData) ProvidedBy.Util.parse(jSONObject, cls);
            }
            throw new CheckoutException.Builder("No RedirectData is available.", (Throwable) null).build();
        }

        @NonNull
        public List<InputDetailImpl> getResponseDetails() {
            return this.mResponseDetails;
        }

        public int hashCode() {
            int i11;
            int i12;
            int i13;
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            int i14 = 0;
            if (paymentMethodBase != null) {
                i11 = paymentMethodBase.hashCode();
            } else {
                i11 = 0;
            }
            int i15 = i11 * 31;
            String str = this.mPaymentMethodReturnData;
            if (str != null) {
                i12 = str.hashCode();
            } else {
                i12 = 0;
            }
            int i16 = (i15 + i12) * 31;
            JSONObject jSONObject = this.mRedirectData;
            if (jSONObject != null) {
                i13 = jSONObject.hashCode();
            } else {
                i13 = 0;
            }
            int i17 = (i16 + i13) * 31;
            List<InputDetailImpl> list = this.mResponseDetails;
            if (list != null) {
                i14 = list.hashCode();
            }
            return i17 + i14;
        }
    }

    public enum ErrorCode {
        EMPTY_REQUEST,
        PAYLOAD_NOT_PROVIDED,
        INVALID_PAYLOAD,
        PAYMENT_METHOD_DATA_NOT_PROVIDED,
        INVALID_PAYMENT_METHOD_DATA,
        INVALID_PAYMENT_METHOD_DETAILS,
        PAYMENT_SESSION_EXPIRED,
        NOT_ALLOWED,
        INCOMPLETE_PAYMENTS_REQUEST,
        INVALID_EXPIRY_DATE,
        INVALID_SECURITY_CODE_LENGTH,
        INVALID_BIC,
        ISSUER_NOT_PROVIDED,
        INTERNAL_ERROR,
        PAYMENT_ERROR
    }

    public static final class ErrorFields extends JsonObject {
        @NonNull
        public static final JsonObject.Creator<ErrorFields> CREATOR = new JsonObject.DefaultCreator(ErrorFields.class);
        private static final String KEY_ERROR_CODE = "errorCode";
        private static final String KEY_ERROR_MESSAGE = "errorMessage";
        private static final String KEY_PAYLOAD = "payload";
        private final ErrorCode mErrorCode = ((ErrorCode) d("errorCode", ErrorCode.class));
        private final String mErrorMessage;
        private final String mPayload;

        public ErrorFields(@NonNull JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            this.mErrorMessage = jSONObject.getString("errorMessage");
            this.mPayload = jSONObject.optString(KEY_PAYLOAD, (String) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ErrorFields.class != obj.getClass()) {
                return false;
            }
            ErrorFields errorFields = (ErrorFields) obj;
            String str = this.mErrorMessage;
            if (str == null ? errorFields.mErrorMessage != null : !str.equals(errorFields.mErrorMessage)) {
                return false;
            }
            if (this.mErrorCode != errorFields.mErrorCode) {
                return false;
            }
            String str2 = this.mPayload;
            String str3 = errorFields.mPayload;
            if (str2 != null) {
                return str2.equals(str3);
            }
            if (str3 == null) {
                return true;
            }
            return false;
        }

        @Nullable
        public ErrorCode getErrorCode() {
            return this.mErrorCode;
        }

        @NonNull
        public String getErrorMessage() {
            return this.mErrorMessage;
        }

        @Nullable
        public String getPayload() {
            return this.mPayload;
        }

        public int hashCode() {
            int i11;
            int i12;
            String str = this.mErrorMessage;
            int i13 = 0;
            if (str != null) {
                i11 = str.hashCode();
            } else {
                i11 = 0;
            }
            int i14 = i11 * 31;
            ErrorCode errorCode = this.mErrorCode;
            if (errorCode != null) {
                i12 = errorCode.hashCode();
            } else {
                i12 = 0;
            }
            int i15 = (i14 + i12) * 31;
            String str2 = this.mPayload;
            if (str2 != null) {
                i13 = str2.hashCode();
            }
            return i15 + i13;
        }
    }

    public static final class RedirectFields extends JsonObject implements RedirectDetails {
        @NonNull
        public static final Parcelable.Creator<RedirectFields> CREATOR = new JsonObject.DefaultCreator(RedirectFields.class);
        private static final String KEY_PAYMENT_METHOD = "paymentMethod";
        private static final String KEY_SUBMIT_PAYMENT_METHOD_RETURN_DATA = "submitPaymentMethodReturnData";
        private static final String KEY_URL = "url";
        private final PaymentMethodBase mPaymentMethod;
        private final Boolean mSubmitPaymentMethodReturnData;
        private final String mUrl;

        private RedirectFields(@NonNull JSONObject jSONObject) throws JSONException {
            super(jSONObject);
            Boolean bool;
            this.mPaymentMethod = (PaymentMethodBase) JsonObject.parseFrom(jSONObject.getJSONObject(KEY_PAYMENT_METHOD), PaymentMethodBase.class);
            this.mUrl = jSONObject.getString("url");
            if (jSONObject.has(KEY_SUBMIT_PAYMENT_METHOD_RETURN_DATA)) {
                bool = Boolean.valueOf(jSONObject.getBoolean(KEY_SUBMIT_PAYMENT_METHOD_RETURN_DATA));
            } else {
                bool = null;
            }
            this.mSubmitPaymentMethodReturnData = bool;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || RedirectFields.class != obj.getClass()) {
                return false;
            }
            RedirectFields redirectFields = (RedirectFields) obj;
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            if (paymentMethodBase == null ? redirectFields.mPaymentMethod != null : !paymentMethodBase.equals(redirectFields.mPaymentMethod)) {
                return false;
            }
            String str = this.mUrl;
            if (str == null ? redirectFields.mUrl != null : !str.equals(redirectFields.mUrl)) {
                return false;
            }
            Boolean bool = this.mSubmitPaymentMethodReturnData;
            Boolean bool2 = redirectFields.mSubmitPaymentMethodReturnData;
            if (bool != null) {
                return bool.equals(bool2);
            }
            if (bool2 == null) {
                return true;
            }
            return false;
        }

        @NonNull
        public PaymentMethodBase getPaymentMethod() {
            return this.mPaymentMethod;
        }

        @NonNull
        public Uri getUri() {
            return Uri.parse(this.mUrl);
        }

        @NonNull
        public String getUrl() {
            return this.mUrl;
        }

        public int hashCode() {
            int i11;
            int i12;
            PaymentMethodBase paymentMethodBase = this.mPaymentMethod;
            int i13 = 0;
            if (paymentMethodBase != null) {
                i11 = paymentMethodBase.hashCode();
            } else {
                i11 = 0;
            }
            int i14 = i11 * 31;
            String str = this.mUrl;
            if (str != null) {
                i12 = str.hashCode();
            } else {
                i12 = 0;
            }
            int i15 = (i14 + i12) * 31;
            Boolean bool = this.mSubmitPaymentMethodReturnData;
            if (bool != null) {
                i13 = bool.hashCode();
            }
            return i15 + i13;
        }

        public boolean isSubmitPaymentMethodReturnData() {
            return Boolean.TRUE.equals(this.mSubmitPaymentMethodReturnData);
        }
    }

    public enum Type {
        COMPLETE,
        DETAILS,
        REDIRECT,
        IDENTIFY_SHOPPER,
        CHALLENGE_SHOPPER,
        ERROR,
        VALIDATION
    }

    private PaymentInitiationResponse(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        Type type = (Type) d("type", Type.class);
        this.mType = type;
        switch (AnonymousClass1.f40121a[type.ordinal()]) {
            case 1:
                this.mCompleteFields = (CompleteFields) JsonObject.parseFrom(jSONObject, CompleteFields.class);
                this.mAuthenticationFields = null;
                this.mDetailFields = null;
                this.mRedirectFields = null;
                this.mErrorFields = null;
                return;
            case 2:
                this.mCompleteFields = null;
                this.mAuthenticationFields = null;
                this.mDetailFields = (DetailFields) JsonObject.parseFrom(jSONObject, DetailFields.class);
                this.mRedirectFields = null;
                this.mErrorFields = null;
                return;
            case 3:
                this.mCompleteFields = null;
                this.mAuthenticationFields = null;
                this.mDetailFields = null;
                this.mRedirectFields = (RedirectFields) JsonObject.parseFrom(jSONObject, RedirectFields.class);
                this.mErrorFields = null;
                return;
            case 4:
            case 5:
                this.mCompleteFields = null;
                this.mAuthenticationFields = (AuthenticationFields) JsonObject.parseFrom(jSONObject, AuthenticationFields.class);
                this.mDetailFields = null;
                this.mRedirectFields = null;
                this.mErrorFields = null;
                return;
            case 6:
            case 7:
                this.mCompleteFields = null;
                this.mAuthenticationFields = null;
                this.mDetailFields = null;
                this.mRedirectFields = null;
                this.mErrorFields = (ErrorFields) JsonObject.parseFrom(jSONObject, ErrorFields.class);
                return;
            default:
                throw new RuntimeException("Unknown type: " + type);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentInitiationResponse.class != obj.getClass()) {
            return false;
        }
        PaymentInitiationResponse paymentInitiationResponse = (PaymentInitiationResponse) obj;
        if (this.mType != paymentInitiationResponse.mType) {
            return false;
        }
        CompleteFields completeFields = this.mCompleteFields;
        if (completeFields == null ? paymentInitiationResponse.mCompleteFields != null : !completeFields.equals(paymentInitiationResponse.mCompleteFields)) {
            return false;
        }
        AuthenticationFields authenticationFields = this.mAuthenticationFields;
        if (authenticationFields == null ? paymentInitiationResponse.mAuthenticationFields != null : !authenticationFields.equals(paymentInitiationResponse.mAuthenticationFields)) {
            return false;
        }
        DetailFields detailFields = this.mDetailFields;
        if (detailFields == null ? paymentInitiationResponse.mDetailFields != null : !detailFields.equals(paymentInitiationResponse.mDetailFields)) {
            return false;
        }
        RedirectFields redirectFields = this.mRedirectFields;
        if (redirectFields == null ? paymentInitiationResponse.mRedirectFields != null : !redirectFields.equals(paymentInitiationResponse.mRedirectFields)) {
            return false;
        }
        ErrorFields errorFields = this.mErrorFields;
        ErrorFields errorFields2 = paymentInitiationResponse.mErrorFields;
        if (errorFields != null) {
            return errorFields.equals(errorFields2);
        }
        if (errorFields2 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public AuthenticationFields getAuthenticationFields() {
        return this.mAuthenticationFields;
    }

    @Nullable
    public CompleteFields getCompleteFields() {
        return this.mCompleteFields;
    }

    @Nullable
    public DetailFields getDetailFields() {
        return this.mDetailFields;
    }

    @Nullable
    public ErrorFields getErrorFields() {
        return this.mErrorFields;
    }

    @Nullable
    public RedirectFields getRedirectFields() {
        return this.mRedirectFields;
    }

    @NonNull
    public Type getType() {
        return this.mType;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        Type type = this.mType;
        int i15 = 0;
        if (type != null) {
            i11 = type.hashCode();
        } else {
            i11 = 0;
        }
        int i16 = i11 * 31;
        CompleteFields completeFields = this.mCompleteFields;
        if (completeFields != null) {
            i12 = completeFields.hashCode();
        } else {
            i12 = 0;
        }
        int i17 = (i16 + i12) * 31;
        DetailFields detailFields = this.mDetailFields;
        if (detailFields != null) {
            i13 = detailFields.hashCode();
        } else {
            i13 = 0;
        }
        int i18 = (i17 + i13) * 31;
        RedirectFields redirectFields = this.mRedirectFields;
        if (redirectFields != null) {
            i14 = redirectFields.hashCode();
        } else {
            i14 = 0;
        }
        int i19 = (i18 + i14) * 31;
        ErrorFields errorFields = this.mErrorFields;
        if (errorFields != null) {
            i15 = errorFields.hashCode();
        }
        return i19 + i15;
    }
}
