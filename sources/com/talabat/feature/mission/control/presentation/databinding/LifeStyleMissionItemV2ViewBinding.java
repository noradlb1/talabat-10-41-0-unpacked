package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.R;

public final class LifeStyleMissionItemV2ViewBinding implements ViewBinding {
    @NonNull
    public final CardView containerView;
    @NonNull
    public final AppCompatImageView image;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TextView title;

    private LifeStyleMissionItemV2ViewBinding(@NonNull ConstraintLayout constraintLayout, @NonNull CardView cardView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.containerView = cardView;
        this.image = appCompatImageView;
        this.title = textView;
    }

    @NonNull
    public static LifeStyleMissionItemV2ViewBinding bind(@NonNull View view) {
        int i11 = R.id.containerView;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i11);
        if (cardView != null) {
            i11 = R.id.image;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i11);
            if (appCompatImageView != null) {
                i11 = R.id.title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                if (textView != null) {
                    return new LifeStyleMissionItemV2ViewBinding((ConstraintLayout) view, cardView, appCompatImageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LifeStyleMissionItemV2ViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static LifeStyleMissionItemV2ViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.life_style_mission_item_v2_view, viewGroup, false);
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
