package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.TalabatFillButton;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.view.AddCardCustomView;

public final class FragmentWalletAddCardBinding implements ViewBinding {
    @NonNull
    public final AddCardCustomView addCardCustomView;
    @NonNull
    public final ImageButton backIcon;
    @NonNull
    public final LinearLayout errorNotifyLinearLayout;
    @NonNull
    public final ConstraintLayout header;
    @NonNull
    public final TextView learnMore;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TalabatFillButton saveButton;
    @NonNull
    public final RelativeLayout talabatToolbar;
    @NonNull
    public final TextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView yourPaymentInfo;

    private FragmentWalletAddCardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AddCardCustomView addCardCustomView2, @NonNull ImageButton imageButton, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ProgressBar progressBar2, @NonNull TalabatFillButton talabatFillButton, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView2, @NonNull Toolbar toolbar2, @NonNull TextView textView3) {
        this.rootView = constraintLayout;
        this.addCardCustomView = addCardCustomView2;
        this.backIcon = imageButton;
        this.errorNotifyLinearLayout = linearLayout;
        this.header = constraintLayout2;
        this.learnMore = textView;
        this.progressBar = progressBar2;
        this.saveButton = talabatFillButton;
        this.talabatToolbar = relativeLayout;
        this.title = textView2;
        this.toolbar = toolbar2;
        this.yourPaymentInfo = textView3;
    }

    @NonNull
    public static FragmentWalletAddCardBinding bind(@NonNull View view) {
        int i11 = R.id.add_card_custom_view;
        AddCardCustomView addCardCustomView2 = (AddCardCustomView) ViewBindings.findChildViewById(view, i11);
        if (addCardCustomView2 != null) {
            i11 = R.id.back_icon;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, i11);
            if (imageButton != null) {
                i11 = R.id.errorNotifyLinearLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                    if (constraintLayout != null) {
                        i11 = R.id.learn_more;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.progress_bar;
                            ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i11);
                            if (progressBar2 != null) {
                                i11 = R.id.save_button;
                                TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, i11);
                                if (talabatFillButton != null) {
                                    i11 = R.id.talabat_toolbar;
                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                                    if (relativeLayout != null) {
                                        i11 = R.id.title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                                        if (textView2 != null) {
                                            i11 = R.id.toolbar;
                                            Toolbar toolbar2 = (Toolbar) ViewBindings.findChildViewById(view, i11);
                                            if (toolbar2 != null) {
                                                i11 = R.id.your_payment_info;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                                                if (textView3 != null) {
                                                    return new FragmentWalletAddCardBinding((ConstraintLayout) view, addCardCustomView2, imageButton, linearLayout, constraintLayout, textView, progressBar2, talabatFillButton, relativeLayout, textView2, toolbar2, textView3);
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
    public static FragmentWalletAddCardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentWalletAddCardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_wallet_add_card, viewGroup, false);
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
