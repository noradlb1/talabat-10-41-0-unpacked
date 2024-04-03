package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class WalletTransactionDetailHeaderBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final ConstraintLayout deatailHeader;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;

    private WalletTransactionDetailHeaderBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageButton imageButton, @NonNull ConstraintLayout constraintLayout2, @NonNull RelativeLayout relativeLayout, @NonNull TalabatTextView talabatTextView, @NonNull Toolbar toolbar2) {
        this.rootView = constraintLayout;
        this.back = imageButton;
        this.deatailHeader = constraintLayout2;
        this.talabatToolbar = relativeLayout;
        this.title = talabatTextView;
        this.toolbar = toolbar2;
    }

    @NonNull
    public static WalletTransactionDetailHeaderBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (imageButton != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R.id.talabat_toolbar;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_toolbar);
            if (relativeLayout != null) {
                i11 = R.id.title;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                if (talabatTextView != null) {
                    i11 = R.id.toolbar;
                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (toolbar2 != null) {
                        return new WalletTransactionDetailHeaderBinding(constraintLayout, imageButton, constraintLayout, relativeLayout, talabatTextView, toolbar2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static WalletTransactionDetailHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletTransactionDetailHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_transaction_detail_header, viewGroup, false);
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
