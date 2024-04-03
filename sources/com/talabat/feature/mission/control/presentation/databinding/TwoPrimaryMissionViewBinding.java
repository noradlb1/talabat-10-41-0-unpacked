package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.R;
import com.talabat.feature.mission.control.presentation.TwoPrimaryMissionItem;

public final class TwoPrimaryMissionViewBinding implements ViewBinding {
    @NonNull
    public final TwoPrimaryMissionItem firstPrimaryMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final TwoPrimaryMissionItem secondPrimaryMission;

    private TwoPrimaryMissionViewBinding(@NonNull View view, @NonNull TwoPrimaryMissionItem twoPrimaryMissionItem, @NonNull TwoPrimaryMissionItem twoPrimaryMissionItem2) {
        this.rootView = view;
        this.firstPrimaryMission = twoPrimaryMissionItem;
        this.secondPrimaryMission = twoPrimaryMissionItem2;
    }

    @NonNull
    public static TwoPrimaryMissionViewBinding bind(@NonNull View view) {
        int i11 = R.id.firstPrimaryMission;
        TwoPrimaryMissionItem twoPrimaryMissionItem = (TwoPrimaryMissionItem) ViewBindings.findChildViewById(view, i11);
        if (twoPrimaryMissionItem != null) {
            i11 = R.id.secondPrimaryMission;
            TwoPrimaryMissionItem twoPrimaryMissionItem2 = (TwoPrimaryMissionItem) ViewBindings.findChildViewById(view, i11);
            if (twoPrimaryMissionItem2 != null) {
                return new TwoPrimaryMissionViewBinding(view, twoPrimaryMissionItem, twoPrimaryMissionItem2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static TwoPrimaryMissionViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.two_primary_mission_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
