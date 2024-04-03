package com.talabat.talabatlife.databinding;

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
import com.talabat.talabatlife.R;

public final class ViewVendorListAreaButtonBinding implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView vendorsListAreaButtonHeader;
    @NonNull
    public final ImageView vendorsListToolbarAreaImageView;
    @NonNull
    public final LinearLayout vendorsListToolbarAreaLinearLayout;
    @NonNull
    public final TextView vendorsListToolbarAreaTextView;

    private ViewVendorListAreaButtonBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.vendorsListAreaButtonHeader = textView;
        this.vendorsListToolbarAreaImageView = imageView;
        this.vendorsListToolbarAreaLinearLayout = linearLayout2;
        this.vendorsListToolbarAreaTextView = textView2;
    }

    @NonNull
    public static ViewVendorListAreaButtonBinding bind(@NonNull View view) {
        int i11 = R.id.vendorsListAreaButtonHeader;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.vendorsListToolbarAreaImageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.vendorsListToolbarAreaLinearLayout;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
                if (linearLayout != null) {
                    i11 = R.id.vendorsListToolbarAreaTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new ViewVendorListAreaButtonBinding((LinearLayout) view, textView, imageView, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewVendorListAreaButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewVendorListAreaButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_vendor_list_area_button, viewGroup, false);
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
