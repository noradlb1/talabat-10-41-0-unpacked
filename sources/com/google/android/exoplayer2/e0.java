package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl.ComponentListener f34931a;

    public /* synthetic */ e0(ExoPlayerImpl.ComponentListener componentListener) {
        this.f34931a = componentListener;
    }

    public final void invoke(Object obj) {
        this.f34931a.lambda$onMetadata$4((Player.Listener) obj);
    }
}
