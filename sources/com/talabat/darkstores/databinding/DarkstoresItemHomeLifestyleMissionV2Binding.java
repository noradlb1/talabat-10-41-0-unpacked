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
import com.talabat.feature.mission.control.presentation.LifeStyleMissionV2View;

public final class DarkstoresItemHomeLifestyleMissionV2Binding implements ViewBinding {
    @NonNull
    public final LifeStyleMissionV2View lifeStyleMissionV2;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresItemHomeLifestyleMissionV2Binding(@NonNull LinearLayout linearLayout, @NonNull LifeStyleMissionV2View lifeStyleMissionV2View) {
        this.rootView = linearLayout;
        this.lifeStyleMissionV2 = lifeStyleMissionV2View;
    }

    @NonNull
    public static DarkstoresItemHomeLifestyleMissionV2Binding bind(@NonNull View view) {
        int i11 = R.id.lifeStyleMissionV2;
        LifeStyleMissionV2View lifeStyleMissionV2View = (LifeStyleMissionV2View) ViewBindings.findChildViewById(view, i11);
        if (lifeStyleMissionV2View != null) {
            return new DarkstoresItemHomeLifestyleMissionV2Binding((LinearLayout) view, lifeStyleMissionV2View);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomeLifestyleMissionV2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomeLifestyleMissionV2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_lifestyle_mission_v2, viewGroup, false);
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
