package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class r implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34989a;

    public /* synthetic */ r(PlaybackInfo playbackInfo) {
        this.f34989a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTracksChanged(this.f34989a.trackSelectorResult.tracks);
    }
}
