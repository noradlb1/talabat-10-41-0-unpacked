package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class m implements ListenerSet.IterationFinishedEvent {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f34954a;

    public /* synthetic */ m(ExoPlayerImpl exoPlayerImpl) {
        this.f34954a = exoPlayerImpl;
    }

    public final void invoke(Object obj, FlagSet flagSet) {
        this.f34954a.lambda$new$0((Player.Listener) obj, flagSet);
    }
}
