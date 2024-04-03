package com.adyen.checkout.ui.internal.card;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.base.internal.Objects;
import com.adyen.checkout.core.AdditionalDetails;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.Observable;
import com.adyen.checkout.core.PaymentHandler;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.card.Card;
import com.adyen.checkout.core.card.CardType;
import com.adyen.checkout.core.card.CardValidator;
import com.adyen.checkout.core.card.Cards;
import com.adyen.checkout.core.card.EncryptedCard;
import com.adyen.checkout.core.card.EncryptionException;
import com.adyen.checkout.core.handler.AdditionalDetailsHandler;
import com.adyen.checkout.core.internal.model.InputDetailImpl;
import com.adyen.checkout.core.internal.model.PaymentMethodImpl;
import com.adyen.checkout.core.model.CardDetails;
import com.adyen.checkout.core.model.CupSecurePlusDetails;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.PaymentSession;
import com.adyen.checkout.nfc.NfcCardReader;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.card.NfcCardReaderTutorialFragment;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.fragment.ErrorDialogFragment;
import com.adyen.checkout.ui.internal.common.fragment.ProgressDialogFragment;
import com.adyen.checkout.ui.internal.common.util.Adapter;
import com.adyen.checkout.ui.internal.common.util.ConnectivityDelegate;
import com.adyen.checkout.ui.internal.common.util.KeyboardUtil;
import com.adyen.checkout.ui.internal.common.util.LockToCheckmarkAnimationDelegate;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.common.util.PaymentMethodUtil;
import com.adyen.checkout.ui.internal.common.util.PhoneNumberUtil;
import com.adyen.checkout.ui.internal.common.util.TextViewUtil;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.ui.internal.common.util.image.Rembrandt;
import com.adyen.checkout.ui.internal.common.util.image.Target;
import com.adyen.checkout.ui.internal.common.util.recyclerview.CheckoutItemAnimator;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SpacingItemDecoration;
import com.adyen.checkout.ui.internal.common.view.CustomTextInputLayout;
import com.adyen.checkout.util.PaymentMethodTypes;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.List;

public class CardDetailsActivity extends CheckoutDetailsActivity implements View.OnClickListener, NfcCardReaderTutorialFragment.Listener, DialogInterface.OnDismissListener {
    private static final int CARD_NUMBER_BLOCK_LENGTH = 4;
    private static final String EXTRA_TARGET_PAYMENT_METHOD = "EXTRA_TARGET_PAYMENT_METHOD";
    /* access modifiers changed from: private */
    public List<PaymentMethod> mAllowedPaymentMethods;
    /* access modifiers changed from: private */
    public EditText mCardNumberEditText;
    private ConnectivityDelegate mConnectivityDelegate;
    /* access modifiers changed from: private */
    public EditText mExpiryDateEditText;
    private EditText mHolderNameEditText;
    private View mInstallmentsContainer;
    private Spinner mInstallmentsSpinner;
    /* access modifiers changed from: private */
    public LockToCheckmarkAnimationDelegate mLockToCheckmarkAnimationDelegate;
    private NfcCardReader mNfcCardReader;
    private Button mPayButton;
    /* access modifiers changed from: private */
    public EditText mPhoneNumberEditText;
    /* access modifiers changed from: private */
    public EditText mSecurityCodeEditText;
    private SwitchCompat mStoreDetailsSwitchCompat;
    private TextView mSurchargeTextView;
    private PaymentMethod mTargetPaymentMethod;

    /* renamed from: com.adyen.checkout.ui.internal.card.CardDetailsActivity$17  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass17 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40159a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.adyen.checkout.nfc.NfcCardReader$Error[] r0 = com.adyen.checkout.nfc.NfcCardReader.Error.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f40159a = r0
                com.adyen.checkout.nfc.NfcCardReader$Error r1 = com.adyen.checkout.nfc.NfcCardReader.Error.CARD_UNSUPPORTED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f40159a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.adyen.checkout.nfc.NfcCardReader$Error r1 = com.adyen.checkout.nfc.NfcCardReader.Error.CONNECTION_LOST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.adyen.checkout.ui.internal.card.CardDetailsActivity.AnonymousClass17.<clinit>():void");
        }
    }

    public final class NfcCardReaderListener implements NfcCardReader.Listener {
        private NfcCardReaderListener() {
        }

        public void onCardDiscovered() {
            ProgressDialogFragment.show((AppCompatActivity) CardDetailsActivity.this);
        }

        public void onCardRead(@NonNull Card card) {
            ProgressDialogFragment.hide((AppCompatActivity) CardDetailsActivity.this);
            CardDetailsActivity.this.hideCardReaderTutorialFragment();
            CardDetailsActivity.this.fillInputFieldsWithCard(card);
        }

        public void onChipDiscovered(boolean z11) {
            if (!z11) {
                Toast.makeText(CardDetailsActivity.this.getApplicationContext(), R.string.checkout_card_nfc_error_chip_unsupported, 0).show();
            }
        }

        public void onError(@NonNull NfcCardReader.Error error) {
            ProgressDialogFragment.hide((AppCompatActivity) CardDetailsActivity.this);
            int i11 = AnonymousClass17.f40159a[error.ordinal()];
            if (i11 == 1) {
                Toast.makeText(CardDetailsActivity.this.getApplicationContext(), R.string.checkout_card_nfc_error_card_unsupported, 0).show();
            } else if (i11 == 2) {
                Toast.makeText(CardDetailsActivity.this.getApplicationContext(), R.string.checkout_card_nfc_error_connection_lost, 0).show();
            }
        }
    }

    /* access modifiers changed from: private */
    public void fillInputFieldsWithCard(@NonNull Card card) {
        this.mCardNumberEditText.setText(card.getNumber());
        Integer expiryMonth = card.getExpiryMonth();
        Integer expiryYear = card.getExpiryYear();
        if (!(expiryMonth == null || expiryYear == null)) {
            this.mExpiryDateEditText.setText(Cards.FORMATTER.formatExpiryDate(expiryMonth.intValue(), expiryYear.intValue()));
        }
        this.mSecurityCodeEditText.setText(card.getSecurityCode());
        updatePayButtonState();
        CardValidator cardValidator = Cards.VALIDATOR;
        CardValidator.Validity validity = cardValidator.validateNumber(this.mCardNumberEditText.getText().toString()).getValidity();
        CardValidator.Validity validity2 = CardValidator.Validity.VALID;
        if (validity != validity2) {
            KeyboardUtil.showAndSelect(this.mCardNumberEditText);
        } else if (cardValidator.validateExpiryDate(this.mExpiryDateEditText.getText().toString()).getValidity() != validity2) {
            KeyboardUtil.showAndSelect(this.mExpiryDateEditText);
        } else {
            CardValidator.SecurityCodeValidationResult securityCodeValidationResult = getSecurityCodeValidationResult();
            if (securityCodeValidationResult.getValidity() != validity2) {
                KeyboardUtil.showAndSelect(this.mSecurityCodeEditText);
            } else if (securityCodeValidationResult.getSecurityCode() != null) {
                this.mSecurityCodeEditText.requestFocus();
                EditText editText = this.mSecurityCodeEditText;
                editText.setSelection(editText.length());
                KeyboardUtil.hide(this.mSecurityCodeEditText);
            }
        }
    }

    /* access modifiers changed from: private */
    @NonNull
    public List<PaymentMethod> getAllowedPaymentMethods(@NonNull PaymentSession paymentSession) {
        ArrayList arrayList = new ArrayList();
        if ("card".equals(this.mTargetPaymentMethod.getType())) {
            arrayList.addAll(getPaymentMethodsWithGroup(paymentSession, this.mTargetPaymentMethod));
        } else {
            arrayList.add(this.mTargetPaymentMethod);
        }
        return arrayList;
    }

    @NonNull
    private List<CardType> getCardTypesToDisplay() {
        ArrayList arrayList = new ArrayList();
        String number = Cards.VALIDATOR.validateNumber(this.mCardNumberEditText.getText().toString()).getNumber();
        if (number != null) {
            for (PaymentMethod forTxVariantProvider : this.mAllowedPaymentMethods) {
                CardType forTxVariantProvider2 = CardType.forTxVariantProvider(forTxVariantProvider);
                if (forTxVariantProvider2 != null && forTxVariantProvider2.isEstimateFor(number)) {
                    arrayList.add(forTxVariantProvider2);
                }
            }
        }
        return arrayList;
    }

    @NonNull
    private CardValidator.HolderNameValidationResult getHolderNameValidationResult() {
        boolean z11;
        String obj = this.mHolderNameEditText.getText().toString();
        PaymentMethodUtil.Requirement requirementForInputDetail = PaymentMethodUtil.getRequirementForInputDetail("holderName", this.mAllowedPaymentMethods);
        CardValidator cardValidator = Cards.VALIDATOR;
        if (requirementForInputDetail == PaymentMethodUtil.Requirement.REQUIRED) {
            z11 = true;
        } else {
            z11 = false;
        }
        return cardValidator.validateHolderName(obj, z11);
    }

    @Nullable
    private Integer getInstallments() {
        if (this.mInstallmentsContainer.getVisibility() != 0) {
            return null;
        }
        Object selectedItem = this.mInstallmentsSpinner.getSelectedItem();
        if (!(selectedItem instanceof Item)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(((Item) selectedItem).getId()));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @NonNull
    private List<PaymentMethod> getPaymentMethodsWithGroup(@NonNull PaymentSession paymentSession, @NonNull PaymentMethod paymentMethod) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (PaymentMethod next : paymentSession.getPaymentMethods()) {
            PaymentMethod group = next.getGroup();
            if (group != null) {
                str = group.getType();
            } else {
                str = null;
            }
            if (paymentMethod.getType().equals(str)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    @NonNull
    private PhoneNumberUtil.ValidationResult getPhoneNumberValidationResult() {
        boolean z11;
        PaymentMethodUtil.Requirement requirementForInputDetail = PaymentMethodUtil.getRequirementForInputDetail("telephoneNumber", this.mAllowedPaymentMethods);
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
        CardType cardType;
        CardType cardType2;
        String obj = this.mSecurityCodeEditText.getText().toString();
        boolean z11 = false;
        boolean z12 = true;
        if (this.mAllowedPaymentMethods.size() == 1) {
            PaymentMethod paymentMethod = this.mAllowedPaymentMethods.get(0);
            if (PaymentMethodUtil.getRequirementForInputDetail(CardDetails.KEY_ENCRYPTED_SECURITY_CODE, paymentMethod) == PaymentMethodUtil.Requirement.REQUIRED) {
                z11 = true;
            }
            cardType = CardType.forTxVariantProvider(paymentMethod);
        } else {
            List<CardType> cardTypesToDisplay = getCardTypesToDisplay();
            if (cardTypesToDisplay.size() == 1 && cardTypesToDisplay.get(0) == (cardType2 = CardType.AMERICAN_EXPRESS)) {
                cardType = cardType2;
                return Cards.VALIDATOR.validateSecurityCode(obj, z12, cardType);
            }
            if (PaymentMethodUtil.getRequirementForInputDetail(CardDetails.KEY_ENCRYPTED_SECURITY_CODE, this.mAllowedPaymentMethods) == PaymentMethodUtil.Requirement.REQUIRED) {
                z11 = true;
            }
            cardType = null;
        }
        z12 = z11;
        return Cards.VALIDATOR.validateSecurityCode(obj, z12, cardType);
    }

    @Nullable
    private Boolean getStoreDetails() {
        if (PaymentMethodUtil.getRequirementForInputDetail("storeDetails", this.mAllowedPaymentMethods) != PaymentMethodUtil.Requirement.NONE && this.mStoreDetailsSwitchCompat.isChecked()) {
            return Boolean.TRUE;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void hideCardReaderTutorialFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.executePendingTransactions();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(NfcCardReaderTutorialFragment.TAG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    public boolean isCardNumberValidForUser() {
        boolean z11;
        CardValidator.NumberValidationResult validateNumber = Cards.VALIDATOR.validateNumber(this.mCardNumberEditText.getText().toString());
        boolean z12 = true;
        if (validateNumber.getValidity() == CardValidator.Validity.VALID) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || !this.mCardNumberEditText.hasFocus()) {
            return z11;
        }
        String number = validateNumber.getNumber();
        int length = number.length();
        if (this.mCardNumberEditText.getSelectionEnd() != this.mCardNumberEditText.length() || (length != 16 && (length != 15 || !CardType.estimate(number).contains(CardType.AMERICAN_EXPRESS)))) {
            z12 = false;
        }
        return z12;
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, CardDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_TARGET_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    @Nullable
    private Card parseCardFromInput() {
        String obj = this.mCardNumberEditText.getText().toString();
        CardValidator cardValidator = Cards.VALIDATOR;
        CardValidator.NumberValidationResult validateNumber = cardValidator.validateNumber(obj);
        CardValidator.Validity validity = validateNumber.getValidity();
        CardValidator.Validity validity2 = CardValidator.Validity.VALID;
        if (validity != validity2) {
            return null;
        }
        CardValidator.ExpiryDateValidationResult validateExpiryDate = cardValidator.validateExpiryDate(this.mExpiryDateEditText.getText().toString());
        if (validateExpiryDate.getValidity() != validity2) {
            return null;
        }
        CardValidator.SecurityCodeValidationResult securityCodeValidationResult = getSecurityCodeValidationResult();
        if (securityCodeValidationResult.getValidity() != validity2) {
            return null;
        }
        return new Card.Builder().setNumber(validateNumber.getNumber()).setExpiryDate(validateExpiryDate.getExpiryMonth().intValue(), validateExpiryDate.getExpiryYear().intValue()).setSecurityCode(securityCodeValidationResult.getSecurityCode()).build();
    }

    /* access modifiers changed from: private */
    @Nullable
    public String[] replaceCurrencyCodeWithSymbol(@NonNull String[] strArr) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        boolean z11 = false;
        for (int i11 = 0; i11 < strArr2.length; i11++) {
            try {
                Currency instance = Currency.getInstance(strArr2[i11]);
                if (instance == null) {
                    continue;
                } else if (z11) {
                    return null;
                } else {
                    strArr2[i11] = instance.getSymbol();
                    z11 = true;
                }
            } catch (Exception unused) {
            }
        }
        return strArr2;
    }

    /* access modifiers changed from: private */
    public void setupCardLogoViews() {
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_cardTypes);
        if (this.mAllowedPaymentMethods.size() == 1) {
            recyclerView.setVisibility(8);
            Rembrandt.createDefaultLogoRequestArgs(getApplication(), N().newBuilder(this.mAllowedPaymentMethods.get(0)).buildCallable()).into((LifecycleOwner) this, (Target) new Target() {
                private int mInsetRight;

                {
                    this.mInsetRight = CardDetailsActivity.this.getResources().getDimensionPixelSize(R.dimen.standard_half_margin);
                }

                public void setImageDrawable(@Nullable Drawable drawable) {
                    InsetDrawable insetDrawable = new InsetDrawable(drawable, 0, 0, this.mInsetRight, 0);
                    Resources resources = CardDetailsActivity.this.getResources();
                    insetDrawable.setBounds(0, 0, resources.getDimensionPixelSize(R.dimen.payment_method_logo_width) + this.mInsetRight, resources.getDimensionPixelSize(R.dimen.payment_method_logo_height));
                    TextViewUtil.setCompoundDrawableLeft(CardDetailsActivity.this.mCardNumberEditText, insetDrawable);
                }
            });
            return;
        }
        final LogoAdapter logoAdapter = new LogoAdapter(this, recyclerView, N());
        recyclerView.setItemAnimator(new CheckoutItemAnimator(getResources()));
        recyclerView.setAdapter(logoAdapter);
        recyclerView.addItemDecoration(new SpacingItemDecoration(getResources().getDimensionPixelSize(R.dimen.standard_half_margin)));
        this.mCardNumberEditText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                CardDetailsActivity.this.updateCardLogosRecyclerView(recyclerView, logoAdapter);
            }
        });
        updateCardLogosRecyclerView(recyclerView, logoAdapter);
    }

    /* access modifiers changed from: private */
    public void setupCardNumberEditText(boolean z11) {
        TextViewUtil.addInputFilter(this.mCardNumberEditText, new InputFilter.LengthFilter(23));
        this.mCardNumberEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                CardDetailsActivity.this.validateCardNumberEditText();
                CardDetailsActivity.this.mLockToCheckmarkAnimationDelegate.onFocusChanged();
            }
        });
        this.mCardNumberEditText.addTextChangedListener(new SimpleTextWatcher() {
            private boolean mDeleted;

            public void afterTextChanged(Editable editable) {
                CardDetailsActivity.this.validateCardNumberEditText();
                CardDetailsActivity.this.updatePayButtonState();
                if (!this.mDeleted && CardDetailsActivity.this.isCardNumberValidForUser()) {
                    KeyboardUtil.showAndSelect(CardDetailsActivity.this.mExpiryDateEditText);
                }
                CardDetailsActivity.this.mLockToCheckmarkAnimationDelegate.onTextChanged();
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                this.mDeleted = i13 == 0;
            }
        });
        Cards.FORMATTER.attachAsYouTypeNumberFormatter(this.mCardNumberEditText);
        if (z11) {
            this.mCardNumberEditText.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    public void setupExpiryDateEditText() {
        this.mExpiryDateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                CardDetailsActivity.this.validateExpiryDateEditText();
            }
        });
        this.mExpiryDateEditText.addTextChangedListener(new SimpleTextWatcher() {
            private boolean mDeleted;

            public void afterTextChanged(Editable editable) {
                CardDetailsActivity.this.validateExpiryDateEditText();
                CardDetailsActivity.this.updatePayButtonState();
                PaymentMethodUtil.Requirement requirementForInputDetail = PaymentMethodUtil.getRequirementForInputDetail(CardDetails.KEY_ENCRYPTED_SECURITY_CODE, (List<PaymentMethod>) CardDetailsActivity.this.mAllowedPaymentMethods);
                if (!this.mDeleted && requirementForInputDetail != PaymentMethodUtil.Requirement.NONE && Cards.VALIDATOR.validateExpiryDate(CardDetailsActivity.this.mExpiryDateEditText.getText().toString()).getValidity() == CardValidator.Validity.VALID) {
                    KeyboardUtil.showAndSelect(CardDetailsActivity.this.mSecurityCodeEditText);
                }
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                this.mDeleted = i13 == 0;
            }
        });
        Cards.FORMATTER.attachAsYouTypeExpiryDateFormatter(this.mExpiryDateEditText);
    }

    /* access modifiers changed from: private */
    public boolean setupHolderNameViews(boolean z11) {
        CustomTextInputLayout customTextInputLayout = (CustomTextInputLayout) findViewById(R.id.customTextInputLayout_holderName);
        this.mHolderNameEditText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                CardDetailsActivity.this.validateHolderNameEditText();
                CardDetailsActivity.this.updatePayButtonState();
            }
        });
        this.mHolderNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                CardDetailsActivity.this.validateHolderNameEditText();
            }
        });
        PaymentMethodUtil.Requirement requirementForInputDetail = PaymentMethodUtil.getRequirementForInputDetail("holderName", this.mAllowedPaymentMethods);
        if (requirementForInputDetail == PaymentMethodUtil.Requirement.NONE) {
            customTextInputLayout.setVisibility(8);
            return false;
        }
        customTextInputLayout.setVisibility(0);
        if (!z11 || requirementForInputDetail != PaymentMethodUtil.Requirement.REQUIRED) {
            return false;
        }
        this.mHolderNameEditText.requestFocus();
        return true;
    }

    /* access modifiers changed from: private */
    public void setupInstallmentViews() {
        InputDetail inputDetail;
        Adapter forSpinner = Adapter.forSpinner(new Adapter.TextDelegate<Item>() {
            @NonNull
            public String getText(@NonNull Item item) {
                String[] i02 = CardDetailsActivity.this.replaceCurrencyCodeWithSymbol(item.getName().split("\\s"));
                return i02 != null ? TextUtils.join(" ", i02) : item.getName();
            }
        });
        this.mInstallmentsSpinner = (Spinner) findViewById(R.id.spinner_installments);
        Iterator<PaymentMethod> it = this.mAllowedPaymentMethods.iterator();
        if (!it.hasNext()) {
            inputDetail = null;
        } else {
            inputDetail = InputDetailImpl.findByKey(it.next().getInputDetails(), CardDetails.KEY_INSTALLMENTS);
            if (inputDetail != null) {
                while (true) {
                    if (it.hasNext()) {
                        if (!inputDetail.equals(InputDetailImpl.findByKey(it.next().getInputDetails(), CardDetails.KEY_INSTALLMENTS))) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                inputDetail = null;
            }
        }
        if (inputDetail == null) {
            this.mInstallmentsContainer.setVisibility(8);
            this.mInstallmentsSpinner.setAdapter((SpinnerAdapter) null);
            forSpinner.setItems((List) null);
            return;
        }
        this.mInstallmentsContainer.setVisibility(0);
        this.mInstallmentsSpinner.setAdapter(forSpinner);
        forSpinner.setItems(inputDetail.getItems());
    }

    /* access modifiers changed from: private */
    public void setupPayButton() {
        PayButtonUtil.setPayButtonText(this, this.mTargetPaymentMethod, (TextView) this.mPayButton, this.mSurchargeTextView);
        this.mPayButton.setOnClickListener(this);
    }

    /* access modifiers changed from: private */
    public void setupPhoneNumberViews() {
        CustomTextInputLayout customTextInputLayout = (CustomTextInputLayout) findViewById(R.id.customTextInputLayout_phoneNumber);
        this.mPhoneNumberEditText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                CardDetailsActivity.this.updatePayButtonState();
            }
        });
        if (PaymentMethodUtil.getRequirementForInputDetail("telephoneNumber", this.mAllowedPaymentMethods) == PaymentMethodUtil.Requirement.NONE) {
            customTextInputLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void setupSecurityCodeViews() {
        CustomTextInputLayout customTextInputLayout = (CustomTextInputLayout) findViewById(R.id.customTextInputLayout_securityCode);
        this.mSecurityCodeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                CardDetailsActivity.this.validateSecurityCodeEditText();
            }
        });
        this.mSecurityCodeEditText.addTextChangedListener(new SimpleTextWatcher() {
            private boolean mDeleted;

            public void afterTextChanged(Editable editable) {
                CardDetailsActivity.this.validateSecurityCodeEditText();
                CardDetailsActivity.this.updatePayButtonState();
                if (!this.mDeleted && CardDetailsActivity.this.mAllowedPaymentMethods.size() == 1 && CardDetailsActivity.this.getSecurityCodeValidationResult().getValidity() == CardValidator.Validity.VALID && PaymentMethodUtil.getRequirementForInputDetail("telephoneNumber", (List<PaymentMethod>) CardDetailsActivity.this.mAllowedPaymentMethods) != PaymentMethodUtil.Requirement.NONE) {
                    KeyboardUtil.showAndSelect(CardDetailsActivity.this.mPhoneNumberEditText);
                }
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                this.mDeleted = i13 == 0;
            }
        });
        if (PaymentMethodUtil.getRequirementForInputDetail(CardDetails.KEY_ENCRYPTED_SECURITY_CODE, this.mAllowedPaymentMethods) == PaymentMethodUtil.Requirement.NONE) {
            customTextInputLayout.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void setupStoreDetailsSwitchCompat() {
        boolean z11;
        Iterator<PaymentMethod> it = this.mAllowedPaymentMethods.iterator();
        while (true) {
            if (it.hasNext()) {
                if (InputDetailImpl.findByKey(it.next().getInputDetails(), "storeDetails") == null) {
                    z11 = false;
                    break;
                }
            } else {
                z11 = true;
                break;
            }
        }
        if (z11) {
            this.mStoreDetailsSwitchCompat.setVisibility(0);
        } else {
            this.mStoreDetailsSwitchCompat.setVisibility(8);
        }
    }

    private void showCardReaderTutorialFragment() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.executePendingTransactions();
        String str = NfcCardReaderTutorialFragment.TAG;
        if (supportFragmentManager.findFragmentByTag(str) == null) {
            NfcCardReaderTutorialFragment.newInstance().show(supportFragmentManager, str);
        }
    }

    /* access modifiers changed from: private */
    public void updateCardLogosRecyclerView(@NonNull RecyclerView recyclerView, @NonNull LogoAdapter logoAdapter) {
        int i11;
        List<CardType> cardTypesToDisplay = getCardTypesToDisplay();
        logoAdapter.setTxVariantProviders(cardTypesToDisplay);
        if (cardTypesToDisplay.size() > 0) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        recyclerView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public void updatePayButtonState() {
        this.mPayButton.setEnabled(this.mConnectivityDelegate.isConnectedOrConnecting() && isValidCardDetails());
    }

    /* access modifiers changed from: private */
    public void validateCardNumberEditText() {
        CardValidator.NumberValidationResult validateNumber = Cards.VALIDATOR.validateNumber(this.mCardNumberEditText.getText().toString());
        if (validateNumber.getValidity() == CardValidator.Validity.VALID) {
            TextViewUtil.setDefaultTextColor(this.mCardNumberEditText);
        } else if (!this.mCardNumberEditText.hasFocus() || validateNumber.getValidity() != CardValidator.Validity.PARTIAL) {
            TextViewUtil.setErrorTextColor(this.mCardNumberEditText);
        } else {
            TextViewUtil.setDefaultTextColor(this.mCardNumberEditText);
        }
    }

    /* access modifiers changed from: private */
    public void validateExpiryDateEditText() {
        CardValidator.ExpiryDateValidationResult validateExpiryDate = Cards.VALIDATOR.validateExpiryDate(this.mExpiryDateEditText.getText().toString());
        if (validateExpiryDate.getValidity() == CardValidator.Validity.VALID) {
            TextViewUtil.setDefaultTextColor(this.mExpiryDateEditText);
        } else if (!this.mExpiryDateEditText.hasFocus() || validateExpiryDate.getValidity() != CardValidator.Validity.PARTIAL) {
            TextViewUtil.setErrorTextColor(this.mExpiryDateEditText);
        } else {
            TextViewUtil.setDefaultTextColor(this.mExpiryDateEditText);
        }
    }

    /* access modifiers changed from: private */
    public void validateHolderNameEditText() {
        CardValidator.HolderNameValidationResult holderNameValidationResult = getHolderNameValidationResult();
        if (holderNameValidationResult.getValidity() == CardValidator.Validity.VALID) {
            TextViewUtil.setDefaultTextColor(this.mHolderNameEditText);
        } else if (!this.mHolderNameEditText.hasFocus() || holderNameValidationResult.getValidity() != CardValidator.Validity.PARTIAL) {
            TextViewUtil.setErrorTextColor(this.mHolderNameEditText);
        } else {
            TextViewUtil.setDefaultTextColor(this.mHolderNameEditText);
        }
    }

    /* access modifiers changed from: private */
    public void validateSecurityCodeEditText() {
        CardValidator.SecurityCodeValidationResult securityCodeValidationResult = getSecurityCodeValidationResult();
        if (securityCodeValidationResult.getValidity() == CardValidator.Validity.VALID) {
            TextViewUtil.setDefaultTextColor(this.mSecurityCodeEditText);
        } else if (!this.mSecurityCodeEditText.hasFocus() || securityCodeValidationResult.getValidity() != CardValidator.Validity.PARTIAL) {
            TextViewUtil.setErrorTextColor(this.mSecurityCodeEditText);
        } else {
            TextViewUtil.setDefaultTextColor(this.mSecurityCodeEditText);
        }
    }

    public void P(@NonNull CheckoutException checkoutException) {
        super.P(checkoutException);
        updatePayButtonState();
    }

    @Nullable
    public CardDetails buildCardDetails() throws EncryptionException {
        if (!isValidCardDetails()) {
            return null;
        }
        CardValidator.HolderNameValidationResult holderNameValidationResult = getHolderNameValidationResult();
        PhoneNumberUtil.ValidationResult phoneNumberValidationResult = getPhoneNumberValidationResult();
        Card parseCardFromInput = parseCardFromInput();
        PaymentSession O = O();
        if (O == null) {
            return null;
        }
        try {
            EncryptedCard call = Cards.ENCRYPTOR.encryptFields(parseCardFromInput, O.getGenerationTime(), (String) Objects.requireNonNull(O.getPublicKey(), "Public key for card payments has not been generated.")).call();
            return new CardDetails.Builder().setHolderName(holderNameValidationResult.getHolderName()).setEncryptedCardNumber(call.getEncryptedNumber()).setEncryptedExpiryMonth(call.getEncryptedExpiryMonth()).setEncryptedExpiryYear(call.getEncryptedExpiryYear()).setEncryptedSecurityCode(call.getEncryptedSecurityCode()).setPhoneNumber(phoneNumberValidationResult.getPhoneNumber()).setStoreDetails(getStoreDetails()).setInstallments(getInstallments()).build();
        } catch (EncryptionException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new RuntimeException("Failed to encrypt card.", e12);
        }
    }

    public boolean isNfcEnabledOnDevice() {
        NfcCardReader nfcCardReader = this.mNfcCardReader;
        return nfcCardReader != null && nfcCardReader.isNfcEnabledOnDevice();
    }

    public boolean isValidCardDetails() {
        if (O() == null || getHolderNameValidationResult().getValidity() != CardValidator.Validity.VALID || getPhoneNumberValidationResult().getValidity() != PhoneNumberUtil.Validity.VALID || parseCardFromInput() == null) {
            return false;
        }
        return true;
    }

    public void onClick(@NonNull View view) {
        if (view == this.mPayButton) {
            try {
                CardDetails buildCardDetails = buildCardDetails();
                if (buildCardDetails != null) {
                    getPaymentHandler().initiatePayment(this.mTargetPaymentMethod, buildCardDetails);
                }
                this.mPayButton.setEnabled(false);
            } catch (EncryptionException e11) {
                ErrorDialogFragment.newInstance((Context) this, (Throwable) e11).showIfNotShown(getSupportFragmentManager());
            }
        }
    }

    public void onCreate(@Nullable final Bundle bundle) {
        super.onCreate(bundle);
        this.mTargetPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_TARGET_PAYMENT_METHOD);
        setContentView(R.layout.activity_card_details);
        setTitle(this.mTargetPaymentMethod.getName());
        findViewById(16908290).setVisibility(8);
        this.mHolderNameEditText = (EditText) findViewById(R.id.editText_holderName);
        EditText editText = (EditText) findViewById(R.id.editText_cardNumber);
        this.mCardNumberEditText = editText;
        this.mLockToCheckmarkAnimationDelegate = new LockToCheckmarkAnimationDelegate(editText, new LockToCheckmarkAnimationDelegate.ValidationCallback() {
            public boolean isValid() {
                return CardDetailsActivity.this.isCardNumberValidForUser();
            }
        });
        this.mExpiryDateEditText = (EditText) findViewById(R.id.editText_expiryDate);
        this.mSecurityCodeEditText = (EditText) findViewById(R.id.editText_securityCode);
        this.mPhoneNumberEditText = (EditText) findViewById(R.id.editText_phoneNumber);
        this.mInstallmentsContainer = findViewById(R.id.linearLayout_installmentsContainer);
        this.mStoreDetailsSwitchCompat = (SwitchCompat) findViewById(R.id.switchCompat_storeDetails);
        this.mPayButton = (Button) findViewById(R.id.button_pay);
        this.mSurchargeTextView = (TextView) findViewById(R.id.textView_surcharge);
        try {
            this.mNfcCardReader = NfcCardReader.getInstance(this, new NfcCardReaderListener());
        } catch (NoClassDefFoundError unused) {
            this.mNfcCardReader = null;
        }
        this.mConnectivityDelegate = new ConnectivityDelegate(this, new Observer<NetworkInfo>() {
            public void onChanged(@Nullable NetworkInfo networkInfo) {
                CardDetailsActivity.this.updatePayButtonState();
            }
        });
        PaymentHandler paymentHandler = getPaymentHandler();
        final Observable<PaymentSession> paymentSessionObservable = paymentHandler.getPaymentSessionObservable();
        paymentSessionObservable.observe(this, new com.adyen.checkout.core.Observer<PaymentSession>() {
            public void onChanged(@NonNull PaymentSession paymentSession) {
                CardDetailsActivity cardDetailsActivity = CardDetailsActivity.this;
                List unused = cardDetailsActivity.mAllowedPaymentMethods = cardDetailsActivity.getAllowedPaymentMethods(paymentSession);
                boolean z11 = true;
                boolean z12 = bundle == null;
                boolean o02 = CardDetailsActivity.this.setupHolderNameViews(z12);
                CardDetailsActivity cardDetailsActivity2 = CardDetailsActivity.this;
                if (o02 || !z12) {
                    z11 = false;
                }
                cardDetailsActivity2.setupCardNumberEditText(z11);
                CardDetailsActivity.this.setupCardLogoViews();
                CardDetailsActivity.this.setupExpiryDateEditText();
                CardDetailsActivity.this.setupSecurityCodeViews();
                CardDetailsActivity.this.setupPhoneNumberViews();
                CardDetailsActivity.this.setupInstallmentViews();
                CardDetailsActivity.this.setupStoreDetailsSwitchCompat();
                CardDetailsActivity.this.setupPayButton();
                CardDetailsActivity.this.updatePayButtonState();
                CardDetailsActivity.this.findViewById(16908290).setVisibility(0);
                paymentSessionObservable.removeObserver(this);
            }
        });
        paymentHandler.setAdditionalDetailsHandler(this, new AdditionalDetailsHandler() {
            public void onAdditionalDetailsRequired(@NonNull AdditionalDetails additionalDetails) {
                PaymentMethod findByType;
                if (PaymentMethodTypes.CUP.equals(additionalDetails.getPaymentMethodType())) {
                    List<InputDetail> inputDetails = additionalDetails.getInputDetails();
                    if (inputDetails.size() == 1 && CupSecurePlusDetails.KEY_SMS_CODE.equals(inputDetails.get(0).getKey()) && (findByType = PaymentMethodImpl.findByType(CardDetailsActivity.this.mAllowedPaymentMethods, PaymentMethodTypes.CUP)) != null) {
                        CardDetailsActivity cardDetailsActivity = CardDetailsActivity.this;
                        CardDetailsActivity.this.startActivity(CupSecurePlusDetailsActivity.newIntent(cardDetailsActivity, cardDetailsActivity.getPaymentReference(), findByType, additionalDetails));
                    }
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        getMenuInflater().inflate(R.menu.menu_card_details, menu);
        MenuItem findItem = menu.findItem(R.id.action_card_reader_tutorial);
        if (this.mNfcCardReader != null) {
            findItem.setVisible(true);
            ThemeUtil.setTintFromAttributeColor(ThemeUtil.getThemedActionBarContext(this), findItem.getIcon(), R.attr.colorIconActiveFocused);
        } else {
            findItem.setVisible(false);
        }
        return true;
    }

    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        View findFocus = getWindow().getDecorView().findFocus();
        if (findFocus != null) {
            KeyboardUtil.show(findFocus);
        }
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_card_reader_tutorial) {
            return super.onOptionsItemSelected(menuItem);
        }
        showCardReaderTutorialFragment();
        return true;
    }

    public void onPause() {
        super.onPause();
        NfcCardReader nfcCardReader = this.mNfcCardReader;
        if (nfcCardReader != null) {
            nfcCardReader.disable();
        }
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.mLockToCheckmarkAnimationDelegate.onTextChanged();
    }

    public void onResume() {
        super.onResume();
        updatePayButtonState();
        NfcCardReader nfcCardReader = this.mNfcCardReader;
        if (nfcCardReader != null) {
            nfcCardReader.enableWithSounds(true);
        }
    }
}
