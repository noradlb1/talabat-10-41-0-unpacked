package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class a0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34909a;

    public /* synthetic */ a0(int i11) {
        this.f34909a = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onAudioSessionIdChanged(this.f34909a);
    }
}
