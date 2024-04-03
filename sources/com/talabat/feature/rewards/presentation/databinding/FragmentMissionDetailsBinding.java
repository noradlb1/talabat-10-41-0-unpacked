package com.talabat.feature.rewards.presentation.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_icon_button.DSIconButton;
import com.talabat.feature.rewards.presentation.R;
import com.talabat.talabatcommon.views.TalabatImageView;

public final class FragmentMissionDetailsBinding implements ViewBinding {
    @NonNull
    public final DSIconButton dsIconButtonClose;
    @NonNull
    public final LinearLayout llSections;
    @NonNull
    private final ConstraintLayout rootView;
    @NonNull
    public final TalabatImageView tivImage;
    @NonNull
    public final TextView tvTitle;

    private FragmentMissionDetailsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull DSIconButton dSIconButton, @NonNull LinearLayout linearLayout, @NonNull TalabatImageView talabatImageView, @NonNull TextView textView) {
        this.rootView = constraintLayout;
        this.dsIconButtonClose = dSIconButton;
        this.llSections = linearLayout;
        this.tivImage = talabatImageView;
        this.tvTitle = textView;
    }

    @NonNull
    public static FragmentMissionDetailsBinding bind(@NonNull View view) {
        int i11 = R.id.dsIconButtonClose;
        DSIconButton dSIconButton = (DSIconButton) ViewBindings.findChildViewById(view, i11);
        if (dSIconButton != null) {
            i11 = R.id.llSections;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i11);
            if (linearLayout != null) {
                i11 = R.id.tivImage;
                TalabatImageView talabatImageView = (TalabatImageView) ViewBindings.findChildViewById(view, i11);
                if (talabatImageView != null) {
                    i11 = R.id.tvTitle;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i11);
                    if (textView != null) {
                        return new FragmentMissionDetailsBinding((ConstraintLayout) view, dSIconButton, linearLayout, talabatImageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentMissionDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentMissionDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_mission_details, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public ConstraintLayout getRoot() {
        return this.rootView;
    }
}
