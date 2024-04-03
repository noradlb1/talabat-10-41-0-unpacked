package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class o implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MediaItem f34970a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34971b;

    public /* synthetic */ o(MediaItem mediaItem, int i11) {
        this.f34970a = mediaItem;
        this.f34971b = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onMediaItemTransition(this.f34970a, this.f34971b);
    }
}
