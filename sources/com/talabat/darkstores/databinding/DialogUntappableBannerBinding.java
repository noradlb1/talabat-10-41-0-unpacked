package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;

public final class DialogUntappableBannerBinding implements ViewBinding {
    @NonNull
    public final TextView continueBtn;
    @NonNull
    public final TextView dBody;
    @NonNull
    public final TextView dTitle;
    @NonNull
    public final AppCompatImageView imageView;
    @NonNull
    private final ConstraintLayout rootView;

    private DialogUntappableBannerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull AppCompatImageView appCompatImageView) {
        this.rootView = constraintLayout;
        this.continueBtn = textView;
        this.dBody = textView2;
        this.dTitle = textView3;
        this.imageView = appCompatImageView;
    }

    @NonNull
    public static DialogUntappableBannerBinding bind(@NonNull View view) {
        int i11 = R.id.continue_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView != null) {
            i11 = R.id.d_body;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
            if (textView2 != null) {
                i11 = R.id.d_title;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView3 != null) {
                    i11 = R.id.imageView;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
                    if (appCompatImageView != null) {
                        return new DialogUntappableBannerBinding((ConstraintLayout) view, textView, textView2, textView3, appCompatImageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DialogUntappableBannerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DialogUntappableBannerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.dialog_untappable_banner, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
