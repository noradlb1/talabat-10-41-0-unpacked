package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.feature.rewards.presentation.R;
import com.talabat.feature.rewards.presentation.mission.StepProgressView;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class MissionWidgetActiveBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clMission;
    @NonNull
    public final TalabatImageView ivMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final StepProgressView spiMission;
    @NonNull
    public final TextView tvMissionDescription;
    @NonNull
    public final TextView tvMissionTitle;

    private MissionWidgetActiveBinding(@NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull TalabatImageView talabatImageView, @NonNull StepProgressView stepProgressView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.rootView = view;
        this.clMission = constraintLayout;
        this.ivMission = talabatImageView;
        this.spiMission = stepProgressView;
        this.tvMissionDescription = textView;
        this.tvMissionTitle = textView2;
    }

    @NonNull
    public static MissionWidgetActiveBinding bind(@NonNull View view) {
        int i11 = R.id.clMission;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.ivMission;
            TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
            if (talabatImageView != null) {
                i11 = R.id.spiMission;
                StepProgressView stepProgressView = (StepProgressView) ViewBindings.findChildViewById(view, i11);
                if (stepProgressView != null) {
                    i11 = R.id.tvMissionDescription;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tvMissionTitle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            return new MissionWidgetActiveBinding(view, constraintLayout, talabatImageView, stepProgressView, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MissionWidgetActiveBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.mission_widget_active, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
