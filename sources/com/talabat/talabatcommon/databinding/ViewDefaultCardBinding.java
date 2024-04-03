package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewDefaultCardBinding implements ViewBinding {
    @NonNull
    public final ViewCardContainerBinding cardView;
    @NonNull
    public final ViewNoCardContainerBinding noCardInfoView;
    @NonNull
    public final ViewWalletPaymentWidgetNoCardBinding noCardView;
    @NonNull
    private final ConstraintLayout rootView;

    private ViewDefaultCardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ViewCardContainerBinding viewCardContainerBinding, @NonNull ViewNoCardContainerBinding viewNoCardContainerBinding, @NonNull ViewWalletPaymentWidgetNoCardBinding viewWalletPaymentWidgetNoCardBinding) {
        this.rootView = constraintLayout;
        this.cardView = viewCardContainerBinding;
        this.noCardInfoView = viewNoCardContainerBinding;
        this.noCardView = viewWalletPaymentWidgetNoCardBinding;
    }

    @NonNull
    public static ViewDefaultCardBinding bind(@NonNull View view) {
        int i11 = R.id.card_view;
        View findChildViewById = ViewBindings.findChildViewById(view, i11);
        if (findChildViewById != null) {
            ViewCardContainerBinding bind = ViewCardContainerBinding.bind(findChildViewById);
            int i12 = R.id.no_card_info_view;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i12);
            if (findChildViewById2 != null) {
                ViewNoCardContainerBinding bind2 = ViewNoCardContainerBinding.bind(findChildViewById2);
                int i13 = R.id.no_card_view;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i13);
                if (findChildViewById3 != null) {
                    return new ViewDefaultCardBinding((ConstraintLayout) view, bind, bind2, ViewWalletPaymentWidgetNoCardBinding.bind(findChildViewById3));
                }
                i11 = i13;
            } else {
                i11 = i12;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewDefaultCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewDefaultCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_default_card, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
