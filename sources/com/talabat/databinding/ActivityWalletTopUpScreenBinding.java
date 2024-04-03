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
import com.talabat.TalabatEditText;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.wang.avi.AVLoadingIndicatorView;

public final class ActivityWalletTopUpScreenBinding implements ViewBinding {
    @NonNull
    public final ImageButton back;
    @NonNull
    public final TalabatTextView cashBackLabel;
    @NonNull
    public final TalabatTextView enterAmount;
    @NonNull
    public final TalabatFillButton firstSelectAmountButton;
    @NonNull
    public final ConstraintLayout header;
    @NonNull
    public final RelativeLayout rootView;
    @NonNull
    private final RelativeLayout rootView_;
    @NonNull
    public final TalabatFillButton secondSelectAmountButton;
    @NonNull
    public final TalabatTextView selectAmountTextView;
    @NonNull
    public final TalabatFillButton submitTopUpButton;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TalabatFillButton thirdSelectAmountButton;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TalabatEditText topUpAmount;
    @NonNull
    public final TalabatTextView topUpCurrency;
    @NonNull
    public final AVLoadingIndicatorView topUpLoading;

    private ActivityWalletTopUpScreenBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageButton imageButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatFillButton talabatFillButton, @NonNull ConstraintLayout constraintLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatFillButton talabatFillButton2, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatFillButton talabatFillButton3, @NonNull RelativeLayout relativeLayout3, @NonNull TalabatFillButton talabatFillButton4, @NonNull TalabatTextView talabatTextView4, @NonNull Toolbar toolbar2, @NonNull TalabatEditText talabatEditText, @NonNull TalabatTextView talabatTextView5, @NonNull AVLoadingIndicatorView aVLoadingIndicatorView) {
        this.rootView_ = relativeLayout;
        this.back = imageButton;
        this.cashBackLabel = talabatTextView;
        this.enterAmount = talabatTextView2;
        this.firstSelectAmountButton = talabatFillButton;
        this.header = constraintLayout;
        this.rootView = relativeLayout2;
        this.secondSelectAmountButton = talabatFillButton2;
        this.selectAmountTextView = talabatTextView3;
        this.submitTopUpButton = talabatFillButton3;
        this.talabatToolbar = relativeLayout3;
        this.thirdSelectAmountButton = talabatFillButton4;
        this.title = talabatTextView4;
        this.toolbar = toolbar2;
        this.topUpAmount = talabatEditText;
        this.topUpCurrency = talabatTextView5;
        this.topUpLoading = aVLoadingIndicatorView;
    }

    @NonNull
    public static ActivityWalletTopUpScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.back;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view2, R.id.back);
        if (imageButton != null) {
            i11 = R.id.cash_back_label;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.cash_back_label);
            if (talabatTextView != null) {
                i11 = R.id.enter_amount;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.enter_amount);
                if (talabatTextView2 != null) {
                    i11 = R.id.first_select_amount_button;
                    TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.first_select_amount_button);
                    if (talabatFillButton != null) {
                        i11 = R.id.header;
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, R.id.header);
                        if (constraintLayout != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) view2;
                            i11 = R.id.second_select_amount_button;
                            TalabatFillButton talabatFillButton2 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.second_select_amount_button);
                            if (talabatFillButton2 != null) {
                                i11 = R.id.select_amount_text_view;
                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.select_amount_text_view);
                                if (talabatTextView3 != null) {
                                    i11 = R.id.submit_top_up_button;
                                    TalabatFillButton talabatFillButton3 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.submit_top_up_button);
                                    if (talabatFillButton3 != null) {
                                        i11 = R.id.talabat_toolbar;
                                        RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view2, R.id.talabat_toolbar);
                                        if (relativeLayout2 != null) {
                                            i11 = R.id.third_select_amount_button;
                                            TalabatFillButton talabatFillButton4 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.third_select_amount_button);
                                            if (talabatFillButton4 != null) {
                                                i11 = R.id.title;
                                                TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.title);
                                                if (talabatTextView4 != null) {
                                                    i11 = R.id.toolbar;
                                                    Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view2, R.id.toolbar);
                                                    if (toolbar2 != null) {
                                                        i11 = R.id.top_up_amount;
                                                        TalabatEditText talabatEditText = (TalabatEditText) ViewBindings.findChildViewById(view2, R.id.top_up_amount);
                                                        if (talabatEditText != null) {
                                                            i11 = R.id.top_up_currency;
                                                            TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.top_up_currency);
                                                            if (talabatTextView5 != null) {
                                                                i11 = R.id.top_up_loading;
                                                                AVLoadingIndicatorView aVLoadingIndicatorView = (AVLoadingIndicatorView) ViewBindings.findChildViewById(view2, R.id.top_up_loading);
                                                                if (aVLoadingIndicatorView != null) {
                                                                    return new ActivityWalletTopUpScreenBinding(relativeLayout, imageButton, talabatTextView, talabatTextView2, talabatFillButton, constraintLayout, relativeLayout, talabatFillButton2, talabatTextView3, talabatFillButton3, relativeLayout2, talabatFillButton4, talabatTextView4, toolbar2, talabatEditText, talabatTextView5, aVLoadingIndicatorView);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityWalletTopUpScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWalletTopUpScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_top_up_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView_;
    }
}
