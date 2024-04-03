package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_button.DSSecondaryButton;
import com.designsystem.ds_button.DSTertiaryButton;
import com.talabat.R;
import com.talabat.designhelpers.WrappingViewPager;

public final class ActivityNewRateBinding implements ViewBinding {
    @NonNull
    public final DSSecondaryButton buttonBack;
    @NonNull
    public final DSTertiaryButton buttonFinish;
    @NonNull
    public final DSPrimaryButton buttonSubmit;
    @NonNull
    public final LinearLayout continueContainer;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final WrappingViewPager viewPager;

    private ActivityNewRateBinding(@NonNull RelativeLayout relativeLayout, @NonNull DSSecondaryButton dSSecondaryButton, @NonNull DSTertiaryButton dSTertiaryButton, @NonNull DSPrimaryButton dSPrimaryButton, @NonNull LinearLayout linearLayout, @NonNull WrappingViewPager wrappingViewPager) {
        this.rootView = relativeLayout;
        this.buttonBack = dSSecondaryButton;
        this.buttonFinish = dSTertiaryButton;
        this.buttonSubmit = dSPrimaryButton;
        this.continueContainer = linearLayout;
        this.viewPager = wrappingViewPager;
    }

    @NonNull
    public static ActivityNewRateBinding bind(@NonNull View view) {
        int i11 = R.id.button_back;
        DSSecondaryButton dSSecondaryButton = (DSSecondaryButton) ViewBindings.findChildViewById(view, R.id.button_back);
        if (dSSecondaryButton != null) {
            i11 = R.id.button_finish;
            DSTertiaryButton dSTertiaryButton = (DSTertiaryButton) ViewBindings.findChildViewById(view, R.id.button_finish);
            if (dSTertiaryButton != null) {
                i11 = R.id.button_submit;
                DSPrimaryButton dSPrimaryButton = (DSPrimaryButton) ViewBindings.findChildViewById(view, R.id.button_submit);
                if (dSPrimaryButton != null) {
                    i11 = R.id.continue_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.continue_container);
                    if (linearLayout != null) {
                        i11 = R.id.viewPager;
                        WrappingViewPager wrappingViewPager = (WrappingViewPager) ViewBindings.findChildViewById(view, R.id.viewPager);
                        if (wrappingViewPager != null) {
                            return new ActivityNewRateBinding((RelativeLayout) view, dSSecondaryButton, dSTertiaryButton, dSPrimaryButton, linearLayout, wrappingViewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static ActivityNewRateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static ActivityNewRateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.activity_new_rate, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public RelativeLayout getRoot() {
        return this.rootView;
    }
}
