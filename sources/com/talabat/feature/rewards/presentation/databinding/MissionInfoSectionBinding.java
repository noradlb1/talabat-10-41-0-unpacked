package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_alert.DSAlert;
import com.talabat.feature.rewards.presentation.R;

public final class MissionInfoSectionBinding implements ViewBinding {
    @NonNull
    public final DSAlert dsAlert;
    @NonNull
    private final DSAlert rootView;

    private MissionInfoSectionBinding(@NonNull DSAlert dSAlert, @NonNull DSAlert dSAlert2) {
        this.rootView = dSAlert;
        this.dsAlert = dSAlert2;
    }

    @NonNull
    public static MissionInfoSectionBinding bind(@NonNull View view) {
        if (view != null) {
            DSAlert dSAlert = (DSAlert) view;
            return new MissionInfoSectionBinding(dSAlert, dSAlert);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MissionInfoSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MissionInfoSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mission_info_section, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DSAlert getRoot() {
        return this.rootView;
    }
}
