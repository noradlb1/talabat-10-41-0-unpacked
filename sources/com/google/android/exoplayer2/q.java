package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class q implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34984a;

    public /* synthetic */ q(PlaybackInfo playbackInfo) {
        this.f34984a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerError(this.f34984a.playbackError);
    }
}
