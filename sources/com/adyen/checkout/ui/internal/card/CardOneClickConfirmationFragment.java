package com.adyen.checkout.ui.internal.card;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.adyen.checkout.base.internal.Objects;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.card.Card;
import com.adyen.checkout.core.card.CardType;
import com.adyen.checkout.core.card.CardValidator;
import com.adyen.checkout.core.card.Cards;
import com.adyen.checkout.core.card.EncryptionException;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.model.CardDetails;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentMethodDetails;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.card.NumpadView;
import com.adyen.checkout.ui.internal.common.fragment.CheckoutDetailsFragment;
import com.adyen.checkout.ui.internal.common.fragment.ErrorDialogFragment;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodPickerListener;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;

public class CardOneClickConfirmationFragment extends CheckoutDetailsFragment {
    private static final String ARG_PAYMENT_METHOD = "ARG_PAYMENT_METHOD";
    private NumpadView mNumpadView;
    private Button mPayButton;
    private PaymentMethod mPaymentMethod;
    private TextView mSecurityCodePromptTextView;
    /* access modifiers changed from: private */
    public CodeView mSecurityCodeView;
    private Button mSelectOtherPaymentMethodButton;
    private TextView mSurchargeTextView;

    @NonNull
    private CardValidator.SecurityCodeValidationResult getSecurityCodeValidationResult() {
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
    public static CardOneClickConfirmationFragment newInstance(@NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_PAYMENT_REFERENCE", paymentReference);
        bundle.putParcelable(ARG_PAYMENT_METHOD, paymentMethod);
        CardOneClickConfirmationFragment cardOneClickConfirmationFragment = new CardOneClickConfirmationFragment();
        cardOneClickConfirmationFragment.setArguments(bundle);
        return cardOneClickConfirmationFragment;
    }

    /* access modifiers changed from: private */
    public void submit() {
        PaymentSession j02;
        CardValidator.SecurityCodeValidationResult securityCodeValidationResult = getSecurityCodeValidationResult();
        if (securityCodeValidationResult.getValidity() == CardValidator.Validity.VALID && (j02 = j0()) != null) {
            String securityCode = securityCodeValidationResult.getSecurityCode();
            if (securityCode != null) {
                Card build = new Card.Builder().setSecurityCode(securityCode).build();
                try {
                    getPaymentHandler().initiatePayment(this.mPaymentMethod, new CardDetails.Builder().setEncryptedSecurityCode(Cards.ENCRYPTOR.encryptFields(build, j02.getGenerationTime(), (String) Objects.requireNonNull(j02.getPublicKey(), "Public key for card payments has not been generated.")).call().getEncryptedSecurityCode()).build());
                    this.mPayButton.setEnabled(false);
                } catch (EncryptionException e11) {
                    Context context = getContext();
                    if (context != null) {
                        ErrorDialogFragment.newInstance(context, (Throwable) e11).showIfNotShown(getChildFragmentManager());
                    }
                } catch (Exception unused) {
                    throw new RuntimeException("Unexpected exception while encrypting card.");
                }
            } else {
                getPaymentHandler().initiatePayment(this.mPaymentMethod, (PaymentMethodDetails) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updatePayButton() {
        boolean z11;
        CardValidator.SecurityCodeValidationResult securityCodeValidationResult = getSecurityCodeValidationResult();
        String securityCode = securityCodeValidationResult.getSecurityCode();
        boolean z12 = true;
        if (CardType.forTxVariantProvider(this.mPaymentMethod) == CardType.AMERICAN_EXPRESS) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (securityCodeValidationResult.getValidity() == CardValidator.Validity.VALID) {
            Button button = this.mPayButton;
            if (securityCode != null && ((z11 || securityCode.length() != 3) && (!z11 || securityCode.length() != 4))) {
                z12 = false;
            }
            button.setEnabled(z12);
            return;
        }
        this.mPayButton.setEnabled(false);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPaymentMethod = (PaymentMethod) getArguments().getParcelable(ARG_PAYMENT_METHOD);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int i11;
        View inflate = layoutInflater.inflate(R.layout.fragment_card_one_click_details, viewGroup, false);
        this.mSecurityCodePromptTextView = (TextView) inflate.findViewById(R.id.textView_securityCodePrompt);
        String maskNumber = Cards.FORMATTER.maskNumber(this.mPaymentMethod.getStoredDetails().getCard().getLastFourDigits());
        String string = getString(R.string.checkout_card_one_click_security_code_prompt, maskNumber);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        int indexOf = string.indexOf(maskNumber);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf, maskNumber.length() + indexOf, 33);
        this.mSecurityCodePromptTextView.setText(spannableStringBuilder);
        CodeView codeView = (CodeView) inflate.findViewById(R.id.codeView_securityCode);
        this.mSecurityCodeView = codeView;
        codeView.setInputType(0);
        CodeView codeView2 = this.mSecurityCodeView;
        if (this.mPaymentMethod.getTxVariant().equals(CardType.AMERICAN_EXPRESS.getTxVariant())) {
            i11 = 4;
        } else {
            i11 = 3;
        }
        codeView2.setLength(i11);
        Button button = (Button) inflate.findViewById(R.id.button_pay);
        this.mPayButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CardOneClickConfirmationFragment.this.submit();
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
        updatePayButton();
        Button button2 = (Button) inflate.findViewById(R.id.button_selectOtherPaymentMethod);
        this.mSelectOtherPaymentMethodButton = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentActivity activity = CardOneClickConfirmationFragment.this.getActivity();
                if (activity instanceof CheckoutMethodPickerListener) {
                    ((CheckoutMethodPickerListener) activity).onClearSelection();
                }
            }
        });
        NumpadView numpadView = (NumpadView) inflate.findViewById(R.id.numpadView);
        this.mNumpadView = numpadView;
        numpadView.setKeyListener(new NumpadView.KeyListener() {
            public void onBackspace() {
                Editable text = CardOneClickConfirmationFragment.this.mSecurityCodeView.getText();
                int length = text.length();
                if (length > 0) {
                    text.delete(length - 1, length);
                    CardOneClickConfirmationFragment.this.updatePayButton();
                }
            }

            public void onCharClicked(char c11) {
                CardOneClickConfirmationFragment.this.mSecurityCodeView.getText().append(c11);
                CardOneClickConfirmationFragment.this.updatePayButton();
            }
        });
        return inflate;
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        updatePayButton();
    }
}
