package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f34915a;

    public /* synthetic */ b0(ExoPlayerImpl exoPlayerImpl) {
        this.f34915a = exoPlayerImpl;
    }

    public final void invoke(Object obj) {
        this.f34915a.lambda$setPlaylistMetadata$7((Player.Listener) obj);
    }
}
