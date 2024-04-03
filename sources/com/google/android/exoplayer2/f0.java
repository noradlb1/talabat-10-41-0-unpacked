package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class f0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Metadata f34938a;

    public /* synthetic */ f0(Metadata metadata) {
        this.f34938a = metadata;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMetadata(this.f34938a);
    }
}
