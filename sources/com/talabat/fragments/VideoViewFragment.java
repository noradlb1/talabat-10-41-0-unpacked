package com.talabat.fragments;

import android.animation.Animator;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.helpers.MutedVideoView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.welcomevideo.IWelcomVideoPresenter;
import library.talabat.mvp.welcomevideo.IWelcomVideoView;
import library.talabat.mvp.welcomevideo.WelcomeVideoPresenter;
import mq.u;
import mq.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0002$%B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u000e\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J&\u0010\u001d\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\"\u001a\u00020\u000fH\u0016J\u0012\u0010#\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/fragments/VideoViewFragment;", "Landroidx/fragment/app/Fragment;", "Llibrary/talabat/mvp/welcomevideo/IWelcomVideoView;", "()V", "listener", "Lcom/talabat/fragments/VideoViewFragment$OnVideoFragmentInteractionListener;", "mPresenter", "Llibrary/talabat/mvp/welcomevideo/IWelcomVideoPresenter;", "mVideoViewSplash", "Lcom/talabat/helpers/MutedVideoView;", "mWelcomeImageView", "Landroid/widget/ImageView;", "videoPath", "", "init", "", "initUI", "view", "Landroid/view/View;", "loadWelocomeImageView", "onAttach", "context", "Landroid/content/Context;", "onButtonPressed", "uri", "Landroid/net/Uri;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "playWelcomeVideo", "Companion", "OnVideoFragmentInteractionListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VideoViewFragment extends Fragment implements IWelcomVideoView, TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    @Nullable
    private OnVideoFragmentInteractionListener listener;
    @Nullable
    private IWelcomVideoPresenter mPresenter;
    @Nullable
    private MutedVideoView mVideoViewSplash;
    @Nullable
    private ImageView mWelcomeImageView;
    @Nullable
    private String videoPath;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/fragments/VideoViewFragment$Companion;", "", "()V", "newInstance", "Lcom/talabat/fragments/VideoViewFragment;", "param1", "", "param2", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final VideoViewFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "param1");
            Intrinsics.checkNotNullParameter(str2, "param2");
            VideoViewFragment videoViewFragment = new VideoViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("video_path", str);
            videoViewFragment.setArguments(bundle);
            return videoViewFragment;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/fragments/VideoViewFragment$OnVideoFragmentInteractionListener;", "", "onFragmentInteraction", "", "uri", "Landroid/net/Uri;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnVideoFragmentInteractionListener {
        void onFragmentInteraction(@NotNull Uri uri);
    }

    private final void init() {
        IWelcomVideoPresenter iWelcomVideoPresenter = this.mPresenter;
        if (iWelcomVideoPresenter != null) {
            iWelcomVideoPresenter.loadVideoView(this.videoPath);
        }
    }

    private final void initUI(View view) {
        this.mVideoViewSplash = (MutedVideoView) view.findViewById(R.id.videoView_splash);
    }

    @JvmStatic
    @NotNull
    public static final VideoViewFragment newInstance(@NotNull String str, @NotNull String str2) {
        return Companion.newInstance(str, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: playWelcomeVideo$lambda-1  reason: not valid java name */
    public static final void m10499playWelcomeVideo$lambda1(VideoViewFragment videoViewFragment, MediaPlayer mediaPlayer) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        Intrinsics.checkNotNullParameter(videoViewFragment, "this$0");
        mediaPlayer.start();
        MutedVideoView mutedVideoView = videoViewFragment.mVideoViewSplash;
        if (mutedVideoView != null && (animate = mutedVideoView.animate()) != null && (alpha = animate.alpha(1.0f)) != null && (duration = alpha.setDuration(500)) != null) {
            duration.setListener((Animator.AnimatorListener) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playWelcomeVideo$lambda-2  reason: not valid java name */
    public static final void m10500playWelcomeVideo$lambda2(MediaPlayer mediaPlayer) {
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

    public void loadWelocomeImageView() {
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof OnVideoFragmentInteractionListener) {
            this.listener = (OnVideoFragmentInteractionListener) context;
        }
    }

    public final void onButtonPressed(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        OnVideoFragmentInteractionListener onVideoFragmentInteractionListener = this.listener;
        if (onVideoFragmentInteractionListener != null) {
            onVideoFragmentInteractionListener.onFragmentInteraction(uri);
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("VideoViewFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "VideoViewFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VideoViewFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || getArguments() == null)) {
            this.videoPath = arguments.getString("video_path");
        }
        TraceMachine.exitMethod();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "VideoViewFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "VideoViewFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_video_view, viewGroup, false);
        this.mPresenter = new WelcomeVideoPresenter(this);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        initUI(inflate);
        init();
        TraceMachine.exitMethod();
        return inflate;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void playWelcomeVideo(@Nullable String str) {
        ViewGroup.LayoutParams layoutParams;
        WindowManager windowManager;
        Display defaultDisplay;
        MutedVideoView mutedVideoView = this.mVideoViewSplash;
        if (mutedVideoView != null) {
            mutedVideoView.setVisibility(0);
        }
        MutedVideoView mutedVideoView2 = this.mVideoViewSplash;
        if (mutedVideoView2 != null) {
            mutedVideoView2.setVisibility(0);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        FragmentActivity activity = getActivity();
        if (!(activity == null || (windowManager = activity.getWindowManager()) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        MutedVideoView mutedVideoView3 = this.mVideoViewSplash;
        String str2 = null;
        if (mutedVideoView3 != null) {
            layoutParams = mutedVideoView3.getLayoutParams();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.width = displayMetrics.widthPixels;
            layoutParams2.height = displayMetrics.heightPixels;
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = 0;
            MutedVideoView mutedVideoView4 = this.mVideoViewSplash;
            if (mutedVideoView4 != null) {
                mutedVideoView4.setLayoutParams(layoutParams2);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                str2 = activity2.getPackageName();
            }
            String str3 = "android.resource://" + str2 + "/2131951648";
            MutedVideoView mutedVideoView5 = this.mVideoViewSplash;
            if (mutedVideoView5 != null) {
                mutedVideoView5.setVideoURI(Uri.parse(str3), true);
            }
            MutedVideoView mutedVideoView6 = this.mVideoViewSplash;
            if (mutedVideoView6 != null) {
                mutedVideoView6.setCanLoop(Boolean.TRUE);
            }
            MutedVideoView mutedVideoView7 = this.mVideoViewSplash;
            if (mutedVideoView7 != null) {
                mutedVideoView7.setAlpha(0.0f);
            }
            MutedVideoView mutedVideoView8 = this.mVideoViewSplash;
            if (mutedVideoView8 != null) {
                mutedVideoView8.setOnPreparedListener(new u(this));
            }
            MutedVideoView mutedVideoView9 = this.mVideoViewSplash;
            if (mutedVideoView9 != null) {
                mutedVideoView9.setOnCompletionListener(new v());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
}
