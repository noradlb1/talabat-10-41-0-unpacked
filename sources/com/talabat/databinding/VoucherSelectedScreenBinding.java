package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.materialedittext.MaterialEditText;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatNestedScrollView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class VoucherSelectedScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton back;
    @NonNull
    public final TalabatFillButton buyVoucherButton;
    @NonNull
    public final TalabatTextView buyVoucherTerms;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatNestedScrollView scrollView1;
    @NonNull
    public final ImageButton selectedVoucher;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final MaterialEditText voucherPersonalizedMessage;
    @NonNull
    public final MaterialEditText voucherRecipientEmail;
    @NonNull
    public final MaterialEditText voucherRecipientName;

    private VoucherSelectedScreenBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatNestedScrollView talabatNestedScrollView, @NonNull ImageButton imageButton, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull TalabatToolBar talabatToolBar, @NonNull MaterialEditText materialEditText, @NonNull MaterialEditText materialEditText2, @NonNull MaterialEditText materialEditText3) {
        this.rootView = linearLayout;
        this.back = talabatToolBarImageButton;
        this.buyVoucherButton = talabatFillButton;
        this.buyVoucherTerms = talabatTextView;
        this.scrollView1 = talabatNestedScrollView;
        this.selectedVoucher = imageButton;
        this.title = talabatToolBarTextView;
        this.toolbar = talabatToolBar;
        this.voucherPersonalizedMessage = materialEditText;
        this.voucherRecipientEmail = materialEditText2;
        this.voucherRecipientName = materialEditText3;
    }

    @NonNull
    public static VoucherSelectedScreenBinding bind(@NonNull View view) {
        int i11 = R.id.back;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.buy_voucher_button;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.buy_voucher_button);
            if (talabatFillButton != null) {
                i11 = R.id.buy_voucher_terms;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.buy_voucher_terms);
                if (talabatTextView != null) {
                    i11 = R.id.scrollView1;
                    TalabatNestedScrollView talabatNestedScrollView = (TalabatNestedScrollView) ViewBindings.findChildViewById(view, R.id.scrollView1);
                    if (talabatNestedScrollView != null) {
                        i11 = R.id.selected_voucher;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.selected_voucher);
                        if (imageButton != null) {
                            i11 = R.id.title;
                            TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (talabatToolBarTextView != null) {
                                i11 = R.id.toolbar;
                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (talabatToolBar != null) {
                                    i11 = R.id.voucher_personalized_message;
                                    MaterialEditText materialEditText = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.voucher_personalized_message);
                                    if (materialEditText != null) {
                                        i11 = R.id.voucher_recipient_email;
                                        MaterialEditText materialEditText2 = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.voucher_recipient_email);
                                        if (materialEditText2 != null) {
                                            i11 = R.id.voucher_recipient_name;
                                            MaterialEditText materialEditText3 = (MaterialEditText) ViewBindings.findChildViewById(view, R.id.voucher_recipient_name);
                                            if (materialEditText3 != null) {
                                                return new VoucherSelectedScreenBinding((LinearLayout) view, talabatToolBarImageButton, talabatFillButton, talabatTextView, talabatNestedScrollView, imageButton, talabatToolBarTextView, talabatToolBar, materialEditText, materialEditText2, materialEditText3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static VoucherSelectedScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static VoucherSelectedScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.voucher_selected_screen, viewGroup, false);
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
