package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewRateWidgetBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final ImageView vendorRateAvatar;
    @NonNull
    public final TextView vendorRateStatusM;

    private ViewRateWidgetBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = linearLayout;
        this.vendorRateAvatar = imageView;
        this.vendorRateStatusM = textView;
    }

    @NonNull
    public static ViewRateWidgetBinding bind(@NonNull View view) {
        int i11 = R.id.vendorRateAvatar;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.vendorRateStatusM;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new ViewRateWidgetBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewRateWidgetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewRateWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_rate_widget, viewGroup, false);
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
