package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_button_v2.DSPrimaryButton;
import com.talabat.feature.rewards.presentation.R;

public final class MissionButtonPrimarySectionBinding implements ViewBinding {
    @NonNull
    private final DSPrimaryButton rootView;

    private MissionButtonPrimarySectionBinding(@NonNull DSPrimaryButton dSPrimaryButton) {
        this.rootView = dSPrimaryButton;
    }

    @NonNull
    public static MissionButtonPrimarySectionBinding bind(@NonNull View view) {
        if (view != null) {
            return new MissionButtonPrimarySectionBinding((DSPrimaryButton) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MissionButtonPrimarySectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MissionButtonPrimarySectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mission_button_primary_section, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DSPrimaryButton getRoot() {
        return this.rootView;
    }
}
