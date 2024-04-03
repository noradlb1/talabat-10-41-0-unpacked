package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class WalletSecureMoreInfoViewBinding implements ViewBinding {
    @NonNull
    public final LinearLayout containerLayout;
    @NonNull
    public final TalabatTextView contentText;
    @NonNull
    public final ImageView iconSecurityIcon;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final TalabatTextView subTitle;
    @NonNull
    public final TalabatTextView title;
    @NonNull
    public final LinearLayout walletSecureMoreInfoView;

    private WalletSecureMoreInfoViewBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView, @NonNull TalabatTextView talabatTextView2, @NonNull TalabatTextView talabatTextView3, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.containerLayout = linearLayout2;
        this.contentText = talabatTextView;
        this.iconSecurityIcon = imageView;
        this.scrollView1 = nestedScrollView;
        this.subTitle = talabatTextView2;
        this.title = talabatTextView3;
        this.walletSecureMoreInfoView = linearLayout3;
    }

    @NonNull
    public static WalletSecureMoreInfoViewBinding bind(@NonNull View view) {
        int i11 = R.id.container_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.container_layout);
        if (linearLayout != null) {
            i11 = R.id.content_text;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.content_text);
            if (talabatTextView != null) {
                i11 = R.id.icon_security_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon_security_icon);
                if (imageView != null) {
                    i11 = R.id.scrollView1;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scrollView1);
                    if (nestedScrollView != null) {
                        i11 = R.id.sub_title;
                        TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.sub_title);
                        if (talabatTextView2 != null) {
                            i11 = R.id.title;
                            TalabatTextView talabatTextView3 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.title);
                            if (talabatTextView3 != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view;
                                return new WalletSecureMoreInfoViewBinding(linearLayout2, linearLayout, talabatTextView, imageView, nestedScrollView, talabatTextView2, talabatTextView3, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static WalletSecureMoreInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static WalletSecureMoreInfoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.wallet_secure_more_info_view, viewGroup, false);
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
