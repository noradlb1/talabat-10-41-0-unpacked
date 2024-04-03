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

public final class CustomMessageErrorViewBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView header;
    @NonNull
    public final ImageView image;
    @NonNull
    private final CoordinatorLayout rootView;
    @NonNull
    public final TalabatTextView text;

    private CustomMessageErrorViewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TalabatTextView talabatTextView, @NonNull ImageView imageView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = coordinatorLayout;
        this.header = talabatTextView;
        this.image = imageView;
        this.text = talabatTextView2;
    }

    @NonNull
    public static CustomMessageErrorViewBinding bind(@NonNull View view) {
        int i11 = R.id.header;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.header);
        if (talabatTextView != null) {
            i11 = R.id.image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.image);
            if (imageView != null) {
                i11 = R.id.text;
                TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.text);
                if (talabatTextView2 != null) {
                    return new CustomMessageErrorViewBinding((CoordinatorLayout) view, talabatTextView, imageView, talabatTextView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static CustomMessageErrorViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static CustomMessageErrorViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.custom_message_error_view, viewGroup, false);
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
