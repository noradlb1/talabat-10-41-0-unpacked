package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class FragmentWalletSecureMoreInfoBinding implements ViewBinding {
    @NonNull
    public final LinearLayout containerLayout;
    @NonNull
    public final TextView contentText;
    @NonNull
    public final ImageView iconSecurityIcon;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final NestedScrollView scrollView1;
    @NonNull
    public final TextView subTitle;
    @NonNull
    public final TextView title;
    @NonNull
    public final LinearLayout walletSecureMoreInfoView;

    private FragmentWalletSecureMoreInfoBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull LinearLayout linearLayout3) {
        this.rootView = linearLayout;
        this.containerLayout = linearLayout2;
        this.contentText = textView;
        this.iconSecurityIcon = imageView;
        this.scrollView1 = nestedScrollView;
        this.subTitle = textView2;
        this.title = textView3;
        this.walletSecureMoreInfoView = linearLayout3;
    }

    @NonNull
    public static FragmentWalletSecureMoreInfoBinding bind(@NonNull View view) {
        int i11 = R.id.container_layout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.content_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.icon_security_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
                if (imageView != null) {
                    i11 = R.id.scrollView1;
                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i11);
                    if (nestedScrollView != null) {
                        i11 = R.id.sub_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view;
                                return new FragmentWalletSecureMoreInfoBinding(linearLayout2, linearLayout, textView, imageView, nestedScrollView, textView2, textView3, linearLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentWalletSecureMoreInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentWalletSecureMoreInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_wallet_secure_more_info, viewGroup, false);
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
