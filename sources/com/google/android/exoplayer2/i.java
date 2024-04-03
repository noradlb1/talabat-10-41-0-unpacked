package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class i implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34944a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34945b;

    public /* synthetic */ i(PlaybackInfo playbackInfo, int i11) {
        this.f34944a = playbackInfo;
        this.f34945b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onPlayWhenReadyChanged(this.f34944a.playWhenReady, this.f34945b);
    }
}
