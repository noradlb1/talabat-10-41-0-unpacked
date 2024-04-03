package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class c0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f34920a;

    public /* synthetic */ c0(boolean z11) {
        this.f34920a = z11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onShuffleModeEnabledChanged(this.f34920a);
    }
}
