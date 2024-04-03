package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarLinearLayoutContainer;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class RedeemVoucherScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatFillButton btnRedeem;
    @NonNull
    private final TalabatToolBarLinearLayoutContainer rootView;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final MaterialEditText voucherCode;

    private RedeemVoucherScreenBinding(@NonNull TalabatToolBarLinearLayoutContainer talabatToolBarLinearLayoutContainer, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull MaterialEditText materialEditText) {
        this.rootView = talabatToolBarLinearLayoutContainer;
        this.back = talabatToolBarImageButton;
        this.btnRedeem = talabatFillButton;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.voucherCode = materialEditText;
    }

    @NonNull
    public static RedeemVoucherScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.btnRedeem;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.btnRedeem);
            if (talabatFillButton != null) {
                i11 = R.id.title;
                TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                if (talabatToolBarTextView != null) {
                    i11 = R.id.toolbar;
                    TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                    if (talabatToolBar != null) {
                        i11 = R.id.voucher_code;
                        MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.voucher_code);
                        if (materialEditText != null) {
                            return new RedeemVoucherScreenBinding((TalabatToolBarLinearLayoutContainer) view, talabatToolBarImageButton, talabatFillButton, talabatToolBarTextView, talabatToolBar, materialEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static RedeemVoucherScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static RedeemVoucherScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.redeem_voucher_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public TalabatToolBarLinearLayoutContainer getRoot() {
        return this.rootView;
    }
}
