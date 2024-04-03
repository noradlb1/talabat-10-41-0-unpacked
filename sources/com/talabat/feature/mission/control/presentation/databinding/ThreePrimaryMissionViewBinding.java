package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.R;
import com.talabat.feature.mission.control.presentation.ThreePrimaryMissionItem;

public final class ThreePrimaryMissionViewBinding implements ViewBinding {
    @NonNull
    public final ThreePrimaryMissionItem firstPrimaryMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final ThreePrimaryMissionItem secondPrimaryMission;
    @NonNull
    public final ThreePrimaryMissionItem thirdPrimaryMission;

    private ThreePrimaryMissionViewBinding(@NonNull View view, @NonNull ThreePrimaryMissionItem threePrimaryMissionItem, @NonNull ThreePrimaryMissionItem threePrimaryMissionItem2, @NonNull ThreePrimaryMissionItem threePrimaryMissionItem3) {
        this.rootView = view;
        this.firstPrimaryMission = threePrimaryMissionItem;
        this.secondPrimaryMission = threePrimaryMissionItem2;
        this.thirdPrimaryMission = threePrimaryMissionItem3;
    }

    @NonNull
    public static ThreePrimaryMissionViewBinding bind(@NonNull View view) {
        int i11 = R.id.firstPrimaryMission;
        ThreePrimaryMissionItem threePrimaryMissionItem = (ThreePrimaryMissionItem) ViewBindings.findChildViewById(view, i11);
        if (threePrimaryMissionItem != null) {
            i11 = R.id.secondPrimaryMission;
            ThreePrimaryMissionItem threePrimaryMissionItem2 = (ThreePrimaryMissionItem) ViewBindings.findChildViewById(view, i11);
            if (threePrimaryMissionItem2 != null) {
                i11 = R.id.thirdPrimaryMission;
                ThreePrimaryMissionItem threePrimaryMissionItem3 = (ThreePrimaryMissionItem) ViewBindings.findChildViewById(view, i11);
                if (threePrimaryMissionItem3 != null) {
                    return new ThreePrimaryMissionViewBinding(view, threePrimaryMissionItem, threePrimaryMissionItem2, threePrimaryMissionItem3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ThreePrimaryMissionViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.three_primary_mission_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
