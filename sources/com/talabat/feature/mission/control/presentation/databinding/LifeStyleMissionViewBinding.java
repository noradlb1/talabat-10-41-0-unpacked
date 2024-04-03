package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.OneLifeStyleMissionItem;
import com.talabat.feature.mission.control.presentation.R;
import com.talabat.feature.mission.control.presentation.TwoLifeStyleMissionItem;

public final class LifeStyleMissionViewBinding implements ViewBinding {
    @NonNull
    public final OneLifeStyleMissionItem oneLifeStyleMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final TwoLifeStyleMissionItem twoLifeStyleMission;

    private LifeStyleMissionViewBinding(@NonNull View view, @NonNull OneLifeStyleMissionItem oneLifeStyleMissionItem, @NonNull TwoLifeStyleMissionItem twoLifeStyleMissionItem) {
        this.rootView = view;
        this.oneLifeStyleMission = oneLifeStyleMissionItem;
        this.twoLifeStyleMission = twoLifeStyleMissionItem;
    }

    @NonNull
    public static LifeStyleMissionViewBinding bind(@NonNull View view) {
        int i11 = R.id.oneLifeStyleMission;
        OneLifeStyleMissionItem oneLifeStyleMissionItem = (OneLifeStyleMissionItem) ViewBindings.findChildViewById(view, i11);
        if (oneLifeStyleMissionItem != null) {
            i11 = R.id.twoLifeStyleMission;
            TwoLifeStyleMissionItem twoLifeStyleMissionItem = (TwoLifeStyleMissionItem) ViewBindings.findChildViewById(view, i11);
            if (twoLifeStyleMissionItem != null) {
                return new LifeStyleMissionViewBinding(view, oneLifeStyleMissionItem, twoLifeStyleMissionItem);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LifeStyleMissionViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.life_style_mission_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
