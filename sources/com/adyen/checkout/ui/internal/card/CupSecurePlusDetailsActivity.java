package com.adyen.checkout.ui.internal.card;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.AdditionalDetails;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.CupSecurePlusDetails;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.util.internal.SimpleTextWatcher;

public class CupSecurePlusDetailsActivity extends CheckoutDetailsActivity {
    private static final int EXPECTED_SMS_CODE_SIZE = 6;
    private static final String EXTRA_ADDITIONAL_DETAILS = "EXTRA_ADDITIONAL_DETAILS";
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private AdditionalDetails mAdditionalDetails;
    private Button mPayButton;
    private PaymentMethod mPaymentMethod;
    private EditText mSmsCodeEditText;
    private TextView mSmsCodePromptTextView;
    private TextView mSurchargeTextView;

    /* access modifiers changed from: private */
    @NonNull
    public String getTrimmedSmsCode() {
        return this.mSmsCodeEditText.getText().toString().trim();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod, @NonNull AdditionalDetails additionalDetails) {
        Intent intent = new Intent(context, CupSecurePlusDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        intent.putExtra(EXTRA_ADDITIONAL_DETAILS, additionalDetails);
        return intent;
    }

    /* access modifiers changed from: private */
    public void updatePayButton() {
        this.mPayButton.setEnabled(getTrimmedSmsCode().length() == 6);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mPaymentMethod = (PaymentMethod) intent.getParcelableExtra(EXTRA_PAYMENT_METHOD);
        this.mAdditionalDetails = (AdditionalDetails) intent.getParcelableExtra(EXTRA_ADDITIONAL_DETAILS);
        setContentView(R.layout.activity_cup_secure_plus_details);
        this.mSmsCodePromptTextView = (TextView) findViewById(R.id.textView_smsCodePrompt);
        EditText editText = (EditText) findViewById(R.id.editText_smsCode);
        this.mSmsCodeEditText = editText;
        editText.addTextChangedListener(new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                CupSecurePlusDetailsActivity.this.updatePayButton();
            }
        });
        Button button = (Button) findViewById(R.id.button_pay);
        this.mPayButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CupSecurePlusDetailsActivity.this.getPaymentHandler().submitAdditionalDetails(new CupSecurePlusDetails.Builder(CupSecurePlusDetailsActivity.this.getTrimmedSmsCode()).build());
            }
        });
        TextView textView = (TextView) findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
        updatePayButton();
    }
}
