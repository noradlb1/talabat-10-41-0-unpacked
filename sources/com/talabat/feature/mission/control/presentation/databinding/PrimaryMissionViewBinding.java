package com.talabat.feature.mission.control.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.mission.control.presentation.R;
import com.talabat.feature.mission.control.presentation.ThreePrimaryMissionView;
import com.talabat.feature.mission.control.presentation.TwoPrimaryMissionView;

public final class PrimaryMissionViewBinding implements ViewBinding {
    @NonNull
    private final View rootView;
    @NonNull
    public final ThreePrimaryMissionView threePrimaryMissionView;
    @NonNull
    public final TwoPrimaryMissionView twoPrimaryMissionView;

    private PrimaryMissionViewBinding(@NonNull View view, @NonNull ThreePrimaryMissionView threePrimaryMissionView2, @NonNull TwoPrimaryMissionView twoPrimaryMissionView2) {
        this.rootView = view;
        this.threePrimaryMissionView = threePrimaryMissionView2;
        this.twoPrimaryMissionView = twoPrimaryMissionView2;
    }

    @NonNull
    public static PrimaryMissionViewBinding bind(@NonNull View view) {
        int i11 = R.id.threePrimaryMissionView;
        ThreePrimaryMissionView threePrimaryMissionView2 = (ThreePrimaryMissionView) ViewBindings.findChildViewById(view, i11);
        if (threePrimaryMissionView2 != null) {
            i11 = R.id.twoPrimaryMissionView;
            TwoPrimaryMissionView twoPrimaryMissionView2 = (TwoPrimaryMissionView) ViewBindings.findChildViewById(view, i11);
            if (twoPrimaryMissionView2 != null) {
                return new PrimaryMissionViewBinding(view, threePrimaryMissionView2, twoPrimaryMissionView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static PrimaryMissionViewBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.primary_mission_view, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
