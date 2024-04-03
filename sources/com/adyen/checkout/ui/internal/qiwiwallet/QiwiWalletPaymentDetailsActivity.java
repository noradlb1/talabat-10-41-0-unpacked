package com.adyen.checkout.ui.internal.qiwiwallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.InputDetail;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.core.model.QiwiWalletDetails;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.Adapter;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import java.util.ArrayList;
import java.util.List;

public class QiwiWalletPaymentDetailsActivity extends CheckoutDetailsActivity {
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private Button mPayButton;
    /* access modifiers changed from: private */
    public PaymentMethod mPaymentMethod;
    /* access modifiers changed from: private */
    public EditText mPhoneNumberEditText;
    /* access modifiers changed from: private */
    public Spinner mPhoneNumberPrefixSpinner;
    private TextView mSurchargeTextView;

    @NonNull
    private List<Item> getItems(@NonNull PaymentMethod paymentMethod) {
        List<InputDetail> inputDetails = paymentMethod.getInputDetails();
        if (inputDetails != null) {
            for (InputDetail next : inputDetails) {
                List<Item> items = next.getItems();
                if (items != null && QiwiWalletDetails.KEY_TELEPHONE_NUMBER_PREFIX.equals(next.getKey())) {
                    return items;
                }
            }
        }
        return new ArrayList();
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, QiwiWalletPaymentDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        setContentView(R.layout.activity_qiwi_wallet_details);
        setTitle(this.mPaymentMethod.getName());
        this.mPhoneNumberPrefixSpinner = (Spinner) findViewById(R.id.spinner_phoneNumberPrefix);
        Adapter forSpinner = Adapter.forSpinner(new Adapter.TextDelegate<Item>() {
            @NonNull
            public String getText(@NonNull Item item) {
                return QiwiWalletPaymentDetailsActivity.this.getString(R.string.checkout_qiwiwallet_country_code_format, new Object[]{item.getId(), item.getName()});
            }
        });
        forSpinner.setItems(getItems(this.mPaymentMethod));
        this.mPhoneNumberPrefixSpinner.setAdapter(forSpinner);
        this.mPhoneNumberEditText = (EditText) findViewById(R.id.editText_phoneNumber);
        Button button = (Button) findViewById(R.id.button_continue);
        this.mPayButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                QiwiWalletPaymentDetailsActivity.this.getPaymentHandler().initiatePayment(QiwiWalletPaymentDetailsActivity.this.mPaymentMethod, new QiwiWalletDetails.Builder(((Item) QiwiWalletPaymentDetailsActivity.this.mPhoneNumberPrefixSpinner.getSelectedItem()).getId(), QiwiWalletPaymentDetailsActivity.this.mPhoneNumberEditText.getText().toString().trim()).build());
            }
        });
        TextView textView = (TextView) findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
    }
}
