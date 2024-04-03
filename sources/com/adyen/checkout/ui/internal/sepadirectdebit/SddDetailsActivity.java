package com.adyen.checkout.ui.internal.sepadirectdebit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.SepaDirectDebitDetails;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.KeyboardUtil;
import com.adyen.checkout.ui.internal.common.util.LockToCheckmarkAnimationDelegate;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.common.util.SnackbarSwipeHandler;
import com.adyen.checkout.ui.internal.common.util.TextViewUtil;
import com.adyen.checkout.ui.internal.common.util.recyclerview.CheckoutItemAnimator;
import com.adyen.checkout.ui.internal.common.util.recyclerview.SpacingItemDecoration;
import com.adyen.checkout.ui.internal.sepadirectdebit.IbanSuggestionsAdapter;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import com.adyen.checkout.util.sepadirectdebit.AsYouTypeIbanFormatter;
import com.adyen.checkout.util.sepadirectdebit.HolderName;
import com.adyen.checkout.util.sepadirectdebit.Iban;
import com.google.android.material.snackbar.Snackbar;

public class SddDetailsActivity extends CheckoutDetailsActivity implements IbanSuggestionsAdapter.Listener, View.OnClickListener {
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private static final int SNACKBAR_DURATION = 10000;
    /* access modifiers changed from: private */
    public EditText mAccountHolderNameEditText;
    private SwitchCompat mConsentSwitchCompat;
    /* access modifiers changed from: private */
    public EditText mIbanEditText;
    /* access modifiers changed from: private */
    public IbanSuggestionsAdapter mIbanSuggestionsAdapter;
    /* access modifiers changed from: private */
    public RecyclerView mIbanSuggestionsRecyclerView;
    private Button mPayButton;
    private PaymentMethod mPaymentMethod;
    /* access modifiers changed from: private */
    public Snackbar mSnackbar;
    private TextView mSurchargeTextView;

    public final class ValidationListener extends SimpleTextWatcher implements View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener {
        private final LockToCheckmarkAnimationDelegate mDelegate;
        private boolean mDeleted;

        public void afterTextChanged(Editable editable) {
            boolean z11;
            boolean unused = SddDetailsActivity.this.validate();
            if (Iban.parse(editable.toString()) != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (editable == SddDetailsActivity.this.mIbanEditText.getEditableText() && !this.mDeleted && SddDetailsActivity.this.mIbanEditText.getSelectionEnd() == SddDetailsActivity.this.mIbanEditText.length() && z11) {
                SddDetailsActivity.this.mAccountHolderNameEditText.requestFocus();
            }
            this.mDelegate.onTextChanged();
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
            boolean unused = SddDetailsActivity.this.validate();
        }

        public void onFocusChange(View view, boolean z11) {
            if (!z11) {
                SddDetailsActivity.this.checkSuggestZeroPaddedIban();
            }
            this.mDelegate.onFocusChanged();
            boolean unused = SddDetailsActivity.this.validate();
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.mDeleted = i13 == 0;
        }

        private ValidationListener() {
            this.mDelegate = new LockToCheckmarkAnimationDelegate(SddDetailsActivity.this.mIbanEditText, new LockToCheckmarkAnimationDelegate.ValidationCallback(SddDetailsActivity.this) {
                public boolean isValid() {
                    Iban parse = Iban.parse(SddDetailsActivity.this.mIbanEditText.getText().toString());
                    if (parse == null || !parse.isSepa()) {
                        return false;
                    }
                    return true;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void checkSuggestZeroPaddedIban() {
        String obj = this.mIbanEditText.getText().toString();
        Iban parseByAddingMissingZeros = Iban.parseByAddingMissingZeros(obj);
        if (this.mSnackbar == null && Iban.parse(obj) == null && parseByAddingMissingZeros != null && parseByAddingMissingZeros.isSepa()) {
            final String format = Iban.format(parseByAddingMissingZeros.getValue());
            Snackbar snackbar = (Snackbar) Snackbar.make((View) this.mIbanEditText, R.string.checkout_sdd_iban_suggestion, -2).setAction((CharSequence) format, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    SddDetailsActivity.this.mIbanEditText.setText(format);
                }
            }).addCallback(new Snackbar.Callback() {
                public void onDismissed(Snackbar snackbar, int i11) {
                    Snackbar unused = SddDetailsActivity.this.mSnackbar = null;
                }
            });
            this.mSnackbar = snackbar;
            snackbar.show();
            SnackbarSwipeHandler.attach(this, this.mSnackbar);
            this.mIbanEditText.postDelayed(new Runnable() {
                public void run() {
                    if (SddDetailsActivity.this.mSnackbar != null) {
                        SddDetailsActivity.this.mSnackbar.dismiss();
                    }
                }
            }, 10000);
        }
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, SddDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    private void updateTextColor(@NonNull TextView textView, boolean z11) {
        if (z11) {
            TextViewUtil.setDefaultTextColor(textView);
        } else {
            TextViewUtil.setErrorTextColor(textView);
        }
    }

    /* access modifiers changed from: private */
    public boolean validate() {
        boolean validateIban = validateIban() & validateHolderName() & this.mConsentSwitchCompat.isChecked();
        this.mPayButton.setEnabled(validateIban);
        return validateIban;
    }

    private boolean validateHolderName() {
        boolean z11;
        String obj = this.mAccountHolderNameEditText.getText().toString();
        boolean isValid = HolderName.isValid(obj);
        EditText editText = this.mAccountHolderNameEditText;
        if (isValid || (editText.hasFocus() && HolderName.isPartial(obj))) {
            z11 = true;
        } else {
            z11 = false;
        }
        updateTextColor(editText, z11);
        return isValid;
    }

    private boolean validateIban() {
        boolean z11;
        String obj = this.mIbanEditText.getText().toString();
        Iban parse = Iban.parse(obj);
        boolean z12 = true;
        if (parse == null || !parse.isSepa()) {
            z11 = false;
        } else {
            z11 = true;
        }
        EditText editText = this.mIbanEditText;
        if (!z11 && (!editText.hasFocus() || !Iban.isPartial(obj))) {
            z12 = false;
        }
        updateTextColor(editText, z12);
        return z11;
    }

    public void onClick(@NonNull View view) {
        if (view == this.mPayButton && validate()) {
            Iban parse = Iban.parse(this.mIbanEditText.getText().toString());
            getPaymentHandler().initiatePayment(this.mPaymentMethod, new SepaDirectDebitDetails.Builder(parse.getValue(), this.mAccountHolderNameEditText.getText().toString().trim()).build());
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        setContentView(R.layout.activity_sdd_details);
        setTitle(this.mPaymentMethod.getName());
        this.mIbanEditText = (EditText) findViewById(R.id.editText_iban);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_ibanSuggestions);
        this.mIbanSuggestionsRecyclerView = recyclerView;
        recyclerView.setItemAnimator(new CheckoutItemAnimator(getResources()));
        IbanSuggestionsAdapter ibanSuggestionsAdapter = new IbanSuggestionsAdapter(this.mIbanEditText, this);
        this.mIbanSuggestionsAdapter = ibanSuggestionsAdapter;
        this.mIbanSuggestionsRecyclerView.setAdapter(ibanSuggestionsAdapter);
        this.mIbanSuggestionsRecyclerView.addItemDecoration(new SpacingItemDecoration(getResources().getDimensionPixelSize(R.dimen.standard_half_margin)));
        this.mIbanEditText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                SddDetailsActivity.this.mIbanSuggestionsRecyclerView.setVisibility(SddDetailsActivity.this.mIbanSuggestionsAdapter.getItemCount() == 0 ? 8 : 0);
            }
        });
        ValidationListener validationListener = new ValidationListener();
        this.mIbanEditText.addTextChangedListener(validationListener);
        this.mIbanEditText.setOnFocusChangeListener(validationListener);
        AsYouTypeIbanFormatter.attach(this.mIbanEditText);
        EditText editText = (EditText) findViewById(R.id.editText_accountHolderName);
        this.mAccountHolderNameEditText = editText;
        editText.addTextChangedListener(validationListener);
        this.mAccountHolderNameEditText.setOnFocusChangeListener(validationListener);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.switchCompat_consent);
        this.mConsentSwitchCompat = switchCompat;
        switchCompat.setOnCheckedChangeListener(validationListener);
        Button button = (Button) findViewById(R.id.button_continue);
        this.mPayButton = button;
        button.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
        validate();
        if (bundle == null) {
            KeyboardUtil.show(this.mIbanEditText);
        }
    }

    public void onSuggestionClick(@NonNull Suggestion suggestion) {
        this.mIbanEditText.getEditableText().insert(suggestion.getTargetIndex(), suggestion.getValue());
        EditText editText = this.mIbanEditText;
        editText.setSelection(editText.length());
    }
}
