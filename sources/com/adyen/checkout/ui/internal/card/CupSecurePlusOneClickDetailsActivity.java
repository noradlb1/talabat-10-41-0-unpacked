package com.adyen.checkout.ui.internal.card;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.base.internal.Objects;
import com.adyen.checkout.core.AdditionalDetails;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.card.Card;
import com.adyen.checkout.core.card.CardType;
import com.adyen.checkout.core.card.CardValidator;
import com.adyen.checkout.core.card.Cards;
import com.adyen.checkout.core.card.EncryptionException;
import com.adyen.checkout.core.handler.AdditionalDetailsHandler;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.CardDetails;
import com.adyen.checkout.core.model.CupSecurePlusDetails;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.fragment.ErrorDialogFragment;
import com.adyen.checkout.ui.internal.common.util.KeyboardUtil;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.common.util.PaymentMethodUtil;
import com.adyen.checkout.ui.internal.common.util.PhoneNumberUtil;
import com.adyen.checkout.util.PaymentMethodTypes;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import java.util.List;

public class CupSecurePlusOneClickDetailsActivity extends CheckoutDetailsActivity {
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private Button mPayButton;
    /* access modifiers changed from: private */
    public PaymentMethod mPaymentMethod;
    /* access modifiers changed from: private */
    public EditText mPhoneNumberEditText;
    private TextView mSecurityCodePromptTextView;
    private CodeView mSecurityCodeView;
    private TextView mSurchargeTextView;

    @NonNull
    private PhoneNumberUtil.ValidationResult getPhoneNumberValidationResult() {
        boolean z11;
        PaymentMethodUtil.Requirement requirementForInputDetail = PaymentMethodUtil.getRequirementForInputDetail("telephoneNumber", this.mPaymentMethod);
        String obj = this.mPhoneNumberEditText.getText().toString();
        if (requirementForInputDetail == PaymentMethodUtil.Requirement.REQUIRED) {
            z11 = true;
        } else {
            z11 = false;
        }
        return PhoneNumberUtil.validate(obj, z11);
    }

    /* access modifiers changed from: private */
    @NonNull
    public CardValidator.SecurityCodeValidationResult getSecurityCodeValidationResult() {
        boolean z11;
        String obj = this.mSecurityCodeView.getText().toString();
        InputDetail findByKey = InputDetailImpl.findByKey(this.mPaymentMethod.getInputDetails(), CardDetails.KEY_ENCRYPTED_SECURITY_CODE);
        if (findByKey == null || findByKey.isOptional()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return Cards.VALIDATOR.validateSecurityCode(obj, z11, CardType.forTxVariantProvider(this.mPaymentMethod));
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, CupSecurePlusOneClickDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    /* access modifiers changed from: private */
    public void submit() {
        PaymentSession O;
        CardValidator.SecurityCodeValidationResult securityCodeValidationResult = getSecurityCodeValidationResult();
        PhoneNumberUtil.ValidationResult phoneNumberValidationResult = getPhoneNumberValidationResult();
        if (securityCodeValidationResult.getValidity() == CardValidator.Validity.VALID && phoneNumberValidationResult.getValidity() == PhoneNumberUtil.Validity.VALID && (O = O()) != null) {
            String securityCode = securityCodeValidationResult.getSecurityCode();
            String phoneNumber = phoneNumberValidationResult.getPhoneNumber();
            CardDetails.Builder builder = new CardDetails.Builder();
            if (securityCode != null) {
                Card build = new Card.Builder().setSecurityCode(securityCode).build();
                try {
                    builder.setEncryptedSecurityCode(Cards.ENCRYPTOR.encryptFields(build, O.getGenerationTime(), (String) Objects.requireNonNull(O.getPublicKey(), "Public key for card payments has not been generated.")).call().getEncryptedSecurityCode());
                } catch (EncryptionException e11) {
                    ErrorDialogFragment.newInstance((Context) this, (Throwable) e11).showIfNotShown(getSupportFragmentManager());
                    return;
                } catch (Exception unused) {
                    throw new RuntimeException("Unexpected exception while encrypting card.");
                }
            }
            getPaymentHandler().initiatePayment(this.mPaymentMethod, builder.setPhoneNumber(phoneNumber).build());
        }
    }

    /* access modifiers changed from: private */
    public void updatePayButton() {
        boolean z11;
        Button button = this.mPayButton;
        if (getSecurityCodeValidationResult().getValidity() == CardValidator.Validity.VALID && getPhoneNumberValidationResult().getValidity() == PhoneNumberUtil.Validity.VALID) {
            z11 = true;
        } else {
            z11 = false;
        }
        button.setEnabled(z11);
    }

    public void onCreate(@Nullable Bundle bundle) {
        int i11;
        super.onCreate(bundle);
        PaymentMethod paymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        this.mPaymentMethod = paymentMethod;
        setTitle(paymentMethod.getName());
        setContentView(R.layout.activity_card_cup_secure_plus_one_click_details);
        this.mSecurityCodePromptTextView = (TextView) findViewById(R.id.textView_securityCodePrompt);
        String maskNumber = Cards.FORMATTER.maskNumber(this.mPaymentMethod.getStoredDetails().getCard().getLastFourDigits());
        String string = getString(R.string.checkout_card_one_click_security_code_prompt, new Object[]{maskNumber});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(maskNumber);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, maskNumber.length() + indexOf, 33);
        this.mSecurityCodePromptTextView.setText(spannableStringBuilder);
        if (this.mPaymentMethod.getTxVariant().equals(CardType.AMERICAN_EXPRESS.getTxVariant())) {
            i11 = 4;
        } else {
            i11 = 3;
        }
        CodeView codeView = (CodeView) findViewById(R.id.codeView_securityCode);
        this.mSecurityCodeView = codeView;
        codeView.setLength(i11);
        this.mSecurityCodeView.addTextChangedListener(new SimpleTextWatcher() {
            private boolean mDeleted;

            public void afterTextChanged(Editable editable) {
                CupSecurePlusOneClickDetailsActivity.this.updatePayButton();
                if (!this.mDeleted && CupSecurePlusOneClickDetailsActivity.this.getSecurityCodeValidationResult().getValidity() == CardValidator.Validity.VALID) {
                    KeyboardUtil.showAndSelect(CupSecurePlusOneClickDetailsActivity.this.mPhoneNumberEditText);
                }
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                this.mDeleted = i13 == 0;
            }
        });
        EditText editText = (EditText) findViewById(R.id.editText_phoneNumber);
        this.mPhoneNumberEditText = editText;
        editText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                CupSecurePlusOneClickDetailsActivity.this.updatePayButton();
            }
        });
        Button button = (Button) findViewById(R.id.button_pay);
        this.mPayButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CupSecurePlusOneClickDetailsActivity.this.submit();
            }
        });
        TextView textView = (TextView) findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
        updatePayButton();
        getPaymentHandler().setAdditionalDetailsHandler(this, new AdditionalDetailsHandler() {
            public void onAdditionalDetailsRequired(@NonNull AdditionalDetails additionalDetails) {
                if (PaymentMethodTypes.CUP.equals(additionalDetails.getPaymentMethodType())) {
                    List<InputDetail> inputDetails = additionalDetails.getInputDetails();
                    if (inputDetails.size() == 1 && CupSecurePlusDetails.KEY_SMS_CODE.equals(inputDetails.get(0).getKey())) {
                        CupSecurePlusOneClickDetailsActivity cupSecurePlusOneClickDetailsActivity = CupSecurePlusOneClickDetailsActivity.this;
                        CupSecurePlusOneClickDetailsActivity.this.startActivity(CupSecurePlusDetailsActivity.newIntent(cupSecurePlusOneClickDetailsActivity, cupSecurePlusOneClickDetailsActivity.getPaymentReference(), CupSecurePlusOneClickDetailsActivity.this.mPaymentMethod, additionalDetails));
                    }
                }
            }
        });
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        updatePayButton();
    }
}
