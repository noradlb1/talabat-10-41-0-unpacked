package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.util.ListenerSet;
import java.util.List;

public final /* synthetic */ class g0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f34940a;

    public /* synthetic */ g0(List list) {
        this.f34940a = list;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onCues((List<Cue>) this.f34940a);
    }
}
