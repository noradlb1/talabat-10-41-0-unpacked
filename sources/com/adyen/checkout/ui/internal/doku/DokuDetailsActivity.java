package com.adyen.checkout.ui.internal.doku;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.DokuDetails;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.KeyboardUtil;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.common.util.TextViewUtil;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import java.util.regex.Matcher;

public class DokuDetailsActivity extends CheckoutDetailsActivity implements View.OnClickListener {
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private EditText mFirstNameEditText;
    private EditText mLastNameEditText;
    private Button mPayButton;
    private PaymentMethod mPaymentMethod;
    private EditText mShopperEmailEditText;
    private TextView mSurchargeTextView;

    public final class ValidationListener extends SimpleTextWatcher implements View.OnFocusChangeListener {
        private ValidationListener() {
        }

        public void afterTextChanged(Editable editable) {
            boolean unused = DokuDetailsActivity.this.validate();
        }

        public void onFocusChange(View view, boolean z11) {
            boolean unused = DokuDetailsActivity.this.validate();
        }
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, DokuDetailsActivity.class);
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
        boolean validateEmail = validateEmail() & validateFirstName() & validateLastName();
        this.mPayButton.setEnabled(validateEmail);
        return validateEmail;
    }

    private boolean validateEmail() {
        boolean z11;
        Matcher matcher = Patterns.EMAIL_ADDRESS.matcher(this.mShopperEmailEditText.getText().toString().trim());
        boolean matches = matcher.matches();
        EditText editText = this.mShopperEmailEditText;
        if (matches || (editText.hasFocus() && matcher.hitEnd())) {
            z11 = true;
        } else {
            z11 = false;
        }
        updateTextColor(editText, z11);
        return matches;
    }

    private boolean validateFirstName() {
        boolean z11 = !this.mLastNameEditText.getText().toString().trim().isEmpty();
        updateTextColor(this.mLastNameEditText, z11);
        return z11;
    }

    private boolean validateLastName() {
        boolean z11 = !this.mFirstNameEditText.getText().toString().trim().isEmpty();
        updateTextColor(this.mFirstNameEditText, z11);
        return z11;
    }

    public void onClick(@NonNull View view) {
        if (view == this.mPayButton && validate()) {
            getPaymentHandler().initiatePayment(this.mPaymentMethod, new DokuDetails.Builder(this.mShopperEmailEditText.getText().toString().trim(), this.mFirstNameEditText.getText().toString().trim(), this.mLastNameEditText.getText().toString().trim()).build());
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        setContentView(R.layout.activity_doku_details);
        setTitle(this.mPaymentMethod.getName());
        ValidationListener validationListener = new ValidationListener();
        EditText editText = (EditText) findViewById(R.id.editText_shopperEmail);
        this.mShopperEmailEditText = editText;
        editText.addTextChangedListener(validationListener);
        this.mShopperEmailEditText.setOnFocusChangeListener(validationListener);
        EditText editText2 = (EditText) findViewById(R.id.editText_lastName);
        this.mLastNameEditText = editText2;
        editText2.addTextChangedListener(validationListener);
        this.mLastNameEditText.setOnFocusChangeListener(validationListener);
        EditText editText3 = (EditText) findViewById(R.id.editText_firstName);
        this.mFirstNameEditText = editText3;
        editText3.addTextChangedListener(validationListener);
        this.mFirstNameEditText.setOnFocusChangeListener(validationListener);
        Button button = (Button) findViewById(R.id.button_continue);
        this.mPayButton = button;
        button.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
        validate();
        if (bundle == null) {
            KeyboardUtil.show(this.mShopperEmailEditText);
        }
    }
}
