package com.adyen.checkout.ui.internal.issuer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.model.IssuerDetails;
import com.adyen.checkout.core.model.Item;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.ui.internal.common.util.recyclerview.HeaderItemDecoration;
import com.adyen.checkout.ui.internal.issuer.IssuersAdapter;

public class IssuerDetailsActivity extends CheckoutDetailsActivity implements IssuersAdapter.Listener {
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private PaymentMethod mPaymentMethod;

    @NonNull
    private TextView createHeaderTextView() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.standard_margin);
        AppCompatTextView appCompatTextView = new AppCompatTextView(this);
        appCompatTextView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        appCompatTextView.setTextColor(ThemeUtil.getPrimaryThemeColor(this));
        appCompatTextView.setText(R.string.checkout_issuer_choose_issuer);
        return appCompatTextView;
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, IssuerDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        setContentView(R.layout.activity_issuer_details);
        setTitle(this.mPaymentMethod.getName());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_issuers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new HeaderItemDecoration(createHeaderTextView(), new HeaderItemDecoration.Callback() {
            public boolean isHeaderPosition(int i11) {
                return i11 == 0;
            }
        }));
        recyclerView.setAdapter(new IssuersAdapter(this, this.mPaymentMethod, N(), this));
    }

    public void onIssuerClick(@NonNull PaymentMethod paymentMethod, @NonNull Item item) {
        getPaymentHandler().initiatePayment(paymentMethod, new IssuerDetails.Builder(item.getId()).build());
    }
}
