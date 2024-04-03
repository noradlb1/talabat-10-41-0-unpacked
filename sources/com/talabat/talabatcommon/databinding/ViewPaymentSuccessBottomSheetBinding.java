package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.talabat.talabatcommon.R;

public final class ViewPaymentSuccessBottomSheetBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout redeemConformationAnimationRelativeLayout;
    @NonNull
    private final RelativeLayout rootView;

    private ViewPaymentSuccessBottomSheetBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.redeemConformationAnimationRelativeLayout = relativeLayout2;
    }

    @NonNull
    public static ViewPaymentSuccessBottomSheetBinding bind(@NonNull View view) {
        if (view != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            return new ViewPaymentSuccessBottomSheetBinding(relativeLayout, relativeLayout);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ViewPaymentSuccessBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewPaymentSuccessBottomSheetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_payment_success_bottom_sheet, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
