package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34950a;

    public /* synthetic */ k(PlaybackInfo playbackInfo) {
        this.f34950a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onIsPlayingChanged(ExoPlayerImpl.isPlaying(this.f34950a));
    }
}
