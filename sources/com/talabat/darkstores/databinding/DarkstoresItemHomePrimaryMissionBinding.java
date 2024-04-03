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
import com.talabat.feature.mission.control.presentation.PrimaryMissionView;

public final class DarkstoresItemHomePrimaryMissionBinding implements ViewBinding {
    @NonNull
    public final PrimaryMissionView primaryMissionView1;
    @NonNull
    private final LinearLayout rootView;

    private DarkstoresItemHomePrimaryMissionBinding(@NonNull LinearLayout linearLayout, @NonNull PrimaryMissionView primaryMissionView) {
        this.rootView = linearLayout;
        this.primaryMissionView1 = primaryMissionView;
    }

    @NonNull
    public static DarkstoresItemHomePrimaryMissionBinding bind(@NonNull View view) {
        int i11 = R.id.primaryMissionView1;
        PrimaryMissionView primaryMissionView = (PrimaryMissionView) ViewBindings.findChildViewById(view, i11);
        if (primaryMissionView != null) {
            return new DarkstoresItemHomePrimaryMissionBinding((LinearLayout) view, primaryMissionView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static DarkstoresItemHomePrimaryMissionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static DarkstoresItemHomePrimaryMissionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.darkstores_item_home_primary_mission, viewGroup, false);
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
