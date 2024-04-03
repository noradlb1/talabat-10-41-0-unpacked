package com.adyen.checkout.ui.internal.picker;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.adyen.checkout.core.PaymentReference;
import com.adyen.checkout.ui.R;
import com.adyen.checkout.ui.internal.common.fragment.CheckoutSessionFragment;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodPickerListener;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodsLiveData;
import com.adyen.checkout.ui.internal.common.model.CheckoutMethodsModel;
import com.adyen.checkout.ui.internal.common.model.CheckoutViewModel;
import com.adyen.checkout.ui.internal.common.util.ThemeUtil;
import com.adyen.checkout.ui.internal.common.util.recyclerview.DividerItemDecoration;
import com.adyen.checkout.ui.internal.common.util.recyclerview.HeaderItemDecoration;
import java.util.ArrayList;

public class CheckoutMethodPickerFragment extends CheckoutSessionFragment {
    private static final float DESIRED_HEIGHT_PROPORTION = 0.6666667f;
    @NonNull
    public static final String TAG = "TAG_CHECKOUT_METHOD_PICKER_FRAGMENT";
    /* access modifiers changed from: private */
    public CheckoutMethodPickerAdapter mCheckoutMethodPickerAdapter;
    private RecyclerView mCheckoutMethodsRecyclerView;
    private CheckoutViewModel mCheckoutViewModel;

    @NonNull
    private TextView createHeaderTextView(@StringRes int i11) {
        Context context = this.mCheckoutMethodsRecyclerView.getContext();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.standard_margin);
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        appCompatTextView.setTextColor(ThemeUtil.getPrimaryThemeColor(context));
        if (i11 != 0) {
            appCompatTextView.setText(i11);
        }
        return appCompatTextView;
    }

    @NonNull
    public static CheckoutMethodPickerFragment newInstance(@NonNull PaymentReference paymentReference) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("ARG_PAYMENT_REFERENCE", paymentReference);
        CheckoutMethodPickerFragment checkoutMethodPickerFragment = new CheckoutMethodPickerFragment();
        checkoutMethodPickerFragment.setArguments(bundle);
        return checkoutMethodPickerFragment;
    }

    public int getDesiredPeekHeight() {
        int i11 = (int) (((float) getResources().getDisplayMetrics().heightPixels) * DESIRED_HEIGHT_PROPORTION);
        int itemCount = this.mCheckoutMethodsRecyclerView.getAdapter().getItemCount();
        int i12 = 0;
        int i13 = 0;
        while (i12 < i11 && i13 < itemCount) {
            int i14 = i13 + 1;
            View findViewByPosition = this.mCheckoutMethodsRecyclerView.getLayoutManager().findViewByPosition(i13);
            if (findViewByPosition != null && (i12 = findViewByPosition.getBottom()) > i11) {
                int measuredHeight = findViewByPosition.getMeasuredHeight();
                i12 -= measuredHeight / 2;
                if (i14 == itemCount) {
                    i12 -= measuredHeight;
                }
            }
            i13 = i14;
        }
        return i12;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof CheckoutMethodPickerListener) {
            this.mCheckoutMethodPickerAdapter = new CheckoutMethodPickerAdapter(this, i0(), (CheckoutMethodPickerListener) context);
            return;
        }
        throw new RuntimeException(context.getClass() + " should implement " + CheckoutMethodPickerListener.class.getName());
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        this.mCheckoutViewModel = (CheckoutViewModel) ViewModelProviders.of(getActivity()).get(CheckoutViewModel.class);
    }

    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_checkout_method_picker, viewGroup, false);
        Context context = layoutInflater.getContext();
        final CheckoutMethodsLiveData checkoutMethodsLiveData = this.mCheckoutViewModel.getCheckoutMethodsLiveData();
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.recyclerView_checkoutMethods);
        this.mCheckoutMethodsRecyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        this.mCheckoutMethodsRecyclerView.setAdapter(this.mCheckoutMethodPickerAdapter);
        this.mCheckoutMethodsRecyclerView.addItemDecoration(new DividerItemDecoration(context, new DividerItemDecoration.Callback() {
            public boolean isDividerPosition(int i11) {
                return i11 == checkoutMethodsLiveData.getOneClickCheckoutMethodCount() - 1;
            }
        }));
        this.mCheckoutMethodsRecyclerView.addItemDecoration(new HeaderItemDecoration(createHeaderTextView(R.string.checkout_one_click_payment_method_section_title), new HeaderItemDecoration.Callback() {
            public boolean isHeaderPosition(int i11) {
                return checkoutMethodsLiveData.getOneClickCheckoutMethodCount() > 0 && i11 == 0;
            }
        }));
        this.mCheckoutMethodsRecyclerView.addItemDecoration(new HeaderItemDecoration(createHeaderTextView(R.string.checkout_payment_method_section_with_one_click_title), new HeaderItemDecoration.Callback() {
            public boolean isHeaderPosition(int i11) {
                int oneClickCheckoutMethodCount = checkoutMethodsLiveData.getOneClickCheckoutMethodCount();
                return oneClickCheckoutMethodCount > 0 && i11 == oneClickCheckoutMethodCount;
            }
        }));
        this.mCheckoutMethodsRecyclerView.addItemDecoration(new HeaderItemDecoration(createHeaderTextView(R.string.checkout_payment_method_section_title), new HeaderItemDecoration.Callback() {
            public boolean isHeaderPosition(int i11) {
                int oneClickCheckoutMethodCount = checkoutMethodsLiveData.getOneClickCheckoutMethodCount();
                return i11 == oneClickCheckoutMethodCount && oneClickCheckoutMethodCount == 0;
            }
        }));
        checkoutMethodsLiveData.observe(this, new Observer<CheckoutMethodsModel>() {
            public void onChanged(@Nullable CheckoutMethodsModel checkoutMethodsModel) {
                CheckoutMethodPickerFragment.this.mCheckoutMethodPickerAdapter.d(checkoutMethodsModel != null ? checkoutMethodsModel.getAllCheckoutMethods() : new ArrayList());
            }
        });
        return inflate;
    }
}
