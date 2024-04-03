package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.ListenerSet;

public final /* synthetic */ class n implements ListenerSet.Event {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f34965a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f34966b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Player.PositionInfo f34967c;

    public /* synthetic */ n(int i11, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2) {
        this.f34965a = i11;
        this.f34966b = positionInfo;
        this.f34967c = positionInfo2;
    }

    public final void invoke(Object obj) {
        ExoPlayerImpl.lambda$updatePlaybackInfo$13(this.f34965a, this.f34966b, this.f34967c, (Player.Listener) obj);
    }
}
