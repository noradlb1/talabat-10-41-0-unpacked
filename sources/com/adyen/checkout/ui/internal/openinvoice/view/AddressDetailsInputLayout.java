package com.adyen.checkout.ui.internal.openinvoice.view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.model.Address;
import com.adyen.checkout.core.model.FieldSetConfiguration;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout;

public class AddressDetailsInputLayout extends InputDetailsGroupLayout {
    private EditText mCity;
    private CustomTextInputLayout mCityLayout;
    private Spinner mCountry;
    private LinearLayout mCountryLayout;
    private EditText mHouseNumber;
    private CustomTextInputLayout mHouseNumberLayout;
    private EditText mPostalCode;
    private CustomTextInputLayout mPostalCodeLayout;
    private Address mReadOnlyAddress;
    private EditText mStreet;
    private CustomTextInputLayout mStreetLayout;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i11) {
                return new SavedState[i11];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        public String f40308b;

        /* renamed from: c  reason: collision with root package name */
        public String f40309c;

        /* renamed from: d  reason: collision with root package name */
        public String f40310d;

        /* renamed from: e  reason: collision with root package name */
        public String f40311e;

        /* renamed from: f  reason: collision with root package name */
        public String f40312f;

        public void writeToParcel(Parcel parcel, int i11) {
            super.writeToParcel(parcel, i11);
            parcel.writeString(this.f40308b);
            parcel.writeString(this.f40309c);
            parcel.writeString(this.f40310d);
            parcel.writeString(this.f40311e);
            parcel.writeString(this.f40312f);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f40308b = parcel.readString();
            this.f40309c = parcel.readString();
            this.f40310d = parcel.readString();
            this.f40311e = parcel.readString();
            this.f40312f = parcel.readString();
        }
    }

    public AddressDetailsInputLayout(@NonNull Context context) {
        super(context);
    }

    private void addFormatString(@NonNull StringBuilder sb2, @Nullable String str, boolean z11) {
        if (!str.isEmpty()) {
            if (z11) {
                sb2.append(" ");
            }
            sb2.append(str);
        }
    }

    private void findViews() {
        this.mStreetLayout = (CustomTextInputLayout) findViewById(R.id.layout_street);
        this.mHouseNumberLayout = (CustomTextInputLayout) findViewById(R.id.layout_houseNumber);
        this.mCityLayout = (CustomTextInputLayout) findViewById(R.id.layout_city);
        this.mPostalCodeLayout = (CustomTextInputLayout) findViewById(R.id.layout_postalCode);
        this.mCountryLayout = (LinearLayout) findViewById(R.id.layout_country);
        this.mStreet = (EditText) findViewById(R.id.editText_street);
        this.mHouseNumber = (EditText) findViewById(R.id.editText_houseNumber);
        this.mCity = (EditText) findViewById(R.id.editText_city);
        this.mPostalCode = (EditText) findViewById(R.id.editText_postalCode);
        this.mCountry = (Spinner) findViewById(R.id.spinner_country);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(@androidx.annotation.NonNull java.util.List<com.adyen.checkout.core.model.InputDetail> r8) throws com.adyen.checkout.core.CheckoutException {
        /*
            r7 = this;
            java.util.Iterator r8 = r8.iterator()
        L_0x0004:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x00c2
            java.lang.Object r0 = r8.next()
            com.adyen.checkout.core.model.InputDetail r0 = (com.adyen.checkout.core.model.InputDetail) r0
            java.lang.String r1 = r0.getKey()
            int r2 = r1.hashCode()
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -2104432220: goto L_0x0052;
                case -891990013: goto L_0x0048;
                case 3053931: goto L_0x003e;
                case 957831062: goto L_0x0034;
                case 1989225207: goto L_0x002a;
                case 2011152728: goto L_0x0020;
                default: goto L_0x001f;
            }
        L_0x001f:
            goto L_0x005c
        L_0x0020:
            java.lang.String r2 = "postalCode"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            r1 = r4
            goto L_0x005d
        L_0x002a:
            java.lang.String r2 = "houseNumberOrName"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            r1 = r6
            goto L_0x005d
        L_0x0034:
            java.lang.String r2 = "country"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            r1 = r3
            goto L_0x005d
        L_0x003e:
            java.lang.String r2 = "city"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            r1 = r5
            goto L_0x005d
        L_0x0048:
            java.lang.String r2 = "street"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            r1 = 0
            goto L_0x005d
        L_0x0052:
            java.lang.String r2 = "stateOrProvince"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x005c
            r1 = 5
            goto L_0x005d
        L_0x005c:
            r1 = -1
        L_0x005d:
            if (r1 == 0) goto L_0x00b9
            if (r1 == r6) goto L_0x00b0
            if (r1 == r5) goto L_0x00a7
            if (r1 == r4) goto L_0x009e
            if (r1 == r3) goto L_0x007b
            boolean r0 = r0.isOptional()
            if (r0 == 0) goto L_0x006e
            goto L_0x0004
        L_0x006e:
            com.adyen.checkout.core.CheckoutException$Builder r8 = new com.adyen.checkout.core.CheckoutException$Builder
            java.lang.String r0 = "Required detail does not have matching UI element"
            r1 = 0
            r8.<init>(r0, r1)
            com.adyen.checkout.core.CheckoutException r8 = r8.build()
            throw r8
        L_0x007b:
            android.widget.Spinner r1 = r7.mCountry
            com.adyen.checkout.ui.internal.openinvoice.view.InputDetailsGroupLayout.h(r1, r0)
            com.adyen.checkout.ui.internal.openinvoice.control.SimpleItemSpinnerValidator r1 = new com.adyen.checkout.ui.internal.openinvoice.control.SimpleItemSpinnerValidator
            android.widget.Spinner r2 = r7.mCountry
            r1.<init>(r0, r2)
            com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController r2 = new com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController
            android.widget.Spinner r3 = r7.mCountry
            android.widget.LinearLayout r4 = r7.mCountryLayout
            r2.<init>(r0, r3, r4, r1)
            r2.addValidationChangeListener(r7)
            java.util.LinkedHashMap<java.lang.String, com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController> r1 = r7.f40313b
            java.lang.String r0 = r0.getKey()
            r1.put(r0, r2)
            goto L_0x0004
        L_0x009e:
            android.widget.EditText r1 = r7.mPostalCode
            com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout r2 = r7.mPostalCodeLayout
            r7.e(r1, r2, r0)
            goto L_0x0004
        L_0x00a7:
            android.widget.EditText r1 = r7.mCity
            com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout r2 = r7.mCityLayout
            r7.e(r1, r2, r0)
            goto L_0x0004
        L_0x00b0:
            android.widget.EditText r1 = r7.mHouseNumber
            com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout r2 = r7.mHouseNumberLayout
            r7.e(r1, r2, r0)
            goto L_0x0004
        L_0x00b9:
            android.widget.EditText r1 = r7.mStreet
            com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout r2 = r7.mStreetLayout
            r7.e(r1, r2, r0)
            goto L_0x0004
        L_0x00c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.view.AddressDetailsInputLayout.c(java.util.List):void");
    }

    public void fillSsnResponseAddress(@NonNull Address address) {
        SpinnerAdapter adapter;
        if (getFormVisibility() == FieldSetConfiguration.FieldVisibility.EDITABLE) {
            this.mStreet.setText(address.getStreet());
            this.mHouseNumber.setText(address.getHouseNumberOrName());
            this.mCity.setText(address.getCity());
            this.mPostalCode.setText(address.getPostalCode());
            if (!TextUtils.isEmpty(address.getCountry()) && (adapter = this.mCountry.getAdapter()) != null) {
                for (int i11 = 0; i11 < adapter.getCount(); i11++) {
                    if (address.getCountry().equals(((Item) adapter.getItem(i11)).getId())) {
                        this.mCountry.setSelection(i11);
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        if (r2.equals(com.adyen.checkout.core.model.Address.KEY_CITY) == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(@androidx.annotation.Nullable java.util.List<com.adyen.checkout.core.model.InputDetail> r15) throws com.adyen.checkout.core.CheckoutException {
        /*
            r14 = this;
            if (r15 != 0) goto L_0x0018
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r15 = r14.getFormVisibility()
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r0 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.READ_ONLY
            if (r15 == r0) goto L_0x000b
            return
        L_0x000b:
            com.adyen.checkout.core.CheckoutException$Builder r15 = new com.adyen.checkout.core.CheckoutException$Builder
            java.lang.String r0 = "Read only InputDetail has no child data"
            r1 = 0
            r15.<init>(r0, r1)
            com.adyen.checkout.core.CheckoutException r15 = r15.build()
            throw r15
        L_0x0018:
            java.util.Iterator r15 = r15.iterator()
            java.lang.String r0 = ""
            r5 = r0
            r7 = r5
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
        L_0x0024:
            boolean r1 = r15.hasNext()
            r12 = 1
            r13 = 0
            if (r1 == 0) goto L_0x00e6
            java.lang.Object r1 = r15.next()
            com.adyen.checkout.core.model.InputDetail r1 = (com.adyen.checkout.core.model.InputDetail) r1
            java.lang.String r2 = r1.getKey()
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = -1
            switch(r3) {
                case -891990013: goto L_0x006d;
                case 3053931: goto L_0x0064;
                case 957831062: goto L_0x0059;
                case 1989225207: goto L_0x004e;
                case 2011152728: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r12 = r4
            goto L_0x0077
        L_0x0043:
            java.lang.String r3 = "postalCode"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            r12 = 4
            goto L_0x0077
        L_0x004e:
            java.lang.String r3 = "houseNumberOrName"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            r12 = 3
            goto L_0x0077
        L_0x0059:
            java.lang.String r3 = "country"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0062
            goto L_0x0041
        L_0x0062:
            r12 = 2
            goto L_0x0077
        L_0x0064:
            java.lang.String r3 = "city"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0077
            goto L_0x0041
        L_0x006d:
            java.lang.String r3 = "street"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0076
            goto L_0x0041
        L_0x0076:
            r12 = r13
        L_0x0077:
            switch(r12) {
                case 0: goto L_0x00da;
                case 1: goto L_0x00ce;
                case 2: goto L_0x0091;
                case 3: goto L_0x0086;
                case 4: goto L_0x007b;
                default: goto L_0x007a;
            }
        L_0x007a:
            goto L_0x0024
        L_0x007b:
            java.lang.String r2 = r1.getValue()
            if (r2 == 0) goto L_0x0024
            java.lang.String r10 = r1.getValue()
            goto L_0x0024
        L_0x0086:
            java.lang.String r2 = r1.getValue()
            if (r2 == 0) goto L_0x0024
            java.lang.String r8 = r1.getValue()
            goto L_0x0024
        L_0x0091:
            java.lang.String r2 = r1.getValue()
            if (r2 == 0) goto L_0x0024
            java.lang.String r5 = r1.getValue()
            java.util.List r2 = r1.getItems()
            if (r2 == 0) goto L_0x00c8
            java.util.List r2 = r1.getItems()
            java.util.Iterator r2 = r2.iterator()
        L_0x00a9:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0024
            java.lang.Object r3 = r2.next()
            com.adyen.checkout.core.model.Item r3 = (com.adyen.checkout.core.model.Item) r3
            java.lang.String r4 = r3.getId()
            java.lang.String r6 = r1.getValue()
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x00a9
            java.lang.String r11 = r3.getName()
            goto L_0x00a9
        L_0x00c8:
            java.lang.String r11 = r1.getValue()
            goto L_0x0024
        L_0x00ce:
            java.lang.String r2 = r1.getValue()
            if (r2 == 0) goto L_0x0024
            java.lang.String r9 = r1.getValue()
            goto L_0x0024
        L_0x00da:
            java.lang.String r2 = r1.getValue()
            if (r2 == 0) goto L_0x0024
            java.lang.String r7 = r1.getValue()
            goto L_0x0024
        L_0x00e6:
            com.adyen.checkout.core.model.Address$Builder r15 = new com.adyen.checkout.core.model.Address$Builder
            r1 = r15
            r2 = r7
            r3 = r8
            r4 = r9
            r6 = r10
            r1.<init>(r2, r3, r4, r5, r6)
            com.adyen.checkout.core.model.Address r15 = r15.build()
            r14.mReadOnlyAddress = r15
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r15 = r14.getFormVisibility()
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r1 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.READ_ONLY
            if (r15 != r1) goto L_0x0128
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r14.addFormatString(r15, r7, r13)
            r14.addFormatString(r15, r8, r12)
            java.lang.String r1 = "\n"
            r14.addFormatString(r15, r1, r13)
            r14.addFormatString(r15, r10, r13)
            r14.addFormatString(r15, r9, r12)
            r14.addFormatString(r15, r0, r12)
            r14.addFormatString(r15, r1, r13)
            r14.addFormatString(r15, r11, r13)
            android.widget.TextView r0 = r14.getReadOnlyDetails()
            java.lang.String r15 = r15.toString()
            r0.setText(r15)
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.view.AddressDetailsInputLayout.g(java.util.List):void");
    }

    @Nullable
    public Address getAddress() {
        if (!isValid()) {
            return null;
        }
        if (getFormVisibility() != FieldSetConfiguration.FieldVisibility.EDITABLE) {
            return this.mReadOnlyAddress;
        }
        String b11 = InputDetailsGroupLayout.b(this.mStreet);
        String b12 = InputDetailsGroupLayout.b(this.mHouseNumber);
        String b13 = InputDetailsGroupLayout.b(this.mCity);
        String a11 = InputDetailsGroupLayout.a(this.mCountry);
        String b14 = InputDetailsGroupLayout.b(this.mPostalCode);
        if (b11 == null || b12 == null || b13 == null || a11 == null || b14 == null) {
            return null;
        }
        return new Address.Builder(b11, b12, b13, a11, b14).build();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            findViews();
        }
    }

    public void onRestoreInstanceState(@NonNull Parcelable parcelable) {
        SpinnerAdapter adapter;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mStreet.setText(savedState.f40308b);
        this.mHouseNumber.setText(savedState.f40309c);
        this.mCity.setText(savedState.f40310d);
        this.mPostalCode.setText(savedState.f40311e);
        if (!TextUtils.isEmpty(savedState.f40312f) && (adapter = this.mCountry.getAdapter()) != null) {
            for (int i11 = 0; i11 < adapter.getCount(); i11++) {
                if (savedState.f40312f.equals(((Item) adapter.getItem(i11)).getId())) {
                    this.mCountry.setSelection(i11);
                    return;
                }
            }
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (!TextUtils.isEmpty(this.mStreet.getText())) {
            savedState.f40308b = this.mStreet.getText().toString();
        }
        if (!TextUtils.isEmpty(this.mHouseNumber.getText())) {
            savedState.f40309c = this.mHouseNumber.getText().toString();
        }
        if (!TextUtils.isEmpty(this.mCity.getText())) {
            savedState.f40310d = this.mCity.getText().toString();
        }
        if (!TextUtils.isEmpty(this.mPostalCode.getText())) {
            savedState.f40311e = this.mPostalCode.getText().toString();
        }
        String a11 = InputDetailsGroupLayout.a(this.mCountry);
        if (!TextUtils.isEmpty(InputDetailsGroupLayout.a(this.mCountry))) {
            savedState.f40312f = a11;
        }
        return savedState;
    }

    public AddressDetailsInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddressDetailsInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
