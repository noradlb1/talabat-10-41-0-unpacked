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

public final class FragmentCartErrorDialogBinding implements ViewBinding {
    @NonNull
    public final TextView continueBtn;
    @NonNull
    public final AppCompatImageView imageView;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textView;
    @NonNull
    public final TextView textView3;

    private FragmentCartErrorDialogBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView2, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView4, @NonNull TextView textView5) {
        this.rootView = constraintLayout;
        this.continueBtn = textView2;
        this.imageView = appCompatImageView;
        this.textView = textView4;
        this.textView3 = textView5;
    }

    @NonNull
    public static FragmentCartErrorDialogBinding bind(@NonNull View view) {
        int i11 = R.id.continue_btn;
        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
        if (textView2 != null) {
            i11 = R.id.imageView;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageView != null) {
                i11 = R.id.textView;
                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView4 != null) {
                    i11 = R.id.textView3;
                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView5 != null) {
                        return new FragmentCartErrorDialogBinding((ConstraintLayout) view, textView2, appCompatImageView, textView4, textView5);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentCartErrorDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentCartErrorDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cart_error_dialog, viewGroup, false);
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
