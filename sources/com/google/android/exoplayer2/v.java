package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class v implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f35067a;

    public /* synthetic */ v(PlaybackInfo playbackInfo) {
        this.f35067a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlaybackStateChanged(this.f35067a.playbackState);
    }
}
