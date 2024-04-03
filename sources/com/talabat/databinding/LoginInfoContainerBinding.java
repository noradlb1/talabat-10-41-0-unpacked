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

public final class LoginInfoContainerBinding implements ViewBinding {
    @NonNull
    public final ImageView ivCoverLogo;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TalabatTextView txtBrandCaption;
    @NonNull
    public final TalabatTextView txtLoginInfo;
    @NonNull
    public final TalabatTextView txtLoginTitle;

    private LoginInfoContainerBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3) {
        this.rootView = linearLayout;
        this.ivCoverLogo = imageView;
        this.txtBrandCaption = talabatTextView;
        this.txtLoginInfo = talabatTextView2;
        this.txtLoginTitle = talabatTextView3;
    }

    @NonNull
    public static LoginInfoContainerBinding bind(@NonNull View view) {
        int i11 = R.id.iv_cover_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.iv_cover_logo);
        if (imageView != null) {
            i11 = R.id.txt_brand_caption;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txt_brand_caption);
            if (talabatTextView != null) {
                i11 = R.id.txt_login_info;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txt_login_info);
                if (talabatTextView2 != null) {
                    i11 = R.id.txt_login_title;
                    TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.txt_login_title);
                    if (talabatTextView3 != null) {
                        return new LoginInfoContainerBinding((LinearLayout) view, imageView, talabatTextView, talabatTextView2, talabatTextView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LoginInfoContainerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LoginInfoContainerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.login_info_container, viewGroup, false);
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
