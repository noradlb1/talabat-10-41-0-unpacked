package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.TalabatToolBar;
import com.talabat.helpers.TalabatToolBarImageButton;
import com.talabat.helpers.TalabatToolBarTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class ActivityGoToWalletBinding implements ViewBinding {
    @NonNull
    public final TalabatToolBarImageButton backIcon;
    @NonNull
    public final TalabatFillButton gotToWalletButton;
    @NonNull
    public final TalabatTextView logToAccessWallet;
    @NonNull
    public final TalabatToolBarTextView notificationBuble;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final FrameLayout sidemenuButtonContainer;
    @NonNull
    public final TalabatToolBarTextView title;
    @NonNull
    public final TalabatToolBar toolbar;
    @NonNull
    public final ImageView walletEmptyIcon;

    private ActivityGoToWalletBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TalabatToolBarImageButton talabatToolBarImageButton, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatToolBarTextView talabatToolBarTextView, @NonNull FrameLayout frameLayout, @NonNull TalabatToolBarTextView talabatToolBarTextView2, @NonNull TalabatToolBar talabatToolBar, @NonNull ImageView imageView) {
        this.rootView = constraintLayout;
        this.backIcon = talabatToolBarImageButton;
        this.gotToWalletButton = talabatFillButton;
        this.logToAccessWallet = talabatTextView;
        this.notificationBuble = talabatToolBarTextView;
        this.sidemenuButtonContainer = frameLayout;
        this.title = talabatToolBarTextView2;
        this.toolbar = talabatToolBar;
        this.walletEmptyIcon = imageView;
    }

    @NonNull
    public static ActivityGoToWalletBinding bind(@NonNull View view) {
        int i11 = R.id.back_icon;
        TalabatToolBarImageButton talabatToolBarImageButton = (TalabatToolBarImageButton) ViewBindings.findChildViewById(view, R.id.back_icon);
        if (talabatToolBarImageButton != null) {
            i11 = R.id.got_to_wallet_button;
            TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.got_to_wallet_button);
            if (talabatFillButton != null) {
                i11 = R.id.log_to_access_wallet;
                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.log_to_access_wallet);
                if (talabatTextView != null) {
                    i11 = R.id.notification_buble;
                    TalabatToolBarTextView talabatToolBarTextView = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.notification_buble);
                    if (talabatToolBarTextView != null) {
                        i11 = R.id.sidemenu_button_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.sidemenu_button_container);
                        if (frameLayout != null) {
                            i11 = R.id.title;
                            TalabatToolBarTextView talabatToolBarTextView2 = (TalabatToolBarTextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (talabatToolBarTextView2 != null) {
                                i11 = R.id.toolbar;
                                TalabatToolBar talabatToolBar = (TalabatToolBar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (talabatToolBar != null) {
                                    i11 = R.id.wallet_empty_icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.wallet_empty_icon);
                                    if (imageView != null) {
                                        return new ActivityGoToWalletBinding((ConstraintLayout) view, talabatToolBarImageButton, talabatFillButton, talabatTextView, talabatToolBarTextView, frameLayout, talabatToolBarTextView2, talabatToolBar, imageView);
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
    public static ActivityGoToWalletBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityGoToWalletBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_go_to_wallet, viewGroup, false);
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
