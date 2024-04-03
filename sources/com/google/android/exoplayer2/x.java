package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class x implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f35077a;

    public /* synthetic */ x(boolean z11) {
        this.f35077a = z11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onSkipSilenceEnabledChanged(this.f35077a);
    }
}
