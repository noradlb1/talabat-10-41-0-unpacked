package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewErrorNotifyBinding implements ViewBinding {
    @NonNull
    public final LinearLayout container;
    @NonNull
    private final View rootView;
    @NonNull
    public final ImageView statusNotifyImageView;
    @NonNull
    public final TextView statusNotifyMessageTextView;
    @NonNull
    public final TextView statusNotifyTitleTextView;

    private ViewErrorNotifyBinding(@NonNull View view, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = view;
        this.container = linearLayout;
        this.statusNotifyImageView = imageView;
        this.statusNotifyMessageTextView = textView;
        this.statusNotifyTitleTextView = textView2;
    }

    @NonNull
    public static ViewErrorNotifyBinding bind(@NonNull View view) {
        int i11 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
        if (linearLayout != null) {
            i11 = R.id.statusNotifyImageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView != null) {
                i11 = R.id.statusNotifyMessageTextView;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.statusNotifyTitleTextView;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new ViewErrorNotifyBinding(view, linearLayout, imageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewErrorNotifyBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.view_error_notify, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
