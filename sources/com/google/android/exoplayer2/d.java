package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class d implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ float f34922a;

    public /* synthetic */ d(float f11) {
        this.f34922a = f11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onVolumeChanged(this.f34922a);
    }
}
