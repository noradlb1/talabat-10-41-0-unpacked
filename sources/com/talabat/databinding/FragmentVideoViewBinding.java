package com.talabat.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.MutedVideoView;

public final class FragmentVideoViewBinding implements ViewBinding {
    @NonNull
    public final TalabatTextView locationTitleText;
    @NonNull
    public final LottieAnimationView lottieAnimationView;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final RelativeLayout talabatView;
    @NonNull
    public final MutedVideoView videoViewSplash;

    private FragmentVideoViewBinding(@NonNull FrameLayout frameLayout, @NonNull TalabatTextView talabatTextView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull RelativeLayout relativeLayout, @NonNull MutedVideoView mutedVideoView) {
        this.rootView = frameLayout;
        this.locationTitleText = talabatTextView;
        this.lottieAnimationView = lottieAnimationView2;
        this.talabatView = relativeLayout;
        this.videoViewSplash = mutedVideoView;
    }

    @NonNull
    public static FragmentVideoViewBinding bind(@NonNull View view) {
        int i11 = R.id.location_title_text;
        TalabatTextView talabatTextView = (TalabatTextView) ViewBindings.findChildViewById(view, R.id.location_title_text);
        if (talabatTextView != null) {
            i11 = R.id.lottieAnimationView;
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.lottieAnimationView);
            if (lottieAnimationView2 != null) {
                i11 = R.id.talabat_view;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.talabat_view);
                if (relativeLayout != null) {
                    i11 = R.id.videoView_splash;
                    MutedVideoView mutedVideoView = (MutedVideoView) ViewBindings.findChildViewById(view, R.id.videoView_splash);
                    if (mutedVideoView != null) {
                        return new FragmentVideoViewBinding((FrameLayout) view, talabatTextView, lottieAnimationView2, relativeLayout, mutedVideoView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static FragmentVideoViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    @NonNull
    public static FragmentVideoViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View inflate = layoutInflater.inflate(R.layout.fragment_video_view, viewGroup, false);
        if (z11) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
