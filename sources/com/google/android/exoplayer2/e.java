package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class e implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34930a;

    public /* synthetic */ e(int i11) {
        this.f34930a = i11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onRepeatModeChanged(this.f34930a);
    }
}
