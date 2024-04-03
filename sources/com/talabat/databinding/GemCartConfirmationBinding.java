package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class GemCartConfirmationBinding implements ViewBinding {
    @NonNull
    public final TalabatFillButton addMoreItem;
    @NonNull
    public final TalabatTextView confiramtionDialog;
    @NonNull
    public final TalabatTextView continueToCheckout;
    @NonNull
    public final ImageView gemLogo;
    @NonNull
    public final LinearLayout gemOfferView;
    @NonNull
    public final LinearLayout gemView;
    @NonNull
    public final ImageView imageViewClose;
    @NonNull
    public final TalabatTextView mainTextTitle;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final LinearLayout textLayout;
    @NonNull
    public final TalabatTextView timeTextView;
    @NonNull
    public final LinearLayout timeoutMain;

    private GemCartConfirmationBinding(@NonNull LinearLayout linearLayout, @NonNull TalabatFillButton talabatFillButton, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull ImageView imageView2, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout4, @NonNull TalabatTextView talabatTextView4, @NonNull LinearLayout linearLayout5) {
        this.rootView = linearLayout;
        this.addMoreItem = talabatFillButton;
        this.confiramtionDialog = talabatTextView;
        this.continueToCheckout = talabatTextView2;
        this.gemLogo = imageView;
        this.gemOfferView = linearLayout2;
        this.gemView = linearLayout3;
        this.imageViewClose = imageView2;
        this.mainTextTitle = talabatTextView3;
        this.textLayout = linearLayout4;
        this.timeTextView = talabatTextView4;
        this.timeoutMain = linearLayout5;
    }

    @NonNull
    public static GemCartConfirmationBinding bind(@NonNull View view) {
        int i11 = R.id.add_more_item;
        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.add_more_item);
        if (talabatFillButton != null) {
            i11 = R.id.confiramtion_dialog;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.confiramtion_dialog);
            if (talabatTextView != null) {
                i11 = R.id.continue_to_checkout;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.continue_to_checkout);
                if (talabatTextView2 != null) {
                    i11 = R.id.gem_logo;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.gem_logo);
                    if (imageView != null) {
                        i11 = R.id.gem_offer_view;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.gem_offer_view);
                        if (linearLayout != null) {
                            i11 = R.id.gem_view;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.gem_view);
                            if (linearLayout2 != null) {
                                i11 = R.id.imageView_close;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView_close);
                                if (imageView2 != null) {
                                    i11 = R.id.main_text_title;
                                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.main_text_title);
                                    if (talabatTextView3 != null) {
                                        i11 = R.id.text_layout;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.text_layout);
                                        if (linearLayout3 != null) {
                                            i11 = R.id.time_text_view;
                                            TalabatTextView talabatTextView4 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.time_text_view);
                                            if (talabatTextView4 != null) {
                                                i11 = R.id.timeout_main;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.timeout_main);
                                                if (linearLayout4 != null) {
                                                    return new GemCartConfirmationBinding((LinearLayout) view, talabatFillButton, talabatTextView, talabatTextView2, imageView, linearLayout, linearLayout2, imageView2, talabatTextView3, linearLayout3, talabatTextView4, linearLayout4);
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
    public static GemCartConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static GemCartConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.gem_cart_confirmation, viewGroup, false);
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
