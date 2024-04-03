package com.adyen.checkout.ui.internal.openinvoice;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.widget.ContentLoadingProgressBar;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.SearchHandler;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.Address;
import com.adyen.checkout.core.model.FieldSetConfiguration;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.KlarnaDetails;
import com.adyen.checkout.core.model.KlarnaSsnLookupResponse;
import com.adyen.checkout.core.model.OpenInvoiceDetails;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.core.model.PersonalDetails;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.openinvoice.AsYouTypeSsnFormatter;
import com.adyen.checkout.ui.internal.openinvoice.control.ValidationChanger;
import com.adyen.checkout.ui.internal.openinvoice.view.AddressDetailsInputLayout;
import com.adyen.checkout.ui.internal.openinvoice.view.PersonalDetailsInputLayout;
import com.adyen.checkout.util.LocaleUtil;
import com.adyen.checkout.util.PaymentMethodTypes;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;

public class OpenInvoiceDetailsActivity extends CheckoutDetailsActivity implements ValidationChanger.ValidationChangeListener {
    private static final String AFTERPAY_BE_CONSENT_URL = "https://www.afterpay.be/be/footer/betalen-met-afterpay/betalingsvoorwaarden";
    private static final String AFTERPAY_NL_CONSENT_URL = "https://www.afterpay.nl/nl/algemeen/betalen-met-afterpay/betalingsvoorwaarden";
    private static final String AFTERPAY_US_CONSENT_URL = "https://www.afterpay.nl/en/algemeen/pay-with-afterpay/payment-conditions";
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private static final String KLARNA_CONSENT_URL = "https://cdn.klarna.com/1.0/shared/content/legal/terms/2/de_de/consent";
    private static final String KLARNA_MORE_INFO_URL = "https://cdn.klarna.com/1.0/shared/content/legal/terms/2/%s/invoice";
    private AddressDetailsInputLayout mBillingAddressDetailsLayout;
    private LinearLayout mConsentLayout;
    private SwitchCompat mConsentSwitch;
    /* access modifiers changed from: private */
    public TextView mConsentText;
    /* access modifiers changed from: private */
    public AddressDetailsInputLayout mDeliveryAddressDetailsLayout;
    /* access modifiers changed from: private */
    public LinearLayout mDetailsInputLayout;
    private Button mPayButton;
    /* access modifiers changed from: private */
    public PaymentMethod mPaymentMethod;
    /* access modifiers changed from: private */
    public PersonalDetailsInputLayout mPersonalDetailsLayout;
    /* access modifiers changed from: private */
    public SearchHandler<KlarnaSsnLookupResponse> mSearchHandler;
    private LinearLayout mSeparateDeliveryAddressLayout;
    private SwitchCompat mSeparateDeliveryAddressSwitch;
    /* access modifiers changed from: private */
    public EditText mSsnLookupEditText;
    /* access modifiers changed from: private */
    public RelativeLayout mSsnLookupLayout;
    /* access modifiers changed from: private */
    public ContentLoadingProgressBar mSsnLookupProgress;
    private TextView mSurchargeTextView;

    private void afterpayConsentClick() {
        getPaymentHandler().getPaymentSessionObservable().observe(this, new Observer<PaymentSession>() {
            public void onChanged(@NonNull PaymentSession paymentSession) {
                final String str;
                String countryCode = paymentSession.getPayment().getCountryCode();
                Locale locale = Locale.ROOT;
                String lowerCase = countryCode.toLowerCase(locale);
                boolean equals = lowerCase.toUpperCase(locale).equals(LocaleUtil.getLocale(OpenInvoiceDetailsActivity.this).getCountry().toUpperCase(locale));
                if (!equals || !"NL".equals(lowerCase.toUpperCase(locale))) {
                    str = (!equals || !"BE".equals(lowerCase.toUpperCase(locale))) ? OpenInvoiceDetailsActivity.AFTERPAY_US_CONSENT_URL : OpenInvoiceDetailsActivity.AFTERPAY_BE_CONSENT_URL;
                } else {
                    str = OpenInvoiceDetailsActivity.AFTERPAY_NL_CONSENT_URL;
                }
                OpenInvoiceDetailsActivity.this.mConsentText.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        OpenInvoiceDetailsActivity.this.launchBrowser(Uri.parse(str));
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean areAllDetailsValid() {
        boolean z11;
        boolean z12 = true;
        if (!this.mPersonalDetailsLayout.isValid() || !this.mBillingAddressDetailsLayout.isValid()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11 && this.mSsnLookupLayout.getVisibility() == 0) {
            if (this.mSsnLookupEditText.getText().length() != 13) {
                z12 = false;
            }
            z11 = z12;
        }
        if (z11 && this.mSeparateDeliveryAddressLayout.getVisibility() == 0 && this.mSeparateDeliveryAddressSwitch.isChecked()) {
            z11 = this.mDeliveryAddressDetailsLayout.isValid();
        }
        if (!z11 || this.mConsentLayout.getVisibility() != 0) {
            return z11;
        }
        return this.mConsentSwitch.isChecked();
    }

    /* access modifiers changed from: private */
    public void checkValidation() {
        this.mPayButton.setEnabled(areAllDetailsValid());
    }

    private void findViews() {
        this.mSsnLookupLayout = (RelativeLayout) findViewById(R.id.layout_ssnLookup);
        this.mSsnLookupProgress = (ContentLoadingProgressBar) findViewById(R.id.progressBar_ssnLookup);
        this.mDetailsInputLayout = (LinearLayout) findViewById(R.id.layout_details_input);
        this.mSsnLookupEditText = (EditText) findViewById(R.id.editText_ssnLookup);
        this.mPersonalDetailsLayout = (PersonalDetailsInputLayout) findViewById(R.id.layout_personal_details_input);
        this.mBillingAddressDetailsLayout = (AddressDetailsInputLayout) findViewById(R.id.layout_billing_address_input);
        this.mSeparateDeliveryAddressLayout = (LinearLayout) findViewById(R.id.layout_separate_delivery_address);
        this.mSeparateDeliveryAddressSwitch = (SwitchCompat) findViewById(R.id.switch_separate_delivery_address);
        this.mDeliveryAddressDetailsLayout = (AddressDetailsInputLayout) findViewById(R.id.layout_delivery_address_input);
        this.mConsentLayout = (LinearLayout) findViewById(R.id.layout_terms_and_conditions);
        this.mConsentText = (TextView) findViewById(R.id.textView_terms_and_conditions);
        this.mConsentSwitch = (SwitchCompat) findViewById(R.id.switch_terms_and_conditions);
        this.mPayButton = (Button) findViewById(R.id.button_pay);
        this.mSurchargeTextView = (TextView) findViewById(R.id.textView_surcharge);
    }

    /* access modifiers changed from: private */
    public void initiatePayment() throws CheckoutException {
        String str;
        if (this.mSsnLookupLayout.getVisibility() == 0) {
            str = this.mSsnLookupEditText.getText().toString().replace(" ", "");
        } else {
            str = null;
        }
        PersonalDetails personalDetails = this.mPersonalDetailsLayout.getPersonalDetails(str);
        Address address = this.mBillingAddressDetailsLayout.getAddress();
        if (personalDetails == null || address == null) {
            throw new CheckoutException.Builder("Payment details are not filled correctly and cannot be built.", (Throwable) null).build();
        }
        KlarnaDetails.Builder builder = new KlarnaDetails.Builder(personalDetails, address);
        builder.setSeparateDeliveryAddress(Boolean.valueOf(this.mSeparateDeliveryAddressSwitch.isChecked()));
        if (this.mConsentLayout.getVisibility() == 0) {
            builder.setConsentCheckbox(Boolean.valueOf(this.mConsentSwitch.isChecked()));
            Address address2 = this.mDeliveryAddressDetailsLayout.getAddress();
            if (address2 != null) {
                builder.setDeliveryAddress(address2);
            }
        }
        getPaymentHandler().initiatePayment(this.mPaymentMethod, builder.build());
    }

    private boolean isAfterpay() {
        return PaymentMethodTypes.AFTERPAY.equals(this.mPaymentMethod.getType());
    }

    private boolean isKlarna() {
        return PaymentMethodTypes.KLARNA.equals(this.mPaymentMethod.getType());
    }

    private void klarnaConsentClick() {
        this.mConsentText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OpenInvoiceDetailsActivity.this.launchBrowser(Uri.parse(OpenInvoiceDetailsActivity.KLARNA_CONSENT_URL));
            }
        });
    }

    /* access modifiers changed from: private */
    public void launchBrowser(@NonNull Uri uri) {
        try {
            startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getApplicationContext(), R.string.checkout_error_redirect_failed, 1).show();
        }
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, OpenInvoiceDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    /* access modifiers changed from: private */
    public void populateSsnLookupData(KlarnaSsnLookupResponse klarnaSsnLookupResponse) {
        this.mPersonalDetailsLayout.fillSsnLookupName(klarnaSsnLookupResponse.getName());
        this.mBillingAddressDetailsLayout.fillSsnResponseAddress(klarnaSsnLookupResponse.getAddress());
        checkValidation();
    }

    private void setup() throws CheckoutException {
        setupPayButton();
        setupInputLayout();
        setupSSnLookup();
        checkValidation();
        setupMoreInformationButton();
    }

    private void setupConsent() {
        String str;
        String str2;
        if (isKlarna()) {
            str2 = getString(R.string.checkout_klarna_consent);
            str = getString(R.string.checkout_klarna_terms_and_conditions_text);
        } else if (isAfterpay()) {
            str2 = getString(R.string.checkout_afterpay_conditions);
            str = getString(R.string.checkout_afterpay_terms_and_conditions_text);
        } else {
            return;
        }
        int indexOf = str.indexOf(LogWriteConstants.LOCATION_MSG_FORMAT);
        this.mConsentLayout.setVisibility(0);
        if (indexOf > -1) {
            int length = str2.length() + indexOf;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.format(str, new Object[]{str2}));
            spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, length, 33);
            spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, length, 33);
            this.mConsentText.setText(spannableStringBuilder);
        } else {
            this.mConsentText.setText(String.format(str, new Object[]{str2}));
        }
        if (isKlarna()) {
            klarnaConsentClick();
        } else if (isAfterpay()) {
            afterpayConsentClick();
        }
        this.mConsentSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                OpenInvoiceDetailsActivity.this.checkValidation();
            }
        });
    }

    private void setupInputLayout() throws CheckoutException {
        List<InputDetail> inputDetails = this.mPaymentMethod.getInputDetails();
        if (inputDetails != null) {
            for (InputDetail next : inputDetails) {
                String key = next.getKey();
                key.hashCode();
                char c11 = 65535;
                switch (key.hashCode()) {
                    case -463501827:
                        if (key.equals(OpenInvoiceDetails.KEY_CONSENT_CHECKBOX)) {
                            c11 = 0;
                            break;
                        }
                        break;
                    case 738353401:
                        if (key.equals("billingAddress")) {
                            c11 = 1;
                            break;
                        }
                        break;
                    case 1047887200:
                        if (key.equals(OpenInvoiceDetails.KEY_DELIVERY_ADDRESS)) {
                            c11 = 2;
                            break;
                        }
                        break;
                    case 1308338109:
                        if (key.equals(OpenInvoiceDetails.KEY_SEPARATE_DELIVERY_ADDRESS)) {
                            c11 = 3;
                            break;
                        }
                        break;
                    case 1599855586:
                        if (key.equals(OpenInvoiceDetails.KEY_PERSONAL_DETAILS)) {
                            c11 = 4;
                            break;
                        }
                        break;
                }
                switch (c11) {
                    case 0:
                        setupConsent();
                        break;
                    case 1:
                        if (next.getType() != InputDetail.Type.ADDRESS) {
                            break;
                        } else {
                            this.mBillingAddressDetailsLayout.setVisibility(0);
                            this.mBillingAddressDetailsLayout.setTitle(R.string.checkout_billing_address_title);
                            this.mBillingAddressDetailsLayout.populateInputDetailGroup(next);
                            this.mBillingAddressDetailsLayout.addValidationChangeListener(this);
                            break;
                        }
                    case 2:
                        if (next.getType() != InputDetail.Type.ADDRESS) {
                            break;
                        } else {
                            this.mDeliveryAddressDetailsLayout.setTitle(R.string.checkout_delivery_address_title);
                            this.mDeliveryAddressDetailsLayout.populateInputDetailGroup(next);
                            this.mDeliveryAddressDetailsLayout.addValidationChangeListener(this);
                            break;
                        }
                    case 3:
                        this.mSeparateDeliveryAddressLayout.setVisibility(0);
                        this.mSeparateDeliveryAddressSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                                if (z11) {
                                    OpenInvoiceDetailsActivity.this.mDeliveryAddressDetailsLayout.setVisibility(0);
                                } else {
                                    OpenInvoiceDetailsActivity.this.mDeliveryAddressDetailsLayout.setVisibility(8);
                                }
                                OpenInvoiceDetailsActivity.this.checkValidation();
                            }
                        });
                        InputDetail findByKey = InputDetailImpl.findByKey(this.mPaymentMethod.getInputDetails(), OpenInvoiceDetails.KEY_DELIVERY_ADDRESS);
                        if (findByKey == null) {
                            break;
                        } else {
                            try {
                                FieldSetConfiguration fieldSetConfiguration = (FieldSetConfiguration) findByKey.getConfiguration(FieldSetConfiguration.class);
                                if (fieldSetConfiguration != null && fieldSetConfiguration.getFieldVisibility() == FieldSetConfiguration.FieldVisibility.READ_ONLY) {
                                    this.mSeparateDeliveryAddressLayout.setVisibility(8);
                                    this.mDeliveryAddressDetailsLayout.setVisibility(0);
                                    break;
                                }
                            } catch (CheckoutException unused) {
                                break;
                            }
                        }
                    case 4:
                        if (next.getType() != InputDetail.Type.FIELD_SET) {
                            break;
                        } else {
                            this.mPersonalDetailsLayout.setVisibility(0);
                            this.mPersonalDetailsLayout.setTitle(R.string.checkout_personal_details_title);
                            this.mPersonalDetailsLayout.populateInputDetailGroup(next);
                            this.mPersonalDetailsLayout.addValidationChangeListener(this);
                            break;
                        }
                    default:
                        if (next.isOptional()) {
                            break;
                        } else {
                            throw new CheckoutException.Builder("Unexpected required detail: " + next.getKey(), (Throwable) null).build();
                        }
                }
            }
        }
    }

    private void setupMoreInformationButton() {
        if (isKlarna()) {
            final Button button = (Button) findViewById(R.id.button_more_information);
            button.setVisibility(0);
            getPaymentHandler().getPaymentSessionObservable().observe(this, new Observer<PaymentSession>() {
                public void onChanged(@NonNull PaymentSession paymentSession) {
                    String str;
                    String countryCode = paymentSession.getPayment().getCountryCode();
                    Locale locale = Locale.ROOT;
                    String lowerCase = countryCode.toLowerCase(locale);
                    if (LocaleUtil.getLocale(OpenInvoiceDetailsActivity.this).getCountry().toLowerCase(locale).equals(lowerCase)) {
                        str = lowerCase + JavaConstant.Dynamic.DEFAULT_NAME + lowerCase;
                    } else {
                        str = "en_" + lowerCase;
                    }
                    final String format = String.format(OpenInvoiceDetailsActivity.KLARNA_MORE_INFO_URL, new Object[]{str});
                    button.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            OpenInvoiceDetailsActivity.this.launchBrowser(Uri.parse(format));
                        }
                    });
                }
            });
        }
    }

    private void setupPayButton() {
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, this.mSurchargeTextView);
        this.mPayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (OpenInvoiceDetailsActivity.this.areAllDetailsValid()) {
                    try {
                        OpenInvoiceDetailsActivity.this.initiatePayment();
                    } catch (CheckoutException e11) {
                        OpenInvoiceDetailsActivity.this.P(e11);
                    }
                }
            }
        });
    }

    private void setupSSnLookup() {
        if (this.mPersonalDetailsLayout.getFormVisibility() != FieldSetConfiguration.FieldVisibility.READ_ONLY) {
            getPaymentHandler().getPaymentSessionObservable().observe(this, new Observer<PaymentSession>() {
                public void onChanged(@NonNull PaymentSession paymentSession) {
                    InputDetail findByKey;
                    OpenInvoiceDetailsActivity openInvoiceDetailsActivity = OpenInvoiceDetailsActivity.this;
                    SearchHandler unused = openInvoiceDetailsActivity.mSearchHandler = SearchHandler.Factory.createKlarnaSsnLookupSearchHandler(openInvoiceDetailsActivity.getApplication(), paymentSession, OpenInvoiceDetailsActivity.this.mPaymentMethod);
                    if (OpenInvoiceDetailsActivity.this.mSearchHandler != null) {
                        OpenInvoiceDetailsActivity.this.mSearchHandler.getSearchResultsObservable().observe(OpenInvoiceDetailsActivity.this, new Observer<KlarnaSsnLookupResponse>() {
                            public void onChanged(@NonNull KlarnaSsnLookupResponse klarnaSsnLookupResponse) {
                                OpenInvoiceDetailsActivity.this.mSsnLookupProgress.hide();
                                OpenInvoiceDetailsActivity.this.mDetailsInputLayout.setVisibility(0);
                                OpenInvoiceDetailsActivity.this.populateSsnLookupData(klarnaSsnLookupResponse);
                            }
                        });
                        OpenInvoiceDetailsActivity.this.mSearchHandler.getErrorObservable().observe(OpenInvoiceDetailsActivity.this, new Observer<CheckoutException>() {
                            public void onChanged(@NonNull CheckoutException checkoutException) {
                                OpenInvoiceDetailsActivity.this.mSsnLookupProgress.hide();
                                OpenInvoiceDetailsActivity.this.mDetailsInputLayout.setVisibility(0);
                                OpenInvoiceDetailsActivity.this.checkValidation();
                            }
                        });
                        OpenInvoiceDetailsActivity.this.mSsnLookupLayout.setVisibility(0);
                        OpenInvoiceDetailsActivity.this.mDetailsInputLayout.setVisibility(8);
                        OpenInvoiceDetailsActivity.this.mPersonalDetailsLayout.setExternalSsnField();
                        OpenInvoiceDetailsActivity.this.mSsnLookupEditText.addTextChangedListener(new AsYouTypeSsnFormatter(new AsYouTypeSsnFormatter.SsnInputCompleteCallback() {
                            public void onSsnInputFinished(@NonNull String str) {
                                OpenInvoiceDetailsActivity.this.mSsnLookupProgress.show();
                                OpenInvoiceDetailsActivity.this.mSearchHandler.setSearchString(str);
                            }
                        }));
                        OpenInvoiceDetailsActivity.this.mSsnLookupEditText.addTextChangedListener(new SimpleTextWatcher() {
                            public void afterTextChanged(@NonNull Editable editable) {
                                OpenInvoiceDetailsActivity.this.checkValidation();
                            }
                        });
                        InputDetail findByKey2 = InputDetailImpl.findByKey(OpenInvoiceDetailsActivity.this.mPaymentMethod.getInputDetails(), OpenInvoiceDetails.KEY_PERSONAL_DETAILS);
                        if (findByKey2 != null && (findByKey = InputDetailImpl.findByKey(findByKey2.getChildInputDetails(), PersonalDetails.KEY_SOCIAL_SECURITY_NUMBER)) != null && !TextUtils.isEmpty(findByKey.getValue())) {
                            OpenInvoiceDetailsActivity.this.mSsnLookupEditText.setText(findByKey.getValue());
                        }
                    }
                }
            });
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_open_invoice_details);
        this.mPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) this.mPaymentMethod.getName());
        }
        findViews();
        try {
            setup();
        } catch (CheckoutException e11) {
            P(e11);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mPersonalDetailsLayout.removeValidationChangeListener(this);
        this.mBillingAddressDetailsLayout.removeValidationChangeListener(this);
        this.mDeliveryAddressDetailsLayout.removeValidationChangeListener(this);
    }

    public void onValidationChanged(boolean z11) {
        checkValidation();
    }
}
