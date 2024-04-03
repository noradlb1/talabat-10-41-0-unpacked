package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.talabat.R;
import com.talabat.TalabatButton;
import com.talabat.TalabatTextView;
import com.talabat.talabatcommon.views.TalabatFillButton;

public final class MapOnboardingBinding implements ViewBinding {
    @NonNull
    public final RelativeLayout boardingContentView;
    @NonNull
    public final TalabatButton dummyTransparentButton;
    @NonNull
    public final RelativeLayout onBoardingAnimationContainer;
    @NonNull
    public final ImageView onBoardingAnimationDummy;
    @NonNull
    public final ImageView onBoardingGiff;
    @NonNull
    public final TalabatFillButton onBoardingGotIt;
    @NonNull
    private final RelativeLayout rootView;
    @NonNull
    public final RelativeLayout showCaseView;
    @NonNull
    public final TalabatTextView textUserGuideSubTxt;
    @NonNull
    public final TalabatTextView textUserGuideTxt;

    private MapOnboardingBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TalabatButton talabatButton, @NonNull RelativeLayout relativeLayout3, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TalabatFillButton talabatFillButton, @NonNull RelativeLayout relativeLayout4, @NonNull TalabatTextView talabatTextView, @NonNull TalabatTextView talabatTextView2) {
        this.rootView = relativeLayout;
        this.boardingContentView = relativeLayout2;
        this.dummyTransparentButton = talabatButton;
        this.onBoardingAnimationContainer = relativeLayout3;
        this.onBoardingAnimationDummy = imageView;
        this.onBoardingGiff = imageView2;
        this.onBoardingGotIt = talabatFillButton;
        this.showCaseView = relativeLayout4;
        this.textUserGuideSubTxt = talabatTextView;
        this.textUserGuideTxt = talabatTextView2;
    }

    @NonNull
    public static MapOnboardingBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i11 = R.id.dummy_transparent_button;
        TalabatButton talabatButton = (TalabatButton) ViewBindings.findChildViewById(view, R.id.dummy_transparent_button);
        if (talabatButton != null) {
            i11 = R.id.on_boarding_animation_container;
            RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.on_boarding_animation_container);
            if (relativeLayout2 != null) {
                i11 = R.id.on_boarding_animation_dummy;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.on_boarding_animation_dummy);
                if (imageView != null) {
                    i11 = R.id.on_boarding_giff;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.on_boarding_giff);
                    if (imageView2 != null) {
                        i11 = R.id.on_boarding_got_it;
                        TalabatFillButton talabatFillButton = (TalabatFillButton) ViewBindings.findChildViewById(view, R.id.on_boarding_got_it);
                        if (talabatFillButton != null) {
                            i11 = R.id.show_case_view;
                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.show_case_view);
                            if (relativeLayout3 != null) {
                                i11 = R.id.text_user_guide_sub_txt;
                                TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.text_user_guide_sub_txt);
                                if (talabatTextView != null) {
                                    i11 = R.id.text_user_guide_txt;
                                    TalabatTextView talabatTextView2 = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.text_user_guide_txt);
                                    if (talabatTextView2 != null) {
                                        return new MapOnboardingBinding(relativeLayout, relativeLayout, talabatButton, relativeLayout2, imageView, imageView2, talabatFillButton, relativeLayout3, talabatTextView, talabatTextView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static MapOnboardingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static MapOnboardingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.map_onboarding, viewGroup, false);
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
