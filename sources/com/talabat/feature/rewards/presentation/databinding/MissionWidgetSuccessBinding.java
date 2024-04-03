package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.feature.rewards.presentation.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class MissionWidgetSuccessBinding implements ViewBinding {
    @NonNull
    public final ConstraintLayout clMission;
    @NonNull
    public final LottieAnimationView dsSpinner;
    @NonNull
    public final TalabatImageView ivMission;
    @NonNull
    private final View rootView;
    @NonNull
    public final TextView tvClaimRewards;
    @NonNull
    public final TextView tvMissionDescription;
    @NonNull
    public final TextView tvMissionTitle;

    private MissionWidgetSuccessBinding(@NonNull View view, @NonNull ConstraintLayout constraintLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull TalabatImageView talabatImageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.rootView = view;
        this.clMission = constraintLayout;
        this.dsSpinner = lottieAnimationView;
        this.ivMission = talabatImageView;
        this.tvClaimRewards = textView;
        this.tvMissionDescription = textView2;
        this.tvMissionTitle = textView3;
    }

    @NonNull
    public static MissionWidgetSuccessBinding bind(@NonNull View view) {
        int i11 = R.id.clMission;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i11);
        if (constraintLayout != null) {
            i11 = R.id.dsSpinner;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, i11);
            if (lottieAnimationView != null) {
                i11 = R.id.ivMission;
                TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
                if (talabatImageView != null) {
                    i11 = R.id.tvClaimRewards;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        i11 = R.id.tvMissionDescription;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i11);
                        if (textView2 != null) {
                            i11 = R.id.tvMissionTitle;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i11);
                            if (textView3 != null) {
                                return new MissionWidgetSuccessBinding(view, constraintLayout, lottieAnimationView, talabatImageView, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MissionWidgetSuccessBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.mission_widget_success, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
