package com.instabug.library.internal.video;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.instabug.library.InstabugBaseFragment;
import com.instabug.library.R;
import com.instabug.library.internal.video.a;
import com.instabug.library.util.InstabugSDKLogger;

public class VideoPlayerFragment extends InstabugBaseFragment implements a.C0095a {
    public static final String TAG = "VideoPlayerFragment";
    private static final String VIDEO_PATH = "video.uri";
    /* access modifiers changed from: private */
    @Nullable
    public a mediaControls;
    /* access modifiers changed from: private */
    public int position = 0;
    /* access modifiers changed from: private */
    @Nullable
    public ProgressDialog progressDialog;
    @Nullable
    private String videoUri;
    /* access modifiers changed from: private */
    @Nullable
    public VideoView videoView;
    @Nullable
    private View videoViewToolbar;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            if (VideoPlayerFragment.this.getActivity() != null) {
                VideoPlayerFragment.this.getActivity().onBackPressed();
            }
        }
    }

    public class b implements MediaPlayer.OnPreparedListener {
        public b() {
        }

        @SuppressLint({"NULL_DEREFERENCE"})
        public void onPrepared(MediaPlayer mediaPlayer) {
            if (VideoPlayerFragment.this.progressDialog != null) {
                VideoPlayerFragment.this.progressDialog.dismiss();
            }
            if (VideoPlayerFragment.this.videoView != null) {
                VideoPlayerFragment.this.videoView.seekTo(VideoPlayerFragment.this.position);
                if (VideoPlayerFragment.this.position == 0) {
                    VideoPlayerFragment.this.videoView.start();
                    if (VideoPlayerFragment.this.mediaControls != null) {
                        VideoPlayerFragment.this.mediaControls.show();
                        return;
                    }
                    return;
                }
                VideoPlayerFragment.this.videoView.pause();
            }
        }
    }

    public class c implements MediaPlayer.OnErrorListener {
        public c() {
        }

        @SuppressLint({"NULL_DEREFERENCE"})
        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            if (VideoPlayerFragment.this.progressDialog == null) {
                return false;
            }
            VideoPlayerFragment.this.progressDialog.dismiss();
            return false;
        }
    }

    public static VideoPlayerFragment newInstance(String str) {
        VideoPlayerFragment videoPlayerFragment = new VideoPlayerFragment();
        Bundle bundle = new Bundle();
        bundle.putString(VIDEO_PATH, str);
        videoPlayerFragment.setArguments(bundle);
        return videoPlayerFragment;
    }

    private void showToolbar(boolean z11) {
        ActionBar supportActionBar;
        FragmentActivity activity = getActivity();
        if (activity != null && (supportActionBar = ((AppCompatActivity) activity).getSupportActionBar()) != null) {
            if (z11) {
                supportActionBar.show();
            } else {
                supportActionBar.hide();
            }
        }
    }

    public void i0() {
        this.videoUri = getArguments() == null ? null : getArguments().getString(VIDEO_PATH);
    }

    public void isVisible(boolean z11) {
        int i11;
        View view = this.videoViewToolbar;
        if (view != null) {
            if (z11) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            view.setVisibility(i11);
        }
    }

    public int j0() {
        return R.layout.instabug_lyt_video_view;
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public String k0() {
        return getLocalizedString(R.string.instabug_str_video_player);
    }

    public void l0(Bundle bundle) {
        VideoView videoView2 = this.videoView;
        if (videoView2 != null) {
            bundle.putInt("Position", videoView2.getCurrentPosition());
            this.videoView.pause();
        }
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (this.mediaControls == null) {
                this.mediaControls = new a(activity, this);
            }
            ProgressDialog progressDialog2 = new ProgressDialog(activity);
            this.progressDialog = progressDialog2;
            progressDialog2.setMessage("Loading...");
            this.progressDialog.setCancelable(false);
            this.progressDialog.show();
            try {
                VideoView videoView2 = this.videoView;
                if (!(videoView2 == null || this.videoUri == null)) {
                    videoView2.setMediaController(this.mediaControls);
                    this.videoView.setVideoURI(Uri.parse(this.videoUri));
                }
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't play video due to: ", e11);
            }
            VideoView videoView3 = this.videoView;
            if (videoView3 != null) {
                videoView3.requestFocus();
                this.videoView.setOnPreparedListener(new b());
                this.videoView.setOnErrorListener(new c());
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        showToolbar(true);
    }

    public void onDestroyView() {
        this.mediaControls = null;
        this.videoView = null;
        this.videoViewToolbar = null;
        super.onDestroyView();
    }

    public void onResume() {
        super.onResume();
        showToolbar(false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.videoView = (VideoView) view.findViewById(R.id.video_view);
        View findViewById = view.findViewById(R.id.ib_core_toolbar_video);
        this.videoViewToolbar = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new a());
        }
    }

    public void restoreState(Bundle bundle) {
        int i11 = bundle.getInt("Position");
        this.position = i11;
        VideoView videoView2 = this.videoView;
        if (videoView2 != null) {
            videoView2.seekTo(i11);
        }
    }
}
