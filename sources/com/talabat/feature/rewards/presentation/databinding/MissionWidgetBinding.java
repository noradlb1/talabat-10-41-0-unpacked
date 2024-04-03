package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.rewards.presentation.R;
import com.talabat.feature.rewards.presentation.mission.ActiveMissionWidgetView;
import com.talabat.feature.rewards.presentation.mission.OptInMissionWidgetView;
import com.talabat.feature.rewards.presentation.mission.SuccessMissionWidgetView;

public final class MissionWidgetBinding implements ViewBinding {
    @NonNull
    public final ActiveMissionWidgetView layoutMissionActive;
    @NonNull
    public final OptInMissionWidgetView layoutMissionOptIn;
    @NonNull
    public final SuccessMissionWidgetView layoutMissionSuccess;
    @NonNull
    private final View rootView;

    private MissionWidgetBinding(@NonNull View view, @NonNull ActiveMissionWidgetView activeMissionWidgetView, @NonNull OptInMissionWidgetView optInMissionWidgetView, @NonNull SuccessMissionWidgetView successMissionWidgetView) {
        this.rootView = view;
        this.layoutMissionActive = activeMissionWidgetView;
        this.layoutMissionOptIn = optInMissionWidgetView;
        this.layoutMissionSuccess = successMissionWidgetView;
    }

    @NonNull
    public static MissionWidgetBinding bind(@NonNull View view) {
        int i11 = R.id.layout_mission_active;
        ActiveMissionWidgetView activeMissionWidgetView = (ActiveMissionWidgetView) ViewBindings.findChildViewById(view, i11);
        if (activeMissionWidgetView != null) {
            i11 = R.id.layout_mission_opt_in;
            OptInMissionWidgetView optInMissionWidgetView = (OptInMissionWidgetView) ViewBindings.findChildViewById(view, i11);
            if (optInMissionWidgetView != null) {
                i11 = R.id.layout_mission_success;
                SuccessMissionWidgetView successMissionWidgetView = (SuccessMissionWidgetView) ViewBindings.findChildViewById(view, i11);
                if (successMissionWidgetView != null) {
                    return new MissionWidgetBinding(view, activeMissionWidgetView, optInMissionWidgetView, successMissionWidgetView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MissionWidgetBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.mission_widget, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
