package com.talabat.splash.presentation.ui;

import android.animation.Animator;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.talabat.R;
import com.talabat.TalabatTextView;
import com.talabat.helpers.MutedVideoView;
import com.talabat.splash.core.platform.BaseFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xu.l;
import xu.m;
import xu.n;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0017\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/splash/presentation/ui/WelcomeVideoFragment;", "Lcom/talabat/splash/core/platform/BaseFragment;", "Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModelInjectable;", "()V", "isOnboardingExperimentEnabled", "", "isShowOverlay", "isSplashVideo", "isVideoRepeat", "splashActivitySharedViewModel", "Lcom/talabat/splash/presentation/ui/SplashActivitySharedViewModel;", "videoPath", "", "initObserver", "", "initVideoPlayBack", "playVideoWithOverlay", "(Ljava/lang/Boolean;)V", "inject", "layoutId", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "playWelcomeVideo", "setupLayoutParams", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WelcomeVideoFragment extends BaseFragment implements SplashActivitySharedViewModelInjectable {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_FRAME_IN_ANIMATION = 106;
    public static final int MIN_FRAME_IN_ANIMATION = 0;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private boolean isOnboardingExperimentEnabled;
    private boolean isShowOverlay;
    private boolean isSplashVideo;
    private boolean isVideoRepeat;
    @Nullable
    private SplashActivitySharedViewModel splashActivitySharedViewModel;
    @Nullable
    private String videoPath;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/splash/presentation/ui/WelcomeVideoFragment$Companion;", "", "()V", "MAX_FRAME_IN_ANIMATION", "", "MIN_FRAME_IN_ANIMATION", "newInstance", "Lcom/talabat/splash/presentation/ui/WelcomeVideoFragment;", "param1", "", "param2", "", "param3", "param4", "param5", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final WelcomeVideoFragment newInstance(@NotNull String str, boolean z11, boolean z12, boolean z13, boolean z14) {
            Intrinsics.checkNotNullParameter(str, "param1");
            WelcomeVideoFragment welcomeVideoFragment = new WelcomeVideoFragment();
            Bundle bundle = new Bundle();
            bundle.putString("videoPath", str);
            bundle.putBoolean("IsShowOverlay", z11);
            bundle.putBoolean("IsVideoRepeat", z12);
            bundle.putBoolean("IsSplashVideo", z13);
            bundle.putBoolean("IsOnboardingExperimentEnabled", z14);
            welcomeVideoFragment.setArguments(bundle);
            return welcomeVideoFragment;
        }
    }

    private final void initObserver() {
        MutableLiveData<Boolean> playVideoWithOverlay;
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null && (playVideoWithOverlay = splashActivitySharedViewModel2.getPlayVideoWithOverlay()) != null) {
            playVideoWithOverlay.observe(getViewLifecycleOwner(), new n(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: initObserver$lambda-1  reason: not valid java name */
    public static final void m10923initObserver$lambda1(WelcomeVideoFragment welcomeVideoFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(welcomeVideoFragment, "this$0");
        welcomeVideoFragment.initVideoPlayBack(bool);
    }

    private final void initVideoPlayBack(Boolean bool) {
        Intrinsics.checkNotNull(bool);
        if (bool.booleanValue()) {
            ((TalabatTextView) _$_findCachedViewById(R.id.location_title_text)).setVisibility(8);
        } else {
            ((TalabatTextView) _$_findCachedViewById(R.id.location_title_text)).setVisibility(8);
        }
        playWelcomeVideo();
    }

    @JvmStatic
    @NotNull
    public static final WelcomeVideoFragment newInstance(@NotNull String str, boolean z11, boolean z12, boolean z13, boolean z14) {
        return Companion.newInstance(str, z11, z12, z13, z14);
    }

    private final void playWelcomeVideo() {
        if (this.isOnboardingExperimentEnabled) {
            int i11 = R.id.lottieAnimationView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) _$_findCachedViewById(i11);
            Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "lottieAnimationView");
            setupLayoutParams(lottieAnimationView);
            ((LottieAnimationView) _$_findCachedViewById(i11)).setVisibility(0);
            ((LottieAnimationView) _$_findCachedViewById(i11)).playAnimation();
            ((LottieAnimationView) _$_findCachedViewById(i11)).setMinAndMaxFrame(0, 106);
            return;
        }
        int i12 = R.id.videoView_splash;
        MutedVideoView mutedVideoView = (MutedVideoView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(mutedVideoView, "videoView_splash");
        setupLayoutParams(mutedVideoView);
        MutedVideoView mutedVideoView2 = (MutedVideoView) _$_findCachedViewById(i12);
        if (mutedVideoView2 != null) {
            mutedVideoView2.setVisibility(0);
        }
        MutedVideoView mutedVideoView3 = (MutedVideoView) _$_findCachedViewById(i12);
        if (mutedVideoView3 != null) {
            mutedVideoView3.setCanLoop(Boolean.valueOf(this.isVideoRepeat));
        }
        String str = this.videoPath;
        MutedVideoView mutedVideoView4 = (MutedVideoView) _$_findCachedViewById(i12);
        if (mutedVideoView4 != null) {
            mutedVideoView4.setVideoURI(Uri.parse(str), this.isVideoRepeat);
        }
        MutedVideoView mutedVideoView5 = (MutedVideoView) _$_findCachedViewById(i12);
        if (mutedVideoView5 != null) {
            mutedVideoView5.setAlpha(0.0f);
        }
        MutedVideoView mutedVideoView6 = (MutedVideoView) _$_findCachedViewById(i12);
        if (mutedVideoView6 != null) {
            mutedVideoView6.setOnPreparedListener(new l(this));
        }
        MutedVideoView mutedVideoView7 = (MutedVideoView) _$_findCachedViewById(i12);
        if (mutedVideoView7 != null) {
            mutedVideoView7.setOnCompletionListener(new m(this));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playWelcomeVideo$lambda-2  reason: not valid java name */
    public static final void m10924playWelcomeVideo$lambda2(WelcomeVideoFragment welcomeVideoFragment, MediaPlayer mediaPlayer) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        Intrinsics.checkNotNullParameter(welcomeVideoFragment, "this$0");
        mediaPlayer.start();
        MutedVideoView mutedVideoView = (MutedVideoView) welcomeVideoFragment._$_findCachedViewById(R.id.videoView_splash);
        if (mutedVideoView != null && (animate = mutedVideoView.animate()) != null && (alpha = animate.alpha(1.0f)) != null && (duration = alpha.setDuration(500)) != null) {
            duration.setListener((Animator.AnimatorListener) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playWelcomeVideo$lambda-3  reason: not valid java name */
    public static final void m10925playWelcomeVideo$lambda3(WelcomeVideoFragment welcomeVideoFragment, MediaPlayer mediaPlayer) {
        SplashActivitySharedViewModel splashActivitySharedViewModel2;
        Intrinsics.checkNotNullParameter(welcomeVideoFragment, "this$0");
        if (welcomeVideoFragment.isSplashVideo && (splashActivitySharedViewModel2 = welcomeVideoFragment.splashActivitySharedViewModel) != null) {
            splashActivitySharedViewModel2.videoPlayBackFinished();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void inject(@NotNull SplashActivitySharedViewModel splashActivitySharedViewModel2) {
        Intrinsics.checkNotNullParameter(splashActivitySharedViewModel2, "splashActivitySharedViewModel");
        this.splashActivitySharedViewModel = splashActivitySharedViewModel2;
    }

    public int layoutId() {
        return R.layout.fragment_video_view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || getArguments() == null)) {
            this.videoPath = arguments.getString("videoPath");
            this.isShowOverlay = arguments.getBoolean("IsShowOverlay");
            this.isVideoRepeat = arguments.getBoolean("IsVideoRepeat");
            this.isSplashVideo = arguments.getBoolean("IsSplashVideo");
            this.isOnboardingExperimentEnabled = arguments.getBoolean("IsOnboardingExperimentEnabled");
        }
        initObserver();
        SplashActivitySharedViewModel splashActivitySharedViewModel2 = this.splashActivitySharedViewModel;
        if (splashActivitySharedViewModel2 != null) {
            splashActivitySharedViewModel2.playVideo(this.isShowOverlay);
        }
    }

    public final void setupLayoutParams(@NotNull View view) {
        WindowManager windowManager;
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(view, "view");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = displayMetrics.widthPixels;
            layoutParams2.height = displayMetrics.heightPixels;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            view.setLayoutParams(layoutParams2);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
}
