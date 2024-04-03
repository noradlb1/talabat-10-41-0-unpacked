package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class h0 implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DeviceInfo f34943a;

    public /* synthetic */ h0(DeviceInfo deviceInfo) {
        this.f34943a = deviceInfo;
    }

    public final void invoke(Object obj) {
        ((Player.Listener) obj).onDeviceInfoChanged(this.f34943a);
    }
}
