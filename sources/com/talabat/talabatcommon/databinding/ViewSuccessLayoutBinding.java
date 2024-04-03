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

public final class ViewSuccessLayoutBinding implements ViewBinding {
    @NonNull
    public final TextView dismiss;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final ImageView thankYouLogo;
    @NonNull
    public final TextView thanksForSupportTxt;
    @NonNull
    public final TextView youMadeSomeonesDayTxt;

    private ViewSuccessLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = relativeLayout;
        this.dismiss = textView;
        this.thankYouLogo = imageView;
        this.thanksForSupportTxt = textView2;
        this.youMadeSomeonesDayTxt = textView3;
    }

    @NonNull
    public static ViewSuccessLayoutBinding bind(@NonNull View view) {
        int i11 = R.id.dismiss;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.thank_you_logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.thanks_for_support_txt;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView2 != null) {
                    i11 = R.id.you_made_someones_day_txt;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView3 != null) {
                        return new ViewSuccessLayoutBinding((RelativeLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewSuccessLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewSuccessLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_success_layout, viewGroup, false);
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
