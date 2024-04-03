package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionItemView;
import com.talabat.feature.mission.control.presentation.R;

public final class TwoLifeStyleMissionItemBinding implements ViewBinding {
    @NonNull
    public final LifeStyleMissionItemView firstLifeStyleMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final LifeStyleMissionItemView secondLifeStyleMission;

    private TwoLifeStyleMissionItemBinding(@NonNull View view, @NonNull LifeStyleMissionItemView lifeStyleMissionItemView, @NonNull LifeStyleMissionItemView lifeStyleMissionItemView2) {
        this.rootView = view;
        this.firstLifeStyleMission = lifeStyleMissionItemView;
        this.secondLifeStyleMission = lifeStyleMissionItemView2;
    }

    @NonNull
    public static TwoLifeStyleMissionItemBinding bind(@NonNull View view) {
        int i11 = R.id.firstLifeStyleMission;
        LifeStyleMissionItemView lifeStyleMissionItemView = (LifeStyleMissionItemView) ViewBindings.findChildViewById(view, i11);
        if (lifeStyleMissionItemView != null) {
            i11 = R.id.secondLifeStyleMission;
            LifeStyleMissionItemView lifeStyleMissionItemView2 = (LifeStyleMissionItemView) ViewBindings.findChildViewById(view, i11);
            if (lifeStyleMissionItemView2 != null) {
                return new TwoLifeStyleMissionItemBinding(view, lifeStyleMissionItemView, lifeStyleMissionItemView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TwoLifeStyleMissionItemBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.two_life_style_mission_item, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
