package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class ViewDsAlertBinding implements ViewBinding {
    @NonNull
    public final AppCompatImageView imageViewCloseIcon;
    @NonNull
    public final AppCompatImageView imageViewIcon;
    @NonNull
    public final ConstraintLayout rootView;
    @NonNull
    private final ConstraintLayout rootView_;
    @NonNull
    public final AppCompatTextView textViewAction;
    @NonNull
    public final AppCompatTextView textViewDescriptor;
    @NonNull
    public final AppCompatTextView textViewTitle;

    private ViewDsAlertBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3) {
        this.rootView_ = constraintLayout;
        this.imageViewCloseIcon = appCompatImageView;
        this.imageViewIcon = appCompatImageView2;
        this.rootView = constraintLayout2;
        this.textViewAction = appCompatTextView;
        this.textViewDescriptor = appCompatTextView2;
        this.textViewTitle = appCompatTextView3;
    }

    @NonNull
    public static ViewDsAlertBinding bind(@NonNull View view) {
        int i11 = R.id.image_view_close_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
        if (appCompatImageView != null) {
            i11 = R.id.image_view_icon;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i11 = R.id.text_view_action;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                if (appCompatTextView != null) {
                    i11 = R.id.text_view_descriptor;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R.id.text_view_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.findChildViewById(view, i11);
                        if (appCompatTextView3 != null) {
                            return new ViewDsAlertBinding(constraintLayout, appCompatImageView, appCompatImageView2, constraintLayout, appCompatTextView, appCompatTextView2, appCompatTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ViewDsAlertBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ViewDsAlertBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.view_ds_alert, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView_;
    }
}
