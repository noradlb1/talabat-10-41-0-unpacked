package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.TalabatStrokeButton;

public final class ActivityWalletTopUpResponseScreenBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView availableCreditTextView;
    @NonNull
    public final TalabatTextView errorMessageTextView;
    @NonNull
    public final TalabatFillButton goToWallet;
    @NonNull
    public final TalabatStrokeButton gotToWalletButton;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final CoordinatorLayout rootView;
    @NonNull
    private final CoordinatorLayout rootView_;
    @NonNull
    public final ImageView statusIcon;
    @NonNull
    public final TalabatTextView topUpAmount;
    @NonNull
    public final TalabatTextView topUpStatusTextView;
    @NonNull
    public final TalabatTextView topUpWaitingMessage;
    @NonNull
    public final TalabatTextView topUpWalletTextView;
    @NonNull
    public final TalabatFillButton tryAnotherCardButton;

    private ActivityWalletTopUpResponseScreenBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatStrokeButton talabatStrokeButton, @NonNull ProgressBar progressBar2, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView3, @NonNull TalabatTextView talabatTextView4, @NonNull TalabatTextView talabatTextView5, @NonNull TalabatTextView talabatTextView6, @NonNull TalabatFillButton talabatFillButton2) {
        this.rootView_ = coordinatorLayout;
        this.availableCreditTextView = talabatTextView;
        this.errorMessageTextView = talabatTextView2;
        this.goToWallet = talabatFillButton;
        this.gotToWalletButton = talabatStrokeButton;
        this.progressBar = progressBar2;
        this.rootView = coordinatorLayout2;
        this.statusIcon = imageView;
        this.topUpAmount = talabatTextView3;
        this.topUpStatusTextView = talabatTextView4;
        this.topUpWaitingMessage = talabatTextView5;
        this.topUpWalletTextView = talabatTextView6;
        this.tryAnotherCardButton = talabatFillButton2;
    }

    @NonNull
    public static ActivityWalletTopUpResponseScreenBinding bind(@NonNull View view) {
        View view2 = view;
        int i11 = R.id.available_credit_text_view;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.available_credit_text_view);
        if (talabatTextView != null) {
            i11 = R.id.error_message_text_view;
            TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.error_message_text_view);
            if (talabatTextView2 != null) {
                i11 = R.id.go_to_wallet;
                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.go_to_wallet);
                if (talabatFillButton != null) {
                    i11 = R.id.got_to_wallet_button;
                    TalabatStrokeButton talabatStrokeButton = (TalabatStrokeButton) ViewBindings.findChildViewById(view2, R.id.got_to_wallet_button);
                    if (talabatStrokeButton != null) {
                        i11 = R.id.progress_bar;
                        ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view2, R.id.progress_bar);
                        if (progressBar2 != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view2;
                            i11 = R.id.status_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, R.id.status_icon);
                            if (imageView != null) {
                                i11 = R.id.top_up_amount;
                                TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.top_up_amount);
                                if (talabatTextView3 != null) {
                                    i11 = R.id.top_up_status_text_view;
                                    TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.top_up_status_text_view);
                                    if (talabatTextView4 != null) {
                                        i11 = R.id.top_up_waiting_message;
                                        TalabatTextView talabatTextView5 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.top_up_waiting_message);
                                        if (talabatTextView5 != null) {
                                            i11 = R.id.top_up_wallet_text_view;
                                            TalabatTextView talabatTextView6 = (TalabatTextView) ViewBindings.findChildViewById(view2, R.id.top_up_wallet_text_view);
                                            if (talabatTextView6 != null) {
                                                i11 = R.id.try_another_card_button;
                                                TalabatFillButton talabatFillButton2 = (TalabatFillButton) ViewBindings.findChildViewById(view2, R.id.try_another_card_button);
                                                if (talabatFillButton2 != null) {
                                                    return new ActivityWalletTopUpResponseScreenBinding(coordinatorLayout, talabatTextView, talabatTextView2, talabatFillButton, talabatStrokeButton, progressBar2, coordinatorLayout, imageView, talabatTextView3, talabatTextView4, talabatTextView5, talabatTextView6, talabatFillButton2);
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
    public static ActivityWalletTopUpResponseScreenBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityWalletTopUpResponseScreenBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_wallet_top_up_response_screen, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView_;
    }
}
