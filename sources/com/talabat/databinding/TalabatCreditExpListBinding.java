package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class TalabatCreditExpListBinding implements ViewBinding {
    @NonNull
    public final FrameLayout bottomDivider;
    @NonNull
    public final RelativeLayout container;
    @NonNull
    public final TalabatTextView expiresDaysText;
    @NonNull
    public final TalabatTextView expiresHolderText;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TalabatTextView talCreditExpText;
    @NonNull
    public final LinearLayout textLayout;
    @NonNull
    public final FrameLayout topDivider;
    @NonNull
    public final ImageView yellowDot;

    private TalabatCreditExpListBinding(@NonNull RelativeLayout relativeLayout, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView) {
        this.rootView = relativeLayout;
        this.bottomDivider = frameLayout;
        this.container = relativeLayout2;
        this.expiresDaysText = talabatTextView;
        this.expiresHolderText = talabatTextView2;
        this.talCreditExpText = talabatTextView3;
        this.textLayout = linearLayout;
        this.topDivider = frameLayout2;
        this.yellowDot = imageView;
    }

    @NonNull
    public static TalabatCreditExpListBinding bind(@NonNull View view) {
        int i11 = R.id.bottom_divider;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.bottom_divider);
        if (frameLayout != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i11 = R.id.expires_days_text;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.expires_days_text);
            if (talabatTextView != null) {
                i11 = R.id.expires_holder_text;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.expires_holder_text);
                if (talabatTextView2 != null) {
                    i11 = R.id.tal_credit_exp_text;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.tal_credit_exp_text);
                    if (talabatTextView3 != null) {
                        i11 = R.id.text_layout;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.text_layout);
                        if (linearLayout != null) {
                            i11 = R.id.top_divider;
                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.top_divider);
                            if (frameLayout2 != null) {
                                i11 = R.id.yellow_dot;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.yellow_dot);
                                if (imageView != null) {
                                    return new TalabatCreditExpListBinding(relativeLayout, frameLayout, relativeLayout, talabatTextView, talabatTextView2, talabatTextView3, linearLayout, frameLayout2, imageView);
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
    public static TalabatCreditExpListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static TalabatCreditExpListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.talabat_credit_exp_list, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
