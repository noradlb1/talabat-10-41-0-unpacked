package com.adyen.checkout.core.internal.model;

import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.JsonObject;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.internal.ProvidedBy;
import com.adyen.checkout.core.model.Configuration;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class PaymentMethodImpl extends PaymentMethodBase implements PaymentMethod {
    @NonNull
    public static final Parcelable.Creator<PaymentMethodImpl> CREATOR = new JsonObject.DefaultCreator(PaymentMethodImpl.class);
    private static final String KEY_CONFIGURATION = "configuration";
    private static final String KEY_GROUP = "group";
    private static final String KEY_INPUT_DETAILS = "details";
    private static final String KEY_NAME = "name";
    private static final String KEY_PAYMENT_METHOD_DATA = "paymentMethodData";
    private static final String KEY_STORED_DETAILS = "storedDetails";
    private JSONObject mConfiguration;
    private PaymentMethodImpl mGroup;
    private List<InputDetailImpl> mInputDetails = g(KEY_INPUT_DETAILS, InputDetailImpl.class);
    private String mName;
    private String mPaymentMethodData;
    private StoredDetailsImpl mStoredDetails;

    private PaymentMethodImpl(@NonNull JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        this.mName = jSONObject.getString("name");
        this.mConfiguration = jSONObject.optJSONObject(KEY_CONFIGURATION);
        this.mGroup = (PaymentMethodImpl) f("group", PaymentMethodImpl.class);
        this.mStoredDetails = (StoredDetailsImpl) f(KEY_STORED_DETAILS, StoredDetailsImpl.class);
        this.mPaymentMethodData = jSONObject.getString(KEY_PAYMENT_METHOD_DATA);
    }

    @Nullable
    public static PaymentMethod findByType(@Nullable List<PaymentMethod> list, @NonNull String str) {
        if (list == null) {
            return null;
        }
        Iterator<PaymentMethod> it = list.iterator();
        while (it.hasNext()) {
            PaymentMethod next = it.next();
            while (true) {
                if (next.getType().equals(str)) {
                    return next;
                }
                next = next.getGroup();
                if (next == null) {
                }
            }
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PaymentMethodImpl.class != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        PaymentMethodImpl paymentMethodImpl = (PaymentMethodImpl) obj;
        String str = this.mName;
        if (str == null ? paymentMethodImpl.mName != null : !str.equals(paymentMethodImpl.mName)) {
            return false;
        }
        String str2 = this.mPaymentMethodData;
        if (str2 == null ? paymentMethodImpl.mPaymentMethodData != null : !str2.equals(paymentMethodImpl.mPaymentMethodData)) {
            return false;
        }
        List<InputDetailImpl> list = this.mInputDetails;
        if (list == null ? paymentMethodImpl.mInputDetails != null : !list.equals(paymentMethodImpl.mInputDetails)) {
            return false;
        }
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject == null ? paymentMethodImpl.mConfiguration != null : !jSONObject.equals(paymentMethodImpl.mConfiguration)) {
            return false;
        }
        PaymentMethodImpl paymentMethodImpl2 = this.mGroup;
        if (paymentMethodImpl2 == null ? paymentMethodImpl.mGroup != null : !paymentMethodImpl2.equals(paymentMethodImpl.mGroup)) {
            return false;
        }
        StoredDetailsImpl storedDetailsImpl = this.mStoredDetails;
        StoredDetailsImpl storedDetailsImpl2 = paymentMethodImpl.mStoredDetails;
        if (storedDetailsImpl != null) {
            return storedDetailsImpl.equals(storedDetailsImpl2);
        }
        if (storedDetailsImpl2 == null) {
            return true;
        }
        return false;
    }

    @NonNull
    public <T extends Configuration> T getConfiguration(@NonNull Class<T> cls) throws CheckoutException {
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject != null) {
            return (Configuration) ProvidedBy.Util.parse(jSONObject, cls);
        }
        throw new CheckoutException.Builder("No Configuration is available.", (Throwable) null).build();
    }

    @Nullable
    public List<InputDetail> getInputDetails() {
        if (this.mInputDetails != null) {
            return new ArrayList(this.mInputDetails);
        }
        return null;
    }

    @NonNull
    public String getName() {
        return this.mName;
    }

    @NonNull
    public String getPaymentMethodData() {
        return this.mPaymentMethodData;
    }

    @NonNull
    public String getTxVariant() {
        return getType();
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int hashCode = super.hashCode() * 31;
        String str = this.mName;
        int i16 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i17 = (hashCode + i11) * 31;
        String str2 = this.mPaymentMethodData;
        if (str2 != null) {
            i12 = str2.hashCode();
        } else {
            i12 = 0;
        }
        int i18 = (i17 + i12) * 31;
        List<InputDetailImpl> list = this.mInputDetails;
        if (list != null) {
            i13 = list.hashCode();
        } else {
            i13 = 0;
        }
        int i19 = (i18 + i13) * 31;
        JSONObject jSONObject = this.mConfiguration;
        if (jSONObject != null) {
            i14 = jSONObject.hashCode();
        } else {
            i14 = 0;
        }
        int i21 = (i19 + i14) * 31;
        PaymentMethodImpl paymentMethodImpl = this.mGroup;
        if (paymentMethodImpl != null) {
            i15 = paymentMethodImpl.hashCode();
        } else {
            i15 = 0;
        }
        int i22 = (i21 + i15) * 31;
        StoredDetailsImpl storedDetailsImpl = this.mStoredDetails;
        if (storedDetailsImpl != null) {
            i16 = storedDetailsImpl.hashCode();
        }
        return i22 + i16;
    }

    @NonNull
    public String toString() {
        return "PaymentMethod{Name='" + this.mName + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    @Nullable
    public PaymentMethodImpl getGroup() {
        return this.mGroup;
    }

    @Nullable
    public StoredDetailsImpl getStoredDetails() {
        return this.mStoredDetails;
    }
}
