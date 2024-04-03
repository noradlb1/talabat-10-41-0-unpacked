package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class b implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34913a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f34914b;

    public /* synthetic */ b(int i11, int i12) {
        this.f34913a = i11;
        this.f34914b = i12;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSurfaceSizeChanged(this.f34913a, this.f34914b);
    }
}
