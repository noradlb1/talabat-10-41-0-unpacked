package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewCustomToastBinding implements ViewBinding {
    @NonNull
    public final LinearLayout customToastView;
    @NonNull
    public final AppCompatImageView imageViewCustomToast;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final AppCompatTextView textViewCustomToast;

    private ViewCustomToastBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView) {
        this.rootView = linearLayout;
        this.customToastView = linearLayout2;
        this.imageViewCustomToast = appCompatImageView;
        this.textViewCustomToast = appCompatTextView;
    }

    @NonNull
    public static ViewCustomToastBinding bind(@NonNull View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i11 = R.id.image_view_custom_toast;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.text_view_custom_toast;
            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
            if (appCompatTextView != null) {
                return new ViewCustomToastBinding(linearLayout, linearLayout, appCompatImageView, appCompatTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewCustomToastBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewCustomToastBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_custom_toast, viewGroup, false);
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
