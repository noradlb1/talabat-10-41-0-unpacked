package com.talabat.talabatcommon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.talabatcommon.R;

public final class LayoutLookingGlassRamadanBinding implements ViewBinding {
    @NonNull
    public final ImageView headerIcon;
    @NonNull
    public final ImageView imageviewClock;
    @NonNull
    public final RelativeLayout layoutBody;
    @NonNull
    public final ConstraintLayout layoutHeader;
    @NonNull
    public final ConstraintLayout layoutRamadan;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView textviewRemainingTime;
    @NonNull
    public final TextView textviewTime;

    private LayoutLookingGlassRamadanBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RelativeLayout relativeLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = constraintLayout;
        this.headerIcon = imageView;
        this.imageviewClock = imageView2;
        this.layoutBody = relativeLayout;
        this.layoutHeader = constraintLayout2;
        this.layoutRamadan = constraintLayout3;
        this.textviewRemainingTime = textView;
        this.textviewTime = textView2;
    }

    @NonNull
    public static LayoutLookingGlassRamadanBinding bind(@NonNull View view) {
        int i11 = R.id.headerIcon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i11);
        if (imageView != null) {
            i11 = R.id.imageview_clock;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i11);
            if (imageView2 != null) {
                i11 = R.id.layout_body;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i11);
                if (relativeLayout != null) {
                    i11 = R.id.layout_header;
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
                    if (constraintLayout != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                        i11 = R.id.textview_remainingTime;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView != null) {
                            i11 = R.id.textview_time;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView2 != null) {
                                return new LayoutLookingGlassRamadanBinding(constraintLayout2, imageView, imageView2, relativeLayout, constraintLayout, constraintLayout2, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LayoutLookingGlassRamadanBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LayoutLookingGlassRamadanBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.layout_looking_glass_ramadan, viewGroup, false);
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
