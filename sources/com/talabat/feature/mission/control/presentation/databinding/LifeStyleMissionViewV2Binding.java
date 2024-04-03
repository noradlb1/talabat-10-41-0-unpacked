package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.OneLifeStyleMissionItem;
import com.talabat.feature.mission.control.presentation.R;

public final class LifeStyleMissionViewV2Binding implements ViewBinding {
    @NonNull
    public final RecyclerView lifestyleRecyclerview;
    @NonNull
    public final OneLifeStyleMissionItem oneLifeStyleMission;
    @NonNull
    private final View rootView;

    private LifeStyleMissionViewV2Binding(@NonNull View view, @NonNull RecyclerView recyclerView, @NonNull OneLifeStyleMissionItem oneLifeStyleMissionItem) {
        this.rootView = view;
        this.lifestyleRecyclerview = recyclerView;
        this.oneLifeStyleMission = oneLifeStyleMissionItem;
    }

    @NonNull
    public static LifeStyleMissionViewV2Binding bind(@NonNull View view) {
        int i11 = R.id.lifestyleRecyclerview;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i11);
        if (recyclerView != null) {
            i11 = R.id.oneLifeStyleMission;
            OneLifeStyleMissionItem oneLifeStyleMissionItem = (OneLifeStyleMissionItem) ViewBindings.findChildViewById(view, i11);
            if (oneLifeStyleMissionItem != null) {
                return new LifeStyleMissionViewV2Binding(view, recyclerView, oneLifeStyleMissionItem);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static LifeStyleMissionViewV2Binding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.life_style_mission_view_v2, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
