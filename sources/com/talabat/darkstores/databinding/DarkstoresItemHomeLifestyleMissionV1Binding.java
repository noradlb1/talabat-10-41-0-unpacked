package com.talabat.darkstores.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.darkstores.R;
import com.talabat.feature.mission.control.presentation.LifeStyleMissionView;

public final class DarkstoresItemHomeLifestyleMissionV1Binding implements ViewBinding {
    @NonNull
    public final LifeStyleMissionView lifeStyleMissionV1;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresItemHomeLifestyleMissionV1Binding(@NonNull LinearLayout linearLayout, @NonNull LifeStyleMissionView lifeStyleMissionView) {
        this.rootView = linearLayout;
        this.lifeStyleMissionV1 = lifeStyleMissionView;
    }

    @NonNull
    public static DarkstoresItemHomeLifestyleMissionV1Binding bind(@NonNull View view) {
        int i11 = R.id.lifeStyleMissionV1;
        LifeStyleMissionView lifeStyleMissionView = (LifeStyleMissionView) ViewBindings.findChildViewById(view, i11);
        if (lifeStyleMissionView != null) {
            return new DarkstoresItemHomeLifestyleMissionV1Binding((LinearLayout) view, lifeStyleMissionView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeLifestyleMissionV1Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeLifestyleMissionV1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_lifestyle_mission_v1, viewGroup, false);
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
