package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class j0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34948a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f34949b;

    public /* synthetic */ j0(int i11, boolean z11) {
        this.f34948a = i11;
        this.f34949b = z11;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceVolumeChanged(this.f34948a, this.f34949b);
    }
}
