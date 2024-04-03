package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlaybackInfo f34941a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34942b;

    public /* synthetic */ h(PlaybackInfo playbackInfo, int i11) {
        this.f34941a = playbackInfo;
        this.f34942b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onTimelineChanged(this.f34941a.timeline, this.f34942b);
    }
}
