package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class k0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CueGroup f34951a;

    public /* synthetic */ k0(CueGroup cueGroup) {
        this.f34951a = cueGroup;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues(this.f34951a);
    }
}
