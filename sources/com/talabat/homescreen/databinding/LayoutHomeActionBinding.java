package com.talabat.homescreen.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.homescreen.R;

public final class LayoutHomeActionBinding implements ViewBinding {
    @NonNull
    public final ImageView ivHomeActionLayoutIcon;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView tvHomeActionLayoutTitle;

    private LayoutHomeActionBinding(@NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.rootView = view;
        this.ivHomeActionLayoutIcon = imageView;
        this.tvHomeActionLayoutTitle = textView;
    }

    @NonNull
    public static LayoutHomeActionBinding bind(@NonNull View view) {
        int i11 = R.id.ivHomeActionLayoutIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.tvHomeActionLayoutTitle;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView != null) {
                return new LayoutHomeActionBinding(view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutHomeActionBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.layout_home_action, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
