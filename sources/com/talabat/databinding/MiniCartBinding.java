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
import com.talabat.helpers.MiniCartDisabledLayout;
import com.talabat.helpers.MiniCartTotalLayout;

public final class MiniCartBinding implements ViewBinding {
    @NonNull
    public final MiniCartDisabledLayout miniCartDisabled;
    @NonNull
    public final MiniCartTotalLayout miniCartTotal;
    @NonNull
    private final LinearLayout rootView;

    private MiniCartBinding(@NonNull LinearLayout linearLayout, @NonNull MiniCartDisabledLayout miniCartDisabledLayout, @NonNull MiniCartTotalLayout miniCartTotalLayout) {
        this.rootView = linearLayout;
        this.miniCartDisabled = miniCartDisabledLayout;
        this.miniCartTotal = miniCartTotalLayout;
    }

    @NonNull
    public static MiniCartBinding bind(@NonNull View view) {
        int i11 = R.id.mini_cart_disabled;
        MiniCartDisabledLayout miniCartDisabledLayout = (MiniCartDisabledLayout) ViewBindings.findChildViewById(view, R.id.mini_cart_disabled);
        if (miniCartDisabledLayout != null) {
            i11 = R.id.miniCartTotal;
            MiniCartTotalLayout miniCartTotalLayout = (MiniCartTotalLayout) ViewBindings.findChildViewById(view, R.id.miniCartTotal);
            if (miniCartTotalLayout != null) {
                return new MiniCartBinding((LinearLayout) view, miniCartDisabledLayout, miniCartTotalLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MiniCartBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MiniCartBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mini_cart, viewGroup, false);
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
