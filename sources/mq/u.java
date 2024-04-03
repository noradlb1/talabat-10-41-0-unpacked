package mq;

import android.media.MediaPlayer;
import com.talabat.fragments.VideoViewFragment;

public final /* synthetic */ class u implements MediaPlayer.OnPreparedListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoViewFragment f62336b;

    public /* synthetic */ u(VideoViewFragment videoViewFragment) {
        this.f62336b = videoViewFragment;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        VideoViewFragment.m10499playWelcomeVideo$lambda1(this.f62336b, mediaPlayer);
    }
}
