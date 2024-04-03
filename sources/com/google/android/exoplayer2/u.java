package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class u implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f35056a;

    public /* synthetic */ u(PlaybackInfo playbackInfo) {
        this.f35056a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerStateChanged(this.f35056a.playWhenReady, this.f35056a.playbackState);
    }
}
