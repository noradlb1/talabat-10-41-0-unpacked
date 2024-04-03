package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;

public final class MiniCartDisabledBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView cartAmount;
    @NonNull
    public final LinearLayout llContainer;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatButton showCartBtn;
    @NonNull
    public final TalabatTextView totalAmount;

    private MiniCartDisabledBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatTextView talabatTextView, @NonNull LinearLayout linearLayout2, @NonNull TalabatButton talabatButton, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = linearLayout;
        this.cartAmount = talabatTextView;
        this.llContainer = linearLayout2;
        this.showCartBtn = talabatButton;
        this.totalAmount = talabatTextView2;
    }

    @NonNull
    public static MiniCartDisabledBinding bind(@NonNull View view) {
        int i11 = R.id.cartAmount;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.cartAmount);
        if (talabatTextView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R.id.showCartBtn;
            TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.showCartBtn);
            if (talabatButton != null) {
                i11 = R.id.totalAmount;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.totalAmount);
                if (talabatTextView2 != null) {
                    return new MiniCartDisabledBinding(linearLayout, talabatTextView, linearLayout, talabatButton, talabatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MiniCartDisabledBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MiniCartDisabledBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mini_cart_disabled, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
