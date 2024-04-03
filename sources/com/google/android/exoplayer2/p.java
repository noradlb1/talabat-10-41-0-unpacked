package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class p implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34982a;

    public /* synthetic */ p(PlaybackInfo playbackInfo) {
        this.f34982a = playbackInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayerErrorChanged(this.f34982a.playbackError);
    }
}
