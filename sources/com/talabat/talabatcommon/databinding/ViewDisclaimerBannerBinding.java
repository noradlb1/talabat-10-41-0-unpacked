package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewDisclaimerBannerBinding implements ViewBinding {
    @NonNull
    public final ImageView closeButton;
    @NonNull
    public final TextView moreInfo;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private ViewDisclaimerBannerBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.closeButton = imageView;
        this.moreInfo = textView;
        this.subtitle = textView2;
        this.title = textView3;
    }

    @NonNull
    public static ViewDisclaimerBannerBinding bind(@NonNull View view) {
        int i11 = R.id.closeButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.moreInfo;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                i11 = R.id.subtitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.title;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        return new ViewDisclaimerBannerBinding((RelativeLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewDisclaimerBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewDisclaimerBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_disclaimer_banner, viewGroup, false);
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
