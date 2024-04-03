package com.adyen.checkout.core.model;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Parcelables;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class OpenInvoiceDetails extends PaymentMethodDetails {
    @NonNull
    public static final String KEY_BILLING_ADDRESS = "billingAddress";
    @NonNull
    public static final String KEY_CONSENT_CHECKBOX = "consentCheckbox";
    @NonNull
    public static final String KEY_DELIVERY_ADDRESS = "deliveryAddress";
    @NonNull
    public static final String KEY_PERSONAL_DETAILS = "personalDetails";
    @NonNull
    public static final String KEY_SEPARATE_DELIVERY_ADDRESS = "separateDeliveryAddress";

    /* renamed from: b  reason: collision with root package name */
    public PersonalDetails f40138b;

    /* renamed from: c  reason: collision with root package name */
    public Address f40139c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f40140d;

    /* renamed from: e  reason: collision with root package name */
    public Address f40141e;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f40142f;

    public OpenInvoiceDetails() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OpenInvoiceDetails openInvoiceDetails = (OpenInvoiceDetails) obj;
        PersonalDetails personalDetails = this.f40138b;
        if (personalDetails == null ? openInvoiceDetails.f40138b != null : !personalDetails.equals(openInvoiceDetails.f40138b)) {
            return false;
        }
        Address address = this.f40139c;
        if (address == null ? openInvoiceDetails.f40139c != null : !address.equals(openInvoiceDetails.f40139c)) {
            return false;
        }
        Boolean bool = this.f40140d;
        if (bool == null ? openInvoiceDetails.f40140d != null : !bool.equals(openInvoiceDetails.f40140d)) {
            return false;
        }
        Address address2 = this.f40141e;
        if (address2 == null ? openInvoiceDetails.f40141e != null : !address2.equals(openInvoiceDetails.f40141e)) {
            return false;
        }
        Boolean bool2 = this.f40142f;
        Boolean bool3 = openInvoiceDetails.f40142f;
        if (bool2 != null) {
            return bool2.equals(bool3);
        }
        if (bool3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        PersonalDetails personalDetails = this.f40138b;
        int i15 = 0;
        if (personalDetails != null) {
            i11 = personalDetails.hashCode();
        } else {
            i11 = 0;
        }
        int i16 = i11 * 31;
        Address address = this.f40139c;
        if (address != null) {
            i12 = address.hashCode();
        } else {
            i12 = 0;
        }
        int i17 = (i16 + i12) * 31;
        Boolean bool = this.f40140d;
        if (bool != null) {
            i13 = bool.hashCode();
        } else {
            i13 = 0;
        }
        int i18 = (i17 + i13) * 31;
        Address address2 = this.f40141e;
        if (address2 != null) {
            i14 = address2.hashCode();
        } else {
            i14 = 0;
        }
        int i19 = (i18 + i14) * 31;
        Boolean bool2 = this.f40142f;
        if (bool2 != null) {
            i15 = bool2.hashCode();
        }
        return i19 + i15;
    }

    @NonNull
    public JSONObject serialize() throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3 = new JSONObject();
        PersonalDetails personalDetails = this.f40138b;
        JSONObject jSONObject4 = null;
        if (personalDetails != null) {
            jSONObject = personalDetails.serialize();
        } else {
            jSONObject = null;
        }
        jSONObject3.put(KEY_PERSONAL_DETAILS, (Object) jSONObject);
        Address address = this.f40139c;
        if (address != null) {
            jSONObject2 = address.serialize();
        } else {
            jSONObject2 = null;
        }
        jSONObject3.put("billingAddress", (Object) jSONObject2);
        jSONObject3.put(KEY_SEPARATE_DELIVERY_ADDRESS, (Object) this.f40140d);
        Address address2 = this.f40141e;
        if (address2 != null) {
            jSONObject4 = address2.serialize();
        }
        jSONObject3.put(KEY_DELIVERY_ADDRESS, (Object) jSONObject4);
        jSONObject3.put(KEY_CONSENT_CHECKBOX, (Object) this.f40142f);
        return jSONObject3;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        Parcelables.write(parcel, this.f40138b);
        Parcelables.write(parcel, this.f40139c);
        Parcelables.writeSerializable(parcel, this.f40140d);
        Parcelables.write(parcel, this.f40141e);
        Parcelables.writeSerializable(parcel, this.f40142f);
    }

    public OpenInvoiceDetails(@NonNull Parcel parcel) {
        this.f40138b = (PersonalDetails) Parcelables.read(parcel, PersonalDetails.class);
        Class cls = Address.class;
        this.f40139c = (Address) Parcelables.read(parcel, cls);
        this.f40140d = (Boolean) Parcelables.readSerializable(parcel);
        this.f40141e = (Address) Parcelables.read(parcel, cls);
        this.f40142f = (Boolean) Parcelables.readSerializable(parcel);
    }
}
