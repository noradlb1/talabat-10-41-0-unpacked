package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatTextView;

public final class CustomMessageViewBinding implements ViewBinding {
    @NonNull
    public final ImageView image;
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final TalabatTextView text;

    private CustomMessageViewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView) {
        this.rootView = coordinatorLayout;
        this.image = imageView;
        this.text = talabatTextView;
    }

    @NonNull
    public static CustomMessageViewBinding bind(@NonNull View view) {
        int i11 = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.image);
        if (imageView != null) {
            i11 = R.id.text;
            TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.text);
            if (talabatTextView != null) {
                return new CustomMessageViewBinding((CoordinatorLayout) view, imageView, talabatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomMessageViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomMessageViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.custom_message_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public CoordinatorLayout getRoot() {
        return this.rootView;
    }
}
