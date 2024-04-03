package com.adyen.checkout.ui.internal.openinvoice.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.model.FieldSetConfiguration;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.Name;
import com.adyen.checkout.core.model.PersonalDetails;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.util.Adapter;
import com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout;
import com.adyen.checkout.ui.internal.common.view.DatePickerWidget;
import com.adyen.checkout.ui.internal.openinvoice.control.DateValidator;
import com.adyen.checkout.ui.internal.openinvoice.control.EmailValidator;
import com.adyen.checkout.ui.internal.openinvoice.control.InputDetailController;
import com.adyen.checkout.ui.internal.openinvoice.control.SimpleItemSpinnerValidator;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PersonalDetailsInputLayout extends InputDetailsGroupLayout {
    private static final String TAG = "PersonalDetailsInputLayout";
    private DatePickerWidget mDateOfBirth;
    private CustomTextInputLayout mDateOfBirthLayout;
    private EditText mFirstName;
    private CustomTextInputLayout mFirstNameLayout;
    private Spinner mGender;
    private LinearLayout mGenderLayout;
    private EditText mLastName;
    private CustomTextInputLayout mLastNameLayout;
    private PersonalDetails mReadOnlyPersonalDetails;
    private EditText mShopperEmail;
    private CustomTextInputLayout mShopperEmailLayout;
    private EditText mSocialSecurityNumber;
    private CustomTextInputLayout mSocialSecurityNumberLayout;
    private EditText mTelephoneNumber;
    private CustomTextInputLayout mTelephoneNumberLayout;

    public PersonalDetailsInputLayout(@NonNull Context context) {
        super(context);
    }

    private void addDetailString(@NonNull StringBuilder sb2, @NonNull String str, boolean z11) {
        if (!str.isEmpty()) {
            if (z11) {
                sb2.append(" ");
            }
            sb2.append(str);
        }
    }

    private void findViews() {
        this.mFirstNameLayout = (CustomTextInputLayout) findViewById(R.id.layout_firstName);
        this.mLastNameLayout = (CustomTextInputLayout) findViewById(R.id.layout_lastName);
        this.mGenderLayout = (LinearLayout) findViewById(R.id.layout_gender);
        this.mDateOfBirthLayout = (CustomTextInputLayout) findViewById(R.id.layout_dateOfBirth);
        this.mSocialSecurityNumberLayout = (CustomTextInputLayout) findViewById(R.id.layout_socialSecurityNumber);
        this.mTelephoneNumberLayout = (CustomTextInputLayout) findViewById(R.id.layout_telephoneNumber);
        this.mShopperEmailLayout = (CustomTextInputLayout) findViewById(R.id.layout_shopperEmail);
        this.mFirstName = (EditText) findViewById(R.id.editText_firstName);
        this.mLastName = (EditText) findViewById(R.id.editText_lastName);
        this.mGender = (Spinner) findViewById(R.id.spinner_gender);
        this.mDateOfBirth = (DatePickerWidget) findViewById(R.id.datePicker_dateOfBirth);
        this.mSocialSecurityNumber = (EditText) findViewById(R.id.editText_socialSecurityNumber);
        this.mTelephoneNumber = (EditText) findViewById(R.id.editText_telephoneNumber);
        this.mShopperEmail = (EditText) findViewById(R.id.editText_shopperEmail);
    }

    @Nullable
    private Date parseDate(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            try {
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                int parseInt3 = Integer.parseInt(split[2]);
                Calendar instance = Calendar.getInstance();
                instance.set(1, parseInt);
                instance.set(2, parseInt2);
                instance.set(5, parseInt3);
                return instance.getTime();
            } catch (Exception e11) {
                Log.e(TAG, "parsing date failed", e11);
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    @NonNull
    public String parseGenderString(String str) {
        str.hashCode();
        if (str.equals("F")) {
            return getContext().getResources().getString(R.string.checkout_personal_details_gender_female);
        }
        if (!str.equals("M")) {
            return getContext().getResources().getString(R.string.checkout_personal_details_gender_unknown);
        }
        return getContext().getResources().getString(R.string.checkout_personal_details_gender_male);
    }

    private void populateGenderSpinner(InputDetail inputDetail) {
        Adapter forSpinner = Adapter.forSpinner(new Adapter.TextDelegate<Item>() {
            @NonNull
            public String getText(@NonNull Item item) {
                return PersonalDetailsInputLayout.this.parseGenderString(item.getId());
            }
        });
        forSpinner.setViewCustomizationDelegate(new Adapter.ViewCustomizationDelegate() {
            public void customizeView(@NonNull CheckedTextView checkedTextView) {
                checkedTextView.setTextSize(0, PersonalDetailsInputLayout.this.getContext().getResources().getDimension(R.dimen.primarySpinnerTextSize));
            }
        });
        forSpinner.setItems(inputDetail.getItems());
        this.mGender.setAdapter(forSpinner);
        if (!TextUtils.isEmpty(inputDetail.getValue())) {
            for (int i11 = 0; i11 < forSpinner.getCount(); i11++) {
                if (inputDetail.getValue().equals(((Item) forSpinner.getItem(i11)).getId())) {
                    this.mGender.setSelection(i11);
                    return;
                }
            }
        }
    }

    public void c(@NonNull List<InputDetail> list) throws CheckoutException {
        Date parseDate;
        for (InputDetail next : list) {
            String key = next.getKey();
            key.hashCode();
            char c11 = 65535;
            switch (key.hashCode()) {
                case -1459599807:
                    if (key.equals("lastName")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1249512767:
                    if (key.equals("gender")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -748725899:
                    if (key.equals("shopperEmail")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -386871910:
                    if (key.equals("dateOfBirth")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 132835675:
                    if (key.equals("firstName")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 892233837:
                    if (key.equals("telephoneNumber")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 1202761590:
                    if (key.equals(PersonalDetails.KEY_SOCIAL_SECURITY_NUMBER)) {
                        c11 = 6;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    e(this.mLastName, this.mLastNameLayout, next);
                    break;
                case 1:
                    populateGenderSpinner(next);
                    InputDetailController inputDetailController = new InputDetailController(next, this.mGender, this.mGenderLayout, new SimpleItemSpinnerValidator(next, this.mGender));
                    inputDetailController.addValidationChangeListener(this);
                    this.f40313b.put(next.getKey(), inputDetailController);
                    break;
                case 2:
                    d(this.mShopperEmail, this.mShopperEmailLayout, next, new EmailValidator(next, this.mShopperEmail));
                    break;
                case 3:
                    InputDetailController inputDetailController2 = new InputDetailController(next, this.mDateOfBirth, this.mDateOfBirthLayout, new DateValidator(next, this.mDateOfBirth));
                    inputDetailController2.addValidationChangeListener(this);
                    this.f40313b.put(next.getKey(), inputDetailController2);
                    if (!TextUtils.isEmpty(next.getValue()) && (parseDate = parseDate(next.getValue())) != null) {
                        this.mDateOfBirth.setDate(parseDate);
                        break;
                    }
                case 4:
                    e(this.mFirstName, this.mFirstNameLayout, next);
                    break;
                case 5:
                    e(this.mTelephoneNumber, this.mTelephoneNumberLayout, next);
                    break;
                case 6:
                    e(this.mSocialSecurityNumber, this.mSocialSecurityNumberLayout, next);
                    break;
                default:
                    if (next.isOptional()) {
                        break;
                    } else {
                        throw new CheckoutException.Builder("Required detail does not have matching UI element", (Throwable) null).build();
                    }
            }
        }
    }

    public void fillSsnLookupName(@NonNull Name name2) {
        this.mFirstName.setText(name2.getFirstName());
        this.mLastName.setText(name2.getLastName());
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0080, code lost:
        if (r10.equals("gender") == false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g(@androidx.annotation.Nullable java.util.List<com.adyen.checkout.core.model.InputDetail> r14) throws com.adyen.checkout.core.CheckoutException {
        /*
            r13 = this;
            if (r14 != 0) goto L_0x0018
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r14 = r13.getFormVisibility()
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r0 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.READ_ONLY
            if (r14 == r0) goto L_0x000b
            return
        L_0x000b:
            com.adyen.checkout.core.CheckoutException$Builder r14 = new com.adyen.checkout.core.CheckoutException$Builder
            java.lang.String r0 = "Read only InputDetail has no child data"
            r1 = 0
            r14.<init>(r0, r1)
            com.adyen.checkout.core.CheckoutException r14 = r14.build()
            throw r14
        L_0x0018:
            java.util.Iterator r14 = r14.iterator()
            java.lang.String r0 = ""
            r1 = r0
            r2 = r1
            r3 = r2
            r4 = r3
            r5 = r4
            r6 = r5
        L_0x0024:
            boolean r7 = r14.hasNext()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x00e4
            java.lang.Object r7 = r14.next()
            com.adyen.checkout.core.model.InputDetail r7 = (com.adyen.checkout.core.model.InputDetail) r7
            java.lang.String r10 = r7.getKey()
            r10.hashCode()
            int r11 = r10.hashCode()
            r12 = -1
            switch(r11) {
                case -1459599807: goto L_0x0083;
                case -1249512767: goto L_0x007a;
                case -748725899: goto L_0x006f;
                case -386871910: goto L_0x0064;
                case 132835675: goto L_0x0059;
                case 892233837: goto L_0x004e;
                case 1202761590: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            r8 = r12
            goto L_0x008d
        L_0x0043:
            java.lang.String r8 = "socialSecurityNumber"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x004c
            goto L_0x0041
        L_0x004c:
            r8 = 6
            goto L_0x008d
        L_0x004e:
            java.lang.String r8 = "telephoneNumber"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x0057
            goto L_0x0041
        L_0x0057:
            r8 = 5
            goto L_0x008d
        L_0x0059:
            java.lang.String r8 = "firstName"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x0062
            goto L_0x0041
        L_0x0062:
            r8 = 4
            goto L_0x008d
        L_0x0064:
            java.lang.String r8 = "dateOfBirth"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x006d
            goto L_0x0041
        L_0x006d:
            r8 = 3
            goto L_0x008d
        L_0x006f:
            java.lang.String r8 = "shopperEmail"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x0078
            goto L_0x0041
        L_0x0078:
            r8 = 2
            goto L_0x008d
        L_0x007a:
            java.lang.String r9 = "gender"
            boolean r9 = r10.equals(r9)
            if (r9 != 0) goto L_0x008d
            goto L_0x0041
        L_0x0083:
            java.lang.String r8 = "lastName"
            boolean r8 = r10.equals(r8)
            if (r8 != 0) goto L_0x008c
            goto L_0x0041
        L_0x008c:
            r8 = r9
        L_0x008d:
            switch(r8) {
                case 0: goto L_0x00d8;
                case 1: goto L_0x00cc;
                case 2: goto L_0x00c0;
                case 3: goto L_0x00b4;
                case 4: goto L_0x00a8;
                case 5: goto L_0x009c;
                case 6: goto L_0x0091;
                default: goto L_0x0090;
            }
        L_0x0090:
            goto L_0x0024
        L_0x0091:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r5 = r7.getValue()
            goto L_0x0024
        L_0x009c:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r2 = r7.getValue()
            goto L_0x0024
        L_0x00a8:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r0 = r7.getValue()
            goto L_0x0024
        L_0x00b4:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r4 = r7.getValue()
            goto L_0x0024
        L_0x00c0:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r3 = r7.getValue()
            goto L_0x0024
        L_0x00cc:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r6 = r7.getValue()
            goto L_0x0024
        L_0x00d8:
            java.lang.String r8 = r7.getValue()
            if (r8 == 0) goto L_0x0024
            java.lang.String r1 = r7.getValue()
            goto L_0x0024
        L_0x00e4:
            com.adyen.checkout.core.model.PersonalDetails$Builder r14 = new com.adyen.checkout.core.model.PersonalDetails$Builder
            r14.<init>(r0, r1, r2, r3)
            java.util.Date r4 = r13.parseDate(r4)
            if (r4 == 0) goto L_0x00f2
            r14.setDateOfBirth(r4)
        L_0x00f2:
            boolean r7 = r5.isEmpty()
            if (r7 != 0) goto L_0x00fb
            r14.setSocialSecurityNumber(r5)
        L_0x00fb:
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0104
            r14.setGender(r6)
        L_0x0104:
            com.adyen.checkout.core.model.PersonalDetails r14 = r14.build()
            r13.mReadOnlyPersonalDetails = r14
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r14 = r13.getFormVisibility()
            com.adyen.checkout.core.model.FieldSetConfiguration$FieldVisibility r7 = com.adyen.checkout.core.model.FieldSetConfiguration.FieldVisibility.READ_ONLY
            if (r14 != r7) goto L_0x0170
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r13.addDetailString(r14, r0, r9)
            r13.addDetailString(r14, r1, r8)
            java.lang.String r0 = "\n"
            r13.addDetailString(r14, r0, r9)
            boolean r1 = r6.isEmpty()
            if (r1 != 0) goto L_0x0132
            java.lang.String r1 = r13.parseGenderString(r6)
            r13.addDetailString(r14, r1, r9)
            r13.addDetailString(r14, r0, r9)
        L_0x0132:
            if (r4 == 0) goto L_0x014d
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            android.content.Context r6 = r13.getContext()
            java.util.Locale r6 = com.adyen.checkout.util.LocaleUtil.getLocale(r6)
            java.lang.String r7 = "dd MMM YYYY"
            r1.<init>(r7, r6)
            java.lang.String r1 = r1.format(r4)
            r13.addDetailString(r14, r1, r9)
            r13.addDetailString(r14, r0, r9)
        L_0x014d:
            boolean r1 = r5.isEmpty()
            if (r1 != 0) goto L_0x0159
            r13.addDetailString(r14, r5, r9)
            r13.addDetailString(r14, r0, r9)
        L_0x0159:
            r13.addDetailString(r14, r2, r9)
            r13.addDetailString(r14, r0, r9)
            r13.addDetailString(r14, r3, r9)
            r13.addDetailString(r14, r0, r9)
            android.widget.TextView r0 = r13.getReadOnlyDetails()
            java.lang.String r14 = r14.toString()
            r0.setText(r14)
        L_0x0170:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.openinvoice.view.PersonalDetailsInputLayout.g(java.util.List):void");
    }

    @Nullable
    public PersonalDetails getPersonalDetails(@Nullable String str) {
        if (!isValid()) {
            return null;
        }
        if (getFormVisibility() != FieldSetConfiguration.FieldVisibility.EDITABLE) {
            return this.mReadOnlyPersonalDetails;
        }
        String b11 = InputDetailsGroupLayout.b(this.mFirstName);
        String b12 = InputDetailsGroupLayout.b(this.mLastName);
        String b13 = InputDetailsGroupLayout.b(this.mTelephoneNumber);
        String b14 = InputDetailsGroupLayout.b(this.mShopperEmail);
        if (b11 == null || b12 == null || b13 == null || b14 == null) {
            return null;
        }
        PersonalDetails.Builder builder = new PersonalDetails.Builder(b11, b12, b13, b14);
        String a11 = InputDetailsGroupLayout.a(this.mGender);
        Date date = this.mDateOfBirth.getDate();
        if (str == null) {
            str = InputDetailsGroupLayout.b(this.mSocialSecurityNumber);
        }
        builder.setSocialSecurityNumber(str);
        builder.setGender(a11);
        builder.setDateOfBirth(date);
        return builder.build();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()) {
            findViews();
        }
    }

    public void setExternalSsnField() {
        this.mSocialSecurityNumberLayout.setVisibility(8);
        this.f40313b.remove(PersonalDetails.KEY_SOCIAL_SECURITY_NUMBER);
    }

    public PersonalDetailsInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PersonalDetailsInputLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
