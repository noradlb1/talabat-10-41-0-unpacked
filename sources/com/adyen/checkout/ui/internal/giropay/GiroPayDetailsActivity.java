package com.adyen.checkout.ui.internal.giropay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.lifecycle.LifecycleOwner;
import com.adyen.checkout.core.CheckoutException;
import com.adyen.checkout.core.NetworkingState;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.core.SearchHandler;
import com.adyen.checkout.core.model.GiroPayDetails;
import com.adyen.checkout.core.model.GiroPayIssuer;
import com.adyen.checkout.core.model.PaymentMethod;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.activity.CheckoutDetailsActivity;
import com.adyen.checkout.ui.internal.common.activity.CheckoutSessionActivity;
import com.adyen.checkout.ui.internal.common.util.Adapter;
import com.adyen.checkout.ui.internal.common.util.KeyboardUtil;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.ui.internal.common.util.image.Rembrandt;
import com.adyen.checkout.ui.internal.common.view.holder.TwoLineItemViewHolder;
import com.adyen.checkout.util.internal.SimpleTextWatcher;
import java.util.List;

public class GiroPayDetailsActivity extends CheckoutDetailsActivity {
    private static final String EXTRA_PAYMENT_METHOD = "EXTRA_PAYMENT_METHOD";
    private static final String STATE_SELECTED_GIRO_PAY_ISSUER = "STATE_SELECTED_GIRO_PAY_ISSUER";
    /* access modifiers changed from: private */
    public Adapter<GiroPayIssuer> mAutoCompleteAdapter;
    /* access modifiers changed from: private */
    public TextView mErrorTextView;
    private Button mPayButton;
    /* access modifiers changed from: private */
    public PaymentMethod mPaymentMethod;
    /* access modifiers changed from: private */
    public ContentLoadingProgressBar mProgressBar;
    private FrameLayout mSearchContainer;
    /* access modifiers changed from: private */
    public SearchHandler<List<GiroPayIssuer>> mSearchHandler;
    /* access modifiers changed from: private */
    public AutoCompleteTextView mSearchStringAutoCompleteTextView;
    /* access modifiers changed from: private */
    public GiroPayIssuer mSelectedGiroPayIssuer;
    private TwoLineItemViewHolder mSelectedGiroPayIssuerViewHolder;
    private TextView mSurchargeTextView;

    /* access modifiers changed from: private */
    @NonNull
    public static String formatGiroPayIssuer(@NonNull GiroPayIssuer giroPayIssuer) {
        return giroPayIssuer.getBankName().replaceAll("\\(.*\\)", "");
    }

    @NonNull
    public static Intent newIntent(@NonNull Context context, @NonNull PaymentReference paymentReference, @NonNull PaymentMethod paymentMethod) {
        Intent intent = new Intent(context, GiroPayDetailsActivity.class);
        intent.putExtra(CheckoutSessionActivity.EXTRA_PAYMENT_REFERENCE, paymentReference);
        intent.putExtra(EXTRA_PAYMENT_METHOD, paymentMethod);
        return intent;
    }

    /* access modifiers changed from: private */
    public void onGiroPayIssuerChanged() {
        if (this.mSelectedGiroPayIssuer == null) {
            this.mSearchContainer.setVisibility(0);
            KeyboardUtil.showAndSelect(this.mSearchStringAutoCompleteTextView);
            this.mSelectedGiroPayIssuerViewHolder.getPrimaryTextView().setText((CharSequence) null);
            this.mSelectedGiroPayIssuerViewHolder.getSecondaryTextView().setText((CharSequence) null);
            this.mSelectedGiroPayIssuerViewHolder.itemView.setVisibility(8);
            updateContinueButton();
            if (this.mSearchStringAutoCompleteTextView.getWindowToken() != null) {
                this.mSearchStringAutoCompleteTextView.showDropDown();
                return;
            }
            return;
        }
        this.mSearchContainer.setVisibility(8);
        KeyboardUtil.hide(this.mSearchStringAutoCompleteTextView);
        this.mSelectedGiroPayIssuerViewHolder.getPrimaryTextView().setText(formatGiroPayIssuer(this.mSelectedGiroPayIssuer));
        this.mSelectedGiroPayIssuerViewHolder.getSecondaryTextView().setText(this.mSelectedGiroPayIssuer.getBic());
        this.mSelectedGiroPayIssuerViewHolder.itemView.setVisibility(0);
        updateContinueButton();
        if (this.mSearchStringAutoCompleteTextView.getWindowToken() != null) {
            this.mSearchStringAutoCompleteTextView.dismissDropDown();
        }
    }

    private void updateContinueButton() {
        boolean z11;
        if (this.mSelectedGiroPayIssuer != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.mPayButton.setEnabled(z11);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mPaymentMethod = (PaymentMethod) getIntent().getParcelableExtra(EXTRA_PAYMENT_METHOD);
        this.mSearchHandler = SearchHandler.Factory.createGiroPayIssuerSearchHandler(getApplication(), this.mPaymentMethod);
        if (bundle != null) {
            this.mSelectedGiroPayIssuer = (GiroPayIssuer) bundle.getParcelable(STATE_SELECTED_GIRO_PAY_ISSUER);
        }
        setContentView(R.layout.activity_giropay_details);
        setTitle(this.mPaymentMethod.getName());
        this.mSearchContainer = (FrameLayout) findViewById(R.id.frameLayout_searchContainer);
        this.mAutoCompleteAdapter = Adapter.forAutoCompleteTextView(new Adapter.TextDelegate<GiroPayIssuer>() {
            @NonNull
            public String getText(@NonNull GiroPayIssuer giroPayIssuer) {
                return GiroPayDetailsActivity.formatGiroPayIssuer(giroPayIssuer);
            }
        });
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView_searchString);
        this.mSearchStringAutoCompleteTextView = autoCompleteTextView;
        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GiroPayDetailsActivity.this.mSearchStringAutoCompleteTextView.showDropDown();
            }
        });
        this.mSearchStringAutoCompleteTextView.setAdapter(this.mAutoCompleteAdapter);
        this.mSearchStringAutoCompleteTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (GiroPayDetailsActivity.this.mAutoCompleteAdapter.getCount() != 1) {
                    return false;
                }
                GiroPayDetailsActivity giroPayDetailsActivity = GiroPayDetailsActivity.this;
                GiroPayIssuer unused = giroPayDetailsActivity.mSelectedGiroPayIssuer = (GiroPayIssuer) giroPayDetailsActivity.mAutoCompleteAdapter.getItem(0);
                GiroPayDetailsActivity.this.onGiroPayIssuerChanged();
                return true;
            }
        });
        this.mSearchStringAutoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                GiroPayDetailsActivity giroPayDetailsActivity = GiroPayDetailsActivity.this;
                GiroPayIssuer unused = giroPayDetailsActivity.mSelectedGiroPayIssuer = (GiroPayIssuer) giroPayDetailsActivity.mAutoCompleteAdapter.getItem(i11);
                GiroPayDetailsActivity.this.onGiroPayIssuerChanged();
            }
        });
        this.mSearchStringAutoCompleteTextView.addTextChangedListener(new SimpleTextWatcher() {
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                GiroPayDetailsActivity.this.mSearchHandler.setSearchString(GiroPayDetailsActivity.this.mSearchStringAutoCompleteTextView.getText().toString());
            }
        });
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) findViewById(R.id.contentLoadingProgressBar);
        this.mProgressBar = contentLoadingProgressBar;
        boolean z11 = false;
        ThemeUtil.applyPrimaryThemeColor(this, contentLoadingProgressBar.getProgressDrawable(), this.mProgressBar.getIndeterminateDrawable());
        this.mSelectedGiroPayIssuerViewHolder = TwoLineItemViewHolder.create(findViewById(16908290), R.id.item_two_line);
        Rembrandt.createDefaultLogoRequestArgs(getApplication(), N().newBuilder(this.mPaymentMethod).buildCallable()).into((LifecycleOwner) this, this.mSelectedGiroPayIssuerViewHolder.getLogoImageView());
        this.mSelectedGiroPayIssuerViewHolder.getActionImageView().setImageResource(R.drawable.ic_primary_24dp);
        this.mSelectedGiroPayIssuerViewHolder.getActionImageView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                GiroPayIssuer unused = GiroPayDetailsActivity.this.mSelectedGiroPayIssuer = null;
                GiroPayDetailsActivity.this.onGiroPayIssuerChanged();
            }
        });
        this.mErrorTextView = (TextView) findViewById(R.id.textView_error);
        Button button = (Button) findViewById(R.id.button_continue);
        this.mPayButton = button;
        if (this.mSelectedGiroPayIssuer != null) {
            z11 = true;
        }
        button.setEnabled(z11);
        this.mPayButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (GiroPayDetailsActivity.this.mSelectedGiroPayIssuer != null) {
                    GiroPayDetailsActivity.this.getPaymentHandler().initiatePayment(GiroPayDetailsActivity.this.mPaymentMethod, new GiroPayDetails.Builder().setBic(GiroPayDetailsActivity.this.mSelectedGiroPayIssuer.getBic()).build());
                }
            }
        });
        TextView textView = (TextView) findViewById(R.id.textView_surcharge);
        this.mSurchargeTextView = textView;
        PayButtonUtil.setPayButtonText(this, this.mPaymentMethod, (TextView) this.mPayButton, textView);
        this.mSearchHandler.getNetworkInfoObservable().observe(this, new Observer<NetworkingState>() {
            public void onChanged(@NonNull NetworkingState networkingState) {
                if (networkingState.isExecutingRequests()) {
                    GiroPayDetailsActivity.this.mProgressBar.show();
                } else {
                    GiroPayDetailsActivity.this.mProgressBar.hide();
                }
            }
        });
        this.mSearchHandler.getSearchResultsObservable().observe(this, new Observer<List<GiroPayIssuer>>() {
            public void onChanged(@NonNull List<GiroPayIssuer> list) {
                GiroPayDetailsActivity.this.mAutoCompleteAdapter.setItems(list);
                if (list.isEmpty()) {
                    GiroPayDetailsActivity.this.mErrorTextView.setVisibility(0);
                    GiroPayDetailsActivity.this.mErrorTextView.setText(GiroPayDetailsActivity.this.getString(R.string.checkout_giropay_error_search_no_results));
                    return;
                }
                GiroPayDetailsActivity.this.mErrorTextView.setVisibility(8);
                GiroPayDetailsActivity.this.mErrorTextView.setText((CharSequence) null);
            }
        });
        this.mSearchHandler.getErrorObservable().observe(this, new Observer<CheckoutException>() {
            public void onChanged(@NonNull CheckoutException checkoutException) {
                GiroPayDetailsActivity.this.mErrorTextView.setVisibility(0);
                GiroPayDetailsActivity.this.mErrorTextView.setText(GiroPayDetailsActivity.this.getString(R.string.checkout_error_message_default));
            }
        });
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(STATE_SELECTED_GIRO_PAY_ISSUER, this.mSelectedGiroPayIssuer);
    }
}
