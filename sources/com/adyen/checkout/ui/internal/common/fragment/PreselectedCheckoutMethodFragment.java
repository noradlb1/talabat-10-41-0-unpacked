package com.adyen.checkout.ui.internal.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethod;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodPickerListener;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodsModel;
import com.adyen.checkout.ui.internal.common.model.CheckoutViewModel;
import com.adyen.checkout.ui.internal.common.util.PayButtonUtil;
import com.adyen.checkout.ui.internal.common.view.holder.TwoLineItemViewHolder;

public class PreselectedCheckoutMethodFragment extends CheckoutSessionFragment {
    @NonNull
    public static final String TAG = "PRESELECTED_CHECKOUT_METHOD_FRAGMENT";
    /* access modifiers changed from: private */
    public CheckoutMethod mCheckoutMethod;
    /* access modifiers changed from: private */
    public CheckoutViewModel mCheckoutViewModel;
    private Button mConfirmButton;
    private Button mSelectOtherPaymentMethodButton;
    private TextView mSurchargeTextView;
    private TwoLineItemViewHolder mTwoLineItemViewHolder;

    @NonNull
    public static PreselectedCheckoutMethodFragment newInstance(@NonNull PaymentReference paymentReference) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_PAYMENT_REFERENCE", paymentReference);
        PreselectedCheckoutMethodFragment preselectedCheckoutMethodFragment = new PreselectedCheckoutMethodFragment();
        preselectedCheckoutMethodFragment.setArguments(bundle);
        return preselectedCheckoutMethodFragment;
    }

    /* access modifiers changed from: private */
    public void setCheckoutMethod(@Nullable CheckoutMethod checkoutMethod) {
        this.mCheckoutMethod = checkoutMethod;
        if (checkoutMethod != null) {
            checkoutMethod.buildLogoRequestArgs(i0()).into((LifecycleOwner) this, this.mTwoLineItemViewHolder.getLogoImageView());
            this.mTwoLineItemViewHolder.setPrimaryText(this.mCheckoutMethod.getPrimaryText());
            this.mTwoLineItemViewHolder.setSecondaryText(this.mCheckoutMethod.getSecondaryText());
            PayButtonUtil.setPayButtonText(this, this.mCheckoutMethod.getPaymentMethod(), (TextView) this.mConfirmButton, this.mSurchargeTextView);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        CheckoutViewModel checkoutViewModel = (CheckoutViewModel) ViewModelProviders.of(getActivity()).get(CheckoutViewModel.class);
        this.mCheckoutViewModel = checkoutViewModel;
        checkoutViewModel.getCheckoutMethodsLiveData().observe(this, new Observer<CheckoutMethodsModel>() {
            public void onChanged(@Nullable CheckoutMethodsModel checkoutMethodsModel) {
                PreselectedCheckoutMethodFragment.this.setCheckoutMethod(checkoutMethodsModel != null ? checkoutMethodsModel.getPreselectedCheckoutMethod() : null);
            }
        });
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_preselected_checkout_method, viewGroup, false);
        this.mTwoLineItemViewHolder = TwoLineItemViewHolder.create(inflate, R.id.item_two_line);
        Button button = (Button) inflate.findViewById(R.id.button_confirm);
        this.mConfirmButton = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PreselectedCheckoutMethodFragment.this.mCheckoutMethod != null) {
                    FragmentActivity activity = PreselectedCheckoutMethodFragment.this.getActivity();
                    if (activity instanceof CheckoutMethodPickerListener) {
                        ((CheckoutMethodPickerListener) activity).onCheckoutMethodSelected(PreselectedCheckoutMethodFragment.this.mCheckoutMethod);
                    }
                }
            }
        });
        this.mSurchargeTextView = (TextView) inflate.findViewById(R.id.textView_surcharge);
        Button button2 = (Button) inflate.findViewById(R.id.button_selectOtherPaymentMethod);
        this.mSelectOtherPaymentMethodButton = button2;
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentActivity activity = PreselectedCheckoutMethodFragment.this.getActivity();
                if (activity instanceof CheckoutMethodPickerListener) {
                    PreselectedCheckoutMethodFragment.this.mCheckoutViewModel.getCheckoutMethodsLiveData().setPreselectedCheckoutMethodCleared();
                    ((CheckoutMethodPickerListener) activity).onClearSelection();
                }
            }
        });
        return inflate;
    }

    public void onStart() {
        super.onStart();
        setCheckoutMethod(this.mCheckoutViewModel.getCheckoutMethodsLiveData().getPreselectedCheckoutMethod());
    }
}
