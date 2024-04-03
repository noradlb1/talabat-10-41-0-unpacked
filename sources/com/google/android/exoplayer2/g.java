package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class g implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f34939a;

    public /* synthetic */ g(ExoPlayerImpl exoPlayerImpl) {
        this.f34939a = exoPlayerImpl;
    }

    public final void invoke(Object obj) {
        this.f34939a.lambda$updateAvailableCommands$26((Player.Listener) obj);
    }
}
