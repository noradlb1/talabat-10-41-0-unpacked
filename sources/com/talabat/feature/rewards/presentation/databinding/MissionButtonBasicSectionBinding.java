package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.designsystem.ds_button_v2.DSSecondaryButton;
import com.talabat.feature.rewards.presentation.R;

public final class MissionButtonBasicSectionBinding implements ViewBinding {
    @NonNull
    private final DSSecondaryButton rootView;

    private MissionButtonBasicSectionBinding(@NonNull DSSecondaryButton dSSecondaryButton) {
        this.rootView = dSSecondaryButton;
    }

    @NonNull
    public static MissionButtonBasicSectionBinding bind(@NonNull View view) {
        if (view != null) {
            return new MissionButtonBasicSectionBinding((DSSecondaryButton) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MissionButtonBasicSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MissionButtonBasicSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.mission_button_basic_section, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public DSSecondaryButton getRoot() {
        return this.rootView;
    }
}
