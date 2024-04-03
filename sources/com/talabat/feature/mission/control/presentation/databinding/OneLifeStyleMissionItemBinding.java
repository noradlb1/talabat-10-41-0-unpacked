package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.R;

public final class OneLifeStyleMissionItemBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout containerView;
    @NonNull
    public final AppCompatImageView image;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView subtitle;
    @NonNull
    public final TextView title;

    private OneLifeStyleMissionItemBinding(@NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = view;
        this.containerView = constraintLayout;
        this.image = appCompatImageView;
        this.subtitle = textView;
        this.title = textView2;
    }

    @NonNull
    public static OneLifeStyleMissionItemBinding bind(@NonNull View view) {
        int i11 = R.id.containerView;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageView != null) {
                i11 = R.id.subtitle;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    i11 = R.id.title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView2 != null) {
                        return new OneLifeStyleMissionItemBinding(view, constraintLayout, appCompatImageView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static OneLifeStyleMissionItemBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.one_life_style_mission_item, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
